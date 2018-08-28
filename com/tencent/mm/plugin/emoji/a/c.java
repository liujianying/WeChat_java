package com.tencent.mm.plugin.emoji.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.a.d;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.protocal.c.ts;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends a {
    private final String TAG = "MicroMsg.emoji.EmojiMineAdapter";
    private ProgressDialog eEX;

    public c(Context context) {
        super(context);
    }

    public final void notifyDataSetChanged() {
        if (this.ien == null) {
            this.ien = a(null);
        }
        super.notifyDataSetChanged();
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        a aVar = (a) view.getTag();
        f oG = oG(i);
        if (!(aVar == null || oG == null)) {
            ts tsVar = oG.iez;
            if (tsVar != null) {
                if (com.tencent.mm.plugin.emoji.h.a.d(tsVar)) {
                    aVar.setTitle(R.l.emoji_store_tuzi_title);
                    aVar.oz(R.g.icon_002_cover);
                } else {
                    if (bi.oW(tsVar.rwQ)) {
                        aVar.setTitle(tsVar.rem);
                    } else {
                        aVar.setTitle(tsVar.rwQ);
                    }
                    if (bi.oW(tsVar.jPG)) {
                        x.i("MicroMsg.emoji.EmojiMineAdapter", "Icon rul is null");
                    } else {
                        o.Pj().a(tsVar.jPG, aVar.aDm(), com.tencent.mm.plugin.emoji.e.f.cr(tsVar.rem, tsVar.jPG));
                    }
                }
                if (i + 1 == getCount()) {
                    aVar.icZ.setBackgroundResource(R.g.comm_list_item_selector_no_divider);
                } else {
                    aVar.icZ.setBackgroundResource(R.g.comm_list_item_selector);
                }
            }
        }
        return view;
    }

    protected final a c(Context context, View view) {
        a aVar = new a(this, context, view);
        aVar.a(this.ieo);
        return aVar;
    }

    protected final com.tencent.mm.plugin.emoji.a.a.c a(com.tencent.mm.plugin.emoji.model.f fVar) {
        return new d(fVar);
    }

    public final void be(String str, int i) {
        if (i == 7) {
            super.be(str, i);
        }
    }

    public final void clear() {
        if (this.eEX != null) {
            this.eEX.cancel();
        }
        super.clear();
    }

    protected final void aDy() {
        super.aDy();
    }

    public final int aDz() {
        return 0;
    }

    public final void oD(int i) {
    }

    public final int aDA() {
        return 0;
    }

    public final void oE(int i) {
    }

    public final int aDB() {
        return 0;
    }

    public final void oF(int i) {
    }
}
