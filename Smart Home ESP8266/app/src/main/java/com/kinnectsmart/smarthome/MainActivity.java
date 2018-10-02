package kinnectsmart.com.smarthome;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    Switch appliance1Switch;
    Switch appliance2Switch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appliance1Switch = (Switch)findViewById(R.id.appliance1ToggleSwitch);
        appliance2Switch = (Switch)findViewById(R.id.appliance2ToggleSwitch);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void appliance1Switch(View view) {
        if(appliance1Switch.isChecked())
            new JSONTask().execute("http://192.168.4.1/?pin=OFF1");
        else
            new JSONTask().execute("http://192.168.4.1/?pin=ON1");
    }

    public void appliance2Switch(View view) {
        if(appliance2Switch.isChecked())
            new JSONTask().execute("http://192.168.4.1/?pin=OFF2");
        else
            new JSONTask().execute("http://192.168.4.1/?pin=ON2");
    }



    public class  JSONTask extends AsyncTask<String,String,String> {

        @Override
        protected String doInBackground(String... params) {

            BufferedReader reader = null;
            HttpURLConnection connection = null;

            try{
                URL url = new URL(params[0]);
                connection =  (HttpURLConnection)url.openConnection();
                connection.connect();

                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();

                String line = "";
                while ((line  = reader.readLine()) != null){
                    buffer.append(line);
                }

                return buffer.toString();

            }catch(MalformedURLException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }finally {
                if(connection != null)
                    connection.disconnect();
                try{
                    if(reader != null)
                        reader.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            //tvData.setText(result);
        }
    }

}

