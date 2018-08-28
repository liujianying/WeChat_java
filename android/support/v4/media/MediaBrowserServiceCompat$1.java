package android.support.v4.media;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserServiceCompat.b;
import java.util.List;

class MediaBrowserServiceCompat$1 extends MediaBrowserServiceCompat$c<List<MediaBrowserCompat$MediaItem>> {
    final /* synthetic */ b rO;
    final /* synthetic */ String rP;
    final /* synthetic */ Bundle rQ;
    final /* synthetic */ MediaBrowserServiceCompat rR;

    MediaBrowserServiceCompat$1(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object obj, b bVar, String str, Bundle bundle) {
        this.rR = mediaBrowserServiceCompat;
        this.rO = bVar;
        this.rP = str;
        this.rQ = bundle;
        super(obj);
    }

    final /* synthetic */ void Z(int i) {
        List list = null;
        if (MediaBrowserServiceCompat.b(this.rR).get(this.rO.rW.asBinder()) == this.rO) {
            List list2;
            if ((i & 1) != 0) {
                Bundle bundle = this.rQ;
                int i2 = bundle.getInt("android.media.browse.extra.PAGE", -1);
                int i3 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                if (!(i2 == -1 && i3 == -1)) {
                    int i4 = i3 * (i2 - 1);
                    int i5 = i4 + i3;
                    if (i2 <= 0 || i3 <= 0 || i4 >= list.size()) {
                        list2 = list;
                        this.rO.rW.a(this.rP, list2, this.rQ);
                    }
                    if (i5 > list.size()) {
                        i5 = list.size();
                    }
                    list2 = list.subList(i4, i5);
                    this.rO.rW.a(this.rP, list2, this.rQ);
                }
            }
            list2 = list;
            try {
                this.rO.rW.a(this.rP, list2, this.rQ);
            } catch (RemoteException e) {
                new StringBuilder("Calling onLoadChildren() failed for id=").append(this.rP).append(" package=").append(this.rO.rU);
            }
        }
    }
}
