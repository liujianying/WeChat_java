package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.sdk.platformtools.x;

public abstract class d extends BaseAdapter implements OnScrollListener, OnItemClickListener {
    String bWm;
    private int count;
    private OnScrollListener hRW;
    private e jwd;
    private SparseArray<a> jwe = new SparseArray();
    long jwf;
    a jwg;

    protected abstract boolean a(View view, a aVar, boolean z);

    protected abstract void aQx();

    protected abstract a qh(int i);

    public final Context getContext() {
        return this.jwd.getContext();
    }

    public d(e eVar) {
        x.i("MicroMsg.FTS.FTSBaseAdapter", "Create FTSBaseAdapter");
        this.jwd = eVar;
    }

    protected final void setCount(int i) {
        x.i("MicroMsg.FTS.FTSBaseAdapter", "setCount %d", new Object[]{Integer.valueOf(i)});
        this.count = i;
    }

    public int getCount() {
        return this.count;
    }

    public int getItemViewType(int i) {
        if (qj(i) != null) {
            return qj(i).hER;
        }
        x.e("MicroMsg.FTS.FTSBaseAdapter", "getItemViewType: get data item fail, return unknown Type, count=%d | position = %s", new Object[]{Integer.valueOf(getCount()), Integer.valueOf(i)});
        return -1;
    }

    public int getViewTypeCount() {
        return 21;
    }

    private a qj(int i) {
        if (this.jwe.indexOfKey(i) >= 0) {
            return (a) this.jwe.get(i);
        }
        a aVar = null;
        if (i >= 0 && i < getCount()) {
            aVar = qh(i);
        }
        if (aVar == null) {
            return (a) this.jwe.get(0);
        }
        this.jwe.put(i, aVar);
        return aVar;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a qj = qj(i);
        if (view == null) {
            view = qj.BV().a(getContext(), viewGroup);
        }
        a.a aVar = (a.a) view.getTag();
        if (!qj.jti) {
            qj.a(getContext(), aVar, new Object[0]);
            qj.jti = true;
        }
        qj.BV().a(getContext(), aVar, qj, new Object[0]);
        return view;
    }

    public final void CN(String str) {
        stopSearch();
        this.jwf = System.currentTimeMillis();
        this.bWm = str;
        x.i("MicroMsg.FTS.FTSBaseAdapter", "start search query=%s", new Object[]{str});
        aQx();
    }

    public void stopSearch() {
        this.count = 0;
        this.bWm = "";
        clearCache();
        notifyDataSetChanged();
    }

    public void finish() {
        stopSearch();
    }

    protected void clearCache() {
        this.jwe.clear();
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.hRW != null) {
            this.hRW.onScrollStateChanged(absListView, i);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.hRW != null) {
            this.hRW.onScroll(absListView, i, i2, i3);
        }
    }

    protected final void J(int i, boolean z) {
        if (this.jwg != null) {
            this.jwg.K(i, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.jwd.YC();
        if (i < getCount()) {
            a qj = qj(i);
            a(view, qj, qj.BV().a(getContext(), qj));
            this.jwd.a(qj);
        }
    }

    protected int aQg() {
        return getCount();
    }
}
