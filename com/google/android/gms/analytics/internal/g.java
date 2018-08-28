package com.google.android.gms.analytics.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.analytics.internal.m.1;
import com.google.android.gms.common.internal.w;

class g extends BroadcastReceiver {
    static final String aFm = g.class.getName();
    final q aFn;
    boolean aFo;
    boolean aFp;

    g(q qVar) {
        w.ah(qVar);
        this.aFn = qVar;
    }

    final void mN() {
        this.aFn.nr();
        this.aFn.nt();
    }

    final boolean mO() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.aFn.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (SecurityException e) {
            return false;
        }
    }

    public void onReceive(Context context, Intent intent) {
        mN();
        String action = intent.getAction();
        this.aFn.nr().d("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean mO = mO();
            if (this.aFp != mO) {
                this.aFp = mO;
                m nt = this.aFn.nt();
                nt.d("Network connectivity status changed", Boolean.valueOf(mO));
                nt.aFn.ns().d(new 1(nt, mO));
            }
        } else if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.aFn.nr().f("NetworkBroadcastReceiver received unknown action", action);
        } else if (!intent.hasExtra(aFm)) {
            m nt2 = this.aFn.nt();
            nt2.aO("Radio powered up");
            nt2.ni();
        }
    }

    public final void unregister() {
        if (this.aFo) {
            this.aFn.nr().aO("Unregistering connectivity change receiver");
            this.aFo = false;
            this.aFp = false;
            try {
                this.aFn.mContext.unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.aFn.nr().g("Failed to unregister the network broadcast receiver", e);
            }
        }
    }
}
