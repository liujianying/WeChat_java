package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.pointers.PIntArray;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMHorList;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import java.io.InputStream;
import java.lang.reflect.Array;

public class FilterImageView extends LinearLayout {
    static c[] uxc = new c[]{new c(new b("原图", "原圖", "Normal"), "icon.png", 0, 0, "MatteOrigin.jpg", 0), new c(new b("LOMO", "LOMO", "LOMO"), "nuowei_mask%02d.jpg", 2, 1, "0004.jpg", 2), new c(new b("麦田", "麥田", "Wheat"), "0062_%02d.jpg", 2, 2, "0062.jpg", 20), new c(new b("玻璃镜", "玻璃鏡", "Glossy"), "habi_mask%02d.jpg", 1, 3, "0005.jpg", 4), new c(new b("拍立得", "拍立得", "Polaroid"), "0063_%02d.jpg", 2, 4, "0063.jpg", 21), new c(new b("湖水", "湖水", "Lake"), "0061_%02d.jpg", 1, 5, "0061.jpg", 19), new c(new b("黄昏", "黃昏", "Twilight"), "0030_mask%01d.jpg", 1, 6, "0030.jpg", 7), new c(new b("黑白", "黑白", "B&W"), "0065_%02d.jpg", 1, 7, "0065.jpg", 22), new c(new b("铜版画", "銅版畫", "Aquatint"), "0032_mask%01d.jpg", 1, 8, "0032.jpg", 9), new c(new b("圆珠笔", "圓珠筆", "Pen"), "0035_mask%01d.jpg", 1, 9, "0035.jpg", 18), new c(new b("海报", "海報", "Poster"), "0036_mask%01d.jpg", 0, 10, "0036.jpg", 17), new c(new b("素描", "素描", "Portrait"), "icon.jpg", 0, 11, "0040.jpg", 12)};
    private Activity bOb;
    private int nkW = 0;
    int[] uwT;
    private View uwU;
    private ImageView uwV;
    CropImageView uwW;
    Bitmap uwX;
    private MMHorList uwY;
    private a uwZ;
    private Runnable uxa;
    private Runnable uxb;

    class a extends BaseAdapter {
        int kJp = 0;

        a() {
        }

        public final int getCount() {
            return FilterImageView.uxc.length;
        }

        public final Object getItem(int i) {
            return FilterImageView.uxc[i];
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            c cVar = (c) getItem(i);
            if (view == null || !(view.getTag() instanceof a)) {
                view = View.inflate(FilterImageView.this.bOb, h.filter_selecter_item, null);
                a aVar2 = new a(this);
                aVar2.ePz = (TextView) view.findViewById(g.filter_selecter_tv);
                aVar2.uxe = (ImageView) view.findViewById(g.filter_selecter_img);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
                if (aVar.uxf != null) {
                    x.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[]{aVar.uxf.toString()});
                    aVar.uxf.recycle();
                }
            }
            TextView textView = aVar.ePz;
            b bVar = cVar.uxj;
            String chP = w.chP();
            CharSequence charSequence = chP.equals("zh_CN") ? bVar.tUY : (chP.equals("zh_TW") || chP.equals("zh_HK")) ? bVar.uxh : bVar.uxi;
            textView.setText(charSequence);
            try {
                InputStream open = FilterImageView.this.bOb.getAssets().open("filter/" + cVar.bWP);
                aVar.uxf = com.tencent.mm.sdk.platformtools.c.decodeStream(open);
                open.close();
                aVar.uxe.setImageBitmap(aVar.uxf);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FilterView", e, "", new Object[0]);
            }
            view.setLayoutParams(new LayoutParams(-2, -2));
            if (i == this.kJp) {
                view.findViewById(g.filter_selecter_img).setBackgroundResource(f.camera_filter_reviewbox_checked);
            } else {
                view.findViewById(g.filter_selecter_img).setBackgroundResource(f.camera_filter_reviewbox_normal);
            }
            return view;
        }
    }

    static class c {
        String bWP;
        b uxj;
        String uxk;
        int uxl;
        int uxm;
        int uxn;

        c(b bVar, String str, int i, int i2, String str2, int i3) {
            this.uxj = bVar;
            this.uxk = str;
            this.uxl = i;
            this.uxm = i2;
            this.bWP = str2;
            this.uxn = i3;
        }
    }

    public FilterImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bOb = (Activity) context;
        View inflate = View.inflate(this.bOb, h.crop_image_filter, this);
        this.uwW = (CropImageView) inflate.findViewById(g.cropimage_filter_show_iv);
        this.uwV = (ImageView) inflate.findViewById(g.cropimage_iv);
        this.uwU = inflate.findViewById(g.cropimage_frame);
        this.uwW.setOnTouchListener(null);
        this.uwY = (MMHorList) inflate.findViewById(g.cropimage_filter_gallery);
        this.uwZ = new a();
        this.uwY.setAdapter(this.uwZ);
        this.uwY.invalidate();
        this.uwY.setOnItemClickListener(new 1(this));
    }

    public void setOnConfirmImp(Runnable runnable) {
        this.uxa = runnable;
    }

    public void setOnExitImp(Runnable runnable) {
        this.uxb = runnable;
    }

    public Bitmap getFilterBmp() {
        return this.uwX;
    }

    public void setLimitZoomIn(boolean z) {
        if (this.uwW != null) {
            this.uwW.setLimitZoomIn(z);
        }
    }

    public void setMatrix(Matrix matrix) {
        if (this.uwW != null) {
            this.uwW.setImageMatrix(matrix);
        }
    }

    public void setImage(Bitmap bitmap) {
        this.uwX = bitmap;
    }

    public CropImageView getCropImageIV() {
        return this.uwW;
    }

    public View getCropAreaView() {
        return this.uwU;
    }

    public void setCropMaskVisible(int i) {
        if (this.uwV != null) {
            this.uwV.setVisibility(i);
        }
    }

    public void setCropMaskBackground(int i) {
        if (this.uwV != null) {
            this.uwV.setBackgroundResource(i);
        }
    }

    public final void dt(String str, int i) {
        x.i("MicroMsg.FilterView", "filePath before fiterBmp:" + str);
        if (this.uwX == null || this.uwX.isRecycled()) {
            this.uwX = com.tencent.mm.sdk.platformtools.c.b(com.tencent.mm.sdk.platformtools.c.e(str, 480, 480, false), (float) i);
        }
        x.d("MicroMsg.FilterView", "filterBmp w:" + this.uwX.getWidth() + " h:" + this.uwX.getHeight());
        this.uwT = new int[(this.uwX.getWidth() * this.uwX.getHeight())];
        this.uwX.getPixels(this.uwT, 0, this.uwX.getWidth(), 0, 0, this.uwX.getWidth(), this.uwX.getHeight());
        this.uwW.setImageBitmap(this.uwX);
    }

    public void setVisibility(int i) {
        if (i == 0) {
            this.uwZ.notifyDataSetChanged();
            this.uwY.invalidate();
        }
        super.setVisibility(i);
    }

    public int getFilterId() {
        return this.nkW;
    }

    private boolean aq(String str, int i, int i2) {
        if (i2 == 0) {
            this.uwX.setPixels(this.uwT, 0, this.uwX.getWidth(), 0, 0, this.uwX.getWidth(), this.uwX.getHeight());
            this.uwW.invalidate();
            return true;
        }
        int width = this.uwX.getWidth() * this.uwX.getHeight();
        x.d("MicroMsg.FilterView", "len:" + width + "  maskCount:" + i);
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{i, width});
        int i3 = 0;
        while (i3 < i) {
            InputStream inputStream = null;
            try {
                inputStream = this.bOb.getAssets().open("filter/" + String.format(str, new Object[]{Integer.valueOf(i3)}));
                byte[] bArr = new byte[width];
                inputStream.read(bArr);
                Bitmap bs = com.tencent.mm.sdk.platformtools.c.bs(bArr);
                inputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bs == null) {
                    return false;
                }
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bs, this.uwX.getWidth(), this.uwX.getHeight(), true);
                if (bs != createScaledBitmap) {
                    x.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[]{bs.toString()});
                    bs.recycle();
                }
                if (createScaledBitmap == null) {
                    return false;
                }
                createScaledBitmap.getPixels(iArr[i3], 0, createScaledBitmap.getWidth(), 0, 0, createScaledBitmap.getWidth(), createScaledBitmap.getHeight());
                x.i("MicroMsg.FilterView", "recycle bitmap:%s", new Object[]{createScaledBitmap.toString()});
                createScaledBitmap.recycle();
                i3++;
            } catch (Exception e) {
                throw e;
            } catch (Throwable th) {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        }
        PIntArray pIntArray = new PIntArray();
        x.e("MicroMsg.FilterView", "src.len:" + this.uwT.length);
        for (int i4 = 0; i4 < iArr.length; i4++) {
            x.e("MicroMsg.FilterView", "mask[" + i4 + "].len:" + iArr[i4].length);
        }
        x.e("MicroMsg.FilterView", "before filter");
        ImgFilter.FilterInt(i2, this.uwT, iArr, i, this.uwX.getWidth(), this.uwX.getHeight(), pIntArray);
        x.e("MicroMsg.FilterView", "after filter");
        this.uwX.setPixels(pIntArray.value, 0, this.uwX.getWidth(), 0, 0, this.uwX.getWidth(), this.uwX.getHeight());
        this.uwW.invalidate();
        return true;
    }
}
