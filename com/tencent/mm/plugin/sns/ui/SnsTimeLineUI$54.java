package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.qq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class SnsTimeLineUI$54 extends c<qq> {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$54(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
        this.sFo = qq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (SnsTimeLineUI.g(this.odw) != null) {
            com.tencent.mm.plugin.sns.h.b bVar2 = SnsTimeLineUI.g(this.odw).nLK.nrb;
            bVar2.nvI++;
            SnsTimeLineUI.g(this.odw).nLK.nrb.hW(false);
        }
        return false;
    }
}
