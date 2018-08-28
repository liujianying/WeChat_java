package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s$j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;

class c$1 implements a {
    final /* synthetic */ String bAj;
    final /* synthetic */ MMActivity bAl;
    final /* synthetic */ int bpX;
    final /* synthetic */ String dEt;
    final /* synthetic */ String dFT;
    final /* synthetic */ String dMs;
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ p fIY;
    final /* synthetic */ String fYB;
    final /* synthetic */ boolean fYC;
    final /* synthetic */ String fYD;
    final /* synthetic */ String fYE;
    final /* synthetic */ String fYF;
    final /* synthetic */ String fYG;
    final /* synthetic */ boolean fYH;
    final /* synthetic */ String fYI;
    final /* synthetic */ boolean fYJ;
    final /* synthetic */ boolean fYK;
    final /* synthetic */ int fYL;
    final /* synthetic */ c fYM;
    final /* synthetic */ AppBrandSysConfig fdg;

    c$1(c cVar, l lVar, int i, String str, String str2, boolean z, String str3, String str4, String str5, String str6, int i2, String str7, AppBrandSysConfig appBrandSysConfig, String str8, p pVar, boolean z2, String str9, boolean z3, boolean z4, String str10, int i3, MMActivity mMActivity) {
        this.fYM = cVar;
        this.fCl = lVar;
        this.doP = i;
        this.bAj = str;
        this.fYB = str2;
        this.fYC = z;
        this.dMs = str3;
        this.dEt = str4;
        this.fYD = str5;
        this.fYE = str6;
        this.bpX = i2;
        this.fYF = str7;
        this.fdg = appBrandSysConfig;
        this.fYG = str8;
        this.fIY = pVar;
        this.fYH = z2;
        this.fYI = str9;
        this.fYJ = z3;
        this.fYK = z4;
        this.dFT = str10;
        this.fYL = i3;
        this.bAl = mMActivity;
    }

    public final void b(int i, int i2, Intent intent) {
        int i3 = 16;
        String str;
        String str2;
        if (i != 1) {
            x.i("MicroMsg.JsApiShareAppMessage", "requestCode(%d) not corrected.", Integer.valueOf(i));
        } else if (i2 != -1) {
            x.i("MicroMsg.JsApiShareAppMessage", "resultCode is not RESULT_OK(%d)", Integer.valueOf(i2));
            this.fCl.E(this.doP, this.fYM.f("cancel", null));
            str = this.bAj;
            str2 = this.fYB;
            if (!this.fYC) {
                i3 = 2;
            }
            c.a(str, str2, i3, "", 3, i2);
        } else {
            str2 = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (str2 == null || str2.length() == 0) {
                x.e("MicroMsg.JsApiShareAppMessage", "mmOnActivityResult fail, toUser is null");
                this.fCl.E(this.doP, this.fYM.f("fail:selected user is nil", null));
                if (!this.fYC) {
                    i3 = 2;
                }
                c.a(this.bAj, this.fYB, i3, "", 2, i2);
                return;
            }
            x.i("MicroMsg.JsApiShareAppMessage", "result success toUser : %s ", str2);
            str = intent.getStringExtra("custom_send_text");
            SendAppMessageTask sendAppMessageTask = new SendAppMessageTask();
            sendAppMessageTask.fYU = str;
            sendAppMessageTask.toUser = str2;
            sendAppMessageTask.appId = this.bAj;
            sendAppMessageTask.userName = this.dMs;
            sendAppMessageTask.title = this.dEt;
            sendAppMessageTask.description = this.fYD;
            sendAppMessageTask.url = this.fYE;
            sendAppMessageTask.path = this.fYB;
            sendAppMessageTask.type = this.bpX;
            sendAppMessageTask.fYV = this.fYF;
            sendAppMessageTask.iconUrl = this.fdg.fqJ;
            sendAppMessageTask.bPh = this.fdg.frm.fih;
            sendAppMessageTask.fso = this.fdg.frm.bKg;
            sendAppMessageTask.version = this.fdg.frm.fii;
            sendAppMessageTask.nickname = this.fdg.bKC;
            sendAppMessageTask.dxx = this.fYG;
            sendAppMessageTask.fYX = k.qv(this.bAj).fdH.getAndIncrement();
            sendAppMessageTask.fYZ = this.fIY.getURL();
            sendAppMessageTask.fZa = this.fIY.agW();
            AppBrandStatObject qb = com.tencent.mm.plugin.appbrand.a.qb(this.bAj);
            if (qb != null) {
                sendAppMessageTask.scene = qb.scene == 0 ? 1000 : qb.scene;
                sendAppMessageTask.bGG = bi.oV(qb.bGG);
                sendAppMessageTask.fYY = bi.oV(j.g(this.fCl.fdO).fdE);
            }
            sendAppMessageTask.fPt = this.fYH;
            sendAppMessageTask.fYW = k.tZ(this.fYI);
            sendAppMessageTask.withShareTicket = this.fYC;
            sendAppMessageTask.fZb = this.fYJ;
            sendAppMessageTask.fZc = this.fYK;
            sendAppMessageTask.fwS = this.dFT;
            sendAppMessageTask.dCn = this.fYL;
            com.tencent.mm.plugin.appbrand.jsapi.p.a alS = this.fIY.alS();
            if (alS == null) {
                str = "";
            } else {
                str = alS.getWebView().getUrl();
            }
            sendAppMessageTask.fZd = str;
            if (this.fYC) {
                sendAppMessageTask.fFC = new 1(this, sendAppMessageTask, str2, i2);
                sendAppMessageTask.ahA();
                AppBrandMainProcessService.a(sendAppMessageTask);
            } else {
                AppBrandMainProcessService.a(sendAppMessageTask);
                this.fCl.E(this.doP, this.fYM.f("ok", null));
                if (str2.toLowerCase().endsWith("@chatroom")) {
                    i3 = 9;
                } else {
                    i3 = 2;
                }
                c.a(this.bAj, this.fYB, i3, "", 1, i2);
            }
            if (this.bAl != null) {
                h.bA(this.bAl, this.bAl.getResources().getString(s$j.app_brand_app_msg_shared));
            }
        }
    }
}
