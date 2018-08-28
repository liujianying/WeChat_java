package com.tencent.mm.plugin.websearch;

import com.tencent.mm.g.a.mv;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.e;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.plugin.websearch.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.File;
import junit.framework.Assert;

public class PluginWebSearch extends f implements b, c {
    private com.tencent.mm.sdk.b.c eOh = new 3(this);
    private com.tencent.mm.sdk.b.c gsK = new 4(this);
    private final com.tencent.mm.sdk.b.c ifc = new 1(this);
    private n oyE = new 5(this);
    private b pKu;
    private c pKv;
    private com.tencent.mm.sdk.b.c pKw = new 2(this);

    public void execute(g gVar) {
    }

    public void parallelsDependency() {
    }

    public void configure(g gVar) {
        super.configure(gVar);
        this.pKu = new b();
        com.tencent.mm.kernel.g.a(e.class, new com.tencent.mm.kernel.c.e(new a()));
        com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.websearch.api.f.class, new com.tencent.mm.kernel.c.e(this.pKu));
        if (((h) com.tencent.mm.kernel.g.Ef().DM()).ES()) {
            this.pKv = new c();
            com.tencent.mm.kernel.g.a(i.class, new com.tencent.mm.kernel.c.e(this.pKv));
        }
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        this.pKw.cht();
        this.eOh.cht();
        this.gsK.cht();
        this.ifc.cht();
        c.init();
        com.tencent.mm.sdk.f.e.post(new a(this, cVar.dqH), "CopySearchTemplateTask");
        ((o) com.tencent.mm.kernel.g.n(o.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.oyE);
    }

    public void onAccountRelease() {
        this.pKw.dead();
        this.eOh.dead();
        this.gsK.dead();
        this.ifc.dead();
        ((o) com.tencent.mm.kernel.g.n(o.class)).getSysCmdMsgExtension().b("mmsearch_reddot_new", this.oyE);
        x.pLP = null;
    }

    private void initTemplateFolder(File file, int i) {
        String zR = p.zR(i);
        if (bi.oW(zR)) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebSearch.PluginWebSearch", "initTemplateFolder outputZipFilePath nil! type:%d, ftsTemplateFolder:%s", new Object[]{Integer.valueOf(i), file.getAbsolutePath()});
            return;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, ".nomedia");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.WebSearch.PluginWebSearch", e, "create nomedia file error", new Object[0]);
            }
        }
        file2 = new File(zR);
        if (p.zQ(i)) {
            int fR = bi.fR(file2.getAbsolutePath(), file2.getParent());
            if (fR < 0) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebSearch.PluginWebSearch", "unzip fail, ret = " + fR + ", zipFilePath = " + file2.getAbsolutePath() + ", unzipPath = " + file2.getParent());
                return;
            }
            fR = p.zS(i);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebSearch.PluginWebSearch", "Unzip Path%s version=%d", new Object[]{file2.getParent(), Integer.valueOf(fR)});
            return;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebSearch.PluginWebSearch", "copy template file from asset fail %s", new Object[]{file2.getAbsolutePath()});
    }

    private void copyTemplateFile(boolean z) {
        int i;
        int[] iArr = new int[]{0, 1};
        String[] strArr = new String[2];
        for (i = 0; i < 2; i++) {
            strArr[i] = p.zT(iArr[i]);
        }
        Assert.assertEquals(2, 2);
        for (i = 0; i < 2; i++) {
            File file = new File(strArr[i]);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebSearch.PluginWebSearch", "copy to path %s, type %d", new Object[]{file.getAbsolutePath(), Integer.valueOf(iArr[i])});
            int zS = p.zS(iArr[i]);
            if (z) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebSearch.PluginWebSearch", "need update assetVersion=%d currentVersion=%d type=%d", new Object[]{Integer.valueOf(p.zN(iArr[i])), Integer.valueOf(zS), Integer.valueOf(iArr[i])});
                if (zS < p.zN(iArr[i])) {
                    com.tencent.mm.a.e.k(file);
                    initTemplateFolder(file, iArr[i]);
                }
            } else if (zS == 1 || p.bSV()) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebSearch.PluginWebSearch", "need init template");
                com.tencent.mm.a.e.k(file);
                initTemplateFolder(file, iArr[i]);
            } else {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebSearch.PluginWebSearch", "currentVersion=%d", new Object[]{Integer.valueOf(zS)});
            }
        }
        com.tencent.mm.a.e.k(new File(com.tencent.mm.compatible.util.e.bnE, "fts"));
    }

    private void initTemplateFoldByResUpdate(File file, int i) {
        String str = "";
        String str2 = "";
        switch (i) {
            case 1:
                str = p.zT(0);
                str2 = p.zR(0);
                break;
            case 2:
                str = p.zT(1);
                str2 = p.zR(1);
                break;
        }
        if (bi.oW(str) || bi.oW(str2)) {
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.WebSearch.PluginWebSearch", "initTemplateFoldByResUpdate templatePath nil! subtype:%d, resFile:%s", new Object[]{Integer.valueOf(i), file.getAbsolutePath()});
            return;
        }
        File file2 = new File(str);
        com.tencent.mm.a.e.k(file2);
        file2.mkdirs();
        File file3 = new File(file2, ".nomedia");
        if (!file3.exists()) {
            try {
                file3.createNewFile();
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.WebSearch.PluginWebSearch", e, "create nomedia file error", new Object[0]);
            }
        }
        file3 = new File(str2);
        com.tencent.mm.a.e.y(file.getAbsolutePath(), file3.getAbsolutePath());
        int fR = bi.fR(file3.getAbsolutePath(), file3.getParent());
        if (fR < 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.WebSearch.PluginWebSearch", "unzip fail, ret = " + fR + ", zipFilePath = " + file3.getAbsolutePath() + ", unzipPath = " + file3.getParent());
            return;
        }
        switch (i) {
            case 1:
                fR = p.zS(0);
                break;
            case 2:
                fR = p.zS(1);
                break;
            default:
                fR = 1;
                break;
        }
        com.tencent.mm.sdk.b.a.sFg.m(new mv());
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.WebSearch.PluginWebSearch", "Unzip Path%s version=%d", new Object[]{file3.getParent(), Integer.valueOf(fR)});
    }

    private static void reportIdKey649ForLook(int i, int i2) {
        if (i == 2) {
            ad.Ad(i2);
        }
    }

    public static boolean checkTopStoryTemplateFolderValid() {
        File file = new File(p.zT(1));
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        File file2 = new File(file, p.bSL());
        File file3 = new File(file, p.bSM());
        if (file2.exists() && file3.exists()) {
            return true;
        }
        return false;
    }
}
