package com.example.course2androidnews.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.course2androidnews.DetailBerita;
import com.example.course2androidnews.R;
import com.example.course2androidnews.retrofitjson.ArticlesItem;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<ArticlesItem> items;

    public MyAdapter(Context context, List<ArticlesItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.adapter_news, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        ((MyViewHolder)holder).title.setText(items.get(position).getTitle().toString());
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
                .threadPriority(Thread.NORM_PRIORITY-2)
                .denyCacheImageMultipleSizesInMemory()
                .build();
        ((MyViewHolder)holder).imageLoader.init(configuration);
        ((MyViewHolder)holder).imageLoader.displayImage(items.get(position).getUrlToImage(),((MyViewHolder)holder).imageView);
        ((MyViewHolder)holder).click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Kamu klik new list pada psisi "+position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DetailBerita.class);
                intent.putExtra("title", items.get(position).getTitle());
                intent.putExtra("urlToImage", items.get(position).getUrlToImage());
                intent.putExtra("content", items.get(position).getContent());
                intent.putExtra("url", items.get(position).getUrl());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title;
        private ImageLoader imageLoader;
        private LinearLayout click;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageId);
            title = itemView.findViewById(R.id.titleId);
            click = itemView.findViewById(R.id.click);
            imageLoader = ImageLoader.getInstance();
        }
    }
}
