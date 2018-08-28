package com.tencent.mm.ui.chatting;

import android.util.Base64;
import com.tencent.mm.ac.f;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.appbrand.n.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.c.a;

class s$1 implements g {
    final /* synthetic */ String dhh;
    final /* synthetic */ a tKw;
    final /* synthetic */ s tKx;

    s$1(s sVar, a aVar, String str) {
        this.tKx = sVar;
        this.tKw = aVar;
        this.dhh = str;
    }

    public final Object a(m mVar) {
        i.Cx(6);
        switch (mVar.type) {
            case 1:
                return s.a(this.tKx);
            case 2:
            case 6:
            case 7:
            case 9:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 20:
            case 21:
            case 22:
            case 23:
                this.tKw.tTq.csV();
                break;
            case 4:
                s.a(this.tKx, mVar);
                break;
            case 25:
            case 30:
            case f$k.AppCompatTheme_actionModeCloseDrawable /*31*/:
                return s.a(this.tKx);
        }
        return null;
    }

    public final Object b(m mVar) {
        switch (mVar.type) {
            case f$k.AppCompatTheme_actionDropDownStyle /*45*/:
                if (!(au.HX() && (f.eZ(this.dhh) || f.kM(this.dhh) || f.kL(this.dhh)))) {
                    x.i("MicroMsg.ChattingListAdapter", "appId:%s,path:%s", new Object[]{new String(Base64.decode(mVar.url, 0)), new String(Base64.decode(bi.aG((String) mVar.F(String.class), ""), 0))});
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = 1082;
                    appBrandStatObject.bGG = this.dhh;
                    ((d) com.tencent.mm.kernel.g.l(d.class)).a(this.tKw.tTq.getContext(), null, r3, 0, 0, r6, appBrandStatObject);
                    break;
                }
        }
        return null;
    }
}
