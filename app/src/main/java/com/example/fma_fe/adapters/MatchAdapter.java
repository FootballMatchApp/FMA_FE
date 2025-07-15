package com.example.fma_fe.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fma_fe.R;
import com.example.fma_fe.models.Match;

import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchViewHolder> {

    private List<Match> matchList;

    public MatchAdapter(List<Match> matchList) {
        this.matchList = matchList;
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_match_recycler_item, parent, false);
        return new MatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        Match match = matchList.get(position);

        if (match == null) return;

        holder.tvTitle.setText(match.getTitle());
        holder.tvTime.setText("🕒 " + match.getTime());
        holder.tvLocation.setText("📍 " + match.getLocation());
    }

    @Override
    public int getItemCount() {
        return matchList != null ? matchList.size() : 0;
    }

    public static class MatchViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvTime, tvLocation;

        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_match_title);
            tvTime = itemView.findViewById(R.id.tvMatchTime);
            tvLocation = itemView.findViewById(R.id.tvMatchLocation);
        }
    }
}

