package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.ko;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsTimeLineUI$34 extends c<ko> {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$34(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
        this.sFo = ko.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        SnsTimeLineUI.a(this.odw).notifyDataSetChanged();
        return false;
    }
}
