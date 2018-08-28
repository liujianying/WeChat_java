package com.tencent.mm.plugin.mmsight.model.b;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

public final class d {
    private ByteBuffer[] agE;
    private ByteBuffer[] apO;
    private boolean bDs = false;
    boolean bTv = false;
    private int bitrate = 0;
    private int fau;
    private int fav;
    int frameCount;
    int kGn;
    int kGo;
    protected int lhM = -1;
    protected MediaCodec lhN;
    private int lhV = -1;
    int lhv;
    protected MediaFormat ljB;
    private int ljC = -1;
    private BufferInfo ljD;
    private boolean ljE = false;
    private int ljF;
    private int ljG;
    a lkr;
    int lks;
    byte[] lkt;
    int lku;

    public d(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fau = i;
        this.fav = i2;
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "create MMSightRemuxMediaCodecEncoder, init targetWidth: %d, targetHeight: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
        this.kGn = i3;
        this.kGo = i4;
        this.ljG = i6;
        this.ljF = 1;
        this.ljD = new BufferInfo();
        this.bitrate = i5;
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "create MMSightRemuxMediaCodecEncoder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s", new Object[]{Integer.valueOf(this.fau), Integer.valueOf(this.fav), Integer.valueOf(this.kGn), Integer.valueOf(this.kGo), Integer.valueOf(i5)});
    }

    public final int sU(int i) {
        try {
            this.lhM = i;
            return beE();
        } catch (Exception e) {
            x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "init error: %s, try to re-init again", new Object[]{e.getMessage()});
            try {
                return beE();
            } catch (Exception e2) {
                x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "re-init again error: %s", new Object[]{e2.getMessage()});
                k.bdW();
                return -1;
            }
        }
    }

    private int beE() {
        int i;
        int i2;
        MediaCodecInfo mediaCodecInfo;
        long VG = bi.VG();
        String str = "video/avc";
        int codecCount = MediaCodecList.getCodecCount();
        loop0:
        for (i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        mediaCodecInfo = codecInfoAt;
                        break loop0;
                    }
                }
                continue;
            }
        }
        mediaCodecInfo = null;
        if (mediaCodecInfo == null) {
            x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "Unable to find an appropriate codec for video/avc");
            k.bdW();
            return -1;
        }
        long bI;
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found codec: %s, used %sms", new Object[]{mediaCodecInfo.getName(), Long.valueOf(bi.bI(VG))});
        VG = bi.VG();
        i2 = 0;
        long VG2 = bi.VG();
        CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "getCapabilitiesForType used %sms", new Object[]{Long.valueOf(bi.bI(VG2))});
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "color format length: %s", new Object[]{Integer.valueOf(capabilitiesForType.colorFormats.length)});
        for (int i3 : capabilitiesForType.colorFormats) {
            Object obj;
            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "capabilities colorFormat: %s", new Object[]{Integer.valueOf(i3)});
            switch (i3) {
                case 19:
                case 21:
                case 2130706688:
                    obj = 1;
                    break;
                default:
                    obj = null;
                    break;
            }
            if (obj != null && i3 > i2) {
                if (i3 != 19) {
                    i2 = i3;
                } else {
                    x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "codec: %s, colorFormat: %s", new Object[]{mediaCodecInfo.getName(), Integer.valueOf(i3)});
                    this.lhv = i3;
                    bI = bi.bI(VG);
                    x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found colorFormat: %s, used %sms", new Object[]{Integer.valueOf(this.lhv), Long.valueOf(bI)});
                    if (this.lhv != 19) {
                        this.lku = 2;
                    } else {
                        this.lku = 1;
                    }
                    bI = bi.VG();
                    this.ljB = MediaFormat.createVideoFormat("video/avc", this.kGn, this.kGo);
                    x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "createVideoFormat used %sms", new Object[]{Long.valueOf(bi.bI(bI))});
                    if (mediaCodecInfo != null) {
                        CodecCapabilities capabilitiesForType2;
                        if (com.tencent.mm.compatible.util.d.fR(23)) {
                            try {
                                capabilitiesForType2 = mediaCodecInfo.getCapabilitiesForType("video/avc");
                                if (capabilitiesForType2 != null) {
                                    CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType2.profileLevels;
                                    if (codecProfileLevelArr != null) {
                                        CodecProfileLevel codecProfileLevel = new CodecProfileLevel();
                                        codecProfileLevel.level = 0;
                                        codecProfileLevel.profile = 0;
                                        for (CodecProfileLevel codecProfileLevel2 : codecProfileLevelArr) {
                                            Object obj2;
                                            int i4 = codecProfileLevel2.profile;
                                            int i5 = codecProfileLevel2.level;
                                            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "profile: %s, level: %s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i5)});
                                            switch (i4) {
                                                case 1:
                                                case 2:
                                                case 8:
                                                    obj2 = 1;
                                                    break;
                                                default:
                                                    obj2 = null;
                                                    break;
                                            }
                                            if (obj2 != null && i4 >= codecProfileLevel.profile && i5 >= codecProfileLevel.level) {
                                                codecProfileLevel.profile = i4;
                                                codecProfileLevel.level = i5;
                                            }
                                        }
                                        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "best profile: %s, level: %s", new Object[]{Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level)});
                                        if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= GLIcon.TOP) {
                                            this.ljB.setInteger("profile", codecProfileLevel.profile);
                                            this.ljB.setInteger("level", GLIcon.TOP);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "trySetProfile error: %s", new Object[]{e.getMessage()});
                            }
                        }
                        try {
                            if (com.tencent.mm.compatible.util.d.fR(21)) {
                                capabilitiesForType2 = mediaCodecInfo.getCapabilitiesForType("video/avc");
                                if (capabilitiesForType2 != null) {
                                    EncoderCapabilities encoderCapabilities = capabilitiesForType2.getEncoderCapabilities();
                                    if (encoderCapabilities != null) {
                                        if (encoderCapabilities.isBitrateModeSupported(2)) {
                                            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cbr bitrate mode");
                                            this.ljB.setInteger("bitrate-mode", 2);
                                        } else if (encoderCapabilities.isBitrateModeSupported(0)) {
                                            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cq bitrate mode");
                                            this.ljB.setInteger("bitrate-mode", 0);
                                        } else {
                                            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "both cbr and cq bitrate mode not support!");
                                        }
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "trySetBitRateMode error: %s", new Object[]{e2.getMessage()});
                        }
                    }
                    this.ljB.setInteger("bitrate", this.bitrate);
                    this.ljB.setInteger("frame-rate", this.ljG);
                    this.ljB.setInteger("color-format", this.lhv);
                    this.ljB.setInteger("i-frame-interval", this.ljF);
                    x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "mediaFormat: %s", new Object[]{this.ljB});
                    this.lhN = MediaCodec.createByCodecName(mediaCodecInfo.getName());
                    this.lhN.configure(this.ljB, null, null, 1);
                    this.lhN.start();
                    return 0;
                }
            }
        }
        i3 = i2;
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "codec: %s, colorFormat: %s", new Object[]{mediaCodecInfo.getName(), Integer.valueOf(i3)});
        this.lhv = i3;
        bI = bi.bI(VG);
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found colorFormat: %s, used %sms", new Object[]{Integer.valueOf(this.lhv), Long.valueOf(bI)});
        if (this.lhv != 19) {
            this.lku = 1;
        } else {
            this.lku = 2;
        }
        bI = bi.VG();
        this.ljB = MediaFormat.createVideoFormat("video/avc", this.kGn, this.kGo);
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "createVideoFormat used %sms", new Object[]{Long.valueOf(bi.bI(bI))});
        if (mediaCodecInfo != null) {
            CodecCapabilities capabilitiesForType22;
            if (com.tencent.mm.compatible.util.d.fR(23)) {
                try {
                    capabilitiesForType22 = mediaCodecInfo.getCapabilitiesForType("video/avc");
                    if (capabilitiesForType22 != null) {
                        CodecProfileLevel[] codecProfileLevelArr2 = capabilitiesForType22.profileLevels;
                        if (codecProfileLevelArr2 != null) {
                            CodecProfileLevel codecProfileLevel3 = new CodecProfileLevel();
                            codecProfileLevel3.level = 0;
                            codecProfileLevel3.profile = 0;
                            for (CodecProfileLevel codecProfileLevel22 : codecProfileLevelArr2) {
                                Object obj22;
                                int i42 = codecProfileLevel22.profile;
                                int i52 = codecProfileLevel22.level;
                                x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "profile: %s, level: %s", new Object[]{Integer.valueOf(i42), Integer.valueOf(i52)});
                                switch (i42) {
                                    case 1:
                                    case 2:
                                    case 8:
                                        obj22 = 1;
                                        break;
                                    default:
                                        obj22 = null;
                                        break;
                                }
                                if (obj22 != null && i42 >= codecProfileLevel3.profile && i52 >= codecProfileLevel3.level) {
                                    codecProfileLevel3.profile = i42;
                                    codecProfileLevel3.level = i52;
                                }
                            }
                            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "best profile: %s, level: %s", new Object[]{Integer.valueOf(codecProfileLevel3.profile), Integer.valueOf(codecProfileLevel3.level)});
                            if (codecProfileLevel3.profile > 0 && codecProfileLevel3.level >= GLIcon.TOP) {
                                this.ljB.setInteger("profile", codecProfileLevel3.profile);
                                this.ljB.setInteger("level", GLIcon.TOP);
                            }
                        }
                    }
                } catch (Exception e22) {
                    x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "trySetProfile error: %s", new Object[]{e22.getMessage()});
                }
            }
            try {
                if (com.tencent.mm.compatible.util.d.fR(21)) {
                    capabilitiesForType22 = mediaCodecInfo.getCapabilitiesForType("video/avc");
                    if (capabilitiesForType22 != null) {
                        EncoderCapabilities encoderCapabilities2 = capabilitiesForType22.getEncoderCapabilities();
                        if (encoderCapabilities2 != null) {
                            if (encoderCapabilities2.isBitrateModeSupported(2)) {
                                x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cbr bitrate mode");
                                this.ljB.setInteger("bitrate-mode", 2);
                            } else if (encoderCapabilities2.isBitrateModeSupported(0)) {
                                x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cq bitrate mode");
                                this.ljB.setInteger("bitrate-mode", 0);
                            } else {
                                x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "both cbr and cq bitrate mode not support!");
                            }
                        }
                    }
                }
            } catch (Exception e222) {
                x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "trySetBitRateMode error: %s", new Object[]{e222.getMessage()});
            }
        }
        this.ljB.setInteger("bitrate", this.bitrate);
        this.ljB.setInteger("frame-rate", this.ljG);
        this.ljB.setInteger("color-format", this.lhv);
        this.ljB.setInteger("i-frame-interval", this.ljF);
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "mediaFormat: %s", new Object[]{this.ljB});
        this.lhN = MediaCodec.createByCodecName(mediaCodecInfo.getName());
        this.lhN.configure(this.ljB, null, null, 1);
        this.lhN.start();
        return 0;
    }

    public final void b(byte[] bArr, boolean z, long j) {
        try {
            if (!this.bTv) {
                x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData, not start!");
            } else if (this.lhN == null) {
                x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder is null");
            } else {
                long VG = bi.VG();
                this.apO = this.lhN.getInputBuffers();
                this.agE = this.lhN.getOutputBuffers();
                int i = 0;
                while (this.lhN != null) {
                    int dequeueInputBuffer = this.lhN.dequeueInputBuffer(600);
                    this.ljC = dequeueInputBuffer;
                    if (dequeueInputBuffer >= 0 || i >= 10) {
                        break;
                    }
                    x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "video no input available, drain first");
                    beF();
                    i++;
                }
                if (this.lhN == null) {
                    x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder is null");
                    return;
                }
                x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "inputBufferIndex: %s", new Object[]{Integer.valueOf(this.ljC)});
                long VG2 = bi.VG();
                if (this.ljC < 0) {
                    x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "input buffer not available");
                } else if (!this.bTv || z || bArr == null) {
                    x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "end of stream");
                    this.ljE = true;
                    this.lhN.queueInputBuffer(this.ljC, 0, 0, j, 4);
                    this.bDs = true;
                } else {
                    x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "presentationTime: " + j);
                    ByteBuffer byteBuffer = this.apO[this.ljC];
                    byteBuffer.clear();
                    byteBuffer.put(bArr);
                    byteBuffer.position(0);
                    this.lhN.queueInputBuffer(this.ljC, 0, bArr.length, j, 0);
                }
                beF();
                x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder used %sms %sms", new Object[]{Long.valueOf(bi.bI(VG)), Long.valueOf(bi.bI(VG2))});
            }
        } catch (Throwable e) {
            k.bdX();
            x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData error: %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecEncoder", e, "", new Object[0]);
        }
    }

    private void beF() {
        this.lhV = this.lhN.dequeueOutputBuffer(this.ljD, 600);
        x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "outputBufferIndex-->" + this.lhV);
        while (true) {
            if (this.lhV == -1) {
                x.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "no output from encoder available, break encoderEndStream %s", new Object[]{Boolean.valueOf(this.ljE)});
                if (!this.ljE) {
                    return;
                }
            } else if (this.lhV == -3) {
                this.agE = this.lhN.getOutputBuffers();
                x.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder output buffers changed");
            } else if (this.lhV == -2) {
                x.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder output format changed: " + this.lhN.getOutputFormat());
            } else if (this.lhV < 0) {
                x.w("MicroMsg.MMSightRemuxMediaCodecEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + this.lhV);
            } else {
                x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "perform encoding");
                ByteBuffer byteBuffer = this.agE[this.lhV];
                if (byteBuffer == null) {
                    throw new RuntimeException("encoderOutputBuffer " + this.lhV + " was null");
                }
                this.frameCount++;
                if ((this.ljD.flags & 2) != 0) {
                    x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[]{Integer.valueOf(this.ljD.size), Boolean.valueOf(false)});
                }
                if (this.ljD.size != 0) {
                    byteBuffer.position(this.ljD.offset);
                    byteBuffer.limit(this.ljD.offset + this.ljD.size);
                    BufferInfo bufferInfo = this.ljD;
                    if (!(byteBuffer == null || bufferInfo == null || this.lkr == null)) {
                        this.lkr.a(this.lhM, byteBuffer, bufferInfo.size);
                    }
                }
                this.lhN.releaseOutputBuffer(this.lhV, false);
                if ((this.ljD.flags & 4) != 0) {
                    if (this.bDs) {
                        x.w("MicroMsg.MMSightRemuxMediaCodecEncoder", "do stop encoder, frameCount: %s, writeFrameCount: %s", new Object[]{Integer.valueOf(this.frameCount), Integer.valueOf(this.lks)});
                        try {
                            this.lhN.stop();
                            this.lhN.release();
                            this.lhN = null;
                            this.bTv = false;
                            return;
                        } catch (Exception e) {
                            x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "do stop encoder error: %s", new Object[]{e.getMessage()});
                            return;
                        }
                    }
                    x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "reached end of stream unexpectedly");
                    return;
                }
            }
            this.lhV = this.lhN.dequeueOutputBuffer(this.ljD, 600);
            if (this.lhV <= 0) {
                x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "get outputBufferIndex %d", new Object[]{Integer.valueOf(this.lhV)});
            }
            if (this.lhV < 0 && !this.ljE) {
                return;
            }
        }
    }
}
