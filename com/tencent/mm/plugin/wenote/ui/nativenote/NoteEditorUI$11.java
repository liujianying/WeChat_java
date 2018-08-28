package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.widget.Toast;
import com.tencent.mm.R;

class NoteEditorUI$11 implements Runnable {
    final /* synthetic */ NoteEditorUI qur;

    NoteEditorUI$11(NoteEditorUI noteEditorUI) {
        this.qur = noteEditorUI;
    }

    public final void run() {
        Toast.makeText(this.qur, this.qur.getString(R.l.share_ok), 0).show();
    }
}
