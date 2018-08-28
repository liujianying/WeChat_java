package com.tencent.mm.view.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.ak.a.c.d;
import com.tencent.mm.ak.a.c.e;
import com.tencent.mm.ak.a.c.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.n.a.f;
import com.tencent.mm.plugin.n.a.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.y;
import com.tencent.mm.view.f.a;
import java.util.ArrayList;

public final class c extends a {
    private l dYr = new 3(this);
    private d ilE = new 2(this);
    ArrayList<EmojiInfo> inB;
    private e uTL = new 1(this);

    public c(Context context, a aVar) {
        super(context, aVar);
    }

    public final int getCount() {
        if (this.uTH != this.uSE - 1) {
            return this.uTG;
        }
        int i = this.hou - (this.uTH * this.uTG);
        if (i < 0) {
            return 0;
        }
        return i;
    }

    private EmojiInfo oO(int i) {
        int i2 = (this.uTH * this.uTG) + i;
        if (this.uSC == 25 && this.uSM.fdx != ChatFooterPanel.qFf) {
            i2--;
        }
        if (this.inB == null || i2 < 0 || i2 >= this.inB.size()) {
            return null;
        }
        return (EmojiInfo) this.inB.get(i2);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = y.gq(this.mContext).inflate(f.smiley_grid_item_l, null);
            view.setLayoutParams(new LayoutParams(this.uSM.getColumnWidth(), this.uSM.uWe));
            a aVar2 = new a(this, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (this.uSC == 25 && this.uTH == 0 && i == 0 && this.uSM.fdx != ChatFooterPanel.qFf) {
            ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDZ().a("", aVar.gmn);
            aVar.gmn.setBackgroundResource(com.tencent.mm.plugin.n.a.d.app_panel_shade);
            aVar.gmn.setImageResource(com.tencent.mm.plugin.n.a.g.app_panel_setting_icon);
            aVar.gmn.setContentDescription(view.getContext().getString(h.settings_emoji_manager));
            int aDV = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDV();
            com.tencent.mm.bo.a.cgy();
            if (aDV > (((com.tencent.mm.kernel.b.h) g.Ef().DM()).ES() ? bi.getInt(com.tencent.mm.k.g.AT().getValue("CustomEmojiMaxSize"), 150) : com.tencent.mm.bo.a.sCw.getInt("EmotionRecommandCount", 3))) {
                aVar.uTN.setVisibility(0);
                aVar.uTN.setText(h.emoji_over_size);
            } else {
                aVar.uTN.setVisibility(8);
            }
        } else {
            aVar.uTN.setVisibility(8);
            EmojiInfo oO = oO(i);
            if (oO == null) {
                x.w("MicroMsg.smiley.EmojiSmileyAdapter", "emoji is null.");
                aVar.gmn.setVisibility(8);
                aVar.eCn.setVisibility(8);
                ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDZ().a("", aVar.gmn);
            } else {
                aVar.gmn.setVisibility(0);
                CharSequence zf = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().zf(oO.Xh());
                if (bi.oW(zf) || this.uSC != 23) {
                    aVar.eCn.setVisibility(8);
                } else {
                    aVar.eCn.setText(zf);
                    aVar.eCn.setVisibility(0);
                }
                aVar.gmn.setBackgroundResource(com.tencent.mm.plugin.n.a.d.smiley_item_bg2);
                String name;
                String replaceAll;
                com.tencent.mm.ak.a.a aDZ;
                com.tencent.mm.ak.a.a.c.a aVar3;
                com.tencent.mm.ak.a.a.c Pt;
                if (this.uSC == 25) {
                    if (oO.field_catalog == EmojiGroupInfo.tcz || oO.field_catalog == EmojiInfo.tcG || oO.field_catalog == EmojiInfo.tcF) {
                        name = oO.getName();
                        if (bi.oW(name)) {
                            x.i("MicroMsg.smiley.EmojiSmileyAdapter", "name is null");
                        } else {
                            replaceAll = name.replaceAll(".png", "");
                            aDZ = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDZ();
                            ImageView imageView = aVar.gmn;
                            com.tencent.mm.ak.a.a.c.a aVar4 = new com.tencent.mm.ak.a.a.c.a();
                            aVar4.dXD = 3;
                            aVar4.dXR = com.tencent.mm.plugin.n.a.d.smiley_item_bg2;
                            aDZ.a(replaceAll, imageView, aVar4.Pt());
                            if (replaceAll.equalsIgnoreCase("dice")) {
                                aVar.gmn.setContentDescription(view.getContext().getString(h.emoji_dice));
                            } else if (replaceAll.equalsIgnoreCase("jsb")) {
                                aVar.gmn.setContentDescription(view.getContext().getString(h.emoji_jsb));
                            }
                        }
                    } else {
                        replaceAll = oO.cnF();
                        name = replaceAll + "_cover";
                        aVar3 = new com.tencent.mm.ak.a.a.c.a();
                        aVar3.dXD = 1;
                        aVar3.dXR = com.tencent.mm.plugin.n.a.d.smiley_item_bg2;
                        aVar3.dXK = true;
                        aVar3.bOX = name;
                        aVar3.dXA = replaceAll;
                        aVar3.dXL = true;
                        aVar3.dYc = new Object[]{oO};
                        aVar3.dYa = true;
                        Pt = aVar3.Pt();
                        if (((com.tencent.mm.kernel.b.h) g.Ef().DM()).ES()) {
                            ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDZ().a(replaceAll, aVar.gmn, Pt, this.uTL, this.ilE, this.dYr);
                        } else {
                            ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDZ().a(replaceAll, aVar.gmn, Pt, null, this.ilE, this.dYr);
                        }
                    }
                } else if (!oO.field_groupId.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.tcy))) {
                    replaceAll = oO.cnF();
                    name = replaceAll + "_cover";
                    aVar3 = new com.tencent.mm.ak.a.a.c.a();
                    aVar3.dXD = 1;
                    aVar3.dXR = com.tencent.mm.plugin.n.a.d.smiley_item_bg2;
                    aVar3.dXK = true;
                    aVar3.bOX = name;
                    aVar3.dXA = replaceAll;
                    aVar3.dXL = true;
                    aVar3.dYc = new Object[]{oO};
                    aVar3.dYa = true;
                    Pt = aVar3.Pt();
                    if (((com.tencent.mm.kernel.b.h) g.Ef().DM()).ES()) {
                        ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDZ().a(replaceAll, aVar.gmn, Pt, this.uTL, this.ilE, this.dYr);
                    } else {
                        ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDZ().a(replaceAll, aVar.gmn, Pt, null, this.ilE, this.dYr);
                    }
                } else if (bi.oW(oO.getName())) {
                    x.i("MicroMsg.smiley.EmojiSmileyAdapter", "name is null");
                } else {
                    replaceAll = (bi.oW(oO.getContent()) ? oO.getName() : oO.getContent()).replaceAll(".png", "");
                    aDZ = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDZ();
                    ImageView imageView2 = aVar.gmn;
                    com.tencent.mm.ak.a.a.c.a aVar5 = new com.tencent.mm.ak.a.a.c.a();
                    aVar5.dXD = 3;
                    aVar5.dXR = com.tencent.mm.plugin.n.a.d.smiley_item_bg2;
                    aDZ.a(replaceAll, imageView2, aVar5.Pt());
                }
            }
        }
        return view;
    }
}
