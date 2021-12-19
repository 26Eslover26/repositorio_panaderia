package usa.proyecto.mipanaderia.dbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String COMMENTS_TABLE_CREATE = "CREATE TABLE productos(_id INTEGER PRIMARY KEY AUTOINCREMENT, producto TEXT, descripcion TEXT, precio INTEGER)";
    private static final String DB_NAME = "panceto";
    private static final int DB_VERSION = 1;
    public AdminSQLiteOpenHelper(Context context) {super(context, DB_NAME, null, DB_VERSION);}

    /*public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }*/

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(COMMENTS_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
