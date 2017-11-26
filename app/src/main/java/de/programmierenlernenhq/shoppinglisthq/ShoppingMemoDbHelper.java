/*
    Diese Klasse hilft beim Erstellen und Aktualisieren der Datenbank.

    Die Hilfsklasse leiten wir von der Klasse SQLiteOpenHelper aus dem Package android.database.sqlite ab.
    Diese Elternklasse wird das eigentliche Erzeugen der SQLite Datenbank für uns übernehmen.
    Wir delegieren dies nur mit unserer Hilfsklasse ShoppingMemoDbHelper an sie weiter.
*/

package de.programmierenlernenhq.shoppinglisthq;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ShoppingMemoDbHelper extends SQLiteOpenHelper{

    private static final String LOG_TAG = ShoppingMemoDbHelper.class.getSimpleName();

    public static final String DB_NAME = "shopping_list.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_SHOPPING_LIST = "shopping_list";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCT = "product";
    public static final String COLUMN_QUANTITY = "quantity";

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_SHOPPING_LIST +
                    "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_PRODUCT + " TEXT NOT NULL, " +
                    COLUMN_QUANTITY + " INTEGER NOT NULL);";


    // Die onCreate-Methode wird nur aufgerufen, falls die Datenbank noch nicht existiert
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Log.d(LOG_TAG, "Die Tabelle wird mit SQL-Befehl: " + SQL_CREATE + " angelegt.");
            db.execSQL(SQL_CREATE);
        } // try
        catch (Exception ex) {
            Log.e(LOG_TAG, "Fehler beim Anlegen der Tabelle: " + ex.getMessage());
        } // catch
    } // onCreate

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    } // onUpgrade

    public ShoppingMemoDbHelper(Context context) {
        //super(context, "PLATZHALTER_DATENBANKNAME", null, 1);
        super(context, DB_NAME, null, DB_VERSION);
        Log.d(LOG_TAG, "DbHelper hat die Datenbank: " + getDatabaseName() + " erzeugt.");
    } // ShoppingMemoDbHelper

} // ShoppingMemoDbHelper