package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.mm.plugin.emoji.model.f;

class a$1 implements Runnable {
    final /* synthetic */ f ies;
    final /* synthetic */ a iet;

    a$1(a aVar, f fVar) {
        this.iet = aVar;
        this.ies = fVar;
    }

    public final void run() {
        if (this.ies != null) {
            a.a(this.iet, this.iet.a(this.ies));
            this.iet.notifyDataSetChanged();
        }
    }
}
