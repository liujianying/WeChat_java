package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.bp.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.ta;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.List;

public final class d extends BaseAdapter {
    List<ta> idD;
    private int idT;
    private int idU;
    private int idV;
    private boolean isd;
    private LayoutParams ise;
    private LayoutParams isf;
    a isg;
    private Context mContext;
    private int mNumColumns;

    public d(Context context) {
        this.mNumColumns = 3;
        this.isd = true;
        this.mNumColumns = 3;
        this.mContext = context;
        this.idU = a.fk(this.mContext);
        this.idT = this.mContext.getResources().getDimensionPixelSize(R.f.emoji_grid_item_width_xhdpi);
        this.idV = (int) (((float) (this.idU - (this.mNumColumns * this.idT))) / (((float) this.mNumColumns) + 1.0f));
    }

    public final void aQ(List<ta> list) {
        if (this.idD == null) {
            this.idD = new ArrayList();
        } else {
            this.idD.clear();
        }
        this.idD = list;
        notifyDataSetChanged();
    }

    private int aFL() {
        return this.idD == null ? 0 : this.idD.size();
    }

    public final int getCount() {
        return this.idD == null ? 0 : (int) Math.ceil((double) (((float) this.idD.size()) / ((float) this.mNumColumns)));
    }

    /* renamed from: oY */
    public final ta getItem(int i) {
        if (i < 0 || i >= aFL() || this.idD == null) {
            return null;
        }
        return (ta) this.idD.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null) {
            view = y.gq(this.mContext).inflate(R.i.emoji_store_v2_single_product_item_2, null);
            bVar = new b(this);
            bVar.ieb = (LinearLayout) view.findViewById(R.h.item_container);
            bVar.ieb.setPadding(0, this.idV, 0, 0);
            view.setTag(bVar);
            for (int i2 = 0; i2 < this.mNumColumns; i2++) {
                this.isf = new LayoutParams(-2, -2);
                this.isf.leftMargin = this.idV;
                this.ise = new LayoutParams(this.idT, this.idT);
                PaddingImageView paddingImageView = new PaddingImageView(this.mContext);
                ViewGroup.LayoutParams layoutParams = this.ise;
                paddingImageView.addView(paddingImageView.isa, layoutParams);
                paddingImageView.addView(paddingImageView.isb, layoutParams);
                bVar.ieb.addView(paddingImageView, i2, this.isf);
            }
        } else {
            bVar = (b) view.getTag();
        }
        for (int i3 = 0; i3 < this.mNumColumns; i3++) {
            int i4 = (this.mNumColumns * i) + i3;
            PaddingImageView paddingImageView2 = (PaddingImageView) bVar.ieb.getChildAt(i3);
            if (i4 <= aFL() - 1) {
                ta oY = getItem(i4);
                if (oY != null) {
                    String stringBuilder;
                    com.tencent.mm.ak.a.a Pj;
                    String str;
                    ImageView imageView;
                    String str2;
                    if (!bi.oW(oY.lPl)) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        au.HU();
                        stringBuilder = stringBuilder2.append(EmojiLogic.L(c.Gg(), "", oY.rwk)).append("_cover").toString();
                        Pj = o.Pj();
                        str = oY.lPl;
                        imageView = paddingImageView2.getImageView();
                        str2 = oY.lPl;
                        Pj.a(str, imageView, f.a(stringBuilder, this.idT, new Object[0]));
                    } else if (bi.oW(oY.jPK)) {
                        x.w("MicroMsg.emoji.PreViewListGridAdapter", "this emoji has no thumb url and url. download faild");
                    } else {
                        au.HU();
                        stringBuilder = EmojiLogic.L(c.Gg(), "", oY.rwk);
                        Pj = i.aDZ();
                        str = oY.jPK;
                        imageView = paddingImageView2.getImageView();
                        str2 = oY.jPK;
                        Pj.a(str, imageView, f.a(stringBuilder, this.idT, new Object[0]));
                    }
                    paddingImageView2.setClickable(true);
                    paddingImageView2.getImageViewFG().setBackgroundResource(R.g.emoji_grid_item_seq_fg);
                    paddingImageView2.setOnClickListener(new 1(this, paddingImageView2, i4));
                } else {
                    paddingImageView2.getImageViewFG().setBackgroundDrawable(null);
                    o.Pj().a("", paddingImageView2.getImageView());
                    x.w("MicroMsg.emoji.PreViewListGridAdapter", "item is null");
                    paddingImageView2.setClickable(false);
                    paddingImageView2.setOnClickListener(null);
                }
            } else {
                paddingImageView2.getImageViewFG().setBackgroundDrawable(null);
                o.Pj().a("", paddingImageView2.getImageView());
                paddingImageView2.setClickable(false);
                paddingImageView2.setOnClickListener(null);
            }
        }
        return view;
    }
}
