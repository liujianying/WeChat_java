package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.tencentmap.mapsdk.a.tc.a;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

public final class se {
    private b a;
    private String b;

    public se(Context context, a aVar) {
        String a = sz.a(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://overseactrl.map.qq.com/?apikey=");
        stringBuilder.append(a);
        stringBuilder.append("&ver=");
        stringBuilder.append("1.3.1.e70cce6");
        stringBuilder.append("&ctrlpf=grid");
        stringBuilder.append("&ctrlmb=and");
        stringBuilder.append("&ctrlver=");
        stringBuilder.append(sn.i());
        this.b = stringBuilder.toString();
        this.a = new b(this, aVar);
    }

    private boolean a(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String jSONArray;
            if (jSONObject.optInt("error", Integer.MIN_VALUE) != 0) {
                sn.a(false);
                sy.a().a("world_map_enable", false);
                jSONArray = jSONObject.getJSONObject("info").getJSONArray("detail").toString();
                sy.a().a("world_map_logo_change_rule_json", jSONArray);
                sn.a(jSONArray);
                return true;
            }
            sn.a(true);
            sy.a().a("world_map_enable", true);
            JSONObject jSONObject2 = jSONObject.getJSONObject("info");
            jSONObject = jSONObject2.optJSONObject("frontier");
            if (jSONObject != null) {
                jSONArray = jSONObject.optString("path");
                if (!(jSONArray == null || jSONArray.length() == 0)) {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(jSONArray).openConnection();
                        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                        if (httpURLConnection.getResponseCode() == 200) {
                            String headerField = httpURLConnection.getHeaderField("Content-Encoding");
                            if (headerField != null && headerField.length() > 0) {
                                headerField.toLowerCase().contains("gzip");
                            }
                            jSONArray = new String(rv.a(new GZIPInputStream(httpURLConnection.getInputStream())));
                            sk.a();
                            sy.a().a("", sk.b(jSONArray));
                            sk.a().a(jSONArray);
                        }
                    } catch (Throwable th) {
                    }
                }
            }
            int i = jSONObject2.getInt("version");
            if ((i != sn.i() ? 1 : 0) == 0) {
                return false;
            }
            sn.m();
            JSONObject jSONObject3 = jSONObject2.getJSONObject("tilesrc");
            int optInt = jSONObject3.optInt("style", TbsLog.TBSLOG_CODE_SDK_BASE);
            int optInt2 = jSONObject3.optInt("scene", 0);
            int optInt3 = jSONObject3.optInt("version", ro.e);
            if (optInt3 != sn.g()) {
                te.a().a(a.b);
            }
            String jSONArray2 = jSONObject2.getJSONArray("detail").toString();
            sn.a(optInt2, optInt, optInt3, i, null, jSONArray2);
            sy.a().a("world_map_tile_url_regex", null);
            sy.a().a("world_map_version", optInt3);
            sy.a().a("world_map_style", optInt);
            sy.a().a("world_map_scene", optInt2);
            sy.a().a("world_map_logo_change_rule_json", jSONArray2);
            sy.a().a("world_map_protocol_version", i);
            return true;
        } catch (Throwable th2) {
            sy.a().a("world_map_protocol_version", 0);
            return false;
        }
    }

    public final void a() {
        this.a.execute(new String[]{this.b});
    }
}
