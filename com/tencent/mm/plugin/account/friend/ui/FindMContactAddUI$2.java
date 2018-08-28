package com.tencent.mm.plugin.account.friend.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMWizardActivity;

class FindMContactAddUI$2 implements e {
    final /* synthetic */ FindMContactAddUI eLW;

    FindMContactAddUI$2(FindMContactAddUI findMContactAddUI) {
        this.eLW = findMContactAddUI;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (FindMContactAddUI.a(this.eLW) != null) {
            FindMContactAddUI.a(this.eLW).dismiss();
            FindMContactAddUI.b(this.eLW);
        }
        if (FindMContactAddUI.o(this.eLW) != null) {
            g.DF().b(30, FindMContactAddUI.o(this.eLW));
            FindMContactAddUI.p(this.eLW);
        }
        if (i == 4 && i2 == -24 && !bi.oW(str)) {
            Toast.makeText(this.eLW.mController.tml, str, 1).show();
        } else if (FindMContactAddUI.k(this.eLW) == null || !FindMContactAddUI.k(this.eLW).contains("2")) {
            FindMContactAddUI.n(this.eLW);
        } else {
            Intent intent = new Intent(this.eLW, FindMContactInviteUI.class);
            intent.putExtra("regsetinfo_ticket", FindMContactAddUI.l(this.eLW));
            intent.putExtra("login_type", FindMContactAddUI.m(this.eLW));
            intent.putExtra("regsetinfo_NextStyle", FindMContactAddUI.e(this.eLW));
            MMWizardActivity.D(this.eLW, intent);
        }
    }
}
