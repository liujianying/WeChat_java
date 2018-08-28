package com.tencent.mm.plugin.appbrand.permission;

import android.util.SparseIntArray;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.b;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashSet;
import java.util.Set;

final class a {
    private static final SparseIntArray gpO = new 1();
    private static final Set<String> gpP = new HashSet();

    static {
        gpO.put("requestPayment".hashCode(), j.app_brand_jsapi_ban_banner_hint_api_name_pay);
        gpO.put("playVoice".hashCode(), j.app_brand_jsapi_ban_banner_hint_api_name_play);
        gpO.put(JsApiOperateMusicPlayer.NAME.hashCode(), j.app_brand_jsapi_ban_banner_hint_api_name_play);
        gpO.put("shareAppMessage".hashCode(), j.app_brand_jsapi_ban_banner_hint_api_name_share);
        gpO.put("onShareAppMessage".hashCode(), j.app_brand_jsapi_ban_banner_hint_api_name_share);
        gpO.put("shareAppMessageDirectly".hashCode(), j.app_brand_jsapi_ban_banner_hint_api_name_share);
        gpO.put("shareTimeline".hashCode(), j.app_brand_jsapi_ban_banner_hint_api_name_share);
        gpO.put("onMenuShareTimeline".hashCode(), j.app_brand_jsapi_ban_banner_hint_api_name_share);
        gpO.put("launchMiniProgram".hashCode(), j.app_brand_jsapi_ban_banner_hint_api_name_launch);
        gpP.add("requestPayment");
        gpP.add("playVoice");
        gpP.add(JsApiOperateMusicPlayer.NAME);
        gpP.add("shareAppMessage");
        gpP.add("onShareAppMessage");
        gpP.add("shareAppMessageDirectly");
        gpP.add("shareTimeline");
        gpP.add("onMenuShareTimeline");
        gpP.add("launchMiniProgram");
        gpP.add(JsApiMakeVoIPCall.NAME);
        gpP.add("addCard");
        gpP.add("chooseContact");
        gpP.add("openCard");
        gpP.add("openOfflinePayView");
    }

    static void a(g gVar, b bVar) {
        if (gVar != null && bVar != null && gpP.contains(bVar.getName())) {
            String string = ad.getResources().getString(gpO.get(bVar.getName().hashCode()));
            c.runOnUiThread(new 2(gVar, ad.getResources().getString(j.app_brand_jsapi_ban_banner_hint_format_wording, new Object[]{string})));
        }
    }
}
