package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;

class u$1 implements OnClickListener {
    final /* synthetic */ u tKV;

    u$1(u uVar) {
        this.tKV = uVar;
    }

    public final void onClick(View view) {
        new Intent().putExtra("composeType", 1);
        d.A(this.tKV.mContext, "qqmail", ".ui.ComposeUI");
    }
}
