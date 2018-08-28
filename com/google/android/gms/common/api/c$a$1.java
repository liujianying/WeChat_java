package com.google.android.gms.common.api;

import com.google.android.gms.common.api.c.a;

class c$a$1 implements Runnable {
    final /* synthetic */ c aKk;
    final /* synthetic */ a aKl;

    public c$a$1(a aVar, c cVar) {
        this.aKl = aVar;
        this.aKk = cVar;
    }

    public final void run() {
        if (!this.aKl.aKa.isFinishing() && !this.aKl.aKa.getSupportFragmentManager().isDestroyed()) {
            this.aKl.a(u.b(this.aKl.aKa), this.aKk);
        }
    }
}
