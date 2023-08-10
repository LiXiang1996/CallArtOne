package com.myaaa.nodnoewdew.doewodewd;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import java.util.concurrent.TimeUnit;

/**
 * Created by kachem on 12/7/20
 * Description:
 */
public class hdiuwhiw extends JobService {
    public static final int a = 1000;
    public static final long b = TimeUnit.SECONDS.toMillis(5);

    public static void scheduleService(Context context) {
        //Log.d(DaemonManager.LOG_TAG, "DaemonJobService scheduleService");
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        if (jobScheduler != null) {
            JobInfo.Builder persisted = new JobInfo.Builder(1000, new ComponentName(context, hdiuwhiw.class)).setPersisted(true);
            if (Build.VERSION.SDK_INT < 24) {
                persisted.setPeriodic(b);
            } else {
                persisted.setMinimumLatency(b);
            }
            if (jobScheduler != null) {
                try {
                    jobScheduler.schedule(persisted.build());
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void stopScheduleService(Context context) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        if (jobScheduler != null) {
            jobScheduler.cancel(1000);
        }
    }

    public void onCreate() {
        super.onCreate();
        //Log.d(DaemonManager.LOG_TAG, "DaemonJobService onCreate");
    }

    public void onDestroy() {
        super.onDestroy();
       // Log.d(DaemonManager.LOG_TAG, "DaemonJobService onDestroy");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        //Log.d(DaemonManager.LOG_TAG, "DaemonJobService onStartCommand");
        return START_STICKY;
    }

    public boolean onStartJob(JobParameters jobParameters) {
        //Log.d(DaemonManager.LOG_TAG, "DaemonJobService onStartJob");
        if (Build.VERSION.SDK_INT >= 24) {
            scheduleService(getApplicationContext());
        }
        jowejofdwed.start(getApplicationContext());
        return false;
    }

    public boolean onStopJob(JobParameters jobParameters) {
       // Log.d(DaemonManager.LOG_TAG, "DaemonJobService onStopJob");
        return false;
    }
}
