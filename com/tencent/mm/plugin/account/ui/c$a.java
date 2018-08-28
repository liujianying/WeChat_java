package com.tencent.mm.plugin.account.ui;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import java.util.ArrayList;
import java.util.List;

class c$a extends Filter {
    final /* synthetic */ c ePy;

    private c$a(c cVar) {
        this.ePy = cVar;
    }

    /* synthetic */ c$a(c cVar, byte b) {
        this(cVar);
    }

    protected final FilterResults performFiltering(CharSequence charSequence) {
        int i = 0;
        FilterResults filterResults = new FilterResults();
        if (c.a(this.ePy) == null) {
            synchronized (c.b(this.ePy)) {
                c.a(this.ePy, new ArrayList(c.c(this.ePy)));
            }
        }
        if (charSequence == null || charSequence.length() == 0) {
            synchronized (c.b(this.ePy)) {
                ArrayList arrayList = new ArrayList(c.a(this.ePy));
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
            }
        } else {
            String str;
            ArrayList a;
            int size;
            ArrayList arrayList2;
            String toLowerCase = charSequence.toString().toLowerCase();
            String str2 = "";
            if (c.d(this.ePy) != null && c.d(this.ePy).length() > 0) {
                String[] split = toLowerCase.split(c.d(this.ePy));
                if (split != null && split.length > 1) {
                    str2 = split[0] + c.d(this.ePy);
                    str = split[1];
                    a = c.a(this.ePy);
                    size = a.size();
                    arrayList2 = new ArrayList(size);
                    while (i < size) {
                        toLowerCase = (String) a.get(i);
                        if (toLowerCase.toString().toLowerCase().startsWith(str)) {
                            arrayList2.add(str2 + toLowerCase);
                        }
                        i++;
                    }
                    filterResults.values = arrayList2;
                    filterResults.count = arrayList2.size();
                }
            }
            str = toLowerCase;
            a = c.a(this.ePy);
            size = a.size();
            arrayList2 = new ArrayList(size);
            while (i < size) {
                toLowerCase = (String) a.get(i);
                if (toLowerCase.toString().toLowerCase().startsWith(str)) {
                    arrayList2.add(str2 + toLowerCase);
                }
                i++;
            }
            filterResults.values = arrayList2;
            filterResults.count = arrayList2.size();
        }
        return filterResults;
    }

    protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
        c.a(this.ePy, (List) filterResults.values);
        if (filterResults.count > 0) {
            this.ePy.notifyDataSetChanged();
        } else {
            this.ePy.notifyDataSetInvalidated();
        }
    }
}
