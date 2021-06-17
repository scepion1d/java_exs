package com.epam.cdp.stat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasicStat {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    public abstract void print();
}
