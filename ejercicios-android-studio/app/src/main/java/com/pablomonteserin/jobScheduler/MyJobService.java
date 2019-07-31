package com.pablomonteserin.jobScheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Debug;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by monty on 21/09/17.
 */

public class MyJobService extends JobService {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("TRAZA", "Service created");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("TRAZA", "Service destroyed");
    }

    @Override
    public boolean onStartJob(final JobParameters jobParameters) {

        long duration = jobParameters.getExtras().getLong("DURACION");

        // Uses a handler to delay the execution of jobFinished().
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("TRAZA", "aaaaaaa");
                jobFinished(jobParameters, false);
            }
        }, duration);


        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
Log.d("TRAZA", "stop");
        return false;
    }
}
