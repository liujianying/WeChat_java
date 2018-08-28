package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class c$5 implements OnItemClickListener {
    final /* synthetic */ c kJf;

    c$5(c cVar) {
        this.kJf = cVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        f fVar = null;
        if (c.v(this.kJf).kJp < c.v(this.kJf).getCount()) {
            fVar = c.v(this.kJf).rU(i);
        }
        c.b(this.kJf, fVar);
        c.a(this.kJf, fVar);
    }
}
