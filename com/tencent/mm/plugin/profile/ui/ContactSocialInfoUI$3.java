package com.tencent.mm.plugin.profile.ui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.aa.g;
import com.tencent.mm.aa.g.b;
import com.tencent.mm.aa.q;
import com.tencent.mm.sdk.platformtools.x;

class ContactSocialInfoUI$3 implements b {
    final /* synthetic */ g dGE;
    final /* synthetic */ String dhF;
    final /* synthetic */ ContactSocialInfoUI lVD;
    final /* synthetic */ String lVF;

    ContactSocialInfoUI$3(ContactSocialInfoUI contactSocialInfoUI, g gVar, String str, String str2) {
        this.lVD = contactSocialInfoUI;
        this.dGE = gVar;
        this.dhF = str;
        this.lVF = str2;
    }

    public final int bd(int i, int i2) {
        this.dGE.Ku();
        x.i("MicroMsg.ContactSocialInfoUI", "onSceneEnd: errType=%d, errCode=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            if (ContactSocialInfoUI.a(this.lVD, this.lVF, q.Kp().jU(this.dhF))) {
                Toast.makeText(this.lVD.mController.tml, this.lVD.mController.tml.getString(R.l.contact_info_save_avater_ok), 0).show();
                return 0;
            }
        }
        Toast.makeText(this.lVD.mController.tml, this.lVD.mController.tml.getString(R.l.contact_info_save_avater_fail), 0).show();
        return 0;
    }
}
