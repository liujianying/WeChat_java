package com.tencent.mm.plugin.fav.ui.d;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;

class g$1 implements OnClickListener {
    final /* synthetic */ g jey;

    g$1(g gVar) {
        this.jey = gVar;
    }

    public final void onClick(View view) {
        if (!f.zZ()) {
            s.gH(this.jey.iYh.context);
        } else if (view.getTag() instanceof g) {
            g gVar = (g) view.getTag();
            wr wrVar = gVar.field_favProto.rBG;
            vx c = b.c(gVar);
            if (c == null) {
                x.w("MicroMsg.FavBaseListItem", "data item is null");
            } else if (b.e(c)) {
                x.i("MicroMsg.FavBaseListItem", "same song, do release");
                com.tencent.mm.an.b.PW();
                g.a(this.jey, null);
            } else {
                String uri;
                com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(b.c(c));
                if (bVar.exists()) {
                    uri = bVar.cBX().toString();
                } else if (c.bJv == null) {
                    uri = "";
                } else {
                    bVar = new com.tencent.mm.vfs.b(b.aKO() + com.tencent.mm.a.g.u(c.bJv.getBytes()));
                    uri = bVar.exists() ? bVar.cBX().toString() : "";
                }
                com.tencent.mm.an.b.b(((com.tencent.mm.an.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.an.a.b.class)).a(6, null, c.title, c.desc, c.rzv, c.rzz, c.rzx, c.jdM, b.aKV(), uri, "", wrVar.appId));
                g.a(this.jey, (ImageView) view);
            }
        }
    }
}
