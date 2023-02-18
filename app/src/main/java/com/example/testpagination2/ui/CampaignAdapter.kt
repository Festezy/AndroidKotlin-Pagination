package com.example.testpagination2.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testpagination2.data.DataCampaign
import com.example.testpagination2.data.response.DataJArrray
import com.example.testpagination2.databinding.ItemlistCampaignBinding

class CampaignAdapter: RecyclerView.Adapter<CampaignAdapter.CampaignViewHolder>() {

    private val campList = ArrayList<DataCampaign>()
    inner class CampaignViewHolder(private val binding: ItemlistCampaignBinding)
        :RecyclerView.ViewHolder(binding.root){
            fun bind(campaign: DataCampaign){
                with(binding){
                    Glide.with(binding.root).load(campaign.itemImg).into(imgItemPhoto)
                    tvItemTitle.text = campaign.title
                    tvItemUser.text = campaign.users
                    tvItemDesc.text = campaign.descriptions
                    tvitemTargetDonation.text = campaign.targetDonations
                    tvItemMaxDate.text = campaign.maxDate
                    tvItemSumDonate.text = campaign.sumDonation?: "0"
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CampaignViewHolder {
        return CampaignViewHolder(ItemlistCampaignBinding.inflate(LayoutInflater.from(parent.context),
        parent, false))
    }

    override fun getItemCount(): Int = campList.size

    override fun onBindViewHolder(holder: CampaignViewHolder, position: Int) {
        holder.bind(campList[position])
    }

    fun addGsonArray(items: ArrayList<DataCampaign>){
        campList.addAll(items)
        notifyDataSetChanged()
    }

    fun clearList(){
        campList.clear()
        notifyDataSetChanged()
    }
}