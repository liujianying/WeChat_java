package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.brandservice.b.i;
import com.tencent.mm.plugin.brandservice.ui.c.a;
import com.tencent.mm.protocal.c.ju;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public class BizSearchResultItemContainer extends LinearLayout implements e {
    private int fdx = 0;
    private ListView hoG;
    c hoH;
    private TextView hoI;
    c hoJ;
    private a hoK;
    i hoL;
    private b hoM;
    private long[] hoN;
    int hoO;
    private boolean hoP;
    private int hoQ;
    private int hoq;

    static /* synthetic */ boolean a(BizSearchResultItemContainer bizSearchResultItemContainer) {
        return (!bizSearchResultItemContainer.hoJ.hoX || bizSearchResultItemContainer.hoJ.dYU == 0 || bizSearchResultItemContainer.hoJ.hoW) ? false : true;
    }

    public BizSearchResultItemContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = View.inflate(getContext(), b.e.search_result_lv, this);
        this.hoJ = new c((byte) 0);
        this.hoK = new a((byte) 0);
        this.hoI = (TextView) inflate.findViewById(d.emptyTipsTV);
        this.hoG = (ListView) inflate.findViewById(d.resultLV);
    }

    public void setAdapter(c cVar) {
        this.hoH = cVar;
        if (this.hoH != null) {
            this.hoH.setScene(this.fdx);
            ListView listView = this.hoG;
            a aVar = this.hoK;
            View inflate = View.inflate(getContext(), b.e.loading_footer, null);
            aVar.hoT = inflate.findViewById(d.loading_progress);
            aVar.hoU = inflate.findViewById(d.loading_end);
            aVar.hoV = inflate.findViewById(d.loading_tip);
            aVar.hoT.setVisibility(8);
            aVar.hoU.setVisibility(8);
            aVar.hoV.setVisibility(8);
            listView.addFooterView(inflate, null, false);
            this.hoG.setAdapter(this.hoH);
            this.hoG.setOnScrollListener(new 1(this));
            this.hoG.setOnItemClickListener(this.hoH);
            if (this.hoJ.hnQ == 0) {
                setBusinessTypes(1);
                return;
            }
            return;
        }
        this.hoG.setAdapter(this.hoH);
    }

    public c getAdapter() {
        return this.hoH;
    }

    private void c(String str, int i, long j) {
        ju juVar = null;
        this.hoJ.hoW = true;
        g.DF().a(1071, this);
        a ca = this.hoH.ca(this.hoN[this.hoN.length - 1]);
        List list = ca != null ? ca.hoF : null;
        if (list == null || list.size() == 0) {
            x.i("MicroMsg.BrandService.BizSearchResultItemContainer", "Get business content by type failed.(keyword : %s, offset : %s, businessType : %s)", new Object[]{str, Integer.valueOf(i), Long.valueOf(j)});
        } else {
            juVar = (ju) list.get(list.size() - 1);
        }
        x.d("MicroMsg.BrandService.BizSearchResultItemContainer", "keyword(%s), offset(%d), businessType(%d), searchId(%s).", new Object[]{str, Integer.valueOf(i), Long.valueOf(j), juVar != null ? juVar.rlo : ""});
        g.DF().a(new h(str, j, i, this.fdx, r6), 0);
        this.hoK.nw(1);
    }

    public final void a(int i, int i2, String str, l lVar) {
        int i3 = 3;
        x.i("MicroMsg.BrandService.BizSearchResultItemContainer", "errType (%d) , errCode (%d) , errMsg (errMsg)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.hoM != null) {
            this.hoM.auV();
        }
        if (i == 0 && i2 == 0) {
            this.hoP = false;
            if (lVar == null) {
                x.e("MicroMsg.BrandService.BizSearchResultItemContainer", "scene is null.");
                return;
            }
            int i4;
            int i5;
            int i6;
            if (lVar.getType() == 1070) {
                x.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchHomePage.");
                g.DF().b(1070, this);
                i iVar = (i) lVar;
                List list = iVar.hnR == null ? null : iVar.hnR.sjy;
                this.hoH.d(this.hoJ.bHt, list);
                a ca = this.hoH.ca(this.hoN[this.hoN.length - 1]);
                i6 = (ca == null || ca.hoE) ? 0 : ca.dYU;
                if (i6 != 0) {
                    i3 = 2;
                }
                if (list != null && list.size() > 0) {
                    ju juVar = (ju) list.get(list.size() - 1);
                    if (juVar != null) {
                        this.hoJ.offset = juVar.rjC + this.hoO;
                    }
                }
                i4 = i3;
                i5 = i6;
            } else if (lVar.getType() == 1071) {
                g.DF().b(1071, this);
                x.i("MicroMsg.BrandService.BizSearchResultItemContainer", "BizSearchDetailPage.");
                ju auP = ((h) lVar).auP();
                if (auP == null || auP.jQF == null) {
                    x.e("MicroMsg.BrandService.BizSearchResultItemContainer", "BusinessContent or itemList is null.");
                }
                i6 = auP == null ? 0 : auP.rlm;
                if (i6 == 0) {
                    i4 = 3;
                } else {
                    i4 = 2;
                }
                this.hoH.a(auP, true);
                if (auP != null) {
                    x.d("MicroMsg.BrandService.BizSearchResultItemContainer", "searchId : %s.", new Object[]{auP.rlo});
                    this.hoJ.offset = auP.rjC + this.hoO;
                }
                i5 = i6;
            } else {
                x.e("MicroMsg.BrandService.BizSearchResultItemContainer", "Error type(%d).", new Object[]{Integer.valueOf(lVar.getType())});
                return;
            }
            if (this.hoH.isEmpty()) {
                new ag(Looper.getMainLooper()).post(new 2(this));
            } else {
                this.hoJ.hoX = true;
            }
            this.hoJ.dYU = i5;
            this.hoK.nw(i4);
            this.hoJ.hoW = false;
            x.v("MicroMsg.BrandService.BizSearchResultItemContainer", "The next load data offset is (%d).", new Object[]{Integer.valueOf(this.hoJ.offset)});
            return;
        }
        this.hoJ.hoW = false;
        this.hoP = true;
        Toast.makeText(getContext(), getContext().getString(b.h.fmt_search_err, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
    }

    final void reset() {
        this.hoH.auT();
        this.hoK.nw(0);
        this.hoJ.hoX = false;
        this.hoJ.hoW = false;
        this.hoJ.offset = 0;
        this.hoJ.bHt = null;
        this.hoJ.dYU = 1;
    }

    public void setBusinessTypes(long... jArr) {
        if (jArr != null && jArr.length > 0) {
            this.hoN = jArr;
            this.hoJ.hnQ = 0;
            for (long j : jArr) {
                c cVar = this.hoJ;
                cVar.hnQ |= j;
            }
            this.hoH.e(jArr);
        }
    }

    public void setReporter(c.b bVar) {
        if (this.hoH != null) {
            this.hoH.setReporter(bVar);
        }
    }

    public final void aV(String str, int i) {
        if (this.hoH.isEmpty()) {
            this.hoI.setVisibility(8);
        }
        if (str != null) {
            String trim = str.trim();
            if (!"".equals(trim)) {
                if ((!trim.equals(this.hoJ.bHt) || this.hoP) && !this.hoJ.hoW) {
                    reset();
                    this.hoJ.hoW = true;
                    this.hoJ.bHt = trim;
                    this.hoO = i;
                    if (this.hoQ != 1) {
                        g.DF().a(1070, this);
                        this.hoL = new i(this.hoJ.bHt, this.hoJ.hnQ, this.fdx);
                        g.DF().a(this.hoL, 0);
                    } else if (this.hoN.length == 0) {
                        x.i("MicroMsg.BrandService.BizSearchResultItemContainer", "business type size is 0.");
                        return;
                    } else {
                        c(trim, i, this.hoN[0]);
                        this.hoK.nw(0);
                    }
                    if (this.hoM != null) {
                        this.hoM.auU();
                    }
                }
            }
        }
    }

    public b getIOnSearchStateChangedListener() {
        return this.hoM;
    }

    public void setIOnSearchStateChangedListener(b bVar) {
        this.hoM = bVar;
    }

    public void setScene(int i) {
        this.fdx = i;
        this.hoH.setScene(this.fdx);
    }

    public void setAddContactScene(int i) {
        this.hoq = i;
        this.hoH.setAddContactScene(i);
    }

    public final void setDisplayArgs$25decb5(boolean z) {
        this.hoH.t(z, false);
    }

    public void setMode(int i) {
        this.hoQ = i;
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
        this.hoG.setOnTouchListener(onTouchListener);
    }
}
