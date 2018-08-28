package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Point;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    private long aBL;
    private boolean dRn = false;
    private int frameCount = 0;
    a lkl;
    private String lkm;
    private long lkn;
    private byte[] lko = null;
    private int lkp = 0;
    double lkq;
    private int videoFps;

    public final int c(String str, long j, long j2, int i) {
        x.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s, videoFps: %s", new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)});
        this.lkm = str;
        this.aBL = j;
        this.lkn = j2;
        this.videoFps = i;
        this.lkq = 1000.0d / ((double) i);
        if (bi.oW(str)) {
            return -1;
        }
        long VG = bi.VG();
        int ffmpegOpenAndSeekFile = MP4MuxerJNI.ffmpegOpenAndSeekFile(str, ((double) j) * 1000.0d, ((double) j2) * 1000.0d);
        x.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", new Object[]{Long.valueOf(bi.bI(VG))});
        return ffmpegOpenAndSeekFile;
    }

    public final void beH() {
        x.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
        this.dRn = true;
        this.frameCount = 0;
        while (this.dRn) {
            long VG = bi.VG();
            this.lko = MP4MuxerJNI.ffmpegGetNextVideoFrameData(this.lko);
            x.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", new Object[]{Long.valueOf(bi.bI(VG))});
            boolean ffmpegCheckIfReachEndTimestamp = MP4MuxerJNI.ffmpegCheckIfReachEndTimestamp();
            this.frameCount++;
            if (this.lkp <= 1 || this.frameCount % this.lkp != 0) {
                if (this.lkl != null) {
                    a aVar = this.lkl;
                    byte[] bArr = this.lko;
                    boolean z = this.lko == null || ffmpegCheckIfReachEndTimestamp;
                    aVar.a(bArr, z, (long) ((((double) this.frameCount) * this.lkq) * 1000.0d));
                }
                if (this.lko == null || ffmpegCheckIfReachEndTimestamp) {
                    x.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", new Object[]{Boolean.valueOf(ffmpegCheckIfReachEndTimestamp)});
                    x.i("MicroMsg.FFMpegTranscodeDecoder", "decode finish, frame count: %s", new Object[]{Integer.valueOf(this.frameCount)});
                    this.dRn = false;
                    return;
                }
            }
        }
    }

    public static Point beI() {
        return new Point(MP4MuxerJNI.ffmpegGetVideoWidth(), MP4MuxerJNI.ffmpegGetVideoHeight());
    }
}
