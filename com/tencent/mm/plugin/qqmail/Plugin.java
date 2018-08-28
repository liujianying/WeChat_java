package com.tencent.mm.plugin.qqmail;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.qqmail.a.a;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public final class Plugin implements c {
    private a mbX = new a();

    public final n createApplication() {
        return new a();
    }

    public final b getContactWidgetFactory() {
        return this.mbX;
    }

    public final ar createSubCore() {
        return new w();
    }
}
