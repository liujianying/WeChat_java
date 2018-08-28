package com.tencent.mm.plugin.fav.ui.a;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.fav.a.w;
import java.util.Set;

public abstract class a extends BaseAdapter implements OnItemClickListener {
    protected Set<Integer> jbA;
    protected w jbB;
    protected a jbC;
    protected long lastUpdateTime;
    protected int type;

    public abstract void aMD();

    public abstract void aME();

    public abstract boolean isEmpty();

    public final int getType() {
        return this.type;
    }

    public final long aMB() {
        return this.lastUpdateTime;
    }

    public final void a(a aVar) {
        this.jbC = aVar;
    }

    public final void aMC() {
        if (this.jbC != null) {
            this.jbC.aMA();
        }
    }

    public final void g(Set<Integer> set) {
        this.jbA = set;
    }

    public final void a(w wVar) {
        this.jbB = wVar;
    }
}
