package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class NoteEditorUI$26 implements Runnable {
    final /* synthetic */ NoteEditorUI qur;

    NoteEditorUI$26(NoteEditorUI noteEditorUI) {
        this.qur = noteEditorUI;
    }

    public final void run() {
        h.b(this.qur.mController.tml, this.qur.getString(R.l.wenote_text_limit_tips), null, true);
    }
}
