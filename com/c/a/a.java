package com.c.a;

import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.RemoteException;
import android.os.ServiceManager;

public final class a {
    public c bfX;
    public b bfY;
    public a bfZ;
    private int bga;
    b bgb;
    int bgc = -1;
    public DeathRecipient bgd = new 1(this);

    public static a sm() {
        c sp = sp();
        if (sp == null) {
            return null;
        }
        try {
            return new a(sp, Looper.getMainLooper());
        } catch (Exception e) {
            return null;
        }
    }

    private a(c cVar, Looper looper) {
        this.bfX = cVar;
        a aVar = new a(this, looper);
        this.bga = 1;
        this.bfY = new 2(this);
        if (this.bfX.a(this.bfY, 1)) {
            this.bfZ = aVar;
            cVar.asBinder().linkToDeath(this.bgd, 0);
            return;
        }
        throw new RuntimeException();
    }

    public final int[] sn() {
        try {
            return this.bfX.c(this.bfY);
        } catch (RemoteException e) {
            return new int[0];
        }
    }

    public final int a(b bVar, int[] iArr) {
        int i = -1;
        if (iArr == null || bVar == null) {
            return i;
        }
        this.bgb = bVar;
        this.bgc = 0;
        try {
            return this.bfX.a(this.bfY, iArr, null);
        } catch (RemoteException e) {
            return i;
        }
    }

    public final void abort() {
        if (this.bfZ != null) {
            this.bfZ.removeMessages(8);
        }
        try {
            this.bfX.a(this.bfY);
        } catch (RemoteException e) {
        }
    }

    public static int[] so() {
        c sp = sp();
        if (sp == null) {
            return new int[0];
        }
        try {
            return sp.sq();
        } catch (RemoteException e) {
            return new int[0];
        }
    }

    private static c sp() {
        return com.c.a.c.a.x(ServiceManager.getService("authentication_service"));
    }
}
