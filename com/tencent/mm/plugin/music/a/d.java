package com.tencent.mm.plugin.music.a;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.g.a.t;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.a;
import com.tencent.mm.z.b;
import com.tencent.mm.z.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    private static d lwQ;
    Object itk = new Object();
    HashMap<String, f> lwA = new HashMap();
    LinkedList<String> lwB = new LinkedList();
    HashMap<String, f> lwC = new HashMap();
    LinkedList<String> lwD = new LinkedList();
    LinkedList<String> lwE = new LinkedList();
    HashMap<String, String> lwF = new HashMap();
    HashMap<String, LinkedList<String>> lwG = new HashMap();
    HashMap<String, a> lwH = new HashMap();
    private HashMap<String, c> lwI = new HashMap();
    private LinkedList<String> lwJ = new LinkedList();
    HashMap<String, Integer> lwK = new HashMap();
    private LinkedList<String> lwL = new LinkedList();
    boolean lwM = false;
    private boolean lwN = false;
    long lwO = 0;
    private long lwP = 0;
    private c lwR = new c() {
        public final void onStart(String str) {
            f HZ = d.this.HZ(str);
            if (HZ == null) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "onStart player is null");
                return;
            }
            d.this.e(str, HZ);
            synchronized (d.this.itk) {
                d.this.lwM = false;
            }
            ah.M(d.this.lwT);
        }

        public final void HT(String str) {
            f HZ = d.this.HZ(str);
            if (HZ == null) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "onPause player is null");
                return;
            }
            d.this.b(str, HZ);
            d.this.f(str, HZ);
            d.a(d.this);
            d.this.bhi();
        }

        public final void AW(String str) {
            f HZ = d.this.HZ(str);
            if (HZ == null) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "onStop player is null");
                return;
            }
            d.this.b(str, HZ);
            d.this.f(str, HZ);
            d.a(d.this);
            d.this.bhi();
        }

        public final void HU(String str) {
            f HZ = d.this.HZ(str);
            if (HZ == null) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "onComplete player is null");
                return;
            }
            d.this.b(str, HZ);
            d.this.f(str, HZ);
            d.a(d.this);
            d.this.bhi();
        }

        public final void onError(String str) {
            f HZ = d.this.HZ(str);
            if (HZ == null) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "onError player is null");
                return;
            }
            int intValue;
            Object obj;
            d.this.b(str, HZ);
            d dVar = d.this;
            int i = HZ.isA;
            if (dVar.lwK.containsKey(str)) {
                intValue = ((Integer) dVar.lwK.get(str)).intValue();
            } else {
                intValue = 0;
            }
            if (intValue > 0) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "try it one time, don't try again");
                dVar.lwK.remove(str);
            } else if (66 != i) {
                dVar.lwK.remove(str);
            } else if (dVar.Ig(str)) {
                dVar.lwK.put(str, Integer.valueOf(intValue + 1));
                obj = 1;
                if (obj == null) {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "try to stop same url players and play again");
                    d.this.bhm();
                    d.this.a(str, null);
                }
                x.e("MicroMsg.Audio.AudioPlayerMgr", "not try to play again");
                d.this.f(str, HZ);
                d.a(d.this);
                d.this.bhi();
                return;
            }
            obj = null;
            if (obj == null) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "not try to play again");
                d.this.f(str, HZ);
                d.a(d.this);
                d.this.bhi();
                return;
            }
            x.e("MicroMsg.Audio.AudioPlayerMgr", "try to stop same url players and play again");
            d.this.bhm();
            d.this.a(str, null);
        }
    };
    private Runnable lwS = new Runnable() {
        public final void run() {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudioDelayRunnable, run");
            Iterator it = d.this.lwE.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (d.this.HY(str) == 0) {
                    d.this.Ia(str);
                }
            }
        }
    };
    Runnable lwT = new Runnable() {
        public final void run() {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayRunnable, run");
            Iterator it = d.this.lwE.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2;
                String str = (String) it.next();
                if (d.this.HY(str) == 0) {
                    d dVar = d.this;
                    x.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersAndSaveState, appId:%s", new Object[]{str});
                    LinkedList linkedList = (LinkedList) dVar.lwG.get(str);
                    if (linkedList == null || linkedList.size() == 0) {
                        x.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
                    } else {
                        synchronized (dVar.itk) {
                            Iterator it2 = linkedList.iterator();
                            while (it2.hasNext()) {
                                String str2 = (String) it2.next();
                                f fVar = (f) dVar.lwA.remove(str2);
                                dVar.lwB.remove(str2);
                                if (fVar != null) {
                                    dVar.b(str2, fVar);
                                    x.i("MicroMsg.Audio.AudioPlayerMgr", "destroy player");
                                    if (fVar.dGA) {
                                        d.d(str2, fVar);
                                    } else {
                                        d.c(str2, fVar);
                                    }
                                }
                            }
                            Iterator it3 = linkedList.iterator();
                            while (it3.hasNext()) {
                                str = (String) it3.next();
                                f fVar2 = (f) dVar.lwC.remove(str);
                                dVar.lwD.remove(str);
                                if (fVar2 != null) {
                                    dVar.b(str, fVar2);
                                    x.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
                                    if (fVar2.dGA) {
                                        d.d(str, fVar2);
                                    } else {
                                        d.c(str, fVar2);
                                    }
                                }
                            }
                        }
                    }
                    i2 = 1;
                } else {
                    i2 = i;
                }
                i = i2;
            }
            if (i == 0) {
                synchronized (d.this.itk) {
                    d.this.lwM = true;
                }
                d.this.lwO = System.currentTimeMillis();
                ah.i(d.this.lwT, 1800000);
            }
        }
    };
    private LinkedList<String> lwz = new LinkedList();

    static /* synthetic */ void a(d dVar) {
        if (dVar.bhj() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!dVar.lwN || currentTimeMillis - dVar.lwP >= 10000) {
                synchronized (dVar.itk) {
                    dVar.lwN = true;
                }
                dVar.lwP = currentTimeMillis;
                x.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudioDelayIfPaused, delay_ms:%d", new Object[]{Integer.valueOf(600000)});
                ah.M(dVar.lwS);
                ah.i(dVar.lwS, 600000);
                return;
            }
            return;
        }
        synchronized (dVar.itk) {
            dVar.lwN = false;
        }
        ah.M(dVar.lwS);
    }

    public static synchronized void bhe() {
        synchronized (d.class) {
            if (lwQ == null) {
                lwQ = new d();
            }
        }
    }

    public static d bhf() {
        if (lwQ == null) {
            lwQ = new d();
        }
        return lwQ;
    }

    private d() {
        bhg();
    }

    public final void bhg() {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "_release");
        this.lwz.clear();
        synchronized (this.itk) {
            String str;
            Iterator it = this.lwB.iterator();
            while (it.hasNext()) {
                str = (String) it.next();
                c(str, (f) this.lwA.remove(str));
            }
            this.lwB.clear();
            this.lwA.clear();
            it = this.lwD.iterator();
            while (it.hasNext()) {
                str = (String) it.next();
                c(str, (f) this.lwC.remove(str));
            }
            this.lwD.clear();
            this.lwC.clear();
        }
        Iterator it2 = this.lwE.iterator();
        while (it2.hasNext()) {
            LinkedList linkedList = (LinkedList) this.lwG.remove((String) it2.next());
            if (linkedList != null) {
                linkedList.clear();
            }
        }
        this.lwE.clear();
        this.lwF.clear();
        this.lwG.clear();
        this.lwH.clear();
        this.lwI.clear();
        this.lwK.clear();
        this.lwL.clear();
        ah.M(this.lwS);
        ah.M(this.lwT);
        this.lwM = false;
        this.lwN = false;
    }

    private void dP(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "saveCreateId, appId:%s, audioId:%s", new Object[]{str, str2});
            if (!this.lwE.contains(str)) {
                this.lwE.add(str);
            }
            if (!this.lwz.contains(str2)) {
                this.lwz.add(str2);
            }
            LinkedList linkedList = (LinkedList) this.lwG.get(str);
            if (linkedList == null) {
                linkedList = new LinkedList();
            }
            if (!linkedList.contains(str2)) {
                linkedList.add(str2);
            }
            this.lwG.put(str, linkedList);
        }
    }

    public final String dQ(String str, String str2) {
        int i;
        x.i("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer");
        LinkedList linkedList = (LinkedList) this.lwG.get(str);
        synchronized (this.itk) {
            if (linkedList != null) {
                if (linkedList.contains(str2) && (this.lwB.contains(str2) || this.lwD.contains(str2))) {
                    i = 1;
                }
            }
            i = 0;
        }
        int HY = HY(str);
        if (TextUtils.isEmpty(str2)) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer fail, the audioId is empty!");
            av(604, str2);
            return null;
        } else if (HY >= 10) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_AUDIO_PLAYER_COUNT, save id and not send error event, not create player!", new Object[]{Integer.valueOf(HY)});
            dP(str, str2);
            return null;
        } else if (i != 0) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer fail, the audioId exist in mAudioIds");
            av(603, str2);
            return null;
        } else {
            dP(str, str2);
            Id(str2);
            f bhh = bhh();
            bhh.a(this.lwR);
            bhh.Ih(str2);
            f(str2, bhh);
            x.i("MicroMsg.Audio.AudioPlayerMgr", "create player success, appId:%s, audioId:%s", new Object[]{str, str2});
            return str2;
        }
    }

    public final boolean b(a aVar) {
        boolean z = false;
        if (aVar == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, play param is null");
            av(605, "");
            return false;
        } else if (TextUtils.isEmpty(aVar.bGW)) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is empty!");
            av(604, aVar.bGW);
            return false;
        } else if (this.lwz.contains(aVar.bGW)) {
            f HZ;
            x.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio");
            String Ic = Ic(aVar.bGW);
            a jE = jE(aVar.bGW);
            if (HY(Ic) >= 10) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT, but save param!", new Object[]{Integer.valueOf(HY(Ic))});
                this.lwH.put(aVar.bGW, aVar);
                x.i("MicroMsg.Audio.AudioPlayerMgr", "autoPlay:%b", new Object[]{Boolean.valueOf(aVar.dGu)});
                if (aVar.dGu && If(aVar.bGW)) {
                    bhm();
                } else if (aVar.dGu) {
                    av(600, aVar.bGW);
                    return false;
                } else {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "save param, do nothing ");
                    HZ = HZ(aVar.bGW);
                    if (HZ != null) {
                        HZ.c(aVar);
                        HZ.bhs();
                    }
                    return true;
                }
            }
            Id(aVar.bGW);
            f HZ2 = HZ(aVar.bGW);
            if (HZ2 == null) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, player is null, create new QQAudioPlayer with audioId:%s", new Object[]{aVar.bGW});
                HZ = bhh();
                HZ.a(this.lwR);
                HZ.Ih(aVar.bGW);
                HZ.c(aVar);
                if (aVar.dGu) {
                    e(aVar.bGW, HZ);
                    aVar.dGw = System.currentTimeMillis();
                    HZ.d(aVar);
                } else {
                    f(aVar.bGW, HZ);
                    HZ.bhs();
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "new player autoplay false, not to play ");
                }
            } else {
                x.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio, audioId:%s", new Object[]{aVar.bGW});
                if (aVar.dGu) {
                    e(aVar.bGW, HZ2);
                    aVar.dGw = System.currentTimeMillis();
                    HZ2.c(aVar);
                    if (jE != null && !jE.a(aVar)) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now and play new");
                        if (HZ2.PY() || HZ2.PZ() || HZ2.bhC() || HZ2.isPrepared() || HZ2.isPaused()) {
                            HZ2.stopPlay();
                        }
                        HZ2.d(aVar);
                    } else if (HZ2.PY()) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "is playing, do nothing");
                    } else if (HZ2.PZ() && HZ2.isPaused()) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "is paused, do resume");
                        HZ2.resume();
                    } else if (HZ2.isPrepared()) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "is isPrepared, do resume");
                        HZ2.resume();
                    } else if (HZ2.bhC()) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "is isPreparing, do nothing");
                    } else {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "is end or stop, do startPlay");
                        HZ2.d(aVar);
                    }
                } else {
                    synchronized (this.itk) {
                        if (this.lwB.contains(aVar.bGW)) {
                            z = true;
                        }
                    }
                    if (z) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "don't mark player, is playing");
                    } else {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "mark player recycle");
                        f(aVar.bGW, HZ2);
                    }
                    HZ2.c(aVar);
                    if (!(jE == null || jE.a(aVar))) {
                        x.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now");
                        if (HZ2.PY() || HZ2.PZ() || HZ2.bhC() || HZ2.isPrepared() || HZ2.isPaused()) {
                            HZ2.stopPlay();
                        }
                    }
                    HZ2.bhs();
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "autoplay false, not to play ");
                }
            }
            this.lwF.put(Ic, aVar.processName);
            this.lwH.put(aVar.bGW, aVar);
            return true;
        } else {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is not found!");
            av(601, aVar.bGW);
            return false;
        }
    }

    public final boolean a(String str, a aVar) {
        a aVar2 = (a) this.lwH.get(str);
        if ((!this.lwz.contains(str) || aVar2 == null) && aVar != null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, the audioId %s is not found or param is null, backupParam is exit", new Object[]{str});
            if (aVar == null) {
                x.e("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam param == null, audioId:%s", new Object[]{str});
            } else {
                x.i("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam audioId:%s", new Object[]{str});
                this.lwF.put(aVar.appId, aVar.processName);
                this.lwH.put(aVar.bGW, aVar);
                dP(aVar.appId, str);
                this.lwK.remove(str);
            }
            if (aVar2 == null) {
                aVar2 = aVar;
            }
        } else if (!this.lwz.contains(str)) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the audioId is not found!");
            av(601, str);
            return false;
        } else if (aVar2 == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the param is not found!");
            av(602, str);
            return false;
        }
        x.i("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, audioId:%s", new Object[]{str});
        if (HY(Ic(str)) >= 10) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT", new Object[]{Integer.valueOf(HY(Ic(str)))});
            if (If(str)) {
                bhm();
            } else {
                av(600, str);
                return false;
            }
        }
        f HZ = HZ(str);
        if (HZ == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, player is null");
            Id(str);
            x.i("MicroMsg.Audio.AudioPlayerMgr", "create new QQAudioPlayer with audioId %s to play", new Object[]{str});
            HZ = bhh();
            HZ.a(this.lwR);
            HZ.Ih(str);
            e(str, HZ);
            aVar2.dGu = true;
            aVar2.dGs = 0;
            aVar2.dGw = System.currentTimeMillis();
            HZ.d(aVar2);
            return true;
        }
        e(str, HZ);
        this.lwH.put(str, aVar2);
        if (HZ.PZ() && !HZ.PY()) {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "is pause, do resume");
            HZ.resume();
        } else if (HZ.isPrepared()) {
            aVar2.dGu = true;
            aVar2.dGw = System.currentTimeMillis();
            x.i("MicroMsg.Audio.AudioPlayerMgr", "is prepared, do resume");
            HZ.resume();
            aVar2.dGs = 0;
            HZ.c(aVar2);
        } else if (HZ.bhC()) {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "is preparing, do update param");
            aVar2.dGu = true;
            aVar2.dGw = System.currentTimeMillis();
            HZ.c(aVar2);
        } else if (HZ.PZ()) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "do nothing");
            return false;
        } else {
            aVar2.dGu = true;
            aVar2.dGw = System.currentTimeMillis();
            x.i("MicroMsg.Audio.AudioPlayerMgr", "is stop, do startPlay");
            HZ.d(aVar2);
            aVar2.dGs = 0;
        }
        return true;
    }

    public final boolean HV(String str) {
        f HZ = HZ(str);
        if (HZ == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, player is null");
            return false;
        }
        x.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, audioId:%s", new Object[]{str});
        HZ.stopPlay();
        a aVar = (a) this.lwH.get(str);
        if (aVar != null) {
            aVar.dGs = 0;
            aVar.dGu = true;
        }
        b(str, HZ);
        f(str, HZ);
        return true;
    }

    public final boolean HW(String str) {
        f HZ = HZ(str);
        if (HZ == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, player is null");
            return false;
        }
        x.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, audioId:%s", new Object[]{str});
        c(str, HZ);
        synchronized (this.itk) {
            this.lwA.remove(str);
            this.lwB.remove(str);
            this.lwC.remove(str);
            this.lwD.remove(str);
        }
        this.lwz.remove(str);
        Iterator it = this.lwE.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            LinkedList linkedList = (LinkedList) this.lwG.get(str2);
            if (linkedList != null && linkedList.contains(str)) {
                linkedList.remove(str);
                if (linkedList.size() == 0) {
                    this.lwG.remove(str2);
                    this.lwE.remove(str2);
                    this.lwF.remove(str2);
                }
                this.lwH.remove(str);
                this.lwI.remove(str);
                return true;
            }
        }
        this.lwH.remove(str);
        this.lwI.remove(str);
        return true;
    }

    final boolean bK(String str, int i) {
        a aVar = (a) this.lwH.get(str);
        if (aVar == null) {
            return false;
        }
        aVar.dGs = i;
        return true;
    }

    public final c HX(String str) {
        f HZ = HZ(str);
        if (HZ != null) {
            return HZ.bhF();
        }
        return (c) this.lwI.get(str);
    }

    public final int HY(String str) {
        int size;
        int bhj = bhj();
        synchronized (this.itk) {
            int size2 = this.lwz.size();
            size = this.lwA.size();
            int size3 = this.lwC.size();
            LinkedList linkedList = (LinkedList) this.lwG.get(str);
            int size4 = linkedList == null ? 0 : linkedList.size();
            x.i("MicroMsg.Audio.AudioPlayerMgr", "getAudioPlayerCount, count:%d, player_count:%d, recycled_player_count:%d, audioIdsCount:%d, pause_count:%d", new Object[]{Integer.valueOf(size2), Integer.valueOf(size), Integer.valueOf(size3), Integer.valueOf(size4), Integer.valueOf(bhj)});
        }
        return size;
    }

    public final a jE(String str) {
        if (this.lwH.containsKey(str)) {
            return (a) this.lwH.get(str);
        }
        return null;
    }

    final f HZ(String str) {
        if (this.lwA.containsKey(str)) {
            return (f) this.lwA.get(str);
        }
        if (this.lwC.containsKey(str)) {
            return (f) this.lwC.get(str);
        }
        return null;
    }

    public final void Ia(String str) {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "pauseAllAudioPlayers, appId:%s", new Object[]{str});
        LinkedList linkedList = (LinkedList) this.lwG.get(str);
        if (linkedList == null || linkedList.size() == 0) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
        } else if (this.lwA.isEmpty() && this.lwC.isEmpty()) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
        } else {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                f fVar = (f) this.lwC.get(str2);
                if (fVar != null) {
                    a(str2, fVar);
                }
            }
            x.i("MicroMsg.Audio.AudioPlayerMgr", "playing player count:%d", new Object[]{Integer.valueOf(this.lwA.size())});
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                String str3 = (String) it2.next();
                f fVar2 = (f) this.lwA.get(str3);
                if (fVar2 != null) {
                    a(str3, fVar2);
                    f(str3, fVar2);
                }
            }
        }
    }

    public final void Ib(String str) {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayers, appId:%s", new Object[]{str});
        LinkedList linkedList = (LinkedList) this.lwG.remove(str);
        if (linkedList == null || linkedList.size() == 0) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
            return;
        }
        synchronized (this.itk) {
            String str2;
            f fVar;
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                str2 = (String) it.next();
                fVar = (f) this.lwA.remove(str2);
                this.lwB.remove(str2);
                x.i("MicroMsg.Audio.AudioPlayerMgr", "destroy playing player");
                c(str2, fVar);
                this.lwH.remove(str2);
                this.lwI.remove(str2);
            }
            it = linkedList.iterator();
            while (it.hasNext()) {
                str2 = (String) it.next();
                fVar = (f) this.lwC.remove(str2);
                this.lwD.remove(str2);
                x.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
                c(str2, fVar);
                this.lwH.remove(str2);
                this.lwI.remove(str2);
            }
        }
        this.lwz.removeAll(linkedList);
        this.lwE.remove(str);
        this.lwF.remove(str);
    }

    private void av(int i, String str) {
        x.e("MicroMsg.Audio.AudioPlayerMgr", "onErrorEvent with errCode:%d, audioId:%s", new Object[]{Integer.valueOf(i), str});
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "audioId is empty");
            str = b.Km();
        }
        t tVar = new t();
        tVar.bHb.action = 4;
        tVar.bHb.state = "error";
        tVar.bHb.errCode = com.tencent.mm.plugin.music.b.a.d.tL(i);
        tVar.bHb.Yy = com.tencent.mm.plugin.music.b.a.d.tM(i);
        tVar.bHb.bGW = str;
        tVar.bHb.appId = Ic(str);
        com.tencent.mm.sdk.b.a.sFg.a(tVar, Looper.getMainLooper());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.mm.plugin.music.a.f bhh() {
        /*
        r14 = this;
        r0 = "MicroMsg.Audio.AudioPlayerMgr";
        r1 = "createOrReusePlayer";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r7 = r14.itk;
        monitor-enter(r7);
        r0 = r14.lwC;	 Catch:{ all -> 0x00c4 }
        r0 = r0.size();	 Catch:{ all -> 0x00c4 }
        if (r0 != 0) goto L_0x001b;
    L_0x0014:
        r5 = new com.tencent.mm.plugin.music.a.f;	 Catch:{ all -> 0x00c4 }
        r5.<init>();	 Catch:{ all -> 0x00c4 }
        monitor-exit(r7);	 Catch:{ all -> 0x00c4 }
    L_0x001a:
        return r5;
    L_0x001b:
        r5 = 0;
        r4 = "";
        r2 = 0;
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x00c4 }
        r0 = r14.lwD;	 Catch:{ all -> 0x00c4 }
        r10 = r0.iterator();	 Catch:{ all -> 0x00c4 }
    L_0x002b:
        r0 = r10.hasNext();	 Catch:{ all -> 0x00c4 }
        if (r0 == 0) goto L_0x0077;
    L_0x0031:
        r0 = r10.next();	 Catch:{ all -> 0x00c4 }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x00c4 }
        r1 = r14.lwC;	 Catch:{ all -> 0x00c4 }
        r1 = r1.get(r0);	 Catch:{ all -> 0x00c4 }
        r1 = (com.tencent.mm.plugin.music.a.f) r1;	 Catch:{ all -> 0x00c4 }
        if (r1 == 0) goto L_0x002b;
    L_0x0041:
        r6 = r1.dGA;	 Catch:{ all -> 0x00c4 }
        if (r6 != 0) goto L_0x0062;
    L_0x0045:
        r6 = r1.isCompleted();	 Catch:{ all -> 0x00c4 }
        if (r6 != 0) goto L_0x0062;
    L_0x004b:
        r6 = r1.isStopped();	 Catch:{ all -> 0x00c4 }
        if (r6 != 0) goto L_0x0062;
    L_0x0051:
        r6 = r1.lwZ;	 Catch:{ all -> 0x00c4 }
        if (r6 == 0) goto L_0x0075;
    L_0x0055:
        r6 = r1.lwZ;	 Catch:{ all -> 0x00c4 }
        r6 = r6.getPlayerState();	 Catch:{ all -> 0x00c4 }
        r11 = 9;
        if (r6 != r11) goto L_0x0073;
    L_0x005f:
        r6 = 1;
    L_0x0060:
        if (r6 == 0) goto L_0x00d2;
    L_0x0062:
        r12 = 0;
        r6 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1));
        if (r6 == 0) goto L_0x006e;
    L_0x0068:
        r12 = r1.dkh;	 Catch:{ all -> 0x00c4 }
        r6 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));
        if (r6 >= 0) goto L_0x00d2;
    L_0x006e:
        r2 = r1.dkh;	 Catch:{ all -> 0x00c4 }
    L_0x0070:
        r4 = r0;
        r5 = r1;
        goto L_0x002b;
    L_0x0073:
        r6 = 0;
        goto L_0x0060;
    L_0x0075:
        r6 = 0;
        goto L_0x0060;
    L_0x0077:
        if (r5 == 0) goto L_0x00ca;
    L_0x0079:
        r0 = r8 - r2;
        r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x00ca;
    L_0x0081:
        r0 = "MicroMsg.Audio.AudioPlayerMgr";
        r1 = "player is be reuse to play again with other audio";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ all -> 0x00c4 }
        r0 = "MicroMsg.Audio.AudioPlayerMgr";
        r1 = "unmarkPlayer, unmark player by audioId:%s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00c4 }
        r3 = 0;
        r2[r3] = r4;	 Catch:{ all -> 0x00c4 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);	 Catch:{ all -> 0x00c4 }
        r1 = r14.itk;	 Catch:{ all -> 0x00c4 }
        monitor-enter(r1);	 Catch:{ all -> 0x00c4 }
        r0 = r14.lwD;	 Catch:{ all -> 0x00c7 }
        r0 = r0.contains(r4);	 Catch:{ all -> 0x00c7 }
        if (r0 == 0) goto L_0x00ae;
    L_0x00a4:
        r0 = r14.lwC;	 Catch:{ all -> 0x00c7 }
        r0.remove(r4);	 Catch:{ all -> 0x00c7 }
        r0 = r14.lwD;	 Catch:{ all -> 0x00c7 }
        r0.remove(r4);	 Catch:{ all -> 0x00c7 }
    L_0x00ae:
        r0 = r14.lwB;	 Catch:{ all -> 0x00c7 }
        r0 = r0.contains(r4);	 Catch:{ all -> 0x00c7 }
        if (r0 == 0) goto L_0x00c0;
    L_0x00b6:
        r0 = r14.lwB;	 Catch:{ all -> 0x00c7 }
        r0.remove(r4);	 Catch:{ all -> 0x00c7 }
        r0 = r14.lwA;	 Catch:{ all -> 0x00c7 }
        r0.remove(r4);	 Catch:{ all -> 0x00c7 }
    L_0x00c0:
        monitor-exit(r1);	 Catch:{ all -> 0x00c7 }
        monitor-exit(r7);	 Catch:{ all -> 0x00c4 }
        goto L_0x001a;
    L_0x00c4:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x00c4 }
        throw r0;
    L_0x00c7:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00c7 }
        throw r0;	 Catch:{ all -> 0x00c4 }
    L_0x00ca:
        monitor-exit(r7);	 Catch:{ all -> 0x00c4 }
        r5 = new com.tencent.mm.plugin.music.a.f;
        r5.<init>();
        goto L_0x001a;
    L_0x00d2:
        r0 = r4;
        r1 = r5;
        goto L_0x0070;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.music.a.d.bhh():com.tencent.mm.plugin.music.a.f");
    }

    private String Ic(String str) {
        Iterator it = this.lwE.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            LinkedList linkedList = (LinkedList) this.lwG.get(str2);
            if (linkedList != null && linkedList.contains(str)) {
                return str2;
            }
        }
        return "";
    }

    private void a(String str, f fVar) {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "pausePlayerOnBackground, pause player on background by audioId:%s", new Object[]{str});
        a aVar = (a) this.lwH.get(str);
        if (aVar != null && fVar.PY() && fVar.PZ()) {
            aVar.dGu = true;
            aVar.dGs = fVar.bhE();
        } else if (aVar != null && fVar.PZ()) {
            aVar.dGu = true;
            aVar.dGs = fVar.bhE();
        } else if (aVar != null) {
            aVar.dGu = true;
            aVar.dGs = 0;
        }
        b(str, fVar);
        c HX = HX(str);
        if (HX != null && fVar.PY()) {
            HX.dGz = true;
        }
        if (fVar.PY() || fVar.PZ() || fVar.bhC() || fVar.isPrepared() || fVar.isPaused()) {
            x.i("MicroMsg.Audio.QQAudioPlayer", "pauseOnBackGround");
            fVar.dGA = true;
            fVar.bhD();
            return;
        }
        x.i("MicroMsg.Audio.QQAudioPlayer", "setPauseOnBackground");
        fVar.dGA = true;
        fVar.lxc = true;
    }

    final void b(String str, f fVar) {
        this.lwI.put(str, fVar.bhF());
    }

    static void c(String str, f fVar) {
        if (fVar == null) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer player is null for audioId:%s", new Object[]{str});
            return;
        }
        if (fVar.PY() || fVar.PZ() || fVar.bhC() || fVar.isPrepared() || fVar.isPaused()) {
            fVar.stopPlay();
        }
        fVar.release();
        x.i("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer stop and release player by audioId:%s", new Object[]{str});
    }

    static void d(String str, f fVar) {
        x.d("MicroMsg.Audio.AudioPlayerMgr", "releasePlayer");
        c(str, fVar);
    }

    final void e(String str, f fVar) {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayer, mark player by audioId:%s", new Object[]{str});
        synchronized (this.itk) {
            if (this.lwD.contains(str)) {
                this.lwC.remove(str);
                this.lwD.remove(str);
            }
            if (!this.lwB.contains(str)) {
                this.lwB.add(str);
                this.lwA.put(str, fVar);
            }
        }
    }

    final void f(String str, f fVar) {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayerRecycled, mark player recycled by audioId:%s", new Object[]{str});
        synchronized (this.itk) {
            if (this.lwB.contains(str)) {
                this.lwA.remove(str);
                this.lwB.remove(str);
            }
            if (!this.lwD.contains(str)) {
                this.lwD.add(str);
                this.lwC.put(str, fVar);
            }
        }
    }

    public final void bhi() {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.lwM || currentTimeMillis - this.lwO >= 10000) {
            this.lwO = currentTimeMillis;
            synchronized (this.itk) {
                this.lwM = true;
            }
            x.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayIfPaused, delay_ms:%d", new Object[]{Integer.valueOf(1800000)});
            ah.M(this.lwT);
            ah.i(this.lwT, 1800000);
        }
    }

    private int bhj() {
        int i;
        synchronized (this.itk) {
            Iterator it = this.lwD.iterator();
            i = 0;
            while (it.hasNext()) {
                boolean z;
                int i2;
                String str = (String) it.next();
                f HZ = HZ(str);
                if (HZ == null) {
                    x.e("MicroMsg.Audio.AudioPlayerMgr", "isPausedPlayer, player is null");
                    c HX = HX(str);
                    z = HX != null ? HX.dGz : false;
                } else {
                    z = HZ.isPaused();
                }
                if (z) {
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                i = i2;
            }
        }
        return i;
    }

    private void Id(String str) {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePlayer");
        int size = this.lwA.size();
        int size2 = this.lwC.size();
        int bhj = bhj();
        x.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d, paused_player_count:%d", new Object[]{Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(bhj)});
        if (size >= 10) {
            bhk();
        } else if (bhj >= 6) {
            bhk();
        } else if (size + bhj >= 8) {
            bhk();
        }
        String Ic = Ic(str);
        bhj = this.lwA.size();
        size = this.lwC.size();
        x.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", new Object[]{Integer.valueOf(bhj), Integer.valueOf(size)});
        Iterator it;
        String str2;
        if (size >= 50) {
            it = this.lwE.iterator();
            while (it.hasNext()) {
                str2 = (String) it.next();
                if (!(str2 == null || str2.equalsIgnoreCase(Ic))) {
                    Ie(str2);
                }
            }
        } else if (size + bhj >= 50) {
            it = this.lwE.iterator();
            while (it.hasNext()) {
                str2 = (String) it.next();
                if (!(str2 == null || str2.equalsIgnoreCase(Ic))) {
                    Ie(str2);
                }
            }
        } else {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "not do recycle player, condition is not satisfy to do recycleStopPlayerByAppId");
        }
        size = this.lwC.size();
        x.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", new Object[]{Integer.valueOf(bhj), Integer.valueOf(size)});
        if (size >= 50) {
            bhl();
        } else if (size + bhj >= 50) {
            bhl();
        } else {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "not do recycle player, condition is not satisfy to do recycleAllStopPlayer");
        }
    }

    private void bhk() {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePausedPlayer");
        synchronized (this.itk) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.lwD);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                f fVar = (f) this.lwC.get(str);
                if (fVar != null && fVar.isPaused()) {
                    a(str, fVar);
                }
            }
        }
    }

    private void bhl() {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStopPlayer");
        synchronized (this.itk) {
            LinkedList linkedList = new LinkedList();
            linkedList.addAll(this.lwD);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                f fVar = (f) this.lwC.remove(str);
                this.lwD.remove(str);
                if (fVar != null) {
                    if (fVar.dGA) {
                        b(str, fVar);
                        d(str, fVar);
                    } else if (!fVar.isPaused()) {
                        b(str, fVar);
                        c(str, fVar);
                    }
                }
            }
        }
    }

    private void Ie(String str) {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStoppedPlayerByAppId");
        x.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllStoppedAudioPlayersAndSaveStateByAppId, appId:%s", new Object[]{str});
        LinkedList linkedList = (LinkedList) this.lwG.get(str);
        if (linkedList == null || linkedList.size() == 0) {
            x.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
            return;
        }
        synchronized (this.itk) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                f fVar = (f) this.lwC.remove(str2);
                this.lwD.remove(str2);
                if (fVar != null) {
                    b(str2, fVar);
                    x.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
                    if (fVar.dGA) {
                        d(str2, fVar);
                    } else {
                        c(str2, fVar);
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean If(java.lang.String r17) {
        /*
        r16 = this;
        r5 = 0;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r7 = new java.util.HashMap;
        r7.<init>();
        r8 = new java.util.HashMap;
        r8.<init>();
        r0 = r16;
        r4 = r0.itk;
        monitor-enter(r4);
        r0 = r16;
        r1 = r0.lwA;	 Catch:{ all -> 0x0091 }
        r9 = r1.size();	 Catch:{ all -> 0x0091 }
        r1 = 10;
        if (r9 >= r1) goto L_0x003e;
    L_0x0021:
        r0 = r16;
        r1 = r0.lwJ;	 Catch:{ all -> 0x0091 }
        r1.clear();	 Catch:{ all -> 0x0091 }
        r1 = "MicroMsg.Audio.AudioPlayerMgr";
        r2 = "playerCount:%d is not need to remove";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0091 }
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r9);	 Catch:{ all -> 0x0091 }
        r3[r5] = r6;	 Catch:{ all -> 0x0091 }
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);	 Catch:{ all -> 0x0091 }
        r1 = 0;
        monitor-exit(r4);	 Catch:{ all -> 0x0091 }
    L_0x003d:
        return r1;
    L_0x003e:
        r0 = r16;
        r1 = r0.lwB;	 Catch:{ all -> 0x0091 }
        r6 = r1.iterator();	 Catch:{ all -> 0x0091 }
    L_0x0046:
        r1 = r6.hasNext();	 Catch:{ all -> 0x0091 }
        if (r1 == 0) goto L_0x00c6;
    L_0x004c:
        r1 = r6.next();	 Catch:{ all -> 0x0091 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0091 }
        r0 = r16;
        r2 = r0.lwH;	 Catch:{ all -> 0x0091 }
        r1 = r2.get(r1);	 Catch:{ all -> 0x0091 }
        r1 = (com.tencent.mm.z.a) r1;	 Catch:{ all -> 0x0091 }
        if (r1 == 0) goto L_0x0046;
    L_0x005e:
        r2 = r1.cfD;	 Catch:{ all -> 0x0091 }
        if (r2 == 0) goto L_0x0046;
    L_0x0062:
        r2 = r1.cfD;	 Catch:{ all -> 0x0091 }
        r2 = r7.containsKey(r2);	 Catch:{ all -> 0x0091 }
        if (r2 != 0) goto L_0x0094;
    L_0x006a:
        r2 = r1.cfD;	 Catch:{ all -> 0x0091 }
        r10 = 1;
        r10 = java.lang.Integer.valueOf(r10);	 Catch:{ all -> 0x0091 }
        r7.put(r2, r10);	 Catch:{ all -> 0x0091 }
        r2 = new java.util.ArrayList;	 Catch:{ all -> 0x0091 }
        r2.<init>();	 Catch:{ all -> 0x0091 }
        r10 = r1.bGW;	 Catch:{ all -> 0x0091 }
        r2.add(r10);	 Catch:{ all -> 0x0091 }
        r10 = r1.cfD;	 Catch:{ all -> 0x0091 }
        r8.put(r10, r2);	 Catch:{ all -> 0x0091 }
    L_0x0083:
        r2 = r1.cfD;	 Catch:{ all -> 0x0091 }
        r2 = r3.contains(r2);	 Catch:{ all -> 0x0091 }
        if (r2 != 0) goto L_0x0046;
    L_0x008b:
        r1 = r1.cfD;	 Catch:{ all -> 0x0091 }
        r3.add(r1);	 Catch:{ all -> 0x0091 }
        goto L_0x0046;
    L_0x0091:
        r1 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0091 }
        throw r1;
    L_0x0094:
        r2 = r1.cfD;	 Catch:{ all -> 0x0091 }
        r2 = r7.get(r2);	 Catch:{ all -> 0x0091 }
        r2 = (java.lang.Integer) r2;	 Catch:{ all -> 0x0091 }
        r2 = r2.intValue();	 Catch:{ all -> 0x0091 }
        r2 = r2 + 1;
        r10 = r1.cfD;	 Catch:{ all -> 0x0091 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0091 }
        r7.put(r10, r2);	 Catch:{ all -> 0x0091 }
        r2 = r1.cfD;	 Catch:{ all -> 0x0091 }
        r2 = r8.get(r2);	 Catch:{ all -> 0x0091 }
        r2 = (java.util.ArrayList) r2;	 Catch:{ all -> 0x0091 }
        r10 = r1.bGW;	 Catch:{ all -> 0x0091 }
        r10 = r2.contains(r10);	 Catch:{ all -> 0x0091 }
        if (r10 != 0) goto L_0x00c0;
    L_0x00bb:
        r10 = r1.bGW;	 Catch:{ all -> 0x0091 }
        r2.add(r10);	 Catch:{ all -> 0x0091 }
    L_0x00c0:
        r10 = r1.cfD;	 Catch:{ all -> 0x0091 }
        r8.put(r10, r2);	 Catch:{ all -> 0x0091 }
        goto L_0x0083;
    L_0x00c6:
        monitor-exit(r4);	 Catch:{ all -> 0x0091 }
        r4 = "";
        r6 = com.tencent.mm.plugin.music.cache.e.bhL();
        r1 = "MicroMsg.Audio.AudioPlayerMgr";
        r2 = "removePlayerGroupMinCount:%d";
        r10 = 1;
        r10 = new java.lang.Object[r10];
        r11 = 0;
        r12 = java.lang.Integer.valueOf(r6);
        r10[r11] = r12;
        com.tencent.mm.sdk.platformtools.x.d(r1, r2, r10);
        r10 = r3.iterator();
        r3 = r6;
    L_0x00e6:
        r1 = r10.hasNext();
        if (r1 == 0) goto L_0x0121;
    L_0x00ec:
        r1 = r10.next();
        r1 = (java.lang.String) r1;
        r2 = r7.get(r1);
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        r11 = "MicroMsg.Audio.AudioPlayerMgr";
        r12 = "count:%d, url:%s";
        r13 = 2;
        r13 = new java.lang.Object[r13];
        r14 = 0;
        r15 = java.lang.Integer.valueOf(r2);
        r13[r14] = r15;
        r14 = 1;
        r13[r14] = r1;
        com.tencent.mm.sdk.platformtools.x.d(r11, r12, r13);
        if (r2 < r6) goto L_0x0240;
    L_0x0114:
        r5 = 1;
        if (r3 >= r2) goto L_0x023d;
    L_0x0117:
        r4 = r1;
    L_0x0118:
        r3 = android.text.TextUtils.isEmpty(r4);
        if (r3 == 0) goto L_0x011f;
    L_0x011e:
        r4 = r1;
    L_0x011f:
        r3 = r2;
        goto L_0x00e6;
    L_0x0121:
        if (r5 == 0) goto L_0x023a;
    L_0x0123:
        r0 = r16;
        r1 = r0.lwH;
        r0 = r17;
        r1 = r1.get(r0);
        r1 = (com.tencent.mm.z.a) r1;
        if (r1 == 0) goto L_0x023a;
    L_0x0131:
        if (r4 == 0) goto L_0x023a;
    L_0x0133:
        r1 = r1.cfD;
        r1 = r4.equalsIgnoreCase(r1);
        if (r1 == 0) goto L_0x023a;
    L_0x013b:
        r1 = "MicroMsg.Audio.AudioPlayerMgr";
        r2 = "srcUrl is same, not remove and don't play again";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        r5 = 0;
        r2 = r5;
    L_0x0146:
        if (r2 == 0) goto L_0x0229;
    L_0x0148:
        r1 = "MicroMsg.Audio.AudioPlayerMgr";
        r3 = "need to remove player";
        com.tencent.mm.sdk.platformtools.x.i(r1, r3);
        r1 = r8.get(r4);
        r1 = (java.util.ArrayList) r1;
        if (r1 == 0) goto L_0x01fb;
    L_0x0159:
        r3 = r1.size();
        if (r3 <= 0) goto L_0x01fb;
    L_0x015f:
        r3 = new java.util.LinkedList;
        r3.<init>();
        r4 = r1.iterator();
    L_0x0168:
        r1 = r4.hasNext();
        if (r1 == 0) goto L_0x0184;
    L_0x016e:
        r1 = r4.next();
        r1 = (java.lang.String) r1;
        r0 = r16;
        r5 = r0.lwH;
        r1 = r5.get(r1);
        r1 = (com.tencent.mm.z.a) r1;
        if (r1 == 0) goto L_0x0168;
    L_0x0180:
        r3.add(r1);
        goto L_0x0168;
    L_0x0184:
        r1 = new com.tencent.mm.plugin.music.a.d$a;
        r0 = r16;
        r1.<init>(r0);
        java.util.Collections.sort(r3, r1);
        r4 = new java.util.LinkedList;
        r4.<init>();
        r3 = r3.iterator();
    L_0x0197:
        r1 = r3.hasNext();
        if (r1 == 0) goto L_0x01a9;
    L_0x019d:
        r1 = r3.next();
        r1 = (com.tencent.mm.z.a) r1;
        r1 = r1.bGW;
        r4.add(r1);
        goto L_0x0197;
    L_0x01a9:
        r1 = r9 + -10;
        if (r1 <= 0) goto L_0x01fe;
    L_0x01ad:
        r3 = r4.size();
        if (r3 <= r1) goto L_0x01fe;
    L_0x01b3:
        r1 = r1 + 1;
        r3 = "MicroMsg.Audio.AudioPlayerMgr";
        r5 = "removeCount should be %d";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r8 = java.lang.Integer.valueOf(r1);
        r6[r7] = r8;
        com.tencent.mm.sdk.platformtools.x.i(r3, r5, r6);
        r3 = r4.size();
        r1 = r3 - r1;
        if (r1 >= 0) goto L_0x01d1;
    L_0x01d0:
        r1 = 1;
    L_0x01d1:
        r0 = r16;
        r3 = r0.lwJ;
        r5 = r4.size();
        r1 = r4.subList(r1, r5);
        r3.addAll(r1);
    L_0x01e0:
        r1 = "MicroMsg.Audio.AudioPlayerMgr";
        r3 = "need remove and stop player count : %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r0 = r16;
        r6 = r0.lwJ;
        r6 = r6.size();
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r1, r3, r4);
    L_0x01fb:
        r1 = r2;
        goto L_0x003d;
    L_0x01fe:
        if (r1 <= 0) goto L_0x0217;
    L_0x0200:
        r3 = r4.size();
        if (r3 >= r1) goto L_0x0217;
    L_0x0206:
        r0 = r16;
        r1 = r0.lwJ;
        r3 = 1;
        r5 = r4.size();
        r3 = r4.subList(r3, r5);
        r1.addAll(r3);
        goto L_0x01e0;
    L_0x0217:
        r0 = r16;
        r1 = r0.lwJ;
        r3 = r4.size();
        r3 = r3 + -1;
        r3 = r4.get(r3);
        r1.add(r3);
        goto L_0x01e0;
    L_0x0229:
        r1 = "MicroMsg.Audio.AudioPlayerMgr";
        r3 = "not need to remove player";
        com.tencent.mm.sdk.platformtools.x.i(r1, r3);
        r0 = r16;
        r1 = r0.lwJ;
        r1.clear();
        goto L_0x01fb;
    L_0x023a:
        r2 = r5;
        goto L_0x0146;
    L_0x023d:
        r2 = r3;
        goto L_0x0118;
    L_0x0240:
        r2 = r3;
        goto L_0x011f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.music.a.d.If(java.lang.String):boolean");
    }

    final void bhm() {
        x.i("MicroMsg.Audio.AudioPlayerMgr", "removeAndStopPlayingAudioPlayer");
        Iterator it = this.lwJ.iterator();
        while (it.hasNext()) {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player audioId : %s", new Object[]{(String) it.next()});
            HV(r0);
        }
        it = this.lwL.iterator();
        while (it.hasNext()) {
            x.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player for try audioId : %s", new Object[]{(String) it.next()});
            HV(r0);
        }
        this.lwJ.clear();
        this.lwL.clear();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final boolean Ig(java.lang.String r14) {
        /*
        r13 = this;
        r0 = "MicroMsg.Audio.AudioPlayerMgr";
        r1 = "canRemoveAudioPlayerInPlayingListForTry";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r4 = 0;
        r5 = new java.util.ArrayList;
        r5.<init>();
        r6 = new java.util.HashMap;
        r6.<init>();
        r7 = new java.util.HashMap;
        r7.<init>();
        r2 = r13.itk;
        monitor-enter(r2);
        r0 = r13.lwA;	 Catch:{ all -> 0x008a }
        r0 = r0.size();	 Catch:{ all -> 0x008a }
        r1 = 5;
        if (r0 > r1) goto L_0x003b;
    L_0x0025:
        r1 = "MicroMsg.Audio.AudioPlayerMgr";
        r3 = "playerCount:%d is not need to remove for try";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x008a }
        r5 = 0;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x008a }
        r4[r5] = r0;	 Catch:{ all -> 0x008a }
        com.tencent.mm.sdk.platformtools.x.i(r1, r3, r4);	 Catch:{ all -> 0x008a }
        r4 = 0;
        monitor-exit(r2);	 Catch:{ all -> 0x008a }
    L_0x003a:
        return r4;
    L_0x003b:
        r0 = r13.lwB;	 Catch:{ all -> 0x008a }
        r3 = r0.iterator();	 Catch:{ all -> 0x008a }
    L_0x0041:
        r0 = r3.hasNext();	 Catch:{ all -> 0x008a }
        if (r0 == 0) goto L_0x00bf;
    L_0x0047:
        r0 = r3.next();	 Catch:{ all -> 0x008a }
        r0 = (java.lang.String) r0;	 Catch:{ all -> 0x008a }
        r1 = r13.lwH;	 Catch:{ all -> 0x008a }
        r0 = r1.get(r0);	 Catch:{ all -> 0x008a }
        r0 = (com.tencent.mm.z.a) r0;	 Catch:{ all -> 0x008a }
        if (r0 == 0) goto L_0x0041;
    L_0x0057:
        r1 = r0.cfD;	 Catch:{ all -> 0x008a }
        if (r1 == 0) goto L_0x0041;
    L_0x005b:
        r1 = r0.cfD;	 Catch:{ all -> 0x008a }
        r1 = r6.containsKey(r1);	 Catch:{ all -> 0x008a }
        if (r1 != 0) goto L_0x008d;
    L_0x0063:
        r1 = r0.cfD;	 Catch:{ all -> 0x008a }
        r8 = 1;
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x008a }
        r6.put(r1, r8);	 Catch:{ all -> 0x008a }
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x008a }
        r1.<init>();	 Catch:{ all -> 0x008a }
        r8 = r0.bGW;	 Catch:{ all -> 0x008a }
        r1.add(r8);	 Catch:{ all -> 0x008a }
        r8 = r0.cfD;	 Catch:{ all -> 0x008a }
        r7.put(r8, r1);	 Catch:{ all -> 0x008a }
    L_0x007c:
        r1 = r0.cfD;	 Catch:{ all -> 0x008a }
        r1 = r5.contains(r1);	 Catch:{ all -> 0x008a }
        if (r1 != 0) goto L_0x0041;
    L_0x0084:
        r0 = r0.cfD;	 Catch:{ all -> 0x008a }
        r5.add(r0);	 Catch:{ all -> 0x008a }
        goto L_0x0041;
    L_0x008a:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x008a }
        throw r0;
    L_0x008d:
        r1 = r0.cfD;	 Catch:{ all -> 0x008a }
        r1 = r6.get(r1);	 Catch:{ all -> 0x008a }
        r1 = (java.lang.Integer) r1;	 Catch:{ all -> 0x008a }
        r1 = r1.intValue();	 Catch:{ all -> 0x008a }
        r1 = r1 + 1;
        r8 = r0.cfD;	 Catch:{ all -> 0x008a }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x008a }
        r6.put(r8, r1);	 Catch:{ all -> 0x008a }
        r1 = r0.cfD;	 Catch:{ all -> 0x008a }
        r1 = r7.get(r1);	 Catch:{ all -> 0x008a }
        r1 = (java.util.ArrayList) r1;	 Catch:{ all -> 0x008a }
        r8 = r0.bGW;	 Catch:{ all -> 0x008a }
        r8 = r1.contains(r8);	 Catch:{ all -> 0x008a }
        if (r8 != 0) goto L_0x00b9;
    L_0x00b4:
        r8 = r0.bGW;	 Catch:{ all -> 0x008a }
        r1.add(r8);	 Catch:{ all -> 0x008a }
    L_0x00b9:
        r8 = r0.cfD;	 Catch:{ all -> 0x008a }
        r7.put(r8, r1);	 Catch:{ all -> 0x008a }
        goto L_0x007c;
    L_0x00bf:
        monitor-exit(r2);	 Catch:{ all -> 0x008a }
        r0 = r13.lwH;
        r0 = r0.get(r14);
        r0 = (com.tencent.mm.z.a) r0;
        r2 = r5.iterator();
    L_0x00cc:
        r1 = r2.hasNext();
        if (r1 == 0) goto L_0x00f0;
    L_0x00d2:
        r1 = r2.next();
        r1 = (java.lang.String) r1;
        if (r0 == 0) goto L_0x00cc;
    L_0x00da:
        if (r1 == 0) goto L_0x00cc;
    L_0x00dc:
        r3 = r0.cfD;
        r1 = r1.equalsIgnoreCase(r3);
        if (r1 == 0) goto L_0x00cc;
    L_0x00e4:
        r0 = "MicroMsg.Audio.AudioPlayerMgr";
        r1 = "srcUrl is same, not remove and don't play again for try";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r4 = 0;
        goto L_0x003a;
    L_0x00f0:
        r3 = "";
        r0 = "MicroMsg.Audio.AudioPlayerMgr";
        r1 = "removePlayerGroupMinCountForTry:%d";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r8 = 0;
        r9 = 2;
        r9 = java.lang.Integer.valueOf(r9);
        r2[r8] = r9;
        com.tencent.mm.sdk.platformtools.x.d(r0, r1, r2);
        r2 = 2;
        r5 = r5.iterator();
    L_0x010c:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x0148;
    L_0x0112:
        r0 = r5.next();
        r0 = (java.lang.String) r0;
        r1 = r6.get(r0);
        r1 = (java.lang.Integer) r1;
        r1 = r1.intValue();
        r8 = "MicroMsg.Audio.AudioPlayerMgr";
        r9 = "count:%d, url:%s";
        r10 = 2;
        r10 = new java.lang.Object[r10];
        r11 = 0;
        r12 = java.lang.Integer.valueOf(r1);
        r10[r11] = r12;
        r11 = 1;
        r10[r11] = r0;
        com.tencent.mm.sdk.platformtools.x.d(r8, r9, r10);
        r8 = 2;
        if (r1 < r8) goto L_0x01d9;
    L_0x013b:
        r4 = 1;
        if (r2 >= r1) goto L_0x01d6;
    L_0x013e:
        r3 = r0;
    L_0x013f:
        r2 = android.text.TextUtils.isEmpty(r3);
        if (r2 == 0) goto L_0x0146;
    L_0x0145:
        r3 = r0;
    L_0x0146:
        r2 = r1;
        goto L_0x010c;
    L_0x0148:
        if (r4 == 0) goto L_0x01cb;
    L_0x014a:
        r0 = "MicroMsg.Audio.AudioPlayerMgr";
        r1 = "need to remove player";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = r7.get(r3);
        r0 = (java.util.ArrayList) r0;
        if (r0 == 0) goto L_0x003a;
    L_0x015b:
        r1 = r0.size();
        if (r1 <= 0) goto L_0x003a;
    L_0x0161:
        r1 = new java.util.LinkedList;
        r1.<init>();
        r2 = r0.iterator();
    L_0x016a:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x0184;
    L_0x0170:
        r0 = r2.next();
        r0 = (java.lang.String) r0;
        r3 = r13.lwH;
        r0 = r3.get(r0);
        r0 = (com.tencent.mm.z.a) r0;
        if (r0 == 0) goto L_0x016a;
    L_0x0180:
        r1.add(r0);
        goto L_0x016a;
    L_0x0184:
        r0 = new com.tencent.mm.plugin.music.a.d$a;
        r0.<init>(r13);
        java.util.Collections.sort(r1, r0);
        r2 = new java.util.LinkedList;
        r2.<init>();
        r1 = r1.iterator();
    L_0x0195:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x01a7;
    L_0x019b:
        r0 = r1.next();
        r0 = (com.tencent.mm.z.a) r0;
        r0 = r0.bGW;
        r2.add(r0);
        goto L_0x0195;
    L_0x01a7:
        r0 = r13.lwL;
        r1 = r2.getLast();
        r0.add(r1);
        r0 = "MicroMsg.Audio.AudioPlayerMgr";
        r1 = "need remove and stop player count for try: %d";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r5 = r13.lwL;
        r5 = r5.size();
        r5 = java.lang.Integer.valueOf(r5);
        r2[r3] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        goto L_0x003a;
    L_0x01cb:
        r0 = "MicroMsg.Audio.AudioPlayerMgr";
        r1 = "not need to remove player for try";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x003a;
    L_0x01d6:
        r1 = r2;
        goto L_0x013f;
    L_0x01d9:
        r1 = r2;
        goto L_0x0146;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.music.a.d.Ig(java.lang.String):boolean");
    }
}
