package com.example.weightliftingcompetition.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weightliftingcompetition.R;
import com.example.weightliftingcompetition.model.Athlete;

import java.util.ArrayList;

public class AthleteAdapter extends RecyclerView.Adapter<AthleteAdapter.AthleteViewHolder> {
    private static ArrayList<Athlete> athletes;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Athlete athlete);
        void onItemLongClick(Athlete athlete);
    }

    public AthleteAdapter(ArrayList<Athlete> athletes, OnItemClickListener listener) {
        this.athletes = athletes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AthleteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.athlete, parent, false);
        return new AthleteViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull AthleteViewHolder holder, int position) {
        Athlete athlete = athletes.get(position);
        holder.name.setText(athlete.getName());
        holder.weight.setText(String.valueOf(athlete.getLiftWeights().get(athlete.getLiftWeights().size() - 1)));
    }

    @Override
    public int getItemCount() {
        return athletes.size();
    }

    static class AthleteViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView weight;

        AthleteViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            name = itemView.findViewById(R.id.textView);
            weight = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(athletes.get(position));
                    }
                }
            });

            itemView.setOnLongClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemLongClick(athletes.get(position));
                        return true;
                    }
                }
                return false;
            });
        }
    }
}

