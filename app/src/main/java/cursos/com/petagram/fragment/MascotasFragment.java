package cursos.com.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cursos.com.petagram.R;
import cursos.com.petagram.adapter.MascotaAdapter;
import cursos.com.petagram.db.ConstructorMascota;
import cursos.com.petagram.pojo.Mascota;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotasFragment extends Fragment {


    private static final String TAG = MascotasFragment.class.getName();
    private List<Mascota> mascotas;
    private RecyclerView vista;


    public MascotasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mascotas, container, false);
        vista = (RecyclerView) view.findViewById(R.id.rvMascotas);

        Log.i(TAG, "Llenando lista de mascotas");
        generarMascotas();
        Log.i(TAG, "Iniciand adaptador");
        inicarAdaptador();


        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        vista.setLayoutManager(llm);


        return view;
    }



    private void inicarAdaptador() {
        MascotaAdapter ma = new MascotaAdapter(mascotas,getContext());
        vista.setAdapter(ma);
    }

    private void generarMascotas() {

        ConstructorMascota cm = new ConstructorMascota(getContext());
        mascotas = cm.obtenerDatos();

    }
}
