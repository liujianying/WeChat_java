package com.tencent.mm.plugin.ext;

import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin implements c {
    public ar createSubCore() {
        return new b();
    }

    public n createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return null;
    }
}
