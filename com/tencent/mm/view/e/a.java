package com.tencent.mm.view.e;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v4.view.ViewPager.e;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.bo.a$b;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.n.a.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.ui.base.HorizontalListViewV2;
import com.tencent.mm.ui.base.MMRadioGroupView.d;
import com.tencent.mm.view.SmileyPanelScrollView;
import com.tencent.mm.view.SmileyPanelScrollView.b;
import com.tencent.mm.view.SmileyPanelViewPager;
import com.tencent.mm.view.SmileyPanelViewPager$a;
import com.tencent.mm.view.a.f;
import com.tencent.mm.view.a.g;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class a implements e, OnClickListener, d, b, SmileyPanelViewPager$a {
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelManager";
    public Context gKE;
    public final com.tencent.mm.sdk.e.j.a igR = new 5(this);
    public final c igS = new c<nb>() {
        {
            this.sFo = nb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "REFRESH_PANEL_EVENT");
            a.this.cCw();
            return false;
        }
    };
    private ag mHandler = new 1(this);
    public View mView;
    public Context rc = ad.getContext();
    public com.tencent.mm.view.f.a uSK;
    private final int uVB = 100;
    private final int uVC = TXLiveConstants.PUSH_WARNING_RECONNECT;
    private final int uVD = TXLiveConstants.PUSH_WARNING_HW_ACCELERATION_FAIL;
    private final int uVE = 100;
    public SmileyPanelViewPager uVF;
    public f uVG;
    public SmileyPanelScrollView uVH;
    public HorizontalListViewV2 uVI;
    public g uVJ;
    public View uVK;
    public ImageView uVL;
    public ImageView uVM;
    private ImageButton uVN;
    public ImageButton uVO;
    public TextView uVP;
    public a uVQ;
    private int uVR = -1;
    private boolean uVS = false;
    public boolean uVT = true;
    public String uVU;
    private boolean uVV = false;
    private boolean uVW = false;
    public final com.tencent.mm.sdk.e.j.a uVX = new 4(this);
    public final com.tencent.mm.sdk.e.j.a uVY = new 7(this);
    public OnItemClickListener uVZ = new 8(this);

    public a(Context context, com.tencent.mm.view.f.a aVar, a aVar2) {
        this.gKE = context;
        this.uSK = aVar;
        this.uVQ = aVar2;
        x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "SmileyPanelManager add listener.");
        ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().j(this.uVX);
        ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().h(this.igR);
        ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().l(this.uVY);
        com.tencent.mm.sdk.b.a.sFg.b(this.igS);
    }

    public final synchronized void cCp() {
        if (this.mView == null || !this.uSK.uWK) {
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "not view can't deal");
        } else {
            Object obj;
            ArrayList aDW;
            int i;
            Collection arrayList;
            g gVar;
            long currentTimeMillis = System.currentTimeMillis();
            this.uSK.uWy = false;
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initSmileyData");
            long currentTimeMillis2 = System.currentTimeMillis();
            com.tencent.mm.view.f.a aVar = this.uSK;
            if (aVar.uWG != null) {
                Iterator it = aVar.uWG.iterator();
                while (it.hasNext()) {
                    if (((com.tencent.mm.view.c.a) it.next()) != null) {
                        x.v("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "removeAllGridViewListener listener: %s", new Object[]{((com.tencent.mm.view.c.a) it.next()).iiv});
                    } else {
                        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelStg", "removeAllGridViewListener already release: ..");
                    }
                }
            }
            if (aVar.uWG != null) {
                aVar.uWG.clear();
            }
            if (((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDV() <= 2) {
                com.tencent.mm.bo.a.cgy();
                a$b a_b = com.tencent.mm.bo.a.sCv;
                if (!a$b.CT(208912)) {
                    obj = null;
                    aDW = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDW();
                    com.tencent.mm.bo.a.cgy();
                    i = ((h) com.tencent.mm.kernel.g.Ef().DM()).ES() ? com.tencent.mm.k.g.AT().getInt("EmotionRecommandCount", 3) : com.tencent.mm.bo.a.sCw.getInt("EmotionRecommandCount", 3);
                    x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "recommend count :%d need recommend count:%d download count:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i - ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDX()), Integer.valueOf(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDX())});
                    arrayList = new ArrayList();
                    if (!this.uSK.uWv) {
                        arrayList.add(com.tencent.mm.view.f.a.cCC());
                        a(com.tencent.mm.view.f.a.cCC(), true);
                    }
                    if (!this.uSK.uWu) {
                        EmojiGroupInfo emojiGroupInfo;
                        if (obj != null) {
                            arrayList.add(com.tencent.mm.view.f.a.cCD());
                            a(com.tencent.mm.view.f.a.cCD(), true);
                        }
                        if (aDW != null) {
                            Iterator it2 = aDW.iterator();
                            int i2 = 0;
                            while (it2.hasNext()) {
                                emojiGroupInfo = (EmojiGroupInfo) it2.next();
                                if (!(emojiGroupInfo == null || bi.oW(emojiGroupInfo.field_productID))) {
                                    if (emojiGroupInfo.field_recommand == 1) {
                                        if (i2 < r6 && i2 < i) {
                                            i2++;
                                            a(emojiGroupInfo, com.tencent.mm.view.f.a.d(emojiGroupInfo));
                                            arrayList.add(emojiGroupInfo);
                                        }
                                    } else if (!(emojiGroupInfo.field_productID.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.tcz)) || emojiGroupInfo.field_productID.equalsIgnoreCase("TAG_DEFAULT_TAB"))) {
                                        a(emojiGroupInfo, com.tencent.mm.view.f.a.d(emojiGroupInfo));
                                        arrayList.add(emojiGroupInfo);
                                    }
                                }
                            }
                        }
                        if (obj == null) {
                            arrayList.add(com.tencent.mm.view.f.a.cCD());
                            a(com.tencent.mm.view.f.a.cCD(), true);
                        }
                        if (!this.uSK.uWv) {
                            emojiGroupInfo = new EmojiGroupInfo();
                            emojiGroupInfo.field_productID = "TAG_STORE_MANEGER_TAB";
                            arrayList.add(emojiGroupInfo);
                        }
                    }
                    gVar = this.uVJ;
                    gVar.mData.clear();
                    gVar.mData.addAll(arrayList);
                    gVar.notifyDataSetChanged();
                    cCt();
                    this.uSK.cCH();
                    x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "end initTabsGroup use time :%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
                    x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "- deal View");
                    if (this.uVF != null) {
                        x.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initPanelVP failed");
                    } else {
                        if (this.uVG == null) {
                            cCs();
                            this.uSK.cCG();
                            this.uVF.setAdapter(this.uVG);
                            this.uVF.setOffscreenPageLimit(1);
                        } else {
                            boolean fC = j.fC(this.rc);
                            if (fC != this.uVW) {
                                x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "orientation changed " + fC);
                                cCs();
                                this.uVF.setAdapter(this.uVG);
                            }
                            this.uVG.uTT = true;
                            this.uVG.cCe();
                            this.uVG.notifyDataSetChanged();
                            this.uVG.uTT = false;
                        }
                        this.uVW = j.fC(this.rc);
                    }
                    cCq();
                    this.uSK.uWy = true;
                    this.uSK.uWB = true;
                    if (!this.uSK.uWz) {
                        com.tencent.mm.plugin.report.service.h.mEJ.a(406, 6, 1, false);
                        com.tencent.mm.plugin.report.service.h.mEJ.a(406, 8, System.currentTimeMillis() - currentTimeMillis, false);
                    }
                }
            }
            obj = 1;
            aDW = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDW();
            com.tencent.mm.bo.a.cgy();
            if (((h) com.tencent.mm.kernel.g.Ef().DM()).ES()) {
            }
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "recommend count :%d need recommend count:%d download count:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i - ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDX()), Integer.valueOf(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aDX())});
            arrayList = new ArrayList();
            if (this.uSK.uWv) {
                arrayList.add(com.tencent.mm.view.f.a.cCC());
                a(com.tencent.mm.view.f.a.cCC(), true);
            }
            if (this.uSK.uWu) {
                EmojiGroupInfo emojiGroupInfo2;
                if (obj != null) {
                    arrayList.add(com.tencent.mm.view.f.a.cCD());
                    a(com.tencent.mm.view.f.a.cCD(), true);
                }
                if (aDW != null) {
                    Iterator it22 = aDW.iterator();
                    int i22 = 0;
                    while (it22.hasNext()) {
                        emojiGroupInfo2 = (EmojiGroupInfo) it22.next();
                        if (!(emojiGroupInfo2 == null || bi.oW(emojiGroupInfo2.field_productID))) {
                            if (emojiGroupInfo2.field_recommand == 1) {
                                if (i22 < r6 && i22 < i) {
                                    i22++;
                                    a(emojiGroupInfo2, com.tencent.mm.view.f.a.d(emojiGroupInfo2));
                                    arrayList.add(emojiGroupInfo2);
                                }
                            } else if (!(emojiGroupInfo2.field_productID.equalsIgnoreCase(String.valueOf(EmojiGroupInfo.tcz)) || emojiGroupInfo2.field_productID.equalsIgnoreCase("TAG_DEFAULT_TAB"))) {
                                a(emojiGroupInfo2, com.tencent.mm.view.f.a.d(emojiGroupInfo2));
                                arrayList.add(emojiGroupInfo2);
                            }
                        }
                    }
                }
                if (obj == null) {
                    arrayList.add(com.tencent.mm.view.f.a.cCD());
                    a(com.tencent.mm.view.f.a.cCD(), true);
                }
                if (!this.uSK.uWv) {
                    emojiGroupInfo2 = new EmojiGroupInfo();
                    emojiGroupInfo2.field_productID = "TAG_STORE_MANEGER_TAB";
                    arrayList.add(emojiGroupInfo2);
                }
            }
            gVar = this.uVJ;
            gVar.mData.clear();
            gVar.mData.addAll(arrayList);
            gVar.notifyDataSetChanged();
            cCt();
            this.uSK.cCH();
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "end initTabsGroup use time :%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "- deal View");
            if (this.uVF != null) {
                if (this.uVG == null) {
                    cCs();
                    this.uSK.cCG();
                    this.uVF.setAdapter(this.uVG);
                    this.uVF.setOffscreenPageLimit(1);
                } else {
                    boolean fC2 = j.fC(this.rc);
                    if (fC2 != this.uVW) {
                        x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "orientation changed " + fC2);
                        cCs();
                        this.uVF.setAdapter(this.uVG);
                    }
                    this.uVG.uTT = true;
                    this.uVG.cCe();
                    this.uVG.notifyDataSetChanged();
                    this.uVG.uTT = false;
                }
                this.uVW = j.fC(this.rc);
            } else {
                x.w("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "initPanelVP failed");
            }
            cCq();
            this.uSK.uWy = true;
            this.uSK.uWB = true;
            if (this.uSK.uWz) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(406, 6, 1, false);
                com.tencent.mm.plugin.report.service.h.mEJ.a(406, 8, System.currentTimeMillis() - currentTimeMillis, false);
            }
        }
    }

    public final void cCq() {
        com.tencent.mm.view.c.a cCG = this.uSK.cCG();
        if (cCG == null) {
            this.uSK.setShowProductId("TAG_DEFAULT_TAB");
            cCG = this.uSK.cCG();
        }
        cCv();
        if (cCG != null && this.uVF != null) {
            int i = this.uSK.uWt;
            if (i < 0 || i > cCG.cCn() - 1) {
                i = cCG.cCn() - 1;
            }
            if (this.uVV) {
                i++;
                this.uVV = false;
            }
            this.uVR = cCG.gKG + i;
            this.uVF.k(this.uVR, false);
            boolean z = this.uSK.cCL() && cCG.iiv.equals("TAG_DEFAULT_TAB");
            if (!cCG.iiv.equals("TAG_STORE_TAB")) {
                x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "init set currentItem not default qq. ");
            }
            e(cCG.cCn(), i + 0, false, z);
        }
    }

    private void e(int i, int i2, boolean z, boolean z2) {
        if (i <= 1) {
            this.uVH.setVisibility(4);
            return;
        }
        this.uVH.setVisibility(0);
        SmileyPanelScrollView smileyPanelScrollView = this.uVH;
        x.d("MicroMsg.SmileyPanelScrollView", "setDot dotCount:%d selectDot:%d force:%b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)});
        smileyPanelScrollView.uSR = i;
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > smileyPanelScrollView.uSR) {
            i2 = smileyPanelScrollView.uSR;
        }
        smileyPanelScrollView.uSS = i2;
        if (smileyPanelScrollView.uTf == -1 || z || smileyPanelScrollView.uTj == 0) {
            smileyPanelScrollView.uTf = smileyPanelScrollView.uSS;
        }
        if (smileyPanelScrollView.uTe == -1 || z || smileyPanelScrollView.uTj == 0) {
            smileyPanelScrollView.uTe = smileyPanelScrollView.uSS;
            smileyPanelScrollView.uTg = 0.0f;
        }
        smileyPanelScrollView.uTi = z2;
        smileyPanelScrollView.invalidate();
    }

    public final void cCr() {
        if (this.uVG != null) {
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "clearViewPagerCache");
            this.uVG.mCount = 0;
        }
    }

    private void cCs() {
        cCr();
        this.uVG = new f(this.uSK, this.gKE);
    }

    private void a(EmojiGroupInfo emojiGroupInfo, boolean z) {
        int i = 0;
        com.tencent.mm.view.f.a aVar = this.uSK;
        if (aVar.uWG == null) {
            aVar.uWG = new ArrayList();
        }
        int size = aVar.uWG.size();
        com.tencent.mm.view.c.a aVar2 = size <= 0 ? null : (com.tencent.mm.view.c.a) aVar.uWG.get(size - 1);
        int a = bi.a((Integer) aVar.uWH.get(emojiGroupInfo.field_productID), 0);
        if (aVar2 != null) {
            i = aVar2.gKG + aVar2.cCn();
        }
        aVar.uWG.add(new com.tencent.mm.view.c.a(emojiGroupInfo, i, a, aVar, this, z));
    }

    public final void cCt() {
        if (this.uVL != null) {
            if (!com.tencent.mm.view.f.a.cCy() || this.uSK.uWs.equalsIgnoreCase("TAG_STORE_TAB")) {
                this.uVM.setVisibility(8);
            } else {
                this.uVM.setVisibility(0);
            }
            this.uVL.setContentDescription(this.rc.getString(com.tencent.mm.plugin.n.a.h.emotion_add));
        }
    }

    private ImageButton cCu() {
        if (this.uVN == null && this.gKE != null) {
            this.uVN = new ImageButton(this.gKE, null, i.MMStyleTabButton);
            this.uVN.setMaxHeight(this.uSK.uWb);
            this.uVN.setMinimumHeight(this.uSK.uWb);
            this.uVN.setMaxWidth(this.uSK.irI);
            this.uVN.setMinimumWidth(this.uSK.irI);
            this.uVN.setScaleType(ScaleType.CENTER);
            this.uVN.setPadding(this.uSK.uWd, this.uSK.uWd, this.uSK.uWd, this.uSK.uWd);
            this.uVN.setClickable(false);
            this.uVN.setVisibility(8);
        }
        return this.uVN;
    }

    public final void onClick(View view) {
        if (view == this.uVL) {
            Intent intent = new Intent();
            intent.putExtra("preceding_scence", 13);
            intent.putExtra("download_entrance_scene", 17);
            intent.putExtra("check_clickflag", false);
            if (com.tencent.mm.view.f.a.cCx()) {
                x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "called emoji store must refresh by net");
                intent.putExtra("emoji_stroe_must_refresh_by_net", true);
            }
            if (!bi.oW(this.uSK.qLj)) {
                intent.putExtra("to_talker_name", this.uSK.qLj);
            }
            com.tencent.mm.bg.d.b(this.rc, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
            com.tencent.mm.plugin.report.service.h.mEJ.h(11594, new Object[]{Integer.valueOf(2)});
        } else if (view == this.uVP) {
            if (this.uVQ != null && this.uVQ.getTextOpListener() != null) {
                this.uVQ.getTextOpListener().bbF();
            }
        } else if (view == this.uVO && this.uVQ.getSmileyPanelCallback() != null) {
            this.uVQ.getSmileyPanelCallback().bcQ();
        }
    }

    public final View findViewById(int i) {
        return this.mView.findViewById(i);
    }

    public final void mL(boolean z) {
        View cCu = cCu();
        if (cCu != null) {
            cCu.setVisibility(8);
        }
        if (this.uVP != null && this.uVP.getVisibility() == 0) {
            if (z) {
                Animation translateAnimation = new TranslateAnimation(0.0f, (float) this.uVP.getWidth(), 0.0f, 0.0f);
                translateAnimation.setDuration(250);
                this.uVP.startAnimation(translateAnimation);
            }
            this.uVP.setVisibility(8);
        }
    }

    public final void GP(int i) {
        if (this.uVF != null) {
            int currentItem = this.uVF.getCurrentItem();
            int i2 = this.uSK.GX(currentItem).gKG + i;
            if (i2 != currentItem) {
                Math.abs(i2 - currentItem);
                this.uVF.setCurrentItem(i2);
            }
            this.uVR = i2;
        }
    }

    public final void N(int i) {
        if (this.uVH != null) {
            SmileyPanelScrollView smileyPanelScrollView = this.uVH;
            smileyPanelScrollView.uTj = i;
            if (i == 0) {
                smileyPanelScrollView.uTf = smileyPanelScrollView.uSS;
                smileyPanelScrollView.uTe = smileyPanelScrollView.uSS;
                smileyPanelScrollView.uTg = 0.0f;
                smileyPanelScrollView.invalidate();
                if (smileyPanelScrollView.uTh) {
                    smileyPanelScrollView.uTh = false;
                }
            } else if (i == 1) {
                smileyPanelScrollView.uTf = smileyPanelScrollView.uSS;
                smileyPanelScrollView.uTe = smileyPanelScrollView.uSS;
                smileyPanelScrollView.uTg = 0.0f;
            }
        }
        if (i == 0 || i == 1) {
            this.uVR = this.uVF.getCurrentItem();
        }
    }

    public final void a(int i, float f, int i2) {
        if (this.uVG != null) {
            f fVar = this.uVG;
            if (fVar.uTW != null) {
                com.tencent.mm.view.a.d dVar = fVar.uTW;
                float f2 = ((float) i) + f;
                dVar.uTO = Math.round(f2);
                dVar.aI(f2);
            }
        }
        if (this.uVH != null && f != 0.0f) {
            com.tencent.mm.view.c.a GX = this.uSK.GX((f > 0.0f ? 1 : -1) + i);
            com.tencent.mm.view.c.a GX2 = this.uSK.GX(i);
            if (GX == GX2) {
                SmileyPanelScrollView smileyPanelScrollView = this.uVH;
                int i3 = i - GX2.gKG;
                smileyPanelScrollView.uTg = f;
                if (smileyPanelScrollView.uTf != i3) {
                    smileyPanelScrollView.uTf = i3;
                }
                smileyPanelScrollView.invalidate();
                this.uVS = true;
                return;
            }
            this.uVS = false;
        }
    }

    private void c(int i, boolean z, boolean z2) {
        int i2 = 1;
        if (this.uVI != null) {
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "tab index:%d selected:%b listView child count:%d", new Object[]{Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(this.uVI.getChildCount())});
            this.uVI.setSelection(i);
            View selectedView = this.uVI.getSelectedView();
            if (selectedView != null) {
                selectedView.setSelected(z);
                return;
            }
            x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "list item view is null. refreshable:%b", new Object[]{Boolean.valueOf(z2)});
            if (z2) {
                Message message = new Message();
                message.what = TXLiveConstants.PUSH_WARNING_HW_ACCELERATION_FAIL;
                message.arg1 = i;
                if (!z) {
                    i2 = 0;
                }
                message.arg2 = i2;
                this.mHandler.sendMessageDelayed(message, 100);
            }
        }
    }

    public final void O(int i) {
        x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "cpan onPageSelected :%d", new Object[]{Integer.valueOf(i)});
        if (this.uVG != null) {
            f fVar = this.uVG;
            fVar.uTU = i;
            if (fVar.uTW != null) {
                com.tencent.mm.view.a.d dVar = fVar.uTW;
                dVar.uTO = i;
                if (i == 0) {
                    dVar.aI(0.0f);
                } else {
                    dVar.aI(1.0f);
                }
            }
            if (i != 0 && fVar.uTV) {
                fVar.as(fVar.uTU, false);
                fVar.uTV = false;
            }
        }
        if (this.uSK != null && this.uSK.uWK) {
            boolean z;
            boolean z2;
            com.tencent.mm.view.c.a GX = this.uSK.GX(i);
            if (GX.iiv.equals("TAG_STORE_TAB")) {
                this.uVL.setSelected(true);
                x.d("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "show TAB: viewId: %d, tabProductId: %s", new Object[]{Integer.valueOf(this.uVL.getId()), "TAG_STORE_TAB"});
                this.uSK.setShowProductId("TAG_STORE_TAB");
                com.tencent.mm.plugin.report.service.h.mEJ.h(11594, new Object[]{Integer.valueOf(5)});
                com.tencent.mm.s.c.Cp().aV(262147, 266244);
                com.tencent.mm.s.c.Cp().aV(262149, 266244);
                cCt();
            } else {
                this.uVL.setSelected(false);
            }
            int i2 = i - GX.gKG;
            if (this.uSK.cCL() && GX.iiv.equals("TAG_DEFAULT_TAB")) {
                z = true;
            } else {
                z = false;
            }
            int cCn = GX.cCn();
            int i3 = i - GX.gKG;
            if (this.uVS) {
                z2 = false;
            } else {
                z2 = true;
            }
            e(cCn, i3, z2, z);
            this.uSK.uWt = i2;
            this.uSK.setShowProductId(GX.iiv);
            GX.uVA = i2;
            com.tencent.mm.view.f.a aVar = this.uSK;
            aVar.uWH.put(GX.iiv, Integer.valueOf(GX.uVA));
            GV(this.uSK.GY(i));
            c(this.uSK.GY(i) - 1, false, true);
            c(this.uSK.GY(i) + 1, false, true);
            cCv();
        }
    }

    private void GV(int i) {
        int i2 = this.uSK.irI;
        int width = this.uVI.getWidth();
        int firstVisiblePosition = this.uVI.getFirstVisiblePosition();
        if (i > this.uVI.getLastVisiblePosition()) {
            this.uVI.Eh((i2 * (i + 1)) - width);
        } else if (i < firstVisiblePosition) {
            this.uVI.Eh(i2 * i);
        }
        c(i, true, true);
    }

    public final void cCv() {
        if (this.uSK.uWs.equals("TAG_DEFAULT_TAB")) {
            if (!(this.uVQ == null || this.uVQ.getTextOpListener() == null)) {
                this.uVQ.getTextOpListener().gp(true);
            }
            if (this.uSK.cCE()) {
                this.uSK.uWA = false;
                View cCu = cCu();
                if (cCu != null) {
                    cCu.setVisibility(0);
                }
                if (this.uVP != null && this.uVP.getVisibility() != 0) {
                    Animation translateAnimation = new TranslateAnimation((float) this.uVP.getWidth(), 0.0f, 0.0f, 0.0f);
                    translateAnimation.setDuration(250);
                    this.uVP.startAnimation(translateAnimation);
                    this.uVP.setVisibility(0);
                    return;
                }
                return;
            }
            return;
        }
        if (!(this.uVQ == null || this.uVQ.getTextOpListener() == null)) {
            this.uVQ.getTextOpListener().gp(false);
        }
        mL(true);
    }

    public final synchronized void GQ(int i) {
        com.tencent.mm.view.f.a aVar;
        if (this.uSK.cCI()) {
            if (!this.uSK.uWE) {
                aVar = this.uSK;
                aVar.uWE = true;
                aVar.uWF = false;
            }
        } else if (!this.uSK.uWF) {
            aVar = this.uSK;
            aVar.uWF = true;
            aVar.uWE = false;
        }
        x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "catch Size & start deal");
        if (i > 0) {
            this.mView.post(new 2(this));
        }
    }

    public final void Eo(int i) {
        if (i > 0) {
            x.i("MicroMsg.emoji.SmileyPanel.SmileyPanelManager", "tab size changed ,so adjusting tab site.");
            GV(this.uSK.cCF());
        }
    }

    public final void cCw() {
        this.uVT = false;
        this.mHandler.removeMessages(TXLiveConstants.PUSH_WARNING_RECONNECT);
        this.mHandler.sendEmptyMessageDelayed(TXLiveConstants.PUSH_WARNING_RECONNECT, 100);
    }
}
