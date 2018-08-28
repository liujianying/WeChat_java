package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

public class ExdeviceLikeView extends RelativeLayout {
    private int iDd;
    private a iDe;
    private int iDf;
    private TextView iDg;
    private ImageView iDh;
    private ProgressBar iDi;
    private Context mContext;

    static /* synthetic */ void c(ExdeviceLikeView exdeviceLikeView) {
        Animation loadAnimation = AnimationUtils.loadAnimation(exdeviceLikeView.mContext, R.a.like_view_anim);
        loadAnimation.setFillAfter(false);
        exdeviceLikeView.iDh.startAnimation(loadAnimation);
    }

    static /* synthetic */ int pj(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 0;
            case 2:
                return 2;
            default:
                x.w("MicroMsg.ExdeviceLikeView", "hy: state error");
                return 2;
        }
    }

    public ExdeviceLikeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.iDf = 2;
        this.mContext = context;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.i.exdevice_like_view, this, true);
        this.iDg = (TextView) inflate.findViewById(R.h.exdevice_like_num);
        this.iDh = (ImageView) inflate.findViewById(R.h.exdevice_like_icon);
        this.iDi = (ProgressBar) inflate.findViewById(R.h.exdevice_loading);
        setOnClickListener(new 1(this));
    }

    public ExdeviceLikeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setLikeNum(int i) {
        this.iDd = i;
        CharSequence charSequence = this.iDd;
        if (this.iDd < 0) {
            x.w("MicroMsg.ExdeviceLikeView", "hy: like num is negative. set to 0");
            charSequence = "0";
        } else if (i > 999) {
            x.d("MicroMsg.ExdeviceLikeView", "hy: like num exceeded the limit. put plus");
            charSequence = "999+";
        }
        if (this.iDd <= 0) {
            this.iDg.setVisibility(8);
        } else {
            this.iDg.setVisibility(0);
        }
        this.iDg.setText(charSequence);
    }

    public void setSelfLikeState(int i) {
        this.iDf = i;
        if (this.iDf == 1) {
            this.iDi.setVisibility(8);
            this.iDg.setVisibility(0);
            this.iDh.setVisibility(0);
            this.iDh.setImageResource(R.k.device_rank_item_liked);
        } else if (this.iDf == 0) {
            this.iDi.setVisibility(8);
            this.iDg.setVisibility(0);
            this.iDh.setVisibility(0);
            this.iDh.setImageResource(R.k.device_rank_item_unliked);
        } else if (this.iDf == 2) {
            this.iDg.setVisibility(8);
            this.iDi.setVisibility(0);
            this.iDh.setVisibility(8);
        } else {
            x.w("MicroMsg.ExdeviceLikeView", "hy: error state");
        }
    }

    public void setOnLikeViewClickListener(a aVar) {
        this.iDe = aVar;
    }
}
