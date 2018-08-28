package com.google.android.gms.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.RemoteException;
import com.google.android.gms.c.d;
import com.google.android.gms.common.b;
import com.google.android.gms.common.c;
import com.google.android.gms.common.e;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.w;
import java.io.IOException;

public final class a {
    private static boolean aEo = false;
    h aEi;
    d aEj;
    boolean aEk;
    Object aEl = new Object();
    b aEm;
    final long aEn;
    private final Context mContext;

    private a(Context context) {
        w.ah(context);
        this.mContext = context;
        this.aEk = false;
        this.aEn = -1;
    }

    private static h Y(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            if (aEo) {
                b.oq();
                switch (b.ae(context)) {
                    case 0:
                    case 2:
                        break;
                    default:
                        throw new IOException("Google Play services not available");
                }
            }
            try {
                e.ag(context);
            } catch (c e) {
                throw new IOException(e);
            }
            h hVar = new h();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (com.google.android.gms.common.stats.b.pG().a(context, intent, hVar, 1)) {
                    return hVar;
                }
                throw new IOException("Connection failure");
            } catch (Throwable th) {
                IOException iOException = new IOException(th);
            }
        } catch (NameNotFoundException e2) {
            throw new c(9);
        }
    }

    public static a Z(Context context) {
        a aVar = new a(context);
        try {
            aVar.mz();
            a mA = aVar.mA();
            return mA;
        } finally {
            aVar.finish();
        }
    }

    private static d a(h hVar) {
        try {
            return com.google.android.gms.c.d.a.n(hVar.pI());
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            IOException iOException = new IOException(th);
        }
    }

    private a mA() {
        a aVar;
        w.bi("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.aEk) {
                synchronized (this.aEl) {
                    if (this.aEm == null || !this.aEm.aEu) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    mz();
                    if (!this.aEk) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (RemoteException e) {
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            w.ah(this.aEi);
            w.ah(this.aEj);
            aVar = new a(this.aEj.getId(), this.aEj.av(true));
        }
        synchronized (this.aEl) {
            if (this.aEm != null) {
                this.aEm.aEt.countDown();
                try {
                    this.aEm.join();
                } catch (InterruptedException e3) {
                }
            }
            if (this.aEn > 0) {
                this.aEm = new b(this, this.aEn);
            }
        }
        return aVar;
    }

    private void mz() {
        w.bi("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.aEk) {
                finish();
            }
            this.aEi = Y(this.mContext);
            this.aEj = a(this.aEi);
            this.aEk = true;
        }
    }

    protected final void finalize() {
        finish();
        super.finalize();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void finish() {
        /*
        r3 = this;
        r0 = "Calling this from your main thread can lead to deadlock";
        com.google.android.gms.common.internal.w.bi(r0);
        monitor-enter(r3);
        r0 = r3.mContext;	 Catch:{ all -> 0x002b }
        if (r0 == 0) goto L_0x000f;
    L_0x000b:
        r0 = r3.aEi;	 Catch:{ all -> 0x002b }
        if (r0 != 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
    L_0x0010:
        return;
    L_0x0011:
        r0 = r3.aEk;	 Catch:{ IllegalArgumentException -> 0x002e }
        if (r0 == 0) goto L_0x0020;
    L_0x0015:
        r0 = com.google.android.gms.common.stats.b.pG();	 Catch:{ IllegalArgumentException -> 0x002e }
        r1 = r3.mContext;	 Catch:{ IllegalArgumentException -> 0x002e }
        r2 = r3.aEi;	 Catch:{ IllegalArgumentException -> 0x002e }
        r0.a(r1, r2);	 Catch:{ IllegalArgumentException -> 0x002e }
    L_0x0020:
        r0 = 0;
        r3.aEk = r0;	 Catch:{ all -> 0x002b }
        r0 = 0;
        r3.aEj = r0;	 Catch:{ all -> 0x002b }
        r0 = 0;
        r3.aEi = r0;	 Catch:{ all -> 0x002b }
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        goto L_0x0010;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        r0 = move-exception;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.a.a.a.finish():void");
    }
}
