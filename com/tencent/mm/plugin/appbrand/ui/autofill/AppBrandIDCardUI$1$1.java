package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.Intent;
import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.wx_extension.b$a;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1;
import com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1.2;
import com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1.3;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class AppBrandIDCardUI$1$1 implements b$a {
    final /* synthetic */ 1 gxC;

    AppBrandIDCardUI$1$1(1 1) {
        this.gxC = 1;
    }

    public final void a(int i, int i2, String str, b bVar) {
        if (AppBrandIDCardUI.d(this.gxC.gxB) != null && AppBrandIDCardUI.d(this.gxC.gxB).isShowing()) {
            AppBrandIDCardUI.d(this.gxC.gxB).dismiss();
        }
        Intent intent;
        if (i == 0 && i2 == 0 && bVar.dIE.dIL != null) {
            bnm bnm = (bnm) bVar.dIE.dIL;
            if (bnm.skj == null) {
                x.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
                intent = new Intent();
                intent.putExtra("intent_err_code", 40000);
                intent.putExtra("intent_err_msg", "network err");
                this.gxC.gxB.setResult(1, intent);
                this.gxC.gxB.finish();
                return;
            }
            x.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response.err_code is %d", new Object[]{Integer.valueOf(bnm.skj.bQO)});
            x.i("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status:%d", new Object[]{Integer.valueOf(bnm.slw)});
            switch (bnm.slw) {
                case 0:
                    if (bnm.skj.bQO != 0) {
                        x.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is not ok");
                        intent = new Intent();
                        intent.putExtra("intent_err_code", bnm.skj.bQO);
                        intent.putExtra("intent_err_msg", bnm.skj.bQP);
                        this.gxC.gxB.setResult(1, intent);
                        this.gxC.gxB.finish();
                        return;
                    }
                    AppBrandIDCardUI.a(this.gxC.gxB, bnm);
                    AppBrandIDCardUI.e(this.gxC.gxB);
                    return;
                case 1:
                    x.i("MicroMsg.AppBrandIDCardUI", "showAlert errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(bnm.skj.bQO), bnm.skj.bQP});
                    1 1 = this.gxC;
                    h.a(1.gxB, false, bnm.slx.desc, bnm.slx.title, 1.gxB.getString(j.app_brand_idcard_show_alert_ok), "", new 2(1, bnm.skj.bQO, bnm.skj.bQP), new 3(1));
                    return;
                default:
                    x.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.show_status error");
                    return;
            }
        }
        x.e("MicroMsg.AppBrandIDCardUI", "getIDCardInfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.dIE.dIL});
        intent = new Intent();
        intent.putExtra("intent_err_code", 40000);
        intent.putExtra("intent_err_msg", "network err");
        this.gxC.gxB.setResult(1, intent);
        this.gxC.gxB.finish();
    }
}
