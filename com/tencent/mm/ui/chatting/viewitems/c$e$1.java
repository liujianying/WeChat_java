package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.viewitems.c.c;
import com.tencent.mm.ui.chatting.viewitems.c.e;

class c$e$1 implements OnPreDrawListener {
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ a tZG;
    private boolean uaB = false;
    final /* synthetic */ c uaC;
    final /* synthetic */ e uaF;

    c$e$1(e eVar, c cVar, a aVar, Bitmap bitmap) {
        this.uaF = eVar;
        this.uaC = cVar;
        this.tZG = aVar;
        this.abc = bitmap;
    }

    public final boolean onPreDraw() {
        if (this.uaB) {
            this.uaC.uad.getViewTreeObserver().removeOnPreDrawListener(this);
        } else {
            this.uaC.uad.getViewTreeObserver().removeOnPreDrawListener(this);
            this.uaB = true;
            int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(this.tZG.tTq.getContext(), 24);
            Bitmap bitmap = this.abc;
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = com.tencent.mm.sdk.platformtools.c.ah(this.tZG.tTq.getContext().getResources().getColor(R.e.chat_item_default_mucic_mask_color), fromDPToPix, fromDPToPix);
            }
            int height = bitmap.getHeight();
            if (fromDPToPix <= height) {
                height = fromDPToPix;
            }
            Bitmap e = com.tencent.mm.sdk.platformtools.c.e(com.tencent.mm.sdk.platformtools.c.T(Bitmap.createScaledBitmap(bitmap, height, height, true)), 20);
            height = this.uaC.uad.getHeight();
            int width = this.uaC.uad.getWidth();
            if (height == 0) {
                height = com.tencent.mm.bp.a.ad(this.tZG.tTq.getContext(), R.f.chatting_music_item_height);
            }
            if (width == 0) {
                width = com.tencent.mm.bp.a.ad(this.tZG.tTq.getContext(), R.f.chatting_music_item_width);
            }
            this.uaC.uad.setBackgroundDrawable(new BitmapDrawable(com.tencent.mm.sdk.platformtools.c.a(e, R.g.chat_to_content_bg_mask, width, height)));
        }
        return true;
    }
}
