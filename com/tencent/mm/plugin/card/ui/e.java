package com.tencent.mm.plugin.card.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.b.g.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.plugin.card.ui.view.d;
import com.tencent.mm.plugin.card.ui.view.i;
import com.tencent.mm.plugin.card.ui.view.j;
import com.tencent.mm.plugin.card.ui.view.k;
import com.tencent.mm.plugin.card.ui.view.m;
import com.tencent.mm.plugin.card.ui.view.u;
import com.tencent.mm.plugin.card.ui.view.w;
import com.tencent.mm.plugin.card.ui.view.y;
import com.tencent.mm.plugin.card.ui.view.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.pluginsdk.ui.applet.t;
import com.tencent.mm.protocal.c.ax;
import com.tencent.mm.protocal.c.la;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.protocal.c.sd;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public final class e implements a, n, MMActivity.a {
    ListView CU;
    private final String TAG = "MicroMsg.CardDetailUIContoller";
    boolean bPd = false;
    LinearLayout bo;
    OnClickListener eZF = new 4(this);
    CardDetailBaseUI hBT;
    g hBU;
    i hBV;
    boolean hBW = false;
    i hBX;
    i hBY;
    com.tencent.mm.plugin.card.widget.g hBZ;
    com.tencent.mm.plugin.card.ui.view.g hCa;
    m hCb;
    i hCc;
    i hCd;
    i hCe;
    i hCf;
    i hCg;
    i hCh;
    i hCi;
    i hCj;
    d hCk;
    i hCl;
    j hCm;
    boolean hCn = true;
    f hCo;
    public String hCp = "";
    public String hCq = "";
    HashMap<Integer, String> hCr = new HashMap();
    HashMap<String, String> hCs = new HashMap();
    ArrayList<String> hCt = new ArrayList();
    d hCu;
    a hCv;
    private ag hCw = new 3(this);
    c hCx = new 7(this);
    b htQ;
    List<com.tencent.mm.plugin.card.model.b> htU = new ArrayList();
    ArrayList<la> htW;
    private View hyK;
    public int hzB = 0;
    String hzC = "";
    String hzD = "";
    public ArrayList<String> hzE = new ArrayList();
    public ArrayList<String> hzF = new ArrayList();

    static /* synthetic */ void a(e eVar) {
        Intent intent = new Intent();
        if (eVar.htQ instanceof CardInfo) {
            intent.putExtra("key_card_info_data", (CardInfo) eVar.htQ);
        } else if (eVar.htQ instanceof ShareCardInfo) {
            intent.putExtra("key_card_info_data", (ShareCardInfo) eVar.htQ);
        }
        intent.putExtra("key_from_appbrand_type", eVar.hCv.hCB);
        intent.setClass(eVar.hBT, CardShopUI.class);
        eVar.hBT.startActivity(intent);
        h hVar = h.mEJ;
        Object[] objArr = new Object[9];
        objArr[0] = "UsedStoresView";
        objArr[1] = Integer.valueOf(eVar.htQ.awm().huV);
        objArr[2] = eVar.htQ.awr();
        objArr[3] = eVar.htQ.awq();
        objArr[4] = Integer.valueOf(0);
        objArr[5] = Integer.valueOf(eVar.hCv.hza);
        objArr[6] = eVar.hCv.hBD;
        objArr[7] = Integer.valueOf(eVar.htQ.awk() ? 1 : 0);
        objArr[8] = "";
        hVar.h(11324, objArr);
    }

    public e(CardDetailBaseUI cardDetailBaseUI, View view) {
        this.hBT = cardDetailBaseUI;
        this.hyK = view;
    }

    public final void a(b bVar, a aVar, ArrayList<la> arrayList) {
        this.htQ = bVar;
        this.hCv = aVar;
        this.htW = arrayList;
    }

    public final View findViewById(int i) {
        return this.hyK.findViewById(i);
    }

    public final b ayu() {
        return this.htQ;
    }

    public final void d(b bVar) {
        if (bVar != null) {
            this.htQ = bVar;
            if (this.hCu != null) {
                this.hCu.d(bVar);
            }
            axM();
        }
    }

    public final boolean ayv() {
        return this.hBW;
    }

    public final void ayw() {
        this.hBW = false;
    }

    public final MMActivity ayx() {
        return this.hBT;
    }

    public final OnClickListener ayy() {
        return this.eZF;
    }

    public final g ayz() {
        return this.hBU;
    }

    public final d ayA() {
        return this.hCu;
    }

    public final a ayB() {
        return this.hCv;
    }

    public final f ayC() {
        return this.hCo;
    }

    public final j ayD() {
        return this.hCm;
    }

    public final String getString(int i) {
        return this.hBT.getString(i);
    }

    public final void axM() {
        if (this.htQ == null) {
            x.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo == null");
            if (this.hCu != null) {
                this.hCu.ayr();
            }
        } else if (this.htQ.awm() == null) {
            x.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getCardTpInfo() == null");
            if (this.hCu != null) {
                this.hCu.ayr();
            }
        } else if (this.htQ.awn() == null) {
            x.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getDataInfo() == null");
            if (this.hCu != null) {
                this.hCu.ayr();
            }
        } else if (this.htQ.avY()) {
            int i;
            x.i("MicroMsg.CardDetailUIContoller", "doUpdate()");
            x.i("MicroMsg.CardDetailUIContoller", "doUpdate() showAcceptView:" + this.htQ.awm().roh);
            f fVar = this.hCo;
            b bVar = this.htQ;
            ArrayList arrayList = this.htW;
            int i2 = this.hCv.hop;
            fVar.htQ = bVar;
            fVar.htW = arrayList;
            fVar.hop = i2;
            boolean z = this.hBU == null ? false : this.htQ.avS() ? !(this.hBU instanceof com.tencent.mm.plugin.card.ui.a.h) : this.htQ.avT() ? !(this.hBU instanceof com.tencent.mm.plugin.card.ui.a.e) : this.htQ.avW() ? !(this.hBU instanceof com.tencent.mm.plugin.card.ui.a.b) : this.htQ.avU() ? !(this.hBU instanceof com.tencent.mm.plugin.card.ui.a.c) : this.htQ.avV() ? !(this.hBU instanceof com.tencent.mm.plugin.card.ui.a.f) : this.htQ.avX() ? !(this.hBU instanceof com.tencent.mm.plugin.card.ui.a.d) : !(this.hBU instanceof com.tencent.mm.plugin.card.ui.a.a);
            if (z) {
                this.hBU.release();
                this.hBU = null;
                x.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, need recreate show logic, card_type:%d", new Object[]{Integer.valueOf(this.htQ.awm().huV)});
            }
            if (this.hBU == null) {
                x.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, mCardShowLogic == null, card_type:%d", new Object[]{Integer.valueOf(this.htQ.awm().huV)});
                x.i("MicroMsg.CardDetailUIContoller", "createShowLogic, card_type:%d", new Object[]{Integer.valueOf(this.htQ.awm().huV)});
                if (!this.htQ.avS()) {
                    switch (this.htQ.awm().huV) {
                        case 0:
                            this.hBU = new com.tencent.mm.plugin.card.ui.a.c(this.hBT);
                            break;
                        case 10:
                            this.hBU = new com.tencent.mm.plugin.card.ui.a.e(this.hBT);
                            break;
                        case 11:
                            this.hBU = new com.tencent.mm.plugin.card.ui.a.b(this.hBT);
                            break;
                        case 20:
                            this.hBU = new com.tencent.mm.plugin.card.ui.a.f(this.hBT);
                            break;
                        case a$k.AppCompatTheme_actionModeSplitBackground /*30*/:
                            this.hBU = new com.tencent.mm.plugin.card.ui.a.d(this.hBT);
                            break;
                        default:
                            this.hBU = new com.tencent.mm.plugin.card.ui.a.a(this.hBT);
                            break;
                    }
                }
                this.hBU = new com.tencent.mm.plugin.card.ui.a.h(this.hBT);
            }
            x.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, card_tye:%d", new Object[]{Integer.valueOf(this.htQ.awm().huV)});
            this.hBU.a(this.htQ, this.hCv);
            this.hBU.azH();
            x.i("MicroMsg.CardDetailUIContoller", "");
            if (this.hBU.azp()) {
                this.hBT.setMMTitle(this.hCo.getTitle());
            } else {
                this.hBT.setMMTitle("");
            }
            if (this.htQ == null) {
                x.e("MicroMsg.CardDetailUIContoller", "updateWidget, mCardInfo is null");
            } else {
                if (this.hBZ != null) {
                    if (this.htQ.avT()) {
                        if (!(this.hBZ instanceof com.tencent.mm.plugin.card.widget.e)) {
                            View azX;
                            z = true;
                            if (z) {
                                azX = this.hBZ.azX();
                                if (azX != null) {
                                    this.bo.removeView(azX);
                                }
                                this.bo.removeAllViews();
                                this.bo.invalidate();
                                this.hBZ.release();
                                this.hBZ = null;
                            }
                            if (this.hBZ == null) {
                                if (this.htQ.avT()) {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.e(this.hBT);
                                } else if (this.htQ.avW()) {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.c(this.hBT);
                                } else if (this.htQ.avU()) {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.b(this.hBT);
                                } else if (this.htQ.avV()) {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.f(this.hBT);
                                } else if (this.htQ.avX()) {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.d(this.hBT);
                                } else {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.b(this.hBT);
                                }
                                this.hBZ.k(this.htQ);
                                azX = this.hBZ.azX();
                                if (azX != null) {
                                    LinearLayout linearLayout = this.bo;
                                    azX.setLayoutParams(new LayoutParams(-1, -2));
                                    linearLayout.addView(azX);
                                }
                                this.bo.invalidate();
                                this.hBZ.setOnClickListener(this.eZF);
                                v(false, false);
                            }
                            if (this.hBZ != null) {
                                if (this.htQ.avV()) {
                                    ((com.tencent.mm.plugin.card.widget.f) this.hBZ).htW = this.htW;
                                }
                                this.hBZ.f(this.htQ);
                            }
                        }
                    } else if (this.htQ.avW()) {
                        if (!(this.hBZ instanceof com.tencent.mm.plugin.card.widget.c)) {
                            z = true;
                            if (z) {
                                azX = this.hBZ.azX();
                                if (azX != null) {
                                    this.bo.removeView(azX);
                                }
                                this.bo.removeAllViews();
                                this.bo.invalidate();
                                this.hBZ.release();
                                this.hBZ = null;
                            }
                            if (this.hBZ == null) {
                                if (this.htQ.avT()) {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.e(this.hBT);
                                } else if (this.htQ.avW()) {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.c(this.hBT);
                                } else if (this.htQ.avU()) {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.b(this.hBT);
                                } else if (this.htQ.avV()) {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.f(this.hBT);
                                } else if (this.htQ.avX()) {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.d(this.hBT);
                                } else {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.b(this.hBT);
                                }
                                this.hBZ.k(this.htQ);
                                azX = this.hBZ.azX();
                                if (azX != null) {
                                    LinearLayout linearLayout2 = this.bo;
                                    azX.setLayoutParams(new LayoutParams(-1, -2));
                                    linearLayout2.addView(azX);
                                }
                                this.bo.invalidate();
                                this.hBZ.setOnClickListener(this.eZF);
                                v(false, false);
                            }
                            if (this.hBZ != null) {
                                if (this.htQ.avV()) {
                                    ((com.tencent.mm.plugin.card.widget.f) this.hBZ).htW = this.htW;
                                }
                                this.hBZ.f(this.htQ);
                            }
                        }
                    } else if (this.htQ.avU()) {
                        if (!(this.hBZ instanceof com.tencent.mm.plugin.card.widget.b)) {
                            z = true;
                            if (z) {
                                azX = this.hBZ.azX();
                                if (azX != null) {
                                    this.bo.removeView(azX);
                                }
                                this.bo.removeAllViews();
                                this.bo.invalidate();
                                this.hBZ.release();
                                this.hBZ = null;
                            }
                            if (this.hBZ == null) {
                                if (this.htQ.avT()) {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.e(this.hBT);
                                } else if (this.htQ.avW()) {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.c(this.hBT);
                                } else if (this.htQ.avU()) {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.b(this.hBT);
                                } else if (this.htQ.avV()) {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.f(this.hBT);
                                } else if (this.htQ.avX()) {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.d(this.hBT);
                                } else {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.b(this.hBT);
                                }
                                this.hBZ.k(this.htQ);
                                azX = this.hBZ.azX();
                                if (azX != null) {
                                    LinearLayout linearLayout22 = this.bo;
                                    azX.setLayoutParams(new LayoutParams(-1, -2));
                                    linearLayout22.addView(azX);
                                }
                                this.bo.invalidate();
                                this.hBZ.setOnClickListener(this.eZF);
                                v(false, false);
                            }
                            if (this.hBZ != null) {
                                if (this.htQ.avV()) {
                                    ((com.tencent.mm.plugin.card.widget.f) this.hBZ).htW = this.htW;
                                }
                                this.hBZ.f(this.htQ);
                            }
                        }
                    } else if (this.htQ.avV()) {
                        if (!(this.hBZ instanceof com.tencent.mm.plugin.card.widget.f)) {
                            z = true;
                            if (z) {
                                azX = this.hBZ.azX();
                                if (azX != null) {
                                    this.bo.removeView(azX);
                                }
                                this.bo.removeAllViews();
                                this.bo.invalidate();
                                this.hBZ.release();
                                this.hBZ = null;
                            }
                            if (this.hBZ == null) {
                                if (this.htQ.avT()) {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.e(this.hBT);
                                } else if (this.htQ.avW()) {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.c(this.hBT);
                                } else if (this.htQ.avU()) {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.b(this.hBT);
                                } else if (this.htQ.avV()) {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.f(this.hBT);
                                } else if (this.htQ.avX()) {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.d(this.hBT);
                                } else {
                                    this.hBZ = new com.tencent.mm.plugin.card.widget.b(this.hBT);
                                }
                                this.hBZ.k(this.htQ);
                                azX = this.hBZ.azX();
                                if (azX != null) {
                                    LinearLayout linearLayout222 = this.bo;
                                    azX.setLayoutParams(new LayoutParams(-1, -2));
                                    linearLayout222.addView(azX);
                                }
                                this.bo.invalidate();
                                this.hBZ.setOnClickListener(this.eZF);
                                v(false, false);
                            }
                            if (this.hBZ != null) {
                                if (this.htQ.avV()) {
                                    ((com.tencent.mm.plugin.card.widget.f) this.hBZ).htW = this.htW;
                                }
                                this.hBZ.f(this.htQ);
                            }
                        }
                    } else if (this.htQ.avX() && !(this.hBZ instanceof com.tencent.mm.plugin.card.widget.d)) {
                        z = true;
                        if (z) {
                            azX = this.hBZ.azX();
                            if (azX != null) {
                                this.bo.removeView(azX);
                            }
                            this.bo.removeAllViews();
                            this.bo.invalidate();
                            this.hBZ.release();
                            this.hBZ = null;
                        }
                        if (this.hBZ == null) {
                            if (this.htQ.avT()) {
                                this.hBZ = new com.tencent.mm.plugin.card.widget.e(this.hBT);
                            } else if (this.htQ.avW()) {
                                this.hBZ = new com.tencent.mm.plugin.card.widget.c(this.hBT);
                            } else if (this.htQ.avU()) {
                                this.hBZ = new com.tencent.mm.plugin.card.widget.b(this.hBT);
                            } else if (this.htQ.avV()) {
                                this.hBZ = new com.tencent.mm.plugin.card.widget.f(this.hBT);
                            } else if (this.htQ.avX()) {
                                this.hBZ = new com.tencent.mm.plugin.card.widget.d(this.hBT);
                            } else {
                                this.hBZ = new com.tencent.mm.plugin.card.widget.b(this.hBT);
                            }
                            this.hBZ.k(this.htQ);
                            azX = this.hBZ.azX();
                            if (azX != null) {
                                LinearLayout linearLayout2222 = this.bo;
                                azX.setLayoutParams(new LayoutParams(-1, -2));
                                linearLayout2222.addView(azX);
                            }
                            this.bo.invalidate();
                            this.hBZ.setOnClickListener(this.eZF);
                            v(false, false);
                        }
                        if (this.hBZ != null) {
                            if (this.htQ.avV()) {
                                ((com.tencent.mm.plugin.card.widget.f) this.hBZ).htW = this.htW;
                            }
                            this.hBZ.f(this.htQ);
                        }
                    }
                }
                z = false;
                if (z) {
                    azX = this.hBZ.azX();
                    if (azX != null) {
                        this.bo.removeView(azX);
                    }
                    this.bo.removeAllViews();
                    this.bo.invalidate();
                    this.hBZ.release();
                    this.hBZ = null;
                }
                if (this.hBZ == null) {
                    if (this.htQ.avT()) {
                        this.hBZ = new com.tencent.mm.plugin.card.widget.e(this.hBT);
                    } else if (this.htQ.avW()) {
                        this.hBZ = new com.tencent.mm.plugin.card.widget.c(this.hBT);
                    } else if (this.htQ.avU()) {
                        this.hBZ = new com.tencent.mm.plugin.card.widget.b(this.hBT);
                    } else if (this.htQ.avV()) {
                        this.hBZ = new com.tencent.mm.plugin.card.widget.f(this.hBT);
                    } else if (this.htQ.avX()) {
                        this.hBZ = new com.tencent.mm.plugin.card.widget.d(this.hBT);
                    } else {
                        this.hBZ = new com.tencent.mm.plugin.card.widget.b(this.hBT);
                    }
                    this.hBZ.k(this.htQ);
                    azX = this.hBZ.azX();
                    if (azX != null) {
                        LinearLayout linearLayout22222 = this.bo;
                        azX.setLayoutParams(new LayoutParams(-1, -2));
                        linearLayout22222.addView(azX);
                    }
                    this.bo.invalidate();
                    this.hBZ.setOnClickListener(this.eZF);
                    v(false, false);
                }
                if (this.hBZ != null) {
                    if (this.htQ.avV()) {
                        ((com.tencent.mm.plugin.card.widget.f) this.hBZ).htW = this.htW;
                    }
                    this.hBZ.f(this.htQ);
                }
            }
            if (this.hBU.azq()) {
                x.i("MicroMsg.CardDetailUIContoller", "updateShareUsersInfoLayout()");
                this.hBV.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't updateShareUsersInfoLayout()");
                this.hBV.azI();
            }
            if (this.hBU.azh()) {
                if (this.hCl == null) {
                    this.hCl = new com.tencent.mm.plugin.card.ui.view.b();
                    this.hCl.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "update CardAcceptView()");
                this.hCl.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update CardAcceptView()");
                if (this.hCl != null) {
                    this.hCl.azI();
                }
            }
            this.hBT.dQ(this.hBU.azl());
            if (this.hBU.azm()) {
                this.hCr.clear();
                this.hCt.clear();
                if (this.htQ.awa()) {
                    this.hCt.add(getString(com.tencent.mm.plugin.card.a.g.card_wv_alert_share_to_friend));
                    this.hCr.put(Integer.valueOf(0), "menu_func_share_friend");
                    this.hCt.add(getString(com.tencent.mm.plugin.card.a.g.card_wv_alert_share_timeline));
                    this.hCr.put(Integer.valueOf(1), "menu_func_share_timeline");
                    i = 2;
                } else {
                    i = 0;
                }
                if (!TextUtils.isEmpty(this.htQ.awn().rng)) {
                    this.hCt.add(getString(com.tencent.mm.plugin.card.a.g.card_menu_report));
                    this.hCr.put(Integer.valueOf(i), "menu_func_report");
                    i++;
                }
                nU(i);
                if (this.hCt.size() > 0) {
                    this.hBT.dQ(true);
                }
            }
            if (this.hBU.azn()) {
                this.hCr.clear();
                this.hCt.clear();
                if (this.htQ.avR() && this.htQ.avZ()) {
                    this.hCt.add(getString(com.tencent.mm.plugin.card.a.g.card_menu_gift_card));
                    this.hCr.put(Integer.valueOf(0), "menu_func_gift");
                    i = 1;
                } else {
                    i = 0;
                }
                if (!TextUtils.isEmpty(this.htQ.awn().rng)) {
                    this.hCt.add(getString(com.tencent.mm.plugin.card.a.g.card_menu_report));
                    this.hCr.put(Integer.valueOf(i), "menu_func_report");
                    i++;
                }
                if (this.htQ.avR()) {
                    this.hCt.add(getString(com.tencent.mm.plugin.card.a.g.app_delete));
                    this.hCr.put(Integer.valueOf(i), "menu_func_delete");
                    i++;
                } else if (this.htQ.avS()) {
                    String GF = q.GF();
                    String aws = this.htQ.aws();
                    if (GF == null || !GF.equals(aws)) {
                        x.i("MicroMsg.CardDetailUIContoller", "the card is not belong mine");
                    } else {
                        this.hCt.add(getString(com.tencent.mm.plugin.card.a.g.app_delete));
                        this.hCr.put(Integer.valueOf(i), "menu_func_delete_share_card");
                        i++;
                    }
                }
                nU(i);
                if (this.hCt.size() > 0) {
                    this.hBT.dQ(true);
                }
            }
            if (this.hBU.azo()) {
                this.hCr.clear();
                this.hCt.clear();
                if (TextUtils.isEmpty(this.htQ.awn().rng)) {
                    i = 0;
                } else {
                    this.hCt.add(getString(com.tencent.mm.plugin.card.a.g.card_menu_report));
                    this.hCr.put(Integer.valueOf(0), "menu_func_report");
                    i = 1;
                }
                nU(i);
                if (this.hCt.size() > 0) {
                    this.hBT.dQ(true);
                }
            }
            if (this.hBZ != null && (this.hBZ instanceof com.tencent.mm.plugin.card.widget.b)) {
                ((com.tencent.mm.plugin.card.widget.b) this.hBZ).aAd();
            }
            v(this.hBU.azj(), this.hBU.azk());
            if (!this.htQ.avT() && this.hBU.azs()) {
                x.i("MicroMsg.CardDetailUIContoller", "update mFromUserView");
                this.hBX.update();
            } else if (this.htQ.avT() && this.hBU.azs()) {
                x.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout for username");
                this.hBY.update();
            } else if (this.hBU.azt()) {
                x.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout");
                this.hBY.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update mFromUserView and mAcceptHeaderLayout");
                this.hBY.azI();
                this.hBX.azI();
            }
            if (this.hBZ != null) {
                this.hBZ.dW(this.hBU.ayF());
            }
            if (this.bPd) {
                x.i("MicroMsg.CardDetailUIContoller", "updateUIBackground onPause return");
            } else {
                View findViewById;
                LayoutParams layoutParams;
                if (this.htQ.avR() && this.htQ.avT()) {
                    this.hyK.findViewById(com.tencent.mm.plugin.card.a.d.card_detain_ui).setBackgroundColor(this.hBT.getResources().getColor(com.tencent.mm.plugin.card.a.a.card_bg_color));
                    com.tencent.mm.ui.statusbar.a.c(this.hyK, -1, true);
                    this.hBT.G(-1, true);
                } else {
                    i = l.xV(this.htQ.awm().dxh);
                    this.hyK.findViewById(com.tencent.mm.plugin.card.a.d.card_detain_ui).setBackgroundColor(i);
                    com.tencent.mm.ui.statusbar.a.c(this.hyK, i, true);
                    this.hBT.G(i, false);
                }
                View findViewById2 = this.hyK.findViewById(com.tencent.mm.plugin.card.a.d.detail_first_container);
                View findViewById3 = this.hyK.findViewById(com.tencent.mm.plugin.card.a.d.header_view);
                View findViewById4 = this.hyK.findViewById(com.tencent.mm.plugin.card.a.d.detail_body_layout);
                if (this.htQ.avR() && this.hBU.azs()) {
                    if (this.htQ.avU()) {
                        findViewById2.setBackgroundResource(com.tencent.mm.plugin.card.a.c.card_white_sequare_top_bg);
                        this.hyK.findViewById(com.tencent.mm.plugin.card.a.d.from_username_container).setBackgroundResource(com.tencent.mm.plugin.card.a.c.card_gray_sequare_bottom_bg);
                        findViewById4.setBackgroundResource(0);
                    } else if (this.htQ.avT()) {
                        this.hyK.findViewById(com.tencent.mm.plugin.card.a.d.from_username_container).setBackgroundResource(0);
                        findViewById4.setBackgroundColor(this.hBT.getResources().getColor(com.tencent.mm.plugin.card.a.a.card_bg_color));
                    } else if (this.htQ.avV()) {
                        findViewById2.setBackgroundResource(com.tencent.mm.plugin.card.a.c.card_white_sequare_top_bg);
                        this.hyK.findViewById(com.tencent.mm.plugin.card.a.d.from_username_container).setBackgroundResource(com.tencent.mm.plugin.card.a.c.card_gray_sequare_bottom_bg);
                        findViewById4.setBackgroundResource(0);
                    } else if (!this.htQ.avW() && this.htQ.avX()) {
                        findViewById4.setBackgroundColor(this.hBT.getResources().getColor(com.tencent.mm.plugin.card.a.a.card_bg_color));
                    }
                } else if (this.htQ.avS()) {
                    if (this.hBU.azq() && this.hBW) {
                        findViewById2.setBackgroundResource(com.tencent.mm.plugin.card.a.c.card_white_sequare_top_bg);
                        findViewById4.setBackgroundResource(0);
                    } else if (!this.hBU.azq() || this.hBW) {
                        findViewById2.setBackgroundResource(0);
                        if (this.hBU.ayF()) {
                            findViewById4.setBackgroundResource(com.tencent.mm.plugin.card.a.c.card_white_bottom_bg);
                        } else {
                            findViewById4.setBackgroundResource(com.tencent.mm.plugin.card.a.c.card_white_sequare_top_bg);
                        }
                    } else {
                        findViewById2.setBackgroundResource(com.tencent.mm.plugin.card.a.c.card_white_bottom_bg);
                        findViewById4.setBackgroundResource(0);
                    }
                } else if (this.htQ.avU()) {
                    findViewById2.setBackgroundResource(0);
                    if (this.hBU.ayF()) {
                        findViewById4.setBackgroundResource(com.tencent.mm.plugin.card.a.c.card_white_bottom_bg);
                    } else {
                        findViewById4.setBackgroundResource(com.tencent.mm.plugin.card.a.c.card_white_sequare_top_bg);
                    }
                } else if (this.htQ.avV()) {
                    findViewById2.setBackgroundResource(com.tencent.mm.plugin.card.a.c.card_widget_member_bg);
                    findViewById4.setBackgroundResource(0);
                } else {
                    findViewById2.setBackgroundResource(0);
                    findViewById4.setBackgroundColor(this.hBT.getResources().getColor(com.tencent.mm.plugin.card.a.a.card_bg_color));
                }
                if (this.htQ.avX()) {
                    TextView textView = (TextView) this.hyK.findViewById(com.tencent.mm.plugin.card.a.d.bottom_wave);
                    Drawable bitmapDrawable = new BitmapDrawable(com.tencent.mm.sdk.platformtools.c.CV(com.tencent.mm.plugin.card.a.c.card_wavy));
                    bitmapDrawable.setTileModeX(TileMode.REPEAT);
                    textView.setBackgroundDrawable(bitmapDrawable);
                    textView.setVisibility(0);
                }
                Rect rect = new Rect(0, 0, 0, 0);
                findViewById2.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                findViewById2.invalidate();
                findViewById4.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                findViewById4.invalidate();
                if (this.htQ.avS() && this.hBU.azq() && this.hBW) {
                    findViewById = this.hyK.findViewById(com.tencent.mm.plugin.card.a.d.share_users_bottom_layout);
                    findViewById.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                    findViewById.invalidate();
                }
                if (this.htQ.avR() && this.hBU.azs()) {
                    findViewById = this.hyK.findViewById(com.tencent.mm.plugin.card.a.d.from_username_container);
                    rect.left = this.hBT.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.card.a.b.LargePadding);
                    rect.right = this.hBT.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.card.a.b.LargePadding);
                    findViewById.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                    findViewById.invalidate();
                    if (this.htQ.avV()) {
                        findViewById = this.hyK.findViewById(com.tencent.mm.plugin.card.a.d.from_username_layout);
                        layoutParams = (LayoutParams) findViewById.getLayoutParams();
                        int dimensionPixelSize = this.hBT.getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.SmallPadding);
                        layoutParams.rightMargin = dimensionPixelSize;
                        layoutParams.leftMargin = dimensionPixelSize;
                        findViewById.setLayoutParams(layoutParams);
                    }
                }
                if (this.hBU.azs() || this.hBU.azq()) {
                    if (this.hBZ != null && ((this.htQ.avR() && this.htQ.avU()) || this.htQ.avS())) {
                        this.hBZ.oc(0);
                    }
                } else if (this.hBZ != null && ((this.htQ.avR() && this.htQ.avU()) || this.htQ.avS())) {
                    if (this.hBU.ayF()) {
                        this.hBZ.oc(com.tencent.mm.plugin.card.a.c.card_white_top_bg);
                    } else {
                        this.hBZ.oc(com.tencent.mm.plugin.card.a.c.card_white_sequare_bottom_bg);
                    }
                }
                if (this.hBZ != null && this.htQ.avR() && this.htQ.avT()) {
                    this.hBZ.a(l.cm(l.xV(this.htQ.awm().dxh), this.hBT.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.card.a.b.card_member_widget_bg_big_round_radius)));
                }
                if (this.htQ.avR() && this.htQ.avT()) {
                    layoutParams = (LayoutParams) findViewById2.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    layoutParams.rightMargin = 0;
                    layoutParams.leftMargin = 0;
                    if (TextUtils.isEmpty(this.htQ.awm().rnR)) {
                        layoutParams.height = 0;
                        layoutParams.weight = 1.0f;
                    } else {
                        layoutParams.weight = 0.0f;
                        layoutParams.height = -2;
                    }
                    findViewById2.setLayoutParams(layoutParams);
                    layoutParams = (LayoutParams) findViewById3.getLayoutParams();
                    int dimensionPixelSize2 = this.hBT.getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.MiddlePadding);
                    layoutParams.rightMargin = dimensionPixelSize2;
                    layoutParams.leftMargin = dimensionPixelSize2;
                    if (this.htQ.avT()) {
                        layoutParams.topMargin = this.hBT.getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.ListPadding);
                        layoutParams.bottomMargin = this.hBT.getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.LittlePadding);
                        dimensionPixelSize2 = this.hBT.getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.LargerPadding);
                        layoutParams.rightMargin = dimensionPixelSize2;
                        layoutParams.leftMargin = dimensionPixelSize2;
                    } else {
                        dimensionPixelSize2 = this.hBT.getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.BiggerPadding);
                        layoutParams.bottomMargin = dimensionPixelSize2;
                        layoutParams.topMargin = dimensionPixelSize2;
                    }
                    findViewById3.setLayoutParams(layoutParams);
                    layoutParams = (LayoutParams) findViewById4.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    layoutParams.rightMargin = 0;
                    layoutParams.leftMargin = 0;
                    if (this.htQ.avT()) {
                        layoutParams.bottomMargin = this.hBT.getResources().getDimensionPixelSize(com.tencent.mm.plugin.card.a.b.LargerPadding);
                    }
                    if (TextUtils.isEmpty(this.htQ.awm().rnR)) {
                        layoutParams.height = 0;
                        layoutParams.weight = 1.0f;
                    } else {
                        layoutParams.weight = 0.0f;
                        layoutParams.height = -2;
                    }
                    findViewById4.setLayoutParams(layoutParams);
                    if (!TextUtils.isEmpty(this.htQ.awm().rnR)) {
                        findViewById2 = findViewById(com.tencent.mm.plugin.card.a.d.advertise_layout);
                        layoutParams = (LayoutParams) findViewById2.getLayoutParams();
                        layoutParams.height = 0;
                        layoutParams.weight = 1.0f;
                        findViewById2.setLayoutParams(layoutParams);
                    }
                }
                this.hyK.invalidate();
            }
            if (this.hBU.azx()) {
                if (this.hCd == null) {
                    this.hCd = new y();
                    this.hCd.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "update CardStatusView");
                this.hCd.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update CardStatusView");
                if (this.hCd != null) {
                    this.hCd.azI();
                }
            }
            if (this.hBU.azG()) {
                if (this.hCc == null) {
                    this.hCc = new com.tencent.mm.plugin.card.ui.view.c();
                    this.hCc.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "update mAdtitleView()");
                this.hCc.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update AdTitleView()");
                if (this.hCc != null) {
                    this.hCc.azI();
                }
            }
            if (this.hBU.azy()) {
                if (this.hCe == null) {
                    this.hCe = new k();
                    this.hCe.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "update mCardDetailFieldView()");
                this.hCe.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update mCardDetailFieldView()");
                if (this.hCe != null) {
                    this.hCe.azI();
                }
            }
            if (this.hBU.azz()) {
                if (this.hCf == null) {
                    this.hCf = new w();
                    this.hCf.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "update CardSecondaryFieldView");
                this.hCf.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update CardSecondaryFieldView");
                if (this.hCf != null) {
                    this.hCf.azI();
                }
            }
            if (this.hBU.azA()) {
                if (this.hCg == null) {
                    this.hCg = new com.tencent.mm.plugin.card.ui.view.l();
                    this.hCg.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "update CardDetailTableView");
                this.hCg.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update CardDetailTableView");
                if (this.hCg != null) {
                    this.hCg.azI();
                }
            }
            if (this.hBU.azB()) {
                if (this.hCh == null) {
                    this.hCh = new z();
                    this.hCh.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "update CardThirdFieldView");
                this.hCh.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update CardThirdFieldView");
                if (this.hCh != null) {
                    this.hCh.azI();
                }
            }
            if (this.hBU.azD()) {
                if (this.hCi == null) {
                    this.hCi = new com.tencent.mm.plugin.card.ui.view.e();
                    this.hCi.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "updateCardAnnoucementView");
                this.hCi.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't updateCardAnnoucementView");
                if (this.hCi != null) {
                    this.hCi.azI();
                }
            }
            if (this.hBU.azC()) {
                if (this.hCj == null) {
                    this.hCj = new u();
                    this.hCj.a(this);
                }
                x.i("MicroMsg.CardDetailUIContoller", "updateCardOperateFieldView");
                this.hCj.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't updateCardOperateFieldView");
                if (this.hCj != null) {
                    this.hCj.azI();
                }
            }
            if (this.hBU.azu()) {
                com.tencent.mm.plugin.card.model.b bVar2;
                this.htU.clear();
                List list = this.htU;
                f fVar2 = this.hCo;
                fVar2.htU.clear();
                if (!(fVar2.htQ.awn().rno == null || bi.oW(fVar2.htQ.awn().rno.title))) {
                    bVar2 = new com.tencent.mm.plugin.card.model.b();
                    bVar2.hvh = 1;
                    bVar2.title = fVar2.htQ.awn().rno.title;
                    bVar2.hyz = "";
                    bVar2.url = "card://jump_card_gift";
                    bVar2.lMY = fVar2.htQ.awn().rno.lMY;
                    fVar2.htU.add(bVar2);
                }
                if (fVar2.htQ.awn().rmX != null && fVar2.htQ.awn().rmX.size() > 0) {
                    Collection az = l.az(fVar2.htQ.awn().rmX);
                    if (az != null) {
                        ((com.tencent.mm.plugin.card.model.b) az.get(0)).hvi = false;
                        fVar2.htU.addAll(az);
                    }
                }
                if (((fVar2.hop == 6 && fVar2.htQ.awn().rnb <= 0) || l.ob(fVar2.hop)) && fVar2.htQ.awi() && fVar2.htQ.avR() && fVar2.htQ.avZ()) {
                    bVar2 = new com.tencent.mm.plugin.card.model.b();
                    bVar2.hvh = 1;
                    bVar2.title = ad.getContext().getString(com.tencent.mm.plugin.card.a.g.card_menu_gift_card);
                    bVar2.hyz = "";
                    bVar2.url = "card://jump_gift";
                    fVar2.htU.add(bVar2);
                }
                if (!(fVar2.htQ.awn().status == 0 || fVar2.htQ.awn().status == 1)) {
                    i = fVar2.htQ.awn().status;
                }
                if (fVar2.hop != 3 && fVar2.hop == 6) {
                    i = fVar2.htQ.awn().rnb;
                }
                sd sdVar = fVar2.htQ.awm().rnY;
                if (fVar2.htQ.awn().rnh != null) {
                    TextUtils.isEmpty(fVar2.htQ.awn().rnh.title);
                }
                com.tencent.mm.plugin.card.model.b bVar3 = new com.tencent.mm.plugin.card.model.b();
                z = fVar2.htQ.avX() ? false : sdVar == null || sdVar.rvz == null || sdVar.rvz.size() <= 0 || TextUtils.isEmpty((CharSequence) sdVar.rvz.get(0));
                bVar3.hvi = false;
                bVar3.hvh = 1;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(fVar2.getTitle());
                stringBuilder.append(fVar2.getString(com.tencent.mm.plugin.card.a.g.card_detail_info));
                bVar3.title = stringBuilder.toString();
                bVar3.huX = "";
                bVar3.hyz = "";
                bVar3.url = "card://jump_detail";
                if (z) {
                    fVar2.htU.add(bVar3);
                }
                if (!fVar2.htQ.avV() || fVar2.htQ.awm().rnK <= 0) {
                    la laVar;
                    if (!fVar2.htQ.avT() || fVar2.htQ.awm().rnK <= 0) {
                        if (fVar2.htQ.awm().rnK > 0) {
                            x.e("MicroMsg.CardDetailDataMgr", "shop_count:" + fVar2.htQ.awm().rnK);
                            if (fVar2.htQ.awm().rnK > 0 && fVar2.htW != null && fVar2.htW.size() > 0) {
                                laVar = (la) fVar2.htW.get(0);
                                if (laVar != null && laVar.rnu < 50000.0f) {
                                    bVar3 = new com.tencent.mm.plugin.card.model.b();
                                    bVar3.hvh = 2;
                                    bVar3.title = laVar.name;
                                    bVar3.huX = fVar2.gKS.getString(com.tencent.mm.plugin.card.a.g.card_shop_distance_address, new Object[]{l.f(fVar2.gKS, laVar.rnu), laVar.dRH});
                                    bVar3.hyz = "";
                                    bVar3.url = "card://jump_shop";
                                    bVar3.hvl = laVar.hvl;
                                    bVar3.dxh = fVar2.htQ.awm().dxh;
                                    fVar2.htU.add(bVar3);
                                } else if (laVar != null) {
                                    x.e("MicroMsg.CardDetailDataMgr", "distance:" + laVar.rnu);
                                }
                            }
                        }
                    }
                    if (fVar2.htQ.awm().rnK > 0 && fVar2.htW == null) {
                        bVar2 = new com.tencent.mm.plugin.card.model.b();
                        bVar2.hvh = 1;
                        if (TextUtils.isEmpty(fVar2.htQ.awm().roj)) {
                            bVar2.title = fVar2.getString(com.tencent.mm.plugin.card.a.g.card_adapted_stores);
                        } else {
                            bVar2.title = fVar2.htQ.awm().roj;
                        }
                        bVar2.huX = "";
                        bVar2.hyz = "";
                        bVar2.url = "card://jump_shop_list";
                        fVar2.htU.add(bVar2);
                    } else if (fVar2.htQ.awm().rnK > 0 && fVar2.htW != null && fVar2.htW.size() > 0) {
                        bVar3 = new com.tencent.mm.plugin.card.model.b();
                        bVar3.hvh = 1;
                        laVar = (la) fVar2.htW.get(0);
                        if (!TextUtils.isEmpty(fVar2.htQ.awm().roj)) {
                            bVar3.title = fVar2.htQ.awm().roj;
                        } else if (fVar2.htQ.avT() || laVar.rnu >= 5000.0f) {
                            bVar3.title = fVar2.getString(com.tencent.mm.plugin.card.a.g.card_adapted_stores);
                        } else if (fVar2.htQ.awm().rnK == 1 || fVar2.htW.size() == 1) {
                            x.i("MicroMsg.CardDetailDataMgr", "shop_count is 1 or mShopList size is 1");
                        } else {
                            bVar3.title = fVar2.getString(com.tencent.mm.plugin.card.a.g.card_check_more_adapted_stores);
                        }
                        if (!fVar2.htQ.avT() || laVar.rnu >= 2000.0f) {
                            bVar3.huX = "";
                        } else if (fVar2.htQ.awm().rnK > 1 || (fVar2.htW != null && fVar2.htW.size() > 1)) {
                            bVar3.huX = fVar2.gKS.getString(com.tencent.mm.plugin.card.a.g.card_membership_most_nearby_shop, new Object[]{l.f(fVar2.gKS, laVar.rnu)});
                        } else {
                            bVar3.huX = l.f(fVar2.gKS, laVar.rnu);
                        }
                        bVar3.hyz = "";
                        bVar3.url = "card://jump_shop_list";
                        fVar2.htU.add(bVar3);
                    }
                }
                if (!((fVar2.htQ.avX() && fVar2.htQ.awn().status == 3) || TextUtils.isEmpty(fVar2.htQ.awm().rnD))) {
                    fVar2.htU.add(fVar2.awL());
                }
                list.addAll(fVar2.htU);
                m mVar = this.hCb;
                Collection collection = this.htU;
                mVar.htU.clear();
                mVar.htU.addAll(collection);
                this.hCb.hGT = this.htQ.avX();
                this.hCb.notifyDataSetChanged();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "card is membership or share card or general coupon, not accept, don't updateCellData()");
            }
            if (this.hBU.azv()) {
                this.htQ.a(this.htQ.awn());
                l.j(this.htQ);
                if (this.hBU.azw()) {
                    if (this.hCa == null) {
                        if (this.htQ.awm().rol != null && this.htQ.awm().rol.rwc) {
                            this.hCa = new m();
                            com.tencent.mm.plugin.card.b.g axy = am.axy();
                            if (axy.htB == null) {
                                axy.htB = new ArrayList();
                            }
                            if (this != null) {
                                axy.htB.add(new WeakReference(this));
                            }
                        } else if (this.htQ.awm().huV == 10) {
                            this.hCa = new com.tencent.mm.plugin.card.ui.view.q();
                        } else {
                            this.hCa = new j();
                        }
                        this.hCa.a(this);
                        this.hCa.update();
                    } else if (this.hCa.h(this.htQ)) {
                        this.hCa.d(this.htQ);
                        this.hCa.update();
                    }
                } else if (this.hCa != null) {
                    this.hCa.azI();
                }
                if (this.hBZ != null) {
                    this.hBZ.dV(true);
                }
            } else {
                x.e("MicroMsg.CardDetailUIContoller", "don't update CardCodeView");
                if (this.hCa != null) {
                    this.hCa.azI();
                }
                if (this.hBZ != null) {
                    this.hBZ.dV(false);
                }
            }
            if (this.hBU.azE()) {
                x.i("MicroMsg.CardDetailUIContoller", "update CardAdvertiseView");
                this.hCk.update();
            } else {
                x.i("MicroMsg.CardDetailUIContoller", "don't update CardAdvertiseView");
                this.hCk.azI();
            }
            this.hCm.htQ = this.htQ;
        } else {
            x.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, not support card type :%d", new Object[]{Integer.valueOf(this.htQ.awm().huV)});
            if (TextUtils.isEmpty(this.htQ.awm().rnM)) {
                com.tencent.mm.ui.base.h.a(this.hBT, getString(com.tencent.mm.plugin.card.a.g.card_not_support_card_type), null, false, new 2(this));
                return;
            }
            com.tencent.mm.plugin.card.d.b.a(this.hBT, this.htQ.awm().rnM, 0);
            if (this.hCu != null) {
                this.hCu.ayr();
            }
        }
    }

    public final void c(com.tencent.mm.plugin.card.d.c cVar) {
        x.i("MicroMsg.CardDetailUIContoller", "onGetCodeSuccess! do update code view!");
        Message obtain = Message.obtain();
        c cVar2 = new c((byte) 0);
        cVar2.hCH = b.hCC;
        cVar2.hCI = cVar;
        obtain.obj = cVar2;
        this.hCw.sendMessage(obtain);
    }

    public final void V(int i, String str) {
        String string;
        x.e("MicroMsg.CardDetailUIContoller", "onGetCodeFail! errCode = %d, errMsg=%s", new Object[]{Integer.valueOf(i), str});
        Message obtain = Message.obtain();
        c cVar = new c((byte) 0);
        cVar.hCH = b.hCF;
        cVar.errCode = i;
        if (i == -1) {
            string = getString(com.tencent.mm.plugin.card.a.g.card_get_code_network_connet_failure);
        } else if (i == 2) {
            string = getString(com.tencent.mm.plugin.card.a.g.card_code_cannot_get);
        } else {
            string = getString(com.tencent.mm.plugin.card.a.g.card_get_code_failure);
        }
        cVar.Yy = string;
        obtain.obj = cVar;
        this.hCw.sendMessage(obtain);
    }

    public final void awM() {
        x.i("MicroMsg.CardDetailUIContoller", "on show TimeExpired! do update refresh code view!");
        Message obtain = Message.obtain();
        c cVar = new c((byte) 0);
        cVar.hCH = b.hCD;
        obtain.obj = cVar;
        this.hCw.sendMessage(obtain);
    }

    public final void b(com.tencent.mm.plugin.card.d.c cVar) {
        x.i("MicroMsg.CardDetailUIContoller", "on onReceiveCodeUnavailable! do update refresh code view!");
        Message obtain = Message.obtain();
        c cVar2 = new c((byte) 0);
        cVar2.hCH = b.hCE;
        cVar2.hCI = cVar;
        obtain.obj = cVar2;
        this.hCw.sendMessage(obtain);
    }

    public final void a(boolean z, com.tencent.mm.plugin.card.b.j.b bVar, boolean z2) {
        int i = 1;
        h hVar;
        Object[] objArr;
        if (z) {
            pr prVar = this.htQ.awn().rnk;
            h hVar2;
            Object[] objArr2;
            if (this.htQ.awf()) {
                com.tencent.mm.plugin.card.d.b.a(this.hBT, bVar.huK, bVar.huL, z2, this.htQ);
                h.mEJ.h(11941, new Object[]{Integer.valueOf(17), this.htQ.awq(), this.htQ.awr(), "", this.htQ.awn().rnk.title});
                return;
            } else if (prVar != null && !TextUtils.isEmpty(prVar.rnv) && !TextUtils.isEmpty(prVar.rnw)) {
                com.tencent.mm.plugin.card.d.b.a(this.htQ.awq(), prVar, this.hCv.hza, this.hCv.hCB);
                hVar2 = h.mEJ;
                objArr2 = new Object[5];
                objArr2[0] = Integer.valueOf(6);
                objArr2[1] = this.htQ.awq();
                objArr2[2] = this.htQ.awr();
                objArr2[3] = "";
                objArr2[4] = prVar.title != null ? prVar.title : "";
                hVar2.h(11941, objArr2);
                return;
            } else if (prVar == null || TextUtils.isEmpty(prVar.url)) {
                hVar = h.mEJ;
                objArr = new Object[9];
                objArr[0] = "CardConsumedCodeUI";
                objArr[1] = Integer.valueOf(this.htQ.awm().huV);
                objArr[2] = this.htQ.awr();
                objArr[3] = this.htQ.awq();
                objArr[4] = Integer.valueOf(0);
                objArr[5] = Integer.valueOf(this.hCv.hza);
                objArr[6] = this.hCv.hBD;
                if (!this.htQ.awk()) {
                    i = 0;
                }
                objArr[7] = Integer.valueOf(i);
                objArr[8] = "";
                hVar.h(11324, objArr);
                xI(bVar.huH);
                return;
            } else {
                com.tencent.mm.plugin.card.d.b.a(this.hBT, l.x(prVar.url, prVar.roL), 1);
                hVar2 = h.mEJ;
                objArr2 = new Object[5];
                objArr2[0] = Integer.valueOf(6);
                objArr2[1] = this.htQ.awq();
                objArr2[2] = this.htQ.awr();
                objArr2[3] = "";
                objArr2[4] = prVar.title != null ? prVar.title : "";
                hVar2.h(11941, objArr2);
                return;
            }
        }
        hVar = h.mEJ;
        objArr = new Object[9];
        objArr[0] = "CardConsumedCodeUI";
        objArr[1] = Integer.valueOf(this.htQ.awm().huV);
        objArr[2] = this.htQ.awr();
        objArr[3] = this.htQ.awq();
        objArr[4] = Integer.valueOf(0);
        objArr[5] = Integer.valueOf(this.hCv.hza);
        objArr[6] = this.hCv.hBD;
        if (!this.htQ.awk()) {
            i = 0;
        }
        objArr[7] = Integer.valueOf(i);
        objArr[8] = "";
        hVar.h(11324, objArr);
        xI(bVar.huH);
    }

    private void v(boolean z, boolean z2) {
        if (this.hBZ != null) {
            this.hBZ.v(z, z2);
        }
    }

    private void nU(int i) {
        LinkedList linkedList = this.htQ.awn().rni;
        if (linkedList != null) {
            this.hCs.clear();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < linkedList.size()) {
                    ax axVar = (ax) linkedList.get(i3);
                    if (!(bi.oW(axVar.text) || bi.oW(axVar.url))) {
                        this.hCt.add(axVar.text);
                        this.hCr.put(Integer.valueOf(i), axVar.text);
                        this.hCs.put(axVar.text, axVar.url);
                        i++;
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public final void b(int i, int i2, Intent intent) {
        switch (i) {
            case 0:
            case 1:
            case 4:
                if (i2 == -1) {
                    this.hCp = intent.getStringExtra("Select_Conv_User");
                    String str = this.hCp;
                    if (this.htQ.awm() == null) {
                        x.e("MicroMsg.CardDetailUIContoller", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    if (i == 0) {
                        if (TextUtils.isEmpty(this.htQ.awo().sli)) {
                            stringBuilder.append(getString(com.tencent.mm.plugin.card.a.g.sns_post_to));
                        } else {
                            stringBuilder.append(this.htQ.awo().sli);
                        }
                    } else if (i == 1) {
                        stringBuilder.append(getString(com.tencent.mm.plugin.card.a.g.card_share_to) + this.hCo.getTitle());
                    } else if (i == 4) {
                        stringBuilder.append(getString(com.tencent.mm.plugin.card.a.g.card_recommend_to) + this.hCo.getTitle());
                    }
                    t.a.qJO.a(this.hBT.mController, stringBuilder.toString(), this.htQ.awm().huW, this.htQ.awm().title + "\n" + this.htQ.awm().hwh, true, this.hBT.getResources().getString(com.tencent.mm.plugin.card.a.g.app_send), new 6(this, i, str));
                    return;
                }
                return;
            case 2:
                if (i2 == -1) {
                    this.hzB = intent.getIntExtra("Ktag_range_index", 0);
                    x.i("MicroMsg.CardDetailUIContoller", "mPrivateSelelct : %d", new Object[]{Integer.valueOf(this.hzB)});
                    if (this.hzB >= 2) {
                        this.hzC = intent.getStringExtra("Klabel_name_list");
                        this.hzD = intent.getStringExtra("Kother_user_name_list");
                        x.d("MicroMsg.CardDetailUIContoller", "mPrivateSelect : %d, names : %s", new Object[]{Integer.valueOf(this.hzB), this.hzC});
                        if (TextUtils.isEmpty(this.hzC) && TextUtils.isEmpty(this.hzD)) {
                            x.e("MicroMsg.CardDetailUIContoller", "mLabelNameList by getIntent is empty");
                            return;
                        }
                        List asList = Arrays.asList(this.hzC.split(","));
                        this.hzF = l.aB(asList);
                        this.hzE = l.aA(asList);
                        if (this.hzD != null && this.hzD.length() > 0) {
                            this.hzE.addAll(Arrays.asList(this.hzD.split(",")));
                        }
                        if (this.hzF != null) {
                            x.i("MicroMsg.CardDetailUIContoller", "mPrivateIdsList size is " + this.hzF.size());
                        }
                        if (this.hzE != null) {
                            x.i("MicroMsg.CardDetailUIContoller", "mPrivateNamesList size is " + this.hzE.size());
                            Iterator it = this.hzE.iterator();
                            while (it.hasNext()) {
                                x.d("MicroMsg.CardDetailUIContoller", "username : %s", new Object[]{(String) it.next()});
                            }
                        }
                        if (this.hzB == 2) {
                            this.hCk.xL(this.hBT.getString(com.tencent.mm.plugin.card.a.g.card_share_card_private_setting_share, new Object[]{axO()}));
                            return;
                        } else if (this.hzB == 3) {
                            this.hCk.xL(this.hBT.getString(com.tencent.mm.plugin.card.a.g.card_share_card_private_setting_not_share, new Object[]{axO()}));
                            return;
                        } else {
                            this.hCk.xL(this.hBT.getString(com.tencent.mm.plugin.card.a.g.card_share_card_private_setting));
                            return;
                        }
                    }
                    this.hCk.xL(this.hBT.getString(com.tencent.mm.plugin.card.a.g.card_share_card_private_setting));
                    return;
                }
                return;
            case 3:
                if (this.hCu != null) {
                    this.hCu.ayt();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private String axO() {
        if (!TextUtils.isEmpty(this.hzC) && !TextUtils.isEmpty(this.hzD)) {
            return this.hzC + "," + l.xZ(this.hzD);
        }
        if (!TextUtils.isEmpty(this.hzC)) {
            return this.hzC;
        }
        if (TextUtils.isEmpty(this.hzD)) {
            return "";
        }
        return l.xZ(this.hzD);
    }

    private void xI(String str) {
        Intent intent = new Intent();
        if (this.htQ instanceof CardInfo) {
            intent.putExtra("key_card_info_data", (CardInfo) this.htQ);
        } else if (this.htQ instanceof ShareCardInfo) {
            intent.putExtra("key_card_info_data", (ShareCardInfo) this.htQ);
        }
        intent.setClass(this.hBT, CardConsumeCodeUI.class);
        intent.putExtra("key_from_scene", this.hCv.hop);
        intent.putExtra("key_previous_scene", this.hCv.hza);
        intent.putExtra("key_mark_user", str);
        intent.putExtra("key_from_appbrand_type", this.hCv.hCB);
        this.hBT.startActivityForResult(intent, 3);
        this.hBT.geJ = this;
    }

    public final int ayE() {
        if (this.hCo == null) {
            return 0;
        }
        f fVar = this.hCo;
        if (fVar.htV == null ? false : fVar.htV.hvk) {
            return 1;
        }
        return 0;
    }

    public final boolean ayF() {
        return this.hBU == null ? false : this.hBU.ayF();
    }
}
