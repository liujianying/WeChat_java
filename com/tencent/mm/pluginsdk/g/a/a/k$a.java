package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.pluginsdk.g.a.c.f.d;
import com.tencent.mm.pluginsdk.g.a.c.q;
import com.tencent.mm.pluginsdk.g.a.d.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class k$a extends d<a> {
    protected k$a(a aVar) {
        super(aVar);
    }

    public final void run() {
        x.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decryptTask, entered", new Object[]{((a) ach()).qBy});
        a aVar = (a) ach();
        int i = aVar.bIC;
        int i2 = aVar.bID;
        int i3 = aVar.bIE;
        try {
            l lVar;
            aVar = (a) ach();
            l lVar2 = new l(aVar.bIC, aVar.bID, aVar.filePath, aVar.qBz, aVar.qBA, aVar.qBB, aVar.qBC, aVar.qBF, aVar.bIF, aVar.qBD, aVar.qBE, aVar.qBH, aVar.qBG, aVar.url, aVar.qBI, aVar.qBJ, aVar.bIE);
            if (lVar2.qCf) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecompress", new Object[]{lVar2.qBy});
                lVar2.qCH = lVar2.filePath + ".decompressed";
                lVar2.state = 32;
                if (lVar2.ccy() != null) {
                    lVar2.state = 16;
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[]{lVar2.qBy});
                }
                lVar = lVar2;
            } else if (lVar2.qCg) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), do fileDecrypt", new Object[]{lVar2.qBy});
                lVar2.qCH = lVar2.filePath + ".decrypted";
                lVar2.state = 32;
                if (lVar2.ccy() != null) {
                    lVar2.state = 16;
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[]{lVar2.qBy});
                }
                lVar = lVar2;
            } else {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), just check sum", new Object[]{lVar2.qBy});
                lVar2.qCH = lVar2.filePath;
                lVar2.state = 32;
                if (lVar2.ccy() != null) {
                    lVar2.state = 16;
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkFileExists(), file already valid", new Object[]{lVar2.qBy});
                }
                lVar = lVar2;
            }
            x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: verify(), file_state " + lVar.ccz(), new Object[]{lVar.qBy});
            if (16 != lVar.state) {
                if (lVar.qCg) {
                    lVar.qCH = lVar.filePath;
                    lVar.qCI = lVar.filePath + ".decrypted";
                    lVar.state = 1;
                } else if (lVar.qCf) {
                    lVar.qCH = lVar.filePath;
                    lVar.qCI = lVar.filePath + ".decompressed";
                    lVar.state = 2;
                } else {
                    lVar.qCH = lVar.filePath;
                    lVar.state = 4;
                }
            }
            String ccy = lVar.ccw().ccx().ccy();
            if (bi.oW(ccy)) {
                a.Tr(((a) ach()).filePath + ".decrypted");
                a.Tr(((a) ach()).filePath + ".decompressed");
                if (Thread.interrupted()) {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[]{((a) ach()).qBy});
                    a.Tr(((a) ach()).filePath);
                    a.Tr(((a) ach()).filePath + ".decrypted");
                    a.Tr(((a) ach()).filePath + ".decompressed");
                }
                q.a.ccH().handler.post(new 1(this, (a) ach()));
                return;
            }
            c.ccr().d(i, i2, ccy, i3);
            if (Thread.interrupted()) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[]{((a) ach()).qBy});
                a.Tr(((a) ach()).filePath);
                a.Tr(((a) ach()).filePath + ".decrypted");
                a.Tr(((a) ach()).filePath + ".decompressed");
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            if (Thread.interrupted()) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DecryptTask", "%s: decrypting and interrupted", new Object[]{((a) ach()).qBy});
                a.Tr(((a) ach()).filePath);
                a.Tr(((a) ach()).filePath + ".decrypted");
                a.Tr(((a) ach()).filePath + ".decompressed");
            }
        }
    }
}
