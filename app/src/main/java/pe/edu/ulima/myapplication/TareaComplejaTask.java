package pe.edu.ulima.myapplication;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by sodm on 19/09/2016.
 */

public class TareaComplejaTask extends AsyncTask<String,Integer,String> {

    @Override
    protected void onPreExecute() {
        Log.i("Task","Se esta ejecutando el onPreExecute");
    }

    @Override
    protected void onPostExecute(String s) {
        Log.i("Task",s);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        //en el hilo principal
    }

    @Override
    protected String doInBackground(String... strings) {

        //en el hilo alterno
        for (String string: strings){
            Log.i("Task",string);
        }
        return "Completado";
    }
}
