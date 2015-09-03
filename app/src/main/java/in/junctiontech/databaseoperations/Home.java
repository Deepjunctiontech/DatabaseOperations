package in.junctiontech.databaseoperations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Home extends AppCompatActivity {

    private DBHandler db;
    private EditText homeName,homeEmail,homeMobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        db=new DBHandler(this,"abc",null,1);


        homeName = (EditText) findViewById(R.id.homeName);
        homeEmail = (EditText) findViewById(R.id.homeEmail);
        homeMobile = (EditText) findViewById(R.id.homeMobile);
        String str[] = db.getEmployee();
        if(str.length >0) {
            homeName.setText(str[0]);
            homeEmail.setText(str[1]);
            homeMobile.setText(str[2]);
            }
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void onClickSave(View view){
        String  str[] = new String[3];

        str[0] = homeName.getText().toString();
        str[1] = homeEmail.getText().toString();
        str[2] = homeMobile.getText().toString();

        db.setEmployee(str);
    }
}
