package com.example.weightliftingcompetition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.os.Handler;

import com.example.weightliftingcompetition.adapter.AthleteAdapter;
import com.example.weightliftingcompetition.model.Athlete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Athlete> athletes = new ArrayList<>();
    private AthleteAdapter athleteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));


        athleteAdapter = new AthleteAdapter(athletes, new AthleteAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Athlete athlete) {
                AthleteDialogFragment.newInstance(athlete).show(getSupportFragmentManager(), "AthleteDialog");
            }

            @Override
            public void onItemLongClick(Athlete athlete) {
                athletes.remove(athlete);
                athleteAdapter.notifyDataSetChanged();
            }
        });
        rv.setAdapter(athleteAdapter);

        for (int i = 0; i < 10; i++) {
            Athlete athlete = new Athlete("Name " + (i + 1), (i + 1) * 10, "Country " + (i + 1));
            athlete.addLiftWeight(new Random().nextInt(200) + 50);
            athletes.add(athlete);
        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (Athlete athlete : athletes) {
                    if (athlete.getLiftWeights().size() < 3) {
                        athlete.addLiftWeight(new Random().nextInt(200) + 50);
                        Collections.sort(athlete.getLiftWeights());
                        athleteAdapter.notifyDataSetChanged();
                        break;
                    }
                }
                handler.postDelayed(this, 300);
            }
        }, 300);


    }
}
