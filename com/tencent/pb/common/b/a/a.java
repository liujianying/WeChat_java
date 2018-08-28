package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;
import com.google.a.a.g;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.util.Arrays;

public interface a {

    public static final class ad extends e {
        public String groupId;
        public int oLB;
        public long oLC;
        public String vcI;

        public ad() {
            this.groupId = "";
            this.oLB = 0;
            this.oLC = 0;
            this.vcI = "";
            this.bfP = -1;
        }

        public final void a(b bVar) {
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.oLB != 0) {
                bVar.aE(2, this.oLB);
            }
            if (this.oLC != 0) {
                bVar.j(3, this.oLC);
            }
            if (!this.vcI.equals("")) {
                bVar.g(4, this.vcI);
            }
            super.a(bVar);
        }

        protected final int sl() {
            int sl = super.sl();
            if (!this.groupId.equals("")) {
                sl += b.h(1, this.groupId);
            }
            if (this.oLB != 0) {
                sl += b.aG(2, this.oLB);
            }
            if (this.oLC != 0) {
                sl += b.l(3, this.oLC);
            }
            if (this.vcI.equals("")) {
                return sl;
            }
            return sl + b.h(4, this.vcI);
        }
    }

    public static final class af extends e {
        public int kpo;
        public long kpp;
        public int veo;
        public int vep;
        public int veq;
        public int ves;
        public int vet;
        public int veu;
        public int vev;
        public int vew;

        public af() {
            this.veo = 0;
            this.kpo = 0;
            this.kpp = 0;
            this.vep = 0;
            this.veq = 0;
            this.ves = 0;
            this.vet = 0;
            this.veu = 0;
            this.vev = -1;
            this.vew = 0;
            this.bfP = -1;
        }

        public final void a(b bVar) {
            if (this.veo != 0) {
                bVar.aF(1, this.veo);
            }
            if (this.kpo != 0) {
                bVar.aE(2, this.kpo);
            }
            if (this.kpp != 0) {
                bVar.j(3, this.kpp);
            }
            if (this.vep != 0) {
                bVar.aF(4, this.vep);
            }
            if (this.veq != 0) {
                bVar.aF(5, this.veq);
            }
            if (this.ves != 0) {
                bVar.aF(6, this.ves);
            }
            if (this.vet != 0) {
                bVar.aF(7, this.vet);
            }
            if (this.veu != 0) {
                bVar.aF(8, this.veu);
            }
            if (this.vev != -1) {
                bVar.aE(9, this.vev);
            }
            if (this.vew != 0) {
                bVar.aE(10, this.vew);
            }
            super.a(bVar);
        }

        protected final int sl() {
            int sl = super.sl();
            if (this.veo != 0) {
                sl += b.aH(1, this.veo);
            }
            if (this.kpo != 0) {
                sl += b.aG(2, this.kpo);
            }
            if (this.kpp != 0) {
                sl += b.l(3, this.kpp);
            }
            if (this.vep != 0) {
                sl += b.aH(4, this.vep);
            }
            if (this.veq != 0) {
                sl += b.aH(5, this.veq);
            }
            if (this.ves != 0) {
                sl += b.aH(6, this.ves);
            }
            if (this.vet != 0) {
                sl += b.aH(7, this.vet);
            }
            if (this.veu != 0) {
                sl += b.aH(8, this.veu);
            }
            if (this.vev != -1) {
                sl += b.aG(9, this.vev);
            }
            return this.vew != 0 ? sl + b.aG(10, this.vew) : sl;
        }
    }

    public static final class am extends e {
        private static volatile am[] vey;
        public int kpU;
        public int qXJ;
        public int veA;
        public String vez;

        public am() {
            this.kpU = 0;
            this.vez = "";
            this.qXJ = 0;
            this.veA = 0;
            this.bfP = -1;
        }

        public static am[] cEw() {
            if (vey == null) {
                synchronized (c.bfO) {
                    if (vey == null) {
                        vey = new am[0];
                    }
                }
            }
            return vey;
        }

        public final void a(b bVar) {
            if (this.kpU != 0) {
                bVar.aF(1, this.kpU);
            }
            if (!this.vez.equals("")) {
                bVar.g(2, this.vez);
            }
            if (this.qXJ != 0) {
                bVar.aF(3, this.qXJ);
            }
            if (this.veA != 0) {
                bVar.aF(4, this.veA);
            }
            super.a(bVar);
        }

        protected final int sl() {
            int sl = super.sl();
            if (this.kpU != 0) {
                sl += b.aH(1, this.kpU);
            }
            if (!this.vez.equals("")) {
                sl += b.h(2, this.vez);
            }
            if (this.qXJ != 0) {
                sl += b.aH(3, this.qXJ);
            }
            return this.veA != 0 ? sl + b.aH(4, this.veA) : sl;
        }
    }

    public static final class at extends e {
        public int bOS;
        public byte[] bjO;
        public String name;
        public byte[] veU;
        public long veV;
        public byte[] veW;
        public byte[] veX;
        public byte[] veY;
        public ax veZ;
        public byte[] vfa;
        public ap vfb;
        public String vfc;
        public String vfd;
        public long vfe;
        public byte[] vff;
        public byte[] vfg;
        public byte[] vfh;
        public byte[] vfi;
        public int vfj;
        public byte[] vfk;
        public byte[] vfl;
        public int vfm;
        public n[] vfn;

        public at() {
            this.name = "";
            this.veU = g.bfW;
            this.bOS = 0;
            this.veV = 0;
            this.veW = g.bfW;
            this.veX = g.bfW;
            this.veY = g.bfW;
            this.veZ = null;
            this.vfa = g.bfW;
            this.vfb = null;
            this.vfc = "";
            this.vfd = "";
            this.vfe = 0;
            this.vff = g.bfW;
            this.vfg = g.bfW;
            this.vfh = g.bfW;
            this.vfi = g.bfW;
            this.vfj = 0;
            this.vfk = g.bfW;
            this.vfl = g.bfW;
            this.bjO = g.bfW;
            this.vfm = 0;
            this.vfn = n.cEt();
            this.bfP = -1;
        }

        public final void a(b bVar) {
            if (!this.name.equals("")) {
                bVar.g(1, this.name);
            }
            if (!Arrays.equals(this.veU, g.bfW)) {
                bVar.b(2, this.veU);
            }
            if (this.bOS != 0) {
                bVar.aE(3, this.bOS);
            }
            if (this.veV != 0) {
                bVar.i(4, this.veV);
            }
            if (!Arrays.equals(this.veW, g.bfW)) {
                bVar.b(5, this.veW);
            }
            if (!Arrays.equals(this.veX, g.bfW)) {
                bVar.b(6, this.veX);
            }
            if (!Arrays.equals(this.veY, g.bfW)) {
                bVar.b(7, this.veY);
            }
            if (this.veZ != null) {
                bVar.a(8, this.veZ);
            }
            if (!Arrays.equals(this.vfa, g.bfW)) {
                bVar.b(9, this.vfa);
            }
            if (this.vfb != null) {
                bVar.a(10, this.vfb);
            }
            if (!this.vfc.equals("")) {
                bVar.g(100, this.vfc);
            }
            if (!this.vfd.equals("")) {
                bVar.g(101, this.vfd);
            }
            if (this.vfe != 0) {
                bVar.i(200, this.vfe);
            }
            if (!Arrays.equals(this.vff, g.bfW)) {
                bVar.b(TbsListener$ErrorCode.EXCEED_UNZIP_RETRY_NUM, this.vff);
            }
            if (!Arrays.equals(this.vfg, g.bfW)) {
                bVar.b(TbsListener$ErrorCode.APK_PATH_ERROR, this.vfg);
            }
            if (!Arrays.equals(this.vfh, g.bfW)) {
                bVar.b(TbsListener$ErrorCode.APK_VERSION_ERROR, this.vfh);
            }
            if (!Arrays.equals(this.vfi, g.bfW)) {
                bVar.b(TbsListener$ErrorCode.APK_INVALID, this.vfi);
            }
            if (this.vfj != 0) {
                bVar.aE(TbsListener$ErrorCode.COPY_INSTALL_SUCCESS, this.vfj);
            }
            if (!Arrays.equals(this.vfk, g.bfW)) {
                bVar.b(TbsListener$ErrorCode.INCRUPDATE_INSTALL_SUCCESS, this.vfk);
            }
            if (!Arrays.equals(this.vfl, g.bfW)) {
                bVar.b(TbsListener$ErrorCode.UNLZMA_FAIURE, this.vfl);
            }
            if (!Arrays.equals(this.bjO, g.bfW)) {
                bVar.b(TbsListener$ErrorCode.EXCEED_LZMA_RETRY_NUM, this.bjO);
            }
            if (this.vfm != 0) {
                bVar.aF(TbsListener$ErrorCode.EXCEED_INCR_UPDATE, this.vfm);
            }
            if (this.vfn != null && this.vfn.length > 0) {
                for (e eVar : this.vfn) {
                    if (eVar != null) {
                        bVar.a(TbsListener$ErrorCode.CREATE_TEMP_CONF_ERROR, eVar);
                    }
                }
            }
            super.a(bVar);
        }

        protected final int sl() {
            int sl = super.sl();
            if (!this.name.equals("")) {
                sl += b.h(1, this.name);
            }
            if (!Arrays.equals(this.veU, g.bfW)) {
                sl += b.c(2, this.veU);
            }
            if (this.bOS != 0) {
                sl += b.aG(3, this.bOS);
            }
            if (this.veV != 0) {
                sl += b.k(4, this.veV);
            }
            if (!Arrays.equals(this.veW, g.bfW)) {
                sl += b.c(5, this.veW);
            }
            if (!Arrays.equals(this.veX, g.bfW)) {
                sl += b.c(6, this.veX);
            }
            if (!Arrays.equals(this.veY, g.bfW)) {
                sl += b.c(7, this.veY);
            }
            if (this.veZ != null) {
                sl += b.b(8, this.veZ);
            }
            if (!Arrays.equals(this.vfa, g.bfW)) {
                sl += b.c(9, this.vfa);
            }
            if (this.vfb != null) {
                sl += b.b(10, this.vfb);
            }
            if (!this.vfc.equals("")) {
                sl += b.h(100, this.vfc);
            }
            if (!this.vfd.equals("")) {
                sl += b.h(101, this.vfd);
            }
            if (this.vfe != 0) {
                sl += b.k(200, this.vfe);
            }
            if (!Arrays.equals(this.vff, g.bfW)) {
                sl += b.c(TbsListener$ErrorCode.EXCEED_UNZIP_RETRY_NUM, this.vff);
            }
            if (!Arrays.equals(this.vfg, g.bfW)) {
                sl += b.c(TbsListener$ErrorCode.APK_PATH_ERROR, this.vfg);
            }
            if (!Arrays.equals(this.vfh, g.bfW)) {
                sl += b.c(TbsListener$ErrorCode.APK_VERSION_ERROR, this.vfh);
            }
            if (!Arrays.equals(this.vfi, g.bfW)) {
                sl += b.c(TbsListener$ErrorCode.APK_INVALID, this.vfi);
            }
            if (this.vfj != 0) {
                sl += b.aG(TbsListener$ErrorCode.COPY_INSTALL_SUCCESS, this.vfj);
            }
            if (!Arrays.equals(this.vfk, g.bfW)) {
                sl += b.c(TbsListener$ErrorCode.INCRUPDATE_INSTALL_SUCCESS, this.vfk);
            }
            if (!Arrays.equals(this.vfl, g.bfW)) {
                sl += b.c(TbsListener$ErrorCode.UNLZMA_FAIURE, this.vfl);
            }
            if (!Arrays.equals(this.bjO, g.bfW)) {
                sl += b.c(TbsListener$ErrorCode.EXCEED_LZMA_RETRY_NUM, this.bjO);
            }
            if (this.vfm != 0) {
                sl += b.aH(TbsListener$ErrorCode.EXCEED_INCR_UPDATE, this.vfm);
            }
            if (this.vfn == null || this.vfn.length <= 0) {
                return sl;
            }
            while (true) {
                int i = sl;
                if (0 >= this.vfn.length) {
                    return i;
                }
                e eVar = this.vfn[0];
                if (eVar != null) {
                    i += b.b(TbsListener$ErrorCode.CREATE_TEMP_CONF_ERROR, eVar);
                }
                sl = 0 + 1;
            }
        }
    }

    public static final class au extends e {
        private static volatile au[] vfo;
        public String groupId;
        public int oLB;
        public long oLC;
        public int vcN;
        public av[] vea;
        public String vfp;

        public static au[] cEz() {
            if (vfo == null) {
                synchronized (c.bfO) {
                    if (vfo == null) {
                        vfo = new au[0];
                    }
                }
            }
            return vfo;
        }

        public au() {
            this.groupId = "";
            this.oLB = 0;
            this.oLC = 0;
            this.vea = av.cEA();
            this.vcN = 0;
            this.vfp = "";
            this.bfP = -1;
        }

        public final void a(b bVar) {
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.oLB != 0) {
                bVar.aE(2, this.oLB);
            }
            if (this.oLC != 0) {
                bVar.j(3, this.oLC);
            }
            if (this.vea != null && this.vea.length > 0) {
                for (e eVar : this.vea) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.vcN != 0) {
                bVar.aF(5, this.vcN);
            }
            if (!this.vfp.equals("")) {
                bVar.g(6, this.vfp);
            }
            super.a(bVar);
        }

        protected final int sl() {
            int sl = super.sl();
            if (!this.groupId.equals("")) {
                sl += b.h(1, this.groupId);
            }
            if (this.oLB != 0) {
                sl += b.aG(2, this.oLB);
            }
            if (this.oLC != 0) {
                sl += b.l(3, this.oLC);
            }
            if (this.vea != null && this.vea.length > 0) {
                int i;
                while (true) {
                    i = sl;
                    if (0 >= this.vea.length) {
                        break;
                    }
                    e eVar = this.vea[0];
                    if (eVar != null) {
                        i += b.b(4, eVar);
                    }
                    sl = 0 + 1;
                }
                sl = i;
            }
            if (this.vcN != 0) {
                sl += b.aH(5, this.vcN);
            }
            if (this.vfp.equals("")) {
                return sl;
            }
            return sl + b.h(6, this.vfp);
        }
    }

    public static final class av extends e {
        private static volatile av[] vfq;
        public int aAk;
        public int kpU;
        public int oWZ;
        public int qXJ;
        public int seW;
        public int status;
        public int vcT;
        public byte[] vcY;
        public String vez;
        public int vfA;
        public int vfB;
        public int vfC;
        public an vfD;
        public String vfE;
        public int vfF;
        public s vfG;
        public int vfH;
        public String vfI;
        public int vfJ;
        public int vfK;
        public int vfL;
        public int vfr;
        public int vfs;
        public aq vft;
        public int vfu;
        public String vfv;
        public ar[] vfw;
        public int vfx;
        public int[] vfy;
        public int vfz;

        public static av[] cEA() {
            if (vfq == null) {
                synchronized (c.bfO) {
                    if (vfq == null) {
                        vfq = new av[0];
                    }
                }
            }
            return vfq;
        }

        public av() {
            this.qXJ = 0;
            this.vfr = 0;
            this.status = 0;
            this.aAk = 0;
            this.kpU = -1;
            this.vfs = 0;
            this.vft = null;
            this.vfu = 0;
            this.vfv = "";
            this.vfw = ar.cEy();
            this.vfx = 0;
            this.vfy = g.bfQ;
            this.vfz = 0;
            this.vfA = 0;
            this.vfB = 0;
            this.vfC = 0;
            this.vfD = null;
            this.vez = "";
            this.vfE = "";
            this.vfF = 0;
            this.vcY = g.bfW;
            this.vfG = null;
            this.vfH = -1;
            this.vfI = "";
            this.seW = 0;
            this.vfJ = 0;
            this.oWZ = 0;
            this.vfK = 0;
            this.vfL = 0;
            this.vcT = 0;
            this.bfP = -1;
        }

        public final void a(b bVar) {
            int i = 0;
            if (this.qXJ != 0) {
                bVar.aF(1, this.qXJ);
            }
            if (this.vfr != 0) {
                bVar.aF(2, this.vfr);
            }
            if (this.status != 0) {
                bVar.aF(3, this.status);
            }
            if (this.aAk != 0) {
                bVar.aF(4, this.aAk);
            }
            if (this.kpU != -1) {
                bVar.aE(5, this.kpU);
            }
            if (this.vfs != 0) {
                bVar.aF(6, this.vfs);
            }
            if (this.vft != null) {
                bVar.a(7, this.vft);
            }
            if (this.vfu != 0) {
                bVar.aF(8, this.vfu);
            }
            if (!this.vfv.equals("")) {
                bVar.g(9, this.vfv);
            }
            if (this.vfw != null && this.vfw.length > 0) {
                for (e eVar : this.vfw) {
                    if (eVar != null) {
                        bVar.a(10, eVar);
                    }
                }
            }
            if (this.vfx != 0) {
                bVar.aF(11, this.vfx);
            }
            if (this.vfy != null && this.vfy.length > 0) {
                while (i < this.vfy.length) {
                    bVar.aF(12, this.vfy[i]);
                    i++;
                }
            }
            if (this.vfz != 0) {
                bVar.aF(13, this.vfz);
            }
            if (this.vfA != 0) {
                bVar.aF(14, this.vfA);
            }
            if (this.vfB != 0) {
                bVar.aF(15, this.vfB);
            }
            if (this.vfC != 0) {
                bVar.aF(16, this.vfC);
            }
            if (this.vfD != null) {
                bVar.a(17, this.vfD);
            }
            if (!this.vez.equals("")) {
                bVar.g(100, this.vez);
            }
            if (!this.vfE.equals("")) {
                bVar.g(101, this.vfE);
            }
            if (this.vfF != 0) {
                bVar.aF(102, this.vfF);
            }
            if (!Arrays.equals(this.vcY, g.bfW)) {
                bVar.b(200, this.vcY);
            }
            if (this.vfG != null) {
                bVar.a(TbsListener$ErrorCode.EXCEED_UNZIP_RETRY_NUM, this.vfG);
            }
            if (this.vfH != -1) {
                bVar.aE(TbsListener$ErrorCode.APK_PATH_ERROR, this.vfH);
            }
            if (!this.vfI.equals("")) {
                bVar.g(TbsListener$ErrorCode.APK_VERSION_ERROR, this.vfI);
            }
            if (this.seW != 0) {
                bVar.aE(TbsListener$ErrorCode.APK_INVALID, this.seW);
            }
            if (this.vfJ != 0) {
                bVar.aF(205, this.vfJ);
            }
            if (this.oWZ != 0) {
                bVar.aF(TbsListener$ErrorCode.UNZIP_IO_ERROR, this.oWZ);
            }
            if (this.vfK != 0) {
                bVar.aF(TbsListener$ErrorCode.UNZIP_OTHER_ERROR, this.vfK);
            }
            if (this.vfL != 0) {
                bVar.aF(TbsListener$ErrorCode.EXCEED_DEXOPT_RETRY_NUM, this.vfL);
            }
            if (this.vcT != 0) {
                bVar.aF(240, this.vcT);
            }
            super.a(bVar);
        }

        protected final int sl() {
            int i;
            int i2;
            int i3 = 0;
            int sl = super.sl();
            if (this.qXJ != 0) {
                sl += b.aH(1, this.qXJ);
            }
            if (this.vfr != 0) {
                sl += b.aH(2, this.vfr);
            }
            if (this.status != 0) {
                sl += b.aH(3, this.status);
            }
            if (this.aAk != 0) {
                sl += b.aH(4, this.aAk);
            }
            if (this.kpU != -1) {
                sl += b.aG(5, this.kpU);
            }
            if (this.vfs != 0) {
                sl += b.aH(6, this.vfs);
            }
            if (this.vft != null) {
                sl += b.b(7, this.vft);
            }
            if (this.vfu != 0) {
                sl += b.aH(8, this.vfu);
            }
            if (!this.vfv.equals("")) {
                sl += b.h(9, this.vfv);
            }
            if (this.vfw != null && this.vfw.length > 0) {
                i = 0;
                while (true) {
                    i2 = sl;
                    if (i >= this.vfw.length) {
                        break;
                    }
                    e eVar = this.vfw[i];
                    if (eVar != null) {
                        i2 += b.b(10, eVar);
                    }
                    sl = i + 1;
                }
                sl = i2;
            }
            if (this.vfx != 0) {
                sl += b.aH(11, this.vfx);
            }
            if (this.vfy != null && this.vfy.length > 0) {
                i = 0;
                while (true) {
                    i2 = i3;
                    if (i >= this.vfy.length) {
                        break;
                    }
                    i2 += b.ee(this.vfy[i]);
                    i3 = i + 1;
                }
                sl = (sl + i2) + (this.vfy.length * 1);
            }
            if (this.vfz != 0) {
                sl += b.aH(13, this.vfz);
            }
            if (this.vfA != 0) {
                sl += b.aH(14, this.vfA);
            }
            if (this.vfB != 0) {
                sl += b.aH(15, this.vfB);
            }
            if (this.vfC != 0) {
                sl += b.aH(16, this.vfC);
            }
            if (this.vfD != null) {
                sl += b.b(17, this.vfD);
            }
            if (!this.vez.equals("")) {
                sl += b.h(100, this.vez);
            }
            if (!this.vfE.equals("")) {
                sl += b.h(101, this.vfE);
            }
            if (this.vfF != 0) {
                sl += b.aH(102, this.vfF);
            }
            if (!Arrays.equals(this.vcY, g.bfW)) {
                sl += b.c(200, this.vcY);
            }
            if (this.vfG != null) {
                sl += b.b(TbsListener$ErrorCode.EXCEED_UNZIP_RETRY_NUM, this.vfG);
            }
            if (this.vfH != -1) {
                sl += b.aG(TbsListener$ErrorCode.APK_PATH_ERROR, this.vfH);
            }
            if (!this.vfI.equals("")) {
                sl += b.h(TbsListener$ErrorCode.APK_VERSION_ERROR, this.vfI);
            }
            if (this.seW != 0) {
                sl += b.aG(TbsListener$ErrorCode.APK_INVALID, this.seW);
            }
            if (this.vfJ != 0) {
                sl += b.aH(205, this.vfJ);
            }
            if (this.oWZ != 0) {
                sl += b.aH(TbsListener$ErrorCode.UNZIP_IO_ERROR, this.oWZ);
            }
            if (this.vfK != 0) {
                sl += b.aH(TbsListener$ErrorCode.UNZIP_OTHER_ERROR, this.vfK);
            }
            if (this.vfL != 0) {
                sl += b.aH(TbsListener$ErrorCode.EXCEED_DEXOPT_RETRY_NUM, this.vfL);
            }
            if (this.vcT != 0) {
                return sl + b.aH(240, this.vcT);
            }
            return sl;
        }
    }

    public static final class aw extends e {
        private static volatile aw[] vfM;
        public String mpV;
        public int qXJ;
        public String username;
        public long vfN;
        public String vfO;
        public String vfP;

        public static aw[] cEB() {
            if (vfM == null) {
                synchronized (c.bfO) {
                    if (vfM == null) {
                        vfM = new aw[0];
                    }
                }
            }
            return vfM;
        }

        public aw() {
            this.qXJ = 0;
            this.username = "";
            this.mpV = "";
            this.vfN = 0;
            this.vfO = "";
            this.vfP = "";
            this.bfP = -1;
        }

        public final void a(b bVar) {
            if (this.qXJ != 0) {
                bVar.aF(1, this.qXJ);
            }
            if (!this.username.equals("")) {
                bVar.g(2, this.username);
            }
            if (!this.mpV.equals("")) {
                bVar.g(3, this.mpV);
            }
            if (this.vfN != 0) {
                bVar.i(4, this.vfN);
            }
            if (!this.vfO.equals("")) {
                bVar.g(5, this.vfO);
            }
            if (!this.vfP.equals("")) {
                bVar.g(6, this.vfP);
            }
            super.a(bVar);
        }

        protected final int sl() {
            int sl = super.sl();
            if (this.qXJ != 0) {
                sl += b.aH(1, this.qXJ);
            }
            if (!this.username.equals("")) {
                sl += b.h(2, this.username);
            }
            if (!this.mpV.equals("")) {
                sl += b.h(3, this.mpV);
            }
            if (this.vfN != 0) {
                sl += b.k(4, this.vfN);
            }
            if (!this.vfO.equals("")) {
                sl += b.h(5, this.vfO);
            }
            if (this.vfP.equals("")) {
                return sl;
            }
            return sl + b.h(6, this.vfP);
        }
    }

    public static final class f extends e {
        public int aAk;
        public String groupId;
        public int oLB;
        public long oLC;
        public int vcX;

        public f() {
            this.groupId = "";
            this.oLB = 0;
            this.oLC = 0;
            this.aAk = 0;
            this.vcX = 0;
            this.bfP = -1;
        }

        public final void a(b bVar) {
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.oLB != 0) {
                bVar.aE(2, this.oLB);
            }
            if (this.oLC != 0) {
                bVar.j(3, this.oLC);
            }
            if (this.aAk != 0) {
                bVar.aE(4, this.aAk);
            }
            if (this.vcX != 0) {
                bVar.aE(5, this.vcX);
            }
            super.a(bVar);
        }

        protected final int sl() {
            int sl = super.sl();
            if (!this.groupId.equals("")) {
                sl += b.h(1, this.groupId);
            }
            if (this.oLB != 0) {
                sl += b.aG(2, this.oLB);
            }
            if (this.oLC != 0) {
                sl += b.l(3, this.oLC);
            }
            if (this.aAk != 0) {
                sl += b.aG(4, this.aAk);
            }
            if (this.vcX != 0) {
                return sl + b.aG(5, this.vcX);
            }
            return sl;
        }
    }

    public static final class m extends e {
        private static volatile m[] vdf;
        public String nickname;
        public int qXJ;
        public String vdg;

        public static m[] cEs() {
            if (vdf == null) {
                synchronized (c.bfO) {
                    if (vdf == null) {
                        vdf = new m[0];
                    }
                }
            }
            return vdf;
        }

        public m() {
            this.qXJ = 0;
            this.nickname = "";
            this.vdg = "";
            this.bfP = -1;
        }

        public final void a(b bVar) {
            if (this.qXJ != 0) {
                bVar.aF(1, this.qXJ);
            }
            if (!this.nickname.equals("")) {
                bVar.g(2, this.nickname);
            }
            if (!this.vdg.equals("")) {
                bVar.g(3, this.vdg);
            }
            super.a(bVar);
        }

        protected final int sl() {
            int sl = super.sl();
            if (this.qXJ != 0) {
                sl += b.aH(1, this.qXJ);
            }
            if (!this.nickname.equals("")) {
                sl += b.h(2, this.nickname);
            }
            if (this.vdg.equals("")) {
                return sl;
            }
            return sl + b.h(3, this.vdg);
        }
    }

    public static final class o extends e {
        private static volatile o[] vdk;
        public int port;
        public int vdl;

        public static o[] cEu() {
            if (vdk == null) {
                synchronized (c.bfO) {
                    if (vdk == null) {
                        vdk = new o[0];
                    }
                }
            }
            return vdk;
        }

        public o() {
            this.vdl = 0;
            this.port = 0;
            this.bfP = -1;
        }

        public final void a(b bVar) {
            if (this.vdl != 0) {
                bVar.aF(1, this.vdl);
            }
            if (this.port != 0) {
                bVar.aE(2, this.port);
            }
            super.a(bVar);
        }

        protected final int sl() {
            int sl = super.sl();
            if (this.vdl != 0) {
                sl += b.aH(1, this.vdl);
            }
            if (this.port != 0) {
                return sl + b.aG(2, this.port);
            }
            return sl;
        }
    }

    public static final class q extends e {
        public int vdu;

        public q() {
            this.vdu = 0;
            this.bfP = -1;
        }

        public final void a(b bVar) {
            bVar.aF(1, this.vdu);
            super.a(bVar);
        }

        protected final int sl() {
            return super.sl() + b.aH(1, this.vdu);
        }
    }

    public static final class s extends e {
        public long riY;
        public long riZ;
        public String sHV;
        public String username;
        public long vdA;
        public int vdB;
        public long vdC;
        public int vdD;
        public String vdg;
        public String vdw;
        public String vdx;
        public int vdy;
        public String vdz;

        public s() {
            this.riY = 0;
            this.vdw = "";
            this.vdx = "";
            this.vdy = 1;
            this.username = "";
            this.vdz = "";
            this.vdg = "";
            this.vdA = 0;
            this.vdB = 0;
            this.sHV = "";
            this.vdC = 0;
            this.vdD = 0;
            this.riZ = 0;
            this.bfP = -1;
        }

        public final void a(b bVar) {
            if (this.riY != 0) {
                bVar.i(1, this.riY);
            }
            if (!this.vdw.equals("")) {
                bVar.g(2, this.vdw);
            }
            if (!this.vdx.equals("")) {
                bVar.g(3, this.vdx);
            }
            if (this.vdy != 1) {
                bVar.aE(4, this.vdy);
            }
            if (!this.username.equals("")) {
                bVar.g(5, this.username);
            }
            if (!this.vdz.equals("")) {
                bVar.g(6, this.vdz);
            }
            if (!this.vdg.equals("")) {
                bVar.g(7, this.vdg);
            }
            if (this.vdA != 0) {
                bVar.i(8, this.vdA);
            }
            if (this.vdB != 0) {
                bVar.aF(9, this.vdB);
            }
            if (!this.sHV.equals("")) {
                bVar.g(10, this.sHV);
            }
            if (this.vdC != 0) {
                bVar.i(11, this.vdC);
            }
            if (this.vdD != 0) {
                bVar.aF(12, this.vdD);
            }
            if (this.riZ != 0) {
                bVar.i(13, this.riZ);
            }
            super.a(bVar);
        }

        protected final int sl() {
            int sl = super.sl();
            if (this.riY != 0) {
                sl += b.k(1, this.riY);
            }
            if (!this.vdw.equals("")) {
                sl += b.h(2, this.vdw);
            }
            if (!this.vdx.equals("")) {
                sl += b.h(3, this.vdx);
            }
            if (this.vdy != 1) {
                sl += b.aG(4, this.vdy);
            }
            if (!this.username.equals("")) {
                sl += b.h(5, this.username);
            }
            if (!this.vdz.equals("")) {
                sl += b.h(6, this.vdz);
            }
            if (!this.vdg.equals("")) {
                sl += b.h(7, this.vdg);
            }
            if (this.vdA != 0) {
                sl += b.k(8, this.vdA);
            }
            if (this.vdB != 0) {
                sl += b.aH(9, this.vdB);
            }
            if (!this.sHV.equals("")) {
                sl += b.h(10, this.sHV);
            }
            if (this.vdC != 0) {
                sl += b.k(11, this.vdC);
            }
            if (this.vdD != 0) {
                sl += b.aH(12, this.vdD);
            }
            if (this.riZ != 0) {
                return sl + b.k(13, this.riZ);
            }
            return sl;
        }
    }

    public static final class t extends e {
        public byte[] data;
        public String iconUrl;
        public String ixy;
        public int status;
        public int vdE;
        public byte[] vdF;
        public byte[] vdG;
        public byte[] vdH;
        public int vdI;
        public int vdJ;
        public byte[] vdK;
        public byte[] vdL;
        public byte[] vdM;
        public byte[] vdN;
        public byte[] vdO;
        public byte[] vdP;
        public byte[] vdQ;
        public byte[] vdR;
        public byte[] vdS;
        public byte[] vdT;

        public t() {
            this.vdE = 0;
            this.vdF = g.bfW;
            this.iconUrl = "";
            this.vdG = g.bfW;
            this.vdH = g.bfW;
            this.vdI = 0;
            this.data = g.bfW;
            this.vdJ = 0;
            this.vdK = g.bfW;
            this.ixy = "";
            this.vdL = g.bfW;
            this.vdM = g.bfW;
            this.vdN = g.bfW;
            this.vdO = g.bfW;
            this.vdP = g.bfW;
            this.vdQ = g.bfW;
            this.vdR = g.bfW;
            this.vdS = g.bfW;
            this.vdT = g.bfW;
            this.status = 0;
            this.bfP = -1;
        }

        public final void a(b bVar) {
            if (this.vdE != 0) {
                bVar.aF(1, this.vdE);
            }
            if (!Arrays.equals(this.vdF, g.bfW)) {
                bVar.b(2, this.vdF);
            }
            if (!this.iconUrl.equals("")) {
                bVar.g(3, this.iconUrl);
            }
            if (!Arrays.equals(this.vdG, g.bfW)) {
                bVar.b(4, this.vdG);
            }
            if (!Arrays.equals(this.vdH, g.bfW)) {
                bVar.b(5, this.vdH);
            }
            if (this.vdI != 0) {
                bVar.aF(6, this.vdI);
            }
            if (!Arrays.equals(this.data, g.bfW)) {
                bVar.b(7, this.data);
            }
            if (this.vdJ != 0) {
                bVar.aF(8, this.vdJ);
            }
            if (!Arrays.equals(this.vdK, g.bfW)) {
                bVar.b(9, this.vdK);
            }
            if (!this.ixy.equals("")) {
                bVar.g(10, this.ixy);
            }
            if (!Arrays.equals(this.vdL, g.bfW)) {
                bVar.b(11, this.vdL);
            }
            if (!Arrays.equals(this.vdM, g.bfW)) {
                bVar.b(12, this.vdM);
            }
            if (!Arrays.equals(this.vdN, g.bfW)) {
                bVar.b(13, this.vdN);
            }
            if (!Arrays.equals(this.vdO, g.bfW)) {
                bVar.b(14, this.vdO);
            }
            if (!Arrays.equals(this.vdP, g.bfW)) {
                bVar.b(15, this.vdP);
            }
            if (!Arrays.equals(this.vdQ, g.bfW)) {
                bVar.b(16, this.vdQ);
            }
            if (!Arrays.equals(this.vdR, g.bfW)) {
                bVar.b(17, this.vdR);
            }
            if (!Arrays.equals(this.vdS, g.bfW)) {
                bVar.b(18, this.vdS);
            }
            if (!Arrays.equals(this.vdT, g.bfW)) {
                bVar.b(19, this.vdT);
            }
            if (this.status != 0) {
                bVar.aF(20, this.status);
            }
            super.a(bVar);
        }

        protected final int sl() {
            int sl = super.sl();
            if (this.vdE != 0) {
                sl += b.aH(1, this.vdE);
            }
            if (!Arrays.equals(this.vdF, g.bfW)) {
                sl += b.c(2, this.vdF);
            }
            if (!this.iconUrl.equals("")) {
                sl += b.h(3, this.iconUrl);
            }
            if (!Arrays.equals(this.vdG, g.bfW)) {
                sl += b.c(4, this.vdG);
            }
            if (!Arrays.equals(this.vdH, g.bfW)) {
                sl += b.c(5, this.vdH);
            }
            if (this.vdI != 0) {
                sl += b.aH(6, this.vdI);
            }
            if (!Arrays.equals(this.data, g.bfW)) {
                sl += b.c(7, this.data);
            }
            if (this.vdJ != 0) {
                sl += b.aH(8, this.vdJ);
            }
            if (!Arrays.equals(this.vdK, g.bfW)) {
                sl += b.c(9, this.vdK);
            }
            if (!this.ixy.equals("")) {
                sl += b.h(10, this.ixy);
            }
            if (!Arrays.equals(this.vdL, g.bfW)) {
                sl += b.c(11, this.vdL);
            }
            if (!Arrays.equals(this.vdM, g.bfW)) {
                sl += b.c(12, this.vdM);
            }
            if (!Arrays.equals(this.vdN, g.bfW)) {
                sl += b.c(13, this.vdN);
            }
            if (!Arrays.equals(this.vdO, g.bfW)) {
                sl += b.c(14, this.vdO);
            }
            if (!Arrays.equals(this.vdP, g.bfW)) {
                sl += b.c(15, this.vdP);
            }
            if (!Arrays.equals(this.vdQ, g.bfW)) {
                sl += b.c(16, this.vdQ);
            }
            if (!Arrays.equals(this.vdR, g.bfW)) {
                sl += b.c(17, this.vdR);
            }
            if (!Arrays.equals(this.vdS, g.bfW)) {
                sl += b.c(18, this.vdS);
            }
            if (!Arrays.equals(this.vdT, g.bfW)) {
                sl += b.c(19, this.vdT);
            }
            if (this.status != 0) {
                return sl + b.aH(20, this.status);
            }
            return sl;
        }
    }

    public static final class v extends e {
        public byte[] body;
        public u vdW;

        public v() {
            this.vdW = null;
            this.body = g.bfW;
            this.bfP = -1;
        }

        public final void a(b bVar) {
            if (this.vdW != null) {
                bVar.a(1, this.vdW);
            }
            if (!Arrays.equals(this.body, g.bfW)) {
                bVar.b(2, this.body);
            }
            super.a(bVar);
        }

        protected final int sl() {
            int sl = super.sl();
            if (this.vdW != null) {
                sl += b.b(1, this.vdW);
            }
            if (Arrays.equals(this.body, g.bfW)) {
                return sl;
            }
            return sl + b.c(2, this.body);
        }
    }

    public static final class x extends e {
        public String groupId;
        public int oLB;
        public long oLC;
        public at vcK;
        public av[] vea;

        public x() {
            this.groupId = "";
            this.oLB = 0;
            this.oLC = 0;
            this.vea = av.cEA();
            this.vcK = null;
            this.bfP = -1;
        }

        public final void a(b bVar) {
            if (!this.groupId.equals("")) {
                bVar.g(1, this.groupId);
            }
            if (this.oLB != 0) {
                bVar.aE(2, this.oLB);
            }
            if (this.oLC != 0) {
                bVar.j(3, this.oLC);
            }
            if (this.vea != null && this.vea.length > 0) {
                for (e eVar : this.vea) {
                    if (eVar != null) {
                        bVar.a(4, eVar);
                    }
                }
            }
            if (this.vcK != null) {
                bVar.a(5, this.vcK);
            }
            super.a(bVar);
        }

        protected final int sl() {
            int sl = super.sl();
            if (!this.groupId.equals("")) {
                sl += b.h(1, this.groupId);
            }
            if (this.oLB != 0) {
                sl += b.aG(2, this.oLB);
            }
            if (this.oLC != 0) {
                sl += b.l(3, this.oLC);
            }
            if (this.vea != null && this.vea.length > 0) {
                int i;
                while (true) {
                    i = sl;
                    if (0 >= this.vea.length) {
                        break;
                    }
                    e eVar = this.vea[0];
                    if (eVar != null) {
                        i += b.b(4, eVar);
                    }
                    sl = 0 + 1;
                }
                sl = i;
            }
            if (this.vcK != null) {
                return sl + b.b(5, this.vcK);
            }
            return sl;
        }
    }
}
