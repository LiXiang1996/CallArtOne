package ndiehfiheifwe.nijewfeow.ndoweofew.jkdpfejpfew;

import android.app.job.JobParameters;
import android.app.job.JobService;




/* loaded from: classes.dex */

public  class jiowejfopew extends JobService {

    public final String f60a;

    public jiowejfopew() {
        this("wifi");
    }

    public jiowejfopew(String str) {

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
