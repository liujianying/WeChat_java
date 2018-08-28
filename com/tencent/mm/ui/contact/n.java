package com.tencent.mm.ui.contact;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.a.a;
import junit.framework.Assert;

public abstract class n extends BaseAdapter {
    private SparseArray<a> sNR;
    public int scene;
    public l ujW;
    private boolean ujX;
    boolean ujY;

    public abstract a iW(int i);

    public n(l lVar, boolean z, int i, boolean z2) {
        this.ujW = lVar;
        this.ujX = z;
        this.sNR = new SparseArray();
        this.scene = i;
        this.ujY = z2;
    }

    public n(l lVar, boolean z, int i) {
        this(lVar, z, i, false);
    }

    public boolean bwq() {
        return this.ujX;
    }

    public final void mk(boolean z) {
        this.ujX = z;
        notifyDataSetChanged();
    }

    /* renamed from: FM */
    public final a getItem(int i) {
        if (this.sNR.indexOfKey(i) >= 0) {
            return (a) this.sNR.get(i);
        }
        if (i < 0 || i >= getCount()) {
            x.e("MicroMsg.MMSelectContactAdapter", "getItem Occur error !!!!!!!!! position = %d", new Object[]{Integer.valueOf(i)});
            return null;
        }
        a iW = iW(i);
        if (iW != null) {
            iW.hoR = c(iW);
            this.sNR.put(i, iW);
            x.d("MicroMsg.MMSelectContactAdapter", "put item to cache viewType=%d|position=%d", new Object[]{Integer.valueOf(iW.hER), Integer.valueOf(i)});
            return iW;
        }
        x.e("MicroMsg.MMSelectContactAdapter", "createDataItem Occur error !!!!!!!!! position = %d", new Object[]{Integer.valueOf(i)});
        return iW;
    }

    protected boolean c(a aVar) {
        return false;
    }

    public long getItemId(int i) {
        return -1;
    }

    public int getItemViewType(int i) {
        if (getItem(i) != null) {
            return getItem(i).hER;
        }
        x.e("MicroMsg.MMSelectContactAdapter", "getItemViewType: get data item fail, return unkown Type, totalCount=%d | position = %s", new Object[]{Integer.valueOf(getCount()), Integer.valueOf(i)});
        return -1;
    }

    public int getViewTypeCount() {
        return 8;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a FM = getItem(i);
        if (view == null) {
            view = FM.Wg().a(this.ujW.getActivity(), viewGroup);
        }
        a.a aVar = (a.a) view.getTag();
        Assert.assertNotNull(aVar);
        if (!FM.umn) {
            FM.ck(this.ujW.getActivity());
            FM.umn = true;
        }
        FM.ujX = bwq();
        FM.Wg().a(this.ujW.getActivity(), aVar, FM, this.ujW.b(FM), this.ujW.a(FM));
        return view;
    }

    public final void clearCache() {
        if (this.sNR != null) {
            this.sNR.clear();
        }
    }

    public void finish() {
        clearCache();
    }

    public boolean FN(int i) {
        return false;
    }
}
