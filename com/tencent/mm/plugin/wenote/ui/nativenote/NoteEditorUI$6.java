package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Dialog;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.bd;

class NoteEditorUI$6 implements Runnable {
    final /* synthetic */ String bAd;
    final /* synthetic */ bd dAB;
    final /* synthetic */ Dialog iYD;
    final /* synthetic */ String mtd;
    final /* synthetic */ NoteEditorUI qur;

    NoteEditorUI$6(NoteEditorUI noteEditorUI, bd bdVar, String str, String str2, Dialog dialog) {
        this.qur = noteEditorUI;
        this.dAB = bdVar;
        this.bAd = str;
        this.mtd = str2;
        this.iYD = dialog;
    }

    public final void run() {
        mw mwVar = new mw();
        mwVar.bXL.type = 4;
        mwVar.bXL.bXQ = this.dAB;
        mwVar.bXL.toUser = this.bAd;
        mwVar.bXL.bOR = this.mtd;
        a.sFg.m(mwVar);
        ah.A(new 1(this));
    }

    public final String toString() {
        return super.toString() + "|onActivityResult";
    }
}
