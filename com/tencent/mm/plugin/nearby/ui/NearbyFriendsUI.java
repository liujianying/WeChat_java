package com.tencent.mm.plugin.nearby.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.aa.q;
import com.tencent.mm.ab.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.plugin.nearby.a.b;
import com.tencent.mm.plugin.nearby.a.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ba;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;
import java.util.List;

public class NearbyFriendsUI extends MMActivity implements e {
    private com.tencent.mm.modelgeo.c cXl;
    private a cXs = new 8(this);
    private com.tencent.mm.sdk.b.c cXu = new 1(this);
    boolean dJO = false;
    private ListView eMX;
    private List<aqp> iKk = new LinkedList();
    private boolean kHX = false;
    private List<aqp> kJo = new LinkedList();
    private com.tencent.mm.plugin.nearby.a.c lBD;
    private b lBP;
    private com.tencent.mm.plugin.nearby.a.c lBQ;
    private d lBR;
    private boolean lBS = false;
    private String[] lBT;
    private int lBU = 1;
    private BindMobileOrQQHeaderView lBV;
    private ViewGroup lBW;
    private View lBX;
    private View lBY;
    private boolean lBZ = false;
    private int lCa;
    private boolean lCb = false;
    private int lCc = 0;
    private View lCd = null;
    private a lCe;
    private p tipDialog = null;

    static class c {
        public static int lCk = 10000;

        public static boolean tR(int i) {
            return i == lCk;
        }

        public static String b(aqp aqp) {
            if (aqp != null) {
                return aqp.eJI;
            }
            return null;
        }
    }

    static /* synthetic */ void k(ImageView imageView, String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.NearbyFriend", "setImgBmp url is empty");
            return;
        }
        imageView.setImageBitmap(null);
        com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
        au.HU();
        aVar.dXB = com.tencent.mm.model.c.Gb();
        aVar.dXy = true;
        aVar.dXV = true;
        o.Pj().a(str, imageView, aVar.Pt());
    }

    static /* synthetic */ void w(NearbyFriendsUI nearbyFriendsUI) {
        if (nearbyFriendsUI.lCe != null) {
            nearbyFriendsUI.lBR = new d(nearbyFriendsUI.lCe.dRT, nearbyFriendsUI.lCe.dRS, nearbyFriendsUI.lCe.accuracy, "", "");
            ActionBarActivity actionBarActivity = nearbyFriendsUI.mController.tml;
            nearbyFriendsUI.getString(R.l.app_tip);
            nearbyFriendsUI.tipDialog = h.a(actionBarActivity, nearbyFriendsUI.getString(R.l.nearby_lbsroom_joining), true, new 3(nearbyFriendsUI));
            b.tP(3);
            au.DF().a(nearbyFriendsUI.lBR, 0);
        }
    }

    public void onCreate(Bundle bundle) {
        g.vu(11);
        super.onCreate(bundle);
        setMMTitle(R.l.nearby_friend_title);
        au.DF().a(JsApiScanCode.CTRL_INDEX, this);
        au.DF().a(376, this);
        au.DF().a(1087, this);
        this.cXl = com.tencent.mm.modelgeo.c.OB();
        initView();
        this.lBT = new String[]{getResources().getString(R.l.nearby_friend_location_findmm), getResources().getString(R.l.nearby_friend_location_findgg), getResources().getString(R.l.nearby_friend_location_findall), getResources().getString(R.l.say_hi_list_lbs_title)};
        au.HU();
        this.lBU = bi.a((Integer) com.tencent.mm.model.c.DT().get(16386, null), 1);
        if (this.lBU == 3) {
            DM(R.k.ic_sex_male);
        } else if (this.lBU == 4) {
            DM(R.k.ic_sex_female);
        } else {
            DM(0);
            this.lBU = 1;
        }
        getData();
    }

    private void getData() {
        this.kHX = false;
        ActionBarActivity actionBarActivity = this.mController.tml;
        getString(R.l.app_tip);
        this.tipDialog = h.a(actionBarActivity, getString(R.l.nearby_friend_locating), true, new 7(this));
        this.dJO = false;
        if (this.cXl != null) {
            this.cXl.a(this.cXs, true);
        }
    }

    protected final int getLayoutId() {
        return R.i.nearby_friend;
    }

    private void biU() {
        if (com.tencent.mm.be.a.cbf()) {
            View view;
            if (this.lCd != null) {
                this.eMX.removeHeaderView(this.lCd);
                this.lCd = null;
            }
            View inflate = View.inflate(this, R.i.nearby_goto_sayhi_btn, null);
            TextView textView = (TextView) inflate.findViewById(R.h.say_hi_count);
            int axd = com.tencent.mm.az.d.SG().axd();
            if (axd == 0) {
                inflate.setVisibility(8);
                view = null;
            } else {
                inflate.setVisibility(0);
                textView.setText(getResources().getQuantityString(R.j.say_hi_count_text_quantity, axd, new Object[]{Integer.valueOf(axd)}));
                ImageView imageView = (ImageView) inflate.findViewById(R.h.match_dlg_img);
                ba clZ = com.tencent.mm.az.d.SG().clZ();
                if (clZ != null) {
                    com.tencent.mm.pluginsdk.ui.a.b.a(imageView, clZ.field_sayhiuser);
                }
                inflate.setOnClickListener(new 9(this));
                view = inflate;
            }
            this.lCd = view;
            if (this.lCd != null) {
                this.eMX.addHeaderView(this.lCd);
            }
        }
    }

    protected final void initView() {
        this.eMX = (ListView) findViewById(R.h.nearby_friend_lv);
        this.lBP = new b(this, this);
        ListView listView = this.eMX;
        if (this.lBW == null) {
            this.lBW = new LinearLayout(this);
            this.lBW.setLayoutParams(new LayoutParams(-1, -2));
            ((LinearLayout) this.lBW).setGravity(17);
        }
        this.lBZ = true;
        listView.addHeaderView(this.lBW);
        String value = com.tencent.mm.k.g.AT().getValue("LBSShowBindPhone");
        if (value != null && value.length() > 0) {
            try {
                this.lCa = Integer.valueOf(value).intValue();
            } catch (Exception e) {
                this.lCa = 0;
            }
        }
        au.HU();
        value = (String) com.tencent.mm.model.c.DT().get(6, null);
        if (value != null && value.length() > 0) {
            this.lCa = 0;
        }
        this.lCc = 0;
        if (com.tencent.mm.model.a.g.IW().iP("3") != null) {
            value = com.tencent.mm.model.a.g.IW().iP("3").value;
            l.a XC = l.XC();
            if (value.equals("0")) {
                this.lCc = 0;
            } else if (value.equals("2")) {
                if (XC == l.a.eKu) {
                    this.lCc = 2;
                    f.iT("3");
                }
            } else if (value.equals("1") && XC == l.a.eKr) {
                this.lCc = 2;
                f.iT("3");
            }
        }
        if ((this.lCa > 0 || this.lCc > 0) && this.lCc != 1) {
            this.lBV = new BindMobileOrQQHeaderView(this);
            this.eMX.addHeaderView(this.lBV);
        }
        this.eMX.setAdapter(this.lBP);
        this.eMX.setOnItemClickListener(new 10(this));
        this.eMX.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (NearbyFriendsUI.this.lBP != null) {
                    b s = NearbyFriendsUI.this.lBP;
                    if (s.eKg != null) {
                        s.eKg.onTouchEvent(motionEvent);
                    }
                }
                return false;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                NearbyFriendsUI.this.finish();
                return true;
            }
        });
        13 13 = new 13(this);
        addIconOptionMenu(0, R.g.mm_title_btn_menu, new 14(this));
    }

    private void biV() {
        com.tencent.mm.plugin.nearby.a.ezn.bd(this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.NearbyFriend", "onActivityResult, requestCode %s, resultCode %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.lBS = false;
                    getData();
                    return;
                }
                return;
            case 2009:
                if (i2 == -1) {
                    finish();
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.cXl != null) {
            this.cXl.c(this.cXs);
        }
        com.tencent.mm.sdk.b.a.sFg.c(this.cXu);
    }

    protected void onResume() {
        super.onResume();
        if (this.cXl != null) {
            this.cXl.a(this.cXs, true);
        }
        biU();
        this.lBP.notifyDataSetChanged();
        if (com.tencent.mm.az.d.SG().axd() == 0) {
            this.eMX.removeHeaderView(this.lBY);
        }
        com.tencent.mm.sdk.b.a.sFg.b(this.cXu);
    }

    protected void onDestroy() {
        if (this.lCc > 0) {
            f.iU("3");
        }
        g.vw(11);
        au.DF().b(JsApiScanCode.CTRL_INDEX, this);
        au.DF().b(376, this);
        au.DF().b(1087, this);
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
        }
        if (this.cXl != null) {
            this.cXl.c(this.cXs);
        }
        q.KJ().cancel();
        if (this.lBP != null) {
            b bVar = this.lBP;
            if (bVar.eKg != null) {
                bVar.eKg.detach();
                bVar.eKg = null;
            }
        }
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if (lVar.getType() == JsApiScanCode.CTRL_INDEX) {
            int Oh = ((com.tencent.mm.plugin.nearby.a.c) lVar).Oh();
            if (this.lBQ != null || (Oh != 1 && Oh != 3 && Oh != 4)) {
                if ((Oh == 1 || Oh == 3 || Oh == 4) && this.lBS) {
                    x.v("MicroMsg.NearbyFriend", "onSceneEnd data already requested, code=%d", new Object[]{Integer.valueOf(Oh)});
                } else if (this.lBD != null || Oh != 2) {
                    x.i("MicroMsg.NearbyFriend", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    if (lVar.getType() == JsApiScanCode.CTRL_INDEX) {
                        if (this.tipDialog != null) {
                            this.tipDialog.dismiss();
                            this.tipDialog = null;
                        }
                        if (i == 0 && i2 == 0) {
                            if (Oh == 1 || Oh == 3 || Oh == 4) {
                                this.iKk = ((com.tencent.mm.plugin.nearby.a.c) lVar).biS();
                                if (this.iKk == null || this.iKk.size() == 0) {
                                    findViewById(R.h.nearby_friend_not_found).setVisibility(0);
                                    this.eMX.setVisibility(8);
                                    biV();
                                    g.vw(11);
                                } else {
                                    findViewById(R.h.nearby_friend_not_found).setVisibility(8);
                                    List linkedList = new LinkedList();
                                    int i3 = 0;
                                    for (aqp aqp : this.iKk) {
                                        au.HU();
                                        if (com.tencent.mm.model.c.FR().Yc(aqp.hbL)) {
                                            linkedList.add(i3, aqp);
                                            i3++;
                                        } else {
                                            linkedList.add(aqp);
                                        }
                                    }
                                    this.iKk.clear();
                                    this.iKk = linkedList;
                                    if (this.kJo != null) {
                                        for (Oh = this.kJo.size() - 1; Oh >= 0; Oh--) {
                                            if (this.kJo.get(Oh) != null) {
                                                this.iKk.add(0, this.kJo.get(Oh));
                                            }
                                        }
                                    }
                                    this.lBP.notifyDataSetChanged();
                                    if (this.lBP.getCount() > 0) {
                                        this.eMX.setSelection(0);
                                    }
                                    this.eMX.post(new 4(this));
                                }
                                if (this.lBU == 3) {
                                    DM(R.k.ic_sex_male);
                                } else if (this.lBU == 4) {
                                    DM(R.k.ic_sex_female);
                                } else {
                                    DM(0);
                                    this.lBU = 1;
                                }
                                this.lBS = true;
                                this.lBQ = null;
                            }
                            if (((com.tencent.mm.plugin.nearby.a.c) lVar).Oh() == 2) {
                                h.a(this.mController.tml, getString(R.l.nearby_friend_clear_location_ok), "", new 5(this));
                                this.lBD = null;
                            }
                            if (((com.tencent.mm.plugin.nearby.a.c) lVar).biQ()) {
                                CharSequence string = getString(R.l.nearby_lbsroom_name);
                                int biR = ((com.tencent.mm.plugin.nearby.a.c) lVar).biR();
                                if (this.lBW != null) {
                                    if (this.lBX == null) {
                                        this.lBX = View.inflate(this, R.i.nearby_group_header_item, null);
                                        this.lBW.addView(this.lBX);
                                        this.lBX.setOnClickListener(new 2(this));
                                    } else {
                                        this.lBX.setVisibility(0);
                                    }
                                    ((TextView) this.lBX.findViewById(R.h.nearby_group_title)).setText(string);
                                    if (biR != 0) {
                                        ((TextView) this.lBX.findViewById(R.h.nearby_group_member_count)).setText(String.format(getResources().getQuantityString(R.j.nearby_lbsroom_member_count, biR, new Object[]{Integer.valueOf(biR)}), new Object[0]));
                                    }
                                }
                            } else if (!(this.lBX == null || this.lBW == null)) {
                                this.lBX.setVisibility(8);
                            }
                            this.lCb = true;
                            return;
                        }
                        if (Oh == 1 || Oh == 3 || Oh == 4) {
                            com.tencent.mm.h.a aVar;
                            TextView textView = (TextView) findViewById(R.h.nearby_friend_not_found);
                            textView.setVisibility(0);
                            biV();
                            if (str == null || str.length() <= 0) {
                                aVar = null;
                            } else {
                                aVar = com.tencent.mm.h.a.eV(str);
                            }
                            if (aVar != null && aVar.desc != null && aVar.desc.length() > 0) {
                                textView.setText(aVar.desc);
                            } else if (i2 == -2001) {
                                textView.setText(getString(R.l.nearby_friend_expose));
                            } else {
                                textView.setText(getString(R.l.nearby_friend_get_friend_fail));
                            }
                            this.eMX.setVisibility(8);
                            this.lBQ = null;
                        }
                        if (((com.tencent.mm.plugin.nearby.a.c) lVar).Oh() == 2) {
                            Toast.makeText(this, R.l.nearby_friend_clear_location_failed, 1).show();
                            this.lBD = null;
                        }
                    }
                }
            }
        } else if (lVar.getType() == 376 && ((d) lVar).Oh() == 1) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            if (i == 0 && i2 == 0 && ((d) lVar).euq != null) {
                String str2 = ((d) lVar).euq;
                b.dV(str2, ((d) lVar).lBn);
                Intent intent = new Intent();
                intent.putExtra("Chat_User", str2);
                com.tencent.mm.plugin.nearby.a.ezn.f(intent, this);
                return;
            }
            h.a(this.mController.tml, R.l.nearby_lbsroom_join_failed, R.l.app_tip, new 6(this));
        }
    }
}
