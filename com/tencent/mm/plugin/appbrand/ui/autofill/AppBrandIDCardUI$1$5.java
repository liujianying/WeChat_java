package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.widget.Toast;
import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1;
import com.tencent.mm.protocal.c.bkx;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandIDCardUI$1$5 implements a {
    final /* synthetic */ 1 gxC;

    AppBrandIDCardUI$1$5(1 1) {
        this.gxC = 1;
    }

    public final void a(int i, int i2, String str, b bVar) {
        if (i == 0 && i2 == 0 && bVar.dIE.dIL != null) {
            bkx bkx = (bkx) bVar.dIE.dIL;
            if (bkx.skj != null) {
                x.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response.err_code:%d", new Object[]{Integer.valueOf(bkx.skj.bQO)});
                if (bkx.skj.bQO == 0) {
                    this.gxC.gxB.gxA = bkx.skk;
                    x.i("MicroMsg.AppBrandIDCardUI", "send success, verifyToken:%s", new Object[]{bkx.skk});
                    return;
                }
                1.a(this.gxC, this.gxC.gxB.getString(j.app_brand_idcard_verify_send_sms_fail));
                return;
            }
            x.i("MicroMsg.AppBrandIDCardUI", "SendSmsResp.auth_base_response is null");
            1.a(this.gxC, this.gxC.gxB.getString(j.app_brand_idcard_verify_send_sms_fail));
            return;
        }
        x.e("MicroMsg.AppBrandIDCardUI", "sendSms cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.dIE.dIL});
        Toast.makeText(this.gxC.gxB, this.gxC.gxB.getString(j.app_brand_idcard_err_msg), 0).show();
    }
}
