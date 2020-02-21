package agr.com.dvdas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class USER_login extends AppCompatActivity {
    Button b1;
    EditText user,pass;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        setTitle("User Login");
        Intent i=getIntent();
        mContext=getApplicationContext();
        b1=findViewById(R.id.login);
        user=findViewById(R.id.userid);
        pass=findViewById(R.id.password);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String us=user.getText().toString().trim();
                String pa=pass.getText().toString().trim();
                /*Intent i1=new Intent(USER_login.this, ShowUserDetail.class);
                i1.putExtra("user",us);
                i1.putExtra("pass",pa);
                startActivity(i1);*/

                StringRequest stringRequest = new StringRequest(Request.Method.POST,
                        "http://192.168.43.224/API/myapi.php?password="+pa+"&user_id="+us,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.d("Check :", response );

                                try {

                                    int i;
                                    JSONArray jsonArray=new JSONArray(response);
                                    JSONObject jsonObject=jsonArray.getJSONObject(0);
                                    Intent i1=new Intent(USER_login.this,ShowUserDetail.class);
                                    i1.putExtra("name",jsonObject.getString("name"));
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

                                    startActivity(i1);


                                    if(jsonArray.length()==0)
                                    {
                                        Toast.makeText(getApplicationContext(),"user not exixst",Toast.LENGTH_LONG).show();
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
                final RequestQueue requestQueue = Volley.newRequestQueue(mContext);
                requestQueue.add(stringRequest);

                finish();
            }
        });
    }
}
