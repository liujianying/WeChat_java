package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer.c;
import com.tencent.mm.protocal.c.ju;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.tools.o.b;
import java.util.LinkedList;
import java.util.List;

public class BizSearchDetailPageUI extends MMActivity implements b {
    private o hol;
    private BizSearchResultItemContainer hom;
    private long hon;
    private String hoo;
    private int hop;
    private int hoq;
    private Runnable hor = new 1(this);
    private int tH;

    protected final int getLayoutId() {
        return e.biz_search_detail_page_ui;
    }

    public final void WY() {
    }

    public final void WZ() {
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        setBackBtn(new 2(this));
        Intent intent = getIntent();
        this.hon = intent.getLongExtra("businessType", 0);
        boolean booleanExtra = intent.getBooleanExtra("showEditText", false);
        this.hop = intent.getIntExtra("fromScene", 0);
        this.hoq = intent.getIntExtra("addContactScene", 35);
        String stringExtra = intent.getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_TITLE);
        String stringExtra2 = intent.getStringExtra("keyword");
        boolean booleanExtra2 = intent.getBooleanExtra("showCatalog", false);
        this.tH = intent.getIntExtra("offset", 0);
        if (this.hon == 0 || bi.oW(stringExtra2)) {
            x.e("MicroMsg.BrandService.BizSearchDetailPageUI", "businessType(%d) or queryStr is nil.", new Object[]{Long.valueOf(this.hon)});
            finish();
            return;
        }
        boolean z2;
        ju juVar;
        byte[] byteArrayExtra = intent.getByteArrayExtra("result");
        if (byteArrayExtra != null) {
            try {
                ju juVar2 = (ju) new ju().aG(byteArrayExtra);
                z2 = juVar2 != null;
                juVar = juVar2;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.BrandService.BizSearchDetailPageUI", e, "", new Object[0]);
                finish();
                return;
            }
        }
        z2 = false;
        juVar = null;
        this.hom = (BizSearchResultItemContainer) findViewById(d.searchResultItemContainer);
        this.hom.setAdapter(new c(this));
        this.hom.setBusinessTypes(new long[]{this.hon});
        this.hom.setMode(1);
        this.hom.setDisplayArgs$25decb5(booleanExtra2);
        this.hom.setScene(this.hop);
        this.hom.setAddContactScene(this.hoq);
        this.hom.setReporter(new 3(this));
        if (booleanExtra) {
            this.hol = new o();
            a(this.hol);
            this.hol.mv(false);
            this.hol.clearFocus();
            this.hol.setSearchContent(stringExtra2);
            this.hol.uBw = this;
            this.hom.setOnTouchListener(new 4(this));
        } else if (!bi.oW(stringExtra)) {
            setMMTitle(stringExtra);
        }
        if (z2) {
            BizSearchResultItemContainer bizSearchResultItemContainer = this.hom;
            int i = this.tH;
            bizSearchResultItemContainer.reset();
            if (juVar == null) {
                x.e("MicroMsg.BrandService.BizSearchResultItemContainer", "setFirst page content failed, content is null.");
                return;
            }
            bizSearchResultItemContainer.hoJ.bHt = stringExtra2;
            bizSearchResultItemContainer.setBusinessTypes(new long[]{juVar.rll});
            bizSearchResultItemContainer.hoJ.dYU = juVar.rlm;
            bizSearchResultItemContainer.hoO = i;
            List linkedList = new LinkedList();
            linkedList.add(juVar);
            bizSearchResultItemContainer.hoH.d(stringExtra2, linkedList);
            bizSearchResultItemContainer.hoJ.offset = i + juVar.rjC;
            c cVar = bizSearchResultItemContainer.hoJ;
            if (bizSearchResultItemContainer.hoH.isEmpty()) {
                z = false;
            }
            cVar.hoX = z;
            return;
        }
        pk(stringExtra2);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.hol != null) {
            this.hol.a(this, menu);
        }
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (this.hol != null) {
            this.hol.a(this, menu);
        }
        return true;
    }

    protected void onPause() {
        super.onPause();
        if (this.hol != null) {
            this.hol.clearFocus();
        }
    }

    public final boolean pj(String str) {
        return false;
    }

    public final void pk(String str) {
        if (!bi.oW(str)) {
            String trim = str.trim();
            if (!trim.equals(this.hoo)) {
                ah.M(this.hor);
                this.hoo = trim;
                ah.i(this.hor, 400);
            }
        }
    }

    public final void WW() {
        finish();
    }

    public final void WX() {
    }
}
