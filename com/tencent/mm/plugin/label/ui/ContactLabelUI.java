package com.tencent.mm.plugin.label.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.h;
import com.tencent.mm.plugin.label.b.d;
import com.tencent.mm.plugin.label.ui.widget.MMLabelPanel;
import com.tencent.mm.protocal.c.bxe;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.MMTagPanelScrollView;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.tools.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ContactLabelUI extends ContactLabelBaseUI implements e {
    private String cYO;
    private MMTagPanelScrollView kBF;
    private MMLabelPanel kBG;
    private TextView kBH;
    private View kBI;
    private View kBJ;
    private TextView kBK;
    private MMLabelPanel kBL;
    private ListView kBM;
    private ScrollView kBN;
    private b kBO;
    private String kBP;
    private ArrayList<String> kBQ;
    private HashSet<String> kBR = new HashSet();
    private HashSet<String> kBS = new HashSet();
    private ArrayList<String> kBT = new ArrayList();
    private int kBU = a.kBZ;
    private boolean kBV = false;
    private ArrayList<String> kBW;
    private boolean kBg = true;

    private enum a {
        ;

        public static int[] aYX() {
            return (int[]) kCd.clone();
        }

        static {
            kBZ = 1;
            kCa = 2;
            kCb = 3;
            kCc = 4;
            kCd = new int[]{kBZ, kCa, kCb, kCc};
        }
    }

    static /* synthetic */ void a(ContactLabelUI contactLabelUI) {
        x.i("MicroMsg.Label.ContactLabelUI", "cpan[save]");
        if (contactLabelUI.kBG == null) {
            x.w("MicroMsg.Label.ContactLabelUI", "save fail. input view is null.");
            return;
        }
        contactLabelUI.FE(contactLabelUI.getString(R.l.label_saving));
        String editText;
        if (contactLabelUI.kBV) {
            x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabelStranger]");
            if (contactLabelUI.kBG != null) {
                editText = contactLabelUI.kBG.getEditText();
                if (!bi.oW(editText)) {
                    contactLabelUI.kBG.bu(editText, true);
                    contactLabelUI.kBG.crN();
                    contactLabelUI.aD(editText, contactLabelUI.kBV);
                }
            }
            if (contactLabelUI.kBS != null && contactLabelUI.kBS.size() > 0) {
                x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabelStranger] save local");
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(contactLabelUI.kBS);
                if (!arrayList.isEmpty()) {
                    int size = arrayList.size();
                    List arrayList2 = new ArrayList();
                    for (int i = 0; i < size; i++) {
                        ad adVar = new ad();
                        editText = (String) arrayList.get(i);
                        adVar.field_isTemporary = true;
                        adVar.field_labelName = editText;
                        adVar.field_labelPYFull = h.oI(editText);
                        adVar.field_labelPYShort = h.oJ(editText);
                        adVar.field_labelID = -((int) System.nanoTime());
                        x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabelStranger]field_labelID:%s field_labelName:%s", new Object[]{Integer.valueOf(adVar.field_labelID), adVar.field_labelName});
                        arrayList2.add(adVar);
                    }
                    com.tencent.mm.plugin.label.e.aYJ().dc(arrayList2);
                }
            }
            x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveStranger]");
            au.HU();
            bq Hh = c.FS().Hh(contactLabelUI.cYO);
            if (contactLabelUI.kBG != null) {
                String bo = com.tencent.mm.plugin.label.a.a.aYK().bo(contactLabelUI.kBG.getTagList());
                if (bi.oW(bo)) {
                    Hh.field_contactLabels = "";
                    au.HU();
                    c.FS().a(Hh);
                } else {
                    Hh.field_contactLabels = bo;
                    if (bi.oW(Hh.field_encryptUsername)) {
                        Hh.field_encryptUsername = contactLabelUI.cYO;
                    }
                    au.HU();
                    c.FS().a(Hh);
                }
            }
            contactLabelUI.aYV();
            return;
        }
        x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLabel]");
        if (contactLabelUI.kBG != null) {
            editText = contactLabelUI.kBG.getEditText();
            if (!bi.oW(editText)) {
                editText = editText.trim();
                contactLabelUI.kBG.bu(editText, true);
                contactLabelUI.kBG.crN();
                contactLabelUI.aD(editText, contactLabelUI.kBV);
            }
        }
        if (contactLabelUI.kBS == null || contactLabelUI.kBS.size() <= 0) {
            x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLable] doSaveContact");
            contactLabelUI.aYU();
            return;
        }
        x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveLable] doScene");
        List arrayList3 = new ArrayList();
        arrayList3.addAll(contactLabelUI.kBS);
        au.DF().a(new com.tencent.mm.plugin.label.b.a(arrayList3), 0);
        if (contactLabelUI.kBT == null || contactLabelUI.kBS.isEmpty()) {
            com.tencent.mm.plugin.report.service.h.mEJ.h(11347, new Object[]{Integer.valueOf(0), Integer.valueOf(0)});
            return;
        }
        com.tencent.mm.plugin.report.service.h.mEJ.h(11347, new Object[]{Integer.valueOf(0), Integer.valueOf(1)});
    }

    protected final int getLayoutId() {
        return R.i.contact_label_ui;
    }

    protected final void initView() {
        setMMTitle(getString(R.l.add_label_title));
        setBackBtn(new 1(this));
        a(0, getString(R.l.app_save), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ContactLabelUI.a(ContactLabelUI.this);
                return false;
            }
        }, b.tmX);
        this.kBF = (MMTagPanelScrollView) findViewById(R.h.label_panel_scroll);
        this.kBF.setMaxLine(3);
        this.kBG = (MMLabelPanel) findViewById(R.h.label_panel_input);
        this.kBH = (TextView) findViewById(R.h.label_panel_tips);
        this.kBI = findViewById(R.h.label_panel_container);
        this.kBJ = findViewById(R.h.label_panel_all_title_pref);
        this.kBJ.setBackgroundDrawable(null);
        this.kBK = (TextView) this.kBJ.findViewById(16908310);
        this.kBK.setText(R.l.label_panel_all);
        this.kBL = (MMLabelPanel) findViewById(R.h.label_panel_all);
        this.kBM = (ListView) findViewById(R.h.label_panel_suggest);
        this.kBN = (ScrollView) findViewById(R.h.label_scroll_view);
        if (this.kBN != null) {
            this.kBN.setOnTouchListener(new 6(this));
        }
        this.kBG.txF = true;
        this.kBG.lL(true);
        this.kBG.setTagEditTextBG(R.g.tag_edittext_gb);
        this.kBG.setCallBack(new com.tencent.mm.ui.base.MMTagPanel.a() {
            public final void zO(String str) {
                x.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagUnSelected] tag:%s", new Object[]{str});
                ContactLabelUI.this.kBG.removeTag(str);
                if (ContactLabelUI.this.kBL != null) {
                    ContactLabelUI.this.kBL.bv(str, false);
                }
                ContactLabelUI.a(ContactLabelUI.this, str);
            }

            public final void zP(String str) {
                x.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagSelected] tag:%s", new Object[]{str});
            }

            public final void zQ(String str) {
                x.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagRemove] tag:%s", new Object[]{str});
                if (ContactLabelUI.this.kBL != null) {
                    ContactLabelUI.this.kBL.bv(str, false);
                }
                ContactLabelUI.a(ContactLabelUI.this, str);
            }

            public final void aGt() {
                x.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextClick]");
            }

            public final void zR(String str) {
                x.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagEditTextChange] curText:%s", new Object[]{str});
                ContactLabelUI.b(ContactLabelUI.this, str);
            }

            public final void zS(String str) {
                x.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagCreate] tag:%s", new Object[]{str});
                if (bi.oW(str)) {
                    x.d("MicroMsg.Label.ContactLabelUI", "tag is null.");
                    return;
                }
                ContactLabelUI.this.kBG.bu(str, true);
                if (ContactLabelUI.this.kBL != null) {
                    ContactLabelUI.this.kBL.bv(str, true);
                }
                ContactLabelUI.this.aD(str, ContactLabelUI.this.kBV);
            }

            public final void i(boolean z, int i) {
                x.d("MicroMsg.Label.ContactLabelUI", "cpan[Input onTagLengthMax] match:%s exceedCount:%d", new Object[]{String.valueOf(z), Integer.valueOf(i)});
                if (z) {
                    ContactLabelUI.this.enableOptionMenu(false);
                    ContactLabelUI.this.kBH.setVisibility(0);
                    ContactLabelUI.this.kBH.setText(R.l.label_panel_max_tips);
                    ContactLabelUI.this.kBH.setText(String.format(ContactLabelUI.this.getString(R.l.label_panel_max_tips), new Object[]{Integer.valueOf(g.be(36, "")), Integer.valueOf(i)}));
                    return;
                }
                ContactLabelUI.this.enableOptionMenu(true);
                ContactLabelUI.this.kBH.setVisibility(8);
            }
        });
        this.kBL.lL(false);
        this.kBL.setCallBack(new com.tencent.mm.ui.base.MMTagPanel.a() {
            public final void zO(String str) {
                x.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagUnSelected] tag:%s", new Object[]{str});
                if (ContactLabelUI.this.kBG != null) {
                    ContactLabelUI.this.kBG.removeTag(str);
                }
                ContactLabelUI.a(ContactLabelUI.this, str);
            }

            public final void zP(String str) {
                x.d("MicroMsg.Label.ContactLabelUI", "cpan[All onTagSelected] tag:%s", new Object[]{str});
                if (ContactLabelUI.this.kBG != null) {
                    ContactLabelUI.this.kBG.bu(str, true);
                }
                ContactLabelUI.this.aD(str, ContactLabelUI.this.kBV);
            }

            public final void zQ(String str) {
            }

            public final void i(boolean z, int i) {
            }

            public final void aGt() {
            }

            public final void zR(String str) {
            }

            public final void zS(String str) {
            }
        });
        this.kBM.setAdapter(this.kBO);
        this.kBM.setOnItemClickListener(new 9(this));
        enableOptionMenu(false);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kBP = getIntent().getStringExtra("label_id_list");
        this.kBQ = getIntent().getStringArrayListExtra("label_str_list");
        this.cYO = getIntent().getStringExtra("label_username");
        this.kBV = getIntent().getBooleanExtra("is_stranger", false);
        this.kBO = new b(this);
        initView();
        if (!(bi.oW(this.kBP) || this.kBQ == null || this.kBQ.size() <= 0)) {
            this.kBG.a(this.kBQ, this.kBQ);
        }
        if (this.kBV) {
            this.kBW = getIntent().getStringArrayListExtra("label_str_list");
            this.kBG.a(this.kBW, this.kBW);
        }
    }

    protected void onResume() {
        au.DF().a(635, this);
        au.DF().a(638, this);
        ah.A(new Runnable() {
            public final void run() {
                Collection collection = null;
                ContactLabelUI.this.kBR.clear();
                ContactLabelUI.this.kBS.clear();
                if (ContactLabelUI.this.kBG != null) {
                    ab Yg;
                    String str;
                    if (ContactLabelUI.this.kBV) {
                        String str2;
                        au.HU();
                        bq Hh = c.FS().Hh(ContactLabelUI.this.cYO);
                        if (Hh != null) {
                            str2 = Hh.field_contactLabels;
                        }
                        if (bi.oW(str2)) {
                            au.HU();
                            Yg = c.FR().Yg(ContactLabelUI.this.cYO);
                            String str3 = Yg.field_encryptUsername;
                            if (!bi.oW(str3)) {
                                au.HU();
                                bq Hh2 = c.FS().Hh(str3);
                                if (Hh2 != null) {
                                    str2 = Hh2.field_contactLabels;
                                }
                            }
                            if (bi.oW(str2)) {
                                str = Yg.field_username;
                                au.HU();
                                Hh = c.FS().Hh(str);
                                if (Hh != null) {
                                    str2 = Hh.field_contactLabels;
                                }
                            }
                        }
                        collection = (ArrayList) com.tencent.mm.plugin.label.a.a.aYK().FB(str2);
                    } else {
                        au.HU();
                        Yg = c.FR().Yg(ContactLabelUI.this.cYO);
                        if (Yg != null) {
                            str = Yg.field_contactLabelIds;
                            if (!bi.oW(str)) {
                                ArrayList arrayList = (ArrayList) com.tencent.mm.plugin.label.a.a.aYK().FC(str);
                            }
                        }
                    }
                    ContactLabelUI.this.kBG.a(collection, collection);
                    ContactLabelUI.a(ContactLabelUI.this, (ArrayList) collection);
                }
                if (ContactLabelUI.this.kBL != null) {
                    ContactLabelUI.this.kBT = com.tencent.mm.plugin.label.e.aYJ().cld();
                    if (ContactLabelUI.this.kBT != null && ContactLabelUI.this.kBT.size() > 0) {
                        ContactLabelUI.this.kBV;
                        ContactLabelUI.this.kBL.a(collection, ContactLabelUI.this.kBT);
                        if (ContactLabelUI.this.kBg) {
                            com.tencent.mm.plugin.report.service.h.mEJ.h(11346, new Object[]{Integer.valueOf(0), Integer.valueOf(1)});
                            ContactLabelUI.this.kBg = false;
                        }
                    } else if (ContactLabelUI.this.kBg) {
                        com.tencent.mm.plugin.report.service.h.mEJ.h(11346, new Object[]{Integer.valueOf(0), Integer.valueOf(0)});
                        ContactLabelUI.this.kBg = false;
                    }
                }
                ContactLabelUI.this.rO(a.kBZ);
            }
        });
        super.onResume();
    }

    protected void onPause() {
        au.DF().b(635, this);
        au.DF().b(638, this);
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (lVar.getType()) {
            case 635:
                if (i == 0 && i2 == 0) {
                    aYU();
                    return;
                } else {
                    aYP();
                    return;
                }
            case 638:
                if (i == 0 && i2 == 0) {
                    x.i("MicroMsg.Label.ContactLabelUI", "cpan[onSceneEnd] success.");
                    aYV();
                    return;
                }
                aYP();
                return;
            default:
                x.w("MicroMsg.Label.ContactLabelUI", "unknow type.");
                return;
        }
    }

    public void onBackPressed() {
        if (aYW()) {
            com.tencent.mm.ui.base.h.a(this, getString(R.l.save_label_msg), "", getString(R.l.btn_save), getString(R.l.btn_unsave), new 2(this), new 3(this));
        } else {
            super.onBackPressed();
        }
    }

    private void rO(int i) {
        this.kBU = i;
        switch (4.kBY[this.kBU - 1]) {
            case 1:
                this.kBM.setVisibility(8);
                if (this.kBT == null || this.kBT.size() <= 0) {
                    this.kBN.setVisibility(8);
                    this.kBI.setVisibility(8);
                } else {
                    this.kBI.setVisibility(0);
                    this.kBN.setVisibility(0);
                }
                this.kBH.setVisibility(8);
                return;
            case 2:
                this.kBN.setVisibility(8);
                this.kBM.setVisibility(0);
                this.kBI.setVisibility(8);
                this.kBH.setVisibility(8);
                return;
            case 3:
                this.kBM.setVisibility(8);
                this.kBN.setVisibility(8);
                this.kBI.setVisibility(8);
                this.kBH.setVisibility(0);
                this.kBH.setText(R.l.label_panel_max_tips);
                return;
            case 4:
                this.kBM.setVisibility(8);
                this.kBN.setVisibility(8);
                this.kBI.setVisibility(8);
                this.kBH.setVisibility(0);
                this.kBH.setText(R.l.label_panel_max_tips);
                return;
            default:
                return;
        }
    }

    private void aD(String str, boolean z) {
        if (bi.oW(str)) {
            x.w("MicroMsg.Label.ContactLabelUI", "tag is empty");
            return;
        }
        String trim = str.trim();
        if (bi.oW(trim)) {
            x.w("MicroMsg.Label.ContactLabelUI", "new tag is empty");
            return;
        }
        ad XX = com.tencent.mm.plugin.label.e.aYJ().XX(trim);
        if (z) {
            if (this.kBT == null || !this.kBT.contains(trim) || XX == null) {
                this.kBS.add(trim);
            }
        } else if (this.kBT == null || !this.kBT.contains(trim) || (XX != null && XX.field_isTemporary)) {
            this.kBS.add(trim);
        }
        if (this.kBR != null && this.kBR.contains(trim)) {
            this.kBR.remove(trim);
        }
        if (aYW()) {
            enableOptionMenu(true);
        }
    }

    private void aYU() {
        x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]");
        if (this.kBG != null) {
            int size;
            int size2;
            int size3;
            x.i("MicroMsg.Label.ContactLabelUI", "cpan[saveContact] doScene");
            String str = "";
            ArrayList tagList = this.kBG.getTagList();
            if (tagList != null && tagList.size() > 0) {
                str = com.tencent.mm.plugin.label.c.bq(com.tencent.mm.plugin.label.e.aYJ().ab(tagList));
            }
            LinkedList linkedList = new LinkedList();
            bxe bxe = new bxe();
            bxe.rvl = str;
            bxe.hbL = this.cYO;
            linkedList.add(bxe);
            au.DF().a(new d(linkedList), 0);
            if (this.kBS != null) {
                size = this.kBS.size();
            } else {
                size = 0;
            }
            if (this.kBQ != null) {
                size2 = this.kBQ.size();
            } else {
                size2 = 0;
            }
            if (this.kBR != null) {
                size3 = this.kBR.size();
            } else {
                size3 = 0;
            }
            size2 = ((size3 + this.kBG.getTagList().size()) - size2) - size;
            if (size > 0 || size2 > 0) {
                x.d("MicroMsg.Label.ContactLabelUI", "cpan[saveContact]addLabelNum:%d,updateLabelNum:%d", new Object[]{Integer.valueOf(size), Integer.valueOf(size2)});
                com.tencent.mm.plugin.report.service.h.mEJ.h(11220, new Object[]{q.GF(), Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(0)});
            }
        }
    }

    private void aYV() {
        aYM();
        this.kBS.clear();
        this.kBR.clear();
        finish();
    }

    private void aYP() {
        aYM();
        zK(getString(R.l.add_label_fail_msg));
    }

    private boolean aYW() {
        if (this.kBG != null) {
            if (this.kBQ == null || this.kBQ.size() <= 0) {
                if (this.kBG.getTagList() != null && this.kBG.getTagList().size() > 0) {
                    return true;
                }
            } else if (this.kBG.getTagList() == null && this.kBG.getTagList().size() <= 0) {
                return true;
            } else {
                List tagList = this.kBG.getTagList();
                Collections.sort(this.kBQ);
                Collections.sort(tagList);
                if (this.kBQ.equals(tagList)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public void finish() {
        if (this.kBG != null) {
            this.kBG.crP();
        }
        Intent intent = new Intent();
        if (aYW()) {
            intent.putExtra("hasLableChange", true);
        } else {
            intent.putExtra("hasLableChange", false);
        }
        setResult(-1, intent);
        super.finish();
    }
}
