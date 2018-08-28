package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.plugin.profile.a;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.i;

class NormalUserFooterPreference$i$2 implements OnCancelListener {
    final /* synthetic */ i lXP;

    NormalUserFooterPreference$i$2(i iVar) {
        this.lXP = iVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.lXP.onStop();
        Intent intent = new Intent();
        intent.putExtra("Intro_Switch", true).addFlags(67108864);
        a.ezn.q(intent, this.lXP.lXw.mContext);
    }
}
