package com.tencent.mm.plugin.backup.b;

import android.database.Cursor;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.e.h;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;

public final class b {
    public boolean gRY = false;

    public interface a {
        void y(LinkedList<com.tencent.mm.plugin.backup.a.f.b> linkedList);
    }

    public final void cancel() {
        x.i("MicroMsg.BackupCalculator", "cancel. stack:%s", new Object[]{bi.cjd()});
        this.gRY = true;
    }

    public final void a(a aVar) {
        x.i("MicroMsg.BackupCalculator", "calculateChooseConversation start");
        long VF = bi.VF();
        LinkedList linkedList = new LinkedList();
        Cursor b = d.asG().asH().FW().b(s.dAN, g.arb(), "*");
        if (b.getCount() == 0) {
            if (aVar != null) {
                ah.A(new 1(this, aVar, linkedList));
            }
            x.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation!");
            b.close();
            return;
        }
        b.moveToFirst();
        x.i("MicroMsg.BackupCalculator", "calculateChooseConversation count[%d]", new Object[]{Integer.valueOf(b.getCount())});
        while (!this.gRY) {
            ai aiVar = new ai();
            aiVar.d(b);
            if (!bi.oW(aiVar.field_username)) {
                if (d.asG().asH().FT().GT(aiVar.field_username) <= 0) {
                    x.i("MicroMsg.BackupCalculator", "calculateChooseConversation empty conversation:%s", new Object[]{aiVar.field_username});
                } else {
                    au.HU();
                    if (ab.Dk(c.FR().Yg(aiVar.field_username).field_verifyFlag)) {
                        x.i("MicroMsg.BackupCalculator", "calculateChooseConversation Biz conv:%s, msgCount[%d]", new Object[]{aiVar.field_username, Integer.valueOf(r5)});
                    } else {
                        com.tencent.mm.plugin.backup.a.f.b bVar = new com.tencent.mm.plugin.backup.a.f.b();
                        bVar.gRI = aiVar.field_username;
                        bVar.gRJ = d.asG().asH().FT().GY(aiVar.field_username);
                        bVar.gRK = d.asG().asH().FT().GZ(aiVar.field_username);
                        x.i("MicroMsg.BackupCalculator", "calculateChooseConversation add conv:%s, msgCount[%d], firstMsgTime[%d], lastMsgTime[%d]", new Object[]{bVar.gRI, Integer.valueOf(r5), Long.valueOf(bVar.gRJ), Long.valueOf(bVar.gRK)});
                        linkedList.add(bVar);
                    }
                }
            }
            if (!b.moveToNext()) {
                b.close();
                if (!(this.gRY || aVar == null)) {
                    ah.A(new 2(this, aVar, linkedList));
                }
                x.i("MicroMsg.BackupCalculator", "calculateChooseConversation finish, use time[%d]", new Object[]{Long.valueOf(bi.bH(VF))});
                return;
            }
        }
        x.e("MicroMsg.BackupCalculator", "calculateChooseConversation cancel.");
        b.close();
    }

    public final boolean a(com.tencent.mm.plugin.backup.a.f.b bVar, String str, long j) {
        if (bVar == null) {
            return false;
        }
        Cursor GN = d.asG().asH().FT().GN(bVar.gRI);
        x.i("MicroMsg.BackupCalculator", "calConversation start convName:%s msgCnt:%d[cu.getCount]", new Object[]{bVar.gRI, Integer.valueOf(GN.getCount())});
        if (GN.moveToFirst()) {
            PLong pLong = new PLong();
            PLong pLong2 = new PLong();
            while (!GN.isAfterLast()) {
                if (this.gRY) {
                    x.i("MicroMsg.BackupCalculator", "calConversation cancel, return");
                    GN.close();
                    return true;
                }
                bd bdVar = new bd();
                bdVar.d(GN);
                try {
                    h.a(bdVar, true, str, pLong, null, null, false, false, j);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BackupCalculator", e, "packedMsg", new Object[0]);
                }
                pLong2.value++;
                GN.moveToNext();
            }
            bVar.gRL = pLong.value;
            bVar.gRM = pLong2.value;
            x.i("MicroMsg.BackupCalculator", "calConversation convName:%s, convDataSize:%d, convMsgCount:%d", new Object[]{bVar.gRI, Long.valueOf(bVar.gRL), Long.valueOf(bVar.gRM)});
        }
        GN.close();
        return false;
    }
}
