package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.f;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.sdk.platformtools.bi;

public class GameFeedVideoView extends LinearLayout implements OnClickListener {
    private e jUA;
    private GameFeedTitleDescView jXU;
    private FrameLayout jXX;
    private GameRoundImageView jYE;
    private LinearLayout jYF;
    private ImageView jYG;
    private TextView jYH;
    private GameFeedSubscriptView jYh;

    public GameFeedVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jXU = (GameFeedTitleDescView) findViewById(f.e.game_feed_title_desc);
        this.jXX = (FrameLayout) findViewById(f.e.video_ly);
        this.jYE = (GameRoundImageView) findViewById(f.e.video_cover_image);
        this.jYF = (LinearLayout) findViewById(f.e.video_desc);
        this.jYG = (ImageView) findViewById(f.e.video_redot);
        this.jYH = (TextView) findViewById(f.e.video_desc_text);
        this.jYh = (GameFeedSubscriptView) findViewById(f.e.subscript);
        setOnClickListener(this);
    }

    public void setVideoData(e eVar) {
        if (eVar == null || eVar.jLz == null || eVar.jLz.jQs == null || bi.oW(eVar.jLz.jQs.jOT)) {
            setVisibility(8);
            return;
        }
        this.jUA = eVar;
        ac acVar = eVar.jLz;
        setVisibility(0);
        this.jXU.a(acVar.jQs.bHD, acVar.jQs.jOS, null);
        com.tencent.mm.plugin.game.e.e.aVj().a(this.jYE, acVar.jQs.jOT, getResources().getDimensionPixelSize(c.GameImageTextWidth), getResources().getDimensionPixelSize(c.GameImageTextHeight), (com.tencent.mm.plugin.game.e.c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
        if (bi.oW(acVar.jQs.jTw)) {
            this.jYF.setVisibility(8);
        } else {
            this.jYF.setVisibility(0);
            this.jYG.setVisibility(8);
            this.jYH.setText(acVar.jQs.jTw);
        }
        this.jYh.setData(acVar);
    }

    public void setLiveData(e eVar) {
        if (eVar == null || eVar.jLz == null || eVar.jLz.jQt == null) {
            setVisibility(8);
            return;
        }
        this.jUA = eVar;
        ac acVar = eVar.jLz;
        setVisibility(0);
        this.jXU.a(acVar.jQt.bHD, acVar.jQt.jOS, null);
        if (bi.oW(acVar.jQt.jOT)) {
            this.jXX.setVisibility(8);
        } else {
            this.jXX.setVisibility(0);
            com.tencent.mm.plugin.game.e.e.aVj().a(this.jYE, acVar.jQt.jOT, getResources().getDimensionPixelSize(c.GameImageTextWidth), getResources().getDimensionPixelSize(c.GameImageTextHeight), (com.tencent.mm.plugin.game.e.c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
        }
        if (bi.oW(acVar.jQt.jSN)) {
            this.jYF.setVisibility(8);
        } else {
            this.jYF.setVisibility(0);
            this.jYG.setVisibility(0);
            this.jYH.setText(acVar.jQt.jSN);
        }
        this.jYh.setData(acVar);
        if (!this.jUA.jLB) {
            an.a(getContext(), 10, 1024, this.jUA.position, this.jUA.jLz.jQb, GameIndexListView.getSourceScene(), an.Dx(this.jUA.jLz.jPA));
            this.jUA.jLB = true;
        }
    }

    public void onClick(View view) {
        if (this.jUA != null && !bi.oW(this.jUA.jLz.jOU)) {
            an.a(getContext(), 10, 1024, this.jUA.position, com.tencent.mm.plugin.game.e.c.an(getContext(), this.jUA.jLz.jOU), this.jUA.jLz.jQb, GameIndexListView.getSourceScene(), an.Q(this.jUA.jLz.jPA, "clickType", "card"));
        }
    }
}
