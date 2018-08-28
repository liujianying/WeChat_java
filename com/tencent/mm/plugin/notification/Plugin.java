package com.tencent.mm.plugin.notification;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin implements c {
    a lHr = new a();

    public n createApplication() {
        return this.lHr;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ar createSubCore() {
        return f.bky();
    }
}
