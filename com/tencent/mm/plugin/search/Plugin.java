package com.tencent.mm.plugin.search;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.search.a.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public final class Plugin implements c {
    public final n createApplication() {
        return new a();
    }

    public final ar createSubCore() {
        return new b();
    }

    public final com.tencent.mm.pluginsdk.b.b getContactWidgetFactory() {
        return null;
    }
}
