package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class e$2 implements OnClickListener {
    final /* synthetic */ e kuf;

    e$2(e eVar) {
        this.kuf = eVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.kuf.ktY, IPCallContactUI.class);
        this.kuf.ktY.startActivity(intent);
    }
}
