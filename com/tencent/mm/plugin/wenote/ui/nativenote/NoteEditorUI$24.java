package com.tencent.mm.plugin.wenote.ui.nativenote;

class NoteEditorUI$24 implements Runnable {
    final /* synthetic */ int hW;
    final /* synthetic */ NoteEditorUI qur;

    NoteEditorUI$24(NoteEditorUI noteEditorUI, int i) {
        this.qur = noteEditorUI;
        this.hW = i;
    }

    public final void run() {
        NoteEditorUI.K(this.qur).bg(this.hW);
    }
}
