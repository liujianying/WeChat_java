package android.support.v4.media;

import android.os.IBinder;

class MediaBrowserServiceCompat$g {
    final /* synthetic */ MediaBrowserServiceCompat rR;

    /* renamed from: android.support.v4.media.MediaBrowserServiceCompat$g$6 */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ MediaBrowserServiceCompat$d sf;

        AnonymousClass6(MediaBrowserServiceCompat$d mediaBrowserServiceCompat$d) {
            this.sf = mediaBrowserServiceCompat$d;
        }

        public final void run() {
            IBinder asBinder = this.sf.asBinder();
            MediaBrowserServiceCompat.b(MediaBrowserServiceCompat$g.this.rR).remove(asBinder);
            MediaBrowserServiceCompat$b mediaBrowserServiceCompat$b = new MediaBrowserServiceCompat$b(MediaBrowserServiceCompat$g.this.rR, (byte) 0);
            mediaBrowserServiceCompat$b.rW = this.sf;
            MediaBrowserServiceCompat.b(MediaBrowserServiceCompat$g.this.rR).put(asBinder, mediaBrowserServiceCompat$b);
        }
    }

    private MediaBrowserServiceCompat$g(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.rR = mediaBrowserServiceCompat;
    }

    /* synthetic */ MediaBrowserServiceCompat$g(MediaBrowserServiceCompat mediaBrowserServiceCompat, byte b) {
        this(mediaBrowserServiceCompat);
    }
}
