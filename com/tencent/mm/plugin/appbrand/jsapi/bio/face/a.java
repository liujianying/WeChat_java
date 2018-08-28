package com.tencent.mm.plugin.appbrand.jsapi.bio.face;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.facedetect.ui.FaceTransparentStubUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.smtt.utils.TbsLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    protected abstract boolean ain();

    protected abstract String aio();

    static /* synthetic */ void a(a aVar, l lVar, int i, Bundle bundle, String str) {
        int i2 = -1;
        String str2 = "not returned";
        Object obj = "";
        if (bundle != null) {
            i2 = bundle.getInt("err_code");
            str2 = bundle.getString("err_msg");
            obj = bundle.getString("verify_result");
        }
        Map hashMap = new HashMap(3);
        hashMap.put("errCode", Integer.valueOf(i2));
        hashMap.put("verifyResult", obj);
        if ("fail".equals(str)) {
            str = str + " " + str2;
        }
        lVar.E(i, aVar.f(str, hashMap));
    }

    public final void a(final l lVar, JSONObject jSONObject, final int i) {
        super.a(lVar, jSONObject, i);
        MMActivity c = c(lVar);
        if (c == null) {
            x.e("MicroMsg.JsApiFaceAsyncBase", "JsApiFaceAsyncBase context is null, appId is %s", new Object[]{lVar.mAppId});
            lVar.E(i, f("fail", null));
            return;
        }
        String optString = jSONObject.optString("requestVerifyPreInfo");
        String str = lVar.mAppId;
        int i2 = ain() ? 1001 : TbsLog.TBSLOG_CODE_SDK_BASE;
        Bundle bundle = new Bundle();
        bundle.putBoolean("k_need_signature", true);
        bundle.putInt("k_server_scene", 5);
        bundle.putBoolean("key_is_need_video", ain());
        bundle.putBoolean("is_check_dyncfg", false);
        bundle.putString("k_app_id", str);
        bundle.putString("request_verify_pre_info", optString);
        bundle.putInt("key_business_type", 4);
        bundle.putString("key_function_name", aio());
        Intent intent = new Intent(c, FaceTransparentStubUI.class);
        intent.putExtra("KEY_EXTRAS", bundle);
        intent.putExtra("KEY_REQUEST_CODE", i2);
        c.geJ = new com.tencent.mm.ui.MMActivity.a() {
            public final void b(int i, int i2, Intent intent) {
                int i3 = 90199;
                Bundle bundle = null;
                if (intent != null) {
                    i3 = intent.getIntExtra("err_code", 90199);
                }
                a aVar;
                l lVar;
                int i4;
                if (i == TbsLog.TBSLOG_CODE_SDK_BASE) {
                    x.i("MicroMsg.JsApiFaceAsyncBase", "alvinluo: requestWxFacePictureVerify errCode: %d", new Object[]{Integer.valueOf(i3)});
                    if (i3 == 0) {
                        aVar = a.this;
                        lVar = lVar;
                        i4 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar, lVar, i4, bundle, "ok");
                    } else if (i3 == 90100) {
                        aVar = a.this;
                        lVar = lVar;
                        i4 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar, lVar, i4, bundle, "cancel");
                    } else {
                        aVar = a.this;
                        lVar = lVar;
                        i4 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar, lVar, i4, bundle, "fail");
                    }
                } else if (i == 1001) {
                    x.i("MicroMsg.JsApiFaceAsyncBase", "hy: REQUEST_FACE_DETECT_WITH_VIDEO errCode: %d", new Object[]{Integer.valueOf(i3)});
                    if (i3 == 0) {
                        aVar = a.this;
                        lVar = lVar;
                        i4 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar, lVar, i4, bundle, "ok");
                    } else if (i3 == 90100) {
                        aVar = a.this;
                        lVar = lVar;
                        i4 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar, lVar, i4, bundle, "cancel");
                    } else {
                        aVar = a.this;
                        lVar = lVar;
                        i4 = i;
                        if (intent != null) {
                            bundle = intent.getExtras();
                        }
                        a.a(aVar, lVar, i4, bundle, "fail");
                    }
                }
            }
        };
        c.startActivityForResult(intent, i2);
    }
}
