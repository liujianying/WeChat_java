package com.tencent.d.b.c;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import com.tencent.d.a.c.c;
import com.tencent.d.b.f.f;
import com.tencent.d.b.f.g;
import junit.framework.Assert;

public final class a {
    public CancellationSignal vlR = null;

    static /* synthetic */ void cFT() {
        f cFZ = f.cFZ();
        synchronized (cFZ.vmx) {
            c.i("Soter.SoterTaskManager", "soter: request publish cancellation", new Object[0]);
            if (f.vmw.size() != 0) {
                for (int i = 0; i < f.vmw.size(); i++) {
                    g.cGb().C(new f$3(cFZ, f.vmw.keyAt(i)));
                }
            }
        }
    }

    public a() {
        Assert.assertTrue(VERSION.SDK_INT >= 16);
        cFS();
    }

    @SuppressLint({"NewApi"})
    public final boolean mR(boolean z) {
        c.v("Soter.SoterFingerprintCanceller", "soter: publishing cancellation. should publish: %b", new Object[]{Boolean.valueOf(z)});
        if (this.vlR.isCanceled()) {
            c.i("Soter.SoterFingerprintCanceller", "soter: cancellation signal already expired.", new Object[0]);
            return false;
        } else if (VERSION.SDK_INT < 23) {
            g.cGb().C(new 1(this, z));
            return true;
        } else {
            g.cGb().C(new 2(this));
            g.cGb().l(new 3(this), 350);
            return true;
        }
    }

    @SuppressLint({"NewApi"})
    public final void cFS() {
        this.vlR = new CancellationSignal();
    }
}
