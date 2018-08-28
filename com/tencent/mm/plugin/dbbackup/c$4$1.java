package com.tencent.mm.plugin.dbbackup;

import android.widget.Toast;
import com.tencent.mm.plugin.dbbackup.c.4;

class c$4$1 implements Runnable {
    final /* synthetic */ int hZq;
    final /* synthetic */ 4 hZv;

    c$4$1(4 4, int i) {
        this.hZv = 4;
        this.hZq = i;
    }

    public final void run() {
        CharSequence format;
        if (this.hZv.hZo != null) {
            this.hZv.hZo.dismiss();
        }
        if (this.hZq == 0) {
            format = String.format("Database recovery succeeded, elapsed %.2f seconds.", new Object[]{Float.valueOf(((float) (System.nanoTime() - this.hZv.dUQ)) / 1.0E9f)});
        } else if (this.hZq == 1) {
            format = "Database recovery canceled.";
        } else {
            format = "Database recovery failed.";
        }
        Toast.makeText(this.hZv.val$context, format, 0).show();
    }
}
