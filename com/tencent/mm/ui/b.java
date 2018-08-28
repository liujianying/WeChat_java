package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.g;

public final class b {
    public TextView eCm;
    private ImageView jfx;
    private View qfa;
    public TextView tfV;
    private ImageView tfW;
    public ImageView tfX;
    private ImageView tfY;
    public ImageView tfZ;
    private View tga;

    public b(View view) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-2, -1);
        } else {
            layoutParams.width = -2;
            layoutParams.height = -1;
        }
        view.setLayoutParams(layoutParams);
        this.eCm = (TextView) view.findViewById(g.title_area);
        this.tfV = (TextView) view.findViewById(g.sub_title_area);
        this.tfW = (ImageView) view.findViewById(g.mute_icon);
        this.tfX = (ImageView) view.findViewById(g.phone_icon);
        this.tfY = (ImageView) view.findViewById(g.qmsg_icon);
        this.qfa = view.findViewById(g.arrow_area);
        this.jfx = (ImageView) view.findViewById(g.arrow_area_btn);
        this.tfZ = (ImageView) view.findViewById(g.reject_icon);
        this.tga = view;
    }

    public final void setTitle(CharSequence charSequence) {
        this.eCm.setText(charSequence);
        if (a.fi(this.eCm.getContext())) {
            this.eCm.setTextSize(0, ((float) a.ae(this.eCm.getContext(), e.ActionBarTextSize)) * a.fg(this.eCm.getContext()));
        }
    }

    public final void lq(boolean z) {
        this.tfW.setVisibility(z ? 0 : 8);
    }

    public final void lr(boolean z) {
        this.tfY.setVisibility(z ? 0 : 8);
    }

    public final void b(OnClickListener onClickListener) {
        this.qfa.setOnClickListener(onClickListener);
    }
}
