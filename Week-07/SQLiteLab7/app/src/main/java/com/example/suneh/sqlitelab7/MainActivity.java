package com.example.suneh.sqlitelab7;


        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.widget.ListAdapter;
        import android.widget.ArrayAdapter;
        import android.widget.Spinner;
        import android.widget.ListView;
        import android.widget.SimpleCursorAdapter;
        import android.widget.Toast;
        import android.widget.AdapterView;
        import android.widget.AdapterView.OnItemSelectedListener;
        import android.view.View;

        import java.util.*;
        import java.util.SimpleTimeZone;


public class MainActivity extends AppCompatActivity implements OnItemSelectedListener{
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    SQLHelper sqlHelper;
    Cursor cursor;
    Spinner spinner;
    ArrayAdapter<String> adapter;
    ArrayList<String> title;

    List<Book> BookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        RateFunction();
        //spinnerFunction();

    }



    /*public void spinnerFunction(){

        spinner = (Spinner)findViewById(R.id.spinner);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,title);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
/*
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){


            @Override
                public void OnItemSelected(AdapterView<?> adapterView, View view, int i, long l){

                Toast.makeText(MainActivity.this,BookList.get( i ).author,Toast.LENGHT_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView){


            }

        });
*/
        //adapter = ArrayAdapter.createFromResource(this,title,android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner.setAdapter(adapter);
    //}

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        //String item = parent.getItemAtPosition(position).toString();
        //  Log.d( "00000000000000000","");
        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Author's Name: "+BookList.get( position ).author+"\nRating: "+BookList.get( position ).rating, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void RateFunction(){
        SQLHelper db = null;

        try {
            db = new SQLHelper( this );

            // remove enteries if exist in the table
            db.deleteAllEnteries();
            // add books
            db.addBook( new Book( "Professional Android 4 Application", "Reto Meier",3 ) );
            db.addBook( new Book( "Beginning Android 4 Application  Development", "WeiMeng Lee",4) );
            db.addBook( new Book( "Programming Android", "Wallace Jackson",2) );
            db.addBook( new Book( "Hello, Android", "Wallace Jackson",5 ) );


            BookList = db.getAllBooks();

            title = new ArrayList<String>();


            for(int i=0;i<BookList.size();i++){

                title.add(String.valueOf(BookList.get( i ).title));
//                Log.d( "----LIST------"
            }

            Log.d( "jjjjjjjj",String.valueOf(BookList.get( 0 ).title));
            ListGeneration();
            
        } catch (Exception e) {
            Toast.makeText( this, "Something went wrong!", Toast.LENGTH_LONG ).show();
        }
    }



    ListView ViewBooklist;
    ListAdapter listAdapter;
    private void ListGeneration(){

        ViewBooklist = (ListView) findViewById(R.id.booklist);
        listAdapter = new com.example.suneh.sqlitelab7.ListAdapter(MainActivity.this, BookList);
        ViewBooklist.setAdapter(listAdapter);


    }



}

