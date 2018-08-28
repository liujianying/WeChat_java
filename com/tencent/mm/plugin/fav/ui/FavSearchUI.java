package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.m;
import android.support.v7.app.ActionBarActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.w;
import com.tencent.mm.plugin.fav.ui.a.b;
import com.tencent.mm.plugin.fav.ui.a.c;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.plugin.fav.ui.m.f;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.plugin.fav.ui.widget.FavCapacityPanel;
import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@a(3)
public class FavSearchUI extends MMActivity {
    private String bEN;
    private String bWm = "";
    private int eqm;
    private long hYp;
    private ListView hoG;
    private k iYr;
    private b iYs;
    private List<Integer> iZA;
    private List<String> iZB;
    private List<String> iZC;
    private Set<String> iZD = new HashSet();
    private View iZE;
    private ImageButton iZF;
    private MenuItem iZG;
    private List<Long> iZH = new ArrayList();
    private TextView iZI;
    private TextView iZJ;
    private TextView iZK;
    private TextView iZL;
    private TextView iZM;
    private TextView iZN;
    a iZO;
    private OnClickListener iZP = new 3(this);
    private String iZp;
    private Set<Integer> iZq;
    private w iZr;
    private c iZs;
    private FavSearchActionView iZt;
    private View iZu;
    private ListView iZv;
    private View iZw;
    private FavCapacityPanel iZx;
    private Animation iZy;
    private Animation iZz;
    private ag mHandler;

    static /* synthetic */ void a(FavSearchUI favSearchUI, List list, List list2, List list3) {
        if ((list == null || list.isEmpty()) && ((list2 == null || list2.isEmpty()) && (list3 == null || list3.isEmpty()))) {
            favSearchUI.iZF.setVisibility(8);
        } else {
            favSearchUI.iZF.setVisibility(0);
        }
    }

    static /* synthetic */ void c(FavSearchUI favSearchUI) {
        favSearchUI.iZs.notifyDataSetChanged();
        if (favSearchUI.iZv.getVisibility() != 0) {
            favSearchUI.iZv.setVisibility(0);
            favSearchUI.iZv.startAnimation(favSearchUI.iZy);
        }
        if (8 != favSearchUI.hoG.getVisibility()) {
            favSearchUI.hoG.setVisibility(8);
            favSearchUI.hoG.startAnimation(favSearchUI.iZz);
        }
        if (8 != favSearchUI.iZw.getVisibility()) {
            favSearchUI.iZw.setVisibility(8);
            favSearchUI.iZw.startAnimation(favSearchUI.iZz);
        }
    }

    static /* synthetic */ int j(FavSearchUI favSearchUI) {
        int size = favSearchUI.iZA.size();
        int size2 = favSearchUI.iZB.size();
        int size3 = favSearchUI.iZC.size();
        if (size == 0 && size2 == 0 && size3 > 0) {
            return 2;
        }
        if (size == 0 && size2 > 0 && size3 == 0) {
            return 3;
        }
        return (size > 0 && size2 == 0 && size3 == 0) ? 1 : 4;
    }

    protected final int getLayoutId() {
        return f.fav_search_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            Transition inflateTransition = TransitionInflater.from(this).inflateTransition(17760258);
            inflateTransition.excludeTarget(getWindow().getDecorView().findViewById(e.action_bar_container), true);
            inflateTransition.excludeTarget(16908335, true);
            getWindow().setEnterTransition(inflateTransition);
        }
        this.mHandler = new ag();
        setMMTitle("");
        lF(this.mController.tml.getResources().getColor(m.b.normal_actionbar_color));
        cqh();
        this.eqm = getIntent().getIntExtra("key_search_type", 0);
        if (1 == this.eqm) {
            this.bEN = getIntent().getStringExtra("key_to_user");
            this.iZp = getIntent().getStringExtra("key_fav_item_id");
        }
        this.iZv = (ListView) findViewById(e.tag_panel_list);
        this.hoG = (ListView) findViewById(e.search_result_list);
        this.iZw = findViewById(e.search_empty_tv);
        this.iZy = AnimationUtils.loadAnimation(this.mController.tml, m.a.panel_fade_in);
        this.iZz = AnimationUtils.loadAnimation(this.mController.tml, m.a.panel_fade_out);
        aMs();
        this.iZu = View.inflate(this.mController.tml, f.fav_type_header, null);
        this.iZI = (TextView) this.iZu.findViewById(e.fav_sub_url_tv);
        this.iZJ = (TextView) this.iZu.findViewById(e.fav_sub_image_tv);
        this.iZK = (TextView) this.iZu.findViewById(e.fav_sub_voice_tv);
        this.iZL = (TextView) this.iZu.findViewById(e.fav_sub_music_tv);
        this.iZM = (TextView) this.iZu.findViewById(e.fav_sub_video_tv);
        this.iZN = (TextView) this.iZu.findViewById(e.fav_sub_location_tv);
        this.iZI.setOnClickListener(this.iZP);
        this.iZI.setTag(Integer.valueOf(5));
        this.iZJ.setOnClickListener(this.iZP);
        this.iZJ.setTag(Integer.valueOf(2));
        this.iZK.setOnClickListener(this.iZP);
        this.iZK.setTag(Integer.valueOf(3));
        this.iZL.setOnClickListener(this.iZP);
        this.iZL.setTag(Integer.valueOf(7));
        this.iZM.setOnClickListener(this.iZP);
        this.iZM.setTag(Integer.valueOf(4));
        this.iZN.setOnClickListener(this.iZP);
        this.iZN.setTag(Integer.valueOf(6));
        this.iZx = (FavCapacityPanel) View.inflate(this.mController.tml, f.fav_capacity_foot_panel, null);
        this.iZx.jfc = getIntent().getIntExtra("key_enter_fav_search_from", 0);
        this.iZs = new 9(this, this.mController.tml);
        this.iZv.addHeaderView(this.iZu);
        if (((ae) g.n(ae.class)).getFavTagSetMgr().aLn() > 0) {
            this.iZv.addHeaderView((TextView) View.inflate(this.mController.tml, f.fav_tag_panel_headerview, null));
        }
        this.iZv.addFooterView(this.iZx);
        this.iZv.setAdapter(this.iZs);
        this.iZv.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        FavSearchUI.this.YC();
                        break;
                }
                return false;
            }
        });
        this.iYr = new k(this.mController.tml, 16);
        ActionBarActivity actionBarActivity = this.mController.tml;
        this.iYs = new b(this.iYr, false);
        this.iYs.scene = 2;
        this.iYs.jbS = this.hoG;
        if (1 == this.eqm) {
            this.iZq = new HashSet();
            this.iZr = new k();
            if (!bi.oW(this.iZp)) {
                for (String str : this.iZp.split(",")) {
                    int i = bi.getInt(str, Integer.MAX_VALUE);
                    if (Integer.MAX_VALUE != i) {
                        this.iZq.add(Integer.valueOf(i));
                    }
                }
            }
            this.iYs.g(this.iZq);
            this.iYs.a(this.iZr);
        }
        this.hoG.setAdapter(this.iYs);
        this.hoG.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, final int i, long j) {
                final com.tencent.mm.plugin.fav.ui.d.a.b bVar = (com.tencent.mm.plugin.fav.ui.d.a.b) view.getTag();
                if (!(bVar == null || bVar.iWQ == null)) {
                    FavSearchUI.this.iZO.jab = true;
                    FavSearchUI.this.I(3, i, bVar.iWQ.field_id);
                }
                if (1 == FavSearchUI.this.eqm) {
                    if (bVar == null) {
                        x.w("MicroMsg.FavSearchUI", "on item click, holder is null");
                    } else if (bVar.iWQ == null) {
                        x.w("MicroMsg.FavSearchUI", "on item click, info is null");
                    } else {
                        ((ab) g.l(ab.class)).a(FavSearchUI.this.mController.tml, FavSearchUI.this.bEN, bVar.iWQ, i.app_send, false, new 1(this, bVar));
                    }
                } else if (2 != FavSearchUI.this.eqm) {
                    FavSearchUI.this.iYs.onItemClick(adapterView, view, i, j);
                    if (bVar.iWQ != null) {
                        g.Em().H(new Runnable() {
                            public final void run() {
                                int i;
                                x.d("MicroMsg.FavSearchUI", "type %s", new Object[]{Integer.valueOf(bVar.iWQ.field_type)});
                                long j = bVar.iWQ.field_localId;
                                if (FavSearchUI.this.iZH.size() == 0) {
                                    FavSearchUI.this.iZH = ((ae) g.n(ae.class)).getFavItemInfoStorage().aLJ();
                                }
                                if (FavSearchUI.this.iZH.size() != 0) {
                                    Iterator it = FavSearchUI.this.iZH.iterator();
                                    i = 1;
                                    while (it.hasNext() && ((Long) it.next()).longValue() != j) {
                                        i++;
                                    }
                                } else {
                                    i = 1;
                                }
                                h hVar = h.mEJ;
                                Object[] objArr = new Object[3];
                                objArr[0] = Integer.valueOf(bVar.iWQ.field_type);
                                objArr[1] = Integer.valueOf(FavSearchUI.j(FavSearchUI.this));
                                if (FavSearchUI.this.iZH.size() == 0) {
                                    i = i;
                                }
                                objArr[2] = Integer.valueOf(i);
                                hVar.h(12746, objArr);
                            }
                        });
                    }
                } else if (bVar == null) {
                    x.w("MicroMsg.FavSearchUI", "on item click, holder is null");
                } else if (bVar.iWQ == null) {
                    x.w("MicroMsg.FavSearchUI", "on item click, info is null");
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("key_fav_result_local_id", bVar.iWQ.field_localId);
                    FavSearchUI.this.setResult(-1, intent);
                    FavSearchUI.this.finish();
                }
            }
        });
        this.hoG.setOnTouchListener(new 2(this));
        ((ae) g.n(ae.class)).getFavTagSetMgr().a(this.iZs);
        g.Em().h(new 1(this), 1000);
        this.iZO = new a();
        this.hYp = System.currentTimeMillis();
    }

    protected void onDestroy() {
        if (!this.iZO.jab) {
            if (this.iYs.isEmpty() || this.hoG.getVisibility() != 0) {
                I(1, 0, 0);
            } else {
                I(2, 0, 0);
            }
        }
        super.onDestroy();
        this.iYr.destory();
        this.iYr = null;
        ((ae) g.n(ae.class)).getFavTagSetMgr().a(this.iZs);
        ((ae) g.n(ae.class)).getFavTagSetMgr().f(this.iZD);
        if (this.iYs != null) {
            this.iYs.finish();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        x.d("MicroMsg.FavSearchUI", "on create options menu");
        aMs();
        this.iZG = menu.add(0, e.menu_search, 0, i.app_empty_string);
        m.a(this.iZG, this.iZt);
        m.a(this.iZG, 9);
        this.iZt.post(new 4(this));
        m.a(this.iZG, new 5(this));
        this.mHandler.post(new 6(this));
        return true;
    }

    private void aMs() {
        if (this.iZt == null) {
            this.iZt = (FavSearchActionView) View.inflate(this.mController.tml, f.fav_search_actionview, null);
            this.iZE = this.iZt.findViewById(e.ab_back_container);
            this.iZE.setOnClickListener(new 7(this));
            this.iZF = (ImageButton) this.iZt.findViewById(e.search_clear_button);
            this.iZF.setVisibility(8);
            this.iZt.setOnSearchChangedListener(new 8(this));
        }
    }

    private void I(int i, int i2, int i3) {
        this.iZO.actionType = i;
        if (this.iYs != null) {
            this.iZO.iVT = this.iYs.iVT;
        }
        switch (this.eqm) {
            case 0:
                this.iZO.scene = 1;
                break;
            case 1:
                this.iZO.scene = 2;
                break;
            case 2:
                this.iZO.scene = 3;
                break;
            default:
                this.iZO.scene = 0;
                break;
        }
        this.iZO.position = i2;
        this.iZO.iZZ = ((int) (System.currentTimeMillis() - this.hYp)) / BaseReportManager.MAX_READ_COUNT;
        this.iZO.bWm = this.bWm;
        this.iZO.iVH = (long) i3;
        if (this.iZA != null) {
            if (this.iZA.size() > 0) {
                switch (((Integer) this.iZA.get(0)).intValue()) {
                    case 2:
                        this.iZO.jaa = 1;
                        break;
                    case 3:
                        this.iZO.jaa = 6;
                        break;
                    case 4:
                        this.iZO.jaa = 1;
                        break;
                    case 5:
                        this.iZO.jaa = 2;
                        break;
                    case 6:
                        this.iZO.jaa = 8;
                        break;
                    case 7:
                        this.iZO.jaa = 4;
                        break;
                    default:
                        this.iZO.jaa = 0;
                        break;
                }
            }
            this.iZO.jaa = 0;
        }
        a aVar = this.iZO;
        h.mEJ.h(15488, new Object[]{Integer.valueOf(aVar.actionType), Integer.valueOf(aVar.iVT), Integer.valueOf(aVar.scene), Integer.valueOf(aVar.position), Integer.valueOf(aVar.iZZ), aVar.bWm, Long.valueOf(aVar.iVH), Integer.valueOf(aVar.jaa)});
    }

    protected void onResume() {
        long j = 0;
        this.iYs.aME();
        this.iYs.notifyDataSetChanged();
        FavCapacityPanel favCapacityPanel = this.iZx;
        if (favCapacityPanel.jfa != com.tencent.mm.plugin.fav.a.b.aKR() / 1048576) {
            favCapacityPanel.jfa = com.tencent.mm.plugin.fav.a.b.aKR() / 1048576;
            TextView textView = favCapacityPanel.jfb;
            Context context = favCapacityPanel.jfb.getContext();
            int i = i.fav_capacity_info;
            Object[] objArr = new Object[2];
            if (favCapacityPanel.jfd - favCapacityPanel.jfa > 0) {
                j = favCapacityPanel.jfd - favCapacityPanel.jfa;
            }
            objArr[0] = Long.valueOf(j);
            objArr[1] = Long.valueOf(favCapacityPanel.jfa);
            textView.setText(context.getString(i, objArr));
        }
        com.tencent.mm.plugin.fav.a.i.Bk(getClass().getSimpleName());
        super.onResume();
    }

    protected void onPause() {
        com.tencent.mm.plugin.fav.a.i.Bl(getClass().getSimpleName());
        super.onPause();
    }
}
