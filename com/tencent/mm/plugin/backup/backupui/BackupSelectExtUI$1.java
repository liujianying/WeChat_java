package com.tencent.mm.plugin.backup.backupui;

import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;
import com.tencent.mm.plugin.backup.a.g;
import java.util.Date;

class BackupSelectExtUI$1 implements OnDateSetListener {
    final /* synthetic */ BackupSelectExtUI gZa;
    final /* synthetic */ int val$id;

    BackupSelectExtUI$1(BackupSelectExtUI backupSelectExtUI, int i) {
        this.gZa = backupSelectExtUI;
        this.val$id = i;
    }

    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        StringBuffer append = new StringBuffer().append(String.format("%02d", new Object[]{Integer.valueOf(i)})).append(String.format("%02d", new Object[]{Integer.valueOf(i2 + 1)})).append(String.format("%02d", new Object[]{Integer.valueOf(i3)}));
        long wy;
        BackupSelectExtUI backupSelectExtUI;
        boolean z;
        switch (this.val$id) {
            case 1:
                wy = g.wy(append.append("000000").toString());
                BackupSelectExtUI.a(this.gZa, (wy / 1000) * 1000);
                BackupSelectExtUI.b(this.gZa).setSummary(BackupSelectExtUI.a(this.gZa).format(new Date(wy)));
                BackupSelectExtUI.c(this.gZa).notifyDataSetChanged();
                backupSelectExtUI = this.gZa;
                z = (BackupSelectExtUI.d(this.gZa) == 0 || BackupSelectExtUI.e(this.gZa) == 0) ? false : true;
                backupSelectExtUI.enableOptionMenu(z);
                return;
            case 2:
                wy = g.wy(append.append("000000").toString());
                BackupSelectExtUI.b(this.gZa, ((wy / 1000) * 1000) + 86400000);
                BackupSelectExtUI.f(this.gZa).setSummary(BackupSelectExtUI.a(this.gZa).format(new Date(wy)));
                BackupSelectExtUI.c(this.gZa).notifyDataSetChanged();
                backupSelectExtUI = this.gZa;
                z = (BackupSelectExtUI.d(this.gZa) == 0 || BackupSelectExtUI.e(this.gZa) == 0) ? false : true;
                backupSelectExtUI.enableOptionMenu(z);
                return;
            default:
                return;
        }
    }
}
