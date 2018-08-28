package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.modelpay.PayReq.Options;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.plugin.wallet_index.ui.e;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class WXPayEntryActivity extends AutoLoginActivity {
    private String eeY = null;
    private long hej = 0;

    public void onCreate(Bundle bundle) {
        this.hej = System.currentTimeMillis();
        s.b(getIntent(), "key_auto_login_wizard_exit", true);
        super.onCreate(bundle);
    }

    protected final boolean A(Intent intent) {
        return true;
    }

    protected final void a(a aVar, Intent intent) {
        boolean z = true;
        if (intent == null) {
            finish();
            return;
        }
        x.i("MicroMsg.WXPayEntryActivity", "postLogin, delegate intent to OrderHandlerUI, resultCode = " + aVar);
        switch (1.hdM[aVar.ordinal()]) {
            case 1:
                x.i("MicroMsg.WXPayEntryActivity", "coreaccount st %s", new Object[]{Boolean.valueOf(com.tencent.mm.kernel.a.Dr())});
                if (com.tencent.mm.kernel.a.Dr()) {
                    finish();
                    return;
                }
                break;
            case 2:
                mY(-2);
                x.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = " + aVar);
                finish();
                return;
            case 3:
                mY(-1);
                x.e("MicroMsg.WXPayEntryActivity", "postLogin fail, loginResult = " + aVar);
                finish();
                return;
            default:
                x.e("MicroMsg.WXPayEntryActivity", "postLogin, unknown login result = " + aVar);
                break;
        }
        this.eeY = s.j(intent, ConstantsAPI.APP_PACKAGE);
        x.i("MicroMsg.WXPayEntryActivity", "postLogin, getCallingPackage success, value = " + this.eeY);
        if (getIntent() == null || s.aq(getIntent()) == null) {
            z = false;
        } else {
            PayReq payReq = new PayReq();
            payReq.fromBundle(s.aq(getIntent()));
            String str = payReq.appId;
            x.d("MicroMsg.WXPayEntryActivity", "postLogin, appId = " + str);
            if (str == null || str.length() == 0) {
                x.e("MicroMsg.WXPayEntryActivity", "checkApp fail, appId is null");
                z = false;
            } else {
                f bl = g.bl(str, true);
                if (bl == null) {
                    x.w("MicroMsg.WXPayEntryActivity", "checkApp fail, not reg");
                    bl = new f();
                    bl.field_appId = str;
                    bl.field_appName = "";
                    bl.field_packageName = this.eeY;
                    bl.field_status = 0;
                    String bg = p.bg(this, this.eeY);
                    if (bg != null) {
                        bl.field_signature = bg;
                    }
                    if (ao.bmf().l(bl) && bi.oW(bl.field_openId)) {
                        x.d("MicroMsg.WXPayEntryActivity", "checkApp, trigger getAppSetting, appId = " + str);
                        ao.bmh().pS(str);
                    }
                } else if (bl.field_status == 3) {
                    x.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app is in blacklist");
                    z = false;
                } else if (!p.c(this, bl, this.eeY)) {
                    a(this, bl, this.eeY);
                    x.e("MicroMsg.WXPayEntryActivity", "checkApp fail, app invalid");
                    z = false;
                }
            }
        }
        if (!z) {
            x.e("MicroMsg.WXPayEntryActivity", "postLogin, checkApp fail");
        }
        try {
            intent.putExtra("key_scene", 0);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.IntentUtil", e, "", new Object[0]);
        }
        Bundle aq = s.aq(intent);
        aq.putLong("wallet_pay_key_check_time", this.hej);
        h.a(this, aq, z, "");
        finish();
    }

    private static void a(Context context, f fVar, String str) {
        Signature[] bh = p.bh(context, str);
        Object obj = "";
        if (bh != null && bh.length > 0) {
            for (Signature toByteArray : bh) {
                obj = obj + p.Tb(com.tencent.mm.a.g.u(toByteArray.toByteArray())) + "|";
            }
        }
        if (obj.length() > 1) {
            obj = obj.substring(0, obj.length() - 1);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("raw_package_name", bi.aG(str, ""));
            jSONObject.put("package_name", bi.aG(fVar.field_packageName, ""));
            jSONObject.put("raw_signature", obj);
            jSONObject.put("signature", bi.aG(fVar.field_signature, ""));
            jSONObject.put("scene", 5);
        } catch (Exception e) {
            x.i("MicroMsg.WXPayEntryActivity", "doIfAppInValid, jsonException = " + e.getMessage());
        }
        gt gtVar = new gt();
        gtVar.bPU.appId = fVar.field_appId;
        gtVar.bPU.opType = 3;
        gtVar.bPU.bJv = jSONObject.toString();
        com.tencent.mm.sdk.b.a.sFg.m(gtVar);
    }

    private void mY(int i) {
        PayReq payReq = new PayReq();
        payReq.fromBundle(s.aq(getIntent()));
        Options options = new Options();
        options.fromBundle(s.aq(getIntent()));
        PayResp payResp = new PayResp();
        payResp.prepayId = payReq.prepayId;
        payResp.extData = payReq.extData;
        payResp.errCode = i;
        e.a(this, s.j(getIntent(), ConstantsAPI.APP_PACKAGE), payResp, options);
    }
}
