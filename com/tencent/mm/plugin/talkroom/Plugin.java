package com.tencent.mm.plugin.talkroom;

import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.b.a;

public class Plugin implements c {
    public Plugin() {
        a.sFg.b(new 1(this));
        a.sFg.b(new b((byte) 0));
        a.sFg.b(new a(this, (byte) 0));
        a.sFg.b(new c(this, (byte) 0));
    }

    public n createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ar createSubCore() {
        return new com.tencent.mm.plugin.talkroom.model.b();
    }
}
