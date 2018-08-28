package com.tencent.mm.ui.voicesearch;

import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VoiceSearchResultUI extends MMActivity {
    private int ecA = 2;
    private TextView hSp;
    private int iLq = -1;
    int showType = 1;
    private ListView uFC;
    private String uFE = null;
    private b uFP;
    private String[] uFQ;
    private boolean uFR = false;
    boolean uFS = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        this.uFR = false;
    }

    protected final void initView() {
        this.uFC = (ListView) findViewById(R.h.voice_search_resultlist);
        this.hSp = (TextView) findViewById(R.h.empty_voicesearch_tip_tv);
        this.uFQ = getIntent().getStringArrayExtra("VoiceSearchResultUI_Resultlist");
        this.uFE = getIntent().getStringExtra("VoiceSearchResultUI_Error");
        this.iLq = getIntent().getIntExtra("VoiceSearchResultUI_VoiceId", -1);
        this.showType = getIntent().getIntExtra("VoiceSearchResultUI_ShowType", 1);
        this.ecA = this.showType == 1 ? 2 : 1;
        this.uFS = getIntent().getBooleanExtra("VoiceSearchResultUI_IsVoiceControl", false);
        x.i("MicroMsg.VoiceSearchResultUI", "showType = %s, isVoiceControl = %s", new Object[]{Integer.valueOf(this.showType), Boolean.valueOf(this.uFS)});
        this.uFP = new b(getApplicationContext(), this.showType);
        this.uFP.mA(false);
        List linkedList = new LinkedList();
        switch (this.showType) {
            case 2:
                linkedList.add("lbsapp");
                linkedList.add("shakeapp");
                linkedList.add("qqfriend");
                linkedList.add("facebookapp");
                linkedList.add("feedsapp");
                linkedList.add("fmessage");
                linkedList.add("voipapp");
                linkedList.add("voicevoipapp");
                linkedList.add("voiceinputapp");
                linkedList.add("linkedinplugin");
                linkedList.add("notifymessage");
                int GQ = q.GQ();
                if ((GQ & 1) != 0) {
                    linkedList.add("qqmail");
                }
                if (!(s.Ht() && (GQ & 2) == 0)) {
                    linkedList.add("tmessage");
                }
                if ((GQ & 32) != 0) {
                    linkedList.add("qmessage");
                }
                if ((GQ & 128) != 0) {
                    linkedList.add("qqsync");
                }
                if ((GQ & 16) != 0) {
                    linkedList.add("medianote");
                }
                if ((524288 & GQ) != 0) {
                    linkedList.add("newsapp");
                }
                if (!((262144 & GQ) == 0 && s.Hs())) {
                    linkedList.add("blogapp");
                }
                if ((65536 & GQ) != 0) {
                    linkedList.add("masssendapp");
                }
                if ((GQ & 33554432) != 0) {
                    linkedList.add("voiceinputapp");
                    break;
                }
                break;
        }
        if (this.uFP != null) {
            this.uFP.dQ(linkedList);
        }
        this.uFC.setAdapter(this.uFP);
        this.hSp.setVisibility(8);
        x.d("MicroMsg.VoiceSearchResultUI", "voiceId  " + this.iLq);
        if (this.showType == 2) {
            setMMTitle("");
            this.uFQ = K(this.uFQ);
        } else {
            setMMTitle(getString(R.l.voice_search_result));
        }
        setMMTitle(getString(R.l.voice_search_result));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!VoiceSearchResultUI.this.uFR) {
                    h.mEJ.k(10452, VoiceSearchResultUI.this.ecA + "," + VoiceSearchResultUI.this.iLq + "," + (VoiceSearchResultUI.this.uFQ == null ? 0 : VoiceSearchResultUI.this.uFQ.length) + ",0");
                }
                if (VoiceSearchResultUI.this.uFS) {
                    VoiceSearchResultUI.this.moveTaskToBack(true);
                }
                VoiceSearchResultUI.this.finish();
                return true;
            }
        });
        this.uFC.setOnItemClickListener(new 2(this));
        L(this.uFQ);
    }

    private static String[] K(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return strArr;
        }
        x.d("MicroMsg.VoiceSearchResultUI", "oldlist.length " + strArr.length);
        Map hashMap = new HashMap();
        List arrayList = new ArrayList();
        for (String str : strArr) {
            String gT = r.gT(str);
            x.d("MicroMsg.VoiceSearchResultUI", "displayname " + gT);
            if (!hashMap.containsValue(gT) || !s.fq(str)) {
                x.d("MicroMsg.VoiceSearchResultUI", "username " + str);
                hashMap.put(gT, str);
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void onDestroy() {
        super.onDestroy();
        this.uFP.aYc();
    }

    public void onPause() {
        super.onPause();
        this.uFR = true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            if (!this.uFR) {
                h.mEJ.k(10452, this.ecA + "," + this.iLq + "," + (this.uFQ == null ? 0 : this.uFQ.length) + ",0");
            }
            if (this.uFS) {
                moveTaskToBack(true);
                finish();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    static boolean abq(String str) {
        Cursor[] cursorArr = new Cursor[2];
        cursorArr[0] = au.HU().dAb.a(s.dAN, null, str);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        while (cursorArr[0].moveToNext()) {
            try {
                String string = cursorArr[0].getString(cursorArr[0].getColumnIndex("username"));
                arrayList.add(string);
                if (!string.endsWith("@chatroom")) {
                    arrayList2.add(string);
                }
                x.d("MicroMsg.VoiceSearchResultUI", "block user " + string);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VoiceSearchResultUI", e, "", new Object[0]);
            }
        }
        cursorArr[1] = au.HU().dAc.a(str, "@micromsg.with.all.biz.qq.com", arrayList, arrayList2);
        int count = cursorArr[1].getCount();
        int count2 = cursorArr[0].getCount();
        cursorArr[0].close();
        cursorArr[1].close();
        x.d("MicroMsg.VoiceSearchResultUI", "contactCount " + count + " conversationCount " + count2);
        if (count + count2 <= 1) {
            return true;
        }
        return false;
    }

    private void L(String[] strArr) {
        List arrayList = new ArrayList();
        if (!(strArr == null || this.uFP == null)) {
            for (String str : strArr) {
                if (this.uFP.abp(str)) {
                    arrayList.add(str);
                }
            }
        }
        if (arrayList.size() == 0) {
            this.hSp.setVisibility(0);
            if (this.uFE != null) {
                this.hSp.setText(this.uFE);
            } else {
                this.hSp.setText(getString(R.l.address_empty_voicesearch_tip));
            }
        } else {
            this.hSp.setVisibility(8);
        }
        if (this.uFP != null) {
            this.uFP.ed(arrayList);
        }
    }

    protected final int getLayoutId() {
        return R.i.voice_search_result;
    }
}
