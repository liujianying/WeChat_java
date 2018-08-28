package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.jt;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class ac$1 extends c<jt> {
    final /* synthetic */ ac nOP;

    ac$1(ac acVar) {
        this.nOP = acVar;
        this.sFo = jt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        switch (((jt) bVar).bTE.action) {
            case 0:
            case 1:
                this.nOP.nON.setImageResource(e.music_pauseicon);
                break;
            case 2:
            case 3:
            case 4:
                this.nOP.nON.setImageResource(e.music_playicon);
                break;
        }
        return false;
    }
}
