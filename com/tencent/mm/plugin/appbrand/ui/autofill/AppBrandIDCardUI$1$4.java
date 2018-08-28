package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.b.b;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.1;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.brk;
import com.tencent.mm.protocal.c.brl;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandIDCardUI$1$4 implements b {
    final /* synthetic */ 1 gxC;

    AppBrandIDCardUI$1$4(1 1) {
        this.gxC = 1;
    }

    public final void f(boolean z, final String str) {
        if (z) {
            h.mEJ.h(14943, new Object[]{AppBrandIDCardUI.a(this.gxC.gxB), Integer.valueOf(4), AppBrandIDCardUI.g(this.gxC.gxB).bLe});
            a aVar = new a();
            aVar.dIG = new brk();
            aVar.dIH = new brl();
            aVar.uri = "/cgi-bin/mmbiz-bin/userdata/submitauthorizeuserid";
            aVar.dIF = 1721;
            aVar.dII = 0;
            aVar.dIJ = 0;
            com.tencent.mm.ab.b KT = aVar.KT();
            brk brk = (brk) KT.dID.dIL;
            brk.bPS = AppBrandIDCardUI.a(this.gxC.gxB);
            brk.skh = AppBrandIDCardUI.b(this.gxC.gxB);
            brk.ski = str;
            brk.bLe = AppBrandIDCardUI.g(this.gxC.gxB).bLe;
            AppBrandIDCardUI.d(this.gxC.gxB).show();
            com.tencent.mm.ipcinvoker.wx_extension.b.a(KT, new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
                public final void a(int i, int i2, String str, com.tencent.mm.ab.b bVar) {
                    if (AppBrandIDCardUI.d(AppBrandIDCardUI$1$4.this.gxC.gxB) != null && AppBrandIDCardUI.d(AppBrandIDCardUI$1$4.this.gxC.gxB).isShowing()) {
                        AppBrandIDCardUI.d(AppBrandIDCardUI$1$4.this.gxC.gxB).dismiss();
                    }
                    if (i == 0 && i2 == 0 && bVar.dIE.dIL != null) {
                        brl brl = (brl) bVar.dIE.dIL;
                        if (brl.skj == null) {
                            x.e("MicroMsg.AppBrandIDCardUI", "ShowAuthorizeUserIDResp.auth_base_response is err");
                            Toast.makeText(AppBrandIDCardUI$1$4.this.gxC.gxB, AppBrandIDCardUI$1$4.this.gxC.gxB.getString(j.app_brand_idcard_err_msg), 0).show();
                            return;
                        }
                        x.i("MicroMsg.AppBrandIDCardUI", "resp.auth_status:%d", new Object[]{Integer.valueOf(brl.reL)});
                        switch (brl.reL) {
                            case 0:
                                x.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", new Object[]{brl.ruV});
                                h.mEJ.h(14943, new Object[]{AppBrandIDCardUI.a(AppBrandIDCardUI$1$4.this.gxC.gxB), Integer.valueOf(9), AppBrandIDCardUI.g(AppBrandIDCardUI$1$4.this.gxC.gxB).bLe});
                                Intent intent = new Intent();
                                intent.putExtra("intent_err_code", brl.skj.bQO);
                                intent.putExtra("intent_auth_token", brl.ruV);
                                AppBrandIDCardUI$1$4.this.gxC.gxB.setResult(-1, intent);
                                AppBrandIDCardUI$1$4.this.gxC.gxB.finish();
                                return;
                            case 1:
                                h.mEJ.h(14943, new Object[]{AppBrandIDCardUI.a(AppBrandIDCardUI$1$4.this.gxC.gxB), Integer.valueOf(5), AppBrandIDCardUI.g(AppBrandIDCardUI$1$4.this.gxC.gxB).bLe});
                                AppBrandIDCardUI.a(AppBrandIDCardUI$1$4.this.gxC.gxB, str);
                                AppBrandIDCardUI.a(AppBrandIDCardUI$1$4.this.gxC.gxB, brl.spy);
                                AppBrandIDCardUI.h(AppBrandIDCardUI$1$4.this.gxC.gxB);
                                return;
                            default:
                                return;
                        }
                    }
                    x.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.dIE.dIL});
                }
            });
        }
        x.i("MicroMsg.AppBrandIDCardUI", "verifyOk:%b", new Object[]{Boolean.valueOf(z)});
    }
}
