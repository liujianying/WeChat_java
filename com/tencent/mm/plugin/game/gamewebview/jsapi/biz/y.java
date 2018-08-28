package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class y extends a {
    public static final int CTRL_BYTE = 52;
    public static final int DO_IN_ENV = 2;
    public static final String NAME = "launch3rdApp";

    public final void a(Context context, String str, final GameJsApiMMTask.a aVar) {
        x.i("MicroMsg.GameJsApiLaunchApplication", "invoke");
        JSONObject ti = d.ti(str);
        if (ti == null) {
            aVar.tp(a.f("launch_3rdApp:invalid_data", null));
            return;
        }
        int optInt = ti.optInt("type");
        String optString = ti.optString("appID");
        String optString2;
        if (optInt == 0) {
            optString2 = ti.optString("extInfo");
            x.i("MicroMsg.GameJsApiLaunchApplication", "appid:[%s], extinfo:[%s]", new Object[]{optString, optString2});
            if (bi.oW(optString)) {
                x.e("MicroMsg.GameJsApiLaunchApplication", "appid is null or nil");
                aVar.tp(a.f("launch_3rdApp:fail", null));
            } else if (com.tencent.mm.plugin.webview.a.a.ezo.r(ad.getContext(), optString)) {
                WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                wXAppExtendObject.extInfo = optString2;
                WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                wXMediaMessage.sdkVer = 620823808;
                wXMediaMessage.messageExt = optString2;
                ir irVar = new ir();
                irVar.bSe.bSg = wXMediaMessage;
                irVar.bSe.appId = optString;
                irVar.bSe.context = context;
                irVar.bSe.bSh = new g.a() {
                    public final void cI(boolean z) {
                        aVar.tp(a.f("launch_3rdApp:ok", null));
                    }
                };
                com.tencent.mm.sdk.b.a.sFg.m(irVar);
            } else {
                x.e("MicroMsg.GameJsApiLaunchApplication", "app is not installed, appid:[%s]", new Object[]{optString});
                aVar.tp(a.f("launch_3rdApp:fail", null));
            }
        } else if (optInt == 1) {
            String optString3 = ti.optString("signature");
            optString = ti.optString("packageName");
            x.i("MicroMsg.GameJsApiLaunchApplication", "doLaunch3RdApp, signature:[%s], packageName:[%s], param:[%s]", new Object[]{optString3, optString, ti.optString("param")});
            if (bi.oW(optString3) || bi.oW(optString)) {
                x.e("MicroMsg.GameJsApiLaunchApplication", "doLaunch3RdApp invalid_args");
                aVar.tp(a.f("launch_3rdApp:fail_invalid_args", null));
            } else if (p.r(context, optString)) {
                Signature[] bh = p.bh(context, optString);
                if (!(bh == null || bh[0] == null)) {
                    String u = com.tencent.mm.a.g.u(bh[0].toByteArray());
                    if (u != null && u.equalsIgnoreCase(optString3)) {
                        optString3 = ti.optString("current_url");
                        optString2 = ti.optString("current_appid");
                        try {
                            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(optString);
                            if (launchIntentForPackage != null) {
                                Bundle bundle = new Bundle();
                                p.g(bundle, r3);
                                launchIntentForPackage.putExtras(bundle);
                                launchIntentForPackage.addFlags(268435456);
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("current_page_url", optString3);
                                bundle2.putString("current_page_appid", optString2);
                                g.a(context, launchIntentForPackage, null, new 2(this, aVar), bundle2);
                                return;
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.GameJsApiLaunchApplication", "doLaunch3RdApp getLaunchIntentForPackage, %s", new Object[]{e.getMessage()});
                        }
                        aVar.tp(a.f("launch_3rdApp:fail", null));
                        return;
                    }
                }
                x.e("MicroMsg.GameJsApiLaunchApplication", "doLaunch3RdApp signature_mismatch");
                aVar.tp(a.f("launch_3rdApp:fail_signature_mismatch", null));
            } else {
                x.e("MicroMsg.GameJsApiLaunchApplication", "doLaunch3RdApp not_install");
                aVar.tp(a.f("launch_3rdApp:fail_not_install", null));
            }
        } else {
            aVar.tp(a.f("launch_3rdApp:fail_invalid_type", null));
        }
    }
}
