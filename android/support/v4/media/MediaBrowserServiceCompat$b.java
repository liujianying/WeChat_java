package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserServiceCompat.a;
import java.util.HashMap;
import java.util.List;

class MediaBrowserServiceCompat$b {
    final /* synthetic */ MediaBrowserServiceCompat rR;
    String rU;
    Bundle rV;
    MediaBrowserServiceCompat$d rW;
    a rX;
    HashMap<String, List<Bundle>> rY;

    private MediaBrowserServiceCompat$b(MediaBrowserServiceCompat mediaBrowserServiceCompat) {
        this.rR = mediaBrowserServiceCompat;
        this.rY = new HashMap();
    }

    /* synthetic */ MediaBrowserServiceCompat$b(MediaBrowserServiceCompat mediaBrowserServiceCompat, byte b) {
        this(mediaBrowserServiceCompat);
    }
}
