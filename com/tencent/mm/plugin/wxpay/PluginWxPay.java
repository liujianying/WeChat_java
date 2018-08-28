package com.tencent.mm.plugin.wxpay;

import com.tencent.mm.bg.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.aa.b;
import com.tencent.mm.plugin.mall.a.d;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.a;

public class PluginWxPay extends f implements a {
    public String name() {
        return "plugin-wxpay";
    }

    public void installed() {
        alias(a.class);
    }

    public void dependency() {
    }

    public void configure(g gVar) {
        if (gVar.ES()) {
            pin(new p(b.class));
            pin(new p(com.tencent.mm.plugin.collect.a.a.class));
            pin(new p(com.tencent.mm.plugin.luckymoney.a.a.class));
            pin(new p(d.class));
            pin(new p(k.class));
            pin(new p(com.tencent.mm.plugin.order.a.b.class));
            pin(new p(com.tencent.mm.plugin.product.a.a.class));
            pin(new p(com.tencent.mm.plugin.recharge.a.a.class));
            pin(new p(com.tencent.mm.plugin.remittance.a.b.class));
            pin(new p(com.tencent.mm.plugin.wallet.a.p.class));
            pin(new p(o.class));
            pin(new p(com.tencent.mm.plugin.wallet_index.a.a.class));
            pin(new p(com.tencent.mm.plugin.wallet_payu.a.d.class));
            pin(new p(com.tencent.mm.plugin.wxcredit.a.class));
            pin(new p(com.tencent.mm.plugin.fingerprint.a.class));
            pin(new p(com.tencent.mm.plugin.wallet_ecard.a.class));
            pin(new p(com.tencent.mm.plugin.honey_pay.a.class));
        }
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.luckymoney.appbrand.a.class, new e(new com.tencent.mm.plugin.luckymoney.appbrand.b()));
    }

    public void execute(g gVar) {
        if (gVar.ES()) {
            c.Um("wallet");
            c.Um("mall");
            c.Um("wxcredit");
            c.Um("offline");
            c.Um("recharge");
            c.Um("wallet_index");
            c.Um("order");
            c.Um("product");
            c.Um("remittance");
            c.Um("collect");
            c.Um("wallet_payu");
            c.Um("luckymoney");
            c.Um("fingerprint");
        }
    }
}
