package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class NoteEditorUI$30 implements OnMenuItemClickListener {
    final /* synthetic */ NoteEditorUI qur;

    NoteEditorUI$30(NoteEditorUI noteEditorUI) {
        this.qur = noteEditorUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (NoteEditorUI.H(this.qur)) {
            NoteEditorUI.I(this.qur);
            this.qur.finish();
        }
        return true;
    }
}
