package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class l$4 implements OnClickListener {
    final /* synthetic */ SharedPreferences urq;
    final /* synthetic */ boolean urr;
    final /* synthetic */ int urs;
    final /* synthetic */ int urt;

    l$4(SharedPreferences sharedPreferences, boolean z, int i, int i2) {
        this.urq = sharedPreferences;
        this.urr = z;
        this.urs = i;
        this.urt = i2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.urq.edit().putInt("show_rating_flag", 4).commit();
        if (this.urr) {
            this.urq.edit().putBoolean("show_rating_again", false).commit();
            h.mEJ.h(11216, new Object[]{Integer.valueOf(3), Integer.valueOf(this.urs), Integer.valueOf(this.urt)});
        } else {
            x.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]need to show rating dialog again.");
            this.urq.edit().putBoolean("show_rating_again", true).commit();
            h.mEJ.h(11216, new Object[]{Integer.valueOf(6), Integer.valueOf(this.urs), Integer.valueOf(this.urt)});
        }
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        l.czd();
    }
}
