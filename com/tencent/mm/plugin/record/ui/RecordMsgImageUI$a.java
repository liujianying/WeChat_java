package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.record.b.f;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MultiTouchImageView;
import java.util.LinkedList;
import java.util.List;

class RecordMsgImageUI$a extends BaseAdapter {
    long bJC;
    List<vx> hoC;
    f mtf;

    private RecordMsgImageUI$a() {
        this.hoC = new LinkedList();
        this.bJC = -1;
    }

    /* synthetic */ RecordMsgImageUI$a(byte b) {
        this();
    }

    public final int getCount() {
        return this.hoC.size();
    }

    /* renamed from: vo */
    public final vx getItem(int i) {
        return (vx) this.hoC.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        f fVar = this.mtf;
        vx vo = getItem(i);
        long j = this.bJC;
        Bitmap a = fVar.a(vo, j, false);
        if (a == null) {
            x.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", new Object[]{Boolean.valueOf(fVar.a(vo, j))});
            h.b(vo, j, r0);
        }
        if (a == null) {
            x.w("MicroMsg.ShowImageUI", "get image fail");
            if (view == null || (view instanceof MultiTouchImageView)) {
                view = View.inflate(viewGroup.getContext(), R.i.show_image_ui_item, null);
            }
            ((ImageView) view.findViewById(R.h.image_iv)).setImageResource(R.k.download_image_icon);
            view.setLayoutParams(new LayoutParams(-1, -1));
        } else {
            Context context = viewGroup.getContext();
            if (view == null || !(view instanceof MultiTouchImageView)) {
                view = new MultiTouchImageView(context, a.getWidth(), a.getHeight());
            } else {
                MultiTouchImageView multiTouchImageView = (MultiTouchImageView) view;
                multiTouchImageView.eT(a.getWidth(), a.getHeight());
            }
            k.k(view, a.getWidth(), a.getHeight());
            view.setLayoutParams(new LayoutParams(-1, -1));
            view.setImageBitmap(a);
            view.setMaxZoomDoubleTab(true);
        }
        return view;
    }
}
