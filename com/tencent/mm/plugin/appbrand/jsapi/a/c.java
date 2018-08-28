package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.ab.b;
import com.tencent.mm.plugin.ai.a$a;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.s.d;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView;
import com.tencent.mm.protocal.c.aoz;
import com.tencent.mm.protocal.c.apa;
import com.tencent.mm.protocal.c.bla;
import com.tencent.mm.protocal.c.blb;
import com.tencent.mm.protocal.c.ou;
import com.tencent.mm.protocal.c.ov;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public final class c extends a {
    public static final int CTRL_INDEX = 209;
    public static final String NAME = "getPhoneNumber";
    String atm;
    private String bGB;
    String bTi = "";
    int fFd;
    p fJQ;
    private boolean fJR;
    String fJS;
    String fJT;
    String fJU = "";
    boolean fJV = false;
    View fJW;
    EditVerifyCodeView fJX;
    TextView fJY;
    a fJZ;
    com.tencent.mm.plugin.ai.a fKa = null;
    private com.tencent.mm.ui.widget.a.c fKb;
    int fKc = 0;
    int fKd = 0;
    int fKe = 0;
    a$a fKf = new 10(this);
    String signature;

    static /* synthetic */ void a(c cVar) {
        x.i("MicroMsg.JsApiGetPhoneNumber", "showVerifyMobileDialog");
        LayoutInflater layoutInflater = (LayoutInflater) cVar.fJQ.mContext.getSystemService("layout_inflater");
        if (cVar.fJW == null) {
            cVar.fJW = layoutInflater.inflate(h.app_brand_verify_sms_code, null);
            cVar.fJX = (EditVerifyCodeView) cVar.fJW.findViewById(g.app_brand_verify_code_view);
            cVar.fJY = (TextView) cVar.fJW.findViewById(g.app_brand_repeat_send);
        }
        if (cVar.fJW.getParent() != null) {
            ((ViewGroup) cVar.fJW.getParent()).removeAllViews();
        }
        TextView textView = (TextView) cVar.fJW.findViewById(g.app_brand_verify_mobile);
        if (cVar.fJU == null) {
            cVar.fJU = "";
        }
        textView.setText(cVar.fJQ.getContentView().getResources().getString(j.app_brand_get_phone_number_verify_mobile, new Object[]{cVar.fJU}));
        cVar.fJX.setText("");
        cVar.aig();
        OnClickListener anonymousClass18 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                x.i("MicroMsg.JsApiGetPhoneNumber", "to verify sms");
                if (!TextUtils.isEmpty(c.this.fJX.getText()) && c.this.fJX.getText().length() == 6) {
                    x.e("MicroMsg.JsApiGetPhoneNumber", "code is length is 6");
                    dialogInterface.dismiss();
                    c.this.aih();
                    c.this.fJW.post(new 1(this));
                    c cVar = c.this;
                    String str = c.this.fJX.getText().toString();
                    x.i("MicroMsg.JsApiGetPhoneNumber", "doVerifyCode");
                    b.a aVar = new b.a();
                    aVar.dIG = new ou();
                    aVar.dIH = new ov();
                    aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/checkverifycode";
                    aVar.dIF = 1010;
                    aVar.dII = 0;
                    aVar.dIJ = 0;
                    b KT = aVar.KT();
                    ou ouVar = (ou) KT.dID.dIL;
                    ouVar.bPS = cVar.fJQ.mAppId;
                    ouVar.bTi = cVar.bTi;
                    ouVar.pqM = str;
                    com.tencent.mm.ipcinvoker.wx_extension.b.a(KT, new 5(cVar, com.tencent.mm.ui.base.h.a(cVar.fJQ.mContext, "", false, null)));
                } else if (TextUtils.isEmpty(c.this.fJX.getText()) || c.this.fJX.getText().length() >= 6) {
                    x.e("MicroMsg.JsApiGetPhoneNumber", "code is empty");
                    com.tencent.mm.ui.base.h.bA(c.this.fJQ.mContext, c.this.fJQ.getContentView().getResources().getString(j.app_brand_get_phone_number_verify_code_error_empty));
                } else {
                    com.tencent.mm.ui.base.h.bA(c.this.fJQ.mContext, c.this.fJQ.getContentView().getResources().getString(j.app_brand_get_phone_number_verify_code_error_format));
                    x.e("MicroMsg.JsApiGetPhoneNumber", "code is length is < 6");
                }
            }
        };
        cVar.fKb = com.tencent.mm.ui.base.h.a(cVar.fJQ.mContext, false, cVar.fJQ.getContentView().getResources().getString(j.app_brand_get_phone_number_verify_sms_title), cVar.fJW, cVar.fJQ.getContentView().getResources().getString(j.app_ok), cVar.fJQ.getContentView().getResources().getString(j.app_cancel), anonymousClass18, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                x.i("MicroMsg.JsApiGetPhoneNumber", "cancel to verify sms");
                dialogInterface.dismiss();
                c.this.fJQ.E(c.this.fFd, c.this.f("fail:cancel to verify sms", null));
                c.this.aih();
                c.this.fJW.post(new 1(this));
                com.tencent.mm.plugin.report.service.h.mEJ.h(14249, new Object[]{c.this.fJQ.mAppId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(c.this.fKd), Integer.valueOf(c.this.fKe), Integer.valueOf(c.this.fKc)});
            }
        });
        cVar.fKb.a(cVar.fJQ.getContentView().getResources().getString(j.app_ok), false, anonymousClass18);
        cVar.fJW.post(new 3(cVar));
    }

    static /* synthetic */ void b(c cVar) {
        x.i("MicroMsg.JsApiGetPhoneNumber", "doSendVerifyCode");
        b.a aVar = new b.a();
        aVar.dIG = new bla();
        aVar.dIH = new blb();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/sendverifycode";
        aVar.dIF = 1024;
        aVar.dII = 0;
        aVar.dIJ = 0;
        b KT = aVar.KT();
        bla bla = (bla) KT.dID.dIL;
        bla.bPS = cVar.fJQ.mAppId;
        bla.bTi = cVar.bTi;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(KT, new 17(cVar, com.tencent.mm.ui.base.h.a(cVar.fJQ.mContext, "", false, null)));
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber data is null");
            pVar.E(i, f("fail:data is null", null));
            return;
        }
        this.fJQ = pVar;
        this.fFd = i;
        x.i("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber data:%s", new Object[]{jSONObject.toString()});
        Object optString = jSONObject.optString("api_name", "webapi_getuserwxphone");
        boolean optBoolean = jSONObject.optBoolean("with_credentials", true);
        if (TextUtils.isEmpty(optString)) {
            x.e("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber api_name is null");
            pVar.E(i, f("fail:api_name is null", null));
            return;
        }
        e.a(pVar.mAppId, new 1(this, pVar));
        this.bGB = optString;
        this.fJR = optBoolean;
        aie();
    }

    final void aie() {
        x.i("MicroMsg.JsApiGetPhoneNumber", "requestBindPhoneNumber");
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.object();
            jSONStringer.key("api_name");
            jSONStringer.value(this.bGB);
            jSONStringer.key("with_credentials");
            jSONStringer.value(this.fJR);
            jSONStringer.endObject();
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiGetPhoneNumber", "JSONException:%s", new Object[]{e.getMessage()});
        }
        x.i("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber appId:%s, api_name:%s, with_credentials:%b", new Object[]{this.fJQ.mAppId, this.bGB, Boolean.valueOf(this.fJR)});
        b.a aVar = new b.a();
        aVar.dIG = new aoz();
        aVar.dIH = new apa();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-getuserwxphone";
        aVar.dIF = 1141;
        aVar.dII = 0;
        aVar.dIJ = 0;
        b KT = aVar.KT();
        aoz aoz = (aoz) KT.dID.dIL;
        aoz.jQb = this.fJQ.mAppId;
        aoz.hbs = new com.tencent.mm.bk.b(jSONStringer.toString().getBytes());
        com.tencent.mm.ipcinvoker.wx_extension.b.a(KT, new 11(this));
    }

    final void aif() {
        x.i("MicroMsg.JsApiGetPhoneNumber", "doSuccCallback");
        Map hashMap = new HashMap(5);
        hashMap.put("encryptedData", this.fJT);
        hashMap.put("iv", this.atm);
        this.fJQ.E(this.fFd, f("ok", hashMap));
    }

    final void aig() {
        x.i("MicroMsg.JsApiGetPhoneNumber", "updateSendText()");
        Object string = this.fJQ.getContentView().getResources().getString(j.app_brand_get_phone_number_not_receive_verify_code);
        Object string2 = this.fJQ.getContentView().getResources().getString(j.app_brand_get_phone_number_resend_verify_code);
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(string);
        spannableStringBuilder.append(string2);
        int length = string.length();
        int length2 = string2.length();
        spannableStringBuilder.setSpan(new ClickableSpan() {
            public final void onClick(View view) {
                x.i("MicroMsg.JsApiGetPhoneNumber", "click the resend spanBuilder, do resend sms");
                if (c.this.fJV) {
                    c.b(c.this);
                    return;
                }
                x.e("MicroMsg.JsApiGetPhoneNumber", "allow_send_sms is false, show send_verify_code_frequent error");
                c.this.tn(c.this.fJQ.getContentView().getResources().getString(j.app_brand_get_phone_number_send_verify_code_frequent));
            }
        }, length, length + length2, 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.fJQ.mContext.getResources().getColor(d.link_color)), length, length2 + length, 17);
        this.fJY.setText(spannableStringBuilder);
        this.fJY.setMovementMethod(LinkMovementMethod.getInstance());
    }

    final void tn(String str) {
        aih();
        com.tencent.mm.ui.base.h.a(this.fJQ.mContext, str, "", false, new 7(this));
    }

    final void aih() {
        x.i("MicroMsg.JsApiGetPhoneNumber", "stopSmsListener");
        if (this.fJZ != null) {
            this.fJZ.cancel();
        }
        if (this.fKa != null) {
            this.fKa.stop();
            this.fKa.ngW = null;
        }
    }
}
