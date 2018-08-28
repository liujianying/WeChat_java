package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CountryCodeUI extends MMActivity {
    private String countryCode;
    private String dYy;
    private String eIQ = "";
    private o eMS;
    private String eQJ;
    private boolean kuP = false;
    private ListView kvg;
    private List<a> list;
    private VerticalScrollBar.a uhB;
    private c uvP;
    private VerticalScrollBar uvQ;

    static /* synthetic */ void a(CountryCodeUI countryCodeUI) {
        if (countryCodeUI.uvP != null) {
            countryCodeUI.uvP.pi(countryCodeUI.eIQ);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dYy = ai.aG(getIntent().getStringExtra("country_name"), "");
        this.countryCode = ai.aG(getIntent().getStringExtra("couttry_code"), "");
        this.eQJ = ai.aG(getIntent().getStringExtra("iso_code"), "");
        this.kuP = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", true);
        initView();
    }

    protected final int getLayoutId() {
        if (w.chN()) {
            return R.i.country_code_select_big5;
        }
        return R.i.country_code_select;
    }

    protected void onPause() {
        super.onPause();
        if (this.eMS != null) {
            this.eMS.czQ();
        }
    }

    protected final void initView() {
        setMMTitle(R.l.address_title_select_country_code);
        this.list = b.E(this, getString(R.l.country_code));
        if (w.chN()) {
            Collections.sort(this.list, new Comparator<a>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    a aVar = (a) obj;
                    return new Integer(aVar.dYA).intValue() - new Integer(aVar.dYA).intValue();
                }
            });
        } else {
            Collections.sort(this.list, new 1(this));
        }
        this.eMS = new o((byte) 0);
        this.eMS.uBw = new 3(this);
        a(this.eMS);
        this.kvg = (ListView) findViewById(R.h.address_contactlist);
        this.uvP = new c(this, this.list);
        this.uvP.kuP = this.kuP;
        this.kvg.setAdapter(this.uvP);
        this.kvg.setVisibility(0);
        this.uvQ = (VerticalScrollBar) findViewById(R.h.address_scrollbar);
        if (w.chN()) {
            this.uhB = new 5(this);
        } else {
            this.uhB = new 4(this);
        }
        this.uvQ.setOnScrollBarTouchListener(this.uhB);
        setBackBtn(new 6(this));
        this.kvg.setOnItemClickListener(new 7(this));
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        Intent intent = new Intent();
        intent.putExtra("country_name", this.dYy);
        intent.putExtra("couttry_code", this.countryCode);
        intent.putExtra("iso_code", this.eQJ);
        setResult(100, intent);
        finish();
        return true;
    }
}
