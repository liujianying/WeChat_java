package com.tencent.mm.plugin.voip.model;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.bk.b;
import com.tencent.mm.protocal.c.alu;
import com.tencent.mm.protocal.c.alv;
import com.tencent.mm.protocal.c.alw;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;

public final class d {
    public static int oIA = 19;
    public static short[] oIJ = new short[]{(short) 128, (short) 96, (short) 240, (short) 160, (short) 320, (short) 240, (short) 480, (short) 360, (short) 640, (short) 480};
    private static final String[] oIK = new String[]{"OMX.qcom.", "OMX.Exynos.", "OMX.hisi", "OMX.MTK"};
    public static int oIN = 25;
    private static int oIs = 100;
    public static int oIu = 0;
    public static int oIz = 18;
    private static String path = Environment.getExternalStorageDirectory().getAbsolutePath();
    public String ENCODING = "hevc";
    private int giU = 12000;
    protected MediaFormat ljB;
    private BufferedOutputStream oHL;
    public byte[] oHR = null;
    j oHa = null;
    public LinkedList<alw> oIB = new LinkedList();
    public LinkedList<Integer> oIC = new LinkedList();
    f oID = null;
    public int oIE = 0;
    public int oIF = 8;
    public int oIG = 0;
    public int oIH = 0;
    a oII;
    public boolean oIL = false;
    public int oIM = 0;
    public int oIh = 0;
    MediaCodec oIi;
    int oIj;
    int oIk;
    int oIl;
    int oIm;
    int oIn = 8;
    int oIo = 1;
    int oIp;
    int oIq;
    private byte[] oIr = null;
    public long oIt = 0;
    private MediaMuxer oIv;
    private int oIw;
    private boolean oIx;
    private BufferedOutputStream oIy;

    @SuppressLint({"NewApi"})
    private static boolean b(MediaCodecInfo mediaCodecInfo, String str) {
        if (VERSION.SDK_INT < 18) {
            return false;
        }
        String name = mediaCodecInfo.getName();
        boolean z = false;
        for (String startsWith : oIK) {
            if (name.startsWith(startsWith)) {
                try {
                    for (CodecProfileLevel codecProfileLevel : mediaCodecInfo.getCapabilitiesForType(str).profileLevels) {
                        if (codecProfileLevel.profile == 8) {
                            z = true;
                        }
                        x.d("MeidaCodec[HWEnc]", "steve : [" + name + "] supported profiles:" + codecProfileLevel.profile + ", MIME:" + str);
                    }
                } catch (Exception e) {
                }
            }
        }
        return z;
    }

    private void a(MediaCodecInfo mediaCodecInfo, int i) {
        if (com.tencent.mm.compatible.util.d.fR(23)) {
            try {
                CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(this.ENCODING);
                if (capabilitiesForType != null) {
                    CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType.profileLevels;
                    if (codecProfileLevelArr != null) {
                        CodecProfileLevel codecProfileLevel = new CodecProfileLevel();
                        codecProfileLevel.level = 0;
                        codecProfileLevel.profile = 0;
                        int length = codecProfileLevelArr.length;
                        int i2 = 0;
                        while (i2 < length) {
                            CodecProfileLevel codecProfileLevel2 = codecProfileLevelArr[i2];
                            int i3 = codecProfileLevel2.profile;
                            int i4 = codecProfileLevel2.level;
                            if (i3 <= i) {
                                Object obj;
                                x.i("MeidaCodec[HWEnc]", "profile: " + i3 + ", level: " + i4);
                                switch (i3) {
                                    case 1:
                                    case 2:
                                    case 8:
                                        obj = 1;
                                        break;
                                    default:
                                        obj = null;
                                        break;
                                }
                                if (obj != null && i3 >= codecProfileLevel.profile && i4 >= codecProfileLevel.level) {
                                    codecProfileLevel.profile = i3;
                                    codecProfileLevel.level = i4;
                                }
                                i2++;
                            } else {
                                x.i("MeidaCodec[HWEnc]", "best profile: " + codecProfileLevel.profile + ", best level: " + codecProfileLevel.level);
                                if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= GLIcon.TOP) {
                                    this.ljB.setInteger("profile", codecProfileLevel.profile);
                                    this.ljB.setInteger("level", GLIcon.TOP);
                                    return;
                                }
                            }
                        }
                        x.i("MeidaCodec[HWEnc]", "best profile: " + codecProfileLevel.profile + ", best level: " + codecProfileLevel.level);
                        if (codecProfileLevel.profile > 0) {
                        }
                    }
                }
            } catch (Exception e) {
                x.e("MeidaCodec[HWEnc]", "trySetProfile error: " + e.getMessage());
            }
        }
    }

    private static boolean b(MediaCodecInfo mediaCodecInfo) {
        String name = mediaCodecInfo.getName();
        for (String startsWith : oIK) {
            if (name.startsWith(startsWith)) {
                x.d("MeidaCodec[HWEnc]", "steve : known H.264 HW encoder :" + name);
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    private int bJA() {
        MediaCodecInfo codecInfoAt;
        int i;
        int i2 = 0;
        if (this.oIi != null) {
            bJB();
        }
        String str = this.ENCODING;
        int codecCount = MediaCodecList.getCodecCount();
        loop0:
        for (int i3 = 0; i3 < codecCount; i3++) {
            codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        x.d("MeidaCodec[HWEnc]", "steve : H.264 HW encoder found:" + codecInfoAt.getName());
                        break loop0;
                    }
                }
                continue;
            }
        }
        codecInfoAt = null;
        if (codecInfoAt == null) {
            x.e("MeidaCodec[HWEnc]", "steve: Unable to find an appropriate codec for " + this.ENCODING);
            this.oIh = 2001;
            return -this.oIh;
        }
        x.i("MeidaCodec[HWEnc]", "steve: found HW codec: " + codecInfoAt.getName());
        this.ljB = MediaFormat.createVideoFormat(this.ENCODING, this.oIj, this.oIk);
        this.ljB.setInteger("color-format", 21);
        this.ljB.setInteger("bitrate", this.oIm * BaseReportManager.MAX_READ_COUNT);
        this.ljB.setInteger("frame-rate", this.oIl);
        this.ljB.setInteger("i-frame-interval", 4);
        String string = this.ljB.getString("mime");
        this.oIE = 1;
        if (this.ENCODING.equalsIgnoreCase("video/avc") && b(codecInfoAt) && com.tencent.mm.compatible.util.d.fR(23)) {
            i = (this.oIo <= 0 || (this.oIo & 1) == 0) ? 0 : 1;
            if (this.oIo > 0 && (this.oIo & 4) != 0) {
                i2 = 1;
            }
            boolean b = b(codecInfoAt, string);
            if (i2 != 0 && b) {
                this.ljB.setInteger("profile", 8);
                this.ljB.setInteger("level", GLIcon.TOP);
            } else if (i != 0) {
                this.ljB.setInteger("profile", 1);
                this.ljB.setInteger("level", GLIcon.TOP);
            } else if (codecInfoAt != null) {
                a(codecInfoAt, this.oIF);
            }
            this.oIE = this.ljB.getInteger("profile");
        }
        this.ljB.setInteger("bitrate-mode", 2);
        try {
            this.oIi = MediaCodec.createEncoderByType(string);
            x.i("MeidaCodec[HWEnc]", "steve: mediaFormat: " + this.ljB + ", actProfile: " + this.oIE);
            this.oIi.configure(this.ljB, null, null, 1);
            this.oIi.start();
            this.oID = new f();
            return 2000;
        } catch (Exception e) {
            x.e("MeidaCodec[HWEnc]", " error:" + e.toString());
            this.oIh = 2002;
            return -this.oIh;
        }
    }

    public d(int i, int i2, int i3, int i4, int i5, String str) {
        this.oIj = i;
        this.oIk = i2;
        this.oIp = i;
        this.oIq = i2;
        this.ENCODING = str;
        this.oIl = i3;
        this.oIm = i4;
        this.oIo = i5;
        oIu = 0;
        this.oIt = 0;
        this.oII = new a(this);
        this.oIi = null;
        this.oIF = 8;
        this.oIE = 0;
        this.oIG = 0;
        this.oIh = 0;
        alw alw = new alw();
        alw.rOp = 1;
        alw.rOq = 24;
        alw.rOr = 1;
        alw.rOs = 24;
        alw.rOt = 0;
        alw.rOu = 0;
        this.oIB.add(alw);
        this.oIC.add(Integer.valueOf(0));
        this.oIr = null;
        this.oIH = 0;
    }

    @SuppressLint({"NewApi"})
    private void bJB() {
        try {
            if (this.oIi != null) {
                this.oIi.stop();
                this.oIi.release();
            }
        } catch (Exception e) {
            x.e("MeidaCodec[HWEnc]", " error:" + e.toString());
        }
    }

    public final void bJz() {
        this.oIL = false;
        try {
            bJB();
            if (this.oHL != null) {
                this.oHL.flush();
                this.oHL.close();
            }
            if (this.oIy != null) {
                this.oIy.flush();
                this.oIy.close();
            }
            if (this.oIv != null) {
                this.oIv.stop();
                this.oIv.release();
            }
        } catch (Exception e) {
            x.e("MeidaCodec[HWEnc]", " error:" + e.toString());
        }
    }

    private static String aN(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                toHexString = "0" + toHexString;
            }
            str = str + toHexString;
        }
        return str;
    }

    private static ArrayList<Integer> aP(byte[] bArr) {
        byte[] bArr2 = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
        ArrayList<Integer> arrayList = new ArrayList();
        int i = 0;
        String aN = aN(bArr);
        String aN2 = aN(bArr2);
        x.d("MeidaCodec[HWEnc]", "parent: " + aN + ", child:" + aN2);
        while (true) {
            int indexOf = aN.indexOf(aN2, i);
            if (indexOf == -1) {
                return arrayList;
            }
            x.d("MeidaCodec[HWEnc]", "vps/sps/pps start: " + i + ", nextStartIdx:" + indexOf);
            i = aN2.length() + indexOf;
            arrayList.add(Integer.valueOf(indexOf / 2));
        }
    }

    public final int d(byte[] bArr, int i, int i2, int i3) {
        byte[] bArr2;
        int i4;
        int i5 = 0;
        if (!(i == this.oIp && i2 == this.oIq)) {
            this.oIp = i;
            this.oIq = i2;
        }
        if (this.oIr == null) {
            this.oIr = new byte[(((this.oIp * this.oIq) * 3) / 2)];
        }
        x.d("MeidaCodec[HWEnc]", "steve: m_framerate: " + this.oIl + ", m_br_kbps:" + this.oIm);
        if (this.oII.oIZ == (byte) 0) {
            this.oHa.oJX.videoHWProcess(bArr, bArr.length, this.oIp, this.oIq, i3, this.oIr);
            bArr2 = this.oIr;
            if (this.oIj == this.oHa.oJX.field_HWEncW && this.oIk == this.oHa.oJX.field_HWEncH) {
                i4 = 0;
            } else {
                x.d("MeidaCodec[HWEnc]", "restart encoder! clipWH:" + this.oHa.oJX.field_HWEncW + "x" + this.oHa.oJX.field_HWEncH + ", wh:" + this.oIj + "x" + this.oIk);
                this.oIj = this.oHa.oJX.field_HWEncW;
                this.oIk = this.oHa.oJX.field_HWEncH;
                this.oIM = ((this.oIj * this.oIk) * 3) >> 1;
                try {
                    i4 = bJA();
                } catch (Exception e) {
                    x.e("MeidaCodec[HWEnc]", "mediacodec init error: " + e.getMessage());
                    this.oIh = 2003;
                    i4 = -this.oIh;
                }
                if (i4 < 0) {
                    x.e("MeidaCodec[HWEnc]", "mediacodec init failed, stop HW encoding! ret: " + i4);
                    bJz();
                    return i4;
                }
            }
            if (oIu <= 100 && this.oIy != null) {
                try {
                    this.oIy.write(this.oIr, 0, this.oIM);
                    i5 = i4;
                } catch (Exception e2) {
                    x.e("MeidaCodec[HWEnc]", " error:" + e2.toString());
                }
            }
            i5 = i4;
        } else {
            bArr2 = null;
        }
        if (bArr2 == null || this.oIi == null) {
            i4 = this.oIH;
            this.oIH = i4 + 1;
            if (i4 <= 5) {
                return i5;
            }
            this.oIh = 2006;
            return -this.oIh;
        }
        try {
            ByteBuffer byteBuffer;
            this.oIH = 0;
            x.d("MeidaCodec[HWEnc]", "steve: put YUV into encoder, size:" + this.oIM + ", idx:" + oIu + ", time:" + System.currentTimeMillis());
            ByteBuffer[] inputBuffers = this.oIi.getInputBuffers();
            ByteBuffer[] outputBuffers = this.oIi.getOutputBuffers();
            int dequeueInputBuffer = this.oIi.dequeueInputBuffer(-1);
            if (dequeueInputBuffer >= 0) {
                long j = ((this.oIt * 1000000) / 15) + 132;
                byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(bArr2, 0, this.oIM);
                this.oIi.queueInputBuffer(dequeueInputBuffer, 0, this.oIM, j, 0);
                this.oIt++;
            }
            BufferInfo bufferInfo = new BufferInfo();
            dequeueInputBuffer = this.oIi.dequeueOutputBuffer(bufferInfo, (long) this.giU);
            if (dequeueInputBuffer == -2) {
                MediaFormat outputFormat = this.oIi.getOutputFormat();
                x.i("MeidaCodec[HWEnc]", "steve: encoder output format changed: " + outputFormat);
                if (outputFormat.containsKey("bitrate") && ((double) outputFormat.getInteger("bitrate")) > ((double) (this.oIm * BaseReportManager.MAX_READ_COUNT)) * 1.5d) {
                    x.e("MeidaCodec[HWEnc]", "steve: bitrate NOT match!! real:" + outputFormat.getInteger("bitrate") + ", target:" + this.oIm);
                    this.oIh = 2007;
                    return -this.oIh;
                }
            }
            i4 = i5;
            while (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer2 = outputBuffers[dequeueInputBuffer];
                Object obj = new byte[bufferInfo.size];
                byteBuffer2.get(obj);
                if (this.oHL != null) {
                    this.oHL.write(obj, 0, obj.length);
                }
                int intValue;
                if (bufferInfo.flags == 2) {
                    ArrayList aP = aP(obj);
                    alv alv = new alv();
                    i5 = 0;
                    int i6 = 0;
                    int i7 = 0;
                    int i8 = 0;
                    int i9 = 0;
                    if (aP.size() == 3 && this.ENCODING.equalsIgnoreCase("video/hevc")) {
                        intValue = ((Integer) aP.get(0)).intValue() + 4;
                        i6 = ((Integer) aP.get(1)).intValue() + 4;
                        i8 = ((Integer) aP.get(2)).intValue() + 4;
                        i5 = (i6 - intValue) - 4;
                        i7 = (i8 - i6) - 4;
                        i9 = bufferInfo.size - i8;
                        alv.rOo = b.t(obj, intValue, i5);
                        i4 = intValue;
                    } else if (aP.size() == 2) {
                        i6 = ((Integer) aP.get(0)).intValue() + 4;
                        i8 = ((Integer) aP.get(1)).intValue() + 4;
                        i7 = (i8 - i6) - 4;
                        i9 = bufferInfo.size - i8;
                        i4 = 0;
                    } else {
                        i4 = 0;
                    }
                    x.d("MeidaCodec[HWEnc]", "sps start: " + i6 + ", len:" + i7 + ", pps start:" + i8 + ", len:" + i9 + ", vps start: " + i4 + ", len:" + i5);
                    if (this.oIE == 1 || !this.oID.w(new ByteArrayInputStream(obj))) {
                        alv.rOl = 4;
                        alv.rOm = b.t(obj, i6, i7);
                        alv.rOn = b.t(obj, i8, i9);
                        s(alv.toByteArray(), bufferInfo.flags, alv.toByteArray().length);
                    } else {
                        this.oIG = this.oID.oJe;
                        this.oIF = 1;
                        x.i("MeidaCodec[HWEnc]", "steve:B-frames exist in High Profile, reset to Baseline!!!,maxAllowedProfile:" + this.oIF + ", checkCodeForBSlice:" + this.oIG);
                        try {
                            return bJA();
                        } catch (Exception e3) {
                            x.e("MeidaCodec[HWEnc]", "mediacodec reinit error: " + e3.getMessage());
                            this.oIh = 2005;
                            return -this.oIh;
                        }
                    }
                }
                if (this.oIE != 1) {
                    Object obj2;
                    f fVar = this.oID;
                    h hVar = new h(new ByteArrayInputStream(obj));
                    hVar.yq(8);
                    hVar.yq(8);
                    hVar.yq(8);
                    hVar.yq(8);
                    hVar.yq(8);
                    hVar.bJF();
                    intValue = hVar.bJE();
                    x.d("TAG", "steve:slice_type:" + intValue);
                    if (intValue == 1 || intValue == 6) {
                        fVar.oJe |= 8;
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        this.oIG = this.oID.oJe;
                        this.oIF = 1;
                        x.i("MeidaCodec[HWEnc]", "steve:B-frames exist in High Profile, reset to Baseline!!!,maxAllowedProfile:" + this.oIF + ", checkCodeForBSlice:" + this.oIG);
                        try {
                            return bJA();
                        } catch (Exception e32) {
                            x.e("MeidaCodec[HWEnc]", "mediacodec reinit error: " + e32.getMessage());
                            this.oIh = 2005;
                            return -this.oIh;
                        }
                    }
                }
                byteBuffer = ByteBuffer.allocate(4);
                byteBuffer.putInt(bufferInfo.size - 4);
                System.arraycopy(byteBuffer.order(ByteOrder.BIG_ENDIAN).array(), 0, obj, 0, 4);
                x.d("MeidaCodec[HWEnc]", " type:" + bufferInfo.flags + ", size:" + bufferInfo.size + ", idx:" + oIu + ", time:" + System.currentTimeMillis());
                alu alu = new alu();
                alu.rOh = b.t(obj, 0, bufferInfo.size);
                alu.rOi = 1;
                alu.rOj = this.oIB;
                this.oIC.set(0, Integer.valueOf(bufferInfo.size));
                alu.rOk = this.oIC;
                s(alu.toByteArray(), bufferInfo.flags, alu.toByteArray().length);
                if (this.oIx && byteBuffer2 != null) {
                    this.oIv.writeSampleData(this.oIw, byteBuffer2, bufferInfo);
                }
                i5 = bufferInfo.flags;
                oIu++;
                this.oIi.releaseOutputBuffer(dequeueInputBuffer, false);
                dequeueInputBuffer = this.oIi.dequeueOutputBuffer(bufferInfo, (long) this.giU);
                i4 = i5;
            }
            return i4;
        } catch (Exception e322) {
            x.e("MeidaCodec[HWEnc]", " error:" + e322.toString());
            this.oIh = 2004;
            return -this.oIh;
        }
    }

    @SuppressLint({"NewApi"})
    public final boolean yn(int i) {
        try {
            if (this.oIi != null) {
                Bundle bundle = new Bundle();
                int i2 = i * BaseReportManager.MAX_READ_COUNT;
                x.v("MeidaCodec[HWEnc]", "steve: setRates: " + i2);
                bundle.putInt("video-bitrate", i2);
                this.oIi.setParameters(bundle);
                return true;
            }
        } catch (Exception e) {
            x.e("MeidaCodec[HWEnc]", "steve: setRates failed:" + e);
        }
        return false;
    }

    private void s(byte[] bArr, int i, int i2) {
        if (bArr != null && this.oHa.oJX != null) {
            int i3 = oIz;
            if (this.ENCODING.equalsIgnoreCase("video/hevc")) {
                i3 = oIA;
            }
            int videoEncodeToSend = this.oHa.oJX.videoEncodeToSend(bArr, i2, this.oIj, i, i3);
            if (videoEncodeToSend > 0) {
                x.d("MeidaCodec[HWEnc]", "steve: send successfully! frameLen = " + i2 + ", type = " + i + ", pkt cnt = " + videoEncodeToSend);
            }
        }
    }
}
