package com.tencent.mm.graphics.c;

import com.tencent.mm.graphics.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static final int dju = 1;
    private static final /* synthetic */ int[] djv = new int[]{dju};

    public static class a {
        public int Zk;
        public String bXS;
        public int djw;
        public int djx;
        public int djy;
        public int djz;
        public int fileSize;
        public int height;
        public String imagePath;
        public int orientation;
        public int width;
    }

    public static void a(long j, a aVar) {
        if (aVar != null) {
            x.i("MicroMsg.ImageReporter", "alvinluo reportImageDecodeInfo sessionId: %d, from: %s, imageType: %d, w: %d, h: %d, fileSize: %d, orientation: %d, decodeResult: %d, decodeTime: %d, fullSampleSzie: %d, onlyDecodeTime: %d", new Object[]{Long.valueOf(j), aVar.bXS, Integer.valueOf(aVar.djw), Integer.valueOf(aVar.width), Integer.valueOf(aVar.height), Integer.valueOf(aVar.fileSize), Integer.valueOf(aVar.orientation), Integer.valueOf(aVar.djx), Integer.valueOf(aVar.djy), Integer.valueOf(aVar.Zk), Integer.valueOf(aVar.djz)});
            h.mEJ.h(15467, new Object[]{Long.valueOf(j), aVar.bXS, Integer.valueOf(aVar.djw), Integer.valueOf(aVar.width), Integer.valueOf(aVar.height), Integer.valueOf(aVar.fileSize), Integer.valueOf(aVar.orientation), Integer.valueOf(aVar.djx), Integer.valueOf(aVar.djy), Integer.valueOf(aVar.Zk), Integer.valueOf(aVar.djz)});
        }
    }

    public static void a(b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        if (bVar != null) {
            x.i("MicroMsg.ImageReporter", "alvinluo reportPerformance sessionId: %d, fps.maxFps: %f, fps.minFps: %f, fps.averageFps: %f, memory.memoryUsedWhenInit: %f, memory.currentMaxUsedMemory: %f, memory.currentMinUsedMemory: %f, memory.averUsed: %f, memory.currentVarianceSum: %f", new Object[]{Long.valueOf(currentTimeMillis), Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(bVar.djc), Double.valueOf(bVar.djd), Double.valueOf(bVar.dje), Double.valueOf(bVar.djg), Double.valueOf(bVar.djf)});
            h.mEJ.h(15471, new Object[]{Long.valueOf(currentTimeMillis), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf((int) bVar.djc), Integer.valueOf((int) bVar.djd), Integer.valueOf((int) bVar.djg), Integer.valueOf((int) bVar.djf), Integer.valueOf(1)});
        }
    }
}
