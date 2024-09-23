package com.example.artspace

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ArtworkAdapter(private val artworks: List<Artwork>) : RecyclerView.Adapter<ArtworkAdapter.ArtworkViewHolder>() {

    inner class ArtworkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.artworkImageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtworkViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_artwork, parent, false)
        return ArtworkViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArtworkViewHolder, position: Int) {
        val artwork = artworks[position]
        holder.imageView.setImageResource(artwork.imageResId)
    }

    override fun getItemCount(): Int = artworks.size
}

