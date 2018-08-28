package com.tencent.mm.plugin.card.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.ui.MMActivity;

class d$7 implements OnClickListener {
    final /* synthetic */ MMActivity gdk;

    public d$7(MMActivity mMActivity) {
        this.gdk = mMActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.gdk.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }
}
