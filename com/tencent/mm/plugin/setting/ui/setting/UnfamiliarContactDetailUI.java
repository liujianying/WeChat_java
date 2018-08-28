package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$a;
import android.support.v7.widget.RecyclerView.t;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.setting.a.d;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.plugin.setting.model.l;
import com.tencent.mm.plugin.setting.model.l.1;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.RealAlphabetScrollBar;
import com.tencent.mm.ui.base.p;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UnfamiliarContactDetailUI extends MMActivity implements e {
    public static final String hPy = new String(Character.toChars(TbsListener$ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED));
    private p fUo = null;
    private ArrayList<b> fXG = new ArrayList();
    private boolean mOS;
    private boolean mOT;
    private boolean mOU;
    private RecyclerView mUD;
    private TextView mUE;
    private View mUF;
    private View mUG;
    private View mUH;
    private TextView mUI;
    private a mUJ;
    private RealAlphabetScrollBar mUK;
    HashMap<String, Integer> mUL = new HashMap();
    private HashMap<Integer, String> mUM = new HashMap();
    private HashSet<Integer> mUN = new HashSet();
    private d mUO;
    private int mUP = -1;
    private HashSet<String> mUQ = new HashSet();
    private l mUR;
    private boolean mUS;
    private View mhD;

    public interface h {
        void a(e eVar);

        void e(HashSet hashSet);

        void onError();

        void onSuccess();
    }

    class a extends RecyclerView$a {
        a() {
        }

        public final t a(ViewGroup viewGroup, int i) {
            return new c(UnfamiliarContactDetailUI.this, LayoutInflater.from(viewGroup.getContext()).inflate(g.unfamiliar_contact_item_layout, viewGroup, false));
        }

        public final void a(t tVar, int i) {
            if (tVar instanceof c) {
                int i2;
                c cVar = (c) tVar;
                cVar.mVe.setTag(Integer.valueOf(i));
                cVar.SU.setTag(Integer.valueOf(i));
                b bVar = (b) UnfamiliarContactDetailUI.this.fXG.get(i);
                b.a((ImageView) cVar.hPe.getContentView(), bVar.guS.field_username);
                cVar.mVa.setText(j.a(UnfamiliarContactDetailUI.this.mController.tml, bVar.daA, cVar.mVa.getTextSize()));
                cVar.mVd.setVisibility(bVar.guS.BF() ? 0 : 8);
                ImageView imageView = cVar.mVc;
                String str = bVar.guS.field_username;
                if (n.nkA != null && UnfamiliarContactDetailUI.this.mUQ.size() == 0) {
                    UnfamiliarContactDetailUI.this.mUQ.addAll(n.nkA.eD(5));
                }
                if (UnfamiliarContactDetailUI.this.mUQ.contains(str)) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
                if (UnfamiliarContactDetailUI.this.mUM.containsKey(Integer.valueOf(i))) {
                    cVar.mVb.setVisibility(0);
                    cVar.mVb.setText((CharSequence) UnfamiliarContactDetailUI.this.mUM.get(Integer.valueOf(i)));
                } else {
                    cVar.mVb.setVisibility(8);
                }
                if (UnfamiliarContactDetailUI.this.mUS) {
                    cVar.mVf.setPadding(cVar.mVf.getPaddingLeft(), cVar.mVf.getPaddingTop(), 0, cVar.mVf.getPaddingBottom());
                    if (UnfamiliarContactDetailUI.this.mUN.contains(Integer.valueOf(i))) {
                        cVar.jBR.setChecked(true);
                    } else {
                        cVar.jBR.setChecked(false);
                    }
                    cVar.mVe.setVisibility(0);
                    return;
                }
                cVar.mVf.setPadding(cVar.mVf.getPaddingLeft(), cVar.mVf.getPaddingTop(), (int) UnfamiliarContactDetailUI.this.getResources().getDimension(d.ListPadding), cVar.mVf.getPaddingBottom());
                cVar.mVe.setVisibility(8);
            }
        }

        public final int getItemCount() {
            return UnfamiliarContactDetailUI.this.fXG.size();
        }

        public final b vS(int i) {
            if (UnfamiliarContactDetailUI.this.fXG.size() > i) {
                return (b) UnfamiliarContactDetailUI.this.fXG.get(i);
            }
            return new b(UnfamiliarContactDetailUI.this, new ab());
        }
    }

    static /* synthetic */ void a(UnfamiliarContactDetailUI unfamiliarContactDetailUI, final HashSet hashSet, final int i) {
        unfamiliarContactDetailUI.dO(true);
        if (i == 0) {
            f.mVu += hashSet.size();
        } else if (i == 1) {
            f.mVt += hashSet.size();
        }
        com.tencent.mm.sdk.f.e.post(new Runnable() {
            public final void run() {
                List linkedList = new LinkedList();
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    b vS = UnfamiliarContactDetailUI.this.mUJ.vS(((Integer) it.next()).intValue());
                    x.i("MicroMsg.UnfamiliarContactUI", "username:%s index:%s", new Object[]{vS.guS.field_username, Integer.valueOf(i)});
                    qg qgVar;
                    if (i == 0) {
                        qgVar = new qg();
                        qgVar.caP.caR = false;
                        qgVar.caP.caQ = true;
                        qgVar.caP.username = vS.guS.field_username;
                        com.tencent.mm.sdk.b.a.sFg.m(qgVar);
                        linkedList.add(vS.guS.field_username);
                    } else if (i == 1) {
                        vS.guS.Bq();
                        qgVar = new qg();
                        qgVar.caP.caR = true;
                        qgVar.caP.caQ = false;
                        qgVar.caP.username = vS.guS.field_username;
                        com.tencent.mm.sdk.b.a.sFg.m(qgVar);
                        s.j(vS.guS);
                    }
                }
                if (linkedList.size() > 0) {
                    lv lvVar = new lv();
                    lvVar.bWj.list = linkedList;
                    lvVar.bWj.bNI = 1;
                    lvVar.bWj.bWk = 5;
                    com.tencent.mm.sdk.b.a.sFg.m(lvVar);
                    return;
                }
                UnfamiliarContactDetailUI.this.runOnUiThread(new 1(this));
            }
        }, "handleSnsSetting");
    }

    static /* synthetic */ void b(UnfamiliarContactDetailUI unfamiliarContactDetailUI, boolean z) {
        Animation loadAnimation;
        if (z) {
            loadAnimation = AnimationUtils.loadAnimation(unfamiliarContactDetailUI, com.tencent.mm.plugin.setting.a.a.push_up_in);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    UnfamiliarContactDetailUI.this.mhD.setVisibility(0);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            unfamiliarContactDetailUI.mhD.startAnimation(loadAnimation);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(unfamiliarContactDetailUI, com.tencent.mm.plugin.setting.a.a.push_down_out);
            loadAnimation.setAnimationListener(new 12(unfamiliarContactDetailUI));
            unfamiliarContactDetailUI.mhD.startAnimation(loadAnimation);
        }
        unfamiliarContactDetailUI.mUS = z;
        if (unfamiliarContactDetailUI.mUS) {
            unfamiliarContactDetailUI.updateOptionMenuText(1, unfamiliarContactDetailUI.getString(i.unfamiliar_cancel_contact_member_multi_select));
            return;
        }
        unfamiliarContactDetailUI.updateOptionMenuText(1, unfamiliarContactDetailUI.getString(i.unfamiliar_contact_member_multi_select));
        ((CheckBox) unfamiliarContactDetailUI.mUH.findViewById(f.checkbox)).setChecked(false);
    }

    protected final int getLayoutId() {
        return g.settings_unfamiliar_contact_detail_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.kernel.g.DF().a(291, this);
        this.mOS = getIntent().getBooleanExtra("half_year_not_chat", false);
        this.mOT = getIntent().getBooleanExtra("half_year_not_response", false);
        this.mOU = getIntent().getBooleanExtra("has_not_same_chatroom", false);
        initView();
        this.mUR = new l(this.mOS, this.mOT, this.mOU, new h() {
            long start = System.currentTimeMillis();

            public final void onSuccess() {
                x.i("MicroMsg.UnfamiliarContactUI", "[onSuccess] size:%s cost:%sms", new Object[]{Integer.valueOf(UnfamiliarContactDetailUI.this.fXG.size()), Long.valueOf(System.currentTimeMillis() - this.start)});
                UnfamiliarContactDetailUI.this.mUE.setText(UnfamiliarContactDetailUI.this.getString(i.unfamiliar_contact_member_list) + "(" + UnfamiliarContactDetailUI.this.fXG.size() + ")");
                if (UnfamiliarContactDetailUI.this.fXG.size() == 0) {
                    UnfamiliarContactDetailUI.this.findViewById(f.tip_layout).setVisibility(0);
                    UnfamiliarContactDetailUI.this.findViewById(f.progress_bar).setVisibility(8);
                    UnfamiliarContactDetailUI.this.findViewById(f.list_layout).setVisibility(8);
                    UnfamiliarContactDetailUI.this.mUI.setText(UnfamiliarContactDetailUI.this.getString(i.loaded_empty));
                    return;
                }
                UnfamiliarContactDetailUI.this.findViewById(f.tip_layout).setVisibility(8);
                UnfamiliarContactDetailUI.this.findViewById(f.list_layout).setVisibility(0);
                if (UnfamiliarContactDetailUI.this.mUJ != null) {
                    UnfamiliarContactDetailUI.this.mUJ.RR.notifyChanged();
                }
            }

            public final void onError() {
                x.e("MicroMsg.UnfamiliarContactUI", "[onError]");
                UnfamiliarContactDetailUI.this.findViewById(f.tip_layout).setVisibility(0);
                UnfamiliarContactDetailUI.this.findViewById(f.progress_bar).setVisibility(8);
                UnfamiliarContactDetailUI.this.mUI.setText(UnfamiliarContactDetailUI.this.getString(i.unfamiliar_load_err));
            }

            public final void a(e eVar) {
                x.i("MicroMsg.UnfamiliarContactUI", "[onLoading] type:%s", new Object[]{eVar.name()});
                UnfamiliarContactDetailUI.this.findViewById(f.tip_layout).setVisibility(0);
                UnfamiliarContactDetailUI.this.findViewById(f.progress_bar).setVisibility(0);
                if (eVar == e.mVp) {
                    UnfamiliarContactDetailUI.this.mUI.setText(UnfamiliarContactDetailUI.this.getString(i.loading_tips));
                } else if (eVar == e.mVo) {
                    UnfamiliarContactDetailUI.this.mUI.setText(UnfamiliarContactDetailUI.this.getString(i.unfamiliar_loading_about_one_min));
                }
            }

            public final void e(HashSet hashSet) {
                String str = "MicroMsg.UnfamiliarContactUI";
                String str2 = "[onResult] size:%s";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(hashSet == null ? 0 : hashSet.size());
                x.i(str, str2, objArr);
                if (hashSet != null) {
                    UnfamiliarContactDetailUI.a(UnfamiliarContactDetailUI.this, hashSet);
                }
            }
        });
        l lVar = this.mUR;
        lVar.jIL = System.currentTimeMillis();
        lVar.mPb.a(e.mVp);
        lVar.dqM.H(new 1(lVar));
    }

    protected void onResume() {
        super.onResume();
        if (-1 != this.mUP) {
            Object obj;
            if (-1 == this.mUP) {
                obj = null;
            } else {
                b bVar = (b) this.fXG.get(this.mUP);
                ab abVar = bVar.guS;
                ab Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(abVar.field_username);
                if (com.tencent.mm.l.a.gd(Yg.field_type) || !com.tencent.mm.l.a.gd(abVar.field_type)) {
                    bVar.guS = Yg;
                    obj = null;
                } else {
                    this.fXG.remove(this.mUP);
                    obj = 1;
                }
            }
            if (obj != null) {
                f.mVs++;
            }
            this.mUP = -1;
        }
        this.mUQ.clear();
        if (this.mUJ != null) {
            this.mUJ.RR.notifyChanged();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        int i = (this.mOT ? 4 : 0) | ((this.mOU ? 2 : 0) | (this.mOS ? 1 : 0));
        com.tencent.mm.plugin.report.service.h.mEJ.h(14434, new Object[]{Integer.valueOf(i), Integer.valueOf(f.mVs), Integer.valueOf(f.mVr), Integer.valueOf(f.mVw), Integer.valueOf(f.mVt), Integer.valueOf(f.mVv), Integer.valueOf(f.mVu)});
        x.i("MicroMsg.UnfamiliarContactUI", "[%s:%s:%s:%s:%s:%s:%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(f.mVs), Integer.valueOf(f.mVr), Integer.valueOf(f.mVw), Integer.valueOf(f.mVt), Integer.valueOf(f.mVv), Integer.valueOf(f.mVu)});
        f.mVr = 0;
        f.mVs = 0;
        f.mVt = 0;
        f.mVu = 0;
        f.mVv = 0;
        f.mVw = 0;
        com.tencent.mm.kernel.g.DF().b(291, this);
        com.tencent.mm.kernel.g.DF().b(681, this.mUO);
        l lVar = this.mUR;
        x.i("MicroMsg.UnfamiliarContactEngine", "[onDestroy] [%s:%s:%s]", new Object[]{Boolean.valueOf(lVar.mOT), Boolean.valueOf(lVar.mOS), Boolean.valueOf(lVar.mOU)});
        if (lVar.mPa != null) {
            com.tencent.mm.kernel.g.DF().b(292, lVar.mPa);
        }
        lVar.dqM.lnJ.quit();
        com.tencent.mm.sdk.f.e.S(lVar.mRunnable);
    }

    protected final void initView() {
        int i;
        int i2 = 0;
        super.initView();
        setMMTitle(i.settings_unfamiliar_contact);
        addTextOptionMenu(1, getString(i.unfamiliar_contact_member_multi_select), new 1(this));
        setBackBtn(new 5(this));
        findViewById(f.settings_half_year_not_chat_title).setVisibility(this.mOS ? 0 : 8);
        View findViewById = findViewById(f.settings_has_not_same_chatroom_title);
        if (this.mOU) {
            i = 0;
        } else {
            i = 8;
        }
        findViewById.setVisibility(i);
        View findViewById2 = findViewById(f.settings_half_year_not_response_title);
        if (!this.mOT) {
            i2 = 8;
        }
        findViewById2.setVisibility(i2);
        this.mUD = (RecyclerView) findViewById(f.unfamiliar_member_list);
        this.mhD = findViewById(f.bottom_bar);
        this.mUE = (TextView) findViewById(f.member_list_title);
        this.mUO = new d(this, this.mUN, new 6(this));
        this.mUF = findViewById(f.unfamiliar_contact_member_delete);
        this.mUF.setOnClickListener(new 7(this));
        this.mUG = findViewById(f.unfamiliar_contact_member_more);
        this.mUG.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(UnfamiliarContactDetailUI.this, 1, false);
                dVar.ofp = new 1(this);
                dVar.ofq = new 2(this);
                dVar.bXO();
            }
        });
        this.mUH = findViewById(f.unfamiliar_contact_member_select_all_area);
        this.mUH.setOnClickListener(new 9(this));
        this.mUI = (TextView) findViewById(f.tip_tv);
        this.mUD.setLayoutManager(new LinearLayoutManager());
        this.mUJ = new a();
        this.mUD.setAdapter(this.mUJ);
        this.mUK = (RealAlphabetScrollBar) findViewById(f.unfamiliar_member_scrollbar);
        this.mUK.setOnScrollBarTouchListener(new 10(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.UnfamiliarContactUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " " + lVar.getType());
        if (!(i == 0 && i2 == 0)) {
            Toast.makeText(this, getString(i.unfamiliar_contact_setting_err), 1).show();
        }
        if (lVar.getType() == 291) {
            dO(false);
            this.mUQ.clear();
            this.mUJ.RR.notifyChanged();
        }
    }

    private void cd(List<b> list) {
        this.mUL.clear();
        this.mUM.clear();
        int i = 0;
        String str = null;
        Iterator it = list.iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                b bVar = (b) it.next();
                if (hPy.equalsIgnoreCase(bVar.mUZ)) {
                    bVar.mUZ = "#";
                }
                str = bVar.mUZ;
                if (!str.equalsIgnoreCase(str2)) {
                    this.mUL.put(str.toUpperCase(), Integer.valueOf(i));
                    this.mUM.put(Integer.valueOf(i), str.toUpperCase());
                }
                i++;
            } else {
                return;
            }
        }
    }

    private void dO(boolean z) {
        x.i("MicroMsg.UnfamiliarContactUI", "[setProgress] isVisible:%s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.fUo = p.b(this, getString(i.unfamiliar_contact_member_handling), true, 0, null);
        } else if (this.fUo != null && this.fUo.isShowing()) {
            this.fUo.dismiss();
            this.fUo = null;
        }
    }
}
