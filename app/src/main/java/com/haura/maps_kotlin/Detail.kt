package com.haura.maps_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class Detail : AppCompatActivity() , OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)


        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map_wisata) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val photo = intent.getIntExtra("photoWisata", 0)
        val bidang = intent.getStringExtra("ketWisata")
        val sinopsis = intent.getStringExtra("sinopsis")
        val lat = intent.getDoubleExtra("lat",0.0)
        val long = intent.getDoubleExtra("lng",0.0)


        val txtnama = findViewById<TextView>(R.id.tvDetail)
        val imgphoto = findViewById<ImageView>(R.id.imgDetail)
        val textViewDesc = findViewById<TextView>(R.id.tvDetail)


        txtnama.text = bidang
        imgphoto.setImageResource(photo)
        textViewDesc.setText(sinopsis)

        val ActButton2 = findViewById<Button>(R.id.btnMap)
        ActButton2.setOnClickListener {
            val Intent = Intent(this, MapsActivity::class.java).apply {
                putExtra("lat", lat)
                putExtra("lng", long)

            }
            startActivity(Intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val lat = intent.getDoubleExtra("lat", 0.0)
        val lng = intent.getDoubleExtra("lng", 0.0)
        val lokasiwisata= LatLng(lat,lng)

        mMap.addMarker(MarkerOptions().position(lokasiwisata).title("Marker in padang"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lokasiwisata))
    }
}