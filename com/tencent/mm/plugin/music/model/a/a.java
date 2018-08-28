package com.tencent.mm.plugin.music.model.a;

import android.database.Cursor;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.music.cache.b;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class a implements b {
    static /* synthetic */ void bii() {
        x.i("MicroMsg.PieceCacheCleanController", "scanMusicFile");
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mm.plugin.music.model.f.a bid = h.bid();
        String format = String.format("SELECT * from %s WHERE updateTime < ? AND musicType <> ? limit 10", new Object[]{"Music"});
        long currentTimeMillis2 = System.currentTimeMillis() - 604800000;
        List<com.tencent.mm.an.a> arrayList = new ArrayList();
        Cursor rawQuery = bid.diF.rawQuery(format, new String[]{String.valueOf(currentTimeMillis2), "6"});
        while (rawQuery.moveToNext()) {
            com.tencent.mm.an.a aVar = new com.tencent.mm.an.a();
            aVar.d(rawQuery);
            arrayList.add(aVar);
        }
        rawQuery.close();
        for (com.tencent.mm.an.a aVar2 : arrayList) {
            String g = com.tencent.mm.plugin.music.d.a.g(aVar2, true);
            String g2 = com.tencent.mm.plugin.music.d.a.g(aVar2, false);
            String h = com.tencent.mm.plugin.music.d.a.h(aVar2, false);
            String h2 = com.tencent.mm.plugin.music.d.a.h(aVar2, true);
            FileOp.deleteFile(g);
            FileOp.deleteFile(g2);
            FileOp.deleteFile(h);
            FileOp.deleteFile(h2);
            com.tencent.mm.plugin.music.model.f.a bid2 = h.bid();
            g2 = aVar2.field_musicId;
            bid2.lzX.remove(g2);
            bid2.lzY.remove(g2);
            bid2 = h.bid();
            g2 = aVar2.field_musicId;
            int delete = bid2.diF.delete("Music", "musicId=?", new String[]{g2});
            x.i("MicroMsg.PieceCacheCleanController", "delete music %d %s", new Object[]{Integer.valueOf(delete), aVar2.field_musicId});
        }
        x.i("MicroMsg.PieceCacheCleanController", "scanMusic UseTime=%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        ArrayList arrayList2 = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(285);
        iDKey.SetKey(254);
        iDKey.SetValue((long) ((int) r0));
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(285);
        iDKey2.SetKey(255);
        iDKey2.SetValue(1);
        arrayList2.add(iDKey);
        arrayList2.add(iDKey2);
        com.tencent.mm.plugin.report.service.h.mEJ.b(arrayList2, false);
    }

    public final void bhJ() {
        long longValue = ((Long) g.Ei().DT().get(com.tencent.mm.storage.aa.a.sWp, Long.valueOf(0))).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longValue < gio.longValue()) {
            x.e("MicroMsg.PieceCacheCleanController", "don't scanMusic because the time is in one day");
            return;
        }
        g.Ei().DT().a(com.tencent.mm.storage.aa.a.sWp, Long.valueOf(currentTimeMillis));
        e.b(new 1(this), "ScanMusicThread", 1);
    }
}
