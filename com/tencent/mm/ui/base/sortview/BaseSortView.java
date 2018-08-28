package com.tencent.mm.ui.base.sortview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.VerticalScrollBar.a;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseSortView extends LinearLayout implements a {
    private OnItemSelectedListener DT;
    private OnItemClickListener UD;
    private ListView hqn;
    private int mMode;
    private VerticalScrollBar tDG;
    private View tDH;
    private c tDI = new c(getItemViewCreator());
    private OnItemLongClickListener tDJ;
    private List<d> tDK = new ArrayList();
    public boolean tDL;
    public boolean tDM;
    private a tDN;

    public abstract boolean a(String str, d dVar);

    public abstract c.a getItemViewCreator();

    public abstract ListView getListView();

    public abstract View getNoResultView();

    public abstract VerticalScrollBar getScrollBar();

    public abstract View inflate();

    public BaseSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflate();
        this.tDG = getScrollBar();
        this.hqn = getListView();
        this.tDH = getNoResultView();
        this.tDL = true;
        lP(true);
        this.hqn.setAdapter(this.tDI);
        if (this.tDG != null) {
            this.tDG.setOnScrollBarTouchListener(this);
        }
        this.tDI.registerDataSetObserver(new 1(this));
        this.hqn.setOnItemClickListener(new 2(this));
        this.hqn.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (BaseSortView.this.tDJ != null) {
                    return BaseSortView.this.tDJ.onItemLongClick(adapterView, view, i, j);
                }
                return false;
            }
        });
        this.hqn.setOnItemSelectedListener(new 4(this));
    }

    public void refresh() {
        ah.A(this.tDI.tDR);
    }

    public c getAdapter() {
        return this.tDI;
    }

    public final void dx(List<d> list) {
        if (this.mMode == 0 && this.tDK != list) {
            this.tDK.clear();
            if (list != null) {
                this.tDK.addAll(list);
            }
        }
        this.tDI.dx(list);
    }

    public final void aac(String str) {
        boolean z = true;
        if (this.mMode != 1) {
            x.w("MicroMsg.BaseSortView", "Can't doFilter successfully out of the search mode.");
            return;
        }
        boolean z2;
        boolean z3;
        List arrayList = new ArrayList();
        if (bi.oW(str)) {
            z2 = false;
        } else {
            arrayList.clear();
            for (d dVar : this.tDK) {
                if (a(str, dVar)) {
                    arrayList.add(dVar);
                }
            }
            z2 = true;
        }
        View view = this.hqn;
        if (!z2 || arrayList.size() <= 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        o(view, z3);
        View view2 = this.tDH;
        if (!z2 || arrayList.size() > 0) {
            z = false;
        }
        o(view2, z);
        dx(arrayList);
    }

    public List<d> getDatas() {
        return this.tDI.tDK;
    }

    public final void ys(String str) {
        int aad = this.tDI.aad(str);
        if (aad >= 0) {
            this.hqn.setSelection(aad);
        }
    }

    public OnItemClickListener getOnItemClickListener() {
        return this.UD;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.UD = onItemClickListener;
    }

    public OnItemLongClickListener getOnItemLongClickListener() {
        return this.tDJ;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.tDJ = onItemLongClickListener;
    }

    public OnItemSelectedListener getOnItemSelectedListener() {
        return this.DT;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.DT = onItemSelectedListener;
    }

    public int getMode() {
        return this.mMode;
    }

    public void setMode(int i) {
        if (i == 1) {
            this.mMode = 1;
            aac("");
            return;
        }
        this.mMode = 0;
        o(this.tDH, false);
        o(this.hqn, true);
        dx(this.tDK);
    }

    public static void o(View view, boolean z) {
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public final void lP(boolean z) {
        this.tDM = z;
        if (this.tDG != null) {
            this.tDG.setVisibility(z ? 0 : 8);
        }
    }

    public final void cso() {
        this.tDL = false;
        ah.A(this.tDI.tDR);
    }

    public a getDataSetObserver() {
        return this.tDN;
    }

    public void setDataSetObserver(a aVar) {
        this.tDN = aVar;
    }
}
