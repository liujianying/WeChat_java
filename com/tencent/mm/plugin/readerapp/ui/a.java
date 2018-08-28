package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.ui.r;

public abstract class a<T> extends r<T> implements OnScrollListener {
    private static final String TAG = ("MicroMsg." + a.class.getName());
    protected boolean iKs;

    public abstract boolean ayQ();

    public abstract int ayR();

    public abstract int bpU();

    public a(Context context, T t) {
        super(context, t);
        lB(true);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.iKs = false;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
