package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.game.d.v;
import com.tencent.mm.plugin.game.e.e$a.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;

public class GameFeedTitleDescView extends LinearLayout {
    private TextView gsY;
    private TextView hVS;
    private LinearLayout jYD;

    public GameFeedTitleDescView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        View inflate = LayoutInflater.from(getContext()).inflate(f.game_feed_title_desc_view, this, true);
        this.jYD = (LinearLayout) inflate.findViewById(e.user_title_container);
        this.gsY = (TextView) inflate.findViewById(e.title);
        this.hVS = (TextView) inflate.findViewById(e.desc);
    }

    public final void a(String str, String str2, LinkedList<v> linkedList) {
        int i = 0;
        if (bi.oW(str) && bi.oW(str2)) {
            setVisibility(8);
            return;
        }
        int i2;
        setVisibility(0);
        if (!bi.cX(linkedList)) {
            this.jYD.setVisibility(0);
            while (this.jYD.getChildCount() < linkedList.size() + 1) {
                View imageView = new ImageView(getContext());
                LayoutParams layoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(c.GameSmallAvatarSize), getResources().getDimensionPixelSize(c.GameSmallAvatarSize));
                layoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(c.GameMiniPadding), 0);
                layoutParams.gravity = 16;
                imageView.setScaleType(ScaleType.FIT_XY);
                this.jYD.addView(imageView, 0, layoutParams);
            }
            int i3 = 0;
            while (i3 < linkedList.size()) {
                v vVar = (v) linkedList.get(i3);
                ImageView imageView2 = (ImageView) this.jYD.getChildAt(i3);
                com.tencent.mm.plugin.game.e.e aVj = com.tencent.mm.plugin.game.e.e.aVj();
                String str3 = vVar.jPM;
                a aVar = new a();
                aVar.dXW = true;
                aVj.a(imageView2, str3, aVar.aVk(), null);
                imageView2.setVisibility(0);
                i3++;
            }
            while (i3 < this.jYD.getChildCount() - 1) {
                i2 = i3 + 1;
                this.jYD.getChildAt(i3).setVisibility(8);
                i3 = i2;
            }
            if (!bi.oW(str)) {
                ((TextView) this.jYD.getChildAt(i3)).setText(str);
            }
            this.gsY.setVisibility(8);
        } else if (bi.oW(str)) {
            this.gsY.setVisibility(8);
        } else {
            this.gsY.setText(str);
            this.gsY.setVisibility(0);
        }
        if (bi.oW(str2)) {
            this.hVS.setVisibility(8);
        } else {
            this.hVS.setText(str2);
            this.hVS.setVisibility(0);
        }
        TextView textView = this.gsY;
        i2 = (com.tencent.mm.plugin.game.e.c.getScreenWidth(getContext()) - ((ViewGroup) getParent()).getPaddingLeft()) - ((ViewGroup) getParent()).getPaddingRight();
        if (!bi.oW(str)) {
            i = textView.getPaint().measureText(str) > ((float) i2) ? 2 : 1;
        }
        if (i > 1) {
            this.hVS.setMaxLines(1);
        } else {
            this.hVS.setMaxLines(2);
        }
    }
}
