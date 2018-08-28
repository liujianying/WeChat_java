package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.plugin.base.stub.e.1;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.a;
import com.tencent.mm.protocal.c.cp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public class WXBizEntryActivity extends AutoLoginActivity {
    private int hdK;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitleVisibility(0);
    }

    protected final int getLayoutId() {
        return R.i.biz_share_check;
    }

    protected final boolean A(Intent intent) {
        return true;
    }

    protected final void a(a aVar, Intent intent) {
        Uri uri = null;
        x.i("MicroMsg.WXBizEntryActivity", "postLogin, loginResult = " + aVar);
        if (getIntent() != null) {
            this.hdK = getIntent().getIntExtra("key_command_id", 0);
        }
        switch (6.hdM[aVar.ordinal()]) {
            case 1:
                x.i("MicroMsg.WXBizEntryActivity", "req type = %d", new Object[]{Integer.valueOf(this.hdK)});
                Intent intent2;
                Uri data;
                switch (this.hdK) {
                    case 7:
                    case 8:
                        intent2 = getIntent();
                        intent2.setClassName(this, "com.tencent.mm.ui.CheckCanSubscribeBizUI");
                        startActivity(intent2);
                        finish();
                        return;
                    case 9:
                        d.c(this, "card", ".ui.CardAddEntranceUI", getIntent());
                        finish();
                        return;
                    case 11:
                        intent2 = getIntent();
                        intent2.putExtra("device_type", 1);
                        d.c(this, "exdevice", ".ui.ExdeviceRankInfoUI", intent2);
                        finish();
                        return;
                    case 12:
                        try {
                            uri = getIntent().getData();
                        } catch (Exception e) {
                            x.e("MicroMsg.WXBizEntryActivity", "post login get url from intent failed : %s", new Object[]{e.getMessage()});
                        }
                        if (uri != null && com.tencent.mm.pluginsdk.d.SB(uri.toString())) {
                            u.Hx().ib("key_data_center_session_id");
                            com.tencent.mm.pluginsdk.d.a(this, uri.toString(), getIntent().getIntExtra("translate_link_scene", 1), new 3(this), getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                            return;
                        }
                        return;
                    case 13:
                        intent2 = getIntent();
                        intent2.putExtra("key_static_from_scene", 100001);
                        d.c(this, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent2);
                        finish();
                        return;
                    case 14:
                    case 15:
                        new a(this, getIntent().getStringExtra("key_app_id"), getIntent().getStringExtra("open_id"), new 1(this)).atx();
                        return;
                    case 16:
                        d.c(this, "card", ".ui.CardListSelectedUI", getIntent());
                        finish();
                        return;
                    case 17:
                        try {
                            data = getIntent().getData();
                            2 2 = new 2(this);
                            String stringExtra = getIntent().getStringExtra("key_package_name");
                            String stringExtra2 = getIntent().getStringExtra("key_package_signature");
                            int intExtra = getIntent().getIntExtra("translate_link_scene", 1);
                            x.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: callPackage=%s, packageSignature=%s", new Object[]{stringExtra, stringExtra2});
                            if (bi.oW(stringExtra) || bi.oW(stringExtra2)) {
                                x.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult:packageName or signature null");
                                return;
                            }
                            LinkedList linkedList = new LinkedList();
                            cp cpVar = new cp();
                            x.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult package name = %s", new Object[]{stringExtra});
                            cpVar.rcN = stringExtra;
                            cpVar.signature = stringExtra2;
                            linkedList.add(cpVar);
                            aa aaVar = new aa(data.toString(), intExtra, linkedList);
                            au.DF().a(1200, new 1(this, 2));
                            au.DF().a(aaVar, 0);
                            return;
                        } catch (Exception e2) {
                            x.e("MicroMsg.WXBizEntryActivity", "get url from intent failed : %s", new Object[]{e2.getMessage()});
                            return;
                        }
                    case 19:
                        try {
                            uri = getIntent().getData();
                        } catch (Exception e22) {
                            x.e("MicroMsg.WXBizEntryActivity", "get data from intent for launch wxminiprogram failed : %s", new Object[]{e22.getMessage()});
                        }
                        if (uri != null) {
                            com.tencent.mm.pluginsdk.d.a(this, uri.toString(), getIntent().getIntExtra("translate_link_scene", 1), new 4(this), getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                            return;
                        }
                        return;
                    case 24:
                        try {
                            data = getIntent().getData();
                        } catch (Exception e222) {
                            x.e("MicroMsg.WXBizEntryActivity", "get data from intent for offline pay failed : %s", new Object[]{e222.getMessage()});
                            data = uri;
                        }
                        if (data != null) {
                            com.tencent.mm.pluginsdk.d.a(this, data.toString(), getIntent().getIntExtra("translate_link_scene", 1), new 5(this), getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                            return;
                        }
                        return;
                    default:
                        finish();
                        return;
                }
            case 2:
            case 3:
                x.e("MicroMsg.WXBizEntryActivity", "postLogin fail, loginResult = " + aVar);
                break;
            default:
                x.e("MicroMsg.WXBizEntryActivity", "postLogin, unknown login result = " + aVar);
                break;
        }
        finish();
    }
}
