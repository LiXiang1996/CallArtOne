package ndiehfiheifwe.nijewfeow.dmeofmowe.dmiwdhiwdw;

import android.app.job.JobParameters;
import android.app.job.JobService;




/* loaded from: classes.dex */

public  class lewkfkewfew extends JobService {

    public final String f60a;

    public lewkfkewfew() {
        this("charging");
    }

    public lewkfkewfew(String str) {

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
