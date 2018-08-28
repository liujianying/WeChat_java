package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.app.Activity;
import com.tencent.mm.plugin.appbrand.jsapi.a.c.17;
import com.tencent.mm.plugin.appbrand.jsapi.a.c.9;
import com.tencent.mm.plugin.appbrand.jsapi.a.c.a;
import com.tencent.mm.plugin.appbrand.s.b;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.blb;
import com.tencent.mm.sdk.platformtools.x;

class c$17$1 implements Runnable {
    final /* synthetic */ blb fKr;
    final /* synthetic */ 17 fKs;

    c$17$1(17 17, blb blb) {
        this.fKs = 17;
        this.fKr = blb;
    }

    public final void run() {
        c cVar = this.fKs.fKg;
        int i = this.fKr.status;
        x.i("MicroMsg.JsApiGetPhoneNumber", "handleSendVerifyCodeStatus:%d", new Object[]{Integer.valueOf(i)});
        if (i == 0) {
            x.i("MicroMsg.JsApiGetPhoneNumber", "startSmsListener");
            if (cVar.fJZ != null) {
                cVar.fJZ.cancel();
            } else {
                cVar.fJZ = new a(cVar);
            }
            cVar.fJZ.start();
            if (cVar.fKa == null) {
                cVar.fKa = new com.tencent.mm.plugin.ai.a(cVar.fJQ.mContext);
            }
            cVar.fKa.eNC = cVar.fJQ.getContentView().getResources().getStringArray(b.appbrand_sms_content);
            cVar.fKa.ngW = cVar.fKf;
            com.tencent.mm.plugin.appbrand.a.a(cVar.fJQ.mAppId, new 9(cVar));
            boolean a = com.tencent.mm.pluginsdk.permission.a.a((Activity) cVar.fJQ.mContext, "android.permission.READ_SMS", 128, "", "");
            if (a) {
                com.tencent.mm.plugin.appbrand.a.pZ(cVar.fJQ.mAppId);
            }
            if (a) {
                x.i("MicroMsg.JsApiGetPhoneNumber", "request sms permission success");
            } else {
                x.e("MicroMsg.JsApiGetPhoneNumber", "request sms permission fail");
            }
            cVar.fKa.start();
        } else if (i == 1 || i != 2) {
            cVar.tn(cVar.fJQ.getContentView().getResources().getString(j.app_brand_get_phone_number_send_verify_code_fail));
            h.mEJ.h(14249, new Object[]{cVar.fJQ.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(cVar.fKd), Integer.valueOf(cVar.fKe), Integer.valueOf(cVar.fKc)});
        } else {
            cVar.tn(cVar.fJQ.getContentView().getResources().getString(j.app_brand_get_phone_number_send_verify_code_frequent));
            h.mEJ.h(14249, new Object[]{cVar.fJQ.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(cVar.fKd), Integer.valueOf(cVar.fKe), Integer.valueOf(cVar.fKc)});
        }
    }
}
