package com.tencent.mm.plugin.dbbackup;

import android.widget.Toast;
import com.tencent.mm.plugin.dbbackup.c.2;

class c$2$1 implements Runnable {
    final /* synthetic */ int hZq;
    final /* synthetic */ 2 hZt;

    c$2$1(2 2, int i) {
        this.hZt = 2;
        this.hZq = i;
    }

    public final void run() {
        CharSequence format;
        if (this.hZt.hZo != null) {
            this.hZt.hZo.dismiss();
        }
        if (this.hZq == 0) {
            String str = "Database (%s) backup succeeded, elapsed %.2f seconds.";
            Object[] objArr = new Object[2];
            objArr[0] = this.hZt.hZs ? "incremental" : "new";
            objArr[1] = Float.valueOf(((float) (System.nanoTime() - this.hZt.dUQ)) / 1.0E9f);
            format = String.format(str, objArr);
        } else if (this.hZq == 1) {
            format = "Database backup canceled.";
        } else {
            format = "Database backup failed.";
        }
        Toast.makeText(this.hZt.val$context, format, 0).show();
    }
}
