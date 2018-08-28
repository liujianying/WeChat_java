package com.google.android.gms.common.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.a.c;
import com.google.android.gms.common.api.o.d;
import com.google.android.gms.common.api.o.e;
import com.google.android.gms.common.internal.w;
import java.util.concurrent.atomic.AtomicReference;

public abstract class k$a<R extends g, A extends b> extends i<R> implements k.b<R>, e<A> {
    final c<A> aJR;
    private AtomicReference<d> aKF = new AtomicReference();

    public k$a(c<A> cVar, c cVar2) {
        super(((c) w.j(cVar2, "GoogleApiClient must not be null")).getLooper());
        this.aJR = (c) w.ah(cVar);
    }

    private void a(RemoteException remoteException) {
        c(new Status(remoteException.getLocalizedMessage()));
    }

    public final void a(A a) {
        try {
            b(a);
        } catch (RemoteException e) {
            a(e);
            throw e;
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    public final void a(d dVar) {
        this.aKF.set(dVar);
    }

    public final /* synthetic */ void ad(Object obj) {
        super.a((g) obj);
    }

    public abstract void b(A a);

    public final void c(Status status) {
        w.e(!status.isSuccess(), "Failed result must not be success");
        a(b(status));
    }

    protected final void oG() {
        d dVar = (d) this.aKF.getAndSet(null);
        if (dVar != null) {
            dVar.c(this);
        }
    }

    public final c<A> os() {
        return this.aJR;
    }
}
