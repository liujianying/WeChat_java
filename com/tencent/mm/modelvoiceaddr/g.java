package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.byr;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class g {
    String eqL;
    LinkedHashMap<String, a> eqM = new LinkedHashMap();
    final ReadWriteLock eqN = new ReentrantReadWriteLock();
    private StringBuilder eqO = new StringBuilder();

    public g(String str) {
        this.eqL = str;
    }

    public final LinkedList<bhz> Ue() {
        LinkedList<bhz> linkedList = new LinkedList();
        this.eqN.readLock().lock();
        for (a aVar : this.eqM.values()) {
            if (aVar.eqQ) {
                linkedList.add(new bhz().VO(aVar.eqP));
            }
        }
        this.eqN.readLock().unlock();
        return linkedList;
    }

    public final String getResult() {
        this.eqO.setLength(0);
        this.eqN.readLock().lock();
        for (a aVar : this.eqM.values()) {
            if (aVar.data != null) {
                this.eqO.append(aVar.data);
            }
        }
        this.eqN.readLock().unlock();
        return this.eqO.toString();
    }

    public final boolean Uf() {
        this.eqN.readLock().lock();
        if (this.eqM.size() == 0) {
            x.i("MicroMsg.ShortSentenceContainer", "isAllRespEnd innerContainer.size() == 0");
            return false;
        }
        boolean z;
        for (a aVar : this.eqM.values()) {
            x.d("MicroMsg.ShortSentenceContainer", "isAllRespEnd voiceId:%s isRequestEnd:%s isResponseEnd:%s", new Object[]{aVar.eqP, Boolean.valueOf(aVar.eqR), Boolean.valueOf(aVar.eqV)});
            if (!((a) r3.next()).eqV) {
                z = false;
                break;
            }
        }
        z = true;
        this.eqN.readLock().unlock();
        return z;
    }

    public final void Y(List<byr> list) {
        String str;
        String str2 = "MicroMsg.ShortSentenceContainer";
        String str3 = "updateVoiceInfoResult respVTList size %s innerContainer %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
        this.eqN.readLock().lock();
        if (this.eqM.size() == 0) {
            this.eqN.readLock().unlock();
            str = "[]";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            for (a aVar : this.eqM.values()) {
                stringBuilder.append(aVar.eqP).append(", ");
            }
            if (stringBuilder.length() <= 3) {
                this.eqN.readLock().unlock();
                str = stringBuilder.append("]").toString();
            } else {
                stringBuilder.setLength(stringBuilder.length() - 2);
                this.eqN.readLock().unlock();
                str = stringBuilder.append("]").toString();
            }
        }
        objArr[1] = str;
        x.d(str2, str3, objArr);
        if (list == null || list.size() == 0) {
            x.i("MicroMsg.ShortSentenceContainer", "respList == null");
            return;
        }
        this.eqN.readLock().lock();
        for (byr byr : list) {
            if (byr == null) {
                x.i("MicroMsg.ShortSentenceContainer", "setFetchedVoiceInfoResult voiceTransCell is null.");
            } else {
                a aVar2 = (a) this.eqM.get(byr.rsZ);
                if (aVar2 == null) {
                    x.i("MicroMsg.ShortSentenceContainer", "voiceInfoContainer not found the voiceId %s", new Object[]{byr.rsZ});
                } else if (byr == null) {
                    x.d("MicroMsg.ShortSentenceContainer", "update VoiceInfo cell is null");
                } else {
                    String str4 = "MicroMsg.ShortSentenceContainer";
                    String str5 = "update VoiceInfo get {cell} %s, seq %s, text %s, endFlag %s, endFlag %s {currentInfo} %s, isRequestStart %s, isRequestEnd %s, voiceFileMark %s, seq %s, data %s, isResponseEnd %s";
                    Object[] objArr2 = new Object[12];
                    objArr2[0] = byr.rsZ;
                    objArr2[1] = Integer.valueOf(byr.suB);
                    Integer valueOf = (byr.ssr == null || byr.ssr.siK == null) ? null : Integer.valueOf(byr.ssr.siI);
                    objArr2[2] = valueOf;
                    objArr2[3] = Boolean.valueOf(byr.rgC != 0);
                    objArr2[4] = Integer.valueOf(byr.rgC);
                    objArr2[5] = aVar2.eqP;
                    objArr2[6] = Boolean.valueOf(aVar2.eqQ);
                    objArr2[7] = Boolean.valueOf(aVar2.eqR);
                    objArr2[8] = Integer.valueOf(aVar2.eqS);
                    objArr2[9] = Integer.valueOf(aVar2.eqU);
                    objArr2[10] = aVar2.data == null ? null : Integer.valueOf(aVar2.data.length());
                    objArr2[11] = Boolean.valueOf(aVar2.eqV);
                    x.d(str4, str5, objArr2);
                    if (byr.suB < aVar2.eqU || aVar2.eqV) {
                        x.d("MicroMsg.ShortSentenceContainer", "update seq not fit.");
                    } else {
                        aVar2.eqU = byr.suB;
                        str3 = (byr.ssr == null || byr.ssr.siK == null) ? null : byr.ssr.siK.cfV();
                        aVar2.data = str3;
                        aVar2.eqV = byr.rgC != 0;
                        str3 = "MicroMsg.ShortSentenceContainer";
                        str4 = "update VoiceId = %s,respSeq = %s,isResponseEnd = %s,data.length = %s";
                        Object[] objArr3 = new Object[4];
                        objArr3[0] = byr.rsZ;
                        objArr3[1] = Integer.valueOf(aVar2.eqU);
                        objArr3[2] = Boolean.valueOf(aVar2.eqV);
                        objArr3[3] = Integer.valueOf(aVar2.data == null ? -1 : aVar2.data.length());
                        x.i(str3, str4, objArr3);
                        if (byr.rgC == 2) {
                            x.e("MicroMsg.ShortSentenceContainer", "update cell.EndFlag = 2 VoiceId = %s", new Object[]{byr.rsZ});
                        }
                    }
                }
            }
        }
        this.eqN.readLock().unlock();
    }

    public final void iI(int i) {
        x.i("MicroMsg.ShortSentenceContainer", "cutShortSentence markEnd:%s", new Object[]{Integer.valueOf(i)});
        if (i < 0) {
            throw new IllegalStateException("splitShortSentence file mark less than zero. mark: " + i);
        }
        this.eqN.readLock().lock();
        if (this.eqM.size() == 0) {
            x.e("MicroMsg.ShortSentenceContainer", "splitShortSentence there is no last one");
            return;
        }
        a aVar = null;
        for (a aVar2 : this.eqM.values()) {
        }
        if (aVar2 == null) {
            throw new IllegalStateException("splitShortSentence last info is null");
        }
        x.d("MicroMsg.ShortSentenceContainer", "cutShortSentence voiceFileMarkEnd:%s voiceId:%s markEnd:%s", new Object[]{Integer.valueOf(aVar2.eqS), aVar2.eqP, Integer.valueOf(i)});
        aVar2.eqS = i;
        this.eqN.readLock().unlock();
    }

    public final a iJ(int i) {
        this.eqN.readLock().lock();
        if (this.eqM.size() == 0) {
            return null;
        }
        for (a aVar : this.eqM.values()) {
            x.d("MicroMsg.ShortSentenceContainer", "locateCurrentShortSentence oldOffset = %s voiceFileMarkEnd = %s info.isRequestEnd = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(aVar.eqS), Boolean.valueOf(aVar.eqR)});
            if (!aVar.eqR && i <= aVar.eqS) {
                break;
            }
        }
        a aVar2 = null;
        this.eqN.readLock().unlock();
        return aVar2;
    }
}
