package com.tencent.mm.plugin.backup.backupmoveui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.c.a;
import com.tencent.mm.plugin.backup.c.a.2;
import com.tencent.mm.plugin.backup.c.b;
import com.tencent.mm.plugin.backup.c.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.LinkedList;

class BackupMoveChooseUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ BackupMoveChooseUI gVl;

    BackupMoveChooseUI$2(BackupMoveChooseUI backupMoveChooseUI) {
        this.gVl = backupMoveChooseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        LinkedList linkedList;
        PLong pLong = new PLong();
        PInt pInt = new PInt();
        a a = BackupMoveChooseUI.a(this.gVl);
        LinkedList linkedList2 = new LinkedList();
        if (a.gUV.size() <= 0) {
            linkedList = linkedList2;
        } else {
            pLong.value = 0;
            pInt.value = 0;
            LinkedList arr = b.arv().arz().arr();
            if (arr != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= a.getCount()) {
                        break;
                    }
                    if (a.gUV.contains(Integer.valueOf(i2))) {
                        linkedList2.add(arr.get(i2));
                        pLong.value += ((f.b) arr.get(i2)).gRL;
                        pInt.value = (int) (((long) pInt.value) + ((f.b) arr.get(i2)).gRM);
                    }
                    i = i2 + 1;
                }
            }
            x.i("MicroMsg.BackupMoveChooseAdapter", "finishSelected usernameSize:%d, convSize:%d, convMsgCount:%d", new Object[]{Integer.valueOf(linkedList2.size()), Long.valueOf(pLong.value), Integer.valueOf(pInt.value)});
            linkedList = linkedList2;
        }
        LinkedList x = g.x(linkedList);
        a arz = b.arv().arz();
        if (linkedList.size() == 0) {
            arz.gTy = new LinkedList();
        } else {
            arz.gTy = new LinkedList(linkedList.subList((linkedList.size() * 3) / 4, linkedList.size()));
            arz.gTy.addAll(linkedList.subList(0, (linkedList.size() * 3) / 4));
        }
        d arx = b.arv().arx();
        arx.gUu = x;
        b.arv();
        if (b.aqU().getInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0) == 1) {
            d.gUB = true;
        } else {
            d.gUB = false;
        }
        b.arv();
        arx.gUx = b.aqU().getLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
        b.arv();
        arx.gUy = b.aqU().getLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
        b.arv();
        if (b.aqU().getInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0) == 1) {
            d.gTb = true;
        } else {
            d.gTb = false;
        }
        x.i("MicroMsg.BackupMoveServer", "setBakupChooseData users size[%d], selectStartTime[%d], selectEndTime[%d], isQuickBackup[%b]", new Object[]{Integer.valueOf(x.size()), Long.valueOf(arx.gUx), Long.valueOf(arx.gUy), Boolean.valueOf(d.gTb)});
        au.HU();
        c.DT().a(aa.a.sVb, Boolean.valueOf(true));
        a arz2 = b.arv().arz();
        if (arz2.gTt != null) {
            arz2.gTt.cancel();
        }
        e.post(new 2(arz2), "BakMoveChooseServer.calculateChooseConvSize");
        if (BackupMoveChooseUI.a(this.gVl).gUW) {
            h.mEJ.a(485, 22, 1, false);
            h.mEJ.h(11788, new Object[]{Integer.valueOf(4)});
        }
        if (BackupMoveChooseUI.KD() == 1 && BackupMoveChooseUI.uw() == 1) {
            h.mEJ.a(485, 26, 1, false);
            h.mEJ.a(485, 27, 1, false);
            h.mEJ.h(11788, new Object[]{Integer.valueOf(7)});
        } else if (BackupMoveChooseUI.KD() == 1) {
            h.mEJ.a(485, 26, 1, false);
            h.mEJ.h(11788, new Object[]{Integer.valueOf(5)});
        } else if (BackupMoveChooseUI.uw() == 1) {
            h.mEJ.a(485, 27, 1, false);
            h.mEJ.h(11788, new Object[]{Integer.valueOf(6)});
        }
        h.mEJ.h(11788, new Object[]{Integer.valueOf(8)});
        MMWizardActivity.D(this.gVl, new Intent(this.gVl, BackupMoveQRCodeUI.class));
        h.mEJ.a(485, 23, 1, false);
        return true;
    }
}
