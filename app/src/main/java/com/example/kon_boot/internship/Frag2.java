package com.example.kon_boot.internship;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Frag2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;
    private TextView txterror;
    private ImageButton imageButton;
    private ProgressBar progressBar;
    EditText editText;
    String search;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Frag2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Frag2.
     */
    // TODO: Rename and change types and number of parameters
    public static Frag2 newInstance(String param1, String param2) {
        Frag2 fragment = new Frag2();
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
        View V1= inflater.inflate(R.layout.fragment_blank, container, false);
        recyclerView =V1.findViewById(R.id.recyclerview1);
        imageButton = V1.findViewById(R.id.imagesearch);
        txterror =V1.findViewById(R.id.text);
        progressBar=V1.findViewById(R.id.progressbar);
        editText =V1.findViewById(R.id.search);
        search = editText.getText().toString();
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
                progressBar.setVisibility(View.VISIBLE);
            }
        });


        return V1;
    }

    private void getData() {

        Call<Autocomplete> postlistCall = FlickerSearchAPI.getPostService().getSearch(editText.getText().toString().toLowerCase());
        postlistCall.enqueue(new Callback<Autocomplete>() {
            @Override
            public void onResponse(Call<Autocomplete> call, Response<Autocomplete> response) {
               Autocomplete lst2 = response.body();
                if(lst2.getPhotos().getPhoto().size()==0)
                {
                    progressBar.setVisibility(View.INVISIBLE);
                    txterror.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.INVISIBLE);
                }
                else
                {
                    progressBar.setVisibility(View.INVISIBLE);
                    recyclerView.setVisibility(View.VISIBLE);
                    recyclerView.setAdapter(new RecyclerAdapter(getContext(),lst2.getPhotos().getPhoto()));
                    Toast.makeText(getActivity(),"Successful",Toast.LENGTH_SHORT).show();
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                }
            }

            @Override
            public void onFailure(Call<Autocomplete> call, Throwable t) {
                Toast.makeText(getActivity(),"Error" , Toast.LENGTH_SHORT).show();
            }
        });
    }

}
