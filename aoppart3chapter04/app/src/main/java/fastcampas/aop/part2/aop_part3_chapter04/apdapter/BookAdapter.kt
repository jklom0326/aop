package fastcampas.aop.part2.aop_part3_chapter04.apdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fastcampas.aop.part2.aop_part3_chapter04.databinding.ItemBookBinding
import fastcampas.aop.part2.aop_part3_chapter04.model.Book


class BookAdapter(private val itemClickedListener: (Book) -> Unit) : ListAdapter<Book, BookAdapter.BookItemViewHolder>(diffUtil) {

    inner class BookItemViewHolder(private val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(bookModel: Book) {
            binding.titleTextView.text = bookModel.title
            binding.descripstionTextView.text = bookModel.description

            binding.root.setOnClickListener {
                itemClickedListener(bookModel)
            }

            //context좀 찾아봐야할듯
            Glide
                .with(binding.coverImageView.context)
                .load(bookModel.coverSmallUrl)
                .into(binding.coverImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookItemViewHolder {
        return BookItemViewHolder(
            ItemBookBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BookItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        // object 무명클래스
        val diffUtil = object : DiffUtil.ItemCallback<Book>() {
            override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem.id == newItem.id
            }

        }
    }
}