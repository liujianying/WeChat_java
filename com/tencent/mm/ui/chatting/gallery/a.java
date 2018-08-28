package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import com.tencent.mm.storage.bd;

public abstract class a {
    protected b tTx;

    public a(b bVar) {
        this.tTx = bVar;
    }

    public void detach() {
        this.tTx = null;
    }

    public boolean a(j jVar, bd bdVar, int i) {
        return false;
    }

    public final j Fl(int i) {
        if (this.tTx == null) {
            return null;
        }
        View Ep = this.tTx.Ep(i);
        return Ep == null ? null : (j) Ep.getTag();
    }

    public final void Fm(int i) {
        if (this.tTx != null) {
            View Ep = this.tTx.Ep(i);
            if (Ep != null && Ep.getTag() != null) {
                a((j) Ep.getTag(), this.tTx.ES(i), i);
            }
        }
    }
}
