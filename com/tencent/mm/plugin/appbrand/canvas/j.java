package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.mm.modelappbrand.b.b;
import com.tencent.mm.modelappbrand.b.b.e;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.canvas.g.a;
import com.tencent.mm.plugin.appbrand.page.o;

final class j implements g {
    j() {
    }

    public final Bitmap aY(String str, String str2) {
        return a(str, str2, null);
    }

    public final Bitmap a(String str, String str2, a aVar) {
        return a(str, str2, null, aVar);
    }

    public final Bitmap a(String str, String str2, Rect rect, a aVar) {
        e aVar2;
        Bitmap a;
        if (rect != null) {
            aVar2 = new a(rect.left, rect.top, rect.width(), rect.height());
        } else {
            aVar2 = null;
        }
        if (str2.startsWith("wxfile://")) {
            AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(str, str2);
            if (itemByLocalId == null || TextUtils.isEmpty(itemByLocalId.dDG)) {
                return null;
            }
            String str3 = itemByLocalId.dDG;
            if (!str3.startsWith("file://")) {
                str3 = "file://" + str3;
            }
            a = b.Ka().a(str3, aVar2);
        } else if (str2.startsWith("https://") || str2.startsWith("http://")) {
            Bitmap a2 = b.Ka().a(str2, aVar2);
            if (a2 == null) {
                b.Ka().a(new 1(this, aVar, str, str2), str2, null, aVar2);
                a = a2;
            } else {
                a = a2;
            }
        } else {
            a = o.j(com.tencent.mm.plugin.appbrand.a.pY(str), str2);
            if (rect != null) {
                a = new b(rect.left, rect.top, rect.width(), rect.height()).o(a);
            }
        }
        return a;
    }
}
