package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.gridviewheaders.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends BaseAdapter implements e {
    private SimpleDateFormat hZW = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    ArrayList<MediaItem> jBA = new ArrayList();
    private b jBB;
    int jBC;
    LinkedList<a> jBD = new LinkedList();
    boolean jBE = false;
    private OnClickListener jBF = new 2(this);
    int jBx = 9;
    com.tencent.mm.plugin.gallery.stub.a jBy = null;
    ArrayList<MediaItem> jBz = new ArrayList();
    private Context mContext;

    public interface b {
        void J(int i, int i2, int i3);
    }

    public a(Context context, b bVar) {
        this.mContext = context;
        this.jBB = bVar;
    }

    public final void a(a aVar) {
        if (aVar == null) {
            x.w("MicroMsg.AlbumAdapter", "addHeader error, header is null");
            return;
        }
        this.jBD.remove(aVar);
        this.jBD.add(aVar);
    }

    public final ArrayList<String> aRN() {
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = this.jBA.iterator();
        while (it.hasNext()) {
            arrayList.add(((MediaItem) it.next()).egA);
        }
        return arrayList;
    }

    public final void x(ArrayList<String> arrayList) {
        x.d("MicroMsg.AlbumAdapter", "before set selected paths, selected[%s]", new Object[]{this.jBA});
        this.jBA.clear();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                MediaItem a = MediaItem.a(0, 0, str, str, "");
                if (c.aRh() != null) {
                    int indexOf = c.aRh().indexOf(a);
                    if (indexOf >= 0) {
                        a = (MediaItem) c.aRh().get(indexOf);
                        if (a != null && a.getType() == 2) {
                            this.jBA.add(MediaItem.a(2, 0, str, "", ""));
                        }
                    }
                }
                x.d("MicroMsg.AlbumAdapter", "media item no exist on preview items.");
                int i = 1;
                long j = 0;
                String str2 = str;
                this.jBA.add(MediaItem.a(i, j, str2, "", ""));
            }
        }
        x.d("MicroMsg.AlbumAdapter", "after set selected paths, selected[%s]", new Object[]{this.jBA});
    }

    public final ArrayList<MediaItem> qw(int i) {
        ArrayList<MediaItem> arrayList = new ArrayList();
        Iterator it = this.jBz.iterator();
        while (it.hasNext()) {
            MediaItem mediaItem = (MediaItem) it.next();
            if (mediaItem.getType() == i) {
                arrayList.add(mediaItem);
            }
        }
        return arrayList;
    }

    public final int getCount() {
        return this.jBD.size() + this.jBz.size();
    }

    public final int getViewTypeCount() {
        return this.jBD.size() + 1;
    }

    public final int getItemViewType(int i) {
        return i < this.jBD.size() ? i : this.jBD.size();
    }

    /* renamed from: qx */
    public final MediaItem getItem(int i) {
        if (i < this.jBD.size()) {
            x.i("MicroMsg.AlbumAdapter", "get header, pos[%d]", new Object[]{Integer.valueOf(i)});
            return null;
        }
        int size = i - this.jBD.size();
        if (size < this.jBz.size()) {
            return (MediaItem) this.jBz.get(size);
        }
        x.w("MicroMsg.AlbumAdapter", "get item error, media items size[%d], adjustPos[%d]", new Object[]{Integer.valueOf(this.jBz.size()), Integer.valueOf(size)});
        MediaItem imageMediaItem = new ImageMediaItem();
        imageMediaItem.jAV = bi.VF();
        return imageMediaItem;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        x.v("MicroMsg.AlbumAdapter", "duanyi getview index[%d] header size[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(this.jBD.size())});
        if (i < this.jBD.size()) {
            x.i("MicroMsg.AlbumAdapter", "position[%d], get header view", new Object[]{Integer.valueOf(i)});
            return ((a) this.jBD.get(i)).getView();
        }
        String str;
        View inflate;
        d dVar;
        int size = i - this.jBD.size();
        MediaItem mediaItem = (MediaItem) this.jBz.get(size);
        x.i("MicroMsg.AlbumAdapter", "addtime:%s", new Object[]{Long.valueOf(mediaItem.jAV)});
        if (view == null || !(view.getTag() instanceof d)) {
            String str2 = "MicroMsg.AlbumAdapter";
            str = "converview is null?[%B]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(view == null);
            x.d(str2, str, objArr);
            inflate = LayoutInflater.from(this.mContext).inflate(R.i.sd_card_media_folder_preview_item, viewGroup, false);
            d dVar2 = new d((byte) 0);
            dVar2.jBM = (ImageView) inflate.findViewById(R.h.media_placeholder);
            dVar2.jBN = (ImageView) inflate.findViewById(R.h.media_thumb);
            dVar2.jBO = (RelativeLayout) inflate.findViewById(R.h.video_mask);
            dVar2.jBP = (TextView) inflate.findViewById(R.h.video_mask_tv);
            dVar2.jBR = (CheckBox) inflate.findViewById(R.h.media_cbx);
            dVar2.jBQ = (TextView) inflate.findViewById(R.h.select_num);
            dVar2.jBS = inflate.findViewById(R.h.media_cbx_clickarea);
            dVar2.jBT = (ImageView) inflate.findViewById(R.h.media_mask);
            dVar2.jBS.setOnClickListener(this.jBF);
            dVar2.jBS.setTag(R.h.media_cbx, dVar2.jBR);
            dVar2.jBS.setTag(R.h.select_num, dVar2.jBQ);
            dVar2.jBS.setTag(R.h.media_mask, dVar2.jBT);
            if (c.aRf().aRI() == 0 || c.aRf().aRI() == 5 || c.aRf().aRI() == 10 || c.aRf().aRI() == 11) {
                dVar2.jBR.setVisibility(8);
                dVar2.jBQ.setVisibility(8);
                dVar2.jBS.setVisibility(8);
                dVar2.jBT.setVisibility(8);
            }
            dVar2.jBU = (ImageView) inflate.findViewById(R.h.gif_mask);
            dVar2.jBV = (ImageView) inflate.findViewById(R.h.edit_mark_iv);
            inflate.setTag(dVar2);
            dVar = dVar2;
        } else {
            dVar = (d) view.getTag();
            inflate = view;
        }
        if (mediaItem == null) {
            x.e("MicroMsg.AlbumAdapter", "get item failed");
            return inflate;
        }
        dVar.jBM.setVisibility(0);
        if (mediaItem.getType() == 2) {
            dVar.jBO.setVisibility(0);
            c.a(dVar.jBP, (VideoMediaItem) mediaItem);
        } else {
            dVar.jBO.setVisibility(8);
        }
        if (mediaItem.mMimeType.equalsIgnoreCase("edit")) {
            dVar.jBV.setVisibility(0);
        } else {
            dVar.jBV.setVisibility(8);
        }
        str = mediaItem.aRw();
        String str3 = mediaItem.egA;
        if (bi.oW(str) && bi.oW(str3)) {
            x.e("MicroMsg.AlbumAdapter", "null or nil filepath: " + size);
            return inflate;
        }
        dVar.jBS.setTag(R.h.media_cbx_clickarea, Integer.valueOf(size));
        int i2 = R.l.picture_tips;
        if (mediaItem.getType() == 2) {
            i2 = R.l.video_tips;
        }
        x.d("MicroMsg.AlbumAdapter", "thumbFilaPath: %s | origFilePath: %s | contentDescription %s", new Object[]{str, str3, viewGroup.getContext().getString(i2, new Object[]{Integer.valueOf((i + 1) - this.jBD.size()), this.hZW.format(new Date(mediaItem.jAV))})});
        dVar.jBN.setContentDescription(r2);
        h.a(dVar.jBN, mediaItem.getType(), str, str3, mediaItem.jAU, -1, new 1(this, dVar.jBM));
        if (this.jBE) {
            if (mediaItem.getType() == 2) {
                dVar.jBR.setVisibility(8);
                dVar.jBQ.setVisibility(8);
                dVar.jBS.setVisibility(8);
                dVar.jBT.setVisibility(8);
            } else if (this.jBA.contains(mediaItem)) {
                dVar.jBR.setChecked(true);
                dVar.jBQ.setText((mediaItem == null ? -1 : this.jBA.indexOf(mediaItem)));
                dVar.jBT.setBackgroundResource(R.e.half_alpha_black);
                dVar.jBS.setVisibility(0);
                dVar.jBR.setVisibility(0);
                dVar.jBT.setVisibility(0);
            } else {
                dVar.jBQ.setVisibility(8);
                dVar.jBR.setChecked(false);
                dVar.jBT.setBackgroundResource(R.e.image_gallery_mask);
                dVar.jBR.setVisibility(0);
                dVar.jBS.setVisibility(0);
                dVar.jBT.setVisibility(0);
            }
        } else if (this.jBA.contains(mediaItem)) {
            dVar.jBR.setChecked(true);
            dVar.jBT.setVisibility(0);
            dVar.jBT.setBackgroundResource(R.e.half_alpha_black);
        } else {
            dVar.jBR.setChecked(false);
            dVar.jBQ.setVisibility(8);
            dVar.jBT.setVisibility(0);
            dVar.jBT.setBackgroundResource(R.e.image_gallery_mask);
        }
        if ((c.aRf().aRI() == 3 || c.aRf().aRI() == 11) && mediaItem != null && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            dVar.jBU.setVisibility(0);
        } else {
            dVar.jBU.setVisibility(8);
        }
        return inflate;
    }

    public final long oo(int i) {
        if (i < this.jBD.size()) {
            x.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", new Object[]{Integer.valueOf(i)});
            i = this.jBD.size();
        }
        x.v("MicroMsg.AlbumAdapter", "getHeaderId, adjust pos[%d], date[%d] date[%s], headerID[%d]", new Object[]{Integer.valueOf(i), Long.valueOf(getItem(i).jAV), r1, Long.valueOf(com.tencent.mm.ui.gridviewheaders.a.czj().b(new Date(getItem(i).jAV)))});
        return com.tencent.mm.ui.gridviewheaders.a.czj().b(new Date(getItem(i).jAV));
    }

    public final String qy(int i) {
        if (i < this.jBD.size()) {
            x.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", new Object[]{Integer.valueOf(i)});
            i = this.jBD.size();
        }
        return com.tencent.mm.ui.gridviewheaders.a.czj().a(new Date(getItem(i).jAV), this.mContext);
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        View textView;
        if (i < this.jBD.size()) {
            x.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", new Object[]{Integer.valueOf(i)});
            i = this.jBD.size();
        }
        if (view == null || view.getParent() != null) {
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            textView = new TextView(this.mContext);
            textView.setBackgroundResource(R.g.list_item_normal);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.SmallPadding);
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.f.SmallPadding);
            textView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
            textView.setTextColor(this.mContext.getResources().getColor(R.e.gallery_catalog_color));
            textView.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(R.f.HintTextSize));
            textView.setTypeface(null, 1);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = view;
        }
        x.v("MicroMsg.AlbumAdapter", "getHeaderView, adjust pos[%d], date[%d] date[%s], headerStr[%s]", new Object[]{Integer.valueOf(i), Long.valueOf(r0.jAV), new Date(getItem(i).jAV), com.tencent.mm.ui.gridviewheaders.a.czj().a(new Date(getItem(i).jAV), this.mContext)});
        ((TextView) textView).setText(r3);
        return textView;
    }
}
