package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.mm.R;

public final class g {
    public View mParentView;
    public PopupWindow qqu;
    public a qqv;

    public g(Context context, View view) {
        this.mParentView = view;
        View inflate = LayoutInflater.from(context).inflate(R.i.wenote_editor_operate_window, null);
        inflate.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        this.qqu = new PopupWindow(inflate, -2, -2, false);
        this.qqu.setClippingEnabled(false);
        inflate.findViewById(R.h.wenote_delete_tv).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                g.this.qqu.dismiss();
                g.this.mParentView.setVisibility(8);
                if (g.this.qqv != null) {
                    g.this.qqv.bZT();
                }
            }
        });
        inflate.findViewById(R.h.wenote_copy_tv).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                g.this.qqu.dismiss();
                g.this.mParentView.setVisibility(8);
                if (g.this.qqv != null) {
                    g.this.qqv.bZU();
                }
            }
        });
        inflate.findViewById(R.h.wenote_cut_tv).setOnClickListener(new 3(this));
        inflate.findViewById(R.h.wenote_paste_tv).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                g.this.qqu.dismiss();
                g.this.mParentView.setVisibility(8);
                if (g.this.qqv != null) {
                    g.this.qqv.bZW();
                }
            }
        });
    }
}
