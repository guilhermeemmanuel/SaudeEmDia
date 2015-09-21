package com.northeast.saudeemdia;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.northeast.saudeemdia.adapters.PersonAdapter;
import com.northeast.saudeemdia.controller.PersonController;
import com.northeast.saudeemdia.model.Person;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private ListView personsLv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner dropdown = (Spinner)findViewById(R.id.category_sp);

        String[] items = new String[]{"Hipertensos", "Diabeticos", "Gestantes", "Criancas"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        dropdown.setAdapter(adapter);


        personsLv = (ListView) findViewById(R.id.persons_lv);
        final PersonAdapter personAdapter = new PersonAdapter(MainActivity.this, PersonController.getInstance().getPersonsByCategory("Hipertensos"));
        personsLv.setAdapter(personAdapter);


        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String category = adapter.getItem(position);
                personAdapter.updateItems(PersonController.getInstance().getPersonsByCategory(category));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add_person) {
            Intent i = new Intent(MainActivity.this, AddPersonCategoryActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
