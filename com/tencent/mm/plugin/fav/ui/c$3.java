package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.fav.a.b;

class c$3 implements OnClickListener {
    final /* synthetic */ OnClickListener iYJ;
    final /* synthetic */ Context val$context;

    c$3(Context context, OnClickListener onClickListener) {
        this.val$context = context;
        this.iYJ = onClickListener;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("key_enter_fav_cleanui_from", 3);
        b.a(this.val$context, ".ui.FavCleanUI", intent);
        dialogInterface.dismiss();
        if (this.iYJ != null) {
            this.iYJ.onClick(dialogInterface, -2);
        }
    }
}
