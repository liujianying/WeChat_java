package com.tencent.tencentmap.mapsdk.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

public final class d extends BroadcastReceiver {
    private boolean a = false;
    private Context b;
    private Runnable c = new 1();

    public final void onReceive(Context context, Intent intent) {
        if (context == null) {
            try {
                ct.c(" onReceive context is null!", new Object[0]);
                return;
            } catch (Throwable e) {
                ct.a(e);
                return;
            }
        }
        if (this.b == null) {
            this.b = context;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            ct.c(" onReceive ConnectivityManager is null!", new Object[0]);
            return;
        }
        State state;
        State state2;
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo != null) {
            state = networkInfo.getState();
        } else {
            state = null;
        }
        if (networkInfo2 != null) {
            state2 = networkInfo2.getState();
        } else {
            state2 = null;
        }
        if (!(state == null && state2 == null)) {
            cf a = cf.a(context);
            if (!(a.a() || dl.d().h() == 0 || a.j() == 2)) {
                b.a().a(a.d());
            }
        }
        if (state != null || state2 != null) {
            if (State.CONNECTED == state2 || State.CONNECTED == state) {
                b.a().a(this.c);
            }
        }
    }

    public final void a(Context context) {
        if (context == null) {
            ct.c(" Context is null!", new Object[0]);
        } else if (!this.a) {
            this.a = true;
            context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }
}
