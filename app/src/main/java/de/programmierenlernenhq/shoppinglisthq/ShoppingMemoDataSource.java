/*
    Arbeiterklasse, sie regelt die SQLite Datenbankzugriffe
    Sie ist für alle Datenbankzugriffe verantwortlich. Mit ihrer Hilfe schreiben wir Datensätze in die Tabelle unserer SQLite Datenbank und lesen diese auch wieder aus.

    Die ShoppingMemoDataSource-Klasse besitzt eine Membervariable vom Datentyp SQLiteDatabase, in der wir unsere Datenbank-Objekte abspeichern werden.
    Dadurch hält die ShoppingMemoDataSource-Klasse die Verbindung zu unserer Datenbank aufrecht.

    Weiterhin besitzt sie eine Membervariable vom Typ ShoppingMemoDbHelper, mit deren Hilfe wir die SQLite Datenbank erstellen lassen bzw. die Verbindung zur Datenbank herstellen können,
    wenn bereits eine Datenbank angelegt wurde.

    Außerdem wird die Arbeiterklasse weitere Funktionen zur Verfügung stellen, die das Arbeiten mit den Datensätzen erleichtern.
 */
package de.programmierenlernenhq.shoppinglisthq;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ShoppingMemoDataSource {

    private static final String LOG_TAG = ShoppingMemoDataSource.class.getSimpleName();

    private SQLiteDatabase database;
    private ShoppingMemoDbHelper dbHelper;

    public ShoppingMemoDataSource(Context context) {
        Log.d(LOG_TAG, "Unsere DataSource erzeugt jetzt den dbHelper.");
        dbHelper = new ShoppingMemoDbHelper(context);
    }

    public void open() {
        Log.d(LOG_TAG, "Eine Referenz auf die Datenbank wird jetzt angefragt.");
        database = dbHelper.getWritableDatabase();
        Log.d(LOG_TAG, "Datenbank-Referenz erhalten. Pfad zur Datenbank: " + database.getPath());
    }

    public void close() {
        dbHelper.close();
        Log.d(LOG_TAG, "Datenbank mit Hilfe des DbHelpers geschlossen.");
    }
}