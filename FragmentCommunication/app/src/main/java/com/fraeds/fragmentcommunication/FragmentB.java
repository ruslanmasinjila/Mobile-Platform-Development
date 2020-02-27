package com.fraeds.fragmentcommunication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment {




    ////////////////////////////////////////////////////////////////////////////////////////////
    private TextView TextView_NAME;
    private String   TextView_NAME_VALUE = "AAA";

    private TextView TextView_AGE;
    private String   TextView_AGE_VALUE = "BBB";

    private TextView TextView_TELEPHONE;
    private String   TextView_TELEPHONE_VALUE= "CCC";

    private TextView TextView_EMAIL;
    private String   TextView_EMAIL_VALUE = "DDD";


    private TextView TextView_ADDRESS;
    private String   TextView_ADDRESS_VALUE = "EEE";
    ////////////////////////////////////////////////////////////////////////////////////////////

    public FragmentB ()
    {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        // Link the TextViews
        TextView_NAME = (TextView)view.findViewById(R.id.TextView_NAME);
        TextView_NAME.setText("AAA");

        TextView_AGE = (TextView)view.findViewById(R.id.TextView_AGE);
        TextView_AGE.setText("BBB");

        TextView_TELEPHONE = (TextView)view.findViewById(R.id.TextView_TELEPHONE);
        TextView_TELEPHONE.setText("CCC");

        TextView_EMAIL = (TextView)view.findViewById(R.id.TextView_EMAIL);
        TextView_EMAIL.setText("DDD");

        TextView_ADDRESS = (TextView)view.findViewById(R.id.TextView_ADDRESS);
        TextView_ADDRESS.setText("EEE");

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

    }
}
