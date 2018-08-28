package com.tencent.mm.plugin.ipcall;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public class Plugin implements c {
    b koc = new b();

    public n createApplication() {
        return this.koc;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public ar createSubCore() {
        return i.aXo();
    }
}
