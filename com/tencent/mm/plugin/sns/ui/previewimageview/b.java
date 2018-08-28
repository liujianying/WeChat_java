package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public abstract class b extends a {
    ArrayList<Object> bA = new ArrayList();
    protected Context mContext;
    int olq;

    protected b(Context context) {
        this.mContext = context;
        this.olq = 3;
    }

    public void cu(List<?> list) {
        clear();
        ct(list);
        this.bA.addAll(list);
        notifyDataSetChanged();
    }

    public void clear() {
        this.olp.clear();
        this.bA.clear();
        notifyDataSetChanged();
    }

    public final void add(Object obj) {
        bT(obj);
        this.bA.add(obj);
        notifyDataSetChanged();
    }

    public final void add(int i, Object obj) {
        bT(obj);
        this.bA.add(i, obj);
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.bA.size();
    }

    public Object getItem(int i) {
        return this.bA.get(i);
    }

    public final int getColumnCount() {
        return this.olq;
    }

    public void dG(int i, int i2) {
        if (i2 < getCount()) {
            List list = this.bA;
            list.add(i2, list.remove(i));
            notifyDataSetChanged();
        }
    }

    public boolean xF(int i) {
        return true;
    }

    public boolean xG(int i) {
        return true;
    }

    protected final Context getContext() {
        return this.mContext;
    }
}
