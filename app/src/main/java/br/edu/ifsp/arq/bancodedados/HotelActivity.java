package br.edu.ifsp.arq.bancodedados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.edu.ifsp.arq.bancodedados.model.Hotel;

public class HotelActivity extends AppCompatActivity implements HotelListFragment.AoClicarNoHotel{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void clicouNoHotel(Hotel hotel) {
        Intent intent = new Intent(this, HotelDetalheActivity.class);
        intent.putExtra("hotel", hotel);
        startActivity(intent);
    }

}
