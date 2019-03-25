package in.spooke.seekbar;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    Button btn_inc,btn_dec;
    int int_seekvalue=0;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        btn_inc=(Button)findViewById(R.id.btn_inc);
        btn_dec=(Button)findViewById(R.id.btn_dec);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                Log.e("page1_task1",""+progress);
                int_seekvalue=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.e("page1_task2","seekbar touch started!");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.e("page1_task3","seekbar touch stopped!");
            }
        });

        /*set progress value to seekbar programmatically*/
        //seekBar.setProgress(20);

        btn_inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekBar.setProgress(int_seekvalue+10);
                int_seekvalue=int_seekvalue+10;
            }
        });

        btn_dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seekBar.setProgress(int_seekvalue-10);
                int_seekvalue=int_seekvalue-10;
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            seekBar.setTooltipText("Deepankumar");
        }

        /*Disble seekbar*/
        //seekBar.setEnabled(false);

        /*Disble the touch in seekbar*/
//        seekBar.setOnTouchListener(new View.OnTouchListener(){
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });

    }
}
