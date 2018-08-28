package com.tencent.mm.plugin.fav.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class FavoriteIndexUI$9 implements OnClickListener {
    final /* synthetic */ FavoriteIndexUI jbh;

    FavoriteIndexUI$9(FavoriteIndexUI favoriteIndexUI) {
        this.jbh = favoriteIndexUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.jbh.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
