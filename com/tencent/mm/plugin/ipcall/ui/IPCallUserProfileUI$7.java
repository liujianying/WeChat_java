package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.n$d;

class IPCallUserProfileUI$7 implements n$d {
    final /* synthetic */ IPCallUserProfileUI kzx;
    final /* synthetic */ TextView kzz;

    IPCallUserProfileUI$7(IPCallUserProfileUI iPCallUserProfileUI, TextView textView) {
        this.kzx = iPCallUserProfileUI;
        this.kzz = textView;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (i == 0) {
            h.mEJ.h(12766, new Object[]{Integer.valueOf(4)});
            c.c(this.kzx, this.kzz.getText().toString());
            Toast.makeText(this.kzx, R.l.ip_call_phonenumber_pasted, 0).show();
        }
    }
}
