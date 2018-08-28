package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.x;

class d$10 implements OnClickListener {
    final /* synthetic */ Context val$context;

    d$10(Context context) {
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", 22);
        intent.putExtra("key_home_page_from_scene", 1);
        d.b(this.val$context, "card", ".ui.CardHomePageUI", intent);
        x.i("MicroMsg.CardDialogHelper", "enter to cardhome");
    }
}
