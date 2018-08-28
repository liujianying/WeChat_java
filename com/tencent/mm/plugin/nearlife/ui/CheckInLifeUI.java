package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.protocal.c.aqq;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

public class CheckInLifeUI extends BaseLifeUI implements e {
    private String csL = "";
    private OnClickListener jXR = new 1(this);
    private String lDL = "";
    private b lDR;
    private b lDS;
    private ArrayList<LatLongData> lDT;
    private b lDU = null;
    private aqq lDV;
    private OnClickListener lDW = new 2(this);
    private a lDX = new a() {
        public final void b(Addr addr) {
            x.i("MicroMsg.CheckInLifeUI", "get info %s", new Object[]{addr.toString()});
            if (bi.oW(CheckInLifeUI.this.csL)) {
                CheckInLifeUI.this.csL = addr.dRJ;
                CheckInLifeUI.this.lDR.dW(CheckInLifeUI.this.csL, addr.dRR);
            }
        }
    };

    static /* synthetic */ void a(CheckInLifeUI checkInLifeUI, View view, boolean z) {
        x.d("MicroMsg.CheckInLifeUI", "click tag");
        if (view.getTag() instanceof b.a) {
            LatLongData IJ;
            int IK;
            b.a aVar = (b.a) view.getTag();
            com.tencent.mm.plugin.nearlife.b.a aVar2 = aVar.lDN;
            Intent intent = new Intent();
            try {
                intent.putExtra("get_poi_item_buf", aVar2.lCP.toByteArray());
                intent.putExtra("location_ctx", aVar2.lCO.siK.lR);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CheckInLifeUI", e, "", new Object[0]);
            }
            if (z) {
                IJ = checkInLifeUI.lDS.IJ(aVar.lCG);
                IK = checkInLifeUI.lDS.IK(aVar.lCG);
                checkInLifeUI.a(IK, true, aVar.lCG);
            } else {
                IJ = checkInLifeUI.lDR.IJ(aVar.lCG);
                IK = checkInLifeUI.lDR.IK(aVar.lCG);
                checkInLifeUI.a(IK, false, aVar.lCG);
            }
            intent.putExtra("report_index", IK);
            intent.putExtra("first_start_time", checkInLifeUI.lDx);
            intent.putExtra("lastSuccStamp", checkInLifeUI.lDz);
            intent.putExtra("firstSuccStamp", checkInLifeUI.lDy);
            intent.putExtra("reqLoadCnt", checkInLifeUI.lDA);
            intent.putExtra("entry_time", checkInLifeUI.kIW);
            intent.putExtra("search_id", aVar2.kJF);
            intent.putExtra("request_id", aVar2.kJG);
            if (IJ == null) {
                IJ = checkInLifeUI.lDs == null ? new LatLongData(-85.0f, -1000.0f) : new LatLongData(checkInLifeUI.lDs.rms, checkInLifeUI.lDs.rmr);
            }
            x.i("MicroMsg.CheckInLifeUI", "lbs.Type %d", new Object[]{Integer.valueOf(aVar2.hcE)});
            switch (aVar.type) {
                case 0:
                    if (IJ != null) {
                        intent.putExtra("get_lat", IJ.bSx);
                        intent.putExtra("get_lng", IJ.dVI);
                    }
                    if (!bi.oW(checkInLifeUI.csL)) {
                        intent.putExtra("get_city", checkInLifeUI.csL);
                    }
                    intent.putExtra("get_poi_classify_type", aVar2.hcE);
                    intent.putExtra("get_poi_address", a.bC(aVar2.lCL));
                    intent.putExtra("get_poi_classify_id", aVar2.lCG);
                    intent.putExtra("get_poi_name", aVar2.bHD);
                    intent.putExtra("get_poi_showflag", aVar2.csE);
                    break;
                case 1:
                    if (IJ != null) {
                        intent.putExtra("get_lat", IJ.bSx);
                        intent.putExtra("get_lng", IJ.dVI);
                    }
                    intent.putExtra("get_city", aVar2.bHD);
                    break;
            }
            intent.putExtra("get_cur_lat", checkInLifeUI.lDt);
            intent.putExtra("get_cur_lng", checkInLifeUI.lDu);
            intent.putExtra("get_accuracy", checkInLifeUI.lDw);
            intent.putExtra("get_loctype", checkInLifeUI.lDv);
            intent.putExtra("get_is_mars", checkInLifeUI.dSc);
            checkInLifeUI.setResult(-1, intent);
            checkInLifeUI.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.near_check_list);
        this.lDU = b.Oz();
        this.lDV = new aqq();
        this.lDL = getIntent().getStringExtra("get_poi_classify_id");
        try {
            this.lDV = (aqq) this.lDV.aG(getIntent().getByteArrayExtra("get_poi_item_buf"));
            if (this.lDV != null) {
                this.lDL = this.lDV.lCG;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CheckInLifeUI", e, "", new Object[0]);
            this.lDV = null;
        }
        if (bi.oW(this.lDL)) {
            this.csL = getIntent().getStringExtra("get_city");
        }
        if (!bi.oW(this.csL)) {
            this.lDL = this.lDR.dW(this.csL, "").lCG;
        }
        this.lDR.lDL = this.lDL;
        if (this.lDV != null && !bi.oW(this.lDV.lCG)) {
            b bVar = this.lDR;
            com.tencent.mm.plugin.nearlife.b.a aVar = new com.tencent.mm.plugin.nearlife.b.a("", this.lDV);
            if (bVar.lDJ == null) {
                bVar.a(aVar, 1);
            } else {
                bVar.a(aVar, 2);
            }
        }
    }

    public final void bjd() {
        super.bjd();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.lDU != null) {
            this.lDU.a(this.lDX);
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.near_life_ui;
    }

    public final a bjb() {
        if (this.lDT == null) {
            this.lDT = H(getIntent().getStringArrayListExtra("lat_long_list"));
        }
        if (this.lDR != null) {
            return this.lDR;
        }
        this.lDR = new b(this, this.jXR, "viewlist", false);
        if (!(this.lDT == null || this.lDT.size() == 0)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.lDT.get(this.lDT.size() - 1));
            this.lDR.G(arrayList);
            this.lDR.lDf = false;
        }
        return this.lDR;
    }

    public final a bjc() {
        if (this.lDT == null) {
            this.lDT = H(getIntent().getStringArrayListExtra("lat_long_list"));
        }
        if (this.lDS != null) {
            return this.lDS;
        }
        this.lDS = new b(this, this.lDW, "searchlist", true);
        this.lDS.G(this.lDT);
        this.lDS.lDf = true;
        return this.lDS;
    }

    public final void p(double d, double d2) {
        x.i("MicroMsg.CheckInLifeUI", "checkinLife got address %f %f", new Object[]{Double.valueOf(d), Double.valueOf(d2)});
        if (this.lDU != null && bi.oW(this.csL)) {
            this.lDU.a(d, d2, this.lDX);
        }
    }

    private static ArrayList<LatLongData> H(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<LatLongData> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String[] split = ((String) it.next()).split("\n");
            if (2 == split.length) {
                try {
                    arrayList2.add(new LatLongData(Float.valueOf(split[0]).floatValue(), Float.valueOf(split[1]).floatValue()));
                } catch (NumberFormatException e) {
                }
            }
        }
        x.i("MicroMsg.CheckInLifeUI", "parse list end, size: " + arrayList2.size());
        return arrayList2;
    }
}
