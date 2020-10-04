package com.epam.valkaryne.footballteamsapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.epam.valkaryne.footballteamsapp.databinding.FragmentTeamStatsListBinding
import com.epam.valkaryne.footballteamsapp.view.adapter.TeamStatsAdapter
import com.epam.valkaryne.footballteamsapp.vm.TeamsStatsViewModel
import com.epam.valkaryne.footballteamsapp.vm.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Fragment that shows to user a list of teams' statistics for the certain league
 */
class TeamStatsListFragment : Fragment() {

    private lateinit var binding: FragmentTeamStatsListBinding
    private val viewModel: TeamsStatsViewModel by viewModel()
    private val adapter = TeamStatsAdapter()

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
        viewModel.getAllTeamsStats()
    }

    private fun subscribeUi() {
        viewModel.teamsStatsViewState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ViewState.Success -> adapter.submitList(state.data)
                is ViewState.Error -> Toast.makeText(
                    context,
                    "${state.error.message}",
                    Toast.LENGTH_LONG
                ).show()
                is ViewState.Loading -> Log.d("SuperCat", "Loading")
            }
        }
    }
}