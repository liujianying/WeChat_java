package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public final class g {
    private Set<String> kQj = new HashSet();
    private Object lock = new Object();

    public final boolean Gb(String str) {
        boolean z = false;
        synchronized (this.lock) {
            if (this.kQj.contains(str)) {
                x.i("MicroMsg.LuckyMoneyMsg", "has contains msg, %s", new Object[]{str});
            } else {
                z = this.kQj.add(str);
            }
        }
        return z;
    }

    public final void Gc(String str) {
        synchronized (this.lock) {
            this.kQj.remove(str);
        }
    }
}
