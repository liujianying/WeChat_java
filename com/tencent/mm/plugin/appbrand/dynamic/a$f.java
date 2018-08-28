package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.sdk.platformtools.x;

class a$f implements i<Bundle, IPCBoolean> {
    private a$f() {
    }

    public final /* synthetic */ Object av(Object obj) {
        Bundle bundle = (Bundle) obj;
        String string = bundle.getString("id");
        String string2 = bundle.getString("event");
        String string3 = bundle.getString("data");
        c su = d.aeQ().su(string);
        if (su != null) {
            return new IPCBoolean(su.bg(string2, string3));
        }
        x.e("MicroMsg.IPCInvoke_PublishJsEvent", "get DynamicPageViewIPCProxy(id : %s) return null.", new Object[]{string});
        return new IPCBoolean(false);
    }
}
