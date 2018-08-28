package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.p.a;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.a.b.b;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.d;
import com.tencent.mm.plugin.sns.model.e;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.protocal.c.bqw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;

public class AdListView extends ListView {
    b nKo;
    f nKp;
    private e nKq;
    private boolean nKr = true;
    private HashSet<String> nKs = new HashSet();

    public AdListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setTimelineStat(f fVar) {
        this.nKp = fVar;
    }

    public void setTimelineEvent(e eVar) {
        this.nKq = eVar;
    }

    protected void layoutChildren() {
        super.layoutChildren();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void detachViewFromParent(View view) {
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            str = cVar.position + " " + cVar.bKW;
        }
        if (af.exM) {
            x.d("MicroMsg.AdListView", "1childview  onRemoved " + str + " count:" + getChildCount());
        }
        super.detachViewFromParent(view);
    }

    protected void detachViewFromParent(int i) {
        if (af.exM) {
            x.d("MicroMsg.AdListView", "2childview  onRemoved " + i + " count:" + getChildCount());
        }
        super.detachViewFromParent(i);
    }

    protected void attachViewToParent(View view, int i, LayoutParams layoutParams) {
        super.attachViewToParent(view, i, layoutParams);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            String str2 = cVar.position + " " + cVar.bKW;
            d.nxJ.MT(cVar.ojM.ksA);
            d.nxJ.eF(cVar.ojM.ksA, cVar.ojM.sqb == null ? "" : cVar.ojM.sqb.ksA);
            if (this.nKo != null && cVar.nkG) {
                this.nKo.a(cVar.position, cVar.bKW, cVar.fvT, cVar.jLu, view, cVar.oiF, cVar.nkH, cVar.nib, cVar.hER, 1);
            }
            if (!this.nKs.contains(cVar.bSZ) && ((cVar.nkG && cVar.ojM.sqc.ruz == 15) || cVar.ojM.sqc.ruz == 18)) {
                boolean z = false;
                if (cVar.ojM.sqc.ruz == 15 && (cVar.ojH.neL instanceof SightPlayImageView)) {
                    z = ((SightPlayImageView) cVar.ojH.neL).ndx.bvH();
                }
                j.a(com.tencent.mm.plugin.sns.model.af.byo().Nk(cVar.bSZ), false, z);
                this.nKs.add(cVar.bSZ);
            }
            if (this.nKp != null) {
                this.nKp.a(cVar.bKW, cVar.ojM);
            }
            if (this.nKq != null) {
                this.nKq.a(cVar.position, cVar.bKW, cVar.oiF, cVar.fvT, cVar.ojM, cVar.nkG, cVar.nkH);
            }
            str = str2;
        }
        if (af.exM) {
            x.d("MicroMsg.AdListView", "3childview  onAdded " + str + " count:" + getChildCount());
        }
    }

    public void onViewAdded(View view) {
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            String str2 = cVar.position + " " + cVar.bKW;
            d.nxJ.MT(cVar.ojM.ksA);
            d.nxJ.eF(cVar.ojM.ksA, cVar.ojM.sqb == null ? "" : cVar.ojM.sqb.ksA);
            if (this.nKo != null && cVar.nkG) {
                this.nKo.a(cVar.position, cVar.bKW, cVar.fvT, cVar.jLu, view, cVar.oiF, cVar.nkH, cVar.nib, cVar.hER, 1);
            }
            if (!this.nKs.contains(cVar.bSZ) && ((cVar.nkG && cVar.ojM.sqc.ruz == 15) || cVar.ojM.sqc.ruz == 18)) {
                boolean z = false;
                if (cVar.ojM.sqc.ruz == 15 && (cVar.ojH.neL instanceof SightPlayImageView)) {
                    z = ((SightPlayImageView) cVar.ojH.neL).ndx.bvH();
                }
                j.a(com.tencent.mm.plugin.sns.model.af.byo().Nk(cVar.bSZ), false, z);
                this.nKs.add(cVar.bSZ);
            }
            if (this.nKp != null) {
                this.nKp.a(cVar.bKW, cVar.ojM);
            }
            if (this.nKq != null) {
                this.nKq.a(cVar.position, cVar.bKW, cVar.oiF, cVar.fvT, cVar.ojM, cVar.nkG, cVar.nkH);
            }
            str = str2;
        }
        if (af.exM) {
            x.d("MicroMsg.AdListView", "4childview  onViewAdded " + str + " count:" + getChildCount());
        }
    }

    public void onViewRemoved(View view) {
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            String str2 = cVar.position + " " + cVar.bKW;
            if (this.nKo != null && cVar.nkG) {
                this.nKo.t(cVar.position, cVar.bKW, cVar.fvT);
            }
            if (this.nKp != null) {
                this.nKp.LX(cVar.bKW);
            }
            if (this.nKq != null) {
                this.nKq.a(cVar.position, cVar.bKW, cVar.oiF, cVar.fvT, cVar.ojM, cVar.nkG);
            }
            if (cVar.ojM.sqc.ruz == 3) {
                n Nk = com.tencent.mm.plugin.sns.model.af.byo().Nk(cVar.bSZ);
                int bBq = Nk == null ? 0 : Nk.bBq();
                a aVar = a.ekV;
                String str3 = cVar.ojM.nNV;
                String eF = i.eF(cVar.oiF);
                if (!bi.oW(str3)) {
                    byte[] bArr = new byte[0];
                    try {
                        bArr = Base64.decode(str3, 0);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SnsStatExtUtil", e, null, new Object[0]);
                    }
                    bqw bqw = new bqw();
                    try {
                        bqw.aG(bArr);
                        if (bqw.soW == null) {
                            str = str2;
                        } else {
                            x.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%d), statExtStr:%s(id=%s, uxinfo=%s)", new Object[]{Integer.valueOf(aVar.value), str3, bqw.soW.soZ, bqw.soW.spa});
                            ((com.tencent.mm.plugin.sns.b.c) g.l(com.tencent.mm.plugin.sns.b.c.class)).a(13235, bBq, new Object[]{aVar.value, bqw.soW.soZ, bqw.soW.spa, eF});
                        }
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.SnsStatExtUtil", e2, "", new Object[0]);
                        str = str2;
                    }
                }
            }
            str = str2;
        }
        if (af.exM) {
            x.d("MicroMsg.AdListView", "5childview  onViewRemoved " + str + " count:" + getChildCount());
        }
    }

    public void removeViewInLayout(View view) {
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            str = cVar.position + " " + cVar.bKW;
        }
        if (af.exM) {
            x.d("MicroMsg.AdListView", "6removeViewInLayout  onViewRemoved " + str + " count:" + getChildCount());
        }
        super.removeViewInLayout(view);
    }

    public void removeView(View view) {
        super.removeView(view);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof c)) {
            c cVar = (c) view.getTag();
            str = cVar.position + " " + cVar.bKW;
        }
        if (af.exM) {
            x.d("MicroMsg.AdListView", "7removeView  onViewRemoved " + str + " count:" + getChildCount());
        }
    }

    protected void detachViewsFromParent(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            View childAt = getChildAt(i3);
            String str = "";
            if (childAt.getTag() != null && (childAt.getTag() instanceof c)) {
                c cVar = (c) childAt.getTag();
                if (this.nKo != null && cVar.nkG) {
                    this.nKo.t(cVar.position, cVar.bKW, cVar.fvT);
                }
                if (this.nKp != null) {
                    this.nKp.LX(cVar.bKW);
                }
                if (this.nKq != null) {
                    this.nKq.a(cVar.position, cVar.bKW, cVar.oiF, cVar.fvT, cVar.ojM, cVar.nkG);
                }
                str = cVar.position + " " + cVar.bKW;
            }
            if (af.exM) {
                x.d("MicroMsg.AdListView", "8removeView  detachViewsFromParent " + str + " count:" + getChildCount());
            }
        }
        super.detachViewsFromParent(i, i2);
    }
}
