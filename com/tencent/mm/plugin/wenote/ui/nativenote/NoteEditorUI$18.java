package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;

class NoteEditorUI$18 implements Runnable {
    final /* synthetic */ NoteEditorUI qur;

    NoteEditorUI$18(NoteEditorUI noteEditorUI) {
        this.qur = noteEditorUI;
    }

    public final void run() {
        WXRTEditText cai = NoteEditorUI.f(this.qur).cai();
        if (cai != null) {
            cai.clearFocus();
        }
    }
}
