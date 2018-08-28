package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements p {
    final /* synthetic */ d msz;

    d$1(d dVar) {
        this.msz = dVar;
    }

    public final void d(c cVar) {
        if (cVar.field_favLocalId != ((b) this.msz.msQ).msw.field_localId) {
            x.i("MicroMsg.FavRecordAdapter", "not equal Id %d %d", new Object[]{Long.valueOf(cVar.field_favLocalId), Long.valueOf(((b) this.msz.msQ).msw.field_localId)});
            return;
        }
        x.d("MicroMsg.FavRecordAdapter", "on cdn status changed, fav local id %d, data id %s, status %d", new Object[]{Long.valueOf(cVar.field_favLocalId), cVar.field_dataId, Integer.valueOf(cVar.field_status)});
        if (4 == cVar.field_status) {
            d.bqz().put(bi.aG(cVar.field_dataId, "null"), Boolean.valueOf(true));
        }
        if (cVar.isFinished()) {
            this.msz.msM.post(new 1(this, cVar));
        }
        this.msz.bqH();
    }
}
