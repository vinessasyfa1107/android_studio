package com.example.fragmentdropdown;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Fragment4 extends Fragment {

    ImageButton btn_menu;
    Button btn_click;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_4, container, false);

        // Referencing and Initializing the ImageButton and Button
        btn_menu = rootView.findViewById(R.id.btn_menu);
        btn_click = rootView.findViewById(R.id.btn_click);

        // Setting onClick behavior to the ImageButton
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initializing the popup menu and giving the reference as current context
                PopupMenu popupMenu = new PopupMenu(getActivity(), btn_menu);

                // Inflating popup menu from popup_menu.xml file
                popupMenu.getMenuInflater().inflate(R.menu.option_toolbar, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        // Handle menu item click
                        int itemId = menuItem.getItemId();
                        if (itemId == R.id.option1) {
                            // Create and display Fragment1
                            Fragment1 fragment1 = new Fragment1();
                            openFragment(fragment1);
                            return true;
                        } else if (itemId == R.id.option2) {
                            // Create and display Fragment2
                            Fragment2 fragment2 = new Fragment2();
                            openFragment(fragment2);
                            return true;
                        } else if (itemId == R.id.option3) {
                            // Create and display Fragment3
                            Fragment3 fragment3 = new Fragment3();
                            openFragment(fragment3);
                            return true;
                        } else if (itemId == R.id.option4) {
                            // Create and display Fragment4
                            Fragment4 fragment4 = new Fragment4();
                            openFragment(fragment4);
                            return true;
                        }
                        return false;
                    }
                });

                // Showing the popup menu
                popupMenu.show();
            }
        });

        // Setting onClick behavior to the btn_click
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Show toast message
                Toast.makeText(getActivity(), "Sekarang Anda sedang berada di halaman Fragment 4", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    private void openFragment(Fragment fragment) {
        if (getFragmentManager() != null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

}