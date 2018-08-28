package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class h implements e$a {
    private static int llI = -1;
    long aBL = -1;
    int bYE;
    private int lht;
    private int lhu;
    String lkm;
    long lkn = -1;
    int lkp = -1;
    Thread lkw;
    private int llA;
    private int llB;
    a llC;
    private int llD = 0;
    MediaExtractor llE;
    int llF;
    e llG;
    private boolean llH = false;
    private MediaFormat llJ;
    VideoTransPara lln;
    private int llw;
    private int llx;
    private int lly;
    private int llz;
    private Object lock = new byte[0];

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int beW() {
        /*
        r6 = 21;
        r5 = 3;
        r4 = 2;
        r3 = -1;
        r2 = 1;
        r0 = com.tencent.mm.plugin.mmsight.model.CaptureMMProxy.getInstance();
        r1 = com.tencent.mm.storage.aa.a.sUI;
        r0 = r0.getInt(r1, r3);
        if (r0 == r3) goto L_0x002a;
    L_0x0012:
        if (r0 != r2) goto L_0x0022;
    L_0x0014:
        r0 = com.tencent.mm.compatible.util.d.fR(r6);
        if (r0 == 0) goto L_0x001f;
    L_0x001a:
        llI = r4;
    L_0x001c:
        r0 = llI;
    L_0x001e:
        return r0;
    L_0x001f:
        llI = r2;
        goto L_0x001c;
    L_0x0022:
        if (r0 != r4) goto L_0x0027;
    L_0x0024:
        llI = r2;
        goto L_0x001c;
    L_0x0027:
        llI = r5;
        goto L_0x001c;
    L_0x002a:
        r0 = llI;
        if (r0 == r3) goto L_0x0031;
    L_0x002e:
        r0 = llI;
        goto L_0x001e;
    L_0x0031:
        r0 = com.tencent.mm.compatible.e.q.deT;
        r0 = r0.dff;
        if (r0 == r3) goto L_0x0051;
    L_0x0037:
        if (r0 != r2) goto L_0x003e;
    L_0x0039:
        llI = r2;
    L_0x003b:
        r0 = llI;
        goto L_0x001e;
    L_0x003e:
        if (r0 != r4) goto L_0x004c;
    L_0x0040:
        r0 = com.tencent.mm.compatible.util.d.fR(r6);
        if (r0 == 0) goto L_0x0049;
    L_0x0046:
        llI = r4;
        goto L_0x003b;
    L_0x0049:
        llI = r2;
        goto L_0x003b;
    L_0x004c:
        if (r0 != r5) goto L_0x003b;
    L_0x004e:
        llI = r5;
        goto L_0x003b;
    L_0x0051:
        r0 = com.tencent.mm.plugin.mmsight.model.CaptureMMProxy.getInstance();
        r1 = "SightSegCutMinApiLevel";
        r0 = r0.getDynamicConfig(r1);
        r0 = com.tencent.mm.sdk.platformtools.bi.getInt(r0, r6);
        r0 = com.tencent.mm.compatible.util.d.fR(r0);
        if (r0 == 0) goto L_0x004e;
    L_0x0066:
        llI = r2;
        goto L_0x003b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.segment.h.beW():int");
    }

    public final int e(MediaFormat mediaFormat) {
        x.i("MicroMsg.MediaCodecFFMpegTranscoder", "initDecoder, format: %s, filePath: %s", new Object[]{mediaFormat, this.lkm});
        this.llJ = mediaFormat;
        int beW = beW();
        if (beW == 1) {
            this.llG = new i(this.llE, mediaFormat, this.llF);
            this.llH = false;
        } else if (beW == 2) {
            this.llG = new j(this.llE, mediaFormat, this.llF);
            this.llH = false;
        } else {
            this.llG = new b();
            this.llH = true;
        }
        if (this.llG == null) {
            x.i("MicroMsg.MediaCodecFFMpegTranscoder", "use default config");
            this.llG = new i(this.llE, mediaFormat, this.llF);
            this.llH = false;
        }
        beW = this.llG.t(this.lkm, this.aBL, this.lkn);
        x.i("MicroMsg.MediaCodecFFMpegTranscoder", "init decoder ret: %s", new Object[]{Integer.valueOf(beW)});
        if (beW < 0 && (llI == 1 || llI == 2)) {
            x.i("MicroMsg.MediaCodecFFMpegTranscoder", "init mediaCodecDecoder failed, try ffmepg");
            try {
                this.llG.stop();
                this.llG = null;
            } catch (Exception e) {
            }
            this.llG = new b();
            this.llH = true;
            llI = 3;
            beW = this.llG.t(this.lkm, this.aBL, this.lkn);
        }
        this.llG.a(this);
        x.i("MicroMsg.MediaCodecFFMpegTranscoder", "init finish, ret: %d, decoderType: %d", new Object[]{Integer.valueOf(beW), Integer.valueOf(llI)});
        return beW;
    }

    public final void cR(int i, int i2) {
        x.i("MicroMsg.MediaCodecFFMpegTranscoder", "registerDesiredSize: %s, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.llw = i;
        this.llx = i2;
    }

    private static Point q(int i, int i2, int i3, int i4) {
        x.d("MicroMsg.MediaCodecFFMpegTranscoder", "scale() called with: decoderOutputWidth = [" + i + "], decoderOutputHeight = [" + i2 + "], specWidth = [" + i3 + "], specHeight = [" + i4 + "]");
        if (i > i3 || i2 > i4) {
            int max = Math.max(i, i2);
            int min = Math.min(i, i2);
            int max2 = Math.max(i3, i4);
            int min2 = Math.min(i3, i4);
            int i5;
            if (max % 16 == 0 && Math.abs(max - max2) < 16 && min % 16 == 0 && Math.abs(min - min2) < 16) {
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, same len divide by 16, no need scale");
                return null;
            } else if (max / 2 == max2 && min / 2 == min2) {
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio");
                i5 = i / 2;
                max = i2 / 2;
                if (i5 % 2 != 0) {
                    i5++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                return new Point(i5, max);
            } else {
                i5 = max / 2;
                max = min / 2;
                if (i5 % 16 != 0 || Math.abs(i5 - max2) >= 16 || max % 16 != 0 || Math.abs(max - min2) >= 16) {
                    Point point = new Point();
                    if (i < i2) {
                        max = Math.min(i3, i4);
                        i5 = (int) (((double) i2) / ((((double) i) * 1.0d) / ((double) max)));
                    } else {
                        i5 = Math.min(i3, i4);
                        max = (int) (((double) i) / ((((double) i2) * 1.0d) / ((double) i5)));
                    }
                    if (i5 % 2 != 0) {
                        i5++;
                    }
                    if (max % 2 != 0) {
                        max++;
                    }
                    x.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, outputsize: %s %s", new Object[]{Integer.valueOf(max), Integer.valueOf(i5)});
                    point.x = max;
                    point.y = i5;
                    return point;
                }
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio divide by 16");
                i5 = i / 2;
                max = i2 / 2;
                if (i5 % 2 != 0) {
                    i5++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                return new Point(i5, max);
            }
        }
        x.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, small or equal to spec size");
        return null;
    }

    public final void release() {
        x.i("MicroMsg.MediaCodecFFMpegTranscoder", "release, decoderType: %d", new Object[]{Integer.valueOf(llI)});
        try {
            if (this.llG != null) {
                this.llG.stop();
            }
            MP4MuxerJNI.releaseDataBuf(0);
            llI = -1;
        } catch (Exception e) {
            x.e("MicroMsg.MediaCodecFFMpegTranscoder", "release error: %s", new Object[]{e.getMessage()});
            MP4MuxerJNI.releaseDataBuf(0);
            llI = -1;
        } catch (Throwable th) {
            MP4MuxerJNI.releaseDataBuf(0);
            llI = -1;
            throw th;
        }
    }

    public final void aB(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            x.i("MicroMsg.MediaCodecFFMpegTranscoder", "onYuvDataImp error data is null!!");
            return;
        }
        Point q;
        Point beI = this.llG.beI();
        this.lht = beI.x;
        this.lhu = beI.y;
        if (this.llB <= 0 || this.llA <= 0) {
            q = q(this.lht, this.lhu, this.llw, this.llx);
            if (q != null) {
                this.llA = q.x;
                this.llB = q.y;
            } else {
                this.llA = this.lht;
                this.llB = this.lhu;
            }
            x.i("MicroMsg.MediaCodecFFMpegTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[]{Integer.valueOf(this.llA), Integer.valueOf(this.llB), Integer.valueOf(this.lht), Integer.valueOf(this.lhu)});
        }
        long VG = bi.VG();
        int i = 0;
        int i2 = 0;
        if (this.llJ != null) {
            i = this.llJ.getInteger("width");
            i2 = this.llJ.getInteger("height");
            if (this.lly <= 0 || this.llz <= 0) {
                boolean z;
                q = q(i, i2, this.llw, this.llx);
                if (q != null) {
                    this.lly = q.x;
                    this.llz = q.y;
                    z = true;
                } else {
                    if (Math.abs(i2 - beI.y) <= 0 || i != beI.x) {
                        this.lly = beI.x;
                        this.llz = beI.y;
                    } else {
                        this.lly = i;
                        this.llz = i2;
                    }
                    z = false;
                }
                if (z) {
                    this.llA = this.lly;
                    this.llB = this.llz;
                }
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[]{Integer.valueOf(this.lly), Integer.valueOf(this.llz), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)});
            }
        }
        this.llD = this.llG.beL();
        int writeYuvDataForSegment = MP4MuxerJNI.writeYuvDataForSegment(bArr, beI.x, beI.y, this.llA, this.llB, this.llD, i, i2);
        x.i("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment used %sms", new Object[]{Long.valueOf(bi.bI(VG))});
        if (writeYuvDataForSegment < 0) {
            x.e("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment error: %s", new Object[]{Integer.valueOf(writeYuvDataForSegment)});
        }
        if (this.llC == null) {
            MP4MuxerJNI.initH264Encoder(this.lly, this.llz, (float) this.lln.fps, this.lln.videoBitrate, this.lln.dQI, 8, this.lln.dQH, 23.0f);
            this.llC = new a(this, (byte) 0);
            this.lkw = e.b(this.llC, "MediaCodecFFMpegTranscoder_Encoder");
            this.lkw.start();
            x.i("MicroMsg.MediaCodecFFMpegTranscoder", "initAndStartEncoder");
        }
    }
}
