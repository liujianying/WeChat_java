package com.tencent.mm.wallet_core.d;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave;
import com.tencent.mm.wallet_core.tenpay.model.ITenpaySave.RetryPayInfo;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b implements e {
    static RetryPayInfo oYE;
    private j uXF;
    private int uXH = 0;
    e uXI;

    private boolean cDq() {
        if (this.uXH >= cDr()) {
            return false;
        }
        return true;
    }

    private static int cDr() {
        if (oYE == null || !oYE.cDx()) {
            return 0;
        }
        return oYE.uXT;
    }

    public b(e eVar) {
        this.uXI = eVar;
    }

    public final boolean d(j jVar) {
        int i = (oYE == null || !oYE.cDx()) ? 0 : oYE.uXS;
        int cDr = cDr();
        this.uXH++;
        if (this.uXH > cDr) {
            return false;
        }
        this.uXF = jVar;
        this.uXF.mxp = true;
        g.Ek();
        g.Eh().dpP.a(385, this);
        this.uXF.cDC();
        int i2 = this.uXH;
        int i3 = this.uXH >= cDr ? 1 : 0;
        Map hashMap = new HashMap();
        hashMap.put("retry_count", String.valueOf(i2));
        hashMap.put("is_last_retry", String.valueOf(i3));
        jVar.aB(hashMap);
        x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", new Object[]{Integer.valueOf(i), Integer.valueOf(cDr)});
        g.Ek();
        g.Eh().dpP.a(jVar, i);
        return true;
    }

    private void a(int i, int i2, String str, JSONObject jSONObject) {
        x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback errCode = " + i2 + "errType = " + i);
        if (this.uXF != null && jSONObject != null && i == 0 && i2 == 0) {
            x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mScene !=null");
            this.uXF.a(i2, str, jSONObject);
            this.uXI.a(i, i2, str, this.uXF);
        } else if (this.uXI != null) {
            x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback mRealCallback !=null");
            this.uXI.a(i, i2, str, this.uXF);
        }
        x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "doRealCallback reset");
        this.uXH = 0;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, lVar});
        if (lVar instanceof j) {
            if (lVar instanceof ITenpaySave) {
                RetryPayInfo bMO = ((ITenpaySave) lVar).bMO();
                if (bMO.cDx()) {
                    oYE = bMO;
                }
            }
            g.Ek();
            g.Eh().dpP.b(385, this);
            if (!((j) lVar).uYm) {
                return;
            }
            if (this.uXF.pgm) {
                x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess ok");
                a(i, i2, str, ((j) lVar).uYi);
            } else if (this.uXF.uYn && cDq()) {
                x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try isServerDelayQuery true svrcanRetry %s localCanRetry %s", new Object[]{Boolean.valueOf(this.uXF.uYn), Boolean.valueOf(cDq())});
                if (!d(this.uXF)) {
                    c(i, i2, lVar);
                }
            } else if (((j) lVar).uXm) {
                x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "try svr no resp");
                if (!d(this.uXF)) {
                    c(i, i2, lVar);
                }
            } else {
                x.i("MicroMsg.DelayQueryOrderSaveOrFetchHelper", "PaySuccess error %s", new Object[]{oYE.uXU});
                a(i, i2, r0, ((j) lVar).uYi);
            }
        }
    }

    private void c(int i, int i2, l lVar) {
        a(i, i2, oYE.uXU, ((j) lVar).uYi);
    }
}
