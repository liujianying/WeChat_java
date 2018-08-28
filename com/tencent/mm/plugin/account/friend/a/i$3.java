package com.tencent.mm.plugin.account.friend.a;

import android.view.View;
import android.view.View.OnClickListener;

class i$3 implements OnClickListener {
    final /* synthetic */ i eKi;
    final /* synthetic */ int eKj;

    i$3(i iVar, int i) {
        this.eKi = iVar;
        this.eKj = i;
    }

    public final void onClick(View view) {
        i iVar = this.eKi;
        int i = this.eKj;
        if (iVar.showType == 1) {
            iVar.eIr[i] = 0;
        } else if (iVar.showType == 2) {
            iVar.eIr[i] = 0;
        }
        iVar.notifyDataSetChanged();
    }
}
