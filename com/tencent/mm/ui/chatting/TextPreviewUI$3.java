package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.storage.bd;

class TextPreviewUI$3 implements OnClickListener {
    final /* synthetic */ bd dAs;
    final /* synthetic */ TextPreviewUI tNo;

    TextPreviewUI$3(TextPreviewUI textPreviewUI, bd bdVar) {
        this.tNo = textPreviewUI;
        this.dAs = bdVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        TextPreviewUI.a(this.tNo, this.dAs);
    }
}
