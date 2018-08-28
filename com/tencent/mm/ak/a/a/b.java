package com.tencent.mm.ak.a.a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mm.ak.a.c.a;
import com.tencent.mm.ak.a.c.e;
import com.tencent.mm.ak.a.c.f;
import com.tencent.mm.ak.a.c.h;
import com.tencent.mm.ak.a.c.j;
import com.tencent.mm.ak.a.c.k;
import com.tencent.mm.ak.a.c.m;
import com.tencent.mm.ak.a.c.n;
import java.util.concurrent.Executor;

public final class b {
    public static final int dXg = Runtime.getRuntime().availableProcessors();
    public final Resources dXh;
    public final int dXi;
    public final int dXj;
    public final c dXk;
    public final m dXl;
    public final a dXm;
    public final com.tencent.mm.ak.a.c.b dXn;
    public final f dXo;
    public final j dXp;
    public final k dXq;
    public final e dXr;
    public final h dXs;
    public final Executor dXt;
    public final n dXu;
    public final String packageName;

    public b(a aVar) {
        this.packageName = aVar.context.getPackageName();
        this.dXh = aVar.context.getResources();
        this.dXi = aVar.dXi;
        this.dXj = aVar.dXj;
        this.dXk = aVar.dXk;
        this.dXl = aVar.dXl;
        this.dXm = aVar.dXm;
        this.dXn = aVar.dXn;
        this.dXo = aVar.dXo;
        this.dXp = aVar.dXp;
        this.dXs = aVar.dXs;
        this.dXt = aVar.dXt;
        this.dXq = aVar.dXv;
        this.dXr = aVar.dXr;
        this.dXu = aVar.dXu;
    }

    public static b bN(Context context) {
        return new a(context).Ps();
    }
}
