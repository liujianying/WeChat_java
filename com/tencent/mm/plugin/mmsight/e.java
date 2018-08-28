package com.tencent.mm.plugin.mmsight;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.x$a;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.m;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public class e implements ar {
    private m lew = new m();
    private c lex = new 1(this);
    private c ley = new 2(this);

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        x$a Tf = o.Tf();
        m mVar = this.lew;
        x.l("MicroMsg.VideoService", "addVideoMsgSendCallback %s", new Object[]{mVar});
        if (!(mVar == null || Tf.eou == null || Tf.eou.contains(mVar))) {
            Tf.eou.add(mVar);
        }
        a.sFg.a(this.ley);
        a.sFg.b(this.lex);
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        x$a Tf = o.Tf();
        m mVar = this.lew;
        if (!(mVar == null || Tf.eou == null)) {
            Tf.eou.remove(mVar);
        }
        a.sFg.c(this.ley);
        j.lin.Fm();
        a.sFg.c(this.lex);
    }
}
