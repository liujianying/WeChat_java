package com.tencent.mm.plugin.profile;

import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.x;

public final class Plugin implements c {
    public Plugin() {
        x.i("MicroMsg.Plugin.profile", "profile constructor " + System.currentTimeMillis());
    }

    public final n createApplication() {
        x.i("MicroMsg.Plugin.profile", "profile createApplication " + System.currentTimeMillis());
        return new a();
    }

    public final b getContactWidgetFactory() {
        x.i("MicroMsg.Plugin.profile", "profile getContactWidgetFactory " + System.currentTimeMillis());
        return null;
    }

    public final ar createSubCore() {
        x.i("MicroMsg.Plugin.profile", "profile createSubCore " + System.currentTimeMillis());
        return new b();
    }
}
