package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.a.g;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.azb;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.c.u;

@a(3)
public class OrderHandlerUI extends MMActivity implements e {
    private String bOd;
    private String eeY;
    private int fdx = 0;
    private long hej = 0;
    private c lSI = new 1(this);
    private Options options;
    private PayReq pDs;
    private PayResp pDt;
    private boolean pDu = false;
    private String pDv = "";
    private boolean pDw = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hej = getIntent().getLongExtra("wallet_pay_key_check_time", -1);
        ux(8);
        q.cDf();
        com.tencent.mm.sdk.b.a.sFg.b(this.lSI);
    }

    protected void onResume() {
        Throwable e;
        com.tencent.mm.plugin.wallet_index.c.e eVar;
        super.onResume();
        PayReq payReq = new PayReq();
        payReq.fromBundle(getIntent().getExtras());
        if (this.pDs == null || !(payReq.prepayId == null || payReq.prepayId.equals(this.pDs.prepayId))) {
            this.pDs = payReq;
            this.fdx = getIntent().getIntExtra("key_scene", 0);
            x.i("MicroMsg.OrderHandlerUI", "onCreate() mScene is " + this.fdx);
            if (this.fdx == 0) {
                this.eeY = getIntent().getStringExtra("_mmessage_appPackage");
                if (this.eeY == null || this.eeY.length() == 0) {
                    x.e("MicroMsg.OrderHandlerUI", "callerPkgName is null, dealOrder fail, can not callback");
                    finish();
                    return;
                }
            }
            this.options = new Options();
            this.options.fromBundle(getIntent().getExtras());
            this.pDt = new PayResp();
            this.pDt.prepayId = payReq.prepayId;
            this.pDt.extData = payReq.extData;
            String str = "";
            if (this.fdx == 0) {
                if (!payReq.checkArgs()) {
                    x.e("MicroMsg.OrderHandlerUI", "onCreate, PayReq checkArgs fail");
                    this.pDt.errCode = -1;
                    this.pDt.errStr = getString(a$i.pay_callback_errmsg_req_checkargs_fail);
                    e.a(this, this.eeY, this.pDt, this.options);
                    finish();
                    return;
                } else if (!getIntent().getBooleanExtra("orderhandlerui_checkapp_result", false)) {
                    x.e("MicroMsg.OrderHandlerUI", "onCreate, checkAppResult fail");
                    this.pDt.errCode = -1;
                    e.a(this, this.eeY, this.pDt, this.options);
                    finish();
                    return;
                }
            } else if (this.fdx == 1) {
                str = "WAP";
            }
            String stringExtra = getIntent().getStringExtra("_mmessage_appPackage");
            String str2 = "";
            String str3 = "";
            try {
                getPackageManager().getPackageInfo(stringExtra, 0);
                String str4 = (String) getPackageManager().getPackageInfo(stringExtra, 0).applicationInfo.loadLabel(getPackageManager());
                try {
                    Signature[] bh = p.bh(this, stringExtra);
                    if (bh == null || bh.length == 0) {
                        x.e("MicroMsg.AppUtil", "signs is null");
                        str3 = null;
                    } else {
                        str3 = g.u(bh[0].toByteArray());
                    }
                    str2 = str4;
                } catch (NameNotFoundException e2) {
                    e = e2;
                    str2 = str4;
                    x.printErrStackTrace("MicroMsg.OrderHandlerUI", e, "", new Object[0]);
                    x.i("MicroMsg.OrderHandlerUI", "packagename app %s displayname %s androidSign %s", new Object[]{stringExtra, str2, str3});
                    com.tencent.mm.kernel.g.Ek();
                    com.tencent.mm.kernel.g.Eh().dpP.a(397, this);
                    eVar = new com.tencent.mm.plugin.wallet_index.c.e(payReq, str, stringExtra, str2, str3);
                    com.tencent.mm.kernel.g.Ek();
                    com.tencent.mm.kernel.g.Eh().dpP.a(eVar, 0);
                }
            } catch (Throwable e3) {
                e = e3;
                x.printErrStackTrace("MicroMsg.OrderHandlerUI", e, "", new Object[0]);
                x.i("MicroMsg.OrderHandlerUI", "packagename app %s displayname %s androidSign %s", new Object[]{stringExtra, str2, str3});
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Eh().dpP.a(397, this);
                eVar = new com.tencent.mm.plugin.wallet_index.c.e(payReq, str, stringExtra, str2, str3);
                com.tencent.mm.kernel.g.Ek();
                com.tencent.mm.kernel.g.Eh().dpP.a(eVar, 0);
            }
            x.i("MicroMsg.OrderHandlerUI", "packagename app %s displayname %s androidSign %s", new Object[]{stringExtra, str2, str3});
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.a(397, this);
            eVar = new com.tencent.mm.plugin.wallet_index.c.e(payReq, str, stringExtra, str2, str3);
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.a(eVar, 0);
        }
    }

    protected void onDestroy() {
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(397, this);
        com.tencent.mm.sdk.b.a.sFg.c(this.lSI);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.order_handle_ui;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == 397) {
            PayInfo payInfo = new PayInfo();
            if (this.fdx == 1) {
                payInfo.bVY = 36;
            } else {
                payInfo.bVY = 2;
            }
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.b(397, this);
            x.i("MicroMsg.OrderHandlerUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
            com.tencent.mm.plugin.wallet_index.c.e eVar = (com.tencent.mm.plugin.wallet_index.c.e) lVar;
            azb azb = (azb) eVar.diG.dIE.dIL;
            this.pDv = azb == null ? null : azb.sbS;
            int i3;
            String str2;
            if (i == 4 && i2 == -5) {
                x.e("MicroMsg.OrderHandlerUI", "onSceneEnd, auth access denied");
                this.pDt.errCode = -1;
                bc(str, true);
                i3 = payInfo.bVY;
                if (this.pDs == null) {
                    str2 = "";
                } else {
                    str2 = this.pDs.prepayId;
                }
                u.j(i3, str2, i2);
            } else if (i == 0 && i2 == 0) {
                azb = (azb) eVar.diG.dIE.dIL;
                i3 = azb == null ? -1 : azb.iwS;
                azb = (azb) eVar.diG.dIE.dIL;
                String str3 = azb == null ? null : azb.iwT;
                azb = (azb) eVar.diG.dIE.dIL;
                String str4 = azb == null ? null : azb.rEf;
                azb = (azb) eVar.diG.dIE.dIL;
                x.i("MicroMsg.OrderHandlerUI", "onSceneEnd, respErrCode = %d, respErrMsg = %s, respPrepayId = %s, respAppSource = %s", new Object[]{Integer.valueOf(i3), str3, str4, azb == null ? null : azb.rEg});
                if (bi.oW(str4)) {
                    x.e("MicroMsg.OrderHandlerUI", "onSceneEnd, respPrepayId is null");
                    this.pDt.errCode = -1;
                    bc(str, true);
                    return;
                }
                u.j(payInfo.bVY, str4, i2);
                payInfo.appId = this.pDs.appId;
                payInfo.bOd = str4;
                payInfo.partnerId = this.pDs.partnerId;
                payInfo.pCO = str2;
                payInfo.qUK = String.valueOf(i3);
                payInfo.Yy = str3;
                if (this.hej > 0) {
                    h.mEJ.a(641, 1, 1, true);
                    h.mEJ.a(641, 2, bi.bH(this.hej), true);
                    if (payInfo.qUL == null) {
                        payInfo.qUL = new Bundle();
                    }
                    payInfo.qUL.putLong("wallet_pay_key_check_time", this.hej);
                }
                this.bOd = payInfo.bOd;
                com.tencent.mm.pluginsdk.wallet.h.a(this, payInfo, 123);
                this.pDu = false;
            } else {
                x.e("MicroMsg.OrderHandlerUI", "onSceneEnd,  PayAuthApp is failed!");
                this.pDt.errCode = -1;
                bc(str, true);
                u.j(payInfo.bVY, this.pDs == null ? "" : this.pDs.prepayId, i2);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.pDt != null && !this.pDu) {
            x.e("MicroMsg.OrderHandlerUI", "onActivityResult, onPayEnd not called");
            this.pDt.errCode = -2;
            bc("", false);
        }
    }

    private void bc(String str, boolean z) {
        if (this.fdx != 1) {
            e.a(this, this.eeY, this.pDt, this.options);
            finish();
        } else if (TextUtils.isEmpty(this.pDv) && z) {
            ux(0);
            if (TextUtils.isEmpty(str)) {
                str = getString(a$i.wallet_unknown_err);
            }
            com.tencent.mm.ui.base.h.a(this, str, null, false, new 2(this));
        } else {
            aS(this, this.pDv);
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        x.i("MicroMsg.OrderHandlerUI", "onConfigurationChanged");
    }

    private static void aS(Context context, String str) {
        if (context == null) {
            x.e("MicroMsg.OrderHandlerUI", "startOuterApp context == null");
        } else if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.OrderHandlerUI", "startOuterApp callbackUrl is empty");
        } else {
            x.i("MicroMsg.OrderHandlerUI", "startOuterApp callbackUrl is " + str);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            if (bi.k(context, intent)) {
                context.startActivity(intent);
            }
        }
    }
}
