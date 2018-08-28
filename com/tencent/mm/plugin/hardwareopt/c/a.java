package com.tencent.mm.plugin.hardwareopt.c;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.compatible.e.n;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.n.b;
import com.tencent.mm.protocal.c.amg;
import com.tencent.mm.protocal.c.atk;
import com.tencent.mm.protocal.c.atq;
import com.tencent.mm.protocal.c.bip;
import com.tencent.mm.protocal.c.brf;
import com.tencent.mm.protocal.c.fj;
import com.tencent.mm.protocal.c.kk;
import com.tencent.mm.protocal.c.po;
import com.tencent.mm.protocal.c.xd;
import com.tencent.mm.protocal.c.xu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a implements com.tencent.mm.vending.c.a<amg, Context> {
    private Context mContext = null;

    private amg dH(Context context) {
        Throwable e;
        ActivityManager activityManager;
        MemoryInfo memoryInfo;
        atk atk;
        ConfigurationInfo deviceConfigurationInfo;
        xu xuVar;
        boolean z;
        Display defaultDisplay;
        Point point;
        int i;
        int i2;
        bip bip;
        po poVar;
        String str;
        String str2;
        Object[] objArr;
        xd xdVar;
        amg aVT;
        this.mContext = context;
        long nanoTime = System.nanoTime();
        try {
            fj fjVar = new fj();
            fjVar.imei = bi.fP(this.mContext);
            if (bi.oW(fjVar.imei)) {
                x.w("MicroMsg.TaskFindHardwareInfo", "hy: not got imei. maybe no permission");
                throw new a();
            }
            StatFs statFs;
            brf brf;
            fjVar.rgo = Build.MANUFACTURER;
            fjVar.rgp = Build.MODEL;
            fjVar.rgq = VERSION.INCREMENTAL;
            com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT().rOP = fjVar;
            x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: imei: %s, manufacrtureName: %s, modelName: %s, incremental: %s", new Object[]{fjVar.imei, fjVar.rgo, fjVar.rgp, fjVar.rgq});
            kk kkVar = new kk();
            kkVar.rmF = Build.CPU_ABI;
            Map zn = n.zn();
            kkVar.rmD = bi.aG((String) zn.get("Processor"), "");
            kkVar.rgp = (String) zn.get("model name");
            kkVar.rmG = (String) zn.get("Hardware");
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq", "r");
                try {
                    kkVar.rmE = bi.getInt(randomAccessFile.readLine(), -1) / 1000;
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e2, "hy: error when close read cpu files", new Object[0]);
                    }
                } catch (IOException e3) {
                    e2 = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e2, "hy: error when reading cpu frequency", new Object[0]);
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e22) {
                                x.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e22, "hy: error when close read cpu files", new Object[0]);
                            }
                        }
                        com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT().rOQ = kkVar;
                        x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: abi: %s, cpuModel: %s, cpuClockSpeedInHz: %d, modelName: %s, platform: %s", new Object[]{kkVar.rmF, kkVar.rmD, Integer.valueOf(kkVar.rmE), kkVar.rgp, kkVar.rmG});
                        activityManager = (ActivityManager) this.mContext.getSystemService("activity");
                        memoryInfo = new MemoryInfo();
                        activityManager.getMemoryInfo(memoryInfo);
                        atk = new atk();
                        atk.rWK = (int) ((memoryInfo.totalMem / 1024) / 1024);
                        atk.rWL = (int) ((memoryInfo.threshold / 1024) / 1024);
                        atk.rWM = ((ActivityManager) this.mContext.getSystemService("activity")).getLargeMemoryClass();
                        atk.rWN = ((ActivityManager) this.mContext.getSystemService("activity")).getMemoryClass();
                        com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT().rOR = atk;
                        x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalMemInMB: %d, thresholdInMB: %d, large memory class; %d, memory class: %d", new Object[]{Integer.valueOf(atk.rWK), Integer.valueOf(atk.rWL), Integer.valueOf(atk.rWM), Integer.valueOf(atk.rWN)});
                        statFs = new StatFs(e.bnC);
                        brf = new brf();
                        if (VERSION.SDK_INT >= 18) {
                            brf.sps = (int) ((statFs.getTotalBytes() / 1024) / 1024);
                        } else {
                            brf.sps = (int) (((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1024) / 1024);
                        }
                        brf.spt = Environment.getExternalStorageState().equals("mounted");
                        com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT().rOS = brf;
                        x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalStorageInMB: %d, hasExternalStorage: %b", new Object[]{Integer.valueOf(brf.sps), Boolean.valueOf(brf.spt)});
                        deviceConfigurationInfo = ((ActivityManager) this.mContext.getSystemService("activity")).getDeviceConfigurationInfo();
                        xuVar = new xu();
                        if (deviceConfigurationInfo.reqGlEsVersion >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                            z = true;
                        } else {
                            z = false;
                        }
                        xuVar.rDB = z;
                        xuVar.rDC = deviceConfigurationInfo.reqGlEsVersion >= 196608;
                        xuVar.rDD = ((b) g.l(b.class)).isSupportVulkan();
                        com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT().rOW = xuVar;
                        x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: hasOpenGL20: %b, hasOpenGL30: %b, esversion: %s, isSupportVulkan: %b", new Object[]{Boolean.valueOf(xuVar.rDB), Boolean.valueOf(xuVar.rDC), Integer.valueOf(deviceConfigurationInfo.reqGlEsVersion), Boolean.valueOf(xuVar.rDD)});
                        defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
                        point = new Point();
                        defaultDisplay.getSize(point);
                        i = point.x;
                        i2 = point.y;
                        bip = new bip();
                        bip.sje = String.valueOf(i) + "x" + i2;
                        bip.density = (int) this.mContext.getResources().getDisplayMetrics().density;
                        com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT().rOT = bip;
                        x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: resolution: %s, ppi: %d", new Object[]{bip.sje, Integer.valueOf(bip.density)});
                        poVar = new po();
                        poVar.rtO = EE("video/avc");
                        poVar.rtP = EE("video/hevc");
                        poVar.rtQ = aVU();
                        com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT().rOU = poVar;
                        str = "MicroMsg.TaskFindHardwareInfo";
                        str2 = "hy: hardwareinfo: default codec name avc: %s, default hevc names: %s, codec number: %d";
                        objArr = new Object[3];
                        objArr[0] = poVar.rtO;
                        objArr[1] = poVar.rtP;
                        if (poVar.rtQ != null) {
                            i = poVar.rtQ.size();
                        } else {
                            i = 0;
                        }
                        objArr[2] = Integer.valueOf(i);
                        x.d(str, str2, objArr);
                        xdVar = new xd();
                        xdVar.rCL = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
                        if (VERSION.SDK_INT >= 18) {
                            xdVar.rCM = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
                        } else {
                            xdVar.rCM = false;
                        }
                        xdVar.rCN = this.mContext.getPackageManager().hasSystemFeature("android.hardware.location.gps");
                        xdVar.rCO = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
                        xdVar.rCP = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.front");
                        xdVar.rCQ = this.mContext.getPackageManager().hasSystemFeature("android.hardware.microphone");
                        xdVar.rCR = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
                        if (VERSION.SDK_INT >= 19) {
                            xdVar.rDc = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc.hce");
                        } else {
                            xdVar.rDc = false;
                        }
                        xdVar.rCS = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
                        if (VERSION.SDK_INT < 23) {
                            xdVar.rCT = this.mContext.getPackageManager().hasSystemFeature("android.hardware.fingerprint");
                        } else if (q.deQ.deZ == 1) {
                            xdVar.rCT = true;
                        } else {
                            xdVar.rCT = false;
                        }
                        xdVar.rCU = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.cdma");
                        xdVar.rCV = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.gsm");
                        xdVar.rCW = this.mContext.getPackageManager().hasSystemFeature("android.software.sip");
                        xdVar.rCX = this.mContext.getPackageManager().hasSystemFeature("android.software.sip.voip");
                        if (VERSION.SDK_INT >= 19) {
                            xdVar.rCY = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
                        } else {
                            xdVar.rCY = false;
                        }
                        if (VERSION.SDK_INT >= 19) {
                            xdVar.rCZ = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
                        } else {
                            xdVar.rCZ = false;
                        }
                        xdVar.rDa = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.accelerometer");
                        xdVar.rDb = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.light");
                        com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT().rOV = xdVar;
                        x.d("MicroMsg.TaskFindHardwareInfo", "hy: hy: hardwareinfo: hasBluetooth: %b, hasBluetoothLE: %b, hasGPS: %b, hasCameraFlash: %b, hasCameraFront: %b, hasMic: %b, hasNFC: %b, hasNfcHce: %b, hasHifiSensor: %b, hasFingerprintSensor: %b, hasCDMA: %b, hasGSM: %b, hasSIP: %b, hasSIPBasedVoIP: %b, hasStepDitector: %b , hasStepCounter: %b, hasAcceloratorSensor: %b, hasLightSensor: %b", new Object[]{Boolean.valueOf(xdVar.rCL), Boolean.valueOf(xdVar.rCM), Boolean.valueOf(xdVar.rCN), Boolean.valueOf(xdVar.rCO), Boolean.valueOf(xdVar.rCP), Boolean.valueOf(xdVar.rCQ), Boolean.valueOf(xdVar.rCR), Boolean.valueOf(xdVar.rDc), Boolean.valueOf(xdVar.rCS), Boolean.valueOf(xdVar.rCT), Boolean.valueOf(xdVar.rCU), Boolean.valueOf(xdVar.rCV), Boolean.valueOf(xdVar.rCW), Boolean.valueOf(xdVar.rCX), Boolean.valueOf(xdVar.rCY), Boolean.valueOf(xdVar.rCZ), Boolean.valueOf(xdVar.rDa), Boolean.valueOf(xdVar.rDb)});
                        x.i("MicroMsg.TaskFindHardwareInfo", "hy: calc hardware using: %d ms", new Object[]{Long.valueOf(((System.nanoTime() - nanoTime) / 1000) / 1000)});
                        aVT = com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT();
                        if (aVT != null) {
                            if (aVT.rOQ != null) {
                                g.Ei().DT().a(com.tencent.mm.storage.aa.a.sZy, Integer.valueOf(aVT.rOQ.rmE));
                            }
                            if (aVT.rOR != null) {
                                g.Ei().DT().a(com.tencent.mm.storage.aa.a.sZz, Integer.valueOf(aVT.rOR.rWK));
                            }
                        }
                        return com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT();
                    } catch (Throwable th) {
                        e22 = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e4) {
                                x.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e4, "hy: error when close read cpu files", new Object[0]);
                            }
                        }
                        throw e22;
                    }
                }
            } catch (IOException e5) {
                e22 = e5;
                randomAccessFile = null;
                x.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e22, "hy: error when reading cpu frequency", new Object[0]);
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e222) {
                        x.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e222, "hy: error when close read cpu files", new Object[0]);
                    }
                }
                com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT().rOQ = kkVar;
                x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: abi: %s, cpuModel: %s, cpuClockSpeedInHz: %d, modelName: %s, platform: %s", new Object[]{kkVar.rmF, kkVar.rmD, Integer.valueOf(kkVar.rmE), kkVar.rgp, kkVar.rmG});
                activityManager = (ActivityManager) this.mContext.getSystemService("activity");
                memoryInfo = new MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                atk = new atk();
                atk.rWK = (int) ((memoryInfo.totalMem / 1024) / 1024);
                atk.rWL = (int) ((memoryInfo.threshold / 1024) / 1024);
                atk.rWM = ((ActivityManager) this.mContext.getSystemService("activity")).getLargeMemoryClass();
                atk.rWN = ((ActivityManager) this.mContext.getSystemService("activity")).getMemoryClass();
                com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT().rOR = atk;
                x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalMemInMB: %d, thresholdInMB: %d, large memory class; %d, memory class: %d", new Object[]{Integer.valueOf(atk.rWK), Integer.valueOf(atk.rWL), Integer.valueOf(atk.rWM), Integer.valueOf(atk.rWN)});
                statFs = new StatFs(e.bnC);
                brf = new brf();
                if (VERSION.SDK_INT >= 18) {
                    brf.sps = (int) (((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1024) / 1024);
                } else {
                    brf.sps = (int) ((statFs.getTotalBytes() / 1024) / 1024);
                }
                brf.spt = Environment.getExternalStorageState().equals("mounted");
                com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT().rOS = brf;
                x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalStorageInMB: %d, hasExternalStorage: %b", new Object[]{Integer.valueOf(brf.sps), Boolean.valueOf(brf.spt)});
                deviceConfigurationInfo = ((ActivityManager) this.mContext.getSystemService("activity")).getDeviceConfigurationInfo();
                xuVar = new xu();
                if (deviceConfigurationInfo.reqGlEsVersion >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                    z = false;
                } else {
                    z = true;
                }
                xuVar.rDB = z;
                if (deviceConfigurationInfo.reqGlEsVersion >= 196608) {
                }
                xuVar.rDC = deviceConfigurationInfo.reqGlEsVersion >= 196608;
                xuVar.rDD = ((b) g.l(b.class)).isSupportVulkan();
                com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT().rOW = xuVar;
                x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: hasOpenGL20: %b, hasOpenGL30: %b, esversion: %s, isSupportVulkan: %b", new Object[]{Boolean.valueOf(xuVar.rDB), Boolean.valueOf(xuVar.rDC), Integer.valueOf(deviceConfigurationInfo.reqGlEsVersion), Boolean.valueOf(xuVar.rDD)});
                defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
                point = new Point();
                defaultDisplay.getSize(point);
                i = point.x;
                i2 = point.y;
                bip = new bip();
                bip.sje = String.valueOf(i) + "x" + i2;
                bip.density = (int) this.mContext.getResources().getDisplayMetrics().density;
                com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT().rOT = bip;
                x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: resolution: %s, ppi: %d", new Object[]{bip.sje, Integer.valueOf(bip.density)});
                poVar = new po();
                poVar.rtO = EE("video/avc");
                poVar.rtP = EE("video/hevc");
                poVar.rtQ = aVU();
                com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT().rOU = poVar;
                str = "MicroMsg.TaskFindHardwareInfo";
                str2 = "hy: hardwareinfo: default codec name avc: %s, default hevc names: %s, codec number: %d";
                objArr = new Object[3];
                objArr[0] = poVar.rtO;
                objArr[1] = poVar.rtP;
                if (poVar.rtQ != null) {
                    i = 0;
                } else {
                    i = poVar.rtQ.size();
                }
                objArr[2] = Integer.valueOf(i);
                x.d(str, str2, objArr);
                xdVar = new xd();
                xdVar.rCL = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
                if (VERSION.SDK_INT >= 18) {
                    xdVar.rCM = false;
                } else {
                    xdVar.rCM = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
                }
                xdVar.rCN = this.mContext.getPackageManager().hasSystemFeature("android.hardware.location.gps");
                xdVar.rCO = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
                xdVar.rCP = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.front");
                xdVar.rCQ = this.mContext.getPackageManager().hasSystemFeature("android.hardware.microphone");
                xdVar.rCR = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
                if (VERSION.SDK_INT >= 19) {
                    xdVar.rDc = false;
                } else {
                    xdVar.rDc = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc.hce");
                }
                xdVar.rCS = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
                if (VERSION.SDK_INT < 23) {
                    xdVar.rCT = this.mContext.getPackageManager().hasSystemFeature("android.hardware.fingerprint");
                } else if (q.deQ.deZ == 1) {
                    xdVar.rCT = true;
                } else {
                    xdVar.rCT = false;
                }
                xdVar.rCU = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.cdma");
                xdVar.rCV = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.gsm");
                xdVar.rCW = this.mContext.getPackageManager().hasSystemFeature("android.software.sip");
                xdVar.rCX = this.mContext.getPackageManager().hasSystemFeature("android.software.sip.voip");
                if (VERSION.SDK_INT >= 19) {
                    xdVar.rCY = false;
                } else {
                    xdVar.rCY = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
                }
                if (VERSION.SDK_INT >= 19) {
                    xdVar.rCZ = false;
                } else {
                    xdVar.rCZ = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
                }
                xdVar.rDa = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.accelerometer");
                xdVar.rDb = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.light");
                com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT().rOV = xdVar;
                x.d("MicroMsg.TaskFindHardwareInfo", "hy: hy: hardwareinfo: hasBluetooth: %b, hasBluetoothLE: %b, hasGPS: %b, hasCameraFlash: %b, hasCameraFront: %b, hasMic: %b, hasNFC: %b, hasNfcHce: %b, hasHifiSensor: %b, hasFingerprintSensor: %b, hasCDMA: %b, hasGSM: %b, hasSIP: %b, hasSIPBasedVoIP: %b, hasStepDitector: %b , hasStepCounter: %b, hasAcceloratorSensor: %b, hasLightSensor: %b", new Object[]{Boolean.valueOf(xdVar.rCL), Boolean.valueOf(xdVar.rCM), Boolean.valueOf(xdVar.rCN), Boolean.valueOf(xdVar.rCO), Boolean.valueOf(xdVar.rCP), Boolean.valueOf(xdVar.rCQ), Boolean.valueOf(xdVar.rCR), Boolean.valueOf(xdVar.rDc), Boolean.valueOf(xdVar.rCS), Boolean.valueOf(xdVar.rCT), Boolean.valueOf(xdVar.rCU), Boolean.valueOf(xdVar.rCV), Boolean.valueOf(xdVar.rCW), Boolean.valueOf(xdVar.rCX), Boolean.valueOf(xdVar.rCY), Boolean.valueOf(xdVar.rCZ), Boolean.valueOf(xdVar.rDa), Boolean.valueOf(xdVar.rDb)});
                x.i("MicroMsg.TaskFindHardwareInfo", "hy: calc hardware using: %d ms", new Object[]{Long.valueOf(((System.nanoTime() - nanoTime) / 1000) / 1000)});
                aVT = com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT();
                if (aVT != null) {
                    if (aVT.rOQ != null) {
                        g.Ei().DT().a(com.tencent.mm.storage.aa.a.sZy, Integer.valueOf(aVT.rOQ.rmE));
                    }
                    if (aVT.rOR != null) {
                        g.Ei().DT().a(com.tencent.mm.storage.aa.a.sZz, Integer.valueOf(aVT.rOR.rWK));
                    }
                }
                return com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT();
            } catch (Throwable th2) {
                e222 = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e42) {
                        x.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e42, "hy: error when close read cpu files", new Object[0]);
                    }
                }
                throw e222;
            }
            com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT().rOQ = kkVar;
            x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: abi: %s, cpuModel: %s, cpuClockSpeedInHz: %d, modelName: %s, platform: %s", new Object[]{kkVar.rmF, kkVar.rmD, Integer.valueOf(kkVar.rmE), kkVar.rgp, kkVar.rmG});
            activityManager = (ActivityManager) this.mContext.getSystemService("activity");
            memoryInfo = new MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            atk = new atk();
            atk.rWK = (int) ((memoryInfo.totalMem / 1024) / 1024);
            atk.rWL = (int) ((memoryInfo.threshold / 1024) / 1024);
            atk.rWM = ((ActivityManager) this.mContext.getSystemService("activity")).getLargeMemoryClass();
            atk.rWN = ((ActivityManager) this.mContext.getSystemService("activity")).getMemoryClass();
            com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT().rOR = atk;
            x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalMemInMB: %d, thresholdInMB: %d, large memory class; %d, memory class: %d", new Object[]{Integer.valueOf(atk.rWK), Integer.valueOf(atk.rWL), Integer.valueOf(atk.rWM), Integer.valueOf(atk.rWN)});
            statFs = new StatFs(e.bnC);
            brf = new brf();
            if (VERSION.SDK_INT >= 18) {
                brf.sps = (int) ((statFs.getTotalBytes() / 1024) / 1024);
            } else {
                brf.sps = (int) (((((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1024) / 1024);
            }
            brf.spt = Environment.getExternalStorageState().equals("mounted");
            com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT().rOS = brf;
            x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: totalStorageInMB: %d, hasExternalStorage: %b", new Object[]{Integer.valueOf(brf.sps), Boolean.valueOf(brf.spt)});
            deviceConfigurationInfo = ((ActivityManager) this.mContext.getSystemService("activity")).getDeviceConfigurationInfo();
            xuVar = new xu();
            if (deviceConfigurationInfo.reqGlEsVersion >= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                z = true;
            } else {
                z = false;
            }
            xuVar.rDB = z;
            if (deviceConfigurationInfo.reqGlEsVersion >= 196608) {
            }
            xuVar.rDC = deviceConfigurationInfo.reqGlEsVersion >= 196608;
            try {
                xuVar.rDD = ((b) g.l(b.class)).isSupportVulkan();
            } catch (Throwable e2222) {
                x.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e2222, "hy: error when retrieve vulkan support!", new Object[0]);
                xuVar.rDD = false;
            }
            com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT().rOW = xuVar;
            x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: hasOpenGL20: %b, hasOpenGL30: %b, esversion: %s, isSupportVulkan: %b", new Object[]{Boolean.valueOf(xuVar.rDB), Boolean.valueOf(xuVar.rDC), Integer.valueOf(deviceConfigurationInfo.reqGlEsVersion), Boolean.valueOf(xuVar.rDD)});
            defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
            point = new Point();
            defaultDisplay.getSize(point);
            i = point.x;
            i2 = point.y;
            bip = new bip();
            bip.sje = String.valueOf(i) + "x" + i2;
            bip.density = (int) this.mContext.getResources().getDisplayMetrics().density;
            com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT().rOT = bip;
            x.d("MicroMsg.TaskFindHardwareInfo", "hy: hardwareinfo: resolution: %s, ppi: %d", new Object[]{bip.sje, Integer.valueOf(bip.density)});
            poVar = new po();
            poVar.rtO = EE("video/avc");
            poVar.rtP = EE("video/hevc");
            poVar.rtQ = aVU();
            com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT().rOU = poVar;
            str = "MicroMsg.TaskFindHardwareInfo";
            str2 = "hy: hardwareinfo: default codec name avc: %s, default hevc names: %s, codec number: %d";
            objArr = new Object[3];
            objArr[0] = poVar.rtO;
            objArr[1] = poVar.rtP;
            if (poVar.rtQ != null) {
                i = poVar.rtQ.size();
            } else {
                i = 0;
            }
            objArr[2] = Integer.valueOf(i);
            x.d(str, str2, objArr);
            xdVar = new xd();
            xdVar.rCL = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth");
            if (VERSION.SDK_INT >= 18) {
                xdVar.rCM = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
            } else {
                xdVar.rCM = false;
            }
            xdVar.rCN = this.mContext.getPackageManager().hasSystemFeature("android.hardware.location.gps");
            xdVar.rCO = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.flash");
            xdVar.rCP = this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.front");
            xdVar.rCQ = this.mContext.getPackageManager().hasSystemFeature("android.hardware.microphone");
            xdVar.rCR = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
            if (VERSION.SDK_INT >= 19) {
                xdVar.rDc = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc.hce");
            } else {
                xdVar.rDc = false;
            }
            xdVar.rCS = this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc");
            if (VERSION.SDK_INT < 23) {
                xdVar.rCT = this.mContext.getPackageManager().hasSystemFeature("android.hardware.fingerprint");
            } else if (q.deQ.deZ == 1) {
                xdVar.rCT = true;
            } else {
                xdVar.rCT = false;
            }
            xdVar.rCU = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.cdma");
            xdVar.rCV = this.mContext.getPackageManager().hasSystemFeature("android.hardware.telephony.gsm");
            xdVar.rCW = this.mContext.getPackageManager().hasSystemFeature("android.software.sip");
            xdVar.rCX = this.mContext.getPackageManager().hasSystemFeature("android.software.sip.voip");
            if (VERSION.SDK_INT >= 19) {
                xdVar.rCY = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepdetector");
            } else {
                xdVar.rCY = false;
            }
            if (VERSION.SDK_INT >= 19) {
                xdVar.rCZ = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.stepcounter");
            } else {
                xdVar.rCZ = false;
            }
            xdVar.rDa = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.accelerometer");
            xdVar.rDb = this.mContext.getPackageManager().hasSystemFeature("android.hardware.sensor.light");
            com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT().rOV = xdVar;
            x.d("MicroMsg.TaskFindHardwareInfo", "hy: hy: hardwareinfo: hasBluetooth: %b, hasBluetoothLE: %b, hasGPS: %b, hasCameraFlash: %b, hasCameraFront: %b, hasMic: %b, hasNFC: %b, hasNfcHce: %b, hasHifiSensor: %b, hasFingerprintSensor: %b, hasCDMA: %b, hasGSM: %b, hasSIP: %b, hasSIPBasedVoIP: %b, hasStepDitector: %b , hasStepCounter: %b, hasAcceloratorSensor: %b, hasLightSensor: %b", new Object[]{Boolean.valueOf(xdVar.rCL), Boolean.valueOf(xdVar.rCM), Boolean.valueOf(xdVar.rCN), Boolean.valueOf(xdVar.rCO), Boolean.valueOf(xdVar.rCP), Boolean.valueOf(xdVar.rCQ), Boolean.valueOf(xdVar.rCR), Boolean.valueOf(xdVar.rDc), Boolean.valueOf(xdVar.rCS), Boolean.valueOf(xdVar.rCT), Boolean.valueOf(xdVar.rCU), Boolean.valueOf(xdVar.rCV), Boolean.valueOf(xdVar.rCW), Boolean.valueOf(xdVar.rCX), Boolean.valueOf(xdVar.rCY), Boolean.valueOf(xdVar.rCZ), Boolean.valueOf(xdVar.rDa), Boolean.valueOf(xdVar.rDb)});
            x.i("MicroMsg.TaskFindHardwareInfo", "hy: calc hardware using: %d ms", new Object[]{Long.valueOf(((System.nanoTime() - nanoTime) / 1000) / 1000)});
            try {
                aVT = com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT();
                if (aVT != null) {
                    if (aVT.rOQ != null) {
                        g.Ei().DT().a(com.tencent.mm.storage.aa.a.sZy, Integer.valueOf(aVT.rOQ.rmE));
                    }
                    if (aVT.rOR != null) {
                        g.Ei().DT().a(com.tencent.mm.storage.aa.a.sZz, Integer.valueOf(aVT.rOR.rWK));
                    }
                }
            } catch (Throwable e22222) {
                x.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e22222, "alvinluo save hardware info to config storage exception", new Object[0]);
            }
            return com.tencent.mm.plugin.hardwareopt.b.a.aVS().aVT();
        } catch (Throwable e222222) {
            x.printErrStackTrace("MicroMsg.TaskFindHardwareInfo", e222222, "hy: exception when find hardware info", new Object[0]);
            com.tencent.mm.vending.g.b cBL = com.tencent.mm.vending.g.g.cBL();
            if (cBL != null) {
                cBL.ct(null);
            }
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String EE(java.lang.String r5) {
        /*
        r1 = 0;
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0019 }
        r2 = 18;
        if (r0 < r2) goto L_0x0015;
    L_0x0007:
        r1 = android.media.MediaCodec.createEncoderByType(r5);	 Catch:{ Exception -> 0x0019 }
        r0 = r1.getName();	 Catch:{ Exception -> 0x0019 }
        if (r1 == 0) goto L_0x0014;
    L_0x0011:
        r1.release();
    L_0x0014:
        return r0;
    L_0x0015:
        r0 = "too low version";
        goto L_0x0014;
    L_0x0019:
        r0 = move-exception;
        r2 = "MicroMsg.TaskFindHardwareInfo";
        r3 = "hy: error in handle media codec";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x002f }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r0, r3, r4);	 Catch:{ all -> 0x002f }
        r0 = "undefined";
        if (r1 == 0) goto L_0x0014;
    L_0x002b:
        r1.release();
        goto L_0x0014;
    L_0x002f:
        r0 = move-exception;
        if (r1 == 0) goto L_0x0035;
    L_0x0032:
        r1.release();
    L_0x0035:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.hardwareopt.c.a.EE(java.lang.String):java.lang.String");
    }

    private static LinkedList<atq> aVU() {
        int codecCount = MediaCodecList.getCodecCount();
        LinkedList<atq> linkedList = new LinkedList();
        Map hashMap = new HashMap();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                for (String str : codecInfoAt.getSupportedTypes()) {
                    Set set = (Set) hashMap.get(str.toLowerCase());
                    if (set == null) {
                        set = new HashSet();
                    }
                    set.add(codecInfoAt.getName());
                    hashMap.put(str.toLowerCase(), set);
                }
            }
        }
        x.i("MicroMsg.TaskFindHardwareInfo", "hy: allCodecNames: %s", new Object[]{hashMap});
        for (Entry entry : hashMap.entrySet()) {
            atq atq = new atq();
            atq.ldm = (String) entry.getKey();
            LinkedList linkedList2 = new LinkedList();
            if (entry.getValue() != null) {
                linkedList2.addAll((Collection) entry.getValue());
            }
            atq.rWW = linkedList2;
            linkedList.add(atq);
        }
        return linkedList;
    }
}
