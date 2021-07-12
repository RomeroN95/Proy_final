package cl.rom.proy_final;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import cl.rom.proy_final.databinding.ActivityTurismoBinding;

public class turismo extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener,GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mapa;
    private Marker Municipalidad,Mia,Molino,Alma,Domo,Balsas,CabSF,CabPI;
    private ActivityTurismoBinding binding;
    private Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTurismoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapa = googleMap;


        Municipalidad = mapa.addMarker(new MarkerOptions()
                .position(new LatLng(-36.556919155770395,-71.55074299325446))
                .title("Municipalidad de San Fabian")
                .snippet("21 de Mayo 213, San Fabián, Bío Bío")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        Mia = mapa.addMarker(new MarkerOptions()
                .position(new LatLng(-36.55952628065497,-71.54973441415277))
                .title("Cabañita Mía")
                .snippet("San Fabián, Región del Bío Bío")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        Molino = mapa.addMarker(new MarkerOptions()
                .position(new LatLng(-36.55941221136386,-71.54911880758985))
                .title("Hostal el Molino")
                .snippet("N-31 610, San Fabián, Región del Bío Bío")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        Alma = mapa.addMarker(new MarkerOptions()
                .position(new LatLng(-36.55932264436076,-71.55545869800828))
                .title("Complejo Turistico Alma del Alico")
                .snippet("Carrera interior sur s/n, San Fabián, Región del Bío Bío")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        Domo = mapa.addMarker(new MarkerOptions()
                .position(new LatLng(-36.55932264436076,-71.55545869800828))
                .title("Casa Domo San Fabian")
                .snippet("Purísima sn, Biobío, San Fabián, Ñuble")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        Balsas = mapa.addMarker(new MarkerOptions()
                .position(new LatLng(-36.55932264436076,-71.55545869800828))
                .title("Cabaña las Balsas")
                .snippet("San Fabián, Región del Bío Bío")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        CabSF = mapa.addMarker(new MarkerOptions()
                .position(new LatLng(-36.552947637723484,-71.54726815950755))
                .title("Cabañas San Fabian")
                .snippet("San Fabián, Región del Bío Bío")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        CabPI = mapa.addMarker(new MarkerOptions()
                .position(new LatLng(-36.548928165947196,-71.56417501847385))
                .title("Cabaña Puente Ingles")
                .snippet("Ruta N-31 Km 40,5 Camino a San Fabián un 1 km antes de llegar")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));


        googleMap.setOnMarkerClickListener(this);
        //Dialog
        googleMap.setOnInfoWindowClickListener(this);


        LatLng posicion = new LatLng(-36.556919155770395,-71.55074299325446);
        CameraPosition micamara = CameraPosition.builder()
                .zoom(15)
                .target(posicion)
                .build();
        mapa.moveCamera((CameraUpdateFactory.newCameraPosition(micamara)));
        mapa.getUiSettings().setZoomControlsEnabled(true);
        mapa.getUiSettings().setCompassEnabled(true);
        mapa.getUiSettings().setMapToolbarEnabled(true);


    }


    @Override
    public void onInfoWindowClick(Marker marker) {
        if (Municipalidad.getId()==marker.getId()) {
            FragmentMuni.newIntance(marker.getTitle()
                    , getString(R.string.infoMuni))
                    .show(getSupportFragmentManager(), null);
        }
    }
    @Override
    public boolean onMarkerClick(Marker marker) {
        String MuniciID = Municipalidad.getId();
        String MiaID = Mia.getId();
        String MolinoID = Molino.getId();
        String AlmaID = Alma.getId();
        String DomoID = Domo.getId();
        String BalsasID = Balsas.getId();
        String CabSFID = CabSF.getId();
        String CabPIID = CabPI.getId();

        if (Municipalidad.getId()==marker.getId()) {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
        if (Mia.getId()==marker.getId()) {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
        if (Molino.getId()==marker.getId()) {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
        if (Alma.getId()==marker.getId()) {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
        if (Domo.getId()==marker.getId()) {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
        if (Balsas.getId()==marker.getId()) {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
        if (CabSF.getId()==marker.getId()) {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
        if (CabPI.getId()==marker.getId()) {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
        return false;
    }



}

