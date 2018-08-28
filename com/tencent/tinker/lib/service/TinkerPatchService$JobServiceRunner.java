package com.tencent.tinker.lib.service;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import com.tencent.tinker.lib.f.a;

@TargetApi(21)
public class TinkerPatchService$JobServiceRunner extends JobService {
    private a vss = null;

    public boolean onStartJob(JobParameters jobParameters) {
        this.vss = new a(this);
        this.vss.execute(new JobParameters[]{jobParameters});
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        a.w("Tinker.TinkerPatchService", "Stopping TinkerPatchJob service.", new Object[0]);
        if (this.vss != null) {
            this.vss.cancel(true);
            this.vss = null;
        }
        return false;
    }
}
