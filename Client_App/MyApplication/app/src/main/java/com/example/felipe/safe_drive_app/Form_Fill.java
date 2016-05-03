package com.example.felipe.safe_drive_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Button;

import java.util.concurrent.ExecutionException;


public class Form_Fill extends AppCompatActivity {


    private EditText textField;
    private Connect_Thread ct;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form__fill);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ct = null;

        Connect_Thread.setConnected(false);

        Button fab = (Button) findViewById(R.id.button_serv);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText textField = (EditText) findViewById(R.id.textField);
                String message = textField.getText().toString(); //get the text message on the text field
                textField.setText("");

                ct  = new Connect_Thread();
                try {
                    ct.execute(message).get();
                }catch (InterruptedException e1)
                {
                    e1.printStackTrace();
                }catch (ExecutionException e2)
                {
                    e2.printStackTrace();
                }

                ct.startCommunication();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_form__fill, menu);
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

    @Override
    public void onBackPressed() {
        if(ct != null)
            ct.closeConnection();

        Connect_Thread.setConnected(false);
        super.onBackPressed();
    }


}
