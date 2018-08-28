package com.tencent.mm.plugin.sns.ui;

import android.os.Process;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.a.b;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.a.a$c;
import com.tencent.mm.plugin.sns.ui.bb.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.vending.g.g;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.util.LinkedList;
import java.util.List;

class SnsTimeLineUI$19 implements a {
    private int odA = 0;
    private int odB = 0;
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$19(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
    }

    public final void bDY() {
        SnsTimeLineUI.k(this.odw).onm.b(SnsTimeLineUI.q(this.odw), SnsTimeLineUI.i(this.odw), false, SnsTimeLineUI.r(this.odw));
        x.d("MicroMsg.SnsTimeLineUI", "onLoadingMore here");
        if (SnsTimeLineUI.s(this.odw) == null) {
            x.e("MicroMsg.SnsTimeLineUI", "mLogicHandler handler null");
        } else if (SnsTimeLineUI.g(this.odw) != null) {
            SnsTimeLineUI.s(this.odw).removeCallbacks(SnsTimeLineUI.t(this.odw));
            SnsTimeLineUI.s(this.odw).postDelayed(SnsTimeLineUI.t(this.odw), 3000);
        }
    }

    public final ListView bDZ() {
        if (SnsTimeLineUI.g(this.odw).kww == null) {
            SnsTimeLineUI.g(this.odw).kww = (ListView) this.odw.findViewById(f.sns_photo_list);
        }
        return SnsTimeLineUI.g(this.odw).kww;
    }

    public final View bEa() {
        if (SnsTimeLineUI.g(this.odw).ntx == null) {
            SnsTimeLineUI.g(this.odw).ntx = (FrameLayout) this.odw.findViewById(f.timeline_root);
        }
        return SnsTimeLineUI.g(this.odw).ntx;
    }

    public final View bEb() {
        return this.odw.findViewById(f.sns_cover_shadow);
    }

    public final MMPullDownView bEc() {
        return (MMPullDownView) this.odw.findViewById(f.sns_pull_down_view);
    }

    public final int getType() {
        return 1;
    }

    public final void a(int i, List<Integer> list, List<Integer> list2) {
        int i2 = 1;
        if (i > 0) {
            n xd = af.byo().xd(i);
            if (xd != null) {
                if (xd.field_pravited > 0) {
                    Toast.makeText(this.odw, j.sns_has_save, 1).show();
                }
                if (xd.field_pravited == 1) {
                    i2 = 0;
                }
            }
        }
        if (i2 != 0) {
            c.a(SnsTimeLineUI.h(this.odw).kww);
        }
        if (SnsTimeLineUI.a(this.odw) != null) {
            SnsTimeLineUI.a(this.odw).oeg.notifyVendingDataChange();
        }
    }

    public final boolean bEd() {
        return SnsTimeLineUI.u(this.odw);
    }

    public final void bEe() {
        this.odw.bCa();
        if (SnsTimeLineUI.m(this.odw) != null) {
            x.d("MicroMsg.SnsTimeLineUI", "refreshIv onLoadingTap");
            SnsTimeLineUI.m(this.odw).setVisibility(0);
        }
        SnsTimeLineUI.k(this.odw).onl.b(SnsTimeLineUI.q(this.odw), SnsTimeLineUI.i(this.odw), SnsTimeLineUI.j(this.odw), SnsTimeLineUI.r(this.odw));
    }

    public final void bEf() {
        this.odw.bCa();
    }

    public final void xA(int i) {
        int firstVisiblePosition = SnsTimeLineUI.h(this.odw).kww.getFirstVisiblePosition();
        int lastVisiblePosition = SnsTimeLineUI.h(this.odw).kww.getLastVisiblePosition();
        if (firstVisiblePosition != this.odA || lastVisiblePosition != this.odB) {
            com.tencent.mm.plugin.sns.h.a.a aVar;
            this.odA = firstVisiblePosition;
            this.odB = lastVisiblePosition;
            x.i("MicroMsg.SnsTimeLineUI", "onListViewScoll %s %s %s", new Object[]{Integer.valueOf(firstVisiblePosition), Integer.valueOf(lastVisiblePosition), Integer.valueOf(i)});
            if (i == 2) {
                HardCoderJNI.stopPerformace(HardCoderJNI.hcSNSScrollEnable, SnsTimeLineUI.v(this.odw));
                SnsTimeLineUI.c(this.odw, HardCoderJNI.startPerformance(HardCoderJNI.hcSNSScrollEnable, HardCoderJNI.hcSNSScrollDelay, HardCoderJNI.hcSNSScrollCPU, HardCoderJNI.hcSNSScrollIO, HardCoderJNI.hcSNSScrollThr ? Process.myTid() : 0, HardCoderJNI.hcSNSScrollTimeout, TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_RESPONSE_IS_NULL, HardCoderJNI.hcSNSScrollAction, "MicroMsg.SnsTimeLineUI"));
                x.i("MicroMsg.SnsTimeLineUI", "summer hardcoder sns startPerformance [%s]", new Object[]{Integer.valueOf(SnsTimeLineUI.v(this.odw))});
            }
            com.tencent.mm.plugin.sns.h.a f = SnsTimeLineUI.f(this.odw);
            av avVar = SnsTimeLineUI.a(this.odw).oef;
            firstVisiblePosition = com.tencent.mm.modelsns.c.ehb;
            if (firstVisiblePosition == 2) {
                aVar = null;
            } else if (firstVisiblePosition != 4 || f.nvh) {
                long nanoTime = System.nanoTime();
                com.tencent.mm.plugin.sns.h.a.a aVar2 = new com.tencent.mm.plugin.sns.h.a.a();
                aVar2.nvi = System.currentTimeMillis();
                aVar2.mScreenHeight = f.mScreenHeight;
                aVar2.mScreenWidth = f.mScreenWidth;
                lastVisiblePosition = f.nvg.getTop();
                firstVisiblePosition = f.nvg.getHeight();
                if (lastVisiblePosition < 0) {
                    firstVisiblePosition += lastVisiblePosition;
                }
                aVar2.nvk = firstVisiblePosition;
                lastVisiblePosition = f.eZb.getFirstVisiblePosition() - 1;
                int lastVisiblePosition2 = f.eZb.getLastVisiblePosition() - 1;
                aVar2.nvj = lastVisiblePosition;
                aVar2.jDz = lastVisiblePosition2;
                int count = avVar.getCount();
                boolean z = false;
                if (f.eZb.getChildAt(0) != null) {
                    z = f.eZb.getChildAt(0) instanceof SnsHeader;
                }
                x.v("MicroMsg.CaptureSnsHelper", "first last %s %s isHeaderExist %s", new Object[]{Integer.valueOf(lastVisiblePosition), Integer.valueOf(lastVisiblePosition2), Boolean.valueOf(z)});
                firstVisiblePosition = z ? 1 : 0;
                int childCount = f.eZb.getChildCount();
                int i2 = lastVisiblePosition;
                while (i2 <= lastVisiblePosition2) {
                    if (i2 < count && i2 >= 0) {
                        if (firstVisiblePosition >= childCount) {
                            x.e("MicroMsg.CaptureSnsHelper", "childPos biger than childCount %d %d", new Object[]{Integer.valueOf(firstVisiblePosition), Integer.valueOf(childCount)});
                        } else {
                            int left;
                            int height;
                            int width;
                            if (aVar2.nvl == null) {
                                aVar2.nvl = new LinkedList();
                            }
                            b bVar = new b();
                            aVar2.nvl.add(bVar);
                            View childAt = f.eZb.getChildAt(firstVisiblePosition);
                            lastVisiblePosition = firstVisiblePosition + 1;
                            if (childAt != null) {
                                firstVisiblePosition = childAt.getTop();
                                left = childAt.getLeft();
                                height = childAt.getHeight();
                                width = childAt.getWidth();
                                n xi = avVar.xi(i2);
                                bVar.nvq = i.g(xi);
                                bVar.nvo = xi.field_type;
                                bVar.nvp = xi.xb(32);
                                bVar.nvm = firstVisiblePosition;
                                bVar.nvn = left;
                                bVar.aaH = height;
                                bVar.aaG = width;
                            }
                            if (!(childAt == null || childAt.getTag() == null || !(childAt.getTag() instanceof a$c))) {
                                a$c a_c = (a$c) childAt.getTag();
                                if (a_c.ojl && a_c.nKX != null) {
                                    int top = a_c.nKX.getTop();
                                    left = a_c.nKX.getLeft();
                                    height = a_c.ojd.getHeight();
                                    width = a_c.ojd.getWidth();
                                    int top2 = a_c.oje.getTop() + top;
                                    int left2 = a_c.oje.getLeft() + left;
                                    int height2 = a_c.oje.getHeight();
                                    int width2 = a_c.oje.getWidth();
                                    x.v("MicroMsg.CaptureSnsHelper", "holder position %s %s index %s", new Object[]{Integer.valueOf(a_c.position), Integer.valueOf(i2), Integer.valueOf(lastVisiblePosition)});
                                    if (a_c.nib.smJ != 0) {
                                        bVar.nvs = a_c.nib.smJ;
                                        bVar.nvt = top;
                                        bVar.nvu = left;
                                        bVar.nvv = width;
                                        bVar.nvw = height;
                                    }
                                    if (a_c.nib.smM != 0) {
                                        bVar.nvr = a_c.nib.smM;
                                        bVar.nvy = left2;
                                        bVar.nvx = top2;
                                        bVar.nvz = width2;
                                        bVar.nvA = height2;
                                    }
                                }
                            }
                            firstVisiblePosition = lastVisiblePosition;
                        }
                    }
                    i2++;
                }
                x.i("MicroMsg.CaptureSnsHelper", "end cap: " + (System.nanoTime() - nanoTime));
                aVar = aVar2;
            } else {
                aVar = null;
            }
            g.cBK().d(new com.tencent.mm.vending.c.a<Void, Void>() {
                public final /* synthetic */ Object call(Object obj) {
                    Void voidR = (Void) obj;
                    if (aVar != null) {
                        com.tencent.mm.plugin.sns.h.a.a aVar = aVar;
                        com.tencent.mm.modelsns.b io = com.tencent.mm.modelsns.b.io(501);
                        io.timeStamp = aVar.nvi;
                        io.ir(aVar.mScreenWidth).ir(aVar.mScreenHeight);
                        io.ir(aVar.nvk);
                        io.ir(0);
                        io.ir(aVar.nvj);
                        io.ir(aVar.jDz);
                        io.RD();
                        if (aVar.nvl != null) {
                            for (b bVar : aVar.nvl) {
                                com.tencent.mm.modelsns.b io2 = com.tencent.mm.modelsns.b.io(502);
                                io2.timeStamp = aVar.nvi;
                                io2.nb(bVar.nvq).ir(bVar.nvo).bP(bVar.nvp).ir(bVar.nvn).ir(bVar.nvm).ir(bVar.aaG).ir(bVar.aaH);
                                io2.RD();
                                x.v("MicroMsg.CaptureSnsHelper", "rootview top left %s %s viewWidth: %s viewHeight: %s", new Object[]{Integer.valueOf(bVar.nvm), Integer.valueOf(bVar.nvn), Integer.valueOf(bVar.aaG), Integer.valueOf(bVar.aaH)});
                                x.v("MicroMsg.CaptureSnsHelper", "like %s %s likeheight: %s likewidth: %s", new Object[]{Integer.valueOf(bVar.nvt), Integer.valueOf(bVar.nvu), Integer.valueOf(bVar.nvw), Integer.valueOf(bVar.nvv)});
                                x.v("MicroMsg.CaptureSnsHelper", "comment %s %s commentheight: %s commentwidth: %s", new Object[]{Integer.valueOf(bVar.nvx), Integer.valueOf(bVar.nvy), Integer.valueOf(bVar.nvA), Integer.valueOf(bVar.nvz)});
                                if (bVar.nvs != 0) {
                                    io2 = com.tencent.mm.modelsns.b.io(503);
                                    io2.timeStamp = aVar.nvi;
                                    io2.nb(bVar.nvq).ir(bVar.nvo).bP(bVar.nvp).ir(bVar.nvs).ir(bVar.nvu).ir(bVar.nvt).ir(bVar.nvv).ir(bVar.nvw);
                                    io2.RD();
                                }
                                if (bVar.nvr != 0) {
                                    io2 = com.tencent.mm.modelsns.b.io(504);
                                    io2.timeStamp = aVar.nvi;
                                    io2.nb(bVar.nvq).ir(bVar.nvo).bP(bVar.nvp).ir(bVar.nvr).ir(bVar.nvy).ir(bVar.nvx).ir(bVar.nvz).ir(bVar.nvA);
                                    io2.RD();
                                }
                            }
                        }
                        io = com.tencent.mm.modelsns.b.io(506);
                        io.timeStamp = aVar.nvi;
                        io.RD();
                    }
                    return voidR;
                }
            });
        }
    }

    public final void Q(int i, boolean z) {
        if (SnsTimeLineUI.a(this.odw) != null) {
            SnsTimeLineUI.a(this.odw).oeg.notifyVendingDataChange();
        }
        if (!z) {
            this.odw.EW().Q(com.tencent.mm.plugin.sns.j.c.b.class);
        }
    }

    public final void it(boolean z) {
        SnsTimeLineUI snsTimeLineUI = this.odw;
        snsTimeLineUI.odg = z;
        ag aRu = af.aRu();
        com.tencent.mm.plugin.sns.model.g byl = af.byl();
        com.tencent.mm.plugin.sns.model.b byj = af.byj();
        if (z) {
            if (byl.nmG || byj.nmG) {
                aRu.removeCallbacks(snsTimeLineUI.odh);
                aRu.removeCallbacks(snsTimeLineUI.odi);
                aRu.postDelayed(snsTimeLineUI.odh, 0);
            }
        } else if (!byl.nmG || !byj.nmG) {
            aRu.removeCallbacks(snsTimeLineUI.odh);
            aRu.removeCallbacks(snsTimeLineUI.odi);
            aRu.postDelayed(snsTimeLineUI.odi, 0);
        }
    }
}
