package com.google.android.gms.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.internal.w;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public final class ah {
    private static volatile ah aYl;
    private volatile aj aGF;
    private final List<Object> aYm = new CopyOnWriteArrayList();
    private final ad aYn = new ad();
    public final a aYo = new a(this);
    public UncaughtExceptionHandler aYp;
    public final Context mContext;

    private static class c extends Thread {
        c(Runnable runnable, String str) {
            super(runnable, str);
        }

        public final void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    private ah(Context context) {
        Context applicationContext = context.getApplicationContext();
        w.ah(applicationContext);
        this.mContext = applicationContext;
    }

    public static ah au(Context context) {
        w.ah(context);
        if (aYl == null) {
            synchronized (ah.class) {
                if (aYl == null) {
                    aYl = new ah(context);
                }
            }
        }
        return aYl;
    }

    public static void nx() {
        if (!(Thread.currentThread() instanceof c)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final <V> Future<V> a(Callable<V> callable) {
        w.ah(callable);
        if (!(Thread.currentThread() instanceof c)) {
            return this.aYo.submit(callable);
        }
        Future futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    public final void d(Runnable runnable) {
        w.ah(runnable);
        this.aYo.submit(runnable);
    }

    public final aj qp() {
        if (this.aGF == null) {
            synchronized (this) {
                if (this.aGF == null) {
                    aj ajVar = new aj();
                    PackageManager packageManager = this.mContext.getPackageManager();
                    String packageName = this.mContext.getPackageName();
                    ajVar.aYu = packageName;
                    ajVar.aYv = packageManager.getInstallerPackageName(packageName);
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.mContext.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (NameNotFoundException e) {
                    }
                    ajVar.aEV = packageName;
                    ajVar.aEW = str;
                    this.aGF = ajVar;
                }
            }
        }
        return this.aGF;
    }
}
