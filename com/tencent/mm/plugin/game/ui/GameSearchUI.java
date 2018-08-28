package com.tencent.mm.plugin.game.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.p.h;
import com.tencent.mm.plugin.game.f;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.ar;
import com.tencent.mm.plugin.game.model.as;
import com.tencent.mm.plugin.game.ui.r.c;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xx;
import com.tencent.mm.protocal.c.xz;
import com.tencent.mm.protocal.c.ya;
import com.tencent.mm.protocal.c.yb;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.protocal.c.yd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.tools.o.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;

public class GameSearchUI extends MMActivity implements e, b {
    private static final Pattern kct = Pattern.compile("\\s+");
    private o eMS;
    private ProgressBar eVR;
    private int fromScene;
    private View gPU;
    private TextView jwj;
    private String kcA;
    private LinkedList<String> kcB;
    private String kcC;
    private LinkedList<l> kcD = new LinkedList();
    private boolean kcE = false;
    private OnItemClickListener kcF = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            r b = GameSearchUI.this.kcx;
            c cVar = (i < 0 || i >= b.getCount()) ? null : ((r$b) b.getItem(i)).kcj;
            if (cVar != null) {
                int b2;
                Map hashMap;
                if (cVar.actionType == 1 && !bi.oW(cVar.appId)) {
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("game_app_id", cVar.appId);
                    bundle.putInt("game_report_from_scene", cVar.bYq);
                    b2 = com.tencent.mm.plugin.game.e.c.b(GameSearchUI.this, cVar.appId, null, bundle);
                    hashMap = new HashMap();
                    hashMap.put("function_type", "search");
                    hashMap.put("funtion_value", cVar.kcl);
                    hashMap.put("keyword", GameSearchUI.this.kcz);
                    an.a(GameSearchUI.this, 14, cVar.bYq, cVar.position, b2, cVar.appId, GameSearchUI.this.fromScene, an.D(hashMap));
                } else if (cVar.actionType == 2 && !bi.oW(cVar.kck)) {
                    b2 = com.tencent.mm.plugin.game.e.c.r(GameSearchUI.this, cVar.kck, "game_center_detail");
                    hashMap = new HashMap();
                    hashMap.put("function_type", "search");
                    hashMap.put("funtion_value", cVar.kcl);
                    hashMap.put("keyword", GameSearchUI.this.kcz);
                    an.a(GameSearchUI.this, 14, cVar.bYq, cVar.position, b2, 0, cVar.appId, GameSearchUI.this.fromScene, cVar.kcf, String.valueOf(cVar.kcg), null, an.D(hashMap));
                }
            }
        }
    };
    private OnItemClickListener kcG = new 6(this);
    private ViewGroup kcu;
    private ListView kcv;
    private ListView kcw;
    private r kcx;
    private s kcy;
    private String kcz;

    public final void WY() {
    }

    public final void WZ() {
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        if (g.Eg().Dx()) {
            g.DF().a(1328, this);
            g.DF().a(1329, this);
            this.fromScene = getIntent().getIntExtra("game_report_from_scene", 0);
            initView();
            an.a(this, 14, 1401, 0, 2, this.fromScene, null);
            x.i("MicroMsg.GameSearchUI", "[onCreate] time:" + (System.currentTimeMillis() - currentTimeMillis));
            return;
        }
        x.e("MicroMsg.GameSearchUI", "account not ready");
        finish();
    }

    protected final void initView() {
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                GameSearchUI.this.onBackPressed();
                return true;
            }
        });
        this.eMS = new o();
        this.eMS.mv(true);
        this.eMS.uBw = this;
        this.kcu = (ViewGroup) findViewById(f.e.voicesearch_view);
        this.eVR = (ProgressBar) findViewById(f.e.search_progress_bar);
        this.jwj = (TextView) findViewById(f.e.no_result);
        this.kcv = (ListView) findViewById(f.e.search_result);
        this.kcx = new r(this);
        this.kcv.setAdapter(this.kcx);
        this.kcv.setOnItemClickListener(this.kcF);
        this.kcv.setOnTouchListener(new 2(this));
        this.kcv.setOnScrollListener(new 3(this));
        this.gPU = getLayoutInflater().inflate(f.f.game_list_footer_loading, this.kcv, false);
        this.gPU.setVisibility(8);
        this.kcv.addFooterView(this.gPU);
        this.kcw = (ListView) findViewById(f.e.search_recmd);
        this.kcy = new s(this);
        this.kcw.setAdapter(this.kcy);
        this.kcw.setOnItemClickListener(this.kcG);
        this.kcw.setOnTouchListener(new 4(this));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.eMS.a(this, menu);
        this.eMS.setHint(com.tencent.mm.plugin.game.model.f.aTK());
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        this.eMS.a(this, menu);
        return true;
    }

    protected final int getLayoutId() {
        return f.f.game_search_layout;
    }

    private void mH(int i) {
        switch (i) {
            case 0:
                this.kcu.setVisibility(8);
                this.jwj.setVisibility(8);
                this.kcv.setVisibility(8);
                this.kcw.setVisibility(8);
                this.eVR.setVisibility(8);
                return;
            case 1:
                YC();
                this.kcv.smoothScrollToPosition(0);
                this.eMS.clearFocus();
                this.kcu.setVisibility(8);
                this.jwj.setVisibility(8);
                this.kcv.setVisibility(8);
                this.kcw.setVisibility(8);
                this.eVR.setVisibility(0);
                return;
            case 2:
                this.kcu.setVisibility(8);
                if (this.kcx.getCount() > 0) {
                    this.jwj.setVisibility(8);
                    this.kcv.setVisibility(0);
                } else {
                    this.jwj.setVisibility(0);
                    this.kcv.setVisibility(8);
                }
                this.kcw.setVisibility(8);
                this.eVR.setVisibility(8);
                return;
            case 3:
                this.kcu.setVisibility(0);
                this.jwj.setVisibility(8);
                this.kcv.setVisibility(8);
                this.kcw.setVisibility(8);
                this.eVR.setVisibility(8);
                return;
            case 4:
                this.kcu.setVisibility(8);
                this.jwj.setVisibility(0);
                this.kcv.setVisibility(8);
                this.kcw.setVisibility(8);
                this.eVR.setVisibility(8);
                return;
            case 5:
                this.kcu.setVisibility(8);
                this.jwj.setVisibility(8);
                this.kcv.setVisibility(8);
                this.kcw.setVisibility(0);
                this.eVR.setVisibility(8);
                return;
            case 6:
                this.kcv.smoothScrollToPosition(0);
                this.kcu.setVisibility(8);
                this.jwj.setVisibility(8);
                this.kcv.setVisibility(8);
                this.kcw.setVisibility(8);
                this.eVR.setVisibility(0);
                return;
            default:
                return;
        }
    }

    private void Q(LinkedList<String> linkedList) {
        a(linkedList, 0, true);
    }

    private void a(LinkedList<String> linkedList, int i, boolean z) {
        while (!this.kcD.isEmpty()) {
            g.Ek();
            g.Eh().dpP.c((l) this.kcD.pop());
        }
        if (z) {
            r rVar = this.kcx;
            rVar.jNB = 0;
            rVar.kbN = false;
        }
        this.kcB = linkedList;
        ar arVar = new ar(w.chP(), linkedList, com.tencent.mm.plugin.game.model.f.aTz(), this.kcx.jNB);
        g.DF().a(arVar, 0);
        this.kcD.add(arVar);
        Iterator it = linkedList.iterator();
        this.kcz = "";
        while (it.hasNext()) {
            this.kcz += " " + ((String) it.next());
        }
        this.kcz = this.kcz.trim();
        if (i == 1 || i == 2) {
            this.kcE = true;
            this.eMS.setSearchContent(this.kcz);
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (!lVar.aBS) {
            if (this.kcD.contains(lVar)) {
                this.kcD.remove(lVar);
            }
            this.gPU.setVisibility(8);
            switch (lVar.getType()) {
                case 1328:
                    xz xzVar = (xz) ((ar) lVar).ivx.dID.dIL;
                    x.d("MicroMsg.GameSearchUI", "keywords = %s, offset = %d", new Object[]{xzVar.rDP, Integer.valueOf(xzVar.rDQ)});
                    if (i == 0 && i2 == 0) {
                        ya yaVar = (ya) ((ar) lVar).ivx.dIE.dIL;
                        LinkedList linkedList = yaVar != null ? yaVar.rDR : null;
                        if (!bi.cX(linkedList)) {
                            this.kcA = this.kcz;
                            yb ybVar;
                            if (this.kcx.jNB != 0) {
                                r rVar = this.kcx;
                                String str2 = this.kcA;
                                Iterator it = linkedList.iterator();
                                while (it.hasNext()) {
                                    ybVar = (yb) it.next();
                                    if (ybVar.type != 3 || bi.cX(ybVar.rDT)) {
                                        rVar.kbN = false;
                                    } else {
                                        rVar.jNB = ybVar.rDX;
                                        rVar.kbN = ybVar.rDY;
                                        Iterator it2 = ybVar.rDT.iterator();
                                        while (it2.hasNext()) {
                                            r$b a = r$b.a((yd) it2.next());
                                            a.bHt = str2;
                                            a.kcj.appId = a.appId;
                                            a.kcj.kcf = a.kcf;
                                            a.kcj.kcg = a.kcg;
                                            a.kcj.kcl = "2";
                                            c cVar = a.kcj;
                                            int i3 = rVar.kbK;
                                            rVar.kbK = i3 + 1;
                                            cVar.position = i3 + 301;
                                            a.kcj.bYq = rVar.bHx ? 1403 : 1405;
                                            rVar.hQM.add(a);
                                        }
                                    }
                                }
                            } else {
                                r rVar2 = this.kcx;
                                String str3 = this.kcA;
                                if (rVar2.hQM == null) {
                                    rVar2.hQM = new ArrayList();
                                }
                                rVar2.jZl = 0;
                                rVar2.kbI = 0;
                                rVar2.kbJ = 0;
                                rVar2.kbK = 0;
                                rVar2.kbL = 0;
                                rVar2.bHx = false;
                                rVar2.kbH = false;
                                rVar2.kbN = false;
                                rVar2.jNB = 0;
                                rVar2.hQM.clear();
                                rVar2.kbO = false;
                                Iterator it3 = linkedList.iterator();
                                while (it3.hasNext()) {
                                    ybVar = (yb) it3.next();
                                    Object obj = (ybVar.rDS == null || ybVar.rDS.size() == 0) ? 1 : null;
                                    Object obj2 = (ybVar.rDT == null || ybVar.rDT.size() == 0) ? 1 : null;
                                    Object obj3 = (ybVar.rDW == null || ybVar.rDW.size() == 0) ? 1 : null;
                                    obj2 = (obj == null || obj2 == null || obj3 == null) ? null : 1;
                                    if (obj2 == null) {
                                        Iterator it4;
                                        r$b r_b;
                                        c cVar2;
                                        int i4;
                                        rVar2.hQM.add(r$b.ap(0, ybVar.bHD));
                                        if (!rVar2.kbO) {
                                            ((r$b) rVar2.hQM.get(rVar2.hQM.size() - 1)).kch = true;
                                            rVar2.kbO = true;
                                        }
                                        if (ybVar.type == 4 && ybVar.rDW != null) {
                                            it4 = ybVar.rDW.iterator();
                                            while (it4.hasNext()) {
                                                yc ycVar = (yc) it4.next();
                                                r_b = new r$b();
                                                r_b.type = 3;
                                                r_b.appId = ycVar.rDZ.jQb;
                                                r_b.name = ycVar.rDZ.jPe;
                                                r_b.fky = ycVar.rDZ.rul;
                                                r_b.iconUrl = ycVar.rDZ.jPG;
                                                r_b.kcb = ycVar.rDZ.jPf;
                                                r_b.kcc = ycVar.rDZ.rDE;
                                                r_b.actionType = ycVar.rDZ.rDF;
                                                r_b.kcd = ycVar.rDZ.rDG;
                                                r_b.kce = ycVar.rEa;
                                                r_b.kcj = new c(ycVar.rDZ.rDF, 4, ycVar.rDZ.jQb, ycVar.rDZ.rDG);
                                                r_b.bHt = str3;
                                                r_b.kcj.kcl = "3";
                                                cVar2 = r_b.kcj;
                                                i4 = rVar2.kbJ;
                                                rVar2.kbJ = i4 + 1;
                                                cVar2.position = i4 + 601;
                                                rVar2.hQM.add(r_b);
                                            }
                                        }
                                        if ((ybVar.type == 1 || ybVar.type == 2) && ybVar.rDS != null) {
                                            it4 = ybVar.rDS.iterator();
                                            while (it4.hasNext()) {
                                                xv xvVar = (xv) it4.next();
                                                r_b = new r$b();
                                                r_b.type = 1;
                                                r_b.appId = xvVar.jQb;
                                                r_b.name = xvVar.jPe;
                                                r_b.fky = xvVar.rul;
                                                r_b.iconUrl = xvVar.jPG;
                                                r_b.kcb = xvVar.jPf;
                                                r_b.kcc = xvVar.rDE;
                                                r_b.actionType = xvVar.rDF;
                                                r_b.kcd = xvVar.rDG;
                                                r_b.kcj = new c(xvVar.rDF, 1, xvVar.jQb, xvVar.rDG);
                                                r_b.bHt = str3;
                                                if (ybVar.type == 1) {
                                                    rVar2.bHx = true;
                                                    cVar2 = r_b.kcj;
                                                    i4 = rVar2.jZl;
                                                    rVar2.jZl = i4 + 1;
                                                    cVar2.position = i4 + 1;
                                                } else if (ybVar.type == 2) {
                                                    rVar2.kbH = true;
                                                    cVar2 = r_b.kcj;
                                                    i4 = rVar2.kbI;
                                                    rVar2.kbI = i4 + 1;
                                                    cVar2.position = i4 + 1;
                                                }
                                                r_b.kcj.kcl = "1";
                                                rVar2.hQM.add(r_b);
                                            }
                                        } else if (ybVar.type == 3 && ybVar.rDT != null) {
                                            rVar2.jNB = ybVar.rDX;
                                            rVar2.kbN = ybVar.rDY;
                                            it4 = ybVar.rDT.iterator();
                                            while (it4.hasNext()) {
                                                r$b a2 = r$b.a((yd) it4.next());
                                                a2.bHt = str3;
                                                a2.kcj.appId = a2.appId;
                                                a2.kcj.kcf = a2.kcf;
                                                a2.kcj.kcg = a2.kcg;
                                                a2.kcj.kcl = "2";
                                                c cVar3 = a2.kcj;
                                                i4 = rVar2.kbK;
                                                rVar2.kbK = i4 + 1;
                                                cVar3.position = i4 + 301;
                                                rVar2.hQM.add(a2);
                                            }
                                        }
                                        if (!(bi.oW(ybVar.rDU) || bi.oW(ybVar.rDV) || ybVar.type != 1)) {
                                            String str4 = ybVar.rDU;
                                            String str5 = ybVar.rDV;
                                            r$b r_b2 = new r$b();
                                            r_b2.type = 5;
                                            r_b2.name = str4;
                                            r_b2.kcj = new c(str5);
                                            r_b2.kcj.appId = "wx62d9035fd4fd2059";
                                            r_b2.kcj.kcl = "1";
                                            r_b2.kcj.position = h.CTRL_INDEX;
                                            rVar2.hQM.add(r_b2);
                                        }
                                    } else if (ybVar.type == 1) {
                                        rVar2.hQM.add(r$b.ap(6, !bi.oW(str3) ? rVar2.context.getString(i.game_search_no_res_kw, new Object[]{str3}) : rVar2.context.getString(i.game_search_no_res)));
                                        rVar2.kbO = true;
                                    }
                                }
                                Iterator it5 = rVar2.hQM.iterator();
                                while (it5.hasNext()) {
                                    r$b r_b3 = (r$b) it5.next();
                                    if (rVar2.bHx) {
                                        r_b3.kcj.bYq = 1403;
                                    } else if (rVar2.kbH) {
                                        r_b3.kcj.bYq = 1404;
                                    } else {
                                        r_b3.kcj.bYq = 1405;
                                    }
                                }
                                rVar2.notifyDataSetChanged();
                            }
                        }
                    }
                    mH(2);
                    return;
                case 1329:
                    if (i == 0 && i2 == 0) {
                        this.kcy.a(((as) lVar).bHt, ((xx) ((as) lVar).ivx.dIE.dIL).bHD, ((xx) ((as) lVar).ivx.dIE.dIL).rDN);
                        mH(5);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    protected void onDestroy() {
        x.i("MicroMsg.GameSearchUI", "onDestroy");
        super.onDestroy();
        g.DF().b(1328, this);
        g.DF().b(1329, this);
    }

    public final void WX() {
    }

    public final void WW() {
        YC();
        onBackPressed();
    }

    public final void pk(String str) {
        if (this.kcE) {
            this.kcE = false;
        } else if (this.kcC == null || !this.kcC.equals(bi.oV(str))) {
            this.kcC = str;
            if (bi.oW(str)) {
                while (!this.kcD.isEmpty()) {
                    g.Ek();
                    g.Eh().dpP.c((l) this.kcD.pop());
                }
                as asVar = new as(w.chP(), str, com.tencent.mm.plugin.game.model.f.aTz());
                g.DF().a(asVar, 0);
                this.kcD.add(asVar);
                return;
            }
            LinkedList linkedList = new LinkedList();
            String[] split = kct.split(str.replace('*', ' '));
            for (Object add : split) {
                linkedList.add(add);
            }
            Q(linkedList);
            mH(6);
        } else {
            x.d("MicroMsg.GameSearchUI", "repeat searchChange");
        }
    }

    public final boolean pj(String str) {
        if (!bi.oW(str)) {
            LinkedList linkedList = new LinkedList();
            String[] split = kct.split(str.replace('*', ' '));
            for (Object add : split) {
                linkedList.add(add);
            }
            Q(linkedList);
            mH(1);
        }
        return true;
    }
}
