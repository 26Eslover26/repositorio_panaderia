package usa.proyecto.mipanaderia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edCorreo, esContraseña;
    private Button btInicio, btRegistro;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edCorreo = (EditText) findViewById(R.id.correoInicio);

        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_gingerbread);

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
            Intent pantallaProductos = new Intent(this, Productos.class);
            startActivity(pantallaProductos);
            Toast.makeText(getApplicationContext(), "Productos", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.serviciosId){
            Intent pantallaServicios = new Intent(this, Servicios.class);
            startActivity(pantallaServicios);
            Toast.makeText(getApplicationContext(), "Servicios", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.sucursalesId){
            Intent pantallaSucursales = new Intent(this, Sucursales.class);
            startActivity(pantallaSucursales);
            Toast.makeText(getApplicationContext(), "Sucursales", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}