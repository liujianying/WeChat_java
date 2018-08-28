package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.storage.q;

class a$18 implements OnLongClickListener {
    final /* synthetic */ q her;
    final /* synthetic */ a hqX;

    a$18(a aVar, q qVar) {
        this.hqX = aVar;
        this.her = qVar;
    }

    public final boolean onLongClick(View view) {
        a.a(this.hqX, this.her);
        a.a(this.hqX, 1);
        a.f(this.hqX).a(view, this.hqX, a.c(this.hqX), a.d(this.hqX), a.e(this.hqX));
        return true;
    }
}
