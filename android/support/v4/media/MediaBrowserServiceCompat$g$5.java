package android.support.v4.media;

import android.support.v4.media.MediaBrowserServiceCompat.g;
import android.support.v4.os.ResultReceiver;

class MediaBrowserServiceCompat$g$5 implements Runnable {
    final /* synthetic */ ResultReceiver rS;
    final /* synthetic */ g sj;
    final /* synthetic */ String sl;

    MediaBrowserServiceCompat$g$5(g gVar, String str, ResultReceiver resultReceiver) {
        this.sj = gVar;
        this.sl = str;
        this.rS = resultReceiver;
    }

    public final void run() {
        MediaBrowserServiceCompat.a(this.sj.rR, this.sl, this.rS);
    }
}
