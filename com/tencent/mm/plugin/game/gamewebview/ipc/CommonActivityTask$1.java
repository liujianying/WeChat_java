package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask.a;

class CommonActivityTask$1 implements OnClickListener {
    final /* synthetic */ a jGc;
    final /* synthetic */ CommonActivityTask jGd;

    CommonActivityTask$1(CommonActivityTask commonActivityTask, a aVar) {
        this.jGd = commonActivityTask;
        this.jGc = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.jGc.ahz();
    }
}
