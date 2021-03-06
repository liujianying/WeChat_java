package android.support.v4.media;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.media.MediaBrowserServiceCompat.c;
import android.support.v4.os.ResultReceiver;
import android.support.v4.os.ResultReceiver.b;

class MediaBrowserServiceCompat$2 extends c<MediaItem> {
    final /* synthetic */ MediaBrowserServiceCompat rR;
    final /* synthetic */ ResultReceiver rS;

    MediaBrowserServiceCompat$2(MediaBrowserServiceCompat mediaBrowserServiceCompat, Object obj, ResultReceiver resultReceiver) {
        this.rR = mediaBrowserServiceCompat;
        this.rS = resultReceiver;
        super(obj);
    }

    final /* synthetic */ void Z(int i) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("media_item", null);
        ResultReceiver resultReceiver = this.rS;
        if (resultReceiver.sW) {
            if (resultReceiver.mHandler != null) {
                resultReceiver.mHandler.post(new b(resultReceiver, 0, bundle));
            } else {
                resultReceiver.onReceiveResult(0, bundle);
            }
        } else if (resultReceiver.sX != null) {
            try {
                resultReceiver.sX.send(0, bundle);
            } catch (RemoteException e) {
            }
        }
    }
}
