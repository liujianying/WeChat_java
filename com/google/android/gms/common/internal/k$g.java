package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.k.a;

protected final class k$g extends a {
    final /* synthetic */ k aOj;
    public final IBinder aOn;

    public k$g(k kVar, int i, IBinder iBinder, Bundle bundle) {
        this.aOj = kVar;
        super(kVar, i, bundle);
        this.aOn = iBinder;
    }

    protected final void h(ConnectionResult connectionResult) {
        if (k.e(this.aOj) != null) {
            k.e(this.aOj).a(connectionResult);
        }
        k.pf();
    }

    protected final boolean pj() {
        try {
            String interfaceDescriptor = this.aOn.getInterfaceDescriptor();
            if (this.aOj.ox().equals(interfaceDescriptor)) {
                IInterface f = this.aOj.f(this.aOn);
                if (f == null || !k.a(this.aOj, 2, 3, f)) {
                    return false;
                }
                if (k.b(this.aOj) != null) {
                    k.b(this.aOj).e(null);
                }
                return true;
            }
            new StringBuilder("service descriptor mismatch: ").append(this.aOj.ox()).append(" vs. ").append(interfaceDescriptor);
            return false;
        } catch (RemoteException e) {
            return false;
        }
    }
}
