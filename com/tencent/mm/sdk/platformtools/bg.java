package com.tencent.mm.sdk.platformtools;

import android.os.SystemClock;
import java.util.ArrayList;

public final class bg {
    private boolean gnY = false;
    private String mTag;
    private String sJj;
    ArrayList<Long> sJk;
    ArrayList<String> sJl;

    public bg(String str, String str2) {
        this.mTag = str;
        this.sJj = str2;
        if (!this.gnY) {
            if (this.sJk == null) {
                this.sJk = new ArrayList();
                this.sJl = new ArrayList();
            } else {
                this.sJk.clear();
                this.sJl.clear();
            }
            addSplit(null);
        }
    }

    public final void addSplit(String str) {
        if (!this.gnY) {
            this.sJk.add(Long.valueOf(SystemClock.elapsedRealtime()));
            this.sJl.add(str);
        }
    }

    public final void dumpToLog() {
        if (!this.gnY) {
            x.d(this.mTag, this.sJj + ": begin");
            long longValue = ((Long) this.sJk.get(0)).longValue();
            long j = longValue;
            for (int i = 1; i < this.sJk.size(); i++) {
                j = ((Long) this.sJk.get(i)).longValue();
                x.d(this.mTag, this.sJj + ":      " + (j - ((Long) this.sJk.get(i - 1)).longValue()) + " ms, " + ((String) this.sJl.get(i)));
            }
            x.d(this.mTag, this.sJj + ": end, " + (j - longValue) + " ms");
        }
    }
}
