package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ImageView;
import com.tencent.mm.ab.e;
import com.tencent.mm.bg.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.label.a.a;
import com.tencent.mm.plugin.sns.i$c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.listview.AnimatedExpandableListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SnsLabelUI extends MMActivity implements e {
    public static int[] nXt = new int[]{j.sns_label_public, j.sns_label_private, j.sns_label_include, j.sns_label_exclude};
    private boolean nXA = false;
    private boolean nXB = false;
    private boolean nXC = false;
    private int nXD;
    private p nXE;
    private String nXF;
    private int nXG;
    private ArrayList<String> nXH;
    private ArrayList<String> nXI;
    private ArrayList<Long> nXJ;
    private ArrayList<String[]> nXK;
    private AnimatedExpandableListView nXs;
    private ArrayList<String> nXu;
    private String nXv;
    private String nXw;
    aq nXx;
    private int nXy = 0;
    private boolean nXz;

    static /* synthetic */ void a(SnsLabelUI snsLabelUI, int i, ArrayList arrayList, String str, View view) {
        if (snsLabelUI.nXx == null || snsLabelUI.nXx.style != 1) {
            if (arrayList.contains(str)) {
                arrayList.remove(str);
                ((ImageView) view.findViewById(f.sns_label_right_img)).setImageResource(i.checkbox_unselected);
                return;
            }
            arrayList.add(str);
            if (i == 1) {
                ((ImageView) view.findViewById(f.sns_label_right_img)).setImageResource(i.checkbox_selected);
            } else {
                ((ImageView) view.findViewById(f.sns_label_right_img)).setImageResource(i.checkbox_selected_red);
            }
        } else if (arrayList.contains(str)) {
            arrayList.remove(str);
            if (i == 1) {
                ((ImageView) view.findViewById(f.sns_label_right_img)).setImageResource(i.sight_list_checkbox_unselected);
            } else {
                ((ImageView) view.findViewById(f.sns_label_right_img)).setImageResource(i.sight_list_checkbox_unselected_red);
            }
        } else {
            arrayList.add(str);
            if (i == 1) {
                ((ImageView) view.findViewById(f.sns_label_right_img)).setImageResource(i.sight_list_checkbox_selected);
            } else {
                ((ImageView) view.findViewById(f.sns_label_right_img)).setImageResource(i.sight_list_checkbox_selected_red);
            }
        }
    }

    static /* synthetic */ void f(SnsLabelUI snsLabelUI) {
        Intent intent = new Intent();
        intent.putExtra("titile", snsLabelUI.getString(j.address_title_select_contact));
        intent.putExtra("snsPostWhoCanSee", true);
        intent.putExtra("list_attr", s.s(new int[]{s.ukF, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT}));
        if (snsLabelUI.nXD == 2) {
            if (snsLabelUI.nXx.nXV.size() > 0) {
                intent.putExtra("already_select_contact", bi.c(snsLabelUI.nXx.nXV, ","));
            }
        } else if (snsLabelUI.nXD == 3 && snsLabelUI.nXx.nXW.size() > 0) {
            intent.putExtra("already_select_contact", bi.c(snsLabelUI.nXx.nXW, ","));
        }
        d.b(snsLabelUI, ".ui.contact.SelectContactUI", intent, 4003);
    }

    protected final int getLayoutId() {
        return g.sns_label;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        goBack();
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(j.sns_tag_title);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(292, this);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(635, this);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(638, this);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.a(com.tencent.mm.plugin.appbrand.jsapi.audio.e.CTRL_INDEX, this);
        this.nXx = new aq(this);
        Intent intent = getIntent();
        if (intent == null) {
            this.nXy = 0;
            this.nXx.style = 0;
            this.nXv = null;
            this.nXw = null;
        } else {
            this.nXy = intent.getIntExtra("KLabel_range_index", 0);
            this.nXx.style = intent.getIntExtra("k_sns_label_ui_style", 0);
            this.nXv = intent.getStringExtra("Klabel_name_list");
            this.nXw = intent.getStringExtra("Kother_user_name_list");
            if (!TextUtils.isEmpty(intent.getStringExtra("k_sns_label_ui_title"))) {
                setMMTitle(intent.getStringExtra("k_sns_label_ui_title"));
            }
        }
        this.nXx.nXR = this.nXy;
        if (this.nXx.style == 1) {
            findViewById(f.sns_label_layout).setBackgroundResource(i$c.black);
        }
        if (this.nXy == 2) {
            if (!TextUtils.isEmpty(this.nXv)) {
                this.nXx.nXT = bi.F(this.nXv.split(","));
            }
            if (!TextUtils.isEmpty(this.nXw)) {
                this.nXx.nXV = bi.F(this.nXw.split(","));
            }
        } else if (this.nXy == 3) {
            if (!TextUtils.isEmpty(this.nXv)) {
                this.nXx.nXU = bi.F(this.nXv.split(","));
            }
            if (!TextUtils.isEmpty(this.nXw)) {
                this.nXx.nXW = bi.F(this.nXw.split(","));
            }
        }
        com.tencent.mm.kernel.g.Ek();
        this.nXz = ((Boolean) com.tencent.mm.kernel.g.Ei().DT().get(335873, Boolean.valueOf(true))).booleanValue();
        if (this.nXz) {
            this.nXB = true;
            this.nXC = true;
            if (bDA() > 0) {
                this.nXA = true;
            }
            com.tencent.mm.kernel.g.Ek();
            com.tencent.mm.kernel.g.Eh().dpP.a(new v(1), 0);
        }
        initView();
    }

    protected final void initView() {
        boolean booleanExtra = getIntent().getBooleanExtra("KLabel_is_filter_private", false);
        this.nXs = (AnimatedExpandableListView) findViewById(f.sns_label_exlist);
        this.nXu = (ArrayList) a.aYK().aYF();
        this.nXx.nXS = booleanExtra;
        this.nXx.O(this.nXu);
        LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
        layoutParams.height = getResources().getDimensionPixelSize(com.tencent.mm.plugin.sns.i.d.LargerPadding);
        View view = new View(this);
        view.setLayoutParams(layoutParams);
        this.nXs.addHeaderView(view);
        this.nXs.setAdapter(this.nXx);
        if (this.nXx.nXR == 2) {
            this.nXs.expandGroup(2);
        } else if (this.nXx.nXR == 3) {
            this.nXs.expandGroup(3);
        }
        this.nXs.setOnGroupClickListener(new 1(this));
        this.nXs.setOnChildClickListener(new 3(this));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SnsLabelUI.this.goBack();
                return true;
            }
        });
        a(0, getString(j.sns_label_finish), new 5(this), b.tmX);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String stringExtra;
        Intent intent2;
        if (i2 == -1 && i == 4003) {
            x.i("MicroMsg.SnsLabelUI", "the Activity completed");
            stringExtra = intent.getStringExtra("Select_Contacts_To_Create_New_Label");
            if (bi.oW(stringExtra)) {
                stringExtra = intent.getStringExtra("Select_Contact");
                this.nXw = new String(stringExtra);
                x.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[]{stringExtra});
                if (this.nXD == 2) {
                    this.nXx.nXV.clear();
                    if (!bi.oW(stringExtra)) {
                        this.nXx.nXV.addAll(bi.F(stringExtra.split(",")));
                        this.nXx.nXR = this.nXD;
                    }
                } else if (this.nXD == 3) {
                    this.nXx.nXW.clear();
                    if (!bi.oW(stringExtra)) {
                        this.nXx.nXW.addAll(bi.F(stringExtra.split(",")));
                        this.nXx.nXR = this.nXD;
                    }
                }
                this.nXx.notifyDataSetChanged();
                this.nXs.expandGroup(this.nXD);
                return;
            }
            intent2 = new Intent();
            intent2.putExtra("Select_Contact", stringExtra);
            d.b(this.mController.tml, "label", ".ui.ContactLabelEditUI", intent2, 4002);
        } else if (i2 == -1 && i == 4001) {
            stringExtra = intent.getStringExtra("Select_Contact");
            x.i("MicroMsg.SnsLabelUI", "dz[onActivityResult] %s", new Object[]{stringExtra});
            if (!bi.oW(stringExtra)) {
                intent2 = new Intent();
                intent2.putExtra("Select_Contact", stringExtra);
                d.b(this, "label", ".ui.ContactLabelEditUI", intent2, 4002);
            }
        } else if (i2 == 0 && i == 4002 && intent != null) {
            stringExtra = intent.getStringExtra("k_sns_label_add_label");
            this.nXF = intent.getStringExtra("k_sns_label_add_label");
            this.nXs.postDelayed(new 7(this, stringExtra), 300);
        }
    }

    private void goBack() {
        boolean z = false;
        int i = this.nXx.nXR;
        if (this.nXx.nXR != this.nXy) {
            if ((i == 2 && (this.nXx.nXT.size() != 0 || this.nXx.nXV.size() != 0)) || (i == 3 && (this.nXx.nXU.size() != 0 || this.nXx.nXW.size() != 0))) {
                z = true;
            } else if (i == 1 || i == 0) {
                z = true;
            }
        } else if (!((i != 2 || this.nXx.nXT.size() == 0 || (bi.c(this.nXx.nXT, ",").equals(this.nXv) && bi.c(this.nXx.nXV, ",").equals(this.nXw))) && (i != 3 || this.nXx.nXU.size() == 0 || (bi.c(this.nXx.nXU, ",").equals(this.nXv) && bi.c(this.nXx.nXW, ",").equals(this.nXw))))) {
            z = true;
        }
        if (z) {
            h.a((Context) this, true, getString(j.sns_label_goback_tip), "", getString(j.sns_label_goback_save), getString(j.sns_label_goback_notsave), new 8(this), new 9(this));
        } else {
            bDy();
        }
    }

    private void bDy() {
        Intent intent = new Intent();
        intent.putExtra("Ktag_range_index", this.nXy);
        if (this.nXy == 2 || this.nXy == 3) {
            intent.putExtra("Klabel_name_list", this.nXv);
            intent.putExtra("Kother_user_name_list", this.nXw);
        }
        setResult(-1, intent);
        finish();
    }

    /* renamed from: bDz */
    final void l() {
        Intent intent = new Intent();
        if (this.nXx.nXR == 2) {
            this.nXv = bi.c(this.nXx.nXT, ",");
            this.nXw = bi.c(this.nXx.nXV, ",");
            intent.putExtra("Klabel_name_list", this.nXv);
            intent.putExtra("Kother_user_name_list", this.nXw);
        } else if (this.nXx.nXR == 3) {
            this.nXv = bi.c(this.nXx.nXU, ",");
            this.nXw = bi.c(this.nXx.nXW, ",");
            intent.putExtra("Klabel_name_list", this.nXv);
            intent.putExtra("Kother_user_name_list", this.nXw);
        }
        intent.putExtra("Ktag_range_index", this.nXx.nXR);
        setResult(-1, intent);
        finish();
    }

    protected void onDestroy() {
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(292, this);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(635, this);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(638, this);
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Eh().dpP.b(com.tencent.mm.plugin.appbrand.jsapi.audio.e.CTRL_INDEX, this);
        super.onDestroy();
    }

    public void onResume() {
        if (this.nXx != null && this.nXF == null) {
            this.nXu = (ArrayList) a.aYK().aYF();
            this.nXx.O(this.nXu);
            if ((this.nXu == null || this.nXu.size() == 0) && !((this.nXw != null && this.nXw.length() != 0) || this.nXx.nXR == 0 || this.nXx.nXR == 1)) {
                this.nXx.nXR = 0;
            }
            this.nXx.notifyDataSetChanged();
        }
        this.nXF = null;
        super.onResume();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r9, int r10, java.lang.String r11, com.tencent.mm.ab.l r12) {
        /*
        r8 = this;
        r0 = "MicroMsg.SnsLabelUI";
        r1 = "dz:[onSceneEnd]errType:%d errCode:%d errMsg:%s";
        r2 = 3;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = java.lang.Integer.valueOf(r9);
        r2[r3] = r4;
        r3 = 1;
        r4 = java.lang.Integer.valueOf(r10);
        r2[r3] = r4;
        r3 = 2;
        r2[r3] = r11;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = r8.nXB;
        if (r0 != 0) goto L_0x0022;
    L_0x0021:
        return;
    L_0x0022:
        r0 = r12.getType();
        switch(r0) {
            case 290: goto L_0x002a;
            case 292: goto L_0x0038;
            case 635: goto L_0x0142;
            case 638: goto L_0x015b;
            default: goto L_0x0029;
        };
    L_0x0029:
        goto L_0x0021;
    L_0x002a:
        if (r9 != 0) goto L_0x002e;
    L_0x002c:
        if (r10 == 0) goto L_0x0021;
    L_0x002e:
        r0 = "MicroMsg.SnsLabelUI";
        r1 = "dz: error at delete tag list!";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x0021;
    L_0x0038:
        if (r9 != 0) goto L_0x0135;
    L_0x003a:
        if (r10 != 0) goto L_0x0135;
    L_0x003c:
        r0 = com.tencent.mm.plugin.sns.model.af.byu();
        r2 = r0.getCursor();
        r0 = r2.getCount();
        r8.nXG = r0;
        r0 = r8.nXG;
        if (r0 <= 0) goto L_0x00f0;
    L_0x004e:
        r2.moveToFirst();
        r3 = new com.tencent.mm.plugin.sns.storage.t;
        r3.<init>();
        r0 = r2.getCount();
        r1 = new java.util.ArrayList;
        r1.<init>(r0);
        r8.nXI = r1;
        r1 = new java.util.ArrayList;
        r1.<init>(r0);
        r8.nXH = r1;
        r1 = new java.util.ArrayList;
        r1.<init>(r0);
        r8.nXK = r1;
        r1 = new java.util.ArrayList;
        r1.<init>(r0);
        r8.nXJ = r1;
    L_0x0076:
        r0 = r2.isAfterLast();
        if (r0 != 0) goto L_0x00e2;
    L_0x007c:
        r3.d(r2);
        r0 = r3.field_memberList;
        if (r0 == 0) goto L_0x00d8;
    L_0x0083:
        r0 = r3.field_memberList;
        r0 = r0.length();
        if (r0 == 0) goto L_0x00d8;
    L_0x008b:
        r0 = r8.nXK;
        r1 = r3.field_memberList;
        r4 = ",";
        r1 = r1.split(r4);
        r0.add(r1);
        r1 = r3.field_tagName;
        r4 = r8.nXI;
        r0 = com.tencent.mm.plugin.label.a.a.aYK();
        r0 = r0.aYH();
        if (r0 != 0) goto L_0x00bf;
    L_0x00a7:
        r0 = r1;
    L_0x00a8:
        r4.add(r0);
        r0 = r8.nXH;
        r0.add(r1);
        r0 = r8.nXJ;
        r4 = r3.field_tagId;
        r1 = java.lang.Long.valueOf(r4);
        r0.add(r1);
    L_0x00bb:
        r2.moveToNext();
        goto L_0x0076;
    L_0x00bf:
        r0 = r0.contains(r1);
        if (r0 != 0) goto L_0x00c7;
    L_0x00c5:
        r0 = r1;
        goto L_0x00a8;
    L_0x00c7:
        r0 = com.tencent.mm.plugin.sns.i.j.sns_label_from_tag_suffix;
        r0 = r8.getString(r0);
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r5[r6] = r1;
        r0 = java.lang.String.format(r0, r5);
        goto L_0x00a8;
    L_0x00d8:
        r0 = "MicroMsg.SnsLabelUI";
        r1 = "dz:snstaginfo memberlist is null.";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x00bb;
    L_0x00e2:
        r2.close();
        r0 = r8.nXH;
        r0 = r0.size();
        if (r0 != 0) goto L_0x012f;
    L_0x00ed:
        r0 = 0;
    L_0x00ee:
        if (r0 != 0) goto L_0x0117;
    L_0x00f0:
        r0 = r8.nXC;
        if (r0 == 0) goto L_0x0117;
    L_0x00f4:
        r0 = r8.nXx;
        r1 = r8.nXD;
        r0.nXR = r1;
        r0 = r8.nXs;
        r1 = r8.nXD;
        r0.Gw(r1);
        com.tencent.mm.kernel.g.Ek();
        r0 = com.tencent.mm.kernel.g.Ei();
        r0 = r0.DT();
        r1 = 335873; // 0x52001 float:4.70658E-40 double:1.659433E-318;
        r3 = 0;
        r3 = java.lang.Boolean.valueOf(r3);
        r0.set(r1, r3);
    L_0x0117:
        r2.close();
        r0 = r8.nXA;
        if (r0 == 0) goto L_0x0131;
    L_0x011e:
        r0 = 1;
        r8.nXB = r0;
        r0 = com.tencent.mm.plugin.label.a.a.aYK();
        r1 = r8.nXI;
        r0.bp(r1);
    L_0x012a:
        r0 = 0;
        r8.nXC = r0;
        goto L_0x0021;
    L_0x012f:
        r0 = 1;
        goto L_0x00ee;
    L_0x0131:
        r0 = 0;
        r8.nXB = r0;
        goto L_0x012a;
    L_0x0135:
        r8.bDB();
        r0 = "MicroMsg.SnsLabelUI";
        r1 = "dz: error at get sns tag list!";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x012a;
    L_0x0142:
        if (r9 != 0) goto L_0x014d;
    L_0x0144:
        if (r10 != 0) goto L_0x014d;
    L_0x0146:
        r0 = r8.nXK;
        r8.cs(r0);
        goto L_0x0021;
    L_0x014d:
        r8.bDB();
        r0 = "MicroMsg.SnsLabelUI";
        r1 = "dz: error at add contact label!";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x0021;
    L_0x015b:
        if (r9 != 0) goto L_0x020c;
    L_0x015d:
        if (r10 != 0) goto L_0x020c;
    L_0x015f:
        r0 = r8.nXH;
        r1 = r0.iterator();
        r0 = r8.nXJ;
        r2 = r0.iterator();
    L_0x016b:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x019a;
    L_0x0171:
        r0 = r2.next();
        r0 = (java.lang.Long) r0;
        r4 = r0.longValue();
        r0 = r1.next();
        r0 = (java.lang.String) r0;
        r6 = 0;
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 == 0) goto L_0x016b;
    L_0x0187:
        com.tencent.mm.kernel.g.Ek();
        r3 = com.tencent.mm.kernel.g.Eh();
        r3 = r3.dpP;
        r6 = new com.tencent.mm.plugin.sns.model.x;
        r6.<init>(r4, r0);
        r0 = 0;
        r3.a(r6, r0);
        goto L_0x016b;
    L_0x019a:
        com.tencent.mm.kernel.g.Ek();
        r0 = com.tencent.mm.kernel.g.Ei();
        r0 = r0.DT();
        r1 = 335874; // 0x52002 float:4.7066E-40 double:1.65944E-318;
        r2 = 0;
        r2 = java.lang.Integer.valueOf(r2);
        r0.set(r1, r2);
        r0 = com.tencent.mm.plugin.label.a.a.aYK();
        r0 = r0.aYF();
        r0 = (java.util.ArrayList) r0;
        r8.nXu = r0;
        r0 = com.tencent.mm.plugin.report.service.h.mEJ;
        r1 = 11455; // 0x2cbf float:1.6052E-41 double:5.6595E-320;
        r2 = 4;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = "";
        r2[r3] = r4;
        r3 = 1;
        r4 = "";
        r2[r3] = r4;
        r3 = 2;
        r4 = r8.nXG;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 3;
        r4 = r8.nXI;
        r4 = r4.size();
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.h(r1, r2);
        r0 = r8.nXs;
        r1 = new com.tencent.mm.plugin.sns.ui.SnsLabelUI$10;
        r1.<init>(r8);
        r2 = 600; // 0x258 float:8.41E-43 double:2.964E-321;
        r0.postDelayed(r1, r2);
        com.tencent.mm.kernel.g.Ek();
        r0 = com.tencent.mm.kernel.g.Ei();
        r0 = r0.DT();
        r1 = 335873; // 0x52001 float:4.70658E-40 double:1.659433E-318;
        r2 = 0;
        r2 = java.lang.Boolean.valueOf(r2);
        r0.set(r1, r2);
        goto L_0x0021;
    L_0x020c:
        r8.bDB();
        r0 = "MicroMsg.SnsLabelUI";
        r1 = "dz: error at modify label list!";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.SnsLabelUI.a(int, int, java.lang.String, com.tencent.mm.ab.l):void");
    }

    private static int bDA() {
        com.tencent.mm.kernel.g.Ek();
        return ((Integer) com.tencent.mm.kernel.g.Ei().DT().get(335874, Integer.valueOf(0))).intValue();
    }

    private void bDB() {
        com.tencent.mm.plugin.report.service.h.mEJ.h(11455, new Object[]{"", "", Integer.valueOf(this.nXG), Integer.valueOf(0)});
        com.tencent.mm.kernel.g.Ek();
        int intValue = ((Integer) com.tencent.mm.kernel.g.Ei().DT().get(335874, Integer.valueOf(0))).intValue() + 1;
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Ei().DT().set(335874, Integer.valueOf(intValue));
        this.nXI = null;
        this.nXC = false;
        this.nXB = false;
        if (this.nXE != null && this.nXE.isShowing()) {
            this.nXE.dismiss();
        }
        if (this.nXA) {
            this.nXA = false;
            return;
        }
        intValue = j.sns_label_transform_failed_once;
        if (bDA() > 1) {
            intValue = j.sns_label_transform_failed_again;
        }
        h.a((Context) this, intValue, j.app_ok, new 2(this));
    }

    private void cs(List<String[]> list) {
        if (this.nXI != null && this.nXI.size() != 0) {
            Iterator it = this.nXI.iterator();
            Iterator it2 = list.iterator();
            List arrayList = new ArrayList(this.nXI.size());
            List arrayList2 = new ArrayList(this.nXI.size());
            while (it.hasNext()) {
                arrayList.add(a.aYK().FA((String) it.next()));
                arrayList2.add(bi.c(Arrays.asList((Object[]) it2.next()), ","));
                this.nXB = true;
            }
            a.aYK().g(arrayList, arrayList2);
        }
    }
}
