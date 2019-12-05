package app.memerr.feature_memerr.rate.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import app.memerr.feature_memerr.R
import app.memerr.feature_memerr.shared.model.Meme
import com.bumptech.glide.Glide

class CardStackAdapter: PagedListAdapter<Meme, CardStackAdapter.ViewHolder>(MemeDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.adapter_meme, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val memeImageView: ImageView = view.findViewById(R.id.memeImageView)
        private val tvTitle: TextView = view.findViewById(R.id.tvTitle)

        fun bind(meme: Meme) {
            Glide.with(memeImageView)
                .load(meme.link)
                .into(memeImageView)

            tvTitle.text = meme.description
        }
    }

    class MemeDiffCallback: DiffUtil.ItemCallback<Meme>() {
        override fun areContentsTheSame(oldItem: Meme, newItem: Meme): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: Meme, newItem: Meme): Boolean {
            return oldItem == newItem
        }
    }
}
