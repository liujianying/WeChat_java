package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cu;
import com.tencent.mm.plugin.emoji.model.h.a;

public class c$a extends a {
    final /* synthetic */ c idz;

    public c$a(c cVar, Context context, View view) {
        this.idz = cVar;
        super(context, view);
    }

    protected final void aDj() {
        this.idb.setVisibility(8);
        aDo();
        this.ide.setVisibility(8);
        this.idi.setVisibility(8);
        this.idj.setVisibility(8);
        this.ida.setVisibility(0);
        this.gsY.setVisibility(0);
        this.idg.setVisibility(0);
        this.idf.setVisibility(0);
        this.idh.setVisibility(0);
    }

    protected final boolean a(a aVar, View view) {
        aDp();
        return super.a(aVar, view);
    }

    protected final void b(a aVar, View view) {
        super.b(aVar, view);
        if (com.tencent.mm.plugin.emoji.h.a.zT(getProductId())) {
            cu cuVar = new cu();
            cuVar.bKj.bKk = getProductId();
            cuVar.bKj.status = com.tencent.mm.plugin.emoji.h.a.aFS() ? 7 : 3;
            cuVar.bKj.progress = getProgress();
            cuVar.bKj.bKl = this.icY.ieC;
            com.tencent.mm.sdk.b.a.sFg.m(cuVar);
        }
    }

    protected final int[] aDk() {
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.BigIconSize);
        return new int[]{dimensionPixelSize, dimensionPixelSize};
    }

    protected final int aDl() {
        return -1;
    }

    protected final boolean aDr() {
        return true;
    }

    public final void aDu() {
        if (this.icY != null) {
            switch (aDp()) {
                case 0:
                case 3:
                    this.ide.setVisibility(8);
                    this.idf.setBackgroundResource(R.g.btn_solid_green);
                    this.idf.setVisibility(0);
                    this.idh.setVisibility(0);
                    this.idh.setText(R.l.emoji_store_download);
                    this.idh.setTextColor(this.mContext.getResources().getColorStateList(R.e.white_text_color_selector));
                    this.idi.setVisibility(4);
                    this.idi.setImageResource(R.g.emoji_download);
                    this.idj.setVisibility(4);
                    return;
                case 6:
                    aDs();
                    return;
                default:
                    this.ide.setVisibility(8);
                    this.idf.setBackgroundResource(R.g.btn_solid_white);
                    this.idf.setVisibility(0);
                    this.idh.setVisibility(0);
                    this.idh.setText(R.l.emoji_store_uninstall_emoji);
                    this.idh.setTextColor(this.mContext.getResources().getColorStateList(R.e.black_text_color_selector));
                    this.idi.setVisibility(4);
                    this.idi.setImageResource(R.g.emoji_download);
                    this.idj.setVisibility(4);
                    return;
            }
        }
    }
}
