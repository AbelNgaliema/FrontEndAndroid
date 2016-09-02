package bookstore.com.bookstore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Set;

import bookstore.com.bookstore.Repository.EmployeeRepoImpl;
import bookstore.com.bookstore.domain.Employee;

public class displayRecords extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_records);
        //DBAdapter dbAdapter= new DBAdapter(this);
        // adap
        EmployeeRepoImpl repo = new EmployeeRepoImpl(this.getApplicationContext());
        Set<Employee> employees;
        employees =   repo.findAll();
        ArrayList<String> names = new ArrayList<String>();

        for (Employee employee : employees)
        {
            names.add( employee.getId()+ " " + employee.getSystemName() + " "+ employee.getPassword());
        }

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, names);

        ListView listView = (ListView)findViewById(R.id.listView);

        listView.setAdapter(arrayAdapter);





    }


    public void goBackHome(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
