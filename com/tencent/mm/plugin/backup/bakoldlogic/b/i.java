package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bia;
import com.tencent.mm.sdk.platformtools.x;

public final class i {
    public static int a(a aVar) {
        if (aVar.gVX == null) {
            x.e("MicroMsg.BakOldPackUtil", "packBackupItem %s is null!", new Object[]{"backupItemInfo.backupitem"});
            return 0;
        }
        int cm = e.cm(aVar.filePath);
        if (cm <= 0) {
            x.e("MicroMsg.BakOldPackUtil", "packBackupItem filePath error:" + aVar.filePath);
            return 0;
        } else if (aVar.gVZ) {
            return cm;
        } else {
            if (cm < 8192 && aVar.gVX.rfy.siI == 0) {
                byte[] f;
                if (aVar.bMT != 5) {
                    f = e.f(aVar.filePath, 0, -1);
                } else if (aVar.gZe == null) {
                    x.e("MicroMsg.BakOldPackUtil", "packBackupItem BACKUPITEM_EMOJI type but emojiInfo is null!");
                    f = null;
                } else {
                    f = ((c) g.n(c.class)).getEmojiMgr().a(aVar.gZe);
                }
                bhy bq = new bhy().bq(f);
                aVar.gVX.rfz = cm;
                aVar.gVX.rfA = aVar.bMT;
                aVar.gVX.rfy = bq;
                return cm;
            } else if (aVar.gVY == null) {
                x.e("MicroMsg.BakOldPackUtil", "packBackupItem error mediaInfoList null");
                return 0;
            } else {
                String str = aVar.gVX.rcj.toString() + "_" + aVar.gVX.rck.toString() + "_" + aVar.gVX.rcq + "_backup_" + (aVar.gWa == null ? "" : aVar.gWa);
                x.d("MicroMsg.BakOldPackUtil", "packBackupItem mediaId:%s, filePath:%s", new Object[]{str, aVar.filePath});
                aVar.gVX.rfw.add(new bhz().VO(str));
                aVar.gVX.rfx.add(new bia().CS(aVar.bMT));
                aVar.gVX.rfv = aVar.gVX.rfw.size();
                if (aVar.gVU == null) {
                    aVar.gVU = new u();
                }
                aVar.gVU.hcB = aVar.gVX.rcq;
                aVar.gVU.mediaId = str;
                aVar.gVU.path = aVar.filePath;
                aVar.gVU.type = aVar.bMT;
                if (!aVar.gWb) {
                    aVar.gVY.add(aVar.gVU);
                }
                return 0;
            }
        }
    }
}
