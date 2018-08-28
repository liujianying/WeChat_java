package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.View;
import android.view.View.OnClickListener;

class NoteEditorUI$1 implements OnClickListener {
    final /* synthetic */ NoteEditorUI qur;

    NoteEditorUI$1(NoteEditorUI noteEditorUI) {
        this.qur = noteEditorUI;
    }

    public final void onClick(View view) {
        if (NoteEditorUI.a(this.qur) != null) {
            NoteEditorUI.a(this.qur).qqu.dismiss();
        }
        NoteEditorUI.b(this.qur).setVisibility(8);
    }
}
