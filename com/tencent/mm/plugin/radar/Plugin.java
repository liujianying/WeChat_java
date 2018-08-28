package com.tencent.mm.plugin.radar;

import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public final class Plugin implements c {
    public final n createApplication() {
        return (n) new b();
    }

    public final b getContactWidgetFactory() {
        return null;
    }

    public final ar createSubCore() {
        return (ar) new c();
    }
}
