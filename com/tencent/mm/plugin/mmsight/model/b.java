package com.tencent.mm.plugin.mmsight.model;

import com.tencent.mm.sdk.platformtools.bi;

public final class b {
    long etW = 0;
    long lfj = bi.VG();
    long lfk = bi.VG();
    private String tag = "default";
    long value = 0;

    public b(String str) {
        this.tag = str;
    }

    public final void ec(long j) {
        if (this.etW == 0) {
            this.lfj = bi.VG();
        }
        this.value += j;
        this.etW++;
        this.lfk = bi.VG();
    }

    public final String getValue() {
        String str = "";
        if (this.etW == 0) {
            return "";
        }
        double d = ((double) (this.lfk - this.lfj)) / 1000.0d;
        if (d == 0.0d) {
            d = 1.0d;
        }
        return String.format("CounterUtil %s tag %s count %s passed %.3f perValue %.3f/count counttime %.3f/s valuetime %.3f/s st:%s ed:%s diff%s", new Object[]{str, this.tag, Long.valueOf(this.etW), Double.valueOf(d), Double.valueOf((((double) this.value) * 1.0d) / ((double) this.etW)), Double.valueOf((((double) this.etW) * 1.0d) / d), Double.valueOf((1.0d * ((double) this.value)) / d), Long.valueOf(this.lfj), Long.valueOf(this.lfk), Long.valueOf(this.lfk - this.lfj)});
    }

    public final String bdJ() {
        if (this.etW == 0) {
            return "";
        }
        double d = ((double) (this.lfk - this.lfj)) / 1000.0d;
        if (d == 0.0d) {
            d = 1.0d;
        }
        return ((1.0d * ((double) this.etW)) / d);
    }

    public final void reset() {
        this.value = 0;
        this.etW = 0;
    }
}
