package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.profile.a;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.i;

class NormalUserFooterPreference$i$1 implements OnClickListener {
    final /* synthetic */ i lXP;

    NormalUserFooterPreference$i$1(i iVar) {
        this.lXP = iVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.lXP.onStop();
        Intent intent = new Intent();
        intent.putExtra("Intro_Switch", true).addFlags(67108864);
        a.ezn.q(intent, this.lXP.lXw.mContext);
    }
}
