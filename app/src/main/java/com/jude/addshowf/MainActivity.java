package com.jude.addshowf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoToAnime();

    }

    private void GoToAnime() {

        FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FrameLayoutMain, new ShowFragment());
        ft.commit();
    }

}