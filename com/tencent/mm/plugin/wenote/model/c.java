package com.tencent.mm.plugin.wenote.model;

import com.tencent.mm.a.e;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.wenote.a.a;
import com.tencent.mm.plugin.wenote.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

public final class c implements ar {
    private static HashMap<Integer, d> cVM = new HashMap();
    private com.tencent.mm.sdk.b.c bannerOnInitListener = new 1(this);
    private com.tencent.mm.plugin.wenote.a.c qnA = new com.tencent.mm.plugin.wenote.a.c();
    private a qnB = new a();
    public d qnC = null;
    private b qnz = new b();

    public static c bZb() {
        au.HN();
        c cVar = (c) bs.iK("plugin.wenote");
        if (cVar != null) {
            return cVar;
        }
        cVar = new c();
        au.HN().a("plugin.wenote", cVar);
        return cVar;
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        InputStream open;
        x.d("MicroMsg.SubCoreWNNoteMsg", "on account post reset");
        com.tencent.mm.sdk.b.a.sFg.b(this.qnz);
        ((com.tencent.mm.plugin.record.a.a) g.n(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this.qnA);
        ((ae) g.n(ae.class)).getFavCdnStorage().a(this.qnA);
        com.tencent.mm.sdk.b.a.sFg.b(this.qnB);
        com.tencent.mm.sdk.b.a.sFg.b(this.bannerOnInitListener);
        File file = new File(i.Go());
        if (!(file.exists() && file.isDirectory())) {
            x.d("MicroMsg.SubCoreWNNoteMsg", "record stg dir[%s] not exsit, create it");
            file.mkdirs();
        }
        File file2 = new File(an.aLQ());
        x.i("MicroMsg.SubCoreWNNoteMsg", "copy to path %s", new Object[]{file2.getAbsolutePath()});
        if (com.tencent.mm.protocal.d.qVQ || com.tencent.mm.protocal.d.qVR) {
            x.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile develop version delete template");
            e.k(file2);
        } else {
            an.iXk = an.Oe();
            if (z) {
                x.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need update assetVersion=%d currentVersion=%d", new Object[]{Integer.valueOf(an.Of()), Integer.valueOf(an.iXk)});
                if (an.iXk < an.Of()) {
                    e.k(file2);
                }
            } else if (an.iXk == 1) {
                x.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need init template");
                e.k(file2);
            } else {
                x.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile currentVersion=%d", new Object[]{Integer.valueOf(an.iXk)});
            }
        }
        if (!file2.exists()) {
            file2.mkdirs();
        }
        try {
            open = ad.getContext().getAssets().open("WNNote.zip");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", e, "", new Object[0]);
            open = null;
        }
        if (open == null) {
            x.e("MicroMsg.SubCoreWNNoteMsg", "file inputStream not found");
            return;
        }
        File file3 = new File(file2, "WNNote.zip");
        if (file3.exists()) {
            x.i("MicroMsg.SubCoreWNNoteMsg", "wenote template already exists");
            e.f(open);
            return;
        }
        OutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file3);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", e2, "", new Object[0]);
            fileOutputStream = null;
        }
        if (fileOutputStream != null) {
            try {
                e(open, fileOutputStream);
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", e3, "", new Object[0]);
            }
        }
        e.f(open);
        e.closeOutputStream(fileOutputStream);
        int fR = bi.fR(file3.getAbsolutePath(), file3.getParent());
        if (fR < 0) {
            x.e("MicroMsg.SubCoreWNNoteMsg", "unzip fail, ret = " + fR + ", zipFilePath = " + file3.getAbsolutePath() + ", unzipPath = " + file3.getParent());
        }
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        x.d("MicroMsg.SubCoreWNNoteMsg", "on account post release");
        com.tencent.mm.sdk.b.a.sFg.c(this.qnz);
        if (((com.tencent.mm.plugin.record.a.a) g.n(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage() != null) {
            ((com.tencent.mm.plugin.record.a.a) g.n(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this.qnA);
        }
        if (((ae) g.n(ae.class)).getFavCdnStorage() != null) {
            ((ae) g.n(ae.class)).getFavCdnStorage().b(this.qnA);
        }
        com.tencent.mm.sdk.b.a.sFg.c(this.qnB);
        com.tencent.mm.sdk.b.a.sFg.c(this.bannerOnInitListener);
    }

    private static void e(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }
}
