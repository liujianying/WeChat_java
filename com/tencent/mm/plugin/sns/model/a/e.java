package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.c;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends f {
    public e(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    public final boolean bza() {
        Object obj;
        long VG;
        long j = -1;
        Object obj2 = (bi.oW(this.nsN.nkR) || bi.oW(this.nsN.nkS)) ? null : 1;
        String l = obj2 != null ? this.nsN.nkS : i.l(this.caK);
        String str = this.nsN.getPath() + this.nsN.byY();
        Options options = new Options();
        options.inJustDecodeBounds = true;
        MMBitmapFactory.decodeFile(str, options, null, 0, new int[0]);
        String toLowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
        long mI = FileOp.mI(str);
        int obj3;
        if (this.ntm || toLowerCase.contains("webp")) {
            obj3 = null;
        } else if (this.ntn || toLowerCase.contains("vcodec")) {
            obj3 = 1;
        } else {
            obj3 = 2;
        }
        long bI;
        switch (obj3) {
            case null:
                h.mEJ.a(22, 64, 1, true);
                FileOp.deleteFile(this.nsN.getPath() + l);
                VG = bi.VG();
                s.e(this.nsN.getPath(), this.nsN.getPath() + this.nsN.byY(), l, false);
                bI = bi.bI(VG);
                FileOp.deleteFile(this.nsN.getPath() + this.nsN.byY());
                j = bi.bI(VG);
                c.a(this.nsN.getPath() + l, this.nsN.url, 0, options.outMimeType, options.outWidth, options.outHeight, -1, mI, bI);
                break;
            case 1:
                x.i("MicroMsg.SnsDownloadImage", "found vcodec:%s, reencoded.", new Object[]{this.nsN.getPath() + this.nsN.byY()});
                FileOp.deleteFile(this.nsN.getPath() + l);
                VG = bi.VG();
                s.e(this.nsN.getPath(), this.nsN.getPath() + this.nsN.byY(), l, false);
                bI = bi.bI(VG);
                FileOp.deleteFile(this.nsN.getPath() + this.nsN.byY());
                j = bi.bI(VG);
                c.a(this.nsN.getPath() + l, this.nsN.url, 0, options.outMimeType, options.outWidth, options.outHeight, -1, mI, bI);
                break;
            case 2:
                bI = -1;
                if (i.LO(this.nsN.getPath() + this.nsN.byY())) {
                    x.w("MicroMsg.SnsDownloadImage", "the " + this.nsN.mediaId + " is too max ! " + this.nsN.url);
                    FileOp.deleteFile(this.nsN.getPath() + l);
                    VG = bi.VG();
                    s.ad(this.nsN.getPath(), this.nsN.getPath() + this.nsN.byY(), l);
                    bI = bi.bI(VG);
                    FileOp.deleteFile(this.nsN.getPath() + this.nsN.byY());
                    j = bi.bI(VG);
                } else {
                    FileOp.i(this.nsN.getPath(), this.nsN.byY(), l);
                    j = 0;
                }
                int i = -1;
                if (toLowerCase.contains("jpg") || toLowerCase.contains("jpeg")) {
                    i = MMNativeJpeg.queryQuality(this.nsN.getPath() + l);
                    if (i == 0) {
                        i = -1;
                    }
                }
                c.a(this.nsN.getPath() + l, this.nsN.url, 0, options.outMimeType, options.outWidth, options.outHeight, i, mI, bI);
                break;
        }
        x.i("MicroMsg.SnsDownloadImage", "donwload big pic isWebp " + (obj3 == null));
        VG = FileOp.mI(this.nsN.getPath() + l);
        h.mEJ.h(11696, new Object[]{Integer.valueOf(3), Long.valueOf(j), Long.valueOf(VG), Thread.currentThread().getName(), af.byB(), com.tencent.mm.compatible.util.e.bnC});
        Object obj4 = this.nsN.nsI != 3 ? 1 : null;
        if (!(this.nsN.nkK == null || this.nsN.nkK.nkQ == 4 || this.nsN.nkK.nkQ == 5)) {
            obj4 = null;
        }
        if (obj4 != null) {
            toLowerCase = i.e(this.caK);
            if (FileOp.cn(this.nsN.getPath() + toLowerCase)) {
                FileOp.deleteFile(this.nsN.getPath() + toLowerCase);
            }
            long VG2 = bi.VG();
            s.a(this.nsN.getPath(), l, toLowerCase, (float) af.byx());
            VG2 = bi.bI(VG2);
            FileOp.mI(this.nsN.getPath() + toLowerCase);
            h.mEJ.h(11696, new Object[]{Integer.valueOf(3), Long.valueOf(VG2), Long.valueOf(VG), Thread.currentThread().getName(), af.byB(), com.tencent.mm.compatible.util.e.bnC});
            toLowerCase = i.f(this.caK);
            if (!FileOp.cn(this.nsN.getPath() + toLowerCase)) {
                s.b(this.nsN.getPath(), l, toLowerCase, (float) af.byw());
            }
        }
        return true;
    }

    protected final int bzb() {
        return 1;
    }
}
