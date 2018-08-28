package com.tencent.mm.view.c;

import com.tencent.mm.br.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;

public final class a {
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelInfo";
    public int gKG;
    public String iiv;
    public int pGW;
    public int pGX;
    public com.tencent.mm.view.f.a uSK;
    public int uVA;
    public com.tencent.mm.view.e.a uVv;
    public int uVw;
    public int uVx;
    public int uVy;
    public boolean uVz = false;

    public a(EmojiGroupInfo emojiGroupInfo, int i, int i2, com.tencent.mm.view.f.a aVar, com.tencent.mm.view.e.a aVar2, boolean z) {
        if (emojiGroupInfo == null || bi.oW(emojiGroupInfo.field_productID)) {
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelInfo", "catch invalid Smiley Tab want add??!!");
            return;
        }
        this.uVv = aVar2;
        this.uSK = aVar;
        this.iiv = emojiGroupInfo.field_productID;
        this.gKG = i;
        this.uVA = i2;
        if (z || emojiGroupInfo.field_productID.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.tcy))) {
            int apW;
            com.tencent.mm.view.f.a aVar3;
            String str;
            com.tencent.mm.view.f.a aVar4;
            String str2;
            com.tencent.mm.view.f.a aVar5 = this.uSK;
            if (emojiGroupInfo != null) {
                int zs;
                if (emojiGroupInfo.field_productID.equals("TAG_DEFAULT_TAB")) {
                    apW = e.cjH().apW();
                    aVar5.cCL();
                } else if (emojiGroupInfo.field_productID.equals(String.valueOf(EmojiGroupInfo.tcz))) {
                    apW = com.tencent.mm.view.f.a.isSDCardAvailable() ? ((c) g.n(c.class)).getProvider().aDV() + 1 : 0;
                } else if (emojiGroupInfo.field_productID.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.tcy))) {
                    apW = com.tencent.mm.view.f.a.isSDCardAvailable() ? 16 : 0;
                } else if (com.tencent.mm.view.f.a.d(emojiGroupInfo)) {
                    apW = 1;
                    if (emojiGroupInfo != null) {
                        if (emojiGroupInfo.field_count > 0) {
                            apW = emojiGroupInfo.field_count;
                        } else {
                            zs = ((c) g.n(c.class)).getProvider().zs(emojiGroupInfo.field_productID);
                            emojiGroupInfo.field_count = zs;
                            long currentTimeMillis = System.currentTimeMillis();
                            ((c) g.n(c.class)).getProvider().a(emojiGroupInfo);
                            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                            apW = zs;
                        }
                    }
                    if (apW == 0) {
                        apW = 1;
                    }
                    if (!com.tencent.mm.view.f.a.isSDCardAvailable()) {
                        apW = 0;
                    }
                }
                if (aVar5.uWv) {
                    apW--;
                }
                this.uVw = apW;
                aVar3 = this.uSK;
                str = this.iiv;
                if (aVar3.gKZ > 0 || bi.oW(str)) {
                    apW = 1;
                } else if (str.equals("TAG_STORE_TAB")) {
                    apW = 1;
                } else {
                    apW = str.equals("TAG_DEFAULT_TAB") ? (aVar3.gKZ - aVar3.uWo) / aVar3.abR(str) : aVar3.gKZ / aVar3.abR(str);
                    zs = bi.oW(str) ? 0 : str.equals("TAG_DEFAULT_TAB") ? 3 : 2;
                    if (apW > zs) {
                        apW = zs;
                    }
                    if (apW <= 0) {
                        apW = 1;
                    }
                }
                this.pGW = apW;
                aVar4 = this.uSK;
                str2 = this.iiv;
                if (bi.oW(str2)) {
                    apW = 0;
                } else if (str2.equals("TAG_DEFAULT_TAB")) {
                    apW = aVar4.cCI() ? 7 : aVar4.cCz() / aVar4.uWi;
                } else if (aVar4.gKZ <= 0) {
                    apW = 0;
                } else if (str2.equals("TAG_STORE_TAB")) {
                    apW = 3;
                } else {
                    apW = aVar4.cCz() / aVar4.uWf;
                    if (aVar4.cCI() && apW > 4) {
                        apW = 4;
                    }
                    x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "return calc Col Nums: %d", new Object[]{Integer.valueOf(apW)});
                }
                this.pGX = apW;
                this.uSK.a(this);
            }
            apW = 1;
            if (aVar5.uWv) {
                apW--;
            }
            this.uVw = apW;
            aVar3 = this.uSK;
            str = this.iiv;
            if (aVar3.gKZ > 0) {
            }
            apW = 1;
            this.pGW = apW;
            aVar4 = this.uSK;
            str2 = this.iiv;
            if (bi.oW(str2)) {
                apW = 0;
            } else if (str2.equals("TAG_DEFAULT_TAB")) {
                apW = aVar4.cCI() ? 7 : aVar4.cCz() / aVar4.uWi;
            } else if (aVar4.gKZ <= 0) {
                apW = 0;
            } else if (str2.equals("TAG_STORE_TAB")) {
                apW = 3;
            } else {
                apW = aVar4.cCz() / aVar4.uWf;
                if (aVar4.cCI() && apW > 4) {
                    apW = 4;
                }
                x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "return calc Col Nums: %d", new Object[]{Integer.valueOf(apW)});
            }
            this.pGX = apW;
            this.uSK.a(this);
        } else {
            this.uVw = 1;
            this.pGW = 1;
            this.pGX = 1;
            this.uSK.a(this);
        }
        this.uVz = z;
        x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelInfo", "smiley panel tab: productId: %s, startIndex: %d mAllEmojiNums: %d mRow:%d mCol:%d mSpacing:%d ", new Object[]{this.iiv, Integer.valueOf(i), Integer.valueOf(this.uVw), Integer.valueOf(this.pGW), Integer.valueOf(this.pGX), Integer.valueOf(this.uVx)});
    }

    public final int getType() {
        String str = this.iiv;
        if (str.equals("TAG_DEFAULT_TAB")) {
            return 20;
        }
        return str.equals(String.valueOf(EmojiGroupInfo.tcz)) ? 25 : 23;
    }

    public final int aqd() {
        return this.pGW * this.pGX;
    }

    public final int cCn() {
        if (aqd() <= 0) {
            return 0;
        }
        if (!"TAG_DEFAULT_TAB".equals(this.iiv)) {
            return (int) Math.ceil(((double) this.uVw) / ((double) aqd()));
        }
        int ceil = (int) Math.ceil(((double) this.uVw) / ((double) (aqd() - 1)));
        if (this.uSK.cCL()) {
            return ceil + 1;
        }
        return ceil;
    }

    public final int getColumnWidth() {
        return this.uSK.cCz() / (this.uSK.cCz() / this.uSK.uWf);
    }

    public final j getSmileyPanelCallback() {
        com.tencent.mm.view.e.a aVar = this.uVv;
        return aVar.uVQ == null ? null : aVar.uVQ.getSmileyPanelCallback();
    }

    public final com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a cCo() {
        com.tencent.mm.view.e.a aVar = this.uVv;
        return aVar.uVQ == null ? null : aVar.uVQ.getTextOpListener();
    }
}
