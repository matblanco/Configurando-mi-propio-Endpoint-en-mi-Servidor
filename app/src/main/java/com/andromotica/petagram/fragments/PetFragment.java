package com.andromotica.petagram.fragments;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andromotica.petagram.R;
import com.andromotica.petagram.adapters.MiPetAdapter;
import com.andromotica.petagram.adapters.PetagramAdapter;
import com.andromotica.petagram.pojo.MiPet;
import com.andromotica.petagram.pojo.Pet;
import com.andromotica.petagram.presentador.IMipetPresentador;
import com.andromotica.petagram.presentador.MipetPresentador;

import java.util.ArrayList;

public class PetFragment extends Fragment implements IPetFragment {

    private RecyclerView recycler;
    ArrayList<MiPet> pets;
    private IMipetPresentador iMipetPresentador;
    private ImageView imageViewq;
    private TextView profileName;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pet, container, false);

        profileName = v.findViewById(R.id.profileName);
        imageViewq = v.findViewById(R.id.imgFotoProfile);
        recycler = (RecyclerView) v.findViewById(R.id.rcMimascota);
        iMipetPresentador = new MipetPresentador(this, getContext(), imageViewq,profileName);
        return v;
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getContext(), 2);
        recycler.setLayoutManager(glm);
    }

    @Override
    public MiPetAdapter crearAdaptador(ArrayList<MiPet> miPets) {
        return new MiPetAdapter(miPets, getActivity());
    }


    @Override
    public void inicializarAdaptadorRV(MiPetAdapter adaptador) {
        recycler.setAdapter(adaptador);
    }
}