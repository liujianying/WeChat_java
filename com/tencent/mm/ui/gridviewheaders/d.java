package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

public final class d extends BaseAdapter implements b {
    private ListAdapter uuz;
    private DataSetObserver yY = new DataSetObserver() {
        public final void onChanged() {
            d.this.notifyDataSetChanged();
        }

        public final void onInvalidated() {
            d.this.notifyDataSetInvalidated();
        }
    };

    public d(ListAdapter listAdapter) {
        this.uuz = listAdapter;
        listAdapter.registerDataSetObserver(this.yY);
    }

    public final int getCount() {
        return this.uuz.getCount();
    }

    public final Object getItem(int i) {
        return this.uuz.getItem(i);
    }

    public final long getItemId(int i) {
        return this.uuz.getItemId(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.uuz.getView(i, view, viewGroup);
    }

    public final int FW(int i) {
        return 0;
    }

    public final int czk() {
        return 0;
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
