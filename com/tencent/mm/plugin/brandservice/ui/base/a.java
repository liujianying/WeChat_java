package com.tencent.mm.plugin.brandservice.ui.base;

import com.tencent.mm.plugin.brandservice.ui.c$b;
import java.util.List;

public abstract class a extends com.tencent.mm.ui.base.sortview.a {
    protected c$b hoA;
    public List<String> hqc;
    protected int hqd;
    protected int position;

    public a(int i, Object obj) {
        super(i, obj);
    }

    public final void setReporter(c$b c_b) {
        this.hoA = c_b;
    }

    public final c$b avb() {
        return this.hoA;
    }

    public final void ny(int i) {
        this.hqd = i;
    }

    public final int avc() {
        return this.hqd;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final int getPosition() {
        return this.position;
    }
}
