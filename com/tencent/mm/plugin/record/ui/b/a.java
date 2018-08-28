package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h$b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.k;
import java.util.HashMap;
import java.util.Map;

public final class a implements h$b {
    private ListView CU;
    k fUH;
    Map<String, mu> iYQ = new HashMap();
    private c iYS = new 4(this);
    private OnClickListener iZP = new 1(this);
    OnLongClickListener jcS = new 2(this);
    com.tencent.mm.plugin.record.ui.h.a msR;
    int mtu;

    public a(com.tencent.mm.plugin.record.ui.h.a aVar, ListView listView) {
        this.msR = aVar;
        this.CU = listView;
        com.tencent.mm.sdk.b.a.sFg.b(this.iYS);
    }

    public final View eb(Context context) {
        View inflate = View.inflate(context, R.i.record_listitem_image, null);
        this.mtu = com.tencent.mm.bp.a.fromDPToPix(context, 200);
        return inflate;
    }

    public final void a(View view, int i, b bVar) {
        ImageView imageView = (ImageView) view.findViewById(R.h.record_listitem_content);
        imageView.setTag(bVar);
        imageView.setOnClickListener(this.iZP);
        if (bVar.bjS == 1) {
            imageView.setOnLongClickListener(this.jcS);
        }
        com.tencent.mm.plugin.record.ui.h.a.b bVar2 = new com.tencent.mm.plugin.record.ui.h.a.b();
        if (bVar.bjS == 0) {
            bVar2.msT = bVar.bJC;
        } else if (bVar.bjS == 1) {
            bVar2.msT = bVar.msw.field_localId;
        }
        bVar2.bOz = bVar.bOz;
        bVar2.bOC = true;
        bVar2.maxWidth = this.mtu;
        Bitmap a = this.msR.a(bVar2);
        if (a != null) {
            x.d("MicroMsg.ImageViewWrapper", "get from dataId %s, cache %s", new Object[]{bVar2.bOz.jdM, a});
            a(imageView, a, R.k.fav_list_img_default, bVar.bOz.jdM);
            return;
        }
        au.Em().H(new 3(this, bVar, imageView));
    }

    final void a(ImageView imageView, Bitmap bitmap, int i, String str) {
        if (!((b) imageView.getTag()).bOz.jdM.equals(str)) {
            x.d("MicroMsg.ImageViewWrapper", "scroll over to next img. old tag %s, now tag %s", new Object[]{str, imageView.getTag()});
        } else if (bitmap == null) {
            LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.height = 200;
            layoutParams.width = 280;
            imageView.setImageResource(i);
            imageView.setBackgroundResource(R.e.light_grey);
        } else {
            Bitmap createBitmap;
            int i2;
            x.d("MicroMsg.ImageViewWrapper", "update view bmp[%d, %d], iv[%d, %d]", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(imageView.getWidth()), Integer.valueOf(imageView.getHeight())});
            LayoutParams layoutParams2 = imageView.getLayoutParams();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float f;
            float f2;
            if (height >= width) {
                f = ((float) height) / ((float) width);
                if (((double) f) > 2.5d) {
                    createBitmap = Bitmap.createBitmap(bitmap, 0, (bitmap.getHeight() - ((int) (((float) bitmap.getWidth()) * 2.5f))) / 2, bitmap.getWidth(), (int) (((float) bitmap.getWidth()) * 2.5f));
                    f2 = 2.5f;
                } else {
                    f2 = f;
                    createBitmap = bitmap;
                }
                if (f2 <= 2.0f) {
                    width = com.tencent.mm.bp.a.ae(imageView.getContext(), R.f.ChatImgLimitWidth);
                    i2 = (int) (((float) width) / f2);
                } else {
                    i2 = com.tencent.mm.bp.a.ae(imageView.getContext(), R.f.ChatImgMinWidth);
                    width = (int) (((float) i2) * f2);
                }
            } else {
                f = ((float) width) / ((float) height);
                if (((double) f) > 2.5d) {
                    createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - ((int) (((float) bitmap.getHeight()) * 2.5f))) / 2, 0, (int) (((float) bitmap.getHeight()) * 2.5f), bitmap.getHeight());
                    f2 = 2.5f;
                } else {
                    f2 = f;
                    createBitmap = bitmap;
                }
                if (f2 <= 2.0f) {
                    i2 = com.tencent.mm.bp.a.ae(imageView.getContext(), R.f.ChatImgLimitWidth);
                    width = (int) (((float) i2) / f2);
                } else {
                    width = com.tencent.mm.bp.a.ae(imageView.getContext(), R.f.ChatImgMinWidth);
                    i2 = (int) (((float) width) * f2);
                }
            }
            layoutParams2.width = i2;
            layoutParams2.height = width;
            imageView.setScaleType(ScaleType.FIT_XY);
            com.tencent.mm.sdk.platformtools.k.k(imageView, i2, width);
            if (imageView.getLayerType() == 1) {
                this.CU.setLayerType(1, null);
            }
            imageView.setImageBitmap(createBitmap);
            imageView.setBackgroundResource(0);
        }
    }

    public final void destroy() {
        com.tencent.mm.sdk.b.a.sFg.c(this.iYS);
    }

    public final void pause() {
    }
}
