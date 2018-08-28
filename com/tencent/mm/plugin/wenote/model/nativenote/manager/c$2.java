package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.mm.plugin.wenote.model.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class c$2 implements Runnable {
    final /* synthetic */ c qpX;
    final /* synthetic */ ArrayList qpY;

    public c$2(c cVar, ArrayList arrayList) {
        this.qpX = cVar;
        this.qpY = arrayList;
    }

    public final void run() {
        ArrayList a = h.a(c.d(this.qpX), this.qpY, false);
        x.i("MicroMsg.Note.NoteDataManager", "updateDataByHtml, start mNotifyListener.setUpNoteData(dataItems, true)");
        c.e(this.qpX).m(a, true);
    }
}
