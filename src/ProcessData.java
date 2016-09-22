import java.util.Map;

import org.hyperic.sigar.ProcStat;
import org.hyperic.sigar.ProcState;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;


public class ProcessData {

    private static Sigar sigar;

    public ProcessData(Sigar s) throws SigarException {
        this.sigar = s;
        System.out.println(getMetric().toString());
        System.out.println(getMetric(getPidString()).toString());
    }

    public static void main(String[] args) throws SigarException {
        new ProcessData(new Sigar());
        System.out.println(ProcessData.getMetric());
        System.out.println(ProcessData.getMetric(getPidString()));
    }

    public static Map<String, String> getMetric() throws SigarException {
        ProcStat state = sigar.getProcStat();
        return (Map<String, String>) state.toMap();
    }

    public static Map<String, String> getMetric(String pid) throws SigarException {
        ProcState state = sigar.getProcState(pid);
        return (Map<String, String>) state.toMap();
    }

    public static long getPid() {
        return sigar.getPid();
    }

    public static String getPidString() {
        return ""+sigar.getPid();
    }

}