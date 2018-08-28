package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.widget.PopupWindow;
import com.tencent.mm.plugin.game.f.a;

class GameDropdownView$b extends PopupWindow {
    public GameDropdownView$b(Context context) {
        super(context);
        setWindowLayoutMode(-1, -2);
        setBackgroundDrawable(new BitmapDrawable());
        setFocusable(true);
        setOutsideTouchable(true);
        setTouchInterceptor(new 1(this));
        setAnimationStyle(a.game_dropdown);
    }
}
