package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f;
import com.tencent.mm.plugin.game.f$c;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.sdk.platformtools.bi;

public class GameFeedImageTextView extends LinearLayout implements OnClickListener {
    private int hmV = 0;
    private e jUA;
    private GameFeedTitleDescView jXU;
    private GameRoundImageView jXY;
    private LinearLayout jYc;
    private GameRoundImageView jYd;
    private GameRoundImageView jYe;
    private GameRoundImageView jYf;
    private TextView jYg;
    private GameFeedSubscriptView jYh;
    private int jYi = 0;
    private int jYj;

    public GameFeedImageTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jXU = (GameFeedTitleDescView) findViewById(f.e.game_feed_title_desc);
        this.jXY = (GameRoundImageView) findViewById(f.e.big_image);
        this.jYc = (LinearLayout) findViewById(f.e.small_image_layout);
        this.jYd = (GameRoundImageView) findViewById(f.e.first_image);
        this.jYe = (GameRoundImageView) findViewById(f.e.second_image);
        this.jYf = (GameRoundImageView) findViewById(f.e.third_image);
        this.jYg = (TextView) findViewById(f.e.more_image_text);
        this.jYh = (GameFeedSubscriptView) findViewById(f.e.subscript);
        setOnClickListener(this);
        this.hmV = (c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight();
        this.jYi = (this.hmV - (a.fromDPToPix(getContext(), 10) * 2)) / 3;
        this.jYj = a.fromDPToPix(getContext(), 105);
        if (this.jYi < this.jYj) {
            this.jYj = this.jYi;
        }
        LayoutParams layoutParams = this.jYd.getLayoutParams();
        layoutParams.width = this.jYj;
        layoutParams.height = this.jYj;
        this.jYd.setLayoutParams(layoutParams);
        this.jYe.setLayoutParams(layoutParams);
        this.jYf.setLayoutParams(layoutParams);
    }

    public void setData(e eVar) {
        if (eVar == null || eVar.jLz == null || eVar.jLz.jQr == null) {
            setVisibility(8);
            return;
        }
        this.jUA = eVar;
        ac acVar = eVar.jLz;
        setVisibility(0);
        this.jXU.a(acVar.jQr.bHD, acVar.jQr.jSA, null);
        if (bi.cX(acVar.jQr.jSB)) {
            this.jXY.setVisibility(8);
            this.jYc.setVisibility(8);
        } else {
            int size = acVar.jQr.jSB.size();
            if (size == 1) {
                this.jYc.setVisibility(8);
                this.jXY.setVisibility(0);
                com.tencent.mm.plugin.game.e.e.aVj().a(this.jXY, (String) acVar.jQr.jSB.get(0), getResources().getDimensionPixelSize(f$c.GameImageTextWidth), getResources().getDimensionPixelSize(f$c.GameImageTextHeight), (c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
            } else {
                this.jXY.setVisibility(8);
                this.jYc.setVisibility(0);
                this.jYg.setVisibility(8);
                com.tencent.mm.plugin.game.e.e.a.a aVar = new com.tencent.mm.plugin.game.e.e.a.a();
                aVar.kdA = true;
                com.tencent.mm.plugin.game.e.e.a aVk = aVar.aVk();
                com.tencent.mm.plugin.game.e.e.aVj().a(this.jYd, (String) acVar.jQr.jSB.get(0), aVk);
                com.tencent.mm.plugin.game.e.e.aVj().a(this.jYe, (String) acVar.jQr.jSB.get(1), aVk);
                if (size > 2) {
                    com.tencent.mm.plugin.game.e.e.aVj().a(this.jYf, (String) acVar.jQr.jSB.get(2), aVk);
                    this.jYf.setVisibility(0);
                    if (size > 3) {
                        this.jYg.setVisibility(0);
                        this.jYg.setText(String.format("共%d张", new Object[]{Integer.valueOf(size)}));
                    }
                } else {
                    this.jYf.setVisibility(4);
                }
            }
        }
        this.jYh.setData(acVar);
        if (!this.jUA.jLB) {
            an.a(getContext(), 10, 1024, this.jUA.position, this.jUA.jLz.jQb, GameIndexListView.getSourceScene(), an.Dx(this.jUA.jLz.jPA));
            this.jUA.jLB = true;
        }
    }

    public void onClick(View view) {
        if (this.jUA != null && this.jUA.jLz != null && !bi.oW(this.jUA.jLz.jOU)) {
            an.a(getContext(), 10, 1024, this.jUA.position, c.an(getContext(), this.jUA.jLz.jOU), this.jUA.jLz.jQb, GameIndexListView.getSourceScene(), an.Q(this.jUA.jLz.jPA, "clickType", "card"));
        }
    }
}
