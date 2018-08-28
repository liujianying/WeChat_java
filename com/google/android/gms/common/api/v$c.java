package com.google.android.gms.common.api;

import android.content.IntentSender.SendIntentException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.e;

class v$c implements Runnable {
    private final int aLW;
    private final ConnectionResult aLX;
    final /* synthetic */ v aMa;

    public v$c(v vVar, int i, ConnectionResult connectionResult) {
        this.aMa = vVar;
        this.aLW = i;
        this.aLX = connectionResult;
    }

    public final void run() {
        if (this.aLX.op()) {
            try {
                this.aLX.b(this.aMa.getActivity(), ((this.aMa.getActivity().getSupportFragmentManager().getFragments().indexOf(this.aMa) + 1) << 16) + 1);
            } catch (SendIntentException e) {
                v.a(this.aMa);
            }
        } else if (e.dk(this.aLX.aJC)) {
            e.a(this.aLX.aJC, this.aMa.getActivity(), this.aMa, this.aMa);
        } else {
            v.a(this.aMa, this.aLW, this.aLX);
        }
    }
}
