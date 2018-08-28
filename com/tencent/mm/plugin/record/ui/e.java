package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h.a;

public final class e extends h implements c {
    int fromScene = 0;

    public e(Context context, a aVar) {
        super(context, aVar);
    }

    public final void a(a aVar) {
        this.msQ = aVar;
        this.msv.clear();
        this.msv.addAll(aVar.msv);
        notifyDataSetChanged();
    }

    public final void d(b bVar) {
        bVar.bjS = 0;
        bVar.fromScene = this.fromScene;
        bVar.bJC = ((f) this.msQ).bJC;
        bVar.bXN = ((f) this.msQ).bXN;
    }

    public final void a(int i, f fVar) {
        bqH();
    }
}
