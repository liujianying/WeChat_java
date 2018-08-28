package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.f;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.sdk.platformtools.bi;

public class GameFeedMatchView extends LinearLayout implements OnClickListener {
    private e jUA;
    private GameFeedTitleDescView jXU;
    private GameFeedSubscriptView jYh;
    private GameRoundImageView jYk;

    public GameFeedMatchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jXU = (GameFeedTitleDescView) findViewById(f.e.game_feed_title_desc);
        this.jYk = (GameRoundImageView) findViewById(f.e.big_image);
        this.jYh = (GameFeedSubscriptView) findViewById(f.e.subscript);
        setOnClickListener(this);
    }

    public void setData(e eVar) {
        if (eVar == null || eVar.jLz == null || eVar.jLz.jQu == null) {
            setVisibility(8);
            return;
        }
        this.jUA = eVar;
        ac acVar = eVar.jLz;
        setVisibility(0);
        this.jXU.a(acVar.jQu.bHD, acVar.jQu.jOS, null);
        if (bi.oW(acVar.jQu.jOT)) {
            setVisibility(8);
        } else {
            this.jYk.setVisibility(0);
            com.tencent.mm.plugin.game.e.e.aVj().a(this.jYk, acVar.jQu.jOT, getResources().getDimensionPixelSize(c.GameMatchImageWidth), getResources().getDimensionPixelSize(c.GameMatchImageHeight), (com.tencent.mm.plugin.game.e.c.getScreenWidth(getContext()) - getPaddingLeft()) - getPaddingRight());
        }
        this.jYh.setData(acVar);
        if (!this.jUA.jLB) {
            an.a(getContext(), 10, 1024, this.jUA.position, this.jUA.jLz.jQb, GameIndexListView.getSourceScene(), an.Dx(this.jUA.jLz.jPA));
            this.jUA.jLB = true;
        }
    }

    public void onClick(View view) {
        if (this.jUA != null && this.jUA.jLz != null && !bi.oW(this.jUA.jLz.jOU)) {
            an.a(getContext(), 10, 1024, this.jUA.position, com.tencent.mm.plugin.game.e.c.an(getContext(), this.jUA.jLz.jOU), this.jUA.jLz.jQb, GameIndexListView.getSourceScene(), an.Q(this.jUA.jLz.jPA, "clickType", "card"));
        }
    }
}
