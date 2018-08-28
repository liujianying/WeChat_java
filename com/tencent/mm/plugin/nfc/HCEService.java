package com.tencent.mm.plugin.nfc;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.cardemulation.CardEmulation;
import android.nfc.cardemulation.HostApduService;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Base64;
import com.tencent.mm.g.a.ib;
import com.tencent.mm.g.a.id;
import com.tencent.mm.plugin.nfc.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
public class HCEService extends HostApduService {
    private static final byte[] lEQ = new byte[]{(byte) 0, (byte) 0};
    private static long mStartTime = -1;
    private int fWA;
    private ArrayList<String> lEJ;
    private boolean lEK = false;
    private boolean lEL = true;
    private boolean lEM = false;
    private boolean lEN = false;
    private a lEO = new a(this, (byte) 0);
    private com.tencent.mm.plugin.nfc.b.b lEP = new b(this, (byte) 0);
    private c<ib> lER = new 1(this);
    private String mAppId = null;

    private class b implements com.tencent.mm.plugin.nfc.b.b {
        private b() {
        }

        /* synthetic */ b(HCEService hCEService, byte b) {
            this();
        }

        public final void onCreate() {
            x.i("MicroMsg.HCEService", "alvinluo HCELifeCycle AppBrandUI onCreate");
        }

        public final void onResume() {
            x.i("MicroMsg.HCEService", "alvinluo HCELifeCycle AppBrandUI onResume");
            if (HCEService.this.lEK) {
                HCEService.this.bjl();
                HCEService.this.lEK = false;
            }
        }

        public final void onPause() {
            x.i("MicroMsg.HCEService", "alvinluo HCELifeCycle AppBrandUI onPause");
            HCEService.this.bjm();
            HCEService.this.lEK = true;
        }

        public final void onDestroy() {
            x.i("MicroMsg.HCEService", "alvinluo HCELifeCycle AppBrandUI onDestroy");
        }
    }

    public void onCreate() {
        super.onCreate();
        x.i("MicroMsg.HCEService", "alvinluo HCEService onCreate");
        if (!com.tencent.mm.sdk.b.a.sFg.d(this.lER)) {
            com.tencent.mm.sdk.b.a.sFg.a(this.lER);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.HCEService", "alvinluo HCEService onDestroy");
        bjm();
        if (com.tencent.mm.sdk.b.a.sFg.d(this.lER)) {
            com.tencent.mm.sdk.b.a.sFg.c(this.lER);
        }
    }

    @TargetApi(21)
    private void bjl() {
        if (this.lEJ == null) {
            x.e("MicroMsg.HCEService", "alvinluo mAidList is null, fail to register");
            return;
        }
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
        if (defaultAdapter == null) {
            x.e("MicroMsg.HCEService", "alvinluo NfcAdapter is null when register aids");
        } else if (VERSION.SDK_INT < 21) {
            x.e("MicroMsg.HCEService", "alvinluo android version: %d is not satisfied when register aids", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
        } else {
            CardEmulation instance = CardEmulation.getInstance(defaultAdapter);
            if (instance != null) {
                try {
                    ComponentName componentName = new ComponentName(this, HCEService.class);
                    x.i("MicroMsg.HCEService", "alvinluo register aids result: %b", new Object[]{Boolean.valueOf(instance.registerAidsForService(componentName, "payment", this.lEJ))});
                    if (instance.registerAidsForService(componentName, "payment", this.lEJ)) {
                        gS(true);
                        List aidsForService = instance.getAidsForService(componentName, "payment");
                        if (aidsForService != null && aidsForService.size() > 0) {
                            for (int i = 0; i < aidsForService.size(); i++) {
                                x.e("MicroMsg.HCEService", "dynamicAIDList aid=" + ((String) aidsForService.get(i)));
                            }
                            return;
                        }
                        return;
                    }
                    gS(false);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.HCEService", e, "alvinluo HCEService register aid exception", new Object[0]);
                    gS(false);
                }
            }
        }
    }

    private void gS(boolean z) {
        Bundle bundle = new Bundle();
        if (z) {
            bundle.putInt("errCode", 0);
            bundle.putString("errMsg", "");
        } else {
            bundle.putInt("errCode", 13006);
            bundle.putString("errMsg", "register aids failed");
        }
        d(this.mAppId, 12, bundle);
    }

    private static void d(String str, int i, Bundle bundle) {
        id idVar = new id();
        idVar.bRE.appId = str;
        idVar.bRE.type = i;
        idVar.bRE.extras = bundle;
        com.tencent.mm.sdk.b.a.sFg.m(idVar);
    }

    @TargetApi(21)
    private void bjm() {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
        if (defaultAdapter != null && VERSION.SDK_INT >= 21) {
            CardEmulation instance = CardEmulation.getInstance(defaultAdapter);
            if (instance != null) {
                ComponentName componentName = new ComponentName(this, HCEService.class);
                x.i("MicroMsg.HCEService", "alvinluo HCEService unregister aids");
                instance.removeAidsForService(componentName, "payment");
            }
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        x.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand");
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand start: %d", new Object[]{Long.valueOf(currentTimeMillis)});
        if (intent == null) {
            return super.onStartCommand(intent, i, i2);
        }
        this.mAppId = intent.getStringExtra("key_appid");
        this.lEJ = intent.getStringArrayListExtra("key_aid_list");
        this.fWA = intent.getIntExtra("key_time_limit", 1500);
        if (this.fWA < 1500) {
            x.i("MicroMsg.HCEService", "alvinluo HCEService timeLimit: %d smaller than: %d and set a valid value", new Object[]{Integer.valueOf(this.fWA), Integer.valueOf(1500)});
            this.fWA = 1500;
        }
        if (this.fWA > 60000) {
            x.i("MicroMsg.HCEService", "alvinluo HCEService timeLimit: %d, bigger than: %d and set a valid value", new Object[]{Integer.valueOf(this.fWA), Integer.valueOf(60000)});
            this.fWA = 60000;
        }
        x.i("MicroMsg.HCEService", "alvinluo HCEService valid timeLimit: %d", new Object[]{Integer.valueOf(this.fWA)});
        bjl();
        this.lEK = false;
        long currentTimeMillis2 = System.currentTimeMillis();
        x.i("MicroMsg.HCEService", "alvinluo HCEService onStartCommand end: %d, total: %d", new Object[]{Long.valueOf(currentTimeMillis2), Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
        return super.onStartCommand(intent, i, i2);
    }

    public byte[] processCommandApdu(byte[] bArr, Bundle bundle) {
        x.i("MicroMsg.HCEService", "alvinluo HCECOMMAND processCommandApdu, received command from system: %s", new Object[]{b.aE(bArr)});
        if (this.lEO != null) {
            this.lEO.dX(this.mAppId, new String(Base64.encode(bArr, 2)));
        }
        return null;
    }

    public void onDeactivated(int i) {
        x.i("MicroMsg.HCEService", "alvinluo HCEService onDeactivated reason: %d", new Object[]{Integer.valueOf(i)});
        this.lEM = false;
        this.lEN = false;
        Bundle bundle = new Bundle();
        bundle.putInt("key_on_deactivated_reason", i);
        d(this.mAppId, 41, bundle);
    }

    private synchronized void e(byte[] bArr, boolean z) {
        x.i("MicroMsg.HCEService", "alvinluo HCECOMMAND sendResponseCommandToSystem isDefaultCommand: %b, hasCommandNotResponded: %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.lEL)});
        if (this.lEL) {
            this.lEL = false;
            long currentTimeMillis = System.currentTimeMillis();
            x.i("MicroMsg.HCEService", "alvinluo HCECOMMAND send response command time: %d, cost: %d", new Object[]{Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - mStartTime)});
            sendResponseApdu(bArr);
            if (z) {
                x.i("MicroMsg.HCEReportManager", "alvinluo reportHCEtimeExceeded appId: %s", new Object[]{this.mAppId});
                h.mEJ.k(14838, r0);
            }
        }
    }
}
