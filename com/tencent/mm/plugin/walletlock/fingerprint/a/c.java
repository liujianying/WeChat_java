package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.soter.d.b;
import com.tencent.mm.plugin.walletlock.b.g;
import com.tencent.mm.plugin.walletlock.b.h;
import com.tencent.mm.plugin.walletlock.fingerprint.a.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements e, d {
    private String eWo = null;
    boolean mcv = false;
    a pGA = null;
    private a pGB = null;
    private boolean pGC = false;

    public final void a(a aVar, Bundle bundle) {
        this.eWo = bundle.getString("key_pay_passwd");
        this.pGC = bundle.getBoolean("key_fp_lock_offline_mode");
        x.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepare pwd: %s, isOfflineMode: %b", new Object[]{this.eWo, Boolean.valueOf(this.pGC)});
        this.pGA = aVar;
        this.mcv = false;
        g.pIt.pIu = null;
        g.pIt.pIv = null;
        com.tencent.mm.kernel.g.DF().a(1967, this);
        com.tencent.mm.kernel.g.DF().a(1548, this);
        if (this.pGC) {
            g.pIt.pIu = String.valueOf(System.currentTimeMillis());
            jH(false);
            return;
        }
        SharedPreferences chZ = ad.chZ();
        if (chZ != null) {
            String string = chZ.getString("cpu_id", null);
            String string2 = chZ.getString("uid", null);
            x.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo cpuId: %s, uid: %s", new Object[]{string, string2});
            if (bi.oW(string) || bi.oW(string2)) {
                b.a(true, true, new 2(this, chZ));
            } else {
                fg(string, string2);
            }
        } else if (this.pGA != null) {
            this.pGA.af(2, "system error");
        }
    }

    private void jH(boolean z) {
        x.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepareAuthKey isNeedChangeAuthKey: %b", new Object[]{Boolean.valueOf(z)});
        com.tencent.d.b.a.a(new com.tencent.d.b.a.b<com.tencent.d.b.a.c>() {
            public final /* synthetic */ void a(com.tencent.d.b.a.e eVar) {
                com.tencent.d.b.a.c cVar = (com.tencent.d.b.a.c) eVar;
                x.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo prepareAuthKey onResult errCode: %d, errMsg: %s, isCancelled: %b", new Object[]{Integer.valueOf(cVar.errCode), cVar.Yy, Boolean.valueOf(c.this.mcv)});
                if (!c.this.mcv) {
                    if (cVar.isSuccess()) {
                        x.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo update wallet lock auth key success");
                        if (c.this.pGA != null) {
                            c.this.pGA.af(0, "prepare auth key ok");
                            return;
                        }
                        return;
                    }
                    x.e("MicroMsg.FingerprintLockOpenDelegate", "alvinluo error when prepare auth key");
                    h.ed(2, cVar.errCode);
                    if (c.this.pGA != null) {
                        c.this.pGA.af(2, cVar.Yy);
                    }
                }
            }
        }, z, 3, this.pGC ? null : new g(this.eWo), new com.tencent.mm.plugin.soter.b.e());
    }

    static void fg(String str, String str2) {
        com.tencent.mm.kernel.g.DF().a(new e(str, str2), 0);
    }

    public final void a(a aVar, String str, String str2, String str3) {
        x.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo do open fingerprint lock");
        this.pGB = aVar;
        com.tencent.mm.kernel.g.DF().a(new f(str2, str3, str), 0);
    }

    public final void release() {
        x.d("MicroMsg.FingerprintLockOpenDelegate", "alvinluo release open delegate");
        this.pGA = null;
        this.pGB = null;
        this.mcv = true;
        com.tencent.mm.kernel.g.DF().b(1967, this);
        com.tencent.mm.kernel.g.DF().b(1548, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.FingerprintLockOpenDelegate", "alvinluo fingerprint wallet lock open delegate errType: %d, errCode: %d, errMsg: %s, cgi type: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(lVar.getType())});
        if (!this.mcv) {
            if (lVar instanceof e) {
                if (i == 0 && i2 == 0) {
                    e eVar = (e) lVar;
                    g.pIt.pIu = eVar.jgX;
                    jH(eVar.pGF);
                } else if (this.pGA != null) {
                    this.pGA.af(7, "get challenge failed");
                }
            } else if (!(lVar instanceof f)) {
            } else {
                if (i == 0 && i2 == 0) {
                    h.jL(true);
                    if (this.pGB != null) {
                        this.pGB.af(0, "open touch lock ok");
                        return;
                    }
                    return;
                }
                h.jL(false);
                if (this.pGB != null) {
                    this.pGB.af(6, "open touch lock failed");
                }
            }
        }
    }
}
