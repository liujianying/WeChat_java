package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public class MMLoadMoreListView extends ListView {
    public View iln = null;
    private a tvW = null;
    private boolean tvX = false;
    private TextView tvY;
    private boolean tvZ = false;

    public MMLoadMoreListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMLoadMoreListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public final void crB() {
        this.iln = View.inflate(getContext(), h.mm_footerview, null);
        this.tvY = (TextView) this.iln.findViewById(g.footer_tips);
        this.iln.setVisibility(8);
    }

    private void init() {
        if (this.iln == null) {
            crB();
            addFooterView(this.iln);
            this.iln.setVisibility(8);
        }
    }

    public void setOnLoadMoreListener(a aVar) {
        this.tvW = aVar;
    }

    public final void crC() {
        this.tvX = true;
        setOnScrollListener(new 1(this));
    }

    public boolean getScroll2Top() {
        return this.tvZ;
    }

    public void setOnFootrClickListener(OnClickListener onClickListener) {
        this.tvY.setOnClickListener(onClickListener);
    }

    public void setFooterTips(String str) {
        this.tvY.setText(str);
    }

    public final void crD() {
        if (this.iln != null) {
            this.tvY.setVisibility(8);
            this.iln.setVisibility(8);
        }
    }

    public final void crE() {
        this.tvY.setVisibility(0);
        this.iln.setVisibility(0);
    }
}
