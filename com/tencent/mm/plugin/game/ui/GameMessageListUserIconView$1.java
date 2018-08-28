package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.plugin.game.e.e.b;

class GameMessageListUserIconView$1 extends b {
    final /* synthetic */ GameMessageListUserIconView kaS;
    final /* synthetic */ String val$url;

    GameMessageListUserIconView$1(GameMessageListUserIconView gameMessageListUserIconView, String str) {
        this.kaS = gameMessageListUserIconView;
        this.val$url = str;
    }

    public final void a(View view, Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            GameMessageListUserIconView.a(this.kaS).put(this.val$url, bitmap);
        }
    }
}
