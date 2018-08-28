package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONObject;

public final class b extends e {
    private boolean pfj = false;
    private boolean pfk;

    public final int aBO() {
        return 121;
    }

    public b(p pVar, Orders orders) {
        super(pVar, orders);
        bNw();
    }

    private void bNw() {
        this.pfj = false;
        com.tencent.mm.plugin.wallet.a.p.bNp();
        if (!(com.tencent.mm.plugin.wallet.a.p.bNq().prG == null || this.pfq.mpb == null)) {
            String str = this.pfq.lMV;
            com.tencent.mm.plugin.wallet.a.p.bNp();
            if (str.equals(com.tencent.mm.plugin.wallet.a.p.bNq().prG.field_bankcardType)) {
                if (this.pfq.mpb.bVY == 31 || this.pfq.mpb.bVY == 32 || this.pfq.mpb.bVY == 33 || this.pfq.mpb.bVY == 42 || this.pfq.mpb.bVY == 37) {
                    this.pfj = true;
                } else {
                    this.pfk = true;
                }
            }
        }
        x.i("MicroMsg.NetSceneTenpayPayVertify", "isLqtSns: %s, isLqtTs: %s", new Object[]{Boolean.valueOf(this.pfj), Boolean.valueOf(this.pfk)});
    }

    protected final void Q(Map<String, String> map) {
        bNw();
        if (this.pfj || this.pfk) {
            map.put("busi_scene", this.pfq.lMV);
        }
    }

    public final int If() {
        bNw();
        if (this.pfj) {
            return 1281;
        }
        if (this.pfk) {
            return 1305;
        }
        return 1601;
    }

    public final String getUri() {
        bNw();
        if (this.pfj) {
            return "/cgi-bin/mmpay-bin/tenpay/snslqtpaybindverify";
        }
        if (this.pfk) {
            return "/cgi-bin/mmpay-bin/tenpay/lqtpaybindverify";
        }
        return "/cgi-bin/mmpay-bin/tenpay/banpaybindverify";
    }

    public final int a(e eVar, com.tencent.mm.ab.e eVar2) {
        if (this.pfj) {
            h.mEJ.a(663, 26, 1, false);
        } else if (this.pfk) {
            h.mEJ.a(663, 22, 1, false);
        }
        return super.a(eVar, eVar2);
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        super.a(i, str, jSONObject);
        if (i == 0) {
            return;
        }
        if (this.pfj) {
            h.mEJ.a(663, 27, 1, false);
        } else if (this.pfk) {
            h.mEJ.a(663, 23, 1, false);
        }
    }
}
