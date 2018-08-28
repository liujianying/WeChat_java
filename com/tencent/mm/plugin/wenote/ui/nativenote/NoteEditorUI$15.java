package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.d;

class NoteEditorUI$15 implements OnCancelListener {
    final /* synthetic */ NoteEditorUI qur;
    final /* synthetic */ d quv;
    final /* synthetic */ j quw;

    NoteEditorUI$15(NoteEditorUI noteEditorUI, d dVar, j jVar) {
        this.qur = noteEditorUI;
        this.quv = dVar;
        this.quw = jVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        d dVar = this.quv;
        dVar.isStop = true;
        dVar.interrupt();
        this.quw.qoU = true;
        this.qur.e(true, 100);
        this.qur.Q(1, 0);
    }
}
