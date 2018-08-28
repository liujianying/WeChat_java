package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.modelappbrand.b.f;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.jsapi.a.c.12;
import com.tencent.mm.plugin.appbrand.jsapi.a.c.15;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.s$d;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.protocal.c.apa;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import org.json.JSONException;
import org.json.JSONObject;

class c$11 implements a {
    final /* synthetic */ c fKg;

    c$11(c cVar) {
        this.fKg = cVar;
    }

    public final void a(int i, int i2, String str, b bVar) {
        if (i == 0 && i2 == 0 && bVar.dIE.dIL != null) {
            x.i("MicroMsg.JsApiGetPhoneNumber", "JsOperateWxData success");
            final apa apa = (apa) bVar.dIE.dIL;
            this.fKg.fJQ.getContentView().post(new Runnable() {
                public final void run() {
                    c cVar = c$11.this.fKg;
                    apa apa = apa;
                    x.i("MicroMsg.JsApiGetPhoneNumber", "handleOperateWxData");
                    Object obj = "";
                    if (apa.hbs != null) {
                        obj = apa.hbs.cfV();
                    }
                    x.i("MicroMsg.JsApiGetPhoneNumber", "resp data:%s", new Object[]{obj});
                    if (TextUtils.isEmpty(obj)) {
                        x.e("MicroMsg.JsApiGetPhoneNumber", "resp data is empty");
                        cVar.fJQ.E(cVar.fFd, cVar.f("fail:resp data is empty", null));
                        return;
                    }
                    String str;
                    CharSequence charSequence;
                    Object obj2 = apa.rbh;
                    CharSequence charSequence2 = apa.jSv;
                    String str2 = "";
                    String str3 = "";
                    if (apa.rRk != null) {
                        str2 = apa.rRk.jOS;
                        cVar.fJU = apa.rRk.fJU;
                        str = apa.rRk.rQD;
                        charSequence = str2;
                    } else {
                        str = str3;
                        Object charSequence3 = str2;
                    }
                    x.i("MicroMsg.JsApiGetPhoneNumber", "appName:%s, desc:%s, IconUrl:%s, ext_desc:%s", new Object[]{charSequence2, charSequence3, obj2, cVar.fJU});
                    JSONObject jSONObject = null;
                    try {
                        jSONObject = new JSONObject(obj);
                    } catch (JSONException e) {
                        x.e("MicroMsg.JsApiGetPhoneNumber", "new data json exception:%s", new Object[]{e.getMessage()});
                    }
                    if (jSONObject == null) {
                        x.e("MicroMsg.JsApiGetPhoneNumber", "jsonObj is null");
                        cVar.fJQ.E(cVar.fFd, cVar.f("fail:jsonObj is null", null));
                        return;
                    }
                    boolean z;
                    cVar.fJS = jSONObject.optString("data");
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (optJSONObject == null && !TextUtils.isEmpty(cVar.fJS)) {
                        try {
                            optJSONObject = new JSONObject(cVar.fJS);
                        } catch (JSONException e2) {
                            x.e("MicroMsg.JsApiGetPhoneNumber", "new dataJson exist exception, e:%s", new Object[]{e2.getMessage()});
                        }
                    }
                    if (optJSONObject != null) {
                        cVar.bTi = optJSONObject.optString("mobile");
                        boolean optBoolean = optJSONObject.optBoolean("need_auth", false);
                        cVar.fJV = optJSONObject.optBoolean("allow_send_sms", false);
                        z = optBoolean;
                    } else {
                        z = false;
                    }
                    cVar.signature = jSONObject.optString("signature");
                    cVar.fJT = jSONObject.optString("encryptedData");
                    cVar.atm = jSONObject.optString("iv");
                    x.i("MicroMsg.JsApiGetPhoneNumber", "mobile:%s, need_auth:%b, allow_send_sms:%b", new Object[]{cVar.bTi, Boolean.valueOf(z), Boolean.valueOf(cVar.fJV)});
                    if (cVar.fKc == 0) {
                        if (TextUtils.isEmpty(cVar.bTi)) {
                            cVar.fKc = 3;
                        } else if (z) {
                            cVar.fKc = 2;
                        } else {
                            cVar.fKc = 1;
                        }
                    }
                    if (TextUtils.isEmpty(cVar.bTi)) {
                        x.i("MicroMsg.JsApiGetPhoneNumber", "show the confirm bind phone dialog");
                        h.a(cVar.fJQ.mContext, false, cVar.fJQ.getContentView().getResources().getString(j.app_brand_get_phone_number_no_bind_phone_msg), cVar.fJQ.getContentView().getResources().getString(j.app_brand_get_phone_number_no_bind_phone_title), cVar.fJQ.getContentView().getResources().getString(j.app_brand_get_phone_number_to_bind_phone), cVar.fJQ.getContentView().getResources().getString(j.app_cancel), new 15(cVar), new c$16(cVar), s$d.green_text_color, s$d.green_text_color);
                        return;
                    }
                    x.i("MicroMsg.JsApiGetPhoneNumber", "show the confirm login dialog");
                    LayoutInflater layoutInflater = (LayoutInflater) cVar.fJQ.mContext.getSystemService("layout_inflater");
                    View inflate = layoutInflater.inflate(s.h.app_brand_get_phone_number_do_login, null);
                    ImageView imageView = (ImageView) inflate.findViewById(g.app_brand_get_phone_number_logo);
                    TextView textView = (TextView) inflate.findViewById(g.app_brand_get_phone_number_brand_name);
                    ImageView imageView2 = (ImageView) inflate.findViewById(g.app_brand_get_phone_number_question);
                    TextView textView2 = (TextView) inflate.findViewById(g.app_brand_get_phone_number_desc);
                    TextView textView3 = (TextView) inflate.findViewById(g.app_brand_get_phone_number_phone);
                    View inflate2 = layoutInflater.inflate(s.h.app_brand_get_phone_number_do_expose, null);
                    TextView textView4 = (TextView) inflate2.findViewById(g.app_brand_get_phone_number_expose_url);
                    if (bi.oW(str)) {
                        str = cVar.fJQ.getContentView().getResources().getString(j.app_brand_get_phone_number_expose_desc_default);
                    }
                    String string = cVar.fJQ.getContentView().getResources().getString(j.app_brand_get_phone_number_expose_desc_end);
                    WxaExposedParams.a aVar = new WxaExposedParams.a();
                    aVar.appId = cVar.fJQ.mAppId;
                    aVar.bVs = cVar.fJQ.gns.getPageURL();
                    aVar.bJu = 8;
                    a aVar2 = new a(n.a(aVar.aeo()));
                    CharSequence spannableString = new SpannableString(str + string);
                    spannableString.setSpan(aVar2, str.length(), str.length() + string.length(), 18);
                    textView4.setMovementMethod(LinkMovementMethod.getInstance());
                    textView4.setText(spannableString);
                    if (TextUtils.isEmpty(charSequence2)) {
                        textView.setVisibility(8);
                    } else {
                        textView.setText(charSequence2);
                        textView.setVisibility(0);
                    }
                    textView2.setText(charSequence3);
                    if (TextUtils.isEmpty(cVar.fJU)) {
                        textView3.setVisibility(8);
                    } else {
                        textView3.setText(cVar.fJU);
                        textView3.setVisibility(0);
                    }
                    if (TextUtils.isEmpty(obj2)) {
                        imageView.setImageDrawable(com.tencent.mm.modelappbrand.b.a.JZ());
                    } else {
                        com.tencent.mm.modelappbrand.b.b.Ka().a(imageView, obj2, com.tencent.mm.modelappbrand.b.a.JZ(), f.dGr);
                    }
                    imageView2.setOnClickListener(new 12(cVar, inflate2));
                    h.a(cVar.fJQ.mContext, false, cVar.fJQ.getContentView().getResources().getString(j.app_brand_get_phone_number_has_phone_title), inflate, cVar.fJQ.getContentView().getResources().getString(j.app_brand_get_phone_number_has_phone_do_login), cVar.fJQ.getContentView().getResources().getString(j.app_cancel), new c$13(cVar, z), new c$14(cVar));
                }
            });
            return;
        }
        x.e("MicroMsg.JsApiGetPhoneNumber", "getPhoneNumber JsOperateWxData cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.dIE.dIL});
        this.fKg.fJQ.E(this.fKg.fFd, this.fKg.f("fail:JsOperateWxData cgi fail", null));
    }
}
