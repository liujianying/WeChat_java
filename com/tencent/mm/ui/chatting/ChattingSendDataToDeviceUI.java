package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.ed;
import com.tencent.mm.g.a.ep;
import com.tencent.mm.model.au;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.HorizontalListView;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public class ChattingSendDataToDeviceUI extends MMActivity {
    boolean bLV = false;
    private com.tencent.mm.y.g.a bXA;
    private long cYP;
    String filePath = null;
    String fjS = null;
    private String iux;
    private bd oup;
    private HorizontalListView qNg;
    boolean tGV = false;
    private boolean tGg;
    HashMap<String, c> tLA = new HashMap();
    Map<Integer, View> tLB = new HashMap();
    Map<String, Integer> tLC = new HashMap();
    WXMediaMessage tLD = null;
    private c tLE = new 10(this);
    private c tLF = new 2(this);
    private HorizontalListView tLh;
    private b tLi;
    private a tLj;
    private int tLk;
    private String tLl = "";
    private RelativeLayout tLm;
    private RelativeLayout tLn;
    private TextView tLo;
    private Boolean tLp = Boolean.valueOf(false);
    private b tLq;
    private List<c> tLr = new ArrayList();
    private List<f> tLs = new ArrayList();
    private long tLt = 0;
    private boolean tLu = true;
    boolean tLv = false;
    boolean tLw = true;
    int tLx = 2;
    int tLy = -1;
    private HashMap<String, View> tLz = new HashMap();

    /* renamed from: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$7 */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ aq tLI;
        final /* synthetic */ c tLJ;

        AnonymousClass7(aq aqVar, c cVar) {
            this.tLI = aqVar;
            this.tLJ = cVar;
        }

        public final void run() {
            this.tLI.tNv.setVisibility(0);
            this.tLI.tLN.setTextColor(ChattingSendDataToDeviceUI.this.getResources().getColor(R.e.send_data_sending));
            this.tLI.tLN.setText(ChattingSendDataToDeviceUI.this.getText(R.l.chatting_sending));
            this.tLJ.bLZ = "send_data_sending";
        }
    }

    private class a extends BaseAdapter {
        private Context context;
        private com.tencent.mm.ak.a.a.c iAs;
        private List<Map<String, c>> tGU = new ArrayList();
        private Map<String, c> tLO;

        public a(Context context) {
            this.context = context;
            com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
            aVar.dXN = R.g.my_device_default_icon;
            this.iAs = aVar.Pt();
        }

        public final void aQ(List<c> list) {
            this.tGU.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.tLO = new HashMap();
                this.tLO.put("hard_device_info", list.get(i));
                this.tGU.add(this.tLO);
            }
        }

        public final int getCount() {
            return this.tGU.size();
        }

        /* renamed from: EU */
        public final c getItem(int i) {
            return (c) ((Map) this.tGU.get(i)).get("hard_device_info");
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            aq aqVar;
            View view2;
            c EU = getItem(i);
            x.d("MicroMsg.ChattingSendDataToDeviceUI", "position = %d, getCount() = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(getCount())});
            if (ChattingSendDataToDeviceUI.this.tLB.get(Integer.valueOf(i)) == null) {
                aqVar = new aq();
                View inflate = View.inflate(viewGroup.getContext(), R.i.send_data_to_device_item, null);
                aqVar.iDt = inflate.findViewById(R.h.container);
                aqVar.eMe = (TextView) inflate.findViewById(R.h.nameTV);
                aqVar.gmn = (ImageView) inflate.findViewById(R.h.iconIV);
                aqVar.tLN = (TextView) inflate.findViewById(R.h.sendStateTV);
                aqVar.tNv = (SendDataToDeviceProgressBar) inflate.findViewById(R.h.sendProgress);
                aqVar.tNv.setVisibility(4);
                ChattingSendDataToDeviceUI.this.tLB.put(Integer.valueOf(i), inflate);
                inflate.setTag(aqVar);
                view2 = inflate;
            } else {
                View view3 = (View) ChattingSendDataToDeviceUI.this.tLB.get(Integer.valueOf(i));
                aqVar = (aq) view3.getTag();
                view2 = view3;
            }
            ChattingSendDataToDeviceUI.this.tLC.put(EU.deviceID, Integer.valueOf(i));
            Object obj = EU.daA;
            int i2 = 8;
            int i3 = 0;
            StringBuffer stringBuffer = new StringBuffer();
            CharSequence stringBuffer2 = new StringBuffer();
            float fe = com.tencent.mm.bp.a.fe(this.context);
            if (fe == 1.125f || fe == 1.25f) {
                i2 = 6;
            } else if (fe == 1.375f || fe == 1.625f) {
                i2 = 5;
            }
            for (int i4 = 0; i4 < obj.length(); i4++) {
                int codePointAt = Character.codePointAt(obj, i4);
                String substring = obj.substring(i4, i4 + 1);
                if (codePointAt < 0 || codePointAt > WebView.NORMAL_MODE_ALPHA) {
                    i3 += 2;
                } else {
                    i3++;
                }
                if (i3 <= i2) {
                    stringBuffer = stringBuffer.append(substring);
                } else {
                    stringBuffer2 = stringBuffer2.append(substring);
                }
            }
            aqVar.eMe.setText(stringBuffer.toString());
            if (i3 >= i2) {
                aqVar.tLN.setText(stringBuffer2);
            }
            c cVar = null;
            if (ChattingSendDataToDeviceUI.this.tLA.containsKey(getItem(i).deviceID)) {
                cVar = (c) ChattingSendDataToDeviceUI.this.tLA.get(getItem(i).deviceID);
            }
            if (!(cVar == null || cVar.bLZ == null)) {
                x.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), sendState(%s).", new Object[]{Integer.valueOf(i), cVar.bLZ});
                if (cVar.bLZ.equals("send_data_sending")) {
                    aqVar.tLN.setText(this.context.getString(R.l.chatting_sending));
                    aqVar.tLN.setTextColor(this.context.getResources().getColor(R.e.send_data_sending));
                    aqVar.tNv.setProgress(EU.progress);
                    aqVar.tNv.setVisibility(0);
                    c cVar2 = (c) ChattingSendDataToDeviceUI.this.tLA.get(EU.deviceID);
                    int i5 = cVar2.progress;
                    if (i5 >= 100) {
                        i3 = 0;
                    } else {
                        i3 = 500 / (100 - i5);
                    }
                    e.b(new 1(this, i5, cVar2, aqVar, i3), "SendDataState_handler").start();
                } else if (cVar.bLZ.equals("send_data_sucess")) {
                    aqVar.tLN.setText(this.context.getString(R.l.chatting_send_success));
                    aqVar.tLN.setTextColor(this.context.getResources().getColor(R.e.send_data_sending));
                    aqVar.tNv.setVisibility(4);
                } else if (cVar.bLZ.equals("send_data_cancel")) {
                    aqVar.tLN.setText(this.context.getString(R.l.chatting_send_cancel));
                    aqVar.tLN.setTextColor(this.context.getResources().getColor(R.e.send_data_cancel));
                    aqVar.tNv.setVisibility(4);
                } else if (cVar.bLZ.equals("send_data_failed")) {
                    aqVar.tLN.setText(this.context.getString(R.l.chatting_send_failed));
                    aqVar.tLN.setTextColor(this.context.getResources().getColor(R.e.send_state_text_failed));
                    aqVar.tNv.setVisibility(4);
                }
            }
            x.d("MicroMsg.ChattingSendDataToDeviceUI", "position(%s), name(%s).", new Object[]{Integer.valueOf(i), EU.daA});
            o.Pj().a(EU.iconUrl, aqVar.gmn, this.iAs);
            aqVar.iDt.setTag(Integer.valueOf(i));
            return view2;
        }
    }

    static /* synthetic */ void a(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI, String str, String str2, int i) {
        x.d("MicroMsg.ChattingSendDataToDeviceUI", "ap: send Data State:%s progress: %d", new Object[]{str, Integer.valueOf(i)});
        chattingSendDataToDeviceUI.runOnUiThread(new 9(chattingSendDataToDeviceUI, str2, str, i));
    }

    static /* synthetic */ void a(boolean z, int i, View view) {
        try {
            aq aqVar = (aq) view.getTag();
            if (aqVar != null) {
                if (z) {
                    aqVar.tNv.setVisibility(0);
                    if (i > aqVar.tNv.getProgress()) {
                        aqVar.tNv.setProgress(i);
                        return;
                    }
                    return;
                }
                aqVar.tNv.setVisibility(4);
                aqVar.tNv.setProgress(0);
            }
        } catch (Exception e) {
            x.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: set progress exception %s", new Object[]{e});
        }
    }

    static /* synthetic */ void aaj(String str) {
        ed edVar = new ed();
        edVar.bLX.bLZ = str;
        com.tencent.mm.sdk.b.a.sFg.m(edVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r11) {
        /*
        r10 = this;
        r5 = 2;
        r3 = 6;
        r1 = 3;
        r2 = 1;
        r4 = 0;
        super.onCreate(r11);
        r0 = r10.getIntent();
        r0 = r0.getExtras();
        r6 = "sns_send_data_ui_activity";
        r0 = r0.getBoolean(r6, r4);
        r10.bLV = r0;
        r0 = "MicroMsg.ChattingSendDataToDeviceUI";
        r6 = new java.lang.StringBuilder;
        r7 = "isSnsMsg:";
        r6.<init>(r7);
        r7 = r10.bLV;
        r6 = r6.append(r7);
        r6 = r6.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r6);
        r0 = r10.bLV;
        if (r0 != 0) goto L_0x006b;
    L_0x0035:
        r0 = r10.getIntent();
        r0 = r0.getExtras();
        r6 = "Retr_Msg_Id";
        r6 = r0.getLong(r6);
        r10.cYP = r6;
        r6 = r10.cYP;
        r8 = -1;
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 == 0) goto L_0x006b;
    L_0x004e:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FT();
        r6 = r10.cYP;
        r0 = r0.dW(r6);
        r10.oup = r0;
        r0 = r10.oup;
        if (r0 == 0) goto L_0x006b;
    L_0x0061:
        r0 = r10.oup;
        r6 = r0.field_msgId;
        r8 = 0;
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 != 0) goto L_0x0175;
    L_0x006b:
        r0 = r10.getIntent();
        r0 = r0.getExtras();
        r6 = "exdevice_open_scene_type";
        r0 = r0.getInt(r6, r5);
        r10.tLx = r0;
        r10.tLv = r4;
        r10.setFinishOnTouchOutside(r2);
        r0 = r10.tLr;
        r0.clear();
        r0 = r10.tLA;
        r0.clear();
        r0 = com.tencent.mm.R.h.newtork_device;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.RelativeLayout) r0;
        r10.tLm = r0;
        r0 = new com.tencent.mm.g.a.dj;
        r0.<init>();
        r6 = r10.bLV;
        if (r6 == 0) goto L_0x02ac;
    L_0x009e:
        r6 = r10.getIntent();
        r6 = r6.getExtras();
        r7 = "sns_local_id";
        r6 = r6.getString(r7);
        r10.iux = r6;
        r6 = r10.iux;
        if (r6 == 0) goto L_0x00c8;
    L_0x00b3:
        r6 = r0.bLf;
        r7 = r10.iux;
        r6.bKW = r7;
        r6 = "MicroMsg.ChattingSendDataToDeviceUI";
        r7 = "mSnsLocalId: %s";
        r8 = new java.lang.Object[r2];
        r9 = r10.iux;
        r8[r4] = r9;
        com.tencent.mm.sdk.platformtools.x.i(r6, r7, r8);
    L_0x00c8:
        r6 = com.tencent.mm.sdk.b.a.sFg;
        r6.m(r0);
        r0 = r0.bLg;
        r0 = r0.bKE;
        if (r0 == 0) goto L_0x0339;
    L_0x00d3:
        r0 = java.lang.Boolean.valueOf(r2);
        r10.tLp = r0;
        r0 = com.tencent.mm.sdk.b.a.sFg;
        r6 = r10.tLE;
        r0.b(r6);
        r0 = com.tencent.mm.sdk.b.a.sFg;
        r6 = r10.tLF;
        r0.b(r6);
        r0 = r10.tLm;
        r0.setVisibility(r4);
        r0 = com.tencent.mm.R.h.listview;
        r0 = r10.findViewById(r0);
        r0 = (com.tencent.mm.ui.base.HorizontalListView) r0;
        r10.qNg = r0;
        r0 = com.tencent.mm.R.h.available_device;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.tLo = r0;
        r0 = r10.tLo;
        r6 = com.tencent.mm.R.l.chatting_searching_available_device;
        r0.setText(r6);
        r0 = new com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$a;
        r0.<init>(r10);
        r10.tLj = r0;
        r0 = r10.qNg;
        r6 = r10.tLj;
        r0.setAdapter(r6);
        r0 = r10.qNg;
        r6 = new com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$1;
        r6.<init>(r10);
        r0.setOnItemClickListener(r6);
        r10.ctW();
        r0 = r10.bLV;
        if (r0 == 0) goto L_0x02c9;
    L_0x0126:
        r0 = r10.iux;
        if (r0 == 0) goto L_0x02c6;
    L_0x012a:
        r5 = new com.tencent.mm.g.a.hu;
        r5.<init>();
        r6 = r5.bRf;
        r6.bKW = r0;
        r0 = com.tencent.mm.sdk.b.a.sFg;
        r0.m(r5);
        r0 = r5.bRg;
        r0 = r0.bRh;
        r0 = r0.sqc;
        r0 = r0.ruz;
        if (r0 != r2) goto L_0x02b4;
    L_0x0142:
        r0 = r1;
    L_0x0143:
        r10.tLy = r0;
    L_0x0145:
        r10.pf(r2);
    L_0x0148:
        r0 = com.tencent.mm.R.h.application;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.RelativeLayout) r0;
        r10.tLn = r0;
        r0 = com.tencent.mm.R.h.app_listview;
        r0 = r10.findViewById(r0);
        r0 = (com.tencent.mm.ui.base.HorizontalListView) r0;
        r10.tLh = r0;
        r0 = new com.tencent.mm.ui.chatting.b;
        r0.<init>(r10);
        r10.tLi = r0;
        r0 = r10.tLh;
        r1 = new com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$3;
        r1.<init>(r10);
        r0.setOnItemClickListener(r1);
        r0 = r10.tLh;
        r1 = r10.tLi;
        r0.setAdapter(r1);
        return;
    L_0x0175:
        r0 = r10.oup;
        r0 = r0.getType();
        r10.tLk = r0;
        r0 = r10.oup;
        r0 = r0.field_talker;
        r0 = com.tencent.mm.model.s.fq(r0);
        r10.tGg = r0;
        r0 = r10.oup;
        r0 = r0.field_content;
        r10.tLl = r0;
        r0 = r10.tGg;
        if (r0 == 0) goto L_0x01ad;
    L_0x0191:
        r0 = r10.oup;
        r0 = r0.field_isSend;
        if (r0 != 0) goto L_0x01ad;
    L_0x0197:
        r0 = r10.oup;
        r0 = r0.field_content;
        r6 = r10.oup;
        r6 = r6.field_isSend;
        r7 = r10.tGg;
        if (r7 == 0) goto L_0x01ab;
    L_0x01a3:
        if (r0 == 0) goto L_0x01ab;
    L_0x01a5:
        if (r6 != 0) goto L_0x01ab;
    L_0x01a7:
        r0 = com.tencent.mm.model.bd.iC(r0);
    L_0x01ab:
        r10.tLl = r0;
    L_0x01ad:
        r0 = r10.oup;
        r0 = r0.getType();
        r6 = 49;
        if (r0 != r6) goto L_0x024d;
    L_0x01b7:
        r0 = r10.tLl;
        r0 = com.tencent.mm.y.g.a.gp(r0);
        r10.bXA = r0;
        r0 = r10.bXA;
        if (r0 != 0) goto L_0x01ce;
    L_0x01c3:
        r0 = "MicroMsg.ChattingSendDataToDeviceUI";
        r6 = "initParams content is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r6);
        goto L_0x006b;
    L_0x01ce:
        r0 = r10.bXA;
        r0 = r0.type;
        if (r0 != r1) goto L_0x01ed;
    L_0x01d4:
        r6 = 16;
        r10.tLt = r6;
    L_0x01d8:
        r0 = "MicroMsg.ChattingSendDataToDeviceUI";
        r6 = "contentFlag: %s";
        r7 = new java.lang.Object[r2];
        r8 = r10.tLt;
        r8 = java.lang.Long.valueOf(r8);
        r7[r4] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r0, r6, r7);
        goto L_0x006b;
    L_0x01ed:
        r0 = r10.bXA;
        r0 = r0.type;
        r6 = 4;
        if (r0 != r6) goto L_0x01f9;
    L_0x01f4:
        r6 = 8;
        r10.tLt = r6;
        goto L_0x01d8;
    L_0x01f9:
        r0 = r10.bXA;
        r0 = r0.type;
        r6 = 5;
        if (r0 != r6) goto L_0x0205;
    L_0x0200:
        r6 = 32;
        r10.tLt = r6;
        goto L_0x01d8;
    L_0x0205:
        r0 = r10.bXA;
        r0 = r0.type;
        if (r0 != r3) goto L_0x0227;
    L_0x020b:
        r0 = r10.bXA;
        r0 = r0.dwp;
        r0 = com.tencent.mm.pluginsdk.b.a.Sy(r0);
        if (r0 != 0) goto L_0x0220;
    L_0x0215:
        r0 = "MicroMsg.ChattingSendDataToDeviceUI";
        r6 = "initParams TYPE_FILE getContentTypeFlag null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r6);
        goto L_0x006b;
    L_0x0220:
        r6 = r0.longValue();
        r10.tLt = r6;
        goto L_0x01d8;
    L_0x0227:
        r0 = r10.bXA;
        r0 = r0.type;
        if (r0 != r5) goto L_0x0242;
    L_0x022d:
        r6 = 2;
        r10.tLt = r6;
        r0 = com.tencent.mm.ak.o.Pf();
        r6 = r10.oup;
        r0 = r0.q(r6);
        if (r0 == 0) goto L_0x01d8;
    L_0x023d:
        r0 = r0.dTV;
        r10.tLl = r0;
        goto L_0x01d8;
    L_0x0242:
        r0 = "MicroMsg.ChattingSendDataToDeviceUI";
        r6 = "initParams APPMSG not support type";
        com.tencent.mm.sdk.platformtools.x.e(r0, r6);
        goto L_0x006b;
    L_0x024d:
        r0 = r10.oup;
        r0 = r0.getType();
        if (r0 != r1) goto L_0x0285;
    L_0x0255:
        r0 = com.tencent.mm.ak.o.Pf();
        r6 = r10.oup;
        r0 = r0.q(r6);
        if (r0 == 0) goto L_0x0265;
    L_0x0261:
        r0 = r0.dTV;
        r10.tLl = r0;
    L_0x0265:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r6 = r10.tLk;
        r0 = r0.append(r6);
        r0 = r0.toString();
        r0 = com.tencent.mm.pluginsdk.b.a.Sy(r0);
        if (r0 != 0) goto L_0x02a4;
    L_0x027a:
        r0 = "MicroMsg.ChattingSendDataToDeviceUI";
        r6 = "initParams not appmsg getContentTypeFlag null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r6);
        goto L_0x006b;
    L_0x0285:
        r0 = r10.oup;
        r0 = r0.getType();
        r6 = 43;
        if (r0 != r6) goto L_0x0265;
    L_0x028f:
        r0 = com.tencent.mm.modelvideo.o.Ta();
        r6 = r10.oup;
        r6 = r6.field_imgPath;
        r0 = r0.nI(r6);
        if (r0 == 0) goto L_0x0265;
    L_0x029d:
        r0 = r0.Tm();
        r10.tLl = r0;
        goto L_0x0265;
    L_0x02a4:
        r6 = r0.longValue();
        r10.tLt = r6;
        goto L_0x01d8;
    L_0x02ac:
        r6 = r0.bLf;
        r8 = r10.cYP;
        r6.bJC = r8;
        goto L_0x00c8;
    L_0x02b4:
        r5 = 4;
        if (r0 != r5) goto L_0x02ba;
    L_0x02b7:
        r0 = r2;
        goto L_0x0143;
    L_0x02ba:
        r5 = 15;
        if (r0 != r5) goto L_0x02c1;
    L_0x02be:
        r0 = r3;
        goto L_0x0143;
    L_0x02c1:
        if (r0 != r1) goto L_0x02c6;
    L_0x02c3:
        r0 = 5;
        goto L_0x0143;
    L_0x02c6:
        r0 = r4;
        goto L_0x0143;
    L_0x02c9:
        r6 = r10.cYP;
        r8 = -1;
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 == 0) goto L_0x02d7;
    L_0x02d1:
        r8 = -9223372036854775808;
        r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r0 != 0) goto L_0x02dc;
    L_0x02d7:
        r3 = r4;
    L_0x02d8:
        r10.tLy = r3;
        goto L_0x0145;
    L_0x02dc:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FT();
        r0 = r0.dW(r6);
        r6 = r0.field_msgId;
        r8 = 0;
        r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r6 == 0) goto L_0x030a;
    L_0x02ef:
        r6 = r0.getType();
        r7 = r0.field_content;
        r0 = r0.aQm();
        if (r0 == 0) goto L_0x032a;
    L_0x02fb:
        r0 = com.tencent.mm.y.g.a.gp(r7);
        if (r0 != 0) goto L_0x030c;
    L_0x0301:
        r0 = "MicroMsg.ChattingSendDataToDeviceUI";
        r1 = "get content is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x030a:
        r3 = r4;
        goto L_0x02d8;
    L_0x030c:
        r6 = r0.type;
        if (r6 != r1) goto L_0x0312;
    L_0x0310:
        r3 = r2;
        goto L_0x02d8;
    L_0x0312:
        r6 = r0.type;
        r7 = 4;
        if (r6 == r7) goto L_0x02d8;
    L_0x0317:
        r6 = r0.type;
        if (r6 != r3) goto L_0x031d;
    L_0x031b:
        r3 = 4;
        goto L_0x02d8;
    L_0x031d:
        r3 = r0.type;
        if (r3 != r5) goto L_0x0323;
    L_0x0321:
        r3 = r1;
        goto L_0x02d8;
    L_0x0323:
        r0 = r0.type;
        r1 = 5;
        if (r0 != r1) goto L_0x030a;
    L_0x0328:
        r3 = 5;
        goto L_0x02d8;
    L_0x032a:
        if (r6 != r1) goto L_0x032e;
    L_0x032c:
        r3 = r1;
        goto L_0x02d8;
    L_0x032e:
        r0 = 48;
        if (r6 != r0) goto L_0x0334;
    L_0x0332:
        r3 = r5;
        goto L_0x02d8;
    L_0x0334:
        r0 = 62;
        if (r6 != r0) goto L_0x030a;
    L_0x0338:
        goto L_0x02d8;
    L_0x0339:
        r0 = r10.tLm;
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x0148;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.onCreate(android.os.Bundle):void");
    }

    private void pf(int i) {
        if (this.bLV) {
            h.mEJ.h(13197, new Object[]{Integer.valueOf(i), Integer.valueOf(this.tLy), "", Integer.valueOf(2), Integer.valueOf(this.tLx)});
            return;
        }
        h hVar = h.mEJ;
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(this.tLy);
        long j = this.cYP;
        String str = "";
        au.HU();
        bd dW = com.tencent.mm.model.c.FT().dW(j);
        if (dW.field_msgId == 0) {
            str = "";
        } else {
            String str2 = dW.field_content;
            if (dW.getType() == 49) {
                com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(str2);
                if (gp != null && gp.type == 6) {
                    str = gp.dwp;
                }
            }
        }
        objArr[2] = str;
        objArr[3] = Integer.valueOf(1);
        objArr[4] = Integer.valueOf(this.tLx);
        hVar.h(13197, objArr);
    }

    protected final int getLayoutId() {
        return R.i.chatting_send_data_to_device_ui;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        dh dhVar = new dh();
        if (this.bLV) {
            String string = getIntent().getExtras().getString("sns_send_data_ui_image_path");
            int i = getIntent().getExtras().getInt("sns_send_data_ui_image_position");
            dhVar.bKU.bKW = this.iux;
            dhVar.bKU.bKX = string;
            dhVar.bKU.bKY = i;
        } else {
            dhVar.bKU.bJC = this.cYP;
        }
        com.tencent.mm.sdk.b.a.sFg.m(dhVar);
        if (dhVar.bKV.bKE && this.tLr.size() > 0) {
            x.d("MicroMsg.ChattingSendDataToDeviceUI", "online device size %d", new Object[]{Integer.valueOf(this.tLr.size())});
            this.tLj.aQ(this.tLr);
            if (this.tLj.getCount() > 0) {
                this.tLo.setText(R.l.chatting_available_device);
                this.tLu = false;
            }
            this.tLj.notifyDataSetChanged();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void ctV() {
        /*
        r10 = this;
        r9 = 8;
        r8 = 2;
        r1 = 1;
        r2 = 0;
        r0 = r10.tLi;
        if (r0 == 0) goto L_0x0011;
    L_0x0009:
        r4 = r10.tLt;
        r6 = 0;
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 != 0) goto L_0x003b;
    L_0x0011:
        r3 = "MicroMsg.ChattingSendDataToDeviceUI";
        r4 = "mAppInfoAdapter is null %s, contentFlag %s";
        r5 = new java.lang.Object[r8];
        r0 = r10.tLi;
        if (r0 != 0) goto L_0x0039;
    L_0x001d:
        r0 = r1;
    L_0x001e:
        r0 = java.lang.Boolean.valueOf(r0);
        r5[r2] = r0;
        r6 = r10.tLt;
        r0 = java.lang.Long.valueOf(r6);
        r5[r1] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);
        r0 = r10.tLn;
        if (r0 == 0) goto L_0x0038;
    L_0x0033:
        r0 = r10.tLn;
        r0.setVisibility(r9);
    L_0x0038:
        return;
    L_0x0039:
        r0 = r2;
        goto L_0x001e;
    L_0x003b:
        r4 = r10.tLt;
        r0 = com.tencent.mm.pluginsdk.model.app.g.b(r10, r4, r2);
        r10.tLs = r0;
        r4 = r10.tLt;
        r0 = com.tencent.mm.pluginsdk.model.app.g.m(r10, r4);
        if (r0 != 0) goto L_0x0054;
    L_0x004b:
        r0 = r10.tLn;
        if (r0 == 0) goto L_0x0054;
    L_0x004f:
        r0 = r10.tLn;
        r0.setVisibility(r9);
    L_0x0054:
        r3 = new java.util.ArrayList;
        r3.<init>();
        r0 = r10.tLs;
        if (r0 == 0) goto L_0x00a8;
    L_0x005d:
        r0 = r10.tLs;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x00a8;
    L_0x0065:
        r0 = com.tencent.mm.pluginsdk.model.app.ao.cbZ();
        r4 = r10.tLt;
        r0 = r0.fL(r4);
        if (r0 == 0) goto L_0x0081;
    L_0x0071:
        r4 = r0.size();
        if (r4 <= 0) goto L_0x0081;
    L_0x0077:
        r4 = r10.tLs;
        r5 = new com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$4;
        r5.<init>(r10, r0);
        java.util.Collections.sort(r4, r5);
    L_0x0081:
        r0 = r10.tLs;
        r4 = r0.iterator();
    L_0x0087:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x00a8;
    L_0x008d:
        r0 = r4.next();
        r0 = (com.tencent.mm.pluginsdk.model.app.f) r0;
        r5 = new com.tencent.mm.ui.chatting.ab;
        r5.<init>();
        r6 = r0.field_appId;
        r5.appId = r6;
        r6 = r0.field_appName;
        r5.daA = r6;
        r0 = r0.field_appIconUrl;
        r5.iconUrl = r0;
        r3.add(r5);
        goto L_0x0087;
    L_0x00a8:
        r0 = r10.tLD;
        if (r0 != 0) goto L_0x00d4;
    L_0x00ac:
        r0 = 0;
        r4 = r10.oup;
        r4 = r4.getType();
        switch(r4) {
            case 1: goto L_0x01e1;
            case 3: goto L_0x01ec;
            case 43: goto L_0x0273;
            case 48: goto L_0x0259;
            case 49: goto L_0x00e6;
            default: goto L_0x00b6;
        };
    L_0x00b6:
        r2 = new com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
        r2.<init>(r0);
        r10.tLD = r2;
        r2 = r10.tLD;
        r4 = 620823808; // 0x25010500 float:1.119066E-16 double:3.067277157E-315;
        r2.sdkVer = r4;
        r2 = r10.fjS;
        if (r2 == 0) goto L_0x00d4;
    L_0x00c8:
        r2 = r10.filePath;
        if (r2 == 0) goto L_0x00d4;
    L_0x00cc:
        if (r0 == 0) goto L_0x00d4;
    L_0x00ce:
        r0 = r0 instanceof com.tencent.mm.opensdk.modelmsg.WXFileObject;
        if (r0 == 0) goto L_0x00d4;
    L_0x00d2:
        r10.tGV = r1;
    L_0x00d4:
        r0 = r10.tLi;
        r1 = r10.tGV;
        r0.tGV = r1;
        r0 = r10.tLi;
        r0.aQ(r3);
        r0 = r10.tLi;
        r0.notifyDataSetChanged();
        goto L_0x0038;
    L_0x00e6:
        r4 = r10.bXA;
        if (r4 == 0) goto L_0x00b6;
    L_0x00ea:
        r4 = r10.bXA;
        r4 = r4.type;
        r5 = 3;
        if (r4 != r5) goto L_0x010f;
    L_0x00f1:
        r0 = new com.tencent.mm.opensdk.modelmsg.WXMusicObject;
        r0.<init>();
        r2 = r10.bXA;
        r2 = r2.url;
        r0.musicUrl = r2;
        r2 = r10.bXA;
        r2 = r2.dwN;
        r0.musicDataUrl = r2;
        r2 = r10.bXA;
        r2 = r2.dwn;
        r0.musicLowBandUrl = r2;
        r2 = r10.bXA;
        r2 = r2.dwO;
        r0.musicLowBandDataUrl = r2;
        goto L_0x00b6;
    L_0x010f:
        r4 = r10.bXA;
        r4 = r4.type;
        r5 = 4;
        if (r4 != r5) goto L_0x0128;
    L_0x0116:
        r0 = new com.tencent.mm.opensdk.modelmsg.WXVideoObject;
        r0.<init>();
        r2 = r10.bXA;
        r2 = r2.url;
        r0.videoUrl = r2;
        r2 = r10.bXA;
        r2 = r2.dwO;
        r0.videoLowBandUrl = r2;
        goto L_0x00b6;
    L_0x0128:
        r4 = r10.bXA;
        r4 = r4.type;
        r5 = 5;
        if (r4 != r5) goto L_0x013a;
    L_0x012f:
        r0 = new com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
        r2 = r10.bXA;
        r2 = r2.url;
        r0.<init>(r2);
        goto L_0x00b6;
    L_0x013a:
        r4 = r10.bXA;
        r4 = r4.type;
        r5 = 6;
        if (r4 != r5) goto L_0x018f;
    L_0x0141:
        r4 = com.tencent.mm.pluginsdk.model.app.ao.asF();
        r5 = r10.bXA;
        r5 = r5.bGP;
        r4 = r4.SR(r5);
        if (r4 == 0) goto L_0x0185;
    L_0x014f:
        r0 = "MicroMsg.ChattingSendDataToDeviceUI";
        r5 = "getWXMediaMessage fileFullPath %s";
        r6 = new java.lang.Object[r1];
        r7 = r4.field_fileFullPath;
        r6[r2] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r0, r5, r6);
        r0 = new com.tencent.mm.opensdk.modelmsg.WXFileObject;
        r2 = r4.field_fileFullPath;
        r0.<init>(r2);
        r2 = r4.field_fileFullPath;
        r10.filePath = r2;
        r2 = r10.bXA;
        r2 = r2.dwp;
        r10.fjS = r2;
    L_0x016f:
        r2 = r10.filePath;
        r2 = com.tencent.mm.pluginsdk.model.app.q.Td(r2);
        if (r2 == 0) goto L_0x00b6;
    L_0x0177:
        r0 = com.tencent.mm.R.l.chatting_send_apk_file;
        r0 = r10.getString(r0);
        com.tencent.mm.ui.base.h.bA(r10, r0);
        r10.finish();
        goto L_0x00d4;
    L_0x0185:
        r2 = "MicroMsg.ChattingSendDataToDeviceUI";
        r4 = "getWXMediaMessage attInfo is null";
        com.tencent.mm.sdk.platformtools.x.e(r2, r4);
        goto L_0x016f;
    L_0x018f:
        r4 = r10.bXA;
        r4 = r4.type;
        if (r4 != r8) goto L_0x00b6;
    L_0x0195:
        r0 = new com.tencent.mm.opensdk.modelmsg.WXImageObject;
        r0.<init>();
        r4 = com.tencent.mm.ak.o.Pf();
        r5 = r10.oup;
        r4 = r4.q(r5);
        if (r4 == 0) goto L_0x01c6;
    L_0x01a6:
        r5 = com.tencent.mm.ak.o.Pf();
        r6 = r4.dTL;
        r5 = r5.lN(r6);
        r0.imagePath = r5;
        r5 = r0.imagePath;
        r5 = com.tencent.mm.sdk.platformtools.bi.oW(r5);
        if (r5 == 0) goto L_0x01c6;
    L_0x01ba:
        r5 = com.tencent.mm.ak.o.Pf();
        r4 = r4.dTN;
        r4 = r5.lN(r4);
        r0.imagePath = r4;
    L_0x01c6:
        r4 = r0.imagePath;
        r10.filePath = r4;
        r4 = r10.bXA;
        r4 = r4.dwp;
        r10.fjS = r4;
        r4 = "MicroMsg.ChattingSendDataToDeviceUI";
        r5 = "getWXMediaMessage imagePath %s";
        r6 = new java.lang.Object[r1];
        r7 = r0.imagePath;
        r6[r2] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        goto L_0x00b6;
    L_0x01e1:
        r0 = new com.tencent.mm.opensdk.modelmsg.WXTextObject;
        r2 = r10.oup;
        r2 = r2.field_content;
        r0.<init>(r2);
        goto L_0x00b6;
    L_0x01ec:
        r0 = new com.tencent.mm.opensdk.modelmsg.WXImageObject;
        r0.<init>();
        r4 = com.tencent.mm.ak.o.Pf();
        r5 = r10.oup;
        r4 = r4.q(r5);
        if (r4 == 0) goto L_0x0248;
    L_0x01fd:
        r5 = com.tencent.mm.ak.o.Pf();
        r6 = r4.dTL;
        r5 = r5.lN(r6);
        r0.imagePath = r5;
        r5 = r0.imagePath;
        r5 = com.tencent.mm.sdk.platformtools.bi.oW(r5);
        if (r5 == 0) goto L_0x021d;
    L_0x0211:
        r5 = com.tencent.mm.ak.o.Pf();
        r4 = r4.dTN;
        r4 = r5.lN(r4);
        r0.imagePath = r4;
    L_0x021d:
        r4 = r0.imagePath;
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r4 != 0) goto L_0x0248;
    L_0x0225:
        r4 = r0.imagePath;
        r10.filePath = r4;
        r4 = r0.imagePath;
        r5 = ".";
        r4 = r4.lastIndexOf(r5);
        if (r4 < 0) goto L_0x0248;
    L_0x0234:
        r5 = r0.imagePath;
        r5 = r5.length();
        r5 = r5 + -1;
        if (r4 >= r5) goto L_0x0248;
    L_0x023e:
        r5 = r0.imagePath;
        r4 = r4 + 1;
        r4 = r5.substring(r4);
        r10.fjS = r4;
    L_0x0248:
        r4 = "MicroMsg.ChattingSendDataToDeviceUI";
        r5 = "getWXMediaMessage imagePath %s";
        r6 = new java.lang.Object[r1];
        r7 = r0.imagePath;
        r6[r2] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        goto L_0x00b6;
    L_0x0259:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.FT();
        r2 = r10.oup;
        r2 = r2.field_content;
        r2 = r0.GS(r2);
        r0 = new com.tencent.mm.opensdk.modelmsg.WXLocationObject;
        r4 = r2.kCw;
        r6 = r2.kCx;
        r0.<init>(r4, r6);
        goto L_0x00b6;
    L_0x0273:
        r0 = new com.tencent.mm.opensdk.modelmsg.WXVideoObject;
        r0.<init>();
        com.tencent.mm.modelvideo.o.Ta();
        r2 = r10.oup;
        r2 = r2.field_imgPath;
        r2 = com.tencent.mm.modelvideo.s.nK(r2);
        if (r2 == 0) goto L_0x00b6;
    L_0x0285:
        r0.videoUrl = r2;
        r10.filePath = r2;
        r4 = ".";
        r4 = r2.lastIndexOf(r4);
        if (r4 < 0) goto L_0x00b6;
    L_0x0292:
        r5 = r2.length();
        r5 = r5 + -1;
        if (r4 >= r5) goto L_0x00b6;
    L_0x029a:
        r4 = r4 + 1;
        r2 = r2.substring(r4);
        r10.fjS = r2;
        goto L_0x00b6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.ctV():void");
    }

    private void ctW() {
        dh dhVar = new dh();
        if (this.bLV) {
            String string = getIntent().getExtras().getString("sns_send_data_ui_image_path");
            int i = getIntent().getExtras().getInt("sns_send_data_ui_image_position");
            dhVar.bKU.bKW = this.iux;
            dhVar.bKU.bKX = string;
            dhVar.bKU.bKY = i;
        } else {
            dhVar.bKU.bJC = this.cYP;
        }
        com.tencent.mm.sdk.b.a.sFg.m(dhVar);
        if (dhVar.bKV.bKE) {
            List list = dhVar.bKV.bKZ;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                c cVar = new c(this);
                cVar.bKv = (String) ((Map) list.get(i2)).get("deviceType");
                cVar.deviceID = (String) ((Map) list.get(i2)).get("deviceID");
                cVar.daA = (String) ((Map) list.get(i2)).get("displayName");
                cVar.iconUrl = (String) ((Map) list.get(i2)).get("iconUrl");
                cVar.bLU = (String) ((Map) list.get(i2)).get("ability");
                cVar.tLS = (String) ((Map) list.get(i2)).get("abilityInf");
                if (this.bLV && a(cVar, this.iux)) {
                    this.tLr.add(cVar);
                } else if (!this.bLV && a(cVar, this.cYP)) {
                    this.tLr.add(cVar);
                }
            }
            if (this.tLr.size() > 0) {
                x.d("MicroMsg.ChattingSendDataToDeviceUI", "update data mListHardDeviceOnline");
                this.tLj.aQ(this.tLr);
                if (this.tLj.getCount() > 0) {
                    this.tLo.setText(R.l.chatting_available_device);
                    this.tLu = false;
                }
                this.tLj.notifyDataSetChanged();
            }
        }
    }

    private static boolean a(String str, c cVar) {
        String str2 = cVar.bLU;
        String str3 = cVar.tLS;
        String host = Uri.parse(str).getHost();
        if (str3 == null || str3.length() <= 0 || str2 == null || !str2.contains("wxmsg_url")) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONObject(str3).getJSONArray("wxmsg_url");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (jSONArray.getString(i).equals(host)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ChattingSendDataToDeviceUI", e, str3, new Object[0]);
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.c r8, java.lang.String r9) {
        /*
        r1 = 0;
        r0 = 1;
        if (r9 != 0) goto L_0x0005;
    L_0x0004:
        return r1;
    L_0x0005:
        r2 = new com.tencent.mm.g.a.hu;
        r2.<init>();
        r3 = r2.bRf;
        r3.bKW = r9;
        r3 = com.tencent.mm.sdk.b.a.sFg;
        r3.m(r2);
        r2 = r2.bRg;
        r2 = r2.bRh;
        r3 = r2.sqc;
        r3 = r3.ruz;
        r4 = "MicroMsg.ChattingSendDataToDeviceUI";
        r5 = "isNeedToShowSnsInfo contentStyle %d";
        r6 = new java.lang.Object[r0];
        r7 = java.lang.Integer.valueOf(r3);
        r6[r1] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        r4 = r8.bLU;
        if (r4 != 0) goto L_0x003a;
    L_0x0030:
        r0 = "MicroMsg.ChattingSendDataToDeviceUI";
        r2 = "ability is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);
        goto L_0x0004;
    L_0x003a:
        if (r3 != r0) goto L_0x0047;
    L_0x003c:
        r2 = "wxmsg_image";
        r2 = r4.contains(r2);
        if (r2 == 0) goto L_0x0053;
    L_0x0045:
        r1 = r0;
        goto L_0x0004;
    L_0x0047:
        r5 = 4;
        if (r3 != r5) goto L_0x0055;
    L_0x004a:
        r2 = "wxmsg_music";
        r2 = r4.contains(r2);
        if (r2 != 0) goto L_0x0045;
    L_0x0053:
        r0 = r1;
        goto L_0x0045;
    L_0x0055:
        r5 = 15;
        if (r3 != r5) goto L_0x0063;
    L_0x0059:
        r2 = "wxmsg_video";
        r2 = r4.contains(r2);
        if (r2 == 0) goto L_0x0053;
    L_0x0062:
        goto L_0x0045;
    L_0x0063:
        r0 = 3;
        if (r3 != r0) goto L_0x0053;
    L_0x0066:
        r0 = r2.sqc;
        r0 = r0.jPK;
        r0 = a(r0, r8);
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.a(com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$c, java.lang.String):boolean");
    }

    public void onBackPressed() {
        if (this.tLz.size() > 0) {
            com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this);
            aVar.Gr(R.l.chatting_send_cancel_tips);
            aVar.Gt(R.l.chatting_send_dialog_cancel).a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    for (String str : ChattingSendDataToDeviceUI.this.tLz.keySet()) {
                        cw cwVar = new cw();
                        cwVar.bKr.byN = str;
                        com.tencent.mm.sdk.b.a.sFg.m(cwVar);
                    }
                    ChattingSendDataToDeviceUI.this.finish();
                }
            });
            aVar.Gu(R.l.chatting_send_continue).b(new 6(this));
            aVar.anj().show();
            return;
        }
        super.onBackPressed();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.c r9, long r10) {
        /*
        r8 = 3;
        r1 = 0;
        r0 = 1;
        r2 = -1;
        r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r2 = r9.bLU;
        com.tencent.mm.model.au.HU();
        r3 = com.tencent.mm.model.c.FT();
        r3 = r3.dW(r10);
        r4 = r3.field_msgId;
        r6 = 0;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 == 0) goto L_0x0009;
    L_0x001f:
        if (r2 == 0) goto L_0x0009;
    L_0x0021:
        r4 = r3.getType();
        r5 = r3.field_content;
        r3 = r3.aQm();
        if (r3 == 0) goto L_0x007e;
    L_0x002d:
        r3 = com.tencent.mm.y.g.a.gp(r5);
        if (r3 != 0) goto L_0x003d;
    L_0x0033:
        r0 = "MicroMsg.ChattingSendDataToDeviceUI";
        r2 = "get content is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);
        goto L_0x0009;
    L_0x003d:
        r4 = r3.type;
        if (r4 != r8) goto L_0x004c;
    L_0x0041:
        r3 = "wxmsg_music";
        r2 = r2.contains(r3);
        if (r2 == 0) goto L_0x0061;
    L_0x004a:
        r1 = r0;
        goto L_0x0009;
    L_0x004c:
        r4 = r3.type;
        r5 = 4;
        if (r4 != r5) goto L_0x0053;
    L_0x0051:
        r0 = r1;
        goto L_0x004a;
    L_0x0053:
        r4 = r3.type;
        r5 = 6;
        if (r4 != r5) goto L_0x0063;
    L_0x0058:
        r3 = "wxmsg_file";
        r2 = r2.contains(r3);
        if (r2 != 0) goto L_0x004a;
    L_0x0061:
        r0 = r1;
        goto L_0x004a;
    L_0x0063:
        r4 = r3.type;
        r5 = 5;
        if (r4 != r5) goto L_0x006f;
    L_0x0068:
        r0 = r3.url;
        r0 = a(r0, r9);
        goto L_0x004a;
    L_0x006f:
        r3 = r3.type;
        r4 = 2;
        if (r3 != r4) goto L_0x0061;
    L_0x0074:
        r3 = "wxmsg_image";
        r2 = r2.contains(r3);
        if (r2 == 0) goto L_0x0061;
    L_0x007d:
        goto L_0x004a;
    L_0x007e:
        if (r4 != r8) goto L_0x008a;
    L_0x0080:
        r3 = "wxmsg_image";
        r2 = r2.contains(r3);
        if (r2 == 0) goto L_0x0061;
    L_0x0089:
        goto L_0x004a;
    L_0x008a:
        r3 = 48;
        if (r4 != r3) goto L_0x0098;
    L_0x008e:
        r3 = "wxmsg_poi";
        r2 = r2.contains(r3);
        if (r2 == 0) goto L_0x0061;
    L_0x0097:
        goto L_0x004a;
    L_0x0098:
        r3 = 62;
        if (r4 != r3) goto L_0x0061;
    L_0x009c:
        r3 = "wxmsg_video";
        r2 = r2.contains(r3);
        if (r2 == 0) goto L_0x0061;
    L_0x00a5:
        goto L_0x004a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.a(com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI$c, long):boolean");
    }

    protected void onResume() {
        super.onResume();
        ctV();
        if (this.tLp.booleanValue()) {
            LayoutParams layoutParams = (LayoutParams) this.qNg.getLayoutParams();
            int i = layoutParams.height;
            float fe = com.tencent.mm.bp.a.fe(this);
            if (fe == 1.125f) {
                layoutParams.height = i + getResources().getDimensionPixelSize(R.f.LittlePadding);
            } else if (fe == 1.375f || fe == 1.25f || fe == 1.625f) {
                layoutParams.height = i + getResources().getDimensionPixelSize(R.f.NormalPadding);
            }
            this.qNg.setLayoutParams(layoutParams);
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a(this, i, i2, intent, true, R.l.download_no_match_msg, R.l.download_no_match_title, 1);
    }

    protected void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.ChattingSendDataToDeviceUI", "onDestroy...");
        this.tLw = false;
        if (this.tLp.booleanValue()) {
            if (!this.tLv) {
                pf(2);
            }
            com.tencent.mm.sdk.b.a.sFg.c(this.tLE);
            com.tencent.mm.sdk.b.a.sFg.c(this.tLF);
            ep epVar = new ep();
            com.tencent.mm.sdk.b.a.sFg.m(epVar);
            if (epVar.bMt.bLW) {
                x.i("MicroMsg.ChattingSendDataToDeviceUI", "Stop scan Network success!");
            }
        }
    }

    public final b ctX() {
        if (this.tLq == null) {
            this.tLq = new b(this);
        }
        return this.tLq;
    }
}
