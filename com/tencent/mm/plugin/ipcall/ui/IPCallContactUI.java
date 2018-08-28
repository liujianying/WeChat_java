package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a;
import com.tencent.mm.plugin.ipcall.a.g.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.o;

public class IPCallContactUI extends MMActivity {
    private ag dvh = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            if (message.what == 1) {
                if (IPCallContactUI.this.kuy != null) {
                    IPCallContactUI.this.kuy.dismiss();
                }
                IPCallContactUI.this.kuA.setVisibility(0);
                IPCallContactUI.this.kuz;
                c.ksx = b.aXV();
                IPCallContactUI.this.kuz.WT();
                IPCallContactUI.this.kuz.notifyDataSetChanged();
                IPCallContactUI.this.kuj.invalidateViews();
                IPCallContactUI.this.kuC.setAddressCount(IPCallContactUI.this.kuz.getCount());
                a.aWF().Vk();
            } else if (message.what == 2) {
                if (IPCallContactUI.this.kuz.getCount() == 0) {
                    IPCallContactUI.this.kuE.setVisibility(0);
                } else {
                    IPCallContactUI.this.kuE.setVisibility(8);
                }
                if (IPCallContactUI.this.kuz.getCount() != 0 && IPCallContactUI.this.kuJ) {
                    IPCallContactUI.this.kuz.notifyDataSetChanged();
                }
            }
        }
    };
    private String eIQ;
    private o eMS = new o((byte) 0);
    private RelativeLayout kuA;
    private LinearLayout kuB;
    private IPCallAddressCountView kuC = null;
    private VerticalScrollBar kuD;
    private LinearLayout kuE;
    private int kuF = -1;
    private int kuG = -1;
    private com.tencent.mm.plugin.ipcall.a.a.a kuH = new 7(this);
    private Runnable kuI = new 10(this);
    private boolean kuJ = true;
    private ListView kuj;
    private Runnable kuq = new 8(this);
    private ProgressDialog kuy = null;
    private c kuz;

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.ip_call_address_list);
        setBackBtn(new 1(this));
        x.i("MicroMsg.IPCallContactUI", "summerper checkPermission checkContacts[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bi.cjd()});
        if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            this.kuA = (RelativeLayout) findViewById(R.h.layout);
            this.kuB = (LinearLayout) findViewById(R.h.address_ui_shadow);
            this.kuj = (ListView) findViewById(R.h.addres_list);
            this.kuD = (VerticalScrollBar) findViewById(R.h.address_scrollbar);
            this.kuE = (LinearLayout) findViewById(R.h.address_ui_hint_ll);
            this.eMS.uBw = new 5(this);
            this.eMS.uBB = R.l.app_search;
            a(this.eMS);
            this.kuz = new c(this.mController.tml);
            c.ksx = b.aXV();
            this.kuC = new IPCallAddressCountView(this.mController.tml, this.kuz.aYb());
            this.kuj.addFooterView(this.kuC, null, false);
            this.kuj.setAdapter(this.kuz);
            this.kuj.setOnItemClickListener(new 6(this));
            this.kuD.setVisibility(0);
            this.kuj.setOnScrollListener(new 11(this));
            this.kuD.setOnScrollBarTouchListener(new VerticalScrollBar.a() {
                public final void ys(String str) {
                    if ("↑".equals(str)) {
                        IPCallContactUI.this.kuj.setSelection(0);
                        return;
                    }
                    int intValue;
                    c d = IPCallContactUI.this.kuz;
                    if (d.hPz.containsKey(str)) {
                        intValue = ((Integer) d.hPz.get(str)).intValue();
                    } else {
                        intValue = -1;
                    }
                    if (intValue != -1) {
                        IPCallContactUI.this.kuj.setSelection(intValue);
                    }
                }
            });
            if (this.kuz.aYb() <= 0) {
                this.kuA.setVisibility(8);
                ActionBarActivity actionBarActivity = this.mController.tml;
                this.mController.tml.getString(R.l.app_tip);
                this.kuy = h.a(actionBarActivity, this.mController.tml.getString(R.l.ip_call_extracting_address_hint), true, new 9(this));
                e.post(this.kuq, "IPCall_LoadSystemAddressBook");
                return;
            }
            a.aWF().Vk();
        }
    }

    public final void pi(String str) {
        this.eIQ = str;
        this.dvh.removeCallbacks(this.kuI);
        this.dvh.postDelayed(this.kuI, 200);
    }

    public final void fZ(boolean z) {
        this.kuJ = z;
        if (this.kuJ) {
            this.kuz.notifyDataSetChanged();
        }
    }

    protected final int getLayoutId() {
        return R.i.ip_call_contact_ui;
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.ipcall.a.a aXa = com.tencent.mm.plugin.ipcall.a.a.aXa();
        com.tencent.mm.plugin.ipcall.a.a.a aVar = this.kuH;
        if (aXa.kod.contains(aVar)) {
            aXa.kod.remove(aVar);
        }
        this.dvh.removeMessages(1);
    }

    protected void onResume() {
        super.onResume();
        supportInvalidateOptionsMenu();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        x.d("MicroMsg.IPCallContactUI", "onCreateOptionsMenu");
        return super.onCreateOptionsMenu(menu);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.IPCallContactUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 48:
                if (iArr[0] != 0) {
                    h.a(this, getString(R.l.permission_contacts_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new 3(this), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            IPCallContactUI.this.finish();
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }
}
