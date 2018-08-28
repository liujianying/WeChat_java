package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Locale;
import org.json.JSONObject;

public final class c extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 120;
    private static final String NAME = "getImageInfo";
    private static final Collection<b> fUW;

    private static final class a implements b {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final com.tencent.mm.vending.j.a i(g gVar, String str) {
            if (!str.startsWith("wxfile://")) {
                return null;
            }
            AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(gVar.mAppId, str);
            if (itemByLocalId == null || bi.oW(itemByLocalId.dDG) || !e.cn(itemByLocalId.dDG)) {
                return com.tencent.mm.vending.j.a.cz(e.fVa);
            }
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(itemByLocalId.dDG, options);
            c cVar = new c((byte) 0);
            cVar.width = options.outWidth;
            cVar.height = options.outHeight;
            cVar.type = com.tencent.mm.plugin.appbrand.r.a.b(options);
            cVar.fqt = com.tencent.mm.plugin.appbrand.r.a.a(options) ? com.tencent.mm.plugin.appbrand.r.a.lQ(com.tencent.mm.plugin.appbrand.r.a.vR(itemByLocalId.dDG)) : "up";
            return com.tencent.mm.vending.j.a.x(e.fVc, cVar);
        }
    }

    public final void a(l lVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("src");
        if (bi.oW(optString)) {
            lVar.E(i, f("fail:invalid data", null));
            return;
        }
        com.tencent.mm.sdk.f.e.b(new 1(this, lVar, optString, new WeakReference(lVar), i), String.format(Locale.US, "AppBrandJsApiGetImageInfo[%s]", new Object[]{optString}), 10);
    }

    static {
        Collection linkedList = new LinkedList();
        linkedList.add(new a());
        linkedList.add(new d((byte) 0));
        fUW = Collections.unmodifiableCollection(linkedList);
    }
}
