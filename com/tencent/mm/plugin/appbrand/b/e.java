package com.tencent.mm.plugin.appbrand.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import java.lang.ref.WeakReference;

public abstract class e {
    public final BroadcastReceiver fjD = new 1(this);
    final WeakReference<Activity> fjz;

    public abstract void acA();

    public e(Activity activity) {
        this.fjz = new WeakReference(activity);
    }
}
