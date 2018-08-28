package com.tencent.mm.plugin.wenote.ui.nativenote;

class NoteEditorUI$25 implements Runnable {
    final /* synthetic */ NoteEditorUI qur;

    NoteEditorUI$25(NoteEditorUI noteEditorUI) {
        this.qur = noteEditorUI;
    }

    public final void run() {
        if (NoteEditorUI.Z(this.qur) != null) {
            NoteEditorUI.Z(this.qur).dismiss();
            NoteEditorUI.aa(this.qur);
        }
    }
}
