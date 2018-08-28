package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.nativenote.b.f;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends a<com.tencent.mm.plugin.wenote.ui.nativenote.b.a> {
    private final String TAG = "MicroMsg.Note.NoteRecyclerViewAdapter";
    private k qtF;
    private f qvf;

    public c(k kVar) {
        this.qtF = kVar;
        this.qvf = new f();
    }

    private synchronized void a(com.tencent.mm.plugin.wenote.ui.nativenote.b.a aVar, int i) {
        boolean z = true;
        synchronized (this) {
            b Bv = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().Bv(i);
            if (Bv == null || Bv.getType() != aVar.caZ()) {
                String str = "MicroMsg.Note.NoteRecyclerViewAdapter";
                String str2 = "onBindViewHolder, item is null %b, position is %d";
                Object[] objArr = new Object[2];
                if (Bv != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                objArr[1] = Integer.valueOf(i);
                x.e(str, str2, objArr);
            } else {
                aVar.a(Bv, i, Bv.getType());
            }
        }
    }

    public final int getItemViewType(int i) {
        b Bv = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().Bv(i);
        if (Bv != null) {
            return Bv.getType();
        }
        x.e("MicroMsg.Note.NoteRecyclerViewAdapter", "getItemViewType, item is null, position is %d", new Object[]{Integer.valueOf(i)});
        return 0;
    }

    public final int getItemCount() {
        return com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZD().size();
    }
}
