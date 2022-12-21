package com.example.listapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listapplication.databinding.ListItemBinding;

public class PostAdapter  extends ArrayAdapter<Posts> {
    private final Posts[] post;
    public ListItemBinding binding;

    public PostAdapter(@NonNull Context context, Posts[] post) {
        super(context, R.layout.list_item);
        this.post = post;
    }
        @Override
        public int getCount() {
            return post.length;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Posts posts = post[position];
            this.binding =ListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        binding.postName.setText(posts.getName());
        binding.like.setText(String.valueOf(posts.getLikes()));
        binding.comment.setText(String.valueOf(posts.getComments()));
        binding.photo.setImageResource(posts.getImageResourceId());
        binding.likeIcon.setImageResource(posts.isLiked()?R.drawable.redlike:R.drawable.like);
            binding.likeLayout.setOnClickListener(view -> {
                posts.plusLike();
                notifyDataSetInvalidated();
            });
            binding.commentLayout.setOnClickListener(view -> {
                posts.plusComments();
                Intent intent =new Intent(getContext(), AnotherActivity.class);
                intent.putExtra("Name",posts.getName() );
                getContext().startActivity(intent);
                notifyDataSetInvalidated();
            });
            binding.shareLayout.setOnClickListener(view -> {
                Toast.makeText(getContext(), "Shared" , Toast.LENGTH_SHORT).show();
            });

        return binding.getRoot();



    }

}
