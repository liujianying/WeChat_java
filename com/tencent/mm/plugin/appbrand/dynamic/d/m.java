package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.j.d;
import com.tencent.mm.u.b.b;
import org.json.JSONObject;

public final class m extends a {
    public m() {
        super(d.NAME, 457);
    }

    protected final void a(com.tencent.mm.u.c.a aVar, JSONObject jSONObject, final b.a<JSONObject> aVar2) {
        u.b Da = aVar.Da();
        String string = Da.getString("__page_view_id", "");
        Bundle bundle = new Bundle();
        bundle.putString("id", string);
        bundle.putString("data", jSONObject.toString());
        XIPCInvoker.a(Da.getString("__process_name", ((h) g.Ef().DM()).dox), bundle, a.class, new c<Bundle>() {
            public final /* synthetic */ void at(Object obj) {
                Bundle bundle;
                String str;
                Bundle bundle2 = (Bundle) obj;
                boolean z = false;
                if (bundle2 != null) {
                    z = bundle2.getBoolean("ret");
                    String string = bundle2.getString("reason");
                    bundle = bundle2.getBundle("data");
                    str = string;
                } else {
                    bundle = null;
                    str = null;
                }
                aVar2.aA(m.this.a(z, str, bundle));
            }
        });
    }
}
