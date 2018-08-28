package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.List;

public abstract class a extends BaseAdapter implements d {
    private int olo = 0;
    HashMap<Object, Integer> olp = new HashMap();

    public final boolean hasStableIds() {
        return true;
    }

    protected final void bT(Object obj) {
        HashMap hashMap = this.olp;
        int i = this.olo;
        this.olo = i + 1;
        hashMap.put(obj, Integer.valueOf(i));
    }

    protected final void ct(List<?> list) {
        for (Object bT : list) {
            bT(bT);
        }
    }

    public final long getItemId(int i) {
        if (i < 0 || i >= this.olp.size()) {
            return -1;
        }
        return (long) ((Integer) this.olp.get(getItem(i))).intValue();
    }
}
