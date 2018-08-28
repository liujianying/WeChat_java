package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a$e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class WalletCardSelectUI extends WalletBaseUI {
    private int pdu = -1;
    private int phG = 3;
    private List<ElementQuery> puA = new LinkedList();
    private CheckedTextView puB;
    private CheckedTextView puC;
    private String puD;
    private int puE;
    private int puF = -1;
    private int puG = -1;
    private a puH;
    private MaxListView puI;
    private List<ElementQuery> puz = new LinkedList();

    public class a extends BaseAdapter {
        private Context context;
        List<ElementQuery> dEw = new ArrayList();

        public a(Context context) {
            this.context = context;
        }

        public final boolean isEnabled(int i) {
            return bi.oW(((ElementQuery) this.dEw.get(i)).pnz);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CharSequence charSequence;
            a aVar = new a(this);
            View inflate = View.inflate(this.context, g.wallet_bank_select_item, null);
            aVar.puK = (CheckedTextView) inflate.findViewById(f.check_tv_cv);
            ElementQuery elementQuery = (ElementQuery) this.dEw.get(i);
            String aG = bi.aG(elementQuery.knE, "");
            if (bi.oW(elementQuery.pnz)) {
                aVar.puK.setEnabled(true);
                Object charSequence2 = aG;
            } else {
                charSequence2 = aG + "[" + elementQuery.pnz + "]";
                aVar.puK.setEnabled(false);
            }
            aVar.puK.setText(charSequence2);
            return inflate;
        }

        public final int getCount() {
            return this.dEw.size();
        }

        /* renamed from: zr */
        public final ElementQuery getItem(int i) {
            return (ElementQuery) this.dEw.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(i.wallet_card_select_ui);
        initView();
        this.puA.clear();
        this.puz.clear();
        if (o.bPe().pjy != null) {
            for (ElementQuery elementQuery : o.bPe().pjy) {
                if (this.pdu == 5 && !elementQuery.pnO) {
                    elementQuery.pnz = getString(i.wallet_wx_offline_no_support);
                }
                if (elementQuery.bOu()) {
                    this.puA.add(elementQuery);
                } else if (elementQuery.bOE()) {
                    this.puz.add(elementQuery);
                }
            }
        }
        if (this.phG == 3 && !this.puA.isEmpty()) {
            if (o.bOW().bPx()) {
                Collections.sort(this.puA, new Comparator<ElementQuery>() {
                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        return ((ElementQuery) obj).pjA - ((ElementQuery) obj2).pjA;
                    }
                });
            } else {
                Collections.sort(this.puA, new 7(this));
            }
        }
        int size;
        int i;
        if (this.puz.isEmpty()) {
            size = this.puA.size();
            for (i = 0; i < size; i++) {
                if (((ElementQuery) this.puA.get(i)).lMV.equals(this.puD)) {
                    this.puG = i;
                    jw(false);
                    enableOptionMenu(true);
                    break;
                }
            }
            if (this.puG < 0) {
                jw(false);
                enableOptionMenu(false);
            }
            this.puB.setVisibility(8);
            this.puC.setBackgroundResource(a$e.comm_list_item_selector);
            this.puC.setCheckMarkDrawable(a$e.round_selector);
        } else if (bi.oW(this.puD)) {
            this.puB.setChecked(false);
            this.puC.setChecked(false);
            this.puI.setVisibility(8);
        } else if (this.puE == 2) {
            size = this.puA.size();
            for (i = 0; i < size; i++) {
                if (((ElementQuery) this.puA.get(i)).lMV.equals(this.puD)) {
                    this.puG = i;
                    jw(false);
                    enableOptionMenu(true);
                    break;
                }
            }
            if (this.puG < 0) {
                jw(false);
                enableOptionMenu(false);
            }
        } else {
            size = this.puz.size();
            for (i = 0; i < size; i++) {
                if (((ElementQuery) this.puz.get(i)).lMV.equals(this.puD)) {
                    this.puF = i;
                    jw(true);
                    enableOptionMenu(true);
                    break;
                }
            }
            if (this.puF < 0) {
                jw(false);
                enableOptionMenu(false);
            }
        }
    }

    public final void initView() {
        this.puD = this.sy.getString("key_bank_type");
        this.puE = this.sy.getInt("key_bankcard_type", 1);
        this.phG = this.sy.getInt("key_support_bankcard", 1);
        this.pdu = this.sy.getInt("key_bind_scene", -1);
        this.puI = (MaxListView) findViewById(f.settings_lv_bank);
        this.puB = (CheckedTextView) findViewById(f.check_type_first_tv);
        this.puC = (CheckedTextView) findViewById(f.check_type_second_tv);
        this.puH = new a(this);
        this.puI.setAdapter(this.puH);
        this.puI.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ElementQuery zr = WalletCardSelectUI.this.puH.getItem(i);
                if (bi.oW(zr.pnz)) {
                    if (zr.bOE()) {
                        WalletCardSelectUI.this.puF = i;
                    } else {
                        WalletCardSelectUI.this.puG = i;
                    }
                    WalletCardSelectUI.this.enableOptionMenu(true);
                    return;
                }
                h.a(WalletCardSelectUI.this, zr.pnz, null, true, null);
            }
        });
        setBackBtn(new 2(this));
        a(0, getString(i.app_finish), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Parcelable parcelable = null;
                Intent intent = new Intent();
                if (WalletCardSelectUI.this.puB.isChecked() && WalletCardSelectUI.this.puF >= 0) {
                    parcelable = (ElementQuery) WalletCardSelectUI.this.puz.get(WalletCardSelectUI.this.puF);
                } else if (WalletCardSelectUI.this.puC.isChecked() && WalletCardSelectUI.this.puG >= 0) {
                    ElementQuery parcelable2 = (ElementQuery) WalletCardSelectUI.this.puA.get(WalletCardSelectUI.this.puG);
                }
                if (parcelable2 != null) {
                    intent.putExtra("elemt_query", parcelable2);
                    WalletCardSelectUI.this.setResult(-1, intent);
                } else {
                    WalletCardSelectUI.this.setResult(0);
                }
                WalletCardSelectUI.this.finish();
                return true;
            }
        }, b.tmX);
        enableOptionMenu(false);
        this.puB.setOnClickListener(new 4(this));
        this.puC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletCardSelectUI.this.jw(false);
            }
        });
    }

    private void jw(boolean z) {
        this.puI.setVisibility(0);
        if (z) {
            this.puB.setChecked(true);
            this.puC.setChecked(false);
            this.puH.dEw = this.puz;
            this.puH.notifyDataSetChanged();
            this.puI.clearChoices();
            if (this.puF >= 0) {
                this.puI.setItemChecked(this.puF, true);
                enableOptionMenu(true);
                return;
            }
            enableOptionMenu(false);
            return;
        }
        this.puB.setChecked(false);
        this.puC.setChecked(true);
        this.puH.dEw = this.puA;
        this.puH.notifyDataSetChanged();
        this.puI.clearChoices();
        if (this.puG >= 0) {
            this.puI.setItemChecked(this.puG, true);
            enableOptionMenu(true);
            return;
        }
        enableOptionMenu(false);
    }

    protected final int getLayoutId() {
        return g.wallet_cardselect_ui;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        return false;
    }

    public final boolean bbU() {
        return false;
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
