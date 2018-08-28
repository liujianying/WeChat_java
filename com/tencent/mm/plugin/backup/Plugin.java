package com.tencent.mm.plugin.backup;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.backup.i.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin implements c {
    public n createApplication() {
        return new a();
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ar createSubCore() {
        if (a.hdd == null) {
            a.hdd = new a();
        }
        return a.hdd;
    }
}
