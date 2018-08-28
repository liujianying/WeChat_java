package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class n extends m implements Callback {
    private final Context aGi;
    private final HashMap<a, b> aOx = new HashMap();
    private final com.google.android.gms.common.stats.b aOy;
    private final long aOz;
    private final Handler mHandler;

    private final class b {
        IBinder aMX;
        ComponentName aOC;
        final a aOD = new a(this);
        final Set<ServiceConnection> aOE = new HashSet();
        boolean aOF;
        final a aOG;
        int mState = 2;

        public b(a aVar) {
            this.aOG = aVar;
        }

        public final void a(ServiceConnection serviceConnection, String str) {
            n.this.aOy.a(n.this.aGi, serviceConnection, str, this.aOG.pn(), 3);
            this.aOE.add(serviceConnection);
        }

        public final boolean a(ServiceConnection serviceConnection) {
            return this.aOE.contains(serviceConnection);
        }

        public final void bd(String str) {
            this.aOF = n.this.aOy.a(n.this.aGi, str, this.aOG.pn(), this.aOD, 129);
            if (this.aOF) {
                this.mState = 3;
                return;
            }
            try {
                n.this.aOy.a(n.this.aGi, this.aOD);
            } catch (IllegalArgumentException e) {
            }
        }

        public final boolean po() {
            return this.aOE.isEmpty();
        }
    }

    n(Context context) {
        this.aGi = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.aOy = com.google.android.gms.common.stats.b.pG();
        this.aOz = 5000;
    }

    private void a(a aVar, ServiceConnection serviceConnection) {
        w.j(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.aOx) {
            b bVar = (b) this.aOx.get(aVar);
            if (bVar == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + aVar);
            } else if (bVar.a(serviceConnection)) {
                bVar.aOH.aOy.a(bVar.aOH.aGi, serviceConnection, null, null, 4);
                bVar.aOE.remove(serviceConnection);
                if (bVar.po()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, bVar), this.aOz);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + aVar);
            }
        }
    }

    private boolean a(a aVar, ServiceConnection serviceConnection, String str) {
        boolean z;
        w.j(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.aOx) {
            b bVar = (b) this.aOx.get(aVar);
            if (bVar != null) {
                this.mHandler.removeMessages(0, bVar);
                if (!bVar.a(serviceConnection)) {
                    bVar.a(serviceConnection, str);
                    switch (bVar.mState) {
                        case 1:
                            serviceConnection.onServiceConnected(bVar.aOC, bVar.aMX);
                            break;
                        case 2:
                            bVar.bd(str);
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + aVar);
            }
            bVar = new b(aVar);
            bVar.a(serviceConnection, str);
            bVar.bd(str);
            this.aOx.put(aVar, bVar);
            z = bVar.aOF;
        }
        return z;
    }

    public final void a(ComponentName componentName, ServiceConnection serviceConnection) {
        a(new a(componentName), serviceConnection);
    }

    public final void a(String str, String str2, ServiceConnection serviceConnection) {
        a(new a(str, str2), serviceConnection);
    }

    public final boolean a(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return a(new a(componentName), serviceConnection, str);
    }

    public final boolean a(String str, String str2, ServiceConnection serviceConnection, String str3) {
        return a(new a(str, str2), serviceConnection, str3);
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                b bVar = (b) message.obj;
                synchronized (this.aOx) {
                    if (bVar.po()) {
                        if (bVar.aOF) {
                            bVar.aOH.aOy.a(bVar.aOH.aGi, bVar.aOD);
                            bVar.aOF = false;
                            bVar.mState = 2;
                        }
                        this.aOx.remove(bVar.aOG);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
