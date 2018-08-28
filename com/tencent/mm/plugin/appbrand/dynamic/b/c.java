package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.b.b;
import com.tencent.mm.modelappbrand.b.b$h;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.canvas.g;
import com.tencent.mm.plugin.appbrand.canvas.g.a;
import com.tencent.mm.plugin.appbrand.dynamic.i;

final class c implements g {
    c() {
    }

    public final Bitmap aY(String str, String str2) {
        return a(str, str2, null);
    }

    public final Bitmap a(String str, String str2, a aVar) {
        return a(str, str2, null, aVar);
    }

    public final Bitmap a(final String str, final String str2, Rect rect, final a aVar) {
        if (str2.startsWith("wxfile://")) {
            AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(str, str2);
            if (itemByLocalId == null || TextUtils.isEmpty(itemByLocalId.dDG)) {
                return null;
            }
            String str3 = itemByLocalId.dDG;
            if (!str3.startsWith("file://")) {
                str3 = "file://" + str3;
            }
            return b.Ka().a(str3, null);
        } else if (!str2.startsWith("https://") && !str2.startsWith("http://")) {
            return a.aY(str, str2);
        } else {
            Bitmap a = b.Ka().a(str2, null);
            if (a != null) {
                return a;
            }
            b.Ka().a(new b$h() {
                public final void Kc() {
                }

                public final void n(Bitmap bitmap) {
                    if (aVar != null && bitmap != null && !bitmap.isRecycled()) {
                        aVar.adn();
                    }
                }

                public final void Kd() {
                    Parcelable bundle = new Bundle();
                    bundle.putString("id", str);
                    bundle.putInt("widgetState", 2103);
                    f.a(i.aeT().sz(str), bundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.class, null);
                }

                public final String Ke() {
                    return "WxaWidgetIcon";
                }
            }, str2, null, null);
            return a;
        }
    }
}
