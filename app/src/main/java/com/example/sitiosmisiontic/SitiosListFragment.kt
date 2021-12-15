package com.mintic.travelappfinal

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sitiosmisiontic.R

class SitiosListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel

    //    private var listener: OnCityListButtonListener? = null
    private lateinit var sitiosAdapter : SitiosAdapter
    private lateinit var recycler: RecyclerView
    private lateinit var contexto: Context


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        observeLiveData()
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.sitios_list_fragment, container, false)

        recycler = view.findViewById(R.id.sitios_list)
        initRecyclerView(view)
        return  view
    }

    private fun observeLiveData() {
        return viewModel.getSitios().observe(viewLifecycleOwner,{
            Log.d("SITIOSLISTA",it.toString())
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    //    agregar contexto
    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context
    }

    private fun initRecyclerView(view: View){

        recycler.addItemDecoration(
            DividerItemDecoration(
                contexto,
                DividerItemDecoration.VERTICAL
            )
        )
        recycler.layoutManager = LinearLayoutManager(activity)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.getSitios().observe(viewLifecycleOwner, {
            sitiosAdapter = SitiosAdapter(it, contexto){
                    sitio ->   sitiosOnClick(sitio,view)
            }
            recycler.adapter = sitiosAdapter
        })
        viewModel.getIsFailure().observe(viewLifecycleOwner, {
            if (it) {
                Log.d(TAG, "Request failed")
            }
        })

    }

    private fun sitiosOnClick(sitio: Sitios,view: View){
        val action = SitiosListFragmentDirections
            .navigateToSitiosDetails(sitio.cityName,
                                    sitio.largeInfo,
                                    sitio.ubiGeo,
                                    sitio.imageURL,
                                    sitio.sitesRec,
                                    sitio.latitud,
                                    sitio.longitud,
                                    sitio.punctuation
                                    )


        Navigation.findNavController((view)).navigate(action)
    }


    companion object{

        private const val TAG = "SitiosListFragment"



    }

}