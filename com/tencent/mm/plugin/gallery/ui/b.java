package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class b extends BaseAdapter {
    private int jBm;
    ArrayList<AlbumItem> jCO;
    AlbumItem jCP;
    String jCQ = "";
    private int jCR = 0;
    private Context mContext;

    private static class a {
        public TextView eCn;
        public ImageView jBN;
        public TextView jCS;
        public ImageView jCT;
        public ImageView jeF;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public b(Context context, int i) {
        this.mContext = context;
        this.jCO = new ArrayList();
        this.jBm = i;
        this.jCP = new AlbumItem("", 0);
        this.jCP.jAR = new ImageMediaItem();
        this.jCR = context.getResources().getDimensionPixelSize(R.f.SmallPadding);
    }

    public final int getCount() {
        return this.jCO.size() + 1;
    }

    /* renamed from: qB */
    public final AlbumItem getItem(int i) {
        if (i == 0) {
            return this.jCP;
        }
        return (AlbumItem) this.jCO.get(i - 1);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        x.i("MicroMsg.GalleryAdapter", "duanyi test getview:" + i);
        AlbumItem qB = getItem(i);
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.i.sd_card_medial_folder_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.jBN = (ImageView) view.findViewById(R.h.folder_thumb);
            aVar2.eCn = (TextView) view.findViewById(R.h.folder_name);
            aVar2.jeF = (ImageView) view.findViewById(R.h.video_mask);
            aVar2.jCS = (TextView) view.findViewById(R.h.folder_count);
            aVar2.jCT = (ImageView) view.findViewById(R.h.folder_selected_iv);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (this.jCQ.equals(qB.jAQ)) {
            aVar.jCT.setVisibility(0);
        } else {
            aVar.jCT.setVisibility(4);
        }
        if (i == 0) {
            aVar.jBN.setImageResource(R.g.pic_thumb_bg);
            if (qB.jAR != null) {
                h.a(aVar.jBN, qB.jAR.getType(), qB.aRw(), qB.jAR.egA, qB.aRx());
            }
            if (c.aRf().aRJ() == 1) {
                aVar.eCn.setText(R.l.gallery_all_pic);
            } else if (c.aRf().aRJ() == 3) {
                aVar.eCn.setText(R.l.gallery_all_pic_and_video);
            } else {
                aVar.eCn.setText(R.l.gallery_all_video);
            }
            aVar.jBN.setVisibility(0);
            aVar.eCn.setVisibility(0);
            aVar.jCS.setVisibility(8);
        } else {
            aVar.jBN.setVisibility(0);
            aVar.eCn.setVisibility(0);
            aVar.eCn.setText(qB.jAQ);
            aVar.jCS.setVisibility(0);
            aVar.jCS.setText(this.mContext.getString(R.l.gallery_pic_count, new Object[]{Integer.valueOf(qB.bMU)}));
            if (!(aVar.jeF == null || qB.jAR == null)) {
                aVar.jeF.setVisibility(qB.jAR.getType() == 2 ? 0 : 8);
            }
            String aRw = qB.aRw();
            if (!bi.oW(aRw) && qB.jAR != null) {
                h.a(aVar.jBN, qB.jAR.getType(), aRw, qB.jAR.egA, qB.aRx());
            } else if (qB.jAR == null || qB.jAR.getType() != 2) {
                x.e("MicroMsg.GalleryAdapter", "get folder failed");
                aVar.jBN.setVisibility(8);
                aVar.eCn.setVisibility(8);
            } else {
                h.a(aVar.jBN, qB.jAR.getType(), null, qB.jAR.egA, qB.aRx());
            }
        }
        return view;
    }
}
