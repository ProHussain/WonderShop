package com.training.wondershop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.training.wondershop.R
import com.training.wondershop.models.Product
import javax.inject.Inject

class MainAdapter () : RecyclerView.Adapter<MainAdapter.MainViewHolder>(){
    private var products: List<Product> = emptyList()

    fun setProducts(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }
    inner class MainViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var productTitle: TextView = itemView.findViewById(R.id.tv_title)
        var productPrice: TextView = itemView.findViewById(R.id.tv_price)
        var productCategory: TextView = itemView.findViewById(R.id.tv_category)
        var productImage: ImageView = itemView.findViewById(R.id.img_product)

        fun bindData(product: Product) {
            productTitle.text = product.title
            productPrice.text = product.price.toString()
            productCategory.text = product.category
            Glide.with(itemView.context).load(product.image).placeholder(R.drawable.ic_launcher_foreground).into(productImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val product:Product = products[position]
        holder.bindData(product)
    }
}