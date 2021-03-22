package com.example.chcapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private FusedLocationProviderClient fusedLocationClient;
    public static int REQUEST_CODE_LOCATION_PERMISSION = 1;
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String url = "https://run.mocky.io/v3/ee23ee18-2ac4-40d6-b1b3-20678d376f39";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        volleyPost();
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                  if (ContextCompat.checkSelfPermission(
                                     getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(
                            MainActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            REQUEST_CODE_LOCATION_PERMISSION
                    );

                } else {
                   // getCurrentLocation();
                }

            }
        });

        fusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                   double lati =  location.getLatitude();
                    double lang =  location.getLongitude();

//
//
//                    Log.i("JSON", jsonParam.toString());

                    System.out.println(lati);
                    System.out.println(lang);


                }
            }
        });

    }
//    public void volleyPost(){
//        String postUrl = "https://reqres.in/api/users";
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//
//        JSONObject postData = new JSONObject();
//        try {
//            postData.put("name", "bandfaialllll");
//            postData.put("job", "Software Engineer");
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, postUrl, postData, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                System.out.println(response);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        });
//
//
//        requestQueue.add(jsonObjectRequest);
//
//    }
//
//


    public void onBtnClick (View view){
        TextView txtg = findViewById(R.id.textView);
        TextView txt1 = findViewById(R.id.textView2);
        TextView txt2 = findViewById((R.id.textView3));
        TextView txt3 = findViewById(R.id.textView4);

        EditText edtTextName = findViewById(R.id.edtTextFName);
        TextView EdtTxtFname = findViewById(R.id.edtTextFName);
        TextView EdtTxtLname = findViewById(R.id.edtTextLName);
        TextView EdtTxtEmail = findViewById((R.id.edtTextEmail));


    }

}