package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MultiTouchImageView;

class CardGiftImageUI$a extends BaseAdapter {
    final /* synthetic */ CardGiftImageUI hDo;

    private CardGiftImageUI$a(CardGiftImageUI cardGiftImageUI) {
        this.hDo = cardGiftImageUI;
    }

    /* synthetic */ CardGiftImageUI$a(CardGiftImageUI cardGiftImageUI, byte b) {
        this(cardGiftImageUI);
    }

    public final int getCount() {
        return 1;
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        Bitmap oQ = y.oQ(CardGiftImageUI.b(this.hDo));
        if (oQ == null) {
            x.w("MicroMsg.CardGiftImageUI", "get image fail");
            if (view != null && !(view instanceof MultiTouchImageView)) {
                return view;
            }
            view = View.inflate(viewGroup.getContext(), e.card_image_ui_item, null);
            ((ImageView) view.findViewById(d.image_iv)).setImageResource(f.download_image_icon);
            view.setLayoutParams(new LayoutParams(-1, -1));
            return view;
        }
        Context context = viewGroup.getContext();
        if (view == null || !(view instanceof MultiTouchImageView)) {
            view = new MultiTouchImageView(context, oQ.getWidth(), oQ.getHeight());
        } else {
            MultiTouchImageView multiTouchImageView = (MultiTouchImageView) view;
            multiTouchImageView.eT(oQ.getWidth(), oQ.getHeight());
        }
        view.setLayoutParams(new LayoutParams(-1, -1));
        view.setImageBitmap(oQ);
        view.setMaxZoomDoubleTab(true);
        return view;
    }
}
