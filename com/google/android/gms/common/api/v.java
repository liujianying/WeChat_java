package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.m;
import android.support.v4.app.t;
import android.support.v4.app.t.a;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.internal.w;

public final class v extends Fragment implements OnCancelListener, a<ConnectionResult> {
    private boolean aLN;
    private int aLO = -1;
    private ConnectionResult aLP;
    private final Handler aLQ = new Handler(Looper.getMainLooper());
    public final SparseArray<b> aLR = new SparseArray();

    private void a(int i, ConnectionResult connectionResult) {
        b bVar = (b) this.aLR.get(i);
        if (bVar != null) {
            this.aLR.remove(i);
            getLoaderManager().destroyLoader(i);
            c cVar = bVar.aLU;
            if (cVar != null) {
                cVar.a(connectionResult);
            }
        }
        oU();
    }

    public static v c(FragmentActivity fragmentActivity) {
        w.bh("Must be called from main thread of process");
        m supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        try {
            v vVar = (v) supportFragmentManager.J("GmsSupportLoaderLifecycleFragment");
            if (vVar != null && !vVar.isRemoving()) {
                return vVar;
            }
            vVar = new v();
            supportFragmentManager.bk().a(vVar, "GmsSupportLoaderLifecycleFragment").commit();
            supportFragmentManager.executePendingTransactions();
            return vVar;
        } catch (Throwable e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLoaderLifecycleFragment is not a SupportLoaderLifecycleFragment", e);
        }
    }

    private void oU() {
        int i = 0;
        this.aLN = false;
        this.aLO = -1;
        this.aLP = null;
        t loaderManager = getLoaderManager();
        while (i < this.aLR.size()) {
            int keyAt = this.aLR.keyAt(i);
            a dp = dp(keyAt);
            if (dp != null && dp.aLY) {
                loaderManager.destroyLoader(keyAt);
                loaderManager.a(keyAt, this);
            }
            i++;
        }
    }

    public final android.support.v4.content.c<ConnectionResult> X(int i) {
        return new a(getActivity(), ((b) this.aLR.get(i)).aLT);
    }

    public final a dp(int i) {
        try {
            return (a) getLoaderManager().W(i);
        } catch (Throwable e) {
            throw new IllegalStateException("Unknown loader in SupportLoaderLifecycleFragment", e);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
        r3 = this;
        r0 = 1;
        r1 = 0;
        switch(r4) {
            case 1: goto L_0x0017;
            case 2: goto L_0x000c;
            default: goto L_0x0005;
        };
    L_0x0005:
        r0 = r1;
    L_0x0006:
        if (r0 == 0) goto L_0x001b;
    L_0x0008:
        r3.oU();
    L_0x000b:
        return;
    L_0x000c:
        r2 = r3.getActivity();
        r2 = com.google.android.gms.common.e.ae(r2);
        if (r2 != 0) goto L_0x0005;
    L_0x0016:
        goto L_0x0006;
    L_0x0017:
        r2 = -1;
        if (r5 != r2) goto L_0x0005;
    L_0x001a:
        goto L_0x0006;
    L_0x001b:
        r0 = r3.aLO;
        r1 = r3.aLP;
        r3.a(r0, r1);
        goto L_0x000b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.v.onActivityResult(int, int, android.content.Intent):void");
    }

    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.aLR.size()) {
                int keyAt = this.aLR.keyAt(i2);
                a dp = dp(keyAt);
                if (dp == null || ((b) this.aLR.valueAt(i2)).aLT == dp.aLT) {
                    getLoaderManager().a(keyAt, this);
                } else {
                    getLoaderManager().b(keyAt, this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public final void onCancel(DialogInterface dialogInterface) {
        a(this.aLO, new ConnectionResult(13, null));
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.aLN = bundle.getBoolean("resolving_error", false);
            this.aLO = bundle.getInt("failed_client_id", -1);
            if (this.aLO >= 0) {
                this.aLP = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", this.aLN);
        if (this.aLO >= 0) {
            bundle.putInt("failed_client_id", this.aLO);
            bundle.putInt("failed_status", this.aLP.aJC);
            bundle.putParcelable("failed_resolution", this.aLP.aJD);
        }
    }

    public final void onStart() {
        super.onStart();
        if (!this.aLN) {
            for (int i = 0; i < this.aLR.size(); i++) {
                getLoaderManager().a(this.aLR.keyAt(i), this);
            }
        }
    }
}
