package com.pablomonteserin.jobScheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.pablomonteserin.ejercicios.R;

public class MyJobScheduler extends AppCompatActivity {
private ComponentName mServiceComponent;
    private int mJobId = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_scheduler);
    }

    public void scheduleJob(View v) {
        JobInfo.Builder builder = new JobInfo.Builder(mJobId++, mServiceComponent);

        mServiceComponent = new ComponentName(this, MyJobService.class);
            builder.setMinimumLatency(5000);

            builder.setOverrideDeadline(1000);

//Idle mode es cuando el teléfono está encendido pero no lo estás usando y la pantalla está apagada
        builder.setRequiresDeviceIdle(false);
        builder.setRequiresCharging(false);

        // Extras, work duration.
        PersistableBundle extras = new PersistableBundle();

        extras.putLong("DURACION", 1 * 1000);
        builder.setExtras(extras);

        // Schedule job
        JobScheduler tm = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        tm.schedule(builder.build());
    }

    /**
     * Executed when user clicks on CANCEL ALL.
     */
    public void cancelAllJobs(View v) {
        JobScheduler tm = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
        tm.cancelAll();
        Log.d("TRAZA", "cancelar trabajos");
    }


}
