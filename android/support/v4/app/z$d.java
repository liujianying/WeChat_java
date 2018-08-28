package android.support.v4.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.z.a;
import android.support.v4.app.z.e;
import android.support.v4.app.z.i;
import android.support.v4.app.z.r;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class z$d {
    public Context mContext;
    Bundle mExtras;
    int mPriority;
    boolean pA = true;
    public boolean pB;
    public r pC;
    public CharSequence pD;
    int pE;
    int pF;
    boolean pG;
    String pH;
    boolean pI;
    String pJ;
    public ArrayList<a> pK = new ArrayList();
    public boolean pL = false;
    public String pM;
    int pN = 0;
    int pO = 0;
    Notification pP;
    public Notification pQ = new Notification();
    public ArrayList<String> pR;
    public CharSequence ps;
    public CharSequence pt;
    public PendingIntent pu;
    PendingIntent pv;
    RemoteViews pw;
    public Bitmap px;
    public CharSequence py;
    public int pz;

    public z$d(Context context) {
        this.mContext = context;
        this.pQ.when = System.currentTimeMillis();
        this.pQ.audioStreamType = -1;
        this.mPriority = 0;
        this.pR = new ArrayList();
    }

    public final z$d g(long j) {
        this.pQ.when = j;
        return this;
    }

    public final z$d Y(int i) {
        this.pQ.icon = i;
        return this;
    }

    public final z$d b(CharSequence charSequence) {
        this.ps = e(charSequence);
        return this;
    }

    public final z$d c(CharSequence charSequence) {
        this.pt = e(charSequence);
        return this;
    }

    public final z$d b(int i, int i2, boolean z) {
        this.pE = i;
        this.pF = i2;
        this.pG = z;
        return this;
    }

    public final z$d d(CharSequence charSequence) {
        this.pQ.tickerText = e(charSequence);
        return this;
    }

    public final z$d u(boolean z) {
        j(16, z);
        return this;
    }

    public final void j(int i, boolean z) {
        Notification notification;
        if (z) {
            notification = this.pQ;
            notification.flags |= i;
            return;
        }
        notification = this.pQ;
        notification.flags &= i ^ -1;
    }

    public final z$d a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        this.pK.add(new a(i, charSequence, pendingIntent));
        return this;
    }

    @Deprecated
    public final Notification getNotification() {
        return build();
    }

    public final Notification build() {
        i by = z.by();
        e eVar = new e();
        return by.b(this);
    }

    protected static CharSequence e(CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 5120) {
            return charSequence.subSequence(0, 5120);
        }
        return charSequence;
    }
}
