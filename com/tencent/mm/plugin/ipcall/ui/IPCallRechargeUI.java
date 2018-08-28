package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.c;
import com.tencent.mm.plugin.ipcall.a.d.f;
import com.tencent.mm.plugin.ipcall.a.e.g;
import com.tencent.mm.plugin.ipcall.a.e.h;
import com.tencent.mm.plugin.ipcall.a.e.j;
import com.tencent.mm.protocal.c.aka;
import com.tencent.mm.protocal.c.ccd;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

public class IPCallRechargeUI extends MMActivity implements e {
    TextView hVS;
    private int ini = -1;
    private String[] ink;
    private com.tencent.mm.pluginsdk.model.h.a iny = new 1(this);
    ProgressDialog kuy;
    f kxA;
    private String[] kxj;
    private String[] kxk;
    private String kxl;
    private String kxm;
    private boolean kxn = false;
    private int kxo;
    private int kxp = -1;
    private String kxq;
    private String kxr;
    private h kxs = new h();
    private g kxt = new g();
    private j kxu = new j();
    RelativeLayout kxv;
    GridView kxw;
    ListView kxx;
    a kxy;
    Button kxz;
    private ag mHandler = new 3(this);

    private static class a extends BaseAdapter {
        List<ccd> jWl = null;
        private IPCallRechargeUI kxD = null;
        aka kxE = null;

        public a(IPCallRechargeUI iPCallRechargeUI) {
            Assert.assertTrue(iPCallRechargeUI != null);
            this.kxD = iPCallRechargeUI;
        }

        public final int getCount() {
            return this.jWl == null ? 0 : this.jWl.size();
        }

        public final Object getItem(int i) {
            if (this.jWl != null) {
                return this.jWl.get(i);
            }
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = ((LayoutInflater) this.kxD.getSystemService("layout_inflater")).inflate(R.i.ipcall_recharge_price_item, viewGroup, false);
                aVar = new a(this, (byte) 0);
                aVar.kwJ = (TextView) view.findViewById(R.h.tvPrice);
                aVar.kxG = (TextView) view.findViewById(R.h.tvCurrency);
                aVar.kxH = (TextView) view.findViewById(R.h.tvCoupon);
                aVar.kxI = (TextView) view.findViewById(R.h.tvCallTime);
                aVar.kxJ = (Button) view.findViewById(R.h.btnBuy);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            ccd ccd = (ccd) getItem(i);
            if (ccd != null) {
                aVar.kwJ.setText(ccd.sdK);
                aVar.kxG.setText(ccd.sye);
                aVar.kxH.setText(ccd.syf);
                if (bi.oW(ccd.syf)) {
                    aVar.kxH.setVisibility(8);
                } else {
                    aVar.kxH.setVisibility(0);
                }
                if (this.kxE != null) {
                    aVar.kxI.setText(String.format(this.kxD.getString(R.l.ip_call_recharge_price_time_tip), new Object[]{com.tencent.mm.plugin.ipcall.b.a.Fm(this.kxE.rMy), String.valueOf(ccd.syc)}));
                }
                aVar.kxJ.setTag(Integer.valueOf(i));
                aVar.kxJ.setOnClickListener(new 1(this));
            }
            return view;
        }
    }

    static /* synthetic */ void j(IPCallRechargeUI iPCallRechargeUI) {
        if (iPCallRechargeUI.kxy != null) {
            iPCallRechargeUI.kxy.jWl = null;
            iPCallRechargeUI.kxy.notifyDataSetChanged();
        }
        if (iPCallRechargeUI.kxx != null) {
            iPCallRechargeUI.kxx.setVisibility(4);
        }
        if (iPCallRechargeUI.kuy != null) {
            iPCallRechargeUI.kuy.show();
        }
        iPCallRechargeUI.Fe("");
    }

    static /* synthetic */ void k(IPCallRechargeUI iPCallRechargeUI) {
        if (!bi.oW(iPCallRechargeUI.kxq) && !bi.oW(iPCallRechargeUI.kxr)) {
            x.i("MicroMsg.IPCallRechargeUI", "showGotoExchangeRecordsAlert");
            com.tencent.mm.ui.base.h.a(iPCallRechargeUI, iPCallRechargeUI.kxr, iPCallRechargeUI.kxq, iPCallRechargeUI.getString(R.l.ip_call_recharge_button_continue), iPCallRechargeUI.getString(R.l.ip_call_recharge_button_goto), false, null, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    IPCallRechargeUI.this.finish();
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", IPCallRechargeUI.this.getString(R.l.ip_call_exchange_record_url));
                    intent.putExtra("showShare", false);
                    d.b(IPCallRechargeUI.this, "webview", ".ui.tools.WebViewUI", intent);
                }
            });
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        au.DF().a(929, this);
        setMMTitle(R.l.ip_call_recharge);
        setBackBtn(new 5(this));
        addIconOptionMenu(0, R.g.mm_title_btn_menu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.base.h.a(IPCallRechargeUI.this.mController.tml, null, null, IPCallRechargeUI.this.getResources().getString(R.l.ipcall_restore_all), false, new 9(IPCallRechargeUI.this));
                return true;
            }
        });
        this.kxv = (RelativeLayout) findViewById(R.h.layout);
        this.kxw = (GridView) findViewById(R.h.recharge_gv);
        this.kxx = (ListView) findViewById(R.h.recharge_lv);
        ViewGroup viewGroup = (ViewGroup) View.inflate(this.mController.tml, R.i.ipcall_recharge_bottom_tip, null);
        this.kxx.addFooterView(viewGroup, null, false);
        this.kxy = new a(this);
        this.kxx.setAdapter(this.kxy);
        this.hVS = (TextView) viewGroup.findViewById(R.h.tip_tv);
        this.kxz = (Button) findViewById(R.h.buy_btn);
        Object string = getString(R.l.ip_call_recharge_see_price_tip);
        CharSequence newSpannable = Factory.getInstance().newSpannable(string);
        newSpannable.setSpan(new 7(this), 0, string.length(), 33);
        this.hVS.setText(newSpannable);
        this.hVS.setMovementMethod(LinkMovementMethod.getInstance());
        ActionBarActivity actionBarActivity = this.mController.tml;
        getString(R.l.app_tip);
        this.kuy = com.tencent.mm.ui.base.h.a(actionBarActivity, getString(R.l.ip_call_loading_tip), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                try {
                    if (IPCallRechargeUI.this.kxA != null) {
                        au.DF().c(IPCallRechargeUI.this.kxA);
                    }
                    IPCallRechargeUI.this.finish();
                } catch (Exception e) {
                    x.e("MicroMsg.IPCallRechargeUI", "cancel getProductListScene error: %s", new Object[]{e.getMessage()});
                }
            }
        });
        Fe("");
        this.kxs.start();
        com.tencent.mm.plugin.report.service.h.mEJ.a(257, 4, 1, true);
    }

    protected void onDestroy() {
        super.onDestroy();
        this.kxs.krL = bi.VF();
        this.kxs.finish();
        au.DF().b(929, this);
    }

    protected final int getLayoutId() {
        return R.i.ipcall_recharge_ui;
    }

    private void Fe(String str) {
        String Fo;
        List aXe = c.aXb().aXe();
        if (aXe.size() == 0) {
            Fo = com.tencent.mm.plugin.ipcall.b.a.Fo(com.tencent.mm.plugin.ipcall.b.c.aYB());
        } else {
            Fo = com.tencent.mm.plugin.ipcall.b.a.Fo(((Integer) aXe.get(0)).toString());
        }
        this.kxA = new f(Fo, str);
        au.DF().a(this.kxA, 0);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.IPCallRechargeUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        boolean z;
        ArrayList stringArrayListExtra;
        if (i == 2001) {
            int intExtra;
            int intExtra2;
            String string;
            int i3;
            String str = "";
            z = false;
            if (intent != null) {
                intExtra = intent.getIntExtra("key_err_code", 0);
                String stringExtra = intent.getStringExtra("key_err_msg");
                long longExtra = intent.getLongExtra("key_launch_ts", 0);
                int intExtra3 = intent.getIntExtra("key_gw_error_code", 0);
                intExtra2 = intent.getIntExtra("key_response_position", 0);
                if (intExtra == 100000001) {
                    z = true;
                }
                x.i("MicroMsg.IPCallRechargeUI", "onActivityResult pay.errCode:[%d] errMsg:[%s] errGWCode:[%s] errPosition:[%d] isFailedConsume:[%s]", new Object[]{Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra3), Integer.valueOf(intExtra2), String.valueOf(z)});
                if (intExtra != 6 || intExtra3 == 0) {
                    this.kxt.ksd = (long) intExtra;
                } else {
                    this.kxt.ksd = (long) intExtra3;
                }
                if (intExtra2 == 3) {
                    com.tencent.mm.plugin.report.service.h.mEJ.a(257, 9, 1, true);
                    com.tencent.mm.plugin.report.service.h.mEJ.a(257, 11, 1, true);
                    this.kxt.ksd = 0;
                    this.kxt.kse = 2;
                    string = getString(R.l.ipcall_verify_failed);
                } else {
                    if (intExtra2 != 1) {
                        if (i2 == -1 && intExtra == 0) {
                            com.tencent.mm.plugin.report.service.h.mEJ.a(257, 9, 1, true);
                            string = stringExtra;
                        } else if (z) {
                            com.tencent.mm.plugin.report.service.h.mEJ.a(257, 9, 1, true);
                            com.tencent.mm.plugin.report.service.h.mEJ.a(257, 12, 1, true);
                            this.kxt.ksd = 0;
                            this.kxt.kse = 1;
                        }
                    }
                    string = stringExtra;
                }
                this.kxt.ksc = longExtra;
                this.kxt.krL = bi.VF();
                this.kxt.finish();
                i3 = intExtra3;
            } else {
                i3 = 0;
                intExtra2 = 0;
                intExtra = 0;
                string = str;
            }
            if (i2 != -1) {
                return;
            }
            CharSequence string2;
            if (intent != null && intExtra == 0) {
                stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                intent.getStringArrayListExtra("key_response_series_ids");
                Iterator it = stringArrayListExtra.iterator();
                while (it.hasNext()) {
                    x.i("MicroMsg.IPCallRechargeUI", "buy product ok productId:", new Object[]{bi.oV((String) it.next())});
                }
                com.tencent.mm.plugin.report.service.h.mEJ.a(257, 6, 1, true);
                com.tencent.mm.plugin.report.service.h.mEJ.a(257, 10, 1, true);
                Toast.makeText(this, R.l.ipcall_play_success, 0).show();
                finish();
            } else if (intent != null && intExtra == 100000002) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(257, 6, 1, true);
                zE(string);
            } else if (intent != null && intExtra == 109) {
                zE(string);
            } else if (intent != null && intExtra == 1) {
                string2 = getString(R.l.ipcall_play_cancelled);
                com.tencent.mm.plugin.report.service.h.mEJ.a(257, 8, 1, true);
                Toast.makeText(this, string2, 0).show();
            } else if (intent == null || intExtra != 113) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(257, 7, 1, true);
                if (intExtra2 == 3) {
                    zE(string);
                } else if (intExtra != 100000001 && intExtra != 6) {
                } else {
                    if (i3 == 0) {
                        Toast.makeText(this, getString(R.l.ip_call_load_error_desc), 0).show();
                        return;
                    }
                    string2 = getString(R.l.ip_call_load_google_wallet_error_desc);
                    if (!Ff(string2)) {
                        Toast.makeText(this, string2, 0).show();
                    }
                }
            } else {
                com.tencent.mm.ui.base.h.a(this, getString(R.l.ipcall_discount_expired), getString(R.l.ipcall_play_failed), new 10(this));
            }
        } else if (i == 2002) {
            if (this.kuy != null && this.kuy.isShowing()) {
                this.kuy.dismiss();
            }
            String str2 = "";
            int i4 = 0;
            int i5 = 0;
            z = false;
            if (intent != null) {
                i4 = intent.getIntExtra("key_err_code", 0);
                str2 = intent.getStringExtra("key_err_msg");
                i5 = intent.getIntExtra("key_response_position", 0);
                if (i4 == 100000001) {
                    z = true;
                }
                x.i("MicroMsg.IPCallRechargeUI", "onActivityResult restore.errCode:[%d] errMsg:[%s] errPosition:[%d] isFailedConsume:[%s]", new Object[]{Integer.valueOf(i4), str2, Integer.valueOf(i5), String.valueOf(z)});
            }
            CharSequence charSequence = str2;
            this.kxu.ksm = (long) i4;
            this.kxu.ksk = 0;
            if (i2 != -1) {
                this.kxu.ksl = 2;
                x.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore failed");
                Toast.makeText(this, R.l.ipcall_restore_failed, 0).show();
            } else if (intent == null || i4 != 0) {
                if (z) {
                    this.kxu.ksl = 1;
                    com.tencent.mm.plugin.report.service.h.mEJ.a(257, 17, 1, true);
                    charSequence = getString(R.l.ipcall_restore_no_product);
                } else if (i5 == 3) {
                    this.kxu.ksl = 2;
                    com.tencent.mm.plugin.report.service.h.mEJ.a(257, 16, 1, true);
                } else {
                    this.kxu.ksl = 2;
                }
                x.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore not ok");
                Toast.makeText(this, charSequence, 0).show();
            } else {
                stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                    this.kxu.ksl = 3;
                    x.i("MicroMsg.IPCallRechargeUI", "onActivityResult. no product can be restored");
                    Toast.makeText(this, R.l.ipcall_restore_no_product, 0).show();
                } else {
                    this.kxu.ksl = 0;
                    com.tencent.mm.plugin.report.service.h.mEJ.a(257, 15, 1, true);
                    x.i("MicroMsg.IPCallRechargeUI", "onActivityResult. restore ok");
                    com.tencent.mm.ui.base.h.a(this, getString(R.l.ipcall_restore_success), getString(R.l.ipcall_restore_success_title), new 11(this));
                }
            }
            this.kxu.krL = bi.VF();
            this.kxu.finish();
        }
    }

    private void zE(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(R.l.ipcall_play_failed);
        }
        com.tencent.mm.ui.base.h.a(this, str, getString(R.l.ipcall_play_failed), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private boolean Ff(String str) {
        boolean z;
        if (com.tencent.mm.k.g.AT().getInt("WCOSecondPurchaseSwitch", 0) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.kxp >= 0) {
            Object item = this.kxy.getItem(this.kxp);
            if ((item instanceof ccd) && !bi.oW(((ccd) item).syh)) {
                String str2 = ((ccd) item).syh;
                x.i("MicroMsg.IPCallRechargeUI", "tryHandleShowWebViewPayDialog:" + str2);
                com.tencent.mm.ui.base.h.a(this, str, getString(R.l.ipcall_play_failed), getString(R.l.ip_call_webview_recharge_tips), getString(R.l.app_cancel), true, new 2(this, str2), null);
                return true;
            }
        }
        return false;
    }

    public final void a(int i, int i2, String str, l lVar) {
        int i3 = 0;
        x.i("MicroMsg.IPCallRechargeUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", new Object[]{Integer.valueOf(i2), str});
        if (lVar instanceof f) {
            h hVar = this.kxs;
            hVar.ksh = bi.VF();
            hVar.ksi = (long) i2;
            if (i == 0 && i2 == 0) {
                aka aka = ((f) lVar).krq;
                this.kxy.jWl = aka.rHH;
                this.kxy.kxE = aka;
                this.kxy.notifyDataSetChanged();
                this.ink = new String[aka.rHH.size()];
                Iterator it = aka.rHH.iterator();
                int i4 = 0;
                while (it.hasNext()) {
                    this.ink[i4] = ((ccd) it.next()).rem;
                    i4++;
                }
                this.kxq = aka.rMD;
                this.kxr = aka.rME;
                this.kxl = aka.rMy;
                this.kxm = aka.rMC;
                this.kxo = aka.rMB;
                if (this.kxn) {
                    this.kxk = new String[aka.rHH.size()];
                    for (int i5 = 0; i5 < this.kxk.length; i5++) {
                        this.kxk[i5] = aka.rMC;
                    }
                    this.kxj = new String[aka.rHH.size()];
                    while (i3 < this.kxj.length) {
                        this.kxj[i3] = IPCallDynamicTextView.Fd(((ccd) aka.rHH.get(i3)).sdK);
                        i3++;
                    }
                }
                if (((f) lVar).krr) {
                    x.i("MicroMsg.IPCallRechargeUI", "onSceneEnd IsUnkownCurency=true");
                    if (this.ink != null && this.ink.length > 0) {
                        x.i("MicroMsg.IPCallRechargeUI", "startQueryGooglePrice");
                        com.tencent.mm.pluginsdk.model.h.a(this, this.ink, this.iny);
                        return;
                    }
                    return;
                }
                if (this.kuy != null && this.kuy.isShowing()) {
                    this.kuy.dismiss();
                }
                aYo();
                return;
            }
            if (this.kuy != null && this.kuy.isShowing()) {
                this.kuy.dismiss();
            }
            Toast.makeText(this.mController.tml, getString(R.l.ip_call_load_error_desc), 0).show();
            finish();
        }
    }

    public final void aYo() {
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(TXLiveConstants.PUSH_EVT_PUSH_BEGIN);
        }
    }
}
