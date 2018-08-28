package com.tencent.mm.ui.gridviewheaders;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f extends BaseAdapter implements b {
    private e uuB;
    private List<b> uuC;

    public f(e eVar) {
        this.uuB = eVar;
        eVar.registerDataSetObserver(new a(this, (byte) 0));
        this.uuC = a(eVar);
    }

    public final int getCount() {
        return this.uuB.getCount();
    }

    public final int FW(int i) {
        try {
            return ((b) this.uuC.get(i)).mCount;
        } catch (IndexOutOfBoundsException e) {
            e.toString();
            return 0;
        }
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        return this.uuB.a(((b) this.uuC.get(i)).uuE, view, viewGroup);
    }

    public final Object getItem(int i) {
        return this.uuB.getItem(i);
    }

    public final long getItemId(int i) {
        return this.uuB.getItemId(i);
    }

    public final int czk() {
        return this.uuC.size();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.uuB.getView(i, view, viewGroup);
    }

    protected final List<b> a(e eVar) {
        Map hashMap = new HashMap();
        List<b> arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= eVar.getCount()) {
                return arrayList;
            }
            long oo = eVar.oo(i2);
            b bVar = (b) hashMap.get(Long.valueOf(oo));
            if (bVar == null) {
                bVar = new b(this, i2);
                arrayList.add(bVar);
            }
            bVar.mCount++;
            hashMap.put(Long.valueOf(oo), bVar);
            i = i2 + 1;
        }
    }
}
