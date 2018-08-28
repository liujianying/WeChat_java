package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class NoteEditorUI$12 implements OnCancelListener {
    final /* synthetic */ NoteEditorUI qur;

    NoteEditorUI$12(NoteEditorUI noteEditorUI) {
        this.qur = noteEditorUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (NoteEditorUI.c(this.qur) != null) {
            NoteEditorUI.c(this.qur).dismiss();
            NoteEditorUI.a(this.qur, null);
        }
    }
}
