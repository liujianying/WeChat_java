package com.tencent.mm.plugin.voip.model;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Environment;
import android.view.Surface;
import com.tencent.mm.protocal.c.alu;
import com.tencent.mm.protocal.c.alv;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class c extends Thread {
    public static int oHJ = 64;
    private static String oHK = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/AVLog/dec264.h264");
    public static byte[] oHO = null;
    public static byte[] oHP = null;
    public static byte[] oHQ = null;
    public static int oHT = 640;
    public static int oHU = 480;
    private Surface aeJ;
    private BufferedOutputStream oHL;
    private BufferedOutputStream oHM;
    private MediaCodec oHN;
    public byte[] oHR;
    private boolean oHS;
    private boolean oHV;
    public boolean oHW;
    public boolean oHX;
    public boolean oHY;
    public int oHZ;
    j oHa;
    public byte[] oIa;
    public int oIb;
    public int oIc;
    public int oId;
    public byte[] oIe;
    public byte[] oIf;
    public byte[] oIg;

    public c(Surface surface) {
        this.oHL = null;
        this.oHM = null;
        this.oHR = null;
        this.oHS = false;
        this.oHV = false;
        this.oHW = true;
        this.oHX = true;
        this.oHY = false;
        this.oHZ = 0;
        this.oHa = null;
        this.oIa = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
        this.oIb = 0;
        this.oIc = 0;
        this.oId = 0;
        this.oIe = new byte[]{(byte) 103, (byte) 100, (byte) 0, (byte) 13, (byte) -84, (byte) -74, (byte) 10, (byte) 15, (byte) -120};
        this.oIf = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 40, (byte) -50, (byte) 60, (byte) 48};
        this.oIg = new byte[]{(byte) 13, (byte) 0, (byte) -15, (byte) 98, (byte) -22};
        this.oHW = true;
        this.oHX = true;
        this.oHN = null;
        this.oHS = false;
        this.oId = 0;
        if (surface != null) {
            this.aeJ = surface;
        }
    }

    public final void a(j jVar) {
        this.oHa = jVar;
        x.i("MeidaCodec[HWDec]", "setCallBack");
    }

    private int bJy() {
        this.oHZ++;
        x.d("MeidaCodec[HWDec]", "[HW]:DecFrmError: I Req mIReqFlag = " + this.oHY + ", mIsHWDecEnable = " + this.oHW + ", mHWErrorDecFrmCount = " + this.oHZ);
        if (!this.oHW || this.oHZ > oHJ) {
            bJz();
            this.oHa.bJU();
            this.oId |= 64;
            x.d("MeidaCodec[HWDec]", "[HW]:VTDecompressionSessionDecodeFrame: ErrFrm > threshold, end HWDec!!");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(1);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.put((byte) 1);
        this.oHa.oJX.setAppCmd(28, allocate.array(), 1);
        this.oHY = true;
        return 1;
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

    private static boolean aO(byte[] bArr) {
        byte[] bArr2 = new byte[]{(byte) 0, (byte) 0, (byte) 3};
        String aN = aN(bArr);
        String aN2 = aN(bArr2);
        x.d("MeidaCodec[HWDec]", "parent: " + aN + ", child:" + aN2);
        int indexOf = aN.indexOf(aN2, 0);
        if (indexOf == -1) {
            return false;
        }
        x.d("MeidaCodec[HWDec]", "hack code detected!!pos: " + indexOf);
        return true;
    }

    public final int Q(byte[] bArr, int i) {
        if (this.oHW) {
            int i2;
            int length;
            Object obj;
            byte[] bArr2;
            System.currentTimeMillis();
            int length2;
            if (i == 2) {
                try {
                    alv alv = (alv) new alv().aG(bArr);
                    if (alv.rOo == null) {
                        i2 = 0;
                    } else {
                        i2 = alv.rOo.lR.length;
                    }
                    length2 = alv.rOm.lR.length;
                    length = alv.rOn.lR.length;
                    if (i2 != 0) {
                        if (!this.oHS) {
                            this.oHV = false;
                        }
                        this.oHS = true;
                        oHO = new byte[(i2 + 4)];
                        oHP = new byte[(length2 + 4)];
                        oHQ = new byte[(length + 4)];
                        System.arraycopy(this.oIa, 0, oHO, 0, 4);
                        System.arraycopy(this.oIa, 0, oHP, 0, 4);
                        System.arraycopy(this.oIa, 0, oHQ, 0, 4);
                        alv.rOo.bj(oHO);
                        alv.rOm.bj(oHP);
                        alv.rOn.bj(oHQ);
                        this.oHR = new byte[((oHO.length + oHP.length) + oHQ.length)];
                        System.arraycopy(oHO, 0, this.oHR, 0, oHO.length);
                        int length3 = oHO.length + 0;
                        System.arraycopy(oHP, 0, this.oHR, length3, oHP.length);
                        System.arraycopy(oHQ, 0, this.oHR, length3 + oHP.length, oHQ.length);
                    } else {
                        if (this.oHS) {
                            this.oHV = false;
                        }
                        this.oHS = false;
                        obj = new byte[(length2 + 4)];
                        System.arraycopy(this.oIa, 0, obj, 0, 4);
                        alv.rOm.bj(obj);
                        x.d("MeidaCodec[HWDec]", " old sps: " + obj);
                        if (aO(obj)) {
                            x.i("MeidaCodec[HWDec]", " Hack code existed!! NO modify ");
                            oHP = obj;
                        } else {
                            f fVar = new f();
                            oHP = f.v(new ByteArrayInputStream(obj));
                        }
                        x.d("MeidaCodec[HWDec]", " Parsing protobuf, spsLen = " + oHP.length + ", original=" + length2);
                        oHQ = new byte[(length + 4)];
                        System.arraycopy(this.oIa, 0, oHQ, 0, 4);
                        alv.rOn.bj(oHQ);
                        this.oHR = new byte[(oHP.length + oHQ.length)];
                        System.arraycopy(oHP, 0, this.oHR, 0, oHP.length);
                        System.arraycopy(oHQ, 0, this.oHR, oHP.length + 0, oHQ.length);
                    }
                    bArr2 = null;
                    obj = 1;
                } catch (Exception e) {
                    this.oId |= 2;
                    x.e("MeidaCodec[HWDec]", " sps/pps parsing error:" + e.toString());
                    bArr2 = null;
                    obj = null;
                }
            } else {
                try {
                    Object obj2;
                    alu alu = (alu) new alu().aG(bArr);
                    length = ((Integer) alu.rOk.getFirst()).intValue();
                    i2 = 0;
                    x.d("MeidaCodec[HWDec]", " Parsing protobuf, framelen = " + length);
                    if (i == 1) {
                        i2 = this.oHR.length;
                        length2 = length + i2;
                        obj2 = new byte[length2];
                        System.arraycopy(this.oHR, 0, obj2, 0, i2);
                        i2 += 0;
                    } else {
                        obj2 = new byte[length];
                        length2 = length;
                    }
                    int i3 = 0;
                    while (true) {
                        int i4 = length;
                        ByteBuffer allocate = ByteBuffer.allocate(4);
                        alu.rOh.f(allocate.array(), i3, 0, 4);
                        allocate.order(ByteOrder.BIG_ENDIAN);
                        int i5 = allocate.getInt(0);
                        System.arraycopy(this.oIa, 0, obj2, i3 + i2, 4);
                        length = i3 + 4;
                        alu.rOh.f(obj2, length, length + i2, i5);
                        length += i5;
                        i4 -= i5 + 4;
                        i3 = "MeidaCodec[HWDec]";
                        x.d(i3, "steve: nTmpLen :" + i5 + ", framelen:" + length2 + ", naluType:" + i);
                        if (i4 <= 0) {
                            break;
                        }
                    }
                    Object bArr22 = obj2;
                    obj = null;
                } catch (Exception e2) {
                    this.oId |= 4;
                    x.e("MeidaCodec[HWDec]", " frame parsing error:" + e2.toString());
                    bArr22 = null;
                    obj = null;
                }
            }
            if (!(bArr22 == null || this.oHM == null)) {
                try {
                    this.oHM.write(bArr22, 0, bArr22.length);
                } catch (IOException e3) {
                    x.e("MeidaCodec[HWDec]", " error:" + e3.toString());
                }
            }
            if (obj != null) {
                try {
                    if (!(oHP == null || oHQ == null)) {
                        if (!this.oHV) {
                            MediaFormat createVideoFormat;
                            if (this.oHN != null) {
                                this.oHN.stop();
                                this.oHN.release();
                                this.oHN = null;
                            }
                            if (this.oHS) {
                                createVideoFormat = MediaFormat.createVideoFormat("video/hevc", oHT, oHU);
                            } else {
                                createVideoFormat = MediaFormat.createVideoFormat("video/avc", oHT, oHU);
                            }
                            createVideoFormat.setInteger("rotation-degrees", 90);
                            x.i("MeidaCodec[HWDec]", "create HW decoder, format : " + createVideoFormat);
                            String string = createVideoFormat.getString("mime");
                            if (string.startsWith("video/")) {
                                this.oHN = MediaCodec.createDecoderByType(string);
                                try {
                                    x.d("MeidaCodec[HWDec]", "configure, format : " + createVideoFormat);
                                    this.oHN.configure(createVideoFormat, this.aeJ, null, 0);
                                    this.oHN.start();
                                    this.oHV = true;
                                    start();
                                } catch (Exception e22) {
                                    this.oId |= 8;
                                    x.e("MeidaCodec[HWDec]", "codec '" + string + "' failed configuration. " + e22);
                                    this.oHW = false;
                                    bJy();
                                    return -1;
                                }
                            }
                        }
                        return 1;
                    }
                } catch (Exception e222) {
                    this.oId |= 16;
                    x.e("MeidaCodec[HWDec]", " error:" + e222.toString());
                }
            }
            if (this.oHV) {
                if (!this.oHX) {
                    this.oHX = true;
                }
                length = bArr22.length;
                i2 = bArr22[4] & 31;
                char c = (i2 == 7 || i2 == 8) ? 'S' : (i2 == 5 || i2 == 6) ? 'I' : 'P';
                x.d("MeidaCodec[HWDec]", "steve: before dequeueInputBuffer, frameLen=" + length + ", fNalType=" + i2 + ", frmType=" + c + ", mInputCnt=" + this.oIc);
                if (this.oHY && c == 'P') {
                    x.e("MeidaCodec[HWDec]", "DECODER_THREAD:: IRequest, not decodeable!");
                    return -2;
                }
                i2 = this.oHN.dequeueInputBuffer(10000);
                if (i2 < 0) {
                    if (this.oHY && c != 'P') {
                        this.oHW = false;
                        this.oId |= 32;
                    }
                    bJy();
                    x.e("MeidaCodec[HWDec]", "steve: fail to input data into mediacodec inputbuffer!!");
                } else if (bArr22 != null && length > 0) {
                    ByteBuffer byteBuffer;
                    long currentTimeMillis = System.currentTimeMillis();
                    x.d("MeidaCodec[HWDec]", "steve: (10000us)put data into inputbuffer,idx=" + i2 + ", frameLen=" + length + ", frmType=" + c + ", inputpts=" + currentTimeMillis);
                    if (VERSION.SDK_INT < 21) {
                        byteBuffer = this.oHN.getInputBuffers()[i2];
                        byteBuffer.clear();
                    } else {
                        byteBuffer = this.oHN.getInputBuffer(i2);
                    }
                    byteBuffer.clear();
                    byteBuffer.put(bArr22, 0, length);
                    this.oHN.queueInputBuffer(i2, 0, length, currentTimeMillis, 0);
                    this.oIc++;
                    this.oHZ = 0;
                    if (this.oHY) {
                        byteBuffer = ByteBuffer.allocate(1);
                        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                        byteBuffer.put((byte) 0);
                        this.oHa.oJX.setAppCmd(28, byteBuffer.array(), 1);
                        this.oHY = false;
                    }
                }
                return 0;
            }
            x.e("MeidaCodec[HWDec]", "DECODER_THREAD:: decoder not ready yet");
            return -1;
        }
        this.oId |= 1;
        x.d("TAG", "DECODER_THREAD:: HWDec NOT supported!");
        return -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"NewApi"})
    public final void run() {
        /*
        r11 = this;
        r10 = 0;
    L_0x0001:
        r0 = java.lang.Thread.interrupted();
        if (r0 != 0) goto L_0x0181;
    L_0x0007:
        r0 = r11.oHW;
        if (r0 == 0) goto L_0x0181;
    L_0x000b:
        r0 = r11.oHN;
        if (r0 == 0) goto L_0x015d;
    L_0x000f:
        r0 = r11.oHV;
        if (r0 == 0) goto L_0x015d;
    L_0x0013:
        r0 = r11.oHX;
        if (r0 == 0) goto L_0x015d;
    L_0x0017:
        r0 = new android.media.MediaCodec$BufferInfo;	 Catch:{ Exception -> 0x00c7 }
        r0.<init>();	 Catch:{ Exception -> 0x00c7 }
        r1 = r11.oHN;	 Catch:{ Exception -> 0x00c7 }
        r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r1 = r1.dequeueOutputBuffer(r0, r2);	 Catch:{ Exception -> 0x00c7 }
        r2 = "MeidaCodec[HWDec]";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c7 }
        r4 = "steve:  outIndex=";
        r3.<init>(r4);	 Catch:{ Exception -> 0x00c7 }
        r3 = r3.append(r1);	 Catch:{ Exception -> 0x00c7 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00c7 }
        com.tencent.mm.sdk.platformtools.x.d(r2, r3);	 Catch:{ Exception -> 0x00c7 }
        switch(r1) {
            case -3: goto L_0x00ef;
            case -2: goto L_0x00fa;
            case -1: goto L_0x0118;
            default: goto L_0x003d;
        };	 Catch:{ Exception -> 0x00c7 }
    L_0x003d:
        r2 = r0.size;	 Catch:{ Exception -> 0x00c7 }
        if (r2 <= 0) goto L_0x0123;
    L_0x0041:
        r2 = r0.presentationTimeUs;	 Catch:{ Exception -> 0x00c7 }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00c7 }
        r4 = r4 - r2;
        r6 = "MeidaCodec[HWDec]";
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c7 }
        r8 = "DECODER_THREAD:: decoded SUCCESSFULLY!!! cnt : ";
        r7.<init>(r8);	 Catch:{ Exception -> 0x00c7 }
        r8 = r11.oIb;	 Catch:{ Exception -> 0x00c7 }
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x00c7 }
        r8 = ", size:";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x00c7 }
        r8 = r0.size;	 Catch:{ Exception -> 0x00c7 }
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x00c7 }
        r8 = ", pts:";
        r7 = r7.append(r8);	 Catch:{ Exception -> 0x00c7 }
        r8 = r0.presentationTimeUs;	 Catch:{ Exception -> 0x00c7 }
        r0 = r7.append(r8);	 Catch:{ Exception -> 0x00c7 }
        r7 = ", latency:";
        r0 = r0.append(r7);	 Catch:{ Exception -> 0x00c7 }
        r0 = r0.append(r4);	 Catch:{ Exception -> 0x00c7 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00c7 }
        com.tencent.mm.sdk.platformtools.x.d(r6, r0);	 Catch:{ Exception -> 0x00c7 }
        r0 = r11.oIb;	 Catch:{ Exception -> 0x00c7 }
        r0 = r0 + 1;
        r11.oIb = r0;	 Catch:{ Exception -> 0x00c7 }
        r0 = r11.oHN;	 Catch:{ Exception -> 0x00c7 }
        r4 = 1;
        r0.releaseOutputBuffer(r1, r4);	 Catch:{ Exception -> 0x00c7 }
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00c7 }
        r4 = "MeidaCodec[HWDec]";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c7 }
        r6 = "steve: Avcdecoder frame processTime = ";
        r5.<init>(r6);	 Catch:{ Exception -> 0x00c7 }
        r2 = r0 - r2;
        r2 = r5.append(r2);	 Catch:{ Exception -> 0x00c7 }
        r3 = ", decFrameCnt=";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x00c7 }
        r3 = r11.oIb;	 Catch:{ Exception -> 0x00c7 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x00c7 }
        r3 = ", endTime=";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x00c7 }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x00c7 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00c7 }
        com.tencent.mm.sdk.platformtools.x.d(r4, r0);	 Catch:{ Exception -> 0x00c7 }
        goto L_0x0001;
    L_0x00c7:
        r0 = move-exception;
        r11.oHW = r10;
        r1 = r11.oId;
        r1 = r1 | 128;
        r11.oId = r1;
        r11.bJy();
        r1 = "MeidaCodec[HWDec]";
        r2 = new java.lang.StringBuilder;
        r3 = " dequeueOutputBuffer/releaseOutputBuffer error:";
        r2.<init>(r3);
        r0 = r0.toString();
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.x.e(r1, r0);
        goto L_0x0001;
    L_0x00ef:
        r0 = "MeidaCodec[HWDec]";
        r1 = "INFO_OUTPUT_BUFFERS_CHANGED";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);	 Catch:{ Exception -> 0x00c7 }
        goto L_0x0001;
    L_0x00fa:
        r0 = "MeidaCodec[HWDec]";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c7 }
        r2 = "DECODER_THREAD:: New format : ";
        r1.<init>(r2);	 Catch:{ Exception -> 0x00c7 }
        r2 = r11.oHN;	 Catch:{ Exception -> 0x00c7 }
        r2 = r2.getOutputFormat();	 Catch:{ Exception -> 0x00c7 }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x00c7 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00c7 }
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);	 Catch:{ Exception -> 0x00c7 }
        goto L_0x0001;
    L_0x0118:
        r0 = "MeidaCodec[HWDec]";
        r1 = "DECODER_THREAD:: dequeueOutputBuffer timed out!";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);	 Catch:{ Exception -> 0x00c7 }
        goto L_0x0001;
    L_0x0123:
        r2 = "MeidaCodec[HWDec]";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c7 }
        r4 = "steve: drop frame: ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x00c7 }
        r4 = r11.oIb;	 Catch:{ Exception -> 0x00c7 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00c7 }
        r4 = ", size:";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00c7 }
        r4 = r0.size;	 Catch:{ Exception -> 0x00c7 }
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00c7 }
        r4 = ", pts:";
        r3 = r3.append(r4);	 Catch:{ Exception -> 0x00c7 }
        r4 = r0.presentationTimeUs;	 Catch:{ Exception -> 0x00c7 }
        r0 = r3.append(r4);	 Catch:{ Exception -> 0x00c7 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00c7 }
        com.tencent.mm.sdk.platformtools.x.d(r2, r0);	 Catch:{ Exception -> 0x00c7 }
        r0 = r11.oHN;	 Catch:{ Exception -> 0x00c7 }
        r2 = 0;
        r0.releaseOutputBuffer(r1, r2);	 Catch:{ Exception -> 0x00c7 }
        goto L_0x0001;
    L_0x015d:
        r0 = 20;
        java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x0164 }
        goto L_0x0001;
    L_0x0164:
        r0 = move-exception;
        r1 = "MeidaCodec[HWDec]";
        r2 = new java.lang.StringBuilder;
        r3 = " error:";
        r2.<init>(r3);
        r0 = r0.toString();
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.x.e(r1, r0);
        goto L_0x0001;
    L_0x0181:
        r0 = r11.oHW;
        if (r0 != 0) goto L_0x0196;
    L_0x0185:
        r0 = r11.oHN;
        if (r0 == 0) goto L_0x0196;
    L_0x0189:
        r0 = r11.oHN;
        r0.stop();
        r0 = r11.oHN;
        r0.release();
        r0 = 0;
        r11.oHN = r0;
    L_0x0196:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.model.c.run():void");
    }

    public final void bJz() {
        this.oHW = false;
        this.oHX = false;
        this.oHZ = 0;
        x.d("MeidaCodec[HWDec]", "steve: Stop Decode Thread!");
        try {
            if (this.oHL != null) {
                this.oHL.flush();
                this.oHL.close();
            }
            if (this.oHM != null) {
                this.oHM.flush();
                this.oHM.close();
            }
        } catch (IOException e) {
            x.e("MeidaCodec[HWDec]", " error:" + e.toString());
        }
    }
}
