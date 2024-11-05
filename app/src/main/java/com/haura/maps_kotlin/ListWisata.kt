package com.haura.maps_kotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.haura.maps_kotlin.Adapter.ItemAdapter
import com.haura.maps_kotlin.Model.ItemWisata

class ListWisata : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var iconAdapter: ItemAdapter
    private var itemList = mutableListOf<ItemWisata>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_wisata)

        val menudokter = listOf(
            ItemWisata(R.drawable.jamgadang,"Jam Gadang Bukittinggi","Bukittinggi, Sumatera Barat", "Destinasi yang tidak boleh dilewatkan kalau kamu berkunjung ke Bukittinggi pastilah Jam Gadang. Jam di menara berukuran 13×4 meter ini berada di kawasan Taman Sabai Nan Aluih. Berlokasi di taman, Jam Gadang memiliki suasana yang rindang dengan adanya sejumlah pepohonan hijau. Ikon Bukittinggi ini tak pernah sepi dari pengunjung. Mulai dari pagi, siang, sore, hingga malam, kawasan ini sangat digemari oleh wisatawan.",-0.3027177,100.3513805  ),
            ItemWisata(R.drawable.pantai,"Pantai Padang","Padang, Sumatera Barat", "Pantai Padang atau populer dengan sebutan Taplau (singkatan dari tapi lauik, bahasa Minang yang artinya tepi laut) adalah sebuah pantai yang terletak di Kota Padang, Sumatera Barat.[1] Pantai ini terletak pada kawasan padat perkotaan di Kecamatan Padang Barat, dan membentang dari daerah Purus hingga muara Batang Arau. Pantai ini berjarak kurang lebih 23 km dari Bandar Udara Internasional Minangkabau atau 30 menit perjalanan darat dengan mobil.",-0.8937223,100.2474528),
            ItemWisata(R.drawable.airterjun,"Air Terjun Lembah Anai","Singgalang, X Koto, Kabupaten Tanah Datar, Sumatera Barat. ", "ir Terjun Lembah Anai adalah sebuah air terjun yang terletak di jorong aie mancua nagari Singgalang, X Koto, Kabupaten Tanah Datar, Sumatera Barat. Air terjun setinggi sekira 35 meter ini berada tepat di tepi Jalan Raya Padang-Bukittinggi di kaki Gunung Singgalang.",-0.4837883,100.3354818),
            ItemWisata(R.drawable.danausingkarak,"Danau Singkarak","Kabupaten Solok", "Danau Singkarak adalah sebuah danau yang membentang di dua kabupaten yang terdapat di provinsi Sumatera Barat, Indonesia, yaitu kabupaten Solok dan kabupaten Tanah Datar.",-0.9295501,100.3473816),
            ItemWisata(R.drawable.pantai,"Danau Kembar","Alahan Panjang, Solok", "Alahan Panjang adalah salah satu nagari di Kecamatan Lembah Gumanti, Kabupaten Solok, Sumatera Barat, Indonesia. Nagari ini yang berjarak sekitar 65 km dari Kota Padang yang berada di atas Bukit Barisan, tepatnya di lereng bagian timur kawasan Taman Nasional Kerinci Seblat pada ketinggian 1.400–1.600 mdpl.",-0.9295501,100.3473816)

        )

        recyclerView = findViewById(R.id.rvWisata)
        recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        iconAdapter= ItemAdapter(menudokter)
        recyclerView.adapter = iconAdapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}