package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$LayoutParams;
import android.support.v7.widget.RecyclerView.k;
import android.util.AttributeSet;
import com.tencent.mm.R;
import com.tencent.mm.plugin.chatroom.a.a;
import com.tencent.mm.plugin.chatroom.a.b;
import java.util.Collection;

public class DayPickerView extends RecyclerView {
    private TypedArray hKJ;
    private a hKK;
    protected b hMr;
    protected int hMs;
    protected long hMt;
    private k hMu;
    private Collection<com.tencent.mm.plugin.chatroom.d.a> hMv;
    private long hMw;
    protected int ie;
    protected Context mContext;

    public DayPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DayPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hMs = 0;
        this.ie = 0;
        this.hMw = -1;
        if (!isInEditMode()) {
            this.hKJ = context.obtainStyledAttributes(attributeSet, R.n.DayPickerView);
            setLayoutParams(new RecyclerView$LayoutParams(-1, -1));
            setLayoutManager(new LinearLayoutManager());
            this.mContext = context;
            setVerticalScrollBarEnabled(false);
            setOnScrollListener(this.hMu);
            setFadingEdgeLength(0);
            this.hMu = new k() {
                public final void c(RecyclerView recyclerView, int i, int i2) {
                    super.c(recyclerView, i, i2);
                    if (((b) recyclerView.getChildAt(0)) != null) {
                        DayPickerView.this.hMt = (long) i2;
                        DayPickerView.this.ie = DayPickerView.this.hMs;
                    }
                }
            };
        }
    }

    public final void a(a aVar, Collection<com.tencent.mm.plugin.chatroom.d.a> collection) {
        this.hMv = collection;
        this.hKK = aVar;
        setUpAdapter(collection);
        setAdapter(this.hMr);
        bg(this.hMr.getItemCount() - 1);
        this.hMr.RR.notifyChanged();
    }

    public void setBeginDate(long j) {
        this.hMw = j;
    }

    protected void setUpAdapter(Collection<com.tencent.mm.plugin.chatroom.d.a> collection) {
        if (this.hMr == null) {
            this.hMr = new b(getContext(), this.hKK, this.hKJ, this.hMw, collection);
        }
    }

    public b.a<com.tencent.mm.plugin.chatroom.d.a> getSelectedDays() {
        return this.hMr.hKL;
    }

    protected a getController() {
        return this.hKK;
    }

    protected TypedArray getTypedArray() {
        return this.hKJ;
    }
}
