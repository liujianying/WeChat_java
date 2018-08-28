package com.tencent.mm.plugin.music;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.music.model.b;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin implements c {
    public n createApplication() {
        return new b();
    }

    public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory() {
        return null;
    }

    public ar createSubCore() {
        return new h();
    }
}
