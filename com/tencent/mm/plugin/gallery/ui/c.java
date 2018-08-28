package com.tencent.mm.plugin.gallery.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.m;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.WxImageView;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.e.b.a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class c extends t {
    private Bitmap byb = null;
    ArrayList<MediaItem> jBz = new ArrayList();
    ArrayList<String> jCV = new ArrayList();
    boolean jCW;
    HashSet<String> jCX = new HashSet();
    int jCY = -1;
    View jCZ = null;
    boolean jDa = false;
    private HashMap<String, WeakReference<b>> jDb = new HashMap();
    public e jDc = new e(this);
    public d jDd = new d(this);
    Context mContext;

    static class b {
        MultiTouchImageView jDf;
        TextView jDg;
        ImageView jeF;

        b() {
        }
    }

    public final /* synthetic */ Object c(int i, View view) {
        Object view2;
        b bVar;
        String str;
        MediaItem mediaItem;
        String str2;
        long VG = bi.VG();
        if (view2 == null) {
            view2 = View.inflate(this.mContext, R.i.image_gallery_plugin_item, null);
            b bVar2 = new b();
            bVar2.jDf = (MultiTouchImageView) view2.findViewById(R.h.image);
            bVar2.jeF = (ImageView) view2.findViewById(R.h.video_mask);
            bVar2.jDg = (TextView) view2.findViewById(R.h.video_info);
            view2.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view2.getTag();
        }
        String str3;
        if (this.jCW) {
            MediaItem mediaItem2 = (MediaItem) this.jBz.get(i);
            str3 = mediaItem2.egA;
            str = mediaItem2.iSr;
            mediaItem = mediaItem2;
            str2 = str3;
        } else {
            str3 = (String) this.jCV.get(i);
            if (com.tencent.mm.plugin.gallery.model.c.aRh() != null) {
                int indexOf = com.tencent.mm.plugin.gallery.model.c.aRh().indexOf(MediaItem.a(0, 0, str3, str3, ""));
                if (indexOf >= 0) {
                    mediaItem = (MediaItem) com.tencent.mm.plugin.gallery.model.c.aRh().get(indexOf);
                    str = null;
                    str2 = str3;
                }
            }
            mediaItem = null;
            str = null;
            str2 = str3;
        }
        if (mediaItem == null || mediaItem.getType() != 2) {
            if (com.tencent.mm.plugin.gallery.model.c.aRf().aRI() == 3 && mediaItem != null && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                bVar.jDg.setText(this.mContext.getString(R.l.gallery_gif_size, new Object[]{bi.bF(new File(str2).length())}));
                bVar.jDg.setVisibility(0);
            } else {
                bVar.jDg.setVisibility(8);
            }
            bVar.jeF.setVisibility(8);
            bVar.jeF.setOnClickListener(null);
        } else {
            bVar.jDg.setVisibility(8);
            bVar.jeF.setVisibility(0);
            bVar.jeF.setOnClickListener(new a(this, str2));
            if (com.tencent.mm.plugin.gallery.model.c.aRf().aRI() == 4) {
                m mVar = new m(mediaItem.egA, i, (VideoMediaItem) mediaItem, null);
                if (e.X(mVar)) {
                    x.d("MicroMsg.ImageAdapter", "analysis of path[%s] has already been added in ThreadPool", new Object[]{Integer.valueOf(16842794)});
                } else {
                    e.post(mVar, "video_analysis");
                }
            }
        }
        MultiTouchImageView multiTouchImageView;
        if (com.tencent.mm.plugin.gallery.model.c.aRf().aRI() != 3 || (!(mediaItem == null && o.Wf(str2)) && (mediaItem == null || !mediaItem.mMimeType.equalsIgnoreCase("image/gif")))) {
            Bitmap bitmap;
            com.tencent.mm.plugin.gallery.model.c.aRg().aRv();
            if (this.jDd.jDs.bb(str2)) {
                bitmap = (Bitmap) this.jDd.jDs.get(str2);
                if (!bitmap.isRecycled()) {
                    a(bVar.jDf, bitmap);
                }
            }
            bitmap = com.tencent.mm.plugin.gallery.model.c.aRe().CQ(bi.oW(str) ? str2 : str);
            if (bitmap == null) {
                MultiTouchImageView multiTouchImageView2 = bVar.jDf;
                if (this.byb == null || this.byb.isRecycled()) {
                    this.byb = BitmapFactory.decodeResource(this.mContext.getResources(), R.g.pic_thumb_bg);
                }
                a(multiTouchImageView2, this.byb);
            } else {
                a(bVar.jDf, bitmap);
            }
            if (!this.jCX.contains(str2)) {
                this.jCX.add(str2);
                d dVar = this.jDd;
                multiTouchImageView = bVar.jDf;
                if (!dVar.qD.contains(str2)) {
                    int hashCode = multiTouchImageView.hashCode();
                    dVar.qF(hashCode);
                    dVar.jDp.put(str2, Integer.valueOf(hashCode));
                    dVar.jDq.put(hashCode, str2);
                    dVar.jDo.put(hashCode, new WeakReference(multiTouchImageView));
                    dVar.qD.add(str2);
                    dVar.ahW();
                }
            }
        } else {
            bVar.jDf.setGifPath(str2);
            multiTouchImageView = bVar.jDf;
            if (multiTouchImageView.tzG && multiTouchImageView.tzH != null) {
                ((a) multiTouchImageView.tzH).stop();
                ((a) multiTouchImageView.tzH).start();
            }
            bVar.jDf.setMaxZoomLimit(1.0f);
            bVar.jDf.setEnableHorLongBmpMode(false);
            if (VERSION.SDK_INT == 20) {
                bVar.jDf.setLayerType(1, null);
            } else {
                k.k(bVar.jDf, bVar.jDf.getWidth(), bVar.jDf.getHeight());
            }
            bVar.jDf.requestLayout();
            bVar.jDf.csa();
        }
        x.v("MicroMsg.ImageAdapter", "test getview: %d position:%d", new Object[]{Long.valueOf(bi.bI(VG)), Integer.valueOf(i)});
        return view2;
    }

    public c(Context context) {
        this.mContext = context;
    }

    public final void A(ArrayList<String> arrayList) {
        this.jCV.clear();
        this.jCV = new ArrayList();
        this.jCV.addAll(arrayList);
        reset();
        notifyDataSetChanged();
    }

    public final Object b(ViewGroup viewGroup, int i) {
        if (this.jCW) {
            return super.b(viewGroup, i);
        }
        x.i("MicroMsg.ImageAdapter", "[instantiateItem] position:%s %s", new Object[]{Integer.valueOf(i), Integer.valueOf(this.jCY)});
        if (i != this.jCY || !this.jDa) {
            return super.b(viewGroup, i);
        }
        x.d("MicroMsg.ImageAdapter", "[isSwap-instantiateItem]");
        this.tza.put(this.jCZ, Integer.valueOf(this.jCY));
        this.tzb.put(this.jCY, this.jCZ);
        this.jCY = -1;
        this.jDa = false;
        return this.jCZ;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        if (this.jCW) {
            super.a(viewGroup, i, obj);
        } else if (obj == null) {
            x.e("MicroMsg.ImageAdapter", "[destroyItem] position:%s", new Object[]{Integer.valueOf(i)});
        } else {
            if (this.jCZ != null) {
                x.i("MicroMsg.ImageAdapter", "[destroyItem] position:%s object:%s lastVisableView:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(obj.hashCode()), Integer.valueOf(this.jCZ.hashCode())});
            }
            if (obj == this.jCZ && this.jDa) {
                x.d("MicroMsg.ImageAdapter", "[isSwap-destroyItem]");
                return;
            }
            super.a(viewGroup, i, obj);
            viewGroup.removeView((View) obj);
        }
    }

    public final int getCount() {
        if (this.jCW) {
            return this.jBz.size();
        }
        return this.jCV.size();
    }

    public final MultiTouchImageView qC(int i) {
        View Ep = super.Ep(i);
        if (Ep == null) {
            x.e("MicroMsg.ImageAdapter", "position : %s getMultiTouchImageViewByPosition is null", new Object[]{Integer.valueOf(i)});
            return null;
        } else if (Ep == null || Ep.getVisibility() == 8) {
            return null;
        } else {
            Ep = Ep.findViewById(R.h.image);
            return Ep == null ? null : (MultiTouchImageView) Ep;
        }
    }

    public final WxImageView qD(int i) {
        return null;
    }

    public final String jl(int i) {
        if (this.jCW) {
            if (i >= 0 && i < this.jBz.size()) {
                return ((MediaItem) this.jBz.get(i)).egA;
            }
            x.w("MicroMsg.ImageAdapter", "error position %d, mediaitems size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.jBz.size())});
            return "";
        } else if (i >= 0 && i < this.jCV.size()) {
            return (String) this.jCV.get(i);
        } else {
            x.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.jCV.size())});
            return "";
        }
    }

    public final MediaItem qE(int i) {
        if (this.jCW) {
            if (i >= 0 && i < this.jBz.size()) {
                return (MediaItem) this.jBz.get(i);
            }
            x.w("MicroMsg.ImageAdapter", "error position %d mediaitems size", new Object[]{Integer.valueOf(i), Integer.valueOf(this.jBz.size())});
            return null;
        } else if (i < 0 || i >= this.jCV.size()) {
            x.w("MicroMsg.ImageAdapter", "error position %d, imagePaths size %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.jCV.size())});
            return null;
        } else {
            String str = (String) this.jCV.get(i);
            if (com.tencent.mm.plugin.gallery.model.c.aRh() == null) {
                return null;
            }
            int indexOf = com.tencent.mm.plugin.gallery.model.c.aRh().indexOf(MediaItem.a(0, 0, str, str, ""));
            if (indexOf >= 0) {
                return (MediaItem) com.tencent.mm.plugin.gallery.model.c.aRh().get(indexOf);
            }
            return null;
        }
    }

    @TargetApi(11)
    static void a(MultiTouchImageView multiTouchImageView, Bitmap bitmap) {
        multiTouchImageView.setMaxZoomLimit(4.5f);
        multiTouchImageView.setEnableHorLongBmpMode(false);
        if (VERSION.SDK_INT == 20) {
            multiTouchImageView.setLayerType(1, null);
        } else {
            k.k(multiTouchImageView, bitmap.getWidth(), bitmap.getHeight());
        }
        multiTouchImageView.eT(bitmap.getWidth(), bitmap.getHeight());
        multiTouchImageView.setImageBitmap(bitmap);
        multiTouchImageView.requestLayout();
    }

    public final void release() {
        detach();
        this.jDb.clear();
        this.jCX.clear();
    }

    public final void detach() {
        super.detach();
        d dVar = this.jDd;
        dVar.jDu = null;
        dVar.jDo.clear();
        dVar.jDr.clear();
        dVar.jDq.clear();
        dVar.jDp.clear();
        dVar.aRU();
    }
}
