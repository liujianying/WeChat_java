package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import android.view.View.OnClickListener;

class a$1 implements OnClickListener {
    final /* synthetic */ a hTl;
    final /* synthetic */ int hW;

    a$1(a aVar, int i) {
        this.hTl = aVar;
        this.hW = i;
    }

    public final void onClick(View view) {
        if (a.a(this.hTl).contains(Integer.valueOf(this.hW))) {
            a.a(this.hTl).remove(Integer.valueOf(this.hW));
        } else {
            a.a(this.hTl).add(Integer.valueOf(this.hW));
        }
        this.hTl.notifyDataSetChanged();
        a.b(this.hTl).a(a.a(this.hTl));
    }
}
