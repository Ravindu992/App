package com.example.multilayoutuiandroidapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "StudentDB";
    private static final int DATABASE_VERSION = 1;
    
    // Table name and columns
    public static final String TABLE_STUDENTS = "students";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONE = "phone";

    // Create table SQL query
    private static final String CREATE_TABLE_STUDENTS = "CREATE TABLE " + TABLE_STUDENTS + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_NAME + " TEXT,"
            + COLUMN_EMAIL + " TEXT,"
            + COLUMN_PHONE + " TEXT"
            + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        onCreate(db);
    }

    // Insert new student
    public long insertStudent(String name, String email, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PHONE, phone);
        return db.insert(TABLE_STUDENTS, null, values);
    }

    // Get all students
    public Cursor getAllStudents() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_STUDENTS, null, null, null, null, null, null);
    }

    // Update student
    public int updateStudent(long id, String name, String email, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PHONE, phone);
        return db.update(TABLE_STUDENTS, values, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
    }

    // Delete student
    public void deleteStudent(long id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_STUDENTS, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
    }
}
