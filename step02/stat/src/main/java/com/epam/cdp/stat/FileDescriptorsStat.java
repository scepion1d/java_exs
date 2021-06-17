package com.epam.cdp.stat;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;


public class FileDescriptorsStat extends BasicStat {
    @Override
    public void print() {
        OperatingSystemMXBean osMxBean = ManagementFactory.getOperatingSystemMXBean();
        try {
            Method getMaxFileDescriptorCountField = osMxBean.getClass().getDeclaredMethod("getMaxFileDescriptorCount");
            Method getOpenFileDescriptorCountField = osMxBean.getClass().getDeclaredMethod("getOpenFileDescriptorCount");
            getMaxFileDescriptorCountField.setAccessible(true);
            getOpenFileDescriptorCountField.setAccessible(true);

            log.info(
                    "Application environment: [\n\t{}\n]",
                    getOpenFileDescriptorCountField.invoke(osMxBean) + "/" + getMaxFileDescriptorCountField.invoke(osMxBean)
            );
        } catch (Exception e) {
            log.error("Can't get file descriptors statistics: " + e.getMessage());
        }
    }
}
