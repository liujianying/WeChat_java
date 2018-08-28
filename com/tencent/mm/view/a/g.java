package com.tencent.mm.view.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.n.a.d;
import com.tencent.mm.plugin.n.a.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.view.f.a;
import java.io.File;
import java.util.ArrayList;

public final class g extends BaseAdapter {
    public static final String ihe = File.separator;
    private Context mContext;
    public ArrayList<EmojiGroupInfo> mData = new ArrayList();
    private a uSK;
    c uUd = null;

    public g(Context context, a aVar) {
        this.mContext = context;
        this.uSK = aVar;
        c.a aVar2 = new c.a();
        aVar2.dXw = true;
        aVar2.dXD = 4;
        aVar2.dXR = d.bottom_btn_bg;
        aVar2.dXE = this.uSK.uWc;
        aVar2.dXE = this.uSK.uWc;
        this.uUd = aVar2.Pt();
    }

    public final int getCount() {
        return this.mData == null ? 0 : this.mData.size();
    }

    /* renamed from: GS */
    public final EmojiGroupInfo getItem(int i) {
        if (this.mData == null || this.mData.isEmpty() || this.mData.size() < i) {
            return null;
        }
        return (EmojiGroupInfo) this.mData.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(f.smiley_panel_listview_item, null);
            a aVar2 = new a(this, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        EmojiGroupInfo GS = getItem(i);
        if (GS == null) {
            aVar.bOA.setVisibility(8);
            aVar.bOA.setTag("");
            x.i("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "emoji group info is null. position:%d", new Object[]{Integer.valueOf(i)});
        } else {
            aVar.bOA.setVisibility(0);
            if ("TAG_DEFAULT_TAB".equals(GS.field_productID)) {
                if (((h) com.tencent.mm.kernel.g.Ef().DM()).ES()) {
                    o.Pj().a(com.tencent.mm.plugin.n.a.g.emotionstore_emoji_icon, aVar.bOA, this.uUd);
                } else {
                    ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDZ().a(com.tencent.mm.plugin.n.a.g.emotionstore_emoji_icon, aVar.bOA, this.uUd);
                }
                aVar.bOA.setContentDescription(this.mContext.getString(com.tencent.mm.plugin.n.a.h.emoji_system));
            } else if (String.valueOf(EmojiGroupInfo.tcz).equals(GS.field_productID)) {
                if (((h) com.tencent.mm.kernel.g.Ef().DM()).ES()) {
                    o.Pj().a(com.tencent.mm.plugin.n.a.g.emotionstore_custom_icon, aVar.bOA, this.uUd);
                } else {
                    ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDZ().a(com.tencent.mm.plugin.n.a.g.emotionstore_custom_icon, aVar.bOA, this.uUd);
                }
                aVar.bOA.setContentDescription(this.mContext.getString(com.tencent.mm.plugin.n.a.h.emotion_custom));
            } else if (String.valueOf(EmojiGroupInfo.tcy).equals(GS.field_productID)) {
                if (((h) com.tencent.mm.kernel.g.Ef().DM()).ES()) {
                    o.Pj().a(d.emotions_bagcover, aVar.bOA, this.uUd);
                } else {
                    ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDZ().a(d.emotions_bagcover, aVar.bOA, this.uUd);
                }
                aVar.bOA.setContentDescription(this.mContext.getString(com.tencent.mm.plugin.n.a.h.emoji_store_tuzi_title));
            } else if ("TAG_STORE_MANEGER_TAB".equals(GS.field_productID)) {
                if (((h) com.tencent.mm.kernel.g.Ef().DM()).ES()) {
                    o.Pj().a(com.tencent.mm.plugin.n.a.g.emotionstore_manager_icon, aVar.bOA, this.uUd);
                } else {
                    ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDZ().a(com.tencent.mm.plugin.n.a.g.emotionstore_manager_icon, aVar.bOA, this.uUd);
                }
                aVar.bOA.setContentDescription(this.mContext.getString(com.tencent.mm.plugin.n.a.h.settings_emoji_manager));
            } else {
                String str;
                if (a.d(GS)) {
                    str = K(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().Gq() + "emoji/", GS.field_productID, "") + "_panel_enable";
                    c.a aVar3 = new c.a();
                    aVar3.dXA = str;
                    aVar3.dXw = true;
                    aVar3.dXR = d.bottom_btn_bg;
                    aVar3.dXD = 1;
                    aVar3.dXE = this.uSK.uWc;
                    aVar3.dXE = this.uSK.uWc;
                    ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDZ().a(str, aVar.bOA, aVar3.Pt());
                } else {
                    str = GS.field_packGrayIconUrl;
                    String K = K(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().Gq() + "emoji/", GS.field_productID, str);
                    c.a aVar4 = new c.a();
                    aVar4.dXA = K;
                    aVar4.dXw = true;
                    aVar4.dXy = true;
                    aVar4.dXR = d.bottom_btn_bg;
                    aVar4.dXH = true;
                    aVar4.dXE = this.uSK.uWc;
                    aVar4.dXE = this.uSK.uWc;
                    c Pt = aVar4.Pt();
                    if (bi.oW(str)) {
                        ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDZ().a("", aVar.bOA, Pt);
                        x.i("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "empty url.");
                    } else {
                        ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDZ().a(str, aVar.bOA, Pt);
                    }
                }
                if (bi.oW(GS.field_packName)) {
                    aVar.bOA.setContentDescription(this.mContext.getString(com.tencent.mm.plugin.n.a.h.emoji_store_title));
                } else {
                    aVar.bOA.setContentDescription(GS.field_packName);
                }
            }
            aVar.bOA.setBackgroundResource(d.bottom_btn_bg);
            aVar.bOA.setPadding(this.uSK.uWd, this.uSK.uWd, this.uSK.uWd, this.uSK.uWd);
            if (i == this.uSK.cCF()) {
                aVar.bOA.setSelected(true);
            } else {
                aVar.bOA.setSelected(false);
            }
        }
        return view;
    }

    private static String K(String str, String str2, String str3) {
        if (bi.oW(str2) && bi.oW(str3)) {
            x.w("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "[cpan] get icon path failed. productid and url are null.");
            return null;
        }
        String str4;
        if (bi.oW(str2) && bi.oW(str3)) {
            x.e("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "[cpan] product id and url are null.");
            str4 = null;
        } else {
            str4 = bi.oW(str3) ? com.tencent.mm.a.g.u(str2.getBytes()) : com.tencent.mm.a.g.u(str3.getBytes());
        }
        if (bi.oW(str4)) {
            return null;
        }
        if (bi.oW(str2)) {
            return str + str4;
        }
        return str + str2 + ihe + str4;
    }
}
