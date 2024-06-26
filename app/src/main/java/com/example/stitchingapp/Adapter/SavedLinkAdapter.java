// SavedLinkAdapter.java
package com.example.stitchingapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stitchingapp.R;

import java.util.List;

public class SavedLinkAdapter extends RecyclerView.Adapter<SavedLinkAdapter.ViewHolder> {

    private List<String> savedLinks;
    private Context context;

    public SavedLinkAdapter(List<String> savedLinks, Context context) {
        this.savedLinks = savedLinks;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_saved_link, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String link = savedLinks.get(position);
        holder.textView.setText(link);
    }

    @Override
    public int getItemCount() {
        return savedLinks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewSavedLink);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            String url = savedLinks.get(position);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(intent);
        }
    }
}
