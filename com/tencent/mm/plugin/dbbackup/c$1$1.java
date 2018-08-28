package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.R;
import com.tencent.mm.plugin.dbbackup.c.1;
import com.tencent.mm.ui.base.h;

class c$1$1 implements Runnable {
    final /* synthetic */ int hZq;
    final /* synthetic */ 1 hZr;

    c$1$1(1 1, int i) {
        this.hZr = 1;
        this.hZq = i;
    }

    public final void run() {
        int i;
        if (this.hZr.hZo != null) {
            this.hZr.hZo.dismiss();
        }
        switch (this.hZq) {
            case -3:
                i = R.l.recover_db_no_datafile;
                break;
            case -2:
                i = R.l.recover_db_no_enough_space;
                break;
            case 0:
                i = R.l.recover_db_success;
                break;
            default:
                i = R.l.recover_db_fail;
                break;
        }
        h.i(this.hZr.val$context, i, R.l.app_tip);
    }
}
