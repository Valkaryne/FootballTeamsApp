package com.epam.valkaryne.footballteamsapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.epam.valkaryne.footballteamsapp.R
import com.epam.valkaryne.footballteamsapp.databinding.FragmentTeamDetailsBinding
import com.epam.valkaryne.footballteamsapp.utils.loadImageFromUrl
import com.epam.valkaryne.footballteamsapp.view.adapter.TeamPlayerAdapter
import com.epam.valkaryne.footballteamsapp.vm.TeamDetailsViewModel
import com.epam.valkaryne.footballteamsapp.vm.ViewState
import com.epam.valkaryne.footballteamsapp.vm.model.TeamDetailsViewStateModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Fragment that shows to user a detailed information about the certain team
 */
class TeamDetailsFragment : Fragment() {

    private val args: TeamDetailsFragmentArgs by navArgs()

    private lateinit var binding: FragmentTeamDetailsBinding
    private val viewModel: TeamDetailsViewModel by viewModel()
    private val adapter = TeamPlayerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamDetailsBinding.inflate(inflater, container, false)
        context ?: return binding.root

        binding.playerList.layoutManager = LinearLayoutManager(context)
        binding.playerList.adapter = adapter

        subscribeUi()

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getTeamDetails(args.teamId)
    }

    private fun subscribeUi() {
        viewModel.teamDetailsViewState.observe(viewLifecycleOwner) { state ->
            when (state) {
                is ViewState.Success -> {
                    binding.progressBar.isVisible = false
                    populateViews(state.data)
                    adapter.submitList(state.data.squad)
                }
                is ViewState.Error -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(context, "${state.error.message}", Toast.LENGTH_LONG).show()
                }
                is ViewState.Loading -> binding.progressBar.isVisible = true
            }
        }
    }

    private fun populateViews(stateModel: TeamDetailsViewStateModel) {
        with(binding) {
            teamDetailsTitle.text = stateModel.name
            teamDetailsImage.loadImageFromUrl(stateModel.crestUrl)
            teamDetailsAddress.text =
                String.format(getString(R.string.address_text), stateModel.address)
            teamDetailsPhone.text = String.format(getString(R.string.phone_text), stateModel.phone)
            teamDetailsWebsite.text =
                String.format(getString(R.string.website_text), stateModel.website)
            teamDetailsFounded.text =
                String.format(getString(R.string.founded_text), stateModel.founded)
            teamDetailsVenue.text = String.format(getString(R.string.venue_text), stateModel.venue)
            teamDetailsColors.text =
                String.format(getString(R.string.colors_text), stateModel.clubColors)
        }
    }
}