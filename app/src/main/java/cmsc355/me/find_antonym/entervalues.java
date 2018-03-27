package cmsc355.me.find_antonym;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by gelbe on 3/21/2018.
 */

public class entervalues extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entervalues);
    }

    public void onEnterVal(View v){
        if(v.getId()==R.id.Bsubmit){
            EditText word = (EditText)findViewById(R.id.TFword);
            EditText ant = (EditText)findViewById(R.id.TFant);

            String wordstr = word.getText().toString();
            String antstr = ant.getText().toString();

            findAntonym a = new findAntonym();
            a.setWord(wordstr);
            a.setAnt(antstr);

            helper.insertContact(a);

            Intent i = new Intent(entervalues.this, MainActivity.class);
            startActivity(i);
        }
    }

}
