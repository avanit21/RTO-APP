package agr.com.dvdas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Police_detail extends AppCompatActivity {
    TextView t,t1;
    EditText veh;
    Button find;
    Context nContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_detail);
        setTitle("Search Vehicle");

        Intent i=getIntent();
        final String us=i.getStringExtra("user");

        nContext=getApplicationContext();
        t=findViewById(R.id.textView5);
        t1=findViewById(R.id.text6);
        veh=findViewById(R.id.veh);
        find=findViewById(R.id.f1);
        t.setText(us);


        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nu=veh.getText().toString().trim();


                StringRequest stringRequest = new StringRequest(Request.Method.POST,
                        "http://192.168.43.224/API/user.php?v_number="+nu,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.d("Check :", response );

                                try {

                                    int i;
                                    JSONArray jsonArray=new JSONArray(response);
                                    JSONObject jsonObject=jsonArray.getJSONObject(0);
                                    JSONObject jsonObject1=jsonArray.getJSONObject(1);
                                    Intent i1=new Intent(Police_detail.this,Vehical_detail.class);
                                    i1.putExtra("name",jsonObject1.getString("fname")+" "+jsonObject1.getString("mname")+" "+jsonObject1.getString("lname"));
                                    i1.putExtra("bdate",jsonObject1.getString("dob"));
                                    i1.putExtra("gender",jsonObject1.getString("gender"));
                                    i1.putExtra("address",jsonObject1.getString("address"));
                                    i1.putExtra("email",jsonObject1.getString("email"));
                                    i1.putExtra("mnumber",jsonObject1.getString("mnumber"));

                                    i1.putExtra("authority",jsonObject.getString("authority"));
                                    i1.putExtra("vnumber",jsonObject.getString("vehicle_number"));
                                    i1.putExtra("rdate",jsonObject.getString("registration_date"));
                                    i1.putExtra("chassis_number",jsonObject.getString("chassis_number"));
                                    i1.putExtra("engine_number",jsonObject.getString("engine_number"));
                                    i1.putExtra("veh",jsonObject.getString("vehicle_class"));
                                    i1.putExtra("fuel",jsonObject.getString("fuel"));
                                    i1.putExtra("maker",jsonObject.getString("maker"));
                                    i1.putExtra("model",jsonObject.getString("model"));
                                    i1.putExtra("mv_tax",jsonObject.getString("mv_tax"));
                                    i1.putExtra("insurance_detail",jsonObject.getString("insurance_details"));
                                    i1.putExtra("puc",jsonObject.getString("puc_number"));
                                    i1.putExtra("puc_upto_date",jsonObject.getString("puc_upto_date"));
                                    i1.putExtra("rc_book_expire",jsonObject.getString("rc_book_expire"));
                                    i1.putExtra("memo",jsonObject.getString("memo"));


                                    //1.putExtra("address",jsonObject.getString("fuel"));
                                    //i1.putExtra("vehical",jsonObject.getString("vehicle_number"));
                                   // i1.putExtra("memo",jsonObject.getString("memo"));

                                    startActivity(i1);


                                    if(jsonArray.length()==0)
                                    {
                                        Toast.makeText(getApplicationContext(),"Vehical not exixst",Toast.LENGTH_LONG).show();
                                    }
                                }catch (JSONException e)
                                {
                                    e.printStackTrace();

                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();

                    }
                });
                final RequestQueue requestQueue = Volley.newRequestQueue(nContext);
                requestQueue.add(stringRequest);
            }
        });


    }
}
