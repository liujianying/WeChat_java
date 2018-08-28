package com.tencent.mm.modelvideo;

import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;

class s$2 implements Runnable {
    final /* synthetic */ s enY;
    final /* synthetic */ String enZ;
    final /* synthetic */ String eoa;
    final /* synthetic */ String eob;

    s$2(s sVar, String str, String str2, String str3) {
        this.enY = sVar;
        this.enZ = str;
        this.eoa = str2;
        this.eob = str3;
    }

    public final void run() {
        Object obj;
        Throwable e;
        long VF = bi.VF();
        int cm = e.cm(this.enZ);
        int cm2 = e.cm(this.eoa);
        x.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff now:%s size:%s,%s path:%s,%s", new Object[]{Long.valueOf(VF), Integer.valueOf(cm), Integer.valueOf(cm2), this.enZ, this.eoa});
        int i;
        if (cm2 != cm) {
            i = (cm <= 0 ? 20 : 0) + ((cm2 <= 0 ? 10 : 0) + f$k.AppCompatTheme_ratingBarStyle);
            h.mEJ.h(12696, new Object[]{Integer.valueOf(i), this.eob, "", "", Integer.valueOf(cm2)});
            x.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Err File Size diff %d,%d path:%s org:%s", new Object[]{Integer.valueOf(cm), Integer.valueOf(cm2), this.enZ, this.eoa});
            return;
        }
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        int i2;
        int i3 = 0;
        Object obj2 = null;
        try {
            fileInputStream = new FileInputStream(this.enZ);
            try {
                fileInputStream2 = new FileInputStream(this.eoa);
                try {
                    byte[] bArr = new byte[GLIcon.LEFT];
                    byte[] bArr2 = new byte[GLIcon.LEFT];
                    i2 = 0;
                    while (true) {
                        try {
                            i3 = fileInputStream.read(bArr);
                            if (i3 != fileInputStream2.read(bArr2)) {
                                obj2 = 1;
                            }
                            if (i3 == -1) {
                                obj = obj2;
                                break;
                            }
                            int i4 = 0;
                            i = i2;
                            while (i4 < i3) {
                                try {
                                    if (bArr[i4] != bArr2[i4]) {
                                        i++;
                                    }
                                    i4++;
                                } catch (Exception e2) {
                                    e = e2;
                                    i3 = i;
                                }
                            }
                            i2 = i;
                        } catch (Throwable e3) {
                            e = e3;
                            i3 = i2;
                        }
                    }
                } catch (Throwable e32) {
                    e = e32;
                    x.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Err e:%s", new Object[]{bi.i(e)});
                    obj = 1;
                    i2 = i3;
                    fileInputStream2.close();
                    fileInputStream.close();
                    if (obj == null) {
                        long bH = bi.bH(VF);
                        h.mEJ.h(12696, new Object[]{Integer.valueOf(400), this.eob, String.valueOf(i2), Long.valueOf(bH)});
                        x.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff time:%s diff:%s check:%s org:%s", new Object[]{Long.valueOf(bH), Integer.valueOf(i2), this.enZ, this.eoa});
                    }
                    x.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Read Failed! size:%s,%s path:%s,%s", new Object[]{Integer.valueOf(cm), Integer.valueOf(cm2), this.enZ, this.eoa});
                    h.mEJ.h(12696, new Object[]{Integer.valueOf(107), this.eob});
                    return;
                }
            } catch (Throwable e322) {
                e = e322;
                fileInputStream2 = null;
                x.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Err e:%s", new Object[]{bi.i(e)});
                obj = 1;
                i2 = i3;
                fileInputStream2.close();
                fileInputStream.close();
                if (obj == null) {
                    long bH2 = bi.bH(VF);
                    h.mEJ.h(12696, new Object[]{Integer.valueOf(400), this.eob, String.valueOf(i2), Long.valueOf(bH2)});
                    x.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff time:%s diff:%s check:%s org:%s", new Object[]{Long.valueOf(bH2), Integer.valueOf(i2), this.enZ, this.eoa});
                }
                x.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Read Failed! size:%s,%s path:%s,%s", new Object[]{Integer.valueOf(cm), Integer.valueOf(cm2), this.enZ, this.eoa});
                h.mEJ.h(12696, new Object[]{Integer.valueOf(107), this.eob});
                return;
            }
        } catch (Throwable e3222) {
            e = e3222;
            fileInputStream2 = null;
            fileInputStream = null;
            x.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Err e:%s", new Object[]{bi.i(e)});
            obj = 1;
            i2 = i3;
            fileInputStream2.close();
            fileInputStream.close();
            if (obj == null) {
                x.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Read Failed! size:%s,%s path:%s,%s", new Object[]{Integer.valueOf(cm), Integer.valueOf(cm2), this.enZ, this.eoa});
                h.mEJ.h(12696, new Object[]{Integer.valueOf(107), this.eob});
                return;
            }
            long bH22 = bi.bH(VF);
            h.mEJ.h(12696, new Object[]{Integer.valueOf(400), this.eob, String.valueOf(i2), Long.valueOf(bH22)});
            x.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff time:%s diff:%s check:%s org:%s", new Object[]{Long.valueOf(bH22), Integer.valueOf(i2), this.enZ, this.eoa});
        }
        try {
            fileInputStream2.close();
        } catch (Exception e4) {
        }
        try {
            fileInputStream.close();
        } catch (Exception e5) {
        }
        if (obj == null) {
            x.e("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff Read Failed! size:%s,%s path:%s,%s", new Object[]{Integer.valueOf(cm), Integer.valueOf(cm2), this.enZ, this.eoa});
            h.mEJ.h(12696, new Object[]{Integer.valueOf(107), this.eob});
            return;
        }
        long bH222 = bi.bH(VF);
        h.mEJ.h(12696, new Object[]{Integer.valueOf(400), this.eob, String.valueOf(i2), Long.valueOf(bH222)});
        x.i("MicroMsg.VideoInfoStorage", "checkVideoHashByteDiff time:%s diff:%s check:%s org:%s", new Object[]{Long.valueOf(bH222), Integer.valueOf(i2), this.enZ, this.eoa});
    }
}
