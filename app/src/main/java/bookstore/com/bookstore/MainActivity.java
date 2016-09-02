package bookstore.com.bookstore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import bookstore.com.bookstore.Repository.EmployeeRepoImpl;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void addRecord(View view){
        try {

            Intent intent = new Intent(getApplicationContext(), registercustomeractivity.class);

            startActivity(intent);
        }
        catch(Exception nfe)
        {
        }
    }
    public void  displayAll(View view){
        try{
            Intent intent = new Intent(getApplicationContext(), displayRecords.class);
            startActivity(intent);
        }
        catch(Exception e) {

        }
    }
    public void updateRecord(View view){
        try{

            //  key ="UPDATE";
            Intent intent = new Intent(getApplicationContext(), update.class);
            //   intent.putExtra("key",key);
            startActivity(intent);
        }
        catch ( Exception e) {
        }
    }

    public void deleteAll(View view){
        EmployeeRepoImpl repo = new EmployeeRepoImpl(this.getApplicationContext());
        repo.removeAll();
        Toast.makeText(getBaseContext(), "ALL USERS DELETED", Toast.LENGTH_LONG).show();
    }
}
