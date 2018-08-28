package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.ui.SquareImageView;
import com.tencent.mm.protocal.c.tp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.LinkedList;

class EmojiStoreV2RewardDetailUI$a extends BaseAdapter {
    private Bitmap byb = null;
    private int idU;
    int idV;
    int ioN;
    final /* synthetic */ EmojiStoreV2RewardDetailUI iqc;
    private LinkedList<tp> iqd;
    boolean iqe = false;
    private Context mContext;
    private int mNumColumns = 1;

    public EmojiStoreV2RewardDetailUI$a(EmojiStoreV2RewardDetailUI emojiStoreV2RewardDetailUI, Context context) {
        this.iqc = emojiStoreV2RewardDetailUI;
        this.mContext = context;
        this.ioN = a.ad(emojiStoreV2RewardDetailUI.mController.tml, R.f.emoji_donors_avatar_size);
        int fk = a.fk(emojiStoreV2RewardDetailUI.mController.tml) - (a.ad(emojiStoreV2RewardDetailUI.mController.tml, R.f.LargePadding) * 2);
        int i = this.ioN;
        int ad = a.ad(emojiStoreV2RewardDetailUI.mController.tml, R.f.LittlePadding);
        int i2 = fk / (i + ad);
        if ((fk - (i2 * i)) - (ad * (i2 - 1)) > i) {
            i2++;
        }
        this.mNumColumns = i2;
        this.idU = a.fk(this.mContext);
        this.idV = (int) (((float) (this.idU - (this.mNumColumns * this.ioN))) / (((float) this.mNumColumns) + 1.0f));
        try {
            this.byb = b.a(this.mContext.getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
        } catch (IOException e) {
            x.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "decode stream default avatar failed. %s", new Object[]{bi.cjd()});
        }
    }

    public final void K(LinkedList<tp> linkedList) {
        if (this.iqd == null) {
            this.iqd = new LinkedList();
        }
        if (this.iqe) {
            this.iqd.clear();
            this.iqe = false;
        }
        this.iqd.addAll(linkedList);
        notifyDataSetChanged();
    }

    public final int getCount() {
        int size = this.iqd == null ? 0 : this.iqd.size();
        if (size > 0) {
            return (int) Math.ceil((double) (((float) size) / ((float) this.mNumColumns)));
        }
        return size;
    }

    private tp oR(int i) {
        if (this.iqd != null) {
            if (i < (this.iqd == null ? 0 : this.iqd.size())) {
                return (tp) this.iqd.get(i);
            }
        }
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        EmojiStoreV2RewardDetailUI.b bVar;
        if (view == null || view.getTag() == null) {
            view = new LinearLayout(this.mContext);
            LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
            view.setBackgroundResource(R.g.transparent_background);
            view.setOrientation(0);
            view.setLayoutParams(layoutParams);
            view.setPadding(0, 0, 0, this.idV);
            bVar = new EmojiStoreV2RewardDetailUI.b(this.iqc);
            bVar.ieb = view;
            view.setTag(bVar);
            for (int i2 = 0; i2 < this.mNumColumns; i2++) {
                LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.ioN, this.ioN);
                layoutParams2.leftMargin = this.idV;
                bVar.ieb.addView(new SquareImageView(this.mContext), i2, layoutParams2);
            }
        } else {
            bVar = (EmojiStoreV2RewardDetailUI.b) view.getTag();
        }
        for (int i3 = 0; i3 < this.mNumColumns; i3++) {
            SquareImageView squareImageView = (SquareImageView) bVar.ieb.getChildAt(i3);
            tp oR = oR((this.mNumColumns * i) + i3);
            if (oR != null) {
                squareImageView.setVisibility(0);
                if (bi.oW(oR.rxm)) {
                    squareImageView.setImageBitmap(this.byb);
                } else {
                    o.Pj().a(oR.rxm, squareImageView, f.r(EmojiStoreV2RewardDetailUI.c(this.iqc), oR.rxm, this.ioN));
                }
            } else {
                squareImageView.setVisibility(8);
            }
        }
        return view;
    }
}
