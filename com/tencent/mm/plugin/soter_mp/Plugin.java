package com.tencent.mm.plugin.soter_mp;

import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.x;

public class Plugin implements c {
    public Plugin() {
        x.i("SubCoreSoter", "soter plugin constructor");
    }

    public n createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ar createSubCore() {
        return new b();
    }
}
