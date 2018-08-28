package com.tencent.mm.ui.widget.picker;

import android.view.View;
import android.view.View.OnClickListener;

class b$2 implements OnClickListener {
    final /* synthetic */ b uLm;

    b$2(b bVar) {
        this.uLm = bVar;
    }

    public final void onClick(View view) {
        b bVar = this.uLm;
        Object aqr = b.b(this.uLm) == null ? null : b.b(this.uLm).aqr();
        if (b.a(this.uLm) != null) {
            b.a(this.uLm).aqr();
        }
        b.a(bVar, true, aqr);
    }
}
