package com.tencent.mm.plugin.clean.c.a;

import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public final class b implements c {
    public HashMap<Long, ag> hRt;
    private HashSet<Long> hRu;

    public b() {
        this((byte) 0);
    }

    private b(byte b) {
        this.hRu = new HashSet(5);
        this.hRt = new HashMap(5);
        for (int i = 0; i <= 5; i++) {
            e.d(new 1(this), "ThreadController_handler", 1).start();
        }
    }

    public final synchronized boolean b(a aVar) {
        boolean z;
        aVar.hRs = this;
        x.d("MicroMsg.ThreadController", "running threads %s", new Object[]{this.hRu.toString()});
        for (Entry entry : this.hRt.entrySet()) {
            if (!this.hRu.contains(entry.getKey())) {
                ((ag) entry.getValue()).post(aVar);
                this.hRu.add(entry.getKey());
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    private synchronized void e(Long l) {
        if (this.hRu.remove(l)) {
            x.d("MicroMsg.ThreadController", "thread is idle, id=%d", new Object[]{l});
        }
    }

    public final void f(Long l) {
        e(l);
    }
}
