package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.backup.h.i;
import com.tencent.mm.plugin.backup.h.j;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class h extends b {
    private i gYi = new i();
    public j gYj = new j();

    public h(LinkedList<String> linkedList, long j, long j2) {
        x.i("MicroMsg.BackupRequestSessionScene", "init sessionName[%d], startTime[%d], endTime[%d]", new Object[]{Integer.valueOf(linkedList.size()), Long.valueOf(j), Long.valueOf(j2)});
        this.gYi.hbH = linkedList;
        this.gYi.hbI = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            it.next();
            this.gYi.hbI.add(Long.valueOf(j));
            this.gYi.hbI.add(Long.valueOf(j2));
        }
    }

    public final int getType() {
        return 11;
    }

    public final a asj() {
        return this.gYj;
    }

    public final a ask() {
        return this.gYi;
    }

    public final void mI(int i) {
        if (this.gYj.hbH == null || this.gYj.hbI == null || this.gYj.hbH.isEmpty() || this.gYj.hbH.size() * 2 != this.gYj.hbI.size()) {
            if (!(this.gYj.hbH == null || this.gYj.hbI == null)) {
                x.e("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName and TimeInterval size error. sessionName size[%d], timeInterval size[%d]", new Object[]{Integer.valueOf(this.gYj.hbH.size()), Integer.valueOf(this.gYj.hbI.size())});
            }
            g(4, -1, "BackupRequestSession failed");
            return;
        }
        x.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd sessionName size[%d], name:%s", new Object[]{Integer.valueOf(this.gYj.hbH.size()), this.gYj.hbH.toString()});
        x.i("MicroMsg.BackupRequestSessionScene", "onSceneEnd requestsession resp, TimeInterval:%s", new Object[]{this.gYj.hbI.toString()});
        g(0, 0, "BackupRequestSession success");
    }
}
