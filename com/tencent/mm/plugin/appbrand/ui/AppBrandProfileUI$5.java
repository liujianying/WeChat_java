package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.config.t;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.g;

class AppBrandProfileUI$5 implements a {
    final /* synthetic */ AppBrandProfileUI gvm;
    final /* synthetic */ t gvn;
    final /* synthetic */ View gvo;

    AppBrandProfileUI$5(AppBrandProfileUI appBrandProfileUI, t tVar, View view) {
        this.gvm = appBrandProfileUI;
        this.gvn = tVar;
        this.gvo = view;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i != 1) {
            AppBrandProfileUI.a(this.gvm, 8, 2);
        } else if (i2 == -1) {
            String str;
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("Select_Conv_User");
            }
            if (str == null || str.length() == 0) {
                x.i("MicroMsg.AppBrandProfileUI", "mmOnActivityResult fail, toUser is null");
                return;
            }
            x.i("MicroMsg.AppBrandProfileUI", "result success toUser : %s ", new Object[]{str});
            String stringExtra = intent.getStringExtra("custom_send_text");
            String str2 = this.gvn.appId;
            u.Hx().v(u.ic("wxapp_" + str2), true).p("prePublishId", "wxapp_" + str2);
            g.a aVar = new g.a();
            aVar.title = this.gvn.nickname;
            aVar.type = 33;
            aVar.dyS = AppBrandProfileUI.e(this.gvm);
            aVar.dyT = str2;
            aVar.dyU = 1;
            aVar.bZM = "wxapp_" + str2;
            aVar.thumburl = this.gvn.fsq;
            aVar.url = n.qz(str2);
            aVar.bZG = AppBrandProfileUI.e(this.gvm);
            aVar.bZH = this.gvn.nickname;
            for (String str3 : bi.F(str.split(","))) {
                int i3;
                ((com.tencent.mm.plugin.appbrand.compat.a.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.compat.a.a.class)).a(aVar, str2, this.gvn.nickname, str3, null);
                if (!bi.oW(stringExtra)) {
                    ow owVar = new ow();
                    owVar.bZQ.bZR = str3;
                    owVar.bZQ.content = stringExtra;
                    owVar.bZQ.type = s.hQ(str3);
                    owVar.bZQ.flags = 0;
                    com.tencent.mm.sdk.b.a.sFg.m(owVar);
                }
                if (str3.endsWith("@chatroom")) {
                    i3 = 9;
                } else {
                    i3 = 8;
                }
                AppBrandProfileUI.a(this.gvm, i3, bi.VE());
            }
            h.bA(this.gvo.getContext(), this.gvo.getContext().getResources().getString(j.app_shared));
        }
    }
}
