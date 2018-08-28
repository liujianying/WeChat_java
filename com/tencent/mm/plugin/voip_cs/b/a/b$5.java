package com.tencent.mm.plugin.voip_cs.b.a;

import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;

class b$5 implements OnClickListener {
    final /* synthetic */ b oXY;

    b$5(b bVar) {
        this.oXY = bVar;
    }

    public final void onClick(View view) {
        b.a(this.oXY, !b.h(this.oXY));
        Point b = b.b(this.oXY, b.h(this.oXY));
        b.i(this.oXY).dU(b.x, b.y);
    }
}
