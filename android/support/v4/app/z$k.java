package android.support.v4.app;

import android.app.Notification;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.ab.a;
import android.support.v4.app.ac.b;
import android.support.v4.app.z.d;
import android.support.v4.app.z.j;

class z$k extends j {
    z$k() {
    }

    public final Notification b(d dVar) {
        a aVar = new a(dVar.mContext, dVar.pQ, dVar.ps, dVar.pt, dVar.py, dVar.pw, dVar.pz, dVar.pu, dVar.pv, dVar.px, dVar.pE, dVar.pF, dVar.pG, dVar.pA, dVar.pB, dVar.mPriority, dVar.pD, dVar.pL, dVar.pM, dVar.pR, dVar.mExtras, dVar.pN, dVar.pO, dVar.pP, dVar.pH, dVar.pI, dVar.pJ);
        z.a(aVar, dVar.pK);
        z.a(aVar, dVar.pC);
        return aVar.build();
    }

    public final Bundle a(b bVar) {
        String str = null;
        int i = 0;
        if (bVar == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (bVar.getParticipants() != null && bVar.getParticipants().length > 1) {
            str = bVar.getParticipants()[0];
        }
        Parcelable[] parcelableArr = new Parcelable[bVar.getMessages().length];
        while (i < parcelableArr.length) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("text", bVar.getMessages()[i]);
            bundle2.putString("author", str);
            parcelableArr[i] = bundle2;
            i++;
        }
        bundle.putParcelableArray("messages", parcelableArr);
        aj.a bA = bVar.bA();
        if (bA != null) {
            bundle.putParcelable("remote_input", ab.a(bA));
        }
        bundle.putParcelable("on_reply", bVar.getReplyPendingIntent());
        bundle.putParcelable("on_read", bVar.getReadPendingIntent());
        bundle.putStringArray("participants", bVar.getParticipants());
        bundle.putLong("timestamp", bVar.getLatestTimestamp());
        return bundle;
    }
}
