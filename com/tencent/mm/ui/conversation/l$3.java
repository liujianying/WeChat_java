package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class l$3 implements OnClickListener {
    final /* synthetic */ SharedPreferences urq;
    final /* synthetic */ boolean urr;
    final /* synthetic */ int urs;
    final /* synthetic */ int urt;
    final /* synthetic */ Context val$context;

    l$3(SharedPreferences sharedPreferences, Context context, boolean z, int i, int i2) {
        this.urq = sharedPreferences;
        this.val$context = context;
        this.urr = z;
        this.urs = i;
        this.urt = i2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.urq.edit().putInt("show_rating_flag", 4).commit();
        String str = "market://details?id=" + ad.getPackageName();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.val$context.startActivity(intent);
        x.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]start market intent");
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        this.urq.edit().putBoolean("show_rating_again", false).commit();
        l.czd();
        if (this.urr) {
            h.mEJ.h(11216, new Object[]{Integer.valueOf(5), Integer.valueOf(this.urs), Integer.valueOf(this.urt)});
            return;
        }
        h.mEJ.h(11216, new Object[]{Integer.valueOf(4), Integer.valueOf(this.urs), Integer.valueOf(this.urt)});
    }
}
