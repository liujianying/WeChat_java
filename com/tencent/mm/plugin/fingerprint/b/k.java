package com.tencent.mm.plugin.fingerprint.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.d.a.c.i;
import com.tencent.d.b.a.e;
import com.tencent.d.b.c.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.lg;
import com.tencent.mm.plugin.soter.d.b;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k extends a {
    private l jgP = null;
    private a jgQ = null;

    public final boolean aNh() {
        boolean z;
        if (q.deQ.deZ == 1) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.SoterAuthMgrImp", "hy: config support: %b, device support: %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(com.tencent.d.b.a.cFN())});
        return z && com.tencent.d.b.a.cFN();
    }

    public final boolean aNi() {
        return com.tencent.d.a.a.hz(ad.getContext());
    }

    public final void aNj() {
        x.i("MicroMsg.SoterAuthMgrImp", "hy: soter init fp. Do nothing?? Prepare ASK??");
        e.fc(true);
        e.fb(true);
        b.a(false, false, null);
    }

    public final boolean aNl() {
        return false;
    }

    public final void di(Context context) {
        x.i("MicroMsg.SoterAuthMgrImp", "hy: start startRigesterSysFP");
    }

    public final boolean aNm() {
        return aNh();
    }

    @TargetApi(16)
    public final int a(final c cVar, boolean z) {
        if (z) {
            x.i("MicroMsg.SoterAuthMgrImp", "hy: req restart after fail, but no need");
        } else {
            1 1 = new 1(this, cVar);
            this.jgQ = new a();
            com.tencent.d.b.a.a(new com.tencent.d.b.a.b<com.tencent.d.b.a.a>() {
                public final /* synthetic */ void a(e eVar) {
                    com.tencent.d.b.a.a aVar = (com.tencent.d.b.a.a) eVar;
                    x.i("MicroMsg.SoterAuthMgrImp", "alvinluo requestAuthAndSign onResult errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(aVar.errCode), aVar.Yy});
                    if (aVar.isSuccess()) {
                        s.pqR.pqT = (i) aVar.vlN;
                        if (cVar != null) {
                            cVar.aK(0, -1);
                            return;
                        }
                        return;
                    }
                    com.tencent.mm.plugin.soter.c.a.dL(3, aVar.errCode);
                    if (aVar.errCode == 13) {
                        x.i("MicroMsg.SoterAuthMgrImp", "hy: init error, maybe key invalid. remove former key and give suggestion");
                        com.tencent.d.a.a.bD(e.aNu(), true);
                        if (cVar != null) {
                            cVar.aK(2007, -1);
                        }
                    } else if (aVar.errCode == 25) {
                        x.i("MicroMsg.SoterAuthMgrImp", "hy: too many trial");
                        if (cVar != null) {
                            cVar.aK(10308, -1);
                        }
                    } else if (aVar.errCode == 24) {
                        x.i("MicroMsg.SoterAuthMgrImp", "alvinluo user cancelled");
                        if (cVar != null) {
                            cVar.aK(2000, -1);
                        }
                    } else if (aVar.errCode == 26) {
                        x.e("MicroMsg.SoterAuthMgrImp", "alvinluo add authenticate task failed");
                        if (cVar != null) {
                            cVar.aK(2009, -1);
                        }
                    } else if (cVar != null) {
                        cVar.aK(2005, -1);
                    }
                }
            }, new com.tencent.d.b.f.b.a().Hq(1).hK(ad.getContext()).a(this.jgQ).acG(s.pqR.jgX).a(1).vml);
        }
        return 0;
    }

    @SuppressLint({"NewApi"})
    public final void aNn() {
        x.i("MicroMsg.SoterAuthMgrImp", "hy: do nothing in system release");
    }

    @SuppressLint({"NewApi"})
    public final void aNo() {
        x.i("MicroMsg.SoterAuthMgrImp", "hy: do nothing in system release");
    }

    public final void a(lg lgVar, int i) {
        x.i("MicroMsg.SoterAuthMgrImp", "hy: soter onOpenFingerprintAuthSuccess");
        lgVar.bVA.bVE = aNE();
        lgVar.bVA.errCode = !bi.oW(lgVar.bVA.bVE) ? 0 : 1;
        lgVar.bVA.bVF = 2;
        lgVar.bVA.bQb = "";
        lgVar.bVA.bQc = "";
        if (lgVar.bVz.bVD != null) {
            lgVar.bVz.bVD.run();
        }
    }

    private static String aNE() {
        i iVar = s.pqR.pqT;
        if (iVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("json", iVar.vlM);
                jSONObject.put("signature", iVar.signature);
                return jSONObject.toString();
            } catch (Throwable e) {
                x.e("MicroMsg.SoterAuthMgrImp", "hy: error when convert to json: %s", new Object[]{e.toString()});
                x.printErrStackTrace("MicroMsg.SoterAuthMgrImp", e, "", new Object[0]);
                return "";
            }
        }
        x.e("MicroMsg.SoterAuthMgrImp", "hy: signature result is null");
        return "";
    }

    public final void aNp() {
        if (com.tencent.d.a.a.acz(e.aNu())) {
            com.tencent.d.a.a.bD(e.aNu(), false);
        }
    }

    public final j aNg() {
        this.jgP = new l();
        return this.jgP;
    }

    public final Map<String, String> aNq() {
        Map<String, String> hashMap = new HashMap();
        com.tencent.mm.plugin.soter.c.c bFh = com.tencent.mm.plugin.soter.c.b.bFh();
        String str = bFh.onE;
        String str2 = bFh.onF;
        hashMap.put("cpu_id", str);
        hashMap.put("uid", str2);
        return hashMap;
    }

    public final com.tencent.mm.pluginsdk.wallet.k aNr() {
        return new m();
    }

    public final Map<String, String> aNs() {
        return aNq();
    }

    public final boolean aNt() {
        boolean cFC = com.tencent.d.a.a.cFC();
        boolean acz = com.tencent.d.a.a.acz(e.aNu());
        boolean acA = com.tencent.d.a.a.acA(e.aNu());
        x.v("MicroMsg.SoterAuthMgrImp", "hasAsk: %b, hasAuthKey: %b, isAuthKeyValid: %b", new Object[]{Boolean.valueOf(cFC), Boolean.valueOf(acz), Boolean.valueOf(acA)});
        if (!(com.tencent.d.a.a.cFC() && com.tencent.d.a.a.acz(e.aNu()) && com.tencent.d.a.a.acA(e.aNu()))) {
            x.i("MicroMsg.SoterAuthMgrImp", "hy: no ask or auth key");
            s.pqR.jgY = true;
        }
        if (s.pqR.jgY) {
            return false;
        }
        return true;
    }

    public final boolean a(boolean z, boolean z2, Bundle bundle) {
        x.i("MicroMsg.SoterAuthMgrImp", "hy: post pay. is fingerprint pay: %b, is pay ok: %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (!z) {
            String string = bundle.getString("pwd");
            if (bi.oW(string)) {
                x.e("MicroMsg.SoterAuthMgrImp", "hy: no pwd. can not change auth key");
            } else if (s.pqR.jgY) {
                x.i("MicroMsg.SoterAuthMgrImp", "hy: need change auth key. start gen auth key");
                com.tencent.d.b.a.a(new 3(this), true, 1, new com.tencent.mm.plugin.fingerprint.c.c(string), new com.tencent.mm.plugin.soter.b.e());
            }
        }
        return false;
    }

    public final boolean aNc() {
        return com.tencent.d.a.a.hA(ad.getContext());
    }

    public final void aNe() {
        if (this.jgQ != null && VERSION.SDK_INT >= 16) {
            x.i("MicroMsg.SoterAuthMgrImp", "alvinluo cancel fingeprint canceller");
            this.jgQ.mR(true);
            if (com.tencent.mm.plugin.soter.c.a.bFg()) {
                com.tencent.mm.plugin.soter.c.a.c(1, -1000223, -1, "user cancelled");
            }
        }
    }

    public final int type() {
        return 2;
    }
}
