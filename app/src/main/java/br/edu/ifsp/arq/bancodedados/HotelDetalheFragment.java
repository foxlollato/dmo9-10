package br.edu.ifsp.arq.bancodedados;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import br.edu.ifsp.arq.bancodedados.model.Hotel;


public class HotelDetalheFragment extends Fragment {
    private TextView txtNome;
    private TextView txtEndereco;
    private RatingBar rtbEstrelas;
    private Hotel hotel;

    public static HotelDetalheFragment novaInstancia(Hotel hotel){
        Bundle parametros = new Bundle();
        parametros.putSerializable("hotel", hotel);
        HotelDetalheFragment fragment = new HotelDetalheFragment();
        fragment.setArguments(parametros);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hotel = (Hotel)getArguments().getSerializable("hotel");
        setHasOptionsMenu(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_detalhe_hotel, container,
                false);
        txtNome = (TextView)layout.findViewById(R.id.txtNome);
        txtEndereco = (TextView)layout.findViewById(R.id.txtEndereco);
        rtbEstrelas = (RatingBar)layout.findViewById(R.id.rtbEstrelas);
        if(hotel != null){
            txtNome.setText(hotel.getNome());
            txtEndereco.setText(hotel.getEndereco());
            rtbEstrelas.setRating(hotel.getEstrelas());
        }
        return layout;
    }
}
