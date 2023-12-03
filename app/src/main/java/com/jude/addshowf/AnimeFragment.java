package com.jude.addshowf;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.time.Year;

import kotlin.collections.UCollectionsKt;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnimeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnimeFragment extends Fragment {

    private EditText etName, etRelease, etRating;
    private Button btnAdd, btnShow;
    private FireBaseServices fbs;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AnimeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnimeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnimeFragment newInstance(String param1, String param2) {
        AnimeFragment fragment = new AnimeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anime, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        fbs = FireBaseServices.getInstance();
        etName = getView().findViewById(R.id.etName);
        etRating = getView().findViewById(R.id.etRating);
        etRelease = getView().findViewById(R.id.etRelease);
        btnAdd = getView().findViewById(R.id.btnAdd);
        btnShow = getView().findViewById(R.id.btnShow);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String rating = etRating.getText().toString();
                String release = etRelease.getText().toString();

                if(name.trim().isEmpty()||rating.trim().isEmpty()||release.trim().isEmpty())
                {
                    Toast.makeText(getActivity(), "Some fields are empty !", Toast.LENGTH_SHORT).show();
                    return;

                }

                //Adding the Anime
                Integer releasyear= Integer.parseInt(release);
                Double rating10= Double.parseDouble(rating);

                Anime Add = new Anime(name,releasyear,rating10);
                FirebaseFirestore db = fbs.getStore();
                db.collection("AnimePlace").add(Add).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getActivity(),"Anime Added To The List",Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener(){
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getActivity(),"Couldn't Upload Anime, Please Try Again",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // go to Fragment Show!
                GoToShowAnime();
            }
        });

    }

    private void GoToShowAnime() {

        FragmentTransaction ft= getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.FrameLayoutMain, new ShowFragment());
        ft.commit();
    }
}