package com.tencent.mm.plugin.wear;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public final class Plugin implements c {
    public final n createApplication() {
        return null;
    }

    public final b getContactWidgetFactory() {
        return null;
    }

    public final ar createSubCore() {
        return new a();
    }
}
