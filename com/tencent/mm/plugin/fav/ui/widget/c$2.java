package com.tencent.mm.plugin.fav.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class c$2 implements OnClickListener {
    final /* synthetic */ c jfv;

    c$2(c cVar) {
        this.jfv = cVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.FavHeaderView", "click retry item");
        List<g> aLF = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().aLF();
        if (aLF != null && !aLF.isEmpty()) {
            for (g gVar : aLF) {
                if (gVar.aLg()) {
                    b.l(gVar);
                } else {
                    x.w("MicroMsg.FavHeaderView", "item id is %d, status is not upload fail", new Object[]{Integer.valueOf(gVar.field_id)});
                }
            }
            c.c(this.jfv).setVisibility(8);
            c.d(this.jfv).setVisibility(8);
        }
    }
}
