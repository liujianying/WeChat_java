package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    private String bIQ;
    private String bLe;
    private int jkE;

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
    }

    public final synchronized boolean j(int i, String str, String str2) {
        boolean z = true;
        synchronized (this) {
            boolean z2;
            x.i("MicroMsg.FreeWifi.Protocol31Locker", "threeOneStartUpType=%d, apKey=%s, ticket=%s", new Object[]{Integer.valueOf(i), str, str2});
            if (i == 1 || i == 2 || i == 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (m.isEmpty(str) || m.isEmpty(str2)) {
                    z = false;
                } else if (str.equals(this.bIQ) && str2.equals(this.bLe) && this.jkE != i) {
                    z = false;
                } else {
                    this.jkE = i;
                    this.bIQ = str;
                    this.bLe = str2;
                }
            }
        }
        return z;
    }
}
