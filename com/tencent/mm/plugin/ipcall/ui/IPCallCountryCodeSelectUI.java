package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

@a(3)
public class IPCallCountryCodeSelectUI extends MMActivity {
    private String countryCode;
    private String dYy;
    private String eIQ = "";
    private o eMS;
    public LinearLayout kuE;
    private boolean kuP = false;
    private ListView kvg;
    private f kvh;
    private IPCallCountryCodeScrollbar kvi;
    private IPCallCountryCodeScrollbar.a kvj;
    private boolean kvk = false;
    private List<a> list;

    static /* synthetic */ void a(IPCallCountryCodeSelectUI iPCallCountryCodeSelectUI) {
        if (iPCallCountryCodeSelectUI.kvh != null) {
            iPCallCountryCodeSelectUI.kvh.pi(iPCallCountryCodeSelectUI.eIQ);
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.list = new ArrayList();
        this.dYy = bi.aG(getIntent().getStringExtra("country_name"), "");
        this.countryCode = bi.aG(getIntent().getStringExtra("couttry_code"), "");
        this.kuP = getIntent().getBooleanExtra("CountryCodeUI_isShowCountryCode", false);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                IPCallCountryCodeSelectUI.this.finish();
                return false;
            }
        });
        initView();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(-1, R.a.push_down_out);
    }

    protected final int getLayoutId() {
        return R.i.ip_call_country_select_ui;
    }

    protected void onPause() {
        super.onPause();
        if (this.eMS != null) {
            this.eMS.czQ();
        }
    }

    protected final void initView() {
        int intValue;
        setMMTitle(R.l.address_title_select_country_code);
        this.eMS = new o((byte) 0);
        this.eMS.uBw = new 2(this);
        a(this.eMS);
        this.kvi = (IPCallCountryCodeScrollbar) findViewById(R.h.address_scrollbar);
        long currentTimeMillis = System.currentTimeMillis();
        int i = 0;
        for (Integer intValue2 : c.aXb().aXe()) {
            intValue = intValue2.intValue();
            if (i >= 5) {
                break;
            }
            String Fn = com.tencent.mm.plugin.ipcall.b.a.Fn(String.valueOf(intValue));
            if (bi.oW(Fn) || c.aXb().ru(intValue)) {
                intValue = i;
            } else {
                this.list.add(new a(Fn, String.valueOf(intValue), 0, "0"));
                intValue = i + 1;
            }
            i = intValue;
        }
        if (i > 0) {
            this.kvk = true;
        }
        b bVar;
        String str;
        if (w.chL()) {
            for (Entry entry : com.tencent.mm.plugin.ipcall.b.a.aYx().entrySet()) {
                entry.getKey();
                bVar = (b) entry.getValue();
                str = bVar.kAl;
                if (!(str == null || "".equals(str.trim()))) {
                    char[] toCharArray = str.toCharArray();
                    StringBuffer stringBuffer = new StringBuffer();
                    int length = toCharArray.length;
                    for (i = 0; i < length; i++) {
                        String g = SpellMap.g(toCharArray[i]);
                        if (bi.oW(g)) {
                            stringBuffer.append(toCharArray[i]);
                        } else {
                            stringBuffer.append(g);
                        }
                    }
                    str = stringBuffer.toString();
                }
                str = str.toUpperCase();
                if (bi.oW(str)) {
                    str = " ";
                }
                if (!c.aXb().ru(bi.getInt(bVar.kAk, 0))) {
                    this.list.add(new a(bVar.kAl, bVar.kAk, str.charAt(0), str));
                }
            }
        } else {
            for (Entry entry2 : com.tencent.mm.plugin.ipcall.b.a.aYx().entrySet()) {
                entry2.getKey();
                bVar = (b) entry2.getValue();
                str = bVar.kAl.toUpperCase();
                if (bi.oW(str)) {
                    str = " ";
                }
                if (!c.aXb().ru(bi.getInt(bVar.kAk, 0))) {
                    this.list.add(new a(bVar.kAl, bVar.kAk, str.charAt(0), str));
                }
            }
        }
        Collections.sort(this.list, new 6(this));
        for (a aXZ : this.list) {
            intValue = aXZ.aXZ();
            if (intValue != 0) {
                this.kvi.Fc(String.valueOf((char) intValue));
            }
        }
        x.d("MicroMsg.IPCallCountryCodeSelectUI", "initCountryCode used: %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        this.kuE = (LinearLayout) findViewById(R.h.address_ui_hint_ll);
        this.kvg = (ListView) findViewById(R.h.address_contactlist);
        this.kvh = new f(this, this.list);
        this.kvh.kuP = this.kuP;
        this.kvh.kuQ = this.kvk;
        this.kvg.setAdapter(this.kvh);
        this.kvg.setVisibility(0);
        this.kvj = new IPCallCountryCodeScrollbar.a() {
            public final void ys(String str) {
                int i = 0;
                char charAt = str.charAt(0);
                if ("↑".equals(str)) {
                    IPCallCountryCodeSelectUI.this.kvg.setSelection(0);
                    return;
                }
                int[] iArr = IPCallCountryCodeSelectUI.this.kvh.kuO;
                if (iArr != null) {
                    while (i < iArr.length) {
                        if (iArr[i] == charAt) {
                            IPCallCountryCodeSelectUI.this.kvg.setSelection(i + IPCallCountryCodeSelectUI.this.kvg.getHeaderViewsCount());
                            return;
                        }
                        i++;
                    }
                }
            }
        };
        this.kvi.setOnScrollBarTouchListener(this.kvj);
        setBackBtn(new 4(this));
        this.kvg.setOnItemClickListener(new 5(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        Intent intent = new Intent();
        intent.putExtra("country_name", this.dYy);
        intent.putExtra("couttry_code", this.countryCode);
        setResult(100, intent);
        finish();
        return true;
    }
}
