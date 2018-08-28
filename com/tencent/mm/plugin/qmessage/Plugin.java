package com.tencent.mm.plugin.qmessage;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin implements c {
    private b hjL = new 1(this);

    public n createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return this.hjL;
    }

    public ar createSubCore() {
        return new g();
    }
}
