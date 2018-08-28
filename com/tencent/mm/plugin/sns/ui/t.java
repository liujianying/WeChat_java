package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.mm.ab.e;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.cb;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.g.a.kh;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.g.a.qr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;
import java.util.List;

public final class t implements e {
    int bJr;
    int bJs;
    final Context context;
    public int hcA = 0;
    c iYS = new 10(this);
    String nMT;
    String nMW;
    boolean nMX = false;
    SnsCmdList nND = new SnsCmdList();
    private final a nNE;
    d nNF = null;
    boolean nNG;
    ate nNH;
    private final String nNI;
    c nNd = new c<kh>() {
        {
            this.sFo = kh.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            kh khVar = (kh) bVar;
            if (khVar == null || !(khVar instanceof kh)) {
                x.e("MicroMsg.GalleryTitleManager", "event is null or not a instant of NotifyDealQBarStrResultEvent");
            } else {
                x.i("MicroMsg.GalleryTitleManager", "notify Event: %d", new Object[]{Integer.valueOf(khVar.bUG.bUE)});
                if (!(khVar.bUG.activity == ((Activity) t.this.context) && khVar.bUG.bHL.equals(t.this.nMW))) {
                    x.e("MicroMsg.GalleryTitleManager", "not the same");
                }
            }
            return false;
        }
    };
    n nhc;
    String sm;
    public p tipDialog = null;

    static /* synthetic */ void NP(String str) {
        qr qrVar = new qr();
        qrVar.cbg.bOh = 3;
        qrVar.cbg.bNH = str;
        a.sFg.m(qrVar);
    }

    static /* synthetic */ void NQ(String str) {
        qr qrVar = new qr();
        qrVar.cbg.bOh = 1;
        qrVar.cbg.cbj = 2;
        qrVar.cbg.bNH = str;
        a.sFg.m(qrVar);
    }

    static /* synthetic */ void a(t tVar, Bundle bundle) {
        x.i("MicroMsg.GalleryTitleManager", "request deal QBAR string");
        cb cbVar = new cb();
        cbVar.bJq.activity = (Activity) tVar.context;
        cbVar.bJq.bHL = tVar.nMW;
        cbVar.bJq.bJr = tVar.bJr;
        cbVar.bJq.bJs = tVar.bJs;
        cbVar.bJq.bJx = bundle;
        a.sFg.m(cbVar);
    }

    static /* synthetic */ void a(t tVar, n nVar, ate ate) {
        ch chVar;
        if (nVar == null) {
            x.i("MicroMsg.GalleryTitleManager", "error beacause info null");
        } else if (nVar.field_type == 1) {
            chVar = new ch();
            com.tencent.mm.plugin.sns.i.a.a(chVar, nVar, ate.ksA);
            chVar.bJF.activity = (Activity) tVar.context;
            chVar.bJF.bJM = 15;
            a.sFg.m(chVar);
        } else if (nVar == null) {
        } else {
            if (nVar.xb(32)) {
                chVar = new ch();
                com.tencent.mm.plugin.sns.i.a.a(chVar, nVar);
                chVar.bJF.activity = (Activity) tVar.context;
                chVar.bJF.bJM = 16;
                a.sFg.m(chVar);
                return;
            }
            String bBe = nVar.bBe();
            qr qrVar = new qr();
            qrVar.cbg.bOh = 2;
            qrVar.cbg.cbh = 16;
            qrVar.cbg.cbi = false;
            qrVar.cbg.bNH = bBe;
            a.sFg.m(qrVar);
        }
    }

    public final void xg(int i) {
        if (i != 0) {
            this.nND.wj(i);
        }
    }

    public t(Context context, a aVar) {
        this.context = context;
        this.nNE = aVar;
        this.nNI = ((Activity) context).getIntent().getStringExtra("sns_gallery_pre_title");
    }

    public final void bBY() {
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", this.nND);
        ((Activity) this.context).setResult(-1, intent);
        ((Activity) this.context).finish();
    }

    public final void a(boolean z, final n nVar, final ate ate, boolean z2, final int i) {
        this.nNG = z;
        this.nhc = nVar;
        this.nNH = ate;
        this.sm = ate.ksA;
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        dj djVar;
        if (!z) {
            nVar.bAJ();
            arrayList.add(this.context.getString(j.sns_post_to));
            arrayList2.add(Integer.valueOf(3));
            if (com.tencent.mm.bg.d.QS("favorite")) {
                arrayList.add(this.context.getString(j.plugin_favorite_opt));
                arrayList2.add(Integer.valueOf(6));
            }
            if (nVar.field_type == 15 || nVar.field_type == 5) {
                arrayList.add(this.context.getString(j.save_video_to_local));
                arrayList2.add(Integer.valueOf(2));
            } else if (nVar.field_type == 1) {
                arrayList.add(this.context.getString(j.save_img_to_local));
                arrayList2.add(Integer.valueOf(2));
            } else {
                arrayList.add(this.context.getString(j.sns_save_to_sns));
                arrayList2.add(Integer.valueOf(2));
            }
            djVar = new dj();
            djVar.bLf.bKW = nVar.bBe();
            a.sFg.m(djVar);
            if (djVar.bLg.bKE) {
                arrayList.add(this.context.getString(j.app_open));
                arrayList2.add(Integer.valueOf(8));
            }
            if (this.nMW != null) {
                arrayList.add(com.tencent.mm.plugin.scanner.a.aB(this.bJr, this.nMW) ? this.context.getString(j.recog_wxcode_of_image_file) : this.context.getString(j.recog_qbar_of_image_file));
                arrayList2.add(Integer.valueOf(7));
            }
            if (arrayList.size() != 0) {
                if (this.nNF == null || !this.nMX) {
                    this.nNF = new d(this.context, 1, false);
                } else {
                    this.nMX = false;
                }
                this.nNF.ofp = new 5(this, arrayList, arrayList2);
                this.nNF.ofq = new 6(this, nVar, ate, i);
                this.nNF.bXO();
            }
        } else if (nVar != null) {
            if (nVar.field_localPrivate > 0) {
                if (!bi.oW(af.bxU()) && af.bxU().equals(nVar.field_userName)) {
                    arrayList.add(this.context.getString(j.sns_set_open));
                    arrayList2.add(Integer.valueOf(5));
                }
                arrayList.add(this.context.getString(j.sns_post_to));
                arrayList2.add(Integer.valueOf(3));
            } else {
                arrayList.add(this.context.getString(j.sns_set_private));
                arrayList2.add(Integer.valueOf(1));
                arrayList.add(this.context.getString(j.sns_post_to));
                arrayList2.add(Integer.valueOf(3));
            }
            if (com.tencent.mm.bg.d.QS("favorite")) {
                arrayList.add(this.context.getString(j.plugin_favorite_opt));
                arrayList2.add(Integer.valueOf(6));
            }
            if (nVar.field_type == 15 || nVar.field_type == 5) {
                arrayList.add(this.context.getString(j.save_video_to_local));
                arrayList2.add(Integer.valueOf(2));
            } else if (nVar.field_type == 1) {
                arrayList.add(this.context.getString(j.save_img_to_local));
                arrayList2.add(Integer.valueOf(2));
            } else {
                arrayList.add(this.context.getString(j.sns_save_to_sns));
                arrayList2.add(Integer.valueOf(2));
            }
            djVar = new dj();
            djVar.bLf.bKW = nVar.bBe();
            a.sFg.m(djVar);
            if (djVar.bLg.bKE) {
                arrayList.add(this.context.getString(j.app_open));
                arrayList2.add(Integer.valueOf(8));
            }
            if (this.nMW != null) {
                arrayList.add(com.tencent.mm.plugin.scanner.a.aB(this.bJr, this.nMW) ? this.context.getString(j.recog_wxcode_of_image_file) : this.context.getString(j.recog_qbar_of_image_file));
                arrayList2.add(Integer.valueOf(7));
            }
            if (this.nNF == null || !this.nMX) {
                this.nNF = new d(this.context, 1, false);
            } else {
                this.nMX = false;
            }
            this.nNF.ofp = new 1(this, arrayList, arrayList2);
            this.nNF.ofq = new com.tencent.mm.ui.base.n.d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    int itemId = menuItem.getItemId();
                    x.d("MicroMsg.GalleryTitleManager", "showAlertWithDel " + itemId);
                    t tVar;
                    r rVar;
                    Context context;
                    switch (itemId) {
                        case -1:
                            if (nVar.bAJ().sqc.ruA.size() > 1) {
                                h.a(t.this.context, t.this.context.getString(j.sns_photos_del), "", new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        t.this.A(nVar);
                                    }
                                }, null);
                                return;
                            } else {
                                h.a(t.this.context, t.this.context.getString(j.sns_photo_del), "", new 2(this), null);
                                return;
                            }
                        case 1:
                            tVar = t.this;
                            n nVar = nVar;
                            if (nVar.bBf() || nVar.bBg()) {
                                af.byo().xe(nVar.nJc);
                                return;
                            }
                            rVar = new r(nVar.field_snsId, 2);
                            g.Ek();
                            g.Eh().dpP.a(rVar, 0);
                            context = tVar.context;
                            tVar.context.getString(j.app_tip);
                            tVar.tipDialog = h.a(context, tVar.context.getString(j.sns_setPrivateing_sns), true, new 8(tVar, rVar));
                            return;
                        case 2:
                            if (nVar != null && nVar.bAJ().sqc != null) {
                                if (nVar.field_type != 15) {
                                    l.i(an.s(af.getAccSnsPath(), ate.ksA) + i.l(ate), t.this.context);
                                    return;
                                } else {
                                    t.NP(nVar.bBe());
                                    return;
                                }
                            }
                            return;
                        case 3:
                            if (nVar != null && nVar.bAJ().sqc != null) {
                                if (nVar.bAJ().sqc.ruz == 1) {
                                    t.this.NO(an.s(af.getAccSnsPath(), ate.ksA) + i.l(ate));
                                    return;
                                }
                                t.NQ(nVar.bBe());
                                return;
                            }
                            return;
                        case 5:
                            tVar = t.this;
                            rVar = new r(nVar.field_snsId, 3);
                            g.Ek();
                            g.Eh().dpP.a(rVar, 0);
                            context = tVar.context;
                            tVar.context.getString(j.app_tip);
                            tVar.tipDialog = h.a(context, tVar.context.getString(j.sns_setPrivateing_sns), true, new 9(tVar, rVar));
                            return;
                        case 6:
                            if (nVar != null && nVar.bAJ().sqc != null) {
                                t.a(t.this, nVar, ate);
                                return;
                            }
                            return;
                        case 7:
                            Bundle bundle = new Bundle();
                            bundle.putString("stat_msg_id", "sns_" + i.eF(nVar.field_snsId));
                            bundle.putString("stat_send_msg_user", nVar.field_userName);
                            bundle.putInt("stat_scene", 3);
                            t.a(t.this, bundle);
                            return;
                        case 8:
                            t.a(t.this, nVar, ate, i);
                            return;
                        default:
                            return;
                    }
                }
            };
            this.nNF.uJQ = new d.a() {
                public final void onDismiss() {
                    ak akVar = new ak();
                    akVar.bHM.filePath = t.this.nMT;
                    a.sFg.m(akVar);
                    t.this.nNF = null;
                    t.this.nMT = null;
                    t.this.nhc = null;
                    t.this.sm = null;
                    t.this.nMW = null;
                    t tVar = t.this;
                    t.this.bJs = 0;
                    tVar.bJr = 0;
                }
            };
            this.nNF.bXO();
        } else {
            return;
        }
        if (true == z2) {
            g.Ek();
            if (g.Eh().dpP.Lg() != 0) {
                ms msVar = new ms();
                String str = an.s(af.getAccSnsPath(), this.sm) + i.l(ate);
                msVar.bXH.filePath = str;
                this.nMT = str;
                a.sFg.m(msVar);
            }
        }
    }

    protected final void A(n nVar) {
        if (nVar.bBf() || nVar.bBg()) {
            af.byo().xe(nVar.nJc);
            this.nND.wj(nVar.nJc);
            return;
        }
        af.byn().eS(nVar.field_snsId);
        r rVar = new r(nVar.field_snsId, 1);
        g.Ek();
        g.Eh().dpP.a(rVar, 0);
        Context context = this.context;
        this.context.getString(j.app_tip);
        this.tipDialog = h.a(context, this.context.getString(j.sns_deling_sns), true, new 7(this, rVar));
    }

    protected final void NO(String str) {
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", str);
        intent.putExtra("Retr_Compress_Type", 0);
        intent.putExtra("Retr_Msg_Type", 0);
        com.tencent.mm.plugin.sns.c.a.ezn.l(intent, this.context);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if (i == 0 && i2 == 0 && lVar != null) {
            x.i("MicroMsg.GalleryTitleManager", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " type = " + lVar.getType() + " @" + hashCode());
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            r rVar = (r) lVar;
            switch (rVar.type) {
                case -1:
                    this.nNE.ci("", rVar.type);
                    return;
                case 1:
                    this.nND.wj(rVar.nkZ);
                    this.nNE.ci(v.ai("sns_table_", (long) rVar.nkZ), rVar.type);
                    return;
                case 2:
                    this.nND.wk(rVar.nkZ);
                    this.nNE.ci("", rVar.type);
                    return;
                case 3:
                    this.nND.wk(rVar.nkZ);
                    this.nNE.ci(v.ai("sns_table_", (long) rVar.nkZ), rVar.type);
                    return;
                default:
                    return;
            }
        }
    }
}
