package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.bq;
import com.tencent.mm.g.a.lg;
import com.tencent.mm.g.a.lg$b;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.x;

public abstract class a implements k {
    public final void dh(Context context) {
        x.i("MicroMsg.BaseFingerprintImp", "showFingerPrintEntrance");
        if (e.aNy() && !aNb()) {
            x.e("MicroMsg.BaseFingerprintImp", "the fingerprint is open ready, but system has none Finger print ids!");
            x.i("MicroMsg.BaseFingerprintImp", "closeFP");
            bq bqVar = new bq();
            bqVar.bJX = new 1(this, bqVar);
            com.tencent.mm.sdk.b.a.sFg.a(bqVar, context.getMainLooper());
        } else if (q.deQ.deZ != 1) {
            x.e("MicroMsg.BaseFingerprintImp", "hy: device info not support");
        } else if (e.aNy() || !(e.aNB() || e.aNC())) {
            x.e("MicroMsg.BaseFingerprintImp", "mgr == null or not support FP or has show guide or show HWManager!");
        }
    }

    public final boolean aNa() {
        return e.aNy();
    }

    public final boolean aNb() {
        com.tencent.mm.plugin.fingerprint.a.aMW();
        com.tencent.mm.plugin.fingerprint.a.aMX();
        return c.aNf();
    }

    public boolean aNc() {
        return false;
    }

    public final void a(lg lgVar, int i, String str) {
        x.i("MicroMsg.BaseFingerprintImp", "hy: onOpenFingerprintAuthFailed");
        if (lgVar != null && lgVar.bVz.bVD != null) {
            lgVar.bVA = new lg$b();
            lgVar.bVA.errCode = i;
            lgVar.bVA.bQb = "";
            lgVar.bVA.bQc = "";
            lgVar.bVA.Yy = str;
            lgVar.bVA.bVF = type();
            lgVar.bVz.bVD.run();
        }
    }

    public final void eZ(boolean z) {
        x.i("MicroMsg.BaseFingerprintImp", "hy: set isOpenFp: %b", new Object[]{Boolean.valueOf(z)});
        e.fa(z);
    }
}
