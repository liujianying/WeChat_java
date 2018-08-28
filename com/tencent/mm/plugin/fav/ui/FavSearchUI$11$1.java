package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.plugin.fav.ui.FavSearchUI.11;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.ui.base.h;

class FavSearchUI$11$1 implements a {
    final /* synthetic */ b iZV;
    final /* synthetic */ 11 iZW;

    FavSearchUI$11$1(11 11, b bVar) {
        this.iZW = 11;
        this.iZV = bVar;
    }

    public final void a(boolean z, String str, int i) {
        this.iZW.iZQ.YC();
        if (z) {
            h.a(this.iZW.iZQ.mController.tml, FavSearchUI.h(this.iZW.iZQ), str, this.iZV.iWQ, new 1(this, h.a(this.iZW.iZQ.mController.tml, this.iZW.iZQ.getString(i.favorite_forward_tips), false, null)));
        }
    }
}
