package com.example.p6_fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailCategoryFragment extends Fragment implements View.OnClickListener {

    private TextView tvCategoryName, tvCategoryDescription;
    private Button btnProfile, btnShowDialog;
    public static String EXTRA_NAME = "extra_name";
    private String description;
    public DetailCategoryFragment() {
        // Required empty public constructor
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_category, container, false);
        tvCategoryName = (TextView)view.findViewById(R.id.tv_category_name);
        tvCategoryDescription = (TextView)view.findViewById(R.id.tv_category_description);
        btnProfile = (Button)view.findViewById(R.id.btn_profile);
        btnProfile.setOnClickListener(this);
        btnShowDialog = (Button)view.findViewById(R.id.btn_show_dialog);
        btnShowDialog.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String categoryName = getArguments().getString(EXTRA_NAME);
        tvCategoryName.setText(categoryName);
        tvCategoryDescription.setText(getDescription());
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.btn_profile){
            //
        } else if (v.getId() == R.id.btn_show_dialog){
            OptionDialogFragment mOptionDialogFragment = new OptionDialogFragment();
            mOptionDialogFragment.setOnOptionDialogListener(new OptionDialogFragment.OnOptionDialogListener() {
                @Override
                public void onOptionChoosen(String text) {
                    Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
                }
            });
            FragmentManager mFragmentManager = getChildFragmentManager();
            mOptionDialogFragment.show(mFragmentManager, OptionDialogFragment.class.getSimpleName());
        }
    }
}