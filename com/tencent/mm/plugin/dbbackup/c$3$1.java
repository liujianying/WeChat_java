package com.tencent.mm.plugin.dbbackup;

import android.widget.Toast;
import com.tencent.mm.plugin.dbbackup.c.3;

class c$3$1 implements Runnable {
    final /* synthetic */ int hZq;
    final /* synthetic */ 3 hZu;

    c$3$1(3 3, int i) {
        this.hZu = 3;
        this.hZq = i;
    }

    public final void run() {
        CharSequence format;
        if (this.hZu.hZo != null) {
            this.hZu.hZo.dismiss();
        }
        if (this.hZq == 0) {
            format = String.format("Database recovery succeeded, elapsed %.2f seconds.", new Object[]{Float.valueOf(((float) (System.nanoTime() - this.hZu.dUQ)) / 1.0E9f)});
        } else if (this.hZq == 1) {
            format = "Database recovery canceled.";
        } else {
            format = "Database recovery failed.";
        }
        Toast.makeText(this.hZu.val$context, format, 0).show();
    }
}
