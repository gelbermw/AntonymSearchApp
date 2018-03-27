package cmsc355.me.find_antonym;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by gelbe on 3/21/2018.
 */

public class results extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
        String wordEnter = getIntent().getStringExtra("word");
        String antonym = helper.searchAnt(wordEnter);

        TextView tvword = (TextView) findViewById(R.id.TVword);
        TextView tvant = (TextView) findViewById(R.id.TVant);

        tvword.setText(wordEnter);
        tvant.setText(antonym);
    }

    public void onHome(View v) {
        if (v.getId() == R.id.Bhome) {
            Intent i = new Intent(results.this, MainActivity.class);
            startActivity(i);
        }
    }
}
