package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class m {
    private static final Object aOv = new Object();
    private static m aOw;

    public static m aj(Context context) {
        synchronized (aOv) {
            if (aOw == null) {
                aOw = new n(context.getApplicationContext());
            }
        }
        return aOw;
    }

    public abstract void a(ComponentName componentName, ServiceConnection serviceConnection);

    public abstract void a(String str, String str2, ServiceConnection serviceConnection);

    public abstract boolean a(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract boolean a(String str, String str2, ServiceConnection serviceConnection, String str3);
}
