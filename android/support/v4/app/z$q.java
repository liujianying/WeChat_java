package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;
import android.support.v4.app.af.a;
import android.support.v4.app.z.d;

class z$q extends z$p {
    z$q() {
    }

    public Notification b(d dVar) {
        a aVar = new a(dVar.mContext, dVar.pQ, dVar.ps, dVar.pt, dVar.py, dVar.pw, dVar.pz, dVar.pu, dVar.pv, dVar.px, dVar.pE, dVar.pF, dVar.pG, dVar.pA, dVar.pB, dVar.mPriority, dVar.pD, dVar.pL, dVar.pR, dVar.mExtras, dVar.pH, dVar.pI, dVar.pJ);
        z.a(aVar, dVar.pK);
        z.a(aVar, dVar.pC);
        return aVar.build();
    }

    public final Bundle a(Notification notification) {
        return notification.extras;
    }
}
