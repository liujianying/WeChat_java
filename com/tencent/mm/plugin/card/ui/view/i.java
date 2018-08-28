package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import com.tencent.mm.plugin.card.ui.n;

public abstract class i {
    n hHF;

    public abstract void initView();

    public final void a(n nVar) {
        this.hHF = nVar;
        initView();
    }

    public void destroy() {
        this.hHF = null;
    }

    public void update() {
    }

    public void azI() {
    }

    protected final View findViewById(int i) {
        return this.hHF.findViewById(i);
    }

    protected final String getString(int i) {
        return this.hHF.getString(i);
    }
}
