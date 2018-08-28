package com.tencent.mm.plugin.fav.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements OnClickListener {
    final /* synthetic */ c jfv;

    c$1(c cVar) {
        this.jfv = cVar;
    }

    public final void onClick(View view) {
        if (c.a(this.jfv) == 1 || c.a(this.jfv) == 3) {
            x.i("MicroMsg.FavHeaderView", "click clear fav item");
            if (c.b(this.jfv) != null) {
                c.b(this.jfv).aMx();
            }
        }
    }
}
