package com.tencent.mm.plugin.subapp.ui.gallery;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.mm.R;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.model.au;
import com.tencent.mm.model.w;
import com.tencent.mm.model.w$b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@a(3)
public class GestureGalleryUI extends MMActivity implements w$b {
    private String dBl = null;
    private c iYS = new c<mu>() {
        {
            this.sFo = mu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            mu muVar = (mu) bVar;
            if (muVar == null) {
                x.e("MicroMsg.GestureGalleryUI", "RecogQBarOfImageFileResultEvent is null.");
            } else if (muVar == null || muVar.bXK.filePath.equals(GestureGalleryUI.this.nMT)) {
                x.i("MicroMsg.GestureGalleryUI", "recog result: %s", new Object[]{muVar.bXK.result});
                if (GestureGalleryUI.this.osq.isEmpty() || GestureGalleryUI.this.osq.contains(Integer.valueOf(muVar.bXK.bJr))) {
                    GestureGalleryUI.this.osm = muVar.bXK.bJr;
                    GestureGalleryUI.this.nMW = muVar.bXK.result;
                    GestureGalleryUI.this.osn = muVar.bXK.bJs;
                    GestureGalleryUI.this.nMT = null;
                    if (!bi.oW(GestureGalleryUI.this.nMW) && GestureGalleryUI.this.osk.isShowing()) {
                        GestureGalleryUI.a(GestureGalleryUI.this);
                    }
                } else {
                    x.i("MicroMsg.GestureGalleryUI", "Result codeType(%s) error.", new Object[]{Integer.valueOf(muVar.bXK.bJr)});
                }
            } else {
                x.e("MicroMsg.GestureGalleryUI", "not same filepath");
            }
            return false;
        }
    };
    private volatile String nMT;
    private String nMW;
    private c nNd = new 2(this);
    private a osf;
    private MMGestureGallery osg;
    private String osh;
    private w osi;
    private boolean osj = false;
    private d osk;
    private volatile boolean osl;
    private int osm;
    private int osn;
    private int oso;
    private final Set<Integer> osp = new HashSet();
    private final Set<Integer> osq = new HashSet();
    private List<String> osr = new ArrayList();
    private int oss = -1;
    private OnItemSelectedListener ost = new 9(this);
    private int type = 0;

    static /* synthetic */ void a(GestureGalleryUI gestureGalleryUI) {
        if (gestureGalleryUI.osk == null) {
            gestureGalleryUI.osk = new d(gestureGalleryUI.mController.tml, 1, false);
        }
        gestureGalleryUI.osk.ofp = new n.c() {
            public final void a(l lVar) {
                lVar.clear();
                lVar.eR(1, R.l.readerapp_alert_retransmit);
                lVar.eR(2, R.l.save_img_to_local);
                lVar.eR(3, R.l.plugin_favorite_opt);
                if (GestureGalleryUI.c(GestureGalleryUI.this)) {
                    lVar.eR(4, com.tencent.mm.plugin.scanner.a.aB(GestureGalleryUI.this.osm, GestureGalleryUI.this.nMW) ? R.l.recog_wxcode_of_image_file : R.l.recog_qbar_of_image_file);
                }
                if (GestureGalleryUI.this.osl && bi.oW(GestureGalleryUI.this.nMW) && au.DF().Lg() != 0) {
                    ms msVar = new ms();
                    msVar.bXH.filePath = GestureGalleryUI.this.osh;
                    msVar.bXH.bXI = new HashSet(GestureGalleryUI.this.osp);
                    GestureGalleryUI.this.nMT = GestureGalleryUI.this.osh;
                    com.tencent.mm.sdk.b.a.sFg.m(msVar);
                }
            }
        };
        gestureGalleryUI.osk.ofq = new 6(gestureGalleryUI);
        gestureGalleryUI.osk.uJQ = new 7(gestureGalleryUI);
        if (!gestureGalleryUI.mController.tml.isFinishing()) {
            gestureGalleryUI.osk.bXO();
        }
    }

    static /* synthetic */ boolean c(GestureGalleryUI gestureGalleryUI) {
        return gestureGalleryUI.osl && !bi.oW(gestureGalleryUI.nMW);
    }

    public final void c(String str, String str2, int i) {
        if (this.osf != null) {
            if (i == this.osg.getSelectedItemPosition()) {
                this.osh = str2;
                x.d("MicroMsg.GestureGalleryUI", "onDownSucc, curFilename:%s, url:%s", new Object[]{this.osh, str});
            }
            this.osf.notifyDataSetChanged();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        fullScreenNoTitleBar(true);
        this.osj = getIntent().getBooleanExtra("isFromWebView", false);
        this.osl = getIntent().getBooleanExtra("shouldShowScanQrCodeMenu", false);
        this.oso = getIntent().getIntExtra("scanQrCodeGetA8KeyScene", 0);
        int[] intArrayExtra = getIntent().getIntArrayExtra("scanCodeTypes");
        if (intArrayExtra != null && intArrayExtra.length > 0) {
            for (int valueOf : intArrayExtra) {
                this.osp.add(Integer.valueOf(valueOf));
            }
        }
        intArrayExtra = getIntent().getIntArrayExtra("scanResultCodeTypes");
        if (intArrayExtra != null && intArrayExtra.length > 0) {
            for (int valueOf2 : intArrayExtra) {
                this.osq.add(Integer.valueOf(valueOf2));
            }
        }
        this.dBl = getIntent().getStringExtra("cookie");
        x.d("MicroMsg.GestureGalleryUI", "isFromWebView: %b, cookie = %s", new Object[]{Boolean.valueOf(this.osj), this.dBl});
        this.osi = new w(this.osj);
        w wVar = this.osi;
        x.d("MicroMsg.GetPicService", "addListener :" + hashCode());
        wVar.dBf = this;
        com.tencent.mm.sdk.b.a.sFg.b(this.iYS);
        com.tencent.mm.sdk.b.a.sFg.b(this.nNd);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
        w wVar = this.osi;
        x.d("MicroMsg.GetPicService", "removeListener :" + hashCode());
        wVar.dBf = null;
        wVar = this.osi;
        if (wVar.dBc != null) {
            wVar.dBc.dBj = true;
        }
        wVar.dBc = null;
        com.tencent.mm.sdk.b.a.sFg.c(this.iYS);
        com.tencent.mm.sdk.b.a.sFg.c(this.nNd);
    }

    public void onPause() {
        super.onPause();
        m.Bk(2);
    }

    public void onResume() {
        super.onResume();
        m.Bk(1);
    }

    protected void onStop() {
        super.onStop();
        if (this.nMW != null) {
            aj ajVar = new aj();
            ajVar.bHK.activity = this;
            ajVar.bHK.bHL = this.nMW;
            com.tencent.mm.sdk.b.a.sFg.m(ajVar);
            this.nMW = null;
            this.osn = 0;
            this.osm = 0;
        }
    }

    protected final int getLayoutId() {
        return R.i.readerapp_imageview;
    }

    protected final void initView() {
        int i;
        String oV = bi.oV(getIntent().getStringExtra("nowUrl"));
        this.type = getIntent().getIntExtra("type", 0);
        String[] stringArrayExtra = getIntent().getStringArrayExtra("urlList");
        if (stringArrayExtra == null || stringArrayExtra.length == 0) {
            String oV2 = bi.oV(getIntent().getStringExtra("htmlData"));
            i = 0;
            while (i >= 0) {
                int indexOf = oV2.indexOf("weixin://viewimage/", i);
                if (indexOf < 0) {
                    break;
                }
                i = oV2.indexOf("\"", indexOf);
                if (i < 0) {
                    break;
                }
                String substring = oV2.substring(indexOf + 19, i);
                x.d("MicroMsg.GestureGalleryUI", "start:" + indexOf + " end:" + i + " url:" + substring);
                this.osr.add(substring);
            }
        } else {
            this.osr = Arrays.asList(stringArrayExtra);
        }
        for (i = 0; i < this.osr.size(); i++) {
            if (oV.equals(this.osr.get(i))) {
                this.oss = i;
                break;
            }
        }
        setBackBtn(new 1(this));
        this.osf = new a(this);
        this.osg = (MMGestureGallery) findViewById(R.h.gallery);
        this.osg.setVisibility(0);
        this.osg.setVerticalFadingEdgeEnabled(false);
        this.osg.setHorizontalFadingEdgeEnabled(false);
        this.osg.setAdapter(this.osf);
        this.osg.setSelection(this.oss);
        this.osg.setOnItemSelectedListener(this.ost);
        this.osg.setSingleClickOverListener(new f() {
            public final void ayI() {
                GestureGalleryUI.this.finish();
            }
        });
        this.osg.setLongClickOverListener(new 4(this, getIntent().getIntExtra("nevNext", 1)));
    }
}
