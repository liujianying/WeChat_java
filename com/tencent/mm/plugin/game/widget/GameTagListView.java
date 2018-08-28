package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.f$d;
import com.tencent.mm.plugin.game.f.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public class GameTagListView extends LinearLayout {
    private int textColor;
    private int textSize;

    public GameTagListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.textColor = getResources().getColor(b.game_title_color);
        this.textSize = getResources().getDimensionPixelSize(c.GameNormalTextSize);
    }

    public final void e(LinkedList<String> linkedList, int i) {
        if (bi.cX(linkedList)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        while (getChildCount() < linkedList.size()) {
            View textView = new TextView(getContext());
            textView.setBackgroundResource(f$d.game_tag_text_style);
            textView.setMaxLines(1);
            textView.setTextColor(this.textColor);
            textView.setTextSize(0, (float) this.textSize);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(c.GameMiniPadding), 0);
            textView.setLayoutParams(layoutParams);
            addView(textView);
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i2;
            if (i3 >= linkedList.size()) {
                break;
            }
            String str = (String) linkedList.get(i3);
            x.d("MicroMsg.GameTagListView", str);
            TextView textView2 = (TextView) getChildAt(i3);
            textView2.setVisibility(0);
            textView2.setText(str);
            if (((float) getResources().getDimensionPixelSize(c.GameMiniPadding)) + (((textView2.getPaint().measureText(str) + ((float) textView2.getPaddingLeft())) + ((float) textView2.getPaddingRight())) + i4) > ((float) i)) {
                textView2.setVisibility(8);
                break;
            }
            i2 = i3 + 1;
        }
        while (i3 < getChildCount()) {
            i2 = i3 + 1;
            getChildAt(i3).setVisibility(8);
            i3 = i2;
        }
    }
}
