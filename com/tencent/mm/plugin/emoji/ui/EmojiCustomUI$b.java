package com.tencent.mm.plugin.emoji.ui;

import android.database.Cursor;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import java.util.ArrayList;
import java.util.List;

class EmojiCustomUI$b extends BaseAdapter {
    final /* synthetic */ EmojiCustomUI ilG;
    private ArrayList<EmojiInfo> ilP;
    private Animation ilQ;

    public EmojiCustomUI$b(EmojiCustomUI emojiCustomUI) {
        this.ilG = emojiCustomUI;
        this.ilQ = AnimationUtils.loadAnimation(emojiCustomUI, R.a.refresh_animation);
        this.ilQ.setInterpolator(new LinearInterpolator());
    }

    public final int getCount() {
        return aFL() + aFK();
    }

    private int aFK() {
        if (aFL() <= 0 || (aFL() + 1) % 5 != 0) {
            return 2;
        }
        return 1;
    }

    public final int aFL() {
        return this.ilP == null ? 0 : this.ilP.size();
    }

    /* renamed from: oO */
    public final EmojiInfo getItem(int i) {
        if (i < aFL() && this.ilP != null) {
            return (EmojiInfo) this.ilP.get(i);
        }
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r8, android.view.View r9, android.view.ViewGroup r10) {
        /*
        r7 = this;
        r6 = 8;
        r5 = 0;
        r4 = 0;
        if (r9 == 0) goto L_0x000c;
    L_0x0006:
        r0 = r9.getTag();
        if (r0 != 0) goto L_0x0067;
    L_0x000c:
        r0 = r7.ilG;
        r0 = r0.mController;
        r0 = r0.tml;
        r0 = android.view.LayoutInflater.from(r0);
        r1 = com.tencent.mm.R.i.emoji_custom_grid_item;
        r9 = r0.inflate(r1, r4);
        r9.setVisibility(r5);
        r0 = new com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$d;
        r0.<init>(r9);
        r9.setTag(r0);
        r1 = r0;
    L_0x0028:
        r0 = r7.ilG;
        r0 = com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.k(r0);
        r2 = com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.c.ilU;
        if (r0 == r2) goto L_0x003c;
    L_0x0032:
        r0 = r7.ilG;
        r0 = com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.k(r0);
        r2 = com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.c.ilS;
        if (r0 != r2) goto L_0x0072;
    L_0x003c:
        r0 = r7.aFK();
    L_0x0040:
        r2 = r7.getCount();
        r2 = r2 - r0;
        if (r8 >= r2) goto L_0x0081;
    L_0x0047:
        r0 = r8 % 5;
        if (r0 != 0) goto L_0x0079;
    L_0x004b:
        r0 = r1.ilW;
        r2 = com.tencent.mm.R.g.emoji_grid_item_bottom;
        r0.setBackgroundResource(r2);
    L_0x0052:
        r0 = r1.ilX;
        r0.clearAnimation();
        r0 = com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.10.ilK;
        r2 = r7.ilG;
        r2 = com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.k(r2);
        r2 = r2 + -1;
        r0 = r0[r2];
        switch(r0) {
            case 1: goto L_0x0097;
            case 2: goto L_0x0137;
            case 3: goto L_0x00e3;
            case 4: goto L_0x01a1;
            default: goto L_0x0066;
        };
    L_0x0066:
        return r9;
    L_0x0067:
        r9.setVisibility(r5);
        r0 = r9.getTag();
        r0 = (com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.d) r0;
        r1 = r0;
        goto L_0x0028;
    L_0x0072:
        r0 = r7.aFK();
        r0 = r0 + -1;
        goto L_0x0040;
    L_0x0079:
        r0 = r1.ilW;
        r2 = com.tencent.mm.R.g.emoji_grid_item_middle;
        r0.setBackgroundResource(r2);
        goto L_0x0052;
    L_0x0081:
        r2 = r7.getCount();
        r0 = r2 - r0;
        if (r8 != r0) goto L_0x0091;
    L_0x0089:
        r0 = r1.ilW;
        r2 = com.tencent.mm.R.g.emoji_grid_item_left;
        r0.setBackgroundResource(r2);
        goto L_0x0052;
    L_0x0091:
        r0 = r1.ilW;
        r0.setBackgroundColor(r5);
        goto L_0x0052;
    L_0x0097:
        r0 = r7.getCount();
        r2 = r7.aFK();
        r0 = r0 - r2;
        r0 = r0 + 1;
        if (r8 != r0) goto L_0x00bb;
    L_0x00a4:
        r0 = com.tencent.mm.ak.o.Pj();
        r2 = "";
        r3 = r1.ilX;
        r0.a(r2, r3);
        r0 = r1.ilX;
        r0.setImageBitmap(r4);
    L_0x00b5:
        r0 = r1.ilY;
        r0.setVisibility(r6);
        goto L_0x0066;
    L_0x00bb:
        r0 = r7.aFL();
        if (r8 != r0) goto L_0x00d5;
    L_0x00c1:
        r0 = com.tencent.mm.ak.o.Pj();
        r2 = "";
        r3 = r1.ilX;
        r0.a(r2, r3);
        r0 = r1.ilX;
        r2 = com.tencent.mm.R.k.emoji_add;
        r0.setImageResource(r2);
        goto L_0x00b5;
    L_0x00d5:
        r0 = r7.ilP;
        r0 = r0.get(r8);
        r0 = (com.tencent.mm.storage.emotion.EmojiInfo) r0;
        r2 = r1.ilX;
        r7.a(r2, r0);
        goto L_0x00b5;
    L_0x00e3:
        r0 = r7.getCount();
        r2 = r7.aFK();
        r0 = r0 - r2;
        r0 = r0 + 1;
        if (r8 != r0) goto L_0x0108;
    L_0x00f0:
        r0 = com.tencent.mm.ak.o.Pj();
        r2 = "";
        r3 = r1.ilX;
        r0.a(r2, r3);
        r0 = r1.ilX;
        r0.setImageBitmap(r4);
    L_0x0101:
        r0 = r1.ilY;
        r0.setVisibility(r6);
        goto L_0x0066;
    L_0x0108:
        r0 = r7.aFL();
        if (r8 != r0) goto L_0x0129;
    L_0x010e:
        r0 = com.tencent.mm.ak.o.Pj();
        r2 = "";
        r3 = r1.ilX;
        r0.a(r2, r3);
        r0 = r1.ilX;
        r2 = com.tencent.mm.R.g.progress_large_holo;
        r0.setImageResource(r2);
        r0 = r1.ilX;
        r2 = r7.ilQ;
        r0.startAnimation(r2);
        goto L_0x0101;
    L_0x0129:
        r0 = r7.ilP;
        r0 = r0.get(r8);
        r0 = (com.tencent.mm.storage.emotion.EmojiInfo) r0;
        r2 = r1.ilX;
        r7.a(r2, r0);
        goto L_0x0101;
    L_0x0137:
        r0 = r7.getCount();
        r2 = r7.aFK();
        r0 = r0 - r2;
        r0 = r0 + 1;
        if (r8 != r0) goto L_0x015c;
    L_0x0144:
        r0 = com.tencent.mm.ak.o.Pj();
        r2 = "";
        r3 = r1.ilX;
        r0.a(r2, r3);
        r0 = r1.ilX;
        r0.setImageBitmap(r4);
    L_0x0155:
        r0 = r1.ilY;
        r0.setVisibility(r6);
        goto L_0x0066;
    L_0x015c:
        r0 = r7.aFL();
        if (r8 != r0) goto L_0x0174;
    L_0x0162:
        r0 = com.tencent.mm.ak.o.Pj();
        r2 = "";
        r3 = r1.ilX;
        r0.a(r2, r3);
        r0 = r1.ilX;
        r0.setImageBitmap(r4);
        goto L_0x0155;
    L_0x0174:
        r0 = r7.ilP;
        r0 = r0.get(r8);
        r0 = (com.tencent.mm.storage.emotion.EmojiInfo) r0;
        r2 = r1.ilX;
        r7.a(r2, r0);
        r2 = r0.field_catalog;
        r3 = com.tencent.mm.storage.emotion.EmojiGroupInfo.tcz;
        if (r2 == r3) goto L_0x0155;
    L_0x0187:
        r2 = r1.ilY;
        r2.setVisibility(r5);
        r1 = r1.ilY;
        r2 = r7.ilG;
        r2 = com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.l(r2);
        r0 = r0.Xh();
        r0 = r2.contains(r0);
        r1.setChecked(r0);
        goto L_0x0066;
    L_0x01a1:
        r0 = r7.getCount();
        r2 = r7.aFK();
        r0 = r0 - r2;
        r0 = r0 + 1;
        if (r8 != r0) goto L_0x01c0;
    L_0x01ae:
        r0 = com.tencent.mm.ak.o.Pj();
        r2 = "";
        r3 = r1.ilX;
        r0.a(r2, r3);
        r0 = r1.ilX;
        r0.setImageBitmap(r4);
        goto L_0x0155;
    L_0x01c0:
        r0 = r7.aFL();
        if (r8 != r0) goto L_0x01d9;
    L_0x01c6:
        r0 = com.tencent.mm.ak.o.Pj();
        r2 = "";
        r3 = r1.ilX;
        r0.a(r2, r3);
        r0 = r1.ilX;
        r0.setImageBitmap(r4);
        goto L_0x0155;
    L_0x01d9:
        r0 = r7.ilP;
        r0 = r0.get(r8);
        r0 = (com.tencent.mm.storage.emotion.EmojiInfo) r0;
        r2 = r1.ilX;
        r7.a(r2, r0);
        goto L_0x0155;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$b.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public final boolean aFM() {
        au.HU();
        if (c.isSDCardAvailable()) {
            d dVar = i.aEA().igx;
            List arrayList = new ArrayList();
            Cursor b = dVar.diF.b("select * from EmojiInfo where catalog=? order by reserved3 asc", new String[]{EmojiGroupInfo.tcA}, 2);
            if (b.moveToFirst()) {
                do {
                    com.tencent.mm.plugin.emoji.d.aDh();
                    EmojiInfo emojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.d.aDi());
                    emojiInfo.d(b);
                    arrayList.add(emojiInfo);
                } while (b.moveToNext());
            }
            b.close();
            this.ilP = (ArrayList) arrayList;
        } else {
            this.ilP = new ArrayList();
        }
        if (EmojiCustomUI.k(this.ilG) == EmojiCustomUI.c.ilS) {
            int size = EmojiCustomUI.l(this.ilG) == null ? 0 : EmojiCustomUI.l(this.ilG).size();
            this.ilG.setMMTitle(this.ilG.getString(R.l.emoji_select_count, new Object[]{Integer.valueOf(size)}));
        } else {
            this.ilG.setMMTitle(this.ilG.getString(R.l.emoji_custom_title, new Object[]{Integer.valueOf(this.ilP.size())}));
        }
        return true;
    }

    private void a(ImageView imageView, EmojiInfo emojiInfo) {
        imageView.setImageBitmap(null);
        String cnF = emojiInfo.cnF();
        String str = cnF + "_cover";
        a aVar = new a();
        aVar.dXD = 1;
        aVar.dXK = true;
        aVar.bOX = str;
        aVar.dXA = cnF;
        aVar.dYc = new Object[]{emojiInfo};
        aVar.dYa = true;
        com.tencent.mm.ak.a.a.c Pt = aVar.Pt();
        o.Pj().a(cnF, imageView, Pt, null, EmojiCustomUI.m(this.ilG), EmojiCustomUI.n(this.ilG));
    }
}
