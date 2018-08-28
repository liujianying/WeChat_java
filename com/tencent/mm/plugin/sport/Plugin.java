package com.tencent.mm.plugin.sport;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.sport.c.o;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin implements c {
    public n createApplication() {
        return new d();
    }

    public b getContactWidgetFactory() {
        return new com.tencent.mm.plugin.sport.ui.a.b();
    }

    public ar createSubCore() {
        return new o();
    }
}
