package com.tencent.mm.plugin.z;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.e.h;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.z.a.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.ez;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;

public final class c {
    public boolean lsA = false;
    public a lsB;

    public final void b(LinkedList<a> linkedList, long j) {
        e.d(new 1(this, linkedList, j), "msgSynchronizePackThread", 10).start();
    }

    public final boolean a(a aVar, String str, int i, PInt pInt, PLong pLong, long j) {
        au.HU();
        if (ab.Dk(com.tencent.mm.model.c.FR().Yg(aVar.gRG).field_verifyFlag)) {
            return true;
        }
        x.i("MicroMsg.MsgSynchronizePack", "summerbak backupChatMsg convName:%s, unReadCount:%d", new Object[]{aVar.gRG, Integer.valueOf(i)});
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        Cursor g = d.asG().asH().FT().g(aVar.gRG, b.lsx, ((i) g.l(i.class)).Gx().Gw(aVar.gRG));
        while (g.moveToNext()) {
            if (this.lsA) {
                g.close();
                return false;
            }
            bd bdVar = new bd();
            bdVar.d(g);
            if ((j >= 0 && bdVar.field_createTime >= j) || j < 0) {
                linkedList2.add(bdVar);
            }
        }
        g.close();
        int i2 = 0;
        int i3 = i;
        while (i2 < linkedList2.size()) {
            Object a;
            int i4;
            try {
                a = h.a((bd) linkedList2.get(i2), false, str, new PLong(), new LinkedList(), null, i3 > 0, true, 0);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MsgSynchronizePack", e, "backupChatMsg", new Object[0]);
                a = null;
            }
            if (a != null) {
                linkedList.add(a);
                pLong.value++;
                i4 = i3 - 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        ez ezVar = new ez();
        ezVar.hbG = linkedList;
        ezVar.hbF = linkedList.size();
        try {
            f.e(f.bfF(), "MSG_" + linkedList.size() + "_" + aVar.gRG + "_" + bi.VF(), ezVar.toByteArray());
            x.i("MicroMsg.MsgSynchronizePack", "add MsgSynchronize, tagTextClientId:%s", new Object[]{r4});
        } catch (Exception e2) {
            x.e("MicroMsg.MsgSynchronizePack", "ERROR: BakChatMsgList to Buffer list:%d :%s", new Object[]{Integer.valueOf(ezVar.hbF), e2.getMessage()});
        }
        pInt.value++;
        return true;
    }
}
