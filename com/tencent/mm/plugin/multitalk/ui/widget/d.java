package com.tencent.mm.plugin.multitalk.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.pluginsdk.ui.a.b;

public final class d implements OnClickListener {
    private Context context;
    private View jxR;
    public LinearLayout lvA;
    public LinearLayout lvB;
    private int lvC;
    private int lvD;
    private int lvE = (b.lvh + b.lvg);
    private int lvF = ((b.lvh * 2) + b.lvg);
    private int lvG = (b.lvh * 4);
    public int lvH;
    private int lvh = b.lvh;
    private int lvn = b.lvn;
    private LinearLayout lvz;
    public int size = 0;

    public d(Activity activity) {
        this.context = activity.getBaseContext();
        int fk = a.fk(this.context) - (this.lvG * 2);
        this.lvC = (fk - (this.lvE * 10)) / 5;
        this.lvD = (fk - (this.lvF * 10)) / 5;
        fk = (this.lvD * 2) + (this.lvh * 12);
        this.jxR = activity.findViewById(R.h.padding_view);
        this.jxR.getLayoutParams().height = fk;
        this.lvz = (LinearLayout) activity.findViewById(R.h.avatar_container);
        LayoutParams layoutParams = (LayoutParams) this.lvz.getLayoutParams();
        layoutParams.topMargin = this.lvh * 2;
        layoutParams.bottomMargin = this.lvh * 2;
        layoutParams.leftMargin = this.lvG;
        layoutParams.rightMargin = this.lvG;
        this.lvz.setLayoutParams(layoutParams);
        this.lvA = new LinearLayout(this.context);
        this.lvB = new LinearLayout(this.context);
        this.lvA.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        this.lvB.setLayoutParams(layoutParams2);
        layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        View relativeLayout = new RelativeLayout(this.context);
        relativeLayout.addView(this.lvB);
        relativeLayout.setLayoutParams(layoutParams2);
        this.lvz.addView(this.lvA);
        this.lvz.addView(relativeLayout);
    }

    public final void setVisible(boolean z) {
        if (z) {
            this.jxR.setVisibility(0);
        } else {
            this.jxR.setVisibility(8);
        }
    }

    public final void HQ(String str) {
        this.size++;
        View imageView = new ImageView(this.context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setTag(str);
        imageView.setOnClickListener(this);
        b.a(imageView, str, 0.1f, false);
        if (this.size <= 5) {
            this.lvA.addView(imageView);
        } else {
            this.lvB.addView(imageView);
        }
        tm(this.size);
        tn(this.size);
    }

    public final void tm(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.lvA.getLayoutParams();
        LayoutParams layoutParams2 = (LayoutParams) this.lvB.getLayoutParams();
        if (i <= 5) {
            layoutParams.height = this.lvC;
            this.lvB.setVisibility(8);
            return;
        }
        layoutParams.height = this.lvD;
        layoutParams.topMargin = this.lvh * 2;
        layoutParams.bottomMargin = this.lvh * 2;
        this.lvB.setVisibility(0);
        layoutParams2.height = this.lvD;
        layoutParams2.topMargin = this.lvh * 2;
        layoutParams2.bottomMargin = this.lvh * 2;
    }

    public final void tn(int i) {
        int i2 = 0;
        int i3;
        LinearLayout.LayoutParams layoutParams;
        if (i <= 5) {
            for (i3 = 0; i3 < this.lvA.getChildCount(); i3++) {
                layoutParams = (LinearLayout.LayoutParams) this.lvA.getChildAt(i3).getLayoutParams();
                layoutParams.width = this.lvC;
                layoutParams.height = this.lvC;
                layoutParams.rightMargin = this.lvE;
                layoutParams.leftMargin = this.lvE;
            }
            while (i2 < this.lvB.getChildCount()) {
                layoutParams = (LinearLayout.LayoutParams) this.lvB.getChildAt(i2).getLayoutParams();
                layoutParams.width = this.lvD;
                layoutParams.height = this.lvD;
                layoutParams.rightMargin = this.lvE;
                layoutParams.leftMargin = this.lvE;
                i2++;
            }
            return;
        }
        for (i3 = 0; i3 < this.lvA.getChildCount(); i3++) {
            layoutParams = (LinearLayout.LayoutParams) this.lvA.getChildAt(i3).getLayoutParams();
            layoutParams.width = this.lvD;
            layoutParams.height = this.lvD;
            layoutParams.rightMargin = this.lvF;
            layoutParams.leftMargin = this.lvF;
        }
        while (i2 < this.lvB.getChildCount()) {
            layoutParams = (LinearLayout.LayoutParams) this.lvB.getChildAt(i2).getLayoutParams();
            layoutParams.width = this.lvD;
            layoutParams.height = this.lvD;
            layoutParams.rightMargin = this.lvF;
            layoutParams.leftMargin = this.lvF;
            i2++;
        }
    }

    public final void onClick(View view) {
        this.lvH++;
    }
}
