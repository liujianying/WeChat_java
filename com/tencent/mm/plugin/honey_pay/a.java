package com.tencent.mm.plugin.honey_pay;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.by.h;
import com.tencent.mm.g.a.mn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.honey_pay.model.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.b.c;
import java.util.HashMap;

public class a implements ar {
    private static HashMap<Integer, d> cVM;
    private h<b> kjw = new h(new 2(this));
    private c<mn> kjx = new 3(this);
    private n kjy = new 4(this);

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("HoneyPayMsgRecord".hashCode()), new 1());
    }

    public static a aWa() {
        return (a) p.v(a.class);
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public final void bo(boolean z) {
    }

    public final void bn(boolean z) {
        this.kjx.cht();
        ((o) g.n(o.class)).getSysCmdMsgExtension().a("paymsg", this.kjy);
    }

    public final void onAccountRelease() {
        this.kjx.dead();
        ((o) g.n(o.class)).getSysCmdMsgExtension().b("paymsg", this.kjy);
    }

    public final b aWb() {
        return (b) this.kjw.get();
    }
}
