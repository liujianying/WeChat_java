package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.23.2;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

class NoteEditorUI$23$2$1 implements OnClickListener {
    final /* synthetic */ 2 quA;

    NoteEditorUI$23$2$1(2 2) {
        this.quA = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        p a = h.a(this.quA.quz.qur.mController.tml, this.quA.quz.qur.getString(R.l.app_delete_tips), false, null);
        this.quA.quz.qur.qtF.cal();
        fz fzVar = new fz();
        fzVar.bOL.type = 12;
        fzVar.bOL.bJA = this.quA.quz.qur.dTK;
        fzVar.bOL.bOQ = new 1(this, a);
        a.sFg.m(fzVar);
    }
}
