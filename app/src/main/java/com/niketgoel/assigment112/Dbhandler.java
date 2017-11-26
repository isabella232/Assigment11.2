package com.niketgoel.assigment112;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

/**
 * Created by niketgoel on 26/11/17.
 */


public class Dbhandler extends SQLiteOpenHelper {
    public Dbhandler(Context context) {
        super(context, "products.db", null, 1);
    }

    /**
     * onCreate method to create the SQLite database table
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE TABLE_PRODUCTS (COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,COLUMN_PRODUCTNAME TEXT)");


    }

    /**
     * onUpgrade method for upgradation of version and database table
     * @param db
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS TABLE_PRODUCTS");
        onCreate(db);

    }

    /**
     * method to add the list of products in table
     * @param productname
     */
    public void Addproducts(String productname){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values  = new ContentValues();

        values.put("COLUMN_PRODUCTNAME",productname);
        db.insert("TABLE_PRODUCTS",null,values);
    }

    /**
     * to read the list item using rawQuery
     * @return
     */
    public ArrayList Databasetoarray(){
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db =getReadableDatabase();


        String query = "SELECT * FROM TABLE_PRODUCTS WHERE 1";
        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            if (c.getString(c.getColumnIndex("COLUMN_PRODUCTNAME"))!=null){
                arrayList.add(c.getString(c.getColumnIndex("COLUMN_PRODUCTNAME")));
                c.moveToNext();

            }

        }
        db.close();
        return arrayList;
    }

}
