package com.tencent.mm.booter.notification;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bf.a;
import com.tencent.mm.g.a.oy;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingUI;

class b$3 extends c<oy> {
    final /* synthetic */ b cYv;

    b$3(b bVar) {
        this.cYv = bVar;
        this.sFo = oy.class.getName().hashCode();
    }

    private boolean a(oy oyVar) {
        if (oyVar != null && (oyVar instanceof oy)) {
            String str = oyVar.bZT.bYo;
            int i = oyVar.bZT.msgType;
            b bVar = this.cYv;
            try {
                x.w("showSendMsgFailNotification fromUserName:%s msgType:%d", str, new Object[]{Integer.valueOf(i)});
                if (!ChattingUI.class.getName().equals(((RunningTaskInfo) ((ActivityManager) bVar.context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName())) {
                    Intent intent = new Intent(bVar.context, ChattingUI.class);
                    intent.putExtra("nofification_type", "pushcontent_notification");
                    intent.putExtra("Intro_Is_Muti_Talker", true);
                    intent.putExtra("Chat_User", str);
                    intent.putExtra("MainUI_User_Last_Msg_Type", i);
                    intent.addFlags(536870912);
                    intent.addFlags(67108864);
                    Notification notification = new Builder(bVar.context).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(bVar.context.getString(R.l.app_pushcontent_title)).setContentText(bVar.context.getString(R.l.message_send_fail)).setContentIntent(PendingIntent.getActivity(bVar.context, 35, intent, 1073741824)).getNotification();
                    notification.icon = a.cbg();
                    notification.defaults |= 1;
                    notification.flags |= 16;
                    bVar.a(35, notification, true);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMNotification", e, "", new Object[0]);
            }
        }
        return false;
    }
}
