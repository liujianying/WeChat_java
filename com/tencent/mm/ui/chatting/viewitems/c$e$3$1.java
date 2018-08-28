package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.ui.chatting.viewitems.c.e.3;

class c$e$3$1 implements OnPreDrawListener {
    final /* synthetic */ Bitmap hIM;
    final /* synthetic */ 3 uaG;

    c$e$3$1(3 3, Bitmap bitmap) {
        this.uaG = 3;
        this.hIM = bitmap;
    }

    public final boolean onPreDraw() {
        this.uaG.uaC.uad.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = this.uaG.uaC.uad.getHeight();
        int width = this.uaG.uaC.uad.getWidth();
        if (height == 0) {
            height = a.ad(this.uaG.tZG.tTq.getContext(), R.f.chatting_music_item_height);
        }
        if (width == 0) {
            width = a.ad(this.uaG.tZG.tTq.getContext(), R.f.chatting_music_item_width);
        }
        this.uaG.uaC.uad.setBackgroundDrawable(new BitmapDrawable(c.a(this.hIM, R.g.chat_to_content_bg_mask, width, height)));
        return true;
    }
}
