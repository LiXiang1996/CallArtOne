package ndiehfiheifwe.nijewfeow.dmeofmowe.dmiwdhiwdw;

import android.app.job.JobParameters;
import android.app.job.JobService;

public  class ftwew2 extends JobService {

    public final String f60a;

    public ftwew2() {
        this("idle");
    }

    public ftwew2(String str) {
        this.f60a = str;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {

        return false;
    }

}
