package com.tencent.mm.plugin.dbbackup;

import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vfs.b;

class d$5 implements b {
    final /* synthetic */ b iaa;
    final /* synthetic */ d iam;
    int iau = 0;
    final /* synthetic */ b iav;
    final /* synthetic */ WakerLock iaw;

    d$5(d dVar, b bVar, b bVar2, WakerLock wakerLock) {
        this.iam = dVar;
        this.iav = bVar;
        this.iaa = bVar2;
        this.iaw = wakerLock;
    }

    public final void ov(int i) {
        do {
            if (this.iau > 0) {
                x.i("MicroMsg.SubCoreDBBackup", "Recovery stage %d result: %d", new Object[]{Integer.valueOf(this.iau), Integer.valueOf(i)});
            }
            if (i == 0) {
                this.iav.delete();
                h.mEJ.a(181, 29, 1, true);
                if (this.iaa != null) {
                    this.iaa.ov(i);
                }
                this.iaw.unLock();
                return;
            } else if (i == -2) {
                this.iav.delete();
                h.mEJ.a(181, 3, 1, true);
                if (this.iaa != null) {
                    this.iaa.ov(i);
                }
                this.iaw.unLock();
                return;
            } else {
                int i2 = this.iau + 1;
                this.iau = i2;
                switch (i2) {
                    case 1:
                        x.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: REPAIR", new Object[]{Integer.valueOf(this.iau)});
                        i = this.iam.b(null, this);
                        continue;
                    case 2:
                        x.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: BACKUP RECOVER", new Object[]{Integer.valueOf(this.iau)});
                        i = this.iam.a(null, this);
                        continue;
                    case 3:
                        x.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: DUMP", new Object[]{Integer.valueOf(this.iau)});
                        i = this.iam.a(this);
                        continue;
                    default:
                        this.iav.delete();
                        h.mEJ.a(181, 30, 1, true);
                        if (this.iaa != null) {
                            this.iaa.ov(i);
                        }
                        this.iaw.unLock();
                        return;
                }
            }
        } while (i != 0);
    }
}
