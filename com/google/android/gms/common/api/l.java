package com.google.android.gms.common.api;

import android.content.IntentFilter;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.k.a;
import com.google.android.gms.common.api.o.c;
import com.google.android.gms.common.api.o.e;
import com.google.android.gms.common.internal.w;

public final class l implements p {
    private final o aKG;

    public l(o oVar) {
        this.aKG = oVar;
    }

    private <A extends b> void a(e<A> eVar) {
        this.aKG.b(eVar);
        o oVar = this.aKG;
        b bVar = (b) oVar.aLw.get(eVar.os());
        w.j(bVar, "Appropriate Api was not requested.");
        if (bVar.isConnected() || !this.aKG.aLx.containsKey(eVar.os())) {
            eVar.a(bVar);
        } else {
            eVar.c(new Status(17));
        }
    }

    public final <A extends b, R extends g, T extends a<R, A>> T a(T t) {
        return b(t);
    }

    public final void a(ConnectionResult connectionResult, a<?> aVar, int i) {
    }

    public final <A extends b, T extends a<? extends g, A>> T b(T t) {
        try {
            a((e) t);
        } catch (DeadObjectException e) {
            this.aKG.a(new 1(this, this));
        }
        return t;
    }

    public final void begin() {
        while (!this.aKG.aLq.isEmpty()) {
            try {
                a((e) this.aKG.aLq.remove());
            } catch (DeadObjectException e) {
            }
        }
    }

    public final void connect() {
    }

    public final void disconnect() {
        this.aKG.aLx.clear();
        this.aKG.oR();
        this.aKG.f(null);
        this.aKG.aLp.pm();
    }

    public final void dm(int i) {
        if (i == 1) {
            o oVar = this.aKG;
            if (!oVar.aLr) {
                oVar.aLr = true;
                if (oVar.aLv == null) {
                    oVar.aLv = new c(oVar);
                    IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addDataScheme("package");
                    oVar.mContext.getApplicationContext().registerReceiver(oVar.aLv, intentFilter);
                }
                oVar.aLu.sendMessageDelayed(oVar.aLu.obtainMessage(1), oVar.aLs);
                oVar.aLu.sendMessageDelayed(oVar.aLu.obtainMessage(2), oVar.aLt);
            }
        }
        for (e a : this.aKG.aLC) {
            a.a(new Status(8, "The connection to Google Play services was lost"));
        }
        this.aKG.f(null);
        this.aKG.aLp.dt(i);
        this.aKG.aLp.pm();
        if (i == 2) {
            this.aKG.connect();
        }
    }

    public final void e(Bundle bundle) {
    }

    public final String getName() {
        return "CONNECTED";
    }
}
