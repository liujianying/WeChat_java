package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bia;
import com.tencent.mm.sdk.platformtools.x;

public final class i {
    public static int a(a aVar) {
        if (aVar.gVX == null) {
            x.e("MicroMsg.BackupPackUtil", "packBackupItem %s is null!", new Object[]{"backupItemInfo.backupitem"});
            return 0;
        }
        int cm = e.cm(aVar.filePath);
        if (cm <= 0) {
            x.e("MicroMsg.BackupPackUtil", "packBackupItem filePath error:" + aVar.filePath);
            return 0;
        } else if (aVar.gVZ) {
            return cm;
        } else {
            if (aVar.gVY == null) {
                x.e("MicroMsg.BackupPackUtil", "packBackupItem error mediaInfoList null");
                return 0;
            }
            String str = aVar.gVX.rcj.toString() + "_" + aVar.gVX.rck.toString() + "_" + aVar.gVX.rcq + "_backup_" + (aVar.gWa == null ? "" : aVar.gWa);
            x.d("MicroMsg.BackupPackUtil", "packBackupItem mediaId:%s, filePath:%s", new Object[]{str, aVar.filePath});
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
