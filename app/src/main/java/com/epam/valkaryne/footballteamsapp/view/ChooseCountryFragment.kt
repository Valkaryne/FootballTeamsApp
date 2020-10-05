package com.epam.valkaryne.footballteamsapp.view

import android.content.ContentResolver
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.epam.valkaryne.footballteamsapp.R
import com.epam.valkaryne.footballteamsapp.databinding.FragmentChooseCountryBinding
import com.epam.valkaryne.footballteamsapp.utils.loadImageFromUrl

class ChooseCountryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentChooseCountryBinding.inflate(inflater, container, false)
        context ?: return binding.root

        binding.buttonEngland.setOnClickListener { navigateToTeamsStats(ENGLAND_ID) }
        binding.buttonGermany.setOnClickListener { navigateToTeamsStats(GERMANY_ID) }

        return binding.root
    }

    private fun navigateToTeamsStats(leagueId: Long) {
        findNavController().navigate(
            ChooseCountryFragmentDirections.actionChooseCountryFragmentToTeamStatsFragment(
                leagueId
            )
        )
    }

    private companion object {
        const val ENGLAND_ID = 2021L
        const val GERMANY_ID = 2002L
    }
}