package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements Runnable {
    final /* synthetic */ g iVt;
    final /* synthetic */ boolean iVu;
    final /* synthetic */ Runnable iVv;

    b$2(g gVar, boolean z, Runnable runnable) {
        this.iVt = gVar;
        this.iVu = z;
        this.iVv = runnable;
    }

    public final void run() {
        x.i("MicroMsg.Fav.FavApiLogic", "delete favItem id %d, localId %d, needBatchDel %B, do on worker thread", new Object[]{Integer.valueOf(this.iVt.field_id), Long.valueOf(this.iVt.field_localId), Boolean.valueOf(this.iVu)});
        b.a(this.iVt, this.iVu);
        ah.A(this.iVv);
    }
}
