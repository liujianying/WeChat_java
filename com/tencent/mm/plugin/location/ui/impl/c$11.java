package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.map.a.d;
import com.tencent.mm.sdk.platformtools.x;

class c$11 implements OnClickListener {
    final /* synthetic */ c kJf;

    c$11(c cVar) {
        this.kJf = cVar;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.MMPoiMapUI", "click lat: %s, lng: %s", new Object[]{Double.valueOf(c.g(this.kJf)), Double.valueOf(c.h(this.kJf))});
        if (c.g(this.kJf) == -85.0d || c.h(this.kJf) == -1000.0d) {
            x.i("MicroMsg.MMPoiMapUI", "invalid lat lng");
            return;
        }
        this.kJf.kFl.getIController().animateTo(c.g(this.kJf), c.h(this.kJf));
        c.a(this.kJf, c.g(this.kJf));
        c.b(this.kJf, c.h(this.kJf));
        c.k(this.kJf).m(c.i(this.kJf), c.j(this.kJf));
        c.l(this.kJf).setBackgroundResource(d.location_my_current);
        c.l(this.kJf).setEnabled(true);
        c.m(this.kJf);
        c.n(this.kJf);
        c.o(this.kJf).kJb = false;
    }
}
