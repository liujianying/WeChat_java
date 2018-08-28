package com.tencent.mm.plugin.freewifi.d;

import android.os.Build;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.protocal.c.ast;
import com.tencent.mm.protocal.c.asu;
import com.tencent.mm.protocal.c.asv;
import java.util.LinkedList;

public final class j extends c {
    protected final void aOR() {
        a aVar = new a();
        aVar.dIG = new ast();
        aVar.dIH = new asu();
        aVar.uri = "/cgi-bin/mmo2o-bin/manufacturerapinfo";
        aVar.dIF = 1707;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int getType() {
        return 1707;
    }

    public j(LinkedList<asv> linkedList, int i) {
        aOR();
        ast ast = (ast) this.diG.dID.dIL;
        ast.rVc = Build.BRAND;
        ast.rVb = i;
        ast.rVa = linkedList;
    }

    public final asu aPe() {
        return (asu) this.diG.dIE.dIL;
    }
}
