package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class d extends h {
    private static HashMap<String, Boolean> msx = new HashMap();
    public p msy = new 1(this);

    public d(Context context, a aVar) {
        super(context, aVar);
    }

    public final void a(a aVar) {
        x.i("MicroMsg.FavRecordAdapter", "updateData localId %s,status %s", new Object[]{Long.valueOf(((b) aVar).msw.field_localId), Integer.valueOf(((b) aVar).msw.field_itemStatus)});
        this.msQ = aVar;
        this.msv.clear();
        this.msv.addAll(aVar.msv);
        notifyDataSetChanged();
    }

    public final void d(b bVar) {
        x.d("MicroMsg.FavRecordAdapter", "setupRecord %s", new Object[]{Long.valueOf(((b) this.msQ).msw.field_localId)});
        bVar.fromScene = 1;
        bVar.bjS = 1;
        bVar.msw = ((b) this.msQ).msw;
    }
}
