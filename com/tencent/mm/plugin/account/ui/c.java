package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.tencent.mm.plugin.account.a.e;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class c extends BaseAdapter implements Filterable {
    private List<String> ePu;
    private ArrayList<String> ePv;
    private a ePw;
    private String ePx;
    private Context mContext;
    private final Object mLock = new Object();

    public c(Context context, String[] strArr, String str) {
        this.mContext = context;
        this.ePu = Arrays.asList(strArr);
        this.ePx = str;
    }

    public final int getCount() {
        return this.ePu.size();
    }

    private String jl(int i) {
        return (String) this.ePu.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.mContext, g.auto_complete_dropdown_item, null);
            b bVar2 = new b();
            bVar2.ePz = (TextView) view.findViewById(f.textview1);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.ePz.setText(jl(i));
        view.setBackgroundResource(e.comm_list_item_selector);
        return view;
    }

    public final Filter getFilter() {
        if (this.ePw == null) {
            this.ePw = new a(this, (byte) 0);
        }
        return this.ePw;
    }
}
