package android.support.v4.app;

import android.app.PendingIntent;
import android.support.v4.app.ac.b;
import android.support.v4.app.ac.b.a;

public class z$f$a extends b {
    static final a pZ = new 1();
    private final String[] pT;
    private final ah pU;
    private final PendingIntent pV;
    private final PendingIntent pW;
    private final String[] pX;
    private final long pY;

    public final /* bridge */ /* synthetic */ aj.a bA() {
        return this.pU;
    }

    public z$f$a(String[] strArr, ah ahVar, PendingIntent pendingIntent, PendingIntent pendingIntent2, String[] strArr2, long j) {
        this.pT = strArr;
        this.pU = ahVar;
        this.pW = pendingIntent2;
        this.pV = pendingIntent;
        this.pX = strArr2;
        this.pY = j;
    }

    public final String[] getMessages() {
        return this.pT;
    }

    public final PendingIntent getReplyPendingIntent() {
        return this.pV;
    }

    public final PendingIntent getReadPendingIntent() {
        return this.pW;
    }

    public final String[] getParticipants() {
        return this.pX;
    }

    public final long getLatestTimestamp() {
        return this.pY;
    }
}
