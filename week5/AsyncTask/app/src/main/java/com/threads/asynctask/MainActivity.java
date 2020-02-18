package com.threads.asynctask;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText time;
    private TextView finalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        time = (EditText) findViewById(R.id.in_time);
        button = (Button) findViewById(R.id.btn_run);
        finalResult = (TextView) findViewById(R.id.tv_result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTaskRunner runner = new AsyncTaskRunner();
                String sleepTime = time.getText().toString();

                // Entry Point to AsyncTask
                runner.execute(sleepTime);
            }
        });
    }

    // Generic Types <Params,Progress,Result>
    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        private String resp;
        ProgressDialog progressDialog;

        @Override
        //  onPreExecute() does not take anything
        //  invoked on the UI thread before the task is executed.
        //  This step is normally used to setup the task, for instance by showing a progress bar in the user interface.
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(MainActivity.this,
                    "ProgressDialog",
                    "Wait for "+time.getText().toString()+ " seconds");
        }

        @Override
        // doInBackground() takes in "Parameters" (sleepTime)
        // Returns "Result"  ("Slept for " + params[0] + " seconds"). This "Result" is passed onto onPostExecute()
        // May call onProgressUpdate() by passing in "progress"
        protected String doInBackground(String... params) {
            publishProgress("Sleeping..."); // Calls onProgressUpdate()
            try {
                int time = Integer.parseInt(params[0])*1000;

                Thread.sleep(time);
                resp = "Slept for " + params[0] + " seconds";
            } catch (InterruptedException e) {
                e.printStackTrace();
                resp = e.getMessage();
            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }


        @Override
        // onPostExecute() takes in result (from doInBackground())
        protected void onPostExecute(String result) {
            // execution of result of Long time consuming operation
            progressDialog.dismiss();
            finalResult.setText(result);
        }





        @Override
        // onProgressUpdate() takes in Progress
        protected void onProgressUpdate(String... text) {
            finalResult.setText(text[0]);

        }
    }
}