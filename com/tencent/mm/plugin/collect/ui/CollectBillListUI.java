package com.tencent.mm.plugin.collect.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior.b;
import android.support.design.widget.c;
import android.support.v4.view.z;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.collect.b.h;
import com.tencent.mm.plugin.collect.b.q;
import com.tencent.mm.plugin.wxpay.a;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CollectBillListUI extends WalletBaseUI {
    private Dialog eXG;
    private View hFL;
    private int hUF = 0;
    private ListView hWR;
    private b hWS;
    private LinearLayout hWT;
    private CollectPullDownView hWU;
    private TextView hWV;
    private Dialog hWW;
    private boolean hWX = false;
    private boolean hWY = false;
    private boolean hWZ = false;
    private boolean hXa = false;
    private boolean hXb = false;
    private boolean hXc = false;
    private boolean hXd = true;
    private boolean hXe = false;
    private boolean hXf = false;
    private long hXg = 0;
    private long hXh = 0;
    private Calendar hXi;
    private List<h> hXj = new ArrayList();
    private int limit = 20;
    private int retryCount = 0;
    private int type = 0;

    static /* synthetic */ void a(CollectBillListUI collectBillListUI) {
        if (collectBillListUI.hWW == null) {
            collectBillListUI.hWW = new c(collectBillListUI);
            DatePickerDialogView datePickerDialogView = new DatePickerDialogView(collectBillListUI);
            datePickerDialogView.setDatePickerMode(collectBillListUI.type);
            collectBillListUI.hWW.setContentView(datePickerDialogView);
            datePickerDialogView.setOnOkBtnClickListener(new 4(collectBillListUI, datePickerDialogView));
            datePickerDialogView.setOnCancelBtnClickListener(new 5(collectBillListUI));
            if (VERSION.SDK_INT >= 21) {
                collectBillListUI.hWW.getWindow().addFlags(Integer.MIN_VALUE);
            }
            BottomSheetBehavior h = BottomSheetBehavior.h((View) datePickerDialogView.getParent());
            h.cv = false;
            if (3 != h.mState) {
                if (h.cB == null) {
                    h.mState = 3;
                } else {
                    View view = (View) h.cB.get();
                    if (view != null) {
                        int i = h.ct;
                        h.r(2);
                        if (h.cw.d(view, view.getLeft(), i)) {
                            z.a(view, new b(h, view, 3));
                        }
                    }
                }
            }
            ah.i(new 6(collectBillListUI, datePickerDialogView, h), 300);
        }
        collectBillListUI.hWW.show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        setMMTitle(a$i.collect_bill_list_title);
        if (this.hXf) {
            addIconOptionMenu(0, a.h.collect_bill_filter_icon, new 1(this));
        }
        this.eXG = g.a(this, false, new 3(this));
        aCf();
        com.tencent.mm.plugin.report.service.h.mEJ.h(13944, new Object[]{Integer.valueOf(4)});
    }

    protected final void initView() {
        this.hWR = (ListView) findViewById(f.collect_bill_list_lv);
        this.hWT = (LinearLayout) findViewById(f.collect_bill_list_empty_ll);
        this.hWV = (TextView) findViewById(f.collect_bill_list_empty_tv);
        this.hFL = y.gq(this).inflate(a.g.collect_bill_list_loading_view, this.hWR, false);
        View view = new View(this);
        view.setLayoutParams(new LayoutParams(-1, com.tencent.mm.bp.a.fromDPToPix(this, 5)));
        this.hWR.addHeaderView(view, null, true);
        new View(this).setLayoutParams(new LayoutParams(-1, com.tencent.mm.bp.a.fromDPToPix(this, 10)));
        this.hWR.addFooterView(view, null, true);
        this.hWR.setOverScrollMode(2);
        this.hWS = new b(this);
        this.hWR.setAdapter(this.hWS);
        this.hWR.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                x.d("MicroMsg.CollectBillListUI", "click item: %d", new Object[]{Integer.valueOf(i)});
                if (i >= 0 && i < adapterView.getAdapter().getCount()) {
                    Intent intent = new Intent(CollectBillListUI.this.mController.tml, CollectBillUI.class);
                    h hVar = (h) adapterView.getItemAtPosition(i);
                    if (hVar == null) {
                        x.w("MicroMsg.CollectBillListUI", "invaild record: %d", new Object[]{Integer.valueOf(i)});
                        return;
                    }
                    intent.putExtra("key_type", hVar.type);
                    intent.putExtra("key_timestamp", hVar.hUf);
                    intent.putExtra("key_from_scene", 2);
                    CollectBillListUI.this.startActivity(intent);
                    com.tencent.mm.plugin.report.service.h.mEJ.h(13944, new Object[]{Integer.valueOf(3)});
                }
            }
        });
        this.hWR.setOnScrollListener(new 8(this));
        this.hWU = (CollectPullDownView) findViewById(f.collect_bill_list_pull_down_view);
        this.hWU.setTopViewVisible(false);
        this.hWU.setIsTopShowAll(false);
        this.hWU.setBottomViewVisible(true);
        this.hWU.setIsBottomShowAll(false);
        this.hWU.setCanOverScrool(true);
        this.hWU.setAtTopCallBack(new 9(this));
        this.hWU.setAtBottomCallBack(new 10(this));
        this.hWU.setOnTopLoadDataListener(new MMPullDownView.g() {
            public final boolean aCj() {
                x.d("MicroMsg.CollectBillListUI", "top load");
                return true;
            }
        });
        this.hWU.setOnBottomLoadDataListener(new 2(this));
    }

    protected final int getLayoutId() {
        return a.g.collect_bill_list;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (!(lVar instanceof q)) {
            return false;
        }
        q qVar = (q) lVar;
        if (this.eXG.isShowing()) {
            this.eXG.dismiss();
        }
        this.hWU.setLoadDataEnd(true);
        if (i == 0 && i2 == 0) {
            b bVar;
            if (qVar.hUF != 0) {
                this.hXc = qVar.dDR;
                if (qVar.hUE) {
                    if (!qVar.hUJ.isEmpty()) {
                        this.hXj.addAll(qVar.hUJ);
                    }
                    if (qVar.hUH != 0 || qVar.hUI <= 0) {
                        this.retryCount = 0;
                        this.hXd = true;
                        this.hXh = qVar.hUf;
                        if (qVar.hUH == 0) {
                            this.hXc = false;
                        } else {
                            this.hXc = true;
                        }
                        if (this.hXj.size() > 0) {
                            this.hWS.aK(this.hXj);
                        } else {
                            x.i("MicroMsg.CollectBillListUI", "still empty data, show empty view");
                            ajx();
                            if (!bi.oW(qVar.fFG)) {
                                this.hWV.setText(qVar.fFG);
                                this.hWV.setVisibility(0);
                            }
                            bVar = this.hWS;
                            bVar.hWN.clear();
                            bVar.notifyDataSetChanged();
                        }
                    } else {
                        x.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[]{Integer.valueOf(this.retryCount)});
                        a(qVar.hUI, qVar.hUf, qVar.hUG, qVar.hUF);
                    }
                    return true;
                }
                if (!qVar.hUJ.isEmpty()) {
                    this.hWS.aK(qVar.hUJ);
                    this.hXg = ((h) qVar.hUJ.get(0)).hUf;
                    this.hXh = ((h) qVar.hUJ.get(qVar.hUJ.size() - 1)).hUf;
                } else if (qVar.hUH != 0 || qVar.hUI <= 0) {
                    ajx();
                } else {
                    x.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[]{Integer.valueOf(qVar.hUI), Long.valueOf(qVar.hUf)});
                    a(qVar.hUI, qVar.hUf, qVar.hUG, qVar.hUF);
                    this.hXj.clear();
                }
                this.hXb = false;
                this.hXd = false;
            } else if (this.hXb) {
                x.i("MicroMsg.CollectBillListUI", "is loading filter, skip!");
                return true;
            } else if (qVar.hUG == 1) {
                this.hXd = qVar.dDR;
                if (qVar.hUJ.isEmpty()) {
                    this.hXd = true;
                } else {
                    bVar = this.hWS;
                    bVar.hWN.addAll(0, qVar.hUJ);
                    bVar.notifyDataSetChanged();
                    this.hXg = ((h) qVar.hUJ.get(0)).hUf;
                }
                this.hXa = false;
                this.hWY = false;
            } else {
                this.hXc = qVar.dDR;
                this.hWR.setVisibility(0);
                this.hWT.setVisibility(8);
                if (qVar.hUE) {
                    if (!qVar.hUJ.isEmpty()) {
                        this.hXj.addAll(qVar.hUJ);
                    }
                    if (qVar.hUH == 0 && qVar.hUI > 0 && qVar.hUJ.isEmpty()) {
                        x.i("MicroMsg.CollectBillListUI", "continue retry: %d", new Object[]{Integer.valueOf(this.retryCount)});
                        a(qVar.hUI, qVar.hUf, qVar.hUG, qVar.hUF);
                    } else {
                        this.retryCount = 0;
                        if (this.hXj.size() > 0) {
                            this.hWS.aL(this.hXj);
                        } else {
                            x.i("MicroMsg.CollectBillListUI", "retry data is empty");
                            yE(qVar.fFG);
                        }
                        this.hWZ = false;
                        this.hXh = qVar.hUf;
                        aCe();
                        ec(this.hXc);
                    }
                    return true;
                } else if (!qVar.hUJ.isEmpty()) {
                    this.hWS.aL(qVar.hUJ);
                    this.hXh = ((h) qVar.hUJ.get(qVar.hUJ.size() - 1)).hUf;
                    if (this.hXh > qVar.hUf) {
                        x.d("MicroMsg.CollectBillListUI", "use from_timestamp");
                        this.hXh = qVar.hUf;
                    } else {
                        x.i("MicroMsg.CollectBillListUI", "last record timestamp is less than fromtimestamp, %s, %s", new Object[]{Long.valueOf(this.hXh), Long.valueOf(qVar.hUf)});
                    }
                    this.hWZ = false;
                    aCe();
                    ec(this.hXc);
                } else if (qVar.hUH != 0 || qVar.hUI <= 0) {
                    this.hWZ = false;
                    aCe();
                    x.i("MicroMsg.CollectBillListUI", "next loading is empty without retry");
                    yE(qVar.fFG);
                    ec(this.hXc);
                } else {
                    x.i("MicroMsg.CollectBillListUI", "need retry, tryNum: %d, timestamp: %s", new Object[]{Integer.valueOf(qVar.hUI), Long.valueOf(qVar.hUf)});
                    a(qVar.hUI, qVar.hUf, qVar.hUG, qVar.hUF);
                    this.hXj.clear();
                }
            }
            return true;
        }
        x.i("MicroMsg.CollectBillListUI", "net error, errType: %s, errCode: %s, errMsg: %s, chooseFlag: %d, direcFlag: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(qVar.hUF), Integer.valueOf(qVar.hUG)});
        if (qVar.hUF != 0) {
            this.hXb = false;
        } else if (qVar.hUG == 0) {
            this.hWZ = false;
            aCe();
        } else {
            this.hXa = false;
        }
        if (this.hWS.isEmpty()) {
            ajx();
        }
        Toast.makeText(this, a$i.collect_bill_item_load_fail_text, 1).show();
        return true;
    }

    private void aCe() {
        this.hWU.scrollTo(0, this.hWU.getTopHeight());
    }

    private void ajx() {
        this.hWR.setVisibility(8);
        this.hWT.setVisibility(0);
        this.hWV.setVisibility(0);
    }

    private void yE(String str) {
        if (this.hWS.getCount() == 0) {
            x.i("MicroMsg.CollectBillListUI", "show empty view");
            if (!bi.oW(str)) {
                this.hWV.setText(str);
            } else if (this.hXc) {
                this.hWV.setText(getString(a$i.collect_bill_list_empty_text1));
            } else {
                this.hWV.setText(getString(a$i.collect_bill_list_empty_text1) + getString(a$i.collect_bill_list_empty_text2));
            }
            ajx();
        } else if (!bi.oW(str)) {
            Toast.makeText(this.mController.tml, str, 1).show();
        }
    }

    private void ec(boolean z) {
        this.hWU.setBottomViewVisible(!z);
    }

    private void aCf() {
        int count = this.hWS.getCount();
        if (count > 0) {
            long j = this.hWS.ot(count - 1).hUf;
            if (j < this.hXh) {
                x.i("MicroMsg.CollectBillListUI", "server lastTimestamp is error! %s, %s", new Object[]{Long.valueOf(j), Long.valueOf(this.hXh)});
                this.hXh = j;
            }
        }
        x.i("MicroMsg.CollectBillListUI", "get next page, type: %d, timestamp: %s", new Object[]{Integer.valueOf(this.type), Long.valueOf(this.hXh)});
        a(new q(this.type, this.hXh, this.limit, 0), false, false);
        this.hWZ = true;
    }

    private void a(int i, long j, int i2, int i3) {
        x.i("MicroMsg.CollectBillListUI", "get retry page, type: %d, timestamp: %s, tryNum: %d, directFlag: %d, chooseFlag: %d", new Object[]{Integer.valueOf(this.type), Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        a(new q(this.type, j, i2, this.limit, i3, i), false, false);
        this.retryCount++;
    }
}
