package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.brandservice.ui.timeline.c.f;
import com.tencent.mm.storage.q;

class a$15 implements OnClickListener {
    final /* synthetic */ q her;
    final /* synthetic */ a hqX;
    final /* synthetic */ f hrb;

    a$15(a aVar, f fVar, q qVar) {
        this.hqX = aVar;
        this.hrb = fVar;
        this.her = qVar;
    }

    public final void onClick(View view) {
        this.hrb.hrI.setMaxLines(Integer.MAX_VALUE);
        this.hrb.hrG.setVisibility(8);
        this.her.field_isExpand = true;
    }
}
