package bookstore.com.bookstore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import bookstore.com.bookstore.Repository.EmployeeRepoImpl;
import bookstore.com.bookstore.Repository.EmployeeRepository;
import bookstore.com.bookstore.domain.Employee;

public class update extends Activity {

    private EditText name;
    private EditText id;
    private  EditText surname;
    private  EditText username;
    private  EditText password;

    EmployeeRepository repo = null;

    private String key;

    Intent intent;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);






    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        return super.onOptionsItemSelected(item);
    }

    public void search(View view) {

        name=(EditText)findViewById(R.id.editText2);
        surname=(EditText)findViewById(R.id.editText3);
        username=(EditText)findViewById(R.id.editText4);
        password= (EditText)findViewById(R.id.editText5);
        repo = new EmployeeRepoImpl(this.getApplicationContext());
        Map<String,String> values = new HashMap<String,String>();
        id = (EditText) findViewById(R.id.editText);
        Employee employee = repo.findById(Long.parseLong(id.getText().toString()));

        if (employee!=null)
        {
            name.setText(employee.getName().toString());
            surname.setText(employee.getSurname().toString());
            username.setText(employee.getSystemName().toString());
            password.setText(employee.getPassword().toString());
        }
        else
            Toast.makeText(getBaseContext(),"RECORD NOT FOUND",Toast.LENGTH_LONG).show();



    }
    public void addPassenger(View view) {
        Employee employee = repo.findById(Long.parseLong(id.getText().toString()));

        if (employee!=null)
        {


            Employee updateEntity = new Employee.Builder()
                    .id(Long.parseLong(id.getText().toString()))
                    .copy(employee)
                    .name(name.getText().toString())
                    .surname(surname.getText().toString())
                    .systemName(username.getText().toString())
                    .password(password.getText().toString())
                    .build();
            repo.update(updateEntity);
            Toast.makeText(getBaseContext(),"UPDATED",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(getBaseContext(), "FAILED", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }

    }
}
