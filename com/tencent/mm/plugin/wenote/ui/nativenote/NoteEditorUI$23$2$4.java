package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.mm.plugin.wenote.model.a.a;
import com.tencent.mm.plugin.wenote.model.h;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23.2;

class NoteEditorUI$23$2$4 implements Runnable {
    final /* synthetic */ 2 quA;

    NoteEditorUI$23$2$4(2 2) {
        this.quA = 2;
    }

    public final void run() {
        this.quA.quz.qur.qtF.cal();
        a aVar = new a();
        aVar.qoH = false;
        aVar.qoN = false;
        c.bZD().a(aVar);
        int i = this.quA.quz.qur.qtF.qrC;
        this.quA.quz.qur.qtF.qrC = 3;
        h.Bn(i);
    }
}
