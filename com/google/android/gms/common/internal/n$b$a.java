package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.n.b;

public class n$b$a implements ServiceConnection {
    final /* synthetic */ b aOI;

    public n$b$a(b bVar) {
        this.aOI = bVar;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (n.a(this.aOI.aOH)) {
            this.aOI.aMX = iBinder;
            this.aOI.aOC = componentName;
            for (ServiceConnection onServiceConnected : this.aOI.aOE) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.aOI.mState = 1;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (n.a(this.aOI.aOH)) {
            this.aOI.aMX = null;
            this.aOI.aOC = componentName;
            for (ServiceConnection onServiceDisconnected : this.aOI.aOE) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.aOI.mState = 2;
        }
    }
}
