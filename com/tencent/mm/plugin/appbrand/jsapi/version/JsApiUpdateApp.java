package com.tencent.mm.plugin.appbrand.jsapi.version;

import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.l;
import org.json.JSONObject;

public final class JsApiUpdateApp extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 359;
    private static final String NAME = "updateApp";

    private static final class a implements com.tencent.mm.ipcinvoker.a<IPCString, SyncResult> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, c cVar) {
            r.a(((IPCString) obj).value, true, new 1(this, cVar));
        }
    }

    public final void a(l lVar, JSONObject jSONObject, int i) {
        XIPCInvoker.a("com.tencent.mm", new IPCString(lVar.fdO.fcu.bGy), a.class, new 1(this, lVar, i));
    }
}
