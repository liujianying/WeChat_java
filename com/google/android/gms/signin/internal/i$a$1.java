package com.google.android.gms.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.c$d$a;
import com.google.android.gms.common.api.c.d;
import com.google.android.gms.signin.internal.i.a;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class i$a$1 implements Runnable {
    final /* synthetic */ List baN;
    final /* synthetic */ String baO;
    final /* synthetic */ f baP;
    final /* synthetic */ a baQ;

    i$a$1(a aVar, List list, String str, f fVar) {
        this.baQ = aVar;
        this.baN = list;
        this.baO = str;
        this.baP = fVar;
    }

    public final void run() {
        try {
            d a = a.a(this.baQ);
            Collections.unmodifiableSet(new HashSet(this.baN));
            c$d$a oC = a.oC();
            this.baP.a(new CheckServerAuthResult(oC.aKm, oC.aKn));
        } catch (RemoteException e) {
        }
    }
}
