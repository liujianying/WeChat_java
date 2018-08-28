package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserServiceCompat.b;
import android.support.v4.media.MediaBrowserServiceCompat.d;
import android.support.v4.media.MediaBrowserServiceCompat.g;

class MediaBrowserServiceCompat$g$1 implements Runnable {
    final /* synthetic */ d sf;
    final /* synthetic */ String sg;
    final /* synthetic */ Bundle sh;
    final /* synthetic */ int si;
    final /* synthetic */ g sj;

    MediaBrowserServiceCompat$g$1(g gVar, d dVar, String str, Bundle bundle, int i) {
        this.sj = gVar;
        this.sf = dVar;
        this.sg = str;
        this.sh = bundle;
        this.si = i;
    }

    public final void run() {
        IBinder asBinder = this.sf.asBinder();
        MediaBrowserServiceCompat.b(this.sj.rR).remove(asBinder);
        b bVar = new b(this.sj.rR, (byte) 0);
        bVar.rU = this.sg;
        bVar.rV = this.sh;
        bVar.rW = this.sf;
        bVar.rX = this.sj.rR.bK();
        if (bVar.rX == null) {
            new StringBuilder("No root for client ").append(this.sg).append(" from service ").append(getClass().getName());
            try {
                this.sf.bL();
                return;
            } catch (RemoteException e) {
                new StringBuilder("Calling onConnectFailed() failed. Ignoring. pkg=").append(this.sg);
                return;
            }
        }
        try {
            MediaBrowserServiceCompat.b(this.sj.rR).put(asBinder, bVar);
            if (this.sj.rR.rN != null) {
                this.sf.a(bVar.rX.rT, this.sj.rR.rN, bVar.rX.mExtras);
            }
        } catch (RemoteException e2) {
            new StringBuilder("Calling onConnect() failed. Dropping client. pkg=").append(this.sg);
            MediaBrowserServiceCompat.b(this.sj.rR).remove(asBinder);
        }
    }
}
