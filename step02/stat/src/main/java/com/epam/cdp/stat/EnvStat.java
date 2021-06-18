package com.epam.cdp.stat;

import com.google.common.base.Joiner;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

@Slf4j
public class EnvStat extends BasicStat {
    @Override
    public void print() {
        Properties env = System.getProperties();
        Joiner.MapJoiner envJoiner = Joiner.on(",\n\t").withKeyValueSeparator("=");
        log.info("Application environment: [\n\t{}\n]", envJoiner.join(env));
    }
}
