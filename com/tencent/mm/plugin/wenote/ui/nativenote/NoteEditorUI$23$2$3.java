package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23.2;

class NoteEditorUI$23$2$3 implements OnCancelListener {
    final /* synthetic */ 2 quA;

    NoteEditorUI$23$2$3(2 2) {
        this.quA = 2;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.quA.quz.qur.iBL != null) {
            this.quA.quz.qur.iBL.dismiss();
            this.quA.quz.qur.iBL = null;
        }
    }
}
