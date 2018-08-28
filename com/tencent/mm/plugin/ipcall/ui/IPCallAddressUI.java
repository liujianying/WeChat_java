package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aa.q;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.ipcall.a.d;
import com.tencent.mm.plugin.ipcall.a.d.g;
import com.tencent.mm.plugin.ipcall.a.f.b;
import com.tencent.mm.plugin.ipcall.ui.e.1;
import com.tencent.mm.plugin.ipcall.ui.e.2;
import com.tencent.mm.plugin.ipcall.ui.e.3;
import com.tencent.mm.plugin.ipcall.ui.e.4;
import com.tencent.mm.plugin.ipcall.ui.e.5;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.MMActivity;

public class IPCallAddressUI extends MMActivity implements e {
    private View ktX;
    private ListView kuj;
    private e kuk = null;
    private int kul = 0;
    private boolean kum = false;
    private boolean kun = true;
    private boolean kuo = false;
    private c kup = new 1(this);
    private Runnable kuq = new 3(this);

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        au.HU();
        if (((Boolean) com.tencent.mm.model.c.DT().get(a.sRv, Boolean.valueOf(false))).booleanValue()) {
            au.HU();
            com.tencent.mm.model.c.DT().a(a.sRv, Boolean.valueOf(false));
            Intent intent = new Intent();
            intent.setClass(this.mController.tml, IPCallAcitivityUI.class);
            this.mController.tml.startActivity(intent);
            overridePendingTransition(R.a.slide_right_in, R.a.slide_left_out);
            this.kun = false;
        }
        setBackBtn(new 2(this));
        if (this.kun) {
            this.kuo = true;
            aYf();
        }
        au.HU();
        this.kum = ((Boolean) com.tencent.mm.model.c.DT().get(a.sQR, Boolean.valueOf(true))).booleanValue();
        setMMTitle(R.l.ip_call_func_name);
        this.kuj = (ListView) findViewById(R.h.addres_list);
        this.ktX = findViewById(R.h.address_ui_hint_ll);
        this.kuk = new e(this, this.kuj, this.ktX);
        e eVar = this.kuk;
        eVar.ktW = new h(eVar.ktY);
        ViewGroup viewGroup = (ViewGroup) View.inflate(eVar.ktY, R.i.ipcall_address_header_item, null);
        eVar.ktV.addHeaderView(viewGroup, null, false);
        eVar.ktV.setAdapter(eVar.ktW);
        eVar.kua = (TextView) viewGroup.findViewById(R.h.account_balance_tv);
        eVar.kub = (TextView) viewGroup.findViewById(R.h.account_package_tv);
        eVar.kuc = (LinearLayout) viewGroup.findViewById(R.h.account_activity_ll);
        eVar.kud = (TextView) viewGroup.findViewById(R.h.account_activity_tv);
        eVar.kue = (ImageView) viewGroup.findViewById(R.h.unread_iv);
        viewGroup.findViewById(R.h.account_rl).setOnClickListener(new 1(eVar));
        viewGroup.findViewById(R.h.contact_rl).setOnClickListener(new 2(eVar));
        viewGroup.findViewById(R.h.dial_rl).setOnClickListener(new 3(eVar));
        eVar.ktV.setOnItemClickListener(new 4(eVar));
        eVar.ktV.setOnItemLongClickListener(new 5(eVar));
        au.HU();
        if (((Boolean) com.tencent.mm.model.c.DT().get(a.sQR, Boolean.valueOf(true))).booleanValue()) {
            d.aXf().fN(true);
            au.HU();
            com.tencent.mm.model.c.DT().a(a.sQR, Boolean.valueOf(false));
        } else {
            d.aXf().fN(false);
        }
        if (eVar.ktW.getCount() > 0) {
            eVar.ktX.setVisibility(8);
        } else {
            eVar.ktX.setVisibility(0);
        }
        eVar.aYe();
        eVar.aYd();
        eVar.ktZ = true;
        au.DF().a(257, this);
        com.tencent.mm.sdk.b.a.sFg.b(this.kup);
        this.kul = getIntent().getIntExtra("IPCallAddressUI_KFrom", 0);
        h.mEJ.a(257, 0, 1, true);
    }

    protected final int getLayoutId() {
        return R.i.ip_call_address_ui;
    }

    private void aYf() {
        x.i("MicroMsg.IPCallAddressUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bi.cjd()});
        if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            com.tencent.mm.sdk.f.e.post(this.kuq, "IPCallAddressUI_LoadSystemAddressBook");
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.kuk != null) {
            e eVar = this.kuk;
            eVar.ktV.setOnItemClickListener(null);
            eVar.ktV.setOnItemLongClickListener(null);
            q.Kp().b(eVar.ktW);
        }
        au.DF().b(257, this);
        com.tencent.mm.sdk.b.a.sFg.c(this.kup);
    }

    protected void onResume() {
        super.onResume();
        if (this.kuk != null) {
            e eVar = this.kuk;
            if (!(eVar.ktW == null || eVar.ktZ)) {
                eVar.ktW.notifyDataSetChanged();
                if (eVar.ktW.getCount() > 0) {
                    eVar.ktX.setVisibility(8);
                } else {
                    eVar.ktX.setVisibility(0);
                }
            }
            eVar.ktZ = false;
        }
        supportInvalidateOptionsMenu();
        b.aXT().fY(true);
        if (!this.kuo) {
            this.kuo = true;
            aYf();
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if ((lVar instanceof g) && i == 0 && i2 == 0 && this.kuk != null) {
            this.kuk.aYe();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        x.d("MicroMsg.IPCallAddressUI", "onCreateOptionsMenu");
        return super.onCreateOptionsMenu(menu);
    }

    public void onBackPressed() {
        if (this.kul == 1) {
            com.tencent.mm.plugin.ipcall.b.ezn.q(new Intent(), this);
        } else {
            super.onBackPressed();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.IPCallAddressUI";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bi.cjd();
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.IPCallAddressUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case s$l.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] != 0 && this.kum) {
                    this.kum = false;
                    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_contacts_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 4(this), new 5(this));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
