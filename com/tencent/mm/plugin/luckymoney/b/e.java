package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    d kLu;

    public e() {
        init();
    }

    private void init() {
        this.kLu = new d();
        g.Ek();
        String str = (String) g.Ei().DT().get(356355, null);
        if (bi.oW(str)) {
            this.kLu.kKT = 2000.0d;
            this.kLu.kKQ = 100;
            this.kLu.kKU = 200.0d;
            this.kLu.kKS = 0.01d;
            this.kLu.kKR = 200.0d;
        } else {
            try {
                this.kLu.aG(str.getBytes("ISO-8859-1"));
            } catch (Exception e) {
                x.w("MicroMsg.LuckyMoneyConfigManager", "parseConfig exp, " + e.getLocalizedMessage());
                this.kLu.kKT = 2000.0d;
                this.kLu.kKQ = 100;
                this.kLu.kKU = 200.0d;
                this.kLu.kKS = 0.01d;
                this.kLu.kKR = 200.0d;
            }
        }
        x.i("MicroMsg.LuckyMoneyConfigManager", "LuckyMoneyConfig init maxTotalAmount:" + this.kLu.kKT + " maxTotalNum:" + this.kLu.kKQ + " perGroupMaxValue:" + this.kLu.kKU + " perMinValue:" + this.kLu.kKS + " perPersonMaxValue:" + this.kLu.kKR);
    }

    public final d baS() {
        if (this.kLu == null) {
            init();
        }
        return this.kLu;
    }
}
