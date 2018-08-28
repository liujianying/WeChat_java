package com.tencent.mm.plugin.subapp.ui.gallery;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MultiTouchImageView;

class GestureGalleryUI$a extends BaseAdapter {
    final /* synthetic */ GestureGalleryUI osu;

    public GestureGalleryUI$a(GestureGalleryUI gestureGalleryUI) {
        this.osu = gestureGalleryUI;
    }

    public final int getCount() {
        x.d("MicroMsg.GestureGalleryUI", "lstpicurl:" + GestureGalleryUI.k(this.osu).size());
        return GestureGalleryUI.k(this.osu).size();
    }

    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this);
            view = View.inflate(this.osu, R.i.readerapp_imageview_item, null);
            aVar.nXq = (ProgressBar) view.findViewById(R.h.progressbar);
            aVar.osx = (MMAnimateView) view.findViewById(R.h.image);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        view.setLayoutParams(new LayoutParams(-1, -1));
        String str = (String) GestureGalleryUI.k(this.osu).get(i);
        if (!e.cn(str)) {
            str = GestureGalleryUI.n(this.osu).c(str, GestureGalleryUI.l(this.osu), i, GestureGalleryUI.m(this.osu));
        }
        if (bi.oW(str)) {
            aVar.nXq.setVisibility(0);
            aVar.osx.setVisibility(8);
        } else {
            Bitmap bitmap;
            aVar.nXq.setVisibility(8);
            if (str == null) {
                bitmap = null;
            } else {
                Options options = new Options();
                options.inJustDecodeBounds = true;
                bitmap = BitmapFactory.decodeFile(str, options);
                if (bitmap != null) {
                    x.i("MicroMsg.GestureGalleryUI", "recycle bitmap:%s", bitmap.toString());
                    bitmap.recycle();
                }
                bitmap = c.Wb(str);
                if (bitmap == null && MMNativeJpeg.IsJpegFile(str) && MMNativeJpeg.isProgressive(str)) {
                    Bitmap decodeAsBitmap = MMNativeJpeg.decodeAsBitmap(str);
                    String str2 = "MicroMsg.GestureGalleryUI";
                    String str3 = "Progressive jpeg, result isNull:%b";
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(decodeAsBitmap == null);
                    x.i(str2, str3, objArr);
                    bitmap = decodeAsBitmap;
                }
                if (bitmap == null) {
                    x.e("MicroMsg.GestureGalleryUI", "getSuitableBmp fail, temBmp is null, filePath = " + str);
                    bitmap = null;
                }
            }
            if (o.Wf(str)) {
                try {
                    aVar.osx.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                    aVar.osx.setVisibility(0);
                    aVar.osx.setImageFilePath(str);
                } catch (Throwable e) {
                    x.e("MicroMsg.GestureGalleryUI", bi.i(e));
                    aVar.osx.setVisibility(0);
                    aVar.osx.setImageBitmap(bitmap);
                }
            } else if (!(bitmap == null || bitmap.isRecycled())) {
                aVar.osx.setVisibility(8);
                view = new MultiTouchImageView(this.osu, bitmap.getWidth(), bitmap.getHeight());
                if (VERSION.SDK_INT == 20) {
                    view.setLayerType(1, null);
                } else {
                    k.k(view, bitmap.getWidth(), bitmap.getHeight());
                }
                view.setEnableHorLongBmpMode(false);
                view.setLayoutParams(new LayoutParams(-1, -1));
                view.setImageBitmap(bitmap);
            }
        }
        return view;
    }
}
