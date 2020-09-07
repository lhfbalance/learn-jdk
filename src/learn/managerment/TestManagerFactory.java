package learn.managerment;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

public class TestManagerFactory {

    public static void main(String[] args) {

        MemoryMXBean memoryMXBean =  ManagementFactory.getMemoryMXBean();
        System.out.println(memoryMXBean.isVerbose());
        System.out.println(memoryMXBean.getObjectName());
        System.out.println(memoryMXBean.getHeapMemoryUsage());
        System.out.println(memoryMXBean.getNonHeapMemoryUsage());

        memoryMXBean.setVerbose(true);
        System.out.println("=============verbose==============");
        System.out.println(memoryMXBean.getObjectName());
        System.out.println(memoryMXBean.getHeapMemoryUsage());
        System.out.println(memoryMXBean.getNonHeapMemoryUsage());
    }

}
