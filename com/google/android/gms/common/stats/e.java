package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.e.j;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public final class e {
    private final long aQc;
    private final int aQd;
    private final j<String, Long> aQe;

    public e() {
        this.aQc = 60000;
        this.aQd = 10;
        this.aQe = new j(10);
    }

    public e(long j) {
        this.aQc = j;
        this.aQd = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        this.aQe = new j();
    }

    public final Long bk(String str) {
        Long l;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.aQc;
        synchronized (this) {
            while (true) {
                long j2 = j;
                if (this.aQe.size() >= this.aQd) {
                    for (int size = this.aQe.size() - 1; size >= 0; size--) {
                        if (elapsedRealtime - ((Long) this.aQe.valueAt(size)).longValue() > j2) {
                            this.aQe.removeAt(size);
                        }
                    }
                    j = j2 / 2;
                    new StringBuilder("The max capacity ").append(this.aQd).append(" is not enough. Current durationThreshold is: ").append(j);
                } else {
                    l = (Long) this.aQe.put(str, Long.valueOf(elapsedRealtime));
                }
            }
        }
        return l;
    }

    public final boolean bl(String str) {
        boolean z;
        synchronized (this) {
            z = this.aQe.remove(str) != null;
        }
        return z;
    }
}
