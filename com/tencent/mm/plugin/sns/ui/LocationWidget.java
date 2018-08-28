package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bg.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelstat.e;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i$i;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.protocal.c.aqq;
import com.tencent.mm.protocal.c.arj;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class LocationWidget extends LinearLayout {
    private float biF;
    private int csE;
    private String csL;
    private float dRS;
    private float dRT;
    private boolean dSc;
    private Activity ftd;
    private a kCE;
    private String kFa;
    private b kHU;
    private String kJG;
    private com.tencent.mm.modelgeo.a.a lDG;
    private aqq lDV;
    private c lDo;
    private float lDu;
    private ImageView nLz;
    private TextView nMC;
    private String nOA;
    private int nOB;
    private float nOC;
    private int nOD;
    private a nOE;
    private boolean nOF;
    private b nOG;
    private View nOs;
    private View nOt;
    private int[] nOu;
    private ImageView[] nOv;
    private int nOw;
    private TextView nOx;
    private byte[] nOy;
    private String nOz;
    private int score;

    public LocationWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nOu = new int[]{i$f.score_iv_1, i$f.score_iv_2, i$f.score_iv_3, i$f.score_iv_4, i$f.score_iv_5};
        this.nOv = new ImageView[5];
        this.dRS = -1000.0f;
        this.dRT = -1000.0f;
        this.nOB = 0;
        this.lDV = null;
        this.csE = 0;
        this.nOC = 0.0f;
        this.lDu = 0.0f;
        this.biF = 0.0f;
        this.nOD = -1;
        this.dSc = true;
        this.lDo = c.OB();
        this.nOE = null;
        this.nOF = false;
        this.kCE = new 3(this);
        this.lDG = new com.tencent.mm.modelgeo.a.a() {
            public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
                if (!z) {
                    return true;
                }
                x.d("MicroMsg.LocationWidget", "get location %f %f", new Object[]{Float.valueOf(f2), Float.valueOf(f)});
                e.RW().a(2003, i != 0, LocationWidget.this.lDo == null ? false : LocationWidget.this.lDo.dSc, f, f2, (int) d2);
                o.a(2003, f, f2, 0);
                if (!LocationWidget.this.nOF) {
                    return false;
                }
                if (LocationWidget.this.dRS == -1000.0f || LocationWidget.this.dRT == -1000.0f) {
                    LocationWidget.this.dRS = f2;
                    LocationWidget.this.dRT = f;
                }
                return false;
            }
        };
        this.nOG = null;
        i((MMActivity) context);
    }

    public LocationWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nOu = new int[]{i$f.score_iv_1, i$f.score_iv_2, i$f.score_iv_3, i$f.score_iv_4, i$f.score_iv_5};
        this.nOv = new ImageView[5];
        this.dRS = -1000.0f;
        this.dRT = -1000.0f;
        this.nOB = 0;
        this.lDV = null;
        this.csE = 0;
        this.nOC = 0.0f;
        this.lDu = 0.0f;
        this.biF = 0.0f;
        this.nOD = -1;
        this.dSc = true;
        this.lDo = c.OB();
        this.nOE = null;
        this.nOF = false;
        this.kCE = new 3(this);
        this.lDG = /* anonymous class already generated */;
        this.nOG = null;
        i((MMActivity) context);
    }

    private void i(MMActivity mMActivity) {
        this.ftd = mMActivity;
        View inflate = View.inflate(mMActivity, getLayoutResource(), this);
        this.nOs = inflate.findViewById(i$f.location_contentview);
        this.nOx = (TextView) this.nOs.findViewById(i$f.location_tips);
        this.nMC = (TextView) this.nOs.findViewById(i$f.location_poi);
        this.nLz = (ImageView) this.nOs.findViewById(i$f.location_iv);
        this.nOt = inflate.findViewById(i$f.score_contentview);
        for (int i = 0; i < 5; i++) {
            this.nOv[i] = (ImageView) this.nOt.findViewById(this.nOu[i]);
            this.nOv[i].setOnClickListener(new 1(this, i));
        }
        this.kHU = b.Oz();
        this.nOs.setOnClickListener(new 2(this));
        this.nOA = mMActivity.getIntent().getStringExtra("kpoi_id");
        if (!bi.oW(this.nOA)) {
            this.dRS = mMActivity.getIntent().getFloatExtra("k_lat", -1000.0f);
            this.dRT = mMActivity.getIntent().getFloatExtra("k_lng", -1000.0f);
            this.kFa = mMActivity.getIntent().getStringExtra("kpoi_name");
            this.nOz = mMActivity.getIntent().getStringExtra("Kpoi_address");
            bCf();
        }
        if (g.Eg().Dx()) {
            this.nOw = bi.getInt(com.tencent.mm.k.g.AT().getValue("SnsPostPOICommentSwitch"), 0);
        } else {
            this.nOw = 0;
        }
        bCd();
    }

    private void bCd() {
        int i = 0;
        x.i("MicroMsg.LocationWidget", "updateScoreItem scoreSwtich:%d, classifyId:%s, poiClassifyType:%d, showFlag:%d, isOverSea:%b", new Object[]{Integer.valueOf(this.nOw), this.nOA, Integer.valueOf(this.nOB), Integer.valueOf(this.csE), Boolean.valueOf(bk.cjj())});
        if (bk.cjj() || this.nOw == 0 || bi.oW(this.nOA) || this.nOB == 1 || (this.csE & 1) == 0) {
            this.nOt.setVisibility(8);
            return;
        }
        this.nOt.setVisibility(0);
        while (i < this.score) {
            this.nOv[i].setImageResource(getSelectedStarImageResource());
            i++;
        }
        for (i = this.score; i < 5; i++) {
            this.nOv[i].setImageResource(getNormalStarImageResource());
        }
    }

    public final void bCe() {
        Intent intent = new Intent();
        intent.putExtra("near_life_scene", 1);
        try {
            intent.putExtra("get_poi_item_buf", this.lDV.toByteArray());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.LocationWidget", e, "", new Object[0]);
        }
        if (!bi.oW(this.nOA)) {
            intent.putExtra("get_poi_classify_id", this.nOA);
        } else if (!bi.oW(this.csL)) {
            intent.putExtra("get_city", this.csL);
        }
        intent.putExtra("get_lat", this.dRS);
        intent.putExtra("get_lng", this.dRT);
        intent.putExtra("request_id", this.kJG);
        if (this.nOE != null) {
            ArrayList bCh = this.nOE.bCh();
            if (bCh != null) {
                M(bCh);
                ArrayList arrayList = new ArrayList();
                Iterator it = bCh.iterator();
                while (it.hasNext()) {
                    Exif.a aVar = (Exif.a) it.next();
                    arrayList.add(String.format("%f\n%f", new Object[]{Double.valueOf(aVar.latitude), Double.valueOf(aVar.longitude)}));
                }
            }
        }
        d.b(getContext(), "nearlife", "com.tencent.mm.plugin.nearlife.ui.CheckInLifeUI", intent, 10);
    }

    private void M(ArrayList<Exif.a> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            Exif.a aVar;
            h.mEJ.k(11139, "1");
            if (((double) Math.abs(-1000.0f - this.dRS)) > 1.0E-6d && ((double) Math.abs(-1000.0f - this.dRT)) > 1.0E-6d) {
                aVar = (Exif.a) arrayList.get(arrayList.size() - 1);
                if (b(aVar.latitude, aVar.longitude, (double) this.dRS, (double) this.dRT)) {
                    h.mEJ.k(11139, "2");
                }
            }
            int i = 0;
            while (i < arrayList.size()) {
                Object obj;
                int i2 = i + 1;
                while (true) {
                    int i3 = i2;
                    if (i3 >= arrayList.size()) {
                        i2 = 1;
                        break;
                    }
                    aVar = (Exif.a) arrayList.get(i);
                    Exif.a aVar2 = (Exif.a) arrayList.get(i3);
                    if (b(aVar.latitude, aVar.longitude, aVar2.latitude, aVar2.longitude)) {
                        h.mEJ.k(11139, "3");
                        obj = null;
                        break;
                    }
                    i2 = i3 + 1;
                }
                if (obj != null) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    private static boolean b(double d, double d2, double d3, double d4) {
        return q.c(d, d2, d3, d4) > 1000.0d;
    }

    public final void stop() {
        if (this.lDo != null) {
            this.lDo.c(this.lDG);
        }
        if (this.kHU != null) {
            this.kHU.a(this.kCE);
        }
    }

    public final boolean Y(Intent intent) {
        if (intent != null) {
            this.nOB = intent.getIntExtra("get_poi_classify_type", 0);
            this.csE = intent.getIntExtra("get_poi_showflag", 0);
            x.d("MicroMsg.LocationWidget", "onactivity result ok poiClassifyType %d", new Object[]{Integer.valueOf(this.nOB)});
            this.kFa = bi.aG(intent.getStringExtra("get_poi_name"), "");
            this.csL = bi.aG(intent.getStringExtra("get_city"), "");
            this.dRS = intent.getFloatExtra("get_lat", -1000.0f);
            this.dRT = intent.getFloatExtra("get_lng", -1000.0f);
            x.i("MicroMsg.LocationWidget", "check cur lat " + this.nOC + " " + this.lDu);
            this.nOC = intent.getFloatExtra("get_cur_lat", 0.0f);
            this.lDu = intent.getFloatExtra("get_cur_lng", 0.0f);
            this.nOD = intent.getIntExtra("get_loctype", -1);
            this.biF = intent.getFloatExtra("get_accuracy", 0.0f);
            this.dSc = intent.getBooleanExtra("get_is_mars", true);
            this.kJG = intent.getStringExtra("request_id");
            e.RW().a(2003, this.nOD != 0, this.dSc, this.dRT, this.dRS, (int) this.biF);
            this.nOy = intent.getByteArrayExtra("location_ctx");
            if (!bi.oW(this.kFa)) {
                this.nOz = bi.aG(intent.getStringExtra("get_poi_address"), "");
                this.nOA = bi.aG(intent.getStringExtra("get_poi_classify_id"), "");
                this.lDV = new aqq();
                try {
                    this.lDV = (aqq) this.lDV.aG(intent.getByteArrayExtra("get_poi_item_buf"));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.LocationWidget", e, "", new Object[0]);
                    this.lDV = null;
                }
                if (!bi.oW(this.nOA)) {
                    this.lDV = new aqq();
                    this.lDV.lCG = this.nOA;
                    this.lDV.hcE = this.nOB;
                    this.lDV.bHD = this.kFa;
                    this.lDV.lCL.add(new bhz().VO(this.nOz));
                }
            } else if (bi.oW(this.csL)) {
                this.dRS = -1000.0f;
                this.dRT = -1000.0f;
                this.kFa = "";
                this.nOz = "";
                this.csL = "";
                this.nOA = "";
                this.lDV = null;
            } else {
                this.kFa = "";
                this.nOz = "";
                this.nOA = "";
                this.lDV = null;
            }
            x.d("MicroMsg.LocationWidget", "label %s poiname %s", new Object[]{this.nOz, this.kFa});
            bCf();
            bCd();
            this.nOG = new b(this);
            b bVar = this.nOG;
            if (intent != null) {
                bVar.index = intent.getIntExtra("report_index", -1);
                bVar.lDx = intent.getLongExtra("first_start_time", 0);
                bVar.lDy = intent.getLongExtra("lastSuccStamp", 0);
                bVar.lDz = intent.getLongExtra("firstSuccStamp", 0);
                bVar.lDA = intent.getIntExtra("reqLoadCnt", 0);
                bVar.kIW = intent.getIntExtra("entry_time", 0);
                bVar.fuu = intent.getStringExtra("search_id");
            }
        }
        return true;
    }

    private void bCf() {
        if (!(this.nOx == null || this.nMC == null)) {
            if (!bi.oW(this.kFa)) {
                this.nOx.setText(this.kFa);
                this.nOx.setTextColor(getResources().getColor(i.c.green_text_color));
                this.nMC.setVisibility(8);
            } else if (bi.oW(this.csL)) {
                this.nOx.setText(i$j.sns_location_tips);
                this.nOx.setTextColor(getResources().getColor(i.c.normal_text_color));
                this.nMC.setVisibility(8);
            } else {
                this.nOx.setText(this.csL);
                this.nOx.setTextColor(getResources().getColor(i.c.green_text_color));
                this.nMC.setVisibility(8);
            }
        }
        if (bi.oW(this.kFa) && bi.oW(this.csL)) {
            this.nLz.setImageResource(getNormalStateImageResource());
        } else {
            this.nLz.setImageResource(getSelectedStateImageResource());
        }
    }

    protected int getNormalStateImageResource() {
        return i$i.album_location_icon_normal;
    }

    protected int getSelectedStateImageResource() {
        return i$i.album_location_icon_pressed;
    }

    protected int getNormalStarImageResource() {
        return i$i.sns_shoot_star_normal;
    }

    protected int getSelectedStarImageResource() {
        return i$i.sns_shoot_star_selected;
    }

    public arj getLocation() {
        arj arj = new arj();
        arj.rms = this.dRS;
        arj.rmr = this.dRT;
        arj.rTJ = 0;
        arj.score = this.score;
        if (this.nOy != null) {
            arj.rTK = new com.tencent.mm.bk.b(this.nOy);
        }
        if (!bi.oW(this.kFa)) {
            arj.nOz = this.nOz;
            arj.kFa = this.kFa;
            arj.rTG = this.nOA;
            arj.eJJ = this.csL;
            if (this.nOB == 0 || this.nOB != 1) {
                arj.nOB = 1;
            } else {
                arj.nOB = 2;
            }
            x.d("MicroMsg.LocationWidget", "getlocation type %d", new Object[]{Integer.valueOf(arj.nOB)});
        } else if (!bi.oW(this.csL)) {
            arj.eJJ = this.csL;
        }
        if (this.nOG != null) {
            String format = String.format("%f/%f", new Object[]{Float.valueOf(arj.rms), Float.valueOf(arj.rmr)});
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("index " + this.nOG.index);
            stringBuffer.append("firstStartStamp " + this.nOG.lDx);
            stringBuffer.append("lastSuccStamp " + this.nOG.lDz);
            stringBuffer.append("firstSuccStamp " + this.nOG.lDy);
            stringBuffer.append("reqLoadCnt " + this.nOG.lDA);
            stringBuffer.append("classifyId " + this.nOA);
            stringBuffer.append("entryTime " + this.nOG.kIW);
            stringBuffer.append("searchId" + this.nOG.fuu);
            x.d("MicroMsg.LocationWidget", "report %s", new Object[]{stringBuffer.toString()});
            h.mEJ.h(11135, new Object[]{Integer.valueOf(5), Integer.valueOf(this.nOG.index + 1), Long.valueOf(this.nOG.lDx), Long.valueOf(this.nOG.lDz), Long.valueOf(System.currentTimeMillis()), Long.valueOf(this.nOG.lDy), Integer.valueOf(this.nOG.lDA), format, this.nOA, Integer.valueOf(this.nOG.kIW), this.nOG.fuu, com.tencent.mm.compatible.e.q.zy()});
        }
        bCg();
        return arj;
    }

    public int getShowFlag() {
        return this.csE;
    }

    public arj getCurLocation() {
        arj arj = new arj();
        arj.rms = this.nOC;
        arj.rmr = this.lDu;
        arj.biF = this.biF;
        arj.nOD = this.nOD;
        return arj;
    }

    private void bCg() {
        if (this.nOE != null) {
            boolean bCi = this.nOE.bCi();
            ArrayList bCh = this.nOE.bCh();
            if (bCh != null && bCh.size() != 0) {
                Iterator it = bCh.iterator();
                while (it.hasNext()) {
                    int i;
                    Exif.a aVar = (Exif.a) it.next();
                    x.d("MicroMsg.LocationWidget", "snsreport lat lng %f, %f", new Object[]{Double.valueOf(aVar.latitude), Double.valueOf(aVar.longitude)});
                    h hVar = h.mEJ;
                    Object[] objArr = new Object[4];
                    objArr[0] = Integer.valueOf((int) (aVar.latitude * 1000000.0d));
                    objArr[1] = Integer.valueOf((int) (aVar.longitude * 1000000.0d));
                    if (bCi) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    objArr[2] = Integer.valueOf(i);
                    objArr[3] = Integer.valueOf(2);
                    hVar.h(11345, objArr);
                }
            }
        }
    }

    public void setLocationWidgetListener(a aVar) {
        this.nOE = aVar;
    }

    protected int getLayoutResource() {
        return i$g.location_widget;
    }
}
