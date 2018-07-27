package com.example.admin.learningandroid.fragments;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.learningandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReceivingFragment extends android.support.v4.app.Fragment {
    private static final String mTAG = "Receiving Fragment";
    public TextView receivingText;
    public Button btnClearText;

    public ReceivingFragment() {
        // Required empty public constructor
    }

    public void getData(String data, final EditText sendingFragment) {
        receivingText.setText(data);
        btnClearText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendingFragment.setText("");
                receivingText.setText("");
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v(mTAG, "onCreateView of Receiving Fragment");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.receiving_fragment, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(mTAG, "onCreate of Receiving Fragment");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.v(mTAG, "onActivityCreated of Receiving Fragment");
        receivingText = getActivity().findViewById(R.id.txt_receiving_fragment);
        btnClearText = getActivity().findViewById(R.id.btn_clear_text);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.v(mTAG, "onAttach of Receiving Fragment");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v(mTAG, "onStart of Receiving Fragment");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v(mTAG, "onResume of Receiving Fragment");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v(mTAG, "onPause of Receiving Fragment");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v(mTAG, "onStop of Receiving Fragment");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.v(mTAG, "onDestroyView of Receiving Fragment");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(mTAG, "onDestroy of Receiving Fragment");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.v(mTAG, "onDetach of Receiving Fragment");
    }
}
