package usa.proyecto.mipanaderia.dbHelper;

import androidx.appcompat.app.ActionBar;
import
        androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import usa.proyecto.mipanaderia.R;

public class CrudActivity extends AppCompatActivity {

    private EditText et_producto, et_descripcion, et_precio;
    private ActionBar actionBar;
    private Button btnCrear, btnBuscar, btnModificar, btnEliminar, btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud);

        btnCrear = findViewById(R.id.btnRegProd);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Agregado exitosamente", Snackbar.LENGTH_LONG)
                        .setActionTextColor(getResources().getColor(R.color.amarillo))
                        .setAction("Deshacer", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                showNotification("Panceto",
                                        "Quieres agregar un producto diferente?");
                            }
                        })
                        .show();
            }
        });

        et_producto = (EditText) findViewById(R.id.txt_producto);
        et_descripcion = (EditText) findViewById(R.id.txt_descripcion);
        et_precio = (EditText) findViewById(R.id.txt_precio);

        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_gingerbread);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        btnListar = findViewById(R.id.btnSQL);
        /*btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> your_array_list = conectToSQL();
                setListData(your_array_list);
            }
        });*/
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 8);
        }
        return super.dispatchTouchEvent(ev);
    }

    //Método para dar de alta los productos
    /*public void Registrar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Panceto", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String producto = et_producto.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        if(!producto.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("producto", producto);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);

            BaseDeDatos.insert("productos", null, registro);

            BaseDeDatos.close();
            et_producto.setText("");
            et_descripcion.setText("");
            et_precio.setText("");

            Toast.makeText(this,"Registro exitoso", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }*/
    //Método para consultar un artículo o producto
    /*public void Buscar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Panceto", null, 1);
        SQLiteDatabase BaseDeDatabase = admin.getWritableDatabase();

        String codigo = et_producto.getText().toString();

        if(!codigo.isEmpty()){
            Cursor fila = BaseDeDatabase.rawQuery
                    ("select descripcion, precio from articulos where codigo =" + codigo, null);

            if(fila.moveToFirst()){
                et_descripcion.setText(fila.getString(0));
                et_precio.setText(fila.getString(1));
                BaseDeDatabase.close();
            } else {
                Toast.makeText(this,"No existe el artículo", Toast.LENGTH_SHORT).show();
                BaseDeDatabase.close();
            }

        } else {
            Toast.makeText(this, "Debes introducir el código del artículo", Toast.LENGTH_SHORT).show();
        }
    }*/
    //Método para eliminar un producto o Artículo
    /*public void Eliminar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper
                (this, "Panceto", null, 1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String codigo = et_producto.getText().toString();

        if(!codigo.isEmpty()){

            int cantidad = BaseDatabase.delete("articulos", "codigo=" + codigo, null);
            BaseDatabase.close();

            et_producto.setText("");
            et_descripcion.setText("");
            et_precio.setText("");

            if(cantidad == 1){
                Toast.makeText(this, "Artículo eliminado exitosamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "El artículo no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debes de introducir el código del artículo", Toast.LENGTH_SHORT).show();
        }
    }*/
    //Método para modificar un artículo o producto
    /*public void Modificar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Panceto", null, 1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String codigo = et_producto.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        if(!codigo.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()){

            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);

            int cantidad = BaseDatabase.update("articulos", registro, "codigo=" + codigo, null);
            BaseDatabase.close();

            if(cantidad == 1){
                Toast.makeText(this, "Artículo modificado correctamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "El artículo no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }*/

    public void showNotification(String title, String message) {
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
        Intent intent = new Intent(getApplicationContext(), CrudActivity.class);
        //intent.putExtra("nombre", "Nuevamente");

        PendingIntent p1 = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setContentIntent(p1);
        mNotificationManager.notify(0, mBuilder.build());
    }

    List<String> conectToSQL() {

        List<String> array = new ArrayList<>();

        AdminSQLiteOpenHelper dbHelper = new AdminSQLiteOpenHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String producto = et_producto.getText().toString();
        String descripcion = et_descripcion.getText().toString();
        String precio = et_precio.getText().toString();

        if (!producto.isEmpty() && !descripcion.isEmpty() && !precio.isEmpty()) {
            ContentValues registro = new ContentValues();

            registro.put("producto", producto);
            registro.put("descripcion", descripcion);
            registro.put("precio", precio);

            db.insert("productos", null, registro);
            db.close();

            et_producto.setText("");
            et_descripcion.setText("");
            et_precio.setText("");

            SQLiteDatabase dbRead = dbHelper.getReadableDatabase();
            Cursor c = dbRead.rawQuery("SELECT producto, descripcion, precio FROM productos", null);

            if (c.moveToFirst()) {
                do {
                    String column1 = c.getString(0);
                    String column2 = c.getString(1);
                    String column3 = c.getString(2);
                    array.add(column1);
                    array.add(column2);
                    array.add(column3);
                    System.out.println("paso producto: " + column1);
                } while (c.moveToNext());
            }
            c.close();
            dbRead.close();
        }
        return array;
    }

    private void setListData(List<String> your_array_List) {
        ListView lv = (ListView) findViewById(R.id.listViewData);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_List );

        lv.setAdapter(arrayAdapter);
    }

}