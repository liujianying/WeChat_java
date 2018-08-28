package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.sdk.platformtools.bi;

public class GameFeedAddTopicView extends LinearLayout implements OnClickListener {
    private e jUA;
    private GameFeedTitleDescView jXU;
    private TextView jXV;

    public GameFeedAddTopicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jXU = (GameFeedTitleDescView) findViewById(f.e.game_feed_title_desc);
        this.jXV = (TextView) findViewById(f.e.add_topic_text);
        setOnClickListener(this);
    }

    public void setData(e eVar) {
        if (eVar == null || eVar.jLz == null || eVar.jLz.jQy == null) {
            setVisibility(8);
            return;
        }
        this.jUA = eVar;
        setVisibility(0);
        this.jXU.a(eVar.jLz.jQy.bHD, eVar.jLz.jQy.jOS, null);
        this.jXV.setText(eVar.jLz.jQy.jPO);
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
