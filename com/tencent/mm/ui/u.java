package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

public abstract class u implements OnClickListener {
    private long ngz = -1;

    public abstract void aBU();

    public void onClick(View view) {
        x.i("MicroMsg.MMCustomClickListener", "button onclick");
        if (this.ngz != -1) {
            if ((System.nanoTime() - this.ngz) / 1000000 < 3000) {
                x.i("MicroMsg.MMCustomClickListener", "click time limited limitetime:%d, delaytime:%d", new Object[]{Long.valueOf((System.nanoTime() - this.ngz) / 1000000), Long.valueOf(3000)});
                return;
            }
        }
        this.ngz = System.nanoTime();
        aBU();
    }
}
