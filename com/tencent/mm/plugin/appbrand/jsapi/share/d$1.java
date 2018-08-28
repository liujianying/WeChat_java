package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.h;

class d$1 implements a {
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
    final /* synthetic */ d fYQ;
    final /* synthetic */ AppBrandSysConfig fdg;

    d$1(d dVar, l lVar, int i, String str, String str2, String str3, String str4, String str5, String str6, int i2, boolean z, String str7, AppBrandSysConfig appBrandSysConfig, p pVar, String str8, boolean z2, boolean z3, boolean z4, String str9, String str10, int i3, MMActivity mMActivity) {
        this.fYQ = dVar;
        this.fCl = lVar;
        this.doP = i;
        this.bAj = str;
        this.dMs = str2;
        this.dEt = str3;
        this.fYD = str4;
        this.fYE = str5;
        this.fYB = str6;
        this.bpX = i2;
        this.fYH = z;
        this.fYF = str7;
        this.fdg = appBrandSysConfig;
        this.fIY = pVar;
        this.fYI = str8;
        this.fYC = z2;
        this.fYJ = z3;
        this.fYK = z4;
        this.fYG = str9;
        this.dFT = str10;
        this.fYL = i3;
        this.bAl = mMActivity;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i != 1) {
            x.i("MicroMsg.JsApiShareAppMessageDirectly", "requestCode(%d) not corrected.", new Object[]{Integer.valueOf(i)});
        } else if (i2 != -1) {
            x.i("MicroMsg.JsApiShareAppMessageDirectly", "resultCode is not RESULT_OK(%d)", new Object[]{Integer.valueOf(i2)});
            this.fCl.E(this.doP, this.fYQ.f("cancel", null));
        } else {
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (stringExtra == null || stringExtra.length() == 0) {
                x.e("MicroMsg.JsApiShareAppMessageDirectly", "mmOnActivityResult fail, toUser is null");
                this.fCl.E(this.doP, this.fYQ.f("fail:selected user is nil", null));
                return;
            }
            x.i("MicroMsg.JsApiShareAppMessageDirectly", "result success toUser : %s ", new Object[]{stringExtra});
            String stringExtra2 = intent.getStringExtra("custom_send_text");
            SendAppMessageTask sendAppMessageTask = new SendAppMessageTask();
            sendAppMessageTask.fYU = stringExtra2;
            sendAppMessageTask.toUser = stringExtra;
            sendAppMessageTask.appId = this.bAj;
            sendAppMessageTask.userName = this.dMs;
            sendAppMessageTask.title = this.dEt;
            sendAppMessageTask.description = this.fYD;
            sendAppMessageTask.url = this.fYE;
            sendAppMessageTask.path = this.fYB;
            sendAppMessageTask.type = this.bpX;
            sendAppMessageTask.fPt = this.fYH;
            sendAppMessageTask.fYV = this.fYF;
            sendAppMessageTask.iconUrl = this.fdg.fqJ;
            sendAppMessageTask.bPh = this.fdg.frm.fih;
            sendAppMessageTask.fso = this.fdg.frm.bKg;
            sendAppMessageTask.version = this.fdg.frm.fii;
            sendAppMessageTask.nickname = this.fdg.bKC;
            sendAppMessageTask.fYX = k.qv(this.bAj).fdH.getAndIncrement();
            sendAppMessageTask.fYZ = this.fIY.getURL();
            sendAppMessageTask.fZa = this.fIY.agW();
            AppBrandStatObject qb = com.tencent.mm.plugin.appbrand.a.qb(this.bAj);
            if (qb != null) {
                sendAppMessageTask.scene = qb.scene == 0 ? 1000 : qb.scene;
                sendAppMessageTask.bGG = bi.oV(qb.bGG);
                sendAppMessageTask.fYY = bi.oV(j.g(this.fCl.fdO).fdE);
            }
            sendAppMessageTask.fYW = k.tZ(this.fYI);
            sendAppMessageTask.withShareTicket = this.fYC;
            sendAppMessageTask.fZb = this.fYJ;
            sendAppMessageTask.fZc = this.fYK;
            sendAppMessageTask.dxx = this.fYG;
            sendAppMessageTask.fwS = this.dFT;
            sendAppMessageTask.dCn = this.fYL;
            com.tencent.mm.plugin.appbrand.jsapi.p.a alS = this.fIY.alS();
            if (alS == null) {
                stringExtra = "";
            } else {
                stringExtra = alS.getWebView().getUrl();
            }
            sendAppMessageTask.fZd = stringExtra;
            if (this.fYC) {
                sendAppMessageTask.fFC = new 1(this, sendAppMessageTask);
                sendAppMessageTask.ahA();
                AppBrandMainProcessService.a(sendAppMessageTask);
            } else {
                AppBrandMainProcessService.a(sendAppMessageTask);
                this.fCl.E(this.doP, this.fYQ.f("ok", null));
            }
            if (this.bAl != null) {
                h.bA(this.bAl, this.bAl.getResources().getString(s.j.app_brand_app_msg_shared));
            }
        }
    }
}
