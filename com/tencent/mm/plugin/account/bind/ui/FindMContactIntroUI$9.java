package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.ag;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import java.util.Iterator;
import java.util.LinkedList;

class FindMContactIntroUI$9 implements e {
    final /* synthetic */ FindMContactIntroUI eHN;

    FindMContactIntroUI$9(FindMContactIntroUI findMContactIntroUI) {
        this.eHN = findMContactIntroUI;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (FindMContactIntroUI.g(this.eHN) != null) {
            FindMContactIntroUI.g(this.eHN).dismiss();
            FindMContactIntroUI.h(this.eHN);
        }
        if (FindMContactIntroUI.i(this.eHN) != null) {
            g.DF().b(431, FindMContactIntroUI.i(this.eHN));
            FindMContactIntroUI.j(this.eHN);
        }
        if (i == 0 && i2 == 0) {
            int i3;
            LinkedList XR = ((ag) lVar).XR();
            ((a) g.n(a.class)).setFriendData(XR);
            int i4;
            if (XR == null || XR.size() <= 0) {
                i4 = 0;
                i3 = 0;
            } else {
                Iterator it = XR.iterator();
                i3 = 0;
                while (it.hasNext()) {
                    arf arf = (arf) it.next();
                    if (arf != null) {
                        if (arf.hcd == 1) {
                            i4 = i3 + 1;
                        } else {
                            i4 = i3;
                        }
                        i3 = i4;
                    }
                }
                i4 = i3 > 0 ? 1 : 0;
            }
            String str2 = "MicroMsg.FindMContactIntroUI";
            String str3 = "tigerreg data size=%d, addcount=%s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(XR == null ? 0 : XR.size());
            objArr[1] = Integer.valueOf(i3);
            x.d(str2, str3, objArr);
            if (FindMContactIntroUI.d(this.eHN) == null || !FindMContactIntroUI.d(this.eHN).contains("1") || i4 == 0) {
                FindMContactIntroUI.b(this.eHN);
                return;
            }
            com.tencent.mm.plugin.c.a.pU("R300_300_phone");
            Intent intent = new Intent(this.eHN, FindMContactAddUI.class);
            intent.putExtra("regsetinfo_ticket", FindMContactIntroUI.c(this.eHN));
            intent.putExtra("regsetinfo_NextStep", FindMContactIntroUI.d(this.eHN));
            intent.putExtra("regsetinfo_NextStyle", FindMContactIntroUI.e(this.eHN));
            intent.putExtra("login_type", 0);
            MMWizardActivity.D(this.eHN, intent);
            return;
        }
        Toast.makeText(this.eHN, this.eHN.getString(j.app_err_system_busy_tip, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
    }
}
