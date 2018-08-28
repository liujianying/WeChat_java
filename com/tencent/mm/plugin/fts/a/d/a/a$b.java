package com.tencent.mm.plugin.fts.a.d.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.n;

public abstract class a$b {
    final /* synthetic */ a jtt;

    public abstract View a(Context context, ViewGroup viewGroup);

    public abstract void a(Context context, a aVar, a aVar2, Object... objArr);

    public abstract boolean a(Context context, a aVar);

    public a$b(a aVar) {
        this.jtt = aVar;
    }

    public static void a(String str, l lVar) {
        ((n) g.n(n.class)).updateTopHitsRank(str, lVar, 0);
    }
}
