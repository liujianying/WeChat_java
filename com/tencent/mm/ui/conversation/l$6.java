package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import com.tencent.mm.plugin.report.service.h;

class l$6 implements OnClickListener {
    final /* synthetic */ SharedPreferences urq;
    final /* synthetic */ int urs;
    final /* synthetic */ int urt;

    l$6(SharedPreferences sharedPreferences, int i, int i2) {
        this.urq = sharedPreferences;
        this.urs = i;
        this.urt = i2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.urq.edit().putInt("show_rating_flag", 4).commit();
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        l.czd();
        h.mEJ.h(11216, new Object[]{Integer.valueOf(1), Integer.valueOf(this.urs), Integer.valueOf(this.urt)});
    }
}
