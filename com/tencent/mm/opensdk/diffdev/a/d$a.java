package com.tencent.mm.opensdk.diffdev.a;

import android.util.Base64;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

class d$a {
    public OAuthErrCode n;
    public String o;
    public String p;
    public String q;
    public int r;
    public String s;
    public byte[] t;

    private d$a() {
    }

    public static d$a a(byte[] bArr) {
        d$a d_a = new d$a();
        if (bArr == null || bArr.length == 0) {
            Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
            d_a.n = OAuthErrCode.WechatAuth_Err_NetworkErr;
        } else {
            try {
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                    int i = jSONObject.getInt("errcode");
                    if (i != 0) {
                        Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", new Object[]{Integer.valueOf(i)}));
                        d_a.n = OAuthErrCode.WechatAuth_Err_NormalErr;
                        d_a.r = i;
                        d_a.s = jSONObject.optString("errmsg");
                    } else {
                        String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                        if (string == null || string.length() == 0) {
                            Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                            d_a.n = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                        } else {
                            byte[] decode = Base64.decode(string, 0);
                            if (decode == null || decode.length == 0) {
                                Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                                d_a.n = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                            } else {
                                d_a.n = OAuthErrCode.WechatAuth_Err_OK;
                                d_a.t = decode;
                                d_a.o = jSONObject.getString("uuid");
                                d_a.p = jSONObject.getString("appname");
                                Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", new Object[]{d_a.o, d_a.p, Integer.valueOf(d_a.t.length)}));
                            }
                        }
                    }
                } catch (Exception e) {
                    Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("parse json fail, ex = %s", new Object[]{e.getMessage()}));
                    d_a.n = OAuthErrCode.WechatAuth_Err_NormalErr;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("parse fail, build String fail, ex = %s", new Object[]{e2.getMessage()}));
                d_a.n = OAuthErrCode.WechatAuth_Err_NormalErr;
            }
        }
        return d_a;
    }
}
