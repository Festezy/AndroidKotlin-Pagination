package com.example.testpagination2.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testpagination2.data.DataJArrray
import com.example.testpagination2.data.SumDonation
import com.example.testpagination2.databinding.ItemlistCampaignBinding

class CampaignAdapter: RecyclerView.Adapter<CampaignAdapter.CampaignViewHolder>() {

    private val campList = ArrayList<DataJArrray>()
    inner class CampaignViewHolder(private val binding: ItemlistCampaignBinding)
        :RecyclerView.ViewHolder(binding.root){
            fun bind(campaign: DataJArrray){
                with(binding){
                    Glide.with(binding.root).load(campaign.image).into(imgItemPhoto)
                    tvItemTitle.text = campaign.title
                    tvItemUser.text = campaign.user?.name
                    tvItemDesc.text = campaign.description
                    tvitemTargetDonation.text = campaign.targetDonation
                    tvItemSumDonate.text = campaign.sumDonation.toString()
                    tvItemMaxDate.text = campaign.maxDate
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

    fun addGsonArray(items: ArrayList<DataJArrray>){
        campList.addAll(items)
        notifyDataSetChanged()
    }

    fun clearList(){
        campList.clear()
        notifyDataSetChanged()
    }
}