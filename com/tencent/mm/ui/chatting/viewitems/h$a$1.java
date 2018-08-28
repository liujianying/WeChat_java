package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.c.g;
import com.tencent.mm.ak.a.d.b;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.ui.chatting.viewitems.h.a;

class h$a$1 implements g {
    final /* synthetic */ a ubb;
    final /* synthetic */ Context val$context;

    h$a$1(a aVar, Context context) {
        this.ubb = aVar;
        this.val$context = context;
    }

    public final void me(String str) {
    }

    public final Bitmap a(String str, b bVar) {
        return null;
    }

    public final void a(String str, View view, b bVar) {
        if (bVar.bitmap != null) {
            final Bitmap bitmap = bVar.bitmap;
            this.ubb.uaY.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                public final boolean onPreDraw() {
                    Bitmap a;
                    h$a$1.this.ubb.uaY.getViewTreeObserver().removeOnPreDrawListener(this);
                    int height = h$a$1.this.ubb.uaY.getHeight();
                    int width = h$a$1.this.ubb.uaY.getWidth();
                    if (height == 0) {
                        height = com.tencent.mm.bp.a.ad(h$a$1.this.val$context, R.f.chatting_music_item_height);
                    }
                    if (width == 0) {
                        width = com.tencent.mm.bp.a.ad(h$a$1.this.val$context, R.f.chatting_music_item_width);
                    }
                    if (h$a$1.this.ubb.uaZ) {
                        a = c.a(bitmap, R.g.chat_from_content_bg_mask, width, height);
                    } else {
                        a = c.a(bitmap, R.g.chat_to_content_bg_mask, width, height);
                    }
                    h$a$1.this.ubb.uaY.setBackgroundDrawable(new BitmapDrawable(a));
                    return true;
                }
            });
        }
    }
}
