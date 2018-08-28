package com.tencent.mm.view.f;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.bo.a.b;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bnv;
import com.tencent.mm.protocal.c.bnw;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class a {
    public int OT;
    private final String TAG;
    public int fdx;
    public int gKZ;
    public int gLa;
    public int irI;
    public int jub;
    public String qLj;
    private Context rc;
    private int uSW;
    public boolean uWA;
    public boolean uWB;
    public boolean uWC;
    public int[] uWD;
    public boolean uWE;
    public boolean uWF;
    public ArrayList<com.tencent.mm.view.c.a> uWG;
    public HashMap<String, Integer> uWH;
    public List<u> uWI;
    public c uWJ;
    public volatile boolean uWK;
    public int uWb;
    public int uWc;
    public int uWd;
    public int uWe;
    public int uWf;
    public int uWg;
    public int uWh;
    public int uWi;
    private int uWj;
    private int uWk;
    public int uWl;
    private int uWm;
    private int uWn;
    public int uWo;
    private int uWp;
    private int uWq;
    private int uWr;
    public String uWs;
    public int uWt;
    public boolean uWu;
    public boolean uWv;
    public boolean uWw;
    public boolean uWx;
    public boolean uWy;
    public boolean uWz;
    public int uuh;

    public a() {
        this.TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelStg";
        this.uuh = 0;
        this.uWk = 0;
        this.OT = 0;
        this.jub = 0;
        this.uWs = "";
        this.uWt = 0;
        this.uWB = false;
        this.uWC = false;
        this.uWG = new ArrayList();
        this.uWH = new HashMap();
        this.uWI = new ArrayList();
        this.uWK = false;
        this.rc = ad.getContext();
        this.uWb = this.rc.getResources().getDimensionPixelSize(com.tencent.mm.plugin.n.a.c.emoji_panel_tab_height);
        this.irI = this.rc.getResources().getDimensionPixelSize(com.tencent.mm.plugin.n.a.c.emoji_panel_tab_width);
        this.uWc = this.rc.getResources().getDimensionPixelSize(com.tencent.mm.plugin.n.a.c.emoji_panel_tab_image_size);
        this.uWh = com.tencent.mm.bp.a.fromDPToPix(this.rc, 48);
        this.uWi = com.tencent.mm.bp.a.fromDPToPix(this.rc, 43);
        this.uWe = com.tencent.mm.bp.a.fromDPToPix(this.rc, 86);
        this.uWf = com.tencent.mm.bp.a.fromDPToPix(this.rc, 80);
        this.uWg = com.tencent.mm.bp.a.fromDPToPix(this.rc, 65);
        this.uWd = com.tencent.mm.bp.a.ad(this.rc, com.tencent.mm.plugin.n.a.c.BasicPaddingSize);
        this.uWm = com.tencent.mm.bp.a.fromDPToPix(this.rc, 6);
        this.uWs = "TAG_DEFAULT_TAB";
        this.uWt = 0;
        this.uSW = com.tencent.mm.bp.a.ad(this.rc, com.tencent.mm.plugin.n.a.c.smiley_panel_dot_height);
        this.uWj = com.tencent.mm.bp.a.ad(this.rc, com.tencent.mm.plugin.n.a.c.BasicPaddingSize);
        this.uWn = com.tencent.mm.bp.a.ad(this.rc, com.tencent.mm.plugin.n.a.c.smiley_panel_top_space);
        this.uWo = com.tencent.mm.bp.a.ad(this.rc, com.tencent.mm.plugin.n.a.c.smiley_panel_top_space_min);
        this.uWp = this.uWn;
        this.uWq = com.tencent.mm.bp.a.fromDPToPix(this.rc, 8);
        this.uWr = com.tencent.mm.bp.a.fromDPToPix(this.rc, 16);
        cCK();
        cCB();
        cCM();
    }

    public final void onPause() {
        this.uWz = false;
        cCA();
        long currentTimeMillis = System.currentTimeMillis();
        bnv bnv = new bnv();
        if (!(this.uWH == null || this.uWH.isEmpty())) {
            for (String str : this.uWH.keySet()) {
                bnw bnw = new bnw();
                bnw.rem = str;
                bnw.rgz = ((Integer) this.uWH.get(str)).intValue();
                bnv.slO.add(bnw);
            }
            ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().a(bnv);
        }
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "save Smiley TabMap use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        cCJ();
        ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aEc();
    }

    public static boolean cCx() {
        boolean CT;
        boolean CT2;
        Exception e;
        boolean z;
        try {
            if (((h) g.Ef().DM()).ES()) {
                com.tencent.mm.bo.a.cgy();
                b bVar = com.tencent.mm.bo.a.sCv;
                CT = b.CT(208913);
                try {
                    com.tencent.mm.bo.a.cgy();
                    b bVar2 = com.tencent.mm.bo.a.sCv;
                    CT2 = b.CT(208899);
                } catch (Exception e2) {
                    e = e2;
                    z = CT;
                }
            } else {
                CT = false;
                CT2 = false;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
            x.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "[cpan] get new emoji flag faild.%s", new Object[]{e.toString()});
            CT = z;
            CT2 = false;
            if (!CT2) {
            }
            return true;
        }
        if (CT2 || CT) {
            return true;
        }
        return false;
    }

    public static boolean cCy() {
        boolean aT;
        Exception e;
        boolean aT2;
        try {
            if (((h) g.Ef().DM()).ES()) {
                aT = com.tencent.mm.s.c.Cp().aT(262147, 266244);
                try {
                    aT2 = com.tencent.mm.s.c.Cp().aT(262149, 266244);
                } catch (Exception e2) {
                    e = e2;
                }
            } else {
                aT2 = false;
                aT = false;
            }
        } catch (Exception e3) {
            e = e3;
            aT = false;
            x.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "[cpan] get new emoji flag faild.%s", new Object[]{e.toString()});
            aT2 = false;
            if (!aT) {
            }
            return true;
        }
        if (aT || aT2) {
            return true;
        }
        return false;
    }

    public final int abR(String str) {
        if ("TAG_DEFAULT_TAB".equals(str)) {
            return this.uWh;
        }
        return this.uWe;
    }

    public final void GW(int i) {
        this.gKZ = i;
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "set viewpager height px: %d mViewPagerHeightPx:%d ", new Object[]{Integer.valueOf(i), Integer.valueOf(this.gKZ)});
    }

    public final int cCz() {
        if (this.gLa <= 1) {
            this.gLa = anG()[0];
        }
        return this.gLa;
    }

    public final void setShowProductId(String str) {
        if (!bi.oW(str)) {
            this.uWs = str;
        }
    }

    public final void cCA() {
        if (!bi.oW(this.uWs) && !this.uWu) {
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "save product Id:%s selected index:%d", new Object[]{this.uWs, Integer.valueOf(this.uWt)});
            com.tencent.mm.bo.a.cgy();
            b bVar = com.tencent.mm.bo.a.sCv;
            b.VP(this.uWs);
        }
    }

    public final void cCB() {
        if (!this.uWu) {
            com.tencent.mm.bo.a.cgy();
            b bVar = com.tencent.mm.bo.a.sCv;
            this.uWs = b.aX(-29414086, "TAG_DEFAULT_TAB");
            this.uWt = bi.a((Integer) this.uWH.get(this.uWs), 0);
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "restoreShowProductId product id: %s selected index:%d", new Object[]{this.uWs, Integer.valueOf(this.uWt)});
        } else if (!this.uWs.equals("TAG_DEFAULT_TAB")) {
            this.uWs = "TAG_DEFAULT_TAB";
            this.uWt = bi.a((Integer) this.uWH.get(this.uWs), 0);
        }
    }

    public static EmojiGroupInfo cCC() {
        EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
        emojiGroupInfo.field_productID = "TAG_DEFAULT_TAB";
        return emojiGroupInfo;
    }

    public static EmojiGroupInfo cCD() {
        EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo();
        emojiGroupInfo.field_productID = String.valueOf(EmojiGroupInfo.tcz);
        return emojiGroupInfo;
    }

    public static boolean d(EmojiGroupInfo emojiGroupInfo) {
        return emojiGroupInfo != null && emojiGroupInfo.field_packStatus == 1;
    }

    public final boolean cCE() {
        com.tencent.mm.bo.a.cgy();
        b bVar = com.tencent.mm.bo.a.sCv;
        return b.CT(66832) && !this.uWA;
    }

    public final com.tencent.mm.view.c.a abS(String str) {
        if (this.uWG == null || str == null) {
            x.w("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "getTab failed.");
            return null;
        }
        Iterator it = this.uWG.iterator();
        while (it.hasNext()) {
            com.tencent.mm.view.c.a aVar = (com.tencent.mm.view.c.a) it.next();
            if (aVar == null) {
                x.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "get null tab");
            } else if (aVar.iiv == null) {
                x.e("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "get null tab productId");
            } else if (aVar.iiv.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public final com.tencent.mm.view.c.a GX(int i) {
        if (this.uWG == null) {
            return null;
        }
        return (com.tencent.mm.view.c.a) this.uWG.get(GY(i));
    }

    public final int GY(int i) {
        if (this.uWD == null || i >= this.uWD.length || i <= 0) {
            return 0;
        }
        return this.uWD[i];
    }

    public final int cCF() {
        String str = this.uWs;
        if (this.uWG != null) {
            for (int i = 0; i < this.uWG.size(); i++) {
                com.tencent.mm.view.c.a aVar = (com.tencent.mm.view.c.a) this.uWG.get(i);
                if (aVar != null && aVar.iiv.equals(str)) {
                    return i;
                }
            }
        }
        return 0;
    }

    public final com.tencent.mm.view.c.a cCG() {
        return abS(this.uWs);
    }

    public final void cCH() {
        this.jub = 0;
        if (this.uWG != null) {
            com.tencent.mm.view.c.a aVar;
            Iterator it = this.uWG.iterator();
            while (it.hasNext()) {
                aVar = (com.tencent.mm.view.c.a) it.next();
                this.jub = aVar.cCn() + this.jub;
            }
            if (this.uWG != null) {
                try {
                    this.uWD = new int[this.jub];
                    int i = 0;
                    loop1:
                    for (int i2 = 0; i2 < this.uWG.size(); i2++) {
                        aVar = (com.tencent.mm.view.c.a) this.uWG.get(i2);
                        int i3 = 0;
                        while (i3 < aVar.cCn()) {
                            if (i >= this.jub) {
                                break loop1;
                            }
                            int i4 = i + 1;
                            this.uWD[i] = i2;
                            i3++;
                            i = i4;
                        }
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", e, "", new Object[0]);
                }
            }
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "refreshAllCount count: %d", new Object[]{Integer.valueOf(this.jub)});
        }
    }

    public final void a(com.tencent.mm.view.c.a aVar) {
        String str = aVar.iiv;
        int i = aVar.pGW;
        int abR;
        if (str.equals("TAG_DEFAULT_TAB")) {
            abR = (this.gKZ - (this.uWn * 2)) - (abR(str) * i);
            if (abR >= this.uWr) {
                aVar.uVy = this.uWn;
                aVar.uVx = (abR - this.uWr) / (i - 1);
                return;
            } else if (abR >= this.uWq) {
                aVar.uVy = this.uWn;
                aVar.uVx = 0;
                return;
            } else {
                if (t.fC(this.rc)) {
                    abR = (abR - this.uWq) / (i + 1);
                } else {
                    abR /= i + 1;
                }
                i = this.uWn + abR;
                if (i < this.uWo) {
                    aVar.uVy = this.uWo;
                } else {
                    aVar.uVy = i;
                }
                aVar.uVx = abR;
                return;
            }
        }
        abR = ((this.gKZ - (this.uSW - this.uWj)) - (abR(str) * i)) / (i + 1);
        aVar.uVy = abR;
        aVar.uVx = abR;
    }

    public static boolean isSDCardAvailable() {
        if (!((h) g.Ef().DM()).ES()) {
            return true;
        }
        g.Ek();
        return g.Ei().isSDCardAvailable();
    }

    public final boolean cCI() {
        if (this.OT == 0) {
            int[] anG = anG();
            if (anG[0] < anG[1]) {
                this.OT = 1;
            } else {
                this.OT = 2;
            }
        }
        return this.OT == 1;
    }

    private int[] anG() {
        int[] iArr = new int[2];
        if (this.rc instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) this.rc).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) this.rc.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        return iArr;
    }

    public final void cCJ() {
        if (this.uWJ != null) {
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "remove succeed send listener");
            com.tencent.mm.sdk.b.a.sFg.c(this.uWJ);
            this.uWJ = null;
        }
    }

    public final int getColumnWidth() {
        int i = 4;
        if (this.uuh == 0) {
            int cCz = cCz() / this.uWf;
            if (!cCI()) {
                i = cCz;
            } else if (cCz <= 4) {
                i = cCz;
            }
            this.uuh = cCz() / i;
        }
        return this.uuh;
    }

    public final void cCK() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.uWH == null) {
            this.uWH = new HashMap();
        }
        this.uWH.clear();
        bnv aDU = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDU();
        if (!(aDU == null || aDU.slO == null || aDU.slO.isEmpty())) {
            Iterator it = aDU.slO.iterator();
            while (it.hasNext()) {
                bnw bnw = (bnw) it.next();
                this.uWH.put(bnw.rem, Integer.valueOf(bnw.rgz));
            }
        }
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "restore smiley tab map use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public final boolean cCL() {
        return this.uWI != null && this.uWI.size() >= 3;
    }

    public final void cCM() {
        this.uWI = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aEb();
    }
}
