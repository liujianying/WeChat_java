package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.aft;
import com.tencent.mm.protocal.c.biy;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.f;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.f$a;
import com.tencent.mm.ui.voicesearch.b;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.x;
import java.util.LinkedList;
import java.util.List;

public class OpenIMAddressUI$a extends x implements e {
    private ProgressDialog eHw = null;
    List<String> gRN = new LinkedList();
    d hLH = new d(new 4(this));
    private int hpr;
    private int hps;
    private com.tencent.mm.ui.widget.e hpv;
    private n.d iEm = new n.d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 1:
                case 2:
                    OpenIMAddressUI$a.a(OpenIMAddressUI$a.this, OpenIMAddressUI$a.this.uhj);
                    return;
                case 7:
                    OpenIMAddressUI$a.c(OpenIMAddressUI$a.this, OpenIMAddressUI$a.this.uhj);
                    return;
                default:
                    return;
            }
        }
    };
    private ListView kBy;
    List<String> uhC = new LinkedList();
    private b uhh;
    private String uhj = "";
    boolean uhx;
    private boolean uhy = true;
    private String ukY = "";
    private t ukZ;
    private Runnable ula = new 18(this);

    static /* synthetic */ void c(OpenIMAddressUI$a openIMAddressUI$a, String str) {
        au.HU();
        ab Yg = c.FR().Yg(str);
        if (a.gd(Yg.field_type)) {
            Intent intent = new Intent();
            intent.setClass(openIMAddressUI$a.getContext(), ContactRemarkInfoModUI.class);
            intent.putExtra("Contact_User", Yg.field_username);
            intent.putExtra("view_mode", true);
            openIMAddressUI$a.getContext().startActivity(intent);
        }
    }

    static /* synthetic */ void i(OpenIMAddressUI$a openIMAddressUI$a) {
        BackwardSupportUtil.c.a(openIMAddressUI$a.kBy);
        new ag().postDelayed(new 2(openIMAddressUI$a), 300);
    }

    public OpenIMAddressUI$a() {
        super(true);
    }

    protected final int getLayoutId() {
        return R.i.openim_address;
    }

    protected final View getLayoutView() {
        return com.tencent.mm.kiss.a.b.EY().a(getContext(), "R.layout.openim_address", R.i.openim_address);
    }

    public final boolean supportNavigationSwipeBack() {
        return false;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        au.HU();
        ab Yg = c.FR().Yg(this.uhj);
        if (Yg == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.OpenIMAddressUI", "onCreateContextMenu, contact is null, username = " + this.uhj);
        } else if (!q.GF().equals(Yg.field_username)) {
            if (s.hc(this.uhj)) {
                contextMenu.setHeaderTitle(j.a(view.getContext(), Yg.BL()));
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.l.address_delgroupcard);
            } else if (!s.hr(this.uhj) && !s.hH(this.uhj)) {
                contextMenu.setHeaderTitle(j.a(view.getContext(), Yg.BL()));
                if (a.gd(Yg.field_type) && Yg.field_deleteFlag != 1) {
                    contextMenu.add(adapterContextMenuInfo.position, 7, 0, R.l.contact_info_mod_remark_labelinfo);
                }
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() != 453) {
            if (this.eHw != null) {
                this.eHw.dismiss();
                this.eHw = null;
            }
            if (!ai.ci(getContext()) || w.a.a(getContext(), i, i2, str, 4) || i != 0 || i2 != 0) {
            }
        } else if (i == 0 && i2 == 0 && !((aft) ((com.tencent.mm.openim.b.c) lVar).diG.dIE.dIL).rJF.isEmpty()) {
            cya();
        }
    }

    private void cxZ() {
        this.gRN = new LinkedList();
        this.uhC = new LinkedList();
        com.tencent.mm.bg.d.cfH();
        this.gRN.add("tmessage");
        this.uhC.addAll(this.gRN);
        if (!this.gRN.contains("officialaccounts")) {
            this.gRN.add("officialaccounts");
        }
        this.gRN.add("helper_entry");
        if (this.ukZ != null) {
            this.ukZ.dQ(this.gRN);
        }
        if (this.uhh != null) {
            this.uhh.dQ(this.uhC);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.OpenIMAddressUI", "onAcvityResult requestCode: %d", new Object[]{Integer.valueOf(i)});
        if (i == 6 && i2 == -1) {
            setResult(-1);
            finish();
        } else if (i2 == -1) {
            switch (i) {
                case 4:
                    setResult(-1, intent);
                    finish();
                    return;
                default:
                    return;
            }
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.OpenIMAddressUI", "on address ui create");
        au.DF().a(138, this);
        g.Ek();
        g.Eh().dpP.a(453, this);
        this.ukY = getStringExtra("key_openim_acctype_id");
        setMMTitle(((com.tencent.mm.openim.a.b) g.l(com.tencent.mm.openim.a.b.class)).h(this.ukY, "openim_acct_type_title", com.tencent.mm.openim.a.b.a.eui));
        setBackBtn(new 1(this));
        setTitleBarDoubleClickListener(this.ula);
        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.OpenIMAddressUI", "on address ui init view, %s", new Object[]{getResources().getDisplayMetrics()});
        this.kBy = (ListView) findViewById(R.h.address_contactlist);
        this.kBy.setScrollingCacheEnabled(false);
        this.ukZ = new t(getContext(), "@openim.contact", this.ukY);
        this.ukZ.a(new f$a() {
            public final void Xb() {
                OpenIMAddressUI$a openIMAddressUI$a = OpenIMAddressUI$a.this;
                OpenIMAddressUI$a.this.ukZ.getCount();
                openIMAddressUI$a.kBy.setVisibility(0);
                OpenIMAddressUI$a.this.ukZ.cxW();
            }

            public final void Xa() {
            }
        });
        this.ukZ.ugS = true;
        this.ukZ.ule = this;
        this.ukZ.setGetViewPositionCallback(new 12(this));
        this.ukZ.setPerformItemClickListener(new MMSlideDelView.g() {
            public final void t(View view, int i) {
                OpenIMAddressUI$a.this.kBy.performItemClick(view, i, 0);
            }
        });
        this.ukZ.a(new 14(this));
        this.uhh = new b(getContext(), 1);
        this.uhh.mA(true);
        this.hpv = new com.tencent.mm.ui.widget.e(getContext());
        this.kBy.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Object d;
                String str = "MicroMsg.OpenIMAddressUI";
                StringBuilder append = new StringBuilder("onItemClick ").append(i);
                if (OpenIMAddressUI$a.this.uhh == null) {
                    d = OpenIMAddressUI$a.this.uhh;
                } else {
                    d = Boolean.valueOf(OpenIMAddressUI$a.this.uhh.uFK);
                }
                com.tencent.mm.sdk.platformtools.x.i(str, append.append(d).toString());
                int headerViewsCount = i - OpenIMAddressUI$a.this.kBy.getHeaderViewsCount();
                String str2;
                if (OpenIMAddressUI$a.this.uhh == null || !OpenIMAddressUI$a.this.uhh.uFK) {
                    f fVar = (f) OpenIMAddressUI$a.this.ukZ.Dy(headerViewsCount);
                    if (fVar != null) {
                        str2 = fVar.field_username;
                        OpenIMAddressUI$a openIMAddressUI$a = OpenIMAddressUI$a.this;
                        if (str2 != null && str2.length() > 0) {
                            if (s.hE(str2)) {
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.OpenIMAddressUI", "error, 4.5 do not contain this contact %s", new Object[]{str2});
                                return;
                            }
                            Intent intent = new Intent();
                            intent.putExtra("Contact_User", str2);
                            if (s.hc(str2)) {
                                intent.putExtra("Is_group_card", true);
                            }
                            if (str2 != null && str2.length() > 0) {
                                e.a(intent, str2);
                                com.tencent.mm.bg.d.b(openIMAddressUI$a.getContext(), "profile", ".ui.ContactInfoUI", intent);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                boolean qY = OpenIMAddressUI$a.this.uhh.qY(headerViewsCount);
                boolean Gl = OpenIMAddressUI$a.this.uhh.Gl(headerViewsCount);
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.OpenIMAddressUI", "onItemClick " + Gl);
                Intent intent2;
                if (Gl) {
                    OpenIMAddressUI$a.this.uhh.abn("");
                } else if (qY) {
                    biy Gk = OpenIMAddressUI$a.this.uhh.Gk(headerViewsCount);
                    String str3 = Gk.rvi.siM;
                    au.HU();
                    ab Yg = c.FR().Yg(str3);
                    if (a.gd(Yg.field_type)) {
                        intent2 = new Intent();
                        intent2.putExtra("Contact_User", str3);
                        intent2.putExtra("Contact_Scene", 3);
                        if (str3 != null && str3.length() > 0) {
                            if (Yg.ckW()) {
                                h.mEJ.k(10298, str3 + ",3");
                            }
                            e.a(intent2, str3);
                            com.tencent.mm.bg.d.b(OpenIMAddressUI$a.this.getContext(), "profile", ".ui.ContactInfoUI", intent2);
                            return;
                        }
                        return;
                    }
                    Intent intent3 = new Intent();
                    intent3.putExtra("Contact_User", Gk.rvi.siM);
                    intent3.putExtra("Contact_Alias", Gk.eJM);
                    intent3.putExtra("Contact_Nick", Gk.rQz.siM);
                    intent3.putExtra("Contact_Signature", Gk.eJK);
                    intent3.putExtra("Contact_RegionCode", RegionCodeDecoder.aq(Gk.eJQ, Gk.eJI, Gk.eJJ));
                    intent3.putExtra("Contact_Sex", Gk.eJH);
                    intent3.putExtra("Contact_VUser_Info", Gk.rTf);
                    intent3.putExtra("Contact_VUser_Info_Flag", Gk.rTe);
                    intent3.putExtra("Contact_KWeibo_flag", Gk.rTi);
                    intent3.putExtra("Contact_KWeibo", Gk.rTg);
                    intent3.putExtra("Contact_KWeiboNick", Gk.rTh);
                    intent3.putExtra("Contact_KSnsIFlag", Gk.rTk.eJS);
                    intent3.putExtra("Contact_KSnsBgId", Gk.rTk.eJU);
                    intent3.putExtra("Contact_KSnsBgUrl", Gk.rTk.eJT);
                    if (Gk.rTl != null) {
                        try {
                            intent3.putExtra("Contact_customInfo", Gk.rTl.toByteArray());
                        } catch (Throwable e) {
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.OpenIMAddressUI", e, "", new Object[0]);
                        }
                    }
                    if ((Gk.rTe & 8) > 0) {
                        h.mEJ.k(10298, str3 + ",3");
                    }
                    com.tencent.mm.bg.d.b(OpenIMAddressUI$a.this.getContext(), "profile", ".ui.ContactInfoUI", intent3);
                } else {
                    ab oj = OpenIMAddressUI$a.this.uhh.oj(headerViewsCount);
                    if (oj == null) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.OpenIMAddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[]{Integer.valueOf(OpenIMAddressUI$a.this.uhh.getCount()), Integer.valueOf(headerViewsCount)});
                        return;
                    }
                    str2 = oj.field_username;
                    if (s.hE(str2)) {
                        Intent intent4 = new Intent(OpenIMAddressUI$a.this.getContext(), OpenIMAddressUI.class);
                        intent4.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                        OpenIMAddressUI$a.this.startActivity(intent4);
                        return;
                    }
                    intent2 = new Intent();
                    intent2.putExtra("Contact_User", str2);
                    intent2.putExtra("Contact_Scene", 3);
                    if (str2 != null && str2.length() > 0) {
                        com.tencent.mm.bg.d.b(OpenIMAddressUI$a.this.getContext(), "profile", ".ui.ContactInfoUI", intent2);
                    }
                }
            }
        });
        this.kBy.setOnItemLongClickListener(new 16(this));
        this.kBy.setOnTouchListener(new 17(this));
        this.kBy.setOnScrollListener(this.hLH);
        this.kBy.setDrawingCacheEnabled(false);
        au.HU();
        c.FR().a(this.ukZ);
    }

    public final void onResume() {
        super.onResume();
        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.OpenIMAddressUI", "address ui on resume");
        if (this.uhy) {
            this.uhy = false;
            this.uhx = false;
            cxZ();
            this.kBy.setAdapter(this.ukZ);
            this.kBy.post(new 7(this));
            this.uhh.mz(false);
        } else if (this.uhx) {
            this.uhx = false;
            com.tencent.mm.sdk.f.e.b(new Runnable() {
                public final void run() {
                    Process.setThreadPriority(10);
                    OpenIMAddressUI$a.this.cya();
                }
            }, "AddressUI_updateUIData", 4);
        }
        if (this.uhh != null) {
            this.uhh.onResume();
        }
        this.ukZ.thH = false;
        ah.A(new 9(this));
    }

    private synchronized void cya() {
        long currentTimeMillis = System.currentTimeMillis();
        cxZ();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.OpenIMAddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        if (this.ukZ != null) {
            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.OpenIMAddressUI", "post to do refresh");
            ah.A(new 5(this));
        }
        if (this.uhh != null) {
            ah.A(new 6(this));
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.OpenIMAddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public final void onPause() {
        super.onPause();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.OpenIMAddressUI", "AddressUI on Pause");
        if (this.uhh != null) {
            this.uhh.onPause();
        }
        this.ukZ.cxX();
        ah.A(new 10(this));
    }

    public final void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.platformtools.x.v("MicroMsg.OpenIMAddressUI", "onDestory");
        au.DF().b(138, this);
        g.Ek();
        g.Eh().dpP.b(453, this);
        if (this.ukZ != null) {
            this.ukZ.lv(true);
            this.ukZ.detach();
            this.ukZ.coT();
        }
        if (this.uhh != null) {
            this.uhh.detach();
            this.uhh.aYc();
        }
        if (au.HX() && this.ukZ != null) {
            au.HU();
            c.FR().b(this.ukZ);
        }
    }
}
