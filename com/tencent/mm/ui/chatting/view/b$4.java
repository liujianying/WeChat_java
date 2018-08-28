package com.tencent.mm.ui.chatting.view;

import android.view.View;
import android.view.View.OnClickListener;

class b$4 implements OnClickListener {
    final /* synthetic */ b tZe;

    b$4(b bVar) {
        this.tZe = bVar;
    }

    public final void onClick(View view) {
        if (this.tZe.tZc != null) {
            this.tZe.tZc.onCancel();
        }
    }
}
