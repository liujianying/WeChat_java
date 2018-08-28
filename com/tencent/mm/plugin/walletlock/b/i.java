package com.tencent.mm.plugin.walletlock.b;

import android.app.Activity;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public enum i {
    ;
    
    private Object pIA;
    public HashSet<WeakReference<Activity>> pIB;
    private boolean pIy;
    private boolean pIz;

    private i(String str) {
        this.pIy = false;
        this.pIz = false;
        this.pIA = new Object();
        this.pIB = new HashSet();
    }

    public final void jM(boolean z) {
        synchronized (this.pIA) {
            this.pIy = z;
        }
    }

    public final boolean bSf() {
        boolean z;
        synchronized (this.pIA) {
            z = this.pIy;
        }
        return z;
    }

    public final void jN(boolean z) {
        synchronized (this.pIA) {
            this.pIz = z;
        }
    }

    public final boolean bSg() {
        boolean z;
        synchronized (this.pIA) {
            z = this.pIz;
        }
        return z;
    }

    public final void bSh() {
        synchronized (this.pIA) {
            this.pIz = true;
        }
    }

    public final void b(WeakReference<Activity> weakReference) {
        if (this.pIB != null) {
            if (weakReference.get() != null) {
                x.v("MicroMsg.WalletLockStatusManager", "alvinluo addProtectActivity %s", new Object[]{((Activity) weakReference.get()).getClass().getName()});
            }
            this.pIB.add(weakReference);
        }
    }

    public final void bSi() {
        Iterator it = this.pIB.iterator();
        while (it.hasNext()) {
            Activity activity = (Activity) ((WeakReference) it.next()).get();
            if (!(activity == null || activity.isFinishing())) {
                x.v("MicroMsg.WalletLockStatusManager", "alvinluo finish %s", new Object[]{activity.getClass().getName()});
                activity.finish();
            }
            it.remove();
        }
    }
}
