package com.tencent.tinker.lib.service;

import android.app.Service;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.os.SystemClock;
import com.tencent.tinker.lib.c.a;
import com.tencent.tinker.lib.f.b;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import java.io.File;
import java.util.concurrent.TimeUnit;

public final class TinkerPatchService {
    private static int cYX = -1119860829;
    private static Handler mHandler = new Handler(Looper.getMainLooper());
    private static a vsq = null;
    private static Class<? extends AbstractResultService> vsr = null;

    static /* synthetic */ void F(Context context, Intent intent) {
        boolean z = false;
        com.tencent.tinker.lib.e.a hL = com.tencent.tinker.lib.e.a.hL(context);
        hL.vsz.O(intent);
        if (intent == null) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchService", "TinkerPatchService received a null intent, ignoring.", new Object[z]);
            return;
        }
        String aB = aB(intent);
        if (aB == null) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchService", "TinkerPatchService can't get the path extra, ignoring.", new Object[z]);
            return;
        }
        File file = new File(aB);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Throwable th = null;
        a aVar = new a();
        try {
            if (vsq == null) {
                throw new TinkerRuntimeException("upgradePatchProcessor is null.");
            }
            z = vsq.a(context, aB, aVar);
            elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
            hL.vsz.a(file, z, elapsedRealtime);
            aVar.bLW = z;
            aVar.vso = aB;
            aVar.grC = elapsedRealtime;
            aVar.vhq = th;
            if (intent == null) {
                throw new TinkerRuntimeException("getPatchResultExtra, but intent is null");
            }
            AbstractResultService.a(context, aVar, ShareIntentUtil.j(intent, "patch_result_class"));
        } catch (Throwable th2) {
            th = th2;
            hL.vsz.a(file, th);
        }
    }

    public static void bM(final Context context, final String str) {
        try {
            if (VERSION.SDK_INT < 26) {
                bN(context, str);
                return;
            }
            int i;
            com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchService", "run patch service by job scheduler.", new Object[0]);
            Builder builder = new Builder(1, new ComponentName(context, JobServiceRunner.class));
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("patch_path_extra", str);
            persistableBundle.putString("patch_result_class", vsr.getName());
            builder.setExtras(persistableBundle);
            builder.setOverrideDeadline(5);
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchService", "jobScheduler is null.", new Object[0]);
            } else if (jobScheduler.schedule(builder.build()) == 1) {
                i = 1;
                if (i == 0) {
                    com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchService", "start patch job service fail, try to fallback to intent service.", new Object[0]);
                    mHandler.postDelayed(new Runnable() {
                        public final void run() {
                            com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchService", "fallback: prepare trying to run patch service by intent service.", new Object[0]);
                            if (!b.hN(context)) {
                                TinkerPatchService.bN(context, str);
                            }
                        }
                    }, TimeUnit.SECONDS.toMillis(3));
                }
            }
            i = 0;
            if (i == 0) {
                com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchService", "start patch job service fail, try to fallback to intent service.", new Object[0]);
                mHandler.postDelayed(/* anonymous class already generated */, TimeUnit.SECONDS.toMillis(3));
            }
        } catch (Throwable th) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchService", "start patch service fail, exception:" + th, new Object[0]);
        }
    }

    private static void bN(Context context, String str) {
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchService", "run patch service by intent service.", new Object[0]);
        Intent intent = new Intent(context, IntentServiceRunner.class);
        intent.putExtra("patch_path_extra", str);
        intent.putExtra("patch_result_class", vsr.getName());
        context.startService(intent);
    }

    public static void a(a aVar, Class<? extends AbstractResultService> cls) {
        vsq = aVar;
        vsr = cls;
        try {
            Class.forName(cls.getName());
        } catch (ClassNotFoundException e) {
        }
    }

    public static String aB(Intent intent) {
        if (intent != null) {
            return ShareIntentUtil.j(intent, "patch_path_extra");
        }
        throw new TinkerRuntimeException("getPatchPathExtra, but intent is null");
    }

    public static Class<? extends Service> cGW() {
        if (VERSION.SDK_INT < 26) {
            return IntentServiceRunner.class;
        }
        return JobServiceRunner.class;
    }
}
