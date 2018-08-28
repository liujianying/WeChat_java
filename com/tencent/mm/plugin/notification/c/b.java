package com.tencent.mm.plugin.notification.c;

import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class b {
    int currentIndex;
    public ArrayList<Long> lHE;

    public b() {
        this.currentIndex = 0;
        this.lHE = new ArrayList();
        this.currentIndex = 0;
    }

    public final void ej(long j) {
        x.d("MicroMsg.FailMsglist", "addMsgId:%d, currentIndex:%d, size:%d", Long.valueOf(j), Integer.valueOf(this.currentIndex), Integer.valueOf(this.lHE.size()));
        this.lHE.add(Long.valueOf(j));
    }

    public final long bks() {
        long j = -1;
        if (this.lHE.size() > 0 && this.currentIndex < this.lHE.size()) {
            j = ((Long) this.lHE.get(this.currentIndex)).longValue();
        }
        x.d("MicroMsg.FailMsglist", "getNextSendMsgId:%d, currentIndex:%d, msgIdList.size:%d", Long.valueOf(j), Integer.valueOf(this.currentIndex), Integer.valueOf(this.lHE.size()));
        this.currentIndex++;
        return j;
    }

    public final boolean ek(long j) {
        return this.lHE.contains(Long.valueOf(j));
    }

    public final void clear() {
        this.lHE.clear();
        this.currentIndex = 0;
    }

    public final long get(int i) {
        return ((Long) this.lHE.get(i)).longValue();
    }

    public final void remove(long j) {
        this.lHE.remove(Long.valueOf(j));
    }
}
