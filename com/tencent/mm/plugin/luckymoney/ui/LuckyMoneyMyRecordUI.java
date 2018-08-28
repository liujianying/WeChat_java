package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.luckymoney.b.aa;
import com.tencent.mm.plugin.luckymoney.b.i;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.luckymoney.b.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LuckyMoneyMyRecordUI extends LuckyMoneyBaseUI {
    private View eLM;
    private ImageView hVP;
    private TextView hWV;
    private boolean ikj = false;
    private TextView kLF;
    private List<i> kLz = new LinkedList();
    public String kRo = "";
    private MMLoadMoreListView kUS;
    private d kUT;
    private boolean kUl = true;
    private Map<String, Integer> kUs = new HashMap();
    public String kUu = "";
    private TextView kVB;
    private TextView kVC;
    private TextView kVD;
    private TextView kVE;
    private TextView kVF;
    private TextView kVG;
    private TextView kVH;
    private String kVI;
    private int kVJ = -1;
    public List<String> kVK = new ArrayList();
    private int mType;
    private int tH = 0;

    static /* synthetic */ void a(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI, i iVar, int i) {
        if (iVar == null || i < 0 || i > luckyMoneyMyRecordUI.kUT.getCount()) {
            x.e("MicroMsg.LuckyMoneyMyRecordUI", "param is illegal");
            return;
        }
        luckyMoneyMyRecordUI.l(new aa(iVar.kLZ, iVar.kPS, luckyMoneyMyRecordUI.mType, i, "v1.0"));
    }

    static /* synthetic */ void b(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        if (luckyMoneyMyRecordUI.kLz != null) {
            luckyMoneyMyRecordUI.kLz.clear();
        }
        if (luckyMoneyMyRecordUI.kUs != null) {
            luckyMoneyMyRecordUI.kUs.clear();
        }
        luckyMoneyMyRecordUI.tH = 0;
    }

    protected /* synthetic */ Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                View inflate = LayoutInflater.from(this).inflate(g.lucky_money_year_list_dialog, null);
                ListViewInScrollView listViewInScrollView = (ListViewInScrollView) inflate.findViewById(f.lucky_money_year_list);
                a aVar = new a(this);
                List list = this.kVK;
                if (list == null) {
                    aVar.kVK = new ArrayList();
                } else {
                    aVar.kVK = list;
                }
                aVar.notifyDataSetChanged();
                aVar.atr = 0;
                listViewInScrollView.setAdapter(aVar);
                listViewInScrollView.setOnItemClickListener(new 8(this, aVar));
                a aVar2 = new a(this);
                aVar2.Gq(com.tencent.mm.plugin.wxpay.a.i.lucky_money_select_year_title);
                aVar2.dR(inflate);
                aVar2.e(null);
                return aVar2.anj();
            default:
                return null;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("key_type", 2);
        initView();
        bbr();
        h.mEJ.h(11701, new Object[]{Integer.valueOf(bby()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.h.actionbar_icon_dark_more, new 2(this));
        this.hWV = (TextView) findViewById(f.lucky_money_my_record_empty_tips);
        this.kUS = (MMLoadMoreListView) findViewById(f.lucky_money_my_record_list);
        this.eLM = LayoutInflater.from(this).inflate(g.lucky_money_my_detail_header, null);
        this.kUS.addHeaderView(this.eLM);
        this.hVP = (ImageView) this.eLM.findViewById(f.lucky_money_my_detail_avatar);
        this.kVB = (TextView) this.eLM.findViewById(f.lucky_money_my_detail_nickname);
        this.kLF = (TextView) this.eLM.findViewById(f.lucky_money_my_detail_amount);
        this.kVC = (TextView) this.eLM.findViewById(f.lucky_money_my_detail_num);
        this.kVD = (TextView) this.eLM.findViewById(f.lucky_money_my_detail_num_title);
        this.kVE = (TextView) this.eLM.findViewById(f.lucky_money_my_detail_lucky_best_num);
        this.kVF = (TextView) this.eLM.findViewById(f.lucky_money_my_detail_lucky_best_num_title);
        this.kVG = (TextView) this.eLM.findViewById(f.lucky_money_my_detail_year);
        this.kVH = (TextView) this.eLM.findViewById(f.lucky_money_my_detail_send_desc);
        this.kUS.setOnItemClickListener(new 3(this));
        this.kUS.setOnItemLongClickListener(new 4(this));
        this.kUS.setOnLoadMoreListener(new 5(this));
        this.hVP.setOnClickListener(new 6(this));
        bbx();
    }

    private void bbx() {
        this.kVH.setVisibility(8);
        this.eLM.findViewById(f.lucky_money_my_detail_receive_desc).setVisibility(8);
        if (this.mType == 1) {
            setMMTitle(getString(com.tencent.mm.plugin.wxpay.a.i.lucky_money_my_send));
            o.a(this.mController.tml, this.kVB, getString(com.tencent.mm.plugin.wxpay.a.i.lucky_money_send_amount_title, new Object[]{q.GH()}));
            this.kVD.setText(com.tencent.mm.plugin.wxpay.a.i.lucky_money_send_num_title);
            this.kUT = new e(this.mController.tml);
            this.kVH.setVisibility(0);
        } else {
            setMMTitle(getString(com.tencent.mm.plugin.wxpay.a.i.lucky_money_my_receive));
            o.a(this.mController.tml, this.kVB, getString(com.tencent.mm.plugin.wxpay.a.i.lucky_money_receive_amount_title, new Object[]{q.GH()}));
            this.kVD.setText(com.tencent.mm.plugin.wxpay.a.i.lucky_money_receive_num_title);
            this.kUT = new c(this.mController.tml);
            this.eLM.findViewById(f.lucky_money_my_detail_receive_desc).setVisibility(0);
        }
        this.kUS.setAdapter(this.kUT);
        b.a(this.hVP, q.GF(), 0.0f, false);
        this.kVG.setText(getString(com.tencent.mm.plugin.wxpay.a.i.lucky_money_record_year_title, new Object[]{bi.oV(this.kVI)}));
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        i iVar;
        if (lVar instanceof z) {
            if (i == 0 && i2 == 0) {
                z zVar = (z) lVar;
                List list = zVar.kRl.kQe;
                this.kUu = zVar.kRb;
                this.kRo = zVar.kRo;
                if (this.tH == 0) {
                    this.kVK = zVar.kRm;
                    this.kVI = zVar.kRn;
                    View findViewById = findViewById(f.lucky_money_my_detail_year_select);
                    ImageView imageView = (ImageView) findViewById(f.lucky_money_my_detail_year_icon);
                    if (this.kVK.size() > 1) {
                        imageView.setVisibility(0);
                        findViewById.setOnClickListener(new 7(this));
                    }
                    this.kVG.setText(getString(com.tencent.mm.plugin.wxpay.a.i.lucky_money_record_year_title, new Object[]{this.kVI}));
                }
                com.tencent.mm.plugin.luckymoney.b.h hVar = zVar.kRl;
                if (hVar != null) {
                    if (this.mType == 1) {
                        this.kLF.setText(e.A(((double) hVar.kQn) / 100.0d));
                        String str2 = hVar.kQm;
                        CharSequence string = getString(com.tencent.mm.plugin.wxpay.a.i.lucky_money_send_num_desc, new Object[]{str2});
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(c.lucky_money_goldstyle_detail_primary_text_color));
                        int indexOf = string.indexOf(str2);
                        CharSequence spannableString = new SpannableString(string);
                        spannableString.setSpan(foregroundColorSpan, indexOf, str2.length() + indexOf, 33);
                        this.kVH.setText(spannableString);
                    } else {
                        this.kLF.setText(e.A(((double) hVar.kQl) / 100.0d));
                        this.kVC.setText(hVar.kQk);
                        this.kVE.setText(hVar.jzh);
                    }
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        iVar = (i) list.get(i3);
                        if (!this.kUs.containsKey(iVar.kLZ)) {
                            this.kLz.add(list.get(i3));
                            this.kUs.put(iVar.kLZ, Integer.valueOf(1));
                        }
                    }
                    this.tH += list.size();
                    this.kUl = zVar.baZ();
                    this.ikj = false;
                    this.kUT.bw(this.kLz);
                }
                if (this.kLz == null || this.kLz.size() == 0) {
                    this.hWV.setVisibility(0);
                } else {
                    this.hWV.setVisibility(8);
                }
                if (this.kUl) {
                    this.kUS.crC();
                } else {
                    this.kUS.crD();
                }
                return true;
            }
            this.kRo = null;
            return false;
        } else if (!(lVar instanceof aa)) {
            return false;
        } else {
            int i4 = this.kVJ;
            this.kVJ = -1;
            if (i != 0 || i2 != 0) {
                return false;
            }
            iVar = this.kUT.sm(i4);
            if (iVar != null) {
                Toast.makeText(this, com.tencent.mm.plugin.wxpay.a.i.lucky_money_list_delete_record_succ, 0).show();
                this.kUT.a(iVar);
                this.kUT.notifyDataSetChanged();
            } else {
                x.e("MicroMsg.LuckyMoneyMyRecordUI", "can't found local record");
            }
            return true;
        }
    }

    protected final int getLayoutId() {
        return g.lucky_money_my_record_ui;
    }

    private void bbr() {
        this.ikj = true;
        if (this.tH == 0) {
            this.kUu = "";
        }
        l(new z(11, this.tH, this.mType, this.kVI, "v1.0", this.kUu));
    }

    private int bby() {
        if (this.mType == 1) {
            return 8;
        }
        return 9;
    }
}
