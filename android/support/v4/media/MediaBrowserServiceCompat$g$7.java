package android.support.v4.media;

import android.support.v4.media.MediaBrowserServiceCompat.d;
import android.support.v4.media.MediaBrowserServiceCompat.g;

class MediaBrowserServiceCompat$g$7 implements Runnable {
    final /* synthetic */ d sf;
    final /* synthetic */ g sj;

    MediaBrowserServiceCompat$g$7(g gVar, d dVar) {
        this.sj = gVar;
        this.sf = dVar;
    }

    public final void run() {
        MediaBrowserServiceCompat.b(this.sj.rR).remove(this.sf.asBinder());
    }
}
