package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Dialog;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.snackbar.b;

class NoteEditorUI$13 implements Runnable {
    final /* synthetic */ Dialog iYD;
    final /* synthetic */ NoteEditorUI qur;

    NoteEditorUI$13(NoteEditorUI noteEditorUI, Dialog dialog) {
        this.qur = noteEditorUI;
        this.iYD = dialog;
    }

    public final void run() {
        this.iYD.dismiss();
        b.h(this.qur, this.qur.getString(R.l.finish_sent));
    }
}
