package usa.proyecto.mipanaderia;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;

public class UbicacionesActivity extends AppCompatActivity {

    ArrayList<OverlayItem> puntos = new ArrayList<OverlayItem>();
    private MapView myOpenMapView;
    private MapController myMapController;
    private ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicaciones);
        /* ---- necesitamos establecer el valor del agente de usuario en la configuración ------- */
        //pre 5.6
        //OpenStreetMapTileProviderConstants.setUserAgentValue(BuildConfig.APPLICATION_ID);
        //5.6 and newer
        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);
        /* -------------------------------------------------------------------------------------- */

        /*   punto de geolocalizacion de ejemplo */
        GeoPoint Centro = new GeoPoint(4.6224038, -74.0680126);
        GeoPoint Kennedy = new GeoPoint(4.6261069, -74.1470604);
        GeoPoint Chico = new GeoPoint(4.6699149, -74.051139);

        //----------------------------------------------------------------------------------

        myOpenMapView = (MapView) findViewById(R.id.openmapview);
        myOpenMapView.setBuiltInZoomControls(true);

        myMapController = (MapController) myOpenMapView.getController();
        myMapController.setCenter(Centro);
        myMapController.setZoom(13);

        myOpenMapView.setMultiTouchControls(true);
        puntos.add(new OverlayItem("Panceto", "Sede Centro", Centro));
        puntos.add(new OverlayItem("Panceto", "Sede Kennedy", Kennedy));
        puntos.add(new OverlayItem("Panceto","Sede Chicó", Chico));
        refrescaPuntos();

        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_gingerbread);
    }




    ItemizedIconOverlay.OnItemGestureListener<OverlayItem> tap = new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
        @Override
        public boolean onItemLongPress(int arg0, OverlayItem arg1) {
            return false;
        }
        @Override
        public boolean onItemSingleTapUp(int index, OverlayItem item) {
            return true;
        }
    };
    private void refrescaPuntos() {
        myOpenMapView.getOverlays().clear();
        ItemizedIconOverlay.OnItemGestureListener<OverlayItem> tap = new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemLongPress(int arg0, OverlayItem arg1) {
                return false;
            }

            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }
        };

        ItemizedOverlayWithFocus<OverlayItem> capa = new ItemizedOverlayWithFocus<>(this, puntos, tap);
        capa.setFocusItemsOnTap(true);
        myOpenMapView.getOverlays().add(capa);
    }
}