package com.tencent.mm.plugin.fav.ui;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Pair;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageButton;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.g.a.kq;
import com.tencent.mm.k.b;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.m;
import com.tencent.mm.plugin.fav.ui.d.a.c;
import com.tencent.mm.plugin.fav.ui.m.h;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.plugin.fav.ui.widget.b.2;
import com.tencent.mm.plugin.fav.ui.widget.b.3;
import com.tencent.mm.plugin.fav.ui.widget.c.a;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.k;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FavoriteIndexUI extends FavBaseUI implements c, a {
    private static final long jaZ = ((long) b.AB());
    private k contextMenuHelper;
    private d hlb = new 17(this);
    private int jba = 0;
    private com.tencent.mm.plugin.fav.ui.a.b jbb;
    private com.tencent.mm.plugin.fav.ui.widget.b jbc;
    private g jbd;
    private e jbe = new 12(this);
    private OnItemLongClickListener jbf = new OnItemLongClickListener() {
        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < FavoriteIndexUI.this.iYa.getHeaderViewsCount()) {
                x.w("MicroMsg.FavoriteIndexUI", "on header view long click, ignore");
            } else {
                FavoriteIndexUI.this.contextMenuHelper.a(view, i, j, FavoriteIndexUI.this, FavoriteIndexUI.this.hlb);
            }
            return true;
        }
    };
    private g jbg;
    private long startTime = 0;

    static /* synthetic */ void b(FavoriteIndexUI favoriteIndexUI, g gVar) {
        favoriteIndexUI.jbb.a(true, gVar);
        favoriteIndexUI.iYa.setOnItemLongClickListener(null);
        favoriteIndexUI.showOptionMenu(11, false);
        com.tencent.mm.plugin.fav.ui.widget.b bVar = favoriteIndexUI.jbc;
        if (!bVar.jff) {
            if (bVar.jfg != null) {
                if (bVar.jfg instanceof ViewStub) {
                    bVar.jfg = ((ViewStub) bVar.jfg).inflate();
                }
                bVar.jfj = (ImageButton) bVar.jfg.findViewById(m.e.fav_edit_forward);
                bVar.jfj.setEnabled(false);
                bVar.jfj.setContentDescription(bVar.jfj.getContext().getString(i.transmit_btn));
                bVar.jfj.setOnClickListener(new b$1(bVar));
                bVar.jfk = (ImageButton) bVar.jfg.findViewById(m.e.fav_edit_addtag);
                bVar.jfk.setEnabled(false);
                bVar.jfk.setContentDescription(bVar.jfk.getContext().getString(i.edit_label_btn));
                bVar.jfk.setOnClickListener(new 2(bVar));
                bVar.jfl = (ImageButton) bVar.jfg.findViewById(m.e.fav_edit_delete);
                bVar.jfl.setEnabled(false);
                bVar.jfl.setContentDescription(bVar.jfl.getContext().getString(i.delete_Imgbtn));
                bVar.jfl.setOnClickListener(new 3(bVar));
                bVar.jff = true;
            } else {
                return;
            }
        }
        if (bVar.jfg.getVisibility() != 0) {
            bVar.jfg.setVisibility(0);
            bVar.jfg.startAnimation(AnimationUtils.loadAnimation(bVar.jfg.getContext(), m.a.fast_faded_in));
        }
    }

    static /* synthetic */ void h(FavoriteIndexUI favoriteIndexUI) {
        long currentTimeMillis = System.currentTimeMillis();
        kp kpVar = new kp();
        kpVar.bUP.field_localId = currentTimeMillis;
        kpVar.bUP.context = favoriteIndexUI.mController.tml;
        kpVar.bUP.type = 9;
        com.tencent.mm.sdk.b.a.sFg.m(kpVar);
        kq kqVar = new kq();
        kqVar.bVa.context = favoriteIndexUI.mController.tml;
        kqVar.bVa.type = 3;
        kqVar.bVa.bUV = 1;
        com.tencent.mm.sdk.b.a.sFg.m(kqVar);
    }

    public void onCreate(Bundle bundle) {
        this.iYi = this;
        x.i("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex");
        super.onCreate(bundle);
        if (((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().aLz() == null) {
            x.e("MicroMsg.FavoriteIndexUI", "onCreate favoriteindex, but favorite db is null ,return");
            finish();
            return;
        }
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().eN(false);
        setMMTitle(i.favorite_index_ui_title);
        setBackBtn(new 1(this));
        this.iYa.setOnItemLongClickListener(this.jbf);
        com.tencent.mm.kernel.g.DF().a(438, this.jbe);
        com.tencent.mm.kernel.g.DF().a(401, this.jbe);
        this.contextMenuHelper = new k(this);
        addIconOptionMenu(11, i.fav_actionbar_title_add_fav, h.actionbar_icon_dark_add, new 21(this));
        this.jbc = new com.tencent.mm.plugin.fav.ui.widget.b();
        com.tencent.mm.plugin.fav.ui.widget.b bVar = this.jbc;
        View findViewById = findViewById(m.e.fav_edit_footer);
        bVar.jff = false;
        bVar.jfg = findViewById;
        this.jbc.jfm = new 2(this);
        com.tencent.mm.kernel.g.Em().H(new 14(this));
        com.tencent.mm.plugin.fav.a.d.aLb().a(null);
        c.aMi();
        com.tencent.mm.plugin.fav.a.i.start();
    }

    protected final void aMg() {
        super.aMg();
        this.dvh.post(new 15(this));
    }

    protected void onDestroy() {
        super.onDestroy();
        if (((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().aLz() != null) {
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnService().eN(true);
            if (this.jbb != null) {
                this.jbb.finish();
            }
            kp kpVar = new kp();
            kpVar.bUP.type = 12;
            com.tencent.mm.sdk.b.a.sFg.m(kpVar);
            com.tencent.mm.kernel.g.DF().b(438, this.jbe);
            com.tencent.mm.kernel.g.DF().b(401, this.jbe);
            com.tencent.mm.plugin.fav.a.i.end();
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (4 != i || !this.jbb.jbI) {
            return super.onKeyUp(i, keyEvent);
        }
        aMw();
        return true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        com.tencent.mm.plugin.fav.a.k kVar = new com.tencent.mm.plugin.fav.a.k();
        g pQ = this.jbb.getItem((((AdapterContextMenuInfo) contextMenuInfo).position - this.iYa.getHeaderViewsCount()) - 1);
        switch (this.jba) {
            case 0:
                contextMenu.setHeaderTitle(i.app_tip);
                boolean t = kVar.t(pQ);
                if (!t) {
                    contextMenu.add(0, 3, 0, i.favorite_retransmit);
                }
                if (t && com.tencent.mm.plugin.fav.a.b.g(pQ)) {
                    contextMenu.add(0, 3, 0, i.favorite_retransmit);
                }
                contextMenu.add(0, 2, 0, i.favorite_edit_tag_tips);
                contextMenu.add(0, 0, 0, i.favorite_delete);
                contextMenu.add(0, 1, 0, i.favorite_more);
                return;
            default:
                super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
                return;
        }
    }

    private void aMw() {
        this.jbb.a(false, null);
        this.iYa.setOnItemLongClickListener(this.jbf);
        showOptionMenu(11, true);
        com.tencent.mm.plugin.fav.ui.widget.b bVar = this.jbc;
        if (bVar.jff && bVar.jfg.getVisibility() != 8) {
            bVar.jfg.setVisibility(8);
            bVar.jfg.startAnimation(AnimationUtils.loadAnimation(bVar.jfg.getContext(), m.a.fast_faded_out));
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (this.jba) {
            case 0:
                if (this.jbb != null) {
                    this.jbb.onItemClick(adapterView, view, i, j);
                    com.tencent.mm.plugin.fav.ui.d.a.b bVar = (com.tencent.mm.plugin.fav.ui.d.a.b) view.getTag();
                    if (bVar == null) {
                        x.w("MicroMsg.FavoriteIndexUI", "on item click, holder is null..");
                        return;
                    } else if (bVar.iWQ == null) {
                        x.w("MicroMsg.FavoriteIndexUI", "on item click, info is null..");
                        return;
                    } else {
                        x.i("MicroMsg.FavoriteIndexUI", "click type is %d", new Object[]{Integer.valueOf(bVar.iWQ.field_type)});
                        com.tencent.mm.plugin.report.service.h.mEJ.h(12746, new Object[]{Integer.valueOf(bVar.iWQ.field_type), Integer.valueOf(0), Integer.valueOf(i - 1)});
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    public final com.tencent.mm.plugin.fav.ui.a.a aMc() {
        if (this.jbb == null) {
            ActionBarActivity actionBarActivity = this.mController.tml;
            this.jbb = new com.tencent.mm.plugin.fav.ui.a.b(this.iYh, false);
            this.jbb.a(new 18(this));
            this.jbb.jbP = this;
            this.jbb.scene = 1;
            this.jbb.jbS = this.iYa;
        }
        return this.jbb;
    }

    protected final void aMd() {
        this.iYg.post(new 19(this));
    }

    protected final boolean aMe() {
        int aLA;
        switch (this.jba) {
            case 3:
                aLA = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().aLA();
                break;
            default:
                aLA = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().getCount();
                break;
        }
        if (aLA > 0) {
            return true;
        }
        return false;
    }

    @SuppressLint({"ResourceType"})
    protected final void aMf() {
        switch (this.jba) {
            case 3:
                this.iYb.setCompoundDrawablesWithIntrinsicBounds(0, h.fav_list_img_default, 0, 0);
                this.iYb.setCompoundDrawablePadding(com.tencent.mm.bp.a.fromDPToPix(this.mController.tml, 10));
                this.iYb.setText(i.favorite_empty_fav_img);
                return;
            default:
                this.iYb.setCompoundDrawablesWithIntrinsicBounds(0, m.d.favorites_empty_favorites_icon, 0, 0);
                this.iYb.setCompoundDrawablePadding(com.tencent.mm.bp.a.fromDPToPix(this.mController.tml, 10));
                this.iYb.setText(i.favorite_empty_fav);
                return;
        }
    }

    protected void onResume() {
        long currentTimeMillis = System.currentTimeMillis();
        super.onResume();
        this.dvh.post(new 20(this));
        x.d("MicroMsg.FavoriteIndexUI", "on resume use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        com.tencent.mm.plugin.fav.a.i.Bk(getClass().getSimpleName());
    }

    protected void onPause() {
        super.onPause();
        com.tencent.mm.plugin.fav.a.i.Bl(getClass().getSimpleName());
    }

    protected final void initHeaderView() {
        super.initHeaderView();
        this.iYg.eX(false);
    }

    private void a(List<g> list, String str, String str2) {
        if (list != null && !list.isEmpty() && !bi.oW(str2)) {
            boolean fq = s.fq(str2);
            com.tencent.mm.plugin.fav.a.k kVar = new com.tencent.mm.plugin.fav.a.k();
            List<g> linkedList = new LinkedList();
            for (g gVar : list) {
                if (!kVar.t(gVar)) {
                    com.tencent.mm.plugin.fav.a.h.f(gVar.field_localId, 1, 0);
                    linkedList.add(gVar);
                    m.a(fq ? m.c.iWy : m.c.iWx, gVar, m.d.iWB, fq ? com.tencent.mm.model.m.gK(str2) : 0);
                }
            }
            if (linkedList.isEmpty()) {
                x.i("MicroMsg.FavoriteIndexUI", "after filter, nothing");
                com.tencent.mm.ui.base.h.bA(getApplicationContext(), getString(i.favorite_retransmit_tip));
                return;
            }
            h.a(this.mController.tml, str2, str, linkedList, new 5(this, com.tencent.mm.ui.base.h.a(this.mController.tml, getString(i.favorite_forward_tips), false, null)));
            for (g gVar2 : linkedList) {
                if (gVar2 != null && gVar2.field_type == 5) {
                    String str3 = "";
                    if (gVar2.field_favProto.rAN != null) {
                        str3 = gVar2.field_favProto.rAN.rCn;
                    }
                    if (gVar2.field_favProto.rBG != null && bi.oW(r1)) {
                        str3 = gVar2.field_favProto.rBG.egr;
                    }
                    if (!bi.oW(str3)) {
                        x.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), str3, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1)});
                        String str4 = "";
                        try {
                            str4 = URLEncoder.encode(str3, "UTF-8");
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.FavoriteIndexUI", e, "", new Object[0]);
                        }
                        com.tencent.mm.plugin.report.service.h.mEJ.h(13378, new Object[]{str4, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(1)});
                    }
                }
            }
            com.tencent.mm.plugin.report.service.h.mEJ.h(11125, new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(1)});
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 4105:
            case 4106:
                com.tencent.mm.plugin.fav.a.i.Bl(".ui.transmit.SelectConversationUI");
                break;
        }
        x.i("MicroMsg.FavoriteIndexUI", "onActivityResult reqCode: %d, retCod: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        String stringExtra;
        String stringExtra2;
        if (i2 == -1) {
            int i3 = 2;
            stringExtra = intent.getStringExtra("custom_send_text");
            switch (i) {
                case 4096:
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    if (stringArrayListExtra != null && stringArrayListExtra.size() != 0) {
                        i3 = 0;
                        this.iYd.post(new 7(this, stringArrayListExtra));
                        break;
                    }
                    x.e("MicroMsg.FavoriteIndexUI", "onActivityResult pathList is null or nil");
                    return;
                    break;
                case 4097:
                    final double doubleExtra = intent.getDoubleExtra("kwebmap_slat", 0.0d);
                    final double doubleExtra2 = intent.getDoubleExtra("kwebmap_lng", 0.0d);
                    final int intExtra = intent.getIntExtra("kwebmap_scale", 0);
                    final String aG = bi.aG(intent.getStringExtra("Kwebmap_locaion"), "");
                    final CharSequence charSequenceExtra = intent.getCharSequenceExtra("kRemark");
                    final String stringExtra3 = intent.getStringExtra("kPoiName");
                    final ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("kTags");
                    this.iYd.post(new Runnable() {
                        public final void run() {
                            FavoriteIndexUI.this.iXX = true;
                            double d = doubleExtra;
                            double d2 = doubleExtra2;
                            int i = intExtra;
                            String str = aG;
                            CharSequence charSequence = charSequenceExtra;
                            String str2 = stringExtra3;
                            List<String> list = stringArrayListExtra2;
                            we weVar = new we();
                            weVar.Vn(str);
                            weVar.z(d);
                            weVar.y(d2);
                            weVar.CK(i);
                            weVar.Vo(str2);
                            g gVar = new g();
                            gVar.field_type = 6;
                            gVar.field_sourceType = 6;
                            gVar.field_favProto.b(weVar);
                            if (!(charSequence == null || bi.oW(charSequence.toString()))) {
                                gVar.field_favProto.Vt(charSequence.toString());
                                gVar.field_favProto.fS(bi.VF());
                                com.tencent.mm.plugin.report.service.h.mEJ.h(10873, new Object[]{Integer.valueOf(6)});
                            }
                            g.E(gVar);
                            if (!(list == null || list.isEmpty())) {
                                for (String Bj : list) {
                                    gVar.Bj(Bj);
                                }
                            }
                            b.B(gVar);
                            com.tencent.mm.plugin.report.service.h.mEJ.h(10648, new Object[]{Integer.valueOf(3), Integer.valueOf(0)});
                            com.tencent.mm.plugin.fav.a.b.dn(gVar.field_localId);
                            long j = gVar.field_localId;
                            g dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(j);
                            if (dy != null && dy.field_favProto.rAL != null) {
                                com.tencent.mm.plugin.fav.a.b.a(j, dy.field_favProto.rAL, "", "", new ArrayList(), FavoriteIndexUI.this.mController.tml);
                            }
                        }
                    });
                    i3 = 0;
                    break;
                case 4098:
                    stringExtra = l.d(getApplicationContext(), intent, com.tencent.mm.plugin.p.c.Gb());
                    if (stringExtra != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 4);
                        intent2.putExtra("CropImage_Filter", true);
                        intent2.putExtra("CropImage_ImgPath", stringExtra);
                        intent2.setClassName(this.mController.tml, "com.tencent.mm.ui.tools.CropImageNewUI");
                        startActivityForResult(intent2, 4099);
                        break;
                    }
                    x.w("MicroMsg.FavoriteIndexUI", "take picture result path is null");
                    return;
                case 4099:
                    stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    if (stringExtra != null) {
                        i3 = 0;
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(stringExtra);
                        this.iYd.post(new 6(this, arrayList));
                        break;
                    }
                    x.w("MicroMsg.FavoriteIndexUI", "crop picture resutl path is null");
                    return;
                case 4100:
                    stringExtra2 = intent.getStringExtra("choosed_file_path");
                    if (!bi.oW(stringExtra2)) {
                        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(stringExtra2);
                        if (bVar.exists()) {
                            if (bVar.length() < jaZ) {
                                Object obj;
                                if (bi.oW(stringExtra2)) {
                                    obj = null;
                                } else {
                                    bVar = new com.tencent.mm.vfs.b(stringExtra2);
                                    if (bVar.exists()) {
                                        g gVar = new g();
                                        gVar.field_type = 8;
                                        gVar.field_sourceType = 6;
                                        g.E(gVar);
                                        gVar.field_favProto.Vu(bVar.getName());
                                        vx vxVar = new vx();
                                        vxVar.UP(stringExtra2);
                                        vxVar.kY(true);
                                        vxVar.UB(bVar.getName());
                                        vxVar.CF(gVar.field_type);
                                        if (stringExtra2 == null || stringExtra2.length() <= 0) {
                                            stringExtra2 = "";
                                        } else {
                                            stringExtra2 = new com.tencent.mm.vfs.b(stringExtra2).getName();
                                            int lastIndexOf = stringExtra2.lastIndexOf(46);
                                            stringExtra2 = (lastIndexOf <= 0 || lastIndexOf == stringExtra2.length() - 1) ? "" : stringExtra2.substring(lastIndexOf + 1);
                                        }
                                        vxVar.UL(stringExtra2);
                                        gVar.field_favProto.rBI.add(vxVar);
                                        b.B(gVar);
                                        com.tencent.mm.plugin.report.service.h.mEJ.h(10648, new Object[]{Integer.valueOf(5), Integer.valueOf(0)});
                                        obj = 1;
                                    } else {
                                        obj = null;
                                    }
                                }
                                if (obj == null) {
                                    i3 = 1;
                                    break;
                                }
                                i3 = 0;
                                this.iXX = true;
                                break;
                            }
                            i3 = 3;
                            break;
                        }
                        i3 = 1;
                        break;
                    }
                    i3 = 1;
                    break;
                    break;
                case 4101:
                case 4102:
                    i3 = 0;
                    this.iXX = true;
                    break;
                case 4103:
                    long longExtra = intent.getLongExtra("key_fav_result_local_id", -1);
                    if (-1 != longExtra) {
                        i3 = this.jbb.dD(longExtra);
                        if (-1 != i3) {
                            this.iYa.removeFooterView(this.iYe);
                            this.iYa.setSelection(i3);
                            return;
                        }
                        return;
                    }
                    return;
                case 4104:
                    List eU = this.jbb.eU(false);
                    String[] stringArrayExtra = intent.getStringArrayExtra("key_fav_result_array");
                    if (!(eU.isEmpty() || stringArrayExtra == null || stringArrayExtra.length <= 0)) {
                        com.tencent.mm.kernel.g.Em().H(new 4(this, eU, stringArrayExtra, com.tencent.mm.ui.base.h.a(this.mController.tml, "", false, null)));
                        com.tencent.mm.plugin.report.service.h.mEJ.h(11125, new Object[]{Integer.valueOf(stringArrayExtra.length), Integer.valueOf(2)});
                        break;
                    }
                case 4105:
                    x.d("MicroMsg.FavoriteIndexUI", "select %s for sending", new Object[]{intent.getStringExtra("Select_Conv_User")});
                    a(this.jbb.eU(false), stringExtra, r4);
                    break;
                case 4106:
                    x.d("MicroMsg.FavoriteIndexUI", "select %s for sending", new Object[]{intent.getStringExtra("Select_Conv_User")});
                    List arrayList2 = new ArrayList();
                    arrayList2.add(this.jbg);
                    a(arrayList2, stringExtra, r4);
                    break;
            }
            if (i3 == 0) {
                com.tencent.mm.ui.base.h.bA(this.mController.tml, getString(i.favorite_ok));
            } else if (1 == i3) {
                com.tencent.mm.ui.base.h.bA(this.mController.tml, getString(i.favorite_fail));
            } else if (3 == i3) {
                Toast.makeText(this.mController.tml, getString(i.favorite_too_large), 1).show();
            } else if (this.jbb.jbI) {
                aMw();
            }
        } else if ((this.jbg != null && this.jbg.field_type == 5) || (this.jbd != null && this.jbd.field_type == 5)) {
            stringExtra2 = "";
            if (this.jbd == null || this.jbd.field_favProto.rBG == null) {
                if (this.jbg.field_favProto.rAN != null) {
                    stringExtra2 = this.jbg.field_favProto.rAN.rCn;
                }
                if (this.jbg.field_favProto.rBG != null && bi.oW(r2)) {
                    stringExtra2 = this.jbg.field_favProto.rBG.egr;
                }
            } else {
                stringExtra2 = this.jbd.field_favProto.rBG.egr;
            }
            if (!bi.oW(stringExtra2)) {
                x.d("MicroMsg.FavoriteIndexUI", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), stringExtra2, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3)});
                stringExtra = "";
                try {
                    stringExtra2 = URLEncoder.encode(stringExtra2, "UTF-8");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FavoriteIndexUI", e, "", new Object[0]);
                    stringExtra2 = stringExtra;
                }
                com.tencent.mm.plugin.report.service.h.mEJ.h(13378, new Object[]{stringExtra2, Long.valueOf(this.startTime), Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(3)});
            }
        }
    }

    public final void dC(long j) {
        if (this.jbb.jbI) {
            com.tencent.mm.plugin.fav.ui.widget.b bVar = this.jbc;
            boolean z = this.jbb.aMG() > 0;
            if (bVar.jff) {
                bVar.jfj.setEnabled(z);
                bVar.jfk.setEnabled(z);
                bVar.jfl.setEnabled(z);
            }
        }
    }

    @SuppressLint({"ResourceType"})
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem add = menu.add(0, 10, 0, i.top_item_desc_search);
        add.setIcon(h.actionbar_icon_dark_search);
        android.support.v4.view.m.a(add, 2);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 10) {
            return super.onOptionsItemSelected(menuItem);
        }
        Intent intent = new Intent();
        intent.putExtra("key_enter_fav_search_from", 0);
        Bundle bundle = null;
        if (VERSION.SDK_INT >= 21) {
            bundle = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
        }
        if (this.jbb.jbI) {
            intent.putExtra("key_search_type", 2);
            com.tencent.mm.plugin.fav.a.b.a(this, ".ui.FavSearchUI", intent, 4103, bundle);
        } else {
            com.tencent.mm.plugin.fav.a.b.a(this, ".ui.FavSearchUI", intent, bundle);
        }
        return true;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.FavoriteIndexUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case a$k.AppCompatTheme_imageButtonStyle /*64*/:
                if (iArr[0] == 0) {
                    Intent intent = new Intent();
                    intent.putExtra("MMActivity.OverrideExitAnimation", m.a.push_down_out);
                    intent.putExtra("MMActivity.OverrideEnterAnimation", m.a.fast_faded_in);
                    intent.putExtra("map_view_type", 3);
                    com.tencent.mm.bg.d.b(this, "location", ".ui.RedirectUI", intent, 4097);
                    return;
                }
                com.tencent.mm.ui.base.h.a(this, getString(i.permission_location_request_again_msg), "", getString(i.jump_to_settings), getString(i.app_cancel), false, new 11(this), new 13(this));
                return;
            case a$k.AppCompatTheme_panelMenuListTheme /*80*/:
                if (iArr[0] == 0) {
                    com.tencent.mm.plugin.fav.a.b.a(this, ".ui.FavPostVoiceUI", new Intent(), 4102);
                    overridePendingTransition(0, 0);
                    return;
                }
                com.tencent.mm.ui.base.h.a(this, getString(i.permission_microphone_request_again_msg), "", getString(i.jump_to_settings), getString(i.app_cancel), false, new 9(this), new 10(this));
                return;
            default:
                return;
        }
    }

    public final void aMx() {
        Intent intent = new Intent();
        intent.putExtra("key_enter_fav_cleanui_from", 0);
        com.tencent.mm.plugin.fav.a.b.a(this.mController.tml, ".ui.FavCleanUI", intent);
    }

    public static void a(List<g> list, String[] strArr) {
        if (list != null && !list.isEmpty() && strArr != null && strArr.length > 0) {
            List<g> linkedList = new LinkedList();
            for (g gVar : list) {
                int i = 0;
                for (String Bj : strArr) {
                    i |= gVar.Bj(Bj);
                }
                if (i != 0) {
                    ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().a(gVar, new String[]{"localId"});
                    com.tencent.mm.plugin.fav.a.b.p(gVar);
                    linkedList.add(gVar);
                }
            }
            for (g a : linkedList) {
                com.tencent.mm.plugin.fav.a.b.a(a, 3);
            }
        }
    }

    public static boolean a(List<g> list, Context context, OnClickListener onClickListener) {
        if (list == null || list.isEmpty()) {
            return true;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        com.tencent.mm.plugin.fav.a.k kVar = new com.tencent.mm.plugin.fav.a.k();
        Object obj = null;
        int i4 = 0;
        for (g gVar : list) {
            if (!(gVar == null || gVar.field_favProto == null || gVar.field_favProto.rBI == null)) {
                if (gVar.field_type == 3) {
                    i3++;
                } else {
                    int i5;
                    Iterator it = gVar.field_favProto.rBI.iterator();
                    int i6 = 0;
                    while (it.hasNext()) {
                        vx vxVar = (vx) it.next();
                        if (vxVar.rAw == 2) {
                            i++;
                        } else if (vxVar.rAw == 1) {
                            i2++;
                        } else {
                            i6++;
                        }
                    }
                    if (com.tencent.mm.plugin.fav.a.k.u(gVar)) {
                        i5 = i4 + 1;
                        if (i6 > 0) {
                            i6--;
                        }
                    } else {
                        i5 = i4;
                    }
                    if (obj == null && r7 == gVar.field_favProto.rBI.size()) {
                        obj = 1;
                    }
                    obj = obj;
                    i4 = i5;
                }
            }
        }
        if (1 == list.size()) {
            if (((g) list.get(0)).field_type == 14 && (i > 0 || i2 > 0)) {
                com.tencent.mm.ui.base.h.bA(context, context.getString(i.favorite_detail_illegal_trans_big_expired));
                return false;
            } else if (i > 0) {
                com.tencent.mm.ui.base.h.bA(context, context.getString(i.favorite_detail_illegal_trans_big_file));
                return false;
            } else if (i2 > 0) {
                switch (((g) list.get(0)).field_type) {
                    case 2:
                        com.tencent.mm.ui.base.h.bA(context, context.getString(i.favorite_detail_illegal_trans_image));
                        break;
                    case 4:
                    case 16:
                        com.tencent.mm.ui.base.h.bA(context, context.getString(i.favorite_detail_illegal_trans_video));
                        break;
                    case 8:
                        com.tencent.mm.ui.base.h.bA(context, context.getString(i.favorite_detail_illegal_trans_file));
                        break;
                }
                return false;
            } else if (i4 > 0) {
                com.tencent.mm.ui.base.h.bA(context, context.getString(i.Fav_NotDownload_CannotForward));
                return false;
            } else if (i3 > 0) {
                com.tencent.mm.ui.base.h.bA(context, context.getString(i.Fav_Voice_CannotForward));
                return false;
            }
        } else if (i > 0 || i2 > 0 || i4 > 0 || i3 > 0) {
            if (obj != null) {
                com.tencent.mm.ui.base.h.a(context, context.getString(i.favorite_detail_illegal_transmay_tips_yes), "", context.getString(i.confirm_dialog_ok), context.getString(i.confirm_dialog_cancel), onClickListener, null, m.b.wechat_green);
            } else {
                com.tencent.mm.ui.base.h.bA(context, context.getString(i.favorite_detail_illegal_transmay_tips_no));
            }
            return false;
        }
        return true;
    }
}
