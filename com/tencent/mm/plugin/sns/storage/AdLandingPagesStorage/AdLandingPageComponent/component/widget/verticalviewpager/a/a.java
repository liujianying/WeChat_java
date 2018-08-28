package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView$a;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c;
import com.tencent.mm.plugin.sns.ui.am;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public final class a extends RecyclerView$a<t> implements b {
    int bgColor;
    private Context context;
    private int hmV;
    private int hmW;
    private LinearLayoutManager nCQ;
    c nHg;
    LinkedHashMap<String, i> nHh = new LinkedHashMap();
    private LayoutInflater nHi;

    public class a extends t {
        private LinearLayout fyt;

        public a(View view) {
            super(view);
            this.fyt = (LinearLayout) view.findViewById(f.root);
        }
    }

    public a(c cVar, int i, Context context, LinearLayoutManager linearLayoutManager) {
        this.nCQ = linearLayoutManager;
        this.nHg = cVar;
        this.bgColor = i;
        this.context = context;
        this.nHi = (LayoutInflater) this.context.getSystemService("layout_inflater");
        int[] ee = ad.ee(this.context);
        this.hmV = ee[0];
        this.hmW = ee[1];
    }

    public final t a(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(g.ad_landing_comp_item, viewGroup, false));
    }

    public final void a(t tVar, int i) {
        x.i("ContentAdapter", "display page " + this.nHg.id + ", pos " + i);
        a aVar = (a) tVar;
        aVar.fyt.removeAllViews();
        s sVar = (s) this.nHg.nIi.get(i);
        i iVar = (i) this.nHh.get(sVar.nAW);
        int i2 = this.bgColor;
        if (sVar.nBf != null && sVar.nBf.length() > 0) {
            try {
                i2 = Color.parseColor(sVar.nBf);
                aVar.fyt.setBackgroundColor(i2);
            } catch (Exception e) {
                x.e("ContentAdapter", "parse cellBackgroundColor error: %s", new Object[]{sVar.nBf});
            }
        }
        if (iVar != null) {
            iVar.a((s) this.nHg.nIi.get(i));
        } else {
            iVar = am.a(aVar.fyt.getContext(), sVar, aVar.fyt, i2);
            if (iVar != null) {
                this.nHh.put(sVar.nAW, iVar);
            }
        }
        if (iVar != null) {
            if (iVar.getView().getParent() != null && (iVar.getView().getParent() instanceof ViewGroup)) {
                ((ViewGroup) iVar.getView().getParent()).removeView(iVar.getView());
            }
            aVar.fyt.addView(iVar.getView());
        }
    }

    public final int getItemViewType(int i) {
        return i;
    }

    public final int getItemCount() {
        return this.nHg.nIi.size();
    }

    public final boolean wU(int i) {
        if (i < this.nCQ.fi() || i > this.nCQ.fj()) {
            x.v("ContentAdapter", "index %d not visible");
            return false;
        }
        i iVar = (i) this.nHh.get(((s) this.nHg.nIi.get(i)).nAW);
        if (iVar == null) {
            return false;
        }
        x.v("ContentAdapter", "comp %s, inScreenH %d", new Object[]{iVar, Integer.valueOf(a(iVar))});
        return a(iVar) >= (iVar.getView().getHeight() >>> 1);
    }

    private int a(i iVar) {
        if (iVar != null) {
            View view = iVar.getView();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[1];
            int height = view.getHeight() + i;
            x.v("ContentAdapter", "comp %s , top %d,bottom %d ", new Object[]{iVar, Integer.valueOf(i), Integer.valueOf(height)});
            if (i >= 0 && height <= this.hmW) {
                return view.getHeight();
            }
            if (i < 0 && height > 0 && height <= this.hmW) {
                return height;
            }
            if (i < 0 && height > this.hmW) {
                return this.hmW;
            }
            if (i < this.hmW && height > this.hmW) {
                return this.hmW - i;
            }
        }
        return 0;
    }

    public final void a(int i, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b bVar) {
        s sVar = (s) this.nHg.nIi.get(i);
        i iVar = (i) this.nHh.get(sVar.nAW);
        if (iVar != null) {
            iVar.bzA();
            iVar.W(a(iVar), iVar.getView().getHeight(), this.hmW);
            if (sVar.type == 61 || sVar.type == 62) {
                List<Integer> arrayList = new ArrayList();
                for (Entry entry : bVar.nCP.entrySet()) {
                    if (((b$a) entry.getValue()).nzR) {
                        arrayList.add(entry.getKey());
                    }
                }
                for (Integer intValue : arrayList) {
                    int intValue2 = intValue.intValue();
                    if (intValue2 != i && wU(intValue2)) {
                        i iVar2 = (i) this.nHh.get(((s) this.nHg.nIi.get(intValue2)).nAW);
                        if (iVar2 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) {
                            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a aVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) iVar2;
                            if (aVar.nzP && this.nHg.nIj && intValue2 == 0) {
                                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) iVar).bzy();
                            } else if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) iVar).nzP) {
                                aVar.bzy();
                            }
                        }
                    }
                }
            }
        }
    }

    public final void wT(int i) {
        if (i < 0 || i >= this.nHg.nIi.size()) {
            x.w("ContentAdapter", "endExposure index[%d], size[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(this.nHg.nIi.size())});
            return;
        }
        i iVar = (i) this.nHh.get(((s) this.nHg.nIi.get(i)).nAW);
        if (iVar != null) {
            iVar.bzB();
        }
    }

    public final void onDestroy() {
        for (Entry value : this.nHh.entrySet()) {
            ((i) value.getValue()).bzz();
        }
    }
}
