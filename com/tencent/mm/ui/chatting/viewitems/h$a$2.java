package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.ui.chatting.viewitems.h.a;

class h$a$2 implements OnPreDrawListener {
    final /* synthetic */ Bitmap abc;
    private boolean uaB = false;
    final /* synthetic */ a ubb;
    final /* synthetic */ Context val$context;

    h$a$2(a aVar, Context context, Bitmap bitmap) {
        this.ubb = aVar;
        this.val$context = context;
        this.abc = bitmap;
    }

    public final boolean onPreDraw() {
        if (this.uaB) {
            this.ubb.uaY.getViewTreeObserver().removeOnPreDrawListener(this);
        } else {
            this.ubb.uaY.getViewTreeObserver().removeOnPreDrawListener(this);
            this.uaB = true;
            int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(this.val$context, 24);
            Bitmap bitmap = this.abc;
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = c.ah(this.val$context.getResources().getColor(R.e.chat_item_default_mucic_mask_color), fromDPToPix, fromDPToPix);
            }
            int height = bitmap.getHeight();
            if (fromDPToPix <= height) {
                height = fromDPToPix;
            }
            Bitmap e = c.e(c.T(Bitmap.createScaledBitmap(bitmap, height, height, true)), 20);
            height = this.ubb.uaY.getHeight();
            int width = this.ubb.uaY.getWidth();
            if (height == 0) {
                height = com.tencent.mm.bp.a.ad(this.val$context, R.f.chatting_music_item_height);
            }
            if (width == 0) {
                width = com.tencent.mm.bp.a.ad(this.val$context, R.f.chatting_music_item_width);
            }
            if (this.ubb.uaZ) {
                bitmap = c.a(e, R.g.chat_from_content_bg_mask, width, height);
            } else {
                bitmap = c.a(e, R.g.chat_to_content_bg_mask, width, height);
            }
            this.ubb.uaY.setBackgroundDrawable(new BitmapDrawable(bitmap));
        }
        return true;
    }
}
