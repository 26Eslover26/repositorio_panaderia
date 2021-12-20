package usa.proyecto.mipanaderia.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import usa.proyecto.mipanaderia.model.productos;

public class productsRepository extends SQLiteOpenHelper {

    SQLiteDatabase dbWrite = null;
    SQLiteDatabase dbRead = null;
    SQLiteDatabase dbHelper = null;

    static final String table = "productos";

    private static final String COMMENTS_TABLE_CREATE = "CREATE TABLE " +table+ " (_id INTEGER PRIMARY KEY AUTOINCREMENT, producto TEXT, descripcion TEXT, precio NUMBER)";
    private static final String DELETE_TABLE_COMMAND = "DELETE FROM ";

    public productsRepository(Context context) {
        super(context, SQLBase.DB_NAME, null, SQLBase.DB_VERSION);
        dbWrite = getWritableDatabase();
        dbRead = getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(COMMENTS_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(COMMENTS_TABLE_CREATE);
    }

    public static void deleteTable(SQLiteDatabase db, String table){
        db.execSQL(DELETE_TABLE_COMMAND + " "+table);
    }

    public int getFirstidTable(){

        int idRes=-1;
        if (dbRead != null) {
            Cursor c = dbRead.rawQuery("SELECT _id FROM "+table, null);
            if (c.moveToFirst()){
                do {
                    idRes = Integer.parseInt(c.getString(0));
                    break;
                } while(c.moveToNext());
            }
            c.close();
            //dbRead.close();
        }
        return idRes;
    }

    public boolean updateRecord(int id, String producto, String descripcion, int precio) {

        boolean res =false;

        String sentencia = "UPDATE "+table+
                " SET producto = '"+producto+ "' , "+
                "descripcion = '"+descripcion+"' , "+
                "precio = '"+precio+"' "+
                " WHERE " +
                " _id = "+id+";";

        System.out.println("sentencia: "+sentencia);

        if (dbWrite != null) {
            dbWrite.execSQL(sentencia);
            res =true;
        }
        return res;
    }

    public List<productos> getAll() {

        List<productos> array = null;

        if (dbRead != null) {
            try {
                Cursor c = dbRead.rawQuery("SELECT * FROM "+ table , null);
                if (c.moveToFirst()) {
                    array = new ArrayList<>();
                    do {
                        // Passing values
                        productos p = new productos();
                        String columnRes = c.getString(0) + " : " + c.getString(1) + " -> " + c.getString(2);
                        p.setIdProducto(Integer.parseInt(c.getString(0)));
                        p.setNombreProducto(c.getString(1));
                        p.setDescProducto(c.getString(2));
                        p.setPrecioProducto(Integer.parseInt(c.getString(3)));
                        array.add(p);
                        System.out.println("get data: " + p.toString());
                        // Do something Here with values
                    } while (c.moveToNext());
                }
                c.close();
            }
            catch(Exception ex){
                System.out.println(ex.getLocalizedMessage());
            }
            //dbRead.close();
        }
        return array;
    }

    public productos getByNombre(String nombre) {

        productos res = null;

        if (dbRead != null) {
            try {
                Cursor c = dbRead.rawQuery("SELECT * FROM "+table+" WHERE producto = '"+ nombre+"'" , null);
                if (c.moveToFirst()) {
                    do {
                        // Passing values
                        res = new productos();
                        String columnRes = c.getString(0) + " : " + c.getString(1) + " -> " + c.getString(2);
                        res.setIdProducto(Integer.parseInt(c.getString(0)));
                        res.setNombreProducto(c.getString(1));
                        res.setDescProducto(c.getString(2));
                        res.setPrecioProducto(Integer.parseInt(c.getString(3)));
                        System.out.println("get data: " + res.toString());
                        break;
                        // Do something Here with values
                    } while (c.moveToNext());
                }
                c.close();
            }
            catch(Exception ex){
                System.out.println(ex.getLocalizedMessage());

            }

        }
        return res;

    }


    public boolean add( productos p) {

        boolean res = false;


        if (dbWrite != null) {

            ContentValues cv = new ContentValues();
            cv.put("producto", p.getNombreProducto());
            cv.put("descripcion", p.getDescProducto());
            cv.put("precio", p.getPrecioProducto());

            dbWrite.insert(table, null, cv);
            //dbWrite.close();
            res = true;

            // Hacer las operaciones que queramos sobre la base de datos
        }
        return res;

    }

    public boolean clear() {

        boolean res = false;


        if (dbWrite != null) {

            dbWrite.execSQL(DELETE_TABLE_COMMAND + " "+table);
            //dbWrite.close();
        }
        return res;

    }

    public void terminate(){
        dbWrite.close();
        dbRead.close();
    }

    public static boolean write(SQLiteDatabase dbWrite, productos product) {

        boolean res = false;


        if (dbWrite != null) {

            ContentValues cv = new ContentValues();
            cv.put("producto", product.getNombreProducto());
            cv.put("descripcion", product.getDescProducto());
            cv.put("precio", product.getPrecioProducto());

            dbWrite.insert("productos", null, cv);
            dbWrite.close();
            res = true;
        }
        return res;
    }
}
