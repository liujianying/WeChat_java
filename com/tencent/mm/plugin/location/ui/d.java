package com.tencent.mm.plugin.location.ui;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLEncoder;

public final class d {
    public Context context;
    public int ecA = -1;
    private ActivityManager iSW;
    public int kEC = 0;
    public int kED = 0;
    public boolean kEE = false;

    public static int aZx() {
        x.d("MicroMsg.MapHelper", "getDefaultZoom isGoogle : false");
        return 16;
    }

    public d(Context context) {
        this.context = context;
        this.iSW = (ActivityManager) context.getSystemService("activity");
    }

    private static String a(Context context, LocationInfo locationInfo) {
        String string = context.getString(h.location_conversation);
        if (!bi.oW(locationInfo.bWB) && !locationInfo.bWB.equals(string)) {
            return locationInfo.bWB;
        }
        if (bi.oW(locationInfo.kCz)) {
            return "";
        }
        return locationInfo.kCz;
    }

    private static Intent a(Context context, LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        if (z || !locationInfo2.aYY()) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.kCw + "," + locationInfo.kCx + "?z=" + locationInfo.kCy));
            intent.setPackage("com.baidu.BaiduMap");
            return intent;
        }
        String format;
        String format2;
        if (bi.oW(a(context, locationInfo2))) {
            format = String.format("%f,%f", new Object[]{Double.valueOf(locationInfo2.kCw), Double.valueOf(locationInfo2.kCx)});
        } else {
            format = String.format("name:%s|latlng:%f,%f", new Object[]{a(context, locationInfo2), Double.valueOf(locationInfo2.kCw), Double.valueOf(locationInfo2.kCx)});
        }
        if (bi.oW(a(context, locationInfo))) {
            format2 = String.format("%f,%f", new Object[]{Double.valueOf(locationInfo.kCw), Double.valueOf(locationInfo.kCx)});
        } else {
            format2 = String.format("name:%s|latlng:%f,%f", new Object[]{a(context, locationInfo), Double.valueOf(locationInfo.kCw), Double.valueOf(locationInfo.kCx)});
        }
        format = String.format("intent://map/direction?origin=%s&destination=%s&mode=driving&coord_type=gcj02", new Object[]{format, format2});
        x.d("MicroMsg.MapHelper", "url " + format);
        try {
            format = format + "&referer=tencent|weixin#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end";
            x.d("MicroMsg.MapHelper", "all: " + format);
            return Intent.getIntent(format);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MapHelper", e, "", new Object[0]);
            return null;
        }
    }

    private static Intent a(LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        Intent intent;
        if (z || !locationInfo2.aYY()) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.kCw + "," + locationInfo.kCx + "?z=" + locationInfo.kCy));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=" + (bi.oW(locationInfo.kCA) ? "zh-cn" : locationInfo.kCA), new Object[]{Double.valueOf(locationInfo2.kCw), Double.valueOf(locationInfo2.kCx), Double.valueOf(locationInfo.kCw), Double.valueOf(locationInfo.kCx)})));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        return intent;
    }

    private static Intent b(Context context, LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        Intent intent;
        if (z || !locationInfo2.aYY()) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.kCw + "," + locationInfo.kCx + "?z=" + locationInfo.kCy));
            intent.setPackage("com.tencent.map");
            return intent;
        }
        String format = String.format("sosomap://type=nav&fromcoord=%f,%f&tocoord=%f,%f", new Object[]{Double.valueOf(locationInfo2.kCx), Double.valueOf(locationInfo2.kCw), Double.valueOf(locationInfo.kCx), Double.valueOf(locationInfo.kCw)});
        String a = a(context, locationInfo2);
        format = format + String.format("&from=%s", new Object[]{URLEncoder.encode(a)});
        String a2 = a(context, locationInfo);
        x.d("MicroMsg.MapHelper", "tencentluxian, url=%s", (format + String.format("&to=%s", new Object[]{URLEncoder.encode(a2)})) + "&referer=wx_client");
        intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
        intent.setPackage("com.tencent.map");
        if (bi.k(context, intent)) {
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.kCw + "," + locationInfo.kCx));
        intent.setPackage("com.tencent.map");
        return intent;
    }

    private static Intent a(Context context, LocationInfo locationInfo, LocationInfo locationInfo2, boolean z, String str) {
        Intent intent;
        if (z || !locationInfo2.aYY()) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.kCw + "," + locationInfo.kCx + "?z=" + locationInfo.kCy));
            intent.setPackage(str);
            return intent;
        }
        String str2 = "&from=%s&to=%s";
        String format = String.format("wechatnav://type=nav&fromcoord=%f,%f&tocoord=%f,%f", new Object[]{Double.valueOf(locationInfo2.kCw), Double.valueOf(locationInfo2.kCx), Double.valueOf(locationInfo.kCw), Double.valueOf(locationInfo.kCx)});
        if (!(bi.oW(locationInfo2.kCz) || bi.oW(locationInfo.kCz))) {
            format = format + String.format(str2, new Object[]{locationInfo2.kCz, locationInfo.kCz});
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
        intent.setPackage(str);
        if (bi.k(context, intent)) {
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.kCw + "," + locationInfo.kCx));
        intent.setPackage(str);
        return intent;
    }

    public final void a(LocationInfo locationInfo, LocationInfo locationInfo2, String str, boolean z) {
        if ("com.tencent.map".equals(str)) {
            if (z) {
                com.tencent.mm.plugin.report.service.h.mEJ.h(11091, Integer.valueOf(4), Integer.valueOf(2));
            } else {
                com.tencent.mm.plugin.report.service.h.mEJ.h(11091, Integer.valueOf(4), Integer.valueOf(1));
            }
        } else if (z) {
            com.tencent.mm.plugin.report.service.h.mEJ.h(11091, Integer.valueOf(5), Integer.valueOf(2));
        } else {
            com.tencent.mm.plugin.report.service.h.mEJ.h(11091, Integer.valueOf(5), Integer.valueOf(1));
        }
        PackageManager packageManager = this.context.getPackageManager();
        Intent a;
        String charSequence;
        PackageInfo aB;
        if ("com.google.android.apps.maps".equals(str)) {
            a = a(locationInfo, locationInfo2, false);
            if (!bi.k(this.context, a)) {
                a = a(locationInfo, locationInfo2, true);
            }
            com.tencent.mm.plugin.report.service.h.mEJ.h(10997, "4", "", Integer.valueOf(0), Integer.valueOf(0));
            this.context.startActivity(a);
        } else if ("com.baidu.BaiduMap".equals(str)) {
            a = a(this.context, locationInfo, locationInfo2, false);
            if (!bi.k(this.context, a)) {
                a = a(this.context, locationInfo, locationInfo2, true);
            }
            charSequence = e.aB(this.context, "com.baidu.BaiduMap").applicationInfo.loadLabel(packageManager).toString();
            com.tencent.mm.plugin.report.service.h.mEJ.h(10997, "5", charSequence, Integer.valueOf(0), Integer.valueOf(0));
            this.context.startActivity(a);
        } else if ("com.tencent.map".equals(str)) {
            a = b(this.context, locationInfo, locationInfo2, false);
            if (!bi.k(this.context, a)) {
                a = b(this.context, locationInfo, locationInfo2, true);
            }
            com.tencent.mm.plugin.report.service.h.mEJ.h(10997, "2", "", Integer.valueOf(0), Integer.valueOf(0));
            this.context.startActivity(a);
        } else if ("com.autonavi.minimap".equals(str)) {
            aB = e.aB(this.context, str);
            if (aB != null) {
                a = a(this.context, locationInfo, locationInfo2, false, str);
                if (!bi.k(this.context, a)) {
                    a = a(this.context, locationInfo, locationInfo2, true, str);
                }
                charSequence = aB.applicationInfo.loadLabel(packageManager).toString();
                com.tencent.mm.plugin.report.service.h.mEJ.h(10997, "5", charSequence, Integer.valueOf(0), Integer.valueOf(0));
                this.context.startActivity(a);
            }
        } else if ("com.sogou.map.android.maps".equals(str)) {
            aB = e.aB(this.context, str);
            if (aB != null) {
                a = a(this.context, locationInfo, locationInfo2, false, str);
                if (!bi.k(this.context, a)) {
                    a = a(this.context, locationInfo, locationInfo2, true, str);
                }
                charSequence = aB.applicationInfo.loadLabel(packageManager).toString();
                com.tencent.mm.plugin.report.service.h.mEJ.h(10997, "5", charSequence, Integer.valueOf(0), Integer.valueOf(0));
                this.context.startActivity(a);
            }
        }
    }
}
