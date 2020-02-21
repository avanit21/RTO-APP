package agr.com.dvdas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Vehical_detail extends AppCompatActivity {
    TextView name,bdate,gender,address,email,mnumber,authority,vnumber,rdate,chassis_nu,eng,veh,fuel,maker,model,mvtext,puc_num,puc_expire,rc_expire,insurance,memo;
    Button generate;
    String v_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehical_detail);
        setTitle("Vehical Detail");

        Intent i=getIntent();
        generate=findViewById(R.id.generate);
        name=findViewById(R.id.name1);
        bdate=findViewById(R.id.bdate1);
        gender=findViewById(R.id.gender1);
        address=findViewById(R.id.address1);
        email=findViewById(R.id.email1);
        mnumber=findViewById(R.id.mnumber1);
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
        bdate.setText(i.getStringExtra("bdate"));
        gender.setText(i.getStringExtra("gender"));
        address.setText(i.getStringExtra("address"));
        email.setText(i.getStringExtra("email"));
        mnumber.setText(i.getStringExtra("mnumber"));
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

        v_number=i.getStringExtra("vnumber");




        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i1=new Intent(Vehical_detail.this,Memo_generate.class);
                i1.putExtra("v_number",v_number);
                startActivity(i1);
            }
        });

    }
}
