package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

class FavSelectUI$4 implements a {
    final /* synthetic */ b iZV;
    final /* synthetic */ FavSelectUI jag;

    FavSelectUI$4(FavSelectUI favSelectUI, b bVar) {
        this.jag = favSelectUI;
        this.iZV = bVar;
    }

    public final void a(boolean z, String str, int i) {
        this.jag.YC();
        if (z) {
            final p a = h.a(this.jag.mController.tml, this.jag.getString(i.favorite_forward_tips), false, null);
            h.a(this.jag.mController.tml, FavSelectUI.b(this.jag), str, this.iZV.iWQ, new Runnable() {
                public final void run() {
                    if (a != null) {
                        a.dismiss();
                    }
                    com.tencent.mm.ui.widget.snackbar.b.h(FavSelectUI$4.this.jag, FavSelectUI$4.this.jag.getString(i.fav_finish_sent));
                    ah.i(new 1(this), 1800);
                }
            });
        }
    }
}
