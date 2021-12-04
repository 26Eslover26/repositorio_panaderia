package usa.proyecto.mipanaderia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources reso = getResources();
        Drawable drawable = reso.getDrawable(R.drawable.kamranaydinov, getTheme());
        ImageView portada = findViewById(R.id.portada);
        portada.setImageDrawable(drawable);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuopciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.productosId){
            Toast.makeText(getApplicationContext(), "Productos", Toast.LENGTH_LONG).show();
            Intent pantallaProductos = new Intent(this, Productos.class);
            startActivity(pantallaProductos);
        }
        if(id == R.id.serviciosId){
            Toast.makeText(getApplicationContext(), "Servicios", Toast.LENGTH_LONG).show();
            Intent pantallaServicios = new Intent(this, Servicios.class);
            startActivity(pantallaServicios);
        }
        if(id == R.id.sucursalesId){
            Toast.makeText(getApplicationContext(), "Sucursales", Toast.LENGTH_LONG).show();
            Intent pantallaSucursales = new Intent(this, Sucursales.class);
            startActivity(pantallaSucursales);
        }
        return super.onOptionsItemSelected(item);
    }
}