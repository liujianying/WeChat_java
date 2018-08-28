package com.google.android.gms.common.api;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.api.u.b;

class u$a implements c {
    public final int aLS;
    public final c aLT;
    public final c aLU;
    final /* synthetic */ u aLV;

    public u$a(u uVar, int i, c cVar, c cVar2) {
        this.aLV = uVar;
        this.aLS = i;
        this.aLT = cVar;
        this.aLU = cVar2;
        cVar.a(this);
    }

    public final void a(ConnectionResult connectionResult) {
        u.e(this.aLV).post(new b(this.aLV, this.aLS, connectionResult));
    }
}
