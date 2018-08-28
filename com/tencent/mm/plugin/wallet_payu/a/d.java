package com.tencent.mm.plugin.wallet_payu.a;

import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.wallet_payu.create.a.c;
import com.tencent.mm.plugin.wallet_payu.pwd.a.f;
import com.tencent.mm.plugin.wallet_payu.pwd.a.g;
import com.tencent.mm.plugin.wallet_payu.remittance.a.i;
import com.tencent.mm.wallet_core.a;
import java.util.HashMap;

public class d implements ar {
    public String pEW = null;
    private int pEX = -1;

    static {
        a.i("PayUOpenProcess", c.class);
        a.i("PayUBindProcess", com.tencent.mm.plugin.wallet_payu.bind.model.c.class);
        a.i("PayUForgotPwdProcess", f.class);
        a.i("PayUModifyPasswordProcess", g.class);
        a.i("PayURemittanceProcess", i.class);
        a.i("PayUShowOrderProcess", com.tencent.mm.plugin.wallet_payu.order.a.d.class);
    }

    public static d bRk() {
        return (d) p.v(d.class);
    }

    public final HashMap<Integer, com.tencent.mm.bt.h.d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
    }
}
