package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.storage.q;

class a$6 implements OnLongClickListener {
    final /* synthetic */ q her;
    final /* synthetic */ a hqX;
    final /* synthetic */ int hqZ;

    a$6(a aVar, q qVar, int i) {
        this.hqX = aVar;
        this.her = qVar;
        this.hqZ = i;
    }

    public final boolean onLongClick(View view) {
        a.a(this.hqX, this.her);
        a.b(this.hqX, this.hqZ);
        a.a(this.hqX, 1);
        a.f(this.hqX).a(view, this.hqX, a.c(this.hqX), a.d(this.hqX), a.e(this.hqX));
        return true;
    }
}
