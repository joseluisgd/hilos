package pe.edu.ulima.myapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but = (Button) findViewById(R.id.but);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(
                        5,
                        5,
                        60l,
                        TimeUnit.SECONDS,
                        new LinkedBlockingQueue<Runnable>()
                );


                final Runnable porcionUI = new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "PRUEBITA", Toast.LENGTH_SHORT).show();
                    }
                };

                final Handler handler= new Handler();


                for(int i=0;i<5 ; i++){
                    final int cont=i;
                    poolExecutor.execute(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Log.i("MainActivity","Cont: "+cont);
                            handler.post(porcionUI);
                        }
                    });
                }




            }
        });

    }
}
