package com.tencent.mm.plugin.aa.ui;

import com.tencent.mm.plugin.aa.a.c.c.a;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.y;
import com.tencent.mm.vending.app.a.b;
import java.util.HashMap;

class LaunchAAByPersonAmountSelectUI$4 implements b<a> {
    final /* synthetic */ LaunchAAByPersonAmountSelectUI eDf;
    final /* synthetic */ HashMap eDh;

    LaunchAAByPersonAmountSelectUI$4(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI, HashMap hashMap) {
        this.eDf = launchAAByPersonAmountSelectUI;
        this.eDh = hashMap;
    }

    public final /* synthetic */ void be(Object obj) {
        a aVar = (a) obj;
        String str = "MicroMsg.LaunchAAByPersonAmountSelectUI";
        String str2 = "get selectMembers: %s, list.size: %s";
        Object[] objArr = new Object[2];
        objArr[0] = aVar;
        objArr[1] = aVar != null ? Integer.valueOf(aVar.dhI.size()) : "0";
        x.i(str, str2, objArr);
        LaunchAAByPersonAmountSelectUI.f(this.eDf).addFooterView(y.gq(this.eDf).inflate(g.aa_large_footer, null), null, false);
        LaunchAAByPersonAmountSelectUI.f(this.eDf).addHeaderView(y.gq(this.eDf).inflate(g.aa_small_footer, null), null, false);
        if (!(aVar == null || aVar.dhI == null || aVar.dhI.size() <= 0)) {
            LaunchAAByPersonAmountSelectUI.a(this.eDf, new LaunchAAByPersonAmountSelectUI.a(this.eDf, aVar.dhI, this.eDh));
            LaunchAAByPersonAmountSelectUI.f(this.eDf).setAdapter(LaunchAAByPersonAmountSelectUI.g(this.eDf));
        }
        LaunchAAByPersonAmountSelectUI.h(this.eDf).setVisibility(0);
        LaunchAAByPersonAmountSelectUI.j(this.eDf).post(LaunchAAByPersonAmountSelectUI.i(this.eDf));
    }
}
