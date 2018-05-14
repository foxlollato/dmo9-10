package br.edu.ifsp.arq.bancodedados;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import br.edu.ifsp.arq.bancodedados.model.Hotel;

/**
 * Created by dmo on 14/05/18.
 */

public class HotelDetalheActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_hotel);
        if(savedInstanceState == null){Intent intent = getIntent();
            Hotel hotel = (Hotel)intent.getSerializableExtra("hotel");
            HotelDetalheFragment fragment =
                    HotelDetalheFragment.novaInstancia(hotel);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.detalhe, fragment, "tagDetalhe");
            ft.commit();
        }
    }
}