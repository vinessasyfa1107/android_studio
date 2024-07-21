package com.example.p6_fragment;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class OptionDialogFragment extends DialogFragment implements View.OnClickListener {

    private Button btnChoose, btnClose;
    private RadioGroup rgOptions;
    private RadioButton rbSaf, rbMou, rbMoyes, rbLvg;
    private OnOptionDialogListener onOptionDialogListener;

    public OptionDialogFragment() {
        // Required empty public constructor
    }

    public OnOptionDialogListener getOnOptionDialogListener() {
        return onOptionDialogListener;
    }

    public void setOnOptionDialogListener(OnOptionDialogListener onOptionDialogListener){
        this.onOptionDialogListener = onOptionDialogListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_option_dialog, container, false);

        btnChoose = (Button)view.findViewById(R.id.btn_choose);
        btnChoose.setOnClickListener(this);

        btnClose = (Button)view.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(this);

        rgOptions = (RadioGroup)view.findViewById(R.id.rg_options);
        rbSaf = (RadioButton) view.findViewById(R.id.rb_saf);
        rbLvg = (RadioButton) view.findViewById(R.id.rb_lvg);
        rbMou = (RadioButton) view.findViewById(R.id.rb_mou);
        rbMoyes = (RadioButton) view.findViewById(R.id.rb_moyes);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_close){
            getDialog().cancel();
        } else if (v.getId() == R.id.btn_choose) {
            int checkedRadioButtonId = rgOptions.getCheckedRadioButtonId();

            if (checkedRadioButtonId != -1){
                String coach = null;

                if (checkedRadioButtonId == R.id.rb_saf){
                    coach = rbSaf.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_mou){
                    coach = rbMou.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_lvg){
                    coach = rbLvg.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_moyes){
                    coach = rbMoyes.getText().toString().trim();
                }

                getOnOptionDialogListener().onOptionChoosen(coach);
            getDialog().cancel();
            }
        }
    }
//    public void closeDialog() {
//        FragmentManager fragmentManager = getParentFragmentManager(); // atau getFragmentManager() tergantung pada konteks
//
//        if (fragmentManager != null) {
//            FragmentTransaction ft = fragmentManager.beginTransaction();
//            Fragment prev = fragmentManager.findFragmentByTag("dialog");
//            if (prev != null) {
//                DialogFragment df = (DialogFragment) prev;
//                df.dismiss();
//            }
//            ft.commit();
//        }
//    }
//    public void show(FragmentManager manager, String tag) {
//        FragmentTransaction ft = manager.beginTransaction();
//        ft.add(this, tag);
//        ft.commitAllowingStateLoss();
//    }
    public interface OnOptionDialogListener {
        void onOptionChoosen(String text);
    }
}