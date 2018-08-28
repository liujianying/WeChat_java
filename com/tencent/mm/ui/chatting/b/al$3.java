package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import com.tencent.mm.storage.bd;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

class al$3 implements OnClickListener {
    final /* synthetic */ bd dAs;
    final /* synthetic */ al tSY;
    final /* synthetic */ int tTa;
    final /* synthetic */ MenuItem tmR;

    al$3(al alVar, bd bdVar, MenuItem menuItem, int i) {
        this.tSY = alVar;
        this.dAs = bdVar;
        this.tmR = menuItem;
        this.tTa = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        al alVar = this.tSY;
        bd bdVar = this.dAs;
        this.tmR.getGroupId();
        al.a(alVar, bdVar, this.tTa == TbsListener$ErrorCode.DOWNLOAD_THROWABLE);
        dialogInterface.dismiss();
    }
}
