package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

@Deprecated
public final class Plugin implements c {
    public final n createApplication() {
        return null;
    }

    public final b getContactWidgetFactory() {
        return null;
    }

    public final ar createSubCore() {
        return new e();
    }
}
