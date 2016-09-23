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
                TareaComplejaTask tarea = new TareaComplejaTask();
                tarea.execute("Param1","Param2");
            }
        });

    }
}
