package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements Runnable {
    final /* synthetic */ b hBo;

    b$1(b bVar) {
        this.hBo = bVar;
    }

    public final void run() {
        x.i("MicroMsg.CardAcitivityLifecycleListener", "CardAcitivityLifecycleListener on activity from background to foreground！doUpdateOfflineDynamicCard!");
        am.axy().a(q.hIQ);
    }
}
