package com.tencent.mm.plugin.appbrand.performance;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.RandomAccessFile;

public final class c {
    private final int gpG;
    private volatile RandomAccessFile gpH;
    private volatile RandomAccessFile gpI;
    private long gpJ;
    private long gpK;
    private long gpL;

    public c(int i) {
        this.gpG = i;
    }

    public final double ami() {
        double d = 0.0d;
        try {
            if (this.gpI == null) {
                this.gpI = new RandomAccessFile("/proc/" + this.gpG + "/stat", "r");
            }
            this.gpI.seek(0);
            String readLine = this.gpI.readLine();
            if (bi.oW(readLine)) {
                return 0.0d;
            }
            String[] split = readLine.split(" ");
            if (split.length < 17) {
                return 0.0d;
            }
            long j;
            long parseLong;
            if (this.gpH == null) {
                this.gpH = new RandomAccessFile("/proc/stat", "r");
            }
            this.gpH.seek(0);
            readLine = this.gpH.readLine();
            if (bi.oW(readLine)) {
                j = 0;
            } else {
                String[] split2 = readLine.split(" ");
                if (split2.length < 9) {
                    j = 0;
                } else {
                    parseLong = Long.parseLong(split2[2]);
                    long parseLong2 = Long.parseLong(split2[3]);
                    long parseLong3 = Long.parseLong(split2[4]);
                    long parseLong4 = Long.parseLong(split2[5]);
                    long parseLong5 = Long.parseLong(split2[6]);
                    long parseLong6 = Long.parseLong(split2[7]);
                    j = Long.parseLong(split2[9]) + ((((((parseLong + parseLong2) + parseLong3) + parseLong4) + parseLong5) + parseLong6) + Long.parseLong(split2[8]));
                }
            }
            parseLong = Long.parseLong(split[13]);
            long parseLong7 = Long.parseLong(split[14]);
            if (this.gpJ != 0) {
                double d2 = ((double) ((parseLong7 - this.gpL) * 100)) / ((double) (j - this.gpJ));
                d = Math.max(0.0d, d2) + Math.max(0.0d, ((double) ((parseLong - this.gpK) * 100)) / ((double) (j - this.gpJ)));
            }
            this.gpJ = j;
            this.gpK = parseLong;
            this.gpL = parseLong7;
            return d;
        } catch (Exception e) {
            x.e(" MicroMsg.CpuSampler", "read pid stat file error: " + e);
            return 0.0d;
        }
    }
}
