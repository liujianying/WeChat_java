package com.tencent.mm.plugin.mmsight.segment;

import android.os.Process;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class h$a implements Runnable {
    int liI;
    volatile int liU;
    Object ljb;
    boolean lkx;
    final /* synthetic */ h llK;

    private h$a(h hVar) {
        this.llK = hVar;
        this.ljb = new Object();
    }

    /* synthetic */ h$a(h hVar, byte b) {
        this(hVar);
    }

    public final void run() {
        if (this.liI == -1) {
            this.liI = Process.myTid();
            Process.setThreadPriority(Process.myTid(), -2);
            x.i("MicroMsg.MediaCodecFFMpegTranscoder", "encodeTid: %s", new Object[]{Integer.valueOf(this.liI)});
        }
        this.liU = 0;
        synchronized (this.ljb) {
            long VG;
            while (!this.lkx) {
                VG = bi.VG();
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "try trigger encode");
                int triggerEncodeForSegment = MP4MuxerJNI.triggerEncodeForSegment(Math.max(0, this.liU), false);
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[]{Long.valueOf(bi.bI(VG)), Integer.valueOf(this.liU), Integer.valueOf(triggerEncodeForSegment), Long.valueOf(Thread.currentThread().getId())});
                if (triggerEncodeForSegment == this.liU) {
                    try {
                        Thread.sleep(20);
                    } catch (Exception e) {
                        x.e("MicroMsg.MediaCodecFFMpegTranscoder", "thread sleep error");
                    }
                }
                this.liU = triggerEncodeForSegment;
            }
            VG = bi.VG();
            this.liU = MP4MuxerJNI.triggerEncodeForSegment(this.liU, true);
            x.i("MicroMsg.MediaCodecFFMpegTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[]{Long.valueOf(bi.bI(VG)), Integer.valueOf(this.liU), Long.valueOf(Thread.currentThread().getId())});
        }
    }
}
