package com.tencent.mm.plugin.backup.backupmoveui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.backup.c.b;

class BackupMoveChooseUI$4 implements OnClickListener {
    final /* synthetic */ BackupMoveChooseUI gVl;

    BackupMoveChooseUI$4(BackupMoveChooseUI backupMoveChooseUI) {
        this.gVl = backupMoveChooseUI;
    }

    public final void onClick(View view) {
        int i = 0;
        if (b.arv().arz().gTz) {
            a a = BackupMoveChooseUI.a(this.gVl);
            if (a.gUV.size() == a.getCount()) {
                a.gUV.clear();
                a.gUW = false;
            } else {
                while (i < a.getCount()) {
                    a.gUV.add(Integer.valueOf(i));
                    i++;
                }
                a.gUW = true;
            }
            a.notifyDataSetChanged();
            a.gUU.a(a.gUV);
        }
    }
}
