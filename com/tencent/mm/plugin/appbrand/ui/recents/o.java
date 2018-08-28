package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.ViewGroup;

abstract class o<_Data, _ViewHolder extends t> {
    public abstract _ViewHolder a(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public abstract void b(_ViewHolder _viewholder, _Data _data);

    public abstract long bn(_Data _data);

    o() {
    }

    public boolean a(_ViewHolder _viewholder, Object obj) {
        return false;
    }
}
