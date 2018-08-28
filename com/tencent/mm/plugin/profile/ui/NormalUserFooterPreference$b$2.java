package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.be.a;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.b;
import com.tencent.mm.ui.e;

class NormalUserFooterPreference$b$2 implements OnClickListener {
    final /* synthetic */ b lXH;

    NormalUserFooterPreference$b$2(b bVar) {
        this.lXH = bVar;
    }

    public final void onClick(View view) {
        Intent intent;
        if (NormalUserFooterPreference.c(this.lXH.lXw) && a.cbf()) {
            intent = new Intent();
            intent.putExtra("Chat_User", NormalUserFooterPreference.a(this.lXH.lXw).field_encryptUsername);
            intent.putExtra("lbs_mode", true);
            intent.putExtra("lbs_ticket", NormalUserFooterPreference.C(this.lXH.lXw));
            intent.putExtra("add_scene", NormalUserFooterPreference.l(this.lXH.lXw));
            com.tencent.mm.plugin.profile.a.ezn.e(intent, NormalUserFooterPreference.b(this.lXH.lXw));
            return;
        }
        intent = new Intent();
        intent.putExtra("Contact_User", NormalUserFooterPreference.a(this.lXH.lXw).field_username);
        intent.putExtra("Contact_Scene", NormalUserFooterPreference.l(this.lXH.lXw));
        intent.putExtra(e.a.ths, NormalUserFooterPreference.a(this.lXH.lXw).cta);
        com.tencent.mm.plugin.profile.a.ezn.a(intent, this.lXH.lXw.mContext);
    }
}
