package com.tencent.mm.plugin.u;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.view.Surface;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

public final class k extends h {
    public Surface aeJ;
    boolean ldO = false;
    private boolean ldP = false;
    boolean ldQ = false;
    private long ldR = 0;
    long ldS = -1;
    private int videoHeight;
    private int videoWidth;

    public k(g gVar, ag agVar) {
        super(gVar, agVar);
    }

    final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, BufferInfo bufferInfo) {
        x.d("MicroMsg.VideoTrackDataSource", "%s start to process output buffer state %d time[%d, %d] index %d", new Object[]{avA(), Integer.valueOf(this.state), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i)});
        if (d.sD(this.state)) {
            x.i("MicroMsg.VideoTrackDataSource", "%s video track flush surface", new Object[]{avA()});
            mediaCodec.releaseOutputBuffer(i, true);
            setState(4);
            return true;
        } else if (d.sC(this.state)) {
            x.d("MicroMsg.VideoTrackDataSource", "%s start to handle precision seek[%d, %d] diff[%d]", new Object[]{avA(), Long.valueOf(bufferInfo.presentationTimeUs / 1000), Long.valueOf(j), Long.valueOf(j - (bufferInfo.presentationTimeUs / 1000))});
            if ((j - (bufferInfo.presentationTimeUs / 1000) <= 30 ? 1 : null) != null) {
                x.i("MicroMsg.VideoTrackDataSource", "%s precision seek done to surface", new Object[]{avA()});
                mediaCodec.releaseOutputBuffer(i, true);
                if (this.ldP) {
                    setState(7);
                    this.ldP = false;
                }
                this.ldP = true;
            } else {
                mediaCodec.releaseOutputBuffer(i, false);
            }
            return true;
        } else if (d.sE(this.state)) {
            long j3 = bufferInfo.presentationTimeUs / 1000;
            long elapsedRealtime = (j3 - j) - (SystemClock.elapsedRealtime() - j2);
            x.d("MicroMsg.VideoTrackDataSource", "%s earlyMs[%d] time[%d, %d, %d] sample[%d %d]", new Object[]{avA(), Long.valueOf(elapsedRealtime), Long.valueOf(SystemClock.elapsedRealtime() - j2), Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(j2), Long.valueOf(j), Long.valueOf(j3)});
            if (elapsedRealtime < -30) {
                x.d("MicroMsg.VideoTrackDataSource", "%s finish to process but it too late to show video frame. throw now", new Object[]{avA()});
                mediaCodec.releaseOutputBuffer(i, false);
                this.ldg.lcZ = 0;
                return true;
            } else if (elapsedRealtime < 30) {
                this.ldg.lcW = bufferInfo.presentationTimeUs;
                if (elapsedRealtime > 11) {
                    try {
                        Thread.sleep(elapsedRealtime - 10);
                    } catch (Exception e) {
                    }
                }
                if (d.sE(this.state)) {
                    if (Math.abs(j3 - this.ldR) > 1000) {
                        x.i("MicroMsg.VideoTrackDataSource", "%s finish to process index[%d] time[%d] to surface", new Object[]{avA(), Integer.valueOf(i), Long.valueOf(j3)});
                        this.ldR = j3;
                    }
                    mediaCodec.releaseOutputBuffer(i, true);
                    return true;
                }
                x.i("MicroMsg.VideoTrackDataSource", "%s it no need process buffer now state %d", new Object[]{avA(), Integer.valueOf(this.state)});
                return false;
            } else {
                x.d("MicroMsg.VideoTrackDataSource", "%s finish to process but it too early now do nothing.", new Object[]{avA()});
                return false;
            }
        } else {
            x.i("MicroMsg.VideoTrackDataSource", "%s it no need process buffer now state %d", new Object[]{avA(), Integer.valueOf(this.state)});
            return false;
        }
    }

    final String type() {
        return "video";
    }

    final boolean a(MediaCodec mediaCodec) {
        if (mediaCodec != null) {
            MediaFormat mediaFormat;
            if (this.aeJ == null) {
                x.w("MicroMsg.VideoTrackDataSource", "%s decoder configure surface but surface is null.", new Object[]{avA()});
                this.ldO = false;
            } else {
                this.ldO = true;
            }
            x.i("MicroMsg.VideoTrackDataSource", "%s handleDecoderBeforeStart", new Object[]{avA()});
            if (this.ldo == null) {
                mediaFormat = this.ldl;
            } else {
                mediaFormat = this.ldo.getTrackFormat(this.ldn);
            }
            mediaCodec.configure(mediaFormat, this.aeJ, null, 0);
        }
        return false;
    }

    protected final void b(MediaCodec mediaCodec) {
        x.i("MicroMsg.VideoTrackDataSource", "%s output format changed", new Object[]{avA()});
        mediaCodec.setVideoScalingMode(1);
    }

    @TargetApi(23)
    public final void bdD() {
        try {
            if (this.ldq != null) {
                this.ldq.setOutputSurface(this.aeJ);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoTrackDataSource", e, "%s change surface23 error [%s]", new Object[]{avA(), e.toString()});
            bdE();
        }
    }

    public final void bdE() {
        x.i("MicroMsg.VideoTrackDataSource", "%s change surface below 23", new Object[]{avA()});
        if (this.ldq != null) {
            ll();
            w(this.ldg.lcW, -1);
            bdy();
        }
    }

    protected final void b(MediaFormat mediaFormat, String str, int i) {
        int integer;
        int i2;
        super.b(mediaFormat, str, i);
        this.videoHeight = mediaFormat.getInteger("height");
        this.videoWidth = mediaFormat.getInteger("width");
        if (mediaFormat.containsKey("rotation-degrees")) {
            integer = mediaFormat.getInteger("rotation-degrees");
            i2 = 1;
        } else {
            integer = SightVideoJNI.getMp4Rotate(this.path);
            x.w("MicroMsg.VideoTrackDataSource", "%s it don't contains rotation key. degrees [%d]", new Object[]{avA(), Integer.valueOf(integer)});
            i2 = 0;
        }
        if (Math.abs(integer) == 90 || Math.abs(integer) == 270) {
            int i3 = this.videoWidth;
            this.videoWidth = this.videoHeight;
            this.videoHeight = i3;
        }
        if (i2 != 0) {
            integer = 0;
        }
        this.ldh.obtainMessage(4, this.videoWidth, this.videoHeight, Integer.valueOf(integer)).sendToTarget();
        x.i("MicroMsg.VideoTrackDataSource", "%s video size[%d, %d] degrees[%d]", new Object[]{avA(), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(integer)});
    }

    protected final boolean B(int i, long j) {
        x.d("MicroMsg.VideoTrackDataSource", "%s reset extractor flag[%d] needReset[%b]", new Object[]{avA(), Integer.valueOf(i), Boolean.valueOf(this.ldg.ldb)});
        if (!this.ldg.ldb || i != 1 || this.ldS == j) {
            return false;
        }
        boolean w = w(j, -1);
        this.ldS = j;
        return w;
    }
}
