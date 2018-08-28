package com.tencent.mm.plugin.freewifi.ui;

import com.tencent.mm.sdk.platformtools.x;

class c$2 implements Runnable {
    final /* synthetic */ c jnp;

    c$2(c cVar) {
        this.jnp = cVar;
    }

    public final void run() {
        c.d(this.jnp);
        if (c.a(this.jnp) != null) {
            c.a(this.jnp).c(c.b(this.jnp));
        }
        if (c.b(this.jnp) == null) {
            x.w(c.ath(), "already callback");
        } else {
            c.c(this.jnp);
        }
    }
}
