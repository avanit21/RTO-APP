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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Memo_generate extends AppCompatActivity {
    EditText amo;
    TextView t1;
    Button gen;
    String amount;
    Context nContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_generate);
        setTitle("Memo Generate");

        Intent i=getIntent();
       final String vnumber=i.getStringExtra("v_number");
        nContext=getApplicationContext();
        amo=findViewById(R.id.amount);
        t1=findViewById(R.id.text1);
        gen=findViewById(R.id.generate);
        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 amount=amo.getText().toString().trim();

              //  String x=";

                ///Log.d("Check :", x );

                StringRequest stringRequest = new StringRequest(Request.Method.POST,
                        "http://192.168.43.224/API/update.php?vehicle_number="+vnumber+"&memo="+amount,
                        new Response.Listener<String>() {


                            @Override
                            public void onResponse(String response) {

                                Toast.makeText(getApplicationContext(),"Memo successfuly generated",Toast.LENGTH_LONG).show();

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();

                    }
                });
                RequestQueue requestQueue = Volley.newRequestQueue(nContext);
                requestQueue.add(stringRequest);
            }
        });




    }
}
