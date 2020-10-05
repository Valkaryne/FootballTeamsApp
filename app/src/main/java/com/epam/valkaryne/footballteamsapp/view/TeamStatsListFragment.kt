package com.epam.valkaryne.footballteamsapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.epam.valkaryne.footballteamsapp.databinding.FragmentTeamStatsListBinding
import com.epam.valkaryne.footballteamsapp.view.adapter.TeamStatsAdapter
import com.epam.valkaryne.footballteamsapp.vm.TeamsStatsViewModel
import com.epam.valkaryne.footballteamsapp.vm.ViewState
import com.epam.valkaryne.footballteamsapp.vm.model.TeamStatsViewStateModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

/**
 * Fragment that shows to user a list of teams' statistics for the certain league
 */
class TeamStatsListFragment : Fragment() {

    private val args: TeamStatsListFragmentArgs by navArgs()

    private val teamDetailsListener: (TeamStatsViewStateModel) -> Unit = {
        findNavController().navigate(
            TeamStatsListFragmentDirections.actionTeamStatsFragmentToTeamDetailsFragment(
                it.id
            )
        )
    }

    private lateinit var binding: FragmentTeamStatsListBinding
    private val viewModel: TeamsStatsViewModel by viewModel()
    private val adapter: TeamStatsAdapter by inject { parametersOf(teamDetailsListener) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamStatsListBinding.inflate(inflater, container, false)
        context ?: return binding.root

        binding.list.layoutManager = LinearLayoutManager(context)
        binding.list.adapter = adapter

        subscribeUi()

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllTeamsStats(args.leagueId)
    }

    private fun subscribeUi() {
        viewModel.teamsStatsViewState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ViewState.Success -> {
                    binding.progressBar.isVisible = false
                    adapter.submitList(state.data)
                }
                is ViewState.Error -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(context, "${state.error.message}", Toast.LENGTH_LONG).show()
                }
                is ViewState.Loading -> binding.progressBar.isVisible = true
            }
        }
    }
}