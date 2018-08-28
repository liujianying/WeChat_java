package com.tencent.mm.plugin.remittance.bankcard.model;

import android.util.Pair;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

class c$a extends Filter {
    List<TransferRecordParcel> muv;
    final /* synthetic */ c muw;

    private c$a(c cVar) {
        this.muw = cVar;
        this.muv = new ArrayList();
    }

    /* synthetic */ c$a(c cVar, byte b) {
        this(cVar);
    }

    protected final FilterResults performFiltering(CharSequence charSequence) {
        this.muv.clear();
        c.a(this.muw).clear();
        x.d("MicroMsg.PayeeAutoCompleteAdapter", "input: %s", new Object[]{charSequence});
        for (TransferRecordParcel transferRecordParcel : c.b(this.muw)) {
            if (!bi.K(charSequence) && transferRecordParcel.muC.contains(charSequence)) {
                int indexOf = transferRecordParcel.muC.indexOf((String) charSequence);
                x.i("MicroMsg.PayeeAutoCompleteAdapter", "match payee: %s, start: %s, end: %s", new Object[]{transferRecordParcel.muC, Integer.valueOf(indexOf), Integer.valueOf(charSequence.length() + indexOf)});
                c.a(this.muw).add(new Pair(Integer.valueOf(indexOf), Integer.valueOf(r3)));
                this.muv.add(transferRecordParcel);
            }
        }
        FilterResults filterResults = new FilterResults();
        filterResults.count = this.muv.size();
        filterResults.values = this.muv;
        return filterResults;
    }

    protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
        c.a(this.muw, (List) filterResults.values);
        x.i("MicroMsg.PayeeAutoCompleteAdapter", "match count: %d", new Object[]{Integer.valueOf(c.c(this.muw).size())});
        this.muw.notifyDataSetChanged();
    }
}
