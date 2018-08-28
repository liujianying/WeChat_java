package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.plugin.mmsight.segment.e.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

public class i implements e {
    protected long aBL;
    protected String elA = null;
    private int frameCount = 0;
    protected MediaExtractor ldo;
    protected MediaCodec ldq;
    protected BufferInfo ljD = new BufferInfo();
    protected a lkS;
    protected long lkn;
    protected int lkp;
    protected int llF;
    private byte[] llL;
    protected MediaFormat lll;
    protected int sampleSize;

    public i(MediaExtractor mediaExtractor, MediaFormat mediaFormat, int i) {
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "create MediaCodecTranscodeDecoder: %s, %s, %s", new Object[]{mediaExtractor, mediaFormat, Integer.valueOf(i)});
        this.ldo = mediaExtractor;
        this.lll = mediaFormat;
        this.llF = i;
    }

    public final int t(String str, long j, long j2) {
        this.elA = str;
        this.aBL = j;
        this.lkn = j2;
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "initDecoder() called with: format = [" + this.lll + "]");
        try {
            String string = this.lll.getString("mime");
            this.ldq = MediaCodec.createDecoderByType(string);
            MediaCodecInfo Hv = Hv(string);
            x.i("MicroMsg.MediaCodecTranscodeDecoder", "found codec: %s", new Object[]{Hv});
            if (Hv != null) {
                x.i("MicroMsg.MediaCodecTranscodeDecoder", "codec name: %s", new Object[]{Hv.getName()});
                x.i("MicroMsg.MediaCodecTranscodeDecoder", "found colorFormat: %s", new Object[]{Integer.valueOf(a(Hv, string))});
                this.lll.setInteger("color-format", r1);
            }
            this.ldq.configure(this.lll, null, null, 0);
            this.ldq.start();
            return 0;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", e, "Init decoder failed : %s", new Object[]{e.getMessage()});
            return -1;
        }
    }

    private static MediaCodecInfo Hv(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }

    protected int a(MediaCodecInfo mediaCodecInfo, String str) {
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[]{str, mediaCodecInfo});
        long VG = bi.VG();
        CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "getCapabilitiesForType used %sms", new Object[]{Long.valueOf(bi.bI(VG))});
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "color format length: %s", new Object[]{Integer.valueOf(capabilitiesForType.colorFormats.length)});
        int i = 0;
        for (int i2 : capabilitiesForType.colorFormats) {
            x.i("MicroMsg.MediaCodecTranscodeDecoder", "capabilities colorFormat: %s", new Object[]{Integer.valueOf(i2)});
            if (sW(i2) && (i2 > i || i2 == 21)) {
                i = i2;
            }
        }
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "codec: %s, colorFormat: %s", new Object[]{mediaCodecInfo.getName(), Integer.valueOf(i)});
        return i;
    }

    protected boolean sW(int i) {
        switch (i) {
            case 19:
            case 21:
                return true;
            default:
                return false;
        }
    }

    protected boolean beX() {
        if (this.ldq == null) {
            x.e("MicroMsg.MediaCodecTranscodeDecoder", "drainDecoder, decoder is null");
            return true;
        }
        ByteBuffer[] outputBuffers = this.ldq.getOutputBuffers();
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "decoderOutputByteBuffers length: %s", new Object[]{Integer.valueOf(outputBuffers.length)});
        int dequeueOutputBuffer = this.ldq.dequeueOutputBuffer(this.ljD, 60000);
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "outputBufferIndex-->" + dequeueOutputBuffer);
        while (dequeueOutputBuffer != -1) {
            if (dequeueOutputBuffer != -3) {
                if (dequeueOutputBuffer != -2) {
                    if (dequeueOutputBuffer >= 0) {
                        x.v("MicroMsg.MediaCodecTranscodeDecoder", "perform decoding");
                        ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                        if (byteBuffer == null) {
                            break;
                        }
                        long j = this.ljD.presentationTimeUs;
                        if (j < this.aBL * 1000 && (this.ljD.flags & 4) == 0) {
                            this.ldq.releaseOutputBuffer(dequeueOutputBuffer, false);
                            x.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder pts: %s, not reach start: %s", new Object[]{Long.valueOf(j), Long.valueOf(this.aBL * 1000)});
                            return false;
                        } else if (this.ljD.size != 0) {
                            byteBuffer.position(this.ljD.offset);
                            byteBuffer.limit(this.ljD.offset + this.ljD.size);
                            long VG = bi.VG();
                            BufferInfo bufferInfo = this.ljD;
                            if (byteBuffer == null) {
                                x.e("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer error! byteBuffer is null");
                            } else {
                                this.frameCount++;
                                if (this.lkp <= 1 || this.frameCount % this.lkp != 0) {
                                    if (this.llL == null) {
                                        this.llL = new byte[byteBuffer.remaining()];
                                    }
                                    long VG2 = bi.VG();
                                    try {
                                        this.lll = this.ldq.getOutputFormat();
                                    } catch (Exception e) {
                                        x.e("MicroMsg.MediaCodecTranscodeDecoder", "get output format error");
                                    }
                                    byteBuffer.get(this.llL, 0, byteBuffer.remaining());
                                    x.i("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d cost %d", new Object[]{byteBuffer, bufferInfo, Integer.valueOf(bufferInfo.size), Long.valueOf(bi.bI(VG2))});
                                    if (this.lkS != null) {
                                        this.lkS.aB(this.llL);
                                    }
                                }
                            }
                            x.v("MicroMsg.MediaCodecTranscodeDecoder", "processDecodeOutputBuffer %s", new Object[]{Long.valueOf(bi.bI(VG))});
                            this.ldq.releaseOutputBuffer(dequeueOutputBuffer, false);
                            if (this.lkn != 1 && j >= this.lkn * 1000) {
                                x.e("MicroMsg.MediaCodecTranscodeDecoder", "exceed endTimeMs");
                                return true;
                            } else if ((this.ljD.flags & 4) == 0) {
                                return false;
                            } else {
                                x.i("MicroMsg.MediaCodecTranscodeDecoder", "receive end of stream");
                                try {
                                    this.ldq.stop();
                                    this.ldq.release();
                                    this.ldq = null;
                                } catch (Exception e2) {
                                    x.e("MicroMsg.MediaCodecTranscodeDecoder", "stop and release decoder error: %s", new Object[]{e2.getMessage()});
                                }
                                return true;
                            }
                        } else {
                            this.ldq.releaseOutputBuffer(dequeueOutputBuffer, false);
                        }
                    } else {
                        x.w("MicroMsg.MediaCodecTranscodeDecoder", "unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                    }
                } else {
                    this.lll = this.ldq.getOutputFormat();
                    x.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output format changed: " + this.lll);
                }
            } else {
                outputBuffers = this.ldq.getOutputBuffers();
                x.i("MicroMsg.MediaCodecTranscodeDecoder", "decoder output buffers changed");
            }
            dequeueOutputBuffer = this.ldq.dequeueOutputBuffer(this.ljD, 60000);
            if (dequeueOutputBuffer < 0) {
                break;
            }
        }
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "no output from decoder available, break");
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void F(java.lang.Runnable r11) {
        /*
        r10 = this;
        r0 = 0;
        r10.frameCount = r0;
    L_0x0003:
        r2 = r10.ldo;
        r0 = r10.ldq;
        if (r0 != 0) goto L_0x00b1;
    L_0x0009:
        r0 = "MicroMsg.MediaCodecTranscodeDecoder";
        r1 = "input decoder is null";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r7 = 1;
    L_0x0013:
        if (r7 != 0) goto L_0x002d;
    L_0x0015:
        r0 = r10.ldo;
        r0.advance();
        r0 = r10.ldo;
        r0 = r0.getSampleTrackIndex();
        r1 = r10.llF;
        if (r0 == r1) goto L_0x0003;
    L_0x0024:
        r0 = "MicroMsg.MediaCodecTranscodeDecoder";
        r1 = "track index not match, break";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
    L_0x002d:
        r0 = r10.ldo;
        r1 = "MicroMsg.MediaCodecTranscodeDecoder";
        r2 = "sendDecoderEOS";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        r1 = r10.ldq;
        r2 = r1.getInputBuffers();
        r1 = r10.ldq;
        r4 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r1 = r1.dequeueInputBuffer(r4);
        if (r1 >= 0) goto L_0x006a;
    L_0x0049:
        r3 = "MicroMsg.MediaCodecTranscodeDecoder";
        r4 = "check decoder input buffer index = %d count = %d";
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = java.lang.Integer.valueOf(r1);
        r5[r6] = r7;
        r6 = 1;
        r7 = 0;
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
        r3 = r10.beX();
        if (r3 != 0) goto L_0x00a3;
    L_0x006a:
        if (r1 < 0) goto L_0x00a0;
    L_0x006c:
        r2 = r2[r1];
        r2.clear();
        r3 = 0;
        r3 = r0.readSampleData(r2, r3);
        r10.sampleSize = r3;
        r3 = 0;
        r2.position(r3);
        r4 = r0.getSampleTime();
        if (r1 < 0) goto L_0x018f;
    L_0x0082:
        r0 = "MicroMsg.MediaCodecTranscodeDecoder";
        r2 = "send EOS, decoderInputBufferIndex: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r6 = 0;
        r7 = java.lang.Integer.valueOf(r1);
        r3[r6] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);
        r0 = r10.ldq;
        r2 = 0;
        r3 = 0;
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 * r6;
        r6 = 4;
        r0.queueInputBuffer(r1, r2, r3, r4, r6);
    L_0x00a0:
        r10.beX();
    L_0x00a3:
        r0 = new com.tencent.mm.plugin.mmsight.segment.i$1;
        r0.<init>(r10);
        r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        com.tencent.mm.sdk.platformtools.ah.i(r0, r2);
        r11.run();
        return;
    L_0x00b1:
        r0 = r10.ldq;
        r3 = r0.getInputBuffers();
        if (r3 != 0) goto L_0x00bc;
    L_0x00b9:
        r7 = 0;
        goto L_0x0013;
    L_0x00bc:
        r0 = "MicroMsg.MediaCodecTranscodeDecoder";
        r1 = "decoderInputByteBuffers size: %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = r3.length;
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r4);
        r0 = 0;
    L_0x00d1:
        r1 = r10.ldq;
        r4 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r1 = r1.dequeueInputBuffer(r4);
        if (r1 >= 0) goto L_0x0107;
    L_0x00dc:
        r4 = 15;
        if (r0 >= r4) goto L_0x0107;
    L_0x00e0:
        r4 = com.tencent.mm.sdk.platformtools.bi.VG();
        r1 = r10.beX();
        r6 = "MicroMsg.MediaCodecTranscodeDecoder";
        r7 = "drain cost1 %d";
        r8 = 1;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r4 = com.tencent.mm.sdk.platformtools.bi.bI(r4);
        r4 = java.lang.Long.valueOf(r4);
        r8[r9] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r6, r7, r8);
        if (r1 == 0) goto L_0x0104;
    L_0x0101:
        r7 = 1;
        goto L_0x0013;
    L_0x0104:
        r0 = r0 + 1;
        goto L_0x00d1;
    L_0x0107:
        r0 = 0;
        if (r1 < 0) goto L_0x0184;
    L_0x010a:
        r3 = r3[r1];
        r3.clear();
        r4 = 0;
        r4 = r2.readSampleData(r3, r4);
        r10.sampleSize = r4;
        r4 = 0;
        r3.position(r4);
        r4 = r2.getSampleTime();
        r2 = "MicroMsg.MediaCodecTranscodeDecoder";
        r3 = "sampleTime: %s";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = java.lang.Long.valueOf(r4);
        r6[r7] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r6);
        r2 = r10.sampleSize;
        if (r2 < 0) goto L_0x013e;
    L_0x0135:
        r2 = r10.lkn;
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r2 * r6;
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x019a;
    L_0x013e:
        r0 = 1;
        r7 = r0;
    L_0x0140:
        r0 = "MicroMsg.MediaCodecTranscodeDecoder";
        r2 = "sawInputEOS: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r6 = 0;
        r8 = java.lang.Boolean.valueOf(r7);
        r3[r6] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);
        r0 = r10.ldq;
        r2 = 0;
        r3 = r10.sampleSize;
        if (r7 == 0) goto L_0x0182;
    L_0x015a:
        r6 = 4;
    L_0x015b:
        r0.queueInputBuffer(r1, r2, r3, r4, r6);
    L_0x015e:
        r0 = com.tencent.mm.sdk.platformtools.bi.VG();
        r2 = r10.beX();
        r3 = "MicroMsg.MediaCodecTranscodeDecoder";
        r4 = "drain cost2 %d";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.bI(r0);
        r0 = java.lang.Long.valueOf(r0);
        r5[r6] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
        if (r2 == 0) goto L_0x0013;
    L_0x017f:
        r7 = 1;
        goto L_0x0013;
    L_0x0182:
        r6 = 0;
        goto L_0x015b;
    L_0x0184:
        r1 = "MicroMsg.MediaCodecTranscodeDecoder";
        r2 = "input buffer not available";
        com.tencent.mm.sdk.platformtools.x.w(r1, r2);
        r7 = r0;
        goto L_0x015e;
    L_0x018f:
        r0 = "MicroMsg.MediaCodecTranscodeDecoder";
        r1 = "input buffer not available";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        goto L_0x00a0;
    L_0x019a:
        r7 = r0;
        goto L_0x0140;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.segment.i.F(java.lang.Runnable):void");
    }

    public final void a(a aVar) {
        this.lkS = aVar;
    }

    public int beL() {
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "src color format: %s", new Object[]{Integer.valueOf(this.lll.getInteger("color-format"))});
        switch (this.lll.getInteger("color-format")) {
            case 19:
                return 2;
            default:
                return 1;
        }
    }

    public final Point beI() {
        return new Point(this.lll.getInteger("width"), this.lll.getInteger("height"));
    }

    public final void stop() {
        if (this.ldq != null) {
            try {
                x.i("MicroMsg.MediaCodecTranscodeDecoder", "stop decoder");
                this.ldq.stop();
                this.ldq.release();
                this.ldq = null;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MediaCodecTranscodeDecoder", e, "stop decoder error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public final void sV(int i) {
        x.i("MicroMsg.MediaCodecTranscodeDecoder", "setFrameDropInterval: %s", new Object[]{Integer.valueOf(i)});
        this.lkp = i;
    }
}
