package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class VideoActivity$3 implements OnClickListener {
    final /* synthetic */ VideoActivity oQn;

    VideoActivity$3(VideoActivity videoActivity) {
        this.oQn = videoActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.oQn.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
