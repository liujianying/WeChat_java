package com.tencent.mm.ui.conversation;

import com.tencent.mm.g.a.jg;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class a$4 extends c<jg> {
    final /* synthetic */ a unj;

    a$4(a aVar) {
        this.unj = aVar;
        this.sFo = jg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (this.unj.unh.getVisibility() != 0) {
            this.unj.unh.setVisibility(0);
            this.unj.uni.setVisibility(8);
        }
        return false;
    }
}
