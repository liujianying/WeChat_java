package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.compat.a.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting.OpenWeRunSetting;
import com.tencent.mm.sdk.platformtools.x;

class JsApiOpenWeRunSetting$OpenWeRunSetting$1 implements a {
    final /* synthetic */ OpenWeRunSetting fGy;

    JsApiOpenWeRunSetting$OpenWeRunSetting$1(OpenWeRunSetting openWeRunSetting) {
        this.fGy = openWeRunSetting;
    }

    public final void q(boolean z, boolean z2) {
        boolean z3;
        OpenWeRunSetting openWeRunSetting = this.fGy;
        if (z && z2) {
            z3 = true;
        } else {
            z3 = false;
        }
        OpenWeRunSetting.a(openWeRunSetting, z3);
        x.i("MicroMsg.JsApiOpenWeRunSetting", "After getUserState requestOk %b, hasStep %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        OpenWeRunSetting.a(this.fGy);
    }
}
