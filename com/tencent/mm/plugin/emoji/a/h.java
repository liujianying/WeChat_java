package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class h extends a {
    public int idM = 0;
    private int idR;
    private int idS;
    private int idT;
    private int idU;
    private int idV;
    private boolean idW;
    public a idX;
    private HashMap<String, b> idY;
    private Context mContext;
    private int mNumColumns = 3;

    public h(Context context) {
        super(context);
        this.mContext = context;
        this.idW = false;
        this.idR = this.mContext.getResources().getDimensionPixelSize(R.f.NormalPadding);
        this.idS = this.mContext.getResources().getDimensionPixelSize(R.f.BigPadding);
        this.idT = this.mContext.getResources().getDimensionPixelSize(R.f.emoji_grid_item_width_xhdpi);
        this.idU = com.tencent.mm.bp.a.fk(this.mContext);
        this.idV = (int) (((float) (this.idU - (this.mNumColumns * this.idT))) / (((float) this.mNumColumns) + 1.0f));
    }

    public final int aDD() {
        if (!this.idW) {
            return super.getCount();
        }
        if (this.idM == 0) {
            return 0;
        }
        if (this.idM <= 0 || super.getCount() <= this.idM) {
            return super.getCount();
        }
        return this.idM;
    }

    public final int getCount() {
        if (!this.idW) {
            int aDD = aDD();
            if (aDD > this.idM) {
                return (int) Math.ceil((double) (((float) (aDD - this.idM)) / ((float) this.mNumColumns)));
            }
            return 0;
        } else if (this.idM == 0) {
            return 0;
        } else {
            if (this.idM <= 0 || aDD() <= this.idM) {
                return (int) Math.ceil((double) (((float) aDD()) / ((float) this.mNumColumns)));
            }
            return (int) Math.ceil((double) (((float) this.idM) / ((float) this.mNumColumns)));
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null) {
            view = new LinearLayout(this.mContext);
            LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
            view.setBackgroundResource(R.g.transparent_background);
            view.setOrientation(0);
            view.setLayoutParams(layoutParams);
            view.setPadding(0, 0, 0, this.idS);
            b bVar2 = new b(this);
            bVar2.ieb = view;
            view.setTag(bVar2);
            for (int i2 = 0; i2 < this.mNumColumns; i2++) {
                LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.leftMargin = this.idV;
                bVar2.ieb.addView(new b(this.mContext, R.i.emoji_store_v2_person_item).ido, i2, layoutParams2);
            }
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        for (int i3 = 0; i3 < this.mNumColumns; i3++) {
            int i4;
            if (this.idW) {
                i4 = this.mNumColumns * i;
            } else {
                i4 = (this.mNumColumns * i) + this.idM;
            }
            i4 += i3;
            final b bVar3 = new b(this.mContext, bVar.ieb.getChildAt(i3));
            bVar3.ido.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (h.this.idX != null) {
                        h.this.idX.ms(i4);
                    }
                }
            });
            f oG = oG(i4);
            if (i4 > aDD() - 1 || oG == null) {
                bVar3.ido.setClickable(false);
                bVar3.ido.setVisibility(8);
                bVar3.idy.setBackgroundDrawable(null);
            } else {
                if (this.idY == null) {
                    this.idY = new HashMap();
                }
                if (this.idY.containsValue(bVar3)) {
                    this.idY.remove(bVar3.idw);
                }
                bVar3.idw = a(oG);
                this.idY.put(a(oG), bVar3);
                bVar3.ido.setVisibility(0);
                bVar3.hEx.setText(oG.iez.rwQ);
                o.Pj().a(oG.iez.jPG, bVar3.idx, com.tencent.mm.plugin.emoji.e.f.cr(oG.iez.rem, oG.iez.jPG));
                bVar3.idy.setBackgroundResource(R.g.emoji_grid_item_fg);
                bVar3.ido.setClickable(true);
                a(bVar3, oG.mStatus);
            }
        }
        return view;
    }

    private void a(b bVar, int i) {
        switch (i) {
            case 7:
                bVar.hEx.setTextColor(this.mContext.getResources().getColor(R.e.half_alpha_black));
                Drawable drawable = this.mContext.getResources().getDrawable(R.k.emoji_download_finish);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                bVar.hEx.setCompoundDrawables(null, null, drawable, null);
                return;
            default:
                bVar.hEx.setTextColor(this.mContext.getResources().getColor(R.e.normal_text_color));
                bVar.hEx.setCompoundDrawables(null, null, null, null);
                x.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "unknow product status:%d", new Object[]{Integer.valueOf(i)});
                return;
        }
    }

    protected final a c(Context context, View view) {
        return null;
    }

    public final int aDz() {
        return this.idM;
    }

    public final void oD(int i) {
        this.idM = i;
    }

    public final int aDA() {
        return 0;
    }

    public final void oE(int i) {
    }

    public final int aDB() {
        return 0;
    }

    public final void oF(int i) {
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    public final void be(String str, int i) {
        if (this.idY == null) {
            x.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus mCacheHolder is nulll.");
            return;
        }
        b bVar = (b) this.idY.get(str);
        f za = this.ien.za(str);
        if (za != null) {
            a(za, str, i);
        }
        if (!(za == null || this.ien == null || za.mStatus != -1)) {
            x.i("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "force refresh status");
            za.a(this.ien.iew, this.ien.ze(str), this.ien.zc(str));
        }
        if (bVar == null) {
            x.w("MicroMsg.emoji.EmojiStoreV2PersonAdapter", "updateStatus viewHolder is nulll.");
        } else {
            a(bVar, i);
        }
    }
}
