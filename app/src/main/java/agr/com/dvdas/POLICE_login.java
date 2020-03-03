package agr.com.dvdas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class POLICE_login extends AppCompatActivity {
    EditText user,pass;
    Button login;
     Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_login);
        setTitle("Police Login");
        Intent i=getIntent();
        mContext=getApplicationContext();
        user=findViewById(R.id.user);
        pass=findViewById(R.id.pass);
        login=findViewById(R.id.login);





        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String us=user.getText().toString().trim();
                final String pa=pass.getText().toString().trim();
                StringRequest stringRequest = new StringRequest(Request.Method.POST,
                        "http://192.168.56.1/API/police.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.d("Check :", response );

                                try {

                                    int i;
                                    JSONArray jsonArray=new JSONArray(response);
                                    for( i=0;i<jsonArray.length();i++)
                                    {
                                        JSONObject jsonObject=jsonArray.getJSONObject(i);

                                        if(us.equalsIgnoreCase(jsonObject.getString("user")) && pa.equalsIgnoreCase(jsonObject.getString("password")))
                                        {

                                            Intent i1=new Intent(POLICE_login.this,Police_detail.class);
                                            i1.putExtra("user",jsonObject.getString("name"));

                                            startActivity(i1);
                                            break;
                                        }


                                    }
                                    if(i>=jsonArray.length())
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


            }

        });
    }
}
