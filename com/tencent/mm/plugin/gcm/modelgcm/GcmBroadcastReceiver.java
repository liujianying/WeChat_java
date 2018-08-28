package com.tencent.mm.plugin.gcm.modelgcm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import com.google.android.gms.gcm.a;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.kernel.k;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.LinkedList;
import java.util.List;

public class GcmBroadcastReceiver extends BroadcastReceiver {
    static List<Pair<Long, Long>> khd = new LinkedList();
    private static volatile boolean khe = false;
    private static WakerLock wakerlock = null;

    public static void aVF() {
        khd.clear();
    }

    public void onReceive(Context context, Intent intent) {
        x.i("GcmBroadcastReceiver", "GcmBroadcastReceiver onReceive in.");
        String aVJ;
        String stringExtra;
        if (intent.getAction().equals("com.google.android.c2dm.intent.REGISTRATION")) {
            a aVG = a.aVG();
            aVJ = aVG.aVJ();
            stringExtra = intent.getStringExtra("registration_id");
            x.i("GcmBroadcastReceiver", "REGISTRATION intent received:" + intent.toString());
            if (intent.getStringExtra("error") == null) {
                if (!(intent.getStringExtra("unregistered") != null || stringExtra == null || aVJ.compareTo(stringExtra) == 0)) {
                    if (aa.UX() == null) {
                        x.w("GcmBroadcastReceiver", "gcm reg id recv, but mmpushcore not init, id = " + stringExtra);
                    } else {
                        aVG.aq(context, stringExtra);
                        aa.UX().post(new 2(aVG));
                    }
                }
            }
            f.mDy.a(452, 25, 1, false);
            return;
        }
        a aVG2 = a.aVG();
        Object[] objArr;
        if (aVG2 == null || bi.oW(aVG2.aVJ())) {
            aVJ = "GcmBroadcastReceiver";
            stringExtra = "Gcm push is not reg to server. reg == null[%b], isRegToSvr[%b]";
            objArr = new Object[2];
            objArr[0] = Boolean.valueOf(aVG2 == null);
            objArr[1] = Boolean.valueOf(aVG2 == null ? false : aVG2.aVO());
            x.i(aVJ, stringExtra, objArr);
            h.mEJ.k(11250, "1,2");
            f.mDy.a(452, aVG2 == null ? 26 : 27, 1, false);
        } else if (aVG2.aVK()) {
            f.mDy.a(452, 42, 1, false);
            if (khe) {
                x.i("GcmBroadcastReceiver", "Gcm push isRegistrationExpired and reNewalRegistting return");
                f.mDy.a(452, 44, 1, false);
            } else if (aa.UX() == null) {
                x.i("GcmBroadcastReceiver", "Gcm push isRegistrationExpired but handler is null wait for next push");
            } else {
                khe = true;
                aa.UX().postDelayed(new 1(this, aVG2), 500);
            }
        } else {
            khe = false;
            try {
                if (k.bA(context)) {
                    x.i("GcmBroadcastReceiver", "Logout or exit MM. no need show Notification.");
                    h.mEJ.k(11250, "1,2");
                    f.mDy.a(452, 28, 1, false);
                    return;
                }
                Bundle extras = intent.getExtras();
                a.al(context);
                aVJ = a.c(intent);
                if (extras.isEmpty()) {
                    x.i("GcmBroadcastReceiver", "Intent extras is empty: ");
                    h.mEJ.k(11250, "1,0");
                    f.mDy.a(452, 29, 1, false);
                    return;
                }
                String string = extras.getString("seq");
                String string2 = extras.getString(OpenSDKTool4Assistant.EXTRA_UIN);
                String string3 = extras.getString("cmd");
                String string4 = extras.getString("username");
                String string5 = extras.getString("time");
                String string6 = extras.getString("collapse_key");
                String string7 = extras.getString("sound");
                String string8 = extras.getString("alert");
                String string9 = extras.getString("msgType");
                String string10 = extras.getString("badge");
                String string11 = extras.getString("from");
                extras.getString("ext");
                if ("send_error".equals(aVJ)) {
                    aVJ = "GcmBroadcastReceiver";
                    stringExtra = "Send error:. seq[%s] uin[%s] cmd[%s] username[%s] time[%s] collapse_key[%s] sound[%s] alert len[%s], msgType[%s], badge[%s], from[%s]";
                    objArr = new Object[11];
                    objArr[0] = string;
                    objArr[1] = string2;
                    objArr[2] = string3;
                    objArr[3] = bi.Xf(string4);
                    objArr[4] = string5;
                    objArr[5] = string6;
                    objArr[6] = string7;
                    objArr[7] = Integer.valueOf(string8 == null ? -1 : string8.length());
                    objArr[8] = string9;
                    objArr[9] = string10;
                    objArr[10] = string11;
                    x.i(aVJ, stringExtra, objArr);
                    h.mEJ.k(11250, "1,1");
                    f.mDy.a(452, 30, 1, false);
                } else if ("deleted_messages".equals(aVJ)) {
                    x.i("GcmBroadcastReceiver", "Deleted messages on server.");
                    h.mEJ.k(11250, "1,1");
                    f.mDy.a(452, 31, 1, false);
                } else if ("gcm".equals(aVJ)) {
                    f.mDy.a(452, 32, 1, false);
                    aVJ = "GcmBroadcastReceiver";
                    stringExtra = "Received gcm msg. seq[%s] uin[%s] cmd[%s] username[%s] time[%s] collapse_key[%s] sound[%s] alert len[%s], msgType[%s], badge[%s], from[%s]";
                    objArr = new Object[11];
                    objArr[0] = string;
                    objArr[1] = string2;
                    objArr[2] = string3;
                    objArr[3] = bi.Xf(string4);
                    objArr[4] = string5;
                    objArr[5] = string6;
                    objArr[6] = string7;
                    objArr[7] = Integer.valueOf(string8 == null ? -1 : string8.length());
                    objArr[8] = string9;
                    objArr[9] = string10;
                    objArr[10] = string11;
                    x.i(aVJ, stringExtra, objArr);
                    long j = bi.oW(string2) ? 0 : bi.getLong(string2, 0);
                    long j2 = bi.oW(string) ? 0 : bi.getLong(string, 0);
                    long j3 = bi.oW(string3) ? 0 : bi.getLong(string3, 0);
                    int Dz = com.tencent.mm.kernel.a.Dz();
                    if (j == 0 || !Integer.toHexString(Dz).equals(Long.toHexString(j))) {
                        x.e("GcmBroadcastReceiver", "Logined user changed. no need show Notification.uin:" + j + ", oldUin:" + Dz);
                        h.mEJ.k(11250, "1,3");
                        f fVar = f.mDy;
                        if (j == 0) {
                            j3 = 33;
                        } else {
                            j3 = 34;
                        }
                        fVar.a(452, j3, 1, false);
                        return;
                    }
                    Object obj;
                    for (Pair pair : khd) {
                        if (((Long) pair.first).longValue() == j3 && ((Long) pair.second).longValue() == j2) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        x.w("GcmBroadcastReceiver", "already has this seq:" + j2);
                        f.mDy.a(452, 35, 1, false);
                        return;
                    }
                    khd.add(Pair.create(Long.valueOf(j3), Long.valueOf(j2)));
                    if (khd.size() > 60) {
                        khd.remove(0);
                    }
                    if (wakerlock == null) {
                        wakerlock = new WakerLock(context, "GcmBroadcastReceiver");
                        x.i("GcmBroadcastReceiver", "start new wakerlock");
                    }
                    wakerlock.lock(200, "GcmBroadcastReceiver.onReceive");
                    gi giVar = new gi();
                    giVar.bPw.type = 13;
                    com.tencent.mm.sdk.b.a.sFg.m(giVar);
                }
                x.i("GcmBroadcastReceiver", "GcmBroadcastReceiver onReceive out.");
            } catch (Throwable e) {
                x.e("GcmBroadcastReceiver", "GcmBroadcastReceiver error :" + e.toString());
                x.printErrStackTrace("GcmBroadcastReceiver", e, "", new Object[0]);
                f.mDy.a(452, 36, 1, false);
            }
        }
    }
}
