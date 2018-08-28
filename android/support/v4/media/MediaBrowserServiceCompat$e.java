package android.support.v4.media;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.media.MediaBrowserCompat.MediaItem;
import android.support.v4.media.MediaBrowserServiceCompat.d;
import android.support.v4.media.session.MediaSessionCompat.Token;
import java.util.ArrayList;
import java.util.List;

class MediaBrowserServiceCompat$e implements d {
    final /* synthetic */ MediaBrowserServiceCompat rR;
    final Messenger sd;

    MediaBrowserServiceCompat$e(MediaBrowserServiceCompat mediaBrowserServiceCompat, Messenger messenger) {
        this.rR = mediaBrowserServiceCompat;
        this.sd = messenger;
    }

    public final IBinder asBinder() {
        return this.sd.getBinder();
    }

    public final void a(String str, Token token, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("extra_service_version", 1);
        Bundle bundle2 = new Bundle();
        bundle2.putString("data_media_item_id", str);
        bundle2.putParcelable("data_media_session_token", token);
        bundle2.putBundle("data_root_hints", bundle);
        a(1, bundle2);
    }

    public final void bL() {
        a(2, null);
    }

    public final void a(String str, List<MediaItem> list, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("data_media_item_id", str);
        bundle2.putBundle("data_options", bundle);
        if (list != null) {
            bundle2.putParcelableArrayList("data_media_item_list", list instanceof ArrayList ? (ArrayList) list : new ArrayList(list));
        }
        a(3, bundle2);
    }

    private void a(int i, Bundle bundle) {
        Message obtain = Message.obtain();
        obtain.what = i;
        obtain.arg1 = 1;
        obtain.setData(bundle);
        this.sd.send(obtain);
    }
}
