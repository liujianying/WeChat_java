package com.tencent.mm.plugin.appbrand.dynamic.j;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.plugin.appbrand.appcache.al;
import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.appcache.base.b$a;
import com.tencent.mm.plugin.appbrand.dynamic.i;
import com.tencent.mm.plugin.appbrand.dynamic.j;
import com.tencent.mm.pluginsdk.g.a.c.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$d implements a<Bundle, Bundle> {
    private a$d() {
    }

    public final /* synthetic */ void a(Object obj, final c cVar) {
        Bundle bundle = (Bundle) obj;
        final String string = bundle.getString("id");
        String string2 = bundle.getString("appId");
        int i = bundle.getInt("debugType");
        al a = ((com.tencent.mm.plugin.appbrand.a.c) g.l(com.tencent.mm.plugin.appbrand.a.c.class)).aaN().a(string2, i, new String[]{"downloadURL"});
        String str = a != null ? a.field_downloadURL : null;
        if (a == null) {
            x.e("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", new Object[]{string2, Integer.valueOf(i)});
            s.i("MicroMsg.DynamicPkgUpdater", "WxaPkgManifestRecord(%s, %d) is null.", new Object[]{string2, Integer.valueOf(i)});
            if (cVar != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("appId", string2);
                bundle2.putBoolean("result", false);
                cVar.at(bundle2);
            }
        } else if (!bi.oW(str)) {
            aq.a(string2, i, str, new aq.a() {
                public final /* bridge */ /* synthetic */ void a(k kVar) {
                }

                public final /* synthetic */ void a(String str, b$a.a aVar, Object obj) {
                    s.i("MicroMsg.DynamicPkgUpdater", "pkg download return %s", new Object[]{aVar});
                    if (!b$a.a.fio.equals(aVar)) {
                        Parcelable bundle = new Bundle();
                        bundle.putString("id", string);
                        bundle.putInt("widgetState", 2106);
                        f.a(i.aeT().sz(string), bundle, com.tencent.mm.plugin.appbrand.dynamic.f.a.class, null);
                        j.aeV().C(string, 626, 16);
                    }
                    if (cVar != null) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("appId", str);
                        bundle2.putBoolean("result", b$a.a.fio.equals(aVar));
                        cVar.at(bundle2);
                    }
                }
            });
        }
    }
}
