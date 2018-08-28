package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class NoteEditorUI$8 implements OnCancelListener {
    final /* synthetic */ NoteEditorUI qur;

    NoteEditorUI$8(NoteEditorUI noteEditorUI) {
        this.qur = noteEditorUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (NoteEditorUI.Z(this.qur) != null) {
            NoteEditorUI.Z(this.qur).dismiss();
            NoteEditorUI.aa(this.qur);
        }
    }
}
