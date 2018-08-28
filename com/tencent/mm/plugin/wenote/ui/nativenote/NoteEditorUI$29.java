package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.wenote.model.h;

class NoteEditorUI$29 implements Runnable {
    final /* synthetic */ Bitmap quD;
    final /* synthetic */ NoteEditorUI qur;

    NoteEditorUI$29(NoteEditorUI noteEditorUI, Bitmap bitmap) {
        this.qur = noteEditorUI;
        this.quD = bitmap;
    }

    public final void run() {
        h.a(this.qur.mController.tml, this.quD, NoteEditorUI.z(this.qur));
    }
}
