package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.z;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.AbstractTabChildActivity.a;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.voicesearch.b;
import com.tencent.mm.ui.w;
import java.util.LinkedList;
import java.util.List;

public class AddressUI$a extends a implements e {
    private ProgressDialog eHw = null;
    private TextView eIR;
    private boolean eMT = false;
    private final long ell = 180000;
    List<String> gRN = new LinkedList();
    d hLH = new d(new 8(this));
    private int hpr;
    private int hps;
    private com.tencent.mm.ui.widget.b.a hql;
    private n.d iEm = new n.d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 1:
                case 2:
                    AddressUI$a.a(AddressUI$a.this, AddressUI$a.this.uhj);
                    return;
                case 7:
                    AddressUI$a.c(AddressUI$a.this, AddressUI$a.this.uhj);
                    return;
                default:
                    return;
            }
        }
    };
    private Animation iPp;
    private ListView kBy;
    private String ugF;
    private String ugG;
    private Animation uhA;
    private VerticalScrollBar.a uhB = new 7(this);
    List<String> uhC = new LinkedList();
    private Runnable uhD = new 15(this);
    private TextView uhe;
    private TextView uhf;
    private a uhg;
    private b uhh;
    private String uhi;
    private String uhj = "";
    private int uhk;
    private AlphabetScrollBar uhl;
    private LinearLayout uhm = null;
    private boolean uhn = false;
    private boolean uho = false;
    private k uhp;
    private BizContactEntranceView uhq;
    private b uhr;
    private b uhs;
    private b uht;
    private ContactCountView uhu;
    private u uhv;
    private i uhw;
    boolean uhx;
    private boolean uhy = true;
    private LinearLayout uhz;

    static /* synthetic */ void b(AddressUI$a addressUI$a) {
        addressUI$a.uhe.setVisibility(8);
        addressUI$a.kBy.setVisibility(0);
    }

    static /* synthetic */ void c(AddressUI$a addressUI$a, String str) {
        au.HU();
        ab Yg = c.FR().Yg(str);
        if (com.tencent.mm.l.a.gd(Yg.field_type)) {
            Intent intent = new Intent();
            intent.setClass(addressUI$a.getContext(), ContactRemarkInfoModUI.class);
            intent.putExtra("Contact_User", Yg.field_username);
            intent.putExtra("view_mode", true);
            addressUI$a.getContext().startActivity(intent);
        }
    }

    static /* synthetic */ void q(AddressUI$a addressUI$a) {
        LauncherUI launcherUI = (LauncherUI) addressUI$a.getContext();
        if (launcherUI == null || launcherUI.tkn.tjF.iUy == 1) {
            BackwardSupportUtil.c.a(addressUI$a.kBy);
            new ag().postDelayed(new 5(addressUI$a), 300);
        }
    }

    protected int getLayoutId() {
        return R.i.address;
    }

    protected View getLayoutView() {
        return com.tencent.mm.kiss.a.b.EY().a(getContext(), "R.layout.address", R.i.address);
    }

    public boolean supportNavigationSwipeBack() {
        return false;
    }

    public boolean noActionBar() {
        return true;
    }

    public final void mg(boolean z) {
        if (this.uhl != null) {
            if (this.iPp == null) {
                this.iPp = AnimationUtils.loadAnimation(getContext(), R.a.faded_in);
                this.iPp.setDuration(200);
            }
            if (this.uhA == null) {
                this.uhA = AnimationUtils.loadAnimation(getContext(), R.a.faded_in);
                this.uhA.setDuration(200);
            }
            if (z) {
                if (this.uhl.getVisibility() != 0) {
                    this.uhl.setVisibility(0);
                    this.uhl.startAnimation(this.iPp);
                }
            } else if (4 != this.uhl.getVisibility()) {
                this.uhl.setVisibility(8);
                this.uhl.startAnimation(this.uhA);
            }
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        au.HU();
        ab Yg = c.FR().Yg(this.uhj);
        if (Yg == null) {
            x.e("MicroMsg.AddressUI", "onCreateContextMenu, contact is null, username = " + this.uhj);
        } else if (!q.GF().equals(Yg.field_username)) {
            if (s.hc(this.uhj)) {
                contextMenu.setHeaderTitle(j.a(view.getContext(), Yg.BL()));
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.l.address_delgroupcard);
            } else if (!s.hr(this.uhj) && !s.hH(this.uhj)) {
                contextMenu.setHeaderTitle(j.a(view.getContext(), Yg.BL()));
                if (com.tencent.mm.l.a.gd(Yg.field_type) && Yg.field_deleteFlag != 1) {
                    contextMenu.add(adapterContextMenuInfo.position, 7, 0, R.l.contact_info_mod_remark_labelinfo);
                }
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (!ai.ci(getContext()) || w.a.a(getContext(), i, i2, str, 4) || i != 0 || i2 == 0) {
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
        if (this.uhg != null) {
            this.uhg.dQ(this.gRN);
        }
        if (this.uhh != null) {
            this.uhh.dQ(this.uhC);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.AddressUI", "onAcvityResult requestCode: %d", new Object[]{Integer.valueOf(i)});
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

    protected final void coy() {
        x.v("MicroMsg.AddressUI", "address ui on create");
        x.v("MicroMsg.AddressUI", "on address ui create");
        this.uhn = false;
        this.eMT = false;
        this.uho = false;
        this.ugF = null;
        this.ugG = null;
        this.uhi = null;
        au.DF().a(138, this);
        this.ugF = "@all.contact.without.chatroom";
        this.ugG = getStringExtra("Contact_GroupFilter_Str");
        this.uhi = getString(R.l.group_weixin);
        this.uhk = getIntExtra("List_Type", 2);
        x.v("MicroMsg.AddressUI", "on address ui init view, %s", new Object[]{getResources().getDisplayMetrics()});
        if (this.kBy != null) {
            if (this.uhp != null) {
                this.kBy.removeHeaderView(this.uhp);
            }
            if (this.uhq != null) {
                this.kBy.removeHeaderView(this.uhq);
            }
            if (this.uhr != null) {
                this.kBy.removeHeaderView(this.uhr);
            }
            if (this.uht != null) {
                this.kBy.removeHeaderView(this.uht);
            }
        }
        this.kBy = (ListView) findViewById(R.h.address_contactlist);
        this.kBy.setScrollingCacheEnabled(false);
        this.uhe = (TextView) findViewById(R.h.empty_blacklist_tip_tv);
        this.uhe.setText(R.l.address_empty_blacklist_tip);
        this.eIR = (TextView) findViewById(R.h.empty_voicesearch_tip_tv);
        this.eIR.setText(R.l.address_empty_voicesearch_tip);
        this.uhf = (TextView) findViewById(R.h.enter_search_tips_tv);
        this.uhf.setOnClickListener(new 1(this));
        this.uhg = new a(getContext(), this.ugF, this.ugG, this.uhk);
        this.kBy.setAdapter(null);
        this.uhg.a(new 12(this));
        this.uhg.ugS = true;
        this.uhg.l(this);
        this.uhg.setGetViewPositionCallback(new 17(this));
        this.uhg.setPerformItemClickListener(new 18(this));
        this.uhg.a(new f() {
            public final void bv(Object obj) {
                if (obj == null) {
                    x.e("MicroMsg.AddressUI", "onItemDel object null");
                } else {
                    AddressUI$a.a(AddressUI$a.this, obj.toString());
                }
            }
        });
        this.uhh = new b(getContext(), 1);
        this.uhh.mA(true);
        this.uhz = new LinearLayout(getContext());
        this.uhz.setOrientation(1);
        this.kBy.addHeaderView(this.uhz);
        this.uhs = new b(getContext(), b.a.uhK);
        this.uhz.addView(this.uhs);
        au.HU();
        ((Boolean) c.DT().get(aa.a.sRf, Boolean.valueOf(false))).booleanValue();
        this.uhs.setVisible(false);
        this.uhp = new k(getContext());
        this.uhz.addView(this.uhp);
        this.uhr = new b(getContext(), b.a.uhI);
        this.uhz.addView(this.uhr);
        this.uhr.setVisible(true);
        this.uht = new b(getContext(), b.a.uhJ);
        this.uhz.addView(this.uht);
        this.uht.setVisible(true);
        ListView listView = this.kBy;
        ContactCountView contactCountView = new ContactCountView(getContext());
        this.uhu = contactCountView;
        listView.addFooterView(contactCountView, null, false);
        if (com.tencent.mm.bg.d.QS("brandservice")) {
            this.uhq = new BizContactEntranceView(getContext());
            this.uhz.addView(this.uhq);
            this.uhq.setVisible(true);
        }
        20 20 = new 20(this);
        this.uhv = new u(getContext(), new u$a() {
        });
        this.uhv.setOnVisibilityChangeListener(20);
        if (this.uhv.getOpenIMCount() <= 0) {
            20.mh(false);
            this.uhv.setVisibility(8);
        } else {
            20.mh(true);
        }
        this.uhz.addView(this.uhv);
        if (com.tencent.mm.bg.d.QS("brandservice")) {
            this.uhw = new i(getContext(), new i$a() {
                public final void FL(int i) {
                    if (AddressUI$a.this.uhw != null) {
                        if (i <= 0) {
                            AddressUI$a.this.uhw.setVisibility(8);
                        } else {
                            AddressUI$a.this.uhw.setVisibility(0);
                        }
                    }
                }
            });
            if (this.uhw.getEnterpriseFriendCount() <= 0) {
                this.uhw.setVisibility(8);
            }
            this.uhz.addView(this.uhw);
        }
        this.hql = new com.tencent.mm.ui.widget.b.a(getContext());
        this.uhg.ugQ = new a.a() {
        };
        this.kBy.setOnItemClickListener(new 2(this));
        this.kBy.setOnItemLongClickListener(new 3(this));
        this.kBy.setOnTouchListener(new 4(this));
        this.kBy.setOnScrollListener(this.hLH);
        this.kBy.setDrawingCacheEnabled(false);
        this.uhl = (AlphabetScrollBar) findViewById(R.h.address_scrollbar);
        this.uhl.setOnScrollBarTouchListener(this.uhB);
        au.HU();
        c.FR().a(this.uhg);
        if (this.uhw != null) {
            z.MY().a(this.uhw, null);
        }
    }

    protected final void coz() {
        x.v("MicroMsg.AddressUI", "address ui on resume");
        long currentTimeMillis = System.currentTimeMillis();
        au.HU();
        if (currentTimeMillis - ai.d((Long) c.DT().get(340226, null)) >= 180000) {
            cyb();
        }
        if (this.uhy) {
            this.uhy = false;
            this.uhx = false;
            cxZ();
            this.kBy.setAdapter(this.uhg);
            this.kBy.post(new 11(this));
            this.uhh.mz(false);
        } else if (this.uhx) {
            this.uhx = false;
            com.tencent.mm.sdk.f.e.b(new 13(this), "AddressUI_updateUIData", 4);
            this.uhu.cyd();
        }
        if (this.uhq != null) {
            BizContactEntranceView bizContactEntranceView = this.uhq;
            bizContactEntranceView.cyc();
            bizContactEntranceView.setVisible(true);
        }
        if (this.uhw != null) {
            if (this.uhw.getEnterpriseFriendCount() <= 0) {
                this.uhw.setVisibility(8);
            } else {
                this.uhw.setVisibility(0);
            }
        }
        au.HU();
        this.uhn = ((Boolean) c.DT().get(12296, Boolean.valueOf(false))).booleanValue();
        if (this.uhk == 2) {
            au.HU();
            ab Yg = c.FR().Yg(q.GF());
            if (!(Yg == null || (com.tencent.mm.l.a.gd(Yg.field_type) && ai.oW(Yg.field_conRemark) && ai.oW(Yg.field_conRemarkPYFull) && ai.oW(Yg.field_conRemarkPYShort)))) {
                Yg.Bb();
                Yg.dv("");
                Yg.dB("");
                Yg.dC("");
                au.HU();
                c.FR().a(q.GF(), Yg);
            }
        }
        if (this.uhh != null) {
            this.uhh.onResume();
        }
        this.uhg.thH = false;
        ah.A(new 14(this));
        if (this.uhp != null) {
            this.uhp.setFrontGround(true);
            k.cyl();
        }
        LauncherUI launcherUI = (LauncherUI) getContext();
        if (launcherUI != null) {
            launcherUI.tkn.setTitleBarDoubleClickListener(this.uhD);
        }
    }

    private synchronized void cya() {
        long currentTimeMillis = System.currentTimeMillis();
        cxZ();
        x.i("MicroMsg.AddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        if (this.uhg != null) {
            x.v("MicroMsg.AddressUI", "post to do refresh");
            ah.A(new 9(this));
        }
        if (this.uhh != null) {
            ah.A(new 10(this));
        }
        x.i("MicroMsg.AddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - currentTimeMillis));
    }

    protected final void coA() {
    }

    protected final void coB() {
        x.i("MicroMsg.AddressUI", "AddressUI on Pause");
        au.HU();
        c.DT().set(340226, Long.valueOf(System.currentTimeMillis()));
        au.HU();
        c.DT().set(12296, Boolean.valueOf(this.uhn));
        if (this.uhh != null) {
            this.uhh.onPause();
        }
        this.uhg.cxX();
        ah.A(new 16(this));
        if (this.uhp != null) {
            this.uhp.setFrontGround(false);
        }
        LauncherUI launcherUI = (LauncherUI) getContext();
        if (launcherUI != null) {
            launcherUI.tkn.ac(this.uhD);
        }
    }

    protected final void coC() {
    }

    protected final void coD() {
        x.v("MicroMsg.AddressUI", "onDestory");
        if (this.uhl != null) {
            this.uhl.tBm = null;
        }
        au.DF().b(138, this);
        if (this.uhg != null) {
            this.uhg.lv(true);
            this.uhg.detach();
            this.uhg.coT();
        }
        if (this.uhh != null) {
            this.uhh.detach();
            this.uhh.aYc();
        }
        if (au.HX() && this.uhg != null) {
            au.HU();
            c.FR().b(this.uhg);
        }
        if (au.HX() && this.uhw != null) {
            z.MY().a(this.uhw);
        }
        if (this.uhp != null) {
            k kVar = this.uhp;
            if (au.HX()) {
                com.tencent.mm.az.d.SF().d(kVar.ujA);
            }
            this.uhp = null;
        }
        if (this.uhq != null) {
            this.uhq = null;
        }
        if (this.uhr != null) {
            this.uhr = null;
        }
        if (this.uht != null) {
            this.uht = null;
        }
    }

    public final void coF() {
        if (this.uhg != null) {
            a aVar = this.uhg;
            aVar.ugW.clear();
            aVar.ugU.clear();
            aVar.ugV = false;
        }
        x.i("MicroMsg.INIT", "KEVIN Address turnTobg");
        if (this.uhq != null) {
            this.uhq.destroyDrawingCache();
        }
        if (this.uhr != null) {
            this.uhr.destroyDrawingCache();
        }
        if (this.uht != null) {
            this.uht.destroyDrawingCache();
        }
        if (this.uhu != null) {
            this.uhu.destroyDrawingCache();
        }
        if (this.uhp != null) {
            this.uhp.destroyDrawingCache();
        }
    }

    public final void coG() {
        x.v("MicroMsg.INIT", "KEVIN Address turnTofg");
    }

    public final void coE() {
        x.v("MicroMsg.AddressUI", "request to top");
        if (this.kBy != null) {
            BackwardSupportUtil.c.a(this.kBy);
        }
    }

    public final void cpr() {
        if (this.uhp != null) {
            k.cyl();
        }
    }

    public final void cps() {
    }

    public final void cyb() {
        if (this.kBy != null) {
            this.kBy.setSelection(0);
        }
    }
}
