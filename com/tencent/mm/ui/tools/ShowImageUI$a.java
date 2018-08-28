package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.c;
import com.tencent.mm.plugin.gif.e;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MultiTouchImageView;

class ShowImageUI$a extends BaseAdapter {
    String imagePath;
    final /* synthetic */ ShowImageUI uCd;

    private ShowImageUI$a(ShowImageUI showImageUI) {
        this.uCd = showImageUI;
    }

    /* synthetic */ ShowImageUI$a(ShowImageUI showImageUI, byte b) {
        this(showImageUI);
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
        if (o.Wf(this.imagePath)) {
            Context context = viewGroup.getContext();
            String str = this.imagePath;
            e eVar = new e(str);
            if (view == null || !(view instanceof MMAnimateView)) {
                view = new MMAnimateView(context);
            } else {
                MMAnimateView mMAnimateView = (MMAnimateView) view;
            }
            view.dk(str, str);
            view.a(str, new 1(this, view));
            if (view.getDrawable() != null && (view.getDrawable() instanceof c)) {
                ((c) view.getDrawable()).stop();
            }
            if (view.getDrawable() != null && (view.getDrawable() instanceof c)) {
                ((c) view.getDrawable()).start();
            }
        } else {
            Bitmap oQ = y.oQ(this.imagePath);
            if (oQ == null) {
                x.w("MicroMsg.ShowImageUI", "get image fail");
                if (view == null || (view instanceof MultiTouchImageView)) {
                    view = View.inflate(viewGroup.getContext(), R.i.show_image_ui_item, null);
                }
                ((ImageView) view.findViewById(R.h.image_iv)).setImageResource(R.k.download_image_icon);
                view.setLayoutParams(new LayoutParams(-1, -1));
            } else {
                Context context2 = viewGroup.getContext();
                if (view == null || !(view instanceof MultiTouchImageView)) {
                    view = new MultiTouchImageView(context2, oQ.getWidth(), oQ.getHeight());
                } else {
                    MultiTouchImageView view2 = (MultiTouchImageView) view2;
                    view2.eT(oQ.getWidth(), oQ.getHeight());
                }
                view2.setLayoutParams(new LayoutParams(-1, -1));
                view2.setImageBitmap(oQ);
                view2.setMaxZoomDoubleTab(true);
            }
        }
        return view2;
    }
}
