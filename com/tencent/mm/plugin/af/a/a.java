package com.tencent.mm.plugin.af.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.plugin.scanner.util.f;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qbar.QbarNative;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class a {
    Set<Integer> bXI;
    private Object dMd = new Object();
    boolean fE = false;
    private boolean fOL = false;
    private QbarNative miO = new QbarNative();
    a miP = null;
    long miQ = 0;

    public final d Kf(String str) {
        OutOfMemoryError e;
        if (str == null || str.length() <= 0) {
            x.e("MicroMsg.scanner.DecodeFile", "in decodeFile, file == null");
            return null;
        }
        d dVar;
        Options VZ = c.VZ(str);
        if (VZ != null) {
            VZ.inJustDecodeBounds = false;
            VZ.inPreferredConfig = Config.RGB_565;
            if (((long) ((VZ.outWidth * VZ.outHeight) * 8)) * 4 > 268435456) {
                x.i("MicroMsg.scanner.DecodeFile", "initial width %d, initial height %d", new Object[]{Integer.valueOf(VZ.outWidth), Integer.valueOf(VZ.outHeight)});
                VZ.inSampleSize = 4;
            }
        }
        if (this.fE) {
            dVar = null;
        } else {
            try {
                Bitmap decodeFile = c.decodeFile(str, VZ);
                if (decodeFile == null) {
                    x.e("MicroMsg.scanner.DecodeFile", "decode bitmap is null!");
                    return null;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                dVar = b(decodeFile, 3);
                l.mFT.bse();
                elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
                x.d("MicroMsg.scanner.DecodeFile", "decode once time(ms):" + elapsedRealtime);
                if (dVar == null || bi.oW(dVar.result)) {
                    if (elapsedRealtime == 0) {
                        elapsedRealtime = 1;
                    }
                    x.i("MicroMsg.scanner.DecodeFile", "max retry time: %s", new Object[]{Integer.valueOf((int) (20000 / elapsedRealtime))});
                    for (int i = 1; i < r6 && !this.fE; i++) {
                        int i2 = (i * 8) + 3;
                        if (i2 >= decodeFile.getWidth() || i2 >= decodeFile.getHeight() || System.currentTimeMillis() - this.miQ > 5000) {
                            break;
                        }
                        dVar = b(decodeFile, i2);
                        l.mFT.bse();
                        if (dVar != null && !bi.oW(dVar.result)) {
                            x.d("MicroMsg.scanner.DecodeFile", "Decode file done, i = %d, max times = %d, width = %d, height = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(r6), Integer.valueOf(decodeFile.getWidth()), Integer.valueOf(decodeFile.getHeight())});
                            break;
                        }
                    }
                }
                ll();
                try {
                    boolean z;
                    String str2 = "MicroMsg.scanner.DecodeFile";
                    String str3 = "decode result==null:%b";
                    Object[] objArr = new Object[1];
                    if (dVar == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    objArr[0] = Boolean.valueOf(z);
                    x.d(str2, str3, objArr);
                    if (!(dVar == null || bi.oW(dVar.result))) {
                        return dVar;
                    }
                } catch (OutOfMemoryError e2) {
                    e = e2;
                    x.e("MicroMsg.scanner.DecodeFile", "OutOfMemoryError, e: %s", new Object[]{e.getMessage()});
                    return dVar;
                }
            } catch (OutOfMemoryError e3) {
                e = e3;
                dVar = null;
                x.e("MicroMsg.scanner.DecodeFile", "OutOfMemoryError, e: %s", new Object[]{e.getMessage()});
                return dVar;
            }
        }
        return dVar;
    }

    private d b(Bitmap bitmap, int i) {
        f fVar = new f(bitmap, i, i);
        if (fVar.bsX() == null || fVar.width <= 0 || fVar.height <= 0) {
            return null;
        }
        return a(fVar, this.bXI);
    }

    private int h(Set<Integer> set) {
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
            x.i("MicroMsg.scanner.DecodeFile", "QBarNative.SetReaders, readers:%s", new Object[]{Arrays.toString(iArr)});
            synchronized (this.dMd) {
                i = this.miO.g(iArr, iArr.length);
            }
        }
        return i;
    }

    private boolean i(Set<Integer> set) {
        if (!(this.fOL || set == null || set.isEmpty())) {
            int E = this.miO.E(1, "ANY", "UTF-8");
            l.mFT.mGi = set.contains(Integer.valueOf(5));
            x.i("MicroMsg.scanner.DecodeFile", "QbarNative.Init = [%s], SetReaders = [%s], version = [%s]", new Object[]{Integer.valueOf(E), Integer.valueOf(h(set)), QbarNative.getVersion()});
            if (E <= 0 || r2 <= 0) {
                x.e("MicroMsg.scanner.DecodeFile", "QbarNative failed, releaseDecoder 1");
                return false;
            }
            this.fOL = true;
        }
        return this.fOL;
    }

    private void ll() {
        x.d("MicroMsg.scanner.DecodeFile", "releaseDecoder() start, hasInitQBar = %s", new Object[]{Boolean.valueOf(this.fOL)});
        synchronized (this.dMd) {
            if (this.fOL) {
                int release = this.miO.release();
                this.miO = null;
                this.fOL = false;
                x.d("MicroMsg.scanner.DecodeFile", "QbarNative.Release() = [%s]", new Object[]{Integer.valueOf(release)});
            }
        }
        com.tencent.mm.plugin.scanner.util.c.bsV();
    }

    private d a(g.a aVar, Set<Integer> set) {
        d dVar = new d();
        synchronized (this.dMd) {
            boolean z;
            if (set != null) {
                try {
                    if (!(set.isEmpty() || i(set))) {
                        ll();
                        return null;
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.scanner.DecodeFile", " Exception in directScanQRCodeImg() " + e.getMessage());
                    x.printErrStackTrace("MicroMsg.scanner.DecodeFile", e, "", new Object[0]);
                    return dVar;
                }
            }
            if (this.fOL) {
                z = this.fOL;
            } else {
                Set hashSet = new HashSet();
                hashSet.add(Integer.valueOf(2));
                hashSet.add(Integer.valueOf(0));
                hashSet.add(Integer.valueOf(3));
                hashSet.add(Integer.valueOf(5));
                z = i(hashSet);
            }
            if (z) {
                int i;
                x.d("MicroMsg.scanner.DecodeFile", "directScanQRCodeImg, lumSrc==null:%b", new Object[]{Boolean.valueOf(false)});
                if (aVar.bsX() != null) {
                    x.i("MicroMsg.scanner.DecodeFile", "directScanQRCodeImg, lumSrc.getMatrix.length: %d, lumSrc.getWidth: %d, lumSrc.getHeight: %d", new Object[]{Integer.valueOf(aVar.bsX().length), Integer.valueOf(aVar.width), Integer.valueOf(aVar.height)});
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (aVar.bsX() == null || aVar.width * aVar.height != aVar.bsX().length) {
                    i = -1;
                } else {
                    l.mFT.dn(aVar.width, aVar.height);
                    i = this.miO.u(aVar.bsX(), aVar.width, aVar.height);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                x.d("MicroMsg.scanner.DecodeFile", "directScanQRCodeImg decode ScanImage %s, cost: %s", new Object[]{Integer.valueOf(i), Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
                l.mFT.es(currentTimeMillis2 - currentTimeMillis);
                l.mFT.bsd();
                if (i != 1) {
                    return null;
                }
                String str;
                l.mFT.bsc();
                l.mFT.et(currentTimeMillis2 - currentTimeMillis);
                StringBuilder stringBuilder = new StringBuilder();
                StringBuilder stringBuilder2 = new StringBuilder();
                StringBuilder stringBuilder3 = new StringBuilder();
                StringBuilder stringBuilder4 = new StringBuilder();
                String str2 = "";
                int i2 = 0;
                int[] iArr = new int[2];
                if (this.miO.a(stringBuilder, stringBuilder2, stringBuilder3, stringBuilder4, iArr) == 1) {
                    x.d("MicroMsg.scanner.DecodeFile", "decode type:%s, sCharset: %s, sBinaryMethod: %s, data:%s, gResult:%s", new Object[]{stringBuilder.toString(), stringBuilder3.toString(), stringBuilder4.toString(), stringBuilder2.toString(), Integer.valueOf(this.miO.a(stringBuilder, stringBuilder2, stringBuilder3, stringBuilder4, iArr))});
                    if (bi.oW(stringBuilder2.toString())) {
                        str = str2;
                    } else {
                        String stringBuilder5 = stringBuilder.toString();
                        if (stringBuilder5.equals("QR_CODE") || stringBuilder5.equals("WX_CODE")) {
                            str = stringBuilder2.toString();
                        } else {
                            str = stringBuilder5 + "," + stringBuilder2;
                        }
                        dVar.mji = stringBuilder.toString();
                    }
                    int KS = p.KS(stringBuilder.toString());
                    i = iArr[0];
                    i2 = KS;
                } else {
                    i = 0;
                    str = str2;
                }
                dVar.result = str;
                dVar.mjh = this.miO.data;
                dVar.bJr = i2;
                dVar.bJs = i;
                l.mFT.a(stringBuilder.toString(), str, stringBuilder3.toString(), iArr[0], iArr[1], stringBuilder4.toString());
                return dVar;
            }
            ll();
            return null;
        }
    }
}
