package com.tencent.mm.plugin.location.ui.impl;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class h$3 implements c {
    final /* synthetic */ h kKh;

    h$3(h hVar) {
        this.kKh = hVar;
    }

    public final void a(l lVar) {
        if (this.kKh.kKv) {
            lVar.a(1, this.kKh.getString(h.location_street_view), 0);
        }
        h hVar = this.kKh;
        d dVar = this.kKh.kHO;
        LocationInfo locationInfo = this.kKh.kHP;
        ArrayList arrayList = new ArrayList();
        arrayList.add("com.tencent.map");
        arrayList.add("com.google.android.apps.maps");
        arrayList.add("com.baidu.BaiduMap");
        arrayList.add("com.autonavi.minimap");
        arrayList.add("com.sogou.map.android.maps");
        String str = "android.intent.action.VIEW";
        Intent intent = new Intent(str, Uri.parse(String.format("geo:%f,%f", new Object[]{Double.valueOf(locationInfo.kCw), Double.valueOf(locationInfo.kCx)})));
        PackageManager packageManager = dVar.context.getPackageManager();
        Map hashMap = new HashMap();
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 65536)) {
            if (arrayList.contains(resolveInfo.activityInfo.packageName)) {
                hashMap.put(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.loadLabel(dVar.context.getPackageManager()).toString());
            }
        }
        hVar.kKf = hashMap;
        if (!e.chv() && (this.kKh.kKg < 4 || h.b(this.kKh))) {
            lVar.ak(2, h.tencent_map_label, 0);
        }
        int i = 3;
        Iterator it = this.kKh.kKf.entrySet().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                Entry entry = (Entry) it.next();
                if (!((String) entry.getKey()).equals("com.tencent.map")) {
                    lVar.a(i2, (CharSequence) entry.getValue(), 0);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
