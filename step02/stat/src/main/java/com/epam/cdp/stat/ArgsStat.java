package com.epam.cdp.stat;

import com.google.common.base.Joiner;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArgsStat extends BasicStat {
    private final String[] args;

    @Override
    public void print() {
        Joiner joiner = Joiner.on("\",\n\t\"");
        log.info("Application arguments: [\n\t\"{}\"\n]", joiner.join(args));
    }
}
