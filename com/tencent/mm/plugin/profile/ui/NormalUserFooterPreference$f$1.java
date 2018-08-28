package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.normsg.a.b;
import com.tencent.mm.plugin.profile.a;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.f;
import com.tencent.mm.ui.e$a;

class NormalUserFooterPreference$f$1 implements OnClickListener {
    final /* synthetic */ f lXO;

    NormalUserFooterPreference$f$1(f fVar) {
        this.lXO = fVar;
    }

    public final void onClick(View view) {
        b.lFJ.S(1, 1, 3);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", NormalUserFooterPreference.a(this.lXO.lXw).field_username);
        intent.putExtra("Contact_Scene", NormalUserFooterPreference.l(this.lXO.lXw));
        intent.putExtra(e$a.ths, NormalUserFooterPreference.a(this.lXO.lXw).cta);
        a.ezn.a(intent, this.lXO.lXw.mContext);
    }
}
