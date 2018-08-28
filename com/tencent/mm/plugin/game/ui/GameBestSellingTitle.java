package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.sdk.platformtools.bi;

public class GameBestSellingTitle extends LinearLayout {
    public GameBestSellingTitle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setText(String str) {
        if (bi.oW(str)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        ((TextView) findViewById(e.game_best_selling_item_title)).setText(str);
    }
}
