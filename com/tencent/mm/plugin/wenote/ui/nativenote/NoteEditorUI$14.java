package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.d.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class NoteEditorUI$14 implements a {
    final /* synthetic */ NoteEditorUI qur;

    NoteEditorUI$14(NoteEditorUI noteEditorUI) {
        this.qur = noteEditorUI;
    }

    public final void a(String str, j jVar) {
        x.i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onImportFinish");
        if (!bi.oW(str) && FileOp.cn(str) && jVar != null) {
            jVar.bOX = str;
        }
    }

    public final void b(String str, j jVar) {
        x.i("MicroMsg.Note.NoteEditorUI", "compressNoteVideo onExportFinish");
        if (NoteEditorUI.Z(this.qur) != null) {
            NoteEditorUI.Z(this.qur).dismiss();
            NoteEditorUI.aa(this.qur);
        }
        if (bi.oW(str) || !e.cn(str) || jVar == null || jVar.qoU) {
            x.i("MicroMsg.Note.NoteEditorUI", "file not exist or user canceled");
        } else if (new File(str).length() < NoteEditorUI.caV()) {
            jVar.bVd = str;
            c.bZD().a((b) jVar, NoteEditorUI.f(this.qur).cam(), false, true, false);
        } else {
            Toast.makeText(this.qur.mController.tml, this.qur.getString(R.l.favorite_too_large), 1).show();
        }
        this.qur.e(true, 100);
        this.qur.Q(1, 0);
    }
}
