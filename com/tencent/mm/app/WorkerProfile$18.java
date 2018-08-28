package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.g.a.ca;
import com.tencent.mm.plugin.base.stub.WXBizEntryActivity;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WorkerProfile$18 extends c<ca> {
    final /* synthetic */ WorkerProfile bzO;

    WorkerProfile$18(WorkerProfile workerProfile) {
        this.bzO = workerProfile;
        this.sFo = ca.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ca caVar = (ca) bVar;
        Context context = caVar.bJp.context;
        if (context == null) {
            x.e("MicroMsg.WorkerProfile", "CreateOrJoinChatroomEvent, context is null");
            return false;
        }
        String[] strArr = caVar.bJp.selectionArgs;
        if (strArr == null || strArr.length < 2) {
            x.e("MicroMsg.WorkerProfile", "CreateOrJoinChatroomEvent, invalid args");
            return false;
        }
        String str;
        int i;
        String[] strArr2 = caVar.bJp.bGj;
        String str2 = "";
        if (strArr2 != null && strArr2.length > 0) {
            str2 = strArr2[0];
        }
        String str3 = strArr[0];
        String str4 = strArr[1];
        String str5 = strArr[2];
        String str6 = "";
        String str7 = "";
        String str8 = "";
        String str9 = "";
        if (caVar.bJp.action == 1) {
            str = "action_create";
            if (strArr.length >= 4) {
                str6 = strArr[3];
            }
            if (strArr.length >= 5) {
                str7 = strArr[4];
            }
            if (strArr.length >= 6) {
                str8 = strArr[5];
            }
            if (strArr.length >= 7) {
                str9 = strArr[6];
            }
            i = 14;
        } else if (caVar.bJp.action != 2) {
            return false;
        } else {
            str = "action_join";
            if (strArr.length >= 4) {
                str7 = strArr[3];
            }
            if (strArr.length >= 5) {
                str8 = strArr[4];
            }
            if (strArr.length >= 6) {
                str9 = strArr[5];
            }
            i = 15;
        }
        Intent intent = new Intent(context, WXBizEntryActivity.class);
        intent.addFlags(268435456).addFlags(134217728).addFlags(67108864);
        intent.putExtra("key_app_id", str3);
        intent.putExtra("key_transaction", str4);
        intent.putExtra("key_command_id", i);
        intent.putExtra("action", str);
        intent.putExtra("package_name", str2);
        intent.putExtra("group_id", str5);
        intent.putExtra("chatroom_name", str6);
        intent.putExtra("chatroom_nickname", str7);
        intent.putExtra("ext_msg", str8);
        intent.putExtra("open_id", str9);
        context.startActivity(intent);
        return true;
    }
}
