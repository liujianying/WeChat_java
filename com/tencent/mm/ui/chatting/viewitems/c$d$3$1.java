package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.ui.chatting.viewitems.c.d.3;

class c$d$3$1 implements OnPreDrawListener {
    final /* synthetic */ Bitmap hIM;
    final /* synthetic */ 3 uaE;

    c$d$3$1(3 3, Bitmap bitmap) {
        this.uaE = 3;
        this.hIM = bitmap;
    }

    public final boolean onPreDraw() {
        this.uaE.uaC.uad.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = this.uaE.uaC.uad.getHeight();
        int width = this.uaE.uaC.uad.getWidth();
        if (height == 0) {
            height = a.ad(this.uaE.tZG.tTq.getContext(), R.f.chatting_music_item_height);
        }
        if (width == 0) {
            width = a.ad(this.uaE.tZG.tTq.getContext(), R.f.chatting_music_item_width);
        }
        this.uaE.uaC.uad.setBackgroundDrawable(new BitmapDrawable(c.a(this.hIM, R.g.chat_from_content_bg_mask, width, height)));
        return true;
    }
}
