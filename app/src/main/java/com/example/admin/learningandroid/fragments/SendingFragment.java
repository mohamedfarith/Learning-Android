package com.example.admin.learningandroid.fragments;


import android.content.Context;
import android.os.Bundle;
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
    public DataTransferBetweenFragments data;
    public EditText etFromSendingFragment;
    public Button buttonSendData;
    public String strText;

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
        data = (DataTransferBetweenFragments) getActivity();
        Log.v(mTAG, "onAttach of Sending Fragment");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.v(mTAG, "onActivityCreated of Sending Fragment");
        etFromSendingFragment = getActivity().findViewById(R.id.et_sending_fragment);
        buttonSendData = getActivity().findViewById(R.id.button_send_data);
        buttonSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strText = etFromSendingFragment.getText().toString();
                data.setData(strText);
            }
        });
    }

    public void clearingEditTextOnButtonClick() {
        etFromSendingFragment.setText("");
    }
}
