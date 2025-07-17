package ru.itis.homework2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.itis.homework2.databinding.ItemModelBinding
import ru.itis.homework2.data.ModelItem
import ru.itis.homework2.util.Constants

class MainAdapter(private val items: MutableList<ModelItem>, private val onItemClick: (ModelItem)->Unit)
    : RecyclerView.Adapter<MainAdapter.Holder>() {

    inner class Holder(val binding: ItemModelBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ModelItem) {
            binding.titleTv.text = item.title
            binding.descTv.text = item.description
            binding.imageIv.setImageResource(item.imageRes)
            binding.root.setOnClickListener { onItemClick(item) }
            binding.imageIv.setOnClickListener {
                item.imageRes = Constants.IMAGE_LIST.random()
                notifyItemChanged(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= Holder(
        ItemModelBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: Holder, position: Int) = holder.bind(items[position])
    override fun getItemCount() = items.size
}
