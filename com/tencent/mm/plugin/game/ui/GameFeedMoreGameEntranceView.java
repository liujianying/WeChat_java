package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.sdk.platformtools.bi;

public class GameFeedMoreGameEntranceView extends RelativeLayout implements OnClickListener {
    private TextView ih;
    private e jUA;

    public GameFeedMoreGameEntranceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.ih = (TextView) findViewById(f.e.more_game_text);
        setOnClickListener(this);
    }

    public void setData(e eVar) {
        if (eVar == null || eVar.jLz == null || eVar.jLz.jQz == null) {
            setVisibility(8);
            return;
        }
        this.jUA = eVar;
        setVisibility(0);
        this.ih.setText(eVar.jLz.jQz.jOS);
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
