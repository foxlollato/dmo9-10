package br.edu.ifsp.arq.bancodedados;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;
import br.edu.ifsp.arq.bancodedados.controller.HotelController;
import br.edu.ifsp.arq.bancodedados.model.Hotel;

    public class HotelListFragment extends ListFragment {
        List<Hotel> hoteis;
        ArrayAdapter<Hotel> adapter;
        HotelController controller;
        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            controller = new HotelController(getActivity());
            cadastrarHoteis();
            carregarHoteis();
        }
        private void cadastrarHoteis(){
            Hotel hotel1 = new Hotel("Comfort Hotel","Avenida 36", 4.5f );
            controller.salvar(hotel1);
            Hotel hotel2 = new Hotel("Othon Hotel","Avenida 36", 4.0f );
            controller.salvar(hotel2);
        }
        private void carregarHoteis(){
            hoteis = controller.buscar(null);
            adapter = new ArrayAdapter<Hotel>(getActivity(),
                    android.R.layout.simple_list_item_1, hoteis);
            setListAdapter(adapter);
        }

        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            super.onListItemClick(l, v, position, id);
            Activity activity = getActivity();
            if(activity instanceof AoClicarNoHotel){
                Hotel hotel = (Hotel)l.getItemAtPosition(position);
                AoClicarNoHotel listener = (AoClicarNoHotel)activity;
                listener.clicouNoHotel(hotel);
            }}
        public interface AoClicarNoHotel{
            void clicouNoHotel(Hotel hotel);
        }
    }