import org.hyperic.sigar.*;

public class Main {

    private static Sigar sigar = new Sigar();

    public static void main(String[] args) {
        getSystemStatistics();
    }

    public static void getSystemStatistics(){
        Mem mem = null;
        CpuPerc cpuperc = null;
        FileSystemUsage filesystemusage = null;
        try {
            mem = sigar.getMem();
            cpuperc = sigar.getCpuPerc();
            filesystemusage = sigar.getFileSystemUsage("/");
        } catch (SigarException se) {
            se.printStackTrace();
        }


        System.out.println("MemPercent: " + mem.getUsedPercent()+"\t");
        System.out.println("CPUPerc: " + (cpuperc.getCombined()*100)+"\t");
        System.out.println("FileSystemUsage: " + filesystemusage.getUsePercent()+"\n");
    }

}