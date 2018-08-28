package com.tencent.matrix.trace.core;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import java.util.Iterator;
import java.util.LinkedList;

public final class a implements ActivityLifecycleCallbacks {
    private static a btq;
    private final LinkedList<a> btr;
    private boolean bts;
    private String btt;
    private Runnable btu;
    private boolean mIsPaused;
    private final Handler mMainHandler;

    public interface a {
        void onActivityCreated(Activity activity);

        void onActivityPause(Activity activity);

        void onActivityStarted(Activity activity);

        void onBackground(Activity activity);

        void onChange(Activity activity, Fragment fragment);

        void onFront(Activity activity);
    }

    private a(Application application) {
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this);
            application.registerActivityLifecycleCallbacks(this);
        }
        this.btr = new LinkedList();
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }

    public static void b(Application application) {
        if (btq == null) {
            btq = new a(application);
        }
    }

    public static a tE() {
        return btq;
    }

    public final void a(a aVar) {
        if (this.btr != null) {
            this.btr.add(aVar);
        }
    }

    public final void b(a aVar) {
        if (this.btr != null) {
            this.btr.remove(aVar);
        }
    }

    public final void onActivityResumed(final Activity activity) {
        boolean z = false;
        this.mIsPaused = false;
        if (!this.bts) {
            z = true;
        }
        this.bts = true;
        String d = d(activity);
        if (!d.equals(this.btt)) {
            Iterator it = this.btr.iterator();
            while (it.hasNext()) {
                ((a) it.next()).onChange(activity, null);
            }
            this.btt = d;
        }
        Handler handler = this.mMainHandler;
        Runnable anonymousClass1 = new Runnable() {
            public final void run() {
                if (z) {
                    Iterator it = a.this.btr.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).onFront(activity);
                    }
                }
            }
        };
        this.btu = anonymousClass1;
        handler.postDelayed(anonymousClass1, 600);
    }

    public final void onActivityPaused(final Activity activity) {
        Iterator it = this.btr.iterator();
        while (it.hasNext()) {
            ((a) it.next()).onActivityPause(activity);
        }
        this.mIsPaused = true;
        if (this.btu != null) {
            this.mMainHandler.removeCallbacks(this.btu);
        }
        Handler handler = this.mMainHandler;
        Runnable anonymousClass2 = new Runnable() {
            public final void run() {
                if (a.this.bts && a.this.mIsPaused) {
                    a.this.bts = false;
                    Iterator it = a.this.btr.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).onBackground(activity);
                    }
                }
            }
        };
        this.btu = anonymousClass2;
        handler.postDelayed(anonymousClass2, 600);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Iterator it = this.btr.iterator();
        while (it.hasNext()) {
            ((a) it.next()).onActivityCreated(activity);
        }
    }

    public final void onActivityStarted(Activity activity) {
        Iterator it = this.btr.iterator();
        while (it.hasNext()) {
            ((a) it.next()).onActivityStarted(activity);
        }
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        if (d(activity).equals(this.btt)) {
            this.btt = null;
        }
    }

    private static String d(Activity activity) {
        return activity.getClass().getName() + activity.hashCode();
    }
}
