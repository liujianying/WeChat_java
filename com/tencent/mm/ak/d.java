package com.tencent.mm.ak;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.f;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class d implements e, f {
    b dTA = null;
    private k dTB = null;
    public boolean dTC = false;
    List<b> dTy = new LinkedList();
    private HashSet<b> dTz = new HashSet();

    public d() {
        g.Eh().dpP.a(109, (e) this);
    }

    public final boolean a(long j, long j2, int i, Object obj, int i2, a aVar) {
        return a(j, j2, i, obj, i2, aVar, -1) >= 0;
    }

    public final int a(long j, long j2, int i, Object obj, int i2, a aVar, int i3) {
        if (aVar == null) {
            x.e("ModelImage.DownloadImgService", "listener is null");
            return -1;
        }
        b bVar = new b(j, j2, i);
        bVar.dTG = i2;
        if (this.dTz.contains(bVar)) {
            x.e("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] add failed, task already done");
            return -2;
        } else if (this.dTA != null && bVar.equals(this.dTA)) {
            return this.dTA.a(aVar, obj) ? 0 : -3;
        } else {
            int indexOf = this.dTy.indexOf(bVar);
            if (indexOf >= 0 && indexOf < this.dTy.size()) {
                return ((b) this.dTy.get(indexOf)).a(aVar, obj) ? 0 : -4;
            } else {
                x.i("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] no found task, create a new task(" + j + " " + j2 + " " + i + ") mLockStart: %s callbackDuration %s", Boolean.valueOf(this.dTC), Integer.valueOf(i3));
                bVar.a(aVar, obj);
                this.dTy.add(bVar);
                hI(i3);
                return 0;
            }
        }
    }

    public final boolean a(long j, long j2, int i) {
        b bVar = new b(j, j2, i);
        if ((this.dTA == null || !this.dTA.equals(bVar)) && this.dTy.indexOf(bVar) < 0) {
            return false;
        }
        return true;
    }

    public final boolean a(long j, long j2, a aVar) {
        if (aVar == null) {
            x.e("ModelImage.DownloadImgService", "listener is null");
            return false;
        }
        b bVar = new b(j, j2, 1);
        b bVar2 = null;
        if (this.dTA == null || !this.dTA.equals(bVar)) {
            int indexOf = this.dTy.indexOf(bVar);
            if (-1 != indexOf) {
                bVar2 = (b) this.dTy.get(indexOf);
            }
        } else {
            bVar2 = this.dTA;
        }
        if (bVar2 != null) {
            bVar2.b(aVar);
            a(bVar2);
            x.i("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] task has been canceled, (" + j + ", " + j2 + ", 1)");
            return true;
        }
        x.e("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] task no found, (" + j + ", " + j2 + ", 1)");
        return false;
    }

    public final void a(a aVar) {
        if (aVar == null) {
            x.e("ModelImage.DownloadImgService", "listener is null");
            return;
        }
        String str;
        String str2;
        Object[] objArr;
        b bVar;
        x.i("ModelImage.DownloadImgService", "[" + aVar.hashCode() + "] cancel all tasks of listener");
        this.dTC = true;
        if (this.dTA != null) {
            String str3;
            str = "ModelImage.DownloadImgService";
            str2 = "cancelAllTaskByListener CurTaskInfo %s mTodoList %s mLockStart %s";
            objArr = new Object[3];
            if (this.dTA == null) {
                str3 = "mCurTaskInfo is null";
            } else {
                str3 = this.dTA.dTD + ", " + this.dTA.dTE + ", " + this.dTA.dTF;
            }
            objArr[0] = str3;
            objArr[1] = Integer.valueOf(this.dTy.size());
            objArr[2] = Boolean.valueOf(this.dTC);
            x.i(str, str2, objArr);
            this.dTA.b(aVar);
            bVar = this.dTA;
            if (bVar.dTH != null) {
                bVar.dTH.clear();
            }
            a(this.dTA);
        }
        List<b> linkedList = new LinkedList();
        for (b bVar2 : this.dTy) {
            linkedList.add(bVar2);
        }
        for (b bVar22 : linkedList) {
            bVar22.b(aVar);
            a(bVar22);
        }
        OL();
        str = "ModelImage.DownloadImgService";
        str2 = "[ %s ] cancelAllTaskByListener done mCurTaskInfo %s";
        objArr = new Object[2];
        objArr[0] = Integer.valueOf(aVar.hashCode());
        objArr[1] = this.dTA == null ? "mCurTaskInfo is null" : this.dTA.dTD + ", " + this.dTA.dTE + ", " + this.dTA.dTF;
        x.i(str, str2, objArr);
    }

    private boolean a(b bVar) {
        if (bVar == null || bVar.dTH.size() > 0) {
            return false;
        }
        return b(bVar);
    }

    public final boolean l(long j, long j2) {
        return b(new b(j, j2, 1));
    }

    final boolean b(b bVar) {
        if (bVar == null) {
            x.e("ModelImage.DownloadImgService", "task is null");
            return false;
        }
        x.i("ModelImage.DownloadImgService", "cancel scene, (" + bVar.dTD + ", " + bVar.dTE + ", " + bVar.dTF + ")");
        if (this.dTA != null && this.dTA.equals(bVar)) {
            g.Eh().dpP.c(this.dTB);
            this.dTB = null;
            x.i("ModelImage.DownloadImgService", "cancelNetScene reset curTaskInfo (%s %s %s)", Long.valueOf(bVar.dTD), Long.valueOf(bVar.dTE), Integer.valueOf(bVar.dTF));
            c(this.dTA);
            this.dTA = null;
            hI(-1);
            return true;
        } else if (!this.dTy.contains(bVar)) {
            return false;
        } else {
            b bVar2 = (b) this.dTy.get(this.dTy.indexOf(bVar));
            if (bVar2 != null) {
                this.dTy.remove(bVar2);
                c(bVar2);
            }
            return true;
        }
    }

    private static void c(b bVar) {
        if (bVar == null) {
            x.e("ModelImage.DownloadImgService", "task is null");
        } else if (bVar.dTH == null) {
            x.e("ModelImage.DownloadImgService", "task callback list is null");
        } else {
            for (c cVar : bVar.dTH) {
                if (cVar.dTI != null) {
                    cVar.dTI.a(bVar.dTD, bVar.dTE, bVar.dTF, bVar.dTG, cVar.dTJ);
                }
            }
        }
    }

    public final void OL() {
        this.dTC = false;
        hI(-1);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.dTB != lVar) {
            x.d("ModelImage.DownloadImgService", "scene changed");
            return;
        }
        this.dTz.add(new b(this.dTA.dTD, this.dTA.dTE, this.dTA.dTF));
        x.i("ModelImage.DownloadImgService", "scene end, (" + this.dTA.dTD + ", " + this.dTA.dTE + ", " + this.dTA.dTF + ")");
        for (c cVar : this.dTA.dTH) {
            if (cVar.dTI != null) {
                cVar.dTI.a(this.dTA.dTD, this.dTA.dTE, this.dTA.dTF, this.dTA.dTG, cVar.dTJ, i, i2, str, lVar);
            }
        }
        this.dTA = null;
        this.dTB = null;
        hI(-1);
    }

    public final void a(int i, int i2, l lVar) {
        if (this.dTB != lVar) {
            x.d("ModelImage.DownloadImgService", "scene changed");
            return;
        }
        for (c cVar : this.dTA.dTH) {
            if (cVar.dTI != null) {
                cVar.dTI.a(this.dTA.dTD, this.dTA.dTE, this.dTA.dTF, this.dTA.dTG, cVar.dTJ, i, i2, lVar);
            }
        }
    }

    private void hI(int i) {
        if (this.dTA != null || this.dTy.size() <= 0 || true == this.dTC) {
            String str = "ModelImage.DownloadImgService";
            String str2 = "mCurTaskInfo %s mTodoList %s mLockStart %s";
            Object[] objArr = new Object[3];
            objArr[0] = this.dTA == null ? "mCurTaskInfo is null" : this.dTA.dTD + ", " + this.dTA.dTE + ", " + this.dTA.dTF;
            objArr[1] = Integer.valueOf(this.dTy.size());
            objArr[2] = Boolean.valueOf(this.dTC);
            x.i(str, str2, objArr);
            return;
        }
        this.dTA = (b) this.dTy.get(0);
        this.dTy.remove(0);
        this.dTB = new k(this.dTA.dTD, this.dTA.dTE, this.dTA.dTF, this, i);
        this.dTB.dVo = this.dTA.dTG;
        x.i("ModelImage.DownloadImgService", "do scene, (" + this.dTA.dTD + ", " + this.dTA.dTE + ", " + this.dTA.dTF + ")");
        g.Eh().dpP.a(this.dTB, 0);
    }
}
