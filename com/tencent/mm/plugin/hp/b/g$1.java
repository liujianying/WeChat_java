package com.tencent.mm.plugin.hp.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.sdk.platformtools.ad;

class g$1 implements OnClickListener {
    final /* synthetic */ g kmJ;

    g$1(g gVar) {
        this.kmJ = gVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Toast.makeText(ad.getContext(), "OK", 0).show();
    }
}
