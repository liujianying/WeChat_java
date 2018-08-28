package com.tencent.mm.ui.base.sortview;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.a.a;
import junit.framework.Assert;

public abstract class b extends BaseAdapter implements OnScrollListener, OnItemClickListener {
    protected Context mContext;
    public SparseArray<a> tDD;
    public Runnable tDE;

    public abstract a nu(int i);

    public abstract Object[] nv(int i);

    public b(Context context) {
        if (context == null) {
            throw new NullPointerException("context is null.");
        }
        this.mContext = context;
        this.tDD = new SparseArray();
        this.tDE = new 1(this);
    }

    public int getCount() {
        return this.tDD.size();
    }

    public int getItemViewType(int i) {
        if (getItem(i) == null) {
            x.d("MicroMsg.BaseMutilDataItemAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount(%d) , position(%d)", new Object[]{Integer.valueOf(getCount()), Integer.valueOf(i)});
            return 0;
        } else if (getItem(i) == null) {
            return 0;
        } else {
            return getItem(i).type;
        }
    }

    public int getViewTypeCount() {
        return 7;
    }

    /* renamed from: nx */
    public a getItem(int i) {
        if (i < 0 || i > getCount()) {
            x.e("MicroMsg.BaseMutilDataItemAdapter", "The given position(%d) is illegal.", new Object[]{Integer.valueOf(i)});
            return null;
        }
        a aVar = (a) this.tDD.get(i);
        if (aVar != null) {
            return aVar;
        }
        aVar = nu(i);
        this.tDD.put(i, aVar);
        return aVar;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        long currentTimeMillis = System.currentTimeMillis();
        a nx = getItem(i);
        if (nx == null) {
            x.e("MicroMsg.BaseMutilDataItemAdapter", "DataItem is null.");
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            a$b auQ = nx.auQ();
            if (auQ == null) {
                x.e("MicroMsg.BaseMutilDataItemAdapter", "ViewItem is null.");
            } else {
                a auR;
                if (view == null) {
                    view = auQ.b(this.mContext, view);
                    auR = nx.auR();
                    auQ.a(view, auR);
                    view.setTag(auR);
                } else {
                    auR = (a) view.getTag();
                }
                Object[] nv = nv(i);
                Assert.assertNotNull(auR);
                if (!nx.tDC) {
                    nx.a(this.mContext, auR, nv);
                }
                long currentTimeMillis3 = System.currentTimeMillis();
                auQ.a(this.mContext, auR, nx);
                long currentTimeMillis4 = System.currentTimeMillis();
                x.d("MicroMsg.BaseMutilDataItemAdapter", "position %d, getItem %d, inflate %d, filling data %d", new Object[]{Integer.valueOf(i), Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(currentTimeMillis3 - currentTimeMillis2), Long.valueOf(currentTimeMillis4 - currentTimeMillis3)});
            }
        }
        return view;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a nx = getItem(i);
        if (nx != null) {
            a$b auQ = nx.auQ();
            if (auQ != null && !auQ.a(this.mContext, nx, nv(i))) {
            }
        }
    }
}
