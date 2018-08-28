package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23.2.1;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p;

class NoteEditorUI$23$2$1$1 implements Runnable {
    final /* synthetic */ p jcG;
    final /* synthetic */ 1 quB;

    NoteEditorUI$23$2$1$1(1 1, p pVar) {
        this.quB = 1;
        this.jcG = pVar;
    }

    public final void run() {
        NoteEditorUI.j(this.quB.quA.quz.qur).iVR = true;
        this.jcG.dismiss();
        x.d("MicroMsg.Note.NoteEditorUI", "do del, local id %d", new Object[]{Long.valueOf(NoteEditorUI.g(this.quB.quA.quz.qur))});
        this.quB.quA.quz.qur.finish();
    }
}
