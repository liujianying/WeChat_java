package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.plugin.backup.e.h.a;
import com.tencent.mm.plugin.backup.h.af;
import com.tencent.mm.plugin.backup.h.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;

public final class k extends b {
    private af gYw = new af();
    private ag gYx = new ag();
    private a gYy;

    public k(String str, HashMap<Long, a> hashMap, a aVar) {
        this.gYy = aVar;
        this.gYw.hbD = str;
        x.i("MicroMsg.BackupSvrIdScene", "init sessionName:%s", new Object[]{str});
        this.gYw.hda = new LinkedList();
        this.gYw.hdb = new LinkedList();
        this.gYw.hdc = new LinkedList();
        for (Long l : hashMap.keySet()) {
            a aVar2 = (a) hashMap.get(l);
            this.gYw.hda.add(Long.valueOf(aVar2.gVV));
            this.gYw.hdb.add(aVar2.gVW);
            this.gYw.hdc.add(aVar2.bKg);
        }
    }

    public final int getType() {
        return 13;
    }

    public final com.tencent.mm.bk.a asj() {
        return this.gYx;
    }

    public final com.tencent.mm.bk.a ask() {
        return this.gYw;
    }

    public final void mI(int i) {
        x.i("MicroMsg.BackupSvrIdScene", "onSceneEnd");
        g(0, 0, "success");
        this.gYy.A(this.gYx.hda);
    }
}
