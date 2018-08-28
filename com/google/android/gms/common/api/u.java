package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.m;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.c;
import com.google.android.gms.common.internal.w;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public final class u extends Fragment implements OnCancelListener {
    boolean aLN;
    private int aLO = -1;
    private ConnectionResult aLP;
    private final Handler aLQ = new Handler(Looper.getMainLooper());
    final SparseArray<a> aLR = new SparseArray();
    boolean mg;

    public static u a(FragmentActivity fragmentActivity) {
        w.bh("Must be called from main thread of process");
        try {
            u uVar = (u) fragmentActivity.getSupportFragmentManager().J("GmsSupportLifecycleFragment");
            return (uVar == null || uVar.isRemoving()) ? null : uVar;
        } catch (Throwable e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", e);
        }
    }

    private void a(int i, ConnectionResult connectionResult) {
        a aVar = (a) this.aLR.get(i);
        if (aVar != null) {
            a aVar2 = (a) this.aLR.get(i);
            this.aLR.remove(i);
            if (aVar2 != null) {
                aVar2.aLT.b(aVar2);
                aVar2.aLT.disconnect();
            }
            c cVar = aVar.aLU;
            if (cVar != null) {
                cVar.a(connectionResult);
            }
        }
        oU();
    }

    public static u b(FragmentActivity fragmentActivity) {
        u a = a(fragmentActivity);
        m supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        if (a != null) {
            return a;
        }
        a = new u();
        supportFragmentManager.bk().a(a, "GmsSupportLifecycleFragment").commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
        return a;
    }

    private void oU() {
        boolean z = false;
        this.aLN = false;
        this.aLO = -1;
        this.aLP = null;
        while (true) {
            boolean z2 = z;
            if (z2 < this.aLR.size()) {
                ((a) this.aLR.valueAt(z2)).aLT.connect();
                z = z2 + 1;
            } else {
                return;
            }
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.aLR.size()) {
                a aVar = (a) this.aLR.valueAt(i2);
                printWriter.append(str).append("GoogleApiClient #").print(aVar.aLS);
                printWriter.println(":");
                aVar.aLT.a(str + "  ", printWriter);
                i = i2 + 1;
            } else {
                return;
            }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.u.onActivityResult(int, int, android.content.Intent):void");
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
        this.mg = true;
        if (!this.aLN) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aLR.size()) {
                    ((a) this.aLR.valueAt(i2)).aLT.connect();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void onStop() {
        boolean z = false;
        super.onStop();
        this.mg = false;
        while (true) {
            boolean z2 = z;
            if (z2 < this.aLR.size()) {
                ((a) this.aLR.valueAt(z2)).aLT.disconnect();
                z = z2 + 1;
            } else {
                return;
            }
        }
    }
}
