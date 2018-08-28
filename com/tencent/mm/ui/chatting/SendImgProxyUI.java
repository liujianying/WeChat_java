package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.o;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.List;

public class SendImgProxyUI extends MMBaseActivity {
    private static boolean bgH = false;
    private p guT = null;

    static /* synthetic */ void a(SendImgProxyUI sendImgProxyUI, Intent intent) {
        if (intent == null) {
            x.e("MicroMsg.SendImgProxyUI", "data is empty!");
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", true);
        intent.getStringExtra("GalleryUI_ToUser");
        ArrayList arrayList = new ArrayList();
        ArrayList a = a(intent.getStringArrayListExtra("CropImage_OutputPath_List"), intent.getIntExtra("CropImage_limit_Img_Size", 26214400), arrayList, booleanExtra);
        intent.putStringArrayListExtra("CropImage_OutputPath_List", a);
        List stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
        if (a.size() == 0 && arrayList.size() == 0 && (stringArrayListExtra == null || stringArrayListExtra.size() == 0)) {
            Toast.makeText(sendImgProxyUI, sendImgProxyUI.getString(R.l.gallery_nothing_to_send_in_selected_items), 0).show();
            x.e("MicroMsg.SendImgProxyUI", "filelist is empty!");
            return;
        }
        int intExtra = intent.getIntExtra("from_source", 0);
        int intExtra2 = intent.getIntExtra("CropImage_rotateCount", 0);
        String stringExtra = intent.getStringExtra("GalleryUI_ToUser");
        x.d("MicroMsg.SendImgProxyUI", "toUserName : " + stringExtra);
        x.d("MicroMsg.SendImgProxyUI", "dkimgsource" + intent.getIntExtra("from_source", 0));
        if (arrayList.size() > 0) {
            n.OW().a(arrayList, true, intExtra, intExtra2, stringExtra, R.g.chat_img_template);
            g(n.OW().lQ(stringExtra), arrayList);
            x.e("MicroMsg.SendImgProxyUI", "overSizeList size:%s!", new Object[]{Integer.valueOf(arrayList.size())});
        }
        n.OW().a(a, booleanExtra, intExtra, intExtra2, stringExtra, R.g.chat_img_template);
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        ak.a(getWindow());
        x.i("MicroMsg.SendImgProxyUI", "onCreate isRunning:%b ,%d", new Object[]{Boolean.valueOf(bgH), Integer.valueOf(hashCode())});
        if (bgH) {
            x.w("MicroMsg.SendImgProxyUI", "duplicate instance");
            finish();
            return;
        }
        bgH = true;
        setContentView(R.i.background_transparent);
        this.guT = h.a(this, getString(R.l.main_sending), false, null);
        boolean isWifi = ao.isWifi(this);
        boolean z = HardCoderJNI.hcSendPicMsgEnable;
        int i2 = HardCoderJNI.hcSendPicMsgDelay;
        int i3 = HardCoderJNI.hcSendPicMsgCPU;
        int i4 = HardCoderJNI.hcSendPicMsgIO;
        if (HardCoderJNI.hcSendPicMsgThr) {
            i = g.Em().cij();
        }
        au.Em().H(new 1(this, isWifi, HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcSendPicMsgTimeout, 203, HardCoderJNI.hcSendPicMsgAction, "MicroMsg.SendImgProxyUI")));
    }

    protected void onDestroy() {
        x.i("MicroMsg.SendImgProxyUI", "onDestroy isRunning:%b , %d", new Object[]{Boolean.valueOf(bgH), Integer.valueOf(hashCode())});
        super.onDestroy();
    }

    public void onResume() {
        x.i("MicroMsg.SendImgProxyUI", "onResume isRunning:%b ,%d", new Object[]{Boolean.valueOf(bgH), Integer.valueOf(hashCode())});
        super.onResume();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<java.lang.String> a(java.util.ArrayList<java.lang.String> r5, int r6, java.util.ArrayList<java.lang.String> r7, boolean r8) {
        /*
        r2 = new java.util.ArrayList;
        r2.<init>();
        if (r5 == 0) goto L_0x0069;
    L_0x0007:
        r3 = r5.iterator();
    L_0x000b:
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0069;
    L_0x0011:
        r0 = r3.next();
        r0 = (java.lang.String) r0;
        r1 = r0.toLowerCase();
        r4 = ".png";
        r1 = r1.endsWith(r4);
        if (r1 == 0) goto L_0x0057;
    L_0x0024:
        r1 = 0;
        r1 = com.tencent.mm.modelsfs.FileOp.openRead(r0);	 Catch:{ Exception -> 0x006a, all -> 0x0050 }
        r4 = com.tencent.mm.sdk.platformtools.MMBitmapFactory.checkIsImageLegal(r1);	 Catch:{ Exception -> 0x0046, all -> 0x0050 }
        if (r4 == 0) goto L_0x003a;
    L_0x002f:
        r4 = com.tencent.mm.a.e.cm(r0);	 Catch:{ Exception -> 0x0046, all -> 0x0050 }
        if (r8 != 0) goto L_0x0042;
    L_0x0035:
        if (r4 <= r6) goto L_0x0042;
    L_0x0037:
        r7.add(r0);	 Catch:{ Exception -> 0x0046, all -> 0x0050 }
    L_0x003a:
        if (r1 == 0) goto L_0x000b;
    L_0x003c:
        r1.close();	 Catch:{ Exception -> 0x0040 }
        goto L_0x000b;
    L_0x0040:
        r0 = move-exception;
        goto L_0x000b;
    L_0x0042:
        r2.add(r0);	 Catch:{ Exception -> 0x0046, all -> 0x0050 }
        goto L_0x003a;
    L_0x0046:
        r0 = move-exception;
        r0 = r1;
    L_0x0048:
        if (r0 == 0) goto L_0x000b;
    L_0x004a:
        r0.close();	 Catch:{ Exception -> 0x004e }
        goto L_0x000b;
    L_0x004e:
        r0 = move-exception;
        goto L_0x000b;
    L_0x0050:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0056;
    L_0x0053:
        r1.close();	 Catch:{ Exception -> 0x0067 }
    L_0x0056:
        throw r0;
    L_0x0057:
        r1 = com.tencent.mm.a.e.cm(r0);
        if (r8 != 0) goto L_0x0063;
    L_0x005d:
        if (r1 <= r6) goto L_0x0063;
    L_0x005f:
        r7.add(r0);
        goto L_0x000b;
    L_0x0063:
        r2.add(r0);
        goto L_0x000b;
    L_0x0067:
        r1 = move-exception;
        goto L_0x0056;
    L_0x0069:
        return r2;
    L_0x006a:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0048;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.SendImgProxyUI.a(java.util.ArrayList, int, java.util.ArrayList, boolean):java.util.ArrayList<java.lang.String>");
    }

    private static void g(ArrayList<Integer> arrayList, ArrayList<String> arrayList2) {
        if (arrayList.size() != arrayList2.size()) {
            x.e("MicroMsg.SendImgProxyUI", "[insertErrMsg] WTF");
            return;
        }
        for (int i = 0; i < arrayList2.size(); i++) {
            int intValue = ((Integer) arrayList.get(i)).intValue();
            e hQ = o.Pf().hQ(intValue);
            int cm = com.tencent.mm.a.e.cm((String) arrayList2.get(i));
            hQ.setOffset(cm);
            hQ.hL(cm);
            o.Pf().a(intValue, hQ);
            long j = hQ.dTS;
            x.i("MicroMsg.SendImgProxyUI", "[insertErrMsg] msgLocalId:%s oriImgLocalId:%s", new Object[]{Long.valueOf(j), Integer.valueOf(intValue)});
            bd dW = ((i) g.l(i.class)).bcY().dW(j);
            dW.setStatus(5);
            dW.eC(256);
            ((i) g.l(i.class)).bcY().a(j, dW);
            x.i("MicroMsg.SendImgProxyUI", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", new Object[]{Long.valueOf(dW.field_msgId), Long.valueOf(dW.field_msgSvrId), dW.field_talker, Integer.valueOf(dW.getType()), Integer.valueOf(dW.field_isSend), dW.field_imgPath, Integer.valueOf(dW.field_status), Long.valueOf(dW.field_createTime)});
        }
    }
}
