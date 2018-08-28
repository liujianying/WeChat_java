package com.tencent.mm.plugin.sight.draft.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.j;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.i;
import java.util.HashSet;
import java.util.Set;

public final class b extends r<j> {
    private int hGJ;
    private int hJO;
    int neA = R.l.sight_draft_send;
    int neB = 0;
    private int neC;
    private int neD;
    private c neE = new 1(this);
    e neF;
    a neu = new a(this, (byte) 0);
    private b nev = new b(this, (byte) 0);
    private c new = new c(this, (byte) 0);
    private Set<e> nex = new HashSet();
    private d ney = d.neH;
    a nez;

    public b(Context context, a aVar) {
        super(context, null);
        this.nez = aVar;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.sight_draft_padding) * 2;
        this.neC = context.getResources().getDisplayMetrics().widthPixels / 3;
        this.hJO = this.neC - dimensionPixelSize;
        this.hGJ = (this.hJO * 3) / 4;
        this.neD = dimensionPixelSize + this.hGJ;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        f fVar;
        if (view == null) {
            f fVar2 = new f((byte) 0);
            view = new LinearLayout(viewGroup.getContext());
            view.setOrientation(0);
            for (int i2 = 0; i2 < 3; i2++) {
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.i.sight_draft_list_item, view, false);
                e eVar = new e((byte) 0);
                eVar.ern = inflate;
                eVar.ern.setTag(eVar);
                eVar.neK = inflate.findViewById(R.h.sight_play_area);
                eVar.neL = (a) inflate.findViewById(R.h.sight_view);
                eVar.jez = (ImageView) inflate.findViewById(R.h.sight_view_mask);
                eVar.neM = inflate.findViewById(R.h.shadow_mask);
                eVar.gmo = (TextView) inflate.findViewById(R.h.sight_tips_tv);
                eVar.gmo.setText(this.neA);
                eVar.mUo = (ImageView) inflate.findViewById(R.h.sight_del_btn);
                fVar2.neO.add(eVar);
                LayoutParams layoutParams = (LayoutParams) inflate.getLayoutParams();
                layoutParams.weight = 1.0f;
                layoutParams.height = this.neD;
                view.addView(inflate);
                inflate.setOnClickListener(this.neu);
                eVar.mUo.setTag(eVar);
                eVar.mUo.setOnClickListener(this.new);
            }
            view.setTag(fVar2);
            fVar = fVar2;
        } else {
            fVar = (f) view.getTag();
        }
        for (int i3 = 0; i3 < fVar.neO.size(); i3++) {
            int i4 = (i * 3) + i3;
            e eVar2 = (e) fVar.neO.get(i3);
            this.nex.add(eVar2);
            eVar2.neM.setVisibility(8);
            eVar2.gmo.setVisibility(8);
            eVar2.jez.setBackgroundResource(R.g.sight_draft_mask);
            eVar2.neL.aO(null, false);
            eVar2.neL.setCanPlay(false);
            eVar2.neL.setForceRecordState(false);
            ((ImageView) eVar2.neL).setBackgroundResource(0);
            if (i4 >= aFL()) {
                eVar2.neN = null;
                eVar2.ern.setVisibility(4);
                i.m(eVar2.neK, 1.0f);
            } else {
                this.neB--;
                j jVar = (j) getItem(i4);
                au.HU();
                if (c.isSDCardAvailable()) {
                    boolean z;
                    eVar2.neN = jVar;
                    c cVar = this.neE;
                    String str = jVar.field_fileName;
                    String nC = k.nC(jVar.field_fileName);
                    if (this.neB <= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Bitmap o = cVar.o(str, nC, z);
                    ((ImageView) eVar2.neL).setScaleType(ScaleType.CENTER_CROP);
                    eVar2.neL.setThumbBmp(o);
                } else {
                    eVar2.neN = null;
                    eVar2.neL.bvE();
                }
                if (d.neI == this.ney) {
                    eVar2.mUo.setVisibility(0);
                    i.m(eVar2.neK, 0.95f);
                } else {
                    eVar2.mUo.setVisibility(8);
                    i.m(eVar2.neK, 1.0f);
                }
                eVar2.ern.setVisibility(0);
            }
        }
        return view;
    }

    /* renamed from: a */
    final void b(e eVar) {
        if (eVar == null) {
            for (e eVar2 : this.nex) {
                eVar2.neM.setVisibility(8);
            }
            return;
        }
        for (e eVar22 : this.nex) {
            eVar22.neM.setVisibility(eVar == eVar22 ? 8 : 0);
        }
    }

    public final boolean a(d dVar, boolean z) {
        if (dVar == this.ney) {
            if (z && this.nez != null) {
                this.nez.bwd();
            }
            return false;
        }
        this.ney = dVar;
        this.neu.bwe();
        notifyDataSetChanged();
        if (z && this.nez != null) {
            this.nez.bwd();
        }
        return true;
    }

    public final void a(String str, l lVar) {
        this.nex.clear();
        super.a(str, lVar);
    }

    public final void WT() {
        WS();
        super.notifyDataSetChanged();
    }

    protected final void WS() {
        setCursor(o.Te().diF.rawQuery("SELECT * FROM SightDraftInfo WHERE fileStatus = ?  ORDER BY localId DESC ", new String[]{"1"}));
    }

    public final int getCount() {
        return (super.getCount() / 3) + 1;
    }
}
