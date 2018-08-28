package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.protocal.c.tp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public class DonorsAvatarView extends LinearLayout {
    private int ioM;
    private int ioN;
    private int ioO;
    private int ioP;
    private LayoutParams ioQ;
    private int mMaxCount;

    public DonorsAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DonorsAvatarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setOrientation(0);
        this.ioM = a.fk(getContext());
        this.ioN = a.ad(getContext(), R.f.emoji_donors_avatar_size);
        this.ioO = a.ad(getContext(), R.f.BasicPaddingSize);
        this.ioP = a.ad(getContext(), R.f.NormalPadding);
        this.ioQ = new LayoutParams(this.ioN, this.ioN);
        this.ioQ.leftMargin = this.ioO;
        this.ioQ.rightMargin = this.ioO;
        this.mMaxCount = (this.ioM - (this.ioP * 2)) / (this.ioN + (this.ioO * 2));
        x.i("MicroMsg.emoji.DonorsAvatarView", "max count:%d", Integer.valueOf(this.mMaxCount));
    }

    public final void b(String str, LinkedList<tp> linkedList) {
        removeAllViews();
        if (linkedList != null && linkedList.size() > 0) {
            int size = linkedList.size() > this.mMaxCount ? this.mMaxCount : linkedList.size();
            for (int i = 0; i < size; i++) {
                tp tpVar = (tp) linkedList.get(i);
                if (tpVar != null) {
                    View imageView = new ImageView(getContext());
                    imageView.setLayoutParams(this.ioQ);
                    if (bi.oW(tpVar.rxm)) {
                        try {
                            imageView.setImageBitmap(b.a(ad.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null)));
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.emoji.DonorsAvatarView", e, "", new Object[0]);
                        }
                    } else {
                        o.Pj().a(tpVar.rxm, imageView, f.j(str, tpVar.rxm, new Object[0]));
                    }
                    addView(imageView);
                }
            }
        }
    }
}
