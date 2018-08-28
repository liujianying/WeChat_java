package android.support.v4.media;

import android.app.Service;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.e.a;
import android.support.v4.media.session.MediaSessionCompat.Token;
import java.util.ArrayList;
import java.util.List;

public abstract class MediaBrowserServiceCompat extends Service {
    private final a<IBinder, b> rL = new a();
    private final f rM = new f(this, (byte) 0);
    Token rN;

    public abstract a bK();

    static /* synthetic */ void a(MediaBrowserServiceCompat mediaBrowserServiceCompat, String str, b bVar, Bundle bundle) {
        List list = (List) bVar.rY.get(str);
        List<Bundle> arrayList = list == null ? new ArrayList() : list;
        for (Bundle a : arrayList) {
            if (a.a(bundle, a)) {
                return;
            }
        }
        arrayList.add(bundle);
        bVar.rY.put(str, arrayList);
        1 1 = new 1(mediaBrowserServiceCompat, str, bVar, str, bundle);
        if (bundle != null) {
            1.rJ = 1;
        }
        if (!1.isDone()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + bVar.rU + " id=" + str);
        }
    }
}
