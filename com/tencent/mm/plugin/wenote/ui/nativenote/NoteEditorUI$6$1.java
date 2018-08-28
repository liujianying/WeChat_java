package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.6;
import com.tencent.mm.ui.widget.snackbar.b;

class NoteEditorUI$6$1 implements Runnable {
    final /* synthetic */ 6 qut;

    NoteEditorUI$6$1(6 6) {
        this.qut = 6;
    }

    public final void run() {
        this.qut.iYD.dismiss();
        b.h(this.qut.qur, this.qut.qur.getString(R.l.finish_sent));
    }
}
