package com.andromotica.petagram.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andromotica.petagram.R;
import com.andromotica.petagram.adapters.PetagramAdapter;
import com.andromotica.petagram.pojo.Pet;
import com.andromotica.petagram.presentador.IRecyclerViewFragmentPresentador;
import com.andromotica.petagram.presentador.RecyclerViewFragmentPresentador;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements IRecyclerViewHomeFragment  {

    ArrayList<Pet> pets;
    private RecyclerView listaPets;
    private IRecyclerViewFragmentPresentador presentador;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        listaPets = (RecyclerView) v.findViewById(R.id.listaPets);
        presentador = new RecyclerViewFragmentPresentador(this,getContext());


        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaPets.setLayoutManager(llm);

    }

    @Override
    public PetagramAdapter crearAdaptador(ArrayList<Pet> pets) {
        return new PetagramAdapter(pets, getActivity());
    }

    @Override
    public void inicializarAdaptadorRV(PetagramAdapter adaptador) {
        listaPets.setAdapter(adaptador);
    }
}