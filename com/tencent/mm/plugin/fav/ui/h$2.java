package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.fav.a.am.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vfs.d;

class h$2 implements a {
    final /* synthetic */ Runnable bzs;
    final /* synthetic */ g iVs;
    final /* synthetic */ Context val$context;

    public h$2(g gVar, Context context, Runnable runnable) {
        this.iVs = gVar;
        this.val$context = context;
        this.bzs = runnable;
    }

    public final void c(SparseArray<String> sparseArray) {
        String str = (String) sparseArray.get(this.iVs.field_id);
        x.d("MicroMsg.FavSendLogic", "on finish, favid %d, url %s", new Object[]{Integer.valueOf(this.iVs.field_id), str});
        if (!bi.oW(str)) {
            if (4 == this.iVs.field_type) {
                vx c = b.c(this.iVs);
                String aG = bi.aG(c.title, this.val$context.getString(i.favorite_video));
                Intent intent = new Intent();
                intent.putExtra("Ksnsupload_link", str);
                intent.putExtra("Ksnsupload_title", aG);
                intent.putExtra("Ksnsupload_imgbuf", d.dv(b.c(c), -1));
                b.w(intent, this.val$context);
                str = "fav_" + q.GF() + "_" + this.iVs.field_id;
                String ic = u.ic(str);
                u.Hx().v(ic, true).p("prePublishId", str);
                intent.putExtra("reportSessionId", ic);
                h.f(this.iVs.field_localId, 0, 0);
            } else {
                x.w("MicroMsg.FavSendLogic", "unknown type %d, fav id %d", new Object[]{Integer.valueOf(this.iVs.field_type), Integer.valueOf(this.iVs.field_id)});
            }
        }
        if (this.bzs != null) {
            ah.A(this.bzs);
        }
    }
}
