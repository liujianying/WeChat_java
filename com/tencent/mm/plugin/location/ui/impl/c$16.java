package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;

class c$16 implements OnClickListener {
    final /* synthetic */ c kJf;

    c$16(c cVar) {
        this.kJf = cVar;
    }

    public final void onClick(View view) {
        if (!c.q(this.kJf)) {
            c.u(this.kJf);
        }
        c.v(this.kJf).clean();
        c.w(this.kJf).setAdapter(c.v(this.kJf));
        c.v(this.kJf).notifyDataSetChanged();
        c.x(this.kJf).setVisibility(8);
    }
}
