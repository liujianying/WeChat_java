package com.tencent.tencentmap.mapsdk.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.util.SparseArray;
import java.lang.ref.WeakReference;

@TargetApi(14)
public final class f implements ActivityLifecycleCallbacks {
    private static SparseArray<WeakReference<Activity>> a = new SparseArray();

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity);
    }

    public final void onActivityStarted(Activity activity) {
        a.b = true;
        a(activity);
    }

    public final void onActivityResumed(Activity activity) {
        a.b = true;
        a(activity);
    }

    public final void onActivityPaused(Activity activity) {
        a.b = true;
        a(activity);
    }

    public final void onActivityStopped(Activity activity) {
        a.b = true;
        a(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a.b = true;
        a(activity);
    }

    public final void onActivityDestroyed(Activity activity) {
        a.b = true;
        a(activity);
    }

    private static void a(Activity activity) {
        if (activity != null && a != null) {
            int hashCode = activity.hashCode();
            if (a.get(hashCode) == null) {
                a.put(hashCode, new WeakReference(activity));
            }
        }
    }
}
