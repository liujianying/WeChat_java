package com.tencent.mm.plugin.aa;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.g.a.bo;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.ml;
import com.tencent.mm.g.a.mm;
import com.tencent.mm.g.a.th;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import java.util.HashMap;

public class b implements ar {
    private static HashMap<Integer, d> cVM;
    private c<mm> ezp = new 1(this);
    private c<ml> ezq = new 2(this);
    private c<bo> ezr = new 3(this);
    private c<bp> ezs = new 4(this);
    private n ezt = new 5(this);
    c<th> ezu = new 6(this);
    private com.tencent.mm.plugin.aa.a.b.d ezv;
    private com.tencent.mm.plugin.aa.a.b.b ezw;

    private static b VP() {
        return (b) p.v(b.class);
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("AARecord".hashCode()), new 7());
        cVM.put(Integer.valueOf("AAPayRecord".hashCode()), new 8());
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public static com.tencent.mm.plugin.aa.a.b.d VQ() {
        if (VP().ezv == null) {
            b VP = VP();
            g.Ek();
            VP.ezv = new com.tencent.mm.plugin.aa.a.b.d(g.Ei().dqq);
        }
        return VP().ezv;
    }

    public static com.tencent.mm.plugin.aa.a.b.b VR() {
        if (VP().ezw == null) {
            b VP = VP();
            g.Ek();
            VP.ezw = new com.tencent.mm.plugin.aa.a.b.b(g.Ei().dqq);
        }
        return VP().ezw;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        a.sFg.b(this.ezp);
        a.sFg.b(this.ezq);
        a.sFg.b(this.ezr);
        a.sFg.b(this.ezs);
        a.sFg.b(this.ezu);
        ((o) g.n(o.class)).getSysCmdMsgExtension().a("paymsg", this.ezt);
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        a.sFg.c(this.ezp);
        a.sFg.c(this.ezq);
        a.sFg.c(this.ezr);
        a.sFg.c(this.ezs);
        a.sFg.c(this.ezu);
        ((o) g.n(o.class)).getSysCmdMsgExtension().b("paymsg", this.ezt);
    }
}
