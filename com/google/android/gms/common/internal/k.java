package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.c.e;
import com.google.android.gms.common.internal.l.a;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class k<T extends IInterface> implements b, a {
    public static final String[] aOh = new String[]{"service_esmobile", "service_googleme"};
    private final Account aIy;
    private final h aKX;
    private final Looper aKe;
    private final com.google.android.gms.common.b aKf;
    private final Set<Scope> aKn;
    private final m aNV;
    private final Object aNW;
    private s aNX;
    private e aNY;
    private T aNZ;
    private final ArrayList<c<?>> aOa;
    private e aOb;
    private int aOc;
    private final c.b aOd;
    private final c.c aOe;
    private final int aOf;
    protected AtomicInteger aOg;
    public final Context mContext;
    final Handler mHandler;

    public k(Context context, Looper looper, int i, h hVar, c.b bVar, c.c cVar) {
        this(context, looper, m.aj(context), com.google.android.gms.common.b.oq(), i, hVar, (c.b) w.ah(bVar), (c.c) w.ah(cVar));
    }

    private k(Context context, Looper looper, m mVar, com.google.android.gms.common.b bVar, int i, h hVar, c.b bVar2, c.c cVar) {
        this.aNW = new Object();
        this.aOa = new ArrayList();
        this.aOc = 1;
        this.aOg = new AtomicInteger(0);
        this.mContext = (Context) w.j(context, "Context must not be null");
        this.aKe = (Looper) w.j(looper, "Looper must not be null");
        this.aNV = (m) w.j(mVar, "Supervisor must not be null");
        this.aKf = (com.google.android.gms.common.b) w.j(bVar, "API availability must not be null");
        this.mHandler = new b(this, looper);
        this.aOf = i;
        this.aKX = (h) w.ah(hVar);
        this.aIy = hVar.aIy;
        this.aKn = c(hVar.aNO);
        this.aOd = bVar2;
        this.aOe = cVar;
    }

    private void a(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        w.au(z);
        synchronized (this.aNW) {
            this.aOc = i;
            this.aNZ = t;
            switch (i) {
                case 1:
                    if (this.aOb != null) {
                        this.aNV.a(ow(), pd(), this.aOb);
                        this.aOb = null;
                        break;
                    }
                    break;
                case 2:
                    if (this.aOb != null) {
                        new StringBuilder("Calling connect() while still connected, missing disconnect() for ").append(ow()).append(" on ").append(pd());
                        this.aNV.a(ow(), pd(), this.aOb);
                        this.aOg.incrementAndGet();
                    }
                    this.aOb = new e(this, this.aOg.get());
                    if (!this.aNV.a(ow(), pd(), this.aOb, this.aKX.aJX)) {
                        new StringBuilder("unable to connect to service: ").append(ow()).append(" on ").append(pd());
                        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.aOg.get(), 9));
                        break;
                    }
                    break;
            }
        }
    }

    private boolean a(int i, int i2, T t) {
        boolean z;
        synchronized (this.aNW) {
            if (this.aOc != i) {
                z = false;
            } else {
                a(i2, (IInterface) t);
                z = true;
            }
        }
        return z;
    }

    private static Set<Scope> c(Set<Scope> set) {
        if (set != null) {
            for (Scope contains : set) {
                if (!set.contains(contains)) {
                    throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
                }
            }
        }
        return set;
    }

    protected static void pe() {
    }

    protected static void pf() {
    }

    private void pg() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, this.aOg.get(), 1));
    }

    public void a(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i2, -1, new g(this, i, iBinder, bundle)));
    }

    public void a(e eVar) {
        this.aNY = (e) w.j(eVar, "Connection progress callbacks cannot be null.");
        a(2, null);
    }

    public final void a(e eVar, ConnectionResult connectionResult) {
        this.aNY = (e) w.j(eVar, "Connection progress callbacks cannot be null.");
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.aOg.get(), connectionResult.aJC, connectionResult.aJD));
    }

    public final void a(p pVar) {
        try {
            this.aNX.a(new d(this, this.aOg.get()), new ValidateAccountRequest(pVar, (Scope[]) this.aKn.toArray(new Scope[this.aKn.size()]), this.mContext.getPackageName()));
        } catch (DeadObjectException e) {
            pg();
        } catch (RemoteException e2) {
        }
    }

    public final void a(p pVar, Set<Scope> set) {
        try {
            Bundle ph = ph();
            GetServiceRequest getServiceRequest = new GetServiceRequest(this.aOf);
            getServiceRequest.aNe = this.mContext.getPackageName();
            getServiceRequest.aNh = ph;
            if (set != null) {
                getServiceRequest.aNg = (Scope[]) set.toArray(new Scope[set.size()]);
            }
            if (ou()) {
                getServiceRequest.aNi = this.aIy != null ? this.aIy : new Account("<<default account>>", "com.google");
                if (pVar != null) {
                    getServiceRequest.aNf = pVar.asBinder();
                }
            }
            this.aNX.a(new d(this, this.aOg.get()), getServiceRequest);
        } catch (DeadObjectException e) {
            pg();
        } catch (RemoteException e2) {
        }
    }

    public final void a(String str, PrintWriter printWriter) {
        int i;
        IInterface iInterface;
        synchronized (this.aNW) {
            i = this.aOc;
            iInterface = this.aNZ;
        }
        printWriter.append(str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("CONNECTING");
                break;
            case 3:
                printWriter.print("CONNECTED");
                break;
            case 4:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (iInterface == null) {
            printWriter.println("null");
        } else {
            printWriter.append(ox()).append("@").println(Integer.toHexString(System.identityHashCode(iInterface.asBinder())));
        }
    }

    public void disconnect() {
        this.aOg.incrementAndGet();
        synchronized (this.aOa) {
            int size = this.aOa.size();
            for (int i = 0; i < size; i++) {
                ((c) this.aOa.get(i)).pl();
            }
            this.aOa.clear();
        }
        a(1, null);
    }

    public abstract T f(IBinder iBinder);

    public final boolean isConnected() {
        boolean z;
        synchronized (this.aNW) {
            z = this.aOc == 3;
        }
        return z;
    }

    public final boolean isConnecting() {
        boolean z;
        synchronized (this.aNW) {
            z = this.aOc == 2;
        }
        return z;
    }

    public boolean ou() {
        return false;
    }

    public boolean ov() {
        return true;
    }

    public abstract String ow();

    public abstract String ox();

    public String pd() {
        return "com.google.android.gms";
    }

    public Bundle ph() {
        return new Bundle();
    }

    public final T pi() {
        T t;
        synchronized (this.aNW) {
            if (this.aOc == 4) {
                throw new DeadObjectException();
            } else if (isConnected()) {
                w.d(this.aNZ != null, "Client is connected but service is null");
                t = this.aNZ;
            } else {
                throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
            }
        }
        return t;
    }
}
