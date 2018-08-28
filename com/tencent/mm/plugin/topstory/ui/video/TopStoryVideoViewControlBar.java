package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.topstory.ui.b.a;
import com.tencent.mm.plugin.topstory.ui.b.d;
import com.tencent.mm.plugin.topstory.ui.b.e;
import com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar;
import com.tencent.mm.sdk.platformtools.ad;

public class TopStoryVideoViewControlBar extends WebSearchWebVideoViewControlBar {
    private View oBX;
    private TextView oBY;
    private ViewGroup oBZ;
    private int oCa;
    private a oCb;

    public TopStoryVideoViewControlBar(Context context) {
        super(context);
    }

    public TopStoryVideoViewControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TopStoryVideoViewControlBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected int getLayoutId() {
        return e.top_story_videoview_control_bar;
    }

    protected final void init() {
        super.init();
        this.oBX = this.contentView.findViewById(d.share_icon_iv);
        this.oBY = (TextView) this.contentView.findViewById(d.full_screen_video_title);
        this.oBZ = (ViewGroup) findViewById(d.play_total_time_tv_container);
        getExitFullscreenIv().getDrawable().setColorFilter(getResources().getColor(a.white), Mode.SRC_ATOP);
        this.oCa = com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 20);
    }

    public final void bIz() {
        super.bIz();
        this.oBX.setVisibility(0);
        this.oBY.setVisibility(0);
        this.oBZ.setPadding(0, 0, this.oCa, 0);
    }

    public final void ajc() {
        super.ajc();
        this.oBX.setVisibility(8);
        this.oBY.setVisibility(8);
        this.oBZ.setPadding(0, 0, 0, 0);
    }

    public void setShareBtnClickListener(OnClickListener onClickListener) {
        this.oBX.setOnClickListener(onClickListener);
    }

    public void setFullScreenTitle(String str) {
        this.oBY.setText(str);
    }

    public final void iD(boolean z) {
        this.pNl.setVisibility(0);
        super.iD(z);
    }

    protected final void yk(int i) {
        super.yk(i);
        if (this.oCb != null) {
            this.oCb.update(i, getBarLen());
        }
    }

    public void setOnUpdateProgressLenListener(a aVar) {
        this.oCb = aVar;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 8 || i == 4) {
            if (this.oCb != null) {
                this.oCb.bIy();
            }
        } else if (i == 0 && this.oCb != null) {
            this.oCb.bIx();
        }
    }
}
