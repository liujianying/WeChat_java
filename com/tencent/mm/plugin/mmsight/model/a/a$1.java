package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.plugin.mmsight.model.a.b.a;

class a$1 implements a {
    final /* synthetic */ a lhl;

    a$1(a aVar) {
        this.lhl = aVar;
    }

    public final void a(final b bVar) {
        a.a(this.lhl).post(new Runnable() {
            public final void run() {
                a.a(a$1.this.lhl, bVar);
            }
        });
    }
}
