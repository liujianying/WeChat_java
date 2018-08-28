package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.protocal.c.auq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.net.URLDecoder;
import org.json.JSONObject;

public final class ae extends i {
    private long eiD;
    public String pjJ;
    public String pjK;
    public String pjL;
    public String pjM;
    public String pjN;
    public int pjO;
    public int pjP;

    public ae() {
        F(null);
    }

    public final int aBO() {
        return 0;
    }

    public final int If() {
        return 1992;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/gettransferwording";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneTransferWording", "errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), str});
        x.d("MicroMsg.NetSceneTransferWording", "json: %s", new Object[]{jSONObject});
        this.pjJ = jSONObject.optString("delay_confirm_wording");
        this.pjK = jSONObject.optString("delay_confirm_switch_wording");
        this.pjL = jSONObject.optString("delay_confirm_switch_remind_wording");
        this.pjM = jSONObject.optString("delay_confirm_desc_url");
        this.pjO = jSONObject.optInt("delay_confirm_desc_url_flag", 0);
        this.eiD = jSONObject.optLong("expire_time", 0) * 1000;
        this.pjP = jSONObject.optInt("delay_confirm_switch_flag", 0);
        g.Ek();
        com.tencent.mm.storage.x DT = g.Ei().DT();
        if (!bi.oW(this.pjJ)) {
            DT.a(a.sVi, this.pjJ);
        }
        if (!bi.oW(this.pjK)) {
            DT.a(a.sVj, this.pjK);
        }
        if (!bi.oW(this.pjL)) {
            DT.a(a.sVk, this.pjL);
        }
        if (!bi.oW(this.pjM)) {
            try {
                this.pjN = URLDecoder.decode(this.pjM, "UTF-8");
                if (!bi.oW(this.pjN)) {
                    DT.a(a.sVm, this.pjN);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneTransferWording", e, "", new Object[0]);
            }
        }
        DT.a(a.sVn, Integer.valueOf(this.pjO));
        DT.a(a.sVl, Long.valueOf(this.eiD));
        DT.a(a.sVo, Integer.valueOf(this.pjP));
        if (this.pjP == 0) {
            x.i("MicroMsg.NetSceneTransferWording", "do reset oplog");
            auq auq = new auq();
            auq.mEc = 0;
            ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FQ().b(new h.a(205, auq));
            DT.set(147457, Long.valueOf((((Long) DT.get(147457, Long.valueOf(0))).longValue() & -17) & -33));
        }
    }

    public static boolean a(boolean z, com.tencent.mm.wallet_core.d.i iVar) {
        g.Ek();
        long longValue = ((Long) g.Ei().DT().get(a.sVl, Long.valueOf(0))).longValue();
        if (z || longValue < System.currentTimeMillis()) {
            x.i("MicroMsg.NetSceneTransferWording", "do scene: %d, force: %B", new Object[]{Long.valueOf(longValue), Boolean.valueOf(z)});
            if (iVar != null) {
                iVar.a(new ae(), false, 1);
            } else {
                g.Ek();
                g.Eh().dpP.a(new ae(), 0);
            }
            return true;
        }
        x.d("MicroMsg.NetSceneTransferWording", "not time");
        return false;
    }

    public final boolean bkU() {
        return false;
    }
}
