package com.tencent.mm.plugin.appbrand.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import java.lang.ref.WeakReference;

public abstract class d {
    private final WeakReference<Activity> fjz;
    public final BroadcastReceiver rj = new 1(this);

    public abstract void acz();

    public d(Activity activity) {
        this.fjz = new WeakReference(activity);
    }
}
