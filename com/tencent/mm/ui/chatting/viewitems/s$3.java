package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ac.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.n.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class s$3 implements OnClickListener {
    final /* synthetic */ String fYG;
    final /* synthetic */ String qiU;
    final /* synthetic */ s ucn;
    final /* synthetic */ String ucv;
    final /* synthetic */ int ucw;
    final /* synthetic */ int ucx;
    final /* synthetic */ String ucy;

    s$3(s sVar, String str, String str2, int i, int i2, String str3, String str4) {
        this.ucn = sVar;
        this.ucv = str;
        this.fYG = str2;
        this.ucw = i;
        this.ucx = i2;
        this.ucy = str3;
        this.qiU = str4;
    }

    public final void onClick(View view) {
        au auVar = (au) view.getTag();
        x.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", new Object[]{this.ucv});
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.bGG = auVar.bXQ.field_msgSvrId + ":" + auVar.userName + ":" + s.b(this.ucn).getTalkerUserName() + ":" + this.fYG;
        if (((a) g.l(a.class)).gr(auVar.userName)) {
            appBrandStatObject.scene = 1014;
            ((d) g.l(d.class)).a(s.b(this.ucn).tTq.getContext(), this.ucv, null, this.ucw, this.ucx, this.ucy, appBrandStatObject);
        } else {
            appBrandStatObject.scene = 1043;
            com.tencent.mm.ac.d kH = f.kH(auVar.userName);
            ((d) g.l(d.class)).a(s.b(this.ucn).tTq.getContext(), this.ucv, null, this.ucw, this.ucx, this.ucy, appBrandStatObject, kH == null ? null : kH.field_appId);
        }
        s.C(9, s.c(this.ucn), s.d(this.ucn));
        h.mEJ.h(11608, new Object[]{s.d(this.ucn), this.qiU, Integer.valueOf(1)});
    }
}
