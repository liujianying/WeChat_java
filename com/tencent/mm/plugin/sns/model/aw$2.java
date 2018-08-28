package com.tencent.mm.plugin.sns.model;

import android.database.Cursor;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.platformtools.x;

class aw$2 implements Runnable {
    final /* synthetic */ aw nsc;

    aw$2(aw awVar) {
        this.nsc = awVar;
    }

    public final void run() {
        n nVar = null;
        if (af.bxX()) {
            x.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
            return;
        }
        aw.b(this.nsc);
        if (af.bxX()) {
            x.e("MicroMsg.UploadManager", "is invalid after checkTLE");
            return;
        }
        o byo = af.byo();
        n nVar2 = new n();
        String str = "select *,rowid from SnsInfo  where " + o.nJx + " order by SnsInfo.rowid asc ";
        Cursor b = byo.diF.b(str, null, 2);
        x.d("MicroMsg.SnsInfoStorage", "getLastUpload " + str);
        if (b.moveToFirst()) {
            nVar2.d(b);
            b.close();
            nVar = nVar2;
        } else {
            b.close();
        }
        if (nVar == null) {
            x.d("MicroMsg.UploadManager", "All has post");
        } else if (af.byn().wq(nVar.nJc)) {
            x.d("MicroMsg.UploadManager", "checking isPosting " + nVar.nJc);
        } else {
            x.d("MicroMsg.UploadManager", "checking startPost " + nVar.bBe());
            aw.a(this.nsc, nVar);
        }
    }
}
