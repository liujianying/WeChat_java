package com.tencent.mm.plugin.downloader;

import com.tencent.mm.bt.h;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.a.c;
import com.tencent.mm.plugin.downloader.c.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class a implements com.tencent.mm.kernel.api.bucket.a, d, c {
    private b iaZ;

    public final void onDataBaseOpened(h hVar, h hVar2) {
        this.iaZ = new b(hVar);
    }

    public final void onDataBaseClosed(h hVar, h hVar2) {
    }

    public final b FX() {
        g.Ek();
        g.Eg().Ds();
        return this.iaZ;
    }

    public final HashMap<Integer, h.d> collectDatabaseFactory() {
        x.d("MicroMsg.FileDownloaderService", "collectDatabaseFactory");
        HashMap<Integer, h.d> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("FILEDOWNLOAD_TABLE".hashCode()), new 1(this));
        return hashMap;
    }
}
