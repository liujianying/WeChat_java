package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.sdk.platformtools.bi;

public class GameFeedModuleTitle extends LinearLayout {
    private TextView gsY;

    public GameFeedModuleTitle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.gsY = (TextView) findViewById(e.game_feed_title);
    }

    public void setData(com.tencent.mm.plugin.game.model.e eVar) {
        if (eVar == null || bi.oW(eVar.jLy)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.gsY.setText(eVar.jLy);
    }
}
