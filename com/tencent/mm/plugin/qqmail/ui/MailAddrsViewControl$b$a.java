package com.tencent.mm.plugin.qqmail.ui;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.b;
import java.util.ArrayList;
import java.util.List;

class MailAddrsViewControl$b$a extends Filter {
    final /* synthetic */ b mhg;

    private MailAddrsViewControl$b$a(b bVar) {
        this.mhg = bVar;
    }

    protected final FilterResults performFiltering(CharSequence charSequence) {
        FilterResults filterResults = new FilterResults();
        if (b.a(this.mhg) == null) {
            synchronized (b.b(this.mhg)) {
                b.a(this.mhg, new ArrayList(b.c(this.mhg)));
            }
        }
        if (charSequence == null || charSequence.length() == 0) {
            synchronized (b.b(this.mhg)) {
                ArrayList arrayList = new ArrayList(b.a(this.mhg));
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
            }
        } else {
            CharSequence toLowerCase = charSequence.toString().toLowerCase();
            ArrayList a = b.a(this.mhg);
            int size = a.size();
            ArrayList arrayList2 = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                i iVar = (i) a.get(i);
                if (iVar.name.toLowerCase().contains(toLowerCase) || iVar.kCs.toLowerCase().contains(toLowerCase)) {
                    arrayList2.add(iVar);
                }
            }
            filterResults.values = arrayList2;
            filterResults.count = arrayList2.size();
        }
        return filterResults;
    }

    protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
        b.a(this.mhg, (List) filterResults.values);
        if (filterResults.count > 0) {
            this.mhg.notifyDataSetChanged();
            return;
        }
        b.a(this.mhg, new ArrayList(b.a(this.mhg)));
        this.mhg.notifyDataSetInvalidated();
    }
}
