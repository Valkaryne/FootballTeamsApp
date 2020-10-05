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
class TeamStatsAdapter(private val listener: (TeamStatsViewStateModel) -> Unit) :
    ListAdapter<TeamStatsViewStateModel, TeamStatsAdapter.TeamStatsViewHolder>(TeamStatsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamStatsViewHolder {
        val viewHolder = TeamStatsViewHolder(
            ItemListTeamStatsBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.bindingAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener(getItem(position))
            }
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: TeamStatsViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(it)
        }
    }

    class TeamStatsViewHolder(private val binding: ItemListTeamStatsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val context = binding.root.context

        fun bind(item: TeamStatsViewStateModel) {
            with(binding) {
                teamStatsItemImage.loadImageFromUrl(item.crestUrl)
                teamStatsItemTitle.text = item.name
                teamStatsItemPosition.text = StringUtils.convertNumberToOrdinal(item.position)
                teamStatsItemPlayed.text =
                    String.format(context.getString(R.string.played_games_text), item.playedGames)
                teamStatsItemWon.text =
                    String.format(context.getString(R.string.games_won_text), item.won)
                teamStatsItemDraw.text =
                    String.format(context.getString(R.string.games_draw_text), item.draw)
                teamStatsItemLost.text =
                    String.format(context.getString(R.string.games_lost_text), item.lost)
                teamStatsItemScore.text =
                    String.format(context.getString(R.string.score_text), item.points)
                teamStatsItemGoalsDiff.text = String.format(
                    context.getString(R.string.goals_difference_text),
                    item.goalDifference
                )
            }
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