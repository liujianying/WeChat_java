package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.content.ContentValues;
import android.os.Bundle;
import android.os.Parcelable;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.plugin.appbrand.widget.h;
import com.tencent.mm.sdk.platformtools.bi;

public final class b {

    private static class a implements i<Bundle, ContentValues> {
        private a() {
        }

        public final /* synthetic */ Object av(Object obj) {
            g gVar;
            String string = ((Bundle) obj).getString(SlookAirButtonFrequentContactAdapter.ID);
            h abj = ((com.tencent.mm.plugin.appbrand.widget.a.a) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.widget.a.a.class)).abj();
            if (bi.oW(string)) {
                gVar = null;
            } else {
                gVar = new g();
                gVar.field_id = string;
                if (!abj.b(gVar, new String[]{SlookAirButtonFrequentContactAdapter.ID})) {
                    gVar = null;
                }
            }
            return gVar == null ? null : gVar.wH();
        }
    }

    public static g sJ(String str) {
        Parcelable bundle = new Bundle();
        bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
        return a((ContentValues) f.a("com.tencent.mm", bundle, a.class));
    }

    static g a(ContentValues contentValues) {
        if (contentValues == null) {
            return null;
        }
        g gVar = new g();
        gVar.field_id = contentValues.getAsString(SlookAirButtonFrequentContactAdapter.ID);
        gVar.field_appId = contentValues.getAsString("appId");
        gVar.field_cacheKey = contentValues.getAsString("cacheKey");
        gVar.field_updateTime = bi.c(contentValues.getAsLong("updateTime"));
        gVar.field_interval = bi.f(contentValues.getAsInteger("interval"));
        gVar.sKx = bi.c(contentValues.getAsLong("rowid"));
        return gVar;
    }
}
