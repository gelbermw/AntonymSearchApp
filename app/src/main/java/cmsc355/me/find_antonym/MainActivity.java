package cmsc355.me.find_antonym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v){
        if(v.getId()==R.id.Bant){
            EditText a = (EditText) findViewById(R.id.TFenterword);
            String str = a.getText().toString();

            String antonym = helper.searchAnt(str);
            if(antonym != null){
                Intent i = new Intent(MainActivity.this, results.class);
                i.putExtra("word",str);
                startActivity(i);
            }
            else{
                Toast temp = Toast.makeText(MainActivity.this, "Word not found", Toast.LENGTH_SHORT);
                temp.show();
            }

        }
        if(v.getId()==R.id.Bentervalue){
            Intent i = new Intent(MainActivity.this, entervalues.class);
            startActivity(i);
        }
    }

}
