package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class NoteEditorUI$27 implements OnClickListener {
    final /* synthetic */ NoteEditorUI qur;

    NoteEditorUI$27(NoteEditorUI noteEditorUI) {
        this.qur = noteEditorUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.qur.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
