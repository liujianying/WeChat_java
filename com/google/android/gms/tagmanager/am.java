package com.google.android.gms.tagmanager;

import com.google.android.gms.common.api.Status;

final class am implements b {
    private a bcO;
    private a bcP;
    private Status bcQ;
    private b bcR;
    a bcS;
    boolean bcT;
    private d bcU;

    public final synchronized void bz(String str) {
        if (!this.bcT) {
            this.bcO.qV().bz(str);
        }
    }

    public final Status oF() {
        return this.bcQ;
    }

    final String rE() {
        if (!this.bcT) {
            return this.bcO.bbj;
        }
        m.rb();
        return "";
    }

    final void rF() {
        if (this.bcT) {
            m.rb();
        }
    }

    public final synchronized void refresh() {
        if (this.bcT) {
            m.rb();
        }
    }

    public final synchronized void release() {
        if (this.bcT) {
            m.rb();
        } else {
            this.bcT = true;
            this.bcU.bbA.remove(this);
            this.bcO.bbk = null;
            this.bcO = null;
            this.bcP = null;
            this.bcS = null;
            this.bcR = null;
        }
    }
}
