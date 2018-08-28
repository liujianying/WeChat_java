package com.tencent.mm.plugin.scanner.util;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qbar.QbarNative;
import com.tencent.rtmp.TXLiveConstants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class d extends b {
    private Object dMd = new Object();
    private QbarNative fOK = new QbarNative();
    public boolean fOL = false;
    private byte[] fOM;
    private byte[] fON;
    public volatile boolean jAi = false;
    public boolean lhy = true;
    public boolean mJI = false;
    public Set<Integer> mLj;
    public int mMN;

    /* renamed from: com.tencent.mm.plugin.scanner.util.d$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ byte[] etO;
        final /* synthetic */ Point mMO;

        public AnonymousClass1(byte[] bArr, Point point) {
            this.etO = bArr;
            this.mMO = point;
        }

        public final void run() {
            if (d.this.a(this.etO, this.mMO)) {
                ah.A(new 1(this));
            } else {
                ah.A(new Runnable() {
                    public final void run() {
                        if (d.this.mME != null) {
                            d.this.mME.bsf();
                        }
                    }
                });
            }
        }
    }

    public d(b$a b_a, int i, boolean z) {
        super(b_a);
        this.mMN = i;
        this.lhy = z;
    }

    private synchronized byte[] a(byte[] bArr, Point point, Rect rect, Point point2) {
        byte[] bArr2;
        if (bArr != null) {
            if (bArr.length > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                Rect rect2 = new Rect();
                int width;
                int height;
                if (com.tencent.mm.compatible.e.d.zf() || this.lhy) {
                    width = rect.width() % 4;
                    height = rect.height() % 4;
                    rect2.left = rect.left;
                    rect2.right = rect.right - width;
                    rect2.top = rect.top;
                    rect2.bottom = rect.bottom - height;
                    if (rect2.right <= rect2.left || rect2.bottom <= rect2.top) {
                        bArr2 = null;
                    }
                } else {
                    rect2.left = (point.x / 2) - rect.height();
                    rect2.right = (point.x / 2) + rect.height();
                    rect2.top = (point.y / 2) - (rect.width() / 2);
                    rect2.bottom = (point.y / 2) + (rect.width() / 2);
                    if (rect2.left < 0) {
                        rect2.left = 0;
                    }
                    if (rect2.right > point.x - 1) {
                        rect2.right = point.x - 1;
                    }
                    if (rect2.top < 0) {
                        rect2.top = 0;
                    }
                    if (rect2.bottom > point.y - 1) {
                        rect2.bottom = point.y - 1;
                    }
                    width = rect2.width() % 4;
                    height = rect2.height() % 4;
                    if (width != 0) {
                        rect2.right -= width;
                    }
                    if (height != 0) {
                        rect2.bottom -= height;
                    }
                    if (rect2.right <= rect2.left || rect2.bottom <= rect2.top) {
                        bArr2 = null;
                    }
                }
                c cVar = new c(bArr, point.x, point.y, rect2);
                point2.x = cVar.width;
                point2.y = cVar.height;
                int i = 0;
                if (!com.tencent.mm.compatible.e.d.zf()) {
                    i = 90;
                    point2.x = cVar.height;
                    point2.y = cVar.width;
                }
                x.d("MicroMsg.scanner.QBarDecoder", "rotate angle: " + i);
                if (this.fOM == null) {
                    this.fOM = new byte[(((cVar.width * cVar.height) * 3) / 2)];
                    this.fON = new byte[(cVar.width * cVar.height)];
                    x.d("MicroMsg.scanner.QBarDecoder", "tempOutBytes = null, new byte[%s]", new Object[]{Integer.valueOf(((cVar.width * cVar.height) * 3) / 2)});
                } else if (this.fOM.length != ((cVar.width * cVar.height) * 3) / 2) {
                    this.fOM = null;
                    this.fOM = new byte[(((cVar.width * cVar.height) * 3) / 2)];
                    this.fON = null;
                    this.fON = new byte[(cVar.width * cVar.height)];
                    x.d("MicroMsg.scanner.QBarDecoder", "tempOutBytes size change, new byte[%s]", new Object[]{Integer.valueOf(((cVar.width * cVar.height) * 3) / 2)});
                }
                if (QbarNative.a(this.fOM, new int[]{point2.x, point2.y}, bArr, point.x, point.y, cVar.left, cVar.top, cVar.width, cVar.height, i) != 1) {
                    x.e("MicroMsg.scanner.QBarDecoder", "decode pro_result %s", new Object[]{Integer.valueOf(QbarNative.a(this.fOM, new int[]{point2.x, point2.y}, bArr, point.x, point.y, cVar.left, cVar.top, cVar.width, cVar.height, i))});
                    bArr2 = null;
                } else {
                    System.arraycopy(this.fOM, 0, this.fON, 0, this.fON.length);
                    x.d("MicroMsg.scanner.QBarDecoder", "decode, rotate and gray, cost:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    bArr2 = this.fON;
                }
            }
        }
        x.w("MicroMsg.scanner.QBarDecoder", "prepareGrayData , data is null");
        bArr2 = null;
        return bArr2;
    }

    public final boolean a(byte[] bArr, Point point, Rect rect) {
        Point point2 = new Point();
        byte[] a = a(bArr, point, rect, point2);
        if (a == null || a.length <= 0) {
            return false;
        }
        return a(a, point2);
    }

    public final synchronized byte[] a(byte[] bArr, Point point, int i, Rect rect, Point point2) {
        if (TXLiveConstants.RENDER_ROTATION_LANDSCAPE == i) {
            byte[] bArr2 = new byte[bArr.length];
            QbarNative.a(bArr2, bArr, point.x, point.y);
            bArr = new byte[bArr.length];
            QbarNative.a(bArr, bArr2, point.y, point.x);
            QbarNative.nativeRelease();
        }
        return a(bArr, point, rect, point2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(byte[] r17, android.graphics.Point r18) {
        /*
        r16 = this;
        r10 = java.lang.System.currentTimeMillis();
        r2 = "MicroMsg.scanner.QBarDecoder";
        r3 = "decode() start";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r0 = r16;
        r2 = r0.jAi;
        if (r2 == 0) goto L_0x001e;
    L_0x0013:
        r2 = "MicroMsg.scanner.QBarDecoder";
        r3 = "is decoding, return false";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        r2 = 0;
    L_0x001d:
        return r2;
    L_0x001e:
        r0 = r16;
        r2 = r0.mJI;
        if (r2 == 0) goto L_0x002f;
    L_0x0024:
        r2 = "MicroMsg.scanner.QBarDecoder";
        r3 = "isReleasing, return false 1";
        com.tencent.mm.sdk.platformtools.x.w(r2, r3);
        r2 = 0;
        goto L_0x001d;
    L_0x002f:
        if (r17 != 0) goto L_0x003c;
    L_0x0031:
        r2 = "MicroMsg.scanner.QBarDecoder";
        r3 = "wrong args";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        r2 = 0;
        goto L_0x001d;
    L_0x003c:
        r0 = r16;
        r9 = r0.dMd;
        monitor-enter(r9);
        r2 = 1;
        r0 = r16;
        r0.jAi = r2;	 Catch:{ all -> 0x00d1 }
        r2 = 0;
        r0 = r16;
        r0.mMG = r2;	 Catch:{ all -> 0x00d1 }
        r2 = 0;
        r0 = r16;
        r0.bJs = r2;	 Catch:{ all -> 0x00d1 }
        r0 = r16;
        r0.bJr = r2;	 Catch:{ all -> 0x00d1 }
        r2 = com.tencent.mm.plugin.scanner.a.l.mFT;	 Catch:{ all -> 0x00d1 }
        r2.bsd();	 Catch:{ all -> 0x00d1 }
        r0 = r16;
        r2 = r0.mMN;	 Catch:{ Exception -> 0x02ef }
        r0 = r16;
        r3 = r0.fOL;	 Catch:{ Exception -> 0x02ef }
        if (r3 != 0) goto L_0x00df;
    L_0x0063:
        r2 = vD(r2);	 Catch:{ Exception -> 0x02ef }
        r0 = r16;
        r3 = r0.fOL;	 Catch:{ Exception -> 0x02ef }
        if (r3 != 0) goto L_0x00bf;
    L_0x006d:
        r3 = r2.isEmpty();	 Catch:{ Exception -> 0x02ef }
        if (r3 != 0) goto L_0x00bf;
    L_0x0073:
        r0 = r16;
        r3 = r0.fOK;	 Catch:{ Exception -> 0x02ef }
        r4 = 0;
        r5 = "ANY";
        r6 = "UTF-8";
        r3 = r3.E(r4, r5, r6);	 Catch:{ Exception -> 0x02ef }
        r4 = com.tencent.mm.plugin.scanner.a.l.mFT;	 Catch:{ Exception -> 0x02ef }
        r5 = 5;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x02ef }
        r5 = r2.contains(r5);	 Catch:{ Exception -> 0x02ef }
        r4.mGi = r5;	 Catch:{ Exception -> 0x02ef }
        r0 = r16;
        r2 = r0.h(r2);	 Catch:{ Exception -> 0x02ef }
        r4 = "MicroMsg.scanner.QBarDecoder";
        r5 = "QbarNative.Init = [%s], SetReaders = [%s], version = [%s]";
        r6 = 3;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x02ef }
        r7 = 0;
        r8 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x02ef }
        r6[r7] = r8;	 Catch:{ Exception -> 0x02ef }
        r7 = 1;
        r8 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x02ef }
        r6[r7] = r8;	 Catch:{ Exception -> 0x02ef }
        r7 = 2;
        r8 = com.tencent.qbar.QbarNative.getVersion();	 Catch:{ Exception -> 0x02ef }
        r6[r7] = r8;	 Catch:{ Exception -> 0x02ef }
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);	 Catch:{ Exception -> 0x02ef }
        if (r3 <= 0) goto L_0x00d4;
    L_0x00b8:
        if (r2 <= 0) goto L_0x00d4;
    L_0x00ba:
        r2 = 1;
        r0 = r16;
        r0.fOL = r2;	 Catch:{ Exception -> 0x02ef }
    L_0x00bf:
        r0 = r16;
        r2 = r0.fOL;	 Catch:{ Exception -> 0x02ef }
    L_0x00c3:
        if (r2 != 0) goto L_0x00e4;
    L_0x00c5:
        r16.ll();	 Catch:{ Exception -> 0x02ef }
        r2 = 0;
        r0 = r16;
        r0.jAi = r2;	 Catch:{ Exception -> 0x02ef }
        r2 = 0;
        monitor-exit(r9);	 Catch:{ all -> 0x00d1 }
        goto L_0x001d;
    L_0x00d1:
        r2 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x00d1 }
        throw r2;
    L_0x00d4:
        r2 = "MicroMsg.scanner.QBarDecoder";
        r3 = "QbarNative failed, releaseDecoder 1";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);	 Catch:{ Exception -> 0x02ef }
        r2 = 0;
        goto L_0x00c3;
    L_0x00df:
        r0 = r16;
        r2 = r0.fOL;	 Catch:{ Exception -> 0x02ef }
        goto L_0x00c3;
    L_0x00e4:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x02ef }
        r4 = "MicroMsg.scanner.QBarDecoder";
        r5 = "data len %d, image size %s";
        r6 = 2;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x02ef }
        r7 = 0;
        r0 = r17;
        r8 = r0.length;	 Catch:{ Exception -> 0x02ef }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x02ef }
        r6[r7] = r8;	 Catch:{ Exception -> 0x02ef }
        r7 = 1;
        r6[r7] = r18;	 Catch:{ Exception -> 0x02ef }
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);	 Catch:{ Exception -> 0x02ef }
        r0 = r16;
        r4 = r0.fOK;	 Catch:{ Exception -> 0x02ef }
        r0 = r18;
        r5 = r0.x;	 Catch:{ Exception -> 0x02ef }
        r0 = r18;
        r6 = r0.y;	 Catch:{ Exception -> 0x02ef }
        r0 = r17;
        r4 = r4.u(r0, r5, r6);	 Catch:{ Exception -> 0x02ef }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x02ef }
        r6 = r6 - r2;
        r0 = r16;
        r2 = r0.fOK;	 Catch:{ Exception -> 0x02ef }
        r2 = r2.cEL();	 Catch:{ Exception -> 0x02ef }
        if (r2 == 0) goto L_0x01cd;
    L_0x0122:
        r2 = 1;
    L_0x0123:
        r0 = r16;
        r3 = r0.fOK;	 Catch:{ Exception -> 0x02ef }
        r3 = r3.cEK();	 Catch:{ Exception -> 0x02ef }
        r5 = "MicroMsg.scanner.QBarDecoder";
        r8 = "after scanImage, result:%d,hasCode: %s, areaRatio: %f";
        r12 = 3;
        r12 = new java.lang.Object[r12];	 Catch:{ Exception -> 0x02ef }
        r13 = 0;
        r14 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x02ef }
        r12[r13] = r14;	 Catch:{ Exception -> 0x02ef }
        r13 = 1;
        r14 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x02ef }
        r12[r13] = r14;	 Catch:{ Exception -> 0x02ef }
        r13 = 2;
        r14 = java.lang.Float.valueOf(r3);	 Catch:{ Exception -> 0x02ef }
        r12[r13] = r14;	 Catch:{ Exception -> 0x02ef }
        com.tencent.mm.sdk.platformtools.x.i(r5, r8, r12);	 Catch:{ Exception -> 0x02ef }
        if (r4 > 0) goto L_0x018b;
    L_0x014e:
        if (r2 == 0) goto L_0x018b;
    L_0x0150:
        r0 = r16;
        r2 = r0.mME;	 Catch:{ Exception -> 0x02ef }
        if (r2 == 0) goto L_0x018b;
    L_0x0156:
        r2 = 1036831949; // 0x3dcccccd float:0.1 double:5.122630465E-315;
        r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x018b;
    L_0x015d:
        r2 = new android.os.Bundle;	 Catch:{ Exception -> 0x02ef }
        r2.<init>();	 Catch:{ Exception -> 0x02ef }
        r5 = "zoom_action";
        r8 = 6;
        r2.putInt(r5, r8);	 Catch:{ Exception -> 0x02ef }
        r5 = "zoom_type";
        r8 = 1;
        r2.putInt(r5, r8);	 Catch:{ Exception -> 0x02ef }
        r5 = "zoom_scale";
        r12 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r8 = 1036831949; // 0x3dcccccd float:0.1 double:5.122630465E-315;
        r3 = r8 / r3;
        r14 = (double) r3;	 Catch:{ Exception -> 0x02ef }
        r14 = java.lang.Math.sqrt(r14);	 Catch:{ Exception -> 0x02ef }
        r12 = r12 * r14;
        r3 = (int) r12;	 Catch:{ Exception -> 0x02ef }
        r2.putInt(r5, r3);	 Catch:{ Exception -> 0x02ef }
        r0 = r16;
        r3 = r0.mME;	 Catch:{ Exception -> 0x02ef }
        r3.E(r2);	 Catch:{ Exception -> 0x02ef }
    L_0x018b:
        r2 = com.tencent.mm.plugin.scanner.a.l.mFT;	 Catch:{ Exception -> 0x02ef }
        r0 = r18;
        r3 = r0.x;	 Catch:{ Exception -> 0x02ef }
        r0 = r18;
        r5 = r0.y;	 Catch:{ Exception -> 0x02ef }
        r2.dn(r3, r5);	 Catch:{ Exception -> 0x02ef }
        r2 = com.tencent.mm.plugin.scanner.a.l.mFT;	 Catch:{ Exception -> 0x02ef }
        r2.bse();	 Catch:{ Exception -> 0x02ef }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x02ef }
        r2 = r2 - r10;
        r5 = com.tencent.mm.plugin.scanner.a.l.mFT;	 Catch:{ Exception -> 0x02ef }
        r5.es(r6);	 Catch:{ Exception -> 0x02ef }
        r5 = "MicroMsg.scanner.QBarDecoder";
        r8 = "decode ScanImage %s, cost:%d";
        r12 = 2;
        r12 = new java.lang.Object[r12];	 Catch:{ Exception -> 0x02ef }
        r13 = 0;
        r14 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x02ef }
        r12[r13] = r14;	 Catch:{ Exception -> 0x02ef }
        r13 = 1;
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x02ef }
        r12[r13] = r2;	 Catch:{ Exception -> 0x02ef }
        com.tencent.mm.sdk.platformtools.x.d(r5, r8, r12);	 Catch:{ Exception -> 0x02ef }
        r2 = 1;
        if (r4 == r2) goto L_0x01d0;
    L_0x01c4:
        r2 = 0;
        r0 = r16;
        r0.jAi = r2;	 Catch:{ Exception -> 0x02ef }
        r2 = 0;
        monitor-exit(r9);	 Catch:{ all -> 0x00d1 }
        goto L_0x001d;
    L_0x01cd:
        r2 = 0;
        goto L_0x0123;
    L_0x01d0:
        r2 = com.tencent.mm.plugin.scanner.a.l.mFT;	 Catch:{ Exception -> 0x02ef }
        r2.bsc();	 Catch:{ Exception -> 0x02ef }
        r2 = com.tencent.mm.plugin.scanner.a.l.mFT;	 Catch:{ Exception -> 0x02ef }
        r2.et(r6);	 Catch:{ Exception -> 0x02ef }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02ef }
        r3.<init>();	 Catch:{ Exception -> 0x02ef }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02ef }
        r4.<init>();	 Catch:{ Exception -> 0x02ef }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02ef }
        r5.<init>();	 Catch:{ Exception -> 0x02ef }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02ef }
        r6.<init>();	 Catch:{ Exception -> 0x02ef }
        r2 = 2;
        r7 = new int[r2];	 Catch:{ Exception -> 0x02ef }
        r0 = r16;
        r2 = r0.fOK;	 Catch:{ Exception -> 0x02ef }
        r2 = r2.a(r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x02ef }
        r8 = 1;
        if (r2 != r8) goto L_0x0280;
    L_0x01fc:
        r8 = "MicroMsg.scanner.QBarDecoder";
        r12 = "decode type:%s, sCharset: %s, sBinaryMethod: %s, data:%s, gResult:%s";
        r13 = 5;
        r13 = new java.lang.Object[r13];	 Catch:{ Exception -> 0x02ef }
        r14 = 0;
        r15 = r3.toString();	 Catch:{ Exception -> 0x02ef }
        r13[r14] = r15;	 Catch:{ Exception -> 0x02ef }
        r14 = 1;
        r15 = r5.toString();	 Catch:{ Exception -> 0x02ef }
        r13[r14] = r15;	 Catch:{ Exception -> 0x02ef }
        r14 = 2;
        r15 = r6.toString();	 Catch:{ Exception -> 0x02ef }
        r13[r14] = r15;	 Catch:{ Exception -> 0x02ef }
        r14 = 3;
        r15 = r4.toString();	 Catch:{ Exception -> 0x02ef }
        r13[r14] = r15;	 Catch:{ Exception -> 0x02ef }
        r14 = 4;
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x02ef }
        r13[r14] = r2;	 Catch:{ Exception -> 0x02ef }
        com.tencent.mm.sdk.platformtools.x.d(r8, r12, r13);	 Catch:{ Exception -> 0x02ef }
        r2 = r4.toString();	 Catch:{ Exception -> 0x02ef }
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);	 Catch:{ Exception -> 0x02ef }
        if (r2 != 0) goto L_0x0256;
    L_0x0235:
        r2 = r3.toString();	 Catch:{ Exception -> 0x02ef }
        r8 = "QR_CODE";
        r8 = r2.equals(r8);	 Catch:{ Exception -> 0x02ef }
        if (r8 != 0) goto L_0x024b;
    L_0x0242:
        r8 = "WX_CODE";
        r8 = r2.equals(r8);	 Catch:{ Exception -> 0x02ef }
        if (r8 == 0) goto L_0x02ce;
    L_0x024b:
        r2 = r4.toString();	 Catch:{ Exception -> 0x02ef }
        r0 = r16;
        r0.mMG = r2;	 Catch:{ Exception -> 0x02ef }
        r2 = 1;
        mMH = r2;	 Catch:{ Exception -> 0x02ef }
    L_0x0256:
        r2 = r3.toString();	 Catch:{ Exception -> 0x02ef }
        r2 = com.tencent.mm.plugin.scanner.util.p.KS(r2);	 Catch:{ Exception -> 0x02ef }
        r0 = r16;
        r0.bJr = r2;	 Catch:{ Exception -> 0x02ef }
        r2 = 0;
        r2 = r7[r2];	 Catch:{ Exception -> 0x02ef }
        r0 = r16;
        r0.bJs = r2;	 Catch:{ Exception -> 0x02ef }
        r0 = r16;
        r2 = r0.fOK;	 Catch:{ Exception -> 0x02ef }
        r2 = r2.data;	 Catch:{ Exception -> 0x02ef }
        r0 = r16;
        r4 = r0.fOK;	 Catch:{ Exception -> 0x02ef }
        r4 = r4.vgD;	 Catch:{ Exception -> 0x02ef }
        r8 = 1;
        r4 = r4[r8];	 Catch:{ Exception -> 0x02ef }
        r2 = java.util.Arrays.copyOf(r2, r4);	 Catch:{ Exception -> 0x02ef }
        r0 = r16;
        r0.mjh = r2;	 Catch:{ Exception -> 0x02ef }
    L_0x0280:
        r2 = com.tencent.mm.plugin.scanner.a.l.mFT;	 Catch:{ Exception -> 0x02ef }
        r3 = r3.toString();	 Catch:{ Exception -> 0x02ef }
        r0 = r16;
        r4 = r0.mMG;	 Catch:{ Exception -> 0x02ef }
        r5 = r5.toString();	 Catch:{ Exception -> 0x02ef }
        r8 = 0;
        r12 = r7[r8];	 Catch:{ Exception -> 0x02ef }
        r8 = 1;
        r7 = r7[r8];	 Catch:{ Exception -> 0x02ef }
        r8 = r6.toString();	 Catch:{ Exception -> 0x02ef }
        r6 = r12;
        r2.a(r3, r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x02ef }
    L_0x029c:
        r2 = 0;
        r0 = r16;
        r0.jAi = r2;	 Catch:{ all -> 0x00d1 }
        r2 = "MicroMsg.scanner.QBarDecoder";
        r3 = "decode() finish, resultText = [%s], cost:%d";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00d1 }
        r5 = 0;
        r0 = r16;
        r6 = r0.mMG;	 Catch:{ all -> 0x00d1 }
        r4[r5] = r6;	 Catch:{ all -> 0x00d1 }
        r5 = 1;
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x00d1 }
        r6 = r6 - r10;
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x00d1 }
        r4[r5] = r6;	 Catch:{ all -> 0x00d1 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ all -> 0x00d1 }
        r0 = r16;
        r2 = r0.mMG;	 Catch:{ all -> 0x00d1 }
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);	 Catch:{ all -> 0x00d1 }
        if (r2 != 0) goto L_0x02fd;
    L_0x02ca:
        r2 = 1;
    L_0x02cb:
        monitor-exit(r9);	 Catch:{ all -> 0x00d1 }
        goto L_0x001d;
    L_0x02ce:
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02ef }
        r8.<init>();	 Catch:{ Exception -> 0x02ef }
        r2 = r8.append(r2);	 Catch:{ Exception -> 0x02ef }
        r8 = ",";
        r2 = r2.append(r8);	 Catch:{ Exception -> 0x02ef }
        r2 = r2.append(r4);	 Catch:{ Exception -> 0x02ef }
        r2 = r2.toString();	 Catch:{ Exception -> 0x02ef }
        r0 = r16;
        r0.mMG = r2;	 Catch:{ Exception -> 0x02ef }
        r2 = 2;
        mMH = r2;	 Catch:{ Exception -> 0x02ef }
        goto L_0x0256;
    L_0x02ef:
        r2 = move-exception;
        r3 = "MicroMsg.scanner.QBarDecoder";
        r4 = "decodeInternal error";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00d1 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r2, r4, r5);	 Catch:{ all -> 0x00d1 }
        goto L_0x029c;
    L_0x02fd:
        r2 = 0;
        goto L_0x02cb;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.util.d.a(byte[], android.graphics.Point):boolean");
    }

    public static Set<Integer> vD(int i) {
        Set<Integer> hashSet = new HashSet();
        if (i == 1) {
            hashSet.add(Integer.valueOf(2));
            hashSet.add(Integer.valueOf(3));
            hashSet.add(Integer.valueOf(4));
            hashSet.add(Integer.valueOf(5));
        } else if (i == 2) {
            hashSet.add(Integer.valueOf(0));
            hashSet.add(Integer.valueOf(3));
            hashSet.add(Integer.valueOf(4));
        } else if (i == 0) {
            hashSet.add(Integer.valueOf(2));
            hashSet.add(Integer.valueOf(0));
            hashSet.add(Integer.valueOf(3));
            hashSet.add(Integer.valueOf(4));
            hashSet.add(Integer.valueOf(5));
        } else if (i == 3) {
            hashSet.add(Integer.valueOf(2));
            hashSet.add(Integer.valueOf(5));
        }
        return hashSet;
    }

    public final int h(Set<Integer> set) {
        int i = 0;
        if (!(set == null || set.isEmpty())) {
            int[] iArr = new int[set.size()];
            int i2 = 0;
            for (Integer num : set) {
                if (num != null) {
                    int i3 = i2 + 1;
                    iArr[i2] = num.intValue();
                    i2 = i3;
                }
            }
            x.i("MicroMsg.scanner.QBarDecoder", "QBarNative.SetReaders, readers:%s", new Object[]{Arrays.toString(iArr)});
            synchronized (this.dMd) {
                if (this.fOK != null) {
                    i = this.fOK.g(iArr, iArr.length);
                }
            }
        }
        return i;
    }

    public final void ll() {
        x.d("MicroMsg.scanner.QBarDecoder", "releaseDecoder() start, hasInitQBar = %s", new Object[]{Boolean.valueOf(this.fOL)});
        this.mJI = true;
        synchronized (this.dMd) {
            if (this.fOL) {
                int release = this.fOK.release();
                this.fOK = null;
                this.fOL = false;
                x.d("MicroMsg.scanner.QBarDecoder", "QbarNative.Release() = [%s]", new Object[]{Integer.valueOf(release)});
            }
        }
        c.bsV();
    }

    public final void bsU() {
        if (this.fOL) {
            ll();
            this.fOL = false;
        }
        this.mJI = false;
        this.jAi = false;
        this.fOK = new QbarNative();
    }
}
