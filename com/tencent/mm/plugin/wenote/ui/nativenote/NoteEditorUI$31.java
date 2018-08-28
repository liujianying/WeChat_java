package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class NoteEditorUI$31 implements OnGlobalLayoutListener {
    final /* synthetic */ NoteEditorUI qur;

    NoteEditorUI$31(NoteEditorUI noteEditorUI) {
        this.qur = noteEditorUI;
    }

    public final void onGlobalLayout() {
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.Note.NoteEditorUI", "startnoteeditorui, onGlobalLayout, current time is %d,from oncreate to dataloading, cost %d", new Object[]{Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - NoteEditorUI.J(this.qur))});
        ah Em = au.Em();
        1 1 = new 1(this);
        if (NoteEditorUI.d(this.qur) == 1) {
            currentTimeMillis = 100;
        } else {
            currentTimeMillis = 0;
        }
        Em.h(1, currentTimeMillis);
        NoteEditorUI.K(this.qur).getViewTreeObserver().removeGlobalOnLayoutListener(this.qur.LE);
    }
}
