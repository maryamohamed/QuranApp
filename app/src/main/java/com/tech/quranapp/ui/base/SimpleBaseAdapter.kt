package com.tech.care.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.tech.quranapp.ui.base.BaseDiffUtil

/**
 * BaseAdapter is an abstract class designed to simplify the implementation of RecyclerView adapters in Android applications.
 *
 * @param T The type of data items that will be displayed in the RecyclerView.
 * @param VB The type of ViewBinding used for the RecyclerView item views.
 * @property items The list of data items to be displayed in the RecyclerView.
 *
 * @constructor Creates a BaseAdapter with the provided list of data items.
 */
abstract class SimpleBaseAdapter<T, VB : ViewBinding>(
    private var items: List<T>,
) : RecyclerView.Adapter<SimpleBaseAdapter.BaseViewHolder<VB>>() {

    /**
     * This property should be implemented by subclasses to provide a way to inflate the ViewBinding for RecyclerView item views.
     */
    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VB

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VB> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = bindingInflater(inflater, parent, false)

        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int) {
        val currentItem = items[position]
        onBindViewHolder(holder, position, currentItem)
    }

    override fun getItemCount() = items.size

    /**
     * Subclasses should implement this method to bind data to the item view and customize its appearance.
     *
     * @param holder The [BaseViewHolder] to bind data to.
     * @param position The position of the item within the adapter's data set.
     * @param currentItem The data item to bind to the item view at the specified position.
     */
    abstract fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int, currentItem: T)

    /**
     * [BaseViewHolder] is a generic inner class that holds the ViewBinding for a RecyclerView item view.
     *
     * @property binding The ViewBinding for the RecyclerView item view.
     * @constructor Creates a [BaseViewHolder] with the provided ViewBinding.
     */
    class BaseViewHolder<VB : ViewBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root)

    /**
     * Sets a new list of data items for the adapter and updates the RecyclerView with any changes using DiffUtil.
     *
     * @param newItems The new list of data items to be displayed in the RecyclerView.
     */
    open fun setItems(newItems: List<T>) {
        val diffResult =
            DiffUtil.calculateDiff(BaseDiffUtil(items, newItems, ::areItemsSame, ::areContentSame))
        items = newItems
        diffResult.dispatchUpdatesTo(this)
    }

    open fun areItemsSame(oldItem: T, newItem: T) = oldItem?.equals(newItem) == true

    interface BaseInteractionListener

    open fun areContentSame(oldPosition: T, newPosition: T) = true
}