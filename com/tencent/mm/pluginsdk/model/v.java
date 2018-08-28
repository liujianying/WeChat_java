package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.e.a.b;
import com.tencent.mm.plugin.e.a.f;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class v extends r {
    public final boolean eM(Context context) {
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("sosomap://type=nav")), 0);
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            int size = queryIntentActivities.size();
            for (int i = 0; i < size; i++) {
                ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
                if (resolveInfo != null && resolveInfo.activityInfo != null && "com.tencent.map".equals(resolveInfo.activityInfo.packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean SK(String str) {
        if (str == null || !"com.tencent.map".equals(str)) {
            return false;
        }
        return true;
    }

    public final String Vw() {
        return "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client";
    }

    public final String cbq() {
        return "TencentMap.apk";
    }

    public final s$a cbr() {
        s$a s_a = new s$a();
        s_a.qzq = f.tencent_map_desc;
        String value = g.AT().getValue("QQMapDownloadTips");
        if (!bi.oW(value)) {
            s_a.qzr = value;
        }
        s_a.qzs = f.tencent_map_label;
        s_a.qzp = b.icon_tencent_map;
        return s_a;
    }

    public final String a(Context context, ResolveInfo resolveInfo) {
        if (context == null || resolveInfo == null || resolveInfo.activityInfo == null) {
            return null;
        }
        CharSequence loadLabel = resolveInfo.activityInfo.loadLabel(context.getPackageManager());
        if (loadLabel == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("\\(.*推荐.*\\)", 2).matcher(loadLabel.toString());
        if (matcher.find()) {
            return matcher.replaceAll("");
        }
        return loadLabel.toString();
    }
}
