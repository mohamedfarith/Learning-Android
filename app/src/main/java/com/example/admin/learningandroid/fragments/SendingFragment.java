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

import com.example.admin.learningandroid.R;


public class SendingFragment extends android.support.v4.app.Fragment {
    private static final String mTAG = "Sending Fragment";
    public PassingData data;
    public EditText etSendingFragment;
    public Button buttonSendData;
    public String editedText;

    public SendingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v(mTAG, "onCreateView of Sending Fragment");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.sending_fragment_layout, container, false);


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        data = (PassingData) getActivity();
        Log.v(mTAG, "onAttach of Sending Fragment");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.v(mTAG, "onActivityCreated of Sending Fragment");
        etSendingFragment = getActivity().findViewById(R.id.et_sending_fragment);
        buttonSendData = getActivity().findViewById(R.id.button_send_data);
        buttonSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editedText = etSendingFragment.getText().toString();
                data.changeData(editedText, etSendingFragment);
            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(mTAG, "onCreate of Sending Fragment");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v(mTAG, "onStart of Sending Fragment");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v(mTAG, "onPause of Sending Fragment");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v(mTAG, "onResume of Sending Fragment");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v(mTAG, "onStop of Sending Fragment");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.v(mTAG, "onDetach of Sending Fragment");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v(mTAG, "onDestroy of Sending Fragment");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.v(mTAG, "onDestroyView of Sending Fragment");
    }
}
