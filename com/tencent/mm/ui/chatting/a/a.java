package com.tencent.mm.ui.chatting.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Date;
import java.util.List;

public final class a extends android.support.v7.widget.RecyclerView.a {
    private String gBf;
    public List<c> gxb = null;
    private c hOC = null;
    Context mContext;
    boolean qIZ = false;
    private boolean qUB = true;
    long tNE;
    public boolean tNF;
    public b tNG;
    public boolean tNH = false;

    public a(Context context, List<c> list, String str) {
        this.gxb = list;
        this.gBf = str;
        au.HU();
        this.qUB = com.tencent.mm.model.c.isSDCardAvailable();
        this.mContext = context;
        gM(context);
    }

    public a(Context context, List<c> list, String str, long j) {
        this.gxb = list;
        this.tNE = j;
        this.gBf = str;
        au.HU();
        this.qUB = com.tencent.mm.model.c.isSDCardAvailable();
        this.qIZ = true;
        this.mContext = context;
        gM(context);
    }

    private void gM(Context context) {
        com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
        aVar.dXD = 1;
        aVar.dXY = true;
        aVar.dXF = com.tencent.mm.bp.a.fk(context) / 4;
        aVar.dXE = com.tencent.mm.bp.a.fk(context) / 4;
        aVar.dXR = R.e.pic_thum_bg_color;
        this.hOC = aVar.Pt();
    }

    public final int getItemViewType(int i) {
        return EY(i).type;
    }

    public final t a(ViewGroup viewGroup, int i) {
        if (i == Integer.MAX_VALUE) {
            return new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.gallery_date_item, viewGroup, false));
        }
        return new d(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.image_gallary_grid_item, viewGroup, false));
    }

    public final void a(t tVar, int i, List list) {
        if (list == null || list.size() <= 0 || !(tVar instanceof d)) {
            super.a(tVar, i, list);
        } else if (((Integer) list.get(0)).intValue() == 0) {
            ((d) tVar).jBR.setChecked(false);
            ((d) tVar).jBR.setVisibility(0);
            ((d) tVar).jBS.setVisibility(0);
        } else {
            ((d) tVar).jBR.setChecked(false);
            ((d) tVar).jBR.setVisibility(8);
            ((d) tVar).jBS.setVisibility(8);
        }
    }

    public final void a(t tVar, int i) {
        if (this.qUB) {
            c EY = EY(i);
            if (tVar.SX != Integer.MAX_VALUE) {
                ((d) tVar).mZb.setTag(Integer.valueOf(i));
                ((d) tVar).jBS.setTag(Integer.valueOf(i));
                o.Pj().a(EY.imagePath, ((d) tVar).mZb, this.hOC);
                if (EY.leb) {
                    ((d) tVar).tNM.setVisibility(0);
                    ((d) tVar).tNN.setVisibility(0);
                    ((d) tVar).tNN.setText(bi.aG(EY.tNJ.tNK, ""));
                } else {
                    ((d) tVar).tNN.setVisibility(8);
                    ((d) tVar).tNM.setVisibility(8);
                }
                if (this.tNH) {
                    ((d) tVar).jBS.setVisibility(0);
                    ((d) tVar).jBR.setVisibility(0);
                    if (com.tencent.mm.ui.chatting.gallery.g.a.cwU().by(EY.bXQ)) {
                        ((d) tVar).tNO.setVisibility(0);
                        ((d) tVar).jBR.setChecked(true);
                        return;
                    }
                    ((d) tVar).tNO.setVisibility(8);
                    ((d) tVar).jBR.setChecked(false);
                    return;
                }
                ((d) tVar).jBS.setVisibility(8);
                ((d) tVar).jBR.setVisibility(8);
                return;
            } else if (i == getItemCount() - 1 || gz(EY(i + 1).timeStamp) != gz(EY.timeStamp)) {
                ((a) tVar).eBP.setVisibility(8);
                return;
            } else {
                ((a) tVar).eBP.setVisibility(0);
                ((a) tVar).eBP.setText(gy(EY.timeStamp));
                if (this.tNF) {
                    ((a) tVar).eVR.setVisibility(0);
                    return;
                } else {
                    ((a) tVar).eVR.setVisibility(8);
                    return;
                }
            }
        }
        x.e("MicroMsg.MediaHistoryGalleryAdapter", "[onBindViewHolder] isSDCardAvailable:%s", new Object[]{Boolean.valueOf(this.qUB)});
    }

    public final String gy(long j) {
        return com.tencent.mm.ui.gridviewheaders.a.czj().a(new Date(j), this.mContext);
    }

    private static long gz(long j) {
        return com.tencent.mm.ui.gridviewheaders.a.czj().b(new Date(j));
    }

    public final int getItemCount() {
        return this.gxb.size();
    }

    public final c EY(int i) {
        return (c) this.gxb.get(i);
    }
}
