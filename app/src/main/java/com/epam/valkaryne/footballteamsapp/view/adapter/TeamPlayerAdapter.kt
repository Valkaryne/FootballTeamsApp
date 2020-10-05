package com.epam.valkaryne.footballteamsapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.epam.valkaryne.footballteamsapp.databinding.ItemTeamPlayerBinding
import com.epam.valkaryne.footballteamsapp.vm.model.PlayerInfo

/**
 * Adapter for the list of team players
 */
class TeamPlayerAdapter :
    ListAdapter<PlayerInfo, TeamPlayerAdapter.TeamPlayerViewHolder>(TeamPlayerDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamPlayerViewHolder {
        return TeamPlayerViewHolder(
            ItemTeamPlayerBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: TeamPlayerViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(it)
        }
    }

    class TeamPlayerViewHolder(private val binding: ItemTeamPlayerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PlayerInfo) {
            binding.teamPlayerItemName.text = item.name
            binding.teamPlayerItemPosition.text = item.position
        }
    }
}

private class TeamPlayerDiffCallback : DiffUtil.ItemCallback<PlayerInfo>() {

    override fun areItemsTheSame(oldItem: PlayerInfo, newItem: PlayerInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PlayerInfo, newItem: PlayerInfo): Boolean {
        return oldItem == newItem
    }
}