package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.g.a.pz;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.model.h;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class ay extends a {
    public static final int CTRL_BYTE = 4;
    public static final String NAME = "shareTimeline";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiSendAppMessage", "invoke");
        GameWebViewUI pageActivity = dVar.getPageActivity();
        if (jSONObject == null) {
            x.e("MicroMsg.GameJsApiSendAppMessage", "sendAppMessage fail, appmsg is null");
            dVar.E(i, a.f("share_timeline:fail_null_params", null));
            return;
        }
        String optString = jSONObject.optString("link");
        if (bi.oW(optString)) {
            x.e("MicroMsg.GameJsApiSendAppMessage", "link is null");
            dVar.E(i, a.f("share_timeline:fail_invalid_params", null));
            return;
        }
        int i2;
        h.a(dVar, jSONObject);
        String optString2 = jSONObject.optString("desc");
        if (optString2 != null) {
            if (optString2.startsWith("http://")) {
                optString2.substring(7);
            } else if (optString2.startsWith("https://")) {
                optString2.substring(8);
            }
        }
        int i3 = 1;
        String str = "";
        int i4 = 0;
        if (this.jGp != null) {
            this.jGp.setClassLoader(getClass().getClassLoader());
            i3 = this.jGp.getInt("snsWebSource", 1);
            str = this.jGp.getString("jsapi_args_appid");
            i4 = bi.getInt(this.jGp.getString("urlAttribute"), 0);
            this.jGp.remove("urlAttribute");
        }
        int i5 = i3;
        if (bi.oW(str)) {
            str = jSONObject.optString("appid");
        }
        String optString3 = jSONObject.optString("img_width");
        String optString4 = jSONObject.optString("img_height");
        x.i("MicroMsg.GameJsApiSendAppMessage", "doTimeline, rawUrl:[%s], shareUrl:[%s]", new Object[]{optString, dVar.Dp(optString)});
        String optString5 = jSONObject.optString("type");
        String optString6 = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_TITLE);
        String optString7 = jSONObject.optString("img_url");
        String optString8 = jSONObject.optString("src_username");
        String optString9 = jSONObject.optString("src_displayname");
        i3 = -1;
        try {
            i3 = Integer.valueOf(optString3).intValue();
            Integer.valueOf(optString4);
            i2 = i3;
        } catch (Exception e) {
            i2 = i3;
        }
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_width", i2);
        intent.putExtra("Ksnsupload_height", i2);
        intent.putExtra("Ksnsupload_link", r11);
        intent.putExtra("Ksnsupload_title", optString6);
        intent.putExtra("Ksnsupload_imgurl", optString7);
        intent.putExtra("Ksnsupload_contentattribute", i4);
        if (s.hf(optString8)) {
            intent.putExtra("src_username", optString8);
            intent.putExtra("src_displayname", optString9);
        }
        intent.putExtra("Ksnsupload_source", i5);
        intent.putExtra("Ksnsupload_type", 1);
        if (!bi.oW(optString5) && optString5.equals("music")) {
            intent.putExtra("ksnsis_music", true);
        }
        if (!bi.oW(optString5) && optString5.equals("video")) {
            intent.putExtra("ksnsis_video", true);
        }
        if (str != null && str.length() > 0) {
            intent.putExtra("Ksnsupload_appid", str);
        }
        str = "MicroMsg.GameJsApiSendAppMessage";
        String str2 = "doTimeline, init intent, jsapiArgs == null ? %b";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.jGp == null);
        x.i(str, str2, objArr);
        if (this.jGp != null) {
            optString2 = this.jGp.getString("K_sns_thumb_url");
            str = this.jGp.getString("K_sns_raw_url");
            str2 = bi.aG(this.jGp.getString("KSnsStrId"), "");
            optString3 = bi.aG(this.jGp.getString("KSnsLocalId"), "");
            intent.putExtra("key_snsad_statextstr", this.jGp.getString("key_snsad_statextstr"));
            x.i("MicroMsg.GameJsApiSendAppMessage", "currentUrl %s contentUrl %s thumbUrl %s", new Object[]{optString, str, optString2});
            if (!(str == null || optString == null || !str.equals(optString))) {
                intent.putExtra("KlinkThumb_url", optString2);
            }
            intent.putExtra("KSnsStrId", str2);
            intent.putExtra("KSnsLocalId", optString3);
            if (str2 != null && this.jGp.getBoolean("KFromTimeline", false)) {
                pz pzVar = new pz();
                pzVar.caF.bSZ = str2;
                pzVar.caF.bKW = optString3;
                com.tencent.mm.sdk.b.a.sFg.m(pzVar);
            }
        }
        intent.putExtra("ShareUrlOriginal", dVar.getRawUrl());
        intent.putExtra("ShareUrlOpen", dVar.getCurrentURL());
        intent.putExtra("JsAppId", dVar.getCacheAppId());
        intent.putExtra("need_result", true);
        x.i("MicroMsg.GameJsApiSendAppMessage", "doTimeline, start activity");
        pageActivity.geJ = new 1(this, dVar, i);
        com.tencent.mm.bg.d.a(pageActivity, "sns", ".ui.SnsUploadUI", intent, 2, false);
    }
}
