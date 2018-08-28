package c.t.m.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public final class dh extends BroadcastReceiver {
    final ct a;
    boolean b;

    public dh(ct ctVar) {
        this.a = ctVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                if (intent.getBooleanExtra("noConnectivity", false)) {
                    this.a.c(Integer.valueOf(-1));
                } else if (j.b(context)) {
                    this.a.c(Integer.valueOf(1));
                } else {
                    this.a.c(Integer.valueOf(0));
                }
            } catch (Exception e) {
            }
        }
    }
}
