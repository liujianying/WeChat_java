package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.v;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView$a;
import com.tencent.mm.protocal.c.akp;
import com.tencent.mm.protocal.c.akq;

class WxaBindBizInfoUI$3 implements LoadMoreRecyclerView$a {
    final /* synthetic */ WxaBindBizInfoUI gwZ;

    WxaBindBizInfoUI$3(WxaBindBizInfoUI wxaBindBizInfoUI) {
        this.gwZ = wxaBindBizInfoUI;
    }

    public final void anH() {
        akp akp = new akp();
        akp.bPS = WxaBindBizInfoUI.a(this.gwZ);
        akp.rNv = WxaBindBizInfoUI.b(this.gwZ);
        a aVar = new a();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getwxabindbizinfo";
        aVar.dIF = 1823;
        aVar.dIG = akp;
        aVar.dIH = new akq();
        v.a(aVar.KT(), new 1(this), false);
    }
}
