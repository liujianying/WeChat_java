package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bkw;
import com.tencent.mm.protocal.c.bkx;
import com.tencent.mm.protocal.c.bnl;
import com.tencent.mm.protocal.c.bnm;
import com.tencent.mm.protocal.c.bxz;
import com.tencent.mm.protocal.c.bya;
import com.tencent.mm.protocal.c.ej;
import com.tencent.mm.protocal.c.ek;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class AppBrandIDCardUI$1 implements AppBrandIDCardUI$a {
    final /* synthetic */ AppBrandIDCardUI gxB;

    AppBrandIDCardUI$1(AppBrandIDCardUI appBrandIDCardUI) {
        this.gxB = appBrandIDCardUI;
    }

    public final void anI() {
        a aVar = new a();
        aVar.dIG = new bnl();
        aVar.dIH = new bnm();
        aVar.uri = "/cgi-bin/mmbiz-bin/userdata/showauthorizeuserid";
        aVar.dIF = 1774;
        aVar.dII = 0;
        aVar.dIJ = 0;
        b KT = aVar.KT();
        bnl bnl = (bnl) KT.dID.dIL;
        bnl.bPS = AppBrandIDCardUI.a(this.gxB);
        bnl.skh = AppBrandIDCardUI.b(this.gxB);
        bnl.slv = AppBrandIDCardUI.c(this.gxB);
        com.tencent.mm.ipcinvoker.wx_extension.b.a(KT, new 1(this));
    }

    public final void onSwipeBack() {
        this.gxB.onSwipeBack();
    }

    public final void back() {
        AppBrandIDCardUI.f(this.gxB);
    }

    public final void vG(String str) {
        x.i("MicroMsg.AppBrandIDCardUI", "protocalUrl click");
        vJ(str);
    }

    public final void vH(String str) {
        x.i("MicroMsg.AppBrandIDCardUI", "urlJump click");
        vJ(str);
    }

    public final void vI(String str) {
        x.i("MicroMsg.AppBrandIDCardUI", "url2Jump click");
        vJ(str);
    }

    private void vJ(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.AppBrandIDCardUI", "url is null");
            return;
        }
        x.v("MicroMsg.AppBrandIDCardUI", "goToWebview url: " + str);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("forceHideShare", true);
        d.b(this.gxB, "webview", ".ui.tools.WebViewUI", intent);
    }

    public final void anJ() {
        x.i("MicroMsg.AppBrandIDCardUI", "verifyPassword");
        h.mEJ.h(14943, new Object[]{AppBrandIDCardUI.a(this.gxB), Integer.valueOf(2), AppBrandIDCardUI.g(this.gxB).bLe});
        if (AppBrandIDCardUI.g(this.gxB).slE == null) {
            x.e("MicroMsg.AppBrandIDCardUI", "showAuthorizeUserIDResp.verify_pay_req is null");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", AppBrandIDCardUI.g(this.gxB).slE.bPS);
            jSONObject.put("timeStamp", AppBrandIDCardUI.g(this.gxB).slE.bJT);
            jSONObject.put("nonceStr", AppBrandIDCardUI.g(this.gxB).slE.rQE);
            jSONObject.put("package", AppBrandIDCardUI.g(this.gxB).slE.sus);
            jSONObject.put("signType", AppBrandIDCardUI.g(this.gxB).slE.hFk);
            jSONObject.put("paySign", AppBrandIDCardUI.g(this.gxB).slE.rQn);
            h.mEJ.h(14943, new Object[]{AppBrandIDCardUI.a(this.gxB), Integer.valueOf(3), AppBrandIDCardUI.g(this.gxB).bLe});
            com.tencent.mm.plugin.appbrand.jsapi.i.a.fWH.a(this.gxB, jSONObject, new 4(this));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandIDCardUI", e, "", new Object[0]);
        }
    }

    public final void anK() {
        h.mEJ.h(14943, new Object[]{AppBrandIDCardUI.a(this.gxB), Integer.valueOf(6), AppBrandIDCardUI.g(this.gxB).bLe});
    }

    public final void a(ej ejVar) {
        h.mEJ.h(14943, new Object[]{AppBrandIDCardUI.a(this.gxB), Integer.valueOf(7), AppBrandIDCardUI.g(this.gxB).bLe});
        x.i("MicroMsg.AppBrandIDCardUI", "sendSms");
        a aVar = new a();
        aVar.dIG = new bkw();
        aVar.dIH = new bkx();
        aVar.uri = "/cgi-bin/mmbiz-bin/userdata/sendsms";
        aVar.dIF = 1762;
        aVar.dII = 0;
        aVar.dIJ = 0;
        b KT = aVar.KT();
        bkw bkw = (bkw) KT.dID.dIL;
        bkw.bPS = AppBrandIDCardUI.a(this.gxB);
        bkw.skh = AppBrandIDCardUI.b(this.gxB);
        bkw.ski = AppBrandIDCardUI.i(this.gxB);
        bkw.reM = ejVar.reM;
        bkw.lMV = ejVar.lMV;
        bkw.bLe = AppBrandIDCardUI.g(this.gxB).bLe;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(KT, new 5(this));
    }

    public final void a(String str, ej ejVar) {
        if (bi.oW(str)) {
            x.e("MicroMsg.AppBrandIDCardUI", "verifyCode is null, err, return");
            return;
        }
        x.i("MicroMsg.AppBrandIDCardUI", "verifySms");
        a aVar = new a();
        aVar.dIG = new bxz();
        aVar.dIH = new bya();
        aVar.uri = "/cgi-bin/mmbiz-bin/userdata/verifysmscode";
        aVar.dIF = 1721;
        aVar.dII = 0;
        aVar.dIJ = 0;
        b KT = aVar.KT();
        bxz bxz = (bxz) KT.dID.dIL;
        bxz.bPS = AppBrandIDCardUI.a(this.gxB);
        bxz.skh = AppBrandIDCardUI.b(this.gxB);
        bxz.ski = AppBrandIDCardUI.i(this.gxB);
        bxz.reM = ejVar.reM;
        bxz.bLe = AppBrandIDCardUI.g(this.gxB).bLe;
        bxz.pqM = str;
        bxz.skk = AppBrandIDCardUI.j(this.gxB);
        bxz.lMV = ejVar.lMV;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(KT, new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
            public final void a(int i, int i2, String str, b bVar) {
                if (i == 0 && i2 == 0 && bVar.dIE.dIL != null) {
                    bya bya = (bya) bVar.dIE.dIL;
                    if (bya.skj != null) {
                        x.i("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response errcode:%s, errMsg:%s", new Object[]{Integer.valueOf(bya.skj.bQO), bi.oV(bya.skj.bQP)});
                        h.mEJ.h(14943, new Object[]{AppBrandIDCardUI.a(AppBrandIDCardUI$1.this.gxB), Integer.valueOf(8), AppBrandIDCardUI.g(AppBrandIDCardUI$1.this.gxB).bLe});
                        if (bya.skj.bQO == 0) {
                            h.mEJ.h(14943, new Object[]{AppBrandIDCardUI.a(AppBrandIDCardUI$1.this.gxB), Integer.valueOf(9), AppBrandIDCardUI.g(AppBrandIDCardUI$1.this.gxB).bLe});
                            x.i("MicroMsg.AppBrandIDCardUI", "verify success");
                            x.d("MicroMsg.AppBrandIDCardUI", "resq.auth_token", new Object[]{bya.ruV});
                            Intent intent = new Intent();
                            intent.putExtra("intent_err_code", bya.skj.bQO);
                            intent.putExtra("intent_auth_token", bya.ruV);
                            AppBrandIDCardUI$1.this.gxB.setResult(-1, intent);
                            AppBrandIDCardUI$1.this.gxB.finish();
                            return;
                        } else if (bya.skj.bQO == 40013) {
                            com.tencent.mm.ui.base.h.a(AppBrandIDCardUI$1.this.gxB, false, AppBrandIDCardUI$1.this.gxB.getString(j.app_brand_idcard_verify_err_msg_not_match), "", AppBrandIDCardUI$1.this.gxB.getString(j.app_brand_confirm), "", new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    x.i("MicroMsg.AppBrandIDCardUI", "[showVerifySmsAlert] btn click");
                                }
                            }, new 8(AppBrandIDCardUI$1.this));
                            return;
                        } else {
                            com.tencent.mm.ui.base.h.a(AppBrandIDCardUI$1.this.gxB, false, AppBrandIDCardUI$1.this.gxB.getString(j.app_brand_idcard_verify_err_msg_expired), "", AppBrandIDCardUI$1.this.gxB.getString(j.app_brand_confirm), "", /* anonymous class already generated */, new 8(AppBrandIDCardUI$1.this));
                            return;
                        }
                    }
                    x.e("MicroMsg.AppBrandIDCardUI", "VerifySmsCodeResp.auth_base_response is null");
                    return;
                }
                x.e("MicroMsg.AppBrandIDCardUI", "SubmitAuthorizeUserID cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.dIE.dIL});
                Toast.makeText(AppBrandIDCardUI$1.this.gxB, AppBrandIDCardUI$1.this.gxB.getString(j.app_brand_idcard_err_msg), 0).show();
            }
        });
    }

    public final bnm anL() {
        return AppBrandIDCardUI.g(this.gxB);
    }

    public final ek anM() {
        return AppBrandIDCardUI.k(this.gxB);
    }
}
