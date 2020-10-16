package com.andromotica.petagram.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.andromotica.petagram.R;
import com.andromotica.petagram.adapters.PageAdapter;
import com.andromotica.petagram.fragments.HomeFragment;
import com.andromotica.petagram.fragments.PetFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //ArrayList<Pet> pets;
    //private RecyclerView listaPets;
    private Toolbar toolbar;
    private ImageView estrella;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbarmain);
        tabLayout = (TabLayout) findViewById(R.id.taplayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        estrella = findViewById(R.id.estrella);


        estrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LikePetsActivity.class);
                startActivity(intent);
            }
        });
        //listaPets = (RecyclerView) findViewById(R.id.listaPets);
        //LinearLayoutManager llm = new LinearLayoutManager(this);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        //listaPets.setLayoutManager(llm);

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

    }

    /*
    public void inicializadorAdaptador(){
        PetagramAdapter adaptador = new PetagramAdapter(pets);
        listaPets.setAdapter(adaptador);
    }
    public void inicializarListaPets(){
        pets = new ArrayList<Pet>();
        pets.add(new Pet(R.drawable.betel, "Betel"));
        pets.add(new Pet(R.drawable.angel, "Angel"));
        pets.add(new Pet(R.drawable.cosiris, "Cosiris"));
        pets.add(new Pet(R.drawable.gucci, "Gucci"));
        pets.add(new Pet(R.drawable.canela, "Canela"));
    }
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menumain, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.contacto:
                Intent intent = new Intent(this, FormularioActivity.class);
                startActivity(intent);
                break;
            case R.id.about:
                Intent intent1 = new Intent(this, AboutActivity.class);
                startActivity(intent1);
                break;
            case R.id.configurarcuenta:
                Intent intent2 = new Intent(this, ConfigurarCuentaActivity.class);
                startActivity(intent2);
                break;
            case R.id.configurarnotificaciones:
                Intent intent3 = new Intent(this, RecibirNotificacionesActivity.class);
                startActivity(intent3);
                break;
        }
        return true;
    }

    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new PetFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);

        try {
            tabLayout.getTabAt(0).setIcon(R.drawable.home);
            tabLayout.getTabAt(1).setIcon(R.drawable.pets);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}