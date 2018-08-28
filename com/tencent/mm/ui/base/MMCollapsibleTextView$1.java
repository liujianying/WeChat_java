package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;

class MMCollapsibleTextView$1 implements OnClickListener {
    final /* synthetic */ MMCollapsibleTextView ttX;

    MMCollapsibleTextView$1(MMCollapsibleTextView mMCollapsibleTextView) {
        this.ttX = mMCollapsibleTextView;
    }

    public final void onClick(View view) {
        switch (MMCollapsibleTextView.b(this.ttX).get(MMCollapsibleTextView.a(this.ttX), -1)) {
            case 1:
                MMCollapsibleTextView.b(this.ttX).put(MMCollapsibleTextView.a(this.ttX), 2);
                break;
            case 2:
                MMCollapsibleTextView.b(this.ttX).put(MMCollapsibleTextView.a(this.ttX), 1);
                break;
            default:
                return;
        }
        MMCollapsibleTextView.c(this.ttX);
    }
}
