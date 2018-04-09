package com.example.suneh.sqlitelab7;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
/**
 * Created by suneh on 4/8/2018.
 */

public class SQLHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DB_NAME = "BooksDb";
    public static final String DB_LOCATION = "/data/data/com.example.suneh.dbanalyticsproject/databases/";
    public static Context context;
    public static SQLiteDatabase database;
    public static SQLiteOpenHelper databaseHandler;

    public SQLHelper(Context context) {


        super(context, DB_NAME, null, DATABASE_VERSION);
        this.context = context;
        database = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(BookContract.SQL_CREATE_TABLE);
        Log.i("Table", "Created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.i("Table", "Upgraded");
        sqLiteDatabase.execSQL(BookContract.SQL_DELETE_TABLE);
        onCreate(sqLiteDatabase);
    }

    /**
     * close the database
     */
    public void closeDatabase() {
        if (database != null) {
            database.close();
            Log.i("Database", "Close");
        }
    }


    /**
     * add a book to Book table in BookDB
     */

    public void addBook(Book book) {

        //SQLiteDatabase db = (new SqlHelper(context)).getWritableDatabase();
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BookContract.BookEntry.COLUMN_NAME_TITLE, book.getTitle());
        values.put(BookContract.BookEntry.COLUMN_NAME_AUTHOR, book.getAuthor());
        values.put(BookContract.BookEntry.COLUMN_NAME_RATING, book.getRating() );
        database.insert(BookContract.BookEntry.TABLE_NAME, null, values);
        Log.i("AddBook()", "\t" + book.toString());


        //List<Book> books = getAllBooks();
    }

    public Cursor getInformation(SQLiteDatabase sqLiteDatabase)
    {
        String[] projections = {BookContract.BookEntry.COLUMN_NAME_TITLE, BookContract.BookEntry.COLUMN_NAME_AUTHOR, BookContract.BookEntry.COLUMN_NAME_RATING};
        Cursor cursor = sqLiteDatabase.query(BookContract.BookEntry.TABLE_NAME, projections, null,null,null,null,null);
        return  cursor;
    }
    /**
     * get all the books from the table
     *
     * @return list of books in the table
     */
    public List<Book> getAllBooks() {
        Log.d( "getAllBooks","================");
        // SQLiteDatabase db = (new SqlHelper(context)).getReadableDatabase();
        List<Book> books = new ArrayList<>();
        Book book;
        Cursor cursor = database.query(BookContract.BookEntry.TABLE_NAME, null, null, null, null, null, null);
        String booksString = "\t\t\t[";
        while (cursor.moveToNext()) {
            // add books to the list
            book= new Book();
            book.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(BookContract.BookEntry.ID))));
            book.setRating(Integer.parseInt(cursor.getString(cursor.getColumnIndex(BookContract.BookEntry.COLUMN_NAME_RATING))));
            book.setTitle(cursor.getString(cursor.getColumnIndex(BookContract.BookEntry.COLUMN_NAME_TITLE)));
            book.setAuthor(cursor.getString(cursor.getColumnIndex(BookContract.BookEntry.COLUMN_NAME_AUTHOR)));
            books.add(book);

            // books string to display in log
            booksString += "Book [ ";
            for (String col : cursor.getColumnNames()) {

                booksString += col + "=" + cursor.getString(cursor.getColumnIndex(col)) + " ";
            }
            booksString += "]\n\t\t\t\t\t\t ";
        }
        Log.i("GetAllBooks()", booksString + " ]");

        return books;
    }

    /**
     * update book in the database
     *
     * @param book book details to be updated
     * @return number of rows changed
     */
    public int updateBook(Book book) {

        ContentValues values = new ContentValues();
        values.put(BookContract.BookEntry.COLUMN_NAME_TITLE, book.getTitle());
        values.put(BookContract.BookEntry.COLUMN_NAME_AUTHOR, book.getAuthor());

        int rowsAffected = database.update(BookContract.BookEntry.TABLE_NAME, values,
                BookContract.BookEntry.ID.toString() + "=?", new String[]{String.valueOf(book.getId())});
        Log.i("UpdateBook()", book.toString());
        return rowsAffected;

    }

    /**
     * delete book from the database
     *
     * @param book book to be deleted
     */
    public void deleteBook(Book book) {
        database.delete(BookContract.BookEntry.TABLE_NAME,
                BookContract.BookEntry.ID + "=?", new String[]{String.valueOf(book.getId())});
        Log.i("DeleteBook()", book.toString());
    }

    /**
     * delete all the enteries from the table
     */
    public void deleteAllEnteries() {
        database.execSQL(BookContract.SQL_DELETE_ALLENTERIES);

    }

}

