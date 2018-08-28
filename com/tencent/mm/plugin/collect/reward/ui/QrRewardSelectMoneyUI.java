package com.tencent.mm.plugin.collect.reward.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.collect.reward.a.a$a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class QrRewardSelectMoneyUI extends QrRewardBaseUI {
    private int bVU;
    private String fIb;
    private String hVA;
    private String hVB;
    private String hVC;
    private String hVD;
    private int hVE;
    private String hVv;
    private String hVx;
    private String hVz;
    private List<Integer> hWl = new ArrayList();
    private ImageView hWm;
    private TextView hWn;
    private TextView hWo;
    private TextView hWp;
    private TextView hWq;
    private MMGridView hWr;
    private TextView hWs;
    private a hWt;
    private String hWu;
    private String hWv;

    private class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(QrRewardSelectMoneyUI qrRewardSelectMoneyUI, byte b) {
            this();
        }

        public final int getCount() {
            return QrRewardSelectMoneyUI.this.hWl.size();
        }

        public final Object getItem(int i) {
            return QrRewardSelectMoneyUI.this.hWl.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(QrRewardSelectMoneyUI.this.mController.tml).inflate(g.qr_reward_select_money_item, viewGroup, false);
            }
            int intValue = ((Integer) getItem(i)).intValue();
            TextView textView = (TextView) view.findViewById(f.qrsi_money_tv);
            if (((double) intValue) / 100.0d > ((double) (intValue / 100))) {
                textView.setText(String.format("%.2f", new Object[]{Double.valueOf(r4)}) + QrRewardSelectMoneyUI.this.getString(i.qr_reward_yuan));
            } else {
                textView.setText(String.format("%d", new Object[]{Integer.valueOf(r2)}) + QrRewardSelectMoneyUI.this.getString(i.qr_reward_yuan));
            }
            return view;
        }
    }

    static /* synthetic */ void a(QrRewardSelectMoneyUI qrRewardSelectMoneyUI, int i, int i2) {
        x.i("MicroMsg.QrRewardSelectMoneyUI", "go to grant ui");
        Intent intent = new Intent(qrRewardSelectMoneyUI.mController.tml, QrRewardGrantUI.class);
        intent.putExtra("key_amt_type", i2);
        if (i2 == 1) {
            intent.putExtra("key_money_amt", i);
        }
        intent.putExtra("key_rcvr_name", qrRewardSelectMoneyUI.hVz);
        intent.putExtra("key_rcvr_true_name", qrRewardSelectMoneyUI.hVA);
        intent.putExtra("key_rcvr_open_id", qrRewardSelectMoneyUI.hVx);
        intent.putExtra("key_qrcode_desc", qrRewardSelectMoneyUI.hVv);
        intent.putExtra("key_channel", qrRewardSelectMoneyUI.bVU);
        intent.putExtra("key_web_url", qrRewardSelectMoneyUI.fIb);
        intent.putExtra("key_scan_id", qrRewardSelectMoneyUI.hVB);
        intent.putExtra("key_sxtend_1", qrRewardSelectMoneyUI.hVC);
        intent.putExtra("key_sxtend_2", qrRewardSelectMoneyUI.hVD);
        intent.putExtra("key_max_amt", qrRewardSelectMoneyUI.hVE);
        qrRewardSelectMoneyUI.startActivityForResult(intent, 1);
    }

    static /* synthetic */ void b(QrRewardSelectMoneyUI qrRewardSelectMoneyUI) {
        String str = qrRewardSelectMoneyUI.hVz;
        com.tencent.mm.kernel.g.Ek();
        ab Yf = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yf(str);
        if (Yf == null || ((int) Yf.dhP) <= 0) {
            x.d("MicroMsg.QrRewardSelectMoneyUI", "Receiver in contactStg and try to get contact");
            com.tencent.mm.model.am.a.dBr.a(str, "", new 6(qrRewardSelectMoneyUI, bi.VF()));
        } else {
            b.a(qrRewardSelectMoneyUI.hWm, str, 0.03f, false);
            qrRewardSelectMoneyUI.hWo.setText(j.a(qrRewardSelectMoneyUI.mController.tml, e.gT(str)));
        }
        if (!bi.oW(qrRewardSelectMoneyUI.hVv)) {
            qrRewardSelectMoneyUI.hWp.setText(j.a(qrRewardSelectMoneyUI, qrRewardSelectMoneyUI.getString(i.qr_reward_wrap_text, new Object[]{qrRewardSelectMoneyUI.hVv}), qrRewardSelectMoneyUI.hWp.getTextSize()));
        }
        if (bi.oW(qrRewardSelectMoneyUI.hWv)) {
            qrRewardSelectMoneyUI.hWn.setVisibility(8);
        } else {
            qrRewardSelectMoneyUI.hWn.setText(qrRewardSelectMoneyUI.hWv);
        }
        qrRewardSelectMoneyUI.hWt.notifyDataSetChanged();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        jr(1516);
        setMMTitle(i.qr_reward_main_title);
        ux(4);
        this.hWu = getIntent().getStringExtra("key_qrcode_url");
        this.bVU = getIntent().getIntExtra("key_channel", 0);
        this.fIb = getIntent().getStringExtra("key_web_url");
        x.i("MicroMsg.QrRewardSelectMoneyUI", "do scan code");
        a(new com.tencent.mm.plugin.collect.reward.a.f(this.hWu, this.bVU, this.fIb), true, true);
        initView();
        int intExtra = getIntent().getIntExtra("key_scene", 0);
        x.d("MicroMsg.QrRewardSelectMoneyUI", "scene: %s", new Object[]{Integer.valueOf(intExtra)});
        h.mEJ.h(14721, new Object[]{Integer.valueOf(2), Integer.valueOf(intExtra)});
    }

    protected final void initView() {
        this.hWm = (ImageView) findViewById(f.qrsm_avatar_iv);
        this.hWn = (TextView) findViewById(f.qrsm_reward_amt_tv);
        this.hWo = (TextView) findViewById(f.qrsm_name_tv);
        this.hWp = (TextView) findViewById(f.qrsm_desc_tv);
        this.hWq = (TextView) findViewById(f.qrsm_reward_money_title_tv);
        this.hWr = (MMGridView) findViewById(f.qrsm_money_layout);
        this.hWs = (TextView) findViewById(f.qrsm_other_reward_money_tv);
        this.hWt = new a(this, (byte) 0);
        this.hWr.setAdapter(this.hWt);
        this.hWr.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, ((Integer) adapterView.getAdapter().getItem(i)).intValue(), 1);
            }
        });
        this.hWs.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                QrRewardSelectMoneyUI.a(QrRewardSelectMoneyUI.this, 0, 2);
            }
        });
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof com.tencent.mm.plugin.collect.reward.a.f) {
            final com.tencent.mm.plugin.collect.reward.a.f fVar = (com.tencent.mm.plugin.collect.reward.a.f) lVar;
            fVar.a(new 5(this, fVar)).b(new a$a() {
                public final void i(l lVar) {
                    x.e("MicroMsg.QrRewardSelectMoneyUI", "scan response error");
                    if (!bi.oW(fVar.hVc.hUn)) {
                        Toast.makeText(QrRewardSelectMoneyUI.this, fVar.hVc.hUn, 1).show();
                    }
                    QrRewardSelectMoneyUI.this.finish();
                }
            }).c(new a$a() {
                public final void i(l lVar) {
                    x.e("MicroMsg.QrRewardSelectMoneyUI", "net error: %s", new Object[]{fVar});
                    com.tencent.mm.ui.base.h.a(QrRewardSelectMoneyUI.this.mController.tml, QrRewardSelectMoneyUI.this.getString(i.wallet_unknown_err), null, false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            QrRewardSelectMoneyUI.this.finish();
                        }
                    });
                }
            });
            ux(0);
        }
        return true;
    }

    protected final int getLayoutId() {
        return g.qr_reward_select_money_ui;
    }

    public void onDestroy() {
        super.onDestroy();
        js(1516);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            x.i("MicroMsg.QrRewardSelectMoneyUI", "pay succ");
            finish();
        }
    }
}
