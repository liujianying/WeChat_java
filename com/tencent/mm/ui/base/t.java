package com.tencent.mm.ui.base;

import android.support.v4.view.u;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public abstract class t extends u {
    public Queue<View> tyZ = new LinkedList();
    public HashMap<Object, Integer> tza = new HashMap();
    public SparseArray<Object> tzb = new SparseArray();

    public abstract Object c(int i, View view);

    public abstract MultiTouchImageView qC(int i);

    public abstract WxImageView qD(int i);

    public Object b(ViewGroup viewGroup, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        View view = null;
        if (this.tyZ.size() > 0) {
            view = (View) this.tyZ.poll();
        }
        Object c = c(i, view);
        x.i("MicroMsg.MMViewPagerAdapter", "instantiateItem object %s, parent %s position:%s", new Object[]{Integer.valueOf(c.hashCode()), ((View) c).getParent(), Integer.valueOf(i)});
        this.tza.put(c, Integer.valueOf(i));
        this.tzb.put(i, c);
        if (((View) c).getParent() == null) {
            viewGroup.addView((View) c);
        }
        x.i("MicroMsg.MMViewPagerAdapter", "instantiateItem spent : %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return c;
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        x.d("MicroMsg.MMViewPagerAdapter", "destroyItem position %s", new Object[]{Integer.valueOf(i)});
        x.i("MicroMsg.MMViewPagerAdapter", "destroyItem object %s", new Object[]{Integer.valueOf(obj.hashCode())});
        this.tyZ.add((View) obj);
        this.tza.remove(obj);
        this.tzb.remove(i);
    }

    public final int k(Object obj) {
        if (this.tza.containsKey(obj)) {
            return ((Integer) this.tza.get(obj)).intValue();
        }
        return -2;
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }

    public final View Ep(int i) {
        Object obj = this.tzb.get(i);
        if (obj != null) {
            return (View) obj;
        }
        return null;
    }

    public final void reset() {
        this.tyZ.clear();
        this.tza.clear();
        this.tzb.clear();
    }

    public int crV() {
        return -1;
    }

    public int crW() {
        return -1;
    }

    public void detach() {
        reset();
    }
}
