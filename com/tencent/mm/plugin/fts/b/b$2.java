package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.g.a.bc;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.fts.b.b.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class b$2 extends c<bc> {
    final /* synthetic */ b jum;

    b$2(b bVar) {
        this.jum = bVar;
        this.sFo = bc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bc bcVar = (bc) bVar;
        if (bcVar.bIB.bIC == 35 && bcVar.bIB.bID == 1) {
            x.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "CheckResUpdateCacheFileEvent: %s", new Object[]{bcVar.bIB.filePath});
            b bVar2 = this.jum;
            String str = bcVar.bIB.filePath;
            File file = new File(b.aQk(), "temp");
            if (file.exists()) {
                FileOp.I(file.getAbsolutePath(), false);
            }
            file.mkdirs();
            x.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "unzip %s %d", new Object[]{str, Integer.valueOf(bi.fR(str, file.getAbsolutePath()))});
            if (bi.fR(str, file.getAbsolutePath()) >= 0) {
                File aQl = b.aQl();
                File file2 = new File(file, "fts_feature");
                x.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "updateFeatureList: updateVersion %d currentVersion %d", new Object[]{Integer.valueOf(b.K(file2)), Integer.valueOf(b.K(aQl))});
                if (b.K(file2) > b.K(aQl)) {
                    FileOp.I(aQl.getAbsolutePath(), false);
                    file2.renameTo(aQl);
                    bVar2.dhW.a(65596, new d(bVar2, aQl.getAbsolutePath()));
                }
            }
        }
        return true;
    }
}
