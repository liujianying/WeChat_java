package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;

public class ExdeviceRankListHeaderView extends RelativeLayout {
    private TextView iFJ;
    private OnClickListener iFK;
    private Animation iFL;
    private Animation iFM;
    private Runnable iFN;
    private boolean iFO;
    private Context mContext;

    static /* synthetic */ void b(ExdeviceRankListHeaderView exdeviceRankListHeaderView) {
        ah.M(exdeviceRankListHeaderView.iFN);
        if (exdeviceRankListHeaderView.iFJ.getVisibility() == 4) {
            exdeviceRankListHeaderView.iFL.reset();
            exdeviceRankListHeaderView.iFJ.startAnimation(exdeviceRankListHeaderView.iFL);
            return;
        }
        exdeviceRankListHeaderView.iFM.reset();
        exdeviceRankListHeaderView.iFJ.startAnimation(exdeviceRankListHeaderView.iFM);
    }

    public ExdeviceRankListHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.iFO = true;
        co(context);
    }

    public ExdeviceRankListHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public ExdeviceRankListHeaderView(Context context) {
        super(context);
        this.iFO = true;
        co(context);
    }

    private void co(Context context) {
        this.mContext = context;
        this.iFJ = (TextView) LayoutInflater.from(this.mContext).inflate(R.i.exdevice_rank_header_view, this, true).findViewById(R.h.champion_motto);
        this.iFJ.setVisibility(4);
        this.iFL = AnimationUtils.loadAnimation(this.mContext, R.a.abc_fade_in);
        this.iFM = AnimationUtils.loadAnimation(this.mContext, R.a.abc_fade_out);
        this.iFN = new Runnable() {
            public final void run() {
                ExdeviceRankListHeaderView.this.iFJ.startAnimation(ExdeviceRankListHeaderView.this.iFM);
            }
        };
        this.iFL.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                ExdeviceRankListHeaderView.this.iFJ.setVisibility(0);
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                ExdeviceRankListHeaderView.this.iFM.reset();
                ah.i(ExdeviceRankListHeaderView.this.iFN, 4000);
            }
        });
        this.iFM.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                ExdeviceRankListHeaderView.this.iFJ.setVisibility(0);
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                ExdeviceRankListHeaderView.this.iFJ.setVisibility(4);
            }
        });
        this.iFL.setFillAfter(true);
        this.iFL.setFillEnabled(true);
        this.iFM.setFillAfter(true);
        this.iFM.setFillAfter(true);
        setOnClickListener(new 1(this));
    }

    public void setMotto(String str) {
        this.iFJ.setText(str);
    }

    public String getMotto() {
        return bi.aG(this.iFJ.getText().toString(), "");
    }

    public void setOnViewClickListener(OnClickListener onClickListener) {
        this.iFK = onClickListener;
    }

    public void setIsShowTip(boolean z) {
        this.iFO = z;
    }
}
