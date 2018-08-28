package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.plugin.report.service.h;

class IPCallUserProfileUI$2 implements OnClickListener {
    final /* synthetic */ IPCallUserProfileUI kzx;

    IPCallUserProfileUI$2(IPCallUserProfileUI iPCallUserProfileUI) {
        this.kzx = iPCallUserProfileUI;
    }

    public final void onClick(View view) {
        h.mEJ.h(12766, new Object[]{Integer.valueOf(4)});
        c.c(this.kzx, IPCallUserProfileUI.f(this.kzx));
        Toast.makeText(this.kzx, R.l.ip_call_phonenumber_pasted, 0).show();
    }
}
