package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import com.tencent.mm.sdk.platformtools.x;

class l$2 implements OnClickListener {
    final /* synthetic */ SharedPreferences urq;
    final /* synthetic */ Context val$context;

    l$2(SharedPreferences sharedPreferences, Context context) {
        this.urq = sharedPreferences;
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.urq.edit().putInt("show_rating_flag", 2).commit();
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        l.czd();
        l.gV(this.val$context);
        x.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show feedback dialog.");
    }
}
