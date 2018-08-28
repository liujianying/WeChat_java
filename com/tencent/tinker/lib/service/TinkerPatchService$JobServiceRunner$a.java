package com.tencent.tinker.lib.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.PersistableBundle;
import com.tencent.tinker.lib.f.a;
import java.lang.ref.WeakReference;

class TinkerPatchService$JobServiceRunner$a extends AsyncTask<JobParameters, Void, Void> {
    private final WeakReference<JobService> vst;

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        JobParameters jobParameters = ((JobParameters[]) objArr)[0];
        PersistableBundle extras = jobParameters.getExtras();
        Intent intent = new Intent();
        intent.putExtra("patch_path_extra", extras.getString("patch_path_extra"));
        intent.putExtra("patch_result_class", extras.getString("patch_result_class"));
        JobService jobService = (JobService) this.vst.get();
        if (jobService == null) {
            a.e("Tinker.TinkerPatchService", "unexpected case: holder job service is null.", new Object[0]);
        } else {
            TinkerPatchService.F(jobService.getApplicationContext(), intent);
            jobService = (JobService) this.vst.get();
            if (jobService != null) {
                jobService.jobFinished(jobParameters, false);
            }
        }
        return null;
    }

    TinkerPatchService$JobServiceRunner$a(JobService jobService) {
        this.vst = new WeakReference(jobService);
    }
}
