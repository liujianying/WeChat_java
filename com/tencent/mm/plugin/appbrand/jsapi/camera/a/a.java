package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import com.eclipsesource.v8.BuildConfig;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.b.2;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qbar.QbarNative;

public final class a extends b {
    private Object dMd = new Object();
    private QbarNative fOK;
    private volatile boolean fOL = false;
    private byte[] fOM;
    byte[] fON;
    private String type;

    public a(com.tencent.mm.plugin.appbrand.jsapi.camera.a.b.a aVar, String str) {
        super(aVar);
        this.type = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void init() {
        /*
        r11 = this;
        r10 = 3;
        r9 = 2;
        r8 = 1;
        r2 = 0;
        r0 = "MicroMsg.appbrand.ScanQBarDecoder";
        r1 = "init";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r11.type;
        r1 = r11.dMd;
        monitor-enter(r1);
        r3 = r11.fOL;	 Catch:{ all -> 0x0078 }
        if (r3 == 0) goto L_0x0021;
    L_0x0016:
        r0 = "MicroMsg.appbrand.ScanQBarDecoder";
        r2 = "the QbarDecoder is already init";
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);	 Catch:{ all -> 0x0078 }
        monitor-exit(r1);	 Catch:{ all -> 0x0078 }
    L_0x0020:
        return;
    L_0x0021:
        monitor-exit(r1);	 Catch:{ all -> 0x0078 }
        r1 = new com.tencent.qbar.QbarNative;
        r1.<init>();
        r11.fOK = r1;
        r1 = new java.util.HashSet;
        r1.<init>();
        r3 = "barcode";
        r3 = r0.contains(r3);
        if (r3 == 0) goto L_0x003e;
    L_0x0037:
        r3 = java.lang.Integer.valueOf(r2);
        r1.add(r3);
    L_0x003e:
        r3 = "qrcode";
        r0 = r0.contains(r3);
        if (r0 == 0) goto L_0x004e;
    L_0x0047:
        r0 = java.lang.Integer.valueOf(r9);
        r1.add(r0);
    L_0x004e:
        r0 = java.lang.Integer.valueOf(r10);
        r1.add(r0);
        r0 = r1.size();
        r4 = new int[r0];
        r5 = r1.iterator();
        r1 = r2;
    L_0x0060:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x007b;
    L_0x0066:
        r0 = r5.next();
        r0 = (java.lang.Integer) r0;
        if (r0 == 0) goto L_0x0060;
    L_0x006e:
        r3 = r1 + 1;
        r0 = r0.intValue();
        r4[r1] = r0;
        r1 = r3;
        goto L_0x0060;
    L_0x0078:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0078 }
        throw r0;
    L_0x007b:
        r0 = r11.fOK;
        r1 = "ANY";
        r3 = "UTF-8";
        r0 = r0.E(r2, r1, r3);
        r1 = r11.fOK;
        r3 = r4.length;
        r1 = r1.g(r4, r3);
        r3 = "MicroMsg.appbrand.ScanQBarDecoder";
        r5 = "QbarNative.Init = [%d], SetReaders = [%d], version = [%s], readers: %s";
        r6 = 4;
        r6 = new java.lang.Object[r6];
        r7 = java.lang.Integer.valueOf(r0);
        r6[r2] = r7;
        r2 = java.lang.Integer.valueOf(r1);
        r6[r8] = r2;
        r2 = com.tencent.qbar.QbarNative.getVersion();
        r6[r9] = r2;
        r2 = java.util.Arrays.toString(r4);
        r6[r10] = r2;
        com.tencent.mm.sdk.platformtools.x.i(r3, r5, r6);
        if (r0 <= 0) goto L_0x00b6;
    L_0x00b4:
        if (r1 > 0) goto L_0x00c4;
    L_0x00b6:
        r0 = "MicroMsg.appbrand.ScanQBarDecoder";
        r1 = "QbarNative failed";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r11.ll();
        goto L_0x0020;
    L_0x00c4:
        r1 = r11.dMd;
        monitor-enter(r1);
        r0 = 1;
        r11.fOL = r0;	 Catch:{ all -> 0x00cd }
        monitor-exit(r1);	 Catch:{ all -> 0x00cd }
        goto L_0x0020;
    L_0x00cd:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00cd }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.camera.a.a.init():void");
    }

    public final boolean b(byte[] bArr, int i, int i2, int i3) {
        boolean z;
        synchronized (this.dMd) {
            if (this.fOL) {
                x.d("MicroMsg.appbrand.ScanQBarDecoder", "decode start");
                int[] iArr = new int[]{i, i2};
                if (this.fOM == null) {
                    this.fOM = new byte[(((i * i2) * 3) / 2)];
                    this.fON = new byte[(i * i2)];
                    x.d("MicroMsg.appbrand.ScanQBarDecoder", "tempOutBytes = null, new byte[%s]", new Object[]{Integer.valueOf(((i * i2) * 3) / 2)});
                } else if (this.fOM.length != ((i * i2) * 3) / 2) {
                    this.fOM = null;
                    this.fOM = new byte[(((i * i2) * 3) / 2)];
                    this.fON = null;
                    this.fON = new byte[(i * i2)];
                    x.d("MicroMsg.appbrand.ScanQBarDecoder", "tempOutBytes size change, new byte[%s]", new Object[]{Integer.valueOf(((i * i2) * 3) / 2)});
                }
                x.d("MicroMsg.appbrand.ScanQBarDecoder", "onFrameData: %s, width: %s, height: %s cameraRotation:%d", new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                if (QbarNative.a(this.fOM, iArr, bArr, i, i2, 0, 0, i, i2, i3) != 1) {
                    x.e("MicroMsg.appbrand.ScanQBarDecoder", "decode isProOk %s", new Object[]{Integer.valueOf(QbarNative.a(this.fOM, iArr, bArr, i, i2, 0, 0, i, i2, i3))});
                    z = false;
                } else {
                    int u;
                    System.arraycopy(this.fOM, 0, this.fON, 0, this.fON.length);
                    if (this.fON != null) {
                        x.d("MicroMsg.appbrand.ScanQBarDecoder", "tempGrayData.len: %d, width: %d, height: %d", new Object[]{Integer.valueOf(this.fON.length), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1])});
                    }
                    if (this.fON != null) {
                        u = this.fOK.u(this.fON, iArr[0], iArr[1]);
                        boolean z2 = this.fOK.cEL() != 0;
                        float cEK = this.fOK.cEK();
                        x.i("MicroMsg.appbrand.ScanQBarDecoder", "after scanImage, result:%d,hasCode: %s, areaRatio: %f", new Object[]{Integer.valueOf(u), Boolean.valueOf(z2), Float.valueOf(cEK)});
                    } else {
                        u = -1;
                    }
                    if (u != 1) {
                        z = false;
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        StringBuilder stringBuilder2 = new StringBuilder();
                        if (this.fOK.a(stringBuilder, stringBuilder2, new StringBuilder(), new StringBuilder(), new int[2]) == 1) {
                            x.d("MicroMsg.appbrand.ScanQBarDecoder", "decode type:%s, sCharset: %s, sBinaryMethod: %s, data:%s, gResult:%s", new Object[]{stringBuilder.toString(), new StringBuilder().toString(), new StringBuilder().toString(), stringBuilder2.toString(), Integer.valueOf(this.fOK.a(stringBuilder, stringBuilder2, new StringBuilder(), new StringBuilder(), new int[2]))});
                            if (!bi.oW(stringBuilder2.toString())) {
                                String stringBuilder3 = stringBuilder.toString();
                                if (!(stringBuilder3.equals("QR_CODE") || stringBuilder3.equals("WX_CODE"))) {
                                    x.d("MicroMsg.appbrand.ScanDecoder", "result:%b, resultText:%s, resultType:%d, codeType:%d, codeVersion:%d", new Object[]{Boolean.valueOf(true), stringBuilder2.toString(), Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0)});
                                    ah.A(new 2(this, stringBuilder3));
                                    z = true;
                                }
                            }
                        }
                        z = false;
                    }
                }
            } else {
                x.e("MicroMsg.appbrand.ScanQBarDecoder", "not init");
                z = false;
            }
        }
        return z;
    }

    public final void release() {
        x.i("MicroMsg.appbrand.ScanQBarDecoder", BuildConfig.BUILD_TYPE);
        ll();
    }

    private void ll() {
        synchronized (this.dMd) {
            if (this.fOL) {
                int release = this.fOK.release();
                this.fOK = null;
                this.fOL = false;
                x.d("MicroMsg.appbrand.ScanQBarDecoder", "QbarNative.Release():%d", new Object[]{Integer.valueOf(release)});
            }
        }
    }
}
