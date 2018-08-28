package com.tencent.mm.plugin.address.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class WalletMultiRcptSelectUI extends MMPreference {
    private int bUw = 0;
    private f eOE;
    private RcptItem eZR = null;
    private RcptItem eZS = null;
    private List<RcptItem> eZT;

    private void ZL() {
        switch (this.bUw) {
            case 1:
                this.eZR = null;
                this.bUw = 0;
                break;
            case 2:
                this.eZS = null;
                this.bUw = 1;
                break;
        }
        Intent intent = new Intent();
        intent.putExtra("key_stage", this.bUw);
        intent.putExtra("key_province", this.eZR);
        intent.putExtra("key_city", this.eZS);
        setResult(0, intent);
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eOE = this.tCL;
        initView();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final int Ys() {
        return R.o.rptselect;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void initView() {
        /*
        r5 = this;
        r1 = r5.getIntent();
        r0 = com.tencent.mm.R.l.address_select_title;
        if (r1 == 0) goto L_0x0011;
    L_0x0008:
        r0 = "ui_title";
        r2 = com.tencent.mm.R.l.address_select_title;
        r0 = r1.getIntExtra(r0, r2);
    L_0x0011:
        r5.setMMTitle(r0);
        r0 = new com.tencent.mm.plugin.address.ui.WalletMultiRcptSelectUI$1;
        r0.<init>(r5);
        r5.setBackBtn(r0);
        r5.r(r1);
        r0 = com.tencent.mm.plugin.address.a.a.Zx();
        r0 = r0.eXP;
        if (r0 == 0) goto L_0x002d;
    L_0x0027:
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x003d;
    L_0x002d:
        r0 = "MicroMsg.MultiRptSelectUI";
        r1 = "list == null || list.isEmpty(), need loadata!";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = com.tencent.mm.plugin.address.a.a.Zx();
        r0.Zy();
    L_0x003d:
        r0 = r5.bUw;
        switch(r0) {
            case 0: goto L_0x0063;
            case 1: goto L_0x006d;
            case 2: goto L_0x008b;
            default: goto L_0x0042;
        };
    L_0x0042:
        com.tencent.mm.plugin.address.a.a.Zv();
        r0 = com.tencent.mm.plugin.address.a.a.Zx();
        r0 = r0.eXP;
    L_0x004b:
        r5.eZT = r0;
        r0 = r5.eZT;
        if (r0 == 0) goto L_0x0059;
    L_0x0051:
        r0 = r5.eZT;
        r0 = r0.size();
        if (r0 > 0) goto L_0x00a9;
    L_0x0059:
        r0 = "MicroMsg.MultiRptSelectUI";
        r1 = "initZoneItems error ,check zone lists!";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x0062:
        return;
    L_0x0063:
        com.tencent.mm.plugin.address.a.a.Zv();
        r0 = com.tencent.mm.plugin.address.a.a.Zx();
        r0 = r0.eXP;
        goto L_0x004b;
    L_0x006d:
        r0 = r5.eZR;
        if (r0 == 0) goto L_0x008b;
    L_0x0071:
        r0 = r5.eZR;
        r0 = r0.code;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x008b;
    L_0x007b:
        com.tencent.mm.plugin.address.a.a.Zv();
        r0 = com.tencent.mm.plugin.address.a.a.Zx();
        r1 = r5.eZR;
        r1 = r1.code;
        r0 = r0.pW(r1);
        goto L_0x004b;
    L_0x008b:
        r0 = r5.eZS;
        if (r0 == 0) goto L_0x0042;
    L_0x008f:
        r0 = r5.eZS;
        r0 = r0.code;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x0042;
    L_0x0099:
        com.tencent.mm.plugin.address.a.a.Zv();
        r0 = com.tencent.mm.plugin.address.a.a.Zx();
        r1 = r5.eZS;
        r1 = r1.code;
        r0 = r0.pX(r1);
        goto L_0x004b;
    L_0x00a9:
        r0 = r5.eOE;
        r0.removeAll();
        r0 = 0;
        r1 = r0;
    L_0x00b0:
        r0 = r5.eZT;
        r0 = r0.size();
        if (r1 >= r0) goto L_0x0116;
    L_0x00b8:
        r0 = r5.eZT;
        r0 = r0.get(r1);
        if (r0 == 0) goto L_0x00f5;
    L_0x00c0:
        r0 = r5.eZT;
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.plugin.address.model.RcptItem) r0;
        r0 = r0.name;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x00f5;
    L_0x00d0:
        r2 = new com.tencent.mm.plugin.address.ui.RcptPreference;
        r2.<init>(r5);
        r0 = r5.eZT;
        r0 = r0.get(r1);
        r0 = (com.tencent.mm.plugin.address.model.RcptItem) r0;
        if (r0 == 0) goto L_0x00e7;
    L_0x00df:
        r3 = r0.name;
        r3 = com.tencent.mm.sdk.platformtools.bi.oW(r3);
        if (r3 == 0) goto L_0x00f9;
    L_0x00e7:
        r0 = "MicroMsg.RcptPreference";
        r3 = "setZoneItem item = null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r3);
    L_0x00f0:
        r0 = r5.eOE;
        r0.a(r2);
    L_0x00f5:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00b0;
    L_0x00f9:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = r0.code;
        r3 = r3.append(r4);
        r4 = r2.hashCode();
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2.setKey(r3);
        r2.eZI = r0;
        goto L_0x00f0;
    L_0x0116:
        r0 = new com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
        r0.<init>(r5);
        r1 = r5.eOE;
        r1.a(r0);
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.address.ui.WalletMultiRcptSelectUI.initView():void");
    }

    private void r(Intent intent) {
        RcptItem rcptItem = null;
        if (intent == null) {
            x.e("MicroMsg.MultiRptSelectUI", "initData intent is null");
            return;
        }
        RcptItem rcptItem2;
        this.bUw = intent.getIntExtra("key_stage", 0);
        this.eZR = (RcptItem) intent.getParcelableExtra("key_province");
        this.eZS = (RcptItem) intent.getParcelableExtra("key_city");
        String stringExtra = intent.getStringExtra("extra_province");
        if (stringExtra != null) {
            a.Zv();
            l Zx = a.Zx();
            if (!bi.oW(stringExtra)) {
                for (RcptItem rcptItem22 : Zx.eXP) {
                    if (rcptItem22.name.startsWith(stringExtra)) {
                        break;
                    }
                }
            }
            rcptItem22 = null;
            this.eZR = rcptItem22;
            if (this.eZR != null) {
                this.bUw = 1;
            }
        }
        stringExtra = intent.getStringExtra("extra_city");
        if (stringExtra != null && 1 == this.bUw) {
            a.Zv();
            List<RcptItem> pW = a.Zx().pW(this.eZR.code);
            if (pW != null && pW.size() != 0) {
                for (RcptItem rcptItem222 : pW) {
                    if (rcptItem222.name.startsWith(stringExtra)) {
                        rcptItem = rcptItem222;
                        break;
                    }
                }
            }
            this.eZS = rcptItem;
            if (this.eZS != null) {
                this.bUw = 2;
            }
        }
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference instanceof RcptPreference) {
            RcptItem rcptItem = ((RcptPreference) preference).eZI;
            if (rcptItem == null || bi.oW(rcptItem.name)) {
                x.e("MicroMsg.MultiRptSelectUI", "onPreferenceTreeClick error item, item is null or item.name isNullOrNil");
            } else {
                if (!rcptItem.eXN) {
                    this.bUw = 2;
                }
                switch (this.bUw) {
                    case 0:
                        this.eZR = rcptItem;
                        this.bUw = 1;
                        break;
                    case 1:
                        this.eZS = rcptItem;
                        this.bUw = 2;
                        break;
                    case 2:
                        StringBuilder stringBuilder = new StringBuilder();
                        if (this.eZR != null) {
                            stringBuilder.append(this.eZR.name).append(" ");
                        }
                        if (this.eZS != null) {
                            stringBuilder.append(this.eZS.name).append(" ");
                        }
                        stringBuilder.append(rcptItem.name);
                        x.d("MicroMsg.MultiRptSelectUI", "area_result: " + stringBuilder.toString() + ",item.name: " + rcptItem.name);
                        Intent intent = new Intent();
                        intent.putExtra("karea_result", stringBuilder.toString());
                        intent.putExtra("kpost_code", rcptItem.eXM);
                        intent.putExtra("kwcode", rcptItem.code);
                        setResult(-1, intent);
                        finish();
                        break;
                }
                Intent intent2 = getIntent();
                int intExtra = intent2 != null ? intent2.getIntExtra("ui_title", -1) : -1;
                Intent intent3 = new Intent(this, WalletMultiRcptSelectUI.class);
                intent3.putExtra("key_stage", this.bUw);
                intent3.putExtra("key_province", this.eZR);
                intent3.putExtra("key_city", this.eZS);
                if (-1 != intExtra) {
                    intent3.putExtra("ui_title", intExtra);
                }
                startActivityForResult(intent3, 1);
            }
        }
        return false;
    }

    public void onBackPressed() {
        ZL();
        super.onBackPressed();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1) {
                    setResult(-1, intent);
                    finish();
                    return;
                }
                r(intent);
                return;
            default:
                return;
        }
    }
}
