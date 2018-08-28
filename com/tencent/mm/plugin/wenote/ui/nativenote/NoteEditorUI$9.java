package com.tencent.mm.plugin.wenote.ui.nativenote;

import com.tencent.mm.plugin.wenote.model.a.e;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class NoteEditorUI$9 implements Runnable {
    final /* synthetic */ NoteEditorUI qur;
    final /* synthetic */ ArrayList quu;

    NoteEditorUI$9(NoteEditorUI noteEditorUI, ArrayList arrayList) {
        this.qur = noteEditorUI;
        this.quu = arrayList;
    }

    public final void run() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.quu.size(); i++) {
            String str = (String) this.quu.get(i);
            e eVar = new e();
            eVar.qpd = true;
            eVar.type = 2;
            eVar.qpc = c.bZD().bZJ();
            eVar.jdM = f.Sf(eVar.toString());
            NoteEditorUI.a(this.qur, new vx());
            NoteEditorUI.ab(this.qur).UO(eVar.jdM);
            eVar.qpe = com.tencent.mm.plugin.wenote.b.c.fw(str, f.o(NoteEditorUI.ab(this.qur)));
            eVar.bVd = com.tencent.mm.plugin.wenote.b.c.fx(eVar.qpe, f.c(NoteEditorUI.ab(this.qur)));
            arrayList.add(eVar);
        }
        if (NoteEditorUI.Z(this.qur) == null || !NoteEditorUI.Z(this.qur).isShowing()) {
            x.i("MicroMsg.Note.NoteEditorUI", "user canceled");
            return;
        }
        c.bZD().a(arrayList, NoteEditorUI.f(this.qur).cam(), true, false, true, false);
        this.qur.e(true, 100);
        this.qur.Q(1, 0);
    }
}
