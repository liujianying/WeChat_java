package com.tencent.mm.ui.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

class MMGridPaperGridView$a extends BaseAdapter {
    final /* synthetic */ MMGridPaperGridView tvs;

    private MMGridPaperGridView$a(MMGridPaperGridView mMGridPaperGridView) {
        this.tvs = mMGridPaperGridView;
    }

    /* synthetic */ MMGridPaperGridView$a(MMGridPaperGridView mMGridPaperGridView, byte b) {
        this(mMGridPaperGridView);
    }

    public final boolean isEnabled(int i) {
        return MMGridPaperGridView.a(this.tvs) != null;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final int getCount() {
        return (MMGridPaperGridView.c(this.tvs) < 0 || MMGridPaperGridView.a(this.tvs) == null) ? 0 : MMGridPaperGridView.c(this.tvs);
    }

    public final Object getItem(int i) {
        return MMGridPaperGridView.a(this.tvs) == null ? null : MMGridPaperGridView.a(this.tvs).getItem(MMGridPaperGridView.b(this.tvs) + i);
    }

    public final long getItemId(int i) {
        return MMGridPaperGridView.a(this.tvs) == null ? 0 : MMGridPaperGridView.a(this.tvs).getItemId(MMGridPaperGridView.b(this.tvs) + i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        boolean z;
        long VG = bi.VG();
        String str = "MicroMsg.MMGridPaperGridView";
        String str2 = "getView:index[%d], pos[%d], converrView is null[%B], parent is [%s], mClearMode[%B]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(MMGridPaperGridView.d(this.tvs));
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Boolean.valueOf(view == null);
        objArr[3] = viewGroup.toString();
        objArr[4] = Boolean.valueOf(MMGridPaperGridView.e(this.tvs));
        x.v(str, str2, objArr);
        if (MMGridPaperGridView.e(this.tvs)) {
            view = null;
        }
        View d = MMGridPaperGridView.a(this.tvs) == null ? null : MMGridPaperGridView.a(this.tvs).d(MMGridPaperGridView.b(this.tvs) + i, view);
        if (d != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (-1 == MMGridPaperGridView.f(this.tvs) || MMGridPaperGridView.b(this.tvs) + i != MMGridPaperGridView.f(this.tvs)) {
            d.setVisibility(0);
        } else {
            d.setVisibility(4);
        }
        x.v("MicroMsg.MMGridPaperGridView", "get View ok: use %d ms, hidden index[%d], cur global index[%d]", new Object[]{Long.valueOf(bi.bI(VG)), Integer.valueOf(MMGridPaperGridView.f(this.tvs)), Integer.valueOf(MMGridPaperGridView.b(this.tvs) + i)});
        return d;
    }
}
