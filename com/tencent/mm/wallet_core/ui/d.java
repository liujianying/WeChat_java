package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

public class d implements OnClickListener {
    private long grW = 0;
    private OnClickListener mtE;

    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.grW >= 500) {
            this.mtE.onClick(view);
            this.grW = currentTimeMillis;
        }
    }
}
