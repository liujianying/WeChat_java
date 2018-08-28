package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import com.tencent.d.b.a.b;
import com.tencent.d.b.a.c;
import com.tencent.d.b.a.e;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.smtt.utils.TbsLog;
import java.lang.ref.WeakReference;

public final class l implements j {
    private String eTo = "";
    private a jgD = null;
    private a jgE = null;
    WeakReference<WalletBaseUI> jgT = null;

    public final void a(Context context, a aVar, String str) {
        x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: prepare");
        this.jgT = new WeakReference((WalletBaseUI) context);
        this.jgD = aVar;
        this.eTo = str;
        ((WalletBaseUI) this.jgT.get()).jr(1586);
        ((WalletBaseUI) this.jgT.get()).jr(1638);
        com.tencent.mm.plugin.soter.c.a.bFd();
        x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: start gen auth key");
        com.tencent.d.b.a.a(new b<c>() {
            public final /* synthetic */ void a(e eVar) {
                c cVar = (c) eVar;
                x.i("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo prepare auth key errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(cVar.errCode), cVar.Yy});
                if (cVar.isSuccess()) {
                    x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: update pay auth key success");
                    if (l.this.jgT == null || l.this.jgT.get() == null) {
                        l.this.ag(-1, "base ui is null");
                        return;
                    } else {
                        ((WalletBaseUI) l.this.jgT.get()).a(new com.tencent.mm.plugin.fingerprint.c.a(), false, false);
                        return;
                    }
                }
                com.tencent.mm.plugin.soter.c.a.dL(2, cVar.errCode);
                if (cVar.errCode == 12) {
                    x.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed upload: model is null or necessary elements null");
                    com.tencent.mm.plugin.soter.c.a.c(4, -1000223, -1, "gen auth key failed: unexpected! generated but cannot get");
                } else if (cVar.errCode == 5) {
                    com.tencent.mm.plugin.soter.c.a.c(4, -1000223, -1, "gen auth key failed");
                } else if (cVar.errCode == 10) {
                    x.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: update pay auth key failed. remove");
                    com.tencent.d.b.a.Hp(1);
                    com.tencent.mm.plugin.soter.c.a.c(5, 4, cVar.errCode, "upload auth key failed");
                } else if (cVar.errCode == 4 || cVar.errCode == 3) {
                    x.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: gen auth key failed");
                    com.tencent.mm.plugin.soter.c.a.c(2, -1000223, -1, "gen ask failed");
                } else if (cVar.errCode == 9) {
                    x.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo upload ask failed");
                    com.tencent.mm.plugin.soter.c.a.c(3, 4, cVar.errCode, cVar.Yy);
                } else {
                    x.e("MicroMsg.SoterFingerprintOpenDelegate", "alvinluo unknown error when prepare auth key");
                    com.tencent.mm.plugin.soter.c.a.c(TbsLog.TBSLOG_CODE_SDK_BASE, -1000223, cVar.errCode, cVar.Yy);
                }
                l.this.ag(-1, cVar.Yy);
            }
        }, true, 1, new com.tencent.mm.plugin.fingerprint.c.c(this.eTo), new com.tencent.mm.plugin.soter.b.e());
    }

    public final void clear() {
        x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: clear");
        if (!(this.jgT == null || this.jgT.get() == null)) {
            ((WalletBaseUI) this.jgT.get()).js(1586);
            ((WalletBaseUI) this.jgT.get()).js(1638);
        }
        this.jgD = null;
        s.pqR.reset();
        if (this.jgT != null && this.jgT.get() != null) {
            this.jgT.clear();
        }
    }

    final void ag(int i, String str) {
        if (this.jgD != null) {
            this.jgD.af(i, str);
        }
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: onSceneEnd: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (bi.oW(str)) {
            str = ad.getContext().getString(i.fingerprint_open_fail);
        }
        if (lVar instanceof com.tencent.mm.plugin.fingerprint.c.a) {
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.SoterFingerprintOpenDelegate", "get challenge success");
                if (bi.oW(((com.tencent.mm.plugin.fingerprint.c.a) lVar).jgX)) {
                    ag(-1, str);
                    return true;
                }
                ah.A(new Runnable() {
                    public final void run() {
                        l.this.ag(0, "");
                    }
                });
            } else {
                x.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: failed get challenge");
                ag(i2, str);
                com.tencent.mm.plugin.soter.c.a.c(7, i, i2, "get challenge failed");
                return true;
            }
        }
        if (!(lVar instanceof com.tencent.mm.plugin.fingerprint.c.b)) {
            return false;
        }
        if (i2 == 0 && i == 0) {
            x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open success");
            com.tencent.mm.plugin.soter.c.a.bFe();
            com.tencent.mm.plugin.soter.c.a.c(0, 0, 0, "OK");
            ah(0, str);
        } else {
            x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: open");
            com.tencent.mm.plugin.soter.c.a.c(8, i, i2, "open fp pay failed");
            ah(-1, str);
        }
        return true;
    }

    private void ah(int i, String str) {
        x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: callback total");
        clear();
        this.jgE.af(i, str);
        this.jgE = null;
    }

    public final void a(a aVar, String str, int i) {
        x.i("MicroMsg.SoterFingerprintOpenDelegate", "hy: doOpenFP");
        this.jgE = aVar;
        com.tencent.d.a.c.i iVar = s.pqR.pqT;
        if (iVar == null) {
            x.e("MicroMsg.SoterFingerprintOpenDelegate", "hy: signature is null");
            com.tencent.mm.plugin.soter.c.a.c(9, -1000223, -1, "signature is null");
            ag(-1, ad.getContext().getString(i.fingerprint_open_fail));
        } else if (this.jgT != null && this.jgT.get() != null) {
            ((WalletBaseUI) this.jgT.get()).a(new com.tencent.mm.plugin.fingerprint.c.b(iVar.vlM, iVar.signature, this.eTo), true, true);
        }
    }
}
