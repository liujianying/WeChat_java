package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.GridView;
import com.tencent.mm.sdk.platformtools.x;

public final class MMGridPaperGridView extends GridView {
    private int mCount;
    private int mIndex;
    private OnItemClickListener osG = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (MMGridPaperGridView.this.tvq == null) {
                x.w("MicroMsg.MMGridPaperGridView", "on item click, but main adapter is null");
            }
        }
    };
    private int tvk;
    private int tvl;
    private int tvm;
    private int tvn = -1;
    private boolean tvo = false;
    a tvp;
    private j tvq;
    private OnItemLongClickListener tvr = new 2(this);

    public MMGridPaperGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMGridPaperGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final int getIndex() {
        return this.mIndex;
    }

    public final void a(int i, int i2, int i3, j jVar) {
        boolean z = true;
        String str = "MicroMsg.MMGridPaperGridView";
        String str2 = "index[%d], rows[%d], columns[%d], adapter is null[%B]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        if (jVar != null) {
            z = false;
        }
        objArr[3] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        this.mIndex = i;
        this.tvk = i2;
        this.tvl = i3;
        this.tvq = jVar;
        this.mCount = this.tvk * this.tvl;
        this.tvm = this.mIndex * this.mCount;
        if (this.tvq != null && this.tvq.getCount() - this.tvm < this.mCount) {
            this.mCount = this.tvq.getCount() - this.tvm;
        }
        if (getAdapter() == null) {
            x.w("MicroMsg.MMGridPaperGridView", "get adapter null, new one");
            this.tvp = new a(this, (byte) 0);
            setAdapter(this.tvp);
        }
        setNumColumns(this.tvl);
        setColumnWidth(3);
        setOnItemClickListener(this.osG);
        setOnItemLongClickListener(this.tvr);
    }

    public final void setHiddenIndex(int i) {
        this.tvn = i;
    }

    public final void setClearMode(boolean z) {
        this.tvo = z;
    }
}
