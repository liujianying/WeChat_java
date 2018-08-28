package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.luckymoney.b.i;
import java.util.LinkedList;
import java.util.List;

public abstract class d extends BaseAdapter {
    protected LayoutInflater Bc;
    protected List<i> kLz = new LinkedList();
    protected Context mContext;

    public d(Context context) {
        this.mContext = context;
        this.Bc = LayoutInflater.from(context);
    }

    public final void bw(List<i> list) {
        if (list == null) {
            this.kLz = new LinkedList();
        } else {
            this.kLz = list;
        }
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.kLz.size();
    }

    public final void a(i iVar) {
        this.kLz.remove(iVar);
    }

    /* renamed from: sm */
    public final i getItem(int i) {
        return (i) this.kLz.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
