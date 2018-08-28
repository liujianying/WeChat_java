package com.tencent.mm.plugin.subapp;

import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.x;

public final class Plugin implements c {
    public Plugin() {
        x.i("MicroMsg.Plugin.subapp", "subapp constructor " + System.currentTimeMillis());
    }

    public final n createApplication() {
        x.i("MicroMsg.Plugin.subapp", "subapp createApplication " + System.currentTimeMillis());
        return new b();
    }

    public final b getContactWidgetFactory() {
        x.i("MicroMsg.Plugin.subapp", "subapp getContactWidgetFactory " + System.currentTimeMillis());
        return null;
    }

    public final ar createSubCore() {
        x.i("MicroMsg.Plugin.subapp", "subapp createSubCore " + System.currentTimeMillis());
        return new a();
    }
}
