package com.example.abc.jason;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView l1;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (TextView)findViewById(R.id.t1);
        l1 = (ListView)findViewById(R.id.listView1);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2/json.php" ;
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try
                        {
                            JSONArray ar=new JSONArray(response);
                            String name[]=new String[ar.length()];
                            String roll[]=new String[ar.length()];
                            for(int i=0;i<ar.length();i++) {
                                JSONObject out = ar.getJSONObject(i);
                                name[i]=out.getString("name");
                                roll[i]=out.getString("rollno");
                                Log.e("resultincisive", out.getString("name") + "");
                                customelist customelist = new customelist(MainActivity.this , name , roll );
                                l1 = (ListView)findViewById(R.id.listView1);
                                l1.setAdapter(customelist);
                            }

                        }
                        catch(JSONException ex){
                            Log.e("result","Error:="+ex.getMessage());
                        }


                    }
                    }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                t1.setText("That didn't work");
            }


        });
        queue.add(stringRequest);

    }


}
