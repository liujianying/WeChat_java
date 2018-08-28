package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.x;

public abstract class v implements OnMenuItemClickListener {
    private long ngz = -1;

    public abstract void bHJ();

    public boolean onMenuItemClick(MenuItem menuItem) {
        x.i("MicroMsg.MMCustomMenuItemClickListener", "button onclick");
        if (this.ngz != -1) {
            if ((System.nanoTime() - this.ngz) / 1000000 < 500) {
                x.i("MicroMsg.MMCustomMenuItemClickListener", "click time limited limitetime:%d, delaytime:%d", new Object[]{Long.valueOf((System.nanoTime() - this.ngz) / 1000000), Long.valueOf(500)});
                return false;
            }
        }
        this.ngz = System.nanoTime();
        bHJ();
        return false;
    }
}
