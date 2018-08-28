package com.tencent.mm.plugin.topstory.ui.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView$t;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ak.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.a.b;
import com.tencent.mm.plugin.topstory.ui.b.d;
import com.tencent.mm.plugin.topstory.ui.video.a;
import com.tencent.mm.plugin.topstory.ui.video.k;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.plugin.topstory.ui.video.p;
import com.tencent.mm.plugin.websearch.api.q;
import com.tencent.mm.protocal.c.bth;
import com.tencent.mm.protocal.c.bti;
import com.tencent.mm.protocal.c.cfn;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n$d;
import com.tencent.mm.ui.base.s;

public class c extends RecyclerView$t implements p {
    public static com.tencent.mm.ak.a.a.c oCI;
    public TextView eBO;
    public View ivV;
    public TextView mKZ;
    protected OnClickListener mtE = new OnClickListener() {
        public final void onClick(View view) {
            c.this.cY(view);
        }
    };
    public Point nqm;
    public a oAb;
    public n oCJ;
    public FrameLayout oCK;
    public View oCL;
    public ImageView oCM;
    public ImageView oCN;
    public TextView oCO;
    public View oCP;
    public View oCQ;
    public View oCR;
    public int oCS;
    public bti ozj;
    public int position;

    static {
        com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
        aVar.dXy = true;
        aVar.dXx = true;
        aVar.dXW = true;
        aVar.dXN = com.tencent.mm.plugin.topstory.ui.b.c.default_avatar;
        oCI = aVar.Pt();
    }

    public c(View view, a aVar) {
        Point point;
        super(view);
        this.oAb = aVar;
        this.nqm = ak.gu(aVar.baA());
        if (ak.gt(aVar.baA())) {
            point = this.nqm;
            point.y -= ak.gs(aVar.baA());
        }
        point = this.nqm;
        point.y -= s.gJ(aVar.baA());
        this.oCS = com.tencent.mm.bp.a.fromDPToPix(aVar.baA(), 24);
        cX(view);
    }

    public void cX(View view) {
        this.oCK = (FrameLayout) view.findViewById(d.video_view_container);
        this.oCL = view.findViewById(d.source_layout);
        this.oCM = (ImageView) view.findViewById(d.source_iv);
        this.mKZ = (TextView) view.findViewById(d.source_tv);
        this.eBO = (TextView) view.findViewById(d.title_tv);
        this.oCO = (TextView) view.findViewById(d.play_count_tv);
        this.ivV = view.findViewById(d.share_icon_iv);
        this.oCP = view.findViewById(d.body_mask);
        this.oCQ = view.findViewById(d.header_mask);
        this.oCR = view.findViewById(d.footer_mask);
        this.oCN = (ImageView) view.findViewById(d.feedback_iv);
    }

    public final void bII() {
        x.d("MicroMsg.TopStory.TopStoryBaseVideoItemHolder", "showMaskView %d", new Object[]{Integer.valueOf(hashCode())});
        this.oCR.animate().cancel();
        this.oCQ.animate().cancel();
        this.oCP.animate().cancel();
        this.oCP.setAlpha(0.8f);
        this.oCR.setAlpha(0.8f);
        this.oCQ.setAlpha(0.8f);
    }

    public final void bIJ() {
        x.d("MicroMsg.TopStory.TopStoryBaseVideoItemHolder", "hideMaskView %d", new Object[]{Integer.valueOf(hashCode())});
        this.oCR.animate().cancel();
        this.oCQ.animate().cancel();
        this.oCP.animate().cancel();
        this.oCP.setAlpha(0.0f);
        this.oCR.setAlpha(0.0f);
        this.oCQ.setAlpha(0.0f);
    }

    public final void bHL() {
        this.oCR.animate().cancel();
        this.oCQ.animate().cancel();
        this.oCR.setAlpha(0.0f);
        this.oCQ.setAlpha(0.0f);
        this.oAb.bHL();
    }

    public final void bHK() {
        this.oCR.animate().cancel();
        this.oCQ.animate().cancel();
        this.oCR.animate().alpha(0.8f).setDuration(200).setStartDelay(3000).start();
        this.oCQ.animate().alpha(0.8f).setDuration(200).setStartDelay(3000).start();
        this.oAb.bHK();
    }

    public final void a(bti bti, int i) {
        this.ozj = bti;
        this.position = i;
        aL();
    }

    public final void iE(boolean z) {
        bIJ();
        this.oAb.yg(this.position);
        if (this.oCJ.iB(z)) {
            bHL();
            bHK();
        }
    }

    protected void aL() {
        if (bi.oW(this.ozj.title)) {
            this.eBO.setVisibility(8);
        } else {
            this.eBO.setText(this.ozj.title);
            this.eBO.setVisibility(0);
            this.eBO.requestLayout();
        }
        this.eBO.setOnClickListener(this.mtE);
        this.mKZ.setText(this.ozj.bhd);
        if (bi.oW(this.ozj.pLz)) {
            this.oCO.setVisibility(8);
        } else {
            this.oCO.setText(this.ozj.pLz);
            this.oCO.setVisibility(0);
        }
        this.oCO.setOnClickListener(this.mtE);
        if (bi.oW(this.ozj.sqY)) {
            this.oCM.setVisibility(8);
        } else {
            o.Pj().a(this.ozj.sqY, this.oCM, oCI);
            this.oCM.setVisibility(0);
        }
        if (this.oAb.bHX()) {
            this.ivV.setVisibility(0);
            this.ivV.setOnClickListener(this.mtE);
        } else {
            this.ivV.setVisibility(8);
        }
        this.oCN.setTag(this.ozj);
        this.oCN.setOnClickListener(this.mtE);
        this.oCP.setVisibility(0);
        this.oCQ.setVisibility(0);
        this.oCR.setVisibility(0);
        this.oCL.setOnClickListener(this.mtE);
        if (this.oCJ == null) {
            this.oCJ = new n(this.oAb.baA());
            this.oCK.removeAllViews();
            this.oCK.addView(this.oCJ);
        }
        this.oCJ.setStreamUIComponent(this.oAb);
        this.oCJ.setVideoItemUIComponent(this);
        n nVar = this.oCJ;
        bti bti = this.ozj;
        nVar.position = this.position;
        nVar.ozj = bti;
        nVar.aL();
        if (this.oAb.bHP() != this.position) {
            bII();
        } else {
            bHK();
        }
    }

    private void bIK() {
        if (this.oAb.bHS().oCg) {
            this.oCJ.bIr();
            this.oAb.bHS().bAf();
        }
    }

    protected void cY(View view) {
        if (this.oAb.bHP() != this.position) {
            this.oAb.bHU().oAl = 2;
            this.oAb.ye(this.position);
            com.tencent.mm.plugin.websearch.api.a.a.kB(4);
            this.oAb.bHU().b(this.ozj);
            ((b) g.n(b.class)).getReporter().a(this.oAb.bHT(), this.ozj, this.position, 2, "");
            return;
        }
        Object obj = (this.oCR.getAlpha() == 0.0f || this.oCQ.getAlpha() == 0.0f) ? null : 1;
        if (obj != null) {
            bHL();
            this.oAb.bHL();
            bHK();
            this.oAb.bHK();
        } else if (view.getId() == this.oCL.getId()) {
            if (!bi.oW(this.ozj.lRt)) {
                Oy(this.ozj.lRt);
                bIK();
                this.oAb.bHU().b(this.ozj);
                ((b) g.n(b.class)).getReporter().a(this.oAb.bHT(), this.ozj, this.position, 3, this.ozj.bhd);
            }
        } else if (view.getId() == this.eBO.getId()) {
            if (this.ozj != null && !bi.oW(this.ozj.pLA)) {
                Oy(this.ozj.pLA);
                bIK();
                this.oAb.bHU().b(this.ozj);
                ((b) g.n(b.class)).getReporter().a(this.oAb.bHT(), this.ozj, this.position, 1, "");
            }
        } else if (view.getId() == this.ivV.getId()) {
            com.tencent.mm.plugin.websearch.api.a.a.kB(8);
            a(this.oAb, this.oAb.baA(), this.oCJ, this.position);
        } else if (view.getId() == this.oCN.getId()) {
            this.oAb.onFeedBackItemClick(this.oCN);
        }
    }

    public static void a(final a aVar, final Context context, final n nVar, int i) {
        final bti bti = (bti) aVar.bHO().get(i);
        if (bti != null) {
            com.tencent.mm.ui.widget.c cVar = new com.tencent.mm.ui.widget.c(context, 1, false);
            cVar.ofp = new com.tencent.mm.ui.base.n.c() {
                public final void a(l lVar) {
                    lVar.eR(0, com.tencent.mm.plugin.topstory.ui.b.g.video_share_to_sns);
                    lVar.eR(1, com.tencent.mm.plugin.topstory.ui.b.g.video_share_to_friend);
                }
            };
            cVar.ofq = new n$d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    k kVar;
                    Context context;
                    bti bti;
                    bth bHT;
                    if (menuItem.getItemId() == 0) {
                        nVar.bIr();
                        kVar = k.oAn;
                        context = context;
                        bti = bti;
                        bHT = aVar.bHT();
                        if (bti != null && bHT != null) {
                            byte[] toByteArray;
                            kVar.oAo = bti;
                            Intent intent = new Intent();
                            intent.putExtra("Ksnsupload_title", bti.ixz);
                            intent.putExtra("Ksnsupload_imgurl", bti.pLw);
                            intent.putExtra("Ksnsupload_link", bti.ixy);
                            intent.putExtra("KContentObjDesc", bi.oW(bti.nzH) ? context.getString(com.tencent.mm.plugin.topstory.ui.b.g.recommend_video_share_desc_default) : bti.nzH);
                            intent.putExtra("KlinkThumb_url", bti.pLw);
                            intent.putExtra("Ksnsupload_source", 1);
                            intent.putExtra("Ksnsupload_type", 16);
                            intent.putExtra("need_result", true);
                            cfn cfn = new cfn();
                            cfn.pLr = bti.sqS;
                            cfn.pLs = bti.sqV;
                            cfn.pLt = bHT.sqJ;
                            cfn.pLu = bti.sqU;
                            cfn.pLv = bHT.sqO;
                            cfn.ixy = bti.ixy;
                            cfn.ixz = bti.ixz;
                            cfn.nzH = bti.nzH;
                            cfn.pLw = bti.pLw;
                            cfn.pLx = bti.pLx;
                            cfn.pLy = bti.pLy;
                            cfn.bhd = bti.bhd;
                            cfn.lRt = bti.lRt;
                            cfn.pLz = bti.pLz;
                            cfn.pLA = bti.pLA;
                            cfn.pLB = k.cB(bHT.pKZ).toString();
                            cfn.pLC = com.tencent.mm.plugin.topstory.a.g.cA(bti.rBV).toString();
                            try {
                                toByteArray = cfn.toByteArray();
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoShareMgr", e, "", new Object[0]);
                                toByteArray = null;
                            }
                            if (toByteArray != null) {
                                intent.putExtra("KWebSearchInfo", toByteArray);
                            }
                            com.tencent.mm.bg.d.b(context, "sns", ".ui.SnsUploadUI", intent, 1024);
                        }
                    } else if (menuItem.getItemId() == 1) {
                        nVar.bIr();
                        kVar = k.oAn;
                        context = context;
                        bti = bti;
                        bHT = aVar.bHT();
                        kVar.oAo = bti;
                        com.tencent.mm.y.g.a aVar = new com.tencent.mm.y.g.a();
                        aVar.type = 5;
                        aVar.title = bti.ixz;
                        aVar.description = bi.oW(bti.nzH) ? context.getString(com.tencent.mm.plugin.topstory.ui.b.g.recommend_video_share_desc_default) : bti.nzH;
                        aVar.url = bti.ixy;
                        aVar.thumburl = bti.pLw;
                        q qVar = new q();
                        qVar.pLr = bti.sqS;
                        qVar.pLs = bti.sqV;
                        qVar.pLt = bHT.sqJ;
                        qVar.pLu = bti.sqU;
                        qVar.pLv = bHT.sqO;
                        qVar.ixy = bti.ixy;
                        qVar.ixz = bti.ixz;
                        qVar.nzH = bti.nzH;
                        qVar.pLw = bti.pLw;
                        qVar.pLx = bti.pLx;
                        qVar.pLy = bti.pLy;
                        qVar.bhd = bti.bhd;
                        qVar.lRt = bti.lRt;
                        qVar.pLz = bti.pLz;
                        qVar.pLA = bti.pLA;
                        qVar.pLB = k.cB(bHT.pKZ).toString();
                        qVar.pLC = com.tencent.mm.plugin.topstory.a.g.cA(bti.rBV).toString();
                        aVar.a(qVar);
                        String a = com.tencent.mm.y.g.a.a(aVar, null, null);
                        Intent intent2 = new Intent();
                        intent2.putExtra("Retr_Msg_Type", 2);
                        intent2.putExtra("Retr_Msg_content", a);
                        intent2.putExtra("Multi_Retr", true);
                        intent2.putExtra("Retr_go_to_chattingUI", false);
                        intent2.putExtra("Retr_show_success_tips", true);
                        com.tencent.mm.bg.d.b(context, ".ui.transmit.MsgRetransmitUI", intent2, 2048);
                    }
                }
            };
            cVar.uJQ = new 4(aVar);
            cVar.bXO();
        }
    }

    private void Oy(String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        com.tencent.mm.bg.d.b(this.oAb.baA(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }

    public void z(n nVar) {
        this.ozj = nVar.getVideoInfo();
        String str = "MicroMsg.TopStory.TopStoryBaseVideoItemHolder";
        String str2 = "setVideoInfoFromResumeFullScreenView, videoInfo: %s, videoViewPosition: %s, position: %s";
        Object[] objArr = new Object[3];
        objArr[0] = this.ozj != null ? this.ozj.title : "";
        objArr[1] = Integer.valueOf(nVar.getPosition());
        objArr[2] = Integer.valueOf(this.position);
        x.i(str, str2, objArr);
        if (this.ozj != null) {
            if (bi.oW(this.ozj.title)) {
                this.eBO.setVisibility(8);
            } else {
                this.eBO.setText(this.ozj.title);
                this.eBO.setVisibility(0);
            }
            this.mKZ.setText(this.ozj.bhd);
            if (bi.oW(this.ozj.pLz)) {
                this.oCO.setVisibility(8);
            } else {
                this.oCO.setText(this.ozj.pLz);
                this.oCO.setVisibility(0);
            }
            this.oCK.removeAllViews();
            if (nVar.getParent() != null) {
                ((ViewGroup) nVar.getParent()).removeView(nVar);
            }
            FrameLayout frameLayout = this.oCK;
            bti bti = this.ozj;
            int min = Math.min(this.nqm.x, this.nqm.y);
            frameLayout.addView(nVar, new LayoutParams(min, (bti.dwI * min) / bti.dwJ));
            this.oCJ = nVar;
            nVar.setVideoItemUIComponent(this);
            if (this.oAb.bHS().oCg) {
                nVar.bIm();
            } else {
                nVar.bIn();
            }
            bIJ();
            bHL();
            bHK();
            this.position = nVar.getPosition();
            this.oAb.yg(this.position);
        }
    }

    public final void bID() {
        this.oCJ = null;
        this.oAb.yg(0);
        aL();
    }

    public final int bIE() {
        return this.position;
    }
}
