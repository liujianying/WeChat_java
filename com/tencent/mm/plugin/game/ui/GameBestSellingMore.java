package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f;
import com.tencent.mm.plugin.game.f$c;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.sdk.platformtools.bi;

public class GameBestSellingMore extends LinearLayout implements OnClickListener {
    private e jUA;
    private TextView jUB;
    private ImageView jUC;

    public GameBestSellingMore(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jUB = (TextView) findViewById(f.e.more_game_text);
        this.jUC = (ImageView) findViewById(f.e.more_game_arrow);
        setOnClickListener(this);
    }

    public void setData(e eVar) {
        this.jUA = eVar;
        if (eVar == null || eVar.jLz == null || eVar.jLz.jQx == null || bi.oW(eVar.jLz.jQx.jQG)) {
            this.jUB.setVisibility(8);
            this.jUC.setVisibility(8);
            setPadding(0, 0, 0, 0);
            return;
        }
        setPadding(getResources().getDimensionPixelSize(f$c.GameLargePadding), 0, getResources().getDimensionPixelSize(f$c.GameLargePadding), getResources().getDimensionPixelSize(f$c.GameLargePadding));
        this.jUB.setVisibility(0);
        this.jUC.setVisibility(0);
        this.jUB.setText(eVar.jLz.jQx.jQG);
    }

    public void onClick(View view) {
        if (this.jUA != null && this.jUA.jLz != null && this.jUA.jLz.jQx != null && !bi.oW(this.jUA.jLz.jQx.jQZ)) {
            an.a(getContext(), 10, 1022, 999, c.an(getContext(), this.jUA.jLz.jQx.jQZ), null, GameIndexListView.getSourceScene(), an.Dx(this.jUA.jLz.jPA));
        }
    }
}
