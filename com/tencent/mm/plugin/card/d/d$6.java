package com.tencent.mm.plugin.card.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ui.MMActivity;

class d$6 implements OnClickListener {
    final /* synthetic */ MMActivity gdk;
    final /* synthetic */ boolean hIG;

    d$6(boolean z, MMActivity mMActivity) {
        this.hIG = z;
        this.gdk = mMActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (this.hIG) {
            this.gdk.finish();
        }
    }
}
