package com.tencent.mm.plugin.radar.ui;

import android.view.View;
import b.c.a.a;
import b.c.b.f;
import b.i;

final class i$b extends f implements a<T> {
    final /* synthetic */ int mnl;
    final /* synthetic */ View mnm;

    i$b(View view, int i) {
        this.mnm = view;
        this.mnl = i;
    }

    public final /* synthetic */ Object invoke() {
        View findViewById = this.mnm.findViewById(this.mnl);
        if (findViewById != null) {
            return findViewById;
        }
        throw new i("null cannot be cast to non-null type T");
    }
}
