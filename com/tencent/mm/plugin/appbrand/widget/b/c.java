package com.tencent.mm.plugin.appbrand.widget.b;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

public final class c implements Iterator<View> {
    private final ViewGroup gFG;
    private int gwc = 0;

    public final /* synthetic */ Object next() {
        ViewGroup viewGroup = this.gFG;
        int i = this.gwc;
        this.gwc = i + 1;
        return viewGroup.getChildAt(i);
    }

    public c(ViewGroup viewGroup) {
        this.gFG = viewGroup;
    }

    public final boolean hasNext() {
        return this.gwc < this.gFG.getChildCount();
    }

    public final void remove() {
        this.gFG.removeViewAt(this.gwc - 1);
    }
}
