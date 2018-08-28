package com.tencent.mm.plugin.wallet_core;

import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.wallet_core.a.a;
import com.tencent.mm.plugin.wallet_core.model.o;
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
        return new o();
    }
}
