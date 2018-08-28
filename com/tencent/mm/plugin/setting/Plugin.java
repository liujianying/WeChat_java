package com.tencent.mm.plugin.setting;

import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.x;

public final class Plugin implements c {
    public Plugin() {
        x.i("MicroMsg.Plugin.setting", "setting constructor " + System.currentTimeMillis());
    }

    public final n createApplication() {
        x.i("MicroMsg.Plugin.setting", "setting createApplication " + System.currentTimeMillis());
        return new b();
    }

    public final b getContactWidgetFactory() {
        x.i("MicroMsg.Plugin.setting", "setting getContactWidgetFactory " + System.currentTimeMillis());
        return null;
    }

    public final ar createSubCore() {
        x.i("MicroMsg.Plugin.setting", "setting createSubCore " + System.currentTimeMillis());
        return new c();
    }
}
