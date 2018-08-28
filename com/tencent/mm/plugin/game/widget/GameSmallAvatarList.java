package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.e.e$a.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;

public class GameSmallAvatarList extends LinearLayout {
    public GameSmallAvatarList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setData(LinkedList<String> linkedList) {
        if (bi.cX(linkedList)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        while (getChildCount() < linkedList.size()) {
            View imageView = new ImageView(getContext());
            LayoutParams layoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(c.GameSmallAvatarSize), getResources().getDimensionPixelSize(c.GameSmallAvatarSize));
            layoutParams.setMargins(0, 0, getResources().getDimensionPixelSize(c.GameMiniPadding), 0);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ScaleType.FIT_XY);
            addView(imageView);
        }
        int i = 0;
        while (i < linkedList.size()) {
            a aVar = new a();
            aVar.dXW = true;
            e.aVj().a((ImageView) getChildAt(i), (String) linkedList.get(i), aVar.aVk());
            getChildAt(i).setVisibility(0);
            i++;
        }
        while (i < getChildCount()) {
            int i2 = i + 1;
            getChildAt(i).setVisibility(8);
            i = i2;
        }
    }
}
