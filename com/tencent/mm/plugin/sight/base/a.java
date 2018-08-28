package com.tencent.mm.plugin.sight.base;

import com.tencent.mm.sdk.platformtools.bi;

public final class a {
    public int dQF = 0;
    public int height = 0;
    public int jdD = 0;
    public int ljG = 0;
    public int nbS = 0;
    public int videoBitrate = 0;
    public int width = 0;

    public final int bvB() {
        return bi.ge((long) this.jdD);
    }

    public final String toString() {
        return "[ videoDuration: " + this.jdD + " videoBitrate: " + this.videoBitrate + " width: " + this.width + " height: " + this.height + " frameRate: " + this.ljG + " audioChannel: " + this.nbS + " audioBitrate: " + this.dQF + "]";
    }
}
