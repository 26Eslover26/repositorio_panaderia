package usa.proyecto.mipanaderia;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
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

import java.util.ArrayList;
import java.util.List;

import usa.proyecto.mipanaderia.dbHelper.AdminSQLiteOpenHelper;

public class ListarActivity extends AppCompatActivity {

    private EditText et_producto, et_descripcion, et_precio;
    private Button btn;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        btn = findViewById(R.id.btnSQL);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //List<String> your_array_list = conectToSQL();
                //setListData(your_array_list);
                refreshList();
            }
        });

        et_producto = (EditText) findViewById(R.id.txt_producto);
        et_descripcion = (EditText) findViewById(R.id.txt_descripcion);
        et_precio = (EditText) findViewById(R.id.txt_precio);

        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_gingerbread);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 8);
        }
        return super.dispatchTouchEvent(ev);
    }

    /*public List<String> conectToSQL() {

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
                } while (c.moveToNext());
            }
            c.close();
            dbRead.close();
        }
        return array;
    }*/

    private void setListData(List<String> your_array_List) {
        ListView lv = (ListView) findViewById(R.id.listViewData);

        if (your_array_List == null) {
            your_array_List = new ArrayList<>();
            lv.setEmptyView(findViewById(android.R.id.empty));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_List );

        lv.setAdapter(arrayAdapter);
    }

    void refreshList() {
        List<String> your_array_list = getDataUsersSQL();
        setListData(your_array_list);
    }

    List<String> getDataUsersSQL() {

        List<String> array = null;
        AdminSQLiteOpenHelper dbHelper = new AdminSQLiteOpenHelper(this);

        SQLiteDatabase dbRead = dbHelper.getReadableDatabase();
        if (dbRead != null) {
            Cursor c = dbRead.rawQuery("SELECT _id,producto,descripcion,precio FROM productos ", null);
            if (c.moveToFirst()) {
                array = new ArrayList<>();
                do {
                    // Passing values
                    String columnRes = c.getString(0) + " : " + c.getString(1) + " : " + c.getString(2) + " -> " + c.getString(3);

                    array.add(columnRes);
                    System.out.println("get data usuario: " + columnRes);
                    // Do something Here with values
                } while (c.moveToNext());
            }
            c.close();
            dbRead.close();
        }
        return array;

    }
}