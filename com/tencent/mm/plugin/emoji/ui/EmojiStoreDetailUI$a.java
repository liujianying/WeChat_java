package com.tencent.mm.plugin.emoji.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.bp.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ayu;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;

class EmojiStoreDetailUI$a extends BaseAdapter {
    final /* synthetic */ EmojiStoreDetailUI inz;

    public EmojiStoreDetailUI$a(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.inz = emojiStoreDetailUI;
    }

    public int getCount() {
        return EmojiStoreDetailUI.b(this.inz) == null ? 0 : EmojiStoreDetailUI.b(this.inz).rwW;
    }

    public Object getItem(int i) {
        if (EmojiStoreDetailUI.b(this.inz) == null || EmojiStoreDetailUI.b(this.inz).rxg == null || EmojiStoreDetailUI.b(this.inz).rxg.size() <= 0 || EmojiStoreDetailUI.b(this.inz).rxg.get(i) == null || ((ayu) EmojiStoreDetailUI.b(this.inz).rxg.get(i)).sbC == null) {
            return null;
        }
        x.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks get preview : %d", new Object[]{Integer.valueOf(i)});
        String a = EmojiStoreDetailUI.a(this.inz);
        String str = ((ayu) EmojiStoreDetailUI.b(this.inz).rxg.get(i)).sbC;
        a.getDensity(EmojiStoreDetailUI.p(this.inz));
        EmojiInfo a2 = EmojiLogic.a(a, 8, str, false);
        if (a2 == null) {
            x.d("MicroMsg.emoji.EmojiStoreDetailUI", "detail preview emoji is null.");
            o.Pj().a(((ayu) EmojiStoreDetailUI.b(this.inz).rxg.get(i)).sbC, null, f.c(EmojiStoreDetailUI.a(this.inz), ((ayu) EmojiStoreDetailUI.b(this.inz).rxg.get(i)).sbC, Integer.valueOf(i)), EmojiStoreDetailUI.z(this.inz), EmojiStoreDetailUI.A(this.inz), null, null, null, null);
        } else {
            h.mEJ.k(10930, EmojiStoreDetailUI.a(this.inz) + ",0");
            if (e.aDM().isEnable()) {
                a2.field_reserved4 = EmojiInfo.tcW;
            }
        }
        oQ(i);
        return a2;
    }

    private void oQ(int i) {
        int[] iArr = new int[]{i - 1, i + 1, i - 4, i + 4};
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < 4) {
                int i4 = iArr[i3];
                if (EmojiStoreDetailUI.b(this.inz) != null && i4 >= 0 && i4 < EmojiStoreDetailUI.b(this.inz).rxf) {
                    au.HU();
                    if (!com.tencent.mm.a.e.cn(EmojiLogic.K(c.Gg(), EmojiStoreDetailUI.a(this.inz), ((ayu) EmojiStoreDetailUI.b(this.inz).rxg.get(i4)).sbC))) {
                        o.Pj().a(((ayu) EmojiStoreDetailUI.b(this.inz).rxg.get(i4)).sbC, null, f.c(EmojiStoreDetailUI.a(this.inz), ((ayu) EmojiStoreDetailUI.b(this.inz).rxg.get(i4)).sbC, Integer.valueOf(i4)), EmojiStoreDetailUI.z(this.inz), EmojiStoreDetailUI.A(this.inz), null, null, null, null);
                    }
                }
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        EmojiStoreDetailUI.c cVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(EmojiStoreDetailUI.p(this.inz)).inflate(R.i.emoji_store_detail_grid_item, null);
            EmojiStoreDetailUI.c cVar2 = new EmojiStoreDetailUI.c(this.inz, view);
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (EmojiStoreDetailUI.c) view.getTag();
        }
        if (EmojiStoreDetailUI.q(this.inz).uTC) {
            cVar.inC.setBackgroundResource(R.g.smiley_item_bg2);
        } else {
            cVar.inC.setBackgroundDrawable(null);
        }
        String str = "";
        if (EmojiStoreDetailUI.b(this.inz).rwX != null) {
            str = ab.a((bhz) EmojiStoreDetailUI.b(this.inz).rwX.get(i));
        }
        o.Pj().a(str, cVar.inC, f.cr(EmojiStoreDetailUI.a(this.inz), str));
        return view;
    }
}
