package com.tencent.mm.ui.base;

import android.content.Context;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.Queue;

public abstract class d extends u {
    public Context context;
    private Queue<View> tsm;
    private int tsn = 0;

    public abstract View a(View view, ViewGroup viewGroup, int i);

    public abstract int biD();

    public abstract void tO(int i);

    public d(Context context) {
        this.context = context;
        this.tsm = new LinkedList();
    }

    public final boolean a(View view, Object obj) {
        return view.equals(obj);
    }

    public final Object b(ViewGroup viewGroup, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        View a = a((View) this.tsm.poll(), viewGroup, i);
        if (a.getLayoutParams() == null) {
            a.setLayoutParams(new LayoutParams(-1, -1));
        }
        viewGroup.addView(a);
        x.v("MicroMsg.CustomPagerAdapter", "instantiateItem usetime: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return a;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        this.tsm.add(view);
        tO(i);
        x.d("MicroMsg.CustomPagerAdapter", "recycle queue size %d", new Object[]{Integer.valueOf(this.tsm.size())});
    }

    public final void notifyDataSetChanged() {
        this.tsn = biD();
        super.notifyDataSetChanged();
    }

    public final int k(Object obj) {
        if (this.tsn <= 0) {
            return super.k(obj);
        }
        this.tsn--;
        return -2;
    }
}
