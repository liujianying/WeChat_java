package com.tencent.mm.ui.base.sortview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c extends BaseAdapter {
    List<d> tDK = null;
    private Map<String, Integer> tDP;
    private a tDQ;
    public Runnable tDR = new 1(this);

    public c(a aVar) {
        if (aVar == null) {
            throw new RuntimeException("ViewCreator can not be null.");
        }
        this.tDQ = aVar;
        this.tDK = new ArrayList();
        this.tDP = new HashMap();
    }

    public final void dx(List<d> list) {
        if (this.tDK != list) {
            this.tDK.clear();
            if (list != null) {
                this.tDK.addAll(list);
            }
        }
        this.tDP.clear();
        int i = 0;
        String str = null;
        while (i < this.tDK.size()) {
            d dVar = (d) this.tDK.get(i);
            String str2 = (dVar == null || dVar.tDT == null) ? null : dVar.tDT;
            if (str2 == null || str2.equalsIgnoreCase(str)) {
                str2 = str;
            } else {
                this.tDP.put(str2, Integer.valueOf(i));
            }
            i++;
            str = str2;
        }
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.tDK.size();
    }

    public final Object getItem(int i) {
        return this.tDK.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z = true;
        d dVar = (d) getItem(i);
        String EB = EB(i);
        String EB2 = EB(i + 1);
        boolean z2 = i == aad(EB);
        if (EB == null || EB.equalsIgnoreCase(EB2)) {
            z = false;
        }
        a aVar = this.tDQ;
        getCount();
        return aVar.a(dVar, view, i, z2, z);
    }

    private String EB(int i) {
        if (i < 0 || i >= this.tDK.size()) {
            return null;
        }
        return ((d) this.tDK.get(i)).tDT;
    }

    public final int aad(String str) {
        return bi.a((Integer) this.tDP.get(str), -1);
    }
}
