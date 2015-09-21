package com.northeast.saudeemdia;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.northeast.saudeemdia.controller.PersonController;
import com.northeast.saudeemdia.model.ChildPerson;
import com.northeast.saudeemdia.model.HypertensionPerson;
import com.northeast.saudeemdia.model.Person;


public class ChildPersonActivity extends ActionBarActivity {

    private EditText nameEt, addressEt, birthdayEt, susEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_person);

        nameEt = (EditText) findViewById(R.id.person_name_et);
        addressEt = (EditText) findViewById(R.id.person_address_et);
        birthdayEt = (EditText) findViewById(R.id.person_birthday_et);
        susEt = (EditText) findViewById(R.id.person_sus_et);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_child_person, menu);
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

    public void addPerson(View view) {

        String name = nameEt.getText().toString();
        String address = addressEt.getText().toString();
        String birthday = birthdayEt.getText().toString();
        String sus = susEt.getText().toString();

        Person person = new ChildPerson(name, address, birthday, sus);
        PersonController.getInstance().addPerson(person);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


}
