package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Gallery;
import android.widget.Toast;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.t.a;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;
import com.tencent.mm.ui.MMNewPhotoEditUI;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.MultiTouchImageView$a;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SnsInfoFlip extends FlipView {
    private static int dwI = 0;
    private static int dwJ = 0;
    private Context context;
    List<b> dEw;
    private ag handler = new ag();
    private boolean nTx = false;
    private boolean nTz = false;
    private boolean nWA = true;
    HashMap<Integer, Integer> nWB = new HashMap();
    HashMap<Integer, Long> nWC = new HashMap();
    HashMap<Integer, Long> nWD = new HashMap();
    private boolean nWE = false;
    private boolean nWF = false;
    private boolean nWG = false;
    private boolean nWH = false;
    private boolean nWI = false;
    private boolean nWJ = true;
    private boolean nWK = true;
    private float nWL = 1.0f;
    MMPageControlView nWM;
    private Runnable nWN = null;
    private String nWO = "";
    private int nWP = -1;
    private int nWQ = -1;
    private boolean nWR = false;
    long nWS = 0;
    private HashSet<String> nWT = new HashSet();
    private Map<String, Boolean> nWU;
    private int nWV = 0;
    private int nWW = 0;
    private boolean nWX = false;
    private c nWY;
    private HashMap<String, n> nWZ = new HashMap();
    b nWy;
    Gallery nWz;
    int nXa = -1;
    private HashSet<String> nXb = new HashSet();
    public int nXc = 0;
    public int nXd = 0;
    private HashMap<String, a> nXe = new HashMap();
    private MultiTouchImageView$a nXf = new 6(this);
    boolean nkG = false;
    private av nkT = av.tbu;
    public String username;

    static /* synthetic */ void a(SnsInfoFlip snsInfoFlip, String str) {
        x.d("MicroMsg.SnsInfoFlip", "recordLoadStart, bigPicId:%s", new Object[]{str});
        if (!snsInfoFlip.nXe.containsKey(str)) {
            a aVar = new a(snsInfoFlip);
            aVar.dzO = snsInfoFlip.getCount();
            aVar.networkType = snsInfoFlip.getReportNetworkType();
            aVar.nXj = System.currentTimeMillis();
            aVar.nXl = str;
            snsInfoFlip.nXe.put(str, aVar);
            x.d("MicroMsg.SnsInfoFlip", "recordLoadStart, put to map");
        }
    }

    public av getFromScene() {
        return this.nkT;
    }

    public void setFromScene(av avVar) {
        this.nkT = avVar;
    }

    public void setIsAd(boolean z) {
        this.nkG = z;
    }

    public void setOnDeleteAllAction(Runnable runnable) {
        this.nWN = runnable;
    }

    public void setItems(List<b> list) {
        this.dEw = list;
    }

    public float getWidthModHeight() {
        return this.nWL;
    }

    public void setOnPageSelectListener(c cVar) {
        this.nWY = cVar;
    }

    public SnsInfoFlip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public SnsInfoFlip(Context context) {
        super(context);
        init(context);
    }

    public void setIsFromMainTimeline(boolean z) {
        this.nTx = z;
    }

    public void setIsSoonEnterPhotoEditUI(boolean z) {
        this.nTz = z;
    }

    public final boolean bBX() {
        return this.nTx;
    }

    private void init(Context context) {
        this.nWS = System.currentTimeMillis();
        this.context = context;
        View inflate = inflate(context, i$g.sns_info_flip_view, this);
        if (f.crf()) {
            inflate.findViewById(i$f.gallery_new).setVisibility(0);
            this.nWz = (Gallery) inflate.findViewById(i$f.gallery_new);
        } else {
            inflate.findViewById(i$f.gallery_sns).setVisibility(0);
            this.nWz = (Gallery) inflate.findViewById(i$f.gallery_sns);
        }
        if (this.nWz instanceof MMGestureGallery) {
            this.nWz.setSpacing(50);
            ((MMGestureGallery) this.nWz).setSingleClickOverListener(new 1(this, context));
            ((MMGestureGallery) this.nWz).setScrollLeftRightListener(new 2(this));
        }
        this.nWM = (MMPageControlView) findViewById(i$f.what_news_page_control);
        this.nWM.setIndicatorLayoutRes(i$g.snspage_control_image);
        this.nWU = new HashMap();
    }

    public void setOreitaion(boolean z) {
    }

    public void setShowPageControl(boolean z) {
        this.nWE = z;
    }

    public void setDoubleClick(boolean z) {
        this.nWF = z;
    }

    public void setShowTitle(boolean z) {
        this.nWH = z;
    }

    public void setTouchFinish(boolean z) {
        this.nWG = z;
    }

    public void setShowLongClickMenu(boolean z) {
        this.nWA = z;
    }

    public void setInfoType(int i) {
        this.infoType = i;
    }

    public void setEnableHorLongBmpMode(boolean z) {
        this.nWI = z;
    }

    public b getSelectItem() {
        if (this.nWz == null) {
            return null;
        }
        return (b) this.nWz.getSelectedItem();
    }

    public String getSelectedMediaId() {
        if (this.nWz == null) {
            return null;
        }
        b bVar = (b) this.nWz.getSelectedItem();
        if (bVar == null) {
            return null;
        }
        return bVar.caK.ksA;
    }

    public String getSelectId() {
        if (this.nWz == null) {
            return "";
        }
        b bVar = (b) this.nWz.getSelectedItem();
        if (bVar == null) {
            return "";
        }
        return bVar.nuP;
    }

    private static int b(String str, bsu bsu) {
        Iterator it = bsu.sqc.ruA.iterator();
        int i = 0;
        while (it.hasNext()) {
            i++;
            if (str.equals(((ate) it.next()).ksA)) {
                return i;
            }
        }
        return 0;
    }

    private void a(ate ate, int i, String str) {
        long j = 0;
        if (this.nWz != null && (this.nWz instanceof MMGestureGallery)) {
            float f;
            float f2;
            float f3;
            if (ate.rVH != null) {
                f = ate.rVH.rWv;
                f2 = ate.rVH.rWu;
            } else {
                f = 0.0f;
                f2 = 0.0f;
            }
            if (f <= 0.0f || r5 <= 0.0f) {
                Options VZ = c.VZ(ate.ksA.startsWith("Locall_path") ? an.s(af.getAccSnsPath(), ate.ksA) + i.m(ate) : an.s(af.getAccSnsPath(), ate.ksA) + i.d(ate));
                if (VZ != null) {
                    f2 = (float) VZ.outWidth;
                    f3 = (float) VZ.outHeight;
                }
            } else {
                f3 = f;
            }
            if (f3 > 0.0f && r5 > 0.0f) {
                MMGestureGallery mMGestureGallery = (MMGestureGallery) this.nWz;
                if (!this.nWI || ((double) r5) * 1.0d <= ((double) f3) * 2.0d) {
                    x.d("MicroMsg.SnsInfoFlip", "set on fling false");
                    mMGestureGallery.tyx = false;
                } else {
                    x.d("MicroMsg.SnsInfoFlip", "set on fling true");
                    mMGestureGallery.tyx = true;
                }
            }
        }
        if (this.nWY != null) {
            this.nWY.xu(i);
        }
        n Nl = af.byo().Nl(str);
        if (Nl != null) {
            ax.c(Nl, i);
        }
        if (this.nWP == -1) {
            this.nWP = i;
        }
        this.nWQ = 1;
        String str2 = ate.ksA;
        if (bi.oW(str)) {
            this.nMM.eP((i + 1) + " / " + this.nWy.getCount(), null);
            return;
        }
        Nl = (n) this.nWZ.get(str);
        if (Nl == null) {
            Nl = af.byo().Nl(str);
            this.nWZ.put(str, Nl);
        }
        n nVar = Nl;
        if (nVar != null) {
            String str3;
            if (ate.hcE == 2) {
                if (this.nWz instanceof MMGestureGallery) {
                    ((MMGestureGallery) this.nWz).setLoadQuit(false);
                }
            } else if (this.nWz instanceof MMGestureGallery) {
                ((MMGestureGallery) this.nWz).setLoadQuit(true);
            }
            if (ate.hcE != 6) {
                af.aRu().post(new 3(this));
            }
            x.d("MicroMsg.SnsInfoFlip", "onItemSelected  " + i + " localId " + str);
            if (this.nXa != i) {
                this.nWB.put(Integer.valueOf(i), Integer.valueOf((this.nWB.containsKey(Integer.valueOf(i)) ? ((Integer) this.nWB.get(Integer.valueOf(i))).intValue() : 0) + 1));
                this.nWC.put(Integer.valueOf(i), Long.valueOf(bi.VG()));
                if (this.nXa >= 0) {
                    long longValue;
                    if (this.nWC.containsKey(Integer.valueOf(this.nXa))) {
                        longValue = ((Long) this.nWC.get(Integer.valueOf(this.nXa))).longValue();
                    } else {
                        longValue = 0;
                    }
                    if (longValue > 0) {
                        this.nWC.put(Integer.valueOf(this.nXa), Long.valueOf(0));
                        if (this.nWD.containsKey(Integer.valueOf(this.nXa))) {
                            j = ((Long) this.nWD.get(Integer.valueOf(this.nXa))).longValue();
                        }
                        longValue = bi.bI(longValue);
                        j += longValue;
                        this.nWD.put(Integer.valueOf(this.nXa), Long.valueOf(j));
                        x.i("MicroMsg.SnsInfoFlip", "lastSelectPosition " + this.nXa + " curtime " + j + " passtime " + (((double) longValue) / 1000.0d));
                    }
                }
                if (this.nTx && this.nWy != null) {
                    b bVar = (b) this.nWy.getItem(this.nXa);
                    if (bVar != null) {
                        str3 = bVar.caK.ksA;
                        x.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, bigPicId:%s", new Object[]{str3});
                        if (this.nXe.containsKey(str3)) {
                            a aVar = (a) this.nXe.get(str3);
                            aVar.networkType = getReportNetworkType();
                            if (aVar.nXk != -1) {
                                aVar.nXi = 1;
                                aVar.nrX = aVar.nXk - aVar.nXj;
                                x.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, load success, costTime:%d", new Object[]{Long.valueOf(aVar.nrX)});
                            } else {
                                aVar.nXi = 2;
                                aVar.nXk = System.currentTimeMillis();
                                aVar.nrX = aVar.nXk - aVar.nXj;
                                x.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, load failed, costTime:%d", new Object[]{Long.valueOf(aVar.nrX)});
                            }
                        }
                    }
                }
            }
            this.nXa = i;
            if (this.nML != null) {
                this.nML.NN(str);
            }
            int i2 = nVar.field_createTime;
            bsu bAJ = nVar.bAJ();
            String l = az.l(this.context, ((long) i2) * 1000);
            str3 = null;
            if (!(bAJ == null || bAJ.sqc == null || bAJ.sqc.ruA.size() <= 1)) {
                str3 = (((b) this.dEw.get(i)).nuQ + 1) + " / " + bAJ.sqc.ruA.size();
                this.nWQ = b(str2, bAJ);
            }
            this.nMM.eP(l, str3);
            this.nMM.cj(str, i);
            if (this.nWy != null) {
                this.nWy.xt(i);
            }
        }
    }

    public final void a(List<b> list, String str, int i, v vVar, a aVar) {
        af.byj().a(this);
        this.dEw = list;
        this.nWR = this.dEw.size() > 1;
        aj.Ml(str);
        this.nML = vVar;
        this.nMM = aVar;
        this.nWy = new b(this, this.context);
        this.nWz.setAdapter(this.nWy);
        if (i >= 0 && i < this.dEw.size()) {
            this.nWz.setSelection(i);
            if (this.nWK) {
                this.nWK = false;
                ate ate = ((b) this.dEw.get(i)).caK;
                if (ate == null || ate.rVH == null || ate.rVH.rWv <= 0.0f) {
                    this.nWL = 1.0f;
                } else {
                    this.nWL = ate.rVH.rWu / ate.rVH.rWv;
                }
            }
        }
        this.nWz.setFadingEdgeLength(0);
        this.nWz.setOnItemSelectedListener(new 4(this));
        if (this.nWA) {
            this.nWz.setOnItemLongClickListener(new 5(this));
        }
        if (this.nWE && this.nWy.getCount() > 1) {
            this.nWM.setVisibility(0);
            this.nWM.eS(this.nWy.getCount(), i);
        }
        if (this.nTz && !bi.oW(((b) this.nWy.getItem(i)).nuP)) {
            NK(an.s(af.getAccSnsPath(), ((b) this.nWy.getItem(i)).caK.ksA) + i.l(((b) this.nWy.getItem(i)).caK));
        }
    }

    public long getSnsId() {
        b bVar = (b) this.nWz.getSelectedItem();
        String str = bVar == null ? "" : bVar.nuP;
        if (bi.oW(str)) {
            return 0;
        }
        n Nl = af.byo().Nl(str);
        return Nl == null ? 0 : Nl.field_snsId;
    }

    public int getPosition() {
        return this.nWQ;
    }

    private void bDq() {
        if (this.nWz.getSelectedItem() != null && this.nWy != null) {
            int selectedItemPosition = this.nWz.getSelectedItemPosition();
            if (this.nWE && this.nWy.getCount() > 1) {
                this.nWM.setVisibility(0);
                this.nWM.setPage(selectedItemPosition);
            }
            ate ate = ((b) this.nWz.getSelectedItem()).caK;
            this.nXb.add(ate.ksA);
            String str = ((b) this.nWz.getSelectedItem()).nuP;
            String str2 = ate.ksA;
            if (bi.oW(this.nWO) || !this.nWO.equals(str2)) {
                this.nWO = "";
            }
            a(ate, selectedItemPosition, str);
        }
    }

    public final void aKx() {
        if (this.nWy != null) {
            x.d("MicroMsg.SnsInfoFlip", "onRefresh ");
            this.nWy.notifyDataSetChanged();
            bDq();
        }
    }

    protected final void onPause() {
        super.onPause();
        if (this.nWy != null) {
            this.nWy.bDx();
            this.nWy.clear();
        }
    }

    protected void onMeasure(int i, int i2) {
        this.nWX = true;
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.nWX = false;
        super.onLayout(z, i, i2, i3, i4);
    }

    public Gallery getGallery() {
        return this.nWz;
    }

    public final void bDr() {
        x.i("MicroMsg.SnsInfoFlip", "sns info flip on detch.");
        if (this.nWy != null) {
            this.nWy.bDx();
            this.nWy.clear();
        }
        af.byj().b(this);
    }

    public final int bDs() {
        if (this.nWz == null) {
            return -1;
        }
        this.dEw.remove(this.nWz.getSelectedItemPosition());
        this.nWy.notifyDataSetChanged();
        bDq();
        return this.nWy.getCount();
    }

    public int getCount() {
        if (this.nWy != null) {
            return this.nWy.getCount();
        }
        return 0;
    }

    public ate getCntMedia() {
        if (this.nWy != null) {
            int selectedItemPosition = this.nWz.getSelectedItemPosition();
            if (this.dEw != null && selectedItemPosition < this.dEw.size()) {
                return ((b) this.dEw.get(selectedItemPosition)).caK;
            }
        }
        return null;
    }

    public int getSelectCount() {
        return this.nXb.size();
    }

    public int gettotalSuccDownload() {
        return this.nXd;
    }

    public int getNumOfFileExist() {
        int i;
        int i2 = 0;
        Iterator it = this.dEw.iterator();
        int i3 = 0;
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            b bVar = (b) it.next();
            af.byl();
            if (FileOp.cn(g.C(bVar.caK))) {
                i++;
            }
            i2 = i3 + 1;
            i3 = 9;
            if (i2 > 9) {
                break;
            }
        }
        return i;
    }

    public final void aS(String str, boolean z) {
        ate ate;
        if (!z) {
            ate = ((b) this.nWz.getSelectedItem()).caK;
            if (!(ate == null || ate.ksA == null || !ate.ksA.equals(str))) {
                Toast.makeText(this.context, this.context.getString(i$j.sns_down_error), 0).show();
                this.nWO = str;
            }
        }
        this.nXd++;
        if (this.nTx) {
            x.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, bigPicId:%s, suceess:%b", new Object[]{str, Boolean.valueOf(z)});
            if (z && this.nXe.containsKey(str)) {
                a aVar = (a) this.nXe.get(str);
                aVar.nXk = System.currentTimeMillis();
                aVar.networkType = getReportNetworkType();
                x.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, update map");
                this.nWU.put(str, Boolean.valueOf(true));
            }
        }
        if (this.nWy != null && ((b) this.nWz.getSelectedItem()) != null) {
            ate = ((b) this.nWz.getSelectedItem()).caK;
            if (ate != null && ate.ksA != null && ate.ksA.equals(str)) {
                this.nWy.notifyDataSetChanged();
                if (this.nTz && ate != null) {
                    String s = an.s(af.getAccSnsPath(), ate.ksA);
                    String l = i.l(ate);
                    if (FileOp.cn(s + l)) {
                        l = s + l;
                        Intent intent = new Intent();
                        x.i("MicroMsg.FlipView", "edit image path:%s", new Object[]{l});
                        intent.putExtra("before_photo_edit", l);
                        intent.putExtra("from_scene", 293);
                        intent.putExtra("after_photo_edit", "");
                        intent.putExtra("Retr_Compress_Type", 0);
                        intent.putExtra("Retr_Msg_Type", 0);
                        intent.putExtra("Retr_FromMainTimeline", bBX());
                        intent.setClass(this.context, MMNewPhotoEditUI.class);
                        this.context.startActivity(intent);
                    }
                }
            }
        }
    }

    public final void aT(String str, boolean z) {
        x.i("MicroMsg.SnsInfoFlip", "onSightFinish " + str + " " + z);
        if (!z) {
            ate ate = ((b) this.nWz.getSelectedItem()).caK;
            if (!(ate == null || ate.ksA == null || !ate.ksA.equals(str))) {
                Toast.makeText(this.context, this.context.getString(i$j.sns_down_sight_error), 0).show();
                this.nWO = str;
            }
        }
        if (this.nWy != null) {
            this.nWy.notifyDataSetChanged();
        }
    }

    public List<b> getFlipList() {
        return this.dEw;
    }

    private int getReportNetworkType() {
        Context context = ad.getContext();
        if (ao.is2G(context)) {
            return 1;
        }
        if (ao.is3G(context)) {
            return 2;
        }
        if (ao.is4G(context)) {
            return 3;
        }
        if (ao.isWifi(context)) {
            return 4;
        }
        return 0;
    }

    public final void bDt() {
        for (a aVar : this.nXe.values()) {
            if (aVar.nXi != -1) {
                h.mEJ.h(11601, new Object[]{Integer.valueOf(aVar.dzO), Integer.valueOf(aVar.nXi), Long.valueOf(aVar.nrX), Integer.valueOf(aVar.networkType)});
                x.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d", new Object[]{Integer.valueOf(aVar.dzO), Integer.valueOf(aVar.nXi), Long.valueOf(aVar.nrX), Integer.valueOf(aVar.networkType)});
            } else if (aVar.nXj != -1) {
                if (aVar.nXk != -1) {
                    aVar.nXi = 1;
                } else {
                    aVar.nXi = 2;
                    aVar.nXk = System.currentTimeMillis();
                }
                aVar.nrX = aVar.nXk - aVar.nXj;
                h.mEJ.h(11601, new Object[]{Integer.valueOf(aVar.dzO), Integer.valueOf(aVar.nXi), Long.valueOf(aVar.nrX), Integer.valueOf(aVar.networkType)});
                x.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d", new Object[]{Integer.valueOf(aVar.dzO), Integer.valueOf(aVar.nXi), Long.valueOf(aVar.nrX), Integer.valueOf(aVar.networkType)});
            }
        }
        this.nXe.clear();
    }
}
