package com.example.dijonkariz.washme.Model;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dijonkariz.washme.Book;
import com.example.dijonkariz.washme.R;
import com.example.dijonkariz.washme.finishBooking;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class DatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(),this, year, month, day);

        //  return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(),  year, month, day);


    }


    @Override
    public void onDateSet(android.widget.DatePicker view, int year, int month, int day) {
        finishBooking activity = (finishBooking) getActivity();

        activity.processDatePickerResult(year, month, day);
    }
}
