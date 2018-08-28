package com.google.android.gms.common.api;

import android.content.IntentSender.SendIntentException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.e;

class u$b implements Runnable {
    final /* synthetic */ u aLV;
    private final int aLW;
    private final ConnectionResult aLX;

    public u$b(u uVar, int i, ConnectionResult connectionResult) {
        this.aLV = uVar;
        this.aLW = i;
        this.aLX = connectionResult;
    }

    public final void run() {
        if (u.a(this.aLV) && !u.b(this.aLV)) {
            u.c(this.aLV);
            u.a(this.aLV, this.aLW);
            u.a(this.aLV, this.aLX);
            if (this.aLX.op()) {
                try {
                    this.aLX.b(this.aLV.getActivity(), ((this.aLV.getActivity().getSupportFragmentManager().getFragments().indexOf(this.aLV) + 1) << 16) + 1);
                } catch (SendIntentException e) {
                    u.d(this.aLV);
                }
            } else if (e.dk(this.aLX.aJC)) {
                e.a(this.aLX.aJC, this.aLV.getActivity(), this.aLV, this.aLV);
            } else {
                u.a(this.aLV, this.aLW, this.aLX);
            }
        }
    }
}
