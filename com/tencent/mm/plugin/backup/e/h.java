package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import java.util.LinkedList;

public final class h {
    public static ey a(bd bdVar, boolean z, String str, PLong pLong, LinkedList<u> linkedList, HashMap<Long, a> hashMap, boolean z2, boolean z3, long j) {
        if (bdVar.field_msgSvrId == 0) {
            x.e("MicroMsg.BackupMsgLogic", "packedMsg msgSvrId is 0, talker[%s], type[%d]", new Object[]{bdVar.field_talker, Integer.valueOf(bdVar.getType())});
            return null;
        }
        int i;
        ey eyVar;
        ey eyVar2 = new ey();
        eyVar2.rcq = bdVar.field_msgSvrId;
        if (bdVar.field_isSend == 1) {
            eyVar2.rcj = new bhz().VO(str);
            eyVar2.rck = new bhz().VO(bdVar.field_talker);
            i = 2;
            eyVar = eyVar2;
        } else {
            eyVar2.rcj = new bhz().VO(bdVar.field_talker);
            eyVar2.rck = new bhz().VO(str);
            if (z2) {
                i = 3;
                eyVar = eyVar2;
            } else {
                i = 4;
                eyVar = eyVar2;
            }
        }
        eyVar.rft = i;
        eyVar2.rfy = new bhy();
        eyVar2.rfz = 0;
        eyVar2.rfA = 0;
        eyVar2.rco = "";
        eyVar2.hcE = l.BJ(bdVar.getType());
        eyVar2.rfu = (int) (bdVar.field_createTime / 1000);
        eyVar2.rfC = bdVar.field_createTime;
        eyVar2.rfB = (int) bdVar.field_msgSeq;
        eyVar2.rfD = bdVar.field_flag;
        bhz bhz = new bhz();
        bhz.VO(bi.aG(bdVar.field_content, ""));
        eyVar2.rcl = bhz;
        l mE = c.arT().mE(l.BJ(bdVar.getType()));
        if (mE == null) {
            x.d("MicroMsg.BackupMsgLogic", "packedMsg unknow type[%d]", new Object[]{Integer.valueOf(bdVar.getType())});
            return null;
        }
        i = mE.a(eyVar2, z, bdVar, str, linkedList, hashMap, z3, j);
        if (i < 0) {
            return null;
        }
        pLong.value += (long) i;
        pLong.value += 60;
        return eyVar2;
    }
}
