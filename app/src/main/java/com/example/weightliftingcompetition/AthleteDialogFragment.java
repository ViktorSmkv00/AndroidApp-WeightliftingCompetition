package com.example.weightliftingcompetition;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import android.app.AlertDialog;

import com.example.weightliftingcompetition.model.Athlete;

public class AthleteDialogFragment extends DialogFragment {
    private Athlete athlete;

    static AthleteDialogFragment newInstance(Athlete athlete) {
        AthleteDialogFragment fragment = new AthleteDialogFragment();
        fragment.setAthlete(athlete);
        return fragment;
    }

    void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(athlete.getName())
                .setMessage("Personal Weight: " + athlete.getPersonalWeight() + "\nCountry: " + athlete.getCountry() + "\nWeights: " + athlete.getLiftWeights())
                .setPositiveButton("OK", null);
        return builder.create();
    }
}
