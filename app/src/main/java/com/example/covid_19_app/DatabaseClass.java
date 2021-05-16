package com.example.covid_19_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseClass extends SQLiteOpenHelper {

    Context context;
    private static final String DatabaseName = "Dates";
    private static final int DatabaseVersion = 1;

    private static final String TableName = "mynotes";
    private static final String ColumnId = "id";
    private static final String ColumnTitle = "title";
    private static final String ColumnDescription = "description";
    private static final String ColumnDate1 = "date1";


    public DatabaseClass(@Nullable Context context) {
        super(context, DatabaseName, null, DatabaseVersion);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TableName +
                " (" + ColumnId + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ColumnTitle + " TEXT, " +
                ColumnDescription + " TEXT, " +
                ColumnDate1 + " TEXT);";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TableName);
        onCreate(db);
    }

    void addNotes(String title, String description, String date1) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(ColumnTitle, title);
        cv.put(ColumnDescription, description);
        cv.put(ColumnDate1, date1);

        long resultValue = db.insert(TableName, null, cv);

        if (resultValue == -1) {
            Toast.makeText(context, "Data nu a fost adaugata", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Data adaugata cu succes", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData() {
        String query = "SELECT * FROM " + TableName;
        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = null;
        if (database != null) {
            cursor = database.rawQuery(query, null);
        }
        return cursor;
    }

    void deleteAllNotes() {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "DELETE FROM " + TableName;
        database.execSQL(query);
    }

    void updateNotes(String id, String title, String description, String date1) {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(ColumnTitle, title);
        cv.put(ColumnDescription, description);
        cv.put(ColumnDate1, date1);

        long result = database.update(TableName, cv, "id=?", new String[]{id});
        if (result == -1) {
            Toast.makeText(context, "Gresit", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Bine", Toast.LENGTH_SHORT).show();
        }

    }

    public void deleteSingleItem(String id) {
        SQLiteDatabase database = this.getWritableDatabase();

        long result = database.delete(TableName, "id=?", new String[]{id});
        if (result == -1) {
            Toast.makeText(context, "Data nu a fost stearsa", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Data stearsa cu succes", Toast.LENGTH_SHORT).show();
        }
    }


}
