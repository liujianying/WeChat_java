package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserServiceCompat.b;
import android.support.v4.media.MediaBrowserServiceCompat.d;
import android.support.v4.media.MediaBrowserServiceCompat.g;

class MediaBrowserServiceCompat$g$4 implements Runnable {
    final /* synthetic */ Bundle rQ;
    final /* synthetic */ d sf;
    final /* synthetic */ g sj;
    final /* synthetic */ String sk;

    MediaBrowserServiceCompat$g$4(g gVar, d dVar, String str, Bundle bundle) {
        this.sj = gVar;
        this.sf = dVar;
        this.sk = str;
        this.rQ = bundle;
    }

    public final void run() {
        b bVar = (b) MediaBrowserServiceCompat.b(this.sj.rR).get(this.sf.asBinder());
        if (bVar == null) {
            new StringBuilder("removeSubscription for callback that isn't registered id=").append(this.sk);
        } else if (!MediaBrowserServiceCompat.a(this.sk, bVar, this.rQ)) {
            new StringBuilder("removeSubscription called for ").append(this.sk).append(" which is not subscribed");
        }
    }
}
