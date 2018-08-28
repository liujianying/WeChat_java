package com.tencent.mm.plugin.freewifi;

import com.tencent.mm.plugin.freewifi.g.b;
import com.tencent.mm.plugin.freewifi.model.j;

public final class i {
    private b jhO;

    /* synthetic */ i(byte b) {
        this();
    }

    private i() {
        this.jhO = j.aOL();
    }

    public final synchronized long oX(String str) {
        long j = 0;
        synchronized (this) {
            if (!m.isEmpty(str)) {
                try {
                    String Ce = this.jhO.Ce(str);
                    if (!m.isEmpty(Ce)) {
                        j = Long.valueOf(Ce).longValue();
                    }
                } catch (Exception e) {
                }
            }
        }
        return j;
    }

    public final synchronized int getInt(String str, int i) {
        if (!m.isEmpty(str)) {
            try {
                String Ce = this.jhO.Ce(str);
                if (!m.isEmpty(Ce)) {
                    i = Integer.valueOf(Ce).intValue();
                }
            } catch (Exception e) {
            }
        }
        return i;
    }

    public final synchronized void C(String str, long j) {
        this.jhO.cR(str, String.valueOf(j));
    }

    public final synchronized void bo(String str, int i) {
        this.jhO.cR(str, String.valueOf(i));
    }
}
