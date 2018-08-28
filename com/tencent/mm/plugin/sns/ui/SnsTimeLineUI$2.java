package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.qe;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsTimeLineUI$2 extends c<qe> {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$2(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
        this.sFo = qe.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        SnsTimeLineUI.a(this.odw).oeg.notifyVendingDataChange();
        return false;
    }
}
