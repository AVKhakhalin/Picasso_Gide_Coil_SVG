package com.example.picasso_gide_coil_svg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
//import coil.ImageLoader
//import coil.decode.SvgDecoder
//import coil.load
//import com.bumptech.glide.Glide
//import coil.request.ImageRequest
import com.example.picasso_gide_coil_svg.databinding.FragmentResultCurrentBinding
import com.squareup.picasso.Picasso

//import com.squareup.picasso.Picasso

class ResultCurrentFragment: Fragment() {

    // Подключение binding
    private var bindingReal: FragmentResultCurrentBinding? = null
    private val bindingNotReal: FragmentResultCurrentBinding
        get() {
            return bindingReal!!
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingReal = FragmentResultCurrentBinding.inflate(inflater, container, false)
        return bindingNotReal.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        renderData()
    }


    private fun renderData() {

        bindingReal?.let{
            it.resultCurrentConstraintLayoutCityName?.text = "Москва"
            it.resultCurrentConstraintLayoutCityCoordinates?.text = "55"
            it.resultCurrentConstraintLayoutTemperatureValue?.text = "55"
            it.resultCurrentConstraintLayoutFeelslikeValue?.text = "Россия"
        }

        // СПОСОБ ЗАГРУЗКИ РАСТРОВОГО JPG, PNG
/*        bindingReal?.resultImageFeels?.let {
            Glide
                .with(it)
//                .load("https://c1.staticflickr.com/1/186/31520440226_175445c41a_b.jpg")
                // ИЛИ
                .load("https://freepngimg.com/thumb/city/36275-3-city-hd.png")
                .into(it)
        }*/

        // СПОСОБ ЗАГРУЗКИ РАСТРОВОГО JPG, PNG

        Picasso
            .get()
//            .load("https://c1.staticflickr.com/1/186/31520440226_175445c41a_b.jpg")
            // ИЛИ
//            .load("https://freepngimg.com/thumb/city/36275-3-city-hd.png")
            .load(R.drawable.red)
//            .transform(CircleTransformation())
            .transform(StarTransformation())
//            .rotate(90f)
            .into(bindingReal?.resultImageFeels)



        // СПОСОБ ЗАГРУЗКИ РАСТРОВОГО PNG
//        bindingReal?.resultImageFeels?.load("https://freepngimg.com/thumb/city/36275-3-city-hd.png")
//        bindingReal?.resultImageFeels?.load("https://c1.staticflickr.com/1/186/31520440226_175445c41a_b.jpg")


        // СПОСОБ ЗАГРУЗКИ ВЕКТОРНЫХ SVG
//        bindingReal?.resultsImageHeader?.loadUrl("https://yastatic.net/weather/i/icons/blueye/color/svg/ovc.svg")
//        bindingReal?.resultsImageHeader?.loadUrl("https://yastatic.net/weather/i/icons/blueye/color/svg/${weather.icon}.svg")
    }

    // НУЖНО ДЛЯ ЗАГРУЗКИ ВЕКТОРНЫХ SVG
//    fun ImageView.loadUrl(url: String) {
//
//        val imageLoader = ImageLoader.Builder(this.context)
//            .componentRegistry { add(SvgDecoder(this@loadUrl.context)) }
//            .build()
//
//        val request = ImageRequest.Builder(this.context)
//            .crossfade(true)
//            .crossfade(500)
//            .data(url)
//            .target(this)
//            .build()
//
//        imageLoader.enqueue(request)
//    }

    // Удаление binding при закрытии фрагмента
    override fun onDestroy() {
        super.onDestroy()
        bindingReal = null
    }
}