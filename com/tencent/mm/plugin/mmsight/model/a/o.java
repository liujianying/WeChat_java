package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

@TargetApi(18)
@Deprecated
public final class o implements e {
    boolean bTv;
    private MediaMuxer ljr;
    private int ljs;
    private int ljt;
    long lju;

    public final boolean bev() {
        return false;
    }

    public final synchronized void c(MediaFormat mediaFormat) {
        try {
            if (this.ljr != null && this.ljs == -1) {
                this.ljs = this.ljr.addTrack(mediaFormat);
                x.i("MicroMsg.MMSightSystemMediaMuxer", "addX264Track, x264TrackIndex: %s", new Object[]{Integer.valueOf(this.ljs)});
                if (!(this.bTv || this.ljs == -1 || this.ljt == -1)) {
                    x.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
                    this.ljr.start();
                    this.bTv = true;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightSystemMediaMuxer", "addX264Track error: %s", new Object[]{e.getMessage()});
        }
        return;
    }

    public final synchronized void d(MediaFormat mediaFormat) {
        try {
            if (this.ljr != null && this.ljt == -1) {
                this.ljt = this.ljr.addTrack(mediaFormat);
                x.i("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack, aacTrackIndex: %s", new Object[]{Integer.valueOf(this.ljt)});
                if (!(this.bTv || this.ljt == -1 || this.ljs == -1)) {
                    x.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
                    this.ljr.start();
                    this.bTv = true;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack error: %s", new Object[]{e.getMessage()});
        }
        return;
    }

    public final synchronized void f(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        try {
            if (!(this.ljr == null || this.ljt == -1 || !this.bTv || byteBuffer == null || bufferInfo == null)) {
                long j = bufferInfo.presentationTimeUs;
                bufferInfo.presentationTimeUs = (System.nanoTime() - this.lju) / 1000;
                long VG = bi.VG();
                this.ljr.writeSampleData(this.ljt, byteBuffer, bufferInfo);
                x.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", new Object[]{Integer.valueOf(bufferInfo.size), Long.valueOf(bi.bI(VG)), Long.valueOf(j), Long.valueOf(bufferInfo.presentationTimeUs)});
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData error: %s", new Object[]{e.getMessage()});
        }
        return;
    }

    public final synchronized void g(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        int i = 1;
        synchronized (this) {
            try {
                if (!(this.ljr == null || this.ljs == -1 || !this.bTv)) {
                    int i2 = byteBuffer != null ? 1 : 0;
                    if (bufferInfo == null) {
                        i = 0;
                    }
                    if ((i & i2) != 0) {
                        long j = bufferInfo.presentationTimeUs;
                        bufferInfo.presentationTimeUs = (System.nanoTime() - this.lju) / 1000;
                        bufferInfo.flags = 1;
                        long VG = bi.VG();
                        this.ljr.writeSampleData(this.ljs, byteBuffer, bufferInfo);
                        x.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", new Object[]{Integer.valueOf(bufferInfo.size), Long.valueOf(bi.bI(VG)), Long.valueOf(j), Long.valueOf(bufferInfo.presentationTimeUs)});
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.MMSightSystemMediaMuxer", "writeX264SampleData error: %s", new Object[]{e.getMessage()});
            }
        }
        return;
    }
}
