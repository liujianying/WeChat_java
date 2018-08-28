package com.tencent.mm.plugin.wenote.ui.nativenote;

class NoteEditorUI$20 implements Runnable {
    final /* synthetic */ NoteEditorUI qur;
    final /* synthetic */ boolean qux;

    NoteEditorUI$20(NoteEditorUI noteEditorUI, boolean z) {
        this.qur = noteEditorUI;
        this.qux = z;
    }

    public final void run() {
        if (this.qux && !NoteEditorUI.L(this.qur)) {
            this.qur.showVKB();
        } else if (!this.qux && NoteEditorUI.L(this.qur)) {
            this.qur.YC();
        }
    }
}
