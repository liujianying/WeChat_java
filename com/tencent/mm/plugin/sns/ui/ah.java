package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.ui.previewimageview.DynamicGridView;
import com.tencent.mm.plugin.sns.ui.previewimageview.e;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.arj;
import com.tencent.mm.protocal.c.boj;
import com.tencent.mm.protocal.c.bpo;
import com.tencent.mm.protocal.c.bqg;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.b.d.i;

public final class ah extends a {
    private String appId;
    private String appName;
    MMActivity bGc;
    private String fmS;
    private int nMA;
    private b nMG = null;
    private boolean nNY = false;
    private boolean nNZ = false;
    private boolean nOU = false;
    private WXMediaMessage nOa = null;
    b nPY = new b(this);
    w nPZ;
    Map<String, com.tencent.mm.compatible.util.Exif.a> nQa = new HashMap();
    private Map<String, bpo> nQb = new HashMap();
    private int nQc = 0;
    private boolean nQd = false;
    arj nQe;

    class a extends h<String, Integer, Boolean> {
        private ProgressDialog eHw = null;
        private ax nOW;
        private List<com.tencent.mm.plugin.sns.data.h> nQg;

        public final /* synthetic */ Object bxI() {
            long currentTimeMillis = System.currentTimeMillis();
            ax axVar = this.nOW;
            axVar.cj(this.nQg);
            this.nOW = axVar;
            x.d("MicroMsg.MMAsyncTask", "commit imp time " + (System.currentTimeMillis() - currentTimeMillis));
            return Boolean.valueOf(true);
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Boolean) obj);
            this.eHw.dismiss();
            ah.this.a(this.nOW);
        }

        public a(ax axVar, List<com.tencent.mm.plugin.sns.data.h> list) {
            this.nOW = axVar;
            this.nQg = list;
            MMActivity mMActivity = ah.this.bGc;
            ah.this.bGc.getString(j.app_tip);
            this.eHw = com.tencent.mm.ui.base.h.a(mMActivity, ah.this.bGc.getString(j.app_loading_data), false, new 1(this, ah.this));
        }

        public final ag bxH() {
            return af.byb();
        }
    }

    public ah(MMActivity mMActivity) {
        this.bGc = mMActivity;
    }

    public final void G(Bundle bundle) {
        String str;
        int i = 1;
        this.nMG = b.p(this.bGc.getIntent());
        this.nOU = this.bGc.getIntent().getBooleanExtra("Kis_take_photo", false);
        this.appId = bi.aG(this.bGc.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bi.aG(this.bGc.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.nNY = this.bGc.getIntent().getBooleanExtra("KThrid_app", false);
        this.nQd = this.bGc.getIntent().getBooleanExtra("KBlockAdd", false);
        this.nNZ = this.bGc.getIntent().getBooleanExtra("KSnsAction", false);
        this.nMA = this.bGc.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.fmS = bi.aG(this.bGc.getIntent().getStringExtra("reportSessionId"), "");
        Bundle bundleExtra = this.bGc.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.nOa = new Req(bundleExtra).message;
        }
        String stringExtra = this.bGc.getIntent().getStringExtra("sns_kemdia_path");
        byte[] byteArrayExtra = this.bGc.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
        if (byteArrayExtra == null && this.nOa != null && this.nOa.mediaObject != null && (this.nOa.mediaObject instanceof WXImageObject)) {
            byteArrayExtra = ((WXImageObject) this.nOa.mediaObject).imageData;
        }
        if (!bi.oW(stringExtra) || bi.bC(byteArrayExtra)) {
            str = stringExtra;
        } else {
            stringExtra = af.getAccSnsTmpPath() + g.u((" " + System.currentTimeMillis()).getBytes());
            FileOp.deleteFile(stringExtra);
            FileOp.b(stringExtra, byteArrayExtra, byteArrayExtra.length);
            str = stringExtra;
        }
        int intExtra = this.bGc.getIntent().getIntExtra("KFilterId", 0);
        if (bundle == null) {
            stringExtra = null;
        } else {
            stringExtra = bundle.getString("sns_kemdia_path_list");
        }
        I(bundle);
        boolean I = I(this.bGc.getIntent().getExtras());
        this.nQc = 0;
        com.tencent.mm.compatible.util.Exif.a location;
        if (!bi.oW(stringExtra)) {
            this.nPY.NU(stringExtra);
        } else if (bi.oW(str)) {
            ArrayList stringArrayListExtra = this.bGc.getIntent().getStringArrayListExtra("sns_kemdia_path_list");
            if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                Iterator it = stringArrayListExtra.iterator();
                while (it.hasNext()) {
                    str = (String) it.next();
                    x.d("MicroMsg.PicWidget", "newPath " + str);
                    this.nPY.l(str, intExtra, false);
                    if (!I) {
                        location = Exif.fromFile(str).getLocation();
                        if (location != null) {
                            this.nQa.put(str, location);
                        }
                    }
                    try {
                        File file = new File(str);
                        bpo bpo = new bpo();
                        bpo.snJ = this.nOU ? 1 : 2;
                        bpo.snL = file.lastModified() / 1000;
                        bpo.snK = Exif.fromFile(str).getUxtimeDatatimeOriginal();
                        this.nQb.put(str, bpo);
                    } catch (Exception e) {
                        x.e("MicroMsg.PicWidget", "get report info error " + e.getMessage());
                    }
                }
            }
        } else {
            int i2;
            String str2 = af.getAccSnsTmpPath() + "pre_temp_sns_pic" + g.u(str.getBytes());
            File file2 = new File(str2);
            if (!file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            FileOp.y(str, str2);
            if (intExtra == -1) {
                i2 = 0;
            } else {
                i2 = intExtra;
            }
            this.nPY.l(str2, i2, this.nOU);
            if (!I) {
                location = Exif.fromFile(str).getLocation();
                if (location != null) {
                    this.nQa.put(str2, location);
                }
            }
            try {
                file2 = new File(str);
                bpo bpo2 = new bpo();
                if (!this.nOU) {
                    i = 2;
                }
                bpo2.snJ = i;
                bpo2.snL = file2.lastModified() / 1000;
                bpo2.snK = Exif.fromFile(str).getUxtimeDatatimeOriginal();
                this.nQb.put(str2, bpo2);
            } catch (Exception e2) {
                x.e("MicroMsg.PicWidget", "get report info error " + e2.getMessage());
            }
        }
    }

    private boolean I(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        ArrayList stringArrayList = bundle.getStringArrayList("sns_media_latlong_list");
        if (stringArrayList == null) {
            return false;
        }
        Iterator it = stringArrayList.iterator();
        while (it.hasNext()) {
            String[] split = ((String) it.next()).split("\n");
            if (3 != split.length) {
                x.e("MicroMsg.PicWidget", "invalid params");
                return true;
            }
            try {
                this.nQa.put(split[0].trim(), new com.tencent.mm.compatible.util.Exif.a(bi.getDouble(split[1], 0.0d), bi.getDouble(split[2], 0.0d), 0.0d));
            } catch (NumberFormatException e) {
                x.e("MicroMsg.PicWidget", e.toString());
            }
        }
        return true;
    }

    public final void H(Bundle bundle) {
        bundle.putString("sns_kemdia_path_list", this.nPY.toString());
        ArrayList arrayList = new ArrayList();
        for (Entry entry : this.nQa.entrySet()) {
            arrayList.add(String.format("%s\n%f\n%f", new Object[]{entry.getKey(), Double.valueOf(((com.tencent.mm.compatible.util.Exif.a) entry.getValue()).latitude), Double.valueOf(((com.tencent.mm.compatible.util.Exif.a) entry.getValue()).longitude)}));
        }
        bundle.putStringArrayList("sns_media_latlong_list", arrayList);
        bundle.getString("contentdesc");
    }

    public final boolean bBU() {
        if (this.nPY != null) {
            b bVar = this.nPY;
            boolean z = bVar.nQj != null && bVar.nQj.size() > 0;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final View a(View view, View view2, DynamicGridView dynamicGridView, View view3) {
        boolean z;
        MMActivity mMActivity = this.bGc;
        List list = this.nPY.nQj;
        AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.sns.ui.w.a() {
            public final void xh(int i) {
                x.d("MicroMsg.PicWidget", "I click");
                if (i < 0) {
                    ah.this.bCA();
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(ah.this.bGc, SnsUploadBrowseUI.class);
                intent.putExtra("sns_gallery_position", i);
                intent.putExtra("sns_gallery_temp_paths", ah.this.nPY.nQj);
                ah.this.bGc.startActivityForResult(intent, 7);
            }
        };
        AnonymousClass2 anonymousClass2 = new com.tencent.mm.plugin.sns.ui.previewimageview.c.a() {
            public final void dC(int i, int i2) {
                b bVar = ah.this.nPY;
                if (i != i2 && bVar.nQj.size() > i) {
                    String str = (String) bVar.nQj.remove(i);
                    if (i2 < bVar.nQj.size()) {
                        bVar.nQj.add(i2, str);
                    } else {
                        bVar.nQj.add(str);
                    }
                }
                ah.this.bGc.getIntent().putExtra("sns_kemdia_path_list", ah.this.nPY.nQj);
            }

            public final void removeItem(int i) {
                b bVar = ah.this.nPY;
                if (bVar.nQj.size() > i) {
                    bVar.nQj.remove(i);
                }
                if (ah.this.bGc instanceof SnsUploadUI) {
                    ((SnsUploadUI) ah.this.bGc).bEA();
                }
                ah.this.bGc.getIntent().putExtra("sns_kemdia_path_list", ah.this.nPY.nQj);
                ((e) ah.this.nPZ).xH(ah.this.nPY.nQj.size());
            }
        };
        if (this.nQd) {
            z = false;
        } else {
            z = true;
        }
        this.nPZ = new e(view, view2, view3, mMActivity, list, dynamicGridView, anonymousClass1, anonymousClass2, z);
        return this.nPZ.getView();
    }

    public final View bBV() {
        this.nPZ = new PreviewImageView(this.bGc);
        if (this.nQd) {
            this.nPZ.setIsShowAddImage(false);
        }
        this.nPZ.setImageClick(new 3(this));
        this.nPZ.setList$22875ea3(this.nPY.nQj);
        return this.nPZ.getView();
    }

    private static ax a(ax axVar, List<com.tencent.mm.plugin.sns.data.h> list) {
        axVar.cj(list);
        return axVar;
    }

    final void a(ax axVar) {
        int commit = axVar.commit();
        if (this.nMG != null) {
            this.nMG.iq(commit);
            com.tencent.mm.plugin.sns.h.e.nxO.c(this.nMG);
        }
        if (!(this.nPY == null || this.nPY.nQj == null || !s.bBF())) {
            com.tencent.mm.plugin.report.service.h.mEJ.h(12834, new Object[]{Integer.valueOf(this.nPY.nQj.size())});
        }
        Intent intent = new Intent();
        intent.putExtra("sns_local_id", commit);
        this.bGc.setResult(-1, intent);
        this.bGc.finish();
    }

    public final boolean a(int i, int i2, i iVar, String str, List<String> list, arj arj, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        String str3;
        List<com.tencent.mm.plugin.sns.data.h> linkedList = new LinkedList();
        Iterator it = this.nPY.nQj.iterator();
        int i6 = 0;
        while (it.hasNext()) {
            str3 = (String) it.next();
            com.tencent.mm.plugin.sns.data.h hVar = new com.tencent.mm.plugin.sns.data.h(str3, 2);
            hVar.type = 2;
            hVar.nkY = i;
            if (i6 == 0) {
                hVar.nkX = i2;
                if (iVar != null) {
                    hVar.nla = iVar.token;
                    hVar.nlb = iVar.rWk;
                }
            } else {
                hVar.nkX = 0;
            }
            int i7 = i6 + 1;
            b bVar = this.nPY;
            hVar.nkW = bVar.nQl.containsKey(str3) ? ((Integer) bVar.nQl.get(str3)).intValue() : 0;
            hVar.desc = str;
            bVar = this.nPY;
            boolean booleanValue = (bi.oW(str3) || !bVar.nQk.containsKey(str3)) ? false : ((Boolean) bVar.nQk.get(str3)).booleanValue();
            hVar.nld = booleanValue;
            linkedList.add(hVar);
            i6 = i7;
        }
        LinkedList linkedList2 = new LinkedList();
        if (list != null) {
            LinkedList linkedList3 = new LinkedList();
            List Hv = com.tencent.mm.model.s.Hv();
            for (String str32 : list) {
                if (!Hv.contains(str32)) {
                    bqg bqg = new bqg();
                    bqg.hbL = str32;
                    linkedList2.add(bqg);
                }
            }
        }
        ax axVar = new ax(1);
        pInt.value = axVar.afv;
        if (iVar != null) {
            axVar.eB(iVar.token, iVar.rWk);
        }
        if (i3 > com.tencent.mm.plugin.sns.c.a.nkE) {
            axVar.wC(3);
        }
        axVar.My(str).a(arj).ag(linkedList2).wE(i).wF(i2);
        if (z) {
            axVar.wH(1);
        } else {
            axVar.wH(0);
        }
        if (!bi.oW(this.appId)) {
            axVar.ME(this.appId);
        }
        if (!bi.oW(this.appName)) {
            axVar.MF(bi.aG(this.appName, ""));
        }
        axVar.wG(this.nMA);
        if (this.nNY) {
            axVar.wG(5);
        }
        if (this.nNZ && this.nOa != null) {
            axVar.Mz(this.nOa.mediaTagName);
            axVar.aa(this.appId, this.nOa.messageExt, this.nOa.messageAction);
        }
        axVar.f(null, null, null, i4, i5);
        axVar.ci(list2);
        axVar.setSessionId(this.fmS);
        if (!(arj == null || arj.score == 0)) {
            i6 = arj.score;
            String str4 = arj.rTG;
            axVar.nsy.rWt = new boj();
            axVar.nsy.rWt.smt = i6;
            axVar.nsy.rWt.smq = str4;
        }
        x.i("MicroMsg.PicWidget", "commit pic size %d, browseImageCount:%d", new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(this.nQc)});
        com.tencent.mm.plugin.report.service.h.mEJ.h(11602, new Object[]{Integer.valueOf(this.nQc), Integer.valueOf(linkedList.size())});
        for (com.tencent.mm.plugin.sns.data.h hVar2 : linkedList) {
            x.i("MicroMsg.PicWidget", "commit path  %s len: %d", new Object[]{hVar2.path, Long.valueOf(FileOp.mI(hVar2.path))});
        }
        for (com.tencent.mm.plugin.sns.data.h hVar22 : linkedList) {
            bpo bpo;
            String str5 = hVar22.path;
            bpo bpo2 = (bpo) this.nQb.get(str5);
            if (bpo2 == null) {
                bpo = new bpo();
            } else {
                bpo = bpo2;
            }
            if (this.nQe == null || (this.nQe.rms == 0.0f && this.nQe.rmr == 0.0f)) {
                bpo.snH = -1000.0f;
                bpo.snI = -1000.0f;
            } else {
                bpo.snH = this.nQe.rms;
                bpo.snI = this.nQe.rmr;
                bpo.nOD = this.nQe.nOD;
                bpo.biF = this.nQe.biF;
            }
            com.tencent.mm.compatible.util.Exif.a aVar = (com.tencent.mm.compatible.util.Exif.a) this.nQa.get(str5);
            if (aVar == null || (aVar.latitude == 0.0d && aVar.longitude == 0.0d)) {
                bpo.snF = -1000.0f;
                bpo.snG = -1000.0f;
            } else {
                bpo.snF = (float) aVar.latitude;
                bpo.snG = (float) aVar.longitude;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("||index: " + axVar.nsy.rWo.size());
            stringBuffer.append("||item poi lat " + bpo.snH + " " + bpo.snI);
            stringBuffer.append("||item pic lat " + bpo.snF + " " + bpo.snG);
            stringBuffer.append("||item exitime:" + bpo.snK + " filetime: " + bpo.snL);
            stringBuffer.append("||item source: " + bpo.snJ);
            x.i("MicroMsg.UploadPackHelper", "addSnsReportInfo item : " + stringBuffer.toString());
            axVar.nsy.rWo.add(bpo);
        }
        if (linkedList.size() <= 1) {
            a(axVar, linkedList);
            a(axVar);
        } else {
            new a(axVar, linkedList).o(new String[]{""});
        }
        com.tencent.mm.kernel.g.Em().H(new 4(this));
        return true;
    }

    protected final boolean bCA() {
        com.tencent.mm.kernel.g.Ek();
        if (!com.tencent.mm.kernel.g.Ei().isSDCardAvailable()) {
            com.tencent.mm.ui.base.s.gH(this.bGc);
            return false;
        } else if (this.nPY.nQj.size() >= 9) {
            com.tencent.mm.ui.base.h.i(this.bGc, j.sns_upload_litmit, j.app_tip);
            return false;
        } else {
            try {
                ba baVar = new ba(this.bGc);
                baVar.ofp = new 5(this);
                baVar.ofq = new 6(this);
                baVar.bEo();
            } catch (Exception e) {
            }
            return true;
        }
    }

    public final boolean d(List<String> list, int i, boolean z) {
        if (list == null || list.size() == 0) {
            x.i("MicroMsg.PicWidget", "no image selected");
        } else if (this.nPY.nQj.size() < 9) {
            for (String str : list) {
                if (FileOp.cn(str)) {
                    String str2 = "pre_temp_sns_pic" + g.u((str + System.currentTimeMillis()).getBytes());
                    s.ad(af.getAccSnsTmpPath(), str, str2);
                    x.d("MicroMsg.PicWidget", "newPath " + af.getAccSnsTmpPath() + str2);
                    this.nPY.l(af.getAccSnsTmpPath() + str2, i, z);
                    ((e) this.nPZ).xH(this.nPY.nQj.size());
                    this.nPZ.setList$22875ea3(this.nPY.nQj);
                    this.bGc.getIntent().putExtra("sns_kemdia_path_list", this.nPY.nQj);
                    try {
                        File file = new File(str);
                        bpo bpo = new bpo();
                        bpo.snJ = z ? 1 : 2;
                        bpo.snL = file.lastModified() / 1000;
                        bpo.snK = Exif.fromFile(str).getUxtimeDatatimeOriginal();
                        this.nQb.put(af.getAccSnsTmpPath() + str2, bpo);
                    } catch (Exception e) {
                        x.e("MicroMsg.PicWidget", "get report info error " + e.getMessage());
                    }
                    com.tencent.mm.compatible.util.Exif.a location = Exif.fromFile(str).getLocation();
                    if (location != null) {
                        this.nQa.put(af.getAccSnsTmpPath() + str2, location);
                    }
                }
            }
        }
        return true;
    }

    public final boolean d(int i, Intent intent) {
        String d;
        String u;
        switch (i) {
            case 2:
                x.d("MicroMsg.PicWidget", "onActivityResult 1");
                if (intent == null) {
                    return false;
                }
                x.d("MicroMsg.PicWidget", "onActivityResult CONTEXT_CHOSE_IMAGE");
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 4);
                intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                intent2.putExtra("CropImage_Filter", true);
                com.tencent.mm.plugin.sns.c.a.ezn.a(this.bGc, intent, intent2, af.getAccSnsTmpPath(), 4, new com.tencent.mm.ui.tools.a.a() {
                    public final String NT(String str) {
                        return af.getAccSnsTmpPath() + g.u((str + System.currentTimeMillis()).getBytes());
                    }
                });
                return true;
            case 3:
                x.d("MicroMsg.PicWidget", "onActivityResult 2");
                d = l.d(this.bGc.getApplicationContext(), intent, af.getAccSnsTmpPath());
                if (d == null) {
                    return true;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CropImageMode", 4);
                intent3.putExtra("CropImage_Filter", true);
                intent3.putExtra("CropImage_DirectlyIntoFilter", true);
                intent3.putExtra("CropImage_ImgPath", d);
                u = g.u((d + System.currentTimeMillis()).getBytes());
                intent3.putExtra("CropImage_OutputPath", af.getAccSnsTmpPath() + u);
                com.tencent.mm.compatible.util.Exif.a location = Exif.fromFile(d).getLocation();
                if (location != null) {
                    this.nQa.put(af.getAccSnsTmpPath() + u, location);
                    x.d("MicroMsg.PicWidget", "take picture lat:%f, long:%f", new Object[]{Double.valueOf(location.latitude), Double.valueOf(location.longitude)});
                }
                bpo bpo = new bpo();
                bpo.snJ = 1;
                bpo.snL = System.currentTimeMillis();
                bpo.snK = bi.WV(Exif.fromFile(d).dateTime);
                this.nQb.put(af.getAccSnsTmpPath() + u, bpo);
                com.tencent.mm.plugin.sns.c.a.ezn.a(this.bGc, intent3, 4);
                this.nOU = true;
                return true;
            case 4:
                x.d("MicroMsg.PicWidget", "onActivityResult 3");
                if (intent == null) {
                    return true;
                }
                d = intent.getStringExtra("CropImage_OutputPath");
                x.d("MicroMsg.PicWidget", "REQUEST_CODE_IMAGE_SEND_COMFIRM filePath " + d);
                if (d == null) {
                    return true;
                }
                if (!FileOp.cn(d)) {
                    return true;
                }
                if (this.nPY.nQj.size() >= 9) {
                    return true;
                }
                int intExtra = intent.getIntExtra("CropImage_filterId", 0);
                u = "pre_temp_sns_pic" + g.u((d + System.currentTimeMillis()).getBytes());
                x.i("MicroMsg.PicWidget", "onactivity result " + FileOp.mI(d) + " " + d);
                FileOp.y(d, af.getAccSnsTmpPath() + u);
                if (this.nQa.containsKey(d)) {
                    this.nQa.put(af.getAccSnsTmpPath() + u, this.nQa.get(d));
                }
                d = af.getAccSnsTmpPath() + u;
                x.d("MicroMsg.PicWidget", "newPath " + d);
                this.nPY.l(d, intExtra, false);
                this.bGc.getIntent().putExtra("sns_kemdia_path_list", this.nPY.nQj);
                ((e) this.nPZ).xH(this.nPY.nQj.size());
                this.nPZ.setList$22875ea3(this.nPY.nQj);
                return true;
            case 7:
                if (intent == null) {
                    return true;
                }
                this.nPY.N(intent.getStringArrayListExtra("sns_gallery_temp_paths"));
                this.bGc.getIntent().putExtra("sns_kemdia_path_list", this.nPY.nQj);
                ((e) this.nPZ).xH(this.nPY.nQj.size());
                this.nPZ.setList$22875ea3(this.nPY.nQj);
                this.nQc = intent.getIntExtra("sns_update_preview_image_count", 0);
                return true;
            case 9:
                return d(intent.getStringArrayListExtra("CropImage_OutputPath_List"), intent.getIntExtra("CropImage_filterId", 0), intent.getBooleanExtra("isTakePhoto", false));
            case 11:
                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                if (sightCaptureResult != null) {
                    d = sightCaptureResult.lek;
                    if (!bi.oW(d)) {
                        return d(Collections.singletonList(d), 0, true);
                    }
                }
                break;
        }
        return false;
    }

    public final boolean bBW() {
        if (this.nPZ != null) {
            this.nPZ.clean();
        }
        return false;
    }
}
