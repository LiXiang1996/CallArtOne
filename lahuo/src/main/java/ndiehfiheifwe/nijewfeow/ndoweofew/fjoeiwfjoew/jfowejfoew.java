package ndiehfiheifwe.nijewfeow.ndoweofew.fjoeiwfjoew;

import android.app.job.JobParameters;
import android.app.job.JobService;




/* loaded from: classes.dex */

public  class jfowejfoew extends JobService {

    public final String f60a;

    public jfowejfoew() {
        this("content");
    }

    public jfowejfoew(String str) {

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
