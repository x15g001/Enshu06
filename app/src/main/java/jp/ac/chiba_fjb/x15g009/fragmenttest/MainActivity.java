package jp.ac.chiba_fjb.x15g009.fragmenttest;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,BlankFragment.OnDialogButtonListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonDialog).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        BlankFragment f = new BlankFragment();
        f.setOnDialogButtonListener(this);
        f.show(getSupportFragmentManager(),"");
    }

    @Override
    public void onDialogButton(int value) {
        TextView textView = (TextView) findViewById(R.id.textOutput);
        if(value == 0)
            textView.setText("BUTTON1が押されました");
        else if(value == 1)
            textView.setText("BUTTON2が押されました");
        else if(value == 2)
            textView.setText("BUTTON3が押されました");
        else if(value == 3)
            textView.setText("BUTTON4が押されました");
    }
}