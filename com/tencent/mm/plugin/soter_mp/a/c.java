package com.tencent.mm.plugin.soter_mp.a;

import android.app.Activity;
import com.tencent.mm.plugin.soter_mp.b.d;
import com.tencent.mm.plugin.soter_mp.b.e;
import com.tencent.mm.plugin.soter_mp.ui.SoterAuthenticationUI;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public abstract class c {
    protected d ooq = null;
    protected e oor = null;
    protected WeakReference<Activity> oos = null;

    public abstract void dd();

    public abstract void onPause();

    public abstract void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public abstract void onResume();

    public c(WeakReference<Activity> weakReference, d dVar, e eVar) {
        this.ooq = dVar;
        this.oor = eVar;
        this.oos = weakReference;
    }

    protected static void bFp() {
        if (SoterAuthenticationUI.oox != null) {
            SoterAuthenticationUI.oox.obtainMessage(5).sendToTarget();
        } else {
            x.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
    }

    protected final void bFq() {
        if (SoterAuthenticationUI.oox != null) {
            bFp();
            SoterAuthenticationUI.oox.obtainMessage(0, this.oor).sendToTarget();
            return;
        }
        x.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    protected final void bFr() {
        if (SoterAuthenticationUI.oox != null) {
            bFp();
            SoterAuthenticationUI.oox.obtainMessage(1, this.oor).sendToTarget();
            return;
        }
        x.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    protected final void bFs() {
        if (SoterAuthenticationUI.oox != null) {
            bFp();
            SoterAuthenticationUI.oox.obtainMessage(2, this.oor).sendToTarget();
            return;
        }
        x.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    protected static void a(com.tencent.mm.ui.widget.a.c cVar) {
        if (cVar == null) {
            x.e("MicroMsg.SoterMpBaseController", "hy: dialog is null.");
        } else if (SoterAuthenticationUI.oox != null) {
            bFp();
            SoterAuthenticationUI.oox.obtainMessage(6, cVar).sendToTarget();
        } else {
            x.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
    }
}
