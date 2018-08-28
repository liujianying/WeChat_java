package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.model.am.b.a;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import java.util.LinkedList;

class NormalUserFooterPreference$c$5 implements a {
    final /* synthetic */ c lXI;
    final /* synthetic */ com.tencent.mm.pluginsdk.ui.applet.a lXL;
    final /* synthetic */ String lXM;
    final /* synthetic */ LinkedList lXN;

    NormalUserFooterPreference$c$5(c cVar, com.tencent.mm.pluginsdk.ui.applet.a aVar, String str, LinkedList linkedList) {
        this.lXI = cVar;
        this.lXL = aVar;
        this.lXM = str;
        this.lXN = linkedList;
    }

    public final void x(String str, boolean z) {
        au.HU();
        ab Yg = com.tencent.mm.model.c.FR().Yg(NormalUserFooterPreference.a(this.lXI.lXw).field_username);
        this.lXL.TC(Yg != null ? bi.aG(Yg.cta, "") : "");
        this.lXL.b(NormalUserFooterPreference.a(this.lXI.lXw).field_username, this.lXM, this.lXN);
    }
}
