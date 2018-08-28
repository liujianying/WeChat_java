package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.dbbackup.DBRecoveryUI;

class i$8 implements OnClickListener {
    final /* synthetic */ i uqR;

    i$8(i iVar) {
        this.uqR = iVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        i.e(this.uqR).dismiss();
        Intent intent = new Intent(i.a(this.uqR), DBRecoveryUI.class);
        intent.putExtra("scene", 0);
        i.a(this.uqR).startActivity(intent);
    }
}
