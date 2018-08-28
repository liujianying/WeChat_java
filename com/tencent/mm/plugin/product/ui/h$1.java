package com.tencent.mm.plugin.product.ui;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import java.util.ArrayList;
import java.util.List;

class h$1 extends Filter {
    final /* synthetic */ h lSV;

    h$1(h hVar) {
        this.lSV = hVar;
    }

    protected final synchronized void publishResults(CharSequence charSequence, FilterResults filterResults) {
        h.a(this.lSV, (List) filterResults.values);
        this.lSV.notifyDataSetChanged();
    }

    protected final FilterResults performFiltering(CharSequence charSequence) {
        FilterResults filterResults = new FilterResults();
        ArrayList arrayList = new ArrayList();
        for (String str : h.a(this.lSV)) {
            if (!(str == null || charSequence == null || !str.contains(charSequence))) {
                arrayList.add(str);
            }
        }
        filterResults.values = arrayList;
        filterResults.count = arrayList.size();
        return filterResults;
    }
}
