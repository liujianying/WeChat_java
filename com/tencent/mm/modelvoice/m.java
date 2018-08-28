package com.tencent.mm.modelvoice;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.e.b.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.by;
import java.util.HashMap;
import junit.framework.Assert;

public class m implements ar {
    private static HashMap<Integer, d> cVM;
    private u epC;
    private by epD;
    private i epE;
    private r epF = new r();
    private c epG = new 1(this);

    private static m TH() {
        return (m) p.v(m.class);
    }

    public static u TI() {
        g.Eg().Ds();
        if (TH().epC == null) {
            Assert.assertTrue("dataDB is null ", g.Ei().dqq != null);
            TH().epC = new u(g.Ei().dqq);
        }
        return TH().epC;
    }

    public static by TJ() {
        g.Eg().Ds();
        if (TH().epD == null) {
            Assert.assertTrue("dataDB is null ", g.Ei().dqq != null);
            TH().epD = new by(g.Ei().dqq);
        }
        return TH().epD;
    }

    public static i TK() {
        g.Eg().Ds();
        if (TH().epE == null) {
            TH().epE = new i();
        }
        return TH().epE;
    }

    public final void onAccountRelease() {
        if (TH().epE != null) {
            TH().epE.bFj = 0;
        }
        com.tencent.mm.ab.d.c.b(Integer.valueOf(34), this.epF);
        a.sFg.c(this.epG);
        b.D(new String[]{"//voicetrymore"});
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("VOICE_TABLE".hashCode()), new 2());
        cVM.put(Integer.valueOf("VOICETRANSTEXT_TABLE".hashCode()), new 3());
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        com.tencent.mm.ab.d.c.a(Integer.valueOf(34), this.epF);
        a.sFg.b(this.epG);
        b.a(new a(), new String[]{"//voicetrymore"});
    }

    public final void bo(boolean z) {
    }
}
