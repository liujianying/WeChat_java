package com.google.android.gms.analytics.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.stats.b;
import java.util.Collections;

public final class t extends o {
    final a aGp = new a(this);
    d aGq;
    private final ae aGr;
    private j aGs;

    protected t(q qVar) {
        super(qVar);
        this.aGs = new j(qVar.aFC);
        this.aGr = new 1(this, qVar);
    }

    static /* synthetic */ void a(t tVar) {
        q.nx();
        if (tVar.isConnected()) {
            tVar.aO("Inactivity, disconnecting from device AnalyticsService");
            tVar.disconnect();
        }
    }

    public final boolean connect() {
        q.nx();
        np();
        if (this.aGq != null) {
            return true;
        }
        d nz = this.aGp.nz();
        if (nz == null) {
            return false;
        }
        this.aGq = nz;
        ny();
        return true;
    }

    public final boolean d(c cVar) {
        w.ah(cVar);
        q.nx();
        np();
        d dVar = this.aGq;
        if (dVar == null) {
            return false;
        }
        try {
            dVar.a(cVar.aFa, cVar.aFd, cVar.aFf ? ac.oa() : ac.ob(), Collections.emptyList());
            ny();
            return true;
        } catch (RemoteException e) {
            aO("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    public final void disconnect() {
        q.nx();
        np();
        try {
            b.pG().a(this.aFn.mContext, this.aGp);
        } catch (IllegalStateException e) {
        } catch (IllegalArgumentException e2) {
        }
        if (this.aGq != null) {
            this.aGq = null;
            this.aFn.nt().nj();
        }
    }

    public final boolean isConnected() {
        q.nx();
        np();
        return this.aGq != null;
    }

    protected final void mE() {
    }

    final void ny() {
        this.aGs.start();
        this.aGr.ac(((Long) aj.aIb.get()).longValue());
    }
}
