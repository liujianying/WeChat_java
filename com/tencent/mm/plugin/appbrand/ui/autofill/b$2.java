package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.widget.c;

class b$2 implements OnClickListener {
    final /* synthetic */ b gxI;

    b$2(b bVar) {
        this.gxI = bVar;
    }

    public final void onClick(View view) {
        if (b.a(this.gxI) != null) {
            b.a(this.gxI).anK();
        }
        c cVar = new c(this.gxI.getContext(), 1, false);
        cVar.ofp = new 1(this);
        cVar.ofq = new 2(this);
        cVar.bXO();
    }
}
