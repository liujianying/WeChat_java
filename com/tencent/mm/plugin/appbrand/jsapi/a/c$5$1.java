package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.jsapi.a.c.5;
import com.tencent.mm.plugin.appbrand.jsapi.a.c.6;
import com.tencent.mm.plugin.appbrand.s$j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ov;
import com.tencent.mm.sdk.platformtools.x;

class c$5$1 implements Runnable {
    final /* synthetic */ ov fKj;
    final /* synthetic */ 5 fKk;

    c$5$1(5 5, ov ovVar) {
        this.fKk = 5;
        this.fKj = ovVar;
    }

    public final void run() {
        if (this.fKj.status == 0) {
            x.d("MicroMsg.JsApiGetPhoneNumber", "encryptedData:%s, iv:%s", this.fKj.fJT, this.fKj.atm);
            if (!TextUtils.isEmpty(this.fKj.fJT)) {
                this.fKk.fKg.fJT = this.fKj.fJT;
            }
            if (!TextUtils.isEmpty(this.fKj.atm)) {
                this.fKk.fKg.atm = this.fKj.atm;
            }
        }
        c cVar = this.fKk.fKg;
        int i = this.fKj.status;
        x.i("MicroMsg.JsApiGetPhoneNumber", "handleCheckVerifyCodeStatus:%d", Integer.valueOf(i));
        if (i == 0) {
            h.mEJ.h(14249, cVar.fJQ.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(cVar.fKd), Integer.valueOf(cVar.fKe), Integer.valueOf(cVar.fKc));
            cVar.aif();
        } else if (i == 1) {
            cVar.tn(cVar.fJQ.getContentView().getResources().getString(s$j.app_brand_get_phone_number_send_verify_code_frequent));
            h.mEJ.h(14249, cVar.fJQ.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(cVar.fKd), Integer.valueOf(cVar.fKe), Integer.valueOf(cVar.fKc));
        } else if (i == 3 || i == 4) {
            com.tencent.mm.ui.base.h.a(cVar.fJQ.mContext, cVar.fJQ.getContentView().getResources().getString(s$j.app_brand_get_phone_number_verify_code_error), "", false, new 6(cVar));
        } else {
            cVar.tn(cVar.fJQ.getContentView().getResources().getString(s$j.app_brand_get_phone_number_verify_code_fail));
            h.mEJ.h(14249, cVar.fJQ.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(cVar.fKd), Integer.valueOf(cVar.fKe), Integer.valueOf(cVar.fKc));
        }
    }
}
