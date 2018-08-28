package com.tencent.mm.ui.chatting;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.appbrand.b;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;
import com.tencent.mm.ui.v;

class AppBrandServiceChattingUI$a$5 extends v {
    final /* synthetic */ a tGQ;

    AppBrandServiceChattingUI$a$5(a aVar) {
        this.tGQ = aVar;
    }

    public final void bHJ() {
        int i;
        boolean hideVKB = this.tGQ.hideVKB();
        Runnable anonymousClass1 = new Runnable() {
            public final void run() {
                String cuz;
                String ZV = b.ZV(AppBrandServiceChattingUI$a$5.this.tGQ.bAG.getTalkerUserName());
                if (TextUtils.isEmpty(ZV)) {
                    ZV = AppBrandServiceChattingUI$a$5.this.tGQ.bAG.getTalkerUserName();
                    cuz = AppBrandServiceChattingUI$a$5.this.tGQ.bAG.cuz();
                } else {
                    cuz = b.ZW(ZV);
                }
                a.f(AppBrandServiceChattingUI$a$5.this.tGQ).username = AppBrandServiceChattingUI$a$5.this.tGQ.bAG.getTalkerUserName();
                a.f(AppBrandServiceChattingUI$a$5.this.tGQ).gPm = false;
                a.f(AppBrandServiceChattingUI$a$5.this.tGQ).scene = a.b(AppBrandServiceChattingUI$a$5.this.tGQ);
                a.f(AppBrandServiceChattingUI$a$5.this.tGQ).trd = a.g(AppBrandServiceChattingUI$a$5.this.tGQ);
                if (a.b(AppBrandServiceChattingUI$a$5.this.tGQ) == 2) {
                    a.f(AppBrandServiceChattingUI$a$5.this.tGQ).gvj = a.c(AppBrandServiceChattingUI$a$5.this.tGQ);
                    if (a.e(AppBrandServiceChattingUI$a$5.this.tGQ)) {
                        a.f(AppBrandServiceChattingUI$a$5.this.tGQ).show(1);
                        return;
                    } else {
                        a.f(AppBrandServiceChattingUI$a$5.this.tGQ).show(2);
                        return;
                    }
                }
                WxaExposedParams.a aVar = new WxaExposedParams.a();
                aVar.appId = b.rW(ZV);
                aVar.bJu = 4;
                aVar.username = ZV;
                aVar.nickname = cuz;
                a.f(AppBrandServiceChattingUI$a$5.this.tGQ).gvj = aVar.aeo();
                a.f(AppBrandServiceChattingUI$a$5.this.tGQ).appId = a.d(AppBrandServiceChattingUI$a$5.this.tGQ);
                if (a.e(AppBrandServiceChattingUI$a$5.this.tGQ)) {
                    a.f(AppBrandServiceChattingUI$a$5.this.tGQ).show(5);
                } else {
                    a.f(AppBrandServiceChattingUI$a$5.this.tGQ).show(6);
                }
            }
        };
        if (hideVKB) {
            i = 100;
        } else {
            i = 0;
        }
        ah.i(anonymousClass1, (long) i);
    }
}
