package agr.com.dvdas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

//import static com.sample.constant.constant.idofthestudent;


public class ShowUserDetail extends AppCompatActivity {
    TextView authority,vnumber,rdate,chassis_nu,eng,veh,fuel,maker,model,mvtext,puc_num,puc_expire,rc_expire,insurance,memo,name;
    String url = "http://192.168.137.1/API/myapi.php";
    public static int a=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user_detail);
        setTitle("Detail");
        Intent i=getIntent();

        name=findViewById(R.id.username);
        authority=findViewById(R.id.authority1);
        vnumber=findViewById(R.id.vnumber1);
        rdate=findViewById(R.id.rdate1);
        chassis_nu=findViewById(R.id.chassis_nu1);
        eng=findViewById(R.id.eng1);
        veh=findViewById(R.id.veh1);
        fuel=findViewById(R.id.fuel1);
        maker=findViewById(R.id.maker1);
        model=findViewById(R.id.model1);
        mvtext=findViewById(R.id.mvtext1);
        puc_num=findViewById(R.id.puc_num1);
        puc_expire=findViewById(R.id.puc_expire1);
        rc_expire=findViewById(R.id.rc_expire1);
        insurance=findViewById(R.id.insurance1);
        memo=findViewById(R.id.memo1);

        name.setText(i.getStringExtra("name"));
        authority.setText(i.getStringExtra("authority"));
        vnumber.setText(i.getStringExtra("vnumber"));
        rdate.setText(i.getStringExtra("rdate"));
        chassis_nu.setText(i.getStringExtra("chassis_number"));
        eng.setText(i.getStringExtra("engine_number"));
        veh.setText(i.getStringExtra("veh"));
        fuel.setText(i.getStringExtra("fuel"));
        maker.setText(i.getStringExtra("maker"));
        model.setText(i.getStringExtra("model"));
        mvtext.setText(i.getStringExtra("mv_tax"));
        puc_num.setText(i.getStringExtra("insurance_detail"));
        puc_expire.setText(i.getStringExtra("puc"));
        rc_expire.setText(i.getStringExtra("puc_upto_date"));
        insurance.setText(i.getStringExtra("rc_book_expire"));
        memo.setText(i.getStringExtra("memo"));


    }
}