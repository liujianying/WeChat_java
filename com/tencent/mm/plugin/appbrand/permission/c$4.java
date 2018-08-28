package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.mm.plugin.appbrand.permission.b.b;
import com.tencent.mm.plugin.appbrand.permission.c.a;

class c$4 implements b {
    final /* synthetic */ c gqn;
    final /* synthetic */ c.b gqo;

    c$4(c cVar, c.b bVar) {
        this.gqn = cVar;
        this.gqo = bVar;
    }

    public final void aml() {
        if (this.gqo != null) {
            this.gqo.a(a.amr());
        }
    }

    public final void amm() {
        if (this.gqo != null) {
            this.gqo.a(a.ams());
        }
    }

    public final void onCancel() {
        if (this.gqo != null) {
            this.gqo.a(a.amt());
        }
    }
}
