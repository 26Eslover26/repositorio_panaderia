package usa.proyecto.mipanaderia;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import usa.proyecto.mipanaderia.databinding.ActivityMainMenuBinding;

public class MainMenu extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainMenuBinding binding;
    private TextView txtEntrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMainMenu.toolbar);
        binding.appBarMainMenu.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_productos, R.id.nav_servicios, R.id.nav_sucursales, R.id.nav_info)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main_menu);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    protected void onStart() {
        super.onStart();
        txtEntrada = findViewById(R.id.txtInfoBienvenida);
        Bundle bundle = getIntent().getExtras();
        if (bundle.getString("nombre")!=null){
            txtEntrada.setText("Bienvenid@"+" "+bundle.getString("nombre"));
        }
    }

    /*@Override
    protected void onResume() {
        super.onResume();
        Button btn = findViewById(R.id.favoriteId);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "añadido a favoritos", Snackbar.LENGTH_LONG)
                        .setActionTextColor(getResources().getColor(R.color.amarillo))
                        .setAction("Deshacer", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                showNotification("TEST NOTIFY",
                                       "Esta es una notificación de prueba");
                                //onBackPressed();
                            }
                        })
                        .show();
            }
        });
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.crud) {

            Intent segundaPantalla = new Intent(this, CrudActivity.class);
            startActivity(segundaPantalla);
        }
        if (id == R.id.ubicacionesId) {
            Intent terceraPantalla = new Intent(this, UbicacionesActivity.class);
            startActivity(terceraPantalla);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main_menu);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    void showNotification(String title, String message) {
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("MY_CHANNEL_ID",
                    "MY_CHANNEL_NAME",
                    NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("YOUR_NOTIFICATION_CHANNEL_DESCRIPTION");
            mNotificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(getApplicationContext(), "MY_CHANNEL_ID")
                .setSmallIcon(R.mipmap.ic_gingerbread_foreground)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true);
        Intent intent = new Intent(getApplicationContext(),MainMenu.class);
        intent.putExtra("nombre", "desde notify");

        PendingIntent p1 = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setContentIntent(p1);
        mNotificationManager.notify(0, mBuilder.build());
    }
}