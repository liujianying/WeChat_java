package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.k;

public class MMCollapsibleTextView extends LinearLayout {
    private Context context;
    private TextView eZj;
    private boolean hasCheck = true;
    private Runnable iYm = new 2(this);
    private TextView nMp;
    private String nMq;
    private String nMr;
    private int nkZ;
    private SparseIntArray ttW = new SparseIntArray();

    static /* synthetic */ void c(MMCollapsibleTextView mMCollapsibleTextView) {
        mMCollapsibleTextView.hasCheck = true;
        switch (mMCollapsibleTextView.ttW.get(mMCollapsibleTextView.nkZ, -1)) {
            case 0:
                mMCollapsibleTextView.nMp.setVisibility(8);
                return;
            case 1:
                mMCollapsibleTextView.eZj.setMaxLines(10);
                mMCollapsibleTextView.nMp.setVisibility(0);
                mMCollapsibleTextView.nMp.setText(mMCollapsibleTextView.nMq);
                return;
            case 2:
                mMCollapsibleTextView.eZj.setMaxLines(Integer.MAX_VALUE);
                mMCollapsibleTextView.nMp.setVisibility(0);
                mMCollapsibleTextView.nMp.setText(mMCollapsibleTextView.nMr);
                return;
            default:
                mMCollapsibleTextView.hasCheck = false;
                mMCollapsibleTextView.nMp.setVisibility(8);
                mMCollapsibleTextView.eZj.setMaxLines(11);
                return;
        }
    }

    public MMCollapsibleTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        this.nMq = this.context.getString(k.spread);
        this.nMr = this.context.getString(k.shrinkup);
        View inflate = inflate(this.context, h.mm_collapsible_textview, this);
        inflate.setPadding(0, -3, 0, 0);
        this.eZj = (TextView) inflate.findViewById(g.desc_tv);
        this.nMp = (TextView) inflate.findViewById(g.desc_op_tv);
        this.nMp.setOnClickListener(new 1(this));
    }

    public int getSpreadHeight() {
        x.e("MicroMsg.CollapsibleTextView", "count:" + this.eZj.getLineCount() + "  height:" + this.eZj.getLineHeight());
        return (this.eZj.getLineCount() - 10) * this.eZj.getLineHeight();
    }

    public void setOpClickListener(OnClickListener onClickListener) {
        this.nMp.setOnClickListener(onClickListener);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.hasCheck) {
            this.hasCheck = true;
            if (this.eZj.getLineCount() <= 10) {
                this.ttW.put(this.nkZ, 0);
                return;
            }
            this.ttW.put(this.nkZ, 1);
            post(this.iYm);
        }
    }
}
