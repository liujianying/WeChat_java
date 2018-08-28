package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import com.tencent.mm.g.a.cp;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.e.c.1;
import com.tencent.mm.plugin.emoji.e.c.2;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class b$5 extends c<cp> {
    final /* synthetic */ b ifh;

    b$5(b bVar) {
        this.ifh = bVar;
        this.sFo = cp.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cp cpVar = (cp) bVar;
        c aDJ = c.aDJ();
        if (cpVar != null && (cpVar instanceof cp)) {
            cpVar = cpVar;
            switch (cpVar.bKa.scene) {
                case 0:
                    au.Em().H(new 1(aDJ, cpVar.bKa.bKb));
                    break;
                case 1:
                    Context context = cpVar.bKa.context;
                    au.Em().H(new 2(aDJ, cpVar.bKa.bKb, context));
                    break;
            }
        }
        return false;
    }
}
