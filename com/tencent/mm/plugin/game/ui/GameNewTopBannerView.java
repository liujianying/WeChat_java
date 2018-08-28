package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class GameNewTopBannerView extends FrameLayout implements OnClickListener {
    String fHA = null;
    int jNv;
    ImageView jVs;
    ImageView jVt;
    int kbe;
    int kbf;
    String kbg = "";
    private String kbh = "";
    Context mContext;

    public GameNewTopBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jVs = (ImageView) findViewById(e.big_image);
        this.jVt = (ImageView) findViewById(e.small_image);
        x.i("MicroMsg.GameTopBannerView", "initView finished");
    }

    final int b(ImageView imageView, int i, int i2) {
        int screenWidth = c.getScreenWidth(this.mContext);
        LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams == null) {
            x.e("MicroMsg.GameTopBannerView", "resizeGameThemePic, params is null");
            return 0;
        }
        layoutParams.height = (int) (((float) screenWidth) * (((float) i) / ((float) i2)));
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ScaleType.FIT_XY);
        return layoutParams.height;
    }

    public void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof String)) {
            String str = (String) view.getTag();
            if (!bi.oW(str)) {
                an.a(this.mContext, 10, 1017, 1, c.r(this.mContext, str, "game_center_top_banner"), 0, null, this.jNv, 0, null, null, this.fHA);
            }
        }
    }

    static void aVc() {
        GameIndexListView.setDefaultPadding(0);
        GameIndexListView.setInitPadding(0);
        GameIndexListView.setCanPulldown(false);
    }
}
