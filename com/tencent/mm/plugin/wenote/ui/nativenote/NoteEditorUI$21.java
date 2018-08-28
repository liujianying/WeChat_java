package com.tencent.mm.plugin.wenote.ui.nativenote;

class NoteEditorUI$21 implements Runnable {
    final /* synthetic */ NoteEditorUI qur;
    final /* synthetic */ int quy;

    NoteEditorUI$21(NoteEditorUI noteEditorUI, int i) {
        this.qur = noteEditorUI;
        this.quy = i;
    }

    public final void run() {
        switch (this.quy) {
            case 0:
                NoteEditorUI.ac(this.qur).setVisibility(8);
                if (NoteEditorUI.e(this.qur).quS) {
                    NoteEditorUI.M(this.qur).setVisibility(0);
                    return;
                } else {
                    NoteEditorUI.M(this.qur).setVisibility(8);
                    return;
                }
            case 1:
                NoteEditorUI.M(this.qur).setVisibility(0);
                NoteEditorUI.ac(this.qur).setVisibility(8);
                return;
            case 2:
                NoteEditorUI.M(this.qur).setVisibility(0);
                NoteEditorUI.ac(this.qur).setVisibility(8);
                return;
            case 3:
                NoteEditorUI.M(this.qur).setVisibility(0);
                NoteEditorUI.ac(this.qur).setVisibility(0);
                return;
            default:
                return;
        }
    }
}
