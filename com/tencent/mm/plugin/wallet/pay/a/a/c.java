package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONObject;

public final class c extends b {
    private boolean pfj;
    private boolean pfk;
    private boolean pfl;

    public c(Authen authen, Orders orders, boolean z) {
        super(authen, orders);
        this.pfl = z;
        bNw();
    }

    private void bNw() {
        this.pfj = false;
        p.bNp();
        if (!(p.bNq().prG == null || this.pfc.mpb == null || this.pfl)) {
            if (this.pfc.mpb.bVY == 31 || this.pfc.mpb.bVY == 32 || this.pfc.mpb.bVY == 33 || this.pfc.mpb.bVY == 42 || this.pfc.mpb.bVY == 37) {
                this.pfj = true;
            } else {
                this.pfk = true;
            }
        }
        x.i("MicroMsg.NetSceneTenpayBalanceBindAuthen", "isLqtSns: %s, isLqtTs: %s, isBalance: %s", new Object[]{Boolean.valueOf(this.pfj), Boolean.valueOf(this.pfk), Boolean.valueOf(this.pfl)});
    }

    protected final void Q(Map<String, String> map) {
        bNw();
        if (this.pfj || this.pfk) {
            map.put("busi_scene", this.pfc.lMV);
        }
    }

    public final int aBO() {
        return 120;
    }

    public final String getUri() {
        bNw();
        if (this.pfj) {
            return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindauthen";
        }
        if (this.pfk) {
            return "/cgi-bin/mmpay-bin/tenpay/lqtpaybindauthen";
        }
        return "/cgi-bin/mmpay-bin/tenpay/banpaybindauthen";
    }

    public final int If() {
        bNw();
        if (this.pfj) {
            return 1274;
        }
        if (this.pfk) {
            return 1259;
        }
        return 1600;
    }

    public final int a(e eVar, com.tencent.mm.ab.e eVar2) {
        if (this.pfj) {
            h.mEJ.a(663, 24, 1, false);
        } else if (this.pfk) {
            h.mEJ.a(663, 20, 1, false);
        }
        return super.a(eVar, eVar2);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        if (i == 0) {
            return;
        }
        if (this.pfj) {
            h.mEJ.a(663, 25, 1, false);
        } else if (this.pfk) {
            h.mEJ.a(663, 21, 1, false);
        }
    }
}
