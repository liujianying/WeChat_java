package com.google.android.gms.signin.internal;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.e;
import com.google.android.gms.signin.internal.d.a;
import java.util.List;
import java.util.concurrent.ExecutorService;

class i$a extends a {
    private final e aNQ;
    private final ExecutorService baM;

    public i$a(e eVar, ExecutorService executorService) {
        this.aNQ = eVar;
        this.baM = executorService;
    }

    public final void a(String str, String str2, f fVar) {
        this.baM.submit(new 2(this, str, str2, fVar));
    }

    public final void a(String str, List<Scope> list, f fVar) {
        this.baM.submit(new 1(this, list, str, fVar));
    }
}
