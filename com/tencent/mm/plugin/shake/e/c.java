package com.tencent.mm.plugin.shake.e;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.y.g$a;
import java.util.Map;

public final class c {
    public static a Lk(String str) {
        if (str == null) {
            return null;
        }
        String str2 = "";
        Map z = bl.z(str, "tv");
        if (z == null) {
            return null;
        }
        a aVar = new a();
        aVar.field_id = bi.oV((String) z.get(str2 + ".tv.id"));
        aVar.field_topic = bi.oV((String) z.get(str2 + ".tv.topic"));
        aVar.field_title = bi.oV((String) z.get(str2 + ".tv.title"));
        aVar.field_subtitle = bi.oV((String) z.get(str2 + ".tv.subtitle"));
        aVar.field_thumburl = bi.oV((String) z.get(str2 + ".tv.thumburl"));
        aVar.field_shareurl = bi.oV((String) z.get(str2 + ".tv.shareurl"));
        aVar.field_playurl = bi.oV((String) z.get(str2 + ".tv.playurl"));
        aVar.field_playstatid = bi.oV((String) z.get(str2 + ".tv.playurl$statid"));
        aVar.field_source = bi.oV((String) z.get(str2 + ".tv.source"));
        aVar.mNX = a.m(z, str2 + ".tv");
        aVar.field_xml = str;
        return aVar;
    }

    public static String b(a aVar) {
        StringBuilder stringBuilder = new StringBuilder(256);
        stringBuilder.append("<tv>");
        if (!bi.oW(aVar.field_id)) {
            stringBuilder.append("<id>" + bi.WS(aVar.field_id) + "</id>");
        }
        stringBuilder.append("<title>" + bi.WS(aVar.field_title) + "</title>");
        stringBuilder.append("<subtitle>" + bi.WS(aVar.field_subtitle) + "</subtitle>");
        stringBuilder.append("<topic>" + bi.WS(aVar.field_topic) + "</topic>");
        stringBuilder.append("<thumburl>" + bi.WS(aVar.field_thumburl) + "</thumburl>");
        stringBuilder.append("<shareurl>" + bi.WS(aVar.field_shareurl) + "</shareurl>");
        if (bi.oW(aVar.field_playstatid)) {
            stringBuilder.append("<playurl>" + bi.WS(aVar.field_playurl) + "</playurl>");
        } else {
            stringBuilder.append("<playurl statid=\"" + aVar.field_playstatid + "\">" + bi.WS(aVar.field_playurl) + "</playurl>");
        }
        stringBuilder.append("<source>" + bi.WS(aVar.field_source) + "</source>");
        stringBuilder.append("</tv>");
        return stringBuilder.toString();
    }

    public static String a(Context context, a aVar) {
        g$a g_a = new g$a();
        g_a.title = aVar.field_title;
        if (bi.oW(aVar.field_topic)) {
            g_a.description = aVar.field_subtitle;
        } else {
            g_a.description = aVar.field_topic;
        }
        g_a.type = 20;
        g_a.url = aVar.field_shareurl;
        g_a.action = "";
        if (k.buA()) {
            g_a.appName = context.getString(R.l.scan_type_tv);
            g_a.appId = "wxaf060266bfa9a35c";
        }
        g_a.thumburl = aVar.field_thumburl;
        g_a.dwV = b(aVar);
        return g$a.a(g_a, null, null);
    }
}
