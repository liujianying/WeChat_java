package com.tencent.mm.plugin.game.wepkg.utils;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static void b(String str, String str2, String str3, String str4, long j, long j2, String str5) {
        String encode;
        try {
            if (bi.oW(str5)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("netType", ao.fH(ad.getContext()));
                encode = URLEncoder.encode(jSONObject.toString(), "UTF-8");
            } else {
                JSONObject jSONObject2 = new JSONObject(URLDecoder.decode(str5, "UTF-8"));
                jSONObject2.put("netType", ao.fH(ad.getContext()));
                encode = URLEncoder.encode(jSONObject2.toString(), "UTF-8");
            }
            try {
                if (!bi.oW(str2)) {
                    str2 = URLEncoder.encode(str2, "UTF-8");
                }
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            encode = str5;
        }
        h.mEJ.h(13980, new Object[]{str, str2, str3, str4, Long.valueOf(j), encode, Long.valueOf(j2)});
    }

    public static String Eq(String str) {
        if (str == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", str);
            return URLEncoder.encode(jSONObject.toString(), "UTF-8");
        } catch (JSONException e) {
            x.e("MicroMsg.WePkgReport", e.getMessage());
        } catch (UnsupportedEncodingException e2) {
            x.e("MicroMsg.WePkgReport", e2.getMessage());
        }
        return "";
    }

    public static String rd(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("subCode", i);
            return URLEncoder.encode(jSONObject.toString(), "UTF-8");
        } catch (JSONException e) {
        } catch (UnsupportedEncodingException e2) {
        }
        return null;
    }
}
