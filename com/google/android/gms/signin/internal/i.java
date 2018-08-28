package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.signin.d;
import com.google.android.gms.signin.e;
import com.google.android.gms.signin.internal.f.a;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public final class i extends k<f> implements d {
    private final h aKX;
    private final e aNQ;
    private Integer aNR;
    private final boolean baL;
    private final ExecutorService baM;

    public i(Context context, Looper looper, boolean z, h hVar, b bVar, c cVar, ExecutorService executorService) {
        super(context, looper, 44, hVar, bVar, cVar);
        this.baL = z;
        this.aKX = hVar;
        this.aNQ = hVar.aNQ;
        this.aNR = hVar.aNR;
        this.baM = executorService;
    }

    public final void a(p pVar, Set<Scope> set, e eVar) {
        w.j(eVar, "Expecting a valid ISignInCallbacks");
        try {
            ((f) pi()).a(new AuthAccountRequest(pVar, set), eVar);
        } catch (RemoteException e) {
            try {
                eVar.a(new ConnectionResult(8, null), new AuthAccountResult());
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onAuthAccount should be executed from the same process, unexpected RemoteException.");
            }
        }
    }

    public final void a(p pVar, boolean z) {
        try {
            ((f) pi()).a(pVar, this.aNR.intValue(), z);
        } catch (RemoteException e) {
        }
    }

    public final void a(t tVar) {
        w.j(tVar, "Expecting a valid IResolveAccountCallbacks");
        try {
            h hVar = this.aKX;
            ((f) pi()).a(new ResolveAccountRequest(hVar.aIy != null ? hVar.aIy : new Account("<<default account>>", "com.google"), this.aNR.intValue()), tVar);
        } catch (RemoteException e) {
            try {
                tVar.a(new ResolveAccountResponse());
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "IResolveAccountCallbacks#onAccountResolutionComplete should be executed from the same process, unexpected RemoteException.");
            }
        }
    }

    public final void connect() {
        a(new k$f(this));
    }

    protected final /* synthetic */ IInterface f(IBinder iBinder) {
        return a.p(iBinder);
    }

    public final boolean ou() {
        return this.baL;
    }

    protected final String ow() {
        return "com.google.android.gms.signin.service.START";
    }

    protected final String ox() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    protected final Bundle ph() {
        e eVar = this.aNQ;
        Integer num = this.aKX.aNR;
        ExecutorService executorService = this.baM;
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", eVar.bbc);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", eVar.bbd);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", eVar.aJw);
        if (eVar.bbe != null) {
            bundle.putParcelable("com.google.android.gms.signin.internal.signInCallbacks", new BinderWrapper(new a(eVar, executorService).asBinder()));
        }
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        if (!this.mContext.getPackageName().equals(this.aKX.aJW)) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", this.aKX.aJW);
        }
        return bundle;
    }

    public final void qT() {
        try {
            ((f) pi()).dQ(this.aNR.intValue());
        } catch (RemoteException e) {
        }
    }
}
