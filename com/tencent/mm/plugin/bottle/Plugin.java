package com.tencent.mm.plugin.bottle;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.bottle.a.i;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public final class Plugin implements c {
    private b hjL = new 1(this);

    public final n createApplication() {
        return new a();
    }

    public final ar createSubCore() {
        return new i();
    }

    public final b getContactWidgetFactory() {
        return this.hjL;
    }
}
