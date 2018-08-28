package com.tencent.mm.plugin.readerapp;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.readerapp.b.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public final class Plugin implements c {
    private b hjL = new 1(this);

    public final n createApplication() {
        return new a();
    }

    public final b getContactWidgetFactory() {
        return this.hjL;
    }

    public final ar createSubCore() {
        return null;
    }
}
