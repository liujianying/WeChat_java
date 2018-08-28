package com.tencent.mm.plugin.wenote.ui.nativenote;

class NoteEditorUI$34 implements Runnable {
    final /* synthetic */ String qhJ;
    final /* synthetic */ NoteEditorUI qur;

    NoteEditorUI$34(NoteEditorUI noteEditorUI, String str) {
        this.qur = noteEditorUI;
        this.qhJ = str;
    }

    public final void run() {
        this.qur.bj(this.qhJ, false);
    }
}
