package com.tencent.mm.plugin.appbrand.jsapi.version;

import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.r$b;
import com.tencent.mm.plugin.appbrand.jsapi.version.JsApiUpdateApp.a;

class JsApiUpdateApp$a$1 implements r$b<WxaAttributes> {
    final /* synthetic */ c dmx;
    final /* synthetic */ a fZJ;

    JsApiUpdateApp$a$1(a aVar, c cVar) {
        this.fZJ = aVar;
        this.dmx = cVar;
    }

    public final /* synthetic */ void e(int i, Object obj) {
        WxaAttributes wxaAttributes = (WxaAttributes) obj;
        switch (i) {
            case 1:
            case 2:
                this.dmx.at(new JsApiUpdateApp$SyncResult(true, wxaAttributes.ael().cbu));
                return;
            case 3:
                this.dmx.at(new JsApiUpdateApp$SyncResult(false, -1));
                return;
            default:
                return;
        }
    }
}
