package com.tencent.mm.plugin.sns.model.a;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.h.c;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends f {
    private boolean dBk = false;

    public i(a aVar, a aVar2) {
        super(aVar, aVar2);
        h.mEJ.a(150, 10, 1, true);
    }

    public final boolean bza() {
        if (this.nsN.nkK != null) {
            int queryQuality;
            String str;
            String e = com.tencent.mm.plugin.sns.data.i.e(this.caK);
            this.dBk = s.NB(this.nsN.getPath() + this.nsN.byY());
            if (this.ntm) {
                this.dBk = true;
            }
            if (this.dBk) {
                h.mEJ.a(22, 64, 1, true);
            }
            String str2 = this.nsN.getPath() + this.nsN.byY();
            Options options = new Options();
            options.inJustDecodeBounds = true;
            MMBitmapFactory.decodeFile(str2, options, null, 0, new int[0]);
            String toLowerCase = options.outMimeType != null ? options.outMimeType.toLowerCase() : "";
            if (options.outMimeType == null || bi.oW(options.outMimeType)) {
                h.mEJ.a(150, 35, 1, true);
            }
            if (toLowerCase.contains("jpg") || toLowerCase.contains("jpeg")) {
                queryQuality = MMNativeJpeg.queryQuality(str2);
                if (queryQuality == 0) {
                    queryQuality = -1;
                }
            } else {
                queryQuality = -1;
            }
            long mI = FileOp.mI(str2);
            if (mI <= 0) {
                h.mEJ.a(150, 23, 1, true);
            }
            long VG = bi.VG();
            String i = com.tencent.mm.plugin.sns.data.i.i(this.caK);
            FileOp.y(this.nsN.getPath() + this.nsN.byY(), this.nsN.getPath() + i);
            x.v("MicroMsg.SnsDownloadThumb", "file src" + FileOp.cn(this.nsN.getPath() + i));
            long VG2 = bi.VG();
            if (!s.a(this.nsN.getPath(), this.nsN.byY(), e, (float) af.byx())) {
                x.e("MicroMsg.SnsDownloadThumb", "decodeInfo createThumb failed");
                h.mEJ.a(150, 27, 1, true);
            }
            VG2 = bi.bI(VG2);
            boolean cn = FileOp.cn(this.nsN.getPath() + this.nsN.byY());
            FileOp.deleteFile(this.nsN.getPath() + this.nsN.byY());
            VG = bi.bI(VG);
            if (!FileOp.cn(this.nsN.getPath() + e)) {
                x.i("MicroMsg.SnsDownloadThumb", "fileExists is false %s", new Object[]{Long.valueOf(FileOp.mI(this.nsN.getPath() + e))});
                h.mEJ.a(150, 31, 1, true);
                if (cn && !FileOp.cn(this.nsN.getPath() + e)) {
                    x.i("MicroMsg.SnsDownloadThumb", "let me see Is DuplicatedApp? %s", new Object[]{Boolean.valueOf(b.lFJ.cKL())});
                    h.mEJ.a(150, 32, 1, true);
                    if (b.lFJ.cKL()) {
                        h.mEJ.a(150, 33, 1, true);
                    }
                }
            }
            h.mEJ.h(11696, new Object[]{Integer.valueOf(3), Long.valueOf(VG), Integer.valueOf(this.nth), Thread.currentThread().getName(), af.byB(), e.bnC});
            if (this.nsN.nkK.nkQ == 0 || this.nsN.nkK.nkQ == 5) {
                i = com.tencent.mm.plugin.sns.data.i.f(this.caK);
                s.b(this.nsN.getPath(), e, i, (float) af.byw());
                str = i;
            } else {
                str = e;
            }
            c.a(this.nsN.getPath() + str, this.nsN.url, 1, options.outMimeType, options.outWidth, options.outHeight, queryQuality, mI, VG2);
            this.nsM = com.tencent.mm.plugin.sns.data.i.LJ(this.nsN.getPath() + str);
            boolean b = com.tencent.mm.plugin.sns.data.i.b(this.nsM);
            x.i("MicroMsg.SnsDownloadThumb", "download decode bitmap done : succ: " + b + " isWebp: " + this.dBk + " srcImgFileSize: " + mI);
            if (!b) {
                h.mEJ.a(150, 65, 1, true);
                if (this.nto) {
                    h.mEJ.a(150, 50, 1, true);
                } else {
                    h.mEJ.a(150, 51, 1, true);
                }
                if (this.ntn) {
                    h.mEJ.a(150, 54, 1, true);
                }
                if (this.ntm) {
                    h.mEJ.a(150, 57, 1, true);
                }
            }
            if (this.dBk && !b) {
                h.mEJ.a(22, 65, 1, true);
            }
            if (this.nto && b) {
                com.tencent.mm.plugin.sns.lucky.a.b.kB(139);
            }
        }
        return true;
    }

    protected final int bzb() {
        return 3;
    }
}
