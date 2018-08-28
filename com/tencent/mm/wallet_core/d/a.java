package com.tencent.mm.wallet_core.d;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.b;
import com.tencent.mm.wallet_core.tenpay.model.c;
import com.tencent.mm.wallet_core.tenpay.model.d;
import com.tencent.mm.wallet_core.tenpay.model.f;
import com.tencent.mm.wallet_core.tenpay.model.h;
import com.tencent.mm.wallet_core.tenpay.model.j;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a implements e {
    private j uXF;
    private f uXG;
    private int uXH = 0;
    e uXI;

    public a(e eVar) {
        this.uXI = eVar;
    }

    public final boolean a(j jVar) {
        int i = o.bOW().mRetryCount;
        x.i("MicroMsg.DelayQueryOrderHelper", " isServerDelayQuery %s mDelayQueryTime %s ", new Object[]{Boolean.valueOf(jVar.cDB()), Integer.valueOf(this.uXH)});
        if (!jVar.cDB() || this.uXH >= i) {
            return false;
        }
        return true;
    }

    public final void b(j jVar) {
        x.i("MicroMsg.DelayQueryOrderHelper", "startDelayScene");
        this.uXH = 0;
        c(jVar);
    }

    private void c(j jVar) {
        f fVar;
        boolean z;
        this.uXF = jVar;
        this.uXF.mxp = true;
        g.Ek();
        g.Eh().dpP.a(385, this);
        ag bOW = o.bOW();
        int i = bOW.prL > 0 ? bOW.prL : 10000;
        this.uXH++;
        Map cDA = this.uXF.cDA();
        String str = (String) cDA.get("req_key");
        if (bi.oW(str)) {
            x.i("MicroMsg.DelayQueryOrderHelper", "no reqKey");
            fVar = new f(cDA);
        } else {
            x.i("MicroMsg.DelayQueryOrderHelper", "payorder reqKey: %s", new Object[]{str});
            x.i("MicroMsg.DelayQueryOrderHelper", "delayquery go new split cgi");
            fVar = str.startsWith("sns_aa_") ? new b(cDA) : str.startsWith("sns_tf_") ? new h(cDA) : str.startsWith("sns_ff_") ? new c(cDA) : str.startsWith("ts_") ? new d(cDA) : str.startsWith("sns_") ? new com.tencent.mm.wallet_core.tenpay.model.g(cDA) : str.startsWith("offline_") ? new com.tencent.mm.wallet_core.tenpay.model.e(cDA) : new f(cDA);
        }
        this.uXG = fVar;
        this.uXG.uXY = true;
        int i2 = o.bOW().mRetryCount;
        f fVar2 = this.uXG;
        if (this.uXH >= i2) {
            z = true;
        } else {
            z = false;
        }
        int i3 = this.uXH;
        Map hashMap = new HashMap();
        hashMap.put("is_last_query", (z ? 1 : 0));
        hashMap.put("curr_query_count", String.valueOf(i3));
        fVar2.aB(hashMap);
        x.i("MicroMsg.DelayQueryOrderHelper", "doLoopDelayScene,delay = %s queryOrderCount %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        g.Ek();
        g.Eh().dpP.a(this.uXG, i);
    }

    private void a(int i, int i2, String str, JSONObject jSONObject) {
        x.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback errCode = " + i2 + "errType = " + i);
        if (this.uXF != null && jSONObject != null && i == 0 && i2 == 0) {
            x.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mScene !=null");
            this.uXF.a(i2, str, jSONObject);
            this.uXI.a(i, i2, str, this.uXF);
        } else if (this.uXI != null) {
            x.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback mRealCallback !=null");
            this.uXI.a(i, i2, str, this.uXF);
        }
        x.i("MicroMsg.DelayQueryOrderHelper", "doRealCallback reset");
        this.uXH = 0;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.DelayQueryOrderHelper", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, lVar});
        if ((lVar instanceof f) && this.uXG.equals(lVar)) {
            g.Ek();
            g.Eh().dpP.b(385, this);
            f fVar = (f) lVar;
            x.d("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder errType: %d, errCode: %d, errMsg: %s scene %s  errmsgtype %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, fVar, Integer.valueOf(fVar.uXX)});
            if (fVar.uXX == 1) {
                x.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step A");
                a(i, i2, str, fVar.cDy());
                return;
            }
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step B");
                if (fVar.uXX != 2) {
                    a(i, i2, str, fVar.cDy());
                    return;
                }
            } else if (!fVar.uXm) {
                x.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step C");
                x.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[]{o.bOW().prM});
            } else if (a(this.uXF)) {
                x.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D doLoopDelayScene");
                c(this.uXF);
                return;
            } else {
                x.i("MicroMsg.DelayQueryOrderHelper", "handlerLoopQueryOrder step D fail");
                if (fVar.uXX == 1) {
                    a(i, i2, str, fVar.cDy());
                    return;
                }
            }
            a(this.uXF.uYf, this.uXF.uYg, this.uXF.uYh, this.uXF.uYi);
        } else if ((lVar instanceof j) && this.uXF.equals(lVar)) {
            g.Ek();
            g.Eh().dpP.b(385, this);
            if (!((j) lVar).uYm) {
                return;
            }
            if (this.uXF.pgm) {
                x.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess ok");
                a(i, i2, str, ((j) lVar).uYi);
            } else if (this.uXF.cDB()) {
                x.i("MicroMsg.DelayQueryOrderHelper", "try isServerDelayQuery true");
                c(this.uXF);
            } else {
                x.i("MicroMsg.DelayQueryOrderHelper", "PaySuccess error %s", new Object[]{o.bOW().prM});
                a(i, i2, r0, ((j) lVar).uYi);
            }
        }
    }
}
