package com.epam.valkaryne.footballteamsapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.epam.valkaryne.footballteamsapp.R
import com.epam.valkaryne.footballteamsapp.databinding.ItemListTeamStatsBinding
import com.epam.valkaryne.footballteamsapp.utils.StringUtils
import com.epam.valkaryne.footballteamsapp.utils.loadImageFromUrl
import com.epam.valkaryne.footballteamsapp.vm.model.TeamStatsViewStateModel

/**
 * Adapter for the list of teams' statistics
 */
class TeamStatsAdapter :
    ListAdapter<TeamStatsViewStateModel, TeamStatsAdapter.TeamStatsViewHolder>(TeamStatsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamStatsViewHolder {
        return TeamStatsViewHolder(
            ItemListTeamStatsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: TeamStatsViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(it)
        }
    }

    class TeamStatsViewHolder(private val binding: ItemListTeamStatsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TeamStatsViewStateModel) {
            binding.teamStatsItemImage.loadImageFromUrl(item.crestUrl)
            binding.teamStatsItemTitle.text = item.name
            binding.teamStatsItemPosition.text = StringUtils.convertNumberToOrdinal(item.position)
            binding.teamStatsItemPlayed.text = String.format(
                binding.root.context.getString(R.string.played_games_label),
                item.playedGames
            )
            binding.teamStatsItemWon.text =
                String.format(binding.root.context.getString(R.string.games_won_label), item.won)
            binding.teamStatsItemDraw.text =
                String.format(binding.root.context.getString(R.string.games_draw_label), item.draw)
            binding.teamStatsItemLost.text =
                String.format(binding.root.context.getString(R.string.games_lost_label), item.lost)
            binding.teamStatsItemScore.text =
                String.format(binding.root.context.getString(R.string.score_label), item.points)
            binding.teamStatsItemGoalsDiff.text = String.format(
                binding.root.context.getString(R.string.goals_difference_label),
                item.goalDifference
            )
        }
    }
}

private class TeamStatsDiffCallback : DiffUtil.ItemCallback<TeamStatsViewStateModel>() {

    override fun areItemsTheSame(
        oldItem: TeamStatsViewStateModel,
        newItem: TeamStatsViewStateModel
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: TeamStatsViewStateModel,
        newItem: TeamStatsViewStateModel
    ): Boolean {
        return oldItem == newItem
    }
}