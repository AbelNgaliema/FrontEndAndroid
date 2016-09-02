package bookstore.com.bookstore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import bookstore.com.bookstore.Repository.EmployeeRepoImpl;
import bookstore.com.bookstore.Repository.EmployeeRepository;
import bookstore.com.bookstore.domain.Employee;
import bookstore.com.bookstore.factory.EmployeeFactory;

public class registercustomeractivity extends Activity {

    private EditText name;
    private EditText surname;
    private EditText password;
    private EditText username;
    private EditText city;
    private EditText code;
    private EditText searchId;
    private Button button;

    private String key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registercustomeractivity);

        name = (EditText) findViewById(R.id.txtID);
        //    button= (Button)findViewById(R.id.btnPreview);
        surname = (EditText) findViewById(R.id.txtName);
        username = (EditText) findViewById(R.id.txtSurname);
        password = (EditText) findViewById(R.id.txtStreetName);
        // city = (EditText) findViewById(R.id.txtCity);
        // code = (EditText) findViewById(R.id.txtCode);
    }






    public void addRecord(View view){

        EmployeeRepository repo = new EmployeeRepoImpl(this.getApplicationContext());
        Map<String,String> values = new HashMap<String,String>();




        values.put("name",name.getText().toString());
        values.put("surname", surname.getText().toString());
        values.put("position", "Developer");
        values.put("password", password.getText().toString());
        values.put("systemName", username.getText().toString());

    //    if (name.getText().toString().eq)


        //Object

        Employee employee = EmployeeFactory.createEmployee(values,12000);

        if (employee!= null){
            repo.add(employee);
            // clear();
            Toast.makeText(getBaseContext(), "SUCCESSFULLY ADDED", Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(getBaseContext(), "FAILED, TRY AGAIN", Toast.LENGTH_LONG).show();
        }
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void home(View view){


        // clear();
        // Toast.makeText(getBaseContext(), "SUCCESSFULLY ADDED", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
