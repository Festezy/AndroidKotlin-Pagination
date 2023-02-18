package com.example.testpagination2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.testpagination2.data.CampaignResponse
import com.example.testpagination2.data.DataJArrray
import com.example.testpagination2.data.SumDonation
import com.example.testpagination2.databinding.ActivityMainBinding
import com.example.testpagination2.services.ApiClient
import com.example.testpagination2.services.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var campAdapter: CampaignAdapter
    private lateinit var layoutManager: LinearLayoutManager

    private val serverInterface: ApiInterface = ApiClient().getApiClient()!!
        .create(ApiInterface::class.java)

    private var page = 1
    private var perPage = 1
    private var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        layoutManager = LinearLayoutManager(this)
        binding.swipeRefresh.setOnRefreshListener(this)
        setUpRecyclerView()
        getCampaignData(false)
        binding.rvListCampaign.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val visibileItemcount = layoutManager.childCount
                val pastVisibleItem = layoutManager.findFirstVisibleItemPosition()
                val total = campAdapter.itemCount
                if (!isLoading && page < perPage){
                    if (visibileItemcount + pastVisibleItem >= total){
                        page++
                        getCampaignData(false)
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    private fun getCampaignData(isOnRefresh: Boolean) {
        isLoading = true
        if (!isOnRefresh) binding.ProgressBar.visibility = View.VISIBLE
        val params = HashMap<String, String>()
        params["page"] = page.toString()
        serverInterface.getCampaign(params).enqueue(object : Callback<CampaignResponse>{
            override fun onResponse(
                call: Call<CampaignResponse>,
                response: Response<CampaignResponse>
            ) {
                val isMyResponse = response.body()!!.data
                val myData = isMyResponse!!.data
                Log.d("Sucess to Call", myData.toString())
                perPage = isMyResponse.perPage!!

                val campaignArrayItems = ArrayList<DataJArrray>()
                for (i in 0 until myData!!.size){
                    val myImg = myData[i].image.toString()
                    val myTitle = myData[i].title.toString()
                    val myUName = myData[i].user
                    val myDesc = myData[i].description.toString()
                    val myMaxDate = myData[i].maxDate.toString()
                    val mySumDonation = myData[i].sumDonation
                    val mytargetDonate = myData[i].targetDonation.toString()


                    Log.d("Logging SUM $i", mySumDonation.toString())
                    Log.d("Logging $i", myUName.toString())
                    campaignArrayItems.add(DataJArrray("", "", myDesc, i, myImg,
                        myMaxDate, "", mySumDonation, mytargetDonate, myTitle, "", myUName,
                    ""))

                    Log.d("arra $i", campaignArrayItems.toString())
                }

                campAdapter.addGsonArray(campaignArrayItems)
                binding.ProgressBar.visibility = View.GONE
                isLoading = false
                binding.swipeRefresh.isRefreshing = false
            }

            override fun onFailure(call: Call<CampaignResponse>, t: Throwable) {
                Log.d("failed to Call", t.message.toString())
            }
        })
    }

    private fun setUpRecyclerView() {
        binding.rvListCampaign.setHasFixedSize(true)
        binding.rvListCampaign.layoutManager = layoutManager
        campAdapter = CampaignAdapter()
        binding.rvListCampaign.adapter = campAdapter
    }

    override fun onRefresh() {
        campAdapter.clearList()
        page = 1
        getCampaignData(true)
    }
}