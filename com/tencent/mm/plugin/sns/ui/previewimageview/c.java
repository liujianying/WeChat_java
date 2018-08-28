package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class c extends b {
    private HashMap<String, Bitmap> nQq = new HashMap();
    boolean nQt;
    private int olr;
    private boolean ols;
    private boolean olt;
    a olu;
    private int olv = 0;

    public c(Context context, List<?> list, boolean z, a aVar) {
        super(context);
        super.cu(cv(list));
        this.olr = 9;
        this.ols = z;
        this.olu = aVar;
        bEI();
        bEJ();
    }

    private List<d> cv(List<?> list) {
        List<d> arrayList = new ArrayList(list.size());
        int i = 0;
        for (Object next : list) {
            d dVar = new d(this, (byte) 0);
            dVar.data = next;
            int i2 = i + 1;
            dVar.id = i;
            arrayList.add(dVar);
            i = i2;
        }
        return arrayList;
    }

    private void bEI() {
        for (int i = 0; i < this.olq; i++) {
            d dVar = new d(this, (byte) 0);
            dVar.data = "";
            dVar.id = getCount();
            dVar.id = getCount();
            add(i, dVar);
        }
    }

    public final void bEJ() {
        x.v("DynamicGridAdapter", "showAddImg %s, getCount %d, getHeaderCount %d, maxShowCount %d， showing %s", new Object[]{Boolean.valueOf(this.ols), Integer.valueOf(getCount()), Integer.valueOf(this.olq), Integer.valueOf(this.olr), Boolean.valueOf(this.olt)});
        if (!this.ols || bEK() >= this.olr) {
            this.olt = false;
        } else if (!this.olt) {
            this.olt = true;
            add("");
        }
    }

    public final void clear() {
        super.clear();
        this.olt = false;
    }

    public final void cu(List<?> list) {
        super.cu(cv(list));
        bEI();
        bEJ();
    }

    public final int bEK() {
        return (getCount() - this.olq) - (this.olt ? 1 : 0);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        int screenWidth;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(g.sns_preview_view_item, viewGroup, false);
            bVar = new b(this, view, (byte) 0);
            view.setTag(f.img_preview_tag, bVar);
            ImageView imageView = bVar.bOA;
            if (this.olv == 0) {
                af.byd();
                screenWidth = s.getScreenWidth();
                if (screenWidth != 0) {
                    this.olv = ((screenWidth - (this.mContext.getResources().getDimensionPixelSize(d.sns_upload_previewimg_view_margin) * 4)) - (this.mContext.getResources().getDimensionPixelSize(d.LargerPadding) * 2)) / 3;
                }
            }
            LayoutParams layoutParams = (LayoutParams) imageView.getLayoutParams();
            layoutParams.width = this.olv;
            layoutParams.height = this.olv;
            imageView.setLayoutParams(layoutParams);
        } else {
            bVar = (b) view.getTag(f.img_preview_tag);
        }
        Object obj = getItem(i).toString();
        ImageView imageView2 = bVar.bOA;
        if (TextUtils.isEmpty(obj)) {
            imageView2.setBackgroundResource(com.tencent.mm.plugin.sns.i.c.sns_upload_add_bg);
            imageView2.setImageResource(i.album_post_add_picture_btn);
            imageView2.setContentDescription(bVar.bOA.getContext().getString(j.sns_add_photo));
            screenWidth = (bVar.olw.olv * 35) / 100;
            imageView2.setPadding(screenWidth, screenWidth, screenWidth, screenWidth);
            if (i > 0) {
                bVar.view.setTag(Integer.valueOf(-1));
            } else if (i < bVar.olw.olq) {
                bVar.view.setTag(Integer.valueOf(Integer.MAX_VALUE));
            }
        } else {
            bVar.view.setTag(Integer.valueOf(i - bVar.olw.olq));
            imageView2.setBackgroundDrawable(null);
            imageView2.setTag(obj);
            imageView2.setContentDescription(bVar.bOA.getContext().getString(j.sns_img));
            imageView2.setPadding(0, 0, 0, 0);
            Bitmap bitmap = (Bitmap) bVar.olw.nQq.get(obj);
            if (com.tencent.mm.plugin.sns.data.i.q(bitmap)) {
                imageView2.setImageBitmap(bitmap);
            } else {
                new c(bVar.olw, imageView2, obj).o(new String[]{""});
            }
        }
        if (i < this.olq) {
            bVar.bOA.setVisibility(4);
        } else {
            bVar.bOA.setVisibility(0);
            view.setVisibility(0);
        }
        return view;
    }

    public final int getItemViewType(int i) {
        if (TextUtils.isEmpty(getItem(i).toString())) {
            return 1;
        }
        return 0;
    }

    public final int getViewTypeCount() {
        return 2;
    }

    public final boolean xF(int i) {
        if (i < this.olq) {
            return false;
        }
        if (!this.olt) {
            return super.xF(i);
        }
        if (i != getCount() - 1) {
            return true;
        }
        return false;
    }

    public final boolean xG(int i) {
        if (i < this.olq) {
            return false;
        }
        if (!this.olt) {
            return super.xG(i);
        }
        if (i != getCount() - 1) {
            return true;
        }
        return false;
    }

    public final void dG(int i, int i2) {
        super.dG(i, i2);
        if (this.olu != null) {
            this.olu.dC(i - this.olq, i2 - this.olq);
        }
    }
}
