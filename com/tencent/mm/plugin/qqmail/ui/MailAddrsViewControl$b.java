package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.i;
import java.util.ArrayList;
import java.util.List;

public class MailAddrsViewControl$b extends BaseAdapter implements Filterable {
    private List<i> ePu;
    private ArrayList<i> ePv;
    private Context mContext;
    private final Object mLock = new Object();
    private boolean mhe = true;
    private a mhf;

    public MailAddrsViewControl$b(Context context, List<i> list) {
        this.mContext = context;
        this.ePu = list;
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.mhe = true;
    }

    public final int getCount() {
        return this.ePu.size();
    }

    /* renamed from: uZ */
    public final i getItem(int i) {
        return (i) this.ePu.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = View.inflate(this.mContext, R.i.qqmail_dropdown_addrlist_item, null);
            b bVar = new b(this, (byte) 0);
            bVar.eMe = (TextView) view.findViewById(R.h.qqmail_addrlist_item_name_tv);
            bVar.mgP = (TextView) view.findViewById(R.h.qqmail_addrlist_item_addr_iv);
            bVar.mhh = (CheckBox) view.findViewById(R.h.qqmail_addrlist_item_select_cb);
            view.setTag(bVar);
        } else {
            ViewGroup viewGroup2 = (ViewGroup) view;
        }
        i uZ = getItem(i);
        b bVar2 = (b) view.getTag();
        bVar2.eMe.setText(uZ.name);
        bVar2.mgP.setText(uZ.kCs);
        bVar2.mhh.setVisibility(8);
        view.setBackgroundColor(-789517);
        return view;
    }

    public final Filter getFilter() {
        if (this.mhf == null) {
            this.mhf = new a(this, (byte) 0);
        }
        return this.mhf;
    }
}
