package com.example.ramadanmubarak;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ramadanmubarak.Adapter.RecyclerViewRamadanList;
import com.example.ramadanmubarak.BackendClass.DataHolder;
import com.example.ramadanmubarak.BackendClass.JSONLoader;
import com.example.ramadanmubarak.BackendClass.Ramadan;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MagrifatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MagrifatFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerViewRamadanList recyclerViewRamadanList;
    ArrayList<Ramadan>ramadanArrayListMagfirat;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MagrifatFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MagrifatFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MagrifatFragment newInstance(String param1, String param2) {
        MagrifatFragment fragment = new MagrifatFragment();
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
        View magfirat= inflater.inflate(R.layout.fragment_magrifat, container, false);

        recyclerView = magfirat.findViewById(R.id.recyclerView);
        getMagfiratData();

        recyclerViewRamadanList = new RecyclerViewRamadanList(DataHolder.ramadanArrayListMagrifat,getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recyclerViewRamadanList);

        return magfirat;
    }

    private void getMagfiratData(){
        JSONLoader jsonLoader = new JSONLoader(getContext());

        try{
            JSONObject object = new JSONObject(jsonLoader.loadJsonFromAsset());
            JSONArray jsonArray = object.getJSONArray("magfirat");
            ramadanArrayListMagfirat = new ArrayList<Ramadan>();

            for(int i =0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                ramadanArrayListMagfirat.add((Ramadan) jsonLoader.parseJSON(jsonObject));
            }

            DataHolder.ramadanArrayListMagrifat=ramadanArrayListMagfirat;
            ;

            System.out.println("Data Get Successful");

        }catch (JSONException e){
            e.printStackTrace();
        }
    }

}