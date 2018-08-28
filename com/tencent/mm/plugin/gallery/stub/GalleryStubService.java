package com.tencent.mm.plugin.gallery.stub;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mm.plugin.gallery.stub.a.a;
import com.tencent.mm.sdk.platformtools.x;

public class GalleryStubService extends Service {
    private a jBv = new 1(this);

    public IBinder onBind(Intent intent) {
        x.d("MicroMsg.GalleryStubService", "on bind, intent[%s]", new Object[]{intent});
        return this.jBv;
    }
}
