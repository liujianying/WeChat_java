package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import com.tencent.mm.plugin.mmsight.segment.e.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements e {
    private long aBL;
    private boolean dRn = false;
    private int frameCount = 0;
    private a lkS;
    private String lkm;
    private long lkn;
    private byte[] lko = null;
    private int lkp;

    public final int t(String str, long j, long j2) {
        x.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s", new Object[]{str, Long.valueOf(j), Long.valueOf(j2)});
        this.lkm = str;
        this.aBL = j;
        this.lkn = j2;
        if (bi.oW(str)) {
            return -1;
        }
        long VG = bi.VG();
        int ffmpegOpenAndSeekFile = MP4MuxerJNI.ffmpegOpenAndSeekFile(str, ((double) j) * 1000.0d, ((double) j2) * 1000.0d);
        x.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", new Object[]{Long.valueOf(bi.bI(VG))});
        return ffmpegOpenAndSeekFile;
    }

    public final void F(Runnable runnable) {
        x.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
        this.dRn = true;
        this.frameCount = 0;
        while (this.dRn) {
            long VG = bi.VG();
            this.lko = MP4MuxerJNI.ffmpegGetNextVideoFrameData(this.lko);
            x.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", new Object[]{Long.valueOf(bi.bI(VG))});
            boolean ffmpegCheckIfReachEndTimestamp = MP4MuxerJNI.ffmpegCheckIfReachEndTimestamp();
            if (this.lko == null || ffmpegCheckIfReachEndTimestamp) {
                x.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", new Object[]{Boolean.valueOf(ffmpegCheckIfReachEndTimestamp)});
                this.dRn = false;
                runnable.run();
                return;
            }
            this.frameCount++;
            if ((this.lkp <= 1 || this.frameCount % this.lkp != 0) && this.lkS != null) {
                this.lkS.aB(this.lko);
            }
        }
    }

    public final void a(a aVar) {
        this.lkS = aVar;
    }

    public final Point beI() {
        return new Point(MP4MuxerJNI.ffmpegGetVideoWidth(), MP4MuxerJNI.ffmpegGetVideoHeight());
    }

    public final void stop() {
        x.i("MicroMsg.FFMpegTranscodeDecoder", "stop, start: %s", new Object[]{Boolean.valueOf(this.dRn)});
        this.dRn = false;
    }

    public final int beL() {
        return 2;
    }

    public final void sV(int i) {
        x.i("MicroMsg.FFMpegTranscodeDecoder", "setFrameDropInterval: %s", new Object[]{Integer.valueOf(i)});
        this.lkp = i;
    }
}
