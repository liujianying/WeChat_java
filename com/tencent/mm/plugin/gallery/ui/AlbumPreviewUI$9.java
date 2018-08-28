package com.tencent.mm.plugin.gallery.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class AlbumPreviewUI$9 implements OnClickListener {
    final /* synthetic */ AlbumPreviewUI jCE;

    AlbumPreviewUI$9(AlbumPreviewUI albumPreviewUI) {
        this.jCE = albumPreviewUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.jCE.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
