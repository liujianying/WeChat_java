package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;

public class NearLifeErrorContent extends FrameLayout {
    private View contentView;
    private ListView eZb;
    private TextView lEt;
    private View lEu;
    private Context mContext;

    public NearLifeErrorContent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    public NearLifeErrorContent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        this.contentView = View.inflate(this.mContext, R.i.near_life_error_content, this);
        this.lEt = (TextView) this.contentView.findViewById(R.h.near_life_not_found);
        this.lEu = this.contentView.findViewById(R.h.nearby_life_locate_failed);
    }

    public void setListView(ListView listView) {
        this.eZb = listView;
    }

    public final void tW(int i) {
        switch (i) {
            case 0:
                this.lEt.setVisibility(8);
                this.lEu.setVisibility(8);
                this.eZb.setVisibility(0);
                return;
            case 1:
                this.lEt.setVisibility(0);
                this.lEu.setVisibility(8);
                this.eZb.setVisibility(8);
                return;
            case 2:
                this.lEt.setVisibility(8);
                this.lEu.setVisibility(0);
                this.eZb.setVisibility(8);
                return;
            default:
                return;
        }
    }
}
