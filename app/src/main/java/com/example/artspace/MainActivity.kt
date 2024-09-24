package com.example.artspace

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val artworks = listOf(
        Artwork(R.drawable.art_one, "Las Virgenes Cristianas Expuestas al Populacho", "Félix Resurrección Hidalgo (1884)"),
        Artwork(R.drawable.art_two, "The Scream", "Edvard Munch (1893)"),
        Artwork(R.drawable.art_three, "The Starry Night", "Vincent Van Gogh (1889)"),
        Artwork(R.drawable.art_four, "Mango Pickers", "Fernando Amorsolo (1936)"),
        Artwork(R.drawable.art_five, "Spoliarium", "Juan Luna (1884)")
    )

    private lateinit var viewPager: ViewPager2
    private lateinit var descriptionTextView: TextView
    private lateinit var previousButton: Button
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        descriptionTextView = findViewById(R.id.descriptionTextView)
        previousButton = findViewById(R.id.previousButton)
        nextButton = findViewById(R.id.nextButton)

        val adapter = ArtworkAdapter(artworks)
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                descriptionTextView.text = "${artworks[position].title} - ${artworks[position].artist}"
            }
        })

        previousButton.setOnClickListener {
            if (viewPager.currentItem > 0) {
                viewPager.currentItem -= 1
            }
        }

        nextButton.setOnClickListener {
            if (viewPager.currentItem < artworks.size - 1) {
                viewPager.currentItem += 1
            }
        }
    }
}