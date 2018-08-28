package com.tencent.mm.br;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.mm.g.a.hd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.n.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.storage.emotion.s;
import java.util.ArrayList;

public class e {
    private static e sLQ = null;
    private String[] sLR;
    private String[] sLS;
    private String[] sLT;
    private ArrayList<s> sLU = new ArrayList();
    private SparseArray<s> sLV = new SparseArray();

    public e(Context context) {
        this.sLR = context.getResources().getStringArray(a.merge_smiley_code_smiley);
        this.sLS = context.getResources().getStringArray(a.merge_smiley_softbank_emoji);
        this.sLT = context.getResources().getStringArray(a.merge_smiley_unicode_emoji);
        this.sLU.clear();
        this.sLV.clear();
        cjG();
    }

    private void cjG() {
        int i = 0;
        if (this.sLR != null && this.sLS != null) {
            int length = this.sLR.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                s sVar = new s(i3, this.sLR[i2]);
                this.sLU.add(sVar);
                this.sLV.put(i3, sVar);
                i2++;
                i3++;
            }
            i2 = this.sLS.length;
            while (i < i2) {
                s sVar2 = new s(i3, this.sLS[i]);
                this.sLU.add(sVar2);
                this.sLV.put(i3, sVar2);
                i++;
                i3++;
            }
        }
    }

    public int apV() {
        x.d("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo");
        this.sLU.clear();
        ArrayList aDS = ((PluginEmoji) g.n(PluginEmoji.class)).getEmojiMgr().aDS();
        if (aDS == null || aDS.isEmpty()) {
            cjG();
            x.i("MicroMsg.MergerSmileyManager", "smiley panel list is null.");
            return -1;
        }
        ArrayList aDR = ((PluginEmoji) g.n(PluginEmoji.class)).getEmojiMgr().aDR();
        int size = aDS.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            s sVar = (s) aDS.get(i);
            String str = sVar.field_key;
            if (!str.startsWith("[") || aDR.contains(str)) {
                this.sLU.add(sVar);
                this.sLV.put(i2, sVar);
                i3 = i2 + 1;
            } else {
                x.i("MicroMsg.MergerSmileyManager", "no smiley info. key:%s", new Object[]{str});
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        return 0;
    }

    public int apW() {
        return this.sLU == null ? 0 : this.sLU.size();
    }

    public static e cjH() {
        if (sLQ == null) {
            synchronized (e.class) {
                sLQ = new e(ad.getContext());
            }
        }
        return sLQ;
    }

    public Drawable mg(int i) {
        if (this.sLV == null) {
            x.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley panel map is null.");
            return null;
        }
        s sVar = (s) this.sLV.get(i);
        if (sVar == null) {
            x.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley info is null.");
            return null;
        }
        Drawable mg;
        q Xz = f.cjI().Xz(sVar.field_key);
        int i2;
        if (Xz != null) {
            f.cjI();
            i2 = Xz.field_position;
            mg = i2 >= 0 ? b.cjC().mg(i2) : f.Xy(Xz.field_fileName);
        } else {
            c cVar;
            b cjC = b.cjC();
            String str = sVar.field_key;
            if (bi.oW(str)) {
                x.i("MicroMsg.EmojiHelper", "getEmoji item failed. key is null.");
                cVar = null;
            } else {
                i2 = str.codePointAt(0);
                cVar = cjC.Dg(i2) != null ? cjC.Dg(i2) : cjC.eH(i2, 0);
            }
            mg = b.cjC().a(cVar, true);
        }
        return mg;
    }

    public String getText(int i) {
        if (i < 0 || i >= this.sLU.size()) {
            x.w("MicroMsg.MergerSmileyManager", "get text, error index");
            return "";
        }
        s sVar = (s) this.sLU.get(i);
        if (sVar == null) {
            return "";
        }
        q Xz = f.cjI().Xz(sVar.field_key);
        if (Xz != null) {
            if (w.chM() && !bi.oW(Xz.field_cnValue)) {
                return Xz.field_cnValue;
            }
            if (w.chN() && !bi.oW(Xz.field_twValue)) {
                return Xz.field_twValue;
            }
        }
        return sVar.field_key;
    }

    public String mi(int i) {
        if (i < 0) {
            x.w("MicroMsg.MergerSmileyManager", "get text, error index");
            return "";
        }
        s sVar = (s) this.sLU.get(i);
        if (sVar != null) {
            return sVar.field_key;
        }
        return "";
    }

    public String mh(int i) {
        if (i < 0) {
            x.w("MicroMsg.MergerSmileyManager", "get emoji text, error index down");
            return "";
        }
        hd hdVar = new hd();
        com.tencent.mm.sdk.b.a.sFg.m(hdVar);
        if ((hdVar.bQr.bKi == 1 ? 1 : 0) == 0) {
            return cjH().sLS[i];
        }
        String[] split = cjH().sLS[i].split(" ");
        char[] toChars = Character.toChars(Integer.decode(split[0]).intValue());
        char[] toChars2 = Character.toChars(Integer.decode(split[1]).intValue());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(toChars);
        stringBuilder.append(toChars2);
        return stringBuilder.toString();
    }
}
