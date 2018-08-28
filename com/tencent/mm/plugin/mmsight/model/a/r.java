package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.f.a;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.nio.ByteBuffer;

@TargetApi(16)
public class r implements f {
    private ByteBuffer[] agE;
    private ByteBuffer[] apO;
    boolean bDs = false;
    boolean bTv = false;
    private int bitrate = 0;
    private long dkh = 0;
    private int fau;
    private int fav;
    int frameCount;
    int kGn;
    int kGo;
    boolean lgJ = false;
    protected MediaCodec lhN;
    private int lhV = -1;
    private o lhZ;
    int lhv;
    a ljA = new a(this.ljI);
    protected MediaFormat ljB;
    private int ljC = -1;
    private BufferInfo ljD;
    private boolean ljE = false;
    private int ljF;
    private int ljG;
    a ljH;
    private a.a ljI = new 1(this);
    int ljw = -1;
    int ljx = -1;
    int ljy = -1;
    int ljz = -1;
    long startTime = 0;

    public r(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        this.fau = i;
        this.fav = i2;
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "create MMSightYUVMediaCodecRecorder, init targetWidth: %d, targetHeight: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "create MMSightYUVMediaCodecRecorder, after align 16, targetWidth: %d, targetHeight: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
        this.kGn = i3;
        this.kGo = i4;
        this.ljG = i7;
        this.ljF = i6;
        this.lhZ = null;
        this.ljD = new BufferInfo();
        this.bitrate = i5;
        this.lgJ = z;
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "create BigSightMediaCodecYUVRecorder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s, needRotateEachFrame: %s, muxer: %s", new Object[]{Integer.valueOf(this.fau), Integer.valueOf(this.fav), Integer.valueOf(this.kGn), Integer.valueOf(this.kGo), Integer.valueOf(i5), Boolean.valueOf(z), null});
    }

    public int cQ(int i, int i2) {
        int i3 = -1;
        try {
            this.ljw = i2;
            return beE();
        } catch (Exception e) {
            x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "init error: %s, try to re-init again", new Object[]{e.getMessage()});
            try {
                if (CaptureMMProxy.getInstance() != null) {
                    CaptureMMProxy.getInstance().set(aa.a.sUM, Integer.valueOf(-1));
                }
                return beE();
            } catch (Exception e2) {
                x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "re-init again error: %s", new Object[]{e2.getMessage()});
                k.bdW();
                return i3;
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
            x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "Unable to find an appropriate codec for video/avc");
            k.bdW();
            return -1;
        }
        long VG2;
        int i3;
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "found codec: %s, used %sms", new Object[]{mediaCodecInfo.getName(), Long.valueOf(bi.bI(VG))});
        VG = bi.VG();
        if (CaptureMMProxy.getInstance() != null) {
            i2 = CaptureMMProxy.getInstance().getInt(aa.a.sUM, -1);
        } else {
            i2 = -1;
        }
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "saveColorFormat: %s", new Object[]{Integer.valueOf(i2)});
        if (i2 <= 0) {
            VG2 = bi.VG();
            CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
            x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "getCapabilitiesForType used %sms", new Object[]{Long.valueOf(bi.bI(VG2))});
            x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "color format length: %s", new Object[]{Integer.valueOf(capabilitiesForType.colorFormats.length)});
            i2 = 0;
            for (int i4 : capabilitiesForType.colorFormats) {
                x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "capabilities colorFormat: %s", new Object[]{Integer.valueOf(i4)});
                switch (i4) {
                    case 19:
                    case 21:
                    case 2130706688:
                        i = 1;
                        break;
                    default:
                        i = 0;
                        break;
                }
                if (i != 0 && (i4 > i2 || i4 == 21)) {
                    i2 = i4;
                }
            }
            x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "codec: %s, colorFormat: %s", new Object[]{mediaCodecInfo.getName(), Integer.valueOf(i2)});
        }
        this.lhv = i2;
        VG2 = bi.bI(VG);
        if (this.lhv > 0 && VG2 > 200 && CaptureMMProxy.getInstance() != null) {
            CaptureMMProxy.getInstance().set(aa.a.sUM, Integer.valueOf(this.lhv));
        }
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "found colorFormat: %s, used %sms", new Object[]{Integer.valueOf(this.lhv), Long.valueOf(VG2)});
        VG = bi.VG();
        String str2;
        if (this.lgJ) {
            str2 = "video/avc";
            i2 = (this.ljw == 180 || this.ljw == 0) ? this.kGn : this.kGo;
            i3 = (this.ljw == 180 || this.ljw == 0) ? this.kGo : this.kGn;
            this.ljB = MediaFormat.createVideoFormat(str2, i2, i3);
        } else {
            str2 = "video/avc";
            i2 = (this.ljw == 180 || this.ljw == 0) ? this.kGo : this.kGn;
            i3 = (this.ljw == 180 || this.ljw == 0) ? this.kGn : this.kGo;
            this.ljB = MediaFormat.createVideoFormat(str2, i2, i3);
        }
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "createVideoFormat used %sms", new Object[]{Long.valueOf(bi.bI(VG))});
        if (mediaCodecInfo != null) {
            if (d.fR(23)) {
                try {
                    CodecCapabilities capabilitiesForType2 = mediaCodecInfo.getCapabilitiesForType("video/avc");
                    if (capabilitiesForType2 != null) {
                        CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType2.profileLevels;
                        if (codecProfileLevelArr != null) {
                            CodecProfileLevel codecProfileLevel = new CodecProfileLevel();
                            codecProfileLevel.level = 0;
                            codecProfileLevel.profile = 0;
                            for (CodecProfileLevel codecProfileLevel2 : codecProfileLevelArr) {
                                int i5 = codecProfileLevel2.profile;
                                int i6 = codecProfileLevel2.level;
                                x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "profile: %s, level: %s", new Object[]{Integer.valueOf(i5), Integer.valueOf(i6)});
                                switch (i5) {
                                    case 1:
                                    case 2:
                                    case 8:
                                        i3 = 1;
                                        break;
                                    default:
                                        i3 = 0;
                                        break;
                                }
                                if (i3 != 0 && i5 >= codecProfileLevel.profile && i6 >= codecProfileLevel.level) {
                                    codecProfileLevel.profile = i5;
                                    codecProfileLevel.level = i6;
                                }
                            }
                            x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "best profile: %s, level: %s", new Object[]{Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level)});
                            if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= 256) {
                                this.ljB.setInteger("profile", codecProfileLevel.profile);
                                this.ljB.setInteger("level", 256);
                            }
                        }
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "trySetProfile error: %s", new Object[]{e.getMessage()});
                }
            }
            try {
                if (d.fR(21)) {
                    this.ljB.setInteger("bitrate-mode", 1);
                }
            } catch (Exception e2) {
                x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "trySetBitRateMode error: %s", new Object[]{e2.getMessage()});
            }
        }
        this.ljB.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.bitrate);
        this.ljB.setInteger("frame-rate", this.ljG);
        this.ljB.setInteger("color-format", this.lhv);
        this.ljB.setInteger("i-frame-interval", this.ljF);
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "mediaFormat: %s", new Object[]{this.ljB});
        this.lhN = MediaCodec.createByCodecName(mediaCodecInfo.getName());
        this.lhN.configure(this.ljB, null, null, 1);
        this.lhN.start();
        return 0;
    }

    public final void d(byte[] bArr, boolean z) {
        try {
            if (!this.bTv) {
                x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData, not start!");
            } else if (this.lhN == null) {
                x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder is null");
            } else {
                if (this.lhZ != null && this.lhZ.lju <= 0) {
                    this.lhZ.lju = System.nanoTime();
                }
                long VG = bi.VG();
                this.apO = this.lhN.getInputBuffers();
                this.agE = this.lhN.getOutputBuffers();
                int dequeueInputBuffer = this.lhN.dequeueInputBuffer(100);
                this.ljC = dequeueInputBuffer;
                if (dequeueInputBuffer < 0) {
                    x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "video no input available, drain first");
                    beF();
                }
                if (this.lhN == null) {
                    x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder is null");
                    return;
                }
                x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "inputBufferIndex: %s", new Object[]{Integer.valueOf(this.ljC)});
                long VG2 = bi.VG();
                if (this.ljC >= 0) {
                    long nanoTime = ((System.nanoTime() - ((long) ((bArr.length / 1600000) / 1000000000))) - (this.lhZ != null ? this.lhZ.lju : this.startTime)) / 1000;
                    x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "presentationTime: " + nanoTime);
                    ByteBuffer byteBuffer = this.apO[this.ljC];
                    byteBuffer.clear();
                    byteBuffer.put(bArr);
                    byteBuffer.position(0);
                    if (!this.bTv || z) {
                        x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "end of stream");
                        this.ljE = true;
                        this.lhN.queueInputBuffer(this.ljC, 0, bArr.length, nanoTime, 4);
                    } else {
                        this.lhN.queueInputBuffer(this.ljC, 0, bArr.length, nanoTime, 0);
                    }
                } else {
                    x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "input buffer not available");
                }
                beF();
                x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder used %sms %sms", new Object[]{Long.valueOf(bi.bI(VG)), Long.valueOf(bi.bI(VG2))});
            }
        } catch (Throwable e) {
            k.bdX();
            x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData error: %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", e, "", new Object[0]);
        }
    }

    private void beF() {
        this.lhV = this.lhN.dequeueOutputBuffer(this.ljD, 100);
        x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "outputBufferIndex-->" + this.lhV);
        while (true) {
            if (this.lhV == -1) {
                x.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "no output from encoder available, break encoderEndStream %s", new Object[]{Boolean.valueOf(this.ljE)});
                if (!this.ljE) {
                    return;
                }
            } else if (this.lhV == -3) {
                this.agE = this.lhN.getOutputBuffers();
                x.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder output buffers changed");
            } else if (this.lhV == -2) {
                MediaFormat outputFormat = this.lhN.getOutputFormat();
                x.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder output format changed: " + outputFormat);
                if (this.lhZ != null) {
                    this.lhZ.c(outputFormat);
                }
            } else if (this.lhV < 0) {
                x.w("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + this.lhV);
            } else {
                x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "perform encoding");
                ByteBuffer byteBuffer = this.agE[this.lhV];
                if (byteBuffer == null) {
                    throw new RuntimeException("encoderOutputBuffer " + this.lhV + " was null");
                }
                this.frameCount++;
                if ((this.ljD.flags & 2) != 0) {
                    x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[]{Integer.valueOf(this.ljD.size), Boolean.valueOf(false)});
                }
                if (this.ljD.size != 0) {
                    if (!(this.lhZ == null || this.lhZ.bTv)) {
                        this.lhZ.c(this.lhN.getOutputFormat());
                    }
                    byteBuffer.position(this.ljD.offset);
                    byteBuffer.limit(this.ljD.offset + this.ljD.size);
                    e(byteBuffer, this.ljD);
                }
                this.lhN.releaseOutputBuffer(this.lhV, false);
                if ((this.ljD.flags & 4) != 0) {
                    if (this.bDs) {
                        x.w("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "do stop encoder");
                        try {
                            this.lhN.stop();
                            this.lhN.release();
                            this.ljA.stop();
                            this.lhN = null;
                            this.bTv = false;
                            if (this.ljH != null) {
                                this.ljH.bew();
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "do stop encoder error: %s", new Object[]{e.getMessage()});
                            return;
                        }
                    }
                    x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "reached end of stream unexpectedly");
                    return;
                }
            }
            this.lhV = this.lhN.dequeueOutputBuffer(this.ljD, 100);
            if (this.lhV <= 0) {
                x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "get outputBufferIndex %d", new Object[]{Integer.valueOf(this.lhV)});
            }
            if (this.lhV < 0 && !this.ljE) {
                return;
            }
        }
    }

    protected void e(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        if (this.lhZ != null && (bufferInfo.flags & 4) == 0) {
            this.lhZ.g(byteBuffer, bufferInfo);
        }
    }

    public final void a(a aVar) {
        this.ljH = aVar;
        this.bDs = true;
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "!!!stop, isStart!!: %s %s isEnd %s", new Object[]{Boolean.valueOf(this.bTv), this.ljH, Boolean.valueOf(this.ljA.bee())});
        if (this.ljA.bee()) {
            beG();
        }
    }

    final void beG() {
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "stopImp %s", new Object[]{bi.cjd().toString()});
        try {
            if (this.bTv) {
                ah.i(new 2(this), 500);
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "stop error: %s", new Object[]{e.getMessage()});
        }
    }

    public final long beD() {
        return System.currentTimeMillis() - this.startTime;
    }

    public void clear() {
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "clear");
        try {
            if (this.lhN != null) {
                x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "stop encoder");
                this.lhN.stop();
                this.lhN.release();
                this.lhN = null;
                this.bTv = false;
            }
            if (this.ljA != null) {
                this.ljA.stop();
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "clear error: %s", new Object[]{e.getMessage()});
        }
    }
}
