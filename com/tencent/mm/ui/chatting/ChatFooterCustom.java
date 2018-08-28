package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.d.b;
import com.tencent.mm.ac.j;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.dw;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.mb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bv.a;
import com.tencent.mm.model.q;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.pluginsdk.wallet.i;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.b.c;
import com.tencent.mm.ui.x;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class ChatFooterCustom extends LinearLayout implements OnClickListener, a {
    private ab bTk;
    private String gtX;
    private Object hue;
    private LinearLayout irL;
    private d lUs;
    private ChatFooter.d qLx;
    private ImageView tHM;
    public ImageView tHN;
    public h tHO;
    private c.a tHP;
    private int tHQ;
    private bl tHR;
    private a tHS;
    private b tHT;
    private List<String> tHU;
    private final String tHV;
    private final String tHW;
    private j tHX;
    private x tnu;

    public void setOnFooterSwitchListener(ChatFooter.d dVar) {
        this.qLx = dVar;
    }

    public void setOnProcessClickListener(c.a aVar) {
        this.tHP = aVar;
    }

    public ChatFooterCustom(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatFooterCustom(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.irL = null;
        this.tHM = null;
        this.tHN = null;
        this.tHO = null;
        this.qLx = null;
        this.tHP = null;
        this.tHQ = 0;
        this.tHU = new LinkedList();
        this.tHV = "qrcode";
        this.tHW = "barcode";
        this.hue = new Object();
    }

    public final void a(x xVar, d dVar, String str) {
        b.c My = dVar.bG(false).My();
        if (My == null || My.dLC == null || str == null) {
            throw new IllegalArgumentException(" menuInfo or username is null ! ");
        }
        this.tHQ = Math.min(My.dLC.size(), 6);
        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "setMenus, count:" + this.tHQ);
        if (this.tHQ <= 0) {
            throw new IllegalArgumentException(" mTabCount is invalid ! ");
        }
        if (this.tHQ > 3) {
            this.tHM.setVisibility(0);
        } else {
            this.tHM.setVisibility(8);
        }
        this.irL.setWeightSum((float) Math.min(this.tHQ, 3));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 6) {
                break;
            }
            FrameLayout frameLayout = (FrameLayout) this.irL.getChildAt(i2);
            TextView textView = (TextView) frameLayout.getChildAt(0).findViewById(R.h.chatting_footer_menu_text);
            frameLayout.getChildAt(0).findViewById(R.h.chatting_footer_menu_icon).setVisibility(8);
            ImageView imageView = (ImageView) frameLayout.getChildAt(1);
            imageView.setVisibility(8);
            if (i2 < this.tHQ) {
                j jVar = (j) My.dLC.get(i2);
                frameLayout.setTag(jVar);
                textView.setText(com.tencent.mm.pluginsdk.ui.d.j.a(getContext(), jVar.name));
                if (jVar.type == 0) {
                    imageView.setVisibility(0);
                }
                frameLayout.setOnClickListener(this);
                frameLayout.setVisibility(0);
            } else if (i2 < 3 || this.tHQ <= 3) {
                frameLayout.setVisibility(8);
            } else {
                frameLayout.setTag(null);
                textView.setText("");
                imageView.setVisibility(8);
                frameLayout.setOnClickListener(null);
                frameLayout.setVisibility(0);
            }
            i = i2 + 1;
        }
        this.tnu = xVar;
        this.gtX = str;
        this.lUs = dVar;
        if (this.tHS != null) {
            com.tencent.mm.sdk.b.a.sFg.c(this.tHS);
        }
        if (this.tHT != null) {
            com.tencent.mm.sdk.b.a.sFg.c(this.tHT);
        }
        this.tHS = new a(this, (byte) 0);
        this.tHT = new b(this, (byte) 0);
        com.tencent.mm.sdk.b.a.sFg.b(this.tHS);
        com.tencent.mm.sdk.b.a.sFg.b(this.tHT);
    }

    public final void bDr() {
        if (this.tHS != null) {
            com.tencent.mm.sdk.b.a.sFg.c(this.tHS);
        }
        if (this.tHT != null) {
            com.tencent.mm.sdk.b.a.sFg.c(this.tHT);
        }
    }

    private void csW() {
        if (this.tnu != null && this.bTk != null && !ai.oW(this.gtX)) {
            l.b(this.tnu, 9, this.gtX, this.bTk.field_username);
        }
    }

    private void csX() {
        File file = new File(e.dgl);
        if (!file.exists() && !file.mkdir()) {
            Toast.makeText((Activity) getContext(), getContext().getString(R.l.chatting_toast_sdk_fail), 1).show();
        } else if (this.tnu != null && !l.a(this.tnu, e.dgl, "microMsg." + System.currentTimeMillis() + ".jpg")) {
            Toast.makeText((Activity) getContext(), getContext().getString(R.l.selectcameraapp_none), 1).show();
        }
    }

    private String getSender() {
        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "getSender " + (this.tHR == null) + " " + (this.tHR == null ? q.GF() : this.tHR.name));
        return this.tHR == null ? q.GF() : this.tHR.name;
    }

    public final void csY() {
        if (this.tHO != null) {
            this.tHO.ctb();
        }
    }

    public synchronized void onClick(View view) {
        String str = null;
        synchronized (this) {
            Object tag = view.getTag();
            if (tag instanceof j) {
                i.Cx(8);
                j jVar = (j) tag;
                jVar.content = "";
                switch (jVar.type) {
                    case 0:
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "show/dismiss submenu, pos:(%d, %d), view width:%d", new Object[]{Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(view.getWidth())});
                        h hVar = this.tHO;
                        int width = iArr[0] + (view.getWidth() / 2);
                        int i = iArr[1];
                        if (!hVar.isShowing()) {
                            hVar.a(jVar, width, i);
                            break;
                        }
                        hVar.ctb();
                        if (!(jVar == null || (hVar.tIf.id == jVar.id && hVar.tIf.aAL.equals(jVar.aAL)))) {
                            hVar.a(jVar, width, i);
                            break;
                        }
                    case 1:
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "get latest message");
                        cta();
                        this.tHO.ctb();
                        jVar.state = j.dMg;
                        b(jVar);
                        d(jVar);
                        this.tHP.cuF();
                        break;
                    case 2:
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "start webview url");
                        cta();
                        this.tHO.ctb();
                        jVar.state = j.dMg;
                        b(jVar);
                        d(jVar);
                        if (!(p.a.qyl.c(getContext(), jVar.value, new Object[0]) || f.a(jVar.ceR, getContext(), this.tnu, this.gtX))) {
                            Intent intent = new Intent();
                            intent.putExtra("KPublisherId", "custom_menu");
                            intent.putExtra("pre_username", this.gtX);
                            intent.putExtra("prePublishId", "custom_menu");
                            intent.putExtra("preUsername", this.gtX);
                            intent.putExtra("preChatName", this.gtX);
                            intent.putExtra("preChatTYPE", t.N(this.gtX, this.gtX));
                            intent.putExtra("rawUrl", jVar.value);
                            intent.putExtra("geta8key_username", this.gtX);
                            intent.putExtra("from_scence", 1);
                            com.tencent.mm.bg.d.b(getContext(), "webview", ".ui.tools.WebViewUI", intent);
                            break;
                        }
                    case 3:
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "switch to input");
                        this.tHO.ctb();
                        csZ();
                        jVar.state = j.dMg;
                        b(jVar);
                        d(jVar);
                        break;
                    case 4:
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "MM_BIZ_CUSTOM_MENU_TYPE_CUSTOM_CLICK");
                        cta();
                        this.tHO.ctb();
                        jVar.state = j.dMh;
                        String str2 = jVar.id + jVar.aAL;
                        synchronized (this.hue) {
                            this.tHU.add(str2);
                        }
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "addToMenuClickCmdList %s %d", new Object[]{str2, Integer.valueOf(this.tHU.size())});
                        h.mEJ.h(10809, new Object[]{this.gtX, Integer.valueOf(jVar.id), jVar.aAL, j.dMh, ""});
                        this.tHX = jVar;
                        Intent intent2;
                        dw dwVar;
                        switch (jVar.dMk) {
                            case 100:
                                intent2 = new Intent();
                                intent2.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                                intent2.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                                intent2.putExtra("key_is_finish_on_scanned", true);
                                intent2.putExtra("key_is_hide_right_btn", true);
                                if (!com.tencent.mm.p.a.bx(getContext())) {
                                    getContext();
                                    if (!com.tencent.mm.ax.e.Sz()) {
                                        com.tencent.mm.bg.d.b(getContext(), "scanner", ".ui.BaseScanUI", intent2);
                                        break;
                                    }
                                }
                                break;
                            case 101:
                                intent2 = new Intent();
                                intent2.putExtra("BaseScanUI_only_scan_qrcode_with_zbar", true);
                                intent2.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
                                intent2.putExtra("key_is_finish_on_scanned", false);
                                intent2.putExtra("key_is_hide_right_btn", true);
                                if (!com.tencent.mm.p.a.bx(getContext())) {
                                    getContext();
                                    if (!com.tencent.mm.ax.e.Sz()) {
                                        com.tencent.mm.bg.d.b(getContext(), "scanner", ".ui.BaseScanUI", intent2);
                                        break;
                                    }
                                }
                                break;
                            case 102:
                                csX();
                                break;
                            case 103:
                                au.HU();
                                if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                                    s.gH(getContext());
                                    break;
                                }
                                com.tencent.mm.ui.base.h.a(getContext(), null, new String[]{getContext().getString(R.l.chatting_context_menu_take_picture), getContext().getString(R.l.chatting_context_menu_image)}, null, new 1(this));
                                break;
                            case 104:
                                csW();
                                break;
                            case 105:
                                intent2 = new Intent();
                                intent2.putExtra("map_view_type", 0);
                                intent2.putExtra("map_sender_name", getSender());
                                intent2.putExtra("map_talker_name", getTalkerUserName());
                                intent2.putExtra("view_type_key", 1);
                                intent2.putExtra("key_get_location_type", 1);
                                com.tencent.mm.bg.d.b(getContext(), "location", ".ui.RedirectUI", intent2);
                                break;
                            case 106:
                                dwVar = new dw();
                                dwVar.bLH.op = 1;
                                dwVar.bLH.userName = this.bTk.field_username;
                                dwVar.bLH.context = getContext();
                                com.tencent.mm.sdk.b.a.sFg.m(dwVar);
                                break;
                            case 107:
                                dwVar = new dw();
                                dwVar.bLH.op = 2;
                                dwVar.bLH.userName = this.bTk.field_username;
                                dwVar.bLH.context = getContext();
                                com.tencent.mm.sdk.b.a.sFg.m(dwVar);
                                break;
                        }
                        break;
                    case 5:
                        cta();
                        this.tHO.ctb();
                        jVar.state = j.dMg;
                        b(jVar);
                        d(jVar);
                        if (!TextUtils.isEmpty(jVar.value)) {
                            try {
                                JSONObject jSONObject = new JSONObject(jVar.value);
                                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                                appBrandStatObject.scene = 1035;
                                appBrandStatObject.bGG = this.gtX;
                                com.tencent.mm.plugin.appbrand.n.d dVar = (com.tencent.mm.plugin.appbrand.n.d) g.l(com.tencent.mm.plugin.appbrand.n.d.class);
                                Context context = getContext();
                                String optString = jSONObject.optString("userName");
                                String optString2 = jSONObject.optString("pagePath");
                                if (this.lUs != null) {
                                    str = this.lUs.field_appId;
                                }
                                dVar.a(context, optString, null, 0, 0, optString2, appBrandStatObject, str);
                                break;
                            } catch (JSONException e) {
                                break;
                            }
                        }
                        break;
                }
            }
        }
    }

    private boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        String str = jVar.id + jVar.aAL;
        synchronized (this.hue) {
            int i;
            for (int i2 = 0; i2 < this.tHU.size(); i2++) {
                if (((String) this.tHU.get(i2)).equals(str)) {
                    i = i2;
                    break;
                }
            }
            i = -1;
            if (i >= 0) {
                this.tHU.remove(i);
                com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "removeOneFromMenuClickCmdList success %s %d", new Object[]{str, Integer.valueOf(this.tHU.size())});
                return true;
            }
            com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "removeOneFromMenuClickCmdList fail %s %d", new Object[]{str, Integer.valueOf(this.tHU.size())});
            return false;
        }
    }

    private void b(j jVar) {
        h.mEJ.h(10809, new Object[]{this.gtX, Integer.valueOf(jVar.id), jVar.aAL, j.dMg, ""});
    }

    private void c(j jVar) {
        h.mEJ.h(10809, new Object[]{this.gtX, Integer.valueOf(jVar.id), jVar.aAL, j.dMi, jVar.content});
    }

    public String getTalkerUserName() {
        return this.bTk == null ? null : this.bTk.field_username;
    }

    public final boolean k(int i, Object obj) {
        if (obj != null) {
            switch (i) {
                case TbsListener$ErrorCode.EXCEED_UNZIP_RETRY_NUM /*201*/:
                case TbsListener$ErrorCode.APK_VERSION_ERROR /*203*/:
                    i = 1001;
                    break;
                case TbsListener$ErrorCode.INCR_UPDATE_FAIL /*217*/:
                    i = 1002;
                    break;
            }
            String stringExtra;
            ArrayList arrayList;
            switch (i) {
                case 1001:
                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "return from camera");
                    if (!(obj instanceof Intent)) {
                        com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "type error");
                        break;
                    }
                    stringExtra = ((Intent) obj).getStringExtra("CropImage_OutputPath");
                    if (stringExtra != null) {
                        File file = new File(stringExtra);
                        if (!file.exists() || !file.isFile()) {
                            com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", new Object[]{stringExtra});
                            break;
                        }
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "%s retrieved!", new Object[]{stringExtra});
                        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "MD5 is %s", new Object[]{com.tencent.mm.a.g.m(file)});
                        if (this.tHX != null && (this.tHX.dMk == 102 || this.tHX.dMk == 103)) {
                            arrayList = new ArrayList();
                            arrayList.add(stringExtra);
                            this.tHX.state = j.dMi;
                            this.tHX.e(arrayList);
                            if (a(this.tHX)) {
                                d(this.tHX);
                                c(this.tHX);
                                break;
                            }
                        }
                        com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "camera photo cache lost or temp type error! cannot pass info!");
                        break;
                    }
                    com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "return null path");
                    break;
                    break;
                case 1002:
                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "return from albumn");
                    if (!(obj instanceof Intent)) {
                        com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "type error");
                        break;
                    }
                    ArrayList stringArrayListExtra = ((Intent) obj).getStringArrayListExtra("CropImage_OutputPath_List");
                    arrayList = new ArrayList();
                    if (!(stringArrayListExtra == null || stringArrayListExtra.size() == 0)) {
                        Iterator it = stringArrayListExtra.iterator();
                        while (it.hasNext()) {
                            stringExtra = (String) it.next();
                            com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "retrieving bitmap path %s", new Object[]{stringExtra});
                            if (stringExtra != null) {
                                File file2 = new File(stringExtra);
                                if (file2.exists() && file2.isFile()) {
                                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "%s retrieved!", new Object[]{stringExtra});
                                    arrayList.add(com.tencent.mm.a.g.m(file2));
                                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "MD5 is %s", new Object[]{stringExtra});
                                } else {
                                    com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "%s cannot be retrieved as file or is directory!!", new Object[]{stringExtra});
                                }
                            } else {
                                com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "no file contained!");
                            }
                        }
                        if (this.tHX != null && (this.tHX.dMk == 104 || this.tHX.dMk == 103 || this.tHX.dMk == 102)) {
                            this.tHX.state = j.dMi;
                            this.tHX.e(arrayList);
                            if (a(this.tHX)) {
                                d(this.tHX);
                                c(this.tHX);
                                break;
                            }
                        }
                        com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "albumn photo cache lost or temp type error! cannot pass info!");
                        break;
                    }
                    break;
                case 1003:
                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "send qrcode wait msg");
                    if (cq(obj)) {
                        this.tHP.cuF();
                        break;
                    }
                    break;
                case 1004:
                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "send qrcode direct");
                    cq(obj);
                    break;
                case 1005:
                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "send current");
                    cp(obj);
                    break;
                case 1006:
                    com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "send selected");
                    cp(obj);
                    break;
            }
        }
        com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "returned data is null, maybe serve for UI");
        return true;
    }

    private boolean cp(Object obj) {
        if (obj instanceof ma) {
            ma maVar = (ma) obj;
            double d = maVar.bWy.lat;
            double d2 = maVar.bWy.lng;
            int i = maVar.bWy.bSz;
            com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "lat:%f , lng:%f , scale: %d , label:%s , poiname:%s", new Object[]{Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), maVar.bWy.label, maVar.bWy.bWB});
            if (this.tHX == null || this.tHX.dMk != 105) {
                com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "cache lost or location type is not correct");
            } else {
                this.tHX.state = j.dMi;
                j jVar = this.tHX;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("x", String.valueOf(d));
                    jSONObject.put("y", String.valueOf(d2));
                    jSONObject.put("scale", i);
                    jSONObject.put("label", r5);
                    jSONObject.put("poiname", r6);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("location", jSONObject);
                    jVar.content = jSONObject2.toString();
                    com.tencent.mm.sdk.platformtools.x.v("MicroMsg.BizMenuItem", jVar.content);
                } catch (JSONException e) {
                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BizMenuItem", e.toString());
                }
                if (a(this.tHX)) {
                    d(this.tHX);
                    c(this.tHX);
                }
            }
        } else {
            com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "send current location data type error!");
        }
        return true;
    }

    private boolean cq(Object obj) {
        if (obj instanceof mb) {
            mb mbVar = (mb) obj;
            if (this.tHX == null || !(this.tHX.dMk == 100 || this.tHX.dMk == 101)) {
                com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "null pointer in cache or type error");
                return false;
            }
            Object obj2;
            switch (mbVar.bWC.bWE) {
                case 0:
                    obj2 = "qrcode";
                    break;
                case 1:
                    obj2 = "barcode";
                    break;
                default:
                    obj2 = "";
                    break;
            }
            com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "scan type: %s , scan result:%s", new Object[]{obj2, mbVar.bWC.scanResult});
            this.tHX.state = j.dMi;
            j jVar = this.tHX;
            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.BizMenuItem", "type is %s , result is %s", new Object[]{obj2, r3});
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("scan_type", obj2);
                jSONObject.put("scan_result", r3);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("scan_code", jSONObject);
                jVar.content = jSONObject2.toString();
                com.tencent.mm.sdk.platformtools.x.v("MicroMsg.BizMenuItem", "content: %s", new Object[]{jVar.content});
            } catch (JSONException e) {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.BizMenuItem", e.toString());
            }
            if (a(this.tHX)) {
                d(this.tHX);
                c(this.tHX);
            }
            return true;
        }
        com.tencent.mm.sdk.platformtools.x.e("ChatCustomFooter", "send current location data type error!");
        return false;
    }

    private void d(j jVar) {
        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", jVar.getInfo());
        au.DF().a(new com.tencent.mm.ac.q(this.gtX, 1, jVar.getInfo(), null), 0);
    }

    public final void l(ViewGroup viewGroup) {
        this.irL = (LinearLayout) findViewById(R.h.chatting_footer_menu_container);
        this.tHN = (ImageView) findViewById(R.h.chatting_footer_switch2input);
        this.tHN.setVisibility(0);
        this.tHN.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ChatFooterCustom.this.csZ();
            }
        });
        this.tHM = (ImageView) findViewById(R.h.chatting_footer_menu_arrow);
        this.tHM.setOnClickListener(new 3(this));
        this.tHO = new h(getContext(), viewGroup);
        this.tHO.tHZ = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ChatFooterCustom.this.onClick(view);
            }
        };
    }

    public final void a(com.tencent.mm.ab.d.a aVar) {
        String a = com.tencent.mm.platformtools.ab.a(aVar.dIN.rcl);
        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "SysCmdMsgExtension:" + a);
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            XmlPullParser newPullParser = newInstance.newPullParser();
            newPullParser.setInput(new StringReader(a));
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                switch (eventType) {
                    case 0:
                    case 2:
                        a = newPullParser.getName();
                        if (!"sysmsg".equals(a)) {
                            if (!"username".equals(a)) {
                                if (!"data".equals(a)) {
                                    break;
                                }
                                newPullParser.nextText();
                                break;
                            }
                            newPullParser.nextText();
                            break;
                        } else if (!"type".equals(newPullParser.getAttributeName(0))) {
                            break;
                        } else {
                            newPullParser.getAttributeValue(0);
                            break;
                        }
                    default:
                        break;
                }
            }
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("ChatCustomFooter", e, "", new Object[0]);
        }
    }

    private void csZ() {
        com.tencent.mm.sdk.platformtools.x.i("ChatCustomFooter", "switch footer");
        if (this.qLx != null) {
            this.tHO.ctb();
            this.qLx.kS(true);
        }
    }

    public ab getTalker() {
        return this.bTk;
    }

    public void setTalker(ab abVar) {
        this.bTk = abVar;
    }

    private void cta() {
        if (this.bTk != null && this.bTk.csS == 1) {
            au.HU();
            com.tencent.mm.model.c.FW().Yu(this.bTk.field_username);
        }
    }
}
