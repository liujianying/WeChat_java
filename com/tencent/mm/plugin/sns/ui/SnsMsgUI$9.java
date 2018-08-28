package com.tencent.mm.plugin.sns.ui;

class SnsMsgUI$9 implements Runnable {
    final /* synthetic */ SnsMsgUI nYl;

    SnsMsgUI$9(SnsMsgUI snsMsgUI) {
        this.nYl = snsMsgUI;
    }

    public final void run() {
        if (SnsMsgUI.e(this.nYl) != null) {
            synchronized (SnsMsgUI.e(this.nYl)) {
                SnsMsgUI.e(this.nYl).a(null, null);
                SnsMsgUI.t(this.nYl);
            }
        }
    }
}
