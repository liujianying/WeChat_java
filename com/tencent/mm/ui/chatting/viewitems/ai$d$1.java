package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.viewitems.ai.d;
import java.lang.ref.WeakReference;

class ai$d$1 implements Runnable {
    final /* synthetic */ r tWJ;

    ai$d$1(r rVar) {
        this.tWJ = rVar;
    }

    public final void run() {
        WeakReference weakReference = (WeakReference) d.ajb().get(this.tWJ.getFileName());
        if (weakReference == null) {
            x.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder not found", new Object[]{this.tWJ.getFileName()});
            return;
        }
        d dVar = (d) weakReference.get();
        if (dVar == null) {
            x.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder gc!", new Object[]{this.tWJ.getFileName()});
            return;
        }
        dVar.tZR.setVisibility(8);
        dVar.nEI.setVisibility(8);
        dVar.uex.setVisibility(0);
        int i = this.tWJ.status;
        x.i("MicroMsg.VideoItemHoder", "updateStatus videoStatus : " + i);
        if (i == 112 || i == 122 || i == 120) {
            dVar.uex.setProgress(t.f(this.tWJ));
        } else {
            dVar.uex.setProgress(t.g(this.tWJ));
        }
    }
}
