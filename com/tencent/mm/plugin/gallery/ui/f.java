package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView$a;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.a.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem$MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class f extends RecyclerView$a<a> implements OnClickListener {
    private boolean jCW;
    private ArrayList<String> jDE;
    c jEj;
    private int jEk;
    ArrayList<String> jEl = new ArrayList();
    b jEm;
    private int jEn = -1;
    private int jEo = -1;
    private int jEp;
    private int jEq;
    private Drawable jEr;
    a jEs = new a(new 1(this));
    private Context mContext;

    public final /* synthetic */ void a(t tVar, int i, List list) {
        a aVar = (a) tVar;
        if (list.isEmpty()) {
            a(aVar, i);
            return;
        }
        GalleryItem$MediaItem a = a(i, aVar);
        if (a != null) {
            c(aVar.jBM, a.egA, i);
        }
    }

    public final void cH(int i, int i2) {
        this.jEq = i;
        this.jEp = i2;
    }

    public f(Context context, ArrayList<String> arrayList, int i, boolean z) {
        this.mContext = context;
        this.jDE = arrayList;
        this.jEl.addAll(arrayList);
        this.jEk = i;
        this.jCW = z;
        this.jEr = context.getResources().getDrawable(R.g.divider);
    }

    private void a(a aVar, int i) {
        GalleryItem$MediaItem a = a(i, aVar);
        if (a == null) {
            x.e("MicroMsg.PreviewSelectedImageAdapter", "get item failed");
            return;
        }
        LayoutParams layoutParams = aVar.jEz.getLayoutParams();
        int i2 = this.jEk;
        layoutParams.width = i2;
        layoutParams.height = i2;
        c(aVar.jBM, a.egA, i);
        aVar.jEz.setOnClickListener(this);
        if (this.jCW) {
            aVar.jEz.setTag(Integer.valueOf(aVar.jEA));
        } else {
            aVar.jEz.setTag(a.egA);
        }
        if (a.getType() == 2) {
            aVar.jBO.setVisibility(0);
            int round = Math.round(((float) ((long) ((VideoMediaItem) a).egD)) / 1000.0f);
            aVar.jBP.setText(String.format(Locale.CHINA, "%d:%02d", new Object[]{Integer.valueOf(round / 60), Integer.valueOf(round % 60)}));
        } else {
            aVar.jBO.setVisibility(8);
        }
        String aRw = a.aRw();
        String str = a.egA;
        if (bi.oW(aRw) && bi.oW(str)) {
            x.e("MicroMsg.PreviewSelectedImageAdapter", "null or nil filepath: " + i);
            return;
        }
        h.a(aVar.jBN, a.getType(), aRw, str, a.jAU, this.jEk, new 2(this, aVar));
        if ((c.aRf().aRI() == 3 || c.aRf().aRI() == 11) && a != null && a.mMimeType.equalsIgnoreCase("image/gif")) {
            aVar.jBU.setVisibility(0);
        } else {
            aVar.jBU.setVisibility(8);
        }
        if (a.mMimeType.equalsIgnoreCase("edit")) {
            aVar.jBV.setVisibility(0);
        } else {
            aVar.jBV.setVisibility(8);
        }
        aVar.jEy.setVisibility(8);
    }

    private void c(ImageView imageView, String str, int i) {
        int i2;
        if (this.jDE.contains(str)) {
            imageView.setBackground(null);
            imageView.setImageDrawable(this.jEr);
            i2 = 0;
        } else {
            imageView.setBackgroundColor(-1090519041);
            imageView.setImageDrawable(null);
            i2 = 1;
        }
        imageView.setVisibility(0);
        if (!bi.oW(this.jEj.jl(this.jEp)) && this.jEj.jl(this.jEp).equals(str)) {
            imageView.setVisibility(0);
            if (i2 != 0 && i == this.jEq) {
                imageView.setImageDrawable(this.jEr);
            }
        } else if (!bi.oW(this.jEj.jl(this.jEp)) && !this.jEj.jl(this.jEp).equals(str)) {
            if (i != this.jEq && i2 == 0) {
                imageView.setVisibility(8);
            } else if (i == this.jEq && i2 == 0) {
                imageView.setImageDrawable(this.jEr);
            }
        }
    }

    public final int getItemCount() {
        return this.jEl.size();
    }

    public final void onClick(View view) {
        if (this.jEm == null) {
            return;
        }
        if (this.jCW) {
            this.jEm.qH(((Integer) view.getTag()).intValue());
        } else {
            this.jEm.qH(this.jEl.indexOf(view.getTag()));
        }
    }

    private GalleryItem$MediaItem a(int i, a aVar) {
        if (i < 0 || i >= this.jEl.size()) {
            x.w("MicroMsg.PreviewSelectedImageAdapter", "error position %d, imagePaths size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.jEl.size())});
            return null;
        }
        String str = (String) this.jEl.get(i);
        GalleryItem$MediaItem a;
        int indexOf;
        Iterator it;
        GalleryItem$MediaItem galleryItem$MediaItem;
        if (this.jCW) {
            if (this.jEj.jBz == null) {
                return null;
            }
            a = GalleryItem$MediaItem.a(0, 0, str, str, "");
            indexOf = this.jEj.jBz.indexOf(a);
            if (indexOf >= 0) {
                aVar.jEA = indexOf;
                return (GalleryItem$MediaItem) this.jEj.jBz.get(indexOf);
            }
            it = c.aRk().iterator();
            while (it.hasNext()) {
                galleryItem$MediaItem = (GalleryItem$MediaItem) it.next();
                if (galleryItem$MediaItem.equals(a)) {
                    x.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", new Object[]{galleryItem$MediaItem.egA});
                    return galleryItem$MediaItem;
                }
            }
            return null;
        } else if (c.aRh() != null) {
            a = GalleryItem$MediaItem.a(0, 0, str, str, "");
            indexOf = c.aRh().indexOf(a);
            if (indexOf >= 0) {
                return (GalleryItem$MediaItem) c.aRh().get(indexOf);
            }
            it = c.aRk().iterator();
            while (it.hasNext()) {
                galleryItem$MediaItem = (GalleryItem$MediaItem) it.next();
                if (galleryItem$MediaItem.equals(a)) {
                    x.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", new Object[]{galleryItem$MediaItem.egA});
                    return galleryItem$MediaItem;
                }
            }
            return null;
        } else {
            return GalleryItem$MediaItem.a(1, 0, str, str, "");
        }
    }
}
