package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.jt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class av$9 extends c<jt> {
    final /* synthetic */ av ocj;

    av$9(av avVar) {
        this.ocj = avVar;
        this.sFo = jt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        jt jtVar = (jt) bVar;
        if (jtVar instanceof jt) {
            switch (jtVar.bTE.action) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                    this.ocj.obU.notifyDataSetChanged();
                    break;
            }
        }
        return false;
    }
}
