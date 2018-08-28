package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.protocal.c.tj;
import com.tencent.mm.protocal.c.ts;
import com.tencent.mm.sdk.platformtools.bi;

public class f extends a {
    private final String TAG = "MicroMsg.emoji.EmojiStoreMainAdapter";
    public boolean idH = false;
    public boolean idI = true;
    public boolean idJ = false;
    public boolean idK = true;

    public f(Context context) {
        super(context);
    }

    protected final a c(Context context, View view) {
        a aVar = new a(this, context, view);
        aVar.a(this.ieo);
        return aVar;
    }

    public final void clear() {
        super.clear();
    }

    public View b(int i, View view, ViewGroup viewGroup) {
        boolean z = true;
        a aVar = (a) view.getTag();
        com.tencent.mm.plugin.emoji.a.a.f oG = oG(i);
        if (this.idJ) {
            oG.ieF = true;
            oG.ieD = false;
            oG.ieE = false;
        }
        if (!(aVar == null || oG == null)) {
            oG.ieE = this.idK;
            tj tjVar = oG.ieA;
            if (tjVar == null) {
                aVar.oC(0);
                z = false;
            } else {
                aVar.setTitle(tjVar.bHD);
                aVar.yY(tjVar.jOS);
                if (!bi.oW(tjVar.jPG)) {
                    o.Pj().a(tjVar.jPG, aVar.aDm(), com.tencent.mm.plugin.emoji.e.f.cr("", tjVar.jPG));
                }
                if (bi.oW(tjVar.rwK)) {
                    aVar.oA(8);
                } else {
                    o.Pj().a(tjVar.rwK, aVar.aDn(), com.tencent.mm.plugin.emoji.e.f.cr("", tjVar.rwK));
                    aVar.oA(0);
                }
                aVar.oC(8);
            }
            if (!z) {
                ts tsVar = oG.iez;
                if (tsVar != null) {
                    aVar.setTitle(tsVar.rwQ);
                    if (com.tencent.mm.plugin.emoji.h.a.d(tsVar)) {
                        o.Pj().a("", aVar.aDm());
                        aVar.oz(R.g.icon_002_cover);
                    } else {
                        o.Pj().a(tsVar.jPG, aVar.aDm(), com.tencent.mm.plugin.emoji.e.f.cr(tsVar.rem, tsVar.jPG));
                    }
                    boolean cs = e.cs(tsVar.rwU, 2);
                    if (!TextUtils.isEmpty(tsVar.rxB)) {
                        aVar.aDn().setImageDrawable(null);
                        aVar.aDn().setVisibility(0);
                        o.Pj().a(tsVar.rxB, aVar.aDn(), com.tencent.mm.plugin.emoji.e.f.cr("", tsVar.rxB));
                    } else if (cs) {
                        aVar.oA(0);
                        aVar.oB(R.g.emotionstore_newtips);
                    } else {
                        aVar.oA(8);
                    }
                    aVar.yY(tsVar.rxA);
                    if (this.idH && aVar.icZ != null) {
                        aVar.icZ.setBackgroundResource(R.g.comm_list_item_selector_no_divider);
                    }
                }
            }
        }
        return view;
    }

    public int aDz() {
        return 0;
    }

    public void oD(int i) {
    }

    public int aDA() {
        return 0;
    }

    public void oE(int i) {
    }

    public int aDB() {
        return 0;
    }

    public void oF(int i) {
    }
}
