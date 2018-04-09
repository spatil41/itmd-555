package com.example.suneh.sqlitelab7;
import android.provider.BaseColumns;


/**
 * Created by suneh on 4/8/2018.
 */

public class BookContract {



    private BookContract() {
    }

    // Inner class that defines the table contents
    public static class BookEntry implements BaseColumns {
        public static final String ID = "id";
        public static final String TABLE_NAME = "BooksDatabase";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_AUTHOR = "author";
        public static final String COLUMN_NAME_RATING= "rating";
    }
    // some common queries
    public static final String SQL_CREATE_TABLE = "CREATE TABLE " + BookEntry.TABLE_NAME +
            "(" + BookEntry.ID + " INTEGER PRIMARY KEY,"+ BookEntry.COLUMN_NAME_RATING + " INTEGER," + BookEntry.COLUMN_NAME_TITLE + " TEXT,"
            + BookEntry.COLUMN_NAME_AUTHOR + " TEXT)";

    public static final String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + BookEntry.TABLE_NAME;
    public static final String SQL_DELETE_ALLENTERIES = "DELETE FROM " + BookEntry.TABLE_NAME;
}

