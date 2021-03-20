package com.erikaosgue.kotlinrecyclerview.data

import android.view.InflateException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.erikaosgue.kotlinrecyclerview.R
import com.erikaosgue.kotlinrecyclerview.models.BlogPost
import java.util.zip.Inflater

class MyClassAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var listBlogPost: List<BlogPost> = ArrayList<BlogPost>()
    class MyViewHolder (val myViewLayout: View): RecyclerView.ViewHolder(myViewLayout) {
        fun render(blogPost: BlogPost) {

            // Getting the views from the Layout I created
            val blogImage = myViewLayout.findViewById<ImageView>(R.id.blog_image)
            val blogTitle = myViewLayout.findViewById<TextView>(R.id.blog_title)
            val blogAuthor = myViewLayout.findViewById<TextView>(R.id.blog_author)

            //Assign values to the myViewLayout
            blogTitle.text = blogPost.title
            blogAuthor.text = blogPost.username

            // Setting the image into my ViewHolder
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(myViewLayout.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(blogPost.image)
                .into(blogImage)

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflateLayout = LayoutInflater.from(parent.context).inflate(R.layout.layout_blog_list_item, parent, false)
        return MyViewHolder(inflateLayout)
    }

    override fun onBindViewHolder(myHolder: RecyclerView.ViewHolder, position: Int) {
        // To use with different types of ViewHolders
        when(myHolder){
            is MyViewHolder -> {
                myHolder.render(listBlogPost[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return listBlogPost.size
    }

    fun submitList(blogList: List<BlogPost>){
        listBlogPost = blogList
    }
}