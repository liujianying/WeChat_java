package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.plugin.brandservice.ui.timeline.g.a;
import com.tencent.mm.storage.q;

class a$9 implements OnLongClickListener {
    final /* synthetic */ a hqX;

    a$9(a aVar) {
        this.hqX = aVar;
    }

    public final boolean onLongClick(View view) {
        a.a(this.hqX, (q) view.getTag());
        a.a(this.hqX, 0);
        a.f(this.hqX).a(view, this.hqX, a.c(this.hqX), a.d(this.hqX), a.e(this.hqX));
        a aVar = (a) a.h(this.hqX).hsb.get(Long.valueOf(a.i(this.hqX).field_msgId));
        if (aVar != null) {
            aVar.rjt = 1;
        }
        return true;
    }
}
