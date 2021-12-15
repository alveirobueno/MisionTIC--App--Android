package com.mintic.travelappfinal

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.sitiosmisiontic.R


class SitiosDescripcionFragment : Fragment() {

    private lateinit var contexto: Context
    private lateinit var sitioName : String
    private lateinit var sitioTemp : String
    private lateinit var sitioDescription : String
    private lateinit var sitioLocation : String
    private lateinit var sitioImageUrl : String
    private lateinit var sitioGeoLat : String
    private lateinit var sitioGeoLon : String
   private lateinit var sitiosReco : String
    val args: SitiosDescripcionFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_sitios_descripcion, container, false)



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sitioName = args.cityName
        sitioTemp = args.temperature
        sitioDescription = args.sitioDescripcion
        sitioLocation = args.sitioLocation
        sitioImageUrl = args.imgUrl
        sitioGeoLat = args.latitud
        sitioGeoLon = args.longitud
        sitiosReco = args.sitioRecomendados
        updateDisplay(view)


        val buttonMap = view.findViewById<ImageButton>(R.id.imageButton)
        buttonMap.setOnClickListener(){
            launchMap(sitioGeoLat,sitioGeoLon)
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contexto = context
    }


        private fun launchMap(latitud: String, longitud: String) {
            val gmmIntentUri = Uri.parse("geo:$latitud,$longitud")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)
        }


    private fun updateDisplay(view: View) {

        val textViewTitle = view.findViewById<TextView>(R.id.cityName).apply {
            text = sitioName
        }

        val textViewTemp = view.findViewById<TextView>(R.id.textTemperature).apply {
            text = sitioTemp
        }

        val textViewLocation = view.findViewById<TextView>(R.id.textLocation).apply {
            text = sitioLocation
        }

        val textViewDescription = view.findViewById<TextView>(R.id.textDescripcion).apply {
            text = sitioDescription
        }



        val imageView = view.findViewById<ImageView>(R.id.imageView);
        Glide.with(this).load(sitioImageUrl).into(imageView)
    }


}