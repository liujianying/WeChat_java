package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Message;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class f {
    private static volatile f daS = null;
    private static boolean daV = false;
    public static boolean daW = false;
    private static boolean daX = false;
    private static boolean daY = false;
    private static int dbe = 0;
    private static int dbf = 0;
    private static HashMap<Integer, String> dbg = new HashMap();
    private static int dbh = 0;
    private static int dbi = 0;
    private static HashMap<Integer, String> dbj = new HashMap();
    private static int dbk = 0;
    private static int dbl = 0;
    private static HashMap<Integer, String> dbm = new HashMap();
    public final AudioManager daT;
    private int daU = -1;
    private int daZ = 0;
    private final Set<a> dba = new HashSet();
    private final int dbb = 1000;
    private ag dbc = new ag() {
        public final void handleMessage(Message message) {
            x.i("MicroMsg.MMAudioManager", "dkbt post delay BLUETOOTH_DEVICE_CONNECTED ");
            f.this.fC(3);
        }
    };
    private int dbd = -1;

    public interface a {
        void ew(int i);
    }

    public static f yz() {
        if (daS == null) {
            synchronized (f.class) {
                if (daS == null) {
                    daS = new f(ad.getContext());
                }
            }
        }
        return daS;
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.dba.add(aVar);
        }
    }

    public final void b(a aVar) {
        if (aVar != null) {
            this.dba.remove(aVar);
        }
    }

    public final void fC(int i) {
        x.i("MicroMsg.MMAudioManager", "notify, new status: %d, current status: %d", Integer.valueOf(i), Integer.valueOf(this.daU));
        for (a ew : this.dba) {
            ew.ew(i);
        }
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public f(Context context) {
        this.daT = (AudioManager) context.getSystemService("audio");
        x.i("MicroMsg.MMAudioManager", "init dkbt %s", yI());
        context.registerReceiver(new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                x.i("MicroMsg.MMAudioManager", "leonl onReceive action[ ACTION_AUDIO_BECOMING_NOISY ] ");
                f.this.fC(7);
            }
        }, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
        context.registerReceiver(new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                int intExtra = intent.getIntExtra("state", -1);
                int intExtra2 = intent.getIntExtra("microphone", -1);
                x.i("MicroMsg.MMAudioManager", "leonl onReceive action[ HEADSET_PLUG ] state = %s,mic = %s", Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
                if (intExtra == 0) {
                    f.this.fC(6);
                } else if (intExtra == 1) {
                    f.this.yC();
                }
            }
        }, new IntentFilter("android.intent.action.HEADSET_PLUG"));
        context.registerReceiver(new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    String action = intent.getAction();
                    f.daX = intent.getBooleanExtra("existing", false);
                    x.i("MicroMsg.MMAudioManager", "dkbt onReceive action[" + action + "] existing:" + f.daX);
                }
            }
        }, new IntentFilter("com.htc.accessory.action.CONNECTION_EXISTING"));
        context.registerReceiver(new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                x.i("MicroMsg.MMAudioManager", "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_CONNECTED ] ");
                if (d.fS(11)) {
                    f.daV = true;
                    f.this.dbc.sendEmptyMessageDelayed(0, 1000);
                }
            }
        }, new IntentFilter("android.bluetooth.device.action.ACL_CONNECTED"));
        context.registerReceiver(new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                x.i("MicroMsg.MMAudioManager", "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_DISCONNECTED ] ");
                f.daV = false;
                if (q.deW.ddv == 1) {
                    com.tencent.mm.compatible.c.a.a(f.this.daT);
                }
                f.this.fC(4);
            }
        }, new IntentFilter("android.bluetooth.device.action.ACL_DISCONNECTED"));
        if (d.fR(11)) {
            context.registerReceiver(new BroadcastReceiver() {
                public final void onReceive(Context context, Intent intent) {
                    if (intent != null) {
                        String action = intent.getAction();
                        int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                        x.i("MicroMsg.MMAudioManager", "dkbt onReceive action[" + action + "] state:" + intExtra);
                        if (intExtra == 2) {
                            f.daV = true;
                            f.this.dbc.sendEmptyMessageDelayed(0, 1000);
                        } else if (intExtra == 0) {
                            f.daV = false;
                            if (q.deW.ddv == 1) {
                                com.tencent.mm.compatible.c.a.a(f.this.daT);
                            }
                            f.this.fC(4);
                        }
                    }
                }
            }, new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"));
        }
        context.registerReceiver(new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
                    int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 10);
                    x.i("MicroMsg.MMAudioManager", "onReceive bluetooth state changed: %s, prevState: %s", Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
                    if (intExtra == 10) {
                        f.daV = false;
                        f.daW = false;
                        if (q.deW.ddv == 1) {
                            com.tencent.mm.compatible.c.a.a(f.this.daT);
                        }
                        f.this.fC(4);
                    }
                }
            }
        }, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
    }

    public final void yA() {
        x.i("MicroMsg.MMAudioManager", "dkbt bluetoothStopped %s", yI());
        daW = false;
        fC(2);
    }

    public final int yB() {
        this.daU = -1;
        if (!yH()) {
            return -1;
        }
        boolean z;
        x.l("MicroMsg.MMAudioManager", "dkbt begin tryStartBluetooth %s", yI());
        AudioManager audioManager = this.daT;
        if (!audioManager.isBluetoothScoAvailableOffCall()) {
            z = false;
        } else if (ar.vZ()) {
            z = false;
        } else {
            x.i("MicroMsg.BluetoothUtil", "start DeviceInfo mCommonInfo getStartBluetoothSco:%s ", Integer.valueOf(q.deW.ddx));
            if ((q.deW.ddx == 1 || q.deW.ddx == -1) && !audioManager.isBluetoothScoOn()) {
                x.i("MicroMsg.BluetoothUtil", "BluetoothUtil am.isBluetoothScoOn is false and startBluetoothSco, stack: %s", bi.cjd());
                audioManager.startBluetoothSco();
            }
            z = true;
        }
        x.i("MicroMsg.MMAudioManager", "dkbt end tryStartBluetooth %s ret:%s", yI(), Boolean.valueOf(z));
        x.d("MicroMsg.MMAudioManager", "dkbt  tryStartBluetooth " + yI() + " ret:" + z);
        x.i("MicroMsg.MMAudioManager", "alvinluo isBluetoothOn: %b", Boolean.valueOf(yE()));
        if (yE()) {
            return 1;
        }
        return 0;
    }

    public final void yC() {
        daW = false;
        x.l("MicroMsg.MMAudioManager", "dkbt begin stopBluetooth %s", yI());
        com.tencent.mm.compatible.c.a.a(this.daT);
        this.dbc.removeCallbacksAndMessages(Integer.valueOf(1));
        x.i("MicroMsg.MMAudioManager", "dkbt end stopBluetooth %s", yI());
    }

    public static boolean yD() {
        return false;
    }

    public final boolean yE() {
        x.i("MicroMsg.MMAudioManager", "isBluetoothScoOn: %s isBluetoothA2dpOn: %s, isScoConnected: %s, isBluetoothCanUse: %s, isACLConnected: %s", Boolean.valueOf(this.daT.isBluetoothScoOn()), Boolean.valueOf(this.daT.isBluetoothA2dpOn()), Boolean.valueOf(daW), Boolean.valueOf(yH()), Boolean.valueOf(daV));
        if (this.daT.isBluetoothScoOn() || this.daT.isBluetoothA2dpOn() || daW) {
            return true;
        }
        return false;
    }

    @TargetApi(14)
    private static boolean yF() {
        try {
            if (VERSION.SDK_INT >= 14) {
                x.i("MicroMsg.MMAudioManager", "isConnectHeadset getProfileConnectionState: %s", Integer.valueOf(BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1)));
                if (BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1) == 2) {
                    return true;
                }
                return false;
            } else if (daV) {
                return true;
            } else {
                if (q.deW.ddG == 1) {
                    return BluetoothAdapter.getDefaultAdapter().isEnabled();
                }
                return false;
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMAudioManager", "dkbt exception in isConnectDevice()");
        }
    }

    public final int aX(boolean z) {
        int i;
        if (z) {
            i = 3;
        } else {
            i = 0;
        }
        return yE() ? 0 : i;
    }

    public static int yG() {
        ((AudioManager) ad.getContext().getSystemService("audio")).isBluetoothScoOn();
        return 0;
    }

    public static boolean yH() {
        x.d("MicroMsg.MMAudioManager", "dkbt isBluetoothCanUse existing:" + daX + " , isUseHTCAccessory = " + daY);
        if (daX && !daY) {
            return false;
        }
        x.d("MicroMsg.MMAudioManager", "dkbt isACLConnected:" + daV);
        if (yF()) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                x.d("MicroMsg.MMAudioManager", "dkbt BluetoothAdapter.getDefaultAdapter() == null");
                return false;
            } else if (defaultAdapter.isEnabled()) {
                Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
                if (bondedDevices == null || bondedDevices.size() == 0) {
                    x.e("MicroMsg.MMAudioManager", "dkbt setDev == null || setDev.size() == 0");
                    return false;
                }
                boolean z;
                for (BluetoothDevice bondState : bondedDevices) {
                    if (bondState.getBondState() == 12) {
                        z = true;
                        break;
                    }
                }
                z = false;
                if (z) {
                    x.i("MicroMsg.MMAudioManager", "alvinluo isBluetoothCanUse: %b", Boolean.valueOf(true));
                    return true;
                }
                x.i("MicroMsg.MMAudioManager", "dkbt hasBond == false");
                return false;
            } else {
                x.i("MicroMsg.MMAudioManager", "dkbt !adp.isEnabled()");
                return false;
            }
        }
        x.i("MicroMsg.MMAudioManager", "dkbt isACLConnected =  " + daV + " , isConnectHeadset() = " + yF());
        return false;
    }

    public final String yI() {
        return "mode:" + (this.daT != null ? this.daT.getMode() : 0) + " isSpeakerphoneOn:" + this.daT.isSpeakerphoneOn() + " isBluetoothOn:" + yE() + " btStatus:" + this.daU;
    }

    public final boolean yJ() {
        return this.daT.getMode() == 0;
    }

    @TargetApi(11)
    public final boolean e(boolean z, boolean z2, boolean z3) {
        boolean z4 = true;
        int i = 0;
        int mode = this.daT.getMode();
        x.i("MicroMsg.MMAudioManager", "dkbt shiftSpeaker:%b -> %b  %s", Boolean.valueOf(yJ()), Boolean.valueOf(z), yI());
        if (ar.vZ()) {
            x.v("MicroMsg.MMAudioManager", "shiftSpeaker return when calling Mode:%d blue:%d", Integer.valueOf(mode), Integer.valueOf(this.daU));
            return false;
        } else if (z3 || !(yE() || daW)) {
            yN();
            if (z2) {
                if (q.deN.dby) {
                    if (q.deN.yV()) {
                        if (q.deN.dbA >= 0) {
                            setMode(q.deN.dbA);
                        } else if (q.deN.dbB >= 0) {
                            if (z) {
                                setMode(0);
                            } else {
                                setMode(2);
                            }
                        }
                        if (q.deN.dbC <= 0) {
                            return z;
                        }
                        setSpeakerphoneOn(z);
                        return z;
                    } else if (q.deN.yW()) {
                        if (z) {
                            if (q.deN.yZ()) {
                                setSpeakerphoneOn(true);
                            }
                            if (q.deN.yY() < 0) {
                                return z;
                            }
                            setMode(q.deN.yY());
                            return z;
                        }
                        if (q.deN.zb()) {
                            setSpeakerphoneOn(false);
                        }
                        if (q.deN.za() < 0) {
                            return z;
                        }
                        setMode(q.deN.za());
                        return z;
                    }
                }
            } else if (q.deN.dby && q.deN.yX()) {
                b bVar;
                if (z) {
                    boolean z5;
                    bVar = q.deN;
                    if (bVar.yX()) {
                        mode = bVar.dbE & 16;
                        x.d("VoipAudioInfo", "enableSpeaker " + (mode > 0));
                        if (mode > 0) {
                            z5 = true;
                        }
                    }
                    if (z5) {
                        setSpeakerphoneOn(true);
                    }
                    if (q.deN.zc() < 0) {
                        return z;
                    }
                    setMode(q.deN.zc());
                    return z;
                }
                bVar = q.deN;
                if (bVar.yX()) {
                    mode = bVar.dbE & 1;
                    x.d("VoipAudioInfo", "disableSpeaker " + (mode > 0));
                    if (mode <= 0) {
                        z4 = false;
                    }
                } else {
                    z4 = false;
                }
                if (z4) {
                    setSpeakerphoneOn(false);
                }
                if (q.deN.zd() < 0) {
                    return z;
                }
                setMode(q.deN.zd());
                return z;
            }
            if (!z2) {
                setSpeakerphoneOn(z);
                if (yJ() == z) {
                    return z;
                }
                if (z) {
                    setMode(0);
                    return z;
                } else if (VERSION.SDK_INT >= 11 && l.xZ() && 2 != q.deW.ddH) {
                    setMode(3);
                    return z;
                } else if (VERSION.SDK_INT >= 11) {
                    setMode(3);
                    return z;
                } else {
                    setMode(2);
                    return z;
                }
            } else if (z) {
                if (VERSION.SDK_INT >= 11) {
                    i = 3;
                }
                if (q.deN.dbY >= 0) {
                    i = q.deN.dbY;
                }
                x.d("MicroMsg.MMAudioManager", "voip doShiftSpeaker useSpeakerMode:" + i);
                if (i != this.daT.getMode()) {
                    setMode(i);
                }
                if (i != this.daT.getMode()) {
                    if (this.daZ == 0) {
                        this.daZ = 1;
                    } else if (this.daZ == 2) {
                        this.daZ = 3;
                    }
                }
                if (this.daT.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(true);
                return z;
            } else {
                if (VERSION.SDK_INT >= 11) {
                    mode = 3;
                } else if (q.deW.ddG == 1) {
                    x.d("MicroMsg.MMAudioManager", "doShiftSpeaker htc usePhoneMode : 0");
                    mode = 0;
                } else {
                    mode = 2;
                }
                if (VERSION.SDK_INT >= 11 && l.xZ() && 2 == q.deW.ddH) {
                    mode = 2;
                }
                if (q.deN.dbZ >= 0) {
                    mode = q.deN.dbZ;
                }
                x.d("MicroMsg.MMAudioManager", "voip doShiftSpeaker usePhoneMode:" + mode);
                if (mode != this.daT.getMode()) {
                    setMode(mode);
                }
                if (mode != this.daT.getMode()) {
                    if (this.daZ == 0) {
                        this.daZ = 2;
                    } else if (this.daZ == 1) {
                        this.daZ = 3;
                    }
                }
                if (!this.daT.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(false);
                return z;
            }
        } else {
            x.i("MicroMsg.MMAudioManager", "dkbt shiftSpeaker isBluetoothOn");
            if (z2) {
                x.d("MicroMsg.MMAudioManager", "Bluetooth is on and now is in VoIP , set 3 MODE_IN_COMMUNICATION..");
                setMode(3);
            } else {
                setMode(0);
            }
            return false;
        }
    }

    @TargetApi(11)
    public final boolean aY(boolean z) {
        int i = 3;
        int i2 = 0;
        x.d("MicroMsg.MMAudioManager", "IPCall dkbt shiftSpeaker:%b -> %b  %s", Boolean.valueOf(yJ()), Boolean.valueOf(z), yI());
        if (ar.vZ()) {
            x.v("MicroMsg.MMAudioManager", "shiftSpeaker return when calling blue:%d", Integer.valueOf(this.daU));
            return false;
        } else if (daW) {
            setMode(3);
            return false;
        } else {
            yN();
            if (!q.deN.dcx) {
                if (q.deN.dby) {
                    if (q.deN.yV()) {
                        if (q.deN.dbA >= 0) {
                            setMode(q.deN.dbA);
                        } else if (q.deN.dbB >= 0) {
                            if (z) {
                                setMode(0);
                            } else {
                                setMode(2);
                            }
                        }
                        if (q.deN.dbC <= 0) {
                            return z;
                        }
                        setSpeakerphoneOn(z);
                        return z;
                    } else if (q.deN.yW()) {
                        if (z) {
                            if (q.deN.yZ()) {
                                setSpeakerphoneOn(true);
                            }
                            if (q.deN.yY() < 0) {
                                return z;
                            }
                            setMode(q.deN.yY());
                            return z;
                        }
                        if (q.deN.zb()) {
                            setSpeakerphoneOn(false);
                        }
                        if (q.deN.za() < 0) {
                            return z;
                        }
                        setMode(q.deN.za());
                        return z;
                    }
                }
                if (z) {
                    if (VERSION.SDK_INT >= 11) {
                        i2 = 3;
                    }
                    if (q.deN.dbY >= 0) {
                        i2 = q.deN.dbY;
                    }
                    x.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker useSpeakerMode:" + i2);
                    if (i2 != this.daT.getMode()) {
                        setMode(i2);
                    }
                    if (this.daT.isSpeakerphoneOn()) {
                        return z;
                    }
                    setSpeakerphoneOn(true);
                    return z;
                }
                if (VERSION.SDK_INT < 11) {
                    if (q.deW.ddG == 1) {
                        x.d("MicroMsg.MMAudioManager", "doShiftSpeaker htc usePhoneMode : 0");
                        i = 0;
                    } else {
                        i = 2;
                    }
                }
                if (VERSION.SDK_INT >= 11 && l.xZ() && 2 == q.deW.ddH) {
                    i = 2;
                }
                if (q.deN.dbZ >= 0) {
                    i = q.deN.dbZ;
                }
                x.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker usePhoneMode:" + i);
                if (i != this.daT.getMode()) {
                    setMode(i);
                }
                if (!this.daT.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(false);
                return z;
            } else if (z) {
                if (VERSION.SDK_INT >= 11) {
                    i2 = 3;
                }
                if (q.deN.dcy >= 0) {
                    i2 = q.deN.dcy;
                }
                x.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker useSpeakerMode:" + i2);
                if (i2 != this.daT.getMode()) {
                    setMode(i2);
                }
                if (this.daT.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(true);
                return z;
            } else {
                if (VERSION.SDK_INT < 11) {
                    if (q.deW.ddG == 1) {
                        x.d("MicroMsg.MMAudioManager", "doShiftSpeaker htc usePhoneMode : 0");
                        i = 0;
                    } else {
                        i = 2;
                    }
                }
                if (q.deN.dcz >= 0) {
                    i = q.deN.dcz;
                }
                x.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker usePhoneMode:" + i);
                if (i != this.daT.getMode()) {
                    setMode(i);
                }
                if (!this.daT.isSpeakerphoneOn()) {
                    return z;
                }
                setSpeakerphoneOn(false);
                return z;
            }
        }
    }

    public final boolean b(boolean z, int i, boolean z2) {
        int streamMaxVolume = this.daT.getStreamMaxVolume(i);
        x.d("MicroMsg.MMAudioManager", "maxVolumn:" + streamMaxVolume);
        streamMaxVolume /= 3;
        int streamVolume = this.daT.getStreamVolume(i);
        if (streamVolume < streamMaxVolume) {
            this.daT.setStreamVolume(i, streamMaxVolume, 0);
        }
        x.i("MicroMsg.MMAudioManager", "StreamType:" + i + "  current:" + streamVolume);
        return e(z, true, z2);
    }

    public final boolean yK() {
        if (this.daT != null) {
            return this.daT.isWiredHeadsetOn();
        }
        return false;
    }

    public final void fD(int i) {
        if (this.daT != null) {
            this.daT.adjustStreamVolume(i, 1, 5);
        }
    }

    public final void fE(int i) {
        if (this.daT != null) {
            this.daT.adjustStreamVolume(i, -1, 5);
        }
    }

    public final void yL() {
        if (this.daT != null) {
            this.daT.setStreamMute(3, true);
        }
    }

    public final void yM() {
        if (this.daT != null) {
            this.daT.setStreamMute(3, false);
        }
    }

    private void yN() {
        if (this.daT != null) {
            int mode = this.daT.getMode();
            boolean isSpeakerphoneOn = this.daT.isSpeakerphoneOn();
            Object fM = com.tencent.mm.compatible.e.l.zh().fM(98305);
            Object fM2 = com.tencent.mm.compatible.e.l.zh().fM(94209);
            if (fM == null) {
                com.tencent.mm.compatible.e.l.zh().set(98305, Boolean.valueOf(isSpeakerphoneOn));
                x.d("MicroMsg.MMAudioManager", "storeAudioConfig spearkeron " + isSpeakerphoneOn);
            }
            if (fM2 == null) {
                com.tencent.mm.compatible.e.l.zh().set(94209, Integer.valueOf(mode));
                x.d("MicroMsg.MMAudioManager", "storeAudioConfig inmode " + mode);
            }
        }
    }

    @Deprecated
    public final void yO() {
        if (this.daT != null) {
            Object fM = com.tencent.mm.compatible.e.l.zh().fM(98305);
            Object fM2 = com.tencent.mm.compatible.e.l.zh().fM(94209);
            if (fM != null) {
                x.d("MicroMsg.MMAudioManager", "resumeAudioConfig spearkeron: " + fM);
                setSpeakerphoneOn(((Boolean) fM).booleanValue());
                com.tencent.mm.compatible.e.l.zh().set(98305, null);
            }
            if (fM2 != null) {
                int i;
                try {
                    x.i("MicroMsg.MMAudioManager", "resumeAudioConfig oinmode: " + fM2 + ",inmode:0");
                    i = bi.getInt(String.valueOf(fM2), 0);
                } catch (Exception e) {
                    i = 0;
                }
                if (i < -1 || i >= 4) {
                    setMode(0);
                } else {
                    setMode(i);
                }
                com.tencent.mm.compatible.e.l.zh().set(94209, null);
            }
        }
    }

    public final void setMode(int i) {
        if (this.daT != null) {
            x.i("MicroMsg.MMAudioManager", "set mode from %d to %d", Integer.valueOf(this.daT.getMode()), Integer.valueOf(i));
            this.daT.setMode(i);
        }
    }

    public final void setSpeakerphoneOn(boolean z) {
        x.l("MicroMsg.MMAudioManager", "setSpeakerphoneOn, on: " + z, new Object[0]);
        if (this.daT != null) {
            x.i("MicroMsg.MMAudioManager", "setSpeakerphoneOn on: " + z);
            this.daT.setSpeakerphoneOn(z);
        }
    }

    public final int yP() {
        int i = this.daZ;
        this.daZ = 0;
        return i;
    }

    public final int getStreamMaxVolume(int i) {
        if (this.daT != null) {
            return this.daT.getStreamMaxVolume(i);
        }
        return 5;
    }

    public final int getStreamVolume(int i) {
        if (this.daT != null) {
            return this.daT.getStreamVolume(i);
        }
        return -1;
    }

    public final void aP(int i, int i2) {
        if (this.daT != null) {
            x.i("MicroMsg.MMAudioManager", "setStreamVolume streamType:%s,index:%s,flags:%s ", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0));
            this.daT.setStreamVolume(i, i2, 0);
        }
    }

    public final int yQ() {
        if (this.dbd == -1) {
            try {
                Field field = Class.forName("android.media.AudioManager").getField("STREAM_BLUETOOTH_SCO");
                if (!(field == null || this.daT == null)) {
                    this.dbd = field.getInt(this.daT);
                }
            } catch (Exception e) {
                x.e("MicroMsg.MMAudioManager", "ClassNotFoundException  android.media.AudioManager,exception:" + e.getMessage());
                this.dbd = 6;
            }
        }
        return this.dbd;
    }

    public static void fF(int i) {
        dbe++;
        x.e("MicroMsg.MMAudioManager", "mm audio track init [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(dbe), Integer.valueOf(dbf));
        dbg.put(Integer.valueOf(i), bi.cjd().toString());
        yR();
    }

    public static void fG(int i) {
        dbf++;
        x.e("MicroMsg.MMAudioManager", "mm audio track release [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(dbe), Integer.valueOf(dbf));
        dbg.remove(Integer.valueOf(i));
    }

    public static void fH(int i) {
        dbh++;
        x.l("MicroMsg.MMAudioManager", "mm audio record init [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(dbh), Integer.valueOf(dbi));
        dbj.put(Integer.valueOf(i), bi.cjd().toString());
        yR();
    }

    public static void fI(int i) {
        if (dbj.containsKey(Integer.valueOf(i))) {
            dbi++;
            x.l("MicroMsg.MMAudioManager", "mm audio record release [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(dbh), Integer.valueOf(dbi));
            dbj.remove(Integer.valueOf(i));
        }
    }

    public static void fJ(int i) {
        dbk++;
        x.e("MicroMsg.MMAudioManager", "mm media player init [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(dbk), Integer.valueOf(dbl));
        dbm.put(Integer.valueOf(i), bi.cjd().toString());
        yR();
    }

    public static void fK(int i) {
        dbl++;
        x.e("MicroMsg.MMAudioManager", "mm media player release [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(dbk), Integer.valueOf(dbl));
        dbm.remove(Integer.valueOf(i));
    }

    private static void yR() {
        com.tencent.mm.sdk.b.b jlVar = new jl();
        if (dbe - dbf > 1) {
            jlVar.bTa.bTb = true;
            jlVar.bTa.bTc = dbg.size();
        }
        if (dbk - dbl > 1) {
            jlVar.bTa.bTd = true;
            jlVar.bTa.bTe = dbm.size();
        }
        if (dbh - dbi > 1) {
            jlVar.bTa.bTf = true;
            jlVar.bTa.bTg = dbj.size();
        }
        if (jlVar.bTa.bTd || jlVar.bTa.bTb || jlVar.bTa.bTf) {
            x.e("MicroMsg.MMAudioManager", "check media leak audio[%b %d] mediaplayer[%b %d] audioRecordLeak [%b %d]", Boolean.valueOf(jlVar.bTa.bTb), Integer.valueOf(jlVar.bTa.bTc), Boolean.valueOf(jlVar.bTa.bTd), Integer.valueOf(jlVar.bTa.bTe), Boolean.valueOf(jlVar.bTa.bTf), Integer.valueOf(jlVar.bTa.bTg));
            com.tencent.mm.sdk.b.a.sFg.m(jlVar);
        }
    }

    public static String yS() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AudioTrack: \r\n");
        stringBuffer.append("leak: ").append(dbg.size()).append("init: ").append(dbe).append("release: ").append(dbf).append("\r\n");
        stringBuffer.append("--------leak map-----------\r\n");
        if (!dbg.isEmpty()) {
            for (String append : dbg.values()) {
                stringBuffer.append(append).append("\r\n");
            }
        }
        stringBuffer.append("MediaPlayer: \r\n");
        stringBuffer.append("leak: ").append(dbm.size()).append("init: ").append(dbk).append("release: ").append(dbl).append("\r\n");
        stringBuffer.append("--------leak map-----------\r\n");
        if (!dbm.isEmpty()) {
            for (String append2 : dbm.values()) {
                stringBuffer.append(append2).append("\r\n");
            }
        }
        stringBuffer.append("AudioRecord: \r\n");
        stringBuffer.append("leak: ").append(dbj.size()).append("init: ").append(dbh).append("release: ").append(dbh).append("\r\n");
        stringBuffer.append("--------leak map-----------\r\n");
        if (!dbj.isEmpty()) {
            for (String append22 : dbj.values()) {
                stringBuffer.append(append22).append("\r\n");
            }
        }
        x.e("MicroMsg.MMAudioManager", "leak? %s", stringBuffer.toString());
        return stringBuffer.toString();
    }
}
